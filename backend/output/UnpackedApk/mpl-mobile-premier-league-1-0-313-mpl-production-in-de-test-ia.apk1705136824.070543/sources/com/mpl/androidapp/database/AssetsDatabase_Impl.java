package com.mpl.androidapp.database;

import androidx.core.widget.CompoundButtonCompat;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase.Callback;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.Migration;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration.Builder;
import com.mpl.androidapp.database.dao.GameAssetsDao;
import com.mpl.androidapp.database.dao.GameAssetsDao_Impl;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class AssetsDatabase_Impl extends AssetsDatabase {
    public volatile GameAssetsDao _gameAssetsDao;

    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `game_resources`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query((String) "PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "game_resources");
    }

    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        RoomOpenHelper roomOpenHelper = new RoomOpenHelper(databaseConfiguration, new Delegate(3) {
            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `game_resources` (`gameId` TEXT NOT NULL, `name` TEXT NOT NULL, `downloadId` INTEGER NOT NULL, `downloadFileName` TEXT NOT NULL, `downloadFilePath` TEXT NOT NULL, `optScreenUserVisit` INTEGER NOT NULL, PRIMARY KEY(`gameId`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '3de34faa2048b980e3877ba36d0a1692')");
            }

            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `game_resources`");
                if (AssetsDatabase_Impl.this.mCallbacks != null) {
                    int size = AssetsDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((Callback) AssetsDatabase_Impl.this.mCallbacks.get(i)).onDestructiveMigration(supportSQLiteDatabase);
                    }
                }
            }

            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (AssetsDatabase_Impl.this.mCallbacks != null) {
                    int size = AssetsDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((Callback) AssetsDatabase_Impl.this.mCallbacks.get(i)).onCreate(supportSQLiteDatabase);
                    }
                }
            }

            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                AssetsDatabase_Impl.this.mDatabase = supportSQLiteDatabase;
                AssetsDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                if (AssetsDatabase_Impl.this.mCallbacks != null) {
                    int size = AssetsDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((Callback) AssetsDatabase_Impl.this.mCallbacks.get(i)).onOpen(supportSQLiteDatabase);
                    }
                }
            }

            public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            }

            public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
                CompoundButtonCompat.dropFtsSyncTriggers(supportSQLiteDatabase);
            }

            public ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
                HashMap hashMap = new HashMap(6);
                Column column = new Column("gameId", "TEXT", true, 1, null, 1);
                hashMap.put("gameId", column);
                Column column2 = new Column("name", "TEXT", true, 0, null, 1);
                hashMap.put("name", column2);
                Column column3 = new Column("downloadId", "INTEGER", true, 0, null, 1);
                hashMap.put("downloadId", column3);
                Column column4 = new Column("downloadFileName", "TEXT", true, 0, null, 1);
                hashMap.put("downloadFileName", column4);
                Column column5 = new Column("downloadFilePath", "TEXT", true, 0, null, 1);
                hashMap.put("downloadFilePath", column5);
                Column column6 = new Column("optScreenUserVisit", "INTEGER", true, 0, null, 1);
                hashMap.put("optScreenUserVisit", column6);
                TableInfo tableInfo = new TableInfo("game_resources", hashMap, new HashSet(0), new HashSet(0));
                TableInfo read = TableInfo.read(supportSQLiteDatabase, "game_resources");
                if (tableInfo.equals(read)) {
                    return new ValidationResult(true, null);
                }
                return new ValidationResult(false, "game_resources(com.mpl.androidapp.database.entity.GameAssetResource).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
            }
        }, "3de34faa2048b980e3877ba36d0a1692", "00441e3d9805e6d8941f1a958525600b");
        Builder builder = Configuration.builder(databaseConfiguration.context);
        builder.name = databaseConfiguration.name;
        builder.callback(roomOpenHelper);
        return databaseConfiguration.sqliteOpenHelperFactory.create(builder.build());
    }

    public GameAssetsDao gameAssetsDao() {
        GameAssetsDao gameAssetsDao;
        if (this._gameAssetsDao != null) {
            return this._gameAssetsDao;
        }
        synchronized (this) {
            if (this._gameAssetsDao == null) {
                this._gameAssetsDao = new GameAssetsDao_Impl(this);
            }
            gameAssetsDao = this._gameAssetsDao;
        }
        return gameAssetsDao;
    }

    public List<Migration> getAutoMigrations(Map<Class<? extends Object>, Object> map) {
        return Arrays.asList(new Migration[0]);
    }

    public Set<Class<? extends Object>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    public Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(GameAssetsDao.class, GameAssetsDao_Impl.getRequiredConverters());
        return hashMap;
    }
}
