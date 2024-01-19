package com.clevertap.android.sdk.login;

import android.content.Context;
import co.hyperverge.hypersnapsdk.c.k;
import com.clevertap.android.sdk.AnalyticsManager;
import com.clevertap.android.sdk.BaseCallbackManager;
import com.clevertap.android.sdk.CTLockManager;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.ControllerManager;
import com.clevertap.android.sdk.CoreMetaData;
import com.clevertap.android.sdk.DeviceInfo;
import com.clevertap.android.sdk.InAppFCManager;
import com.clevertap.android.sdk.LocalDataStore;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.SessionManager;
import com.clevertap.android.sdk.db.BaseDatabaseManager;
import com.clevertap.android.sdk.db.DBManager;
import com.clevertap.android.sdk.displayunits.CTDisplayUnitController;
import com.clevertap.android.sdk.events.BaseEventQueueManager;
import com.clevertap.android.sdk.events.EventGroup;
import com.clevertap.android.sdk.featureFlags.CTFeatureFlagsController;
import com.clevertap.android.sdk.product_config.CTProductConfigController;
import com.clevertap.android.sdk.product_config.ProductConfigSettings;
import com.clevertap.android.sdk.pushnotification.PushProviders;
import com.clevertap.android.sdk.task.CTExecutorFactory;
import com.clevertap.android.sdk.task.Task;
import com.clevertap.android.sdk.utils.FileUtils;
import com.clevertap.android.sdk.validation.ValidationResult;
import com.clevertap.android.sdk.validation.ValidationResultStack;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;

public class LoginController {
    public static final Object processingUserLoginLock = new Object();
    public final AnalyticsManager analyticsManager;
    public final BaseEventQueueManager baseEventQueueManager;
    public String cachedGUID = null;
    public final BaseCallbackManager callbackManager;
    public final CleverTapInstanceConfig config;
    public final Context context;
    public final ControllerManager controllerManager;
    public final CoreMetaData coreMetaData;
    public final CTLockManager ctLockManager;
    public final BaseDatabaseManager dbManager;
    public final DeviceInfo deviceInfo;
    public final LocalDataStore localDataStore;
    public String processingUserLoginIdentifier = null;
    public final PushProviders pushProviders;
    public final SessionManager sessionManager;
    public final ValidationResultStack validationResultStack;

    public LoginController(Context context2, CleverTapInstanceConfig cleverTapInstanceConfig, DeviceInfo deviceInfo2, ValidationResultStack validationResultStack2, BaseEventQueueManager baseEventQueueManager2, AnalyticsManager analyticsManager2, CoreMetaData coreMetaData2, ControllerManager controllerManager2, SessionManager sessionManager2, LocalDataStore localDataStore2, BaseCallbackManager baseCallbackManager, DBManager dBManager, CTLockManager cTLockManager) {
        this.config = cleverTapInstanceConfig;
        this.context = context2;
        this.deviceInfo = deviceInfo2;
        this.validationResultStack = validationResultStack2;
        this.baseEventQueueManager = baseEventQueueManager2;
        this.analyticsManager = analyticsManager2;
        this.coreMetaData = coreMetaData2;
        this.pushProviders = controllerManager2.pushProviders;
        this.sessionManager = sessionManager2;
        this.localDataStore = localDataStore2;
        this.callbackManager = baseCallbackManager;
        this.dbManager = dBManager;
        this.controllerManager = controllerManager2;
        this.ctLockManager = cTLockManager;
    }

