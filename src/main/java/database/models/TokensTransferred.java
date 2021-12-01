package database.models;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TokensTransferred {
    private final String transactionHash;
    private final String contractAddress;
    private final BigInteger blockNumber;
    private final String sender;
    private final String receiver;
    private final BigDecimal amount;
    private final BigInteger gasUsed;
    private final BigInteger gasPrice;
    private final int blockchainId;

    public TokensTransferred
            (String transactionHash,
             String contractAddress,
             BigInteger blockNumber,
             String sender,
             String receiver,
             BigDecimal amount,
             BigInteger gasUsed,
             BigInteger gasPrice,
             int blockchainId) {
        this.transactionHash = transactionHash;
        this.contractAddress = contractAddress;
        this.blockNumber = blockNumber;
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.gasUsed = gasUsed;
        this.gasPrice = gasPrice;
        this.blockchainId = blockchainId;
    }

    public static void insertIfNotExist(Connection connection, TokensTransferred model) throws SQLException {
        String sql = "INSERT IGNORE INTO tokensTransferred VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, model.transactionHash);
        statement.setString(2, model.contractAddress);
        statement.setLong(3, model.blockNumber.longValue());
        statement.setString(4, model.sender);
        statement.setString(5, model.receiver);
        statement.setBigDecimal(6, model.amount);
        statement.setLong(7, model.gasUsed.longValue());
        statement.setLong(8, model.gasPrice.longValue());
        statement.setInt(9, model.blockchainId);
        int result = statement.executeUpdate();
        if (result > 0) {
            System.out.println("new tokensTransferred event : " + model);
        }
        statement.close();
    }


    @Override
    public String toString() {
        return "TokensTransferred{" +
                "transactionHash='" + transactionHash + '\'' +
                ", contractAddress='" + contractAddress + '\'' +
                ", blockNumber=" + blockNumber +
                ", sender='" + sender + '\'' +
                ", receiver='" + receiver + '\'' +
                ", amount=" + amount +
                ", gasUsed=" + gasUsed +
                ", gasPrice=" + gasPrice +
                ", blockchainId=" + blockchainId +
                '}';
    }
}
