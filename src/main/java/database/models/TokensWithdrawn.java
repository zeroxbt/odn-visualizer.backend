package database.models;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TokensWithdrawn {
    private final String transactionHash;
    private final String contractAddress;
    private final BigInteger blockNumber;
    private final String profile;
    private final BigDecimal amountWithdrawn;
    private final BigDecimal newBalance;
    private final BigInteger gasUsed;
    private final BigInteger gasPrice;
    private final int blockchainId;

    public TokensWithdrawn
            (String transactionHash,
             String contractAddress,
             BigInteger blockNumber,
             String profile,
             BigDecimal amountWithdrawn,
             BigDecimal newBalance,
             BigInteger gasUsed,
             BigInteger gasPrice,
             int blockchainId) {
        this.transactionHash = transactionHash;
        this.contractAddress = contractAddress;
        this.blockNumber = blockNumber;
        this.profile = profile;
        this.amountWithdrawn = amountWithdrawn;
        this.newBalance = newBalance;
        this.gasUsed = gasUsed;
        this.gasPrice = gasPrice;
        this.blockchainId = blockchainId;
    }

    public static void insertIfNotExist(Connection connection, TokensWithdrawn model) throws SQLException {
        String sql = "INSERT IGNORE INTO tokensWithdrawn VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, model.transactionHash);
        statement.setString(2, model.contractAddress);
        statement.setLong(3, model.blockNumber.longValue());
        statement.setString(4, model.profile);
        statement.setBigDecimal(5, model.amountWithdrawn);
        statement.setBigDecimal(6, model.newBalance);
        statement.setLong(7, model.gasUsed.longValue());
        statement.setLong(8, model.gasPrice.longValue());
        statement.setInt(9, model.blockchainId);
        int result = statement.executeUpdate();
        if (result > 0) {
            System.out.println("new tokensWithdrawn event : " + model);
        }
        statement.close();
    }

    @Override
    public String toString() {
        return "TokensWithdrawn{" +
                "transactionHash='" + transactionHash + '\'' +
                ", contractAddress='" + contractAddress + '\'' +
                ", blockNumber=" + blockNumber +
                ", profile='" + profile + '\'' +
                ", amountWithdrawn=" + amountWithdrawn +
                ", newBalance=" + newBalance +
                ", gasUsed=" + gasUsed +
                ", gasPrice=" + gasPrice +
                ", blockchainId=" + blockchainId +
                '}';
    }
}
