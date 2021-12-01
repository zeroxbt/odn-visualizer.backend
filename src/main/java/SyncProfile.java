import contracts.Profile;
import contracts.ProfileStorage;
import database.models.*;
import org.bouncycastle.util.encoders.Hex;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.methods.response.EthBlock;
import org.web3j.protocol.core.methods.response.Transaction;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple7;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.utils.Convert;
import util.Database;
import util.Decoder;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.*;
import java.util.*;

import static util.Web3.createWeb3;
import static util.Database.createConnection;
import static util.Decoder.ADDRESS_HEX;
import static util.Decoder.FUNCTION_NAME_HEX;
import static util.Encoder.keccak256;

public class SyncProfile extends Thread {
    private final int chainId;
    private final String contractName;

    public SyncProfile(int chainId) {
        this.chainId = chainId;
        this.contractName = Profile.class.getSimpleName();
    }

    @Override
    public void run() {
        try {
            loadFromProfile();
        } catch (Throwable throwable) {
            System.out.println(throwable.getMessage());
        }
    }

    private void loadFromProfile() throws Exception {
        new SyncTokensWithdrawnThread().start();
        new SyncTokensTransferredThread().start();
        new SyncTokensReservedThread().start();
        new SyncTokensReleasedThread().start();
        new SyncIdentityTransferredThread().start();
        new SyncIdentityCreatedThread().start();
        new SyncProfileCreatedThread().start();
        new SyncTokensDepositedThread().start();
        new LoadProfileBalancesThread().start();
        //new UpdateIdentityThread().start();
    }

    private class SyncIdentityCreatedThread extends SyncEventThread {
        private SyncIdentityCreatedThread() throws SQLException {
            super(contractName, Profile.IDENTITYCREATED_EVENT, chainId);
        }

        @Override
        void handleEvent(String contractAddress, Web3j web3, DefaultBlockParameter start, DefaultBlockParameter end, Connection connection) {
            Profile profile = Profile.load(contractAddress, web3, Main.CREDENTIALS, new DefaultGasProvider());
            disposable = profile.identityCreatedEventFlowable(start, end).subscribe(response -> {
                Transaction transaction = web3.ethGetTransactionByHash(response.log.getTransactionHash()).send().getResult();
                EthBlock.Block block = web3.ethGetBlockByHash(response.log.getBlockHash(), false).send().getResult();
                TransactionReceipt receipt = web3.ethGetTransactionReceipt(transaction.getHash()).send().getResult();

                IdentityCreated identityCreated = new IdentityCreated(
                        transaction.getHash(),
                        response.profile,
                        response.newIdentity,
                        contractAddress,
                        block.getNumber(),
                        receipt.getGasUsed(),
                        transaction.getGasPrice(),
                        chainId
                );

                IdentityCreated.insertIfNotExist(connection, identityCreated);

            }, Throwable::printStackTrace);
        }
    }

    private class SyncProfileCreatedThread extends SyncEventThread {
        private SyncProfileCreatedThread() throws Exception {
            super(contractName, Profile.PROFILECREATED_EVENT, chainId);
        }

        @Override
        void handleEvent(String contractAddress, Web3j web3, DefaultBlockParameter start, DefaultBlockParameter end, Connection connection) {
            Profile profile = Profile.load(contractAddress, web3, Main.CREDENTIALS, new DefaultGasProvider());
            disposable = profile.profileCreatedEventFlowable(start, end).subscribe(response -> {
                Transaction transaction = web3.ethGetTransactionByHash(response.log.getTransactionHash()).send().getResult();
                EthBlock.Block block = web3.ethGetBlockByHash(response.log.getBlockHash(), false).send().getResult();
                TransactionReceipt receipt = web3.ethGetTransactionReceipt(transaction.getHash()).send().getResult();

                List<String> args = decodeFunction(transaction.getInput());
                ProfileCreated profileCreated = new ProfileCreated(
                        transaction.getHash(),
                        contractAddress,
                        response.profile,
                        block.getNumber(),
                        Convert.fromWei(response.initialBalance.toString(), Convert.Unit.ETHER),
                        args.get(0),
                        args.get(1),
                        receipt.getGasUsed(),
                        transaction.getGasPrice(),
                        chainId
                );

                ProfileCreated.insertIfNotExist(connection, profileCreated);

                Identity identity = new Identity(
                        response.profile,
                        transaction.getHash(),
                        chainId,
                        args.get(1)
                );

                Identity.insertIfNotExist(connection, identity);

            }, Throwable::printStackTrace);
        }
    }

    private class SyncIdentityTransferredThread extends SyncEventThread {
        private SyncIdentityTransferredThread() throws SQLException {
            super(contractName, Profile.IDENTITYTRANSFERRED_EVENT, chainId);
        }

