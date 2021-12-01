package database.models;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Offer {
    private final Timestamp createdTimestamp;
    private final Timestamp finalizedTimestamp;
    private final String dcNodeId;
    private final BigInteger holdingTimeInMinutes;
    private final BigDecimal tokenAmountPerHolder;
    private final String dataSetId;
    private final BigInteger litigationIntervalInMinutes;
    private final String createdTransactionHash;
    private final String finalizedTransactionHash;
    private final String offerId;
    private final boolean isFinalized;
    private final BigInteger dataSetSizeInBytes;
    private final BigInteger createdBlockNumber;
    private final BigInteger finalizedBlockNumber;
    private final int blockchainId;

    public Offer(Timestamp createdTimestamp,
                 Timestamp finalizedTimestamp,
                 String dcNodeId,
                 BigInteger holdingTimeInMinutes,
                 BigDecimal tokenAmountPerHolder,
                 String dataSetId,
                 BigInteger litigationIntervalInMinutes,
                 String createdTransactionHash,
                 String finalizedTransactionHash,
                 String offerId,
                 boolean isFinalized,
                 BigInteger dataSetSizeInBytes,
                 BigInteger createdBlockNumber,
                 BigInteger finalizedBlockNumber,
                 int blockchainId) {
        this.createdTimestamp = createdTimestamp;
        this.finalizedTimestamp = finalizedTimestamp;
        this.dcNodeId = dcNodeId;
        this.holdingTimeInMinutes = holdingTimeInMinutes;
        this.tokenAmountPerHolder = tokenAmountPerHolder;
        this.dataSetId = dataSetId;
        this.litigationIntervalInMinutes = litigationIntervalInMinutes;
        this.createdTransactionHash = createdTransactionHash;
        this.finalizedTransactionHash = finalizedTransactionHash;
        this.offerId = offerId;
        this.isFinalized = isFinalized;
        this.dataSetSizeInBytes = dataSetSizeInBytes;
        this.createdBlockNumber = createdBlockNumber;
        this.finalizedBlockNumber = finalizedBlockNumber;
        this.blockchainId = blockchainId;
    }


    public static void insertIfNotExist(Connection connection, OfferCreated offerCreated) throws SQLException {
        String sql = "INSERT IGNORE INTO Offer (CreatedTimestamp, " +
                "DCNodeId, " +
                "HoldingTimeInMinutes, " +
                "TokenAmountPerHolder, " +
                "DataSetId, " +
                "LitigationIntervalInMinutes, " +
                "CreatedTransactionHash, " +
                "OfferId, " +
                "IsFinalized, " +
                "DataSetSizeInBytes, " +
                "CreatedBlockNumber, " +
                "BlockchainId) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setTimestamp(1, offerCreated.getTimestamp());
        statement.setString(2, offerCreated.getDcNodeId());
        statement.setLong(3, offerCreated.getHoldingTimeInMinutes().longValue());
        statement.setBigDecimal(4, offerCreated.getTokenAmountPerHolder());
        statement.setString(5, offerCreated.getDataSetId());
        statement.setLong(6, offerCreated.getLitigationIntervalInMinutes().longValue());
        statement.setString(7, offerCreated.getTransactionHash());
        statement.setString(8, offerCreated.getOfferId());
        statement.setBoolean(9, false);
        statement.setLong(10, offerCreated.getDataSetSizeInBytes().longValue());
        statement.setLong(11, offerCreated.getBlockNumber().longValue());
        statement.setInt(12, offerCreated.getBlockchainId());
        int result = statement.executeUpdate();
        if (result > 0) {
            System.out.println("Offer table updated : " + offerCreated);
        }
        statement.close();
    }

    public static void updateFinalized(Connection connection, OfferFinalized offerFinalized) throws SQLException {
        String sql = "UPDATE Offer SET FinalizedTimestamp = ?, FinalizedTransactionHash = ?, IsFinalized = ?, FinalizedBlockNumber = ? WHERE OfferId = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setTimestamp(1, offerFinalized.getTimestamp());
        statement.setString(2, offerFinalized.getTransactionHash());
        statement.setBoolean(3, true);
        statement.setLong(4, offerFinalized.getBlockNumber().longValue());
        statement.setString(5, offerFinalized.getOfferId());
        int result = statement.executeUpdate();
        if (result > 0) {
            System.out.println("Offer table updated : " + offerFinalized);
        }
        statement.close();
    }

    @Override
    public String toString() {
        return "Offers{" +
                "createdTimestamp=" + createdTimestamp +
                ", finalizedTimestamp=" + finalizedTimestamp +
                ", dcNodeId='" + dcNodeId + '\'' +
                ", holdingTimeInMinutes=" + holdingTimeInMinutes +
                ", tokenAmountPerHolder=" + tokenAmountPerHolder +
                ", dataSetId='" + dataSetId + '\'' +
                ", litigationIntervalInMinutes=" + litigationIntervalInMinutes +
                ", createdTransactionHash='" + createdTransactionHash + '\'' +
                ", finalizedTransactionHash='" + finalizedTransactionHash + '\'' +
                ", offerId='" + offerId + '\'' +
                ", isFinalized=" + isFinalized +
                ", dataSetSizeInBytes=" + dataSetSizeInBytes +
                ", createdBlockNumber=" + createdBlockNumber +
                ", finalizedBlockNumber=" + finalizedBlockNumber +
                ", blockchainId=" + blockchainId +
                '}';
    }
}
