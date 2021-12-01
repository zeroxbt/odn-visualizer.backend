package database.models;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TokensDeposited {
    private final String transactionHash;
    private final String contractAddress;
    private final BigInteger blockNumber;
    private final String profile;
    private final BigDecimal amountDeposited;
    private final BigDecimal newBalance;
    private final BigInteger gasUsed;
    private final BigInteger gasPrice;
    private final int blockchainId;

    public TokensDeposited
            (String transactionHash,
             String contractAddress,
             BigInteger blockNumber,
             String profile,
             BigDecimal amountDeposited,
             BigDecimal newBalance,
             BigInteger gasUsed,
             BigInteger gasPrice,
             int blockchainId) {
        this.transactionHash = transactionHash;
        this.contractAddress = contractAddress;
        this.blockNumber = blockNumber;
        this.profile = profile;
        this.amountDeposited = amountDeposited;
        this.newBalance = newBalance;
        this.gasUsed = gasUsed;
        this.gasPrice = gasPrice;
        this.blockchainId = blockchainId;
    }

    public static void insertIfNotExist(Connection connection, TokensDeposited model) throws SQLException {
        String sql = "INSERT IGNORE INTO tokensDeposited VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, model.transactionHash);
        statement.setString(2, model.contractAddress);
        statement.setLong(3, model.blockNumber.longValue());
        statement.setString(4, model.profile);
        statement.setBigDecimal(5, model.amountDeposited);
        statement.setBigDecimal(6, model.newBalance);
        statement.setLong(7, model.gasUsed.longValue());
        statement.setLong(8, model.gasPrice.longValue());
        statement.setInt(9, model.blockchainId);
        int result = statement.executeUpdate();
        if (result > 0) {
            System.out.println("new tokensDeposited event : " + model);
        }
        statement.close();
    }


    @Override
    public String toString() {
        return "TokensDeposited{" +
                "transactionHash='" + transactionHash + '\'' +
                ", contractAddress='" + contractAddress + '\'' +
                ", blockNumber=" + blockNumber +
                ", profile='" + profile + '\'' +
                ", amountDeposited=" + amountDeposited +
                ", newBalance=" + newBalance +
                ", gasUsed=" + gasUsed +
                ", gasPrice=" + gasPrice +
                ", blockchainId=" + blockchainId +
                '}';
    }
}
