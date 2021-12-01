package database.models;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfileCreated {
    private final String transactionHash;
    private final String contractAddress;
    private final String profile;
    private final BigInteger blockNumber;
    private final BigDecimal initialBalance;
    private final String managementWallet;
    private final String nodeId;
    private final BigInteger gasUsed;
    private final BigInteger gasPrice;
    private final int blockchainId;

    public ProfileCreated
            (String transactionHash,
             String contractAddress,
             String profile,
             BigInteger blockNumber,
             BigDecimal initialBalance,
             String managementWallet,
             String nodeId,
             BigInteger gasUsed,
             BigInteger gasPrice,
             int blockchainId) {
        this.transactionHash = transactionHash;
        this.contractAddress = contractAddress;
        this.profile = profile;
        this.blockNumber = blockNumber;
        this.initialBalance = initialBalance;
        this.managementWallet = managementWallet;
        this.nodeId = nodeId;
        this.gasUsed = gasUsed;
        this.gasPrice = gasPrice;
        this.blockchainId = blockchainId;
    }

    public static void insertIfNotExist(Connection connection, ProfileCreated model) throws SQLException {
        String sql = "INSERT IGNORE INTO ProfileCreated VALUES (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, model.transactionHash);
        statement.setString(2, model.contractAddress);
        statement.setString(3, model.profile);
        statement.setLong(4, model.blockNumber.longValue());
        statement.setBigDecimal(5, model.initialBalance);
        statement.setString(6, model.managementWallet);
        statement.setString(7, model.nodeId);
        statement.setLong(8, model.gasUsed.longValue());
        statement.setLong(9, model.gasPrice.longValue());
        statement.setInt(10, model.blockchainId);
        int result = statement.executeUpdate();
        if (result > 0) {
            System.out.println("new profileCreated event : " + model);
        }
        statement.close();
    }


    @Override
    public String toString() {
        return "ProfileCreated{" +
                "transactionHash='" + transactionHash + '\'' +
                ", contractAddress='" + contractAddress + '\'' +
                ", profile='" + profile + '\'' +
                ", blockNumber=" + blockNumber +
                ", initialBalance=" + initialBalance +
                ", managementWallet='" + managementWallet + '\'' +
                ", nodeId='" + nodeId + '\'' +
                ", gasUsed=" + gasUsed +
                ", gasPrice=" + gasPrice +
                ", blockchainId=" + blockchainId +
                '}';
    }
}
