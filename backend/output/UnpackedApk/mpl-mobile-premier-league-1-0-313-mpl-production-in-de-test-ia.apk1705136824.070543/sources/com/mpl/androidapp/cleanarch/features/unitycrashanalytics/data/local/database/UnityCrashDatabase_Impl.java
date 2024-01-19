package com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.database;

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
import com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.dao.UnityCrashDao;
import com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.dao.UnityCrashDao_Impl;
import com.mpl.androidapp.webview.vm.WebViewGameVm;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class UnityCrashDatabase_Impl extends UnityCrashDatabase {
    public volatile UnityCrashDao _unityCrashDao;

    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `unity_crash_info`");
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
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "unity_crash_info");
    }

    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        RoomOpenHelper roomOpenHelper = new RoomOpenHelper(databaseConfiguration, new Delegate(1) {
            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `unity_crash_info` (`id` INTEGER NOT NULL, `battleId` TEXT NOT NULL, `data` TEXT NOT NULL, `message` TEXT NOT NULL, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '4d8b7311e8f1da1856f9f768e3d57672')");
            }

            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `unity_crash_info`");
                if (UnityCrashDatabase_Impl.this.mCallbacks != null) {
                    int size = UnityCrashDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((Callback) UnityCrashDatabase_Impl.this.mCallbacks.get(i)).onDestructiveMigration(supportSQLiteDatabase);
                    }
                }
            }

            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (UnityCrashDatabase_Impl.this.mCallbacks != null) {
                    int size = UnityCrashDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((Callback) UnityCrashDatabase_Impl.this.mCallbacks.get(i)).onCreate(supportSQLiteDatabase);
                    }
                }
            }

            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                UnityCrashDatabase_Impl.this.mDatabase = supportSQLiteDatabase;
                UnityCrashDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                if (UnityCrashDatabase_Impl.this.mCallbacks != null) {
                    int size = UnityCrashDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((Callback) UnityCrashDatabase_Impl.this.mCallbacks.get(i)).onOpen(supportSQLiteDatabase);
                    }
                }
            }

            public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            }

            public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
                CompoundButtonCompat.dropFtsSyncTriggers(supportSQLiteDatabase);
            }

            public ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
                HashMap hashMap = new HashMap(4);
                Column column = new Column("id", "INTEGER", true, 1, null, 1);
                hashMap.put("id", column);
                Column column2 = new Column(WebViewGameVm.KEY_BATTLE_ID, "TEXT", true, 0, null, 1);
                hashMap.put(WebViewGameVm.KEY_BATTLE_ID, column2);
                Column column3 = new Column("data", "TEXT", true, 0, null, 1);
                hashMap.put("data", column3);
                Column column4 = new Column("message", "TEXT", true, 0, null, 1);
                hashMap.put("message", column4);
                TableInfo tableInfo = new TableInfo("unity_crash_info", hashMap, new HashSet(0), new HashSet(0));
                TableInfo read = TableInfo.read(supportSQLiteDatabase, "unity_crash_info");
                if (tableInfo.equals(read)) {
                    return new ValidationResult(true, null);
                }
                return new ValidationResult(false, "unity_crash_info(com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.entity.UnityCrashData).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
            }
        }, "4d8b7311e8f1da1856f9f768e3d57672", "70666fff2f5e906748cef277179d8990");
        Builder builder = Configuration.builder(databaseConfiguration.context);
        builder.name = databaseConfiguration.name;
        builder.callback(roomOpenHelper);
        return databaseConfiguration.sqliteOpenHelperFactory.create(builder.build());
    }

    public List<Migration> getAutoMigrations(Map<Class<? extends Object>, Object> map) {
        return Arrays.asList(new Migration[0]);
    }

    public Set<Class<? extends Object>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    public Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(UnityCrashDao.class, UnityCrashDao_Impl.getRequiredConverters());
        return hashMap;
    }

    public UnityCrashDao unityCrashDao() {
        UnityCrashDao unityCrashDao;
        if (this._unityCrashDao != null) {
            return this._unityCrashDao;
        }
        synchronized (this) {
            if (this._unityCrashDao == null) {
                this._unityCrashDao = new UnityCrashDao_Impl(this);
            }
            unityCrashDao = this._unityCrashDao;
        }
        return unityCrashDao;
    }
}
