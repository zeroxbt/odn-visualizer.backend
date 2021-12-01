package database.models;

import java.math.BigInteger;
import java.sql.*;

public class OfferFinalized {
    private final String transactionHash;
    private final BigInteger blockNumber;
    private final Timestamp timestamp;
    private final String offerId;
    private final String holder1;
    private final String holder2;
    private final String holder3;
    private final String contractAddress;
    private final BigInteger gasUsed;
    private final BigInteger gasPrice;
    private final String data;
    private final int blockchainId;

    public OfferFinalized
            (String transactionHash,
             BigInteger blockNumber,
             Timestamp timestamp,
             String offerId,
             String holder1,
             String holder2,
             String holder3,
             String contractAddress,
             BigInteger gasUsed,
             BigInteger gasPrice,
             String data,
             int blockchainId) {
        this.transactionHash = transactionHash;
        this.blockNumber = blockNumber;
        this.timestamp = timestamp;
        this.offerId = offerId;
        this.holder1 = holder1;
        this.holder2 = holder2;
        this.holder3 = holder3;
        this.contractAddress = contractAddress;
        this.gasUsed = gasUsed;
        this.gasPrice = gasPrice;
        this.data = data;
        this.blockchainId = blockchainId;
    }

    public static void insertIfNotExist(Connection connection, OfferFinalized model) throws SQLException {
        String sql = "INSERT IGNORE INTO OfferFinalized VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, model.transactionHash);
        statement.setLong(2, model.blockNumber.longValue());
        statement.setTimestamp(3, model.timestamp);
        statement.setString(4, model.offerId);
        statement.setString(5, model.holder1);
        statement.setString(6, model.holder2);
        statement.setString(7, model.holder3);
        statement.setString(8, model.contractAddress);
        statement.setLong(9, model.gasUsed.longValue());
        statement.setLong(10, model.gasPrice.longValue());
        statement.setString(11, model.data);
        statement.setInt(12, model.blockchainId);
        int result = statement.executeUpdate();
        if(result > 0) {
            System.out.println("new finalizedOffer event : " + model);
        }
        statement.close();
    }

    public String getTransactionHash() {
        return transactionHash;
    }

    public BigInteger getBlockNumber() {
        return blockNumber;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public String getOfferId() {
        return offerId;
    }

    public int getBlockchainId() {
        return blockchainId;
    }

    @Override
    public String toString() {
        return "FinalizedOffer{" +
                "transactionHash='" + transactionHash + '\'' +
                ", blockNumber=" + blockNumber +
                ", timestamp=" + timestamp +
                ", offerId='" + offerId + '\'' +
                ", holder1='" + holder1 + '\'' +
                ", holder2='" + holder2 + '\'' +
                ", holder3='" + holder3 + '\'' +
                ", contractAddress='" + contractAddress + '\'' +
                ", gasUsed=" + gasUsed +
                ", gasPrice=" + gasPrice +
                ", data='" + data + '\'' +
                ", blockchainId=" + blockchainId +
                '}';
    }
}
