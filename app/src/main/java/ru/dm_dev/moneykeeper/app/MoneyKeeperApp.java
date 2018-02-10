package ru.dm_dev.moneykeeper.app;

import android.app.Application;
import android.content.Context;

import org.greenrobot.greendao.database.Database;

import ru.dm_dev.moneykeeper.helpers.DatabaseUpgradeHelper;
import ru.dm_dev.moneykeeper.models.DaoMaster;
import ru.dm_dev.moneykeeper.models.DaoSession;

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
        DatabaseUpgradeHelper helper = new DatabaseUpgradeHelper(this, ENCRYPTED ? "gamegpu-db-encrypted" : "gamegpu-db");
        Database db = ENCRYPTED ? helper.getEncryptedWritableDb("super-secret-gamegpu-db") : helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }
}
