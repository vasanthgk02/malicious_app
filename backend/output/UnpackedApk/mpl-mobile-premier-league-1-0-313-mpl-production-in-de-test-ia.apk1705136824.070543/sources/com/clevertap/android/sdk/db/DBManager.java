package com.clevertap.android.sdk.db;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import co.hyperverge.hypersnapsdk.c.k;
import com.clevertap.android.sdk.CTLockManager;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.db.DBAdapter.Table;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class DBManager extends BaseDatabaseManager {
    public final CleverTapInstanceConfig config;
    public final CTLockManager ctLockManager;
    public DBAdapter dbAdapter;

    public DBManager(CleverTapInstanceConfig cleverTapInstanceConfig, CTLockManager cTLockManager) {
        this.config = cleverTapInstanceConfig;
        this.ctLockManager = cTLockManager;
    }

    public void clearQueues(Context context) {
        synchronized (this.ctLockManager.eventLock) {
            DBAdapter loadDBAdapter = loadDBAdapter(context);
            loadDBAdapter.removeEvents(Table.EVENTS);
            loadDBAdapter.removeEvents(Table.PROFILE_EVENTS);
            Editor edit = k.getPreferences(context, "IJ").edit();
            edit.clear();
            k.persist(edit);
            k.putInt(context, k.storageKeyWithSuffix(this.config, "comms_first_ts"), 0);
            k.putInt(context, k.storageKeyWithSuffix(this.config, "comms_last_ts"), 0);
        }
    }

    public QueueCursor getQueueCursor(Context context, Table table, int i, QueueCursor queueCursor) {
        QueueCursor queueCursor2;
        synchronized (this.ctLockManager.eventLock) {
            DBAdapter loadDBAdapter = loadDBAdapter(context);
            if (queueCursor != null) {
                table = queueCursor.tableName;
            }
            if (queueCursor != null) {
                loadDBAdapter.cleanupEventsFromLastId(queueCursor.lastId, queueCursor.tableName);
            }
            queueCursor2 = new QueueCursor();
            queueCursor2.tableName = table;
            JSONObject fetchEvents = loadDBAdapter.fetchEvents(table, i);
            if (fetchEvents != null) {
                Iterator<String> keys = fetchEvents.keys();
                if (keys.hasNext()) {
                    String next = keys.next();
                    queueCursor2.lastId = next;
                    try {
                        queueCursor2.data = fetchEvents.getJSONArray(next);
                    } catch (JSONException unused) {
                        queueCursor2.lastId = null;
                        queueCursor2.data = null;
                    }
                }
            }
        }
        return queueCursor2;
    }

    public DBAdapter loadDBAdapter(Context context) {
        if (this.dbAdapter == null) {
            DBAdapter dBAdapter = new DBAdapter(context, this.config);
            this.dbAdapter = dBAdapter;
            dBAdapter.cleanupStaleEvents(Table.EVENTS);
            this.dbAdapter.cleanupStaleEvents(Table.PROFILE_EVENTS);
            this.dbAdapter.cleanupStaleEvents(Table.PUSH_NOTIFICATION_VIEWED);
            DBAdapter dBAdapter2 = this.dbAdapter;
            synchronized (dBAdapter2) {
                dBAdapter2.cleanInternal(Table.PUSH_NOTIFICATIONS, 0);
            }
        }
        return this.dbAdapter;
    }

    public final void queueEventInternal(Context context, JSONObject jSONObject, Table table) {
        synchronized (this.ctLockManager.eventLock) {
            if (loadDBAdapter(context).storeObject(jSONObject, table) > 0) {
                Logger logger = this.config.getLogger();
                String str = this.config.accountId;
                logger.debug(str, "Queued event: " + jSONObject.toString());
                Logger logger2 = this.config.getLogger();
                String str2 = this.config.accountId;
                logger2.verbose(str2, "Queued event to DB table " + table + ": " + jSONObject.toString());
            }
        }
    }
}
