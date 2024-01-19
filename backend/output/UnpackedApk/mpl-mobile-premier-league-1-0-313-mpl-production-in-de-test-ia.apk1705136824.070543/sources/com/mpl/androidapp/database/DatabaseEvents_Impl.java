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
import com.mpl.androidapp.database.dao.EventDao;
import com.mpl.androidapp.database.dao.EventDao_Impl;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class DatabaseEvents_Impl extends DatabaseEvents {
    public volatile EventDao _eventDao;

    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `events`");
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
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "events");
    }

    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        RoomOpenHelper roomOpenHelper = new RoomOpenHelper(databaseConfiguration, new Delegate(2) {
            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `events` (`_ID` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `key` TEXT, `value` TEXT, `timeStamp` TEXT)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '13952f9068961d24b4329dcd1e186f0f')");
            }

            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `events`");
                if (DatabaseEvents_Impl.this.mCallbacks != null) {
                    int size = DatabaseEvents_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((Callback) DatabaseEvents_Impl.this.mCallbacks.get(i)).onDestructiveMigration(supportSQLiteDatabase);
                    }
                }
            }

            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (DatabaseEvents_Impl.this.mCallbacks != null) {
                    int size = DatabaseEvents_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((Callback) DatabaseEvents_Impl.this.mCallbacks.get(i)).onCreate(supportSQLiteDatabase);
                    }
                }
            }

            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                DatabaseEvents_Impl.this.mDatabase = supportSQLiteDatabase;
                DatabaseEvents_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                if (DatabaseEvents_Impl.this.mCallbacks != null) {
                    int size = DatabaseEvents_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((Callback) DatabaseEvents_Impl.this.mCallbacks.get(i)).onOpen(supportSQLiteDatabase);
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
                Column column = new Column("_ID", "INTEGER", true, 1, null, 1);
                hashMap.put("_ID", column);
                Column column2 = new Column("key", "TEXT", false, 0, null, 1);
                hashMap.put("key", column2);
                Column column3 = new Column(HSLCriteriaBuilder.VALUE, "TEXT", false, 0, null, 1);
                hashMap.put(HSLCriteriaBuilder.VALUE, column3);
                Column column4 = new Column("timeStamp", "TEXT", false, 0, null, 1);
                hashMap.put("timeStamp", column4);
                TableInfo tableInfo = new TableInfo("events", hashMap, new HashSet(0), new HashSet(0));
                TableInfo read = TableInfo.read(supportSQLiteDatabase, "events");
                if (tableInfo.equals(read)) {
                    return new ValidationResult(true, null);
                }
                return new ValidationResult(false, "events(com.mpl.androidapp.database.entity.Events).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
            }
        }, "13952f9068961d24b4329dcd1e186f0f", "0bd7b84a0be1cfe6fa7dccb800bf9ae8");
        Builder builder = Configuration.builder(databaseConfiguration.context);
        builder.name = databaseConfiguration.name;
        builder.callback(roomOpenHelper);
        return databaseConfiguration.sqliteOpenHelperFactory.create(builder.build());
    }

    public EventDao eventDao() {
        EventDao eventDao;
        if (this._eventDao != null) {
            return this._eventDao;
        }
        synchronized (this) {
            if (this._eventDao == null) {
                this._eventDao = new EventDao_Impl(this);
            }
            eventDao = this._eventDao;
        }
        return eventDao;
    }

    public List<Migration> getAutoMigrations(Map<Class<? extends Object>, Object> map) {
        return Arrays.asList(new Migration[0]);
    }

    public Set<Class<? extends Object>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    public Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(EventDao.class, EventDao_Impl.getRequiredConverters());
        return hashMap;
    }
}
