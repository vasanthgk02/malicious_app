package com.rudderstack.android.sdk.core;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.rudderstack.android.sdk.core.util.Utils;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;
import java.util.concurrent.TimeUnit;

public class RudderClient {
    public static final int NUMBER_OF_FLUSH_CALLS_IN_QUEUE = 1;
    public static String _advertisingId;
    public static String _anonymousId;
    public static String _deviceToken;
    public static Application application;
    public static RudderOption defaultOptions;
    public static RudderClient instance;
    public static EventRepository repository;
    public final ExecutorService flushExecutorService;
    public final RejectedExecutionHandler handler = new DiscardOldestPolicy();
    public String mainProcessName = "";

    public static class Builder {
        public Application application;
        public RudderConfig config;
        public int logLevel;
        public boolean recordScreenViews;
        public boolean trackLifecycleEvents;
        public String writeKey;

        public Builder(Context context) {
            this(context, null);
        }

        public RudderClient build() {
            if (this.application == null) {
                RudderLogger.logError((String) "Context is null. Aborting initialization. Returning null Client");
                return null;
            } else if (!TextUtils.isEmpty(this.writeKey)) {
                return RudderClient.getInstance((Context) this.application, this.writeKey, this.config);
            } else {
                RudderLogger.logError((String) "writeKey is null. Aborting initialization. Returning null Client");
                return null;
            }
        }

        public Builder logLevel(int i) {
            if (this.config == null) {
                this.config = new RudderConfig();
            }
            this.config.setLogLevel(i);
            return this;
        }

        public Builder recordScreenViews() {
            if (this.config == null) {
                this.config = new RudderConfig();
            }
            this.config.setRecordScreenViews(true);
            return this;
        }

        public Builder trackApplicationLifecycleEvents() {
            if (this.config == null) {
                this.config = new RudderConfig();
            }
            this.config.setTrackLifecycleEvents(true);
            return this;
        }

        public Builder withRudderConfig(RudderConfig rudderConfig) {
            if (this.config != null) {
                RudderLogger.logWarn("RudderClient: Builder: replacing old config");
            }
            this.config = rudderConfig;
            return this;
        }

