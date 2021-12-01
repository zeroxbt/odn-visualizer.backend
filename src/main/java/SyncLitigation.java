import contracts.Approval;
import contracts.Litigation;
import database.models.*;
import org.bouncycastle.util.encoders.Hex;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.methods.response.EthBlock;
import org.web3j.protocol.core.methods.response.Transaction;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.gas.DefaultGasProvider;

import java.sql.*;


public class SyncLitigation extends Thread {
    private final int chainId;
    private final String contractName;

    public SyncLitigation(int chainId) {
        this.chainId = chainId;
        this.contractName = Litigation.class.getSimpleName();
    }

    @Override
    public void run() {
        try {
            loadFromLitigation();
        } catch (Throwable throwable) {
            System.out.println(throwable.getMessage());
        }
    }

    private void loadFromLitigation() throws SQLException {
        new SyncLitigationInitiatedThread().start();
        new SyncLitigationAnsweredThread().start();
        new SyncLitigationCompletedThread().start();
        new SyncLitigationTimedOutThread().start();
        new SyncReplacementStartedThread().start();

    }

    private class SyncLitigationInitiatedThread extends SyncEventThread {
        private SyncLitigationInitiatedThread() throws SQLException {
            super(contractName, Litigation.LITIGATIONINITIATED_EVENT, chainId);
        }

        @Override
        void handleEvent(String contractAddress, Web3j web3, DefaultBlockParameter start, DefaultBlockParameter end, Connection connection) {
            Litigation litigation = Litigation.load(contractAddress, web3, Main.CREDENTIALS, new DefaultGasProvider());
            disposable = litigation.litigationInitiatedEventFlowable(start, end).subscribe(response -> {
                Transaction transaction = web3.ethGetTransactionByHash(response.log.getTransactionHash()).send().getResult();
                EthBlock.Block block = web3.ethGetBlockByHash(response.log.getBlockHash(), false).send().getResult();
                TransactionReceipt receipt = web3.ethGetTransactionReceipt(transaction.getHash()).send().getResult();

                LitigationInitiated litigationInitiated = new LitigationInitiated(
                        transaction.getHash(),
                        block.getNumber(),
                        new Timestamp(block.getTimestamp().longValue() * 1000),
                        "0x" + Hex.toHexString(response.offerId),
                        response.holderIdentity,
                        receipt.getGasUsed(),
                        transaction.getGasPrice(),
                        response.requestedObjectIndex,
                        response.requestedBlockIndex,
                        chainId
                );

                LitigationInitiated.insertIfNotExist(connection, litigationInitiated);

            }, e -> {});
        }
    }

    private class SyncLitigationAnsweredThread extends SyncEventThread {
        private SyncLitigationAnsweredThread() throws SQLException {
            super(contractName, Litigation.LITIGATIONANSWERED_EVENT, chainId);
        }

        @Override
        void handleEvent(String contractAddress, Web3j web3, DefaultBlockParameter start, DefaultBlockParameter end, Connection connection) {
            Litigation litigation = Litigation.load(contractAddress, web3, Main.CREDENTIALS, new DefaultGasProvider());
            disposable = litigation.litigationAnsweredEventFlowable(start, end).subscribe(response -> {
                Transaction transaction = web3.ethGetTransactionByHash(response.log.getTransactionHash()).send().getResult();
                EthBlock.Block block = web3.ethGetBlockByHash(response.log.getBlockHash(), false).send().getResult();
                TransactionReceipt receipt = web3.ethGetTransactionReceipt(transaction.getHash()).send().getResult();

                LitigationAnswered litigationAnswered = new LitigationAnswered(
                        transaction.getHash(),
                        block.getNumber(),
                        new Timestamp(block.getTimestamp().longValue() * 1000),
                        "0x" + Hex.toHexString(response.offerId),
                        response.holderIdentity,
                        receipt.getGasUsed(),
                        transaction.getGasPrice(),
                        chainId
                );

                LitigationAnswered.insertIfNotExist(connection, litigationAnswered);

            }, e -> {});
        }


    }

    private class SyncLitigationCompletedThread extends SyncEventThread {
        private SyncLitigationCompletedThread() throws SQLException {
            super(contractName, Litigation.LITIGATIONCOMPLETED_EVENT, chainId);
        }

