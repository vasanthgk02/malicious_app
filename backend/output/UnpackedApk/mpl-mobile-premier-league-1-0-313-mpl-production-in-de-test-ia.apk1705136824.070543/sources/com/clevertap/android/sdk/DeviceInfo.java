package com.clevertap.android.sdk;

import android.annotation.SuppressLint;
import android.app.UiModeManager;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Insets;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowInsets.Type;
import android.view.WindowManager;
import android.view.WindowMetrics;
import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.graphics.GL20;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.featureFlags.CTFeatureFlagsController;
import com.clevertap.android.sdk.login.LoginInfoProvider;
import com.clevertap.android.sdk.product_config.CTProductConfigController;
import com.clevertap.android.sdk.task.CTExecutorFactory;
import com.clevertap.android.sdk.task.OnSuccessListener;
import com.clevertap.android.sdk.task.SuccessExecutable;
import com.clevertap.android.sdk.task.Task;
import com.clevertap.android.sdk.validation.ValidationResult;
import com.xiaomi.mipush.sdk.Constants;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.Callable;
import org.json.JSONObject;

public class DeviceInfo {
    public static int sDeviceType = -1;
    public final Object adIDLock = new Object();
    public boolean adIdRun = false;
    public DeviceCachedInfo cachedInfo;
    public final CleverTapInstanceConfig config;
    public final Context context;
    public final Object deviceIDLock = new Object();
    public boolean enableNetworkInfoReporting = false;
    public String googleAdID = null;
    public String library;
    public boolean limitAdTracking = false;
    public final CoreMetaData mCoreMetaData;
    public final ArrayList<ValidationResult> validationResults = new ArrayList<>();

    public class DeviceCachedInfo {
        public String appBucket;
        public final String bluetoothVersion;
        public final int build;
        public final String carrier;
        public final String countryCode;
        public final int dpi;
        public final double height;
        public final String manufacturer;
        public final String model;
        public final String networkType;
        public final boolean notificationsEnabled;
        public final String osName;
        public final String osVersion;
        public final int sdkVersion;
        public final String versionName;
        public final double width;

