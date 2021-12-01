package database.models;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.*;

public class Identity {
    private final String identity;
    private final String transactionHash;
    private final BigDecimal stake;
    private final BigDecimal stakeReserved;
    private final BigDecimal paidOut;
    private final BigInteger reputation;
    private final boolean withdrawalPending;
    private final BigInteger withdrawalTimestamp;
    private final BigDecimal withdrawalAmount;
    private final String nodeId;
    private final int blockchainId;

    public Identity
            (String identity,
             String transactionHash,
             BigDecimal stake,
             BigDecimal stakeReserved,
             BigDecimal paidOut,
             BigInteger reputation,
             boolean withdrawalPending,
             BigInteger withdrawalTimestamp,
             BigDecimal withdrawalAmount,
             String nodeId,
             int blockchainId) {
        this.identity = identity;
        this.transactionHash = transactionHash;
        this.stake = stake;
        this.stakeReserved = stakeReserved;
        this.paidOut = paidOut;
        this.reputation = reputation;
        this.withdrawalPending = withdrawalPending;
        this.withdrawalTimestamp = withdrawalTimestamp;
        this.withdrawalAmount = withdrawalAmount;
        this.nodeId = nodeId;
        this.blockchainId = blockchainId;
    }

    public Identity(String identity,
                    String transactionHash,
                    int blockchainId) {
        this(identity,
                transactionHash,
                null,
                null,
                null,
                null,
                false,
                null,
                null,
                "-1",
                blockchainId);
    }

    public Identity(String identity,
                    String transactionHash,
                    int blockchainId,
                    String nodeId) {
        this(identity,
                transactionHash,
                null,
                null,
                null,
                null,
                false,
                null,
                null,
                nodeId,
                blockchainId);
    }

    public static void insertIfNotExist(Connection connection, Identity model) throws SQLException {
        String sql = "INSERT IGNORE INTO Identity (Identity, TransactionHash, BlockchainId, NodeId, IsLatest) VALUES (?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, model.identity);
        statement.setString(2, model.transactionHash);
        statement.setInt(3, model.blockchainId);
        statement.setString(4, model.nodeId);
        statement.setBoolean(5, true);
        int result = statement.executeUpdate();
        if (result > 0) {
            System.out.println("Identity table updated : " + model);
        }
        statement.close();
    }

    public static void updateExisting(Connection connection, Identity model) throws SQLException {
        String sql = "UPDATE Identity SET Stake = ?, StakeReserved = ?, PaidOut = ?, Reputation = ?, WithdrawalPending = ?, WithdrawalTimestamp = ?, WithdrawalAmount = ? WHERE NodeId = ? AND Identity = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setBigDecimal(1, model.stake);
        statement.setBigDecimal(2, model.stakeReserved);
        statement.setBigDecimal(3, model.paidOut);
        statement.setLong(4, model.reputation.longValue());
        statement.setBoolean(5, model.withdrawalPending);
        statement.setLong(6, model.withdrawalTimestamp.longValue());
        statement.setBigDecimal(7, model.withdrawalAmount);
        statement.setString(8, model.nodeId);
        statement.setString(9, model.identity);
        int result = statement.executeUpdate();
        if (result > 0) {
            System.out.println("Identity table updated : " + model);
        }
        statement.close();
    }

    public static void updatePaidOut(Connection connection, BigDecimal paidOut, String identity) throws SQLException {
        String sql = "UPDATE Identity SET PaidOut = PaidOut + ? WHERE Identity = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setBigDecimal(1, paidOut);
        statement.setString(2, identity);
        int result = statement.executeUpdate();
        if (result > 0) {
            System.out.println("Identity table updated : " + "identity='" + identity + '\'' + ", paidOut=" + paidOut);
        }
        statement.close();
    }

    public static void updateIsLatest(Connection connection, String identity) throws SQLException {
        String sql = "UPDATE Identity SET IsLatest = false WHERE Identity = ? AND IsLatest = true";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, identity);
        int result = statement.executeUpdate();
        if (result > 0) {
            System.out.println("Identity table updated : " + "identity='" + identity);
        }
        statement.close();
    }

    public static ResultSet getAll(Connection connection, int blockchainId) throws SQLException {
        String sql = "SELECT * FROM Identity WHERE BlockchainId = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, blockchainId);
        return statement.executeQuery();
    }

    public static String getNodeId(Connection connection, String identity) throws SQLException {
        String sql = "SELECT NodeId FROM Identity WHERE Identity = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, identity);
        ResultSet resultSet = statement.executeQuery();
        return resultSet.next() ? resultSet.getString("NodeId") : null;
    }


    @Override
    public String toString() {
        return "Identity{" +
                "identity='" + identity + '\'' +
                ", transactionHash='" + transactionHash + '\'' +
                ", stake=" + stake +
                ", stakeReserved=" + stakeReserved +
                ", paidOut=" + paidOut +
                ", reputation=" + reputation +
                ", withdrawalPending=" + withdrawalPending +
                ", withdrawalTimestamp=" + withdrawalTimestamp +
                ", withdrawalAmount=" + withdrawalAmount +
                ", nodeId='" + nodeId + '\'' +
                ", blockchainId=" + blockchainId +
                '}';
    }
}
