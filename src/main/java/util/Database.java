package util;

import contracts.Approval;
import contracts.Holding;
import contracts.Litigation;
import contracts.Profile;
import io.github.cdimascio.dotenv.Dotenv;

import java.math.BigInteger;
import java.sql.*;
import java.util.Arrays;
import java.util.List;

public class Database {
    public static Connection createConnection() throws SQLException {
        Dotenv dotenv = Dotenv.load();
        return DriverManager.getConnection(dotenv.get("DB_URL"), dotenv.get("DB_USER"), dotenv.get("DB_PASSWORD"));
    }

    public static ResultSet getBlockchainIds() throws SQLException {
        Connection connection = createConnection();
        Statement statement = connection.createStatement();
        return statement.executeQuery("SELECT DISTINCT Id FROM Blockchain");
    }

    public static String getRpc(String tableName, int chainId, Connection connection) throws SQLException {
        String sql = "SELECT Rpc " +
                "FROM rpc " +
                "WHERE BlockchainId = ? AND Event = ? ";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, chainId);
        statement.setString(2, tableName);
        ResultSet resultSet = statement.executeQuery();
        return resultSet.next() ? resultSet.getString("Rpc") : null;
    }

    public static ResultSet contracts(String contractName, int chainId, Connection connection, BigInteger lastSyncBlock) throws SQLException {
        String sql = "SELECT Address, CreationBlock, ExpirationBlock " +
                "FROM contracts " +
                "WHERE name = ? AND BlockchainId = ? AND (ExpirationBlock > ? OR ExpirationBlock = -1) " +
                "ORDER BY CreationBlock";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, contractName);
        statement.setInt(2, chainId);
        statement.setLong(3, lastSyncBlock.longValue());
        return statement.executeQuery();
    }

    public static BigInteger getLastSyncBlock(int blockchainId) throws SQLException {
        Connection connection = createConnection();
        List<String> tableNames = Arrays.asList(Approval.NODEAPPROVED_EVENT.getName(),
                Approval.NODEREMOVED_EVENT.getName(),
                Holding.OFFERCREATED_EVENT.getName(),
                Holding.OFFERFINALIZED_EVENT.getName(),
                Holding.OFFERTASK_EVENT.getName(),
                Litigation.LITIGATIONANSWERED_EVENT.getName(),
                Litigation.LITIGATIONCOMPLETED_EVENT.getName(),
                Litigation.LITIGATIONTIMEDOUT_EVENT.getName(),
                Litigation.LITIGATIONINITIATED_EVENT.getName(),
                Litigation.REPLACEMENTSTARTED_EVENT.getName(),
                Profile.IDENTITYCREATED_EVENT.getName(),
                Profile.PROFILECREATED_EVENT.getName(),
                Profile.IDENTITYTRANSFERRED_EVENT.getName(),
                Profile.TOKENSDEPOSITED_EVENT.getName(),
                Profile.TOKENSRELEASED_EVENT.getName(),
                Profile.TOKENSRESERVED_EVENT.getName(),
                Profile.TOKENSWITHDRAWN_EVENT.getName(),
                Profile.TOKENSTRANSFERRED_EVENT.getName());

        BigInteger maxBlock = new BigInteger("0");
        BigInteger lastBlock;
        PreparedStatement statement = null;
        for (String tableName : tableNames) {
            String sql = "SELECT MAX(BlockNumber) AS 'BlockNumber' FROM  " + tableName + " WHERE BlockchainId = '" + blockchainId + "'";
            statement = connection.prepareStatement(sql);
            try {
                ResultSet resultSet = statement.executeQuery();
                resultSet.next();
                lastBlock = new BigInteger(resultSet.getString("BlockNumber"));
            } catch (Exception e) {
                lastBlock = new BigInteger("0");
            }
            if (lastBlock.compareTo(maxBlock) > 0) {
                maxBlock = lastBlock;
            }
        }
        statement.close();
        return maxBlock;
    }
}

