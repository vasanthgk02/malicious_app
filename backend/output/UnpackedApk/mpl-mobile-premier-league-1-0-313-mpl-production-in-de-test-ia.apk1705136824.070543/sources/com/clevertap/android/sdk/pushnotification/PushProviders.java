package com.clevertap.android.sdk.pushnotification;

import android.app.job.JobInfo;
import android.app.job.JobInfo.Builder;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.clevertap.android.sdk.AnalyticsManager;
import com.clevertap.android.sdk.CleverTapAPI.DevicePushTokenRefreshListener;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.Utils;
import com.clevertap.android.sdk.db.BaseDatabaseManager;
import com.clevertap.android.sdk.db.DBAdapter;
import com.clevertap.android.sdk.pushnotification.PushConstants.PushType;
import com.clevertap.android.sdk.pushnotification.amp.CTBackgroundJobService;
import com.clevertap.android.sdk.task.CTExecutorFactory;
import com.clevertap.android.sdk.task.Task;
import com.clevertap.android.sdk.validation.ValidationResultStack;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.Callable;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.json.JSONObject;

public class PushProviders implements CTPushProviderListener {
    public final ArrayList<PushType> allDisabledPushTypes = new ArrayList<>();
    public final ArrayList<PushType> allEnabledPushTypes = new ArrayList<>();
    public final AnalyticsManager analyticsManager;
    public final ArrayList<CTPushProvider> availableCTPushProviders = new ArrayList<>();
    public final BaseDatabaseManager baseDatabaseManager;
    public final CleverTapInstanceConfig config;
    public final Context context;
    public final ArrayList<PushType> customEnabledPushTypes = new ArrayList<>();
    public INotificationRenderer iNotificationRenderer = new CoreNotificationRenderer();
    public final Object pushRenderingLock = new Object();
    public final Object tokenLock = new Object();
    public DevicePushTokenRefreshListener tokenRefreshListener;
    public final ValidationResultStack validationResultStack;

