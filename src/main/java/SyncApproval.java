import contracts.Approval;
import database.models.NodeApproved;
import database.models.NodeRemoved;
import org.bouncycastle.util.encoders.Hex;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.methods.response.EthBlock;
import org.web3j.protocol.core.methods.response.Transaction;
import org.web3j.tx.gas.DefaultGasProvider;
import util.Decoder;

import java.sql.*;

public class SyncApproval extends Thread {
    private final int chainId;
    private final String contractName;

    public SyncApproval(int chainId) {
        this.chainId = chainId;
        this.contractName = Approval.class.getSimpleName();
    }

    @Override
    public void run() {
        try {
            loadFromApprovals();
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }
    }

    private void loadFromApprovals() throws SQLException {
        new SyncNodesApprovedThread().start();
        new SyncNodesRemovedThread().start();
    }

    private class SyncNodesApprovedThread extends SyncEventThread {
        private SyncNodesApprovedThread() throws SQLException {
            super(contractName, Approval.NODEAPPROVED_EVENT, chainId);
        }

        @Override
        void handleEvent(String contractAddress, Web3j web3, DefaultBlockParameter start, DefaultBlockParameter end, Connection connection) {
            Approval approval = Approval.load(contractAddress, web3, Main.CREDENTIALS, new DefaultGasProvider());
            disposable = approval.nodeApprovedEventFlowable(start, end).subscribe(response -> {
                Transaction transaction = web3.ethGetTransactionByHash(response.log.getTransactionHash()).send().getResult();
                EthBlock.Block block = web3.ethGetBlockByHash(response.log.getBlockHash(), false).send().getResult();

                NodeApproved nodeApproved = new NodeApproved(
                        transaction.getHash(),
                        contractAddress,
                        Decoder.removeAddressPadding(Hex.toHexString(response.nodeId)),
                        new Timestamp(block.getTimestamp().longValue() * 1000),
                        block.getNumber()
                );

                NodeApproved.insertIfNotExist(connection, nodeApproved);
            }, e -> {});
        }
    }

    private class SyncNodesRemovedThread extends SyncEventThread {
        private SyncNodesRemovedThread() throws SQLException {
            super(contractName, Approval.NODEREMOVED_EVENT, chainId);
        }

        @Override
        void handleEvent(String contractAddress, Web3j web3, DefaultBlockParameter start, DefaultBlockParameter end, Connection connection) {
            Approval approval = Approval.load(contractAddress, web3, Main.CREDENTIALS, new DefaultGasProvider());
            disposable = approval.nodeRemovedEventFlowable(start, end).subscribe(response -> {
                Transaction transaction = web3.ethGetTransactionByHash(response.log.getTransactionHash()).send().getResult();
                EthBlock.Block block = web3.ethGetBlockByHash(response.log.getBlockHash(), false).send().getResult();

                NodeRemoved nodeRemoved = new NodeRemoved(
                        transaction.getHash(),
                        contractAddress,
                        Decoder.removeAddressPadding(Hex.toHexString(response.nodeId)),
                        new Timestamp(block.getTimestamp().longValue() * 1000),
                        block.getNumber()
                );

                NodeRemoved.insertIfNotExist(connection, nodeRemoved);
            }, e -> {});
        }
    }
}
