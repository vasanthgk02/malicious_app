package com.reactnativecommunity.asyncstorage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ReactDatabaseSupplier extends SQLiteOpenHelper {
    public static ReactDatabaseSupplier sReactDatabaseSupplierInstance;
    public Context mContext;
    public SQLiteDatabase mDb;
    public long mMaximumDatabaseSize = ((BuildConfig.AsyncStorage_db_size.longValue() * 1024) * 1024);

    public ReactDatabaseSupplier(Context context) {
        super(context, "RKStorage", null, 1);
        this.mContext = context;
    }

    public synchronized void clear() {
        get().delete("catalystLocalStorage", null, null);
    }

    public final synchronized void closeDatabase() {
        if (this.mDb != null && this.mDb.isOpen()) {
            this.mDb.close();
            this.mDb = null;
        }
    }

    public final synchronized boolean deleteDatabase() {
        try {
            closeDatabase();
        }
        return this.mContext.deleteDatabase("RKStorage");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:15|16|17|18|19|20|34|21) */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x002f, code lost:
        continue;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0028 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean ensureDatabase() {
        /*
            r5 = this;
            monitor-enter(r5)
            android.database.sqlite.SQLiteDatabase r0 = r5.mDb     // Catch:{ all -> 0x0040 }
            r1 = 1
            if (r0 == 0) goto L_0x0010
            android.database.sqlite.SQLiteDatabase r0 = r5.mDb     // Catch:{ all -> 0x0040 }
            boolean r0 = r0.isOpen()     // Catch:{ all -> 0x0040 }
            if (r0 == 0) goto L_0x0010
            monitor-exit(r5)
            return r1
        L_0x0010:
            r0 = 0
            r2 = 0
        L_0x0012:
            r3 = 2
            if (r2 >= r3) goto L_0x0032
            if (r2 <= 0) goto L_0x001a
            r5.deleteDatabase()     // Catch:{ SQLiteException -> 0x0021 }
        L_0x001a:
            android.database.sqlite.SQLiteDatabase r3 = r5.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0021 }
            r5.mDb = r3     // Catch:{ SQLiteException -> 0x0021 }
            goto L_0x0032
        L_0x0021:
            r0 = move-exception
            r3 = 30
            java.lang.Thread.sleep(r3)     // Catch:{ InterruptedException -> 0x0028 }
            goto L_0x002f
        L_0x0028:
            java.lang.Thread r3 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0040 }
            r3.interrupt()     // Catch:{ all -> 0x0040 }
        L_0x002f:
            int r2 = r2 + 1
            goto L_0x0012
        L_0x0032:
            android.database.sqlite.SQLiteDatabase r2 = r5.mDb     // Catch:{ all -> 0x0040 }
            if (r2 == 0) goto L_0x003f
            android.database.sqlite.SQLiteDatabase r0 = r5.mDb     // Catch:{ all -> 0x0040 }
            long r2 = r5.mMaximumDatabaseSize     // Catch:{ all -> 0x0040 }
            r0.setMaximumSize(r2)     // Catch:{ all -> 0x0040 }
            monitor-exit(r5)
            return r1
        L_0x003f:
            throw r0     // Catch:{ all -> 0x0040 }
        L_0x0040:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativecommunity.asyncstorage.ReactDatabaseSupplier.ensureDatabase():boolean");
    }

    public synchronized SQLiteDatabase get() {
        try {
            ensureDatabase();
        }
        return this.mDb;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE catalystLocalStorage (key TEXT PRIMARY KEY, value TEXT NOT NULL)");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i != i2) {
            deleteDatabase();
            onCreate(sQLiteDatabase);
        }
    }
}
