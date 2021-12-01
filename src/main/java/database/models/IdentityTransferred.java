package database.models;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IdentityTransferred {
    private final String transactionHash;
    private final String nodeId;
    private final String oldIdentity;
    private final String newIdentity;
    private final String contractAddress;
    private final BigInteger blockNumber;
    private final String managementWallet;
    private final BigInteger gasUsed;
    private final BigInteger gasPrice;
    private final int blockchainId;

    public IdentityTransferred
            (String transactionHash,
             String nodeId,
             String oldIdentity,
             String newIdentity,
             String contractAddress,
             BigInteger blockNumber,
             String managementWallet,
             BigInteger gasUsed,
             BigInteger gasPrice,
             int blockchainId) {
        this.transactionHash = transactionHash;
        this.nodeId = nodeId;
        this.oldIdentity = oldIdentity;
        this.newIdentity = newIdentity;
        this.contractAddress = contractAddress;
        this.blockNumber = blockNumber;
        this.managementWallet = managementWallet;
        this.gasUsed = gasUsed;
        this.gasPrice = gasPrice;
        this.blockchainId = blockchainId;
    }

    public static void insertIfNotExist(Connection connection, IdentityTransferred model) throws SQLException {
        String sql = "INSERT IGNORE INTO IdentityTransferred VALUES (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, model.transactionHash);
        statement.setString(2, model.nodeId);
        statement.setString(3, model.oldIdentity);
        statement.setString(4, model.newIdentity);
        statement.setString(5, model.contractAddress);
        statement.setLong(6, model.blockNumber.longValue());
        statement.setString(7, model.managementWallet);
        statement.setLong(8, model.gasUsed.longValue());
        statement.setLong(9, model.gasPrice.longValue());
        statement.setInt(10, model.blockchainId);
        int result = statement.executeUpdate();
        if (result > 0) {
            System.out.println("new identityTransferred event : " + model);
        }
        statement.close();
    }

    @Override
    public String toString() {
        return "IdentityTransferred{" +
                "transactionHash='" + transactionHash + '\'' +
                ", nodeId='" + nodeId + '\'' +
                ", oldIdentity='" + oldIdentity + '\'' +
                ", newIdentity='" + newIdentity + '\'' +
                ", contractAddress='" + contractAddress + '\'' +
                ", blockNumber=" + blockNumber +
                ", managementWallet='" + managementWallet + '\'' +
                ", gasUsed=" + gasUsed +
                ", gasPrice=" + gasPrice +
                ", blockchainId=" + blockchainId +
                '}';
    }
}
