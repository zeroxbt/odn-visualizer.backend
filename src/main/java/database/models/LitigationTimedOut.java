package database.models;

import java.math.BigInteger;
import java.sql.*;

public class LitigationTimedOut {
    private final String transactionHash;
    private final BigInteger blockNumber;
    private final Timestamp timestamp;
    private final String offerId;
    private final String holderIdentity;
    private final BigInteger gasUsed;
    private final BigInteger gasPrice;
    private final int blockchainId;

    public LitigationTimedOut
            (String transactionHash,
             BigInteger blockNumber,
             Timestamp timestamp,
             String offerId,
             String holderIdentity,
             BigInteger gasUsed,
             BigInteger gasPrice,
             int blockchainId) {
        this.transactionHash = transactionHash;
        this.blockNumber = blockNumber;
        this.timestamp = timestamp;
        this.offerId = offerId;
        this.holderIdentity = holderIdentity;
        this.gasUsed = gasUsed;
        this.gasPrice = gasPrice;
        this.blockchainId = blockchainId;
    }

    public static void insertIfNotExist(Connection connection, LitigationTimedOut model) throws SQLException {
        String sql = "INSERT IGNORE INTO LitigationTimedOut VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, model.transactionHash);
        statement.setLong(2, model.blockNumber.longValue());
        statement.setTimestamp(3, model.timestamp);
        statement.setString(4, model.offerId);
        statement.setString(5, model.holderIdentity);
        statement.setLong(6, model.gasUsed.longValue());
        statement.setLong(7, model.gasPrice.longValue());
        statement.setInt(8, model.blockchainId);
        int result = statement.executeUpdate();
        if(result > 0) {
            System.out.println("new litigationTimedOut event : " + model);
        }
        statement.close();
    }

    @Override
    public String toString() {
        return "LitigationTimedOut{" +
                "transactionHash='" + transactionHash + '\'' +
                ", blockNumber=" + blockNumber +
                ", timestamp=" + timestamp +
                ", offerId='" + offerId + '\'' +
                ", holderIdentity='" + holderIdentity + '\'' +
                ", gasUsed=" + gasUsed +
                ", gasPrice=" + gasPrice +
                ", blockchainId=" + blockchainId +
                '}';
    }
}
