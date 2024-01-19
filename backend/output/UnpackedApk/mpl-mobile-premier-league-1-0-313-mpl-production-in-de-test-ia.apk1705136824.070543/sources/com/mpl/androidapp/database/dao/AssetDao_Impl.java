package com.mpl.androidapp.database.dao;

import android.database.Cursor;
import androidx.core.widget.CompoundButtonCompat;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.mpl.androidapp.config.ConfigConstant;
import com.mpl.androidapp.database.model.Asset;
import com.netcore.android.SMTEventParamKeys;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class AssetDao_Impl implements AssetDao {
    public final RoomDatabase __db;
    public final EntityInsertionAdapter<Asset> __insertionAdapterOfAsset;
    public final SharedSQLiteStatement __preparedStmtOfDeleteAll;

    public AssetDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfAsset = new EntityInsertionAdapter<Asset>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `Asset` (`uid`,`assetVersion`,`gameId`,`firstDownloadTime`,`lastModifiedTime`,`gameVersion`,`appVersion`,`reactVersion`,`modifiedAppVersion`,`modifiedReactVersion`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, Asset asset) {
                supportSQLiteStatement.bindLong(1, (long) asset.getUid());
                supportSQLiteStatement.bindLong(2, (long) asset.getAssetVersion());
                supportSQLiteStatement.bindLong(3, (long) asset.getGameId());
                supportSQLiteStatement.bindLong(4, asset.getFirstDownloadTime());
                supportSQLiteStatement.bindLong(5, asset.getLastModifiedTime());
                supportSQLiteStatement.bindLong(6, (long) asset.getGameVersion());
                supportSQLiteStatement.bindLong(7, (long) asset.getAppVersion());
                supportSQLiteStatement.bindLong(8, (long) asset.getReactVersion());
                supportSQLiteStatement.bindLong(9, (long) asset.getModifiedAppVersion());
                supportSQLiteStatement.bindLong(10, (long) asset.getModifiedReactVersion());
            }
        };
        this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM Asset";
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    public void deleteAll() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteAll.acquire();
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteAll.release(acquire);
        }
    }

    public Asset getAsset(int i) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM Asset WHERE gameId=?", 1);
        acquire.bindLong(1, (long) i);
        this.__db.assertNotSuspendingTransaction();
        Asset asset = null;
        Cursor query = CompoundButtonCompat.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CompoundButtonCompat.getColumnIndexOrThrow(query, "uid");
            int columnIndexOrThrow2 = CompoundButtonCompat.getColumnIndexOrThrow(query, "assetVersion");
            int columnIndexOrThrow3 = CompoundButtonCompat.getColumnIndexOrThrow(query, "gameId");
            int columnIndexOrThrow4 = CompoundButtonCompat.getColumnIndexOrThrow(query, "firstDownloadTime");
            int columnIndexOrThrow5 = CompoundButtonCompat.getColumnIndexOrThrow(query, "lastModifiedTime");
            int columnIndexOrThrow6 = CompoundButtonCompat.getColumnIndexOrThrow(query, "gameVersion");
            int columnIndexOrThrow7 = CompoundButtonCompat.getColumnIndexOrThrow(query, SMTEventParamKeys.SMT_APP_VERSION);
            int columnIndexOrThrow8 = CompoundButtonCompat.getColumnIndexOrThrow(query, ConfigConstant.REACT_VERSION);
            int columnIndexOrThrow9 = CompoundButtonCompat.getColumnIndexOrThrow(query, "modifiedAppVersion");
            int columnIndexOrThrow10 = CompoundButtonCompat.getColumnIndexOrThrow(query, "modifiedReactVersion");
            if (query.moveToFirst()) {
                asset = new Asset();
                asset.setUid(query.getInt(columnIndexOrThrow));
                asset.setAssetVersion(query.getInt(columnIndexOrThrow2));
                asset.setGameId(query.getInt(columnIndexOrThrow3));
                asset.setFirstDownloadTime(query.getLong(columnIndexOrThrow4));
                asset.setLastModifiedTime(query.getLong(columnIndexOrThrow5));
                asset.setGameVersion(query.getInt(columnIndexOrThrow6));
                asset.setAppVersion(query.getInt(columnIndexOrThrow7));
                asset.setReactVersion(query.getInt(columnIndexOrThrow8));
                asset.setModifiedAppVersion(query.getInt(columnIndexOrThrow9));
                asset.setModifiedReactVersion(query.getInt(columnIndexOrThrow10));
            }
            return asset;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public List<Asset> getAssets() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM Asset", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = CompoundButtonCompat.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CompoundButtonCompat.getColumnIndexOrThrow(query, "uid");
            int columnIndexOrThrow2 = CompoundButtonCompat.getColumnIndexOrThrow(query, "assetVersion");
            int columnIndexOrThrow3 = CompoundButtonCompat.getColumnIndexOrThrow(query, "gameId");
            int columnIndexOrThrow4 = CompoundButtonCompat.getColumnIndexOrThrow(query, "firstDownloadTime");
            int columnIndexOrThrow5 = CompoundButtonCompat.getColumnIndexOrThrow(query, "lastModifiedTime");
            int columnIndexOrThrow6 = CompoundButtonCompat.getColumnIndexOrThrow(query, "gameVersion");
            int columnIndexOrThrow7 = CompoundButtonCompat.getColumnIndexOrThrow(query, SMTEventParamKeys.SMT_APP_VERSION);
            int columnIndexOrThrow8 = CompoundButtonCompat.getColumnIndexOrThrow(query, ConfigConstant.REACT_VERSION);
            int columnIndexOrThrow9 = CompoundButtonCompat.getColumnIndexOrThrow(query, "modifiedAppVersion");
            int columnIndexOrThrow10 = CompoundButtonCompat.getColumnIndexOrThrow(query, "modifiedReactVersion");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                Asset asset = new Asset();
                asset.setUid(query.getInt(columnIndexOrThrow));
                asset.setAssetVersion(query.getInt(columnIndexOrThrow2));
                asset.setGameId(query.getInt(columnIndexOrThrow3));
                int i = columnIndexOrThrow;
                asset.setFirstDownloadTime(query.getLong(columnIndexOrThrow4));
                asset.setLastModifiedTime(query.getLong(columnIndexOrThrow5));
                asset.setGameVersion(query.getInt(columnIndexOrThrow6));
                asset.setAppVersion(query.getInt(columnIndexOrThrow7));
                asset.setReactVersion(query.getInt(columnIndexOrThrow8));
                asset.setModifiedAppVersion(query.getInt(columnIndexOrThrow9));
                asset.setModifiedReactVersion(query.getInt(columnIndexOrThrow10));
                arrayList.add(asset);
                columnIndexOrThrow = i;
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public void insertAsset(Asset asset) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfAsset.insert(asset);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void insertAssets(List<Asset> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfAsset.insert((Iterable<? extends T>) list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
