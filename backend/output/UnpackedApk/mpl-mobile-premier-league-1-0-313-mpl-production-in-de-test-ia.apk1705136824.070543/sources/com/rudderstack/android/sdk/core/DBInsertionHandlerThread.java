package com.rudderstack.android.sdk.core;

import android.content.ContentValues;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* compiled from: DBPersistentManager */
public class DBInsertionHandlerThread extends HandlerThread {
    public Context context;
    public DBInsertionHandler dbInsertionHandler;

    /* compiled from: DBPersistentManager */
    public class DBInsertionHandler extends Handler {
        public Context context;

        public DBInsertionHandler(Looper looper, Context context2) {
            super(looper);
            this.context = context2;
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            long currentTimeMillis = System.currentTimeMillis();
            ContentValues contentValues = new ContentValues();
            contentValues.put("message", ((String) message.obj).replaceAll("'", "\\\\'"));
            contentValues.put(EventsDbHelper.UPDATED, Long.valueOf(currentTimeMillis));
            DBPersistentManager.initializeUri(this.context);
            this.context.getContentResolver().insert(EventContentProvider.getContentUri(DBPersistentManager.getUri(this.context)), contentValues);
            RudderLogger.logInfo("DBPersistentManager: saveEvent: Event saved to DB");
        }
    }

    public DBInsertionHandlerThread(String str, Context context2) {
        super(str);
        this.context = context2;
    }

    public void addMessage(Message message) {
        if (this.dbInsertionHandler == null) {
            this.dbInsertionHandler = new DBInsertionHandler(getLooper(), this.context);
        }
        this.dbInsertionHandler.sendMessage(message);
    }
}
