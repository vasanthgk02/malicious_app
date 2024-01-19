package com.mpl.androidapp.database.dao;

import android.database.Cursor;
import androidx.core.widget.CompoundButtonCompat;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.mpl.androidapp.database.entity.Events;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class EventDao_Impl implements EventDao {
    public final RoomDatabase __db;
    public final EntityInsertionAdapter<Events> __insertionAdapterOfEvents;
    public final SharedSQLiteStatement __preparedStmtOfDeleteAllDataFromDB;

    public EventDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfEvents = new EntityInsertionAdapter<Events>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `events` (`_ID`,`key`,`value`,`timeStamp`) VALUES (nullif(?, 0),?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, Events events) {
                supportSQLiteStatement.bindLong(1, events.index);
                if (events.getKey() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, events.getKey());
                }
                if (events.getValue() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, events.getValue());
                }
                if (events.getTime() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, events.getTime());
                }
            }
        };
        this.__preparedStmtOfDeleteAllDataFromDB = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "delete FROM events";
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    public void addevent(Events events) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfEvents.insert(events);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public int deleteAllDataFromDB() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteAllDataFromDB.acquire();
        this.__db.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteAllDataFromDB.release(acquire);
        }
    }

    public List<Events> getAllEvents() {
        String str;
        String str2;
        String str3;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM events", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = CompoundButtonCompat.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CompoundButtonCompat.getColumnIndexOrThrow(query, "_ID");
            int columnIndexOrThrow2 = CompoundButtonCompat.getColumnIndexOrThrow(query, "key");
            int columnIndexOrThrow3 = CompoundButtonCompat.getColumnIndexOrThrow(query, HSLCriteriaBuilder.VALUE);
            int columnIndexOrThrow4 = CompoundButtonCompat.getColumnIndexOrThrow(query, "timeStamp");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                Events events = new Events();
                events.index = query.getLong(columnIndexOrThrow);
                if (query.isNull(columnIndexOrThrow2)) {
                    str = null;
                } else {
                    str = query.getString(columnIndexOrThrow2);
                }
                events.setKey(str);
                if (query.isNull(columnIndexOrThrow3)) {
                    str2 = null;
                } else {
                    str2 = query.getString(columnIndexOrThrow3);
                }
                events.setValue(str2);
                if (query.isNull(columnIndexOrThrow4)) {
                    str3 = null;
                } else {
                    str3 = query.getString(columnIndexOrThrow4);
                }
                events.setTime(str3);
                arrayList.add(events);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }
}
