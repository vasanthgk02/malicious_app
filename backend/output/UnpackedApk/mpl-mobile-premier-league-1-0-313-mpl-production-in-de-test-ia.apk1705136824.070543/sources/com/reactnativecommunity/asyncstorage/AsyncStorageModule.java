package com.reactnativecommunity.asyncstorage;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.AsyncTask;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.google.android.material.resources.TextAppearanceConfig;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Executor;

@ReactModule(name = "RNC_AsyncSQLiteDBStorage")
public final class AsyncStorageModule extends ReactContextBaseJavaModule {
    public static final int MAX_SQL_KEYS = 999;
    public static final String NAME = "RNC_AsyncSQLiteDBStorage";
    public final SerialExecutor executor;
    public ReactDatabaseSupplier mReactDatabaseSupplier;
    public boolean mShuttingDown;

    public class SerialExecutor implements Executor {
        public final Executor executor;
        public Runnable mActive;
        public final ArrayDeque<Runnable> mTasks = new ArrayDeque<>();

        public SerialExecutor(AsyncStorageModule asyncStorageModule, Executor executor2) {
            this.executor = executor2;
        }

        public synchronized void execute(final Runnable runnable) {
            this.mTasks.offer(new Runnable() {
                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        SerialExecutor.this.scheduleNext();
                    }
                }
            });
            if (this.mActive == null) {
                scheduleNext();
            }
        }

        public synchronized void scheduleNext() {
            Runnable poll = this.mTasks.poll();
            this.mActive = poll;
            if (poll != null) {
                this.executor.execute(poll);
            }
        }
    }

    public AsyncStorageModule(ReactApplicationContext reactApplicationContext) {
        this(reactApplicationContext, AsyncTask.THREAD_POOL_EXECUTOR);
    }

    /* access modifiers changed from: private */
    public boolean ensureDatabase() {
        if (this.mShuttingDown) {
            return false;
        }
        this.mReactDatabaseSupplier.ensureDatabase();
        return true;
    }

    @ReactMethod
    public void clear(final Callback callback) {
        new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) {
            public void doInBackgroundGuarded(Object[] objArr) {
                Void[] voidArr = (Void[]) objArr;
                try {
                    AsyncStorageModule.this.mReactDatabaseSupplier.ensureDatabase();
                    try {
                        AsyncStorageModule.this.mReactDatabaseSupplier.clear();
                        callback.invoke(new Object[0]);
                    } catch (Exception e2) {
                        FLog.w((String) "ReactNative", e2.getMessage(), (Throwable) e2);
                        callback.invoke(TextAppearanceConfig.getError(null, e2.getMessage()));
                    }
                } catch (Exception unused) {
                }
            }
        }.executeOnExecutor(this.executor, new Void[0]);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002a, code lost:
        throw new java.lang.RuntimeException("Clearing and deleting database RKStorage failed");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0018, code lost:
        if (r0.deleteDatabase() != false) goto L_0x001a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
        com.facebook.common.logging.FLog.d("ReactNative", "Deleted Local Database RKStorage");
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0014 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void clearSensitiveData() {
        /*
            r3 = this;
            com.reactnativecommunity.asyncstorage.ReactDatabaseSupplier r0 = r3.mReactDatabaseSupplier
            monitor-enter(r0)
            r0.clear()     // Catch:{ Exception -> 0x0014 }
            r0.closeDatabase()     // Catch:{ Exception -> 0x0014 }
            java.lang.String r1 = "ReactNative"
            java.lang.String r2 = "Cleaned RKStorage"
            com.facebook.common.logging.FLog.d(r1, r2)     // Catch:{ Exception -> 0x0014 }
            monitor-exit(r0)
            goto L_0x0022
        L_0x0012:
            r1 = move-exception
            goto L_0x002b
        L_0x0014:
            boolean r1 = r0.deleteDatabase()     // Catch:{ all -> 0x0012 }
            if (r1 == 0) goto L_0x0023
            java.lang.String r1 = "ReactNative"
            java.lang.String r2 = "Deleted Local Database RKStorage"
            com.facebook.common.logging.FLog.d(r1, r2)     // Catch:{ all -> 0x0012 }
            monitor-exit(r0)
        L_0x0022:
            return
        L_0x0023:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ all -> 0x0012 }
            java.lang.String r2 = "Clearing and deleting database RKStorage failed"
            r1.<init>(r2)     // Catch:{ all -> 0x0012 }
            throw r1     // Catch:{ all -> 0x0012 }
        L_0x002b:
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativecommunity.asyncstorage.AsyncStorageModule.clearSensitiveData():void");
    }

    @ReactMethod
    public void getAllKeys(final Callback callback) {
        new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) {
            public void doInBackgroundGuarded(Object[] objArr) {
                Cursor query;
                Void[] voidArr = (Void[]) objArr;
                try {
                    if (!AsyncStorageModule.this.ensureDatabase()) {
                        callback.invoke(TextAppearanceConfig.getDBError(null), null);
                        return;
                    }
                    WritableArray createArray = Arguments.createArray();
                    query = AsyncStorageModule.this.mReactDatabaseSupplier.get().query("catalystLocalStorage", new String[]{"key"}, null, null, null, null, null);
                    try {
                        if (query.moveToFirst()) {
                            do {
                                createArray.pushString(query.getString(0));
                            } while (query.moveToNext());
                        }
                        query.close();
                        callback.invoke(null, createArray);
                    } catch (Exception e2) {
                        FLog.w((String) "ReactNative", e2.getMessage(), (Throwable) e2);
                        callback.invoke(TextAppearanceConfig.getError(null, e2.getMessage()), null);
                        query.close();
                    }
                } catch (Exception unused) {
                } catch (Throwable th) {
                    query.close();
                    throw th;
                }
            }
        }.executeOnExecutor(this.executor, new Void[0]);
    }

    public String getName() {
        return NAME;
    }

    public void initialize() {
        super.initialize();
        this.mShuttingDown = false;
    }

    @ReactMethod
    public void multiGet(final ReadableArray readableArray, final Callback callback) {
        if (readableArray == null) {
            callback.invoke(TextAppearanceConfig.getInvalidKeyError(null), null);
            return;
        }
        new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) {
            public void doInBackgroundGuarded(Object[] objArr) {
                Cursor query;
                Void[] voidArr = (Void[]) objArr;
                try {
                    if (!AsyncStorageModule.this.ensureDatabase()) {
                        callback.invoke(TextAppearanceConfig.getDBError(null), null);
                        return;
                    }
                    String[] strArr = {"key", HSLCriteriaBuilder.VALUE};
                    HashSet hashSet = new HashSet();
                    WritableArray createArray = Arguments.createArray();
                    int i = 0;
                    while (i < readableArray.size()) {
                        int min = Math.min(readableArray.size() - i, 999);
                        SQLiteDatabase sQLiteDatabase = AsyncStorageModule.this.mReactDatabaseSupplier.get();
                        String buildKeySelection = TextAppearanceConfig.buildKeySelection(min);
                        ReadableArray readableArray = readableArray;
                        String[] strArr2 = new String[min];
                        for (int i2 = 0; i2 < min; i2++) {
                            strArr2[i2] = readableArray.getString(i + i2);
                        }
                        int i3 = min;
                        int i4 = i;
                        query = sQLiteDatabase.query("catalystLocalStorage", strArr, buildKeySelection, strArr2, null, null, null);
                        hashSet.clear();
                        try {
                            if (query.getCount() != readableArray.size()) {
                                for (int i5 = i4; i5 < i4 + i3; i5++) {
                                    hashSet.add(readableArray.getString(i5));
                                }
                            }
                            if (query.moveToFirst()) {
                                do {
                                    WritableArray createArray2 = Arguments.createArray();
                                    createArray2.pushString(query.getString(0));
                                    createArray2.pushString(query.getString(1));
                                    createArray.pushArray(createArray2);
                                    hashSet.remove(query.getString(0));
                                } while (query.moveToNext());
                            }
                            query.close();
                            Iterator it = hashSet.iterator();
                            while (it.hasNext()) {
                                WritableArray createArray3 = Arguments.createArray();
                                createArray3.pushString((String) it.next());
                                createArray3.pushNull();
                                createArray.pushArray(createArray3);
                            }
                            hashSet.clear();
                            i = i4 + 999;
                        } catch (Exception e2) {
                            FLog.w((String) "ReactNative", e2.getMessage(), (Throwable) e2);
                            callback.invoke(TextAppearanceConfig.getError(null, e2.getMessage()), null);
                            query.close();
                            return;
                        }
                    }
                    callback.invoke(null, createArray);
                } catch (Exception unused) {
                } catch (Throwable th) {
                    query.close();
                    throw th;
                }
            }
        }.executeOnExecutor(this.executor, new Void[0]);
    }

    @ReactMethod
    public void multiMerge(final ReadableArray readableArray, final Callback callback) {
        new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) {
            public void doInBackgroundGuarded(Object[] objArr) {
                Void[] voidArr = (Void[]) objArr;
                try {
                    WritableMap writableMap = null;
                    if (!AsyncStorageModule.this.ensureDatabase()) {
                        callback.invoke(TextAppearanceConfig.getDBError(null));
                        return;
                    }
                    try {
                        AsyncStorageModule.this.mReactDatabaseSupplier.get().beginTransaction();
                        int i = 0;
                        while (i < readableArray.size()) {
                            if (readableArray.getArray(i).size() != 2) {
                                TextAppearanceConfig.getInvalidValueError(null);
                                try {
                                    AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                                    return;
                                } catch (Exception e2) {
                                    e = e2;
                                }
                            } else if (readableArray.getArray(i).getString(0) == null) {
                                TextAppearanceConfig.getInvalidKeyError(null);
                                try {
                                    AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                                    return;
                                } catch (Exception e3) {
                                    e = e3;
                                }
                            } else if (readableArray.getArray(i).getString(1) == null) {
                                TextAppearanceConfig.getInvalidValueError(null);
                                try {
                                    AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                                    return;
                                } catch (Exception e4) {
                                    e = e4;
                                }
                            } else if (!TextAppearanceConfig.mergeImpl(AsyncStorageModule.this.mReactDatabaseSupplier.get(), readableArray.getArray(i).getString(0), readableArray.getArray(i).getString(1))) {
                                TextAppearanceConfig.getDBError(null);
                                try {
                                    AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                                    return;
                                } catch (Exception e5) {
                                    e = e5;
                                }
                            } else {
                                i++;
                            }
                        }
                        AsyncStorageModule.this.mReactDatabaseSupplier.get().setTransactionSuccessful();
                        try {
                            AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                        } catch (Exception e6) {
                            FLog.w((String) "ReactNative", e6.getMessage(), (Throwable) e6);
                            writableMap = TextAppearanceConfig.getError(null, e6.getMessage());
                        }
                    } catch (Exception e7) {
                        FLog.w((String) "ReactNative", e7.getMessage(), (Throwable) e7);
                        writableMap = TextAppearanceConfig.getError(null, e7.getMessage());
                        try {
                            AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                        } catch (Exception e8) {
                            FLog.w((String) "ReactNative", e8.getMessage(), (Throwable) e8);
                        }
                    }
                    if (writableMap != null) {
                        callback.invoke(writableMap);
                        return;
                    }
                    callback.invoke(new Object[0]);
                    return;
                    FLog.w((String) "ReactNative", e.getMessage(), (Throwable) e);
                } catch (Exception unused) {
                } catch (Throwable th) {
                    try {
                        AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                    } catch (Exception e9) {
                        FLog.w((String) "ReactNative", e9.getMessage(), (Throwable) e9);
                        TextAppearanceConfig.getError(null, e9.getMessage());
                    }
                    throw th;
                }
            }
        }.executeOnExecutor(this.executor, new Void[0]);
    }

    @ReactMethod
    public void multiRemove(final ReadableArray readableArray, final Callback callback) {
        if (readableArray.size() == 0) {
            callback.invoke(new Object[0]);
        } else {
            new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) {
                public void doInBackgroundGuarded(Object[] objArr) {
                    Void[] voidArr = (Void[]) objArr;
                    try {
                        WritableMap writableMap = null;
                        if (!AsyncStorageModule.this.ensureDatabase()) {
                            callback.invoke(TextAppearanceConfig.getDBError(null));
                            return;
                        }
                        try {
                            AsyncStorageModule.this.mReactDatabaseSupplier.get().beginTransaction();
                            for (int i = 0; i < readableArray.size(); i += 999) {
                                int min = Math.min(readableArray.size() - i, 999);
                                SQLiteDatabase sQLiteDatabase = AsyncStorageModule.this.mReactDatabaseSupplier.get();
                                String buildKeySelection = TextAppearanceConfig.buildKeySelection(min);
                                ReadableArray readableArray = readableArray;
                                String[] strArr = new String[min];
                                for (int i2 = 0; i2 < min; i2++) {
                                    strArr[i2] = readableArray.getString(i + i2);
                                }
                                sQLiteDatabase.delete("catalystLocalStorage", buildKeySelection, strArr);
                            }
                            AsyncStorageModule.this.mReactDatabaseSupplier.get().setTransactionSuccessful();
                            try {
                                AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                            } catch (Exception e2) {
                                FLog.w((String) "ReactNative", e2.getMessage(), (Throwable) e2);
                                writableMap = TextAppearanceConfig.getError(null, e2.getMessage());
                            }
                        } catch (Exception e3) {
                            FLog.w((String) "ReactNative", e3.getMessage(), (Throwable) e3);
                            writableMap = TextAppearanceConfig.getError(null, e3.getMessage());
                            try {
                                AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                            } catch (Exception e4) {
                                FLog.w((String) "ReactNative", e4.getMessage(), (Throwable) e4);
                            }
                        }
                        if (writableMap != null) {
                            callback.invoke(writableMap);
                            return;
                        }
                        callback.invoke(new Object[0]);
                    } catch (Exception unused) {
                    } catch (Throwable th) {
                        try {
                            AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                        } catch (Exception e5) {
                            FLog.w((String) "ReactNative", e5.getMessage(), (Throwable) e5);
                            TextAppearanceConfig.getError(null, e5.getMessage());
                        }
                        throw th;
                    }
                }
            }.executeOnExecutor(this.executor, new Void[0]);
        }
    }

    @ReactMethod
    public void multiSet(final ReadableArray readableArray, final Callback callback) {
        if (readableArray.size() == 0) {
            callback.invoke(new Object[0]);
        } else {
            new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) {
                public void doInBackgroundGuarded(Object[] objArr) {
                    Void[] voidArr = (Void[]) objArr;
                    try {
                        WritableMap writableMap = null;
                        if (!AsyncStorageModule.this.ensureDatabase()) {
                            callback.invoke(TextAppearanceConfig.getDBError(null));
                            return;
                        }
                        SQLiteStatement compileStatement = AsyncStorageModule.this.mReactDatabaseSupplier.get().compileStatement("INSERT OR REPLACE INTO catalystLocalStorage VALUES (?, ?);");
                        try {
                            AsyncStorageModule.this.mReactDatabaseSupplier.get().beginTransaction();
                            int i = 0;
                            while (i < readableArray.size()) {
                                if (readableArray.getArray(i).size() != 2) {
                                    TextAppearanceConfig.getInvalidValueError(null);
                                    try {
                                        AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                                        return;
                                    } catch (Exception e2) {
                                        e = e2;
                                    }
                                } else if (readableArray.getArray(i).getString(0) == null) {
                                    TextAppearanceConfig.getInvalidKeyError(null);
                                    try {
                                        AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                                        return;
                                    } catch (Exception e3) {
                                        e = e3;
                                    }
                                } else if (readableArray.getArray(i).getString(1) == null) {
                                    TextAppearanceConfig.getInvalidValueError(null);
                                    try {
                                        AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                                        return;
                                    } catch (Exception e4) {
                                        e = e4;
                                    }
                                } else {
                                    compileStatement.clearBindings();
                                    compileStatement.bindString(1, readableArray.getArray(i).getString(0));
                                    compileStatement.bindString(2, readableArray.getArray(i).getString(1));
                                    compileStatement.execute();
                                    i++;
                                }
                            }
                            AsyncStorageModule.this.mReactDatabaseSupplier.get().setTransactionSuccessful();
                            try {
                                AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                            } catch (Exception e5) {
                                FLog.w((String) "ReactNative", e5.getMessage(), (Throwable) e5);
                                writableMap = TextAppearanceConfig.getError(null, e5.getMessage());
                            }
                        } catch (Exception e6) {
                            FLog.w((String) "ReactNative", e6.getMessage(), (Throwable) e6);
                            writableMap = TextAppearanceConfig.getError(null, e6.getMessage());
                            try {
                                AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                            } catch (Exception e7) {
                                FLog.w((String) "ReactNative", e7.getMessage(), (Throwable) e7);
                            }
                        }
                        if (writableMap != null) {
                            callback.invoke(writableMap);
                            return;
                        }
                        callback.invoke(new Object[0]);
                        return;
                        FLog.w((String) "ReactNative", e.getMessage(), (Throwable) e);
                    } catch (Exception unused) {
                    } catch (Throwable th) {
                        try {
                            AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                        } catch (Exception e8) {
                            FLog.w((String) "ReactNative", e8.getMessage(), (Throwable) e8);
                            TextAppearanceConfig.getError(null, e8.getMessage());
                        }
                        throw th;
                    }
                }
            }.executeOnExecutor(this.executor, new Void[0]);
        }
    }

    public void onCatalystInstanceDestroy() {
        this.mShuttingDown = true;
    }

    public AsyncStorageModule(ReactApplicationContext reactApplicationContext, Executor executor2) {
        super(reactApplicationContext);
        this.mShuttingDown = false;
        this.executor = new SerialExecutor(this, executor2);
        if (ReactDatabaseSupplier.sReactDatabaseSupplierInstance == null) {
            ReactDatabaseSupplier.sReactDatabaseSupplierInstance = new ReactDatabaseSupplier(reactApplicationContext.getApplicationContext());
        }
        this.mReactDatabaseSupplier = ReactDatabaseSupplier.sReactDatabaseSupplierInstance;
    }
}
