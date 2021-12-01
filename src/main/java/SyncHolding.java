import contracts.Holding;
import database.models.*;
import org.bouncycastle.util.encoders.Hex;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.methods.response.EthBlock;
import org.web3j.protocol.core.methods.response.Transaction;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.utils.Convert;
import util.Decoder;

import java.sql.*;

public class SyncHolding extends Thread {
    private final int chainId;
    private final String contractName;

    public SyncHolding(int chainId) {
        this.chainId = chainId;
        this.contractName = Holding.class.getSimpleName();
    }

    @Override
    public void run() {
        try {
            loadFromHolding();
        } catch (Throwable throwables) {
            System.out.println(throwables.getMessage());
        }
    }

    private void loadFromHolding() throws SQLException {
        new SyncOfferCreatedThread().start();
        new SyncOfferFinalizedThread().start();
        new SyncOfferTaskThread().start();
        new SyncPaidOutThread().start();
        new SyncOwnershipTransferredThread().start();
    }

    private class SyncOfferCreatedThread extends SyncEventThread {
        private SyncOfferCreatedThread() throws SQLException {
            super(contractName, Holding.OFFERCREATED_EVENT, chainId);
        }

        @Override
        void handleEvent(String contractAddress, Web3j web3, DefaultBlockParameter start, DefaultBlockParameter end, Connection connection) {
            Holding holding = Holding.load(contractAddress, web3, Main.CREDENTIALS, new DefaultGasProvider());
            disposable = holding.offerCreatedEventFlowable(start, end).subscribe(response -> {
                Transaction transaction = web3.ethGetTransactionByHash(response.log.getTransactionHash()).send().getResult();
                EthBlock.Block block = web3.ethGetBlockByHash(response.log.getBlockHash(), false).send().getResult();
                TransactionReceipt receipt = web3.ethGetTransactionReceipt(transaction.getHash()).send().getResult();

                OfferCreated offerCreated = new OfferCreated(
                        new Timestamp(block.getTimestamp().longValue() * 1000),
                        response.litigationIntervalInMinutes,
                        Decoder.removeAddressPadding(Hex.toHexString(response.dcNodeId)),
                        "0x" + Hex.toHexString(response.dataSetId),
                        response.holdingTimeInMinutes,
                        Convert.fromWei(response.tokenAmountPerHolder.toString(), Convert.Unit.ETHER),
                        transaction.getTransactionIndex(),
                        transaction.getHash(),
                        block.getNumber(),
                        "0x" + Hex.toHexString(response.offerId),
                        response.dataSetSizeInBytes,
                        contractAddress,
                        receipt.getGasUsed(),
                        transaction.getGasPrice(),
                        response.log.getData(),
                        chainId
                );

                OfferCreated.insertIfNotExist(connection, offerCreated);
                Offer.insertIfNotExist(connection, offerCreated);
            }, e -> {
            });
        }

    }

    private class SyncOfferFinalizedThread extends SyncEventThread {
        private SyncOfferFinalizedThread() throws SQLException {
            super(contractName, Holding.OFFERFINALIZED_EVENT, chainId);
        }

        @Override
        void handleEvent(String contractAddress, Web3j web3, DefaultBlockParameter start, DefaultBlockParameter end, Connection connection) {
            Holding holding = Holding.load(contractAddress, web3, Main.CREDENTIALS, new DefaultGasProvider());
            disposable = holding.offerFinalizedEventFlowable(start, end).subscribe(response -> {
                Transaction transaction = web3.ethGetTransactionByHash(response.log.getTransactionHash()).send().getResult();
                EthBlock.Block block = web3.ethGetBlockByHash(response.log.getBlockHash(), false).send().getResult();
                TransactionReceipt receipt = web3.ethGetTransactionReceipt(transaction.getHash()).send().getResult();
                String offerId = "0x" + Hex.toHexString(response.offerId);
                Timestamp timestamp = new Timestamp(block.getTimestamp().longValue() * 1000);

                OfferFinalized offerFinalized = new OfferFinalized(
                        transaction.getHash(),
                        block.getNumber(),
                        timestamp,
                        offerId,
                        response.holder1,
                        response.holder2,
                        response.holder3,
                        contractAddress,
                        receipt.getGasUsed(),
                        transaction.getGasPrice(),
                        response.log.getData(),
                        chainId
                );
                OfferFinalized.insertIfNotExist(connection, offerFinalized);
                OfferHolders.insertIfNotExist(connection, new OfferHolders(offerId, response.holder1, chainId));
                OfferHolders.insertIfNotExist(connection, new OfferHolders(offerId, response.holder2, chainId));
                OfferHolders.insertIfNotExist(connection, new OfferHolders(offerId, response.holder3, chainId));
                Offer.updateFinalized(connection, offerFinalized);
            }, e -> {
            });
        }
    }