        @Override
        void handleEvent(String contractAddress, Web3j web3, DefaultBlockParameter start, DefaultBlockParameter end, Connection connection) {
            Profile profile = Profile.load(contractAddress, web3, Main.CREDENTIALS, new DefaultGasProvider());
            disposable = profile.identityTransferredEventFlowable(start, end).subscribe(response -> {
                Transaction transaction = web3.ethGetTransactionByHash(response.log.getTransactionHash()).send().getResult();
                EthBlock.Block block = web3.ethGetBlockByHash(response.log.getBlockHash(), false).send().getResult();
                TransactionReceipt receipt = web3.ethGetTransactionReceipt(transaction.getHash()).send().getResult();

                IdentityTransferred identityTransferred = new IdentityTransferred(
                        transaction.getHash(),
                        Hex.toHexString(response.nodeId),
                        response.oldIdentity,
                        response.newIdentity,
                        contractAddress,
                        block.getNumber(),
                        "0x" + Decoder.removeAddressPadding(Decoder.getArgs(transaction.getInput(), 1)),
                        receipt.getGasUsed(),
                        transaction.getGasPrice(),
                        chainId
                );

                IdentityTransferred.insertIfNotExist(connection, identityTransferred);

            }, Throwable::printStackTrace);
        }
    }

    private class SyncTokensDepositedThread extends SyncEventThread {
        private SyncTokensDepositedThread() throws SQLException {
            super(contractName, Profile.TOKENSDEPOSITED_EVENT, chainId);
        }

        @Override
        void handleEvent(String contractAddress, Web3j web3, DefaultBlockParameter start, DefaultBlockParameter end, Connection connection) {
            Profile profile = Profile.load(contractAddress, web3, Main.CREDENTIALS, new DefaultGasProvider());
            disposable = profile.tokensDepositedEventFlowable(start, end).subscribe(response -> {
                Transaction transaction = web3.ethGetTransactionByHash(response.log.getTransactionHash()).send().getResult();
                EthBlock.Block block = web3.ethGetBlockByHash(response.log.getBlockHash(), false).send().getResult();
                TransactionReceipt receipt = web3.ethGetTransactionReceipt(transaction.getHash()).send().getResult();

                TokensDeposited tokensDeposited = new TokensDeposited(
                        transaction.getHash(),
                        contractAddress,
                        block.getNumber(),
                        response.profile,
                        Convert.fromWei(response.amountDeposited.toString(), Convert.Unit.ETHER),
                        Convert.fromWei(response.newBalance.toString(), Convert.Unit.ETHER),
                        receipt.getGasUsed(),
                        transaction.getGasPrice(),
                        chainId
                );

                TokensDeposited.insertIfNotExist(connection, tokensDeposited);

            }, Throwable::printStackTrace);
        }
    }

    private class SyncTokensReleasedThread extends SyncEventThread {
        private SyncTokensReleasedThread() throws SQLException {
            super(contractName, Profile.TOKENSRELEASED_EVENT, chainId);
        }

        @Override
        void handleEvent(String contractAddress, Web3j web3, DefaultBlockParameter start, DefaultBlockParameter end, Connection connection) {
            Profile profile = Profile.load(contractAddress, web3, Main.CREDENTIALS, new DefaultGasProvider());
            disposable = profile.tokensReleasedEventFlowable(start, end).subscribe(response -> {
                Transaction transaction = web3.ethGetTransactionByHash(response.log.getTransactionHash()).send().getResult();
                EthBlock.Block block = web3.ethGetBlockByHash(response.log.getBlockHash(), false).send().getResult();
                TransactionReceipt receipt = web3.ethGetTransactionReceipt(transaction.getHash()).send().getResult();

                TokensReleased tokensReleased = new TokensReleased(
                        transaction.getHash(),
                        contractAddress,
                        block.getNumber(),
                        response.profile,
                        Convert.fromWei(response.amount.toString(), Convert.Unit.ETHER),
                        receipt.getGasUsed(),
                        transaction.getGasPrice(),
                        chainId
                );

                TokensReleased.insertIfNotExist(connection, tokensReleased);

            }, Throwable::printStackTrace);
        }
    }

    private class SyncTokensWithdrawnThread extends SyncEventThread {
        private SyncTokensWithdrawnThread() throws SQLException {
            super(contractName, Profile.TOKENSWITHDRAWN_EVENT, chainId);
        }

