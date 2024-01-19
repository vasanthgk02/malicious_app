package com.clevertap.android.sdk.events;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.clevertap.android.sdk.BaseCallbackManager;
import com.clevertap.android.sdk.CTLockManager;
import com.clevertap.android.sdk.CallbackManager;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.CoreMetaData;
import com.clevertap.android.sdk.DeviceInfo;
import com.clevertap.android.sdk.FailureFlushListener;
import com.clevertap.android.sdk.LocalDataStore;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.SessionManager;
import com.clevertap.android.sdk.db.BaseDatabaseManager;
import com.clevertap.android.sdk.login.LoginInfoProvider;
import com.clevertap.android.sdk.network.BaseNetworkManager;
import com.clevertap.android.sdk.network.NetworkManager;
import com.clevertap.android.sdk.task.CTExecutorFactory;
import com.clevertap.android.sdk.task.MainLooperHandler;
import com.clevertap.android.sdk.task.Task;
import com.clevertap.android.sdk.validation.ValidationResultStack;
import java.security.SecureRandom;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import org.json.JSONObject;

public class EventQueueManager extends BaseEventQueueManager implements FailureFlushListener {
    public final BaseDatabaseManager baseDatabaseManager;
    public final CoreMetaData cleverTapMetaData;
    public Runnable commsRunnable = null;
    public final CleverTapInstanceConfig config;
    public final Context context;
    public final CTLockManager ctLockManager;
    public final DeviceInfo deviceInfo;
    public final EventMediator eventMediator;
    public final LocalDataStore localDataStore;
    public final Logger logger;
    public LoginInfoProvider loginInfoProvider;
    public final MainLooperHandler mainLooperHandler;
    public final BaseNetworkManager networkManager;
    public Runnable pushNotificationViewedRunnable = null;
    public final SessionManager sessionManager;
    public final ValidationResultStack validationResultStack;

