package com.google.firebase.perf.transport;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.datatransport.TransportFactory;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.perf.BuildConfig;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.application.AppStateMonitor;
import com.google.firebase.perf.application.AppStateMonitor.AppStateCallback;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.config.ConfigurationConstants$LogSourceName;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.Constants$CounterNames;
import com.google.firebase.perf.util.Optional;
import com.google.firebase.perf.util.Rate;
import com.google.firebase.perf.v1.AndroidApplicationInfo;
import com.google.firebase.perf.v1.ApplicationInfo;
import com.google.firebase.perf.v1.ApplicationInfo.Builder;
import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.GaugeMetric;
import com.google.firebase.perf.v1.NetworkRequestMetric;
import com.google.firebase.perf.v1.PerfMetric;
import com.google.firebase.perf.v1.PerfMetricOrBuilder;
import com.google.firebase.perf.v1.TraceMetric;
import com.razorpay.AnalyticsConstants;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class TransportManager implements AppStateCallback {
    public static final TransportManager instance = new TransportManager();
    public static final AndroidLogger logger = AndroidLogger.getInstance();
    public Context appContext;
    public AppStateMonitor appStateMonitor;
    public Builder applicationInfoBuilder;
    public final Map<String, Integer> cacheMap;
    public ConfigResolver configResolver;
    public ExecutorService executorService;
    public FirebaseApp firebaseApp;
    public FirebaseInstallationsApi firebaseInstallationsApi;
    public FirebasePerformance firebasePerformance;
    public FlgTransport flgTransport;
    public Provider<TransportFactory> flgTransportFactoryProvider;
    public boolean isForegroundState = false;
    public final AtomicBoolean isTransportInitialized = new AtomicBoolean(false);
    public String packageName;
    public final ConcurrentLinkedQueue<PendingPerfEvent> pendingEventsQueue = new ConcurrentLinkedQueue<>();
    public String projectId;
    public RateLimiter rateLimiter;

    public TransportManager() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 10, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.executorService = threadPoolExecutor;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.cacheMap = concurrentHashMap;
        Integer valueOf = Integer.valueOf(50);
        concurrentHashMap.put("KEY_AVAILABLE_TRACES_FOR_CACHING", valueOf);
        this.cacheMap.put("KEY_AVAILABLE_NETWORK_REQUESTS_FOR_CACHING", valueOf);
        this.cacheMap.put("KEY_AVAILABLE_GAUGES_FOR_CACHING", valueOf);
    }

    public static String getLogcatMsg(PerfMetricOrBuilder perfMetricOrBuilder) {
        if (perfMetricOrBuilder.hasTraceMetric()) {
            TraceMetric traceMetric = perfMetricOrBuilder.getTraceMetric();
            return String.format(Locale.ENGLISH, "trace metric: %s (duration: %sms)", new Object[]{traceMetric.name_, new DecimalFormat("#.####").format(((double) traceMetric.durationUs_) / 1000.0d)});
        } else if (perfMetricOrBuilder.hasNetworkRequestMetric()) {
            NetworkRequestMetric networkRequestMetric = perfMetricOrBuilder.getNetworkRequestMetric();
            return String.format(Locale.ENGLISH, "network request trace: %s (responseCode: %s, responseTime: %sms)", new Object[]{networkRequestMetric.url_, networkRequestMetric.hasHttpResponseCode() ? String.valueOf(networkRequestMetric.httpResponseCode_) : "UNKNOWN", new DecimalFormat("#.####").format(((double) (networkRequestMetric.hasTimeToResponseCompletedUs() ? networkRequestMetric.timeToResponseCompletedUs_ : 0)) / 1000.0d)});
        } else if (!perfMetricOrBuilder.hasGaugeMetric()) {
            return AnalyticsConstants.LOG;
        } else {
            GaugeMetric gaugeMetric = perfMetricOrBuilder.getGaugeMetric();
            Locale locale = Locale.ENGLISH;
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf((gaugeMetric.bitField0_ & 2) != 0);
            objArr[1] = Integer.valueOf(gaugeMetric.cpuMetricReadings_.size());
            objArr[2] = Integer.valueOf(gaugeMetric.androidMemoryReadings_.size());
            return String.format(locale, "gauges (hasMetadata: %b, cpuGaugeCount: %d, memoryGaugeCount: %d)", objArr);
        }
    }

    public final void incrementDropCount(PerfMetric perfMetric) {
        if (perfMetric.hasTraceMetric()) {
            this.appStateMonitor.incrementCount(Constants$CounterNames.TRACE_EVENT_RATE_LIMITED.toString(), 1);
        } else if (perfMetric.hasNetworkRequestMetric()) {
            this.appStateMonitor.incrementCount(Constants$CounterNames.NETWORK_TRACE_EVENT_RATE_LIMITED.toString(), 1);
        }
    }

    public boolean isInitialized() {
        return this.isTransportInitialized.get();
    }

    public /* synthetic */ void lambda$finishInitialization$0$TransportManager(PendingPerfEvent pendingPerfEvent) {
        syncLog(pendingPerfEvent.perfMetricBuilder, pendingPerfEvent.appState);
    }

    public /* synthetic */ void lambda$log$2$TransportManager(TraceMetric traceMetric, ApplicationProcessState applicationProcessState) {
        syncLog(PerfMetric.newBuilder().setTraceMetric(traceMetric), applicationProcessState);
    }

    public /* synthetic */ void lambda$log$3$TransportManager(NetworkRequestMetric networkRequestMetric, ApplicationProcessState applicationProcessState) {
        syncLog(PerfMetric.newBuilder().setNetworkRequestMetric(networkRequestMetric), applicationProcessState);
    }

    public /* synthetic */ void lambda$log$4$TransportManager(GaugeMetric gaugeMetric, ApplicationProcessState applicationProcessState) {
        syncLog(PerfMetric.newBuilder().setGaugeMetric(gaugeMetric), applicationProcessState);
    }

    public /* synthetic */ void lambda$onUpdateAppState$1$TransportManager() {
        this.rateLimiter.changeRate(this.isForegroundState);
    }

    public void onUpdateAppState(ApplicationProcessState applicationProcessState) {
        this.isForegroundState = applicationProcessState == ApplicationProcessState.FOREGROUND;
        if (isInitialized()) {
            this.executorService.execute(new Runnable() {
                public final void run() {
                    TransportManager.this.lambda$onUpdateAppState$1$TransportManager();
                }
            });
        }
    }

    public final void syncInit() {
        FirebaseApp firebaseApp2 = this.firebaseApp;
        firebaseApp2.checkNotDeleted();
        Context context = firebaseApp2.applicationContext;
        this.appContext = context;
        this.packageName = context.getPackageName();
        this.configResolver = ConfigResolver.getInstance();
        Context context2 = this.appContext;
        Rate rate = new Rate(100, 1, TimeUnit.MINUTES);
        this.rateLimiter = new RateLimiter(context2, rate, 500);
        this.appStateMonitor = AppStateMonitor.getInstance();
        Provider<TransportFactory> provider = this.flgTransportFactoryProvider;
        ConfigResolver configResolver2 = this.configResolver;
        if (configResolver2 != null) {
            ConfigurationConstants$LogSourceName instance2 = ConfigurationConstants$LogSourceName.getInstance();
            String str = "FIREPERF";
            if (BuildConfig.ENFORCE_DEFAULT_LOG_SRC.booleanValue()) {
                if (instance2 != null) {
                    String str2 = BuildConfig.TRANSPORT_LOG_SRC;
                } else {
                    throw null;
                }
            } else if (instance2 != null) {
                long longValue = ((Long) configResolver2.remoteConfigManager.getRemoteConfigValueOrDefault("fpr_log_source", Long.valueOf(-1))).longValue();
                if (ConfigurationConstants$LogSourceName.LOG_SOURCE_MAP.containsKey(Long.valueOf(longValue))) {
                    String str3 = ConfigurationConstants$LogSourceName.LOG_SOURCE_MAP.get(Long.valueOf(longValue));
                    if (str3 != null) {
                        configResolver2.deviceCacheManager.setValue((String) "com.google.firebase.perf.LogSourceName", str3);
                        str = str3;
                    }
                }
                Optional<String> deviceCacheString = configResolver2.getDeviceCacheString(instance2);
                if (deviceCacheString.isAvailable()) {
                    str = (String) deviceCacheString.get();
                } else {
                    String str4 = BuildConfig.TRANSPORT_LOG_SRC;
                }
            } else {
                throw null;
            }
            this.flgTransport = new FlgTransport(provider, str);
            AppStateMonitor appStateMonitor2 = this.appStateMonitor;
            WeakReference weakReference = new WeakReference(instance);
            synchronized (appStateMonitor2.appStateSubscribers) {
                appStateMonitor2.appStateSubscribers.add(weakReference);
            }
            Builder builder = (Builder) ApplicationInfo.DEFAULT_INSTANCE.createBuilder();
            this.applicationInfoBuilder = builder;
            FirebaseApp firebaseApp3 = this.firebaseApp;
            firebaseApp3.checkNotDeleted();
            String str5 = firebaseApp3.options.applicationId;
            builder.copyOnWrite();
            ApplicationInfo.access$100((ApplicationInfo) builder.instance, str5);
            AndroidApplicationInfo.Builder builder2 = (AndroidApplicationInfo.Builder) AndroidApplicationInfo.DEFAULT_INSTANCE.createBuilder();
            String str6 = this.packageName;
            builder2.copyOnWrite();
            AndroidApplicationInfo.access$100((AndroidApplicationInfo) builder2.instance, str6);
            String str7 = BuildConfig.FIREPERF_VERSION_NAME;
            builder2.copyOnWrite();
            AndroidApplicationInfo.access$400((AndroidApplicationInfo) builder2.instance, "20.0.6");
            Context context3 = this.appContext;
            String str8 = "";
            try {
                PackageInfo packageInfo = context3.getPackageManager().getPackageInfo(context3.getPackageName(), 0);
                if (packageInfo.versionName != null) {
                    str8 = packageInfo.versionName;
                }
            } catch (NameNotFoundException unused) {
            }
            builder2.copyOnWrite();
            AndroidApplicationInfo.access$700((AndroidApplicationInfo) builder2.instance, str8);
            builder.copyOnWrite();
            ApplicationInfo.access$700((ApplicationInfo) builder.instance, (AndroidApplicationInfo) builder2.build());
            this.isTransportInitialized.set(true);
            while (!this.pendingEventsQueue.isEmpty()) {
                PendingPerfEvent poll = this.pendingEventsQueue.poll();
                if (poll != null) {
                    this.executorService.execute(new Runnable(poll) {
                        public final /* synthetic */ PendingPerfEvent f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            TransportManager.this.lambda$finishInitialization$0$TransportManager(this.f$1);
                        }
                    });
                }
            }
            return;
        }
        throw null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0301, code lost:
        if (r14.hasVerboseSessions(r13.getTraceMetric().perfSessions_) == false) goto L_0x03a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x039e, code lost:
        if (r14.hasVerboseSessions(r13.getNetworkRequestMetric().perfSessions_) == false) goto L_0x03a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x03a0, code lost:
        r14 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x0439  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0162  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x017b  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01a4  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01b6  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0252  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0263  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void syncLog(com.google.firebase.perf.v1.PerfMetric.Builder r13, com.google.firebase.perf.v1.ApplicationProcessState r14) {
        /*
            r12 = this;
            boolean r0 = r12.isInitialized()
            r1 = 3
            r2 = 2
            r3 = 4
            r4 = 0
            r5 = 1
            if (r0 != 0) goto L_0x00ad
            java.util.Map<java.lang.String, java.lang.Integer> r0 = r12.cacheMap
            java.lang.String r6 = "KEY_AVAILABLE_TRACES_FOR_CACHING"
            java.lang.Object r0 = r0.get(r6)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            java.util.Map<java.lang.String, java.lang.Integer> r7 = r12.cacheMap
            java.lang.String r8 = "KEY_AVAILABLE_NETWORK_REQUESTS_FOR_CACHING"
            java.lang.Object r7 = r7.get(r8)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            java.util.Map<java.lang.String, java.lang.Integer> r9 = r12.cacheMap
            java.lang.String r10 = "KEY_AVAILABLE_GAUGES_FOR_CACHING"
            java.lang.Object r9 = r9.get(r10)
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            boolean r11 = r13.hasTraceMetric()
            if (r11 == 0) goto L_0x0049
            if (r0 <= 0) goto L_0x0049
            java.util.Map<java.lang.String, java.lang.Integer> r1 = r12.cacheMap
            int r0 = r0 - r5
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1.put(r6, r0)
        L_0x0047:
            r0 = 1
            goto L_0x0091
        L_0x0049:
            boolean r6 = r13.hasNetworkRequestMetric()
            if (r6 == 0) goto L_0x005c
            if (r7 <= 0) goto L_0x005c
            java.util.Map<java.lang.String, java.lang.Integer> r0 = r12.cacheMap
            int r7 = r7 - r5
            java.lang.Integer r1 = java.lang.Integer.valueOf(r7)
            r0.put(r8, r1)
            goto L_0x0047
        L_0x005c:
            boolean r6 = r13.hasGaugeMetric()
            if (r6 == 0) goto L_0x006f
            if (r9 <= 0) goto L_0x006f
            java.util.Map<java.lang.String, java.lang.Integer> r0 = r12.cacheMap
            int r9 = r9 - r5
            java.lang.Integer r1 = java.lang.Integer.valueOf(r9)
            r0.put(r10, r1)
            goto L_0x0047
        L_0x006f:
            com.google.firebase.perf.logging.AndroidLogger r6 = logger
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r8 = getLogcatMsg(r13)
            r3[r4] = r8
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r3[r5] = r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r7)
            r3[r2] = r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r9)
            r3[r1] = r0
            java.lang.String r0 = "%s is not allowed to cache. Cache exhausted the limit (availableTracesForCaching: %d, availableNetworkRequestsForCaching: %d, availableGaugesForCaching: %d)."
            r6.debug(r0, r3)
            r0 = 0
        L_0x0091:
            if (r0 == 0) goto L_0x00ac
            com.google.firebase.perf.logging.AndroidLogger r0 = logger
            java.lang.String r1 = "Transport is not initialized yet, %s will be queued for to be dispatched later"
            java.lang.Object[] r2 = new java.lang.Object[r5]
            java.lang.String r3 = getLogcatMsg(r13)
            r2[r4] = r3
            r0.debug(r1, r2)
            java.util.concurrent.ConcurrentLinkedQueue<com.google.firebase.perf.transport.PendingPerfEvent> r0 = r12.pendingEventsQueue
            com.google.firebase.perf.transport.PendingPerfEvent r1 = new com.google.firebase.perf.transport.PendingPerfEvent
            r1.<init>(r13, r14)
            r0.add(r1)
        L_0x00ac:
            return
        L_0x00ad:
            com.google.firebase.perf.config.ConfigResolver r0 = r12.configResolver
            boolean r0 = r0.isPerformanceMonitoringEnabled()
            r6 = 0
            if (r0 == 0) goto L_0x0126
            com.google.firebase.perf.v1.ApplicationInfo$Builder r0 = r12.applicationInfoBuilder
            MessageType r0 = r0.instance
            com.google.firebase.perf.v1.ApplicationInfo r0 = (com.google.firebase.perf.v1.ApplicationInfo) r0
            boolean r0 = r0.hasAppInstanceId()
            if (r0 == 0) goto L_0x00c7
            boolean r0 = r12.isForegroundState
            if (r0 != 0) goto L_0x00c7
            goto L_0x0126
        L_0x00c7:
            com.google.firebase.installations.FirebaseInstallationsApi r0 = r12.firebaseInstallationsApi     // Catch:{ ExecutionException -> 0x00fb, InterruptedException -> 0x00ea, TimeoutException -> 0x00d9 }
            com.google.android.gms.tasks.Task r0 = r0.getId()     // Catch:{ ExecutionException -> 0x00fb, InterruptedException -> 0x00ea, TimeoutException -> 0x00d9 }
            r7 = 60000(0xea60, double:2.9644E-319)
            java.util.concurrent.TimeUnit r9 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ ExecutionException -> 0x00fb, InterruptedException -> 0x00ea, TimeoutException -> 0x00d9 }
            java.lang.Object r0 = com.google.android.gms.tasks.Tasks.await(r0, r7, r9)     // Catch:{ ExecutionException -> 0x00fb, InterruptedException -> 0x00ea, TimeoutException -> 0x00d9 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ ExecutionException -> 0x00fb, InterruptedException -> 0x00ea, TimeoutException -> 0x00d9 }
            goto L_0x010c
        L_0x00d9:
            r0 = move-exception
            com.google.firebase.perf.logging.AndroidLogger r7 = logger
            java.lang.Object[] r8 = new java.lang.Object[r5]
            java.lang.String r0 = r0.getMessage()
            r8[r4] = r0
            java.lang.String r0 = "Task to retrieve Installation Id is timed out: %s"
            r7.error(r0, r8)
            goto L_0x010b
        L_0x00ea:
            r0 = move-exception
            com.google.firebase.perf.logging.AndroidLogger r7 = logger
            java.lang.Object[] r8 = new java.lang.Object[r5]
            java.lang.String r0 = r0.getMessage()
            r8[r4] = r0
            java.lang.String r0 = "Task to retrieve Installation Id is interrupted: %s"
            r7.error(r0, r8)
            goto L_0x010b
        L_0x00fb:
            r0 = move-exception
            com.google.firebase.perf.logging.AndroidLogger r7 = logger
            java.lang.Object[] r8 = new java.lang.Object[r5]
            java.lang.String r0 = r0.getMessage()
            r8[r4] = r0
            java.lang.String r0 = "Unable to retrieve Installation Id: %s"
            r7.error(r0, r8)
        L_0x010b:
            r0 = r6
        L_0x010c:
            boolean r7 = android.text.TextUtils.isEmpty(r0)
            if (r7 != 0) goto L_0x011f
            com.google.firebase.perf.v1.ApplicationInfo$Builder r7 = r12.applicationInfoBuilder
            r7.copyOnWrite()
            MessageType r7 = r7.instance
            com.google.firebase.perf.v1.ApplicationInfo r7 = (com.google.firebase.perf.v1.ApplicationInfo) r7
            com.google.firebase.perf.v1.ApplicationInfo.access$400(r7, r0)
            goto L_0x0126
        L_0x011f:
            com.google.firebase.perf.logging.AndroidLogger r0 = logger
            java.lang.String r7 = "Firebase Installation Id is empty, contact Firebase Support for debugging."
            r0.warn(r7)
        L_0x0126:
            com.google.firebase.perf.v1.ApplicationInfo$Builder r0 = r12.applicationInfoBuilder
            r0.copyOnWrite()
            MessageType r7 = r0.instance
            com.google.firebase.perf.v1.ApplicationInfo r7 = (com.google.firebase.perf.v1.ApplicationInfo) r7
            com.google.firebase.perf.v1.ApplicationInfo.access$1000(r7, r14)
            boolean r14 = r13.hasTraceMetric()
            if (r14 != 0) goto L_0x013e
            boolean r14 = r13.hasNetworkRequestMetric()
            if (r14 == 0) goto L_0x0186
        L_0x013e:
            MessageType r14 = r0.defaultInstance
            com.google.protobuf.GeneratedMessageLite$Builder r14 = r14.newBuilderForType()
            com.google.protobuf.GeneratedMessageLite r0 = r0.buildPartial()
            r14.mergeFrom(r0)
            r0 = r14
            com.google.firebase.perf.v1.ApplicationInfo$Builder r0 = (com.google.firebase.perf.v1.ApplicationInfo.Builder) r0
            com.google.firebase.perf.FirebasePerformance r14 = r12.firebasePerformance
            if (r14 != 0) goto L_0x015e
            boolean r14 = r12.isInitialized()
            if (r14 == 0) goto L_0x015e
            com.google.firebase.perf.FirebasePerformance r14 = com.google.firebase.perf.FirebasePerformance.getInstance()
            r12.firebasePerformance = r14
        L_0x015e:
            com.google.firebase.perf.FirebasePerformance r14 = r12.firebasePerformance
            if (r14 == 0) goto L_0x016a
            java.util.HashMap r7 = new java.util.HashMap
            java.util.Map<java.lang.String, java.lang.String> r14 = r14.mCustomAttributes
            r7.<init>(r14)
            goto L_0x016e
        L_0x016a:
            java.util.Map r7 = java.util.Collections.emptyMap()
        L_0x016e:
            r0.copyOnWrite()
            MessageType r14 = r0.instance
            com.google.firebase.perf.v1.ApplicationInfo r14 = (com.google.firebase.perf.v1.ApplicationInfo) r14
            com.google.protobuf.MapFieldLite<java.lang.String, java.lang.String> r8 = r14.customAttributes_
            boolean r9 = r8.isMutable
            if (r9 != 0) goto L_0x0181
            com.google.protobuf.MapFieldLite r8 = r8.mutableCopy()
            r14.customAttributes_ = r8
        L_0x0181:
            com.google.protobuf.MapFieldLite<java.lang.String, java.lang.String> r14 = r14.customAttributes_
            r14.putAll(r7)
        L_0x0186:
            r13.copyOnWrite()
            MessageType r14 = r13.instance
            com.google.firebase.perf.v1.PerfMetric r14 = (com.google.firebase.perf.v1.PerfMetric) r14
            com.google.protobuf.GeneratedMessageLite r0 = r0.build()
            com.google.firebase.perf.v1.ApplicationInfo r0 = (com.google.firebase.perf.v1.ApplicationInfo) r0
            com.google.firebase.perf.v1.PerfMetric.access$100(r14, r0)
            com.google.protobuf.GeneratedMessageLite r13 = r13.build()
            com.google.firebase.perf.v1.PerfMetric r13 = (com.google.firebase.perf.v1.PerfMetric) r13
            com.google.firebase.perf.config.ConfigResolver r14 = r12.configResolver
            boolean r14 = r14.isPerformanceMonitoringEnabled()
            if (r14 != 0) goto L_0x01b6
            com.google.firebase.perf.logging.AndroidLogger r14 = logger
            java.lang.String r0 = "Performance collection is not enabled, dropping %s"
            java.lang.Object[] r7 = new java.lang.Object[r5]
            java.lang.String r8 = getLogcatMsg(r13)
            r7[r4] = r8
            r14.info(r0, r7)
        L_0x01b3:
            r14 = 0
            goto L_0x0437
        L_0x01b6:
            com.google.firebase.perf.v1.ApplicationInfo r14 = r13.applicationInfo_
            if (r14 != 0) goto L_0x01bc
            com.google.firebase.perf.v1.ApplicationInfo r14 = com.google.firebase.perf.v1.ApplicationInfo.DEFAULT_INSTANCE
        L_0x01bc:
            boolean r14 = r14.hasAppInstanceId()
            if (r14 != 0) goto L_0x01d2
            com.google.firebase.perf.logging.AndroidLogger r14 = logger
            java.lang.String r0 = "App Instance ID is null or empty, dropping %s"
            java.lang.Object[] r7 = new java.lang.Object[r5]
            java.lang.String r8 = getLogcatMsg(r13)
            r7[r4] = r8
            r14.warn(r0, r7)
            goto L_0x01b3
        L_0x01d2:
            android.content.Context r14 = r12.appContext
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            boolean r7 = r13.hasTraceMetric()
            if (r7 == 0) goto L_0x01eb
            com.google.firebase.perf.metrics.validator.FirebasePerfTraceValidator r7 = new com.google.firebase.perf.metrics.validator.FirebasePerfTraceValidator
            com.google.firebase.perf.v1.TraceMetric r8 = r13.getTraceMetric()
            r7.<init>(r8)
            r0.add(r7)
        L_0x01eb:
            boolean r7 = r13.hasNetworkRequestMetric()
            if (r7 == 0) goto L_0x01fd
            com.google.firebase.perf.metrics.validator.FirebasePerfNetworkValidator r7 = new com.google.firebase.perf.metrics.validator.FirebasePerfNetworkValidator
            com.google.firebase.perf.v1.NetworkRequestMetric r8 = r13.getNetworkRequestMetric()
            r7.<init>(r8, r14)
            r0.add(r7)
        L_0x01fd:
            int r14 = r13.bitField0_
            r14 = r14 & r5
            if (r14 == 0) goto L_0x0204
            r14 = 1
            goto L_0x0205
        L_0x0204:
            r14 = 0
        L_0x0205:
            if (r14 == 0) goto L_0x0215
            com.google.firebase.perf.metrics.validator.FirebasePerfApplicationInfoValidator r14 = new com.google.firebase.perf.metrics.validator.FirebasePerfApplicationInfoValidator
            com.google.firebase.perf.v1.ApplicationInfo r7 = r13.applicationInfo_
            if (r7 != 0) goto L_0x020f
            com.google.firebase.perf.v1.ApplicationInfo r7 = com.google.firebase.perf.v1.ApplicationInfo.DEFAULT_INSTANCE
        L_0x020f:
            r14.<init>(r7)
            r0.add(r14)
        L_0x0215:
            boolean r14 = r13.hasGaugeMetric()
            if (r14 == 0) goto L_0x0227
            com.google.firebase.perf.metrics.validator.FirebasePerfGaugeMetricValidator r14 = new com.google.firebase.perf.metrics.validator.FirebasePerfGaugeMetricValidator
            com.google.firebase.perf.v1.GaugeMetric r7 = r13.getGaugeMetric()
            r14.<init>(r7)
            r0.add(r14)
        L_0x0227:
            boolean r14 = r0.isEmpty()
            if (r14 == 0) goto L_0x0237
            com.google.firebase.perf.logging.AndroidLogger r14 = com.google.firebase.perf.logging.AndroidLogger.getInstance()
            java.lang.String r0 = "No validators found for PerfMetric."
            r14.debug(r0)
            goto L_0x024d
        L_0x0237:
            java.util.Iterator r14 = r0.iterator()
        L_0x023b:
            boolean r0 = r14.hasNext()
            if (r0 == 0) goto L_0x024f
            java.lang.Object r0 = r14.next()
            com.google.firebase.perf.metrics.validator.PerfMetricValidator r0 = (com.google.firebase.perf.metrics.validator.PerfMetricValidator) r0
            boolean r0 = r0.isValidPerfMetric()
            if (r0 != 0) goto L_0x023b
        L_0x024d:
            r14 = 0
            goto L_0x0250
        L_0x024f:
            r14 = 1
        L_0x0250:
            if (r14 != 0) goto L_0x0263
            com.google.firebase.perf.logging.AndroidLogger r14 = logger
            java.lang.String r0 = "Unable to process the PerfMetric (%s) due to missing or invalid values. See earlier log statements for additional information on the specific missing/invalid values."
            java.lang.Object[] r7 = new java.lang.Object[r5]
            java.lang.String r8 = getLogcatMsg(r13)
            r7[r4] = r8
            r14.warn(r0, r7)
            goto L_0x01b3
        L_0x0263:
            com.google.firebase.perf.transport.RateLimiter r14 = r12.rateLimiter
            if (r14 == 0) goto L_0x04f6
            boolean r0 = r13.hasTraceMetric()
            r7 = 1065353216(0x3f800000, float:1.0)
            java.lang.Float r7 = java.lang.Float.valueOf(r7)
            if (r0 == 0) goto L_0x030a
            com.google.firebase.perf.config.ConfigResolver r0 = r14.configResolver
            if (r0 == 0) goto L_0x0309
            java.lang.Class<com.google.firebase.perf.config.ConfigurationConstants$TraceSamplingRate> r8 = com.google.firebase.perf.config.ConfigurationConstants$TraceSamplingRate.class
            monitor-enter(r8)
            com.google.firebase.perf.config.ConfigurationConstants$TraceSamplingRate r9 = com.google.firebase.perf.config.ConfigurationConstants$TraceSamplingRate.instance     // Catch:{ all -> 0x0306 }
            if (r9 != 0) goto L_0x0285
            com.google.firebase.perf.config.ConfigurationConstants$TraceSamplingRate r9 = new com.google.firebase.perf.config.ConfigurationConstants$TraceSamplingRate     // Catch:{ all -> 0x0306 }
            r9.<init>()     // Catch:{ all -> 0x0306 }
            com.google.firebase.perf.config.ConfigurationConstants$TraceSamplingRate.instance = r9     // Catch:{ all -> 0x0306 }
        L_0x0285:
            com.google.firebase.perf.config.ConfigurationConstants$TraceSamplingRate r9 = com.google.firebase.perf.config.ConfigurationConstants$TraceSamplingRate.instance     // Catch:{ all -> 0x0306 }
            monitor-exit(r8)
            com.google.firebase.perf.util.Optional r8 = r0.getRemoteConfigFloat(r9)
            boolean r10 = r8.isAvailable()
            if (r10 == 0) goto L_0x02c1
            java.lang.Object r10 = r8.get()
            java.lang.Float r10 = (java.lang.Float) r10
            float r10 = r10.floatValue()
            boolean r10 = r0.isSamplingRateValid(r10)
            if (r10 == 0) goto L_0x02c1
            com.google.firebase.perf.config.DeviceCacheManager r0 = r0.deviceCacheManager
            if (r9 == 0) goto L_0x02c0
            java.lang.String r9 = "com.google.firebase.perf.TraceSamplingRate"
            java.lang.Object r10 = r8.get()
            java.lang.Float r10 = (java.lang.Float) r10
            float r10 = r10.floatValue()
            r0.setValue(r9, r10)
            java.lang.Object r0 = r8.get()
            java.lang.Float r0 = (java.lang.Float) r0
            float r0 = r0.floatValue()
            goto L_0x02ec
        L_0x02c0:
            throw r6
        L_0x02c1:
            com.google.firebase.perf.util.Optional r8 = r0.getDeviceCacheFloat(r9)
            boolean r10 = r8.isAvailable()
            if (r10 == 0) goto L_0x02e6
            java.lang.Object r10 = r8.get()
            java.lang.Float r10 = (java.lang.Float) r10
            float r10 = r10.floatValue()
            boolean r0 = r0.isSamplingRateValid(r10)
            if (r0 == 0) goto L_0x02e6
            java.lang.Object r0 = r8.get()
            java.lang.Float r0 = (java.lang.Float) r0
            float r0 = r0.floatValue()
            goto L_0x02ec
        L_0x02e6:
            if (r9 == 0) goto L_0x0305
            float r0 = r7.floatValue()
        L_0x02ec:
            float r8 = r14.samplingBucketId
            int r0 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x02f4
            r0 = 1
            goto L_0x02f5
        L_0x02f4:
            r0 = 0
        L_0x02f5:
            if (r0 != 0) goto L_0x030a
            com.google.firebase.perf.v1.TraceMetric r0 = r13.getTraceMetric()
            com.google.protobuf.Internal$ProtobufList<com.google.firebase.perf.v1.PerfSession> r0 = r0.perfSessions_
            boolean r0 = r14.hasVerboseSessions(r0)
            if (r0 != 0) goto L_0x030a
            goto L_0x03a0
        L_0x0305:
            throw r6
        L_0x0306:
            r13 = move-exception
            monitor-exit(r8)
            throw r13
        L_0x0309:
            throw r6
        L_0x030a:
            boolean r0 = r13.hasNetworkRequestMetric()
            if (r0 == 0) goto L_0x03a7
            com.google.firebase.perf.config.ConfigResolver r0 = r14.configResolver
            if (r0 == 0) goto L_0x03a6
            java.lang.Class<com.google.firebase.perf.config.ConfigurationConstants$NetworkRequestSamplingRate> r8 = com.google.firebase.perf.config.ConfigurationConstants$NetworkRequestSamplingRate.class
            monitor-enter(r8)
            com.google.firebase.perf.config.ConfigurationConstants$NetworkRequestSamplingRate r9 = com.google.firebase.perf.config.ConfigurationConstants$NetworkRequestSamplingRate.instance     // Catch:{ all -> 0x03a3 }
            if (r9 != 0) goto L_0x0322
            com.google.firebase.perf.config.ConfigurationConstants$NetworkRequestSamplingRate r9 = new com.google.firebase.perf.config.ConfigurationConstants$NetworkRequestSamplingRate     // Catch:{ all -> 0x03a3 }
            r9.<init>()     // Catch:{ all -> 0x03a3 }
            com.google.firebase.perf.config.ConfigurationConstants$NetworkRequestSamplingRate.instance = r9     // Catch:{ all -> 0x03a3 }
        L_0x0322:
            com.google.firebase.perf.config.ConfigurationConstants$NetworkRequestSamplingRate r9 = com.google.firebase.perf.config.ConfigurationConstants$NetworkRequestSamplingRate.instance     // Catch:{ all -> 0x03a3 }
            monitor-exit(r8)
            com.google.firebase.perf.util.Optional r8 = r0.getRemoteConfigFloat(r9)
            boolean r10 = r8.isAvailable()
            if (r10 == 0) goto L_0x035e
            java.lang.Object r10 = r8.get()
            java.lang.Float r10 = (java.lang.Float) r10
            float r10 = r10.floatValue()
            boolean r10 = r0.isSamplingRateValid(r10)
            if (r10 == 0) goto L_0x035e
            com.google.firebase.perf.config.DeviceCacheManager r0 = r0.deviceCacheManager
            if (r9 == 0) goto L_0x035d
            java.lang.String r7 = "com.google.firebase.perf.NetworkRequestSamplingRate"
            java.lang.Object r9 = r8.get()
            java.lang.Float r9 = (java.lang.Float) r9
            float r9 = r9.floatValue()
            r0.setValue(r7, r9)
            java.lang.Object r0 = r8.get()
            java.lang.Float r0 = (java.lang.Float) r0
            float r0 = r0.floatValue()
            goto L_0x0389
        L_0x035d:
            throw r6
        L_0x035e:
            com.google.firebase.perf.util.Optional r8 = r0.getDeviceCacheFloat(r9)
            boolean r10 = r8.isAvailable()
            if (r10 == 0) goto L_0x0383
            java.lang.Object r10 = r8.get()
            java.lang.Float r10 = (java.lang.Float) r10
            float r10 = r10.floatValue()
            boolean r0 = r0.isSamplingRateValid(r10)
            if (r0 == 0) goto L_0x0383
            java.lang.Object r0 = r8.get()
            java.lang.Float r0 = (java.lang.Float) r0
            float r0 = r0.floatValue()
            goto L_0x0389
        L_0x0383:
            if (r9 == 0) goto L_0x03a2
            float r0 = r7.floatValue()
        L_0x0389:
            float r7 = r14.samplingBucketId
            int r0 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x0391
            r0 = 1
            goto L_0x0392
        L_0x0391:
            r0 = 0
        L_0x0392:
            if (r0 != 0) goto L_0x03a7
            com.google.firebase.perf.v1.NetworkRequestMetric r0 = r13.getNetworkRequestMetric()
            com.google.protobuf.Internal$ProtobufList<com.google.firebase.perf.v1.PerfSession> r0 = r0.perfSessions_
            boolean r14 = r14.hasVerboseSessions(r0)
            if (r14 != 0) goto L_0x03a7
        L_0x03a0:
            r14 = 0
            goto L_0x03a8
        L_0x03a2:
            throw r6
        L_0x03a3:
            r13 = move-exception
            monitor-exit(r8)
            throw r13
        L_0x03a6:
            throw r6
        L_0x03a7:
            r14 = 1
        L_0x03a8:
            if (r14 != 0) goto L_0x03be
            r12.incrementDropCount(r13)
            com.google.firebase.perf.logging.AndroidLogger r14 = logger
            java.lang.String r0 = "Event dropped due to device sampling - %s"
            java.lang.Object[] r7 = new java.lang.Object[r5]
            java.lang.String r8 = getLogcatMsg(r13)
            r7[r4] = r8
            r14.info(r0, r7)
            goto L_0x01b3
        L_0x03be:
            com.google.firebase.perf.transport.RateLimiter r14 = r12.rateLimiter
            if (r14 == 0) goto L_0x04f5
            boolean r0 = r13.hasTraceMetric()
            if (r0 == 0) goto L_0x03f7
            com.google.firebase.perf.v1.TraceMetric r0 = r13.getTraceMetric()
            java.lang.String r0 = r0.name_
            com.google.firebase.perf.util.Constants$TraceNames r7 = com.google.firebase.perf.util.Constants$TraceNames.FOREGROUND_TRACE_NAME
            java.lang.String r7 = r7.toString()
            boolean r0 = r0.equals(r7)
            if (r0 != 0) goto L_0x03ec
            com.google.firebase.perf.v1.TraceMetric r0 = r13.getTraceMetric()
            java.lang.String r0 = r0.name_
            com.google.firebase.perf.util.Constants$TraceNames r7 = com.google.firebase.perf.util.Constants$TraceNames.BACKGROUND_TRACE_NAME
            java.lang.String r7 = r7.toString()
            boolean r0 = r0.equals(r7)
            if (r0 == 0) goto L_0x03f7
        L_0x03ec:
            com.google.firebase.perf.v1.TraceMetric r0 = r13.getTraceMetric()
            int r0 = r0.getCountersCount()
            if (r0 <= 0) goto L_0x03f7
            goto L_0x03fd
        L_0x03f7:
            boolean r0 = r13.hasGaugeMetric()
            if (r0 == 0) goto L_0x03ff
        L_0x03fd:
            r0 = 0
            goto L_0x0400
        L_0x03ff:
            r0 = 1
        L_0x0400:
            if (r0 != 0) goto L_0x0404
            r14 = 0
            goto L_0x0420
        L_0x0404:
            boolean r0 = r13.hasNetworkRequestMetric()
            if (r0 == 0) goto L_0x0411
            com.google.firebase.perf.transport.RateLimiter$RateLimiterImpl r14 = r14.networkLimiter
            boolean r14 = r14.check()
            goto L_0x041d
        L_0x0411:
            boolean r0 = r13.hasTraceMetric()
            if (r0 == 0) goto L_0x041f
            com.google.firebase.perf.transport.RateLimiter$RateLimiterImpl r14 = r14.traceLimiter
            boolean r14 = r14.check()
        L_0x041d:
            r14 = r14 ^ r5
            goto L_0x0420
        L_0x041f:
            r14 = 1
        L_0x0420:
            if (r14 == 0) goto L_0x0436
            r12.incrementDropCount(r13)
            com.google.firebase.perf.logging.AndroidLogger r14 = logger
            java.lang.String r0 = "Rate limited (per device) - %s"
            java.lang.Object[] r7 = new java.lang.Object[r5]
            java.lang.String r8 = getLogcatMsg(r13)
            r7[r4] = r8
            r14.info(r0, r7)
            goto L_0x01b3
        L_0x0436:
            r14 = 1
        L_0x0437:
            if (r14 == 0) goto L_0x04f4
            boolean r14 = r13.hasTraceMetric()
            if (r14 == 0) goto L_0x0494
            com.google.firebase.perf.logging.AndroidLogger r14 = logger
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r7 = getLogcatMsg(r13)
            r0[r4] = r7
            com.google.firebase.perf.v1.TraceMetric r7 = r13.getTraceMetric()
            java.lang.String r7 = r7.name_
            java.lang.String r8 = "_st_"
            boolean r8 = r7.startsWith(r8)
            java.lang.String r9 = "android-ide"
            java.lang.String r10 = "perf-android-sdk"
            if (r8 == 0) goto L_0x0474
            java.lang.String r8 = r12.projectId
            java.lang.String r11 = r12.packageName
            java.lang.String r8 = com.google.android.material.resources.TextAppearanceConfig.getRootUrl(r8, r11)
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r4] = r8
            r3[r5] = r7
            r3[r2] = r10
            r3[r1] = r9
            java.lang.String r1 = "%s/metrics/trace/SCREEN_TRACE/%s?utm_source=%s&utm_medium=%s"
            java.lang.String r1 = java.lang.String.format(r1, r3)
            goto L_0x048c
        L_0x0474:
            java.lang.String r8 = r12.projectId
            java.lang.String r11 = r12.packageName
            java.lang.String r8 = com.google.android.material.resources.TextAppearanceConfig.getRootUrl(r8, r11)
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r4] = r8
            r3[r5] = r7
            r3[r2] = r10
            r3[r1] = r9
            java.lang.String r1 = "%s/metrics/trace/DURATION_TRACE/%s?utm_source=%s&utm_medium=%s"
            java.lang.String r1 = java.lang.String.format(r1, r3)
        L_0x048c:
            r0[r5] = r1
            java.lang.String r1 = "Logging %s. In a minute, visit the Firebase console to view your data: %s"
            r14.info(r1, r0)
            goto L_0x04a3
        L_0x0494:
            com.google.firebase.perf.logging.AndroidLogger r14 = logger
            java.lang.Object[] r0 = new java.lang.Object[r5]
            java.lang.String r1 = getLogcatMsg(r13)
            r0[r4] = r1
            java.lang.String r1 = "Logging %s"
            r14.info(r1, r0)
        L_0x04a3:
            com.google.firebase.perf.transport.FlgTransport r14 = r12.flgTransport
            com.google.android.datatransport.Transport<com.google.firebase.perf.v1.PerfMetric> r0 = r14.flgTransport
            if (r0 != 0) goto L_0x04ce
            com.google.firebase.inject.Provider<com.google.android.datatransport.TransportFactory> r0 = r14.flgTransportFactoryProvider
            java.lang.Object r0 = r0.get()
            com.google.android.datatransport.TransportFactory r0 = (com.google.android.datatransport.TransportFactory) r0
            if (r0 == 0) goto L_0x04c7
            java.lang.String r1 = r14.logSourceName
            java.lang.Class<com.google.firebase.perf.v1.PerfMetric> r2 = com.google.firebase.perf.v1.PerfMetric.class
            com.google.android.datatransport.Encoding r3 = new com.google.android.datatransport.Encoding
            java.lang.String r7 = "proto"
            r3.<init>(r7)
            com.google.firebase.perf.transport.-$$Lambda$Itu3_v5Z-Xtk9hzoqKGtXZ9cnAw r7 = com.google.firebase.perf.transport.$$Lambda$Itu3_v5ZXtk9hzoqKGtXZ9cnAw.INSTANCE
            com.google.android.datatransport.Transport r0 = r0.getTransport(r1, r2, r3, r7)
            r14.flgTransport = r0
            goto L_0x04ce
        L_0x04c7:
            com.google.firebase.perf.logging.AndroidLogger r0 = com.google.firebase.perf.transport.FlgTransport.logger
            java.lang.String r1 = "Flg TransportFactory is not available at the moment"
            r0.warn(r1)
        L_0x04ce:
            com.google.android.datatransport.Transport<com.google.firebase.perf.v1.PerfMetric> r0 = r14.flgTransport
            if (r0 == 0) goto L_0x04d3
            r4 = 1
        L_0x04d3:
            if (r4 != 0) goto L_0x04dd
            com.google.firebase.perf.logging.AndroidLogger r13 = com.google.firebase.perf.transport.FlgTransport.logger
            java.lang.String r14 = "Unable to dispatch event because Flg Transport is not available"
            r13.warn(r14)
            goto L_0x04ed
        L_0x04dd:
            com.google.android.datatransport.Transport<com.google.firebase.perf.v1.PerfMetric> r14 = r14.flgTransport
            com.google.android.datatransport.AutoValue_Event r0 = new com.google.android.datatransport.AutoValue_Event
            com.google.android.datatransport.Priority r1 = com.google.android.datatransport.Priority.DEFAULT
            r0.<init>(r6, r13, r1)
            com.google.android.datatransport.runtime.TransportImpl r14 = (com.google.android.datatransport.runtime.TransportImpl) r14
            com.google.android.datatransport.runtime.-$$Lambda$TransportImpl$GkHqAwUYheh1JbNmhy95RHZujbw r13 = com.google.android.datatransport.runtime.$$Lambda$TransportImpl$GkHqAwUYheh1JbNmhy95RHZujbw.INSTANCE
            r14.schedule(r0, r13)
        L_0x04ed:
            com.google.firebase.perf.session.SessionManager r13 = com.google.firebase.perf.session.SessionManager.getInstance()
            r13.updatePerfSessionIfExpired()
        L_0x04f4:
            return
        L_0x04f5:
            throw r6
        L_0x04f6:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.transport.TransportManager.syncLog(com.google.firebase.perf.v1.PerfMetric$Builder, com.google.firebase.perf.v1.ApplicationProcessState):void");
    }
}