    private class SyncOfferTaskThread extends SyncEventThread {
        private SyncOfferTaskThread() throws SQLException {
            super(contractName, Holding.OFFERTASK_EVENT, chainId);
        }

        @Override
        void handleEvent(String contractAddress, Web3j web3, DefaultBlockParameter start, DefaultBlockParameter end, Connection connection) {
            Holding holding = Holding.load(contractAddress, web3, Main.CREDENTIALS, new DefaultGasProvider());
            disposable = holding.offerTaskEventFlowable(start, end).subscribe(response -> {
                Transaction transaction = web3.ethGetTransactionByHash(response.log.getTransactionHash()).send().getResult();
                EthBlock.Block block = web3.ethGetBlockByHash(response.log.getBlockHash(), false).send().getResult();
                TransactionReceipt receipt = web3.ethGetTransactionReceipt(transaction.getHash()).send().getResult();

                OfferTask offerTask = new OfferTask(
                        transaction.getHash(),
                        contractAddress,
                        "0x" + Hex.toHexString(response.dataSetId),
                        Decoder.removeAddressPadding(Hex.toHexString(response.dcNodeId)),
                        "0x" + Hex.toHexString(response.offerId),
                        Hex.toHexString(response.task),
                        block.getNumber(),
                        receipt.getGasUsed(),
                        transaction.getGasPrice(),
                        chainId
                );

                OfferTask.insertIfNotExist(connection, offerTask);

            }, e -> {
            });
        }
    }

    private class SyncPaidOutThread extends SyncEventThread {
        private SyncPaidOutThread() throws SQLException {
            super(contractName, Holding.PAIDOUT_EVENT, chainId);
        }

        @Override
        void handleEvent(String contractAddress, Web3j web3, DefaultBlockParameter start, DefaultBlockParameter end, Connection connection) {
            Holding holding = Holding.load(contractAddress, web3, Main.CREDENTIALS, new DefaultGasProvider());
            disposable = holding.paidOutEventFlowable(start, end).subscribe(response -> {
                Transaction transaction = web3.ethGetTransactionByHash(response.log.getTransactionHash()).send().getResult();
                EthBlock.Block block = web3.ethGetBlockByHash(response.log.getBlockHash(), false).send().getResult();
                TransactionReceipt receipt = web3.ethGetTransactionReceipt(transaction.getHash()).send().getResult();

                PaidOut paidOut = new PaidOut(
                        "0x" + Hex.toHexString(response.offerId),
                        response.holder,
                        Convert.fromWei(response.amount.toString(), Convert.Unit.ETHER),
                        new Timestamp(block.getTimestamp().longValue() * 1000),
                        transaction.getHash(),
                        contractAddress,
                        block.getNumber(),
                        receipt.getGasUsed(),
                        transaction.getGasPrice(),
                        response.log.getData(),
                        chainId
                );

            }, e -> {
            });
        }
    }

    private class SyncOwnershipTransferredThread extends SyncEventThread {
        private SyncOwnershipTransferredThread() throws SQLException {
            super(contractName, Holding.OWNERSHIPTRANSFERRED_EVENT, chainId);
        }

        @Override
        void handleEvent(String contractAddress, Web3j web3, DefaultBlockParameter start, DefaultBlockParameter end, Connection connection) {
            Holding holding = Holding.load(contractAddress, web3, Main.CREDENTIALS, new DefaultGasProvider());
            disposable = holding.ownershipTransferredEventFlowable(start, end).subscribe(response -> {
                Transaction transaction = web3.ethGetTransactionByHash(response.log.getTransactionHash()).send().getResult();
                EthBlock.Block block = web3.ethGetBlockByHash(response.log.getBlockHash(), false).send().getResult();
                TransactionReceipt receipt = web3.ethGetTransactionReceipt(transaction.getHash()).send().getResult();

                OwnershipTransferred ownershipTransferred = new OwnershipTransferred(
                        transaction.getHash(),
                        response.previousOwner,
                        response.newOwner,
                        contractAddress,
                        block.getNumber(),
                        receipt.getGasUsed(),
                        transaction.getGasPrice(),
                        chainId
                );

                OwnershipTransferred.insertIfNotExist(connection, ownershipTransferred);

            }, e -> {
            });
        }
    }
}
