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
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration.Builder;
import com.mpl.androidapp.config.ConfigConstant;
import com.mpl.androidapp.database.dao.AssetDao;
import com.mpl.androidapp.database.dao.AssetDao_Impl;
import com.mpl.androidapp.database.dao.ContactDao;
import com.mpl.androidapp.database.dao.ContactDao_Impl;
import com.mpl.androidapp.database.dao.MutedChannelDao;
import com.mpl.androidapp.database.dao.MutedChannelDao_Impl;
import com.netcore.android.SMTEventParamKeys;
import com.paynimo.android.payment.UPIFragment;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class AppDatabase_Impl extends AppDatabase {
    public volatile AssetDao _assetDao;
    public volatile ContactDao _contactDao;
    public volatile MutedChannelDao _mutedChannelDao;

    public AssetDao assetDao() {
        AssetDao assetDao;
        if (this._assetDao != null) {
            return this._assetDao;
        }
        synchronized (this) {
            if (this._assetDao == null) {
                this._assetDao = new AssetDao_Impl(this);
            }
            assetDao = this._assetDao;
        }
        return assetDao;
    }

    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `contacts`");
            writableDatabase.execSQL("DELETE FROM `MutedChannel`");
            writableDatabase.execSQL("DELETE FROM `Asset`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query((String) "PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    public ContactDao contactDao() {
        ContactDao contactDao;
        if (this._contactDao != null) {
            return this._contactDao;
        }
        synchronized (this) {
            if (this._contactDao == null) {
                this._contactDao = new ContactDao_Impl(this);
            }
            contactDao = this._contactDao;
        }
        return contactDao;
    }

    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "contacts", "MutedChannel", "Asset");
    }

    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        RoomOpenHelper roomOpenHelper = new RoomOpenHelper(databaseConfiguration, new Delegate(8) {
            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `contacts` (`_ID` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `number` TEXT, `type` TEXT, `id` TEXT, `lookup_key` TEXT, `name` TEXT, `display_name` TEXT, `given_name` TEXT, `family_name` TEXT, `mpl_contact` INTEGER, `mpl_name` TEXT, `mpl_id` TEXT, `isSync` INTEGER, `isOnline` INTEGER, `lastSeen` TEXT, `lastUpdateTimeStamp` TEXT, `photo_thumb_uri` TEXT)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `MutedChannel` (`uid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `type` TEXT, `url` TEXT)");
                supportSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_MutedChannel_url` ON `MutedChannel` (`url`)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `Asset` (`uid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `assetVersion` INTEGER NOT NULL, `gameId` INTEGER NOT NULL, `firstDownloadTime` INTEGER NOT NULL, `lastModifiedTime` INTEGER NOT NULL, `gameVersion` INTEGER NOT NULL, `appVersion` INTEGER NOT NULL, `reactVersion` INTEGER NOT NULL, `modifiedAppVersion` INTEGER NOT NULL, `modifiedReactVersion` INTEGER NOT NULL)");
                supportSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_Asset_gameId` ON `Asset` (`gameId`)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'd7ffaca4e8980f78775757b4a4561243')");
            }

            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `contacts`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `MutedChannel`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `Asset`");
                if (AppDatabase_Impl.this.mCallbacks != null) {
                    int size = AppDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((Callback) AppDatabase_Impl.this.mCallbacks.get(i)).onDestructiveMigration(supportSQLiteDatabase);
                    }
                }
            }

            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (AppDatabase_Impl.this.mCallbacks != null) {
                    int size = AppDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((Callback) AppDatabase_Impl.this.mCallbacks.get(i)).onCreate(supportSQLiteDatabase);
                    }
                }
            }

            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                AppDatabase_Impl.this.mDatabase = supportSQLiteDatabase;
                AppDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                if (AppDatabase_Impl.this.mCallbacks != null) {
                    int size = AppDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((Callback) AppDatabase_Impl.this.mCallbacks.get(i)).onOpen(supportSQLiteDatabase);
                    }
                }
            }

            public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            }

            public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
                CompoundButtonCompat.dropFtsSyncTriggers(supportSQLiteDatabase);
            }

            public ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase supportSQLiteDatabase2 = supportSQLiteDatabase;
                HashMap hashMap = new HashMap(17);
                Column column = new Column("_ID", "INTEGER", true, 1, null, 1);
                hashMap.put("_ID", column);
                Column column2 = new Column(UPIFragment.CONFIG_TYPE_NUMBER, "TEXT", false, 0, null, 1);
                hashMap.put(UPIFragment.CONFIG_TYPE_NUMBER, column2);
                Column column3 = new Column("type", "TEXT", false, 0, null, 1);
                hashMap.put("type", column3);
                Column column4 = new Column("id", "TEXT", false, 0, null, 1);
                hashMap.put("id", column4);
                Column column5 = new Column("lookup_key", "TEXT", false, 0, null, 1);
                hashMap.put("lookup_key", column5);
                Column column6 = new Column("name", "TEXT", false, 0, null, 1);
                hashMap.put("name", column6);
                Column column7 = new Column("display_name", "TEXT", false, 0, null, 1);
                hashMap.put("display_name", column7);
                Column column8 = new Column("given_name", "TEXT", false, 0, null, 1);
                hashMap.put("given_name", column8);
                Column column9 = new Column("family_name", "TEXT", false, 0, null, 1);
                hashMap.put("family_name", column9);
                Column column10 = new Column("mpl_contact", "INTEGER", false, 0, null, 1);
                hashMap.put("mpl_contact", column10);
                Column column11 = new Column("mpl_name", "TEXT", false, 0, null, 1);
                hashMap.put("mpl_name", column11);
                Column column12 = new Column("mpl_id", "TEXT", false, 0, null, 1);
                hashMap.put("mpl_id", column12);
                Column column13 = new Column("isSync", "INTEGER", false, 0, null, 1);
                hashMap.put("isSync", column13);
                Column column14 = new Column("isOnline", "INTEGER", false, 0, null, 1);
                hashMap.put("isOnline", column14);
                Column column15 = new Column("lastSeen", "TEXT", false, 0, null, 1);
                hashMap.put("lastSeen", column15);
                Column column16 = new Column("lastUpdateTimeStamp", "TEXT", false, 0, null, 1);
                hashMap.put("lastUpdateTimeStamp", column16);
                Column column17 = new Column("photo_thumb_uri", "TEXT", false, 0, null, 1);
                hashMap.put("photo_thumb_uri", column17);
                TableInfo tableInfo = new TableInfo("contacts", hashMap, new HashSet(0), new HashSet(0));
                TableInfo read = TableInfo.read(supportSQLiteDatabase2, "contacts");
                if (!tableInfo.equals(read)) {
                    return new ValidationResult(false, "contacts(com.mpl.androidapp.database.entity.Contact).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
                }
                HashMap hashMap2 = new HashMap(3);
                Column column18 = new Column("uid", "INTEGER", true, 1, null, 1);
                hashMap2.put("uid", column18);
                Column column19 = new Column("type", "TEXT", false, 0, null, 1);
                hashMap2.put("type", column19);
                Column column20 = new Column("url", "TEXT", false, 0, null, 1);
                hashMap2.put("url", column20);
                HashSet hashSet = new HashSet(0);
                HashSet hashSet2 = new HashSet(1);
                hashSet2.add(new Index("index_MutedChannel_url", true, Arrays.asList(new String[]{"url"}), Arrays.asList(new String[]{"ASC"})));
                TableInfo tableInfo2 = new TableInfo("MutedChannel", hashMap2, hashSet, hashSet2);
                TableInfo read2 = TableInfo.read(supportSQLiteDatabase2, "MutedChannel");
                if (!tableInfo2.equals(read2)) {
                    return new ValidationResult(false, "MutedChannel(com.mpl.androidapp.database.model.MutedChannel).\n Expected:\n" + tableInfo2 + "\n Found:\n" + read2);
                }
                HashMap hashMap3 = new HashMap(10);
                Column column21 = new Column("uid", "INTEGER", true, 1, null, 1);
                hashMap3.put("uid", column21);
                Column column22 = new Column("assetVersion", "INTEGER", true, 0, null, 1);
                hashMap3.put("assetVersion", column22);
                Column column23 = new Column("gameId", "INTEGER", true, 0, null, 1);
                hashMap3.put("gameId", column23);
                Column column24 = new Column("firstDownloadTime", "INTEGER", true, 0, null, 1);
                hashMap3.put("firstDownloadTime", column24);
                Column column25 = new Column("lastModifiedTime", "INTEGER", true, 0, null, 1);
                hashMap3.put("lastModifiedTime", column25);
                Column column26 = new Column("gameVersion", "INTEGER", true, 0, null, 1);
                hashMap3.put("gameVersion", column26);
                Column column27 = new Column(SMTEventParamKeys.SMT_APP_VERSION, "INTEGER", true, 0, null, 1);
                hashMap3.put(SMTEventParamKeys.SMT_APP_VERSION, column27);
                Column column28 = new Column(ConfigConstant.REACT_VERSION, "INTEGER", true, 0, null, 1);
                hashMap3.put(ConfigConstant.REACT_VERSION, column28);
                Column column29 = new Column("modifiedAppVersion", "INTEGER", true, 0, null, 1);
                hashMap3.put("modifiedAppVersion", column29);
                Column column30 = new Column("modifiedReactVersion", "INTEGER", true, 0, null, 1);
                hashMap3.put("modifiedReactVersion", column30);
                HashSet hashSet3 = new HashSet(0);
                HashSet hashSet4 = new HashSet(1);
                hashSet4.add(new Index("index_Asset_gameId", true, Arrays.asList(new String[]{"gameId"}), Arrays.asList(new String[]{"ASC"})));
                TableInfo tableInfo3 = new TableInfo("Asset", hashMap3, hashSet3, hashSet4);
                TableInfo read3 = TableInfo.read(supportSQLiteDatabase2, "Asset");
                if (tableInfo3.equals(read3)) {
                    return new ValidationResult(true, null);
                }
                return new ValidationResult(false, "Asset(com.mpl.androidapp.database.model.Asset).\n Expected:\n" + tableInfo3 + "\n Found:\n" + read3);
            }
        }, "d7ffaca4e8980f78775757b4a4561243", "b21dd3355a0e348f0d669656fc01a3b6");
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
        hashMap.put(ContactDao.class, ContactDao_Impl.getRequiredConverters());
        hashMap.put(MutedChannelDao.class, MutedChannelDao_Impl.getRequiredConverters());
        hashMap.put(AssetDao.class, AssetDao_Impl.getRequiredConverters());
        return hashMap;
    }

    public MutedChannelDao mutedChannelDao() {
        MutedChannelDao mutedChannelDao;
        if (this._mutedChannelDao != null) {
            return this._mutedChannelDao;
        }
        synchronized (this) {
            if (this._mutedChannelDao == null) {
                this._mutedChannelDao = new MutedChannelDao_Impl(this);
            }
            mutedChannelDao = this._mutedChannelDao;
        }
        return mutedChannelDao;
    }
}
