
import io.github.cdimascio.dotenv.Dotenv;
import io.reactivex.plugins.RxJavaPlugins;
import org.web3j.crypto.Credentials;
import util.Database;

import java.math.BigInteger;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static final Credentials CREDENTIALS = Credentials.create((Dotenv.load()).get("CREDENTIALS"));
    public static Map<Integer, BigInteger> lastSyncBlocks = new HashMap<>();

    public static void main(String[] args) {
        try {
            RxJavaPlugins.setErrorHandler(e -> {
            });
            UpdateDatabase.updateDatabase();
            ResultSet blockchains = Database.getBlockchainIds();
            while (blockchains.next()) {
                int chainId = blockchains.getInt("Id");
                lastSyncBlocks.put(chainId, Database.getLastSyncBlock(chainId));
                new SyncHolding(chainId).start();
                new SyncProfile(chainId).start();
                new SyncLitigation(chainId).start();
                new SyncApproval(chainId).start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
