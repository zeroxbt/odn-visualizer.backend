import contracts.Hub;
import database.models.SmartContract;
import org.bouncycastle.util.encoders.Hex;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.Transaction;
import org.web3j.tx.gas.DefaultGasProvider;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.*;

import static util.Decoder.decodeAddress;
import static util.Decoder.getArgs;

public class SyncHub {

    public static void loadFromHub(Connection connection, Web3j web3) throws SQLException, IOException {
        String sql = "SELECT Address, CreationBlock, ExpirationBlock FROM contracts  WHERE Name = 'Hub' AND BlockchainId = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        int chainId = web3.ethChainId().send().getChainId().intValue();
        statement.setInt(1, chainId);

        ResultSet columns = statement.executeQuery();
        while(columns.next()){
            String hubAddress = columns.getString("Address");
            Hub hub = Hub.load(hubAddress, web3, Main.CREDENTIALS, new DefaultGasProvider());

            long expirationBlock = columns.getLong("ExpirationBlock");
            DefaultBlockParameter start = DefaultBlockParameter.valueOf(new BigInteger(columns.getString("CreationBlock")));
            DefaultBlockParameter end = expirationBlock < 0 ?
                    DefaultBlockParameterName.LATEST :
                    DefaultBlockParameter.valueOf(new BigInteger(String.valueOf(expirationBlock)));

            hub.contractsChangedEventFlowable(start, end).subscribe(
                    response -> {
                        Transaction transaction = web3.ethGetTransactionByHash(response.log.getTransactionHash()).send().getResult();                        int chainID = web3.ethChainId().send().getChainId().intValue();
                        String inputData = transaction.getInput();

                        SmartContract smartContract = new SmartContract(
                                decodeContractName(inputData),
                                decodeAddress(getArgs(inputData, 1)),
                                chainId,
                                transaction.getBlockNumber(),
                                new BigInteger("-1")
                        );

                        SmartContract.insertIfNotExist(connection, smartContract);
                        SmartContract.updateExpirationBlock(connection, smartContract, transaction.getBlockNumber());
                    }, Throwable::printStackTrace);
        }
    }

    private static String decodeContractName(String inputData) {
        int contractNameLength = Integer.parseInt(getArgs(inputData, 2), 16);
        return new String(Hex.decode(getArgs(inputData, 3)), StandardCharsets.UTF_8)
                .substring(0, contractNameLength);
    }
}
