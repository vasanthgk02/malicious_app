package com.mpl.analytics;

import android.app.Activity;
import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.core.app.NotificationManagerCompat;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.clevertap.android.pushtemplates.PushTemplateNotificationHandler;
import com.clevertap.android.sdk.CTInboxListener;
import com.clevertap.android.sdk.CTInboxStyleConfig;
import com.clevertap.android.sdk.CallbackManager;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.CleverTapAPI.AnonymousClass3;
import com.clevertap.android.sdk.CleverTapAPI.AnonymousClass4;
import com.clevertap.android.sdk.CleverTapAPI.AnonymousClass5;
import com.clevertap.android.sdk.CleverTapAPI.DevicePushTokenRefreshListener;
import com.clevertap.android.sdk.CoreState;
import com.clevertap.android.sdk.InAppNotificationListener;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.SyncListener;
import com.clevertap.android.sdk.events.EventDetail;
import com.clevertap.android.sdk.inbox.CTInboxController;
import com.clevertap.android.sdk.inbox.CTInboxMessage;
import com.clevertap.android.sdk.inbox.CTMessageDAO;
import com.clevertap.android.sdk.pushnotification.PushConstants.PushType;
import com.clevertap.android.sdk.task.CTExecutorFactory;
import com.clevertap.android.sdk.task.Task;
import com.mpl.analytics.appInbox.MCTInboxInitialisation;
import com.mpl.analytics.appInbox.MCTInboxStyleConfig;
import com.mpl.analytics.appInbox.MPLCTInboxListener;
import com.mpl.analytics.config.IMPLCleverTapConfig;
import com.mpl.analytics.debugging.IMPLCleverTapDebug;
import com.mpl.analytics.event.IMPLCleverTapEvent;
import com.mpl.analytics.lifecycle.ActivityLifeCycleEvents;
import com.mpl.analytics.notification.IMPLCleverTapNotification;
import com.mpl.analytics.profile.IMPLProfileEvent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import org.json.JSONObject;

@Keep
public class MPLAnalytics implements IMPLCleverTapEvent, IMPLCleverTapNotification, IMPLCleverTapDebug, IMPLCleverTapConfig, IMPLProfileEvent, ActivityLifeCycleEvents, MCTInboxInitialisation, MPLCTLsterner {
    public static MPLAnalytics INSTANCE = null;
    public static final String TAG = "com.mpl.analytics.MPLAnalytics";
    public static CleverTapAPI mCleverTapAPI;

    public enum DebugLevel {
        OFF(-1),
        INFO(0),
        DEBUG(2);
        
        public final int value;

        /* access modifiers changed from: public */
        DebugLevel(int i) {
            this.value = i;
        }

        public int intValue() {
            return this.value;
        }
    }

    public MPLAnalytics(Application application) {
        init(application);
    }

    public static MPLAnalytics from(Application application) {
        MPLAnalytics mPLAnalytics;
        MPLAnalytics mPLAnalytics2 = INSTANCE;
        if (mPLAnalytics2 != null) {
            return mPLAnalytics2;
        }
        synchronized (MPLAnalytics.class) {
            try {
                mPLAnalytics = new MPLAnalytics(application);
                INSTANCE = mPLAnalytics;
            }
        }
        return mPLAnalytics;
    }

    @Keep
    public static CleverTapAPI getCleverTapAPI(Application application) {
        if (mCleverTapAPI == null) {
            mCleverTapAPI = MPLCleverTapInstance.getCleverTapAPI(application);
        }
        return mCleverTapAPI;
    }

    public static void init(Application application) {
        mCleverTapAPI = MPLCleverTapInstance.getCleverTapAPI(application);
    }

    @Keep
    public static void setAppForeground(boolean z) {
        CleverTapAPI.setAppForeground(z);
    }

    public void activityPaused(Activity activity) {
        CleverTapAPI.onActivityPaused();
    }

    public void activityResumed(Activity activity) {
        CleverTapAPI.onActivityResumed(activity, null);
    }

    @Deprecated
    public void addMultiValueForKey(String str, String str2) {
        mCleverTapAPI.addMultiValueForKey(str, str2);
    }

    public void addMultiValueForKeyV2(String str, String str2) {
        mCleverTapAPI.addMultiValueForKey(str, str2);
    }

    @Deprecated
    public void addMultiValuesForKey(String str, ArrayList<String> arrayList) {
        mCleverTapAPI.addMultiValuesForKey(str, arrayList);
    }

    public void addMultiValuesForKeyV2(String str, ArrayList<String> arrayList) {
        mCleverTapAPI.addMultiValuesForKey(str, arrayList);
    }

    public void changeCredentials() {
    }

    public void createNotification(Context context, Bundle bundle, int i) {
        CleverTapAPI.createNotification(context, bundle, i);
    }

    public void createNotificationChannel(Context context, String str, CharSequence charSequence, String str2, int i, boolean z) {
        if (VERSION.SDK_INT >= 26) {
            CleverTapAPI.createNotificationChannel(context, str, charSequence, str2, i, z);
        }
    }

