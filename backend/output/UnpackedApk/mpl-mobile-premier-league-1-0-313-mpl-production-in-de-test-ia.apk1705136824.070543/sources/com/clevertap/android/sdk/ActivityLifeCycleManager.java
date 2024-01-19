package com.clevertap.android.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import co.hyperverge.hypersnapsdk.c.k;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.events.BaseEventQueueManager;
import com.clevertap.android.sdk.inapp.InAppController;
import com.clevertap.android.sdk.pushnotification.PushConstants.PushType;
import com.clevertap.android.sdk.pushnotification.PushProviders;
import com.clevertap.android.sdk.task.CTExecutorFactory;
import com.clevertap.android.sdk.task.MainLooperHandler;
import com.clevertap.android.sdk.task.Task;
import java.util.Iterator;
import java.util.concurrent.Callable;
import org.apache.fontbox.cmap.CMapParser;

public class ActivityLifeCycleManager {
    public final AnalyticsManager analyticsManager;
    public final BaseEventQueueManager baseEventQueueManager;
    public final BaseCallbackManager callbackManager;
    public final CleverTapInstanceConfig config;
    public final Context context;
    public final CoreMetaData coreMetaData;
    public final InAppController inAppController;
    public final PushProviders pushProviders;
    public final SessionManager sessionManager;

    public ActivityLifeCycleManager(Context context2, CleverTapInstanceConfig cleverTapInstanceConfig, AnalyticsManager analyticsManager2, CoreMetaData coreMetaData2, SessionManager sessionManager2, PushProviders pushProviders2, BaseCallbackManager baseCallbackManager, InAppController inAppController2, BaseEventQueueManager baseEventQueueManager2) {
        this.context = context2;
        this.config = cleverTapInstanceConfig;
        this.analyticsManager = analyticsManager2;
        this.coreMetaData = coreMetaData2;
        this.sessionManager = sessionManager2;
        this.pushProviders = pushProviders2;
        this.callbackManager = baseCallbackManager;
        this.inAppController = inAppController2;
        this.baseEventQueueManager = baseEventQueueManager2;
    }

    public static void access$300(ActivityLifeCycleManager activityLifeCycleManager) {
        activityLifeCycleManager.config.getLogger().verbose(activityLifeCycleManager.config.accountId, (String) "Starting to handle install referrer");
        try {
            final InstallReferrerClient build = InstallReferrerClient.newBuilder(activityLifeCycleManager.context).build();
            build.startConnection(new InstallReferrerStateListener() {
                public void onInstallReferrerServiceDisconnected() {
                    ActivityLifeCycleManager activityLifeCycleManager = ActivityLifeCycleManager.this;
                    if (!activityLifeCycleManager.coreMetaData.installReferrerDataSent) {
                        ActivityLifeCycleManager.access$300(activityLifeCycleManager);
                    }
                }

                public void onInstallReferrerSetupFinished(int i) {
                    if (i == 0) {
                        try {
                            ReferrerDetails installReferrer = build.getInstallReferrer();
                            String installReferrer2 = installReferrer.getInstallReferrer();
                            ActivityLifeCycleManager.this.coreMetaData.referrerClickTime = installReferrer.getReferrerClickTimestampSeconds();
                            ActivityLifeCycleManager.this.coreMetaData.appInstallTime = installReferrer.getInstallBeginTimestampSeconds();
                            ActivityLifeCycleManager.this.analyticsManager.pushInstallReferrer(installReferrer2);
                            ActivityLifeCycleManager.this.coreMetaData.installReferrerDataSent = true;
                            Logger logger = ActivityLifeCycleManager.this.config.getLogger();
                            String str = ActivityLifeCycleManager.this.config.accountId;
                            logger.debug(str, "Install Referrer data set [Referrer URL-" + installReferrer2 + CMapParser.MARK_END_OF_ARRAY);
                        } catch (RemoteException e2) {
                            Logger logger2 = ActivityLifeCycleManager.this.config.getLogger();
                            String str2 = ActivityLifeCycleManager.this.config.accountId;
                            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Remote exception caused by Google Play Install Referrer library - ");
                            outline73.append(e2.getMessage());
                            logger2.debug(str2, outline73.toString());
                            build.endConnection();
                            ActivityLifeCycleManager.this.coreMetaData.installReferrerDataSent = false;
                        } catch (NullPointerException e3) {
                            Logger logger3 = ActivityLifeCycleManager.this.config.getLogger();
                            String str3 = ActivityLifeCycleManager.this.config.accountId;
                            StringBuilder outline732 = GeneratedOutlineSupport.outline73("Install referrer client null pointer exception caused by Google Play Install Referrer library - ");
                            outline732.append(e3.getMessage());
                            logger3.debug(str3, outline732.toString());
                            build.endConnection();
                            ActivityLifeCycleManager.this.coreMetaData.installReferrerDataSent = false;
                        }
                    } else if (i == 1) {
                        ActivityLifeCycleManager.this.config.getLogger().debug(ActivityLifeCycleManager.this.config.accountId, "Install Referrer data not set, connection to Play Store unavailable");
                    } else if (i == 2) {
                        ActivityLifeCycleManager.this.config.getLogger().debug(ActivityLifeCycleManager.this.config.accountId, "Install Referrer data not set, API not supported by Play Store on device");
                    }
                }
            });
        } catch (Throwable th) {
            Logger logger = activityLifeCycleManager.config.getLogger();
            String str = activityLifeCycleManager.config.accountId;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Google Play Install Referrer's InstallReferrerClient Class not found - ");
            outline73.append(th.getLocalizedMessage());
            outline73.append(" \n Please add implementation 'com.android.installreferrer:installreferrer:2.1' to your build.gradle");
            logger.verbose(str, outline73.toString());
        }
    }

