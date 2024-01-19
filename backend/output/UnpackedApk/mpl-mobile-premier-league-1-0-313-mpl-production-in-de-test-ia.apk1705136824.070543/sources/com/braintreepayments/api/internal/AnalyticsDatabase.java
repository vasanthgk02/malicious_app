package com.braintreepayments.api.internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.braintreepayments.api.interfaces.BraintreeResponseListener;
import com.facebook.react.bridge.ColorPropConverter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AnalyticsDatabase extends SQLiteOpenHelper {
    public final Set<AsyncTask> mTaskSet = new HashSet();

    public static class DatabaseTask extends AsyncTask<Void, Void, Void> {
        public Runnable mDatabaseAction;
        public BraintreeResponseListener<Void> mFinishedCallback;

        public DatabaseTask(Runnable runnable) {
            this.mDatabaseAction = runnable;
        }

        public Object doInBackground(Object[] objArr) {
            Void[] voidArr = (Void[]) objArr;
            this.mDatabaseAction.run();
            return null;
        }

        public void onPostExecute(Object obj) {
            Void voidR = (Void) obj;
            BraintreeResponseListener<Void> braintreeResponseListener = this.mFinishedCallback;
            if (braintreeResponseListener != null) {
                braintreeResponseListener.onResponse(null);
            }
        }
    }

    public AnalyticsDatabase(Context context, CursorFactory cursorFactory) {
        super(context, "braintree-analytics.db", null, 1);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table analytics(_id integer primary key autoincrement, event text not null, timestamp long not null, meta_json text not null);");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("drop table if exists analytics");
        sQLiteDatabase.execSQL("create table analytics(_id integer primary key autoincrement, event text not null, timestamp long not null, meta_json text not null);");
    }

    public final void queueTask(final DatabaseTask databaseTask) {
        databaseTask.mFinishedCallback = new BraintreeResponseListener<Void>() {
            public void onResponse(Object obj) {
                Void voidR = (Void) obj;
                synchronized (AnalyticsDatabase.this.mTaskSet) {
                    AnalyticsDatabase.this.mTaskSet.remove(databaseTask);
                }
            }
        };
        synchronized (this.mTaskSet) {
            this.mTaskSet.add(databaseTask);
        }
        databaseTask.execute(new Void[0]);
    }

    public void removeEvents(List<AnalyticsEvent> list) {
        final StringBuilder outline77 = GeneratedOutlineSupport.outline77("_id", " in (");
        final String[] strArr = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            strArr[i] = Integer.toString(list.get(i).id);
            outline77.append(ColorPropConverter.PREFIX_ATTR);
            if (i < list.size() - 1) {
                outline77.append(",");
            } else {
                outline77.append(")");
            }
        }
        queueTask(new DatabaseTask(new Runnable() {
            public void run() {
                SQLiteDatabase sQLiteDatabase = null;
                try {
                    sQLiteDatabase = AnalyticsDatabase.this.getWritableDatabase();
                    sQLiteDatabase.delete("analytics", outline77.toString(), strArr);
                } catch (SQLiteException unused) {
                    if (sQLiteDatabase == null) {
                        return;
                    }
                } catch (Throwable th) {
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    throw th;
                }
                sQLiteDatabase.close();
            }
        }));
    }
}
