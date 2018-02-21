package ru.dm_dev.moneykeeper.app;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

import ru.dm_dev.moneykeeper.helpers.DatabaseUpgradeHelper;
import ru.dm_dev.moneykeeper.models.Currency;
import ru.dm_dev.moneykeeper.models.CurrencyDao;
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
        Log.d(LOG_TAG, "Init the WalletType entities ...");
        WalletType walletType;
        if (!getWalletTypeByName("VISA")) {
            walletType = new WalletType("VISA");
            daoSession.getWalletTypeDao().insert(walletType);
        }
        if (!getWalletTypeByName("MasterCard")) {
            walletType = new WalletType("MasterCard");
            daoSession.getWalletTypeDao().insert(walletType);
        }
        if (!getWalletTypeByName("МИР")) {
            walletType = new WalletType("МИР");
            daoSession.getWalletTypeDao().insert(walletType);
        }
        if (!getWalletTypeByName("WebMoney")) {
            walletType = new WalletType("WebMoney");
            daoSession.getWalletTypeDao().insert(walletType);
        }
        if (!getWalletTypeByName("ЯндексДеньги")) {
            walletType = new WalletType("ЯндексДеньги");
            daoSession.getWalletTypeDao().insert(walletType);
        }
        if (!getWalletTypeByName("Прочие")) {
            walletType = new WalletType("Прочие");
            daoSession.getWalletTypeDao().insert(walletType);
        }

        Currency currency;
        if (!getCurrencyByCode("RUR")) {
            currency = new Currency("RUR", 643, "Российский рубль", "руб.");
            daoSession.getCurrencyDao().insert(currency);
        }
        if (!getCurrencyByCode("UAH")) {
            currency = new Currency("UAH", 980, "Гривна", "грн.");
            daoSession.getCurrencyDao().insert(currency);
        }
        if (!getCurrencyByCode("USD")) {
            currency = new Currency("USD", 840, "Доллар США", "$");
            daoSession.getCurrencyDao().insert(currency);
        }
        if (!getCurrencyByCode("EUR")) {
            currency = new Currency("EUR", 978, "Евро", "Евро");
            daoSession.getCurrencyDao().insert(currency);
        }
        Log.d(LOG_TAG, "WalletTypes initialized.");
    }

    private boolean getWalletTypeByName(String name) {
        QueryBuilder<WalletType> builder = daoSession.getWalletTypeDao().queryBuilder().where(WalletTypeDao.Properties.Name.eq(name));
        return builder.limit(1).unique() != null;
    }

    private boolean getCurrencyByCode(String code) {
        QueryBuilder<Currency> builder = daoSession.getCurrencyDao().queryBuilder().where(CurrencyDao.Properties.CodeStr.eq(code));
        return builder.limit(1).unique() != null;
    }
}
