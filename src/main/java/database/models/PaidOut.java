package database.models;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.*;

public class PaidOut {
    private final String offerId;
    private final String holder;
    private final BigDecimal amount;
    private final Timestamp timestamp;
    private final String transactionHash;
    private final String contractAddress;
    private final BigInteger blockNumber;
    private final BigInteger gasUsed;
    private final BigInteger gasPrice;
    private final String data;
    private final int blockchainId;

    public PaidOut
            (String offerId,
             String holder,
             BigDecimal amount,
             Timestamp timestamp,
             String transactionHash,
             String contractAddress,
             BigInteger blockNumber,
             BigInteger gasUsed,
             BigInteger gasPrice,
             String data,
             int blockchainId)
    {
        this.offerId = offerId;
        this.holder = holder;
        this.amount = amount;
        this.timestamp = timestamp;
        this.transactionHash = transactionHash;
        this.contractAddress = contractAddress;
        this.blockNumber = blockNumber;
        this.gasUsed = gasUsed;
        this.gasPrice = gasPrice;
        this.data = data;
        this.blockchainId = blockchainId;
    }

    public static void insertIfNotExist(Connection connection, PaidOut model) throws SQLException {
        String sql = "INSERT IGNORE INTO paidOut VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, model.offerId);
        statement.setString(2, model.holder);
        statement.setBigDecimal(3, model.amount);
        statement.setTimestamp(4, model.timestamp);
        statement.setString(5, model.transactionHash);
        statement.setString(6, model.contractAddress);
        statement.setLong(7, model.blockNumber.longValue());
        statement.setLong(8, model.gasUsed.longValue());
        statement.setLong(9, model.gasPrice.longValue());
        statement.setString(10, model.data);
        statement.setInt(11, model.blockchainId);
        int result = statement.executeUpdate();
        if(result > 0) {
            System.out.println("new paidOut event : " + model);
        }
        statement.close();
    }


    @Override
    public String toString() {
        return "PaidOut{" +
                "offerId='" + offerId + '\'' +
                ", holder='" + holder + '\'' +
                ", amount=" + amount +
                ", timestamp=" + timestamp +
                ", transactionHash='" + transactionHash + '\'' +
                ", contractAddress='" + contractAddress + '\'' +
                ", blockNumber=" + blockNumber +
                ", gasUsed=" + gasUsed +
                ", gasPrice=" + gasPrice +
                ", data='" + data + '\'' +
                ", blockchainId=" + blockchainId +
                '}';
    }
}
