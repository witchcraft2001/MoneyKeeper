package ru.dm_dev.moneykeeper.app;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

import ru.dm_dev.moneykeeper.helpers.DatabaseUpgradeHelper;
import ru.dm_dev.moneykeeper.models.DaoMaster;
import ru.dm_dev.moneykeeper.models.DaoSession;
import ru.dm_dev.moneykeeper.models.WalletType;
import ru.dm_dev.moneykeeper.models.WalletTypeDao;

public class MoneyKeeperApp extends Application {
    private static final String LOG_TAG = "MoneyKeeperApp";

    /**
     * A flag to show how easily you can switch from standard SQLite to the encrypted SQLCipher.
     */
    public static final boolean ENCRYPTED = false;

    private DaoSession daoSession;

    public static MoneyKeeperApp get(Context context) {
        return (MoneyKeeperApp) context.getApplicationContext();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        DatabaseUpgradeHelper helper = new DatabaseUpgradeHelper(this, ENCRYPTED ? "gamegpu-db-encrypted" : "moneykeeper-db");
        Database db = ENCRYPTED ? helper.getEncryptedWritableDb("super-secret-gamegpu-db") : helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
        checkWalletTypes();
    }

    private void checkWalletTypes() {
        WalletTypeDao wDao = daoSession.getWalletTypeDao();
        Log.d(LOG_TAG, "Init the WalletType entities ...");
        WalletType walletType;
        if (!getWalletTypeByName("VISA")) {
            walletType = new WalletType("VISA");
            wDao.insert(walletType);
        }
        if (!getWalletTypeByName("MasterCard")) {
            walletType = new WalletType("MasterCard");
            wDao.insert(walletType);
        }
        if (!getWalletTypeByName("МИР")) {
            walletType = new WalletType("МИР");
            wDao.insert(walletType);
        }
        if (!getWalletTypeByName("WebMoney")) {
            walletType = new WalletType("WebMoney");
            wDao.insert(walletType);
        }
        if (!getWalletTypeByName("ЯндексДеньги")) {
            walletType = new WalletType("ЯндексДеньги");
            wDao.insert(walletType);
        }
        if (!getWalletTypeByName("Прочие")) {
            walletType = new WalletType("Прочие");
            wDao.insert(walletType);
        }
        Log.d(LOG_TAG, "WalletTypes initialized.");
    }

    private boolean getWalletTypeByName(String name) {
        WalletTypeDao wDao = daoSession.getWalletTypeDao();
        QueryBuilder<WalletType> builder = daoSession.getWalletTypeDao().queryBuilder().where(WalletTypeDao.Properties.Name.eq(name));
        return builder.limit(1).unique() != null;

    }
}
