package ru.dm_dev.moneykeeper.helpers;

import android.content.Context;

import org.greenrobot.greendao.database.Database;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

import ru.dm_dev.moneykeeper.models.DaoMaster;
import ru.dm_dev.moneykeeper.models.WalletTypeDao;

public class DatabaseUpgradeHelper extends DaoMaster.OpenHelper {
    public DatabaseUpgradeHelper(Context context, String name) {
        super(context, name);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        List<Migration> migrations = getMigrations();

        // Only run migrations past the old version
        for (Migration migration : migrations) {
            if (oldVersion < migration.getVersion()) {
                migration.runMigration(db);
            }
        }
    }

    private List<Migration> getMigrations() {
        List<Migration> migrations = new ArrayList<>();
        migrations.add(new MigrationV1());
//        migrations.add(new MigrationV2());

        // Sorting just to be safe, in case other people add migrations in the wrong order.
        Comparator<Migration> migrationComparator = new Comparator<Migration>() {
            @Override
            public int compare(Migration m1, Migration m2) {
                return m1.getVersion().compareTo(m2.getVersion());
            }
        };
        Collections.sort(migrations, migrationComparator);

        return migrations;
    }

    private static class MigrationV1 implements Migration {

        @Override
        public Integer getVersion() {
            return 1;
        }

        @Override
        public void runMigration(Database db) {
        }
    }

    private interface Migration {
        Integer getVersion();

        void runMigration(Database db);
    }
}
