package com.rudderstack.android.sdk.core;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import com.google.gson.GsonBuilder;
import com.rudderstack.android.sdk.core.RudderClient.Callback;
import com.rudderstack.android.sdk.core.RudderIntegration.Factory;
import com.rudderstack.android.sdk.core.util.RudderContextSerializer;
import com.rudderstack.android.sdk.core.util.RudderTraitsSerializer;
import com.rudderstack.android.sdk.core.util.Utils;
import com.rudderstack.android.sdk.core.util.Utils.NetworkResponses;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class EventRepository implements ActivityLifecycleCallbacks {
    public String anonymousIdHeaderString;
    public Application application;
    public boolean areFactoriesInitialized = false;
    public String authHeaderString;
    public RudderConfig config;
    public RudderServerConfigManager configManager;
    public Context context;
    public DBPersistentManager dbManager;
    public final List<RudderMessage> eventReplayMessageQueue = Collections.synchronizedList(new ArrayList());
    public Map<String, Callback> integrationCallbacks = new HashMap();
    public Map<String, RudderIntegration<?>> integrationOperationsMap = new HashMap();
    public AtomicBoolean isFirstLaunch = new AtomicBoolean(true);
    public boolean isSDKEnabled = true;
    public boolean isSDKInitialized = false;
    public ArrayList<Integer> messageIds = new ArrayList<>();
    public ArrayList<String> messages = new ArrayList<>();
    public int noOfActivities;
    public RudderPreferenceManager preferenceManager;
    public RudderEventFilteringPlugin rudderEventFilteringPlugin;
    public RudderFlushWorkManager rudderFlushWorkManager;

    public EventRepository(Application application2, String str, RudderConfig rudderConfig, String str2, String str3, String str4) {
        try {
            RudderLogger.logDebug(String.format(Locale.US, "EventRepository: constructor: writeKey: %s", new Object[]{str}));
            String encodeToString = Base64.encodeToString(String.format(Locale.US, "%s:", new Object[]{str}).getBytes("UTF-8"), 0);
            this.authHeaderString = encodeToString;
            RudderLogger.logDebug(String.format(Locale.US, "EventRepository: constructor: authHeaderString: %s", new Object[]{encodeToString}));
        } catch (UnsupportedEncodingException e2) {
            RudderLogger.logError((Exception) e2);
        }
        this.context = application2.getApplicationContext();
        this.config = rudderConfig;
        RudderLogger.logDebug(String.format("EventRepository: constructor: %s", new Object[]{rudderConfig.toString()}));
        this.application = application2;
        try {
            RudderPreferenceManager instance = RudderPreferenceManager.getInstance(application2);
            this.preferenceManager = instance;
            if (instance.getOptStatus()) {
                if (!TextUtils.isEmpty(str2)) {
                    RudderLogger.logDebug("User Opted out for tracking the activity, hence dropping the anonymousId");
                    str2 = null;
                }
                if (!TextUtils.isEmpty(str3)) {
                    RudderLogger.logDebug("User Opted out for tracking the activity, hence dropping the advertisingId");
                    str3 = null;
                }
                if (!TextUtils.isEmpty(str4)) {
                    RudderLogger.logDebug("User Opted out for tracking the activity, hence dropping the device token");
                    str4 = null;
                }
            }
            RudderLogger.logDebug("EventRepository: constructor: Initiating RudderElementCache");
            RudderElementCache.initiate(application2, str2, str3, str4);
            String anonymousId = RudderContext.getAnonymousId();
            RudderLogger.logDebug(String.format(Locale.US, "EventRepository: constructor: anonymousId: %s", new Object[]{anonymousId}));
            String encodeToString2 = Base64.encodeToString(anonymousId.getBytes("UTF-8"), 0);
            this.anonymousIdHeaderString = encodeToString2;
            RudderLogger.logDebug(String.format(Locale.US, "EventRepository: constructor: anonymousIdHeaderString: %s", new Object[]{encodeToString2}));
            RudderLogger.logDebug("EventRepository: constructor: Initiating DBPersistentManager");
            this.dbManager = DBPersistentManager.getInstance(application2);
            RudderLogger.logDebug("EventRepository: constructor: Initiating RudderServerConfigManager");
            this.configManager = new RudderServerConfigManager(application2, str, rudderConfig);
            RudderFlushConfig rudderFlushConfig = new RudderFlushConfig(this.config.getDataPlaneUrl(), this.authHeaderString, this.anonymousIdHeaderString, this.config.getFlushQueueSize(), this.config.getLogLevel());
            this.rudderFlushWorkManager = new RudderFlushWorkManager(this.context, this.config, this.preferenceManager, rudderFlushConfig);
            RudderLogger.logDebug("EventRepository: constructor: Initiating processor and factories");
            initiateSDK();
            checkApplicationUpdateStatus(application2);
            if (this.config.isTrackLifecycleEvents() || this.config.isRecordScreenViews()) {
                application2.registerActivityLifecycleCallbacks(this);
            }
        } catch (Exception e3) {
            RudderLogger.logError(e3.getCause());
        }
    }

    private void checkApplicationUpdateStatus(Application application2) {
        int i;
        try {
            int buildVersionCode = this.preferenceManager.getBuildVersionCode();
            RudderLogger.logDebug("Previous Installed Version: " + buildVersionCode);
            PackageInfo packageInfo = application2.getPackageManager().getPackageInfo(application2.getPackageName(), 0);
            if (VERSION.SDK_INT >= 28) {
                i = (int) packageInfo.getLongVersionCode();
            } else {
                i = packageInfo.versionCode;
            }
            RudderLogger.logDebug("Current Installed Version: " + i);
            if (buildVersionCode == -1) {
                this.preferenceManager.saveBuildVersionCode(i);
                sendApplicationInstalled(i);
                this.rudderFlushWorkManager.registerPeriodicFlushWorker();
            } else if (buildVersionCode != i) {
                this.preferenceManager.saveBuildVersionCode(i);
                sendApplicationUpdated(buildVersionCode, i);
            }
        } catch (NameNotFoundException e2) {
            RudderLogger.logError((Exception) e2);
        }
    }

    /* access modifiers changed from: private */
    public void checkIfDBThresholdAttained() {
        int dBRecordCount = this.dbManager.getDBRecordCount();
        RudderLogger.logDebug(String.format(Locale.US, "EventRepository: checkIfDBThresholdAttained: DBRecordCount: %d", new Object[]{Integer.valueOf(dBRecordCount)}));
        if (dBRecordCount > this.config.getDbCountThreshold()) {
            RudderLogger.logDebug(String.format(Locale.US, "EventRepository: checkIfDBThresholdAttained: OldRecordCount: %d", new Object[]{Integer.valueOf(dBRecordCount - this.config.getDbCountThreshold())}));
            this.dbManager.fetchEventsFromDB(this.messageIds, this.messages, dBRecordCount - this.config.getDbCountThreshold());
            this.dbManager.clearEventsFromDB(this.messageIds);
        }
    }

    /* access modifiers changed from: private */
    public String getProcessName(Application application2) {
        int myPid = Process.myPid();
        application2.getApplicationContext();
        for (RunningAppProcessInfo next : ((ActivityManager) application2.getSystemService("activity")).getRunningAppProcesses()) {
            if (next.pid == myPid) {
                return next.processName;
            }
        }
        return "";
    }

    /* access modifiers changed from: private */
    public Runnable getProcessorRunnable() {
        return new Runnable() {
            public void run() {
                NetworkResponses networkResponses = NetworkResponses.SUCCESS;
                int i = 0;
                while (true) {
                    synchronized (EventRepository.this.messageIds) {
                        try {
                            EventRepository.this.messageIds.clear();
                            EventRepository.this.messages.clear();
                            EventRepository.this.checkIfDBThresholdAttained();
                            RudderLogger.logDebug("EventRepository: processor: Fetching events to flush to server");
                            EventRepository.this.dbManager.fetchEventsFromDB(EventRepository.this.messageIds, EventRepository.this.messages, EventRepository.this.config.getFlushQueueSize());
                            if (EventRepository.this.messages.size() >= EventRepository.this.config.getFlushQueueSize() || (!EventRepository.this.messages.isEmpty() && i >= EventRepository.this.config.getSleepTimeOut())) {
                                String payloadFromMessages = FlushUtils.getPayloadFromMessages(EventRepository.this.messageIds, EventRepository.this.messages);
                                RudderLogger.logDebug(String.format(Locale.US, "EventRepository: processor: payload: %s", new Object[]{payloadFromMessages}));
                                RudderLogger.logInfo(String.format(Locale.US, "EventRepository: processor: EventCount: %d", new Object[]{Integer.valueOf(EventRepository.this.messageIds.size())}));
                                if (payloadFromMessages != null) {
                                    networkResponses = FlushUtils.flushEventsToServer(payloadFromMessages, EventRepository.this.config.getDataPlaneUrl(), EventRepository.this.authHeaderString, EventRepository.this.anonymousIdHeaderString);
                                    RudderLogger.logInfo(String.format(Locale.US, "EventRepository: processor: ServerResponse: %s", new Object[]{networkResponses}));
                                    if (networkResponses == NetworkResponses.SUCCESS) {
                                        EventRepository.this.dbManager.clearEventsFromDB(EventRepository.this.messageIds);
                                        i = 0;
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            RudderLogger.logError(e2);
                        }
                    }
                    i++;
                    RudderLogger.logDebug(String.format(Locale.US, "EventRepository: processor: SleepCount: %d", new Object[]{Integer.valueOf(i)}));
                    try {
                        if (networkResponses == NetworkResponses.WRITE_KEY_ERROR) {
                            RudderLogger.logInfo("Wrong WriteKey. Aborting");
                            return;
                        } else if (networkResponses == NetworkResponses.ERROR) {
                            RudderLogger.logInfo("flushEvents: Retrying in " + Math.abs(i - EventRepository.this.config.getSleepTimeOut()) + "s");
                            Thread.sleep((long) (Math.abs(i - EventRepository.this.config.getSleepTimeOut()) * 1000));
                        } else {
                            Thread.sleep(1000);
                        }
                    } catch (Exception e3) {
                        RudderLogger.logError(e3);
                    }
                }
                while (true) {
                }
            }
        };
    }

    private void handleCallBacks(String str, RudderIntegration rudderIntegration) {
        if (this.integrationCallbacks.containsKey(str)) {
            Object underlyingInstance = rudderIntegration.getUnderlyingInstance();
            Callback callback = this.integrationCallbacks.get(str);
            if (underlyingInstance == null || callback == null) {
                RudderLogger.logDebug(String.format(Locale.US, "EventRepository: handleCallBacks: Callback for %s factory is null", new Object[]{str}));
                return;
            }
            RudderLogger.logInfo(String.format(Locale.US, "EventRepository: handleCallBacks: Callback for %s factory invoked", new Object[]{str}));
            callback.onReady(underlyingInstance);
        }
    }

    /* access modifiers changed from: private */
    public void initiateCustomFactories() {
        RudderConfig rudderConfig = this.config;
        if (rudderConfig == null || rudderConfig.getCustomFactories() == null || this.config.getCustomFactories().isEmpty()) {
            RudderLogger.logInfo("EventRepository: initiateCustomFactories: No custom factory found");
            return;
        }
        for (Factory next : this.config.getCustomFactories()) {
            String key = next.key();
            RudderIntegration<?> create = next.create(null, RudderClient.getInstance(), this.config);
            RudderLogger.logInfo(String.format(Locale.US, "EventRepository: initiateCustomFactories: Initiated %s custom factory", new Object[]{key}));
            this.integrationOperationsMap.put(key, create);
            handleCallBacks(key, create);
        }
    }

    /* access modifiers changed from: private */
    public void initiateFactories(List<RudderServerDestination> list) {
        RudderConfig rudderConfig = this.config;
        if (rudderConfig == null || rudderConfig.getFactories() == null || this.config.getFactories().isEmpty()) {
            RudderLogger.logInfo("EventRepository: initiateFactories: No native SDK factory found");
            return;
        }
        if (list.isEmpty()) {
            RudderLogger.logInfo("EventRepository: initiateFactories: No destination found in the config");
        } else {
            HashMap hashMap = new HashMap();
            for (RudderServerDestination next : list) {
                hashMap.put(next.destinationDefinition.displayName, next);
            }
            for (Factory next2 : this.config.getFactories()) {
                String key = next2.key();
                if (hashMap.containsKey(key)) {
                    RudderServerDestination rudderServerDestination = (RudderServerDestination) hashMap.get(key);
                    if (rudderServerDestination == null || !rudderServerDestination.isDestinationEnabled) {
                        RudderLogger.logDebug(String.format(Locale.US, "EventRepository: initiateFactories: destination was null or not enabled for %s", new Object[]{key}));
                    } else {
                        Object obj = rudderServerDestination.destinationConfig;
                        RudderLogger.logDebug(String.format(Locale.US, "EventRepository: initiateFactories: Initiating %s native SDK factory", new Object[]{key}));
                        RudderIntegration<?> create = next2.create(obj, RudderClient.getInstance(), this.config);
                        RudderLogger.logInfo(String.format(Locale.US, "EventRepository: initiateFactories: Initiated %s native SDK factory", new Object[]{key}));
                        this.integrationOperationsMap.put(key, create);
                        handleCallBacks(key, create);
                    }
                } else {
                    RudderLogger.logInfo(String.format(Locale.US, "EventRepository: initiateFactories: %s is not present in configMap", new Object[]{key}));
                }
            }
        }
    }

    private void initiateSDK() {
        new Thread(new Runnable() {
            public void run() {
                int i = 0;
                while (!EventRepository.this.isSDKInitialized && i <= 5) {
                    try {
                        NetworkResponses error = EventRepository.this.configManager.getError();
                        RudderServerConfig config = EventRepository.this.configManager.getConfig();
                        if (config != null) {
                            EventRepository.this.isSDKEnabled = config.source.isSourceEnabled;
                            if (EventRepository.this.isSDKEnabled) {
                                RudderLogger.logDebug("EventRepository: initiateSDK: Initiating processor");
                                StringBuilder sb = new StringBuilder(EventRepository.this.application.getPackageName());
                                if (RudderClient.getInstance() != null && !RudderClient.getInstance().mainProcessName.isEmpty()) {
                                    sb.append(":");
                                    sb.append(RudderClient.getInstance().mainProcessName);
                                }
                                if (EventRepository.this.getProcessName(EventRepository.this.application).equals(sb.toString())) {
                                    new Thread(EventRepository.this.getProcessorRunnable(), "processor_thread").start();
                                }
                                if (config.source.destinations != null) {
                                    EventRepository.this.initiateFactories(config.source.destinations);
                                    RudderLogger.logDebug("EventRepository: initiating event filtering plugin for device mode destinations");
                                    EventRepository.this.rudderEventFilteringPlugin = new RudderEventFilteringPlugin(config.source.destinations);
                                } else {
                                    RudderLogger.logDebug("EventRepository: initiateSDK: No native SDKs are found");
                                }
                                EventRepository.this.initiateCustomFactories();
                                EventRepository.this.areFactoriesInitialized = true;
                                EventRepository.this.replayMessageQueue();
                            } else {
                                RudderLogger.logDebug("EventRepository: initiateSDK: source is disabled in the dashboard");
                                RudderLogger.logDebug("Flushing persisted events");
                                EventRepository.this.dbManager.flushEvents();
                            }
                            EventRepository.this.isSDKInitialized = true;
                        } else if (error == NetworkResponses.WRITE_KEY_ERROR) {
                            RudderLogger.logError((String) "WRONG WRITE_KEY");
                            return;
                        } else {
                            i++;
                            RudderLogger.logDebug("EventRepository: initiateFactories: retry count: " + i);
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("initiateSDK: Retrying in ");
                            int i2 = i * 2;
                            sb2.append(i2);
                            sb2.append("s");
                            RudderLogger.logInfo(sb2.toString());
                            Thread.sleep((long) (i2 * 1000));
                        }
                    } catch (Exception e2) {
                        RudderLogger.logError(e2);
                        return;
                    }
                }
            }
        }).start();
    }

    private void makeFactoryDump(RudderMessage rudderMessage, boolean z) {
        synchronized (this.eventReplayMessageQueue) {
            if (!this.areFactoriesInitialized) {
                if (!z) {
                    RudderLogger.logDebug("EventRepository: makeFactoryDump: factories are not initialized. dumping to replay queue");
                    this.eventReplayMessageQueue.add(rudderMessage);
                }
            }
            Map<String, Object> integrations = rudderMessage.getIntegrations();
            if (((Boolean) integrations.get("All")).booleanValue()) {
                for (String next : this.integrationOperationsMap.keySet()) {
                    RudderIntegration rudderIntegration = this.integrationOperationsMap.get(next);
                    if (rudderIntegration != null && ((!integrations.containsKey(next) || ((Boolean) integrations.get(next)).booleanValue()) && this.rudderEventFilteringPlugin.isEventAllowed(next, rudderMessage))) {
                        RudderLogger.logDebug(String.format(Locale.US, "EventRepository: makeFactoryDump: dumping for %s", new Object[]{next}));
                        rudderIntegration.dump(rudderMessage);
                    }
                }
            } else {
                for (String next2 : this.integrationOperationsMap.keySet()) {
                    RudderIntegration rudderIntegration2 = this.integrationOperationsMap.get(next2);
                    if (rudderIntegration2 != null && integrations.containsKey(next2) && ((Boolean) integrations.get(next2)).booleanValue() && this.rudderEventFilteringPlugin.isEventAllowed(next2, rudderMessage)) {
                        RudderLogger.logDebug(String.format(Locale.US, "EventRepository: makeFactoryDump: dumping for %s", new Object[]{next2}));
                        rudderIntegration2.dump(rudderMessage);
                    }
                }
            }
        }
    }

    private Map<String, Object> prepareIntegrations() {
        HashMap hashMap = new HashMap();
        hashMap.put("All", Boolean.TRUE);
        return hashMap;
    }

    /* access modifiers changed from: private */
    public void replayMessageQueue() {
        synchronized (this.eventReplayMessageQueue) {
            RudderLogger.logDebug(String.format(Locale.US, "EventRepository: replayMessageQueue: replaying old messages with factories. Count: %d", new Object[]{Integer.valueOf(this.eventReplayMessageQueue.size())}));
            if (!this.eventReplayMessageQueue.isEmpty()) {
                for (RudderMessage makeFactoryDump : this.eventReplayMessageQueue) {
                    makeFactoryDump(makeFactoryDump, true);
                }
            }
            this.eventReplayMessageQueue.clear();
        }
    }

    private void sendApplicationInstalled(int i) {
        if (this.config.isTrackLifecycleEvents()) {
            RudderLogger.logDebug("Tracking Application Installed");
            RudderMessage build = new RudderMessageBuilder().setEventName("Application Installed").setProperty(new RudderProperty().putValue("version", Integer.valueOf(i))).build();
            build.setType(MessageType.TRACK);
            dump(build);
        }
    }

    private void sendApplicationUpdated(int i, int i2) {
        if (!getOptStatus() && this.config.isTrackLifecycleEvents()) {
            RudderLogger.logDebug("Tracking Application Updated");
            RudderMessage build = new RudderMessageBuilder().setEventName("Application Updated").setProperty(new RudderProperty().putValue("previous_version", Integer.valueOf(i)).putValue("version", Integer.valueOf(i2))).build();
            build.setType(MessageType.TRACK);
            dump(build);
        }
    }

    private void updateOptStatusTime(boolean z) {
        if (z) {
            this.preferenceManager.updateOptOutTime();
        } else {
            this.preferenceManager.updateOptInTime();
        }
    }

    public void cancelPeriodicFlushWorker() {
        this.rudderFlushWorkManager.cancelPeriodicFlushWorker();
    }

    public void dump(RudderMessage rudderMessage) {
        if (this.isSDKEnabled) {
            RudderLogger.logDebug(String.format(Locale.US, "EventRepository: dump: eventName: %s", new Object[]{rudderMessage.getEventName()}));
            if (rudderMessage.getIntegrations().size() == 0) {
                if (RudderClient.getDefaultOptions() == null || RudderClient.getDefaultOptions().getIntegrations() == null || RudderClient.getDefaultOptions().getIntegrations().size() == 0) {
                    rudderMessage.setIntegrations(prepareIntegrations());
                } else {
                    rudderMessage.setIntegrations(RudderClient.getDefaultOptions().getIntegrations());
                }
            }
            if (!rudderMessage.getIntegrations().containsKey("All")) {
                rudderMessage.setIntegrations(prepareIntegrations());
            }
            String json = new GsonBuilder().registerTypeAdapter(RudderTraits.class, new RudderTraitsSerializer()).registerTypeAdapter(RudderContext.class, new RudderContextSerializer()).create().toJson((Object) rudderMessage);
            makeFactoryDump(rudderMessage, false);
            RudderLogger.logVerbose(String.format(Locale.US, "EventRepository: dump: message: %s", new Object[]{json}));
            if (Utils.getUTF8Length(json) > 32768) {
                RudderLogger.logError(String.format(Locale.US, "EventRepository: dump: Event size exceeds the maximum permitted event size(%d)", new Object[]{Integer.valueOf(32768)}));
                return;
            }
            this.dbManager.saveEvent(json);
        }
    }

    public void flushSync() {
        FlushUtils.flush(this.areFactoriesInitialized, this.integrationOperationsMap, this.messageIds, this.messages, this.config.getFlushQueueSize(), this.config.getDataPlaneUrl(), this.dbManager, this.authHeaderString, this.anonymousIdHeaderString);
    }

    public boolean getOptStatus() {
        return this.preferenceManager.getOptStatus();
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        if (this.config.isRecordScreenViews()) {
            if (!getOptStatus()) {
                RudderMessage build = new RudderMessageBuilder().setEventName(activity.getLocalClassName()).setProperty(new ScreenPropertyBuilder().setScreenName(activity.getLocalClassName()).isAtomatic(true).build()).build();
                build.setType("screen");
                dump(build);
            } else {
                return;
            }
        }
        if (this.config.isTrackLifecycleEvents()) {
            int i = this.noOfActivities + 1;
            this.noOfActivities = i;
            if (i == 1 && !getOptStatus()) {
                RudderMessage build2 = new RudderMessageBuilder().setEventName("Application Opened").setProperty(Utils.trackDeepLink(activity, this.isFirstLaunch, this.preferenceManager.getBuildVersionCode())).build();
                build2.setType(MessageType.TRACK);
                dump(build2);
            }
        }
    }

    public void onActivityStopped(Activity activity) {
        if (this.config.isTrackLifecycleEvents()) {
            int i = this.noOfActivities - 1;
            this.noOfActivities = i;
            if (i == 0 && !getOptStatus()) {
                RudderMessage build = new RudderMessageBuilder().setEventName("Application Backgrounded").build();
                build.setType(MessageType.TRACK);
                dump(build);
            }
        }
    }

    public void onIntegrationReady(String str, Callback callback) {
        RudderLogger.logDebug(String.format(Locale.US, "EventRepository: onIntegrationReady: callback registered for %s", new Object[]{str}));
        this.integrationCallbacks.put(str, callback);
    }

    public void reset() {
        RudderLogger.logDebug("EventRepository: reset: resetting the SDK");
        if (this.areFactoriesInitialized) {
            RudderLogger.logDebug("EventRepository: resetting native SDKs");
            for (String next : this.integrationOperationsMap.keySet()) {
                RudderLogger.logDebug(String.format(Locale.US, "EventRepository: reset for %s", new Object[]{next}));
                RudderIntegration rudderIntegration = this.integrationOperationsMap.get(next);
                if (rudderIntegration != null) {
                    rudderIntegration.reset();
                }
            }
            return;
        }
        RudderLogger.logDebug("EventRepository: reset: factories are not initialized. ignored");
    }

    public void saveOptStatus(boolean z) {
        this.preferenceManager.saveOptStatus(z);
        updateOptStatusTime(z);
    }

    public void shutDown() {
        if (this.areFactoriesInitialized) {
            Map<String, RudderIntegration<?>> map = this.integrationOperationsMap;
            if (map != null) {
                FlushUtils.flushNativeSdks(map);
            }
        }
    }

    public void updateAnonymousId(String str) {
        RudderLogger.logDebug(String.format(Locale.US, "EventRepository: updateAnonymousId: Updating AnonymousId: %s", new Object[]{str}));
        RudderElementCache.updateAnonymousId(str);
        this.preferenceManager.saveAnonymousId(RudderContext.getAnonymousId());
        try {
            this.anonymousIdHeaderString = Base64.encodeToString(RudderContext.getAnonymousId().getBytes("UTF-8"), 0);
        } catch (Exception e2) {
            RudderLogger.logError(e2.getCause());
        }
    }
}