    public void activityPaused() {
        CoreMetaData.appForeground = false;
        this.sessionManager.appLastSeen = System.currentTimeMillis();
        this.config.getLogger().verbose(this.config.accountId, (String) "App in background");
        Task postAsyncSafelyTask = CTExecutorFactory.executors(this.config).postAsyncSafelyTask();
        postAsyncSafelyTask.executor.execute(new Runnable("activityPaused", new Callable<Void>() {
            public Object call() throws Exception {
                int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                if (ActivityLifeCycleManager.this.coreMetaData.inCurrentSession()) {
                    try {
                        k.putInt(ActivityLifeCycleManager.this.context, k.storageKeyWithSuffix(ActivityLifeCycleManager.this.config, "sexe"), currentTimeMillis);
                        Logger logger = ActivityLifeCycleManager.this.config.getLogger();
                        String str = ActivityLifeCycleManager.this.config.accountId;
                        logger.verbose(str, "Updated session time: " + currentTimeMillis);
                    } catch (Throwable th) {
                        Logger logger2 = ActivityLifeCycleManager.this.config.getLogger();
                        String str2 = ActivityLifeCycleManager.this.config.accountId;
                        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Failed to update session time time: ");
                        outline73.append(th.getMessage());
                        logger2.verbose(str2, outline73.toString());
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

    public void activityResumed(Activity activity) {
        this.config.getLogger().verbose(this.config.accountId, (String) "App in foreground");
        SessionManager sessionManager2 = this.sessionManager;
        if (sessionManager2.appLastSeen > 0 && System.currentTimeMillis() - sessionManager2.appLastSeen > 1200000) {
            sessionManager2.config.getLogger().verbose(sessionManager2.config.accountId, (String) "Session Timed Out");
            sessionManager2.destroySession();
            CoreMetaData.setCurrentActivity(null);
        }
        if (!this.coreMetaData.isAppLaunchPushed()) {
            this.analyticsManager.pushAppLaunchedEvent();
            this.analyticsManager.fetchFeatureFlags();
            PushProviders pushProviders2 = this.pushProviders;
            Task ioTask = CTExecutorFactory.executors(pushProviders2.config).ioTask();
            ioTask.executor.execute(new Runnable("PushProviders#refreshAllTokens", new Callable<Void>() {
                public Object call() throws Exception {
                    PushProviders pushProviders = PushProviders.this;
                    Iterator<CTPushProvider> it = pushProviders.availableCTPushProviders.iterator();
                    while (it.hasNext()) {
                        CTPushProvider next = it.next();
                        try {
                            next.requestToken();
                        } catch (Throwable th) {
                            CleverTapInstanceConfig cleverTapInstanceConfig = pushProviders.config;
                            cleverTapInstanceConfig.logger.verbose(cleverTapInstanceConfig.getDefaultSuffix("PushProvider"), "Token Refresh error " + next, th);
                        }
                    }
                    PushProviders pushProviders2 = PushProviders.this;
                    Iterator<PushType> it2 = pushProviders2.customEnabledPushTypes.iterator();
                    while (it2.hasNext()) {
                        PushType next2 = it2.next();
                        try {
                            pushProviders2.pushDeviceTokenEvent(pushProviders2.getCachedToken(next2), true, next2);
                        } catch (Throwable th2) {
                            CleverTapInstanceConfig cleverTapInstanceConfig2 = pushProviders2.config;
                            cleverTapInstanceConfig2.logger.verbose(cleverTapInstanceConfig2.getDefaultSuffix("PushProvider"), "Token Refresh error " + next2, th2);
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
            Task postAsyncSafelyTask = CTExecutorFactory.executors(this.config).postAsyncSafelyTask();
            postAsyncSafelyTask.executor.execute(new Runnable("HandlingInstallReferrer", new Callable<Void>() {
                public Object call() throws Exception {
                    ActivityLifeCycleManager activityLifeCycleManager = ActivityLifeCycleManager.this;
                    CoreMetaData coreMetaData = activityLifeCycleManager.coreMetaData;
                    if (!coreMetaData.installReferrerDataSent && coreMetaData.firstSession) {
                        ActivityLifeCycleManager.access$300(activityLifeCycleManager);
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
            try {
                if (((CallbackManager) this.callbackManager) == null) {
                    throw null;
                }
            } catch (IllegalStateException e2) {
                this.config.getLogger().verbose(this.config.accountId, e2.getLocalizedMessage());
            } catch (Exception unused) {
                this.config.getLogger().verbose(this.config.accountId, (String) "Failed to trigger location");
            }
        }
        this.baseEventQueueManager.pushInitialEventsAsync();
        InAppController inAppController2 = this.inAppController;
        if (inAppController2.canShowInAppOnActivity() && InAppController.currentlyDisplayingInApp != null && System.currentTimeMillis() / 1000 < InAppController.currentlyDisplayingInApp.timeToLive) {
            FragmentActivity fragmentActivity = (FragmentActivity) activity;
            Fragment fragment = fragmentActivity.getSupportFragmentManager().getFragment(new Bundle(), InAppController.currentlyDisplayingInApp.type);
            if (!(CoreMetaData.getCurrentActivity() == null || fragment == null)) {
                FragmentTransaction beginTransaction = fragmentActivity.getSupportFragmentManager().beginTransaction();
                Bundle bundle = new Bundle();
                bundle.putParcelable("inApp", InAppController.currentlyDisplayingInApp);
                bundle.putParcelable("config", inAppController2.config);
                fragment.setArguments(bundle);
                beginTransaction.setCustomAnimations(17498112, 17498113);
                beginTransaction.add(16908290, fragment, InAppController.currentlyDisplayingInApp.type);
                String str = inAppController2.config.accountId;
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("calling InAppFragment ");
                outline73.append(InAppController.currentlyDisplayingInApp.campaignId);
                Logger.v(str, outline73.toString());
                beginTransaction.commit();
            }
        }
        InAppController inAppController3 = this.inAppController;
        if (!inAppController3.canShowInAppOnActivity()) {
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("In-app notifications will not be shown for this activity (");
            outline732.append(activity != null ? activity.getLocalClassName() : "");
            outline732.append(")");
            Logger.d(outline732.toString());
        } else if (inAppController3.mainLooperHandler.pendingRunnable != null) {
            inAppController3.logger.verbose(inAppController3.config.accountId, (String) "Found a pending inapp runnable. Scheduling it");
            MainLooperHandler mainLooperHandler = inAppController3.mainLooperHandler;
            mainLooperHandler.postDelayed(mainLooperHandler.pendingRunnable, 200);
            inAppController3.mainLooperHandler.pendingRunnable = null;
        } else {
            inAppController3.showNotificationIfAvailable(inAppController3.context);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0007, code lost:
        if (r2.config.isDefaultInstance == false) goto L_0x0009;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0018 A[ADDED_TO_REGION, Catch:{ all -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityCreated(android.os.Bundle r3, android.net.Uri r4, java.lang.String r5) {
        /*
            r2 = this;
            r0 = 0
            if (r5 != 0) goto L_0x0009
            com.clevertap.android.sdk.CleverTapInstanceConfig r1 = r2.config     // Catch:{ all -> 0x0035 }
            boolean r1 = r1.isDefaultInstance     // Catch:{ all -> 0x0035 }
            if (r1 != 0) goto L_0x0013
        L_0x0009:
            com.clevertap.android.sdk.CleverTapInstanceConfig r1 = r2.config     // Catch:{ all -> 0x0035 }
            java.lang.String r1 = r1.accountId     // Catch:{ all -> 0x0035 }
            boolean r5 = r1.equals(r5)     // Catch:{ all -> 0x0035 }
            if (r5 == 0) goto L_0x0015
        L_0x0013:
            r5 = 1
            goto L_0x0016
        L_0x0015:
            r5 = 0
        L_0x0016:
            if (r5 == 0) goto L_0x004a
            if (r3 == 0) goto L_0x002d
            boolean r5 = r3.isEmpty()     // Catch:{ all -> 0x0035 }
            if (r5 != 0) goto L_0x002d
            java.lang.String r5 = "wzrk_pn"
            boolean r5 = r3.containsKey(r5)     // Catch:{ all -> 0x0035 }
            if (r5 == 0) goto L_0x002d
            com.clevertap.android.sdk.AnalyticsManager r5 = r2.analyticsManager     // Catch:{ all -> 0x0035 }
            r5.pushNotificationClickedEvent(r3)     // Catch:{ all -> 0x0035 }
        L_0x002d:
            if (r4 == 0) goto L_0x004a
            com.clevertap.android.sdk.AnalyticsManager r3 = r2.analyticsManager     // Catch:{ all -> 0x004a }
            r3.pushDeepLink(r4, r0)     // Catch:{ all -> 0x004a }
            goto L_0x004a
        L_0x0035:
            r3 = move-exception
            java.lang.String r4 = "Throwable - "
            java.lang.StringBuilder r4 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r4)
            java.lang.String r3 = r3.getLocalizedMessage()
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            com.clevertap.android.sdk.Logger.v(r3)
        L_0x004a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.ActivityLifeCycleManager.onActivityCreated(android.os.Bundle, android.net.Uri, java.lang.String):void");
    }
}