        public Builder withRudderConfigBuilder(com.rudderstack.android.sdk.core.RudderConfig.Builder builder) {
            if (this.config != null) {
                RudderLogger.logWarn("RudderClient: Builder: replacing old config");
            }
            this.config = builder.build();
            return this;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
            r3 = com.rudderstack.android.sdk.core.util.Utils.getWriteKeyFromStrings(r2);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public Builder(android.content.Context r2, java.lang.String r3) {
            /*
                r1 = this;
                r1.<init>()
                r0 = 0
                r1.trackLifecycleEvents = r0
                r1.recordScreenViews = r0
                if (r2 != 0) goto L_0x000f
                java.lang.String r0 = "context can not be null"
                com.rudderstack.android.sdk.core.RudderLogger.logError(r0)
            L_0x000f:
                boolean r0 = android.text.TextUtils.isEmpty(r3)
                if (r0 == 0) goto L_0x0020
                java.lang.String r0 = "WriteKey is not specified in constructor. looking for string file"
                com.rudderstack.android.sdk.core.RudderLogger.logDebug(r0)
                if (r2 == 0) goto L_0x0020
                java.lang.String r3 = com.rudderstack.android.sdk.core.util.Utils.getWriteKeyFromStrings(r2)
            L_0x0020:
                boolean r0 = android.text.TextUtils.isEmpty(r3)
                if (r0 == 0) goto L_0x002b
                java.lang.String r0 = "WriteKey can not be null or empty"
                com.rudderstack.android.sdk.core.RudderLogger.logError(r0)
            L_0x002b:
                if (r2 == 0) goto L_0x0035
                android.content.Context r2 = r2.getApplicationContext()
                android.app.Application r2 = (android.app.Application) r2
                r1.application = r2
            L_0x0035:
                r1.writeKey = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.rudderstack.android.sdk.core.RudderClient.Builder.<init>(android.content.Context, java.lang.String):void");
        }
    }

    public interface Callback {
        void onReady(Object obj);
    }

    public RudderClient() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(1), this.handler);
        this.flushExecutorService = threadPoolExecutor;
        RudderLogger.logVerbose("RudderClient: constructor invoked.");
    }

    public static Application getApplication() {
        return application;
    }

    public static RudderOption getDefaultOptions() {
        return defaultOptions;
    }

    public static RudderClient getInstance(Context context, String str) {
        return getInstance(context, str, new RudderConfig());
    }

    public static boolean getOptOutStatus() {
        EventRepository eventRepository = repository;
        if (eventRepository == null) {
            RudderLogger.logError((String) "SDK is not initialised. Hence dropping the event");
            return true;
        } else if (!eventRepository.getOptStatus()) {
            return false;
        } else {
            RudderLogger.logDebug("User Opted out for tracking the activity, hence dropping the event");
            return true;
        }
    }

    public static void putAdvertisingId(String str) {
        if (instance == null) {
            _advertisingId = str;
        } else if (!getOptOutStatus()) {
            RudderElementCache.cachedContext.updateWithAdvertisingId(str);
        }
    }

    public static void putAnonymousId(String str) {
        if (instance == null) {
            _anonymousId = str;
        } else if (!getOptOutStatus()) {
            EventRepository eventRepository = repository;
            if (eventRepository != null) {
                eventRepository.updateAnonymousId(str);
            }
        }
    }

    public static void putDeviceToken(String str) {
        if (instance == null) {
            _deviceToken = str;
        } else if (!getOptOutStatus()) {
            RudderElementCache.cachedContext.putDeviceToken(str);
        }
    }

    public static void setAnonymousId(String str) {
        putAnonymousId(str);
    }

    public static void setSingletonInstance(RudderClient rudderClient) {
        instance = rudderClient;
    }

    public static void updateWithAdvertisingId(String str) {
        putAdvertisingId(str);
    }

    public static RudderClient with(Context context) {
        RudderClient rudderClient = instance;
        return rudderClient == null ? getInstance(context, Utils.getWriteKeyFromStrings(context)) : rudderClient;
    }

    public void alias(RudderMessageBuilder rudderMessageBuilder) {
        if (!getOptOutStatus()) {
            alias(rudderMessageBuilder.build());
        }
    }

    public void cancelPeriodicWorkRequest() {
        EventRepository eventRepository = repository;
        if (eventRepository != null) {
            eventRepository.cancelPeriodicFlushWorker();
        }
    }

    @Deprecated
    public void flush() {
        if (!getOptOutStatus() && repository != null) {
            this.flushExecutorService.submit(new Runnable() {
                public void run() {
                    RudderClient.repository.flushSync();
                }
            });
        }
    }

    public RudderContext getRudderContext() {
        if (getOptOutStatus()) {
            return null;
        }
        return RudderElementCache.getCachedContext();
    }

    public void group(RudderMessageBuilder rudderMessageBuilder) {
        if (!getOptOutStatus()) {
            group(rudderMessageBuilder.build());
        }
    }

    public void identify(RudderMessage rudderMessage) {
        if (!getOptOutStatus()) {
            rudderMessage.setType(MessageType.IDENTIFY);
            EventRepository eventRepository = repository;
            if (eventRepository != null) {
                eventRepository.dump(rudderMessage);
            }
        }
    }

    public void onIntegrationReady(String str, Callback callback) {
        if (!getOptOutStatus()) {
            EventRepository eventRepository = repository;
            if (eventRepository != null) {
                eventRepository.onIntegrationReady(str, callback);
            }
        }
    }

    public void optOut(boolean z) {
        EventRepository eventRepository = repository;
        if (eventRepository != null) {
            eventRepository.saveOptStatus(z);
            RudderLogger.logInfo("optOut() flag is set to " + z);
            return;
        }
        RudderLogger.logError((String) "SDK is not initialised. Hence aborting optOut API call");
    }

    public void reset() {
        RudderElementCache.reset();
        EventRepository eventRepository = repository;
        if (eventRepository != null) {
            eventRepository.reset();
        }
    }

    public void screen(RudderMessageBuilder rudderMessageBuilder) {
        if (!getOptOutStatus()) {
            screen(rudderMessageBuilder.build());
        }
    }

    public void setMainProcessName(String str) {
        this.mainProcessName = str;
    }

    public void shutdown() {
        EventRepository eventRepository = repository;
        if (eventRepository != null) {
            eventRepository.shutDown();
        }
    }

    public void track(RudderMessageBuilder rudderMessageBuilder) {
        if (!getOptOutStatus()) {
            track(rudderMessageBuilder.build());
        }
    }

    public static RudderClient getInstance(Context context, String str, com.rudderstack.android.sdk.core.RudderConfig.Builder builder) {
        return getInstance(context, str, builder.build());
    }

    public static RudderClient getInstance(Context context, String str, RudderConfig rudderConfig, RudderOption rudderOption) {
        defaultOptions = rudderOption;
        return getInstance(context, str, rudderConfig);
    }

    public void alias(RudderMessage rudderMessage) {
        if (!getOptOutStatus()) {
            rudderMessage.setType("alias");
            EventRepository eventRepository = repository;
            if (eventRepository != null) {
                eventRepository.dump(rudderMessage);
            }
        }
    }

    public void group(RudderMessage rudderMessage) {
        if (!getOptOutStatus()) {
            rudderMessage.setType("group");
            EventRepository eventRepository = repository;
            if (eventRepository != null) {
                eventRepository.dump(rudderMessage);
            }
        }
    }

    public void screen(RudderMessage rudderMessage) {
        if (!getOptOutStatus()) {
            rudderMessage.setType("screen");
            EventRepository eventRepository = repository;
            if (eventRepository != null) {
                eventRepository.dump(rudderMessage);
            }
        }
    }

    public void track(RudderMessage rudderMessage) {
        if (!getOptOutStatus()) {
            rudderMessage.setType(MessageType.TRACK);
            EventRepository eventRepository = repository;
            if (eventRepository != null) {
                eventRepository.dump(rudderMessage);
            }
        }
    }

    public static RudderClient getInstance(Context context, String str, RudderConfig rudderConfig) {
        if (instance == null) {
            RudderLogger.logVerbose("getInstance: instance null. creating instance");
            if (!TextUtils.isEmpty(str)) {
                if (rudderConfig == null) {
                    RudderLogger.logVerbose("getInstance: config null. creating default config");
                    rudderConfig = new RudderConfig();
                } else {
                    RudderLogger.logVerbose("getInstance: config present. using config.");
                    if (TextUtils.isEmpty(rudderConfig.getDataPlaneUrl())) {
                        RudderLogger.logVerbose("getInstance: EndPointUri is blank or null. using default.");
                        rudderConfig.setDataPlaneUrl(Constants.DATA_PLANE_URL);
                    }
                    if (rudderConfig.getFlushQueueSize() < 0 || rudderConfig.getFlushQueueSize() > 100) {
                        RudderLogger.logVerbose("getInstance: FlushQueueSize is wrong. using default.");
                        rudderConfig.setFlushQueueSize(30);
                    }
                    if (rudderConfig.getDbCountThreshold() < 0) {
                        RudderLogger.logVerbose("getInstance: DbCountThreshold is wrong. using default.");
                        rudderConfig.setDbCountThreshold(10000);
                    }
                    if (rudderConfig.getSleepTimeOut() < 1) {
                        RudderLogger.logVerbose("getInstance: SleepTimeOut is wrong. using default.");
                        rudderConfig.setSleepTimeOut(10);
                    }
                }
                RudderConfig rudderConfig2 = rudderConfig;
                application = (Application) context.getApplicationContext();
                instance = new RudderClient();
                if (application != null) {
                    RudderLogger.logVerbose("getInstance: creating EventRepository.");
                    EventRepository eventRepository = new EventRepository(application, str, rudderConfig2, _anonymousId, _advertisingId, _deviceToken);
                    repository = eventRepository;
                }
            } else {
                throw new IllegalArgumentException("RudderClient: getInstance: writeKey can not be null or empty");
            }
        }
        return instance;
    }

    public void identify(RudderTraits rudderTraits, RudderOption rudderOption) {
        if (!getOptOutStatus()) {
            RudderMessage build = new RudderMessageBuilder().setEventName(MessageType.IDENTIFY).setUserId(rudderTraits.getId()).setRudderOption(rudderOption).build();
            build.updateTraits(rudderTraits);
            build.updateExternalIds(rudderOption);
            identify(build);
        }
    }

    public void alias(String str) {
        if (!getOptOutStatus()) {
            alias(str, null);
        }
    }

    public void group(String str) {
        if (!getOptOutStatus()) {
            group(str, null);
        }
    }

    public void screen(String str) {
        if (!getOptOutStatus()) {
            RudderProperty rudderProperty = new RudderProperty();
            rudderProperty.put("name", str);
            screen(new RudderMessageBuilder().setEventName(str).setProperty(rudderProperty).build());
        }
    }

    public void track(String str) {
        if (!getOptOutStatus()) {
            track(new RudderMessageBuilder().setEventName(str).build());
        }
    }

    public void alias(String str, RudderOption rudderOption) {
        String str2;
        if (!getOptOutStatus()) {
            Map<String, Object> traits = getRudderContext().getTraits();
            if (traits.containsKey("userId")) {
                str2 = (String) traits.get("userId");
            } else if (traits.containsKey("id")) {
                str2 = (String) traits.get("id");
            } else {
                str2 = RudderContext.getAnonymousId();
            }
            traits.put("userId", str);
            traits.put("id", str);
            RudderMessage build = new RudderMessageBuilder().setUserId(str).setRudderOption(rudderOption).setPreviousId(str2).build();
            build.updateTraits(traits);
            alias(build);
        }
    }

    public void group(String str, RudderTraits rudderTraits) {
        if (!getOptOutStatus()) {
            group(str, rudderTraits, null);
        }
    }

    public void track(String str, RudderProperty rudderProperty) {
        if (!getOptOutStatus()) {
            track(new RudderMessageBuilder().setEventName(str).setProperty(rudderProperty).build());
        }
    }

    public void group(String str, RudderTraits rudderTraits, RudderOption rudderOption) {
        if (!getOptOutStatus()) {
            group(new RudderMessageBuilder().setGroupId(str).setGroupTraits(rudderTraits).setRudderOption(rudderOption).build());
        }
    }

    public void screen(String str, RudderProperty rudderProperty) {
        if (!getOptOutStatus()) {
            if (rudderProperty == null) {
                rudderProperty = new RudderProperty();
            }
            rudderProperty.put("name", str);
            screen(new RudderMessageBuilder().setEventName(str).setProperty(rudderProperty).build());
        }
    }

    public void track(String str, RudderProperty rudderProperty, RudderOption rudderOption) {
        if (!getOptOutStatus()) {
            track(new RudderMessageBuilder().setEventName(str).setProperty(rudderProperty).setRudderOption(rudderOption).build());
        }
    }

    public void identify(RudderTraits rudderTraits) {
        if (!getOptOutStatus()) {
            identify(rudderTraits, null);
        }
    }

    public void screen(String str, String str2, RudderProperty rudderProperty, RudderOption rudderOption) {
        if (!getOptOutStatus()) {
            if (rudderProperty == null) {
                rudderProperty = new RudderProperty();
            }
            rudderProperty.put("category", str2);
            rudderProperty.put("name", str);
            screen(new RudderMessageBuilder().setEventName(str).setProperty(rudderProperty).setRudderOption(rudderOption).build());
        }
    }

    public void identify(RudderTraitsBuilder rudderTraitsBuilder) {
        if (!getOptOutStatus()) {
            identify(rudderTraitsBuilder.build());
        }
    }

    public void identify(String str) {
        if (!getOptOutStatus()) {
            identify(new RudderTraitsBuilder().setId(str));
        }
    }

    public void identify(String str, RudderTraits rudderTraits, RudderOption rudderOption) {
        if (!getOptOutStatus()) {
            if (rudderTraits == null) {
                rudderTraits = new RudderTraits();
            }
            rudderTraits.putId(str);
            identify(rudderTraits, rudderOption);
        }
    }

    public void screen(String str, RudderProperty rudderProperty, RudderOption rudderOption) {
        if (!getOptOutStatus()) {
            if (rudderProperty == null) {
                rudderProperty = new RudderProperty();
            }
            rudderProperty.put("name", str);
            screen(new RudderMessageBuilder().setEventName(str).setProperty(rudderProperty).setRudderOption(rudderOption).build());
        }
    }

    public static RudderClient getInstance() {
        return instance;
    }
}
