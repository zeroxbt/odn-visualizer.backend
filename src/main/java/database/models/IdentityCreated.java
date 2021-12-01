package database.models;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IdentityCreated {
    private final String transactionHash;
    private final String profile;
    private final String newIdentity;
    private final String contractAddress;
    private final BigInteger blockNumber;
    private final BigInteger gasUsed;
    private final BigInteger gasPrice;
    private final int blockchainId;

    public IdentityCreated
            (String transactionHash,
             String profile,
             String newIdentity,
             String contractAddress,
             BigInteger blockNumber,
             BigInteger gasUsed,
             BigInteger gasPrice,
             int blockchainId) {
        this.transactionHash = transactionHash;
        this.profile = profile;
        this.newIdentity = newIdentity;
        this.contractAddress = contractAddress;
        this.blockNumber = blockNumber;
        this.gasUsed = gasUsed;
        this.gasPrice = gasPrice;
        this.blockchainId = blockchainId;
    }

    public static void insertIfNotExist(Connection connection, IdentityCreated model) throws SQLException {
        String sql = "INSERT IGNORE INTO IdentityCreated VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, model.transactionHash);
        statement.setString(2, model.profile);
        statement.setString(3, model.newIdentity);
        statement.setString(4, model.contractAddress);
        statement.setLong(5, model.blockNumber.longValue());
        statement.setLong(6, model.gasUsed.longValue());
        statement.setLong(7, model.gasPrice.longValue());
        statement.setInt(8, model.blockchainId);
        int result = statement.executeUpdate();
        if(result > 0) {
            System.out.println("new IdentityCreated event : " + model);
        }
        statement.close();
    }

    @Override
    public String toString() {
        return "IdentityCreated{" +
                "transactionHash='" + transactionHash + '\'' +
                ", profile='" + profile + '\'' +
                ", newIdentity='" + newIdentity + '\'' +
                ", contractAddress='" + contractAddress + '\'' +
                ", blockNumber=" + blockNumber +
                ", gasUsed=" + gasUsed +
                ", gasPrice=" + gasPrice +
                ", blockchainId=" + blockchainId +
                '}';
    }
}
