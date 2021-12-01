package database.models;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SmartContract {
    private final String name;
    private final String address;
    private final int blockchainId;
    private final BigInteger creationBlock;
    private final BigInteger expirationBlock;

    public SmartContract
            (String name,
             String address,
             int blockchainId,
             BigInteger creationBlock,
             BigInteger expirationBlock) {
        this.name = name;
        this.address = address;
        this.blockchainId = blockchainId;
        this.creationBlock = creationBlock;
        this.expirationBlock = expirationBlock;
    }

    public static void insertIfNotExist(Connection connection, SmartContract model) throws SQLException {
        String sql = "INSERT IGNORE INTO contracts VALUES (?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, model.name);
        statement.setString(2, model.address);
        statement.setInt(3, model.blockchainId);
        statement.setLong(4, model.creationBlock.longValue());
        statement.setLong(5, model.expirationBlock.longValue());
        statement.executeUpdate();
        statement.close();
    }

    public static void updateExpirationBlock(Connection connection, SmartContract model, BigInteger currentBlock) throws SQLException {
        String sql = "UPDATE contracts SET ExpirationBlock = ? WHERE CreationBlock IN (SELECT MAX(CreationBlock) FROM contracts WHERE Name = ? AND BlockchainId = ? AND CreationBlock < ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, currentBlock.longValue());
        statement.setString(2, model.name);
        statement.setInt(3, model.blockchainId);
        statement.setLong(4, model.creationBlock.longValue());
        statement.executeUpdate();
        statement.close();
    }

    @Override
    public String toString() {
        return "SmartContract{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", blockchainId=" + blockchainId +
                ", creationBlock=" + creationBlock +
                ", expirationBlock=" + expirationBlock +
                '}';
    }
}
