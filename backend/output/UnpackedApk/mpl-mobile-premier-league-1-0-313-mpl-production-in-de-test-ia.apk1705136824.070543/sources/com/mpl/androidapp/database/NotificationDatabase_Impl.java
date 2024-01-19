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
import com.mpl.androidapp.database.dao.NotifictionDrawerDao;
import com.mpl.androidapp.database.dao.NotifictionDrawerDao_Impl;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class NotificationDatabase_Impl extends NotificationDatabase {
    public volatile NotifictionDrawerDao _notifictionDrawerDao;

    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `notification`");
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
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "notification");
    }

    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        RoomOpenHelper roomOpenHelper = new RoomOpenHelper(databaseConfiguration, new Delegate(1) {
            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `notification` (`_ID` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `notification_data` TEXT, `recieved_time` TEXT, `read` INTEGER NOT NULL, `category` TEXT, `subCategory` TEXT, `Title` TEXT, `Body` TEXT, `isSoftDeleted` INTEGER NOT NULL)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '37afbe6027752ab38bb8f47b7d56d9d6')");
            }

            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `notification`");
                if (NotificationDatabase_Impl.this.mCallbacks != null) {
                    int size = NotificationDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((Callback) NotificationDatabase_Impl.this.mCallbacks.get(i)).onDestructiveMigration(supportSQLiteDatabase);
                    }
                }
            }

            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (NotificationDatabase_Impl.this.mCallbacks != null) {
                    int size = NotificationDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((Callback) NotificationDatabase_Impl.this.mCallbacks.get(i)).onCreate(supportSQLiteDatabase);
                    }
                }
            }

            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                NotificationDatabase_Impl.this.mDatabase = supportSQLiteDatabase;
                NotificationDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                if (NotificationDatabase_Impl.this.mCallbacks != null) {
                    int size = NotificationDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((Callback) NotificationDatabase_Impl.this.mCallbacks.get(i)).onOpen(supportSQLiteDatabase);
                    }
                }
            }

            public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            }

            public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
                CompoundButtonCompat.dropFtsSyncTriggers(supportSQLiteDatabase);
            }

            public ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
                HashMap hashMap = new HashMap(9);
                Column column = new Column("_ID", "INTEGER", true, 1, null, 1);
                hashMap.put("_ID", column);
                Column column2 = new Column("notification_data", "TEXT", false, 0, null, 1);
                hashMap.put("notification_data", column2);
                Column column3 = new Column("recieved_time", "TEXT", false, 0, null, 1);
                hashMap.put("recieved_time", column3);
                Column column4 = new Column("read", "INTEGER", true, 0, null, 1);
                hashMap.put("read", column4);
                Column column5 = new Column("category", "TEXT", false, 0, null, 1);
                hashMap.put("category", column5);
                Column column6 = new Column("subCategory", "TEXT", false, 0, null, 1);
                hashMap.put("subCategory", column6);
                Column column7 = new Column("Title", "TEXT", false, 0, null, 1);
                hashMap.put("Title", column7);
                Column column8 = new Column("Body", "TEXT", false, 0, null, 1);
                hashMap.put("Body", column8);
                Column column9 = new Column("isSoftDeleted", "INTEGER", true, 0, null, 1);
                hashMap.put("isSoftDeleted", column9);
                TableInfo tableInfo = new TableInfo("notification", hashMap, new HashSet(0), new HashSet(0));
                TableInfo read = TableInfo.read(supportSQLiteDatabase, "notification");
                if (tableInfo.equals(read)) {
                    return new ValidationResult(true, null);
                }
                return new ValidationResult(false, "notification(com.mpl.androidapp.database.entity.Notification).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
            }
        }, "37afbe6027752ab38bb8f47b7d56d9d6", "cc3b29dc68e024213295a24e2be5313a");
        Builder builder = Configuration.builder(databaseConfiguration.context);
        builder.name = databaseConfiguration.name;
        builder.callback(roomOpenHelper);
        return databaseConfiguration.sqliteOpenHelperFactory.create(builder.build());
    }

    public NotifictionDrawerDao dataAccessObject() {
        NotifictionDrawerDao notifictionDrawerDao;
        if (this._notifictionDrawerDao != null) {
            return this._notifictionDrawerDao;
        }
        synchronized (this) {
            if (this._notifictionDrawerDao == null) {
                this._notifictionDrawerDao = new NotifictionDrawerDao_Impl(this);
            }
            notifictionDrawerDao = this._notifictionDrawerDao;
        }
        return notifictionDrawerDao;
    }

    public List<Migration> getAutoMigrations(Map<Class<? extends Object>, Object> map) {
        return Arrays.asList(new Migration[0]);
    }

    public Set<Class<? extends Object>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    public Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(NotifictionDrawerDao.class, NotifictionDrawerDao_Impl.getRequiredConverters());
        return hashMap;
    }
}