        @Override
        void handleEvent(String contractAddress, Web3j web3, DefaultBlockParameter start, DefaultBlockParameter end, Connection connection) {
            Profile profile = Profile.load(contractAddress, web3, Main.CREDENTIALS, new DefaultGasProvider());
            disposable = profile.tokensWithdrawnEventFlowable(start, end).subscribe(response -> {
                Transaction transaction = web3.ethGetTransactionByHash(response.log.getTransactionHash()).send().getResult();
                EthBlock.Block block = web3.ethGetBlockByHash(response.log.getBlockHash(), false).send().getResult();
                TransactionReceipt receipt = web3.ethGetTransactionReceipt(transaction.getHash()).send().getResult();

                TokensWithdrawn tokensWithdrawn = new TokensWithdrawn(
                        transaction.getHash(),
                        contractAddress,
                        block.getNumber(),
                        response.profile,
                        Convert.fromWei(response.amountWithdrawn.toString(), Convert.Unit.ETHER),
                        Convert.fromWei(response.newBalance.toString(), Convert.Unit.ETHER),
                        receipt.getGasUsed(),
                        transaction.getGasPrice(),
                        chainId
                );

                TokensWithdrawn.insertIfNotExist(connection, tokensWithdrawn);

            }, e -> {
            });
        }
    }

    private class SyncTokensTransferredThread extends SyncEventThread {
        private SyncTokensTransferredThread() throws SQLException {
            super(contractName, Profile.TOKENSTRANSFERRED_EVENT, chainId);
        }

        @Override
        void handleEvent(String contractAddress, Web3j web3, DefaultBlockParameter start, DefaultBlockParameter end, Connection connection) {
            Profile profile = Profile.load(contractAddress, web3, Main.CREDENTIALS, new DefaultGasProvider());
            disposable = profile.tokensTransferredEventFlowable(start, end).subscribe(response -> {
                Transaction transaction = web3.ethGetTransactionByHash(response.log.getTransactionHash()).send().getResult();
                EthBlock.Block block = web3.ethGetBlockByHash(response.log.getBlockHash(), false).send().getResult();
                TransactionReceipt receipt = web3.ethGetTransactionReceipt(transaction.getHash()).send().getResult();

                TokensTransferred tokensTransferred = new TokensTransferred(
                        transaction.getHash(),
                        contractAddress,
                        block.getNumber(),
                        response.sender,
                        response.receiver,
                        Convert.fromWei(response.amount.toString(), Convert.Unit.ETHER),
                        receipt.getGasUsed(),
                        transaction.getGasPrice(),
                        chainId
                );

                TokensTransferred.insertIfNotExist(connection, tokensTransferred);

            }, e -> {
            });
        }
    }

    private class SyncTokensReservedThread extends SyncEventThread {
        private SyncTokensReservedThread() throws SQLException {
            super(contractName, Profile.TOKENSRESERVED_EVENT, chainId);
        }

        @Override
        void handleEvent(String contractAddress, Web3j web3, DefaultBlockParameter start, DefaultBlockParameter end, Connection connection) {
            Profile profile = Profile.load(contractAddress, web3, Main.CREDENTIALS, new DefaultGasProvider());
            disposable = profile.tokensReservedEventFlowable(start, end).subscribe(response -> {
                Transaction transaction = web3.ethGetTransactionByHash(response.log.getTransactionHash()).send().getResult();
                EthBlock.Block block = web3.ethGetBlockByHash(response.log.getBlockHash(), false).send().getResult();
                TransactionReceipt receipt = web3.ethGetTransactionReceipt(transaction.getHash()).send().getResult();

                TokensReserved tokensReserved = new TokensReserved(
                        transaction.getHash(),
                        contractAddress,
                        block.getNumber(),
                        response.profile,
                        Convert.fromWei(response.amountReserved.toString(), Convert.Unit.ETHER),
                        receipt.getGasUsed(),
                        transaction.getGasPrice(),
                        chainId
                );

                TokensReserved.insertIfNotExist(connection, tokensReserved);

            }, e -> {
            });
        }
    }

    private class UpdateIdentityThread extends Thread {
        private final Connection connection;

        private UpdateIdentityThread() throws SQLException {
            connection = createConnection();
        }

        @Override
        public void run() {
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    try {
                        ResultSet identities = getMissingIdentitiesFromIdentityCreated();
                        while (identities.next()) {
                            Identity identity = new Identity(
                                    identities.getString("NewIdentity"),
                                    identities.getString("TransactionHash"),
                                    identities.getInt("BlockchainId")
                            );
                            Identity.insertIfNotExist(connection, identity);
                        }

                        identities = getMissingIdentitiesFromProfileCreated();
                        while (identities.next()) {
                            Identity identity = new Identity(
                                    identities.getString("Profile"),
                                    identities.getString("TransactionHash"),
                                    identities.getInt("BlockchainId"),
                                    identities.getString("NodeId")
                            );
                            Identity.insertIfNotExist(connection, identity);
                        }
                        identities.close();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            }, 0, 1000 * 60 * 15);
        }

