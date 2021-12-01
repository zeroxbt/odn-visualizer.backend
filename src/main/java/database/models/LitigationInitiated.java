package database.models;

import java.math.BigInteger;
import java.sql.*;

public class LitigationInitiated {
    private final String transactionHash;
    private final BigInteger blockNumber;
    private final Timestamp timestamp;
    private final String offerId;
    private final String holderIdentity;
    private final BigInteger requestedObjectIndex;
    private final BigInteger requestedBlockIndex;
    private final BigInteger gasUsed;
    private final BigInteger gasPrice;
    private final int blockchainId;

    public LitigationInitiated
            (String transactionHash,
             BigInteger blockNumber,
             Timestamp timestamp,
             String offerId,
             String holderIdentity,
             BigInteger requestedObjectIndex,
             BigInteger requestedBlockIndex,
             BigInteger gasUsed,
             BigInteger gasPrice,
             int blockchainId) {
        this.transactionHash = transactionHash;
        this.blockNumber = blockNumber;
        this.timestamp = timestamp;
        this.offerId = offerId;
        this.holderIdentity = holderIdentity;
        this.requestedObjectIndex = requestedObjectIndex;
        this.requestedBlockIndex = requestedBlockIndex;
        this.gasUsed = gasUsed;
        this.gasPrice = gasPrice;
        this.blockchainId = blockchainId;
    }

    public static void insertIfNotExist(Connection connection, LitigationInitiated model) throws SQLException {
        String sql = "INSERT IGNORE INTO LitigationInitiated VALUES (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, model.transactionHash);
        statement.setLong(2, model.blockNumber.longValue());
        statement.setTimestamp(3, model.timestamp);
        statement.setString(4, model.offerId);
        statement.setString(5, model.holderIdentity);
        statement.setLong(6, model.requestedObjectIndex.longValue());
        statement.setLong(7, model.requestedBlockIndex.longValue());
        statement.setLong(8, model.gasUsed.longValue());
        statement.setLong(9, model.gasPrice.longValue());
        statement.setInt(10, model.blockchainId);
        int result = statement.executeUpdate();
        if(result > 0) {
            System.out.println("new litigationInitiated event : " + model);
        }
        statement.close();
    }

    @Override
    public String toString() {
        return "LitigationInitiated{" +
                "transactionHash='" + transactionHash + '\'' +
                ", blockNumber=" + blockNumber +
                ", timestamp=" + timestamp +
                ", offerId='" + offerId + '\'' +
                ", holderIdentity='" + holderIdentity + '\'' +
                ", gasUsed=" + gasUsed +
                ", gasPrice=" + gasPrice +
                ", requestedObjectIndex=" + requestedObjectIndex +
                ", requestedBlockIndex=" + requestedBlockIndex +
                ", blockchainId=" + blockchainId +
                '}';
    }
}
