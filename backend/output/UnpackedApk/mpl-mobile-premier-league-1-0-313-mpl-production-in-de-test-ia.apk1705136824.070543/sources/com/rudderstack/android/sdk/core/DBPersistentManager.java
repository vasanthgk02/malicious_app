package com.rudderstack.android.sdk.core;

import android.app.Application;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.net.Uri;
import android.os.Message;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Queue;

public class DBPersistentManager {
    public static DBPersistentManager instance;
    public Application application;
    public DBInsertionHandlerThread dbInsertionHandlerThread;
    public final Queue<Message> queue = new LinkedList();

    public DBPersistentManager(final Application application2) {
        this.application = application2;
        new Thread(new Runnable() {
            public void run() {
                try {
                    synchronized (this) {
                        DBPersistentManager.this.dbInsertionHandlerThread = new DBInsertionHandlerThread("db_insertion_thread", application2);
                        DBPersistentManager.this.dbInsertionHandlerThread.start();
                        for (Message addMessage : DBPersistentManager.this.queue) {
                            DBPersistentManager.this.dbInsertionHandlerThread.addMessage(addMessage);
                        }
                    }
                } catch (SQLiteDatabaseCorruptException e2) {
                    RudderLogger.logError((Exception) e2);
                }
            }
        }).start();
    }

    public static DBPersistentManager getInstance(Application application2) {
        if (instance == null) {
            RudderLogger.logInfo("DBPersistentManager: getInstance: creating instance");
            instance = new DBPersistentManager(application2);
        }
        return instance;
    }

    public static String getUri(Context context) {
        return context.getApplicationContext().getPackageName() + "." + EventContentProvider.class.getSimpleName();
    }

    public static void initializeUri(Context context) {
        if (EventContentProvider.authority == null) {
            EventContentProvider.authority = context.getApplicationContext().getPackageName() + "." + EventContentProvider.class.getSimpleName();
        }
    }

    public void clearEventFromDB(int i) {
        RudderLogger.logInfo(String.format(Locale.US, "DBPersistentManager: clearEventFromDB: Deleting event with messageID: %d", new Object[]{Integer.valueOf(i)}));
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(i));
        clearEventsFromDB(arrayList);
    }

    public void clearEventsFromDB(List<Integer> list) {
        try {
            RudderLogger.logInfo(String.format(Locale.US, "DBPersistentManager: clearEventsFromDB: Clearing %d messages from DB", new Object[]{Integer.valueOf(list.size())}));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i));
                sb.append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            initializeUri(this.application);
            int delete = this.application.getContentResolver().delete(EventContentProvider.getContentUri(getUri(this.application)), String.format("id IN (%s)", new Object[]{sb.toString()}), null);
            RudderLogger.logInfo("DBPersistentManager: clearEventsFromDB: Messages deleted from DB " + delete);
        } catch (SQLiteDatabaseCorruptException e2) {
            RudderLogger.logError((Exception) e2);
        }
    }

    public void deleteAllEvents() {
        try {
            initializeUri(this.application);
            this.application.getContentResolver().delete(EventContentProvider.getContentUri(getUri(this.application)), null, null);
            RudderLogger.logInfo("DBPersistentManager: deleteAllEvents: deleted all events");
        } catch (SQLiteDatabaseCorruptException e2) {
            RudderLogger.logError((Exception) e2);
        }
    }

    public void fetchAllEventsFromDB(List<Integer> list, List<String> list2) {
        getEventsFromDB(list, list2, null);
    }

    public void fetchEventsFromDB(ArrayList<Integer> arrayList, ArrayList<String> arrayList2, int i) {
        getEventsFromDB(arrayList, arrayList2, Integer.valueOf(i));
    }

    public void flushEvents() {
        try {
            initializeUri(this.application);
            this.application.getContentResolver().delete(EventContentProvider.getContentUri(getUri(this.application)), null, null);
            RudderLogger.logInfo("DBPersistentManager: flushEvents: Messages deleted from DB");
        } catch (SQLiteDatabaseCorruptException e2) {
            RudderLogger.logError((Exception) e2);
        }
    }

    public int getDBRecordCount() {
        int i = -1;
        try {
            initializeUri(this.application);
            Cursor query = this.application.getContentResolver().query(EventContentProvider.getContentUri(getUri(this.application)), new String[]{"count(*) AS count"}, null, null, null);
            if (query.moveToFirst()) {
                RudderLogger.logInfo("DBPersistentManager: getDBRecordCount: fetched count from DB");
                while (!query.isAfterLast()) {
                    i = query.getInt(0);
                    query.moveToNext();
                }
            } else {
                RudderLogger.logInfo("DBPersistentManager: getDBRecordCount: DB is empty");
            }
            query.close();
        } catch (SQLiteDatabaseCorruptException e2) {
            RudderLogger.logError((Exception) e2);
        }
        return i;
    }

    public void getEventsFromDB(List<Integer> list, List<String> list2, Integer num) {
        if (!list.isEmpty()) {
            list.clear();
        }
        if (!list2.isEmpty()) {
            list2.clear();
        }
        try {
            Uri contentUri = EventContentProvider.getContentUri(getUri(this.application));
            if (num != null) {
                contentUri = contentUri.buildUpon().appendQueryParameter(EventContentProvider.QUERY_PARAMETER_LIMIT, String.valueOf(num)).build();
            }
            Cursor query = this.application.getContentResolver().query(contentUri, null, null, null, "updated ASC");
            if (query.moveToFirst()) {
                RudderLogger.logInfo("DBPersistentManager: fetchEventsFromDB: fetched messages from DB");
                while (!query.isAfterLast()) {
                    int columnIndex = query.getColumnIndex("id");
                    int columnIndex2 = query.getColumnIndex("message");
                    if (columnIndex > -1) {
                        list.add(Integer.valueOf(query.getInt(columnIndex)));
                    }
                    if (columnIndex2 > -1) {
                        list2.add(query.getString(columnIndex2));
                    }
                    query.moveToNext();
                }
            } else {
                RudderLogger.logInfo("DBPersistentManager: fetchEventsFromDB: DB is empty");
            }
            query.close();
        } catch (SQLiteDatabaseCorruptException e2) {
            RudderLogger.logError((Exception) e2);
        }
    }

    public void saveEvent(String str) {
        try {
            new Message();
            Message obtain = Message.obtain();
            obtain.obj = str;
            if (this.dbInsertionHandlerThread == null) {
                this.queue.add(obtain);
                return;
            }
            synchronized (this) {
                this.dbInsertionHandlerThread.addMessage(obtain);
            }
        } catch (Exception e2) {
            RudderLogger.logError(e2.getCause());
        }
    }
}