    public EventQueueManager(BaseDatabaseManager baseDatabaseManager2, Context context2, CleverTapInstanceConfig cleverTapInstanceConfig, EventMediator eventMediator2, SessionManager sessionManager2, BaseCallbackManager baseCallbackManager, MainLooperHandler mainLooperHandler2, DeviceInfo deviceInfo2, ValidationResultStack validationResultStack2, NetworkManager networkManager2, CoreMetaData coreMetaData, CTLockManager cTLockManager, LocalDataStore localDataStore2) {
        this.baseDatabaseManager = baseDatabaseManager2;
        this.context = context2;
        this.config = cleverTapInstanceConfig;
        this.eventMediator = eventMediator2;
        this.sessionManager = sessionManager2;
        this.mainLooperHandler = mainLooperHandler2;
        this.deviceInfo = deviceInfo2;
        this.validationResultStack = validationResultStack2;
        this.networkManager = networkManager2;
        this.localDataStore = localDataStore2;
        this.logger = cleverTapInstanceConfig.getLogger();
        this.cleverTapMetaData = coreMetaData;
        this.ctLockManager = cTLockManager;
        ((CallbackManager) baseCallbackManager).failureFlushListener = this;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(17:25|26|(1:28)|29|(1:31)(2:32|(14:34|35|36|37|38|40|41|42|44|45|(1:47)|48|(1:50)|51)(1:(1:53)(2:54|(1:56)(1:57))))|58|(1:60)|61|62|63|64|(1:68)|69|70|(1:72)|73|(5:(1:76)(1:77)|78|(2:80|(1:(2:83|84))(1:88))|89|94)(1:90)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:69:0x017b */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0183 A[Catch:{ all -> 0x01ae, all -> 0x01c3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0197 A[Catch:{ all -> 0x01ae, all -> 0x01c3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01c2 A[Catch:{ all -> 0x01ae, all -> 0x01c3 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addToQueue(final android.content.Context r11, org.json.JSONObject r12, int r13) {
        /*
            r10 = this;
            r0 = 0
            r1 = 1000(0x3e8, double:4.94E-321)
            r3 = 6
            if (r13 != r3) goto L_0x00b3
            com.clevertap.android.sdk.CleverTapInstanceConfig r13 = r10.config
            com.clevertap.android.sdk.Logger r13 = r13.getLogger()
            com.clevertap.android.sdk.CleverTapInstanceConfig r3 = r10.config
            java.lang.String r3 = r3.accountId
            java.lang.String r4 = "Pushing Notification Viewed event onto separate queue"
            r13.verbose(r3, r4)
            com.clevertap.android.sdk.CTLockManager r13 = r10.ctLockManager
            java.lang.Boolean r3 = r13.eventLock
            monitor-enter(r3)
            com.clevertap.android.sdk.CoreMetaData r13 = r10.cleverTapMetaData     // Catch:{ all -> 0x008a }
            int r13 = r13.currentSessionId     // Catch:{ all -> 0x008a }
            java.lang.String r4 = "s"
            r12.put(r4, r13)     // Catch:{ all -> 0x008a }
            java.lang.String r13 = "type"
            java.lang.String r4 = "event"
            r12.put(r13, r4)     // Catch:{ all -> 0x008a }
            java.lang.String r13 = "ep"
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x008a }
            long r4 = r4 / r1
            int r1 = (int) r4     // Catch:{ all -> 0x008a }
            r12.put(r13, r1)     // Catch:{ all -> 0x008a }
            com.clevertap.android.sdk.validation.ValidationResultStack r13 = r10.validationResultStack     // Catch:{ all -> 0x008a }
            com.clevertap.android.sdk.validation.ValidationResult r13 = r13.popValidationResult()     // Catch:{ all -> 0x008a }
            if (r13 == 0) goto L_0x0046
            java.lang.String r1 = "wzrk_error"
            org.json.JSONObject r13 = co.hyperverge.hypersnapsdk.c.k.getErrorObject(r13)     // Catch:{ all -> 0x008a }
            r12.put(r1, r13)     // Catch:{ all -> 0x008a }
        L_0x0046:
            com.clevertap.android.sdk.CleverTapInstanceConfig r13 = r10.config     // Catch:{ all -> 0x008a }
            com.clevertap.android.sdk.Logger r13 = r13.getLogger()     // Catch:{ all -> 0x008a }
            com.clevertap.android.sdk.CleverTapInstanceConfig r1 = r10.config     // Catch:{ all -> 0x008a }
            java.lang.String r1 = r1.accountId     // Catch:{ all -> 0x008a }
            java.lang.String r2 = "Pushing Notification Viewed event onto DB"
            r13.verbose(r1, r2)     // Catch:{ all -> 0x008a }
            com.clevertap.android.sdk.db.BaseDatabaseManager r13 = r10.baseDatabaseManager     // Catch:{ all -> 0x008a }
            com.clevertap.android.sdk.db.DBManager r13 = (com.clevertap.android.sdk.db.DBManager) r13     // Catch:{ all -> 0x008a }
            if (r13 == 0) goto L_0x0089
            com.clevertap.android.sdk.db.DBAdapter$Table r0 = com.clevertap.android.sdk.db.DBAdapter.Table.PUSH_NOTIFICATION_VIEWED     // Catch:{ all -> 0x008a }
            r13.queueEventInternal(r11, r12, r0)     // Catch:{ all -> 0x008a }
            com.clevertap.android.sdk.CleverTapInstanceConfig r13 = r10.config     // Catch:{ all -> 0x008a }
            com.clevertap.android.sdk.Logger r13 = r13.getLogger()     // Catch:{ all -> 0x008a }
            com.clevertap.android.sdk.CleverTapInstanceConfig r0 = r10.config     // Catch:{ all -> 0x008a }
            java.lang.String r0 = r0.accountId     // Catch:{ all -> 0x008a }
            java.lang.String r1 = "Pushing Notification Viewed event onto queue flush"
            r13.verbose(r0, r1)     // Catch:{ all -> 0x008a }
            java.lang.Runnable r13 = r10.pushNotificationViewedRunnable     // Catch:{ all -> 0x008a }
            if (r13 != 0) goto L_0x007a
            com.clevertap.android.sdk.events.EventQueueManager$6 r13 = new com.clevertap.android.sdk.events.EventQueueManager$6     // Catch:{ all -> 0x008a }
            r13.<init>(r11)     // Catch:{ all -> 0x008a }
            r10.pushNotificationViewedRunnable = r13     // Catch:{ all -> 0x008a }
        L_0x007a:
            com.clevertap.android.sdk.task.MainLooperHandler r11 = r10.mainLooperHandler     // Catch:{ all -> 0x008a }
            java.lang.Runnable r13 = r10.pushNotificationViewedRunnable     // Catch:{ all -> 0x008a }
            r11.removeCallbacks(r13)     // Catch:{ all -> 0x008a }
            com.clevertap.android.sdk.task.MainLooperHandler r11 = r10.mainLooperHandler     // Catch:{ all -> 0x008a }
            java.lang.Runnable r13 = r10.pushNotificationViewedRunnable     // Catch:{ all -> 0x008a }
            r11.post(r13)     // Catch:{ all -> 0x008a }
            goto L_0x00ad
        L_0x0089:
            throw r0     // Catch:{ all -> 0x008a }
        L_0x008a:
            r11 = move-exception
            com.clevertap.android.sdk.CleverTapInstanceConfig r13 = r10.config     // Catch:{ all -> 0x00b0 }
            com.clevertap.android.sdk.Logger r13 = r13.getLogger()     // Catch:{ all -> 0x00b0 }
            com.clevertap.android.sdk.CleverTapInstanceConfig r0 = r10.config     // Catch:{ all -> 0x00b0 }
            java.lang.String r0 = r0.accountId     // Catch:{ all -> 0x00b0 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b0 }
            r1.<init>()     // Catch:{ all -> 0x00b0 }
            java.lang.String r2 = "Failed to queue notification viewed event: "
            r1.append(r2)     // Catch:{ all -> 0x00b0 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x00b0 }
            r1.append(r12)     // Catch:{ all -> 0x00b0 }
            java.lang.String r12 = r1.toString()     // Catch:{ all -> 0x00b0 }
            r13.verbose(r0, r12, r11)     // Catch:{ all -> 0x00b0 }
        L_0x00ad:
            monitor-exit(r3)     // Catch:{ all -> 0x00b0 }
            goto L_0x01e7
        L_0x00b0:
            r11 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x00b0 }
            throw r11
        L_0x00b3:
            com.clevertap.android.sdk.CTLockManager r3 = r10.ctLockManager
            java.lang.Boolean r3 = r3.eventLock
            monitor-enter(r3)
            int r4 = com.clevertap.android.sdk.CoreMetaData.activityCount     // Catch:{ all -> 0x01c3 }
            r5 = 1
            if (r4 != 0) goto L_0x00bf
            com.clevertap.android.sdk.CoreMetaData.activityCount = r5     // Catch:{ all -> 0x01c3 }
        L_0x00bf:
            r4 = 3
            if (r13 != r5) goto L_0x00c5
            java.lang.String r5 = "page"
            goto L_0x0119
        L_0x00c5:
            r6 = 2
            if (r13 != r6) goto L_0x010c
            java.lang.String r6 = "ping"
            java.lang.String r7 = "mc"
            long r8 = com.clevertap.android.sdk.Utils.getMemoryConsumption()     // Catch:{ all -> 0x00d3 }
            r12.put(r7, r8)     // Catch:{ all -> 0x00d3 }
        L_0x00d3:
            java.lang.String r7 = "nt"
            java.lang.String r8 = com.clevertap.android.sdk.Utils.getCurrentNetworkType(r11)     // Catch:{ all -> 0x00dc }
            r12.put(r7, r8)     // Catch:{ all -> 0x00dc }
        L_0x00dc:
            java.lang.String r7 = "bk"
            boolean r7 = r12.has(r7)     // Catch:{ all -> 0x01c3 }
            if (r7 == 0) goto L_0x00ed
            com.clevertap.android.sdk.CoreMetaData r7 = r10.cleverTapMetaData     // Catch:{ all -> 0x01c3 }
            r7.isBgPing = r5     // Catch:{ all -> 0x01c3 }
            java.lang.String r7 = "bk"
            r12.remove(r7)     // Catch:{ all -> 0x01c3 }
        L_0x00ed:
            com.clevertap.android.sdk.CoreMetaData r7 = r10.cleverTapMetaData     // Catch:{ all -> 0x01c3 }
            boolean r7 = r7.isLocationForGeofence     // Catch:{ all -> 0x01c3 }
            if (r7 == 0) goto L_0x010a
            java.lang.String r7 = "gf"
            r12.put(r7, r5)     // Catch:{ all -> 0x01c3 }
            com.clevertap.android.sdk.CoreMetaData r5 = r10.cleverTapMetaData     // Catch:{ all -> 0x01c3 }
            r7 = 0
            r5.isLocationForGeofence = r7     // Catch:{ all -> 0x01c3 }
            java.lang.String r5 = "gfSDKVersion"
            com.clevertap.android.sdk.CoreMetaData r8 = r10.cleverTapMetaData     // Catch:{ all -> 0x01c3 }
            int r8 = r8.geofenceSDKVersion     // Catch:{ all -> 0x01c3 }
            r12.put(r5, r8)     // Catch:{ all -> 0x01c3 }
            com.clevertap.android.sdk.CoreMetaData r5 = r10.cleverTapMetaData     // Catch:{ all -> 0x01c3 }
            r5.geofenceSDKVersion = r7     // Catch:{ all -> 0x01c3 }
        L_0x010a:
            r5 = r6
            goto L_0x0119
        L_0x010c:
            if (r13 != r4) goto L_0x0111
            java.lang.String r5 = "profile"
            goto L_0x0119
        L_0x0111:
            r5 = 5
            if (r13 != r5) goto L_0x0117
            java.lang.String r5 = "data"
            goto L_0x0119
        L_0x0117:
            java.lang.String r5 = "event"
        L_0x0119:
            com.clevertap.android.sdk.CoreMetaData r6 = r10.cleverTapMetaData     // Catch:{ all -> 0x01c3 }
            java.lang.String r6 = r6.currentScreenName     // Catch:{ all -> 0x01c3 }
            if (r6 == 0) goto L_0x0124
            java.lang.String r7 = "n"
            r12.put(r7, r6)     // Catch:{ all -> 0x01c3 }
        L_0x0124:
            com.clevertap.android.sdk.CoreMetaData r6 = r10.cleverTapMetaData     // Catch:{ all -> 0x01c3 }
            int r6 = r6.currentSessionId     // Catch:{ all -> 0x01c3 }
            java.lang.String r7 = "s"
            r12.put(r7, r6)     // Catch:{ all -> 0x01c3 }
            java.lang.String r6 = "pg"
            int r7 = com.clevertap.android.sdk.CoreMetaData.activityCount     // Catch:{ all -> 0x01c3 }
            r12.put(r6, r7)     // Catch:{ all -> 0x01c3 }
            java.lang.String r6 = "type"
            r12.put(r6, r5)     // Catch:{ all -> 0x01c3 }
            java.lang.String r5 = "ep"
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x01c3 }
            long r6 = r6 / r1
            int r1 = (int) r6     // Catch:{ all -> 0x01c3 }
            r12.put(r5, r1)     // Catch:{ all -> 0x01c3 }
            java.lang.String r1 = "f"
            com.clevertap.android.sdk.CoreMetaData r2 = r10.cleverTapMetaData     // Catch:{ all -> 0x01c3 }
            boolean r2 = r2.firstSession     // Catch:{ all -> 0x01c3 }
            r12.put(r1, r2)     // Catch:{ all -> 0x01c3 }
            java.lang.String r1 = "lsl"
            com.clevertap.android.sdk.CoreMetaData r2 = r10.cleverTapMetaData     // Catch:{ all -> 0x01c3 }
            int r2 = r2.lastSessionLength     // Catch:{ all -> 0x01c3 }
            r12.put(r1, r2)     // Catch:{ all -> 0x01c3 }
            java.lang.String r1 = "type"
            java.lang.String r1 = r12.getString(r1)     // Catch:{ all -> 0x017b }
            java.lang.String r2 = "event"
            boolean r1 = r2.equals(r1)     // Catch:{ all -> 0x017b }
            if (r1 == 0) goto L_0x017b
            java.lang.String r1 = "App Launched"
            java.lang.String r2 = "evtName"
            java.lang.String r2 = r12.getString(r2)     // Catch:{ all -> 0x017b }
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x017b }
            if (r1 == 0) goto L_0x017b
            java.lang.String r1 = "pai"
            java.lang.String r2 = r11.getPackageName()     // Catch:{ all -> 0x017b }
            r12.put(r1, r2)     // Catch:{ all -> 0x017b }
        L_0x017b:
            com.clevertap.android.sdk.validation.ValidationResultStack r1 = r10.validationResultStack     // Catch:{ all -> 0x01c3 }
            com.clevertap.android.sdk.validation.ValidationResult r1 = r1.popValidationResult()     // Catch:{ all -> 0x01c3 }
            if (r1 == 0) goto L_0x018c
            java.lang.String r2 = "wzrk_error"
            org.json.JSONObject r1 = co.hyperverge.hypersnapsdk.c.k.getErrorObject(r1)     // Catch:{ all -> 0x01c3 }
            r12.put(r2, r1)     // Catch:{ all -> 0x01c3 }
        L_0x018c:
            com.clevertap.android.sdk.LocalDataStore r1 = r10.localDataStore     // Catch:{ all -> 0x01c3 }
            r1.setDataSyncFlag(r12)     // Catch:{ all -> 0x01c3 }
            com.clevertap.android.sdk.db.BaseDatabaseManager r1 = r10.baseDatabaseManager     // Catch:{ all -> 0x01c3 }
            com.clevertap.android.sdk.db.DBManager r1 = (com.clevertap.android.sdk.db.DBManager) r1     // Catch:{ all -> 0x01c3 }
            if (r1 == 0) goto L_0x01c2
            if (r13 != r4) goto L_0x019c
            com.clevertap.android.sdk.db.DBAdapter$Table r2 = com.clevertap.android.sdk.db.DBAdapter.Table.PROFILE_EVENTS     // Catch:{ all -> 0x01c3 }
            goto L_0x019e
        L_0x019c:
            com.clevertap.android.sdk.db.DBAdapter$Table r2 = com.clevertap.android.sdk.db.DBAdapter.Table.EVENTS     // Catch:{ all -> 0x01c3 }
        L_0x019e:
            r1.queueEventInternal(r11, r12, r2)     // Catch:{ all -> 0x01c3 }
            r1 = 4
            if (r13 != r1) goto L_0x01be
            com.clevertap.android.sdk.LocalDataStore r2 = r10.localDataStore     // Catch:{ all -> 0x01c3 }
            if (r2 == 0) goto L_0x01bd
            if (r13 != r1) goto L_0x01be
            r2.persistEvent(r11, r12)     // Catch:{ all -> 0x01ae }
            goto L_0x01be
        L_0x01ae:
            r13 = move-exception
            com.clevertap.android.sdk.Logger r0 = r2.getConfigLogger()     // Catch:{ all -> 0x01c3 }
            com.clevertap.android.sdk.CleverTapInstanceConfig r1 = r2.config     // Catch:{ all -> 0x01c3 }
            java.lang.String r1 = r1.accountId     // Catch:{ all -> 0x01c3 }
            java.lang.String r2 = "Failed to sync with upstream"
            r0.verbose(r1, r2, r13)     // Catch:{ all -> 0x01c3 }
            goto L_0x01be
        L_0x01bd:
            throw r0     // Catch:{ all -> 0x01c3 }
        L_0x01be:
            r10.scheduleQueueFlush(r11)     // Catch:{ all -> 0x01c3 }
            goto L_0x01e6
        L_0x01c2:
            throw r0     // Catch:{ all -> 0x01c3 }
        L_0x01c3:
            r11 = move-exception
            com.clevertap.android.sdk.CleverTapInstanceConfig r13 = r10.config     // Catch:{ all -> 0x01e8 }
            com.clevertap.android.sdk.Logger r13 = r13.getLogger()     // Catch:{ all -> 0x01e8 }
            com.clevertap.android.sdk.CleverTapInstanceConfig r0 = r10.config     // Catch:{ all -> 0x01e8 }
            java.lang.String r0 = r0.accountId     // Catch:{ all -> 0x01e8 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01e8 }
            r1.<init>()     // Catch:{ all -> 0x01e8 }
            java.lang.String r2 = "Failed to queue event: "
            r1.append(r2)     // Catch:{ all -> 0x01e8 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x01e8 }
            r1.append(r12)     // Catch:{ all -> 0x01e8 }
            java.lang.String r12 = r1.toString()     // Catch:{ all -> 0x01e8 }
            r13.verbose(r0, r12, r11)     // Catch:{ all -> 0x01e8 }
        L_0x01e6:
            monitor-exit(r3)     // Catch:{ all -> 0x01e8 }
        L_0x01e7:
            return
        L_0x01e8:
            r11 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x01e8 }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.events.EventQueueManager.addToQueue(android.content.Context, org.json.JSONObject, int):void");
    }

    public void flushQueueAsync(final Context context2, final EventGroup eventGroup) {
        Task postAsyncSafelyTask = CTExecutorFactory.executors(this.config).postAsyncSafelyTask();
        postAsyncSafelyTask.executor.execute(new Runnable("CommsManager#flushQueueAsync", new Callable<Void>() {
            public Object call() throws Exception {
                if (eventGroup == EventGroup.PUSH_NOTIFICATION_VIEWED) {
                    EventQueueManager eventQueueManager = EventQueueManager.this;
                    eventQueueManager.logger.verbose(eventQueueManager.config.accountId, (String) "Pushing Notification Viewed event onto queue flush sync");
                } else {
                    EventQueueManager eventQueueManager2 = EventQueueManager.this;
                    eventQueueManager2.logger.verbose(eventQueueManager2.config.accountId, (String) "Pushing event onto queue flush sync");
                }
                EventQueueManager.this.flushQueueSync(context2, eventGroup);
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
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c7, code lost:
        if (r3 == null) goto L_0x00ef;
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x001f  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void flushQueueSync(final android.content.Context r8, final com.clevertap.android.sdk.events.EventGroup r9) {
        /*
            r7 = this;
            r0 = 0
            r1 = 1
            java.lang.String r2 = "connectivity"
            java.lang.Object r2 = r8.getSystemService(r2)     // Catch:{ all -> 0x001c }
            android.net.ConnectivityManager r2 = (android.net.ConnectivityManager) r2     // Catch:{ all -> 0x001c }
            if (r2 != 0) goto L_0x000d
            goto L_0x001c
        L_0x000d:
            android.net.NetworkInfo r2 = r2.getActiveNetworkInfo()     // Catch:{ all -> 0x001c }
            if (r2 == 0) goto L_0x001a
            boolean r2 = r2.isConnected()     // Catch:{ all -> 0x001c }
            if (r2 == 0) goto L_0x001a
            goto L_0x001c
        L_0x001a:
            r2 = 0
            goto L_0x001d
        L_0x001c:
            r2 = 1
        L_0x001d:
            if (r2 != 0) goto L_0x002b
            com.clevertap.android.sdk.Logger r8 = r7.logger
            com.clevertap.android.sdk.CleverTapInstanceConfig r9 = r7.config
            java.lang.String r9 = r9.accountId
            java.lang.String r0 = "Network connectivity unavailable. Will retry later"
            r8.verbose(r9, r0)
            return
        L_0x002b:
            com.clevertap.android.sdk.CoreMetaData r2 = r7.cleverTapMetaData
            r3 = 0
            if (r2 == 0) goto L_0x00f0
            com.clevertap.android.sdk.network.BaseNetworkManager r2 = r7.networkManager
            boolean r2 = r2.needsHandshakeForDomain(r9)
            if (r2 == 0) goto L_0x00df
            com.clevertap.android.sdk.network.BaseNetworkManager r2 = r7.networkManager
            com.clevertap.android.sdk.events.EventQueueManager$2 r4 = new com.clevertap.android.sdk.events.EventQueueManager$2
            r4.<init>(r8, r9)
            com.clevertap.android.sdk.network.NetworkManager r2 = (com.clevertap.android.sdk.network.NetworkManager) r2
            r2.responseFailureCount = r0
            android.content.Context r8 = r2.context
            java.lang.String r9 = r2.getEndpoint(r1, r9)
            if (r9 != 0) goto L_0x0056
            com.clevertap.android.sdk.Logger r0 = r2.logger
            com.clevertap.android.sdk.CleverTapInstanceConfig r1 = r2.config
            java.lang.String r1 = r1.accountId
            java.lang.String r5 = "Unable to perform handshake, endpoint is null"
            r0.verbose(r1, r5)
        L_0x0056:
            com.clevertap.android.sdk.Logger r0 = r2.logger
            com.clevertap.android.sdk.CleverTapInstanceConfig r1 = r2.config
            java.lang.String r1 = r1.accountId
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Performing handshake with "
            r5.append(r6)
            r5.append(r9)
            java.lang.String r5 = r5.toString()
            r0.verbose(r1, r5)
            javax.net.ssl.HttpsURLConnection r3 = r2.buildHttpsURLConnection(r9)     // Catch:{ all -> 0x00bb }
            int r9 = r3.getResponseCode()     // Catch:{ all -> 0x00bb }
            r0 = 200(0xc8, float:2.8E-43)
            if (r9 == r0) goto L_0x009b
            com.clevertap.android.sdk.Logger r8 = r2.logger     // Catch:{ all -> 0x00bb }
            com.clevertap.android.sdk.CleverTapInstanceConfig r0 = r2.config     // Catch:{ all -> 0x00bb }
            java.lang.String r0 = r0.accountId     // Catch:{ all -> 0x00bb }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bb }
            r1.<init>()     // Catch:{ all -> 0x00bb }
            java.lang.String r4 = "Invalid HTTP status code received for handshake - "
            r1.append(r4)     // Catch:{ all -> 0x00bb }
            r1.append(r9)     // Catch:{ all -> 0x00bb }
            java.lang.String r9 = r1.toString()     // Catch:{ all -> 0x00bb }
            r8.verbose(r0, r9)     // Catch:{ all -> 0x00bb }
        L_0x0096:
            java.io.InputStream r8 = r3.getInputStream()     // Catch:{ all -> 0x00ef }
            goto L_0x00ca
        L_0x009b:
            com.clevertap.android.sdk.Logger r9 = r2.logger     // Catch:{ all -> 0x00bb }
            com.clevertap.android.sdk.CleverTapInstanceConfig r0 = r2.config     // Catch:{ all -> 0x00bb }
            java.lang.String r0 = r0.accountId     // Catch:{ all -> 0x00bb }
            java.lang.String r1 = "Received success from handshake :)"
            r9.verbose(r0, r1)     // Catch:{ all -> 0x00bb }
            boolean r8 = r2.processIncomingHeaders(r8, r3)     // Catch:{ all -> 0x00bb }
            if (r8 == 0) goto L_0x0096
            com.clevertap.android.sdk.Logger r8 = r2.logger     // Catch:{ all -> 0x00bb }
            com.clevertap.android.sdk.CleverTapInstanceConfig r9 = r2.config     // Catch:{ all -> 0x00bb }
            java.lang.String r9 = r9.accountId     // Catch:{ all -> 0x00bb }
            java.lang.String r0 = "We are not muted"
            r8.verbose(r9, r0)     // Catch:{ all -> 0x00bb }
            r4.run()     // Catch:{ all -> 0x00bb }
            goto L_0x00c9
        L_0x00bb:
            r8 = move-exception
            com.clevertap.android.sdk.Logger r9 = r2.logger     // Catch:{ all -> 0x00d1 }
            com.clevertap.android.sdk.CleverTapInstanceConfig r0 = r2.config     // Catch:{ all -> 0x00d1 }
            java.lang.String r0 = r0.accountId     // Catch:{ all -> 0x00d1 }
            java.lang.String r1 = "Failed to perform handshake!"
            r9.verbose(r0, r1, r8)     // Catch:{ all -> 0x00d1 }
            if (r3 == 0) goto L_0x00ef
        L_0x00c9:
            goto L_0x0096
        L_0x00ca:
            r8.close()     // Catch:{ all -> 0x00ef }
            r3.disconnect()     // Catch:{ all -> 0x00ef }
            goto L_0x00ef
        L_0x00d1:
            r8 = move-exception
            if (r3 == 0) goto L_0x00de
            java.io.InputStream r9 = r3.getInputStream()     // Catch:{ all -> 0x00de }
            r9.close()     // Catch:{ all -> 0x00de }
            r3.disconnect()     // Catch:{ all -> 0x00de }
        L_0x00de:
            throw r8
        L_0x00df:
            com.clevertap.android.sdk.Logger r0 = r7.logger
            com.clevertap.android.sdk.CleverTapInstanceConfig r1 = r7.config
            java.lang.String r1 = r1.accountId
            java.lang.String r2 = "Pushing Notification Viewed event onto queue DB flush"
            r0.verbose(r1, r2)
            com.clevertap.android.sdk.network.BaseNetworkManager r0 = r7.networkManager
            r0.flushDBQueue(r8, r9)
        L_0x00ef:
            return
        L_0x00f0:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.events.EventQueueManager.flushQueueSync(android.content.Context, com.clevertap.android.sdk.events.EventGroup):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r5 = r9.get(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        r8.config.getLogger().verbose(r8.config.accountId, (java.lang.String) "FATAL: Creating basic profile update event failed!");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0042 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00af */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void pushBasicProfile(org.json.JSONObject r9, boolean r10) {
        /*
            r8 = this;
            com.clevertap.android.sdk.DeviceInfo r0 = r8.deviceInfo     // Catch:{ all -> 0x00bf }
            java.lang.String r0 = r0.getDeviceID()     // Catch:{ all -> 0x00bf }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x00bf }
            r1.<init>()     // Catch:{ all -> 0x00bf }
            if (r9 == 0) goto L_0x0067
            int r2 = r9.length()     // Catch:{ all -> 0x00bf }
            if (r2 <= 0) goto L_0x0067
            java.util.Iterator r2 = r9.keys()     // Catch:{ all -> 0x00bf }
            android.content.Context r3 = r8.context     // Catch:{ all -> 0x00bf }
            com.clevertap.android.sdk.CleverTapInstanceConfig r4 = r8.config     // Catch:{ all -> 0x00bf }
            com.clevertap.android.sdk.DeviceInfo r5 = r8.deviceInfo     // Catch:{ all -> 0x00bf }
            com.clevertap.android.sdk.validation.ValidationResultStack r6 = r8.validationResultStack     // Catch:{ all -> 0x00bf }
            com.clevertap.android.sdk.login.IdentityRepo r3 = co.hyperverge.hypersnapsdk.c.k.getRepo(r3, r4, r5, r6)     // Catch:{ all -> 0x00bf }
            com.clevertap.android.sdk.login.LoginInfoProvider r4 = new com.clevertap.android.sdk.login.LoginInfoProvider     // Catch:{ all -> 0x00bf }
            android.content.Context r5 = r8.context     // Catch:{ all -> 0x00bf }
            com.clevertap.android.sdk.CleverTapInstanceConfig r6 = r8.config     // Catch:{ all -> 0x00bf }
            com.clevertap.android.sdk.DeviceInfo r7 = r8.deviceInfo     // Catch:{ all -> 0x00bf }
            r4.<init>(r5, r6, r7)     // Catch:{ all -> 0x00bf }
            r8.loginInfoProvider = r4     // Catch:{ all -> 0x00bf }
        L_0x0030:
            boolean r4 = r2.hasNext()     // Catch:{ all -> 0x00bf }
            if (r4 == 0) goto L_0x0067
            java.lang.Object r4 = r2.next()     // Catch:{ all -> 0x00bf }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x00bf }
            r5 = 0
            org.json.JSONObject r5 = r9.getJSONObject(r4)     // Catch:{ all -> 0x0042 }
            goto L_0x0048
        L_0x0042:
            java.lang.Object r5 = r9.get(r4)     // Catch:{ JSONException -> 0x0047 }
            goto L_0x0048
        L_0x0047:
        L_0x0048:
            if (r5 == 0) goto L_0x0030
            r1.put(r4, r5)     // Catch:{ all -> 0x00bf }
            boolean r6 = r3.hasIdentity(r4)     // Catch:{ all -> 0x00bf }
            if (r6 == 0) goto L_0x005b
            if (r10 == 0) goto L_0x005b
            com.clevertap.android.sdk.login.LoginInfoProvider r5 = r8.loginInfoProvider     // Catch:{ all -> 0x0030 }
            r5.removeValueFromCachedGUIDForIdentifier(r0, r4)     // Catch:{ all -> 0x0030 }
            goto L_0x0030
        L_0x005b:
            if (r6 == 0) goto L_0x0030
            com.clevertap.android.sdk.login.LoginInfoProvider r6 = r8.loginInfoProvider     // Catch:{ all -> 0x0030 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0030 }
            r6.cacheGUIDForIdentifier(r0, r4, r5)     // Catch:{ all -> 0x0030 }
            goto L_0x0030
        L_0x0067:
            com.clevertap.android.sdk.DeviceInfo r9 = r8.deviceInfo     // Catch:{ JSONException -> 0x00af }
            com.clevertap.android.sdk.DeviceInfo$DeviceCachedInfo r9 = r9.getDeviceCachedInfo()     // Catch:{ JSONException -> 0x00af }
            java.lang.String r9 = r9.carrier     // Catch:{ JSONException -> 0x00af }
            java.lang.String r10 = ""
            if (r9 == 0) goto L_0x007e
            boolean r0 = r9.equals(r10)     // Catch:{ JSONException -> 0x00af }
            if (r0 != 0) goto L_0x007e
            java.lang.String r0 = "Carrier"
            r1.put(r0, r9)     // Catch:{ JSONException -> 0x00af }
        L_0x007e:
            com.clevertap.android.sdk.DeviceInfo r9 = r8.deviceInfo     // Catch:{ JSONException -> 0x00af }
            java.lang.String r9 = r9.getCountryCode()     // Catch:{ JSONException -> 0x00af }
            if (r9 == 0) goto L_0x0091
            boolean r10 = r9.equals(r10)     // Catch:{ JSONException -> 0x00af }
            if (r10 != 0) goto L_0x0091
            java.lang.String r10 = "cc"
            r1.put(r10, r9)     // Catch:{ JSONException -> 0x00af }
        L_0x0091:
            java.lang.String r9 = "tz"
            java.util.TimeZone r10 = java.util.TimeZone.getDefault()     // Catch:{ JSONException -> 0x00af }
            java.lang.String r10 = r10.getID()     // Catch:{ JSONException -> 0x00af }
            r1.put(r9, r10)     // Catch:{ JSONException -> 0x00af }
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00af }
            r9.<init>()     // Catch:{ JSONException -> 0x00af }
            java.lang.String r10 = "profile"
            r9.put(r10, r1)     // Catch:{ JSONException -> 0x00af }
            android.content.Context r10 = r8.context     // Catch:{ JSONException -> 0x00af }
            r0 = 3
            r8.queueEvent(r10, r9, r0)     // Catch:{ JSONException -> 0x00af }
            goto L_0x00cf
        L_0x00af:
            com.clevertap.android.sdk.CleverTapInstanceConfig r9 = r8.config     // Catch:{ all -> 0x00bf }
            com.clevertap.android.sdk.Logger r9 = r9.getLogger()     // Catch:{ all -> 0x00bf }
            com.clevertap.android.sdk.CleverTapInstanceConfig r10 = r8.config     // Catch:{ all -> 0x00bf }
            java.lang.String r10 = r10.accountId     // Catch:{ all -> 0x00bf }
            java.lang.String r0 = "FATAL: Creating basic profile update event failed!"
            r9.verbose(r10, r0)     // Catch:{ all -> 0x00bf }
            goto L_0x00cf
        L_0x00bf:
            r9 = move-exception
            com.clevertap.android.sdk.CleverTapInstanceConfig r10 = r8.config
            com.clevertap.android.sdk.Logger r10 = r10.getLogger()
            com.clevertap.android.sdk.CleverTapInstanceConfig r0 = r8.config
            java.lang.String r0 = r0.accountId
            java.lang.String r1 = "Basic profile sync"
            r10.verbose(r0, r1, r9)
        L_0x00cf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.events.EventQueueManager.pushBasicProfile(org.json.JSONObject, boolean):void");
    }

    public void pushInitialEventsAsync() {
        if (!this.cleverTapMetaData.inCurrentSession()) {
            Task postAsyncSafelyTask = CTExecutorFactory.executors(this.config).postAsyncSafelyTask();
            postAsyncSafelyTask.executor.execute(new Runnable("CleverTapAPI#pushInitialEventsAsync", new Callable<Void>() {
                public Object call() throws Exception {
                    try {
                        EventQueueManager.this.config.getLogger().verbose(EventQueueManager.this.config.accountId, (String) "Queuing daily events");
                        EventQueueManager.this.pushBasicProfile(null, false);
                    } catch (Throwable th) {
                        EventQueueManager.this.config.getLogger().verbose(EventQueueManager.this.config.accountId, "Daily profile sync failed", th);
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
        }
    }

    public Future<?> queueEvent(final Context context2, final JSONObject jSONObject, final int i) {
        Task postAsyncSafelyTask = CTExecutorFactory.executors(this.config).postAsyncSafelyTask();
        AnonymousClass4 r1 = new Callable<Void>() {
            /* JADX WARNING: Code restructure failed: missing block: B:29:0x00aa, code lost:
                if (java.util.Arrays.asList(com.clevertap.android.sdk.Constants.SYSTEM_EVENTS).contains(r1.getString("evtName")) != false) goto L_0x00bc;
             */
            /* JADX WARNING: Removed duplicated region for block: B:23:0x0085  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Object call() throws java.lang.Exception {
                /*
                    r11 = this;
                    com.clevertap.android.sdk.events.EventQueueManager r0 = com.clevertap.android.sdk.events.EventQueueManager.this
                    com.clevertap.android.sdk.events.EventMediator r0 = r0.eventMediator
                    org.json.JSONObject r1 = r4
                    int r2 = r5
                    r3 = 0
                    if (r0 == 0) goto L_0x011d
                    r4 = 7
                    r5 = 1
                    r6 = 0
                    if (r2 != r4) goto L_0x0011
                    goto L_0x0080
                L_0x0011:
                    com.clevertap.android.sdk.CoreMetaData r2 = r0.cleverTapMetaData
                    java.lang.Object r7 = r2.optOutFlagLock
                    monitor-enter(r7)
                    boolean r2 = r2.currentUserOptedOut     // Catch:{ all -> 0x011a }
                    monitor-exit(r7)     // Catch:{ all -> 0x011a }
                    if (r2 == 0) goto L_0x0043
                    if (r1 != 0) goto L_0x0020
                    java.lang.String r1 = "null"
                    goto L_0x0024
                L_0x0020:
                    java.lang.String r1 = r1.toString()
                L_0x0024:
                    com.clevertap.android.sdk.CleverTapInstanceConfig r2 = r0.config
                    com.clevertap.android.sdk.Logger r2 = r2.getLogger()
                    com.clevertap.android.sdk.CleverTapInstanceConfig r0 = r0.config
                    java.lang.String r0 = r0.accountId
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder
                    r7.<init>()
                    java.lang.String r8 = "Current user is opted out dropping event: "
                    r7.append(r8)
                    r7.append(r1)
                    java.lang.String r1 = r7.toString()
                    r2.debug(r0, r1)
                    goto L_0x007e
                L_0x0043:
                    long r7 = java.lang.System.currentTimeMillis()
                    r9 = 1000(0x3e8, double:4.94E-321)
                    long r7 = r7 / r9
                    int r2 = (int) r7
                    android.content.Context r7 = r0.context
                    com.clevertap.android.sdk.CleverTapInstanceConfig r8 = r0.config
                    java.lang.String r9 = "comms_mtd"
                    int r7 = co.hyperverge.hypersnapsdk.c.k.getIntFromPrefs(r7, r8, r9, r6)
                    int r2 = r2 - r7
                    r7 = 86400(0x15180, float:1.21072E-40)
                    if (r2 >= r7) goto L_0x005d
                    r2 = 1
                    goto L_0x005e
                L_0x005d:
                    r2 = 0
                L_0x005e:
                    if (r2 == 0) goto L_0x0080
                    com.clevertap.android.sdk.CleverTapInstanceConfig r2 = r0.config
                    com.clevertap.android.sdk.Logger r2 = r2.getLogger()
                    com.clevertap.android.sdk.CleverTapInstanceConfig r0 = r0.config
                    java.lang.String r0 = r0.accountId
                    java.lang.String r7 = "CleverTap is muted, dropping event - "
                    java.lang.StringBuilder r7 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r7)
                    java.lang.String r1 = r1.toString()
                    r7.append(r1)
                    java.lang.String r1 = r7.toString()
                    r2.verbose(r0, r1)
                L_0x007e:
                    r0 = 1
                    goto L_0x0081
                L_0x0080:
                    r0 = 0
                L_0x0081:
                    if (r0 == 0) goto L_0x0085
                    goto L_0x0119
                L_0x0085:
                    com.clevertap.android.sdk.events.EventQueueManager r0 = com.clevertap.android.sdk.events.EventQueueManager.this
                    com.clevertap.android.sdk.events.EventMediator r0 = r0.eventMediator
                    org.json.JSONObject r1 = r4
                    int r2 = r5
                    com.clevertap.android.sdk.CleverTapInstanceConfig r7 = r0.config
                    boolean r7 = r7.createdPostAppLaunch
                    if (r7 == 0) goto L_0x0094
                    goto L_0x00bc
                L_0x0094:
                    java.lang.String r7 = "evtName"
                    boolean r8 = r1.has(r7)
                    if (r8 == 0) goto L_0x00ae
                    java.lang.String[] r8 = com.clevertap.android.sdk.Constants.SYSTEM_EVENTS     // Catch:{ JSONException -> 0x00ad }
                    java.util.List r8 = java.util.Arrays.asList(r8)     // Catch:{ JSONException -> 0x00ad }
                    java.lang.String r1 = r1.getString(r7)     // Catch:{ JSONException -> 0x00ad }
                    boolean r1 = r8.contains(r1)     // Catch:{ JSONException -> 0x00ad }
                    if (r1 == 0) goto L_0x00ae
                    goto L_0x00bc
                L_0x00ad:
                L_0x00ae:
                    r1 = 4
                    if (r2 != r1) goto L_0x00ba
                    com.clevertap.android.sdk.CoreMetaData r0 = r0.cleverTapMetaData
                    boolean r0 = r0.isAppLaunchPushed()
                    if (r0 != 0) goto L_0x00ba
                    goto L_0x00bb
                L_0x00ba:
                    r5 = 0
                L_0x00bb:
                    r6 = r5
                L_0x00bc:
                    if (r6 == 0) goto L_0x00f2
                    com.clevertap.android.sdk.events.EventQueueManager r0 = com.clevertap.android.sdk.events.EventQueueManager.this
                    com.clevertap.android.sdk.CleverTapInstanceConfig r0 = r0.config
                    com.clevertap.android.sdk.Logger r0 = r0.getLogger()
                    com.clevertap.android.sdk.events.EventQueueManager r1 = com.clevertap.android.sdk.events.EventQueueManager.this
                    com.clevertap.android.sdk.CleverTapInstanceConfig r1 = r1.config
                    java.lang.String r1 = r1.accountId
                    java.lang.String r2 = "App Launched not yet processed, re-queuing event "
                    java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r2)
                    org.json.JSONObject r4 = r4
                    r2.append(r4)
                    java.lang.String r4 = "after 2s"
                    r2.append(r4)
                    java.lang.String r2 = r2.toString()
                    r0.debug(r1, r2)
                    com.clevertap.android.sdk.events.EventQueueManager r0 = com.clevertap.android.sdk.events.EventQueueManager.this
                    com.clevertap.android.sdk.task.MainLooperHandler r0 = r0.mainLooperHandler
                    com.clevertap.android.sdk.events.EventQueueManager$4$1 r1 = new com.clevertap.android.sdk.events.EventQueueManager$4$1
                    r1.<init>()
                    r4 = 2000(0x7d0, double:9.88E-321)
                    r0.postDelayed(r1, r4)
                    goto L_0x0119
                L_0x00f2:
                    int r0 = r5
                    if (r0 != r4) goto L_0x0100
                    com.clevertap.android.sdk.events.EventQueueManager r1 = com.clevertap.android.sdk.events.EventQueueManager.this
                    android.content.Context r2 = r3
                    org.json.JSONObject r4 = r4
                    r1.addToQueue(r2, r4, r0)
                    goto L_0x0119
                L_0x0100:
                    com.clevertap.android.sdk.events.EventQueueManager r0 = com.clevertap.android.sdk.events.EventQueueManager.this
                    com.clevertap.android.sdk.SessionManager r0 = r0.sessionManager
                    android.content.Context r1 = r3
                    r0.lazyCreateSession(r1)
                    com.clevertap.android.sdk.events.EventQueueManager r0 = com.clevertap.android.sdk.events.EventQueueManager.this
                    r0.pushInitialEventsAsync()
                    com.clevertap.android.sdk.events.EventQueueManager r0 = com.clevertap.android.sdk.events.EventQueueManager.this
                    android.content.Context r1 = r3
                    org.json.JSONObject r2 = r4
                    int r4 = r5
                    r0.addToQueue(r1, r2, r4)
                L_0x0119:
                    return r3
                L_0x011a:
                    r0 = move-exception
                    monitor-exit(r7)     // Catch:{ all -> 0x011a }
                    throw r0
                L_0x011d:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.events.EventQueueManager.AnonymousClass4.call():java.lang.Object");
            }
        };
        Executor executor = postAsyncSafelyTask.executor;
        if (executor instanceof ExecutorService) {
            return ((ExecutorService) executor).submit(new Runnable("queueEvent", r1) {
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
        }
        throw new UnsupportedOperationException("Can't use this method without ExecutorService, Use Execute alternatively ");
    }

    public void scheduleQueueFlush(final Context context2) {
        if (this.commsRunnable == null) {
            this.commsRunnable = new Runnable() {
                public void run() {
                    EventQueueManager.this.flushQueueAsync(context2, EventGroup.REGULAR);
                    EventQueueManager.this.flushQueueAsync(context2, EventGroup.PUSH_NOTIFICATION_VIEWED);
                }
            };
        }
        this.mainLooperHandler.removeCallbacks(this.commsRunnable);
        MainLooperHandler mainLooperHandler2 = this.mainLooperHandler;
        Runnable runnable = this.commsRunnable;
        NetworkManager networkManager2 = (NetworkManager) this.networkManager;
        Logger logger2 = networkManager2.logger;
        String str = networkManager2.config.accountId;
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Network retry #");
        outline73.append(networkManager2.networkRetryCount);
        logger2.debug(str, outline73.toString());
        int i = 1000;
        if (networkManager2.networkRetryCount < 10) {
            Logger logger3 = networkManager2.logger;
            String str2 = networkManager2.config.accountId;
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("Failure count is ");
            outline732.append(networkManager2.networkRetryCount);
            outline732.append(". Setting delay frequency to 1s");
            logger3.debug(str2, outline732.toString());
        } else {
            CleverTapInstanceConfig cleverTapInstanceConfig = networkManager2.config;
            if (cleverTapInstanceConfig.accountRegion == null) {
                networkManager2.logger.debug(cleverTapInstanceConfig.accountId, "Setting delay frequency to 1s");
            } else {
                int nextInt = ((new SecureRandom().nextInt(10) + 1) * 1000) + 0;
                if (nextInt < 600000) {
                    Logger logger4 = networkManager2.logger;
                    String str3 = networkManager2.config.accountId;
                    logger4.debug(str3, "Setting delay frequency to " + nextInt);
                    i = nextInt;
                } else {
                    networkManager2.logger.debug(networkManager2.config.accountId, "Setting delay frequency to 1000");
                }
            }
        }
        mainLooperHandler2.postDelayed(runnable, (long) i);
        this.logger.verbose(this.config.accountId, (String) "Scheduling delayed queue flush on main event loop");
    }
}