        /* JADX WARNING: Code restructure failed: missing block: B:52:0x0146, code lost:
            r4 = "restricted";
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x004c, code lost:
            r1 = r2.getNetworkOperatorName();
         */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x00e1  */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x0123  */
        /* JADX WARNING: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public DeviceCachedInfo() {
            /*
                r5 = this;
                java.lang.String r0 = "phone"
                com.clevertap.android.sdk.DeviceInfo.this = r6
                r5.<init>()
                r6 = 0
                r1 = 0
                com.clevertap.android.sdk.DeviceInfo r2 = com.clevertap.android.sdk.DeviceInfo.this     // Catch:{ NameNotFoundException -> 0x0020 }
                android.content.Context r2 = r2.context     // Catch:{ NameNotFoundException -> 0x0020 }
                android.content.pm.PackageManager r2 = r2.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0020 }
                com.clevertap.android.sdk.DeviceInfo r3 = com.clevertap.android.sdk.DeviceInfo.this     // Catch:{ NameNotFoundException -> 0x0020 }
                android.content.Context r3 = r3.context     // Catch:{ NameNotFoundException -> 0x0020 }
                java.lang.String r3 = r3.getPackageName()     // Catch:{ NameNotFoundException -> 0x0020 }
                android.content.pm.PackageInfo r2 = r2.getPackageInfo(r3, r6)     // Catch:{ NameNotFoundException -> 0x0020 }
                java.lang.String r2 = r2.versionName     // Catch:{ NameNotFoundException -> 0x0020 }
                goto L_0x0026
            L_0x0020:
                java.lang.String r2 = "Unable to get app version"
                com.clevertap.android.sdk.Logger.d(r2)
                r2 = r1
            L_0x0026:
                r5.versionName = r2
                java.lang.String r2 = "Android"
                r5.osName = r2
                java.lang.String r2 = android.os.Build.VERSION.RELEASE
                r5.osVersion = r2
                java.lang.String r2 = android.os.Build.MANUFACTURER
                r5.manufacturer = r2
                java.lang.String r2 = android.os.Build.MODEL
                java.lang.String r3 = android.os.Build.MANUFACTURER
                java.lang.String r4 = ""
                java.lang.String r2 = r2.replace(r3, r4)
                r5.model = r2
                com.clevertap.android.sdk.DeviceInfo r2 = com.clevertap.android.sdk.DeviceInfo.this     // Catch:{ Exception -> 0x0050 }
                android.content.Context r2 = r2.context     // Catch:{ Exception -> 0x0050 }
                java.lang.Object r2 = r2.getSystemService(r0)     // Catch:{ Exception -> 0x0050 }
                android.telephony.TelephonyManager r2 = (android.telephony.TelephonyManager) r2     // Catch:{ Exception -> 0x0050 }
                if (r2 == 0) goto L_0x0050
                java.lang.String r1 = r2.getNetworkOperatorName()     // Catch:{ Exception -> 0x0050 }
            L_0x0050:
                r5.carrier = r1
                com.clevertap.android.sdk.DeviceInfo r1 = com.clevertap.android.sdk.DeviceInfo.this     // Catch:{ NameNotFoundException -> 0x0069 }
                android.content.Context r1 = r1.context     // Catch:{ NameNotFoundException -> 0x0069 }
                android.content.pm.PackageManager r1 = r1.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0069 }
                com.clevertap.android.sdk.DeviceInfo r2 = com.clevertap.android.sdk.DeviceInfo.this     // Catch:{ NameNotFoundException -> 0x0069 }
                android.content.Context r2 = r2.context     // Catch:{ NameNotFoundException -> 0x0069 }
                java.lang.String r2 = r2.getPackageName()     // Catch:{ NameNotFoundException -> 0x0069 }
                android.content.pm.PackageInfo r1 = r1.getPackageInfo(r2, r6)     // Catch:{ NameNotFoundException -> 0x0069 }
                int r1 = r1.versionCode     // Catch:{ NameNotFoundException -> 0x0069 }
                goto L_0x006f
            L_0x0069:
                java.lang.String r1 = "Unable to get app build"
                com.clevertap.android.sdk.Logger.d(r1)
                r1 = 0
            L_0x006f:
                r5.build = r1
                com.clevertap.android.sdk.DeviceInfo r1 = com.clevertap.android.sdk.DeviceInfo.this
                android.content.Context r1 = r1.context
                java.lang.String r1 = com.clevertap.android.sdk.Utils.getDeviceNetworkType(r1)
                r5.networkType = r1
                com.clevertap.android.sdk.DeviceInfo r1 = com.clevertap.android.sdk.DeviceInfo.this
                android.content.Context r1 = r1.context
                android.content.pm.PackageManager r1 = r1.getPackageManager()
                java.lang.String r2 = "android.hardware.bluetooth_le"
                boolean r1 = r1.hasSystemFeature(r2)
                if (r1 == 0) goto L_0x008e
                java.lang.String r1 = "ble"
                goto L_0x00a3
            L_0x008e:
                com.clevertap.android.sdk.DeviceInfo r1 = com.clevertap.android.sdk.DeviceInfo.this
                android.content.Context r1 = r1.context
                android.content.pm.PackageManager r1 = r1.getPackageManager()
                java.lang.String r2 = "android.hardware.bluetooth"
                boolean r1 = r1.hasSystemFeature(r2)
                if (r1 == 0) goto L_0x00a1
                java.lang.String r1 = "classic"
                goto L_0x00a3
            L_0x00a1:
                java.lang.String r1 = "none"
            L_0x00a3:
                r5.bluetoothVersion = r1
                com.clevertap.android.sdk.DeviceInfo r1 = com.clevertap.android.sdk.DeviceInfo.this     // Catch:{ all -> 0x00b6 }
                android.content.Context r1 = r1.context     // Catch:{ all -> 0x00b6 }
                java.lang.Object r0 = r1.getSystemService(r0)     // Catch:{ all -> 0x00b6 }
                android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0     // Catch:{ all -> 0x00b6 }
                if (r0 == 0) goto L_0x00b6
                java.lang.String r0 = r0.getSimCountryIso()     // Catch:{ all -> 0x00b6 }
                goto L_0x00b7
            L_0x00b6:
                r0 = r4
            L_0x00b7:
                r5.countryCode = r0
                r0 = 40601(0x9e99, float:5.6894E-41)
                r5.sdkVersion = r0
                double r0 = r5.getHeight()
                r5.height = r0
                r5.getHeightPixels()
                double r0 = r5.getWidth()
                r5.width = r0
                r5.getWidthPixels()
                com.clevertap.android.sdk.DeviceInfo r0 = com.clevertap.android.sdk.DeviceInfo.this
                android.content.Context r0 = r0.context
                java.lang.String r1 = "window"
                java.lang.Object r0 = r0.getSystemService(r1)
                android.view.WindowManager r0 = (android.view.WindowManager) r0
                r1 = 30
                if (r0 != 0) goto L_0x00e1
                goto L_0x0102
            L_0x00e1:
                int r6 = android.os.Build.VERSION.SDK_INT
                if (r6 < r1) goto L_0x00f4
                com.clevertap.android.sdk.DeviceInfo r6 = com.clevertap.android.sdk.DeviceInfo.this
                android.content.Context r6 = r6.context
                android.content.res.Resources r6 = r6.getResources()
                android.content.res.Configuration r6 = r6.getConfiguration()
                int r6 = r6.densityDpi
                goto L_0x0102
            L_0x00f4:
                android.util.DisplayMetrics r6 = new android.util.DisplayMetrics
                r6.<init>()
                android.view.Display r0 = r0.getDefaultDisplay()
                r0.getMetrics(r6)
                int r6 = r6.densityDpi
            L_0x0102:
                r5.dpi = r6
                com.clevertap.android.sdk.DeviceInfo r6 = com.clevertap.android.sdk.DeviceInfo.this     // Catch:{ RuntimeException -> 0x0111 }
                android.content.Context r6 = r6.context     // Catch:{ RuntimeException -> 0x0111 }
                androidx.core.app.NotificationManagerCompat r6 = androidx.core.app.NotificationManagerCompat.from(r6)     // Catch:{ RuntimeException -> 0x0111 }
                boolean r6 = r6.areNotificationsEnabled()     // Catch:{ RuntimeException -> 0x0111 }
                goto L_0x011b
            L_0x0111:
                r6 = move-exception
                java.lang.String r0 = "Runtime exception caused when checking whether notification are enabled or not"
                com.clevertap.android.sdk.Logger.d(r0)
                r6.printStackTrace()
                r6 = 1
            L_0x011b:
                r5.notificationsEnabled = r6
                int r6 = android.os.Build.VERSION.SDK_INT
                r0 = 28
                if (r6 < r0) goto L_0x0156
                com.clevertap.android.sdk.DeviceInfo r6 = com.clevertap.android.sdk.DeviceInfo.this
                android.content.Context r6 = r6.context
                java.lang.String r0 = "usagestats"
                java.lang.Object r6 = r6.getSystemService(r0)
                android.app.usage.UsageStatsManager r6 = (android.app.usage.UsageStatsManager) r6
                int r6 = r6.getAppStandbyBucket()
                r0 = 10
                if (r6 == r0) goto L_0x0152
                r0 = 20
                if (r6 == r0) goto L_0x014f
                if (r6 == r1) goto L_0x014c
                r0 = 40
                if (r6 == r0) goto L_0x0149
                r0 = 45
                if (r6 == r0) goto L_0x0146
                goto L_0x0154
            L_0x0146:
                java.lang.String r4 = "restricted"
                goto L_0x0154
            L_0x0149:
                java.lang.String r4 = "rare"
                goto L_0x0154
            L_0x014c:
                java.lang.String r4 = "frequent"
                goto L_0x0154
            L_0x014f:
                java.lang.String r4 = "working_set"
                goto L_0x0154
            L_0x0152:
                java.lang.String r4 = "active"
            L_0x0154:
                r5.appBucket = r4
            L_0x0156:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.DeviceInfo.DeviceCachedInfo.<init>(com.clevertap.android.sdk.DeviceInfo):void");
        }

        public final double getHeight() {
            float f2;
            int i;
            WindowManager windowManager = (WindowManager) DeviceInfo.this.context.getSystemService("window");
            if (windowManager == null) {
                return 0.0d;
            }
            if (VERSION.SDK_INT >= 30) {
                WindowMetrics currentWindowMetrics = windowManager.getCurrentWindowMetrics();
                Configuration configuration = DeviceInfo.this.context.getResources().getConfiguration();
                Insets insetsIgnoringVisibility = currentWindowMetrics.getWindowInsets().getInsetsIgnoringVisibility(Type.systemGestures());
                i = (currentWindowMetrics.getBounds().height() - insetsIgnoringVisibility.top) - insetsIgnoringVisibility.bottom;
                f2 = (float) configuration.densityDpi;
            } else {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                i = displayMetrics.heightPixels;
                f2 = displayMetrics.ydpi;
            }
            return ((double) Math.round(((double) (((float) i) / f2)) * 100.0d)) / 100.0d;
        }

        public final int getHeightPixels() {
            WindowManager windowManager = (WindowManager) DeviceInfo.this.context.getSystemService("window");
            if (windowManager == null) {
                return 0;
            }
            if (VERSION.SDK_INT >= 30) {
                WindowMetrics currentWindowMetrics = windowManager.getCurrentWindowMetrics();
                Insets insetsIgnoringVisibility = currentWindowMetrics.getWindowInsets().getInsetsIgnoringVisibility(Type.systemGestures());
                return (currentWindowMetrics.getBounds().height() - insetsIgnoringVisibility.top) - insetsIgnoringVisibility.bottom;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.heightPixels;
        }

        public final double getWidth() {
            float f2;
            int i;
            WindowManager windowManager = (WindowManager) DeviceInfo.this.context.getSystemService("window");
            if (windowManager == null) {
                return 0.0d;
            }
            if (VERSION.SDK_INT >= 30) {
                WindowMetrics currentWindowMetrics = windowManager.getCurrentWindowMetrics();
                Configuration configuration = DeviceInfo.this.context.getResources().getConfiguration();
                Insets insetsIgnoringVisibility = currentWindowMetrics.getWindowInsets().getInsetsIgnoringVisibility(Type.systemGestures());
                i = (currentWindowMetrics.getBounds().width() - insetsIgnoringVisibility.right) - insetsIgnoringVisibility.left;
                f2 = (float) configuration.densityDpi;
            } else {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                i = displayMetrics.widthPixels;
                f2 = displayMetrics.xdpi;
            }
            return ((double) Math.round(((double) (((float) i) / f2)) * 100.0d)) / 100.0d;
        }

        public final int getWidthPixels() {
            WindowManager windowManager = (WindowManager) DeviceInfo.this.context.getSystemService("window");
            if (windowManager == null) {
                return 0;
            }
            if (VERSION.SDK_INT >= 30) {
                WindowMetrics currentWindowMetrics = windowManager.getCurrentWindowMetrics();
                Insets insetsIgnoringVisibility = currentWindowMetrics.getWindowInsets().getInsetsIgnoringVisibility(Type.systemGestures());
                return (currentWindowMetrics.getBounds().width() - insetsIgnoringVisibility.right) - insetsIgnoringVisibility.left;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.widthPixels;
        }
    }

    public DeviceInfo(Context context2, CleverTapInstanceConfig cleverTapInstanceConfig, final String str, CoreMetaData coreMetaData) {
        this.context = context2;
        this.config = cleverTapInstanceConfig;
        this.library = null;
        this.mCoreMetaData = coreMetaData;
        Task ioTask = CTExecutorFactory.executors(cleverTapInstanceConfig).ioTask();
        ioTask.executor.execute(new Runnable("getDeviceCachedInfo", new Callable<Void>() {
            public Object call() throws Exception {
                DeviceInfo.this.getDeviceCachedInfo();
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
        Task ioTask2 = CTExecutorFactory.executors(this.config).ioTask();
        AnonymousClass2 r7 = new OnSuccessListener<Void>() {
            public void onSuccess(Object obj) {
                Void voidR = (Void) obj;
                Logger configLogger = DeviceInfo.this.getConfigLogger();
                String outline62 = GeneratedOutlineSupport.outline62(new StringBuilder(), DeviceInfo.this.config.accountId, ":async_deviceID");
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("DeviceID initialized successfully!");
                outline73.append(Thread.currentThread());
                configLogger.verbose(outline62, outline73.toString());
                DeviceInfo deviceInfo = DeviceInfo.this;
                CleverTapAPI instanceWithConfig = CleverTapAPI.instanceWithConfig(deviceInfo.context, deviceInfo.config);
                String deviceID = DeviceInfo.this.getDeviceID();
                CoreState coreState = instanceWithConfig.coreState;
                String str = coreState.config.accountId;
                ControllerManager controllerManager = coreState.controllerManager;
                if (controllerManager == null) {
                    Logger configLogger2 = instanceWithConfig.getConfigLogger();
                    configLogger2.verbose(str + ":async_deviceID", (String) "ControllerManager not set yet! Returning from deviceIDCreated()");
                    return;
                }
                if (controllerManager.inAppFCManager == null) {
                    Logger configLogger3 = instanceWithConfig.getConfigLogger();
                    String outline50 = GeneratedOutlineSupport.outline50(str, ":async_deviceID");
                    configLogger3.verbose(outline50, "Initializing InAppFC after Device ID Created = " + deviceID);
                    CoreState coreState2 = instanceWithConfig.coreState;
                    coreState2.controllerManager.inAppFCManager = new InAppFCManager(instanceWithConfig.context, coreState2.config, deviceID);
                }
                CTFeatureFlagsController cTFeatureFlagsController = instanceWithConfig.coreState.controllerManager.ctFeatureFlagsController;
                if (cTFeatureFlagsController != null && TextUtils.isEmpty(cTFeatureFlagsController.guid)) {
                    Logger configLogger4 = instanceWithConfig.getConfigLogger();
                    String outline502 = GeneratedOutlineSupport.outline50(str, ":async_deviceID");
                    configLogger4.verbose(outline502, "Initializing Feature Flags after Device ID Created = " + deviceID);
                    if (!cTFeatureFlagsController.isInitialized) {
                        cTFeatureFlagsController.guid = deviceID;
                        cTFeatureFlagsController.init();
                    }
                }
                CTProductConfigController cTProductConfigController = instanceWithConfig.coreState.controllerManager.ctProductConfigController;
                if (cTProductConfigController != null && TextUtils.isEmpty(cTProductConfigController.settings.guid)) {
                    Logger configLogger5 = instanceWithConfig.getConfigLogger();
                    String outline503 = GeneratedOutlineSupport.outline50(str, ":async_deviceID");
                    configLogger5.verbose(outline503, "Initializing Product Config after Device ID Created = " + deviceID);
                    if (!cTProductConfigController.isInitialized.get() && !TextUtils.isEmpty(deviceID)) {
                        cTProductConfigController.settings.guid = deviceID;
                        cTProductConfigController.initAsync();
                    }
                }
                Logger configLogger6 = instanceWithConfig.getConfigLogger();
                configLogger6.verbose(str + ":async_deviceID", (String) "Got device id from DeviceInfo, notifying user profile initialized to SyncListener");
                instanceWithConfig.coreState.callbackManager.notifyUserProfileInitialized(deviceID);
                if (((CallbackManager) instanceWithConfig.coreState.callbackManager) == null) {
                    throw null;
                }
            }
        };
        ioTask2.successExecutables.add(new SuccessExecutable(ioTask2.defaultCallbackExecutor, r7));
        ioTask2.executor.execute(new Runnable("initDeviceID", new Callable<Void>() {
            /* JADX WARNING: Removed duplicated region for block: B:38:0x0184 A[Catch:{ all -> 0x014c, all -> 0x01ad }] */
            /* JADX WARNING: Removed duplicated region for block: B:41:0x0195 A[SYNTHETIC, Splitter:B:41:0x0195] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Object call() throws java.lang.Exception {
                /*
                    r10 = this;
                    com.clevertap.android.sdk.DeviceInfo r0 = com.clevertap.android.sdk.DeviceInfo.this
                    java.lang.String r1 = r6
                    com.clevertap.android.sdk.Logger r2 = r0.getConfigLogger()
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    r3.<init>()
                    com.clevertap.android.sdk.CleverTapInstanceConfig r4 = r0.config
                    java.lang.String r4 = r4.accountId
                    java.lang.String r5 = ":async_deviceID"
                    java.lang.String r6 = "Called initDeviceID()"
                    com.android.tools.r8.GeneratedOutlineSupport.outline101(r3, r4, r5, r2, r6)
                    com.clevertap.android.sdk.CleverTapInstanceConfig r2 = r0.config
                    boolean r2 = r2.enableCustomCleverTapId
                    r3 = 0
                    if (r2 == 0) goto L_0x0033
                    if (r1 != 0) goto L_0x0046
                    r2 = 18
                    java.lang.String[] r4 = new java.lang.String[r3]
                    java.lang.String r2 = r0.recordDeviceError(r2, r4)
                    com.clevertap.android.sdk.CleverTapInstanceConfig r4 = r0.config
                    com.clevertap.android.sdk.Logger r4 = r4.getLogger()
                    r4.info(r2)
                    goto L_0x0046
                L_0x0033:
                    if (r1 == 0) goto L_0x0046
                    r2 = 19
                    java.lang.String[] r4 = new java.lang.String[r3]
                    java.lang.String r2 = r0.recordDeviceError(r2, r4)
                    com.clevertap.android.sdk.CleverTapInstanceConfig r4 = r0.config
                    com.clevertap.android.sdk.Logger r4 = r4.getLogger()
                    r4.info(r2)
                L_0x0046:
                    com.clevertap.android.sdk.Logger r2 = r0.getConfigLogger()
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder
                    r4.<init>()
                    com.clevertap.android.sdk.CleverTapInstanceConfig r5 = r0.config
                    java.lang.String r5 = r5.accountId
                    java.lang.String r6 = ":async_deviceID"
                    java.lang.String r7 = "Calling _getDeviceID"
                    com.android.tools.r8.GeneratedOutlineSupport.outline101(r4, r5, r6, r2, r7)
                    java.lang.String r2 = r0._getDeviceID()
                    com.clevertap.android.sdk.Logger r4 = r0.getConfigLogger()
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder
                    r5.<init>()
                    com.clevertap.android.sdk.CleverTapInstanceConfig r6 = r0.config
                    java.lang.String r6 = r6.accountId
                    java.lang.String r7 = ":async_deviceID"
                    java.lang.String r8 = "Called _getDeviceID"
                    com.android.tools.r8.GeneratedOutlineSupport.outline101(r5, r6, r7, r4, r8)
                    r4 = 1
                    r5 = 2
                    r6 = 0
                    if (r2 == 0) goto L_0x00a9
                    java.lang.String r7 = r2.trim()
                    int r7 = r7.length()
                    if (r7 <= r5) goto L_0x00a9
                    com.clevertap.android.sdk.Logger r7 = r0.getConfigLogger()
                    com.clevertap.android.sdk.CleverTapInstanceConfig r8 = r0.config
                    java.lang.String r8 = r8.accountId
                    java.lang.String r9 = "CleverTap ID already present for profile"
                    r7.verbose(r8, r9)
                    if (r1 == 0) goto L_0x026d
                    r7 = 20
                    java.lang.String[] r5 = new java.lang.String[r5]
                    r5[r3] = r2
                    r5[r4] = r1
                    java.lang.String r1 = r0.recordDeviceError(r7, r5)
                    com.clevertap.android.sdk.Logger r2 = r0.getConfigLogger()
                    com.clevertap.android.sdk.CleverTapInstanceConfig r0 = r0.config
                    java.lang.String r0 = r0.accountId
                    r2.info(r0, r1)
                    goto L_0x026d
                L_0x00a9:
                    com.clevertap.android.sdk.CleverTapInstanceConfig r2 = r0.config
                    boolean r7 = r2.enableCustomCleverTapId
                    if (r7 == 0) goto L_0x00b4
                    r0.forceUpdateCustomCleverTapID(r1)
                    goto L_0x026d
                L_0x00b4:
                    boolean r1 = r2.useGoogleAdId
                    if (r1 != 0) goto L_0x00e5
                    com.clevertap.android.sdk.Logger r1 = r0.getConfigLogger()
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    com.clevertap.android.sdk.CleverTapInstanceConfig r3 = r0.config
                    java.lang.String r3 = r3.accountId
                    java.lang.String r4 = ":async_deviceID"
                    java.lang.String r5 = "Calling generateDeviceID()"
                    com.android.tools.r8.GeneratedOutlineSupport.outline101(r2, r3, r4, r1, r5)
                    r0.generateDeviceID()
                    com.clevertap.android.sdk.Logger r1 = r0.getConfigLogger()
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    com.clevertap.android.sdk.CleverTapInstanceConfig r0 = r0.config
                    java.lang.String r0 = r0.accountId
                    java.lang.String r3 = ":async_deviceID"
                    java.lang.String r4 = "Called generateDeviceID()"
                    com.android.tools.r8.GeneratedOutlineSupport.outline101(r2, r0, r3, r1, r4)
                    goto L_0x026d
                L_0x00e5:
                    monitor-enter(r0)
                    com.clevertap.android.sdk.Logger r1 = r0.getConfigLogger()     // Catch:{ all -> 0x026e }
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x026e }
                    r2.<init>()     // Catch:{ all -> 0x026e }
                    com.clevertap.android.sdk.CleverTapInstanceConfig r7 = r0.config     // Catch:{ all -> 0x026e }
                    java.lang.String r7 = r7.accountId     // Catch:{ all -> 0x026e }
                    r2.append(r7)     // Catch:{ all -> 0x026e }
                    java.lang.String r7 = ":async_deviceID"
                    r2.append(r7)     // Catch:{ all -> 0x026e }
                    java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x026e }
                    java.lang.String r7 = "fetchGoogleAdID() called!"
                    r1.verbose(r2, r7)     // Catch:{ all -> 0x026e }
                    java.lang.String r1 = r0.getGoogleAdID()     // Catch:{ all -> 0x026e }
                    if (r1 != 0) goto L_0x0255
                    boolean r1 = r0.adIdRun     // Catch:{ all -> 0x026e }
                    if (r1 != 0) goto L_0x0255
                    r0.adIdRun = r4     // Catch:{ all -> 0x01ad }
                    java.lang.String r1 = "com.google.android.gms.ads.identifier.AdvertisingIdClient"
                    java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ all -> 0x01ad }
                    java.lang.String r2 = "getAdvertisingIdInfo"
                    java.lang.Class[] r7 = new java.lang.Class[r4]     // Catch:{ all -> 0x01ad }
                    java.lang.Class<android.content.Context> r8 = android.content.Context.class
                    r7[r3] = r8     // Catch:{ all -> 0x01ad }
                    java.lang.reflect.Method r1 = r1.getMethod(r2, r7)     // Catch:{ all -> 0x01ad }
                    java.lang.Object[] r2 = new java.lang.Object[r4]     // Catch:{ all -> 0x01ad }
                    android.content.Context r7 = r0.context     // Catch:{ all -> 0x01ad }
                    r2[r3] = r7     // Catch:{ all -> 0x01ad }
                    java.lang.Object r1 = r1.invoke(r6, r2)     // Catch:{ all -> 0x01ad }
                    java.lang.Class r2 = r1.getClass()     // Catch:{ all -> 0x01ad }
                    java.lang.String r7 = "isLimitAdTrackingEnabled"
                    java.lang.Class[] r8 = new java.lang.Class[r3]     // Catch:{ all -> 0x01ad }
                    java.lang.reflect.Method r2 = r2.getMethod(r7, r8)     // Catch:{ all -> 0x01ad }
                    java.lang.Object[] r7 = new java.lang.Object[r3]     // Catch:{ all -> 0x01ad }
                    java.lang.Object r2 = r2.invoke(r1, r7)     // Catch:{ all -> 0x01ad }
                    java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ all -> 0x01ad }
                    java.lang.Object r7 = r0.adIDLock     // Catch:{ all -> 0x01ad }
                    monitor-enter(r7)     // Catch:{ all -> 0x01ad }
                    if (r2 == 0) goto L_0x014e
                    boolean r2 = r2.booleanValue()     // Catch:{ all -> 0x014c }
                    if (r2 == 0) goto L_0x014e
                    goto L_0x014f
                L_0x014c:
                    r1 = move-exception
                    goto L_0x01ab
                L_0x014e:
                    r4 = 0
                L_0x014f:
                    r0.limitAdTracking = r4     // Catch:{ all -> 0x014c }
                    com.clevertap.android.sdk.Logger r2 = r0.getConfigLogger()     // Catch:{ all -> 0x014c }
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x014c }
                    r4.<init>()     // Catch:{ all -> 0x014c }
                    com.clevertap.android.sdk.CleverTapInstanceConfig r8 = r0.config     // Catch:{ all -> 0x014c }
                    java.lang.String r8 = r8.accountId     // Catch:{ all -> 0x014c }
                    r4.append(r8)     // Catch:{ all -> 0x014c }
                    java.lang.String r8 = ":async_deviceID"
                    r4.append(r8)     // Catch:{ all -> 0x014c }
                    java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x014c }
                    java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x014c }
                    r8.<init>()     // Catch:{ all -> 0x014c }
                    java.lang.String r9 = "limitAdTracking = "
                    r8.append(r9)     // Catch:{ all -> 0x014c }
                    boolean r9 = r0.limitAdTracking     // Catch:{ all -> 0x014c }
                    r8.append(r9)     // Catch:{ all -> 0x014c }
                    java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x014c }
                    r2.verbose(r4, r8)     // Catch:{ all -> 0x014c }
                    boolean r2 = r0.limitAdTracking     // Catch:{ all -> 0x014c }
                    if (r2 == 0) goto L_0x0195
                    com.clevertap.android.sdk.Logger r1 = r0.getConfigLogger()     // Catch:{ all -> 0x014c }
                    com.clevertap.android.sdk.CleverTapInstanceConfig r2 = r0.config     // Catch:{ all -> 0x014c }
                    java.lang.String r2 = r2.accountId     // Catch:{ all -> 0x014c }
                    java.lang.String r3 = "Device user has opted out of sharing Advertising ID, falling back to random UUID for CleverTap ID generation"
                    r1.debug(r2, r3)     // Catch:{ all -> 0x014c }
                    monitor-exit(r7)     // Catch:{ all -> 0x014c }
                    monitor-exit(r0)
                    goto L_0x0256
                L_0x0195:
                    monitor-exit(r7)     // Catch:{ all -> 0x014c }
                    java.lang.Class r2 = r1.getClass()     // Catch:{ all -> 0x01ad }
                    java.lang.String r4 = "getId"
                    java.lang.Class[] r7 = new java.lang.Class[r3]     // Catch:{ all -> 0x01ad }
                    java.lang.reflect.Method r2 = r2.getMethod(r4, r7)     // Catch:{ all -> 0x01ad }
                    java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x01ad }
                    java.lang.Object r1 = r2.invoke(r1, r3)     // Catch:{ all -> 0x01ad }
                    java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x01ad }
                    goto L_0x0201
                L_0x01ab:
                    monitor-exit(r7)     // Catch:{ all -> 0x014c }
                    throw r1     // Catch:{ all -> 0x01ad }
                L_0x01ad:
                    r1 = move-exception
                    java.lang.Throwable r2 = r1.getCause()     // Catch:{ all -> 0x026e }
                    if (r2 == 0) goto L_0x01e0
                    com.clevertap.android.sdk.Logger r2 = r0.getConfigLogger()     // Catch:{ all -> 0x026e }
                    com.clevertap.android.sdk.CleverTapInstanceConfig r3 = r0.config     // Catch:{ all -> 0x026e }
                    java.lang.String r3 = r3.accountId     // Catch:{ all -> 0x026e }
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x026e }
                    r4.<init>()     // Catch:{ all -> 0x026e }
                    java.lang.String r7 = "Failed to get Advertising ID: "
                    r4.append(r7)     // Catch:{ all -> 0x026e }
                    java.lang.String r7 = r1.toString()     // Catch:{ all -> 0x026e }
                    r4.append(r7)     // Catch:{ all -> 0x026e }
                    java.lang.Throwable r1 = r1.getCause()     // Catch:{ all -> 0x026e }
                    java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x026e }
                    r4.append(r1)     // Catch:{ all -> 0x026e }
                    java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x026e }
                    r2.verbose(r3, r1)     // Catch:{ all -> 0x026e }
                    goto L_0x0200
                L_0x01e0:
                    com.clevertap.android.sdk.Logger r2 = r0.getConfigLogger()     // Catch:{ all -> 0x026e }
                    com.clevertap.android.sdk.CleverTapInstanceConfig r3 = r0.config     // Catch:{ all -> 0x026e }
                    java.lang.String r3 = r3.accountId     // Catch:{ all -> 0x026e }
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x026e }
                    r4.<init>()     // Catch:{ all -> 0x026e }
                    java.lang.String r7 = "Failed to get Advertising ID: "
                    r4.append(r7)     // Catch:{ all -> 0x026e }
                    java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x026e }
                    r4.append(r1)     // Catch:{ all -> 0x026e }
                    java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x026e }
                    r2.verbose(r3, r1)     // Catch:{ all -> 0x026e }
                L_0x0200:
                    r1 = r6
                L_0x0201:
                    if (r1 == 0) goto L_0x0237
                    java.lang.String r2 = r1.trim()     // Catch:{ all -> 0x026e }
                    int r2 = r2.length()     // Catch:{ all -> 0x026e }
                    if (r2 <= r5) goto L_0x0237
                    java.lang.Object r2 = r0.adIDLock     // Catch:{ all -> 0x026e }
                    monitor-enter(r2)     // Catch:{ all -> 0x026e }
                    java.lang.String r3 = "00000000"
                    boolean r3 = r1.contains(r3)     // Catch:{ all -> 0x0234 }
                    if (r3 == 0) goto L_0x0228
                    com.clevertap.android.sdk.Logger r1 = r0.getConfigLogger()     // Catch:{ all -> 0x0234 }
                    com.clevertap.android.sdk.CleverTapInstanceConfig r3 = r0.config     // Catch:{ all -> 0x0234 }
                    java.lang.String r3 = r3.accountId     // Catch:{ all -> 0x0234 }
                    java.lang.String r4 = "Device user has opted out of sharing Advertising ID, falling back to random UUID for CleverTap ID generation"
                    r1.debug(r3, r4)     // Catch:{ all -> 0x0234 }
                    monitor-exit(r2)     // Catch:{ all -> 0x0234 }
                    monitor-exit(r0)
                    goto L_0x0256
                L_0x0228:
                    java.lang.String r3 = "-"
                    java.lang.String r4 = ""
                    java.lang.String r1 = r1.replace(r3, r4)     // Catch:{ all -> 0x0234 }
                    r0.googleAdID = r1     // Catch:{ all -> 0x0234 }
                    monitor-exit(r2)     // Catch:{ all -> 0x0234 }
                    goto L_0x0237
                L_0x0234:
                    r1 = move-exception
                    monitor-exit(r2)     // Catch:{ all -> 0x0234 }
                    throw r1     // Catch:{ all -> 0x026e }
                L_0x0237:
                    com.clevertap.android.sdk.Logger r1 = r0.getConfigLogger()     // Catch:{ all -> 0x026e }
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x026e }
                    r2.<init>()     // Catch:{ all -> 0x026e }
                    com.clevertap.android.sdk.CleverTapInstanceConfig r3 = r0.config     // Catch:{ all -> 0x026e }
                    java.lang.String r3 = r3.accountId     // Catch:{ all -> 0x026e }
                    r2.append(r3)     // Catch:{ all -> 0x026e }
                    java.lang.String r3 = ":async_deviceID"
                    r2.append(r3)     // Catch:{ all -> 0x026e }
                    java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x026e }
                    java.lang.String r3 = "fetchGoogleAdID() done executing!"
                    r1.verbose(r2, r3)     // Catch:{ all -> 0x026e }
                L_0x0255:
                    monitor-exit(r0)
                L_0x0256:
                    r0.generateDeviceID()
                    com.clevertap.android.sdk.Logger r1 = r0.getConfigLogger()
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    com.clevertap.android.sdk.CleverTapInstanceConfig r0 = r0.config
                    java.lang.String r0 = r0.accountId
                    java.lang.String r3 = ":async_deviceID"
                    java.lang.String r4 = "initDeviceID() done executing!"
                    com.android.tools.r8.GeneratedOutlineSupport.outline101(r2, r0, r3, r1, r4)
                L_0x026d:
                    return r6
                L_0x026e:
                    r1 = move-exception
                    monitor-exit(r0)
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.DeviceInfo.AnonymousClass3.call():java.lang.Object");
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
        GeneratedOutlineSupport.outline101(new StringBuilder(), cleverTapInstanceConfig.accountId, ":async_deviceID", getConfigLogger(), "DeviceInfo() called");
    }

    public static int getDeviceType(Context context2) {
        if (sDeviceType == -1) {
            try {
                if (((UiModeManager) context2.getSystemService("uimode")).getCurrentModeType() == 4) {
                    sDeviceType = 3;
                    return 3;
                }
            } catch (Exception e2) {
                Logger.d("Failed to decide whether device is a TV!");
                e2.printStackTrace();
            }
            try {
                sDeviceType = context2.getResources().getBoolean(R$bool.ctIsTablet) ? 2 : 1;
            } catch (Exception e3) {
                Logger.d("Failed to decide whether device is a smart phone or tablet!");
                e3.printStackTrace();
                sDeviceType = 0;
            }
        }
        return sDeviceType;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0020, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String _getDeviceID() {
        /*
            r4 = this;
            java.lang.Object r0 = r4.deviceIDLock
            monitor-enter(r0)
            com.clevertap.android.sdk.CleverTapInstanceConfig r1 = r4.config     // Catch:{ all -> 0x002d }
            boolean r1 = r1.isDefaultInstance     // Catch:{ all -> 0x002d }
            r2 = 0
            if (r1 == 0) goto L_0x0021
            android.content.Context r1 = r4.context     // Catch:{ all -> 0x002d }
            java.lang.String r3 = r4.getDeviceIdStorageKey()     // Catch:{ all -> 0x002d }
            java.lang.String r1 = co.hyperverge.hypersnapsdk.c.k.getString(r1, r3, r2)     // Catch:{ all -> 0x002d }
            if (r1 == 0) goto L_0x0017
            goto L_0x001f
        L_0x0017:
            android.content.Context r1 = r4.context     // Catch:{ all -> 0x002d }
            java.lang.String r3 = "deviceId"
            java.lang.String r1 = co.hyperverge.hypersnapsdk.c.k.getString(r1, r3, r2)     // Catch:{ all -> 0x002d }
        L_0x001f:
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            return r1
        L_0x0021:
            android.content.Context r1 = r4.context     // Catch:{ all -> 0x002d }
            java.lang.String r3 = r4.getDeviceIdStorageKey()     // Catch:{ all -> 0x002d }
            java.lang.String r1 = co.hyperverge.hypersnapsdk.c.k.getString(r1, r3, r2)     // Catch:{ all -> 0x002d }
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            return r1
        L_0x002d:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.DeviceInfo._getDeviceID():java.lang.String");
    }

    public void forceUpdateCustomCleverTapID(String str) {
        if (Utils.validateCTID(str)) {
            getConfigLogger().info(this.config.accountId, "Setting CleverTap ID to custom CleverTap ID : " + str);
            forceUpdateDeviceId("__h" + str);
            return;
        }
        synchronized (this) {
            if (getFallBackDeviceID() == null) {
                synchronized (this.deviceIDLock) {
                    String str2 = "__i" + UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
                    if (str2.trim().length() > 2) {
                        updateFallbackID(str2);
                    } else {
                        getConfigLogger().verbose(this.config.accountId, (String) "Unable to generate fallback error device ID");
                    }
                }
            }
        }
        k.persist(k.getPreferences(this.context).edit().remove(getDeviceIdStorageKey()));
        getConfigLogger().info(this.config.accountId, recordDeviceError(21, str, getFallBackDeviceID()));
    }

    @SuppressLint({"CommitPrefEdits"})
    public void forceUpdateDeviceId(String str) {
        Logger configLogger = getConfigLogger();
        String str2 = this.config.accountId;
        configLogger.verbose(str2, "Force updating the device ID to " + str);
        synchronized (this.deviceIDLock) {
            k.putString(this.context, getDeviceIdStorageKey(), str);
        }
    }

    public final synchronized void generateDeviceID() {
        String str;
        String generateGUID;
        getConfigLogger().verbose(this.config.accountId + ":async_deviceID", (String) "generateDeviceID() called!");
        if (getGoogleAdID() != null) {
            str = "__g" + r0;
        } else {
            synchronized (this.deviceIDLock) {
                generateGUID = generateGUID();
            }
            str = generateGUID;
        }
        forceUpdateDeviceId(str);
        getConfigLogger().verbose(this.config.accountId + ":async_deviceID", (String) "generateDeviceID() done executing!");
    }

    public final String generateGUID() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73(HSLCriteriaBuilder.DIFF_CHAR);
        outline73.append(UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ""));
        return outline73.toString();
    }

    public JSONObject getAppLaunchedFields() {
        try {
            JSONObject from = k.from(this, this.mCoreMetaData.locationFromUser, this.enableNetworkInfoReporting, getGoogleAdID() != null ? new LoginInfoProvider(this.context, this.config, this).deviceIsMultiUser() : false);
            if (this.mCoreMetaData.directCallSDKVersion != 0) {
                from.put("dcv", this.mCoreMetaData.directCallSDKVersion);
            }
            return from;
        } catch (Throwable th) {
            this.config.getLogger().verbose(this.config.accountId, "Failed to construct App Launched event", th);
            return new JSONObject();
        }
    }

    public final Logger getConfigLogger() {
        return this.config.getLogger();
    }

    public String getCountryCode() {
        return getDeviceCachedInfo().countryCode;
    }

    public final DeviceCachedInfo getDeviceCachedInfo() {
        if (this.cachedInfo == null) {
            this.cachedInfo = new DeviceCachedInfo();
        }
        return this.cachedInfo;
    }

    public String getDeviceID() {
        return _getDeviceID() != null ? _getDeviceID() : getFallBackDeviceID();
    }

    public final String getDeviceIdStorageKey() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("deviceId:");
        outline73.append(this.config.accountId);
        return outline73.toString();
    }

    public final String getFallBackDeviceID() {
        Context context2 = this.context;
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("fallbackId:");
        outline73.append(this.config.accountId);
        return k.getString(context2, outline73.toString(), null);
    }

    public String getGoogleAdID() {
        String str;
        synchronized (this.adIDLock) {
            try {
                str = this.googleAdID;
            }
        }
        return str;
    }

    public int getSdkVersion() {
        return getDeviceCachedInfo().sdkVersion;
    }

    public boolean isErrorDeviceId() {
        return getDeviceID() != null && getDeviceID().startsWith("__i");
    }

    public String optOutKey() {
        String deviceID = getDeviceID();
        if (deviceID == null) {
            return null;
        }
        return GeneratedOutlineSupport.outline50("OptOut:", deviceID);
    }

    public final String recordDeviceError(int i, String... strArr) {
        ValidationResult create = k.create(GL20.GL_EQUAL, i, strArr);
        this.validationResults.add(create);
        return create.errorDesc;
    }

    public void setCurrentUserOptOutStateFromStorage() {
        String optOutKey = optOutKey();
        if (optOutKey == null) {
            this.config.getLogger().verbose(this.config.accountId, (String) "Unable to set current user OptOut state from storage: storage key is null");
            return;
        }
        boolean booleanFromPrefs = k.getBooleanFromPrefs(this.context, this.config, optOutKey);
        this.mCoreMetaData.setCurrentUserOptedOut(booleanFromPrefs);
        Logger logger = this.config.getLogger();
        String str = this.config.accountId;
        logger.verbose(str, "Set current user OptOut state from storage to: " + booleanFromPrefs + " for key: " + optOutKey);
    }

    public final void updateFallbackID(String str) {
        Logger configLogger = getConfigLogger();
        String str2 = this.config.accountId;
        configLogger.verbose(str2, "Updating the fallback id - " + str);
        Context context2 = this.context;
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("fallbackId:");
        outline73.append(this.config.accountId);
        k.putString(context2, outline73.toString(), str);
    }
}
