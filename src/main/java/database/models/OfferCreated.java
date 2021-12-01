package database.models;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.*;

public class OfferCreated {
    private final Timestamp timestamp;
    private final BigInteger litigationIntervalInMinutes;
    private final String dcNodeId;
    private final String dataSetId;
    private final BigInteger holdingTimeInMinutes;
    private final BigDecimal tokenAmountPerHolder;
    private final BigInteger transactionIndex;
    private final String transactionHash;
    private final BigInteger blockNumber;
    private final String offerId;
    private final BigInteger dataSetSizeInBytes;
    private final String contractAddress;
    private final BigInteger gasUsed;
    private final BigInteger gasPrice;
    private final String data;
    private final int blockchainId;

    public OfferCreated
            (Timestamp timestamp,
             BigInteger litigationIntervalInMinutes,
             String dcNodeId, String dataSetId,
             BigInteger holdingTimeInMinutes,
             BigDecimal tokenAmountPerHolder,
             BigInteger transactionIndex,
             String transactionHash, BigInteger blockNumber,
             String offerId, BigInteger dataSetSizeInBytes,
             String contractAddress, BigInteger gasUsed,
             BigInteger gasPrice, String data,
             int blockchainId) {
        this.timestamp = timestamp;
        this.litigationIntervalInMinutes = litigationIntervalInMinutes;
        this.dcNodeId = dcNodeId;
        this.dataSetId = dataSetId;
        this.holdingTimeInMinutes = holdingTimeInMinutes;
        this.tokenAmountPerHolder = tokenAmountPerHolder;
        this.transactionIndex = transactionIndex;
        this.transactionHash = transactionHash;
        this.blockNumber = blockNumber;
        this.offerId = offerId;
        this.dataSetSizeInBytes = dataSetSizeInBytes;
        this.contractAddress = contractAddress;
        this.gasUsed = gasUsed;
        this.gasPrice = gasPrice;
        this.data = data;
        this.blockchainId = blockchainId;
    }

    public static void insertIfNotExist(Connection connection, OfferCreated model) throws SQLException {
        String sql = "INSERT IGNORE INTO OfferCreated VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setTimestamp(1, model.timestamp);
        statement.setLong(2, model.litigationIntervalInMinutes.longValue());
        statement.setString(3, model.dcNodeId);
        statement.setString(4, model.dataSetId);
        statement.setLong(5, model.holdingTimeInMinutes.longValue());
        statement.setBigDecimal(6, model.tokenAmountPerHolder);
        statement.setLong(7, model.transactionIndex.longValue());
        statement.setString(8, model.transactionHash);
        statement.setLong(9, model.blockNumber.longValue());
        statement.setString(10, model.offerId);
        statement.setLong(11, model.dataSetSizeInBytes.longValue());
        statement.setString(12, model.contractAddress);
        statement.setLong(13, model.gasUsed.longValue());
        statement.setLong(14, model.gasPrice.longValue());
        statement.setString(15, model.data);
        statement.setInt(16, model.blockchainId);
        int result = statement.executeUpdate();
        if (result > 0) {
            System.out.println("new createdOffer event : " + model);
        }
        statement.close();
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public BigInteger getLitigationIntervalInMinutes() {
        return litigationIntervalInMinutes;
    }

    public String getDcNodeId() {
        return dcNodeId;
    }

    public String getDataSetId() {
        return dataSetId;
    }

    public BigInteger getHoldingTimeInMinutes() {
        return holdingTimeInMinutes;
    }

    public BigDecimal getTokenAmountPerHolder() {
        return tokenAmountPerHolder;
    }

    public String getTransactionHash() {
        return transactionHash;
    }

    public BigInteger getBlockNumber() {
        return blockNumber;
    }

    public String getOfferId() {
        return offerId;
    }

    public BigInteger getDataSetSizeInBytes() {
        return dataSetSizeInBytes;
    }

    public String getContractAddress() {
        return contractAddress;
    }

    public BigInteger getGasUsed() {
        return gasUsed;
    }

    public BigInteger getGasPrice() {
        return gasPrice;
    }

    public String getData() {
        return data;
    }

    public int getBlockchainId() {
        return blockchainId;
    }


    @Override
    public String toString() {
        return "CreatedOffer{" +
                "timestamp=" + timestamp +
                ", litigationIntervalInMinutes=" + litigationIntervalInMinutes +
                ", dcNodeId='" + dcNodeId + '\'' +
                ", dataSetId='" + dataSetId + '\'' +
                ", holdingTimeInMinutes=" + holdingTimeInMinutes +
                ", tokenAmountPerHolder=" + tokenAmountPerHolder +
                ", transactionIndex=" + transactionIndex +
                ", transactionHash='" + transactionHash + '\'' +
                ", blockNumber=" + blockNumber +
                ", offerId='" + offerId + '\'' +
                ", dataSetSizeInBytes=" + dataSetSizeInBytes +
                ", contractAddress='" + contractAddress + '\'' +
                ", gasUsed=" + gasUsed +
                ", gasPrice=" + gasPrice +
                ", data='" + data + '\'' +
                ", blockchainId=" + blockchainId +
                '}';
    }
}
