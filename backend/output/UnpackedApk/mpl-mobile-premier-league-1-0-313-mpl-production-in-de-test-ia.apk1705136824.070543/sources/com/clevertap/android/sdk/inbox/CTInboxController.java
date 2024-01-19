package com.clevertap.android.sdk.inbox;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.clevertap.android.sdk.BaseCallbackManager;
import com.clevertap.android.sdk.CTLockManager;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.CleverTapAPI.LogLevel;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.db.DBAdapter;
import com.clevertap.android.sdk.db.DBAdapter.Table;
import com.clevertap.android.sdk.task.CTExecutorFactory;
import com.clevertap.android.sdk.task.FailureExecutable;
import com.clevertap.android.sdk.task.OnFailureListener;
import com.clevertap.android.sdk.task.OnSuccessListener;
import com.clevertap.android.sdk.task.SuccessExecutable;
import com.clevertap.android.sdk.task.Task;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public class CTInboxController {
    public final BaseCallbackManager callbackManager;
    public final CleverTapInstanceConfig config;
    public final CTLockManager ctLockManager;
    public final DBAdapter dbAdapter;
    public ArrayList<CTMessageDAO> messages;
    public final Object messagesLock = new Object();
    public final String userId;
    public final boolean videoSupported;

    public CTInboxController(CleverTapInstanceConfig cleverTapInstanceConfig, String str, DBAdapter dBAdapter, CTLockManager cTLockManager, BaseCallbackManager baseCallbackManager, boolean z) {
        this.userId = str;
        this.dbAdapter = dBAdapter;
        this.messages = dBAdapter.getMessages(str);
        this.videoSupported = z;
        this.ctLockManager = cTLockManager;
        this.callbackManager = baseCallbackManager;
        this.config = cleverTapInstanceConfig;
    }

    public static void lambda$_markReadForMessageWithId$1(String str, Exception exc) {
        int i = CleverTapAPI.debugLevel;
        LogLevel.INFO.intValue();
    }

    public boolean _deleteMessageWithId(final String str) {
        CTMessageDAO findMessageById = findMessageById(str);
        if (findMessageById == null) {
            return false;
        }
        synchronized (this.messagesLock) {
            this.messages.remove(findMessageById);
        }
        Task postAsyncSafelyTask = CTExecutorFactory.executors(this.config).postAsyncSafelyTask();
        postAsyncSafelyTask.executor.execute(new Runnable("RunDeleteMessage", new Callable<Void>() {
            public Object call() throws Exception {
                CTInboxController cTInboxController = CTInboxController.this;
                DBAdapter dBAdapter = cTInboxController.dbAdapter;
                String str = str;
                String str2 = cTInboxController.userId;
                synchronized (dBAdapter) {
                    if (str != null && str2 != null) {
                        String name = Table.INBOX_MESSAGES.getName();
                        try {
                            dBAdapter.dbHelper.getWritableDatabase().delete(name, "_id = ? AND messageUser = ?", new String[]{str, str2});
                            dBAdapter.dbHelper.close();
                        } catch (SQLiteException e2) {
                            try {
                                Logger configLogger = dBAdapter.getConfigLogger();
                                configLogger.verbose("Error removing stale records from " + name, (Throwable) e2);
                            } finally {
                                dBAdapter.dbHelper.close();
                            }
                        }
                    }
                }
                return null;
            }
        }) {
            public final /* synthetic */ Callable val$callable;
            public final /* synthetic */ String val$logTag;

            {
                this.val$logTag = r2;
                this.val$callable = r3;
            }

            public void run() {
                try {
                    Logger logger = Task.this.config.getLogger();
                    logger.verbose(Task.this.taskName + " Task: " + this.val$logTag + " starting on..." + Thread.currentThread().getName());
                    TResult call = this.val$callable.call();
                    Logger logger2 = Task.this.config.getLogger();
                    logger2.verbose(Task.this.taskName + " Task: " + this.val$logTag + " executed successfully on..." + Thread.currentThread().getName());
                    Task task = Task.this;
                    if (task != null) {
                        STATE state = STATE.SUCCESS;
                        task.result = call;
                        for (SuccessExecutable<TResult> execute : task.successExecutables) {
                            execute.execute(task.result);
                        }
                        return;
                    }
                    throw null;
                } catch (Exception e2) {
                    Task task2 = Task.this;
                    if (task2 != null) {
                        STATE state2 = STATE.FAILED;
                        for (FailureExecutable<Exception> execute2 : task2.failureExecutables) {
                            execute2.execute(e2);
                        }
                        Logger logger3 = Task.this.config.getLogger();
                        logger3.verbose(Task.this.taskName + " Task: " + this.val$logTag + " failed to execute on..." + Thread.currentThread().getName(), (Throwable) e2);
                        e2.printStackTrace();
                        return;
                    }
                    throw null;
                }
            }
        });
        return true;
    }

    public boolean _markReadForMessageWithId(final String str) {
        CTMessageDAO findMessageById = findMessageById(str);
        if (findMessageById == null) {
            return false;
        }
        synchronized (this.messagesLock) {
            findMessageById.read = true;
        }
        Task postAsyncSafelyTask = CTExecutorFactory.executors(this.config).postAsyncSafelyTask();
        $$Lambda$CTInboxController$dTyzBvDLdr2QHBLwAxYADcOOOpo r1 = new OnSuccessListener() {
            public final void onSuccess(Object obj) {
                CTInboxController.this.lambda$_markReadForMessageWithId$0$CTInboxController((Void) obj);
            }
        };
        postAsyncSafelyTask.successExecutables.add(new SuccessExecutable(postAsyncSafelyTask.defaultCallbackExecutor, r1));
        $$Lambda$CTInboxController$5D5pGzSJ6lkjDrjx19PFifzeZi4 r12 = new OnFailureListener(str) {
            public final /* synthetic */ String f$0;

            {
                this.f$0 = r1;
            }

            public final void onFailure(Object obj) {
                CTInboxController.lambda$_markReadForMessageWithId$1(this.f$0, (Exception) obj);
            }
        };
        Executor executor = postAsyncSafelyTask.defaultCallbackExecutor;
        synchronized (postAsyncSafelyTask) {
            postAsyncSafelyTask.failureExecutables.add(new FailureExecutable(executor, r12));
        }
        postAsyncSafelyTask.executor.execute(new Runnable("RunMarkMessageRead", new Callable<Void>() {
            public Object call() throws Exception {
                CTInboxController cTInboxController = CTInboxController.this;
                DBAdapter dBAdapter = cTInboxController.dbAdapter;
                String str = str;
                String str2 = cTInboxController.userId;
                synchronized (dBAdapter) {
                    if (str != null && str2 != null) {
                        String name = Table.INBOX_MESSAGES.getName();
                        try {
                            SQLiteDatabase writableDatabase = dBAdapter.dbHelper.getWritableDatabase();
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("isRead", Integer.valueOf(1));
                            writableDatabase.update(Table.INBOX_MESSAGES.getName(), contentValues, "_id = ? AND messageUser = ?", new String[]{str, str2});
                            dBAdapter.dbHelper.close();
                        } catch (SQLiteException e2) {
                            try {
                                Logger configLogger = dBAdapter.getConfigLogger();
                                configLogger.verbose("Error removing stale records from " + name, (Throwable) e2);
                            } finally {
                                dBAdapter.dbHelper.close();
                            }
                        }
                    }
                }
                return null;
            }
        }) {
            public final /* synthetic */ Callable val$callable;
            public final /* synthetic */ String val$logTag;

            {
                this.val$logTag = r2;
                this.val$callable = r3;
            }

            public void run() {
                try {
                    Logger logger = Task.this.config.getLogger();
                    logger.verbose(Task.this.taskName + " Task: " + this.val$logTag + " starting on..." + Thread.currentThread().getName());
                    TResult call = this.val$callable.call();
                    Logger logger2 = Task.this.config.getLogger();
                    logger2.verbose(Task.this.taskName + " Task: " + this.val$logTag + " executed successfully on..." + Thread.currentThread().getName());
                    Task task = Task.this;
                    if (task != null) {
                        STATE state = STATE.SUCCESS;
                        task.result = call;
                        for (SuccessExecutable<TResult> execute : task.successExecutables) {
                            execute.execute(task.result);
                        }
                        return;
                    }
                    throw null;
                } catch (Exception e2) {
                    Task task2 = Task.this;
                    if (task2 != null) {
                        STATE state2 = STATE.FAILED;
                        for (FailureExecutable<Exception> execute2 : task2.failureExecutables) {
                            execute2.execute(e2);
                        }
                        Logger logger3 = Task.this.config.getLogger();
                        logger3.verbose(Task.this.taskName + " Task: " + this.val$logTag + " failed to execute on..." + Thread.currentThread().getName(), (Throwable) e2);
                        e2.printStackTrace();
                        return;
                    }
                    throw null;
                }
            }
        });
        return true;
    }

    public final CTMessageDAO findMessageById(String str) {
        synchronized (this.messagesLock) {
            try {
                Iterator<CTMessageDAO> it = this.messages.iterator();
                while (it.hasNext()) {
                    CTMessageDAO next = it.next();
                    if (next.id.equals(str)) {
                        return next;
                    }
                }
                Logger.v("Inbox Message for message id - " + str + " not found");
                return null;
            }
        }
    }

    public ArrayList<CTMessageDAO> getMessages() {
        ArrayList<CTMessageDAO> arrayList;
        synchronized (this.messagesLock) {
            try {
                trimMessages();
                arrayList = this.messages;
            }
        }
        return arrayList;
    }

    public ArrayList<CTMessageDAO> getUnreadMessages() {
        ArrayList<CTMessageDAO> arrayList = new ArrayList<>();
        synchronized (this.messagesLock) {
            try {
                Iterator<CTMessageDAO> it = getMessages().iterator();
                while (it.hasNext()) {
                    CTMessageDAO next = it.next();
                    if (!next.read) {
                        arrayList.add(next);
                    }
                }
            }
        }
        return arrayList;
    }

    public /* synthetic */ void lambda$_markReadForMessageWithId$0$CTInboxController(Void voidR) {
        this.callbackManager._notifyInboxMessagesDidUpdate();
    }

    public final void trimMessages() {
        Logger.v("CTInboxController:trimMessages() called");
        ArrayList arrayList = new ArrayList();
        synchronized (this.messagesLock) {
            Iterator<CTMessageDAO> it = this.messages.iterator();
            while (it.hasNext()) {
                CTMessageDAO next = it.next();
                if (this.videoSupported || !next.containsVideoOrAudio()) {
                    long j = next.expires;
                    if (j > 0 && System.currentTimeMillis() / 1000 > j) {
                        Logger.v("Inbox Message: " + next.id + " is expired - removing");
                        arrayList.add(next);
                    }
                } else {
                    Logger.d("Removing inbox message containing video/audio as app does not support video. For more information checkout CleverTap documentation.");
                    arrayList.add(next);
                }
            }
            if (arrayList.size() > 0) {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    _deleteMessageWithId(((CTMessageDAO) it2.next()).id);
                }
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:31|32) */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00fd, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        r0 = r8.getConfigLogger();
        r0.verbose("Error adding data to table " + com.clevertap.android.sdk.db.DBAdapter.Table.INBOX_MESSAGES.getName());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        r8.dbHelper.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0143, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00ff */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean updateMessages(org.json.JSONArray r8) {
        /*
            r7 = this;
            java.lang.String r0 = "CTInboxController:updateMessages() called"
            com.clevertap.android.sdk.Logger.v(r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            r2 = 0
        L_0x000c:
            int r3 = r8.length()
            if (r2 >= r3) goto L_0x0066
            org.json.JSONObject r3 = r8.getJSONObject(r2)     // Catch:{ JSONException -> 0x004e }
            java.lang.String r4 = r7.userId     // Catch:{ JSONException -> 0x004e }
            com.clevertap.android.sdk.inbox.CTMessageDAO r3 = com.clevertap.android.sdk.inbox.CTMessageDAO.initWithJSON(r3, r4)     // Catch:{ JSONException -> 0x004e }
            if (r3 != 0) goto L_0x001f
            goto L_0x0063
        L_0x001f:
            boolean r4 = r7.videoSupported     // Catch:{ JSONException -> 0x004e }
            if (r4 != 0) goto L_0x002f
            boolean r4 = r3.containsVideoOrAudio()     // Catch:{ JSONException -> 0x004e }
            if (r4 == 0) goto L_0x002f
            java.lang.String r3 = "Dropping inbox message containing video/audio as app does not support video. For more information checkout CleverTap documentation."
            com.clevertap.android.sdk.Logger.d(r3)     // Catch:{ JSONException -> 0x004e }
            goto L_0x0063
        L_0x002f:
            r0.add(r3)     // Catch:{ JSONException -> 0x004e }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x004e }
            r4.<init>()     // Catch:{ JSONException -> 0x004e }
            java.lang.String r5 = "Inbox Message for message id - "
            r4.append(r5)     // Catch:{ JSONException -> 0x004e }
            java.lang.String r3 = r3.id     // Catch:{ JSONException -> 0x004e }
            r4.append(r3)     // Catch:{ JSONException -> 0x004e }
            java.lang.String r3 = " added"
            r4.append(r3)     // Catch:{ JSONException -> 0x004e }
            java.lang.String r3 = r4.toString()     // Catch:{ JSONException -> 0x004e }
            com.clevertap.android.sdk.Logger.v(r3)     // Catch:{ JSONException -> 0x004e }
            goto L_0x0063
        L_0x004e:
            r3 = move-exception
            java.lang.String r4 = "Unable to update notification inbox messages - "
            java.lang.StringBuilder r4 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r4)
            java.lang.String r3 = r3.getLocalizedMessage()
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            com.clevertap.android.sdk.Logger.d(r3)
        L_0x0063:
            int r2 = r2 + 1
            goto L_0x000c
        L_0x0066:
            int r8 = r0.size()
            if (r8 <= 0) goto L_0x0147
            com.clevertap.android.sdk.db.DBAdapter r8 = r7.dbAdapter
            monitor-enter(r8)
            boolean r1 = r8.belowMemThreshold()     // Catch:{ all -> 0x0144 }
            if (r1 != 0) goto L_0x007d
            java.lang.String r0 = "There is not enough space left on the device to store data, data discarded"
            com.clevertap.android.sdk.Logger.v(r0)     // Catch:{ all -> 0x0144 }
            monitor-exit(r8)
            goto L_0x0123
        L_0x007d:
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r1 = r8.dbHelper     // Catch:{ SQLiteException -> 0x00ff }
            android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()     // Catch:{ SQLiteException -> 0x00ff }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ SQLiteException -> 0x00ff }
        L_0x0087:
            boolean r2 = r0.hasNext()     // Catch:{ SQLiteException -> 0x00ff }
            if (r2 == 0) goto L_0x011d
            java.lang.Object r2 = r0.next()     // Catch:{ SQLiteException -> 0x00ff }
            com.clevertap.android.sdk.inbox.CTMessageDAO r2 = (com.clevertap.android.sdk.inbox.CTMessageDAO) r2     // Catch:{ SQLiteException -> 0x00ff }
            android.content.ContentValues r3 = new android.content.ContentValues     // Catch:{ SQLiteException -> 0x00ff }
            r3.<init>()     // Catch:{ SQLiteException -> 0x00ff }
            java.lang.String r4 = "_id"
            java.lang.String r5 = r2.id     // Catch:{ SQLiteException -> 0x00ff }
            r3.put(r4, r5)     // Catch:{ SQLiteException -> 0x00ff }
            java.lang.String r4 = "data"
            org.json.JSONObject r5 = r2.jsonData     // Catch:{ SQLiteException -> 0x00ff }
            java.lang.String r5 = r5.toString()     // Catch:{ SQLiteException -> 0x00ff }
            r3.put(r4, r5)     // Catch:{ SQLiteException -> 0x00ff }
            java.lang.String r4 = "wzrkParams"
            org.json.JSONObject r5 = r2.wzrkParams     // Catch:{ SQLiteException -> 0x00ff }
            java.lang.String r5 = r5.toString()     // Catch:{ SQLiteException -> 0x00ff }
            r3.put(r4, r5)     // Catch:{ SQLiteException -> 0x00ff }
            java.lang.String r4 = "campaignId"
            java.lang.String r5 = r2.campaignId     // Catch:{ SQLiteException -> 0x00ff }
            r3.put(r4, r5)     // Catch:{ SQLiteException -> 0x00ff }
            java.lang.String r4 = "tags"
            java.util.List<java.lang.String> r5 = r2.tags     // Catch:{ SQLiteException -> 0x00ff }
            java.lang.String r6 = ","
            java.lang.String r5 = android.text.TextUtils.join(r6, r5)     // Catch:{ SQLiteException -> 0x00ff }
            r3.put(r4, r5)     // Catch:{ SQLiteException -> 0x00ff }
            java.lang.String r4 = "isRead"
            boolean r5 = r2.read     // Catch:{ SQLiteException -> 0x00ff }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ SQLiteException -> 0x00ff }
            r3.put(r4, r5)     // Catch:{ SQLiteException -> 0x00ff }
            java.lang.String r4 = "expires"
            long r5 = r2.expires     // Catch:{ SQLiteException -> 0x00ff }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ SQLiteException -> 0x00ff }
            r3.put(r4, r5)     // Catch:{ SQLiteException -> 0x00ff }
            java.lang.String r4 = "created_at"
            long r5 = r2.date     // Catch:{ SQLiteException -> 0x00ff }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ SQLiteException -> 0x00ff }
            r3.put(r4, r5)     // Catch:{ SQLiteException -> 0x00ff }
            java.lang.String r4 = "messageUser"
            java.lang.String r2 = r2.userId     // Catch:{ SQLiteException -> 0x00ff }
            r3.put(r4, r2)     // Catch:{ SQLiteException -> 0x00ff }
            com.clevertap.android.sdk.db.DBAdapter$Table r2 = com.clevertap.android.sdk.db.DBAdapter.Table.INBOX_MESSAGES     // Catch:{ SQLiteException -> 0x00ff }
            java.lang.String r2 = r2.getName()     // Catch:{ SQLiteException -> 0x00ff }
            r4 = 0
            r5 = 5
            r1.insertWithOnConflict(r2, r4, r3, r5)     // Catch:{ SQLiteException -> 0x00ff }
            goto L_0x0087
        L_0x00fd:
            r0 = move-exception
            goto L_0x013e
        L_0x00ff:
            com.clevertap.android.sdk.Logger r0 = r8.getConfigLogger()     // Catch:{ all -> 0x00fd }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fd }
            r1.<init>()     // Catch:{ all -> 0x00fd }
            java.lang.String r2 = "Error adding data to table "
            r1.append(r2)     // Catch:{ all -> 0x00fd }
            com.clevertap.android.sdk.db.DBAdapter$Table r2 = com.clevertap.android.sdk.db.DBAdapter.Table.INBOX_MESSAGES     // Catch:{ all -> 0x00fd }
            java.lang.String r2 = r2.getName()     // Catch:{ all -> 0x00fd }
            r1.append(r2)     // Catch:{ all -> 0x00fd }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00fd }
            r0.verbose(r1)     // Catch:{ all -> 0x00fd }
        L_0x011d:
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r0 = r8.dbHelper     // Catch:{ all -> 0x0144 }
            r0.close()     // Catch:{ all -> 0x0144 }
            monitor-exit(r8)
        L_0x0123:
            java.lang.String r8 = "New Notification Inbox messages added"
            com.clevertap.android.sdk.Logger.v(r8)
            java.lang.Object r0 = r7.messagesLock
            monitor-enter(r0)
            com.clevertap.android.sdk.db.DBAdapter r8 = r7.dbAdapter     // Catch:{ all -> 0x013b }
            java.lang.String r1 = r7.userId     // Catch:{ all -> 0x013b }
            java.util.ArrayList r8 = r8.getMessages(r1)     // Catch:{ all -> 0x013b }
            r7.messages = r8     // Catch:{ all -> 0x013b }
            r7.trimMessages()     // Catch:{ all -> 0x013b }
            monitor-exit(r0)     // Catch:{ all -> 0x013b }
            r1 = 1
            goto L_0x0147
        L_0x013b:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x013b }
            throw r8
        L_0x013e:
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r1 = r8.dbHelper     // Catch:{ all -> 0x0144 }
            r1.close()     // Catch:{ all -> 0x0144 }
            throw r0     // Catch:{ all -> 0x0144 }
        L_0x0144:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        L_0x0147:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.inbox.CTInboxController.updateMessages(org.json.JSONArray):boolean");
    }
}