    public void createNotificationChannelGroup(Context context, String str, String str2) {
        if (VERSION.SDK_INT >= 26) {
            CleverTapAPI defaultInstanceOrFirstOther = CleverTapAPI.getDefaultInstanceOrFirstOther(context);
            if (defaultInstanceOrFirstOther == null) {
                Logger.v("No CleverTap Instance found in CleverTapAPI#createNotificationChannelGroup");
                return;
            }
            try {
                if (VERSION.SDK_INT >= 26) {
                    Task postAsyncSafelyTask = CTExecutorFactory.executors(defaultInstanceOrFirstOther.coreState.config).postAsyncSafelyTask();
                    postAsyncSafelyTask.executor.execute(new Runnable("creatingNotificationChannelGroup", new Callable<Void>(context, str, str2, defaultInstanceOrFirstOther) {
                        public final /* synthetic */ Context val$context;
                        public final /* synthetic */ String val$groupId;
                        public final /* synthetic */ CharSequence val$groupName;
                        public final /* synthetic */ CleverTapAPI val$instance;

                        {
                            this.val$context = r1;
                            this.val$groupId = r2;
                            this.val$groupName = r3;
                            this.val$instance = r4;
                        }

                        public Object call() throws Exception {
                            NotificationManager notificationManager = (NotificationManager) this.val$context.getSystemService("notification");
                            if (notificationManager != null) {
                                notificationManager.createNotificationChannelGroup(new NotificationChannelGroup(this.val$groupId, this.val$groupName));
                                Logger configLogger = this.val$instance.getConfigLogger();
                                String accountId = this.val$instance.getAccountId();
                                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Notification channel group ");
                                outline73.append(this.val$groupName.toString());
                                outline73.append(" has been created");
                                configLogger.info(accountId, outline73.toString());
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
            } catch (Throwable th) {
                defaultInstanceOrFirstOther.getConfigLogger().verbose(defaultInstanceOrFirstOther.getAccountId(), "Failure creating Notification Channel Group", th);
            }
        }
    }

    public void deleteInboxMessage(CTInboxMessage cTInboxMessage) {
        CleverTapAPI cleverTapAPI = mCleverTapAPI;
        CTInboxController cTInboxController = cleverTapAPI.coreState.controllerManager.ctInboxController;
        if (cTInboxController != null) {
            Task postAsyncSafelyTask = CTExecutorFactory.executors(cTInboxController.config).postAsyncSafelyTask();
            postAsyncSafelyTask.executor.execute(new Runnable("deleteInboxMessage", new Callable<Void>(cTInboxMessage) {
                public final /* synthetic */ CTInboxMessage val$message;

                {
                    this.val$message = r2;
                }

                public Object call() throws Exception {
                    synchronized (CTInboxController.this.ctLockManager.inboxControllerLock) {
                        if (CTInboxController.this._deleteMessageWithId(this.val$message.messageId)) {
                            CTInboxController.this.callbackManager._notifyInboxMessagesDidUpdate();
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
            return;
        }
        cleverTapAPI.getConfigLogger().debug(cleverTapAPI.getAccountId(), "Notification Inbox not initialized");
    }

    public void deleteNotificationChannel(Context context, String str) {
        if (VERSION.SDK_INT >= 26) {
            CleverTapAPI defaultInstanceOrFirstOther = CleverTapAPI.getDefaultInstanceOrFirstOther(context);
            if (defaultInstanceOrFirstOther == null) {
                Logger.v("No CleverTap Instance found in CleverTapAPI#deleteNotificationChannel");
                return;
            }
            try {
                if (VERSION.SDK_INT >= 26) {
                    Task postAsyncSafelyTask = CTExecutorFactory.executors(defaultInstanceOrFirstOther.coreState.config).postAsyncSafelyTask();
                    postAsyncSafelyTask.executor.execute(new Runnable("deletingNotificationChannel", new Callable<Void>(context, str, defaultInstanceOrFirstOther) {
                        public final /* synthetic */ String val$channelId;
                        public final /* synthetic */ Context val$context;
                        public final /* synthetic */ CleverTapAPI val$instance;

                        {
                            this.val$context = r1;
                            this.val$channelId = r2;
                            this.val$instance = r3;
                        }

                        public Object call() throws Exception {
                            NotificationManager notificationManager = (NotificationManager) this.val$context.getSystemService("notification");
                            if (notificationManager != null) {
                                notificationManager.deleteNotificationChannel(this.val$channelId);
                                Logger configLogger = this.val$instance.getConfigLogger();
                                String accountId = this.val$instance.getAccountId();
                                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Notification channel ");
                                outline73.append(this.val$channelId);
                                outline73.append(" has been deleted");
                                configLogger.info(accountId, outline73.toString());
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
            } catch (Throwable th) {
                defaultInstanceOrFirstOther.getConfigLogger().verbose(defaultInstanceOrFirstOther.getAccountId(), "Failure deleting Notification Channel", th);
            }
        }
    }

    public void deleteNotificationChannelGroup(Context context, String str) {
        if (VERSION.SDK_INT >= 26) {
            CleverTapAPI defaultInstanceOrFirstOther = CleverTapAPI.getDefaultInstanceOrFirstOther(context);
            if (defaultInstanceOrFirstOther == null) {
                Logger.v("No CleverTap Instance found in CleverTapAPI#deleteNotificationChannelGroup");
                return;
            }
            try {
                if (VERSION.SDK_INT >= 26) {
                    Task postAsyncSafelyTask = CTExecutorFactory.executors(defaultInstanceOrFirstOther.coreState.config).postAsyncSafelyTask();
                    postAsyncSafelyTask.executor.execute(new Runnable("deletingNotificationChannelGroup", new Callable<Void>(context, str, defaultInstanceOrFirstOther) {
                        public final /* synthetic */ Context val$context;
                        public final /* synthetic */ String val$groupId;
                        public final /* synthetic */ CleverTapAPI val$instance;

                        {
                            this.val$context = r1;
                            this.val$groupId = r2;
                            this.val$instance = r3;
                        }

                        public Object call() throws Exception {
                            NotificationManager notificationManager = (NotificationManager) this.val$context.getSystemService("notification");
                            if (notificationManager != null) {
                                notificationManager.deleteNotificationChannelGroup(this.val$groupId);
                                Logger configLogger = this.val$instance.getConfigLogger();
                                String accountId = this.val$instance.getAccountId();
                                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Notification channel group ");
                                outline73.append(this.val$groupId);
                                outline73.append(" has been deleted");
                                configLogger.info(accountId, outline73.toString());
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
            } catch (Throwable th) {
                defaultInstanceOrFirstOther.getConfigLogger().verbose(defaultInstanceOrFirstOther.getAccountId(), "Failure deleting Notification Channel Group", th);
            }
        }
    }

    public void disableNetworkInfoReporting() {
        mCleverTapAPI.enableDeviceNetworkInfoReporting(false);
    }

    public void enableNetworkInfoReporting() {
        mCleverTapAPI.enableDeviceNetworkInfoReporting(true);
    }

    public ArrayList<CTInboxMessage> getAllInboxMessages() {
        return mCleverTapAPI.getAllInboxMessages();
    }

    public String getCleverTapAttributionIdentifier() {
        return mCleverTapAPI.coreState.deviceInfo.getDeviceID();
    }

    public String getCleverTapID() {
        return mCleverTapAPI.getCleverTapID();
    }

    public String getCleverTapId() {
        return mCleverTapAPI.getCleverTapID();
    }

    @Deprecated
    public int getCount(String str) {
        EventDetail eventDetail = mCleverTapAPI.coreState.localDataStore.getEventDetail(str);
        if (eventDetail != null) {
            return eventDetail.getCount();
        }
        return -1;
    }

    public int getCountV2(String str) {
        EventDetail eventDetail = mCleverTapAPI.coreState.localDataStore.getEventDetail(str);
        if (eventDetail != null) {
            return eventDetail.getCount();
        }
        return -1;
    }

    public MPLEventDetail getDetails(String str) {
        return new MPLEventDetail(mCleverTapAPI.coreState.localDataStore.getEventDetail(str));
    }

    public String getDevicePushToken(String str) {
        if ("fcm".equalsIgnoreCase(str)) {
            CleverTapAPI cleverTapAPI = mCleverTapAPI;
            return cleverTapAPI.coreState.pushProviders.getCachedToken(PushType.FCM);
        }
        CleverTapAPI cleverTapAPI2 = mCleverTapAPI;
        return cleverTapAPI2.coreState.pushProviders.getCachedToken(PushType.FCM);
    }

    @Deprecated
    public int getFirstTime(String str) {
        EventDetail eventDetail = mCleverTapAPI.coreState.localDataStore.getEventDetail(str);
        if (eventDetail != null) {
            return eventDetail.getFirstTime();
        }
        return -1;
    }

    public int getFirstTimeV2(String str) {
        EventDetail eventDetail = mCleverTapAPI.coreState.localDataStore.getEventDetail(str);
        if (eventDetail != null) {
            return eventDetail.getFirstTime();
        }
        return -1;
    }

    @Deprecated
    public Map<String, MPLEventDetail> getHistory() {
        Map<String, EventDetail> history = mCleverTapAPI.getHistory();
        HashMap hashMap = new HashMap();
        for (Entry next : history.entrySet()) {
            hashMap.put(next.getKey(), new MPLEventDetail((EventDetail) next.getValue()));
        }
        return hashMap;
    }

    public Map<String, MPLEventDetail> getHistoryV2() {
        Map<String, EventDetail> history = mCleverTapAPI.getHistory();
        HashMap hashMap = new HashMap();
        for (Entry next : history.entrySet()) {
            hashMap.put(next.getKey(), new MPLEventDetail((EventDetail) next.getValue()));
        }
        return hashMap;
    }

    public int getInboxMessageCount() {
        return mCleverTapAPI.getInboxMessageCount();
    }

    public CTInboxMessage getInboxMessageForId(String str) {
        return mCleverTapAPI.getInboxMessageForId(str);
    }

    public int getInboxMessageUnreadCount() {
        int i;
        CleverTapAPI cleverTapAPI = mCleverTapAPI;
        synchronized (cleverTapAPI.coreState.ctLockManager.inboxControllerLock) {
            if (cleverTapAPI.coreState.controllerManager.ctInboxController != null) {
                i = cleverTapAPI.coreState.controllerManager.ctInboxController.getUnreadMessages().size();
            } else {
                cleverTapAPI.getConfigLogger().debug(cleverTapAPI.getAccountId(), "Notification Inbox not initialized");
                i = -1;
            }
        }
        return i;
    }

    @Deprecated
    public int getLastTime(String str) {
        EventDetail eventDetail = mCleverTapAPI.coreState.localDataStore.getEventDetail(str);
        if (eventDetail != null) {
            return eventDetail.getLastTime();
        }
        return -1;
    }

    public int getLastTimeV2(String str) {
        EventDetail eventDetail = mCleverTapAPI.coreState.localDataStore.getEventDetail(str);
        if (eventDetail != null) {
            return eventDetail.getLastTime();
        }
        return -1;
    }

    @Deprecated
    public Object getProperty(String str) {
        CoreState coreState = mCleverTapAPI.coreState;
        if (!coreState.config.personalization) {
            return null;
        }
        return coreState.localDataStore.getProfileValueForKey(str);
    }

    public Object getPropertyV2(String str) {
        CoreState coreState = mCleverTapAPI.coreState;
        if (!coreState.config.personalization) {
            return null;
        }
        return coreState.localDataStore.getProfileValueForKey(str);
    }

    public ArrayList<CTInboxMessage> getUnreadInboxMessages() {
        CleverTapAPI cleverTapAPI = mCleverTapAPI;
        if (cleverTapAPI != null) {
            ArrayList<CTInboxMessage> arrayList = new ArrayList<>();
            synchronized (cleverTapAPI.coreState.ctLockManager.inboxControllerLock) {
                if (cleverTapAPI.coreState.controllerManager.ctInboxController != null) {
                    Iterator<CTMessageDAO> it = cleverTapAPI.coreState.controllerManager.ctInboxController.getUnreadMessages().iterator();
                    while (it.hasNext()) {
                        arrayList.add(new CTInboxMessage(it.next().toJSON()));
                    }
                } else {
                    cleverTapAPI.getConfigLogger().debug(cleverTapAPI.getAccountId(), "Notification Inbox not initialized");
                }
            }
            return arrayList;
        }
        throw null;
    }

    public void initializeInbox() {
        mCleverTapAPI.coreState.controllerManager.initializeInbox();
    }

    public boolean isCleverTapNotification(Bundle bundle) {
        return CleverTapAPI.getNotificationInfo(bundle).fromCleverTap;
    }

    public void markReadInboxMessage(CTInboxMessage cTInboxMessage) {
        mCleverTapAPI.markReadInboxMessage(cTInboxMessage);
    }

    @Deprecated
    public void push(HashMap<String, Object> hashMap) {
        mCleverTapAPI.coreState.analyticsManager.pushProfile(hashMap);
    }

    @Deprecated
    public void pushChargedEvent(HashMap<String, Object> hashMap, ArrayList<HashMap<String, Object>> arrayList) {
        mCleverTapAPI.pushChargedEvent(hashMap, arrayList);
    }

    @Deprecated
    public void pushChargedEventV2(HashMap<String, Object> hashMap, ArrayList<HashMap<String, Object>> arrayList) {
        mCleverTapAPI.pushChargedEvent(hashMap, arrayList);
    }

    @Keep
    public void pushDeepLink(Uri uri) {
        mCleverTapAPI.coreState.analyticsManager.pushDeepLink(uri, false);
    }

    @Deprecated
    public void pushEvent(String str) {
        mCleverTapAPI.pushEvent(str);
    }

    public void pushEventV2(String str) {
        mCleverTapAPI.pushEvent(str);
    }

    public void pushFacebookUser(JSONObject jSONObject) {
    }

    public void pushGooglePlusPerson(HashMap<String, Object> hashMap) {
    }

    public void pushGooglePlusPersonV2(HashMap<String, Object> hashMap) {
    }

    @Keep
    public void pushInstallReferrer(Intent intent) {
    }

    @Keep
    public void pushInstallReferrer(String str, String str2, String str3) {
        CleverTapAPI cleverTapAPI = mCleverTapAPI;
        synchronized (cleverTapAPI) {
            cleverTapAPI.coreState.analyticsManager.pushInstallReferrer(str, str2, str3);
        }
    }

    @Deprecated
    public void pushLocation(Location location) {
        mCleverTapAPI.setLocation(location);
    }

    public void pushLocationV2(Location location) {
        mCleverTapAPI.setLocation(location);
    }

    @Deprecated
    public void pushNotificationClickedEvent(Bundle bundle) {
        mCleverTapAPI.coreState.analyticsManager.pushNotificationClickedEvent(bundle);
    }

    public void pushNotificationClickedEventV2(Bundle bundle) {
        mCleverTapAPI.coreState.analyticsManager.pushNotificationClickedEvent(bundle);
    }

    @Deprecated
    public void pushNotificationViewedEvent(Bundle bundle) {
        mCleverTapAPI.coreState.analyticsManager.pushNotificationViewedEvent(bundle);
    }

    public void pushNotificationViewedEventV2(Bundle bundle) {
        mCleverTapAPI.coreState.analyticsManager.pushNotificationViewedEvent(bundle);
    }

    public void pushOnUserLoginEvent(HashMap<String, Object> hashMap) {
        mCleverTapAPI.onUserLogin(hashMap);
    }

    @Deprecated
    public void pushProfileEvent(HashMap<String, Object> hashMap) {
        mCleverTapAPI.coreState.analyticsManager.pushProfile(hashMap);
    }

    public void pushProfileEventV2(HashMap<String, Object> hashMap) {
        mCleverTapAPI.coreState.analyticsManager.pushProfile(hashMap);
    }

    public void pushV2(HashMap<String, Object> hashMap) {
        mCleverTapAPI.coreState.analyticsManager.pushProfile(hashMap);
    }

    public void pushXiaomiRegistrationId(Context context) {
    }

    public void registerMIPush(Context context, String str, String str2) {
    }

    @Deprecated
    public void removeMultiValueForKey(String str, String str2) {
        mCleverTapAPI.removeMultiValueForKey(str, str2);
    }

    public void removeMultiValueForKeyV2(String str, String str2) {
        mCleverTapAPI.removeMultiValueForKey(str, str2);
    }

    @Deprecated
    public void removeMultiValuesForKey(String str, ArrayList<String> arrayList) {
        mCleverTapAPI.removeMultiValuesForKey(str, arrayList);
    }

    public void removeMultiValuesForKeyV2(String str, ArrayList<String> arrayList) {
        mCleverTapAPI.removeMultiValuesForKey(str, arrayList);
    }

    @Deprecated
    public void removeValueForKey(String str) {
        mCleverTapAPI.removeValueForKey(str);
    }

    @Deprecated
    public void removeValueForKeyV2(String str) {
        mCleverTapAPI.removeValueForKey(str);
    }

    public void setCTNotificationInboxListener(MPLCTInboxListener mPLCTInboxListener) {
        ((CallbackManager) mCleverTapAPI.coreState.callbackManager).inboxListener = mPLCTInboxListener;
    }

    public void setDebugLevel(DebugLevel debugLevel) {
        CleverTapAPI.debugLevel = debugLevel.value;
    }

    public void setDevicePushTokenRefreshListener(DevicePushTokenRefreshListener devicePushTokenRefreshListener) {
        mCleverTapAPI.coreState.pushProviders.tokenRefreshListener = devicePushTokenRefreshListener;
    }

    public void setInAppNotificationButtonListener(MPLCTInAppNotificationButtonListener mPLCTInAppNotificationButtonListener) {
        CallbackManager callbackManager = (CallbackManager) mCleverTapAPI.coreState.callbackManager;
        if (callbackManager != null) {
            callbackManager.inAppNotificationButtonListener = new WeakReference<>(mPLCTInAppNotificationButtonListener);
            return;
        }
        throw null;
    }

    public void setInAppNotificationListener(InAppNotificationListener inAppNotificationListener) {
        ((CallbackManager) mCleverTapAPI.coreState.callbackManager).inAppNotificationListener = inAppNotificationListener;
    }

    public void setNotificationHandler() {
        CleverTapAPI.sNotificationHandler = new PushTemplateNotificationHandler();
    }

    public void setSyncListener(SyncListener syncListener) {
        ((CallbackManager) mCleverTapAPI.coreState.callbackManager).syncListener = syncListener;
    }

    public void showAppInbox(MCTInboxStyleConfig mCTInboxStyleConfig) {
        mCleverTapAPI.showAppInbox(mCTInboxStyleConfig);
    }

    public void startLoggingEvent() {
        mCleverTapAPI.setOptOut(false);
    }

    public void stopLoggingEvent() {
        mCleverTapAPI.setOptOut(true);
    }

    public void createNotification(Context context, Bundle bundle) {
        CleverTapAPI.createNotification(context, bundle, NotificationManagerCompat.IMPORTANCE_UNSPECIFIED);
    }

    @Deprecated
    public void pushEvent(String str, HashMap<String, Object> hashMap) {
        mCleverTapAPI.pushEvent(str, hashMap);
    }

    public void pushEventV2(String str, HashMap<String, Object> hashMap) {
        mCleverTapAPI.pushEvent(str, hashMap);
    }

    public void showAppInbox() {
        CleverTapAPI cleverTapAPI = mCleverTapAPI;
        if (cleverTapAPI != null) {
            cleverTapAPI.showAppInbox(new CTInboxStyleConfig());
            return;
        }
        throw null;
    }

    public void createNotificationChannel(Context context, String str, CharSequence charSequence, String str2, int i, String str3, boolean z) {
        if (VERSION.SDK_INT >= 26) {
            CleverTapAPI defaultInstanceOrFirstOther = CleverTapAPI.getDefaultInstanceOrFirstOther(context);
            if (defaultInstanceOrFirstOther == null) {
                Logger.v("No CleverTap Instance found in CleverTapAPI#createNotificatonChannel");
                return;
            }
            try {
                if (VERSION.SDK_INT >= 26) {
                    Task postAsyncSafelyTask = CTExecutorFactory.executors(defaultInstanceOrFirstOther.coreState.config).postAsyncSafelyTask();
                    AnonymousClass3 r2 = new Callable<Void>(context, str, charSequence, i, str2, str3, z, defaultInstanceOrFirstOther) {
                        public final /* synthetic */ String val$channelDescription;
                        public final /* synthetic */ String val$channelId;
                        public final /* synthetic */ CharSequence val$channelName;
                        public final /* synthetic */ Context val$context;
                        public final /* synthetic */ String val$groupId;
                        public final /* synthetic */ int val$importance;
                        public final /* synthetic */ CleverTapAPI val$instance;
                        public final /* synthetic */ boolean val$showBadge;

                        {
                            this.val$context = r1;
                            this.val$channelId = r2;
                            this.val$channelName = r3;
                            this.val$importance = r4;
                            this.val$channelDescription = r5;
                            this.val$groupId = r6;
                            this.val$showBadge = r7;
                            this.val$instance = r8;
                        }

                        public Object call() throws Exception {
                            NotificationManager notificationManager = (NotificationManager) this.val$context.getSystemService("notification");
                            if (notificationManager != null) {
                                NotificationChannel notificationChannel = new NotificationChannel(this.val$channelId, this.val$channelName, this.val$importance);
                                notificationChannel.setDescription(this.val$channelDescription);
                                notificationChannel.setGroup(this.val$groupId);
                                notificationChannel.setShowBadge(this.val$showBadge);
                                notificationManager.createNotificationChannel(notificationChannel);
                                Logger configLogger = this.val$instance.getConfigLogger();
                                String accountId = this.val$instance.getAccountId();
                                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Notification channel ");
                                outline73.append(this.val$channelName.toString());
                                outline73.append(" has been created");
                                configLogger.info(accountId, outline73.toString());
                            }
                            return null;
                        }
                    };
                    postAsyncSafelyTask.executor.execute(new Runnable("creatingNotificationChannel", r2) {
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
            } catch (Throwable th) {
                defaultInstanceOrFirstOther.getConfigLogger().verbose(defaultInstanceOrFirstOther.getAccountId(), "Failure creating Notification Channel", th);
            }
        }
    }

    public void setDebugLevel(int i) {
        CleverTapAPI.debugLevel = i;
    }

    public void setCTNotificationInboxListener(CTInboxListener cTInboxListener) {
        ((CallbackManager) mCleverTapAPI.coreState.callbackManager).inboxListener = cTInboxListener;
    }

    public void createNotificationChannel(Context context, String str, CharSequence charSequence, String str2, int i, boolean z, String str3) {
        if (VERSION.SDK_INT >= 26) {
            CleverTapAPI defaultInstanceOrFirstOther = CleverTapAPI.getDefaultInstanceOrFirstOther(context);
            if (defaultInstanceOrFirstOther == null) {
                Logger.v("No CleverTap Instance found in CleverTapAPI#createNotificatonChannel");
                return;
            }
            try {
                if (VERSION.SDK_INT >= 26) {
                    Task postAsyncSafelyTask = CTExecutorFactory.executors(defaultInstanceOrFirstOther.coreState.config).postAsyncSafelyTask();
                    AnonymousClass4 r2 = new Callable<Void>(context, str3, defaultInstanceOrFirstOther, str, charSequence, i, str2, z) {
                        public final /* synthetic */ String val$channelDescription;
                        public final /* synthetic */ String val$channelId;
                        public final /* synthetic */ CharSequence val$channelName;
                        public final /* synthetic */ Context val$context;
                        public final /* synthetic */ int val$importance;
                        public final /* synthetic */ CleverTapAPI val$instance;
                        public final /* synthetic */ boolean val$showBadge;
                        public final /* synthetic */ String val$sound;

                        {
                            this.val$context = r1;
                            this.val$sound = r2;
                            this.val$instance = r3;
                            this.val$channelId = r4;
                            this.val$channelName = r5;
                            this.val$importance = r6;
                            this.val$channelDescription = r7;
                            this.val$showBadge = r8;
                        }

                        /* JADX WARNING: Removed duplicated region for block: B:18:0x0095  */
                        /* JADX WARNING: Removed duplicated region for block: B:19:0x00a7  */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public java.lang.Object call() throws java.lang.Exception {
                            /*
                                r7 = this;
                                android.content.Context r0 = r7.val$context
                                java.lang.String r1 = "notification"
                                java.lang.Object r0 = r0.getSystemService(r1)
                                android.app.NotificationManager r0 = (android.app.NotificationManager) r0
                                r1 = 0
                                if (r0 != 0) goto L_0x000f
                                goto L_0x00e2
                            L_0x000f:
                                java.lang.String r2 = r7.val$sound
                                boolean r2 = r2.isEmpty()
                                if (r2 != 0) goto L_0x007d
                                java.lang.String r2 = r7.val$sound
                                java.lang.String r3 = ".mp3"
                                boolean r2 = r2.contains(r3)
                                if (r2 != 0) goto L_0x004a
                                java.lang.String r2 = r7.val$sound
                                java.lang.String r3 = ".ogg"
                                boolean r2 = r2.contains(r3)
                                if (r2 != 0) goto L_0x004a
                                java.lang.String r2 = r7.val$sound
                                java.lang.String r3 = ".wav"
                                boolean r2 = r2.contains(r3)
                                if (r2 == 0) goto L_0x0036
                                goto L_0x004a
                            L_0x0036:
                                com.clevertap.android.sdk.CleverTapAPI r2 = r7.val$instance
                                com.clevertap.android.sdk.Logger r2 = r2.getConfigLogger()
                                com.clevertap.android.sdk.CleverTapAPI r3 = r7.val$instance
                                java.lang.String r3 = r3.getAccountId()
                                java.lang.String r4 = "Sound file name not supported"
                                r2.debug(r3, r4)
                                java.lang.String r2 = ""
                                goto L_0x0057
                            L_0x004a:
                                java.lang.String r2 = r7.val$sound
                                r3 = 0
                                int r4 = r2.length()
                                int r4 = r4 + -4
                                java.lang.String r2 = r2.substring(r3, r4)
                            L_0x0057:
                                boolean r3 = r2.isEmpty()
                                if (r3 != 0) goto L_0x007d
                                java.lang.String r3 = "android.resource://"
                                java.lang.StringBuilder r3 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r3)
                                android.content.Context r4 = r7.val$context
                                java.lang.String r4 = r4.getPackageName()
                                r3.append(r4)
                                java.lang.String r4 = "/raw/"
                                r3.append(r4)
                                r3.append(r2)
                                java.lang.String r2 = r3.toString()
                                android.net.Uri r2 = android.net.Uri.parse(r2)
                                goto L_0x007e
                            L_0x007d:
                                r2 = r1
                            L_0x007e:
                                android.app.NotificationChannel r3 = new android.app.NotificationChannel
                                java.lang.String r4 = r7.val$channelId
                                java.lang.CharSequence r5 = r7.val$channelName
                                int r6 = r7.val$importance
                                r3.<init>(r4, r5, r6)
                                java.lang.String r4 = r7.val$channelDescription
                                r3.setDescription(r4)
                                boolean r4 = r7.val$showBadge
                                r3.setShowBadge(r4)
                                if (r2 == 0) goto L_0x00a7
                                android.media.AudioAttributes$Builder r4 = new android.media.AudioAttributes$Builder
                                r4.<init>()
                                r5 = 5
                                android.media.AudioAttributes$Builder r4 = r4.setUsage(r5)
                                android.media.AudioAttributes r4 = r4.build()
                                r3.setSound(r2, r4)
                                goto L_0x00b8
                            L_0x00a7:
                                com.clevertap.android.sdk.CleverTapAPI r2 = r7.val$instance
                                com.clevertap.android.sdk.Logger r2 = r2.getConfigLogger()
                                com.clevertap.android.sdk.CleverTapAPI r4 = r7.val$instance
                                java.lang.String r4 = r4.getAccountId()
                                java.lang.String r5 = "Sound file not found, notification channel will be created without custom sound"
                                r2.debug(r4, r5)
                            L_0x00b8:
                                r0.createNotificationChannel(r3)
                                com.clevertap.android.sdk.CleverTapAPI r0 = r7.val$instance
                                com.clevertap.android.sdk.Logger r0 = r0.getConfigLogger()
                                com.clevertap.android.sdk.CleverTapAPI r2 = r7.val$instance
                                java.lang.String r2 = r2.getAccountId()
                                java.lang.String r3 = "Notification channel "
                                java.lang.StringBuilder r3 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r3)
                                java.lang.CharSequence r4 = r7.val$channelName
                                java.lang.String r4 = r4.toString()
                                r3.append(r4)
                                java.lang.String r4 = " has been created"
                                r3.append(r4)
                                java.lang.String r3 = r3.toString()
                                r0.info(r2, r3)
                            L_0x00e2:
                                return r1
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.CleverTapAPI.AnonymousClass4.call():java.lang.Object");
                        }
                    };
                    postAsyncSafelyTask.executor.execute(new Runnable("createNotificationChannel", r2) {
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
            } catch (Throwable th) {
                defaultInstanceOrFirstOther.getConfigLogger().verbose(defaultInstanceOrFirstOther.getAccountId(), "Failure creating Notification Channel", th);
            }
        }
    }

    public void createNotificationChannel(Context context, String str, CharSequence charSequence, String str2, int i, String str3, boolean z, String str4) {
        if (VERSION.SDK_INT >= 26) {
            CleverTapAPI defaultInstanceOrFirstOther = CleverTapAPI.getDefaultInstanceOrFirstOther(context);
            if (defaultInstanceOrFirstOther == null) {
                Logger.v("No CleverTap Instance found in CleverTapAPI#createNotificatonChannel");
                return;
            }
            try {
                if (VERSION.SDK_INT >= 26) {
                    Task postAsyncSafelyTask = CTExecutorFactory.executors(defaultInstanceOrFirstOther.coreState.config).postAsyncSafelyTask();
                    AnonymousClass5 r2 = new Callable<Void>(context, str4, defaultInstanceOrFirstOther, str, charSequence, i, str2, str3, z) {
                        public final /* synthetic */ String val$channelDescription;
                        public final /* synthetic */ String val$channelId;
                        public final /* synthetic */ CharSequence val$channelName;
                        public final /* synthetic */ Context val$context;
                        public final /* synthetic */ String val$groupId;
                        public final /* synthetic */ int val$importance;
                        public final /* synthetic */ CleverTapAPI val$instance;
                        public final /* synthetic */ boolean val$showBadge;
                        public final /* synthetic */ String val$sound;

                        {
                            this.val$context = r1;
                            this.val$sound = r2;
                            this.val$instance = r3;
                            this.val$channelId = r4;
                            this.val$channelName = r5;
                            this.val$importance = r6;
                            this.val$channelDescription = r7;
                            this.val$groupId = r8;
                            this.val$showBadge = r9;
                        }

                        /* JADX WARNING: Removed duplicated region for block: B:18:0x009a  */
                        /* JADX WARNING: Removed duplicated region for block: B:19:0x00ac  */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public java.lang.Object call() throws java.lang.Exception {
                            /*
                                r7 = this;
                                android.content.Context r0 = r7.val$context
                                java.lang.String r1 = "notification"
                                java.lang.Object r0 = r0.getSystemService(r1)
                                android.app.NotificationManager r0 = (android.app.NotificationManager) r0
                                r1 = 0
                                if (r0 != 0) goto L_0x000f
                                goto L_0x00e7
                            L_0x000f:
                                java.lang.String r2 = r7.val$sound
                                boolean r2 = r2.isEmpty()
                                if (r2 != 0) goto L_0x007d
                                java.lang.String r2 = r7.val$sound
                                java.lang.String r3 = ".mp3"
                                boolean r2 = r2.contains(r3)
                                if (r2 != 0) goto L_0x004a
                                java.lang.String r2 = r7.val$sound
                                java.lang.String r3 = ".ogg"
                                boolean r2 = r2.contains(r3)
                                if (r2 != 0) goto L_0x004a
                                java.lang.String r2 = r7.val$sound
                                java.lang.String r3 = ".wav"
                                boolean r2 = r2.contains(r3)
                                if (r2 == 0) goto L_0x0036
                                goto L_0x004a
                            L_0x0036:
                                com.clevertap.android.sdk.CleverTapAPI r2 = r7.val$instance
                                com.clevertap.android.sdk.Logger r2 = r2.getConfigLogger()
                                com.clevertap.android.sdk.CleverTapAPI r3 = r7.val$instance
                                java.lang.String r3 = r3.getAccountId()
                                java.lang.String r4 = "Sound file name not supported"
                                r2.debug(r3, r4)
                                java.lang.String r2 = ""
                                goto L_0x0057
                            L_0x004a:
                                java.lang.String r2 = r7.val$sound
                                r3 = 0
                                int r4 = r2.length()
                                int r4 = r4 + -4
                                java.lang.String r2 = r2.substring(r3, r4)
                            L_0x0057:
                                boolean r3 = r2.isEmpty()
                                if (r3 != 0) goto L_0x007d
                                java.lang.String r3 = "android.resource://"
                                java.lang.StringBuilder r3 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r3)
                                android.content.Context r4 = r7.val$context
                                java.lang.String r4 = r4.getPackageName()
                                r3.append(r4)
                                java.lang.String r4 = "/raw/"
                                r3.append(r4)
                                r3.append(r2)
                                java.lang.String r2 = r3.toString()
                                android.net.Uri r2 = android.net.Uri.parse(r2)
                                goto L_0x007e
                            L_0x007d:
                                r2 = r1
                            L_0x007e:
                                android.app.NotificationChannel r3 = new android.app.NotificationChannel
                                java.lang.String r4 = r7.val$channelId
                                java.lang.CharSequence r5 = r7.val$channelName
                                int r6 = r7.val$importance
                                r3.<init>(r4, r5, r6)
                                java.lang.String r4 = r7.val$channelDescription
                                r3.setDescription(r4)
                                java.lang.String r4 = r7.val$groupId
                                r3.setGroup(r4)
                                boolean r4 = r7.val$showBadge
                                r3.setShowBadge(r4)
                                if (r2 == 0) goto L_0x00ac
                                android.media.AudioAttributes$Builder r4 = new android.media.AudioAttributes$Builder
                                r4.<init>()
                                r5 = 5
                                android.media.AudioAttributes$Builder r4 = r4.setUsage(r5)
                                android.media.AudioAttributes r4 = r4.build()
                                r3.setSound(r2, r4)
                                goto L_0x00bd
                            L_0x00ac:
                                com.clevertap.android.sdk.CleverTapAPI r2 = r7.val$instance
                                com.clevertap.android.sdk.Logger r2 = r2.getConfigLogger()
                                com.clevertap.android.sdk.CleverTapAPI r4 = r7.val$instance
                                java.lang.String r4 = r4.getAccountId()
                                java.lang.String r5 = "Sound file not found, notification channel will be created without custom sound"
                                r2.debug(r4, r5)
                            L_0x00bd:
                                r0.createNotificationChannel(r3)
                                com.clevertap.android.sdk.CleverTapAPI r0 = r7.val$instance
                                com.clevertap.android.sdk.Logger r0 = r0.getConfigLogger()
                                com.clevertap.android.sdk.CleverTapAPI r2 = r7.val$instance
                                java.lang.String r2 = r2.getAccountId()
                                java.lang.String r3 = "Notification channel "
                                java.lang.StringBuilder r3 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r3)
                                java.lang.CharSequence r4 = r7.val$channelName
                                java.lang.String r4 = r4.toString()
                                r3.append(r4)
                                java.lang.String r4 = " has been created"
                                r3.append(r4)
                                java.lang.String r3 = r3.toString()
                                r0.info(r2, r3)
                            L_0x00e7:
                                return r1
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.CleverTapAPI.AnonymousClass5.call():java.lang.Object");
                        }
                    };
                    postAsyncSafelyTask.executor.execute(new Runnable("creatingNotificationChannel", r2) {
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
            } catch (Throwable th) {
                defaultInstanceOrFirstOther.getConfigLogger().verbose(defaultInstanceOrFirstOther.getAccountId(), "Failure creating Notification Channel", th);
            }
        }
    }
}
