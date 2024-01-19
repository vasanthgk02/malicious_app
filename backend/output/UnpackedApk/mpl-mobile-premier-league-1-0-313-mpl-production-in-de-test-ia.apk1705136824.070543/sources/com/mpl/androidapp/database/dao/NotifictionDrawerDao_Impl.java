package com.mpl.androidapp.database.dao;

import android.database.Cursor;
import androidx.core.widget.CompoundButtonCompat;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.mpl.androidapp.database.entity.Notification;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class NotifictionDrawerDao_Impl implements NotifictionDrawerDao {
    public final RoomDatabase __db;
    public final EntityInsertionAdapter<Notification> __insertionAdapterOfNotification;
    public final SharedSQLiteStatement __preparedStmtOfDeleteAllDataFromDB;
    public final SharedSQLiteStatement __preparedStmtOfDeleteDataBasedOnIndexFromDB;
    public final SharedSQLiteStatement __preparedStmtOfDeleteSingleFromDB;
    public final SharedSQLiteStatement __preparedStmtOfUpdate;

    public NotifictionDrawerDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfNotification = new EntityInsertionAdapter<Notification>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `notification` (`_ID`,`notification_data`,`recieved_time`,`read`,`category`,`subCategory`,`Title`,`Body`,`isSoftDeleted`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, Notification notification) {
                supportSQLiteStatement.bindLong(1, notification.index);
                if (notification.getNotificationData() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, notification.getNotificationData());
                }
                if (notification.getRecievedTime() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, notification.getRecievedTime());
                }
                supportSQLiteStatement.bindLong(4, notification.isRead() ? 1 : 0);
                if (notification.getCategory() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, notification.getCategory());
                }
                if (notification.getSubCategory() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, notification.getSubCategory());
                }
                if (notification.getTitle() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, notification.getTitle());
                }
                if (notification.getBody() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, notification.getBody());
                }
                supportSQLiteStatement.bindLong(9, notification.getIsSoftDeleted() ? 1 : 0);
            }
        };
        this.__preparedStmtOfUpdate = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE notification SET read=? WHERE _ID = ?";
            }
        };
        this.__preparedStmtOfDeleteAllDataFromDB = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "delete FROM Notification";
            }
        };
        this.__preparedStmtOfDeleteSingleFromDB = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "delete FROM Notification where _ID ==?";
            }
        };
        this.__preparedStmtOfDeleteDataBasedOnIndexFromDB = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "delete FROM Notification where _ID <=?";
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    public void addevent(Notification notification) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfNotification.insert(notification);
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

    public int deleteDataBasedOnIndexFromDB(long j) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteDataBasedOnIndexFromDB.acquire();
        acquire.bindLong(1, j);
        this.__db.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteDataBasedOnIndexFromDB.release(acquire);
        }
    }

    public int deleteSingleFromDB(int i) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteSingleFromDB.acquire();
        acquire.bindLong(1, (long) i);
        this.__db.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteSingleFromDB.release(acquire);
        }
    }

    public List<Notification> getAllEvents() {
        RoomSQLiteQuery roomSQLiteQuery;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM notification", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = CompoundButtonCompat.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CompoundButtonCompat.getColumnIndexOrThrow(query, "_ID");
            int columnIndexOrThrow2 = CompoundButtonCompat.getColumnIndexOrThrow(query, "notification_data");
            int columnIndexOrThrow3 = CompoundButtonCompat.getColumnIndexOrThrow(query, "recieved_time");
            int columnIndexOrThrow4 = CompoundButtonCompat.getColumnIndexOrThrow(query, "read");
            int columnIndexOrThrow5 = CompoundButtonCompat.getColumnIndexOrThrow(query, "category");
            int columnIndexOrThrow6 = CompoundButtonCompat.getColumnIndexOrThrow(query, "subCategory");
            int columnIndexOrThrow7 = CompoundButtonCompat.getColumnIndexOrThrow(query, "Title");
            int columnIndexOrThrow8 = CompoundButtonCompat.getColumnIndexOrThrow(query, "Body");
            int columnIndexOrThrow9 = CompoundButtonCompat.getColumnIndexOrThrow(query, "isSoftDeleted");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                Notification notification = new Notification();
                roomSQLiteQuery = acquire;
                try {
                    notification.index = query.getLong(columnIndexOrThrow);
                    if (query.isNull(columnIndexOrThrow2)) {
                        str = null;
                    } else {
                        str = query.getString(columnIndexOrThrow2);
                    }
                    notification.setNotificationData(str);
                    if (query.isNull(columnIndexOrThrow3)) {
                        str2 = null;
                    } else {
                        str2 = query.getString(columnIndexOrThrow3);
                    }
                    notification.setRecievedTime(str2);
                    boolean z = true;
                    notification.setRead(query.getInt(columnIndexOrThrow4) != 0);
                    if (query.isNull(columnIndexOrThrow5)) {
                        str3 = null;
                    } else {
                        str3 = query.getString(columnIndexOrThrow5);
                    }
                    notification.setCategory(str3);
                    if (query.isNull(columnIndexOrThrow6)) {
                        str4 = null;
                    } else {
                        str4 = query.getString(columnIndexOrThrow6);
                    }
                    notification.setSubCategory(str4);
                    if (query.isNull(columnIndexOrThrow7)) {
                        str5 = null;
                    } else {
                        str5 = query.getString(columnIndexOrThrow7);
                    }
                    notification.setTitle(str5);
                    if (query.isNull(columnIndexOrThrow8)) {
                        str6 = null;
                    } else {
                        str6 = query.getString(columnIndexOrThrow8);
                    }
                    notification.setBody(str6);
                    if (query.getInt(columnIndexOrThrow9) == 0) {
                        z = false;
                    }
                    notification.setIsSoftDeleted(z);
                    arrayList.add(notification);
                    acquire = roomSQLiteQuery;
                } catch (Throwable th) {
                    th = th;
                    query.close();
                    roomSQLiteQuery.release();
                    throw th;
                }
            }
            query.close();
            acquire.release();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public List<Notification> getNotificationDataInDescendginOrderPagination(long j, long j2) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM Notification  where _ID <= ? and _ID >=? ORDER BY _ID DESC", 2);
        acquire.bindLong(1, j);
        acquire.bindLong(2, j2);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = CompoundButtonCompat.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CompoundButtonCompat.getColumnIndexOrThrow(query, "_ID");
            int columnIndexOrThrow2 = CompoundButtonCompat.getColumnIndexOrThrow(query, "notification_data");
            int columnIndexOrThrow3 = CompoundButtonCompat.getColumnIndexOrThrow(query, "recieved_time");
            int columnIndexOrThrow4 = CompoundButtonCompat.getColumnIndexOrThrow(query, "read");
            int columnIndexOrThrow5 = CompoundButtonCompat.getColumnIndexOrThrow(query, "category");
            int columnIndexOrThrow6 = CompoundButtonCompat.getColumnIndexOrThrow(query, "subCategory");
            int columnIndexOrThrow7 = CompoundButtonCompat.getColumnIndexOrThrow(query, "Title");
            int columnIndexOrThrow8 = CompoundButtonCompat.getColumnIndexOrThrow(query, "Body");
            int columnIndexOrThrow9 = CompoundButtonCompat.getColumnIndexOrThrow(query, "isSoftDeleted");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                Notification notification = new Notification();
                notification.index = query.getLong(columnIndexOrThrow);
                if (query.isNull(columnIndexOrThrow2)) {
                    str = null;
                } else {
                    str = query.getString(columnIndexOrThrow2);
                }
                notification.setNotificationData(str);
                if (query.isNull(columnIndexOrThrow3)) {
                    str2 = null;
                } else {
                    str2 = query.getString(columnIndexOrThrow3);
                }
                notification.setRecievedTime(str2);
                notification.setRead(query.getInt(columnIndexOrThrow4) != 0);
                if (query.isNull(columnIndexOrThrow5)) {
                    str3 = null;
                } else {
                    str3 = query.getString(columnIndexOrThrow5);
                }
                notification.setCategory(str3);
                if (query.isNull(columnIndexOrThrow6)) {
                    str4 = null;
                } else {
                    str4 = query.getString(columnIndexOrThrow6);
                }
                notification.setSubCategory(str4);
                if (query.isNull(columnIndexOrThrow7)) {
                    str5 = null;
                } else {
                    str5 = query.getString(columnIndexOrThrow7);
                }
                notification.setTitle(str5);
                if (query.isNull(columnIndexOrThrow8)) {
                    str6 = null;
                } else {
                    str6 = query.getString(columnIndexOrThrow8);
                }
                notification.setBody(str6);
                notification.setIsSoftDeleted(query.getInt(columnIndexOrThrow9) != 0);
                arrayList.add(notification);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public List<Notification> getNotificationEntityInAscendingOrder(int i) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM Notification ORDER BY _ID ASC LIMIT ?", 1);
        acquire.bindLong(1, (long) i);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = CompoundButtonCompat.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CompoundButtonCompat.getColumnIndexOrThrow(query, "_ID");
            int columnIndexOrThrow2 = CompoundButtonCompat.getColumnIndexOrThrow(query, "notification_data");
            int columnIndexOrThrow3 = CompoundButtonCompat.getColumnIndexOrThrow(query, "recieved_time");
            int columnIndexOrThrow4 = CompoundButtonCompat.getColumnIndexOrThrow(query, "read");
            int columnIndexOrThrow5 = CompoundButtonCompat.getColumnIndexOrThrow(query, "category");
            int columnIndexOrThrow6 = CompoundButtonCompat.getColumnIndexOrThrow(query, "subCategory");
            int columnIndexOrThrow7 = CompoundButtonCompat.getColumnIndexOrThrow(query, "Title");
            int columnIndexOrThrow8 = CompoundButtonCompat.getColumnIndexOrThrow(query, "Body");
            int columnIndexOrThrow9 = CompoundButtonCompat.getColumnIndexOrThrow(query, "isSoftDeleted");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                Notification notification = new Notification();
                notification.index = query.getLong(columnIndexOrThrow);
                if (query.isNull(columnIndexOrThrow2)) {
                    str = null;
                } else {
                    str = query.getString(columnIndexOrThrow2);
                }
                notification.setNotificationData(str);
                if (query.isNull(columnIndexOrThrow3)) {
                    str2 = null;
                } else {
                    str2 = query.getString(columnIndexOrThrow3);
                }
                notification.setRecievedTime(str2);
                notification.setRead(query.getInt(columnIndexOrThrow4) != 0);
                if (query.isNull(columnIndexOrThrow5)) {
                    str3 = null;
                } else {
                    str3 = query.getString(columnIndexOrThrow5);
                }
                notification.setCategory(str3);
                if (query.isNull(columnIndexOrThrow6)) {
                    str4 = null;
                } else {
                    str4 = query.getString(columnIndexOrThrow6);
                }
                notification.setSubCategory(str4);
                if (query.isNull(columnIndexOrThrow7)) {
                    str5 = null;
                } else {
                    str5 = query.getString(columnIndexOrThrow7);
                }
                notification.setTitle(str5);
                if (query.isNull(columnIndexOrThrow8)) {
                    str6 = null;
                } else {
                    str6 = query.getString(columnIndexOrThrow8);
                }
                notification.setBody(str6);
                notification.setIsSoftDeleted(query.getInt(columnIndexOrThrow9) != 0);
                arrayList.add(notification);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public List<Notification> getNotificationEntityInDescendingOrder(int i) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM Notification ORDER BY _ID DESC LIMIT ?", 1);
        acquire.bindLong(1, (long) i);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = CompoundButtonCompat.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CompoundButtonCompat.getColumnIndexOrThrow(query, "_ID");
            int columnIndexOrThrow2 = CompoundButtonCompat.getColumnIndexOrThrow(query, "notification_data");
            int columnIndexOrThrow3 = CompoundButtonCompat.getColumnIndexOrThrow(query, "recieved_time");
            int columnIndexOrThrow4 = CompoundButtonCompat.getColumnIndexOrThrow(query, "read");
            int columnIndexOrThrow5 = CompoundButtonCompat.getColumnIndexOrThrow(query, "category");
            int columnIndexOrThrow6 = CompoundButtonCompat.getColumnIndexOrThrow(query, "subCategory");
            int columnIndexOrThrow7 = CompoundButtonCompat.getColumnIndexOrThrow(query, "Title");
            int columnIndexOrThrow8 = CompoundButtonCompat.getColumnIndexOrThrow(query, "Body");
            int columnIndexOrThrow9 = CompoundButtonCompat.getColumnIndexOrThrow(query, "isSoftDeleted");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                Notification notification = new Notification();
                notification.index = query.getLong(columnIndexOrThrow);
                if (query.isNull(columnIndexOrThrow2)) {
                    str = null;
                } else {
                    str = query.getString(columnIndexOrThrow2);
                }
                notification.setNotificationData(str);
                if (query.isNull(columnIndexOrThrow3)) {
                    str2 = null;
                } else {
                    str2 = query.getString(columnIndexOrThrow3);
                }
                notification.setRecievedTime(str2);
                notification.setRead(query.getInt(columnIndexOrThrow4) != 0);
                if (query.isNull(columnIndexOrThrow5)) {
                    str3 = null;
                } else {
                    str3 = query.getString(columnIndexOrThrow5);
                }
                notification.setCategory(str3);
                if (query.isNull(columnIndexOrThrow6)) {
                    str4 = null;
                } else {
                    str4 = query.getString(columnIndexOrThrow6);
                }
                notification.setSubCategory(str4);
                if (query.isNull(columnIndexOrThrow7)) {
                    str5 = null;
                } else {
                    str5 = query.getString(columnIndexOrThrow7);
                }
                notification.setTitle(str5);
                if (query.isNull(columnIndexOrThrow8)) {
                    str6 = null;
                } else {
                    str6 = query.getString(columnIndexOrThrow8);
                }
                notification.setBody(str6);
                notification.setIsSoftDeleted(query.getInt(columnIndexOrThrow9) != 0);
                arrayList.add(notification);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public List<Notification> getNotificationEntityInDescendingOrderByCount(int i, int i2) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM Notification where _ID <=? ORDER BY _ID DESC LIMIT ?", 2);
        acquire.bindLong(1, (long) i);
        acquire.bindLong(2, (long) i2);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = CompoundButtonCompat.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CompoundButtonCompat.getColumnIndexOrThrow(query, "_ID");
            int columnIndexOrThrow2 = CompoundButtonCompat.getColumnIndexOrThrow(query, "notification_data");
            int columnIndexOrThrow3 = CompoundButtonCompat.getColumnIndexOrThrow(query, "recieved_time");
            int columnIndexOrThrow4 = CompoundButtonCompat.getColumnIndexOrThrow(query, "read");
            int columnIndexOrThrow5 = CompoundButtonCompat.getColumnIndexOrThrow(query, "category");
            int columnIndexOrThrow6 = CompoundButtonCompat.getColumnIndexOrThrow(query, "subCategory");
            int columnIndexOrThrow7 = CompoundButtonCompat.getColumnIndexOrThrow(query, "Title");
            int columnIndexOrThrow8 = CompoundButtonCompat.getColumnIndexOrThrow(query, "Body");
            int columnIndexOrThrow9 = CompoundButtonCompat.getColumnIndexOrThrow(query, "isSoftDeleted");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                Notification notification = new Notification();
                notification.index = query.getLong(columnIndexOrThrow);
                if (query.isNull(columnIndexOrThrow2)) {
                    str = null;
                } else {
                    str = query.getString(columnIndexOrThrow2);
                }
                notification.setNotificationData(str);
                if (query.isNull(columnIndexOrThrow3)) {
                    str2 = null;
                } else {
                    str2 = query.getString(columnIndexOrThrow3);
                }
                notification.setRecievedTime(str2);
                notification.setRead(query.getInt(columnIndexOrThrow4) != 0);
                if (query.isNull(columnIndexOrThrow5)) {
                    str3 = null;
                } else {
                    str3 = query.getString(columnIndexOrThrow5);
                }
                notification.setCategory(str3);
                if (query.isNull(columnIndexOrThrow6)) {
                    str4 = null;
                } else {
                    str4 = query.getString(columnIndexOrThrow6);
                }
                notification.setSubCategory(str4);
                if (query.isNull(columnIndexOrThrow7)) {
                    str5 = null;
                } else {
                    str5 = query.getString(columnIndexOrThrow7);
                }
                notification.setTitle(str5);
                if (query.isNull(columnIndexOrThrow8)) {
                    str6 = null;
                } else {
                    str6 = query.getString(columnIndexOrThrow8);
                }
                notification.setBody(str6);
                notification.setIsSoftDeleted(query.getInt(columnIndexOrThrow9) != 0);
                arrayList.add(notification);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public List<Notification> getSingleNOtificationDataEvent(int i) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM Notification where _ID ==?", 1);
        acquire.bindLong(1, (long) i);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = CompoundButtonCompat.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CompoundButtonCompat.getColumnIndexOrThrow(query, "_ID");
            int columnIndexOrThrow2 = CompoundButtonCompat.getColumnIndexOrThrow(query, "notification_data");
            int columnIndexOrThrow3 = CompoundButtonCompat.getColumnIndexOrThrow(query, "recieved_time");
            int columnIndexOrThrow4 = CompoundButtonCompat.getColumnIndexOrThrow(query, "read");
            int columnIndexOrThrow5 = CompoundButtonCompat.getColumnIndexOrThrow(query, "category");
            int columnIndexOrThrow6 = CompoundButtonCompat.getColumnIndexOrThrow(query, "subCategory");
            int columnIndexOrThrow7 = CompoundButtonCompat.getColumnIndexOrThrow(query, "Title");
            int columnIndexOrThrow8 = CompoundButtonCompat.getColumnIndexOrThrow(query, "Body");
            int columnIndexOrThrow9 = CompoundButtonCompat.getColumnIndexOrThrow(query, "isSoftDeleted");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                Notification notification = new Notification();
                notification.index = query.getLong(columnIndexOrThrow);
                if (query.isNull(columnIndexOrThrow2)) {
                    str = null;
                } else {
                    str = query.getString(columnIndexOrThrow2);
                }
                notification.setNotificationData(str);
                if (query.isNull(columnIndexOrThrow3)) {
                    str2 = null;
                } else {
                    str2 = query.getString(columnIndexOrThrow3);
                }
                notification.setRecievedTime(str2);
                notification.setRead(query.getInt(columnIndexOrThrow4) != 0);
                if (query.isNull(columnIndexOrThrow5)) {
                    str3 = null;
                } else {
                    str3 = query.getString(columnIndexOrThrow5);
                }
                notification.setCategory(str3);
                if (query.isNull(columnIndexOrThrow6)) {
                    str4 = null;
                } else {
                    str4 = query.getString(columnIndexOrThrow6);
                }
                notification.setSubCategory(str4);
                if (query.isNull(columnIndexOrThrow7)) {
                    str5 = null;
                } else {
                    str5 = query.getString(columnIndexOrThrow7);
                }
                notification.setTitle(str5);
                if (query.isNull(columnIndexOrThrow8)) {
                    str6 = null;
                } else {
                    str6 = query.getString(columnIndexOrThrow8);
                }
                notification.setBody(str6);
                notification.setIsSoftDeleted(query.getInt(columnIndexOrThrow9) != 0);
                arrayList.add(notification);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public int getTotalElementINDB() {
        int i = 0;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM notification", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = CompoundButtonCompat.query(this.__db, acquire, false, null);
        try {
            if (query.moveToFirst()) {
                i = query.getInt(0);
            }
            return i;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public void update(boolean z, int i) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfUpdate.acquire();
        acquire.bindLong(1, z ? 1 : 0);
        acquire.bindLong(2, (long) i);
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfUpdate.release(acquire);
        }
    }
}
