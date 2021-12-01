package database.models;

import java.math.BigInteger;
import java.sql.*;

public class NodeRemoved {
    private final String transactionHash;
    private final String contractAddress;
    private final String nodeId;
    private final Timestamp timestamp;
    private final BigInteger blockNumber;

    public NodeRemoved
            (String transactionHash,
             String contractAddress,
             String nodeId,
             Timestamp timestamp,
             BigInteger blockNumber) {
        this.transactionHash = transactionHash;
        this.contractAddress = contractAddress;
        this.nodeId = nodeId;
        this.timestamp = timestamp;
        this.blockNumber = blockNumber;
    }

    public static void insertIfNotExist(Connection connection, NodeRemoved model) throws SQLException {
        String sql = "INSERT IGNORE INTO NodeRemoved VALUES (?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, model.transactionHash);
        statement.setString(2, model.contractAddress);
        statement.setString(3, model.nodeId);
        statement.setTimestamp(4, model.timestamp);
        statement.setLong(5, model.blockNumber.longValue());
        int result = statement.executeUpdate();
        if(result > 0) {
            System.out.println("new nodeRemoved event : " + model);
        }
        statement.close();
    }

    @Override
    public String toString() {
        return "NodeRemoved{" +
                "transactionHash='" + transactionHash + '\'' +
                ", contractAddress='" + contractAddress + '\'' +
                ", nodeId='" + nodeId + '\'' +
                ", timestamp=" + timestamp +
                ", blockNumber=" + blockNumber +
                '}';
    }
}
