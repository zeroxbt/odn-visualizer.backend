package database.models;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OfferTask {
    private final String transactionHash;
    private final String contractAddress;
    private final String dataSetId;
    private final String dcNodeId;
    private final String offerId;
    private final String task;
    private final BigInteger blockNumber;
    private final BigInteger gasUsed;
    private final BigInteger gasPrice;
    private final int blockchainId;

    public OfferTask
            (String transactionHash,
             String contractAddress,
             String dataSetId,
             String dcNodeId,
             String offerId,
             String task,
             BigInteger blockNumber,
             BigInteger gasUsed,
             BigInteger gasPrice,
             int blockchainId) {
        this.transactionHash = transactionHash;
        this.contractAddress = contractAddress;
        this.dataSetId = dataSetId;
        this.dcNodeId = dcNodeId;
        this.offerId = offerId;
        this.task = task;
        this.blockNumber = blockNumber;
        this.gasUsed = gasUsed;
        this.gasPrice = gasPrice;
        this.blockchainId = blockchainId;
    }

    public static void insertIfNotExist(Connection connection, OfferTask model) throws SQLException {
        String sql = "INSERT IGNORE INTO OfferTask VALUES (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, model.transactionHash);
        statement.setString(2, model.contractAddress);
        statement.setString(3, model.dataSetId);
        statement.setString(4, model.dcNodeId);
        statement.setString(5, model.offerId);
        statement.setString(6, model.task);
        statement.setLong(7, model.blockNumber.longValue());
        statement.setLong(8, model.gasUsed.longValue());
        statement.setLong(9, model.gasPrice.longValue());
        statement.setInt(10, model.blockchainId);
        int result = statement.executeUpdate();
        if(result > 0) {
            System.out.println("new offerTask event : " + model);
        }
        statement.close();
    }


    @Override
    public String toString() {
        return "OfferTask{" +
                "transactionHash='" + transactionHash + '\'' +
                ", contractAddress='" + contractAddress + '\'' +
                ", dataSetId='" + dataSetId + '\'' +
                ", dcNodeId='" + dcNodeId + '\'' +
                ", offerId='" + offerId + '\'' +
                ", task='" + task + '\'' +
                ", blockNumber=" + blockNumber +
                ", gasUsed=" + gasUsed +
                ", gasPrice=" + gasPrice +
                ", blockchainId=" + blockchainId +
                '}';
    }
}
