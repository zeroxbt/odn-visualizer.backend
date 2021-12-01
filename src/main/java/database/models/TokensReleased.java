package database.models;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TokensReleased {
    private final String transactionHash;
    private final String contractAddress;
    private final BigInteger blockNumber;
    private final String profile;
    private final BigDecimal amount;
    private final BigInteger gasUsed;
    private final BigInteger gasPrice;
    private final int blockchainId;

    public TokensReleased
            (String transactionHash,
             String contractAddress,
             BigInteger blockNumber,
             String profile,
             BigDecimal amount,
             BigInteger gasUsed,
             BigInteger gasPrice,
             int blockchainId) {
        this.transactionHash = transactionHash;
        this.contractAddress = contractAddress;
        this.blockNumber = blockNumber;
        this.profile = profile;
        this.amount = amount;
        this.gasUsed = gasUsed;
        this.gasPrice = gasPrice;
        this.blockchainId = blockchainId;
    }

    public static void insertIfNotExist(Connection connection, TokensReleased model) throws SQLException {
        String sql = "INSERT IGNORE INTO tokensReleased VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, model.transactionHash);
        statement.setString(2, model.contractAddress);
        statement.setLong(3, model.blockNumber.longValue());
        statement.setString(4, model.profile);
        statement.setBigDecimal(5, model.amount);
        statement.setLong(6, model.gasUsed.longValue());
        statement.setLong(7, model.gasPrice.longValue());
        statement.setInt(8, model.blockchainId);
        int result = statement.executeUpdate();
        if (result > 0) {
            System.out.println("new tokensReleased event : " + model);
        }
        statement.close();
    }


    @Override
    public String toString() {
        return "TokensReleased{" +
                "transactionHash='" + transactionHash + '\'' +
                ", contractAddress='" + contractAddress + '\'' +
                ", blockNumber=" + blockNumber +
                ", profile='" + profile + '\'' +
                ", amount=" + amount +
                ", gasUsed=" + gasUsed +
                ", gasPrice=" + gasPrice +
                ", blockchainId=" + blockchainId +
                '}';
    }
}
