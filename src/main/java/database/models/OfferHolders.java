package database.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OfferHolders {
    private final String offerId;
    private final String holder;
    private final int blockchainId;

    public OfferHolders(String offerId, String holder, int blockchainId) {
        this.offerId = offerId;
        this.holder = holder;
        this.blockchainId = blockchainId;
    }

    public static void insertIfNotExist(Connection connection, OfferHolders model) throws SQLException {
        String sql = "INSERT IGNORE INTO OfferHolders VALUES (?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, model.offerId);
        statement.setString(2, model.holder);
        statement.setInt(3, model.blockchainId);
        int result = statement.executeUpdate();
        if (result > 0) {
            System.out.println("OfferHolders table updated : " + model);
        }
        statement.close();
    }

    @Override
    public String toString() {
        return "OfferHolders{" +
                "offerId='" + offerId + '\'' +
                ", holder='" + holder + '\'' +
                ", blockchainId=" + blockchainId +
                '}';
    }
}
