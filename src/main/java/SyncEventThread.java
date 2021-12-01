import io.reactivex.disposables.Disposable;
import org.web3j.abi.datatypes.Event;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.DefaultBlockParameterName;
import util.Database;

import java.io.IOException;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import static util.Web3.*;
import static util.Database.createConnection;

public abstract class SyncEventThread extends Thread {
    private final Connection connection = createConnection();
    private final String contractName;
    private final Event event;
    private final int chainId;

    private Web3j web3 = null;
    Disposable disposable = null;

    public SyncEventThread(String contractName, Event event, int chainId) throws SQLException {
        this.contractName = contractName;
        this.event = event;
        this.chainId = chainId;
    }

    @Override
    public void run() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    syncEvent();
                } catch (SQLException | IOException throwables) {
                    throwables.printStackTrace();
                }
            }
        }, 0, 1000 * 60 * 15);
    }

    private void syncEvent() throws SQLException, IOException {
        stopSync();
        web3 = createWeb3(Objects.requireNonNull(Database.getRpc(event.getName(), chainId, connection)));
        BigInteger lastSyncBlock = Main.lastSyncBlocks.get(chainId);
        ResultSet contracts = Database.contracts(contractName, chainId, connection, lastSyncBlock);

        while (contracts.next()) {
            DefaultBlockParameter start = startBlock(lastSyncBlock);
            DefaultBlockParameter end = endBlock(contracts);
            String contractAddress = contracts.getString("Address");
            handleEvent(contractAddress, web3, start, end, connection);
        }

        contracts.close();
    }

    private void stopSync() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
        if (web3 != null) {
            web3.shutdown();
        }
    }

    abstract void handleEvent(String contractAddress, Web3j web3, DefaultBlockParameter start, DefaultBlockParameter end, Connection connection);

    /*private BigInteger getLastBlockNumber(String tableName, int blockchainId, Connection connection) throws SQLException {
        String sql = "SELECT MAX(BlockNumber) AS 'BlockNumber' FROM " + tableName + " WHERE BlockchainId = '" + blockchainId + "'";
        PreparedStatement statement = connection.prepareStatement(sql);
        BigInteger lastBlock;
        try {
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            lastBlock = new BigInteger(resultSet.getString("BlockNumber"));
        } catch (Exception e){
            lastBlock = new BigInteger("0");
        }
        statement.close();

        return lastBlock;
    }*/

    /*private DefaultBlockParameter startBlock(BigInteger lastSyncBlock, ResultSet columns) throws SQLException {
        long creationBlock = columns.getLong("CreationBlock");
        BigInteger startBlock = lastSyncBlock.longValue() > creationBlock ?
                lastSyncBlock :
                new BigInteger(String.valueOf(creationBlock));
        return DefaultBlockParameter.valueOf(startBlock);
    }*/

    private DefaultBlockParameter startBlock(BigInteger lastSyncBlock) {
        double blockTime;
        if (chainId == 1) {
            blockTime = 13.4;
        } else if (chainId == 100) {
            blockTime = 5;
        } else {
            blockTime = 2.2;
        }
        BigInteger goBackBlocks = BigInteger.valueOf(Math.round(15 * 60 / blockTime));
        return DefaultBlockParameter.valueOf(lastSyncBlock.subtract(goBackBlocks));
    }

    private DefaultBlockParameter endBlock(ResultSet columns) throws SQLException {
        long expirationBlock = columns.getLong("ExpirationBlock");
        return expirationBlock < 0 ?
                DefaultBlockParameterName.LATEST :
                DefaultBlockParameter.valueOf(new BigInteger(String.valueOf(expirationBlock)));
    }
}
