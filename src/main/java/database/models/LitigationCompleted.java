package database.models;

import java.math.BigInteger;
import java.sql.*;

public class LitigationCompleted {
    private final String transactionHash;
    private final BigInteger blockNumber;
    private final Timestamp timestamp;
    private final String offerId;
    private final String holderIdentity;
    private final boolean dhWasPenalized;
    private final BigInteger gasUsed;
    private final BigInteger gasPrice;
    private final int blockchainId;

    public LitigationCompleted
            (String transactionHash,
             BigInteger blockNumber,
             Timestamp timestamp,
             String offerId,
             String holderIdentity,
             boolean dhWasPenalized,
             BigInteger gasUsed,
             BigInteger gasPrice,
             int blockchainId) {
        this.transactionHash = transactionHash;
        this.blockNumber = blockNumber;
        this.timestamp = timestamp;
        this.offerId = offerId;
        this.holderIdentity = holderIdentity;
        this.dhWasPenalized = dhWasPenalized;
        this.gasUsed = gasUsed;
        this.gasPrice = gasPrice;
        this.blockchainId = blockchainId;
    }

    public static void insertIfNotExist(Connection connection, LitigationCompleted model) throws SQLException {
        String sql = "INSERT IGNORE INTO LitigationCompleted VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, model.transactionHash);
        statement.setLong(2, model.blockNumber.longValue());
        statement.setTimestamp(3, model.timestamp);
        statement.setString(4, model.offerId);
        statement.setString(5, model.holderIdentity);
        statement.setBoolean(6, model.dhWasPenalized);
        statement.setLong(7, model.gasUsed.longValue());
        statement.setLong(8, model.gasPrice.longValue());
        statement.setInt(9, model.blockchainId);
        int result = statement.executeUpdate();
        if(result > 0) {
            System.out.println("new litigationCompleted event : " + model);
        }
        statement.close();
    }

    @Override
    public String toString() {
        return "LitigationCompleted{" +
                "transactionHash='" + transactionHash + '\'' +
                ", blockNumber=" + blockNumber +
                ", timestamp=" + timestamp +
                ", offerId='" + offerId + '\'' +
                ", holderIdentity='" + holderIdentity + '\'' +
                ", dhWasPenalized=" + dhWasPenalized +
                ", gasUsed=" + gasUsed +
                ", gasPrice=" + gasPrice +
                ", blockchainId=" + blockchainId +
                '}';
    }
}
