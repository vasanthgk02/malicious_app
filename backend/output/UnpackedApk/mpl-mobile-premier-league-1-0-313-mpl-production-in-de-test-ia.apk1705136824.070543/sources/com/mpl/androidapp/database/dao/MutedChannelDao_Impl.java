package com.mpl.androidapp.database.dao;

import android.database.Cursor;
import androidx.core.widget.CompoundButtonCompat;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.mpl.androidapp.database.model.MutedChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class MutedChannelDao_Impl implements MutedChannelDao {
    public final RoomDatabase __db;
    public final EntityInsertionAdapter<MutedChannel> __insertionAdapterOfMutedChannel;
    public final SharedSQLiteStatement __preparedStmtOfDeleteAll;

    public MutedChannelDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfMutedChannel = new EntityInsertionAdapter<MutedChannel>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `MutedChannel` (`uid`,`type`,`url`) VALUES (nullif(?, 0),?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, MutedChannel mutedChannel) {
                supportSQLiteStatement.bindLong(1, (long) mutedChannel.getUid());
                if (mutedChannel.getType() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, mutedChannel.getType());
                }
                if (mutedChannel.getUrl() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, mutedChannel.getUrl());
                }
            }
        };
        this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM MutedChannel";
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

    public List<MutedChannel> getMutedChannels() {
        String str;
        String str2;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM MutedChannel", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = CompoundButtonCompat.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CompoundButtonCompat.getColumnIndexOrThrow(query, "uid");
            int columnIndexOrThrow2 = CompoundButtonCompat.getColumnIndexOrThrow(query, "type");
            int columnIndexOrThrow3 = CompoundButtonCompat.getColumnIndexOrThrow(query, "url");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (query.isNull(columnIndexOrThrow2)) {
                    str = null;
                } else {
                    str = query.getString(columnIndexOrThrow2);
                }
                if (query.isNull(columnIndexOrThrow3)) {
                    str2 = null;
                } else {
                    str2 = query.getString(columnIndexOrThrow3);
                }
                MutedChannel mutedChannel = new MutedChannel(str, str2);
                mutedChannel.setUid(query.getInt(columnIndexOrThrow));
                arrayList.add(mutedChannel);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public void insertMutedChannels(List<MutedChannel> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfMutedChannel.insert((Iterable<? extends T>) list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public boolean isChannelMuted(String str) {
        boolean z = true;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT EXISTS(SELECT * FROM MutedChannel WHERE url=?)", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        boolean z2 = false;
        Cursor query = CompoundButtonCompat.query(this.__db, acquire, false, null);
        try {
            if (query.moveToFirst()) {
                if (query.getInt(0) == 0) {
                    z = false;
                }
                z2 = z;
            }
            return z2;
        } finally {
            query.close();
            acquire.release();
        }
    }
}