        private ResultSet getMissingIdentitiesFromIdentityCreated() throws SQLException {
            String sql = "SELECT * from IdentityCreated " +
                    "WHERE NewIdentity not in (SELECT Identity FROM Identity WHERE BlockchainId = ?) AND BlockchainId = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, chainId);
            statement.setInt(2, chainId);
            return statement.executeQuery();
        }

        private ResultSet getMissingIdentitiesFromProfileCreated() throws SQLException {
            String sql = "SELECT * from ProfileCreated " +
                    "WHERE Profile not in (SELECT Identity FROM Identity WHERE BlockchainId = ?) AND BlockchainId = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, chainId);
            statement.setInt(2, chainId);
            return statement.executeQuery();
        }

    }

    private class LoadProfileBalancesThread extends Thread {
        private final Connection connection;

        private LoadProfileBalancesThread() throws SQLException {
            connection = createConnection();
        }

        @Override
        public void run() {
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    try {
                        Web3j web3 = createWeb3(Objects.requireNonNull(Database.getRpc("Identity", chainId, connection)));
                        ResultSet contracts = Database.contracts("ProfileStorage", chainId, connection, Main.lastSyncBlocks.get(chainId));
                        String contractAddress = contracts.next() ? contracts.getString("Address") : "";
                        ProfileStorage profileStorage = ProfileStorage.load(contractAddress, web3, Main.CREDENTIALS, new DefaultGasProvider());
                        ResultSet identities = Identity.getAll(connection, chainId);
                        while (identities.next()) {
                            Tuple7<BigInteger, BigInteger, BigInteger, Boolean, BigInteger, BigInteger, byte[]> profile = profileStorage.profile(identities.getString("Identity").substring(2)).send();

                            BigDecimal stake = Convert.fromWei(profile.component1().toString(), Convert.Unit.ETHER);
                            BigDecimal stakeReserved = Convert.fromWei(profile.component2().toString(), Convert.Unit.ETHER);
                            BigInteger reputation = profile.component3();
                            boolean withdrawalPending = profile.component4();
                            BigInteger withdrawalTimestamp = profile.component5();
                            BigDecimal withdrawalAmount = Convert.fromWei(profile.component6().toString(), Convert.Unit.ETHER);
                            String nodeId = Hex.toHexString(profile.component7()).substring(0, ADDRESS_HEX);

                            if (identities.getBoolean("IsLatest") && !identities.getString("NodeId").equals(nodeId) && !nodeId.equals("0000000000000000000000000000000000000000")) {
                                Identity.updateIsLatest(connection, identities.getString("Identity"));
                                Identity identity = new Identity(identities.getString("Identity"), "", chainId, nodeId);
                                Identity.insertIfNotExist(connection, identity);
                            }

                            if (identities.getBigDecimal("Stake").compareTo(stake) != 0
                                    || identities.getBigDecimal("StakeReserved").compareTo(stakeReserved) != 0
                                    || new BigInteger(identities.getString("Reputation")).compareTo(reputation) != 0
                                    || identities.getBoolean("WithdrawalPending") != withdrawalPending
                                    || new BigInteger(identities.getString("WithdrawalTimestamp")).compareTo(withdrawalTimestamp) != 0
                                    || identities.getBigDecimal("WithdrawalAmount").compareTo(withdrawalAmount) != 0) {
                                Identity identity = new Identity(
                                        identities.getString("Identity"),
                                        identities.getString("TransactionHash"),
                                        stake,
                                        stakeReserved,
                                        identities.getBigDecimal("PaidOut"),
                                        reputation,
                                        withdrawalPending,
                                        withdrawalTimestamp,
                                        withdrawalAmount,
                                        identities.getString("NodeId"),
                                        chainId
                                );

                                Identity.updateExisting(connection, identity);
                            }
                        }
                        identities.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, 0, 1000 * 60 * 60 * 2);
        }
    }

    private static List<String> decodeFunction(String inputData) {
        String hashedDeclaration = inputData.substring(2, 2 + FUNCTION_NAME_HEX);
        List<String> arguments = new ArrayList<>();
        String managementWallet = "";
        String nodeId = "";

        if (keccak256("createProfile(bytes32,uint256,bool,address)").substring(0, FUNCTION_NAME_HEX).equals(hashedDeclaration)) {
            managementWallet = "";
            nodeId = Decoder.getArgs(inputData, 0);
        } else if (keccak256("createProfile(address,bytes32,uint256,bool,address)").substring(0, FUNCTION_NAME_HEX).equals(hashedDeclaration)) {
            managementWallet = "0x" + Decoder.removeAddressPadding(Decoder.getArgs(inputData, 0));
            nodeId = Decoder.getArgs(inputData, 1).substring(0, ADDRESS_HEX);
        } else {
            throw new IllegalArgumentException("CreateProfile function unknown.");
        }
        arguments.add(managementWallet);
        arguments.add(nodeId);
        return arguments;
    }
}