        @Override
        void handleEvent(String contractAddress, Web3j web3, DefaultBlockParameter start, DefaultBlockParameter end, Connection connection) {
            Litigation litigation = Litigation.load(contractAddress, web3, Main.CREDENTIALS, new DefaultGasProvider());
            disposable = litigation.litigationCompletedEventFlowable(start, end).subscribe(response -> {
                Transaction transaction = web3.ethGetTransactionByHash(response.log.getTransactionHash()).send().getResult();
                EthBlock.Block block = web3.ethGetBlockByHash(response.log.getBlockHash(), false).send().getResult();
                TransactionReceipt receipt = web3.ethGetTransactionReceipt(transaction.getHash()).send().getResult();

                LitigationCompleted litigationCompleted = new LitigationCompleted(
                        transaction.getHash(),
                        block.getNumber(),
                        new Timestamp(block.getTimestamp().longValue() * 1000),
                        "0x" + Hex.toHexString(response.offerId),
                        response.holderIdentity,
                        response.DH_was_penalized,
                        receipt.getGasUsed(),
                        transaction.getGasPrice(),
                        chainId
                );

                LitigationCompleted.insertIfNotExist(connection, litigationCompleted);

            }, e -> {});
        }
    }

    private class SyncLitigationTimedOutThread extends SyncEventThread {
        private SyncLitigationTimedOutThread() throws SQLException {
            super(contractName, Litigation.LITIGATIONTIMEDOUT_EVENT, chainId);
        }

        @Override
        void handleEvent(String contractAddress, Web3j web3, DefaultBlockParameter start, DefaultBlockParameter end, Connection connection) {
            Litigation litigation = Litigation.load(contractAddress, web3, Main.CREDENTIALS, new DefaultGasProvider());
            disposable = litigation.litigationTimedOutEventFlowable(start, end).subscribe(response -> {
                Transaction transaction = web3.ethGetTransactionByHash(response.log.getTransactionHash()).send().getResult();
                EthBlock.Block block = web3.ethGetBlockByHash(response.log.getBlockHash(), false).send().getResult();
                TransactionReceipt receipt = web3.ethGetTransactionReceipt(transaction.getHash()).send().getResult();

                LitigationTimedOut litigationTimedOut = new LitigationTimedOut(
                        transaction.getHash(),
                        block.getNumber(),
                        new Timestamp(block.getTimestamp().longValue() * 1000),
                        "0x" + Hex.toHexString(response.offerId),
                        response.holderIdentity,
                        receipt.getGasUsed(),
                        transaction.getGasPrice(),
                        chainId
                );

                LitigationTimedOut.insertIfNotExist(connection, litigationTimedOut);

            }, e -> {});
        }
    }

    private class SyncReplacementStartedThread extends SyncEventThread {
        private SyncReplacementStartedThread() throws SQLException {
            super(contractName, Litigation.REPLACEMENTSTARTED_EVENT, chainId);
        }

        @Override
        void handleEvent(String contractAddress, Web3j web3, DefaultBlockParameter start, DefaultBlockParameter end, Connection connection) {
            Litigation litigation = Litigation.load(contractAddress, web3, Main.CREDENTIALS, new DefaultGasProvider());
            disposable = litigation.replacementStartedEventFlowable(start, end).subscribe(response -> {
                Transaction transaction = web3.ethGetTransactionByHash(response.log.getTransactionHash()).send().getResult();
                EthBlock.Block block = web3.ethGetBlockByHash(response.log.getBlockHash(), false).send().getResult();
                TransactionReceipt receipt = web3.ethGetTransactionReceipt(transaction.getHash()).send().getResult();

                ReplacementStarted replacementStarted = new ReplacementStarted(
                        transaction.getHash(),
                        block.getNumber(),
                        new Timestamp(block.getTimestamp().longValue() * 1000),
                        "0x" + Hex.toHexString(response.offerId),
                        response.holderIdentity,
                        response.challengerIdentity,
                        Hex.toHexString(response.litigationRootHash),
                        receipt.getGasUsed(),
                        transaction.getGasPrice(),
                        chainId
                );

                ReplacementStarted.insertIfNotExist(connection, replacementStarted);

            }, e -> {});
        }
    }
}
