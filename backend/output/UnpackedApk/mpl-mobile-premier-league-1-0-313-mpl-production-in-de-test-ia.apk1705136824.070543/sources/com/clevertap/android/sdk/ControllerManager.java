package com.clevertap.android.sdk;

import android.content.Context;
import com.clevertap.android.sdk.CleverTapAPI.LogLevel;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.db.BaseDatabaseManager;
import com.clevertap.android.sdk.displayunits.CTDisplayUnitController;
import com.clevertap.android.sdk.featureFlags.CTFeatureFlagsController;
import com.clevertap.android.sdk.inapp.InAppController;
import com.clevertap.android.sdk.inbox.CTInboxController;
import com.clevertap.android.sdk.product_config.CTProductConfigController;
import com.clevertap.android.sdk.pushnotification.PushProviders;
import com.clevertap.android.sdk.task.CTExecutorFactory;
import com.clevertap.android.sdk.task.Task;
import java.util.concurrent.Callable;

public class ControllerManager {
    public final BaseDatabaseManager baseDatabaseManager;
    public final BaseCallbackManager callbackManager;
    public final CleverTapInstanceConfig config;
    public final Context context;
    public CTDisplayUnitController ctDisplayUnitController;
    public CTFeatureFlagsController ctFeatureFlagsController;
    public CTInboxController ctInboxController;
    public final CTLockManager ctLockManager;
    public CTProductConfigController ctProductConfigController;
    public final DeviceInfo deviceInfo;
    public InAppController inAppController;
    public InAppFCManager inAppFCManager;
    public PushProviders pushProviders;

    public ControllerManager(Context context2, CleverTapInstanceConfig cleverTapInstanceConfig, CTLockManager cTLockManager, BaseCallbackManager baseCallbackManager, DeviceInfo deviceInfo2, BaseDatabaseManager baseDatabaseManager2) {
        this.config = cleverTapInstanceConfig;
        this.ctLockManager = cTLockManager;
        this.callbackManager = baseCallbackManager;
        this.deviceInfo = deviceInfo2;
        this.context = context2;
        this.baseDatabaseManager = baseDatabaseManager2;
    }

    public void initializeInbox() {
        CleverTapInstanceConfig cleverTapInstanceConfig = this.config;
        if (cleverTapInstanceConfig.analyticsOnly) {
            cleverTapInstanceConfig.getLogger().debug(this.config.accountId, "Instance is analytics only, not initializing Notification Inbox");
            return;
        }
        Task postAsyncSafelyTask = CTExecutorFactory.executors(cleverTapInstanceConfig).postAsyncSafelyTask();
        postAsyncSafelyTask.executor.execute(new Runnable("initializeInbox", new Callable<Void>() {
            public Object call() throws Exception {
                ControllerManager controllerManager = ControllerManager.this;
                synchronized (controllerManager.ctLockManager.inboxControllerLock) {
                    if (controllerManager.ctInboxController != null) {
                        CTInboxListener cTInboxListener = ((CallbackManager) controllerManager.callbackManager).inboxListener;
                        if (cTInboxListener != null) {
                            cTInboxListener.inboxDidInitialize();
                        }
                    } else if (controllerManager.deviceInfo.getDeviceID() != null) {
                        CTInboxController cTInboxController = new CTInboxController(controllerManager.config, controllerManager.deviceInfo.getDeviceID(), controllerManager.baseDatabaseManager.loadDBAdapter(controllerManager.context), controllerManager.ctLockManager, controllerManager.callbackManager, Utils.haveVideoPlayerSupport);
                        controllerManager.ctInboxController = cTInboxController;
                        CTInboxListener cTInboxListener2 = ((CallbackManager) controllerManager.callbackManager).inboxListener;
                        if (cTInboxListener2 != null) {
                            cTInboxListener2.inboxDidInitialize();
                        }
                    } else {
                        int i = controllerManager.config.getLogger().debugLevel;
                        LogLevel.INFO.intValue();
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
    }
}