    public static void access$1500(LoginController loginController) {
        CTFeatureFlagsController cTFeatureFlagsController = loginController.controllerManager.ctFeatureFlagsController;
        if (cTFeatureFlagsController == null || !cTFeatureFlagsController.isInitialized) {
            loginController.config.getLogger().verbose(loginController.config.accountId, (String) "DisplayUnit : Can't reset Display Units, CTFeatureFlagsController is null");
            return;
        }
        cTFeatureFlagsController.guid = loginController.deviceInfo.getDeviceID();
        cTFeatureFlagsController.init();
        Task mainTask = CTExecutorFactory.executors(cTFeatureFlagsController.config).mainTask();
        mainTask.executor.execute(new Runnable("fetchFeatureFlags", new Callable<Void>() {
            public Object call() throws Exception {
                try {
                    CTFeatureFlagsController.this.mAnalyticsManager.fetchFeatureFlags();
                } catch (Exception e2) {
                    CTFeatureFlagsController.this.getConfigLogger().verbose(CTFeatureFlagsController.this.getLogTag(), e2.getLocalizedMessage());
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

    public static void access$1600(LoginController loginController) {
        CleverTapInstanceConfig cleverTapInstanceConfig = loginController.config;
        if (cleverTapInstanceConfig.analyticsOnly) {
            cleverTapInstanceConfig.getLogger().debug(loginController.config.accountId, "Product Config is not enabled for this instance");
            return;
        }
        CTProductConfigController cTProductConfigController = loginController.controllerManager.ctProductConfigController;
        if (cTProductConfigController != null) {
            ProductConfigSettings productConfigSettings = cTProductConfigController.settings;
            FileUtils fileUtils = cTProductConfigController.fileUtils;
            productConfigSettings.initDefaults();
            if (fileUtils != null) {
                Task ioTask = CTExecutorFactory.executors(productConfigSettings.config).ioTask();
                ioTask.executor.execute(new Runnable("ProductConfigSettings#eraseStoredSettingsFile", new Callable<Void>(fileUtils) {
                    public final /* synthetic */ FileUtils val$fileUtils;

                    {
                        this.val$fileUtils = r2;
                    }

                    public Object call() throws Exception {
                        synchronized (this) {
                            try {
                                String fullPath = ProductConfigSettings.this.getFullPath();
                                this.val$fileUtils.deleteFile(fullPath);
                                Logger logger = ProductConfigSettings.this.config.getLogger();
                                String logTag = k.getLogTag(ProductConfigSettings.this.config);
                                logger.verbose(logTag, "Deleted settings file" + fullPath);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                Logger logger2 = ProductConfigSettings.this.config.getLogger();
                                String logTag2 = k.getLogTag(ProductConfigSettings.this.config);
                                logger2.verbose(logTag2, "Error while resetting settings" + e2.getLocalizedMessage());
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
            } else {
                throw new IllegalArgumentException("FileUtils can't be null");
            }
        }
        Context context2 = loginController.context;
        DeviceInfo deviceInfo2 = loginController.deviceInfo;
        CleverTapInstanceConfig cleverTapInstanceConfig2 = loginController.config;
        AnalyticsManager analyticsManager2 = loginController.analyticsManager;
        CoreMetaData coreMetaData2 = loginController.coreMetaData;
        BaseCallbackManager baseCallbackManager = loginController.callbackManager;
        String deviceID = deviceInfo2.getDeviceID();
        FileUtils fileUtils2 = new FileUtils(context2, cleverTapInstanceConfig2);
        CTProductConfigController cTProductConfigController2 = new CTProductConfigController(context2, cleverTapInstanceConfig2, analyticsManager2, coreMetaData2, baseCallbackManager, new ProductConfigSettings(deviceID, cleverTapInstanceConfig2, fileUtils2), fileUtils2);
        loginController.controllerManager.ctProductConfigController = cTProductConfigController2;
        loginController.config.getLogger().verbose(loginController.config.accountId, (String) "Product Config reset");
    }

    public void asyncProfileSwitchUser(final Map<String, Object> map, final String str, final String str2) {
        Task postAsyncSafelyTask = CTExecutorFactory.executors(this.config).postAsyncSafelyTask();
        postAsyncSafelyTask.executor.execute(new Runnable("resetProfile", new Callable<Void>() {
            public Object call() throws Exception {
                String str;
                try {
                    Logger logger = LoginController.this.config.getLogger();
                    String str2 = LoginController.this.config.accountId;
                    StringBuilder sb = new StringBuilder();
                    sb.append("asyncProfileSwitchUser:[profile ");
                    sb.append(map);
                    sb.append(" with Cached GUID ");
                    if (str != null) {
                        str = LoginController.this.cachedGUID;
                    } else {
                        str = "NULL and cleverTapID " + str2;
                    }
                    sb.append(str);
                    logger.verbose(str2, sb.toString());
                    LoginController.this.coreMetaData.setCurrentUserOptedOut(false);
                    LoginController.this.pushProviders.forcePushDeviceToken(false);
                    LoginController.this.baseEventQueueManager.flushQueueSync(LoginController.this.context, EventGroup.REGULAR);
                    LoginController.this.baseEventQueueManager.flushQueueSync(LoginController.this.context, EventGroup.PUSH_NOTIFICATION_VIEWED);
                    LoginController.this.dbManager.clearQueues(LoginController.this.context);
                    LoginController.this.localDataStore.changeUser();
                    CoreMetaData.activityCount = 1;
                    LoginController.this.sessionManager.destroySession();
                    if (str != null) {
                        LoginController.this.deviceInfo.forceUpdateDeviceId(str);
                        LoginController.this.callbackManager.notifyUserProfileInitialized(str);
                    } else if (LoginController.this.config.enableCustomCleverTapId) {
                        LoginController.this.deviceInfo.forceUpdateCustomCleverTapID(str2);
                    } else {
                        DeviceInfo deviceInfo = LoginController.this.deviceInfo;
                        deviceInfo.forceUpdateDeviceId(deviceInfo.generateGUID());
                    }
                    LoginController.this.callbackManager.notifyUserProfileInitialized(LoginController.this.deviceInfo.getDeviceID());
                    LoginController.this.deviceInfo.setCurrentUserOptOutStateFromStorage();
                    AnalyticsManager analyticsManager = LoginController.this.analyticsManager;
                    analyticsManager.coreMetaData.setAppLaunchPushed(false);
                    analyticsManager.pushAppLaunchedEvent();
                    if (map != null) {
                        LoginController.this.analyticsManager.pushProfile(map);
                    }
                    LoginController.this.pushProviders.forcePushDeviceToken(true);
                    synchronized (LoginController.processingUserLoginLock) {
                        LoginController.this.processingUserLoginIdentifier = null;
                    }
                    LoginController loginController = LoginController.this;
                    synchronized (loginController.ctLockManager.inboxControllerLock) {
                        loginController.controllerManager.ctInboxController = null;
                    }
                    loginController.controllerManager.initializeInbox();
                    LoginController.access$1500(LoginController.this);
                    LoginController.access$1600(LoginController.this);
                    LoginController.this.recordDeviceIDErrors();
                    LoginController loginController2 = LoginController.this;
                    CTDisplayUnitController cTDisplayUnitController = loginController2.controllerManager.ctDisplayUnitController;
                    if (cTDisplayUnitController != null) {
                        cTDisplayUnitController.reset();
                    } else {
                        loginController2.config.getLogger().verbose(loginController2.config.accountId, (String) "DisplayUnit : Can't reset Display Units, DisplayUnitcontroller is null");
                    }
                    InAppFCManager inAppFCManager = LoginController.this.controllerManager.inAppFCManager;
                    String deviceID = LoginController.this.deviceInfo.getDeviceID();
                    inAppFCManager.mShownThisSession.clear();
                    inAppFCManager.mShownThisSessionCount = 0;
                    inAppFCManager.mDismissedThisSession.clear();
                    inAppFCManager.deviceId = deviceID;
                    inAppFCManager.init(deviceID);
                } catch (Throwable th) {
                    LoginController.this.config.getLogger().verbose(LoginController.this.config.accountId, "Reset Profile error", th);
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

    public void recordDeviceIDErrors() {
        DeviceInfo deviceInfo2 = this.deviceInfo;
        deviceInfo2.validationResults.clear();
        Iterator it = ((ArrayList) deviceInfo2.validationResults.clone()).iterator();
        while (it.hasNext()) {
            this.validationResultStack.pushValidationResult((ValidationResult) it.next());
        }
    }
}
