import contracts.Approval;
import contracts.Holding;
import contracts.Litigation;
import contracts.Profile;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static util.Database.createConnection;


public class UpdateDatabase {
    public static void updateDatabase() {
        Connection connection = null;
        try {
            connection = createConnection();
            Statement statement = connection.createStatement();
            createTableRPC(statement);
            createTableBlockchain(statement);
            createTableContracts(statement);
            createTableOfferCreated(statement);
            createTableOfferFinalized(statement);
            createTableOfferTask(statement);
            createTablePaidOut(statement);
            createTableOwnershipTransferred(statement);
            createTableIdentityCreated(statement);
            createTableProfileCreated(statement);
            createTableIdentityTransferred(statement);
            createTableTokensDeposited(statement);
            createTableTokensReleased(statement);
            createTableTokensWithdrawn(statement);
            createTableTokensTransferred(statement);
            createTableTokensReserved(statement);
            createTableLitigationInitiated(statement);
            createTableLitigationAnswered(statement);
            createTableLitigationCompleted(statement);
            createTableLitigationTimedOut(statement);
            createTableReplacementStarted(statement);
            createTableNodeApproved(statement);
            createTableNodeRemoved(statement);
            createTableIdentity(statement);
            createTableOffer(statement);
            createTableOfferHolders(statement);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error closing database connection.");
                e.printStackTrace();
            }
        }
    }

    private static void createTableRPC(Statement statement) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS RPC (" +
                "BlockchainId      TINYINT UNSIGNED NOT NULL," +
                "Event    VARCHAR(20)  NOT NULL," +
                "Rpc     VARCHAR(255) NOT NULL PRIMARY KEY)";
        statement.execute(sql);
    }

    private static void createTableBlockchain(Statement statement) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS Blockchain (" +
                "Id      TINYINT UNSIGNED NOT NULL PRIMARY KEY," +
                "Name    VARCHAR(20)  NOT NULL," +
                "Rpc     VARCHAR(255) NOT NULL)";
        statement.execute(sql);
    }

    private static void createTableContracts(Statement statement) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS Contracts (" +
                "Name            VARCHAR(20) NOT NULL," +
                "Address         VARCHAR(42) NOT NULL PRIMARY KEY," +
                "BlockchainId    TINYINT UNSIGNED NOT NULL," +
                "CreationBlock   BIGINT NOT NULL," +
                "ExpirationBlock BIGINT NOT NULL DEFAULT -1," +
                "CONSTRAINT FK_contracts_blockchains FOREIGN KEY (BlockchainId) REFERENCES Blockchain (Id) ON UPDATE NO ACTION ON DELETE NO ACTION)";
        statement.execute(sql);
    }

    private static void createTableOfferCreated(Statement statement) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS " + Holding.OFFERCREATED_EVENT.getName() + " (" +
                "Timestamp                   DATETIME NOT NULL," +
                "LitigationIntervalInMinutes BIGINT UNSIGNED NOT NULL," +
                "DCNodeId                    CHAR(40) NOT NULL," +
                "DataSetId                   CHAR(66) NOT NULL," +
                "HoldingTimeInMinutes        BIGINT UNSIGNED NOT NULL," +
                "TokenAmountPerHolder        DECIMAL(27,18) UNSIGNED NOT NULL," +
                "TransactionIndex            BIGINT UNSIGNED NOT NULL," +
                "TransactionHash             CHAR(66) NOT NULL," +
                "BlockNumber                 BIGINT UNSIGNED NOT NULL," +
                "OfferId                     CHAR(66) NOT NULL PRIMARY KEY," +
                "DataSetSizeInBytes          BIGINT UNSIGNED NOT NULL," +
                "ContractAddress             CHAR(42) NOT NULL," +
                "GasUsed                     BIGINT UNSIGNED NOT NULL," +
                "GasPrice                    BIGINT UNSIGNED NOT NULL," +
                "Data                        VARCHAR(500) NOT NULL," +
                "BlockchainId                TINYINT UNSIGNED NOT NULL)";
        statement.execute(sql);
    }

    private static void createTableOfferFinalized(Statement statement) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS " + Holding.OFFERFINALIZED_EVENT.getName() + " (" +
                "TransactionHash             CHAR(66) NOT NULL," +
                "BlockNumber                 BIGINT UNSIGNED NOT NULL," +
                "Timestamp                   DATETIME NOT NULL," +
                "OfferId                     CHAR(66) NOT NULL PRIMARY KEY," +
                "Holder1                     CHAR(42) NOT NULL," +
                "Holder2                     CHAR(42) NOT NULL," +
                "Holder3                     CHAR(42) NOT NULL," +
                "ContractAddress             CHAR(42) NOT NULL," +
                "GasUsed                     BIGINT UNSIGNED NOT NULL," +
                "GasPrice                    BIGINT UNSIGNED NOT NULL," +
                "Data                        VARCHAR(500) NOT NULL," +
                "BlockchainId                TINYINT UNSIGNED NOT NULL)";
        statement.execute(sql);
    }

    private static void createTableOfferTask(Statement statement) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS " + Holding.OFFERTASK_EVENT.getName() + " (" +
                "TransactionHash             CHAR(66) NOT NULL," +
                "ContractAddress             CHAR(42) NOT NULL," +
                "DataSetId                   CHAR(66) NOT NULL," +
                "DCNodeId                    CHAR(40) NOT NULL," +
                "OfferId                     CHAR(66) NOT NULL PRIMARY KEY," +
                "Task                        CHAR(64) NOT NULL," +
                "BlockNumber                 BIGINT UNSIGNED NOT NULL," +
                "GasUsed                     BIGINT UNSIGNED NOT NULL," +
                "GasPrice                    BIGINT UNSIGNED NOT NULL," +
                "BlockchainId                TINYINT UNSIGNED NOT NULL)";
        statement.execute(sql);
    }

    private static void createTablePaidOut(Statement statement) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS " + Holding.PAIDOUT_EVENT.getName() + " (" +
                "OfferId                     CHAR(66) NOT NULL," +
                "Holder                      CHAR(42) NOT NULL," +
                "Amount                      DECIMAL(27,18) UNSIGNED NOT NULL," +
                "Timestamp                   DATETIME NOT NULL," +
                "TransactionHash             CHAR(66) NOT NULL," +
                "ContractAddress             CHAR(42) NOT NULL," +
                "BlockNumber                 BIGINT UNSIGNED NOT NULL," +
                "GasUsed                     BIGINT UNSIGNED NOT NULL," +
                "GasPrice                    BIGINT UNSIGNED NOT NULL," +
                "Data                        VARCHAR(500) NOT NULL," +
                "BlockchainId                TINYINT UNSIGNED NOT NULL," +
                "PRIMARY KEY(OfferId,TransactionHash))";
        statement.execute(sql);
    }

    private static void createTableOwnershipTransferred(Statement statement) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS " + Holding.OWNERSHIPTRANSFERRED_EVENT.getName() + " (" +
                "TransactionHash             CHAR(66) NOT NULL," +
                "PreviousOwner               CHAR(42) NOT NULL," +
                "NewOwner                    CHAR(42) NOT NULL," +
                "ContractAddress             CHAR(42) NOT NULL," +
                "BlockNumber                 BIGINT UNSIGNED NOT NULL," +
                "GasUsed                     BIGINT UNSIGNED NOT NULL," +
                "GasPrice                    BIGINT UNSIGNED NOT NULL," +
                "BlockchainId                TINYINT UNSIGNED NOT NULL," +
                "PRIMARY KEY(TransactionHash, BlockchainId))";
        statement.execute(sql);
    }

    private static void createTableIdentityCreated(Statement statement) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS " + Profile.IDENTITYCREATED_EVENT.getName() + " (" +
                "TransactionHash             CHAR(66) NOT NULL," +
                "Profile                     CHAR(42) NOT NULL," +
                "NewIdentity                 CHAR(42) NOT NULL," +
                "ContractAddress             CHAR(42) NOT NULL," +
                "BlockNumber                 BIGINT UNSIGNED NOT NULL," +
                "GasUsed                     BIGINT UNSIGNED NOT NULL," +
                "GasPrice                    BIGINT UNSIGNED NOT NULL," +
                "BlockchainId                TINYINT UNSIGNED NOT NULL," +
                "PRIMARY KEY(TransactionHash, BlockchainId))";
        statement.execute(sql);
    }

    private static void createTableProfileCreated(Statement statement) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS " + Profile.PROFILECREATED_EVENT.getName() + " (" +
                "TransactionHash             CHAR(66) NOT NULL," +
                "ContractAddress             CHAR(42) NOT NULL," +
                "Profile                     CHAR(42) NOT NULL," +
                "BlockNumber                 BIGINT UNSIGNED NOT NULL," +
                "InitialBalance              DECIMAL(27,18) UNSIGNED NOT NULL," +
                "ManagementWallet            CHAR(42) NOT NULL," +
                "NodeId                      CHAR(40) NOT NULL," +
                "GasUsed                     BIGINT UNSIGNED NOT NULL," +
                "GasPrice                    BIGINT UNSIGNED NOT NULL," +
                "BlockchainId                TINYINT UNSIGNED NOT NULL," +
                "PRIMARY KEY(TransactionHash, BlockchainId))";
        statement.execute(sql);
    }

    private static void createTableIdentityTransferred(Statement statement) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS " + Profile.IDENTITYTRANSFERRED_EVENT.getName() + " (" +
                "TransactionHash             CHAR(66) NOT NULL," +
                "NodeId                      CHAR(40) NOT NULL," +
                "OldIdentity                 CHAR(42) NOT NULL," +
                "NewIdentity                 CHAR(42) NOT NULL," +
                "ContractAddress             CHAR(42) NOT NULL," +
                "BlockNumber                 BIGINT UNSIGNED NOT NULL," +
                "ManagementWallet            CHAR(42) NOT NULL," +
                "GasUsed                     BIGINT UNSIGNED NOT NULL," +
                "GasPrice                    BIGINT UNSIGNED NOT NULL," +
                "BlockchainId                TINYINT UNSIGNED NOT NULL," +
                "PRIMARY KEY(TransactionHash, BlockchainId))";
        statement.execute(sql);
    }

    private static void createTableTokensDeposited(Statement statement) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS " + Profile.TOKENSDEPOSITED_EVENT.getName() + " (" +
                "TransactionHash             CHAR(66) NOT NULL," +
                "ContractAddress             CHAR(42) NOT NULL," +
                "BlockNumber                 BIGINT UNSIGNED NOT NULL," +
                "Profile                     CHAR(42) NOT NULL," +
                "AmountDeposited             DECIMAL(27,18) UNSIGNED NOT NULL," +
                "NewBalance                  DECIMAL(27,18) UNSIGNED NOT NULL," +
                "GasUsed                     BIGINT UNSIGNED NOT NULL," +
                "GasPrice                    BIGINT UNSIGNED NOT NULL," +
                "BlockchainId                TINYINT UNSIGNED NOT NULL," +
                "PRIMARY KEY(TransactionHash, BlockchainId))";
        statement.execute(sql);
    }

    private static void createTableTokensReleased(Statement statement) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS " + Profile.TOKENSRELEASED_EVENT.getName() + " (" +
                "TransactionHash             CHAR(66) NOT NULL," +
                "ContractAddress             CHAR(42) NOT NULL," +
                "BlockNumber                 BIGINT UNSIGNED NOT NULL," +
                "Profile                     CHAR(42) NOT NULL," +
                "Amount                      DECIMAL(27,18) UNSIGNED NOT NULL," +
                "GasUsed                     BIGINT UNSIGNED NOT NULL," +
                "GasPrice                    BIGINT UNSIGNED NOT NULL," +
                "BlockchainId                TINYINT UNSIGNED NOT NULL," +
                "PRIMARY KEY(TransactionHash, BlockchainId))";
        statement.execute(sql);
    }

    private static void createTableTokensWithdrawn(Statement statement) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS " + Profile.TOKENSWITHDRAWN_EVENT.getName() + " (" +
                "TransactionHash             CHAR(66) NOT NULL," +
                "ContractAddress             CHAR(42) NOT NULL," +
                "BlockNumber                 BIGINT UNSIGNED NOT NULL," +
                "Profile                     CHAR(42) NOT NULL," +
                "AmountWithdrawn             DECIMAL(27,18) UNSIGNED NOT NULL," +
                "NewBalance                  DECIMAL(27,18) UNSIGNED NOT NULL," +
                "GasUsed                     BIGINT UNSIGNED NOT NULL," +
                "GasPrice                    BIGINT UNSIGNED NOT NULL," +
                "BlockchainId                TINYINT UNSIGNED NOT NULL," +
                "PRIMARY KEY(TransactionHash, BlockchainId))";
        statement.execute(sql);
    }

    private static void createTableTokensTransferred(Statement statement) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS " + Profile.TOKENSTRANSFERRED_EVENT.getName() + " (" +
                "TransactionHash             CHAR(66) NOT NULL," +
                "ContractAddress             CHAR(42) NOT NULL," +
                "BlockNumber                 BIGINT UNSIGNED NOT NULL," +
                "Sender                      CHAR(42) NOT NULL," +
                "Receiver                    CHAR(42) NOT NULL," +
                "Amount                      DECIMAL(27,18) UNSIGNED NOT NULL," +
                "GasUsed                     BIGINT UNSIGNED NOT NULL," +
                "GasPrice                    BIGINT UNSIGNED NOT NULL," +
                "BlockchainId                TINYINT UNSIGNED NOT NULL," +
                "PRIMARY KEY(TransactionHash, BlockchainId))";
        statement.execute(sql);
    }

    private static void createTableTokensReserved(Statement statement) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS " + Profile.TOKENSRESERVED_EVENT.getName() + " (" +
                "TransactionHash             CHAR(66) NOT NULL," +
                "ContractAddress             CHAR(42) NOT NULL," +
                "BlockNumber                 BIGINT UNSIGNED NOT NULL," +
                "Profile                     CHAR(42) NOT NULL," +
                "AmountReserved              DECIMAL(27,18) UNSIGNED NOT NULL," +
                "GasUsed                     BIGINT UNSIGNED NOT NULL," +
                "GasPrice                    BIGINT UNSIGNED NOT NULL," +
                "BlockchainId                TINYINT UNSIGNED NOT NULL," +
                "PRIMARY KEY(TransactionHash, BlockchainId))";
        statement.execute(sql);
    }

    private static void createTableLitigationInitiated(Statement statement) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS " + Litigation.LITIGATIONINITIATED_EVENT.getName() + " (" +
                "TransactionHash             CHAR(66) NOT NULL," +
                "BlockNumber                 BIGINT UNSIGNED NOT NULL," +
                "Timestamp                   DATETIME NOT NULL," +
                "OfferId                     CHAR(66) NOT NULL," +
                "HolderIdentity              CHAR(42) NOT NULL," +
                "RequestedObjectIndex        BIGINT UNSIGNED NOT NULL," +
                "requestedBlockIndex         BIGINT UNSIGNED NOT NULL," +
                "GasUsed                     BIGINT UNSIGNED NOT NULL," +
                "GasPrice                    BIGINT UNSIGNED NOT NULL," +
                "BlockchainId                TINYINT UNSIGNED NOT NULL," +
                "PRIMARY KEY(TransactionHash, BlockchainId))";
        statement.execute(sql);
    }

    private static void createTableLitigationAnswered(Statement statement) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS " + Litigation.LITIGATIONANSWERED_EVENT.getName() + " (" +
                "TransactionHash             CHAR(66) NOT NULL," +
                "BlockNumber                 BIGINT UNSIGNED NOT NULL," +
                "Timestamp                   DATETIME NOT NULL," +
                "OfferId                     CHAR(66) NOT NULL," +
                "HolderIdentity              CHAR(42) NOT NULL," +
                "GasUsed                     BIGINT UNSIGNED NOT NULL," +
                "GasPrice                    BIGINT UNSIGNED NOT NULL," +
                "BlockchainId                TINYINT UNSIGNED NOT NULL," +
                "PRIMARY KEY(TransactionHash, BlockchainId))";
        statement.execute(sql);
    }

    private static void createTableLitigationCompleted(Statement statement) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS " + Litigation.LITIGATIONCOMPLETED_EVENT.getName() + " (" +
                "TransactionHash             CHAR(66) NOT NULL," +
                "BlockNumber                 BIGINT UNSIGNED NOT NULL," +
                "Timestamp                   DATETIME NOT NULL," +
                "OfferId                     CHAR(66) NOT NULL," +
                "HolderIdentity              CHAR(42) NOT NULL," +
                "DHWasPenalized              BOOLEAN NOT NULL," +
                "GasUsed                     BIGINT UNSIGNED NOT NULL," +
                "GasPrice                    BIGINT UNSIGNED NOT NULL," +
                "BlockchainId                TINYINT UNSIGNED NOT NULL," +
                "PRIMARY KEY(TransactionHash, BlockchainId))";
        statement.execute(sql);
    }

    private static void createTableLitigationTimedOut(Statement statement) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS " + Litigation.LITIGATIONTIMEDOUT_EVENT.getName() + " (" +
                "TransactionHash             CHAR(66) NOT NULL," +
                "BlockNumber                 BIGINT UNSIGNED NOT NULL," +
                "Timestamp                   DATETIME NOT NULL," +
                "OfferId                     CHAR(66) NOT NULL," +
                "HolderIdentity              CHAR(42) NOT NULL," +
                "GasUsed                     BIGINT UNSIGNED NOT NULL," +
                "GasPrice                    BIGINT UNSIGNED NOT NULL," +
                "BlockchainId                TINYINT UNSIGNED NOT NULL," +
                "PRIMARY KEY(TransactionHash, BlockchainId))";
        statement.execute(sql);
    }

    private static void createTableReplacementStarted(Statement statement) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS " + Litigation.REPLACEMENTSTARTED_EVENT.getName() + " (" +
                "TransactionHash             CHAR(66) NOT NULL," +
                "BlockNumber                 BIGINT UNSIGNED NOT NULL," +
                "Timestamp                   DATETIME NOT NULL," +
                "OfferId                     CHAR(66) NOT NULL," +
                "HolderIdentity              CHAR(42) NOT NULL," +
                "ChallengerIdentity          CHAR(42) NOT NULL," +
                "LitigationRootHash          CHAR(66) NOT NULL," +
                "GasUsed                     BIGINT UNSIGNED NOT NULL," +
                "GasPrice                    BIGINT UNSIGNED NOT NULL," +
                "BlockchainId                TINYINT UNSIGNED NOT NULL," +
                "PRIMARY KEY(TransactionHash, BlockchainId))";
        statement.execute(sql);
    }

    private static void createTableNodeApproved(Statement statement) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS " + Approval.NODEAPPROVED_EVENT.getName() + " (" +
                "TransactionHash             CHAR(66) NOT NULL," +
                "ContractAddress             CHAR(42) NOT NULL," +
                "NodeId                      CHAR(40) NOT NULL," +
                "Timestamp                   DATETIME NOT NULL," +
                "BlockNumber                 BIGINT UNSIGNED NOT NULL," +
                "PRIMARY KEY(TransactionHash, NodeId))";
        statement.execute(sql);
    }

    private static void createTableNodeRemoved(Statement statement) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS " + Approval.NODEREMOVED_EVENT.getName() + " (" +
                "TransactionHash             CHAR(66) NOT NULL," +
                "ContractAddress             CHAR(42) NOT NULL," +
                "NodeId                      CHAR(40) NOT NULL," +
                "Timestamp                   DATETIME NOT NULL," +
                "BlockNumber                 BIGINT UNSIGNED NOT NULL," +
                "PRIMARY KEY(TransactionHash, NodeId))";
        statement.execute(sql);
    }

    private static void createTableIdentity(Statement statement) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS Identity (" +
                "Identity                    CHAR(42) NOT NULL," +
                "TransactionHash             CHAR(66) NOT NULL," +
                "Stake                       DECIMAL(27,18) UNSIGNED NOT NULL DEFAULT 0," +
                "StakeReserved               DECIMAL(27,18) UNSIGNED NOT NULL DEFAULT 0," +
                "PaidOut                     DECIMAL(27,18) UNSIGNED NOT NULL DEFAULT 0," +
                "Reputation                  BIGINT UNSIGNED NOT NULL DEFAULT 0," +
                "WithdrawalPending           BOOLEAN DEFAULT false," +
                "WithdrawalTimestamp         BIGINT NOT NULL DEFAULT 0," +
                "WithdrawalAmount            DECIMAL(27,18) UNSIGNED NOT NULL DEFAULT 0," +
                "NodeId                      CHAR(40) DEFAULT 0," +
                "BlockchainId                TINYINT UNSIGNED NOT NULL," +
                "PRIMARY KEY(Identity))";
        statement.execute(sql);
    }

    private static void createTableOffer(Statement statement) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS Offer (" +
                "CreatedTimestamp            DATETIME NOT NULL," +
                "FinalizedTimestamp          DATETIME DEFAULT NULL," +
                "DCNodeId                    CHAR(40) NOT NULL," +
                "HoldingTimeInMinutes        BIGINT UNSIGNED NOT NULL," +
                "TokenAmountPerHolder        DECIMAL(27,18) UNSIGNED NOT NULL," +
                "DataSetId                   CHAR(66) NOT NULL," +
                "LitigationIntervalInMinutes BIGINT UNSIGNED NOT NULL," +
                "CreatedTransactionHash      CHAR(66) NOT NULL," +
                "FinalizedTransactionHash    CHAR(66) DEFAULT NULL," +
                "OfferId                     CHAR(66) NOT NULL PRIMARY KEY," +
                "IsFinalized                 BOOLEAN NOT NULL," +
                "DataSetSizeInBytes          BIGINT UNSIGNED NOT NULL," +
                "CreatedBlockNumber          BIGINT UNSIGNED NOT NULL," +
                "FinalizedBlockNumber        BIGINT UNSIGNED DEFAULT NULL," +
                "BlockchainId                TINYINT UNSIGNED NOT NULL," +
                "KEY Offer_DCNodeId (DCNodeId) USING BTREE," +
                "KEY ix_Offer_finalised (IsFinalized,FinalizedTimestamp) USING BTREE," +
                "CONSTRAINT FK_Offer_Blockchain FOREIGN KEY (BlockchainId) REFERENCES Blockchain (Id))";
        statement.execute(sql);
    }

    private static void createTableOfferHolders(Statement statement) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS OfferHolders (" +
                "OfferId                     CHAR(66) NOT NULL," +
                "Holder                      CHAR(42) NOT NULL," +
                "BlockchainId                TINYINT UNSIGNED NOT NULL," +
                "PRIMARY KEY (OfferId,Holder,BlockchainId)," +
                "KEY FK_OfferHolders_Offer (OfferID)," +
                "KEY Holder (Holder)," +
                "KEY FK_OfferHolders_Blockchain (BlockchainID)," +
                "CONSTRAINT FK_OfferHolders_Blockchain FOREIGN KEY (BlockchainId) REFERENCES Blockchain (Id)," +
                "CONSTRAINT FK_OfferHolders_Offer FOREIGN KEY (OfferId) REFERENCES OfferCreated (OfferId) ON UPDATE NO ACTION)";
        statement.execute(sql);
    }
}
