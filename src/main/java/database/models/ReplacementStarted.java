package database.models;

import java.math.BigInteger;
import java.sql.*;

public class ReplacementStarted {
    private final String transactionHash;
    private final BigInteger blockNumber;
    private final Timestamp timestamp;
    private final String offerId;
    private final String holderIdentity;
    private final String challengerIdentity;
    private final String litigationRootHash;
    private final BigInteger gasUsed;
    private final BigInteger gasPrice;
    private final int blockchainId;

    public ReplacementStarted
            (String transactionHash,
             BigInteger blockNumber,
             Timestamp timestamp,
             String offerId,
             String holderIdentity,
             String challengerIdentity,
             String litigationRootHash,
             BigInteger gasUsed,
             BigInteger gasPrice,
             int blockchainId) {
        this.transactionHash = transactionHash;
        this.blockNumber = blockNumber;
        this.timestamp = timestamp;
        this.offerId = offerId;
        this.holderIdentity = holderIdentity;
        this.challengerIdentity = challengerIdentity;
        this.litigationRootHash = litigationRootHash;
        this.gasUsed = gasUsed;
        this.gasPrice = gasPrice;
        this.blockchainId = blockchainId;
    }

    public static void insertIfNotExist(Connection connection, ReplacementStarted model) throws SQLException {
        String sql = "INSERT IGNORE INTO ReplacementStarted VALUES (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, model.transactionHash);
        statement.setLong(2, model.blockNumber.longValue());
        statement.setTimestamp(3, model.timestamp);
        statement.setString(4, model.offerId);
        statement.setString(5, model.holderIdentity);
        statement.setString(6, model.challengerIdentity);
        statement.setString(7, model.litigationRootHash);
        statement.setLong(8, model.gasUsed.longValue());
        statement.setLong(9, model.gasPrice.longValue());
        statement.setInt(10, model.blockchainId);
        int result = statement.executeUpdate();
        if(result > 0) {
            System.out.println("new replacementStarted event : " + model);
        }
        statement.close();
    }

    @Override
    public String toString() {
        return "ReplacementStarted{" +
                "transactionHash='" + transactionHash + '\'' +
                ", blockNumber=" + blockNumber +
                ", timestamp=" + timestamp +
                ", offerId='" + offerId + '\'' +
                ", holderIdentity='" + holderIdentity + '\'' +
                ", challengerIdentity='" + challengerIdentity + '\'' +
                ", litigationRootHash='" + litigationRootHash + '\'' +
                ", gasUsed=" + gasUsed +
                ", gasPrice=" + gasPrice +
                ", blockchainId=" + blockchainId +
                '}';
    }
}