    public PushProviders(Context context2, CleverTapInstanceConfig cleverTapInstanceConfig, BaseDatabaseManager baseDatabaseManager2, ValidationResultStack validationResultStack2, AnalyticsManager analyticsManager2) {
        this.context = context2;
        this.config = cleverTapInstanceConfig;
        this.baseDatabaseManager = baseDatabaseManager2;
        this.validationResultStack = validationResultStack2;
        this.analyticsManager = analyticsManager2;
        if (cleverTapInstanceConfig.backgroundSync && !cleverTapInstanceConfig.analyticsOnly) {
            Task postAsyncSafelyTask = CTExecutorFactory.executors(cleverTapInstanceConfig).postAsyncSafelyTask();
            postAsyncSafelyTask.executor.execute(new Runnable("createOrResetJobScheduler", new Callable<Void>() {
                public Object call() throws Exception {
                    PushProviders pushProviders = PushProviders.this;
                    PushProviders.access$400(pushProviders, pushProviders.context);
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

    public static void access$400(PushProviders pushProviders, Context context2) {
        PushProviders pushProviders2 = pushProviders;
        Context context3 = context2;
        JobInfo jobInfo = null;
        if (pushProviders2 != null) {
            int i = k.getInt(context3, "pfjobid", -1);
            JobScheduler jobScheduler = (JobScheduler) context3.getSystemService("jobscheduler");
            if (VERSION.SDK_INT < 26) {
                if (i >= 0) {
                    jobScheduler.cancel(i);
                    k.putInt(context3, "pfjobid", -1);
                }
                pushProviders2.config.getLogger().debug(pushProviders2.config.accountId, "Push Amplification feature is not supported below Oreo");
            } else if (jobScheduler != null) {
                int pingFrequency = pushProviders.getPingFrequency(context2);
                if (i < 0 && pingFrequency < 0) {
                    return;
                }
                if (pingFrequency < 0) {
                    jobScheduler.cancel(i);
                    k.putInt(context3, "pfjobid", -1);
                    return;
                }
                ComponentName componentName = new ComponentName(context3, CTBackgroundJobService.class);
                boolean z = i < 0 && pingFrequency > 0;
                Iterator<JobInfo> it = jobScheduler.getAllPendingJobs().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    JobInfo next = it.next();
                    if (next.getId() == i) {
                        jobInfo = next;
                        break;
                    }
                }
                if (!(jobInfo == null || jobInfo.getIntervalMillis() == ((long) pingFrequency) * 60000)) {
                    jobScheduler.cancel(i);
                    k.putInt(context3, "pfjobid", -1);
                    z = true;
                }
                if (z) {
                    int hashCode = pushProviders2.config.accountId.hashCode();
                    Builder builder = new Builder(hashCode, componentName);
                    builder.setRequiredNetworkType(1);
                    builder.setRequiresCharging(false);
                    builder.setPeriodic(((long) pingFrequency) * 60000, 300000);
                    builder.setRequiresBatteryNotLow(true);
                    if (Utils.hasPermission(context3, "android.permission.RECEIVE_BOOT_COMPLETED")) {
                        builder.setPersisted(true);
                    }
                    if (jobScheduler.schedule(builder.build()) == 1) {
                        String str = pushProviders2.config.accountId;
                        Logger.d(str, "Job scheduled - " + hashCode);
                        k.putInt(context3, "pfjobid", hashCode);
                        return;
                    }
                    String str2 = pushProviders2.config.accountId;
                    Logger.d(str2, "Job not scheduled - " + hashCode);
                }
            }
        } else {
            throw null;
        }
    }

    public static Date access$600(PushProviders pushProviders, String str) {
        if (pushProviders != null) {
            try {
                return new SimpleDateFormat("HH:mm", Locale.US).parse(str);
            } catch (ParseException unused) {
                return new Date(0);
            }
        } else {
            throw null;
        }
    }

    public void _createNotification(Context context2, Bundle bundle, int i) {
        boolean equals;
        if (!(bundle == null || bundle.get("wzrk_pn") == null)) {
            CleverTapInstanceConfig cleverTapInstanceConfig = this.config;
            if (cleverTapInstanceConfig.analyticsOnly) {
                cleverTapInstanceConfig.getLogger().debug(this.config.accountId, "Instance is set for Analytics only, cannot create notification");
                return;
            }
            try {
                if (bundle.getString("wzrk_pn_s", "").equalsIgnoreCase(BaseParser.TRUE)) {
                    this.analyticsManager.pushNotificationViewedEvent(bundle);
                    return;
                }
                String string = bundle.getString("extras_from");
                if (string == null || !string.equals("PTReceiver")) {
                    Logger logger = this.config.getLogger();
                    String str = this.config.accountId;
                    logger.debug(str, "Handling notification: " + bundle);
                    Logger logger2 = this.config.getLogger();
                    String str2 = this.config.accountId;
                    logger2.debug(str2, "Handling notification::nh_source = " + bundle.getString("nh_source", "source not available"));
                    if (bundle.getString("wzrk_pid") != null) {
                        DBAdapter loadDBAdapter = this.baseDatabaseManager.loadDBAdapter(context2);
                        String string2 = bundle.getString("wzrk_pid");
                        synchronized (loadDBAdapter) {
                            equals = string2.equals(loadDBAdapter.fetchPushNotificationId(string2));
                        }
                        if (equals) {
                            this.config.getLogger().debug(this.config.accountId, "Push Notification already rendered, not showing again");
                            return;
                        }
                    }
                    String message = this.iNotificationRenderer.getMessage(bundle);
                    if (message == null) {
                        message = "";
                    }
                    if (message.isEmpty()) {
                        this.config.getLogger().verbose(this.config.accountId, (String) "Push notification message is empty, not rendering");
                        this.baseDatabaseManager.loadDBAdapter(context2).storeUninstallTimestamp();
                        String string3 = bundle.getString("pf", "");
                        if (!TextUtils.isEmpty(string3)) {
                            updatePingFrequencyIfNeeded(context2, Integer.parseInt(string3));
                        }
                        return;
                    }
                }
                if (this.iNotificationRenderer.getTitle(bundle, context2).isEmpty()) {
                    String str3 = context2.getApplicationInfo().name;
                }
                triggerNotification(context2, bundle, i);
            } catch (Throwable th) {
                this.config.getLogger().debug(this.config.accountId, "Couldn't render notification: ", th);
            }
        }
    }

    public void doTokenRefresh(String str, PushType pushType) {
        if (!TextUtils.isEmpty(str) && pushType != null) {
            int ordinal = pushType.ordinal();
            if (ordinal == 0) {
                handleToken(str, PushType.FCM, true);
            } else if (ordinal == 1) {
                handleToken(str, PushType.XPS, true);
            } else if (ordinal == 2) {
                handleToken(str, PushType.HPS, true);
            } else if (ordinal == 3) {
                handleToken(str, PushType.BPS, true);
            } else if (ordinal == 4) {
                handleToken(str, PushType.ADM, true);
            }
        }
    }

    public void forcePushDeviceToken(boolean z) {
        Iterator<PushType> it = this.allEnabledPushTypes.iterator();
        while (it.hasNext()) {
            pushDeviceTokenEvent(null, z, it.next());
        }
    }

    public ArrayList<PushType> getAvailablePushTypes() {
        ArrayList<PushType> arrayList = new ArrayList<>();
        Iterator<CTPushProvider> it = this.availableCTPushProviders.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getPushType());
        }
        return arrayList;
    }

    public final CTPushProvider getCTPushProviderFromPushType(PushType pushType, boolean z) {
        CTPushProvider cTPushProvider;
        Class<CTPushProviderListener> cls = CTPushProviderListener.class;
        String ctProviderClassName = pushType.getCtProviderClassName();
        CTPushProvider cTPushProvider2 = null;
        try {
            Class<?> cls2 = Class.forName(ctProviderClassName);
            if (z) {
                cTPushProvider = (CTPushProvider) cls2.getConstructor(new Class[]{cls, Context.class, CleverTapInstanceConfig.class}).newInstance(new Object[]{this, this.context, this.config});
            } else {
                cTPushProvider = (CTPushProvider) cls2.getConstructor(new Class[]{cls, Context.class, CleverTapInstanceConfig.class, Boolean.class}).newInstance(new Object[]{this, this.context, this.config, Boolean.FALSE});
            }
            cTPushProvider2 = cTPushProvider;
            CleverTapInstanceConfig cleverTapInstanceConfig = this.config;
            cleverTapInstanceConfig.logger.verbose(cleverTapInstanceConfig.getDefaultSuffix("PushProvider"), "Found provider:" + ctProviderClassName);
        } catch (InstantiationException unused) {
            CleverTapInstanceConfig cleverTapInstanceConfig2 = this.config;
            cleverTapInstanceConfig2.logger.verbose(cleverTapInstanceConfig2.getDefaultSuffix("PushProvider"), GeneratedOutlineSupport.outline50("Unable to create provider InstantiationException", ctProviderClassName));
        } catch (IllegalAccessException unused2) {
            CleverTapInstanceConfig cleverTapInstanceConfig3 = this.config;
            cleverTapInstanceConfig3.logger.verbose(cleverTapInstanceConfig3.getDefaultSuffix("PushProvider"), GeneratedOutlineSupport.outline50("Unable to create provider IllegalAccessException", ctProviderClassName));
        } catch (ClassNotFoundException unused3) {
            CleverTapInstanceConfig cleverTapInstanceConfig4 = this.config;
            cleverTapInstanceConfig4.logger.verbose(cleverTapInstanceConfig4.getDefaultSuffix("PushProvider"), GeneratedOutlineSupport.outline50("Unable to create provider ClassNotFoundException", ctProviderClassName));
        } catch (Exception e2) {
            CleverTapInstanceConfig cleverTapInstanceConfig5 = this.config;
            StringBuilder outline80 = GeneratedOutlineSupport.outline80("Unable to create provider ", ctProviderClassName, " Exception:");
            outline80.append(e2.getClass().getName());
            cleverTapInstanceConfig5.logger.verbose(cleverTapInstanceConfig5.getDefaultSuffix("PushProvider"), outline80.toString());
        }
        return cTPushProvider2;
    }

    public String getCachedToken(PushType pushType) {
        if (pushType != null) {
            String tokenPrefKey = pushType.getTokenPrefKey();
            if (!TextUtils.isEmpty(tokenPrefKey)) {
                String stringFromPrefs = k.getStringFromPrefs(this.context, this.config, tokenPrefKey, null);
                CleverTapInstanceConfig cleverTapInstanceConfig = this.config;
                cleverTapInstanceConfig.logger.verbose(cleverTapInstanceConfig.getDefaultSuffix("PushProvider"), pushType + "getting Cached Token - " + stringFromPrefs);
                return stringFromPrefs;
            }
        }
        if (pushType != null) {
            CleverTapInstanceConfig cleverTapInstanceConfig2 = this.config;
            cleverTapInstanceConfig2.logger.verbose(cleverTapInstanceConfig2.getDefaultSuffix("PushProvider"), pushType + " Unable to find cached Token for type ");
        }
        return null;
    }

    public final int getPingFrequency(Context context2) {
        return k.getInt(context2, "pf", 240);
    }

    public void handleToken(final String str, final PushType pushType, boolean z) {
        if (z) {
            pushDeviceTokenEvent(str, true, pushType);
            if (!TextUtils.isEmpty(str) && pushType != null) {
                try {
                    Task ioTask = CTExecutorFactory.executors(this.config).ioTask();
                    ioTask.executor.execute(new Runnable("PushProviders#cacheToken", new Callable<Void>() {
                        public Object call() throws Exception {
                            PushProviders pushProviders = PushProviders.this;
                            String str = str;
                            PushType pushType = pushType;
                            if (pushProviders != null) {
                                boolean z = !TextUtils.isEmpty(str) && pushType != null && str.equalsIgnoreCase(pushProviders.getCachedToken(pushType));
                                if (pushType != null) {
                                    CleverTapInstanceConfig cleverTapInstanceConfig = pushProviders.config;
                                    cleverTapInstanceConfig.logger.verbose(cleverTapInstanceConfig.getDefaultSuffix("PushProvider"), pushType + "Token Already available value: " + z);
                                }
                                if (!z) {
                                    String tokenPrefKey = pushType.getTokenPrefKey();
                                    if (!TextUtils.isEmpty(tokenPrefKey)) {
                                        PushProviders pushProviders2 = PushProviders.this;
                                        try {
                                            k.getPreferences(pushProviders2.context).edit().putString(k.storageKeyWithSuffix(pushProviders2.config, tokenPrefKey), str).commit();
                                        } catch (Throwable th) {
                                            Logger.v((String) "CRITICAL: Failed to persist shared preferences!", th);
                                        }
                                        CleverTapInstanceConfig cleverTapInstanceConfig2 = PushProviders.this.config;
                                        cleverTapInstanceConfig2.logger.verbose(cleverTapInstanceConfig2.getDefaultSuffix("PushProvider"), pushType + "Cached New Token successfully " + str);
                                    }
                                }
                                return null;
                            }
                            throw null;
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
                } catch (Throwable th) {
                    CleverTapInstanceConfig cleverTapInstanceConfig = this.config;
                    cleverTapInstanceConfig.logger.verbose(cleverTapInstanceConfig.getDefaultSuffix("PushProvider"), pushType + "Unable to cache token " + str, th);
                }
            }
        } else {
            pushDeviceTokenEvent(str, false, pushType);
        }
    }

    public boolean isNotificationSupported() {
        Iterator<PushType> it = getAvailablePushTypes().iterator();
        while (it.hasNext()) {
            if (getCachedToken(it.next()) != null) {
                return true;
            }
        }
        return false;
    }

    public void onNewToken(String str, PushType pushType) {
        if (!TextUtils.isEmpty(str)) {
            doTokenRefresh(str, pushType);
            if (this.tokenRefreshListener != null) {
                Logger logger = this.config.getLogger();
                String str2 = this.config.accountId;
                logger.debug(str2, "Notifying devicePushTokenDidRefresh: " + str);
                this.tokenRefreshListener.devicePushTokenDidRefresh(str, pushType);
            }
        }
    }

    public final void pushDeviceTokenEvent(String str, boolean z, PushType pushType) {
        if (pushType != null) {
            if (TextUtils.isEmpty(str)) {
                str = getCachedToken(pushType);
            }
            if (!TextUtils.isEmpty(str)) {
                synchronized (this.tokenLock) {
                    JSONObject jSONObject = new JSONObject();
                    JSONObject jSONObject2 = new JSONObject();
                    String str2 = z ? MiPushClient.COMMAND_REGISTER : MiPushClient.COMMAND_UNREGISTER;
                    try {
                        jSONObject2.put("action", str2);
                        jSONObject2.put("id", str);
                        jSONObject2.put("type", pushType.getType());
                        if (pushType == PushType.XPS) {
                            this.config.getLogger().verbose("PushProviders: pushDeviceTokenEvent requesting device region");
                            jSONObject2.put("region", pushType.getServerRegion());
                        }
                        jSONObject.put("data", jSONObject2);
                        Logger logger = this.config.getLogger();
                        String str3 = this.config.accountId;
                        logger.verbose(str3, pushType + str2 + " device token " + str);
                        AnalyticsManager analyticsManager2 = this.analyticsManager;
                        analyticsManager2.baseEventQueueManager.queueEvent(analyticsManager2.context, jSONObject, 5);
                    } catch (Throwable th) {
                        Logger logger2 = this.config.getLogger();
                        String str4 = this.config.accountId;
                        logger2.verbose(str4, pushType + str2 + " device token failed", th);
                    }
                }
            }
        }
    }

    public void runInstanceJobWork(final Context context2, final JobParameters jobParameters) {
        Task postAsyncSafelyTask = CTExecutorFactory.executors(this.config).postAsyncSafelyTask();
        postAsyncSafelyTask.executor.execute(new Runnable("runningJobService", new Callable<Void>() {
            /* JADX WARNING: Code restructure failed: missing block: B:35:0x00dd, code lost:
                if (r4 == null) goto L_0x010e;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:43:0x0109, code lost:
                if (r4 != null) goto L_0x010b;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:44:0x010b, code lost:
                r4.close();
             */
            /* JADX WARNING: Removed duplicated region for block: B:72:0x01c0  */
            /* JADX WARNING: Unknown top exception splitter block from list: {B:33:0x00d8=Splitter:B:33:0x00d8, B:69:0x01b9=Splitter:B:69:0x01b9} */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Object call() throws java.lang.Exception {
                /*
                    r15 = this;
                    com.clevertap.android.sdk.pushnotification.PushProviders r0 = com.clevertap.android.sdk.pushnotification.PushProviders.this
                    boolean r0 = r0.isNotificationSupported()
                    r1 = 0
                    if (r0 != 0) goto L_0x0016
                    com.clevertap.android.sdk.pushnotification.PushProviders r0 = com.clevertap.android.sdk.pushnotification.PushProviders.this
                    com.clevertap.android.sdk.CleverTapInstanceConfig r0 = r0.config
                    java.lang.String r0 = r0.accountId
                    java.lang.String r2 = "Token is not present, not running the Job"
                    com.clevertap.android.sdk.Logger.v(r0, r2)
                    goto L_0x01b5
                L_0x0016:
                    java.util.Calendar r0 = java.util.Calendar.getInstance()
                    r2 = 11
                    int r2 = r0.get(r2)
                    r3 = 12
                    int r0 = r0.get(r3)
                    com.clevertap.android.sdk.pushnotification.PushProviders r3 = com.clevertap.android.sdk.pushnotification.PushProviders.this
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder
                    r4.<init>()
                    r4.append(r2)
                    java.lang.String r2 = ":"
                    r4.append(r2)
                    r4.append(r0)
                    java.lang.String r0 = r4.toString()
                    java.util.Date r0 = com.clevertap.android.sdk.pushnotification.PushProviders.access$600(r3, r0)
                    com.clevertap.android.sdk.pushnotification.PushProviders r2 = com.clevertap.android.sdk.pushnotification.PushProviders.this
                    java.lang.String r3 = "22:00"
                    java.util.Date r2 = com.clevertap.android.sdk.pushnotification.PushProviders.access$600(r2, r3)
                    com.clevertap.android.sdk.pushnotification.PushProviders r3 = com.clevertap.android.sdk.pushnotification.PushProviders.this
                    java.lang.String r4 = "06:00"
                    java.util.Date r3 = com.clevertap.android.sdk.pushnotification.PushProviders.access$600(r3, r4)
                    com.clevertap.android.sdk.pushnotification.PushProviders r4 = com.clevertap.android.sdk.pushnotification.PushProviders.this
                    if (r4 == 0) goto L_0x01c7
                    java.util.Calendar r4 = java.util.Calendar.getInstance()
                    r4.setTime(r2)
                    java.util.Calendar r5 = java.util.Calendar.getInstance()
                    r5.setTime(r0)
                    java.util.Calendar r0 = java.util.Calendar.getInstance()
                    r0.setTime(r3)
                    int r2 = r3.compareTo(r2)
                    r3 = 1
                    if (r2 >= 0) goto L_0x007d
                    int r2 = r5.compareTo(r0)
                    r6 = 5
                    if (r2 >= 0) goto L_0x007a
                    r5.add(r6, r3)
                L_0x007a:
                    r0.add(r6, r3)
                L_0x007d:
                    int r2 = r5.compareTo(r4)
                    if (r2 < 0) goto L_0x008b
                    int r0 = r5.compareTo(r0)
                    if (r0 >= 0) goto L_0x008b
                    r0 = 1
                    goto L_0x008c
                L_0x008b:
                    r0 = 0
                L_0x008c:
                    if (r0 == 0) goto L_0x009b
                    com.clevertap.android.sdk.pushnotification.PushProviders r0 = com.clevertap.android.sdk.pushnotification.PushProviders.this
                    com.clevertap.android.sdk.CleverTapInstanceConfig r0 = r0.config
                    java.lang.String r0 = r0.accountId
                    java.lang.String r2 = "Job Service won't run in default DND hours"
                    com.clevertap.android.sdk.Logger.v(r0, r2)
                    goto L_0x01b5
                L_0x009b:
                    com.clevertap.android.sdk.pushnotification.PushProviders r0 = com.clevertap.android.sdk.pushnotification.PushProviders.this
                    com.clevertap.android.sdk.db.BaseDatabaseManager r0 = r0.baseDatabaseManager
                    android.content.Context r2 = r4
                    com.clevertap.android.sdk.db.DBAdapter r0 = r0.loadDBAdapter(r2)
                    monitor-enter(r0)
                    com.clevertap.android.sdk.db.DBAdapter$Table r2 = com.clevertap.android.sdk.db.DBAdapter.Table.UNINSTALL_TS     // Catch:{ all -> 0x01c4 }
                    java.lang.String r2 = r2.getName()     // Catch:{ all -> 0x01c4 }
                    r13 = 0
                    com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r4 = r0.dbHelper     // Catch:{ SQLiteException -> 0x00e3, all -> 0x00e0 }
                    android.database.sqlite.SQLiteDatabase r4 = r4.getReadableDatabase()     // Catch:{ SQLiteException -> 0x00e3, all -> 0x00e0 }
                    r6 = 0
                    r7 = 0
                    r8 = 0
                    r9 = 0
                    r10 = 0
                    java.lang.String r11 = "created_at DESC"
                    java.lang.String r12 = "1"
                    r5 = r2
                    android.database.Cursor r4 = r4.query(r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ SQLiteException -> 0x00e3, all -> 0x00e0 }
                    if (r4 == 0) goto L_0x00d7
                    boolean r5 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x00d5 }
                    if (r5 == 0) goto L_0x00d7
                    java.lang.String r5 = "created_at"
                    int r5 = r4.getColumnIndex(r5)     // Catch:{ SQLiteException -> 0x00d5 }
                    long r5 = r4.getLong(r5)     // Catch:{ SQLiteException -> 0x00d5 }
                    goto L_0x00d8
                L_0x00d5:
                    r5 = move-exception
                    goto L_0x00e6
                L_0x00d7:
                    r5 = r13
                L_0x00d8:
                    com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r2 = r0.dbHelper     // Catch:{ all -> 0x01c4 }
                    r2.close()     // Catch:{ all -> 0x01c4 }
                    if (r4 == 0) goto L_0x010e
                    goto L_0x010b
                L_0x00e0:
                    r2 = move-exception
                    goto L_0x01b9
                L_0x00e3:
                    r4 = move-exception
                    r5 = r4
                    r4 = r1
                L_0x00e6:
                    com.clevertap.android.sdk.Logger r6 = r0.getConfigLogger()     // Catch:{ all -> 0x01b6 }
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b6 }
                    r7.<init>()     // Catch:{ all -> 0x01b6 }
                    java.lang.String r8 = "Could not fetch records out of database "
                    r7.append(r8)     // Catch:{ all -> 0x01b6 }
                    r7.append(r2)     // Catch:{ all -> 0x01b6 }
                    java.lang.String r2 = "."
                    r7.append(r2)     // Catch:{ all -> 0x01b6 }
                    java.lang.String r2 = r7.toString()     // Catch:{ all -> 0x01b6 }
                    r6.verbose(r2, r5)     // Catch:{ all -> 0x01b6 }
                    com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r2 = r0.dbHelper     // Catch:{ all -> 0x01c4 }
                    r2.close()     // Catch:{ all -> 0x01c4 }
                    r5 = r13
                    if (r4 == 0) goto L_0x010e
                L_0x010b:
                    r4.close()     // Catch:{ all -> 0x01c4 }
                L_0x010e:
                    monitor-exit(r0)
                    int r0 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
                    if (r0 == 0) goto L_0x011f
                    long r7 = java.lang.System.currentTimeMillis()
                    r9 = 86400000(0x5265c00, double:4.2687272E-316)
                    long r7 = r7 - r9
                    int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                    if (r0 <= 0) goto L_0x01b5
                L_0x011f:
                    org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x01b0 }
                    r0.<init>()     // Catch:{ JSONException -> 0x01b0 }
                    java.lang.String r2 = "bk"
                    r0.put(r2, r3)     // Catch:{ JSONException -> 0x01b0 }
                    com.clevertap.android.sdk.pushnotification.PushProviders r2 = com.clevertap.android.sdk.pushnotification.PushProviders.this     // Catch:{ JSONException -> 0x01b0 }
                    com.clevertap.android.sdk.AnalyticsManager r2 = r2.analyticsManager     // Catch:{ JSONException -> 0x01b0 }
                    com.clevertap.android.sdk.events.BaseEventQueueManager r3 = r2.baseEventQueueManager     // Catch:{ JSONException -> 0x01b0 }
                    android.content.Context r2 = r2.context     // Catch:{ JSONException -> 0x01b0 }
                    r4 = 2
                    r3.queueEvent(r2, r0, r4)     // Catch:{ JSONException -> 0x01b0 }
                    r0 = 134217728(0x8000000, float:3.85186E-34)
                    int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ JSONException -> 0x01b0 }
                    r3 = 31
                    if (r2 < r3) goto L_0x013f
                    r0 = 167772160(0xa000000, float:6.162976E-33)
                L_0x013f:
                    android.app.job.JobParameters r2 = r5     // Catch:{ JSONException -> 0x01b0 }
                    if (r2 != 0) goto L_0x01b5
                    com.clevertap.android.sdk.pushnotification.PushProviders r2 = com.clevertap.android.sdk.pushnotification.PushProviders.this     // Catch:{ JSONException -> 0x01b0 }
                    android.content.Context r3 = r4     // Catch:{ JSONException -> 0x01b0 }
                    int r2 = r2.getPingFrequency(r3)     // Catch:{ JSONException -> 0x01b0 }
                    android.content.Context r3 = r4     // Catch:{ JSONException -> 0x01b0 }
                    java.lang.String r4 = "alarm"
                    java.lang.Object r3 = r3.getSystemService(r4)     // Catch:{ JSONException -> 0x01b0 }
                    r4 = r3
                    android.app.AlarmManager r4 = (android.app.AlarmManager) r4     // Catch:{ JSONException -> 0x01b0 }
                    android.content.Intent r3 = new android.content.Intent     // Catch:{ JSONException -> 0x01b0 }
                    java.lang.String r5 = "com.clevertap.BG_EVENT"
                    r3.<init>(r5)     // Catch:{ JSONException -> 0x01b0 }
                    android.content.Context r5 = r4     // Catch:{ JSONException -> 0x01b0 }
                    java.lang.String r5 = r5.getPackageName()     // Catch:{ JSONException -> 0x01b0 }
                    r3.setPackage(r5)     // Catch:{ JSONException -> 0x01b0 }
                    android.content.Context r5 = r4     // Catch:{ JSONException -> 0x01b0 }
                    com.clevertap.android.sdk.pushnotification.PushProviders r6 = com.clevertap.android.sdk.pushnotification.PushProviders.this     // Catch:{ JSONException -> 0x01b0 }
                    com.clevertap.android.sdk.CleverTapInstanceConfig r6 = r6.config     // Catch:{ JSONException -> 0x01b0 }
                    java.lang.String r6 = r6.accountId     // Catch:{ JSONException -> 0x01b0 }
                    int r6 = r6.hashCode()     // Catch:{ JSONException -> 0x01b0 }
                    android.app.PendingIntent r3 = android.app.PendingIntent.getService(r5, r6, r3, r0)     // Catch:{ JSONException -> 0x01b0 }
                    if (r4 == 0) goto L_0x017b
                    r4.cancel(r3)     // Catch:{ JSONException -> 0x01b0 }
                L_0x017b:
                    android.content.Intent r3 = new android.content.Intent     // Catch:{ JSONException -> 0x01b0 }
                    java.lang.String r5 = "com.clevertap.BG_EVENT"
                    r3.<init>(r5)     // Catch:{ JSONException -> 0x01b0 }
                    android.content.Context r5 = r4     // Catch:{ JSONException -> 0x01b0 }
                    java.lang.String r5 = r5.getPackageName()     // Catch:{ JSONException -> 0x01b0 }
                    r3.setPackage(r5)     // Catch:{ JSONException -> 0x01b0 }
                    android.content.Context r5 = r4     // Catch:{ JSONException -> 0x01b0 }
                    com.clevertap.android.sdk.pushnotification.PushProviders r6 = com.clevertap.android.sdk.pushnotification.PushProviders.this     // Catch:{ JSONException -> 0x01b0 }
                    com.clevertap.android.sdk.CleverTapInstanceConfig r6 = r6.config     // Catch:{ JSONException -> 0x01b0 }
                    java.lang.String r6 = r6.accountId     // Catch:{ JSONException -> 0x01b0 }
                    int r6 = r6.hashCode()     // Catch:{ JSONException -> 0x01b0 }
                    android.app.PendingIntent r10 = android.app.PendingIntent.getService(r5, r6, r3, r0)     // Catch:{ JSONException -> 0x01b0 }
                    if (r4 == 0) goto L_0x01b5
                    r0 = -1
                    if (r2 == r0) goto L_0x01b5
                    r5 = 2
                    long r6 = android.os.SystemClock.elapsedRealtime()     // Catch:{ JSONException -> 0x01b0 }
                    long r2 = (long) r2     // Catch:{ JSONException -> 0x01b0 }
                    r8 = 60000(0xea60, double:2.9644E-319)
                    long r8 = r8 * r2
                    long r6 = r6 + r8
                    r4.setInexactRepeating(r5, r6, r8, r10)     // Catch:{ JSONException -> 0x01b0 }
                    goto L_0x01b5
                L_0x01b0:
                    java.lang.String r0 = "Unable to raise background Ping event"
                    com.clevertap.android.sdk.Logger.v(r0)
                L_0x01b5:
                    return r1
                L_0x01b6:
                    r1 = move-exception
                    r2 = r1
                    r1 = r4
                L_0x01b9:
                    com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r3 = r0.dbHelper     // Catch:{ all -> 0x01c4 }
                    r3.close()     // Catch:{ all -> 0x01c4 }
                    if (r1 == 0) goto L_0x01c3
                    r1.close()     // Catch:{ all -> 0x01c4 }
                L_0x01c3:
                    throw r2     // Catch:{ all -> 0x01c4 }
                L_0x01c4:
                    r1 = move-exception
                    monitor-exit(r0)
                    throw r1
                L_0x01c7:
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.pushnotification.PushProviders.AnonymousClass4.call():java.lang.Object");
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

    /* JADX WARNING: Can't wrap try/catch for region: R(4:52|53|54|55) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:106:0x0309 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:54:0x0110 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void triggerNotification(android.content.Context r17, android.os.Bundle r18, int r19) {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            r8 = r18
            r2 = r19
            java.lang.String r3 = "notification"
            java.lang.Object r3 = r0.getSystemService(r3)
            r9 = r3
            android.app.NotificationManager r9 = (android.app.NotificationManager) r9
            if (r9 != 0) goto L_0x0023
            java.lang.String r0 = "Unable to render notification, Notification Manager is null."
            com.clevertap.android.sdk.CleverTapInstanceConfig r2 = r1.config
            com.clevertap.android.sdk.Logger r2 = r2.getLogger()
            com.clevertap.android.sdk.CleverTapInstanceConfig r3 = r1.config
            java.lang.String r3 = r3.accountId
            r2.debug(r3, r0)
            return
        L_0x0023:
            java.lang.String r3 = "wzrk_cid"
            java.lang.String r4 = ""
            java.lang.String r3 = r8.getString(r3, r4)
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 26
            r10 = 0
            r6 = 1
            if (r4 < r5) goto L_0x0035
            r4 = 1
            goto L_0x0036
        L_0x0035:
            r4 = 0
        L_0x0036:
            int r7 = android.os.Build.VERSION.SDK_INT
            r11 = 512(0x200, float:7.17E-43)
            if (r7 < r5) goto L_0x0078
            java.lang.String r5 = ""
            boolean r7 = r3.isEmpty()
            r12 = -1
            if (r7 == 0) goto L_0x004c
            r5 = 8
            java.lang.String r7 = r18.toString()
            goto L_0x0059
        L_0x004c:
            android.app.NotificationChannel r7 = r9.getNotificationChannel(r3)
            if (r7 != 0) goto L_0x0056
            r5 = 9
            r7 = r3
            goto L_0x0059
        L_0x0056:
            r7 = -1
            r7 = r5
            r5 = -1
        L_0x0059:
            if (r5 == r12) goto L_0x0078
            java.lang.String[] r0 = new java.lang.String[r6]
            r0[r10] = r7
            com.clevertap.android.sdk.validation.ValidationResult r0 = co.hyperverge.hypersnapsdk.c.k.create(r11, r5, r0)
            com.clevertap.android.sdk.CleverTapInstanceConfig r2 = r1.config
            com.clevertap.android.sdk.Logger r2 = r2.getLogger()
            com.clevertap.android.sdk.CleverTapInstanceConfig r3 = r1.config
            java.lang.String r3 = r3.accountId
            java.lang.String r4 = r0.errorDesc
            r2.debug(r3, r4)
            com.clevertap.android.sdk.validation.ValidationResultStack r2 = r1.validationResultStack
            r2.pushValidationResult(r0)
            return
        L_0x0078:
            r11 = 0
            com.clevertap.android.sdk.ManifestInfo r5 = com.clevertap.android.sdk.ManifestInfo.getInstance(r17)     // Catch:{ all -> 0x00a1 }
            if (r5 == 0) goto L_0x00a0
            java.lang.String r5 = com.clevertap.android.sdk.ManifestInfo.notificationIcon     // Catch:{ all -> 0x00a1 }
            if (r5 == 0) goto L_0x009a
            android.content.res.Resources r6 = r17.getResources()     // Catch:{ all -> 0x00a1 }
            java.lang.String r7 = "drawable"
            java.lang.String r12 = r17.getPackageName()     // Catch:{ all -> 0x00a1 }
            int r5 = r6.getIdentifier(r5, r7, r12)     // Catch:{ all -> 0x00a1 }
            if (r5 == 0) goto L_0x0094
            goto L_0x00a7
        L_0x0094:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00a1 }
            r5.<init>()     // Catch:{ all -> 0x00a1 }
            throw r5     // Catch:{ all -> 0x00a1 }
        L_0x009a:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00a1 }
            r5.<init>()     // Catch:{ all -> 0x00a1 }
            throw r5     // Catch:{ all -> 0x00a1 }
        L_0x00a0:
            throw r11     // Catch:{ all -> 0x00a1 }
        L_0x00a1:
            android.content.pm.ApplicationInfo r5 = r17.getApplicationInfo()
            int r5 = r5.icon
        L_0x00a7:
            com.clevertap.android.sdk.pushnotification.INotificationRenderer r6 = r1.iNotificationRenderer
            r6.setSmallIcon(r5, r0)
            java.lang.String r5 = "pr"
            java.lang.String r5 = r8.getString(r5)
            if (r5 == 0) goto L_0x00c4
            java.lang.String r6 = "high"
            boolean r6 = r5.equals(r6)
            java.lang.String r7 = "max"
            boolean r5 = r5.equals(r7)
            if (r5 == 0) goto L_0x00c5
            r6 = 2
            goto L_0x00c5
        L_0x00c4:
            r6 = 0
        L_0x00c5:
            r5 = -1000(0xfffffffffffffc18, float:NaN)
            if (r2 != r5) goto L_0x016c
            com.clevertap.android.sdk.pushnotification.INotificationRenderer r7 = r1.iNotificationRenderer     // Catch:{ NumberFormatException -> 0x013f }
            java.lang.Object r7 = r7.getCollapseKey(r8)     // Catch:{ NumberFormatException -> 0x013f }
            if (r7 == 0) goto L_0x018f
            boolean r12 = r7 instanceof java.lang.Number     // Catch:{ NumberFormatException -> 0x013f }
            if (r12 == 0) goto L_0x00dd
            r12 = r7
            java.lang.Number r12 = (java.lang.Number) r12     // Catch:{ NumberFormatException -> 0x013f }
            int r2 = r12.intValue()     // Catch:{ NumberFormatException -> 0x013f }
            goto L_0x0141
        L_0x00dd:
            boolean r12 = r7 instanceof java.lang.String     // Catch:{ NumberFormatException -> 0x013f }
            if (r12 == 0) goto L_0x0141
            java.lang.String r12 = r7.toString()     // Catch:{ NumberFormatException -> 0x0110 }
            int r2 = java.lang.Integer.parseInt(r12)     // Catch:{ NumberFormatException -> 0x0110 }
            com.clevertap.android.sdk.CleverTapInstanceConfig r12 = r1.config     // Catch:{ NumberFormatException -> 0x0110 }
            com.clevertap.android.sdk.Logger r12 = r12.getLogger()     // Catch:{ NumberFormatException -> 0x0110 }
            com.clevertap.android.sdk.CleverTapInstanceConfig r13 = r1.config     // Catch:{ NumberFormatException -> 0x0110 }
            java.lang.String r13 = r13.accountId     // Catch:{ NumberFormatException -> 0x0110 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x0110 }
            r14.<init>()     // Catch:{ NumberFormatException -> 0x0110 }
            java.lang.String r15 = "Converting collapse_key: "
            r14.append(r15)     // Catch:{ NumberFormatException -> 0x0110 }
            r14.append(r7)     // Catch:{ NumberFormatException -> 0x0110 }
            java.lang.String r15 = " to notificationId int: "
            r14.append(r15)     // Catch:{ NumberFormatException -> 0x0110 }
            r14.append(r2)     // Catch:{ NumberFormatException -> 0x0110 }
            java.lang.String r14 = r14.toString()     // Catch:{ NumberFormatException -> 0x0110 }
            r12.verbose(r13, r14)     // Catch:{ NumberFormatException -> 0x0110 }
            goto L_0x0141
        L_0x0110:
            java.lang.String r12 = r7.toString()     // Catch:{ NumberFormatException -> 0x013f }
            int r2 = r12.hashCode()     // Catch:{ NumberFormatException -> 0x013f }
            com.clevertap.android.sdk.CleverTapInstanceConfig r12 = r1.config     // Catch:{ NumberFormatException -> 0x013f }
            com.clevertap.android.sdk.Logger r12 = r12.getLogger()     // Catch:{ NumberFormatException -> 0x013f }
            com.clevertap.android.sdk.CleverTapInstanceConfig r13 = r1.config     // Catch:{ NumberFormatException -> 0x013f }
            java.lang.String r13 = r13.accountId     // Catch:{ NumberFormatException -> 0x013f }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x013f }
            r14.<init>()     // Catch:{ NumberFormatException -> 0x013f }
            java.lang.String r15 = "Converting collapse_key: "
            r14.append(r15)     // Catch:{ NumberFormatException -> 0x013f }
            r14.append(r7)     // Catch:{ NumberFormatException -> 0x013f }
            java.lang.String r15 = " to notificationId int: "
            r14.append(r15)     // Catch:{ NumberFormatException -> 0x013f }
            r14.append(r2)     // Catch:{ NumberFormatException -> 0x013f }
            java.lang.String r14 = r14.toString()     // Catch:{ NumberFormatException -> 0x013f }
            r12.verbose(r13, r14)     // Catch:{ NumberFormatException -> 0x013f }
            goto L_0x0141
        L_0x013f:
            goto L_0x018f
        L_0x0141:
            int r2 = java.lang.Math.abs(r2)     // Catch:{ NumberFormatException -> 0x013f }
            com.clevertap.android.sdk.CleverTapInstanceConfig r12 = r1.config     // Catch:{ NumberFormatException -> 0x013f }
            com.clevertap.android.sdk.Logger r12 = r12.getLogger()     // Catch:{ NumberFormatException -> 0x013f }
            com.clevertap.android.sdk.CleverTapInstanceConfig r13 = r1.config     // Catch:{ NumberFormatException -> 0x013f }
            java.lang.String r13 = r13.accountId     // Catch:{ NumberFormatException -> 0x013f }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x013f }
            r14.<init>()     // Catch:{ NumberFormatException -> 0x013f }
            java.lang.String r15 = "Creating the notification id: "
            r14.append(r15)     // Catch:{ NumberFormatException -> 0x013f }
            r14.append(r2)     // Catch:{ NumberFormatException -> 0x013f }
            java.lang.String r15 = " from collapse_key: "
            r14.append(r15)     // Catch:{ NumberFormatException -> 0x013f }
            r14.append(r7)     // Catch:{ NumberFormatException -> 0x013f }
            java.lang.String r7 = r14.toString()     // Catch:{ NumberFormatException -> 0x013f }
            r12.debug(r13, r7)     // Catch:{ NumberFormatException -> 0x013f }
            goto L_0x018f
        L_0x016c:
            com.clevertap.android.sdk.CleverTapInstanceConfig r7 = r1.config
            com.clevertap.android.sdk.Logger r7 = r7.getLogger()
            com.clevertap.android.sdk.CleverTapInstanceConfig r12 = r1.config
            java.lang.String r12 = r12.accountId
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = "Have user provided notificationId: "
            r13.append(r14)
            r13.append(r2)
            java.lang.String r14 = " won't use collapse_key (if any) as basis for notificationId"
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            r7.debug(r12, r13)
        L_0x018f:
            if (r2 != r5) goto L_0x01b8
            double r12 = java.lang.Math.random()
            r14 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r12 = r12 * r14
            int r2 = (int) r12
            com.clevertap.android.sdk.CleverTapInstanceConfig r5 = r1.config
            com.clevertap.android.sdk.Logger r5 = r5.getLogger()
            com.clevertap.android.sdk.CleverTapInstanceConfig r7 = r1.config
            java.lang.String r7 = r7.accountId
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "Setting random notificationId: "
            r12.append(r13)
            r12.append(r2)
            java.lang.String r12 = r12.toString()
            r5.debug(r7, r12)
        L_0x01b8:
            r12 = r2
            if (r4 == 0) goto L_0x01e7
            androidx.core.app.NotificationCompat$Builder r2 = new androidx.core.app.NotificationCompat$Builder
            r2.<init>(r0, r3)
            java.lang.String r3 = "wzrk_bi"
            java.lang.String r3 = r8.getString(r3, r11)
            if (r3 == 0) goto L_0x01d3
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ all -> 0x01d2 }
            if (r3 < 0) goto L_0x01d3
            r2.setBadgeIconType(r3)     // Catch:{ all -> 0x01d2 }
            goto L_0x01d3
        L_0x01d2:
        L_0x01d3:
            java.lang.String r3 = "wzrk_bc"
            java.lang.String r3 = r8.getString(r3, r11)
            if (r3 == 0) goto L_0x01ec
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ all -> 0x01e5 }
            if (r3 < 0) goto L_0x01ec
            r2.setNumber(r3)     // Catch:{ all -> 0x01e5 }
            goto L_0x01ec
        L_0x01e5:
            goto L_0x01ec
        L_0x01e7:
            androidx.core.app.NotificationCompat$Builder r2 = new androidx.core.app.NotificationCompat$Builder
            r2.<init>(r0)
        L_0x01ec:
            r2.setPriority(r6)
            com.clevertap.android.sdk.pushnotification.INotificationRenderer r3 = r1.iNotificationRenderer
            boolean r4 = r3 instanceof com.clevertap.android.sdk.interfaces.AudibleNotification
            if (r4 == 0) goto L_0x01fd
            com.clevertap.android.sdk.interfaces.AudibleNotification r3 = (com.clevertap.android.sdk.interfaces.AudibleNotification) r3
            com.clevertap.android.sdk.CleverTapInstanceConfig r4 = r1.config
            androidx.core.app.NotificationCompat$Builder r2 = r3.setSound(r0, r8, r2, r4)
        L_0x01fd:
            r5 = r2
            com.clevertap.android.sdk.pushnotification.INotificationRenderer r2 = r1.iNotificationRenderer
            com.clevertap.android.sdk.CleverTapInstanceConfig r6 = r1.config
            r3 = r18
            r4 = r17
            r7 = r12
            androidx.core.app.NotificationCompat$Builder r2 = r2.renderNotification(r3, r4, r5, r6, r7)
            if (r2 != 0) goto L_0x020e
            return
        L_0x020e:
            android.app.Notification r2 = r2.build()
            r9.notify(r12, r2)
            com.clevertap.android.sdk.CleverTapInstanceConfig r3 = r1.config
            com.clevertap.android.sdk.Logger r3 = r3.getLogger()
            com.clevertap.android.sdk.CleverTapInstanceConfig r4 = r1.config
            java.lang.String r4 = r4.accountId
            java.lang.String r5 = "Rendered notification: "
            java.lang.StringBuilder r5 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r5)
            java.lang.String r2 = r2.toString()
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            r3.debug(r4, r2)
            java.lang.String r2 = "extras_from"
            java.lang.String r2 = r8.getString(r2)
            if (r2 == 0) goto L_0x0243
            java.lang.String r3 = "PTReceiver"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0386
        L_0x0243:
            java.lang.String r2 = "wzrk_ttl"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            long r4 = java.lang.System.currentTimeMillis()
            r6 = 345600000(0x14997000, double:1.70749087E-315)
            long r4 = r4 + r6
            r12 = 1000(0x3e8, double:4.94E-321)
            long r4 = r4 / r12
            r3.append(r4)
            java.lang.String r4 = ""
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.String r2 = r8.getString(r2, r3)
            long r3 = java.lang.Long.parseLong(r2)
            java.lang.String r5 = "wzrk_pid"
            java.lang.String r5 = r8.getString(r5)
            com.clevertap.android.sdk.db.BaseDatabaseManager r9 = r1.baseDatabaseManager
            com.clevertap.android.sdk.db.DBAdapter r9 = r9.loadDBAdapter(r0)
            com.clevertap.android.sdk.CleverTapInstanceConfig r0 = r1.config
            com.clevertap.android.sdk.Logger r0 = r0.getLogger()
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "Storing Push Notification..."
            r12.append(r13)
            r12.append(r5)
            java.lang.String r13 = " - with ttl - "
            r12.append(r13)
            r12.append(r2)
            java.lang.String r2 = r12.toString()
            r0.verbose(r2)
            monitor-enter(r9)
            if (r5 != 0) goto L_0x029d
            monitor-exit(r9)
            goto L_0x0331
        L_0x029d:
            boolean r0 = r9.belowMemThreshold()     // Catch:{ all -> 0x038d }
            if (r0 != 0) goto L_0x02af
            com.clevertap.android.sdk.Logger r0 = r9.getConfigLogger()     // Catch:{ all -> 0x038d }
            java.lang.String r2 = "There is not enough space left on the device to store data, data discarded"
            r0.verbose(r2)     // Catch:{ all -> 0x038d }
            monitor-exit(r9)
            goto L_0x0331
        L_0x02af:
            com.clevertap.android.sdk.db.DBAdapter$Table r0 = com.clevertap.android.sdk.db.DBAdapter.Table.PUSH_NOTIFICATIONS     // Catch:{ all -> 0x038d }
            java.lang.String r0 = r0.getName()     // Catch:{ all -> 0x038d }
            r12 = 0
            int r2 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r2 > 0) goto L_0x02c1
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x038d }
            long r3 = r2 + r6
        L_0x02c1:
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r2 = r9.dbHelper     // Catch:{ SQLiteException -> 0x0309 }
            android.database.sqlite.SQLiteDatabase r2 = r2.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0309 }
            android.content.ContentValues r6 = new android.content.ContentValues     // Catch:{ SQLiteException -> 0x0309 }
            r6.<init>()     // Catch:{ SQLiteException -> 0x0309 }
            java.lang.String r7 = "data"
            r6.put(r7, r5)     // Catch:{ SQLiteException -> 0x0309 }
            java.lang.String r7 = "created_at"
            java.lang.Long r12 = java.lang.Long.valueOf(r3)     // Catch:{ SQLiteException -> 0x0309 }
            r6.put(r7, r12)     // Catch:{ SQLiteException -> 0x0309 }
            java.lang.String r7 = "isRead"
            java.lang.Integer r12 = java.lang.Integer.valueOf(r10)     // Catch:{ SQLiteException -> 0x0309 }
            r6.put(r7, r12)     // Catch:{ SQLiteException -> 0x0309 }
            r2.insert(r0, r11, r6)     // Catch:{ SQLiteException -> 0x0309 }
            r2 = 1
            r9.rtlDirtyFlag = r2     // Catch:{ SQLiteException -> 0x0309 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0309 }
            r2.<init>()     // Catch:{ SQLiteException -> 0x0309 }
            java.lang.String r6 = "Stored PN - "
            r2.append(r6)     // Catch:{ SQLiteException -> 0x0309 }
            r2.append(r5)     // Catch:{ SQLiteException -> 0x0309 }
            java.lang.String r5 = " with TTL - "
            r2.append(r5)     // Catch:{ SQLiteException -> 0x0309 }
            r2.append(r3)     // Catch:{ SQLiteException -> 0x0309 }
            java.lang.String r2 = r2.toString()     // Catch:{ SQLiteException -> 0x0309 }
            com.clevertap.android.sdk.Logger.v(r2)     // Catch:{ SQLiteException -> 0x0309 }
            goto L_0x032b
        L_0x0306:
            r0 = move-exception
            goto L_0x0387
        L_0x0309:
            com.clevertap.android.sdk.Logger r2 = r9.getConfigLogger()     // Catch:{ all -> 0x0306 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0306 }
            r3.<init>()     // Catch:{ all -> 0x0306 }
            java.lang.String r4 = "Error adding data to table "
            r3.append(r4)     // Catch:{ all -> 0x0306 }
            r3.append(r0)     // Catch:{ all -> 0x0306 }
            java.lang.String r0 = " Recreating DB"
            r3.append(r0)     // Catch:{ all -> 0x0306 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0306 }
            r2.verbose(r0)     // Catch:{ all -> 0x0306 }
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r0 = r9.dbHelper     // Catch:{ all -> 0x0306 }
            r0.deleteDatabase()     // Catch:{ all -> 0x0306 }
        L_0x032b:
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r0 = r9.dbHelper     // Catch:{ all -> 0x038d }
            r0.close()     // Catch:{ all -> 0x038d }
            monitor-exit(r9)
        L_0x0331:
            java.lang.String r0 = "true"
            java.lang.String r2 = "wzrk_rnv"
            java.lang.String r3 = ""
            java.lang.String r2 = r8.getString(r2, r3)
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0363
            r0 = 10
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]
            java.lang.String r3 = r18.toString()
            r2[r10] = r3
            r3 = 512(0x200, float:7.17E-43)
            com.clevertap.android.sdk.validation.ValidationResult r0 = co.hyperverge.hypersnapsdk.c.k.create(r3, r0, r2)
            com.clevertap.android.sdk.CleverTapInstanceConfig r2 = r1.config
            com.clevertap.android.sdk.Logger r2 = r2.getLogger()
            java.lang.String r3 = r0.errorDesc
            r2.debug(r3)
            com.clevertap.android.sdk.validation.ValidationResultStack r2 = r1.validationResultStack
            r2.pushValidationResult(r0)
            return
        L_0x0363:
            com.clevertap.android.sdk.AnalyticsManager r0 = r1.analyticsManager
            r0.pushNotificationViewedEvent(r8)
            com.clevertap.android.sdk.CleverTapInstanceConfig r0 = r1.config
            com.clevertap.android.sdk.Logger r0 = r0.getLogger()
            java.lang.String r2 = "Rendered Push Notification... from nh_source = "
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r2)
            java.lang.String r3 = "nh_source"
            java.lang.String r4 = "source not available"
            java.lang.String r3 = r8.getString(r3, r4)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.verbose(r2)
        L_0x0386:
            return
        L_0x0387:
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r2 = r9.dbHelper     // Catch:{ all -> 0x038d }
            r2.close()     // Catch:{ all -> 0x038d }
            throw r0     // Catch:{ all -> 0x038d }
        L_0x038d:
            r0 = move-exception
            monitor-exit(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.pushnotification.PushProviders.triggerNotification(android.content.Context, android.os.Bundle, int):void");
    }

    public void updatePingFrequencyIfNeeded(final Context context2, int i) {
        Logger logger = this.config.getLogger();
        logger.verbose("Ping frequency received - " + i);
        Logger logger2 = this.config.getLogger();
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Stored Ping Frequency - ");
        outline73.append(getPingFrequency(context2));
        logger2.verbose(outline73.toString());
        if (i != getPingFrequency(context2)) {
            k.putInt(context2, "pf", i);
            CleverTapInstanceConfig cleverTapInstanceConfig = this.config;
            if (cleverTapInstanceConfig.backgroundSync && !cleverTapInstanceConfig.analyticsOnly) {
                Task postAsyncSafelyTask = CTExecutorFactory.executors(cleverTapInstanceConfig).postAsyncSafelyTask();
                postAsyncSafelyTask.executor.execute(new Runnable("createOrResetJobScheduler", new Callable<Void>() {
                    public Object call() throws Exception {
                        PushProviders.this.config.getLogger().verbose("Creating job");
                        PushProviders.access$400(PushProviders.this, context2);
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
    }
}
