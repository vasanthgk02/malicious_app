package com.google.firebase.perf.session.gauges;

import android.content.Context;
import androidx.annotation.Keep;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.components.Lazy;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.config.ConfigurationConstants$SessionsCpuCaptureFrequencyBackgroundMs;
import com.google.firebase.perf.config.ConfigurationConstants$SessionsCpuCaptureFrequencyForegroundMs;
import com.google.firebase.perf.config.ConfigurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs;
import com.google.firebase.perf.config.ConfigurationConstants$SessionsMemoryCaptureFrequencyForegroundMs;
import com.google.firebase.perf.config.DeviceCacheManager;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.session.PerfSession;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Optional;
import com.google.firebase.perf.util.StorageUnit;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.util.Utils;
import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.GaugeMetadata;
import com.google.firebase.perf.v1.GaugeMetadata.Builder;
import com.google.firebase.perf.v1.GaugeMetric;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@Keep
public class GaugeManager {
    public static final long APPROX_NUMBER_OF_DATA_POINTS_PER_GAUGE_METRIC = 20;
    public static final long INVALID_GAUGE_COLLECTION_FREQUENCY = -1;
    public static final long TIME_TO_WAIT_BEFORE_FLUSHING_GAUGES_QUEUE_MS = 20;
    public static final GaugeManager instance = new GaugeManager();
    public static final AndroidLogger logger = AndroidLogger.getInstance();
    public ApplicationProcessState applicationProcessState;
    public final ConfigResolver configResolver;
    public final Lazy<CpuGaugeCollector> cpuGaugeCollector;
    public ScheduledFuture gaugeManagerDataCollectionJob;
    public final Lazy<ScheduledExecutorService> gaugeManagerExecutor;
    public GaugeMetadataManager gaugeMetadataManager;
    public final Lazy<MemoryGaugeCollector> memoryGaugeCollector;
    public String sessionId;
    public final TransportManager transportManager;

    public GaugeManager() {
        this(new Lazy($$Lambda$GaugeManager$FcUhnNfX7VCtfAsjyLkBJIyY6Y.INSTANCE), TransportManager.instance, ConfigResolver.getInstance(), null, new Lazy($$Lambda$GaugeManager$a17SdzwfnWnZX7OC8qfvLHEIPU.INSTANCE), new Lazy($$Lambda$GaugeManager$ChOhLTAowqBZM8YPnvH91RDObY0.INSTANCE));
    }

    public static void collectGaugeMetricOnce(CpuGaugeCollector cpuGaugeCollector2, MemoryGaugeCollector memoryGaugeCollector2, Timer timer) {
        synchronized (cpuGaugeCollector2) {
            try {
                cpuGaugeCollector2.cpuMetricCollectorExecutor.schedule(new Runnable(timer) {
                    public final /* synthetic */ Timer f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        CpuGaugeCollector.this.lambda$scheduleCpuMetricCollectionOnce$1$CpuGaugeCollector(this.f$1);
                    }
                }, 0, TimeUnit.MILLISECONDS);
            } catch (RejectedExecutionException e2) {
                AndroidLogger androidLogger = CpuGaugeCollector.logger;
                androidLogger.warn("Unable to collect Cpu Metric: " + e2.getMessage());
            }
        }
        synchronized (memoryGaugeCollector2) {
            try {
                memoryGaugeCollector2.memoryMetricCollectorExecutor.schedule(new Runnable(timer) {
                    public final /* synthetic */ Timer f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        MemoryGaugeCollector.this.lambda$scheduleMemoryMetricCollectionOnce$1$MemoryGaugeCollector(this.f$1);
                    }
                }, 0, TimeUnit.MILLISECONDS);
            } catch (RejectedExecutionException e3) {
                AndroidLogger androidLogger2 = MemoryGaugeCollector.logger;
                androidLogger2.warn("Unable to collect Memory Metric: " + e3.getMessage());
            }
        }
        return;
    }

    private long getCpuGaugeCollectionFrequencyMs(ApplicationProcessState applicationProcessState2) {
        long j;
        ConfigurationConstants$SessionsCpuCaptureFrequencyForegroundMs configurationConstants$SessionsCpuCaptureFrequencyForegroundMs;
        ConfigurationConstants$SessionsCpuCaptureFrequencyBackgroundMs configurationConstants$SessionsCpuCaptureFrequencyBackgroundMs;
        int ordinal = applicationProcessState2.ordinal();
        if (ordinal == 1) {
            ConfigResolver configResolver2 = this.configResolver;
            if (configResolver2 != null) {
                synchronized (ConfigurationConstants$SessionsCpuCaptureFrequencyForegroundMs.class) {
                    if (ConfigurationConstants$SessionsCpuCaptureFrequencyForegroundMs.instance == null) {
                        ConfigurationConstants$SessionsCpuCaptureFrequencyForegroundMs.instance = new ConfigurationConstants$SessionsCpuCaptureFrequencyForegroundMs();
                    }
                    configurationConstants$SessionsCpuCaptureFrequencyForegroundMs = ConfigurationConstants$SessionsCpuCaptureFrequencyForegroundMs.instance;
                }
                Optional<Long> metadataLong = configResolver2.getMetadataLong(configurationConstants$SessionsCpuCaptureFrequencyForegroundMs);
                if (!metadataLong.isAvailable() || !configResolver2.isGaugeCaptureFrequencyMsValid(((Long) metadataLong.get()).longValue())) {
                    Optional<Long> remoteConfigLong = configResolver2.getRemoteConfigLong(configurationConstants$SessionsCpuCaptureFrequencyForegroundMs);
                    if (!remoteConfigLong.isAvailable() || !configResolver2.isGaugeCaptureFrequencyMsValid(((Long) remoteConfigLong.get()).longValue())) {
                        Optional<Long> deviceCacheLong = configResolver2.getDeviceCacheLong(configurationConstants$SessionsCpuCaptureFrequencyForegroundMs);
                        if (deviceCacheLong.isAvailable() && configResolver2.isGaugeCaptureFrequencyMsValid(((Long) deviceCacheLong.get()).longValue())) {
                            j = ((Long) deviceCacheLong.get()).longValue();
                        } else if (configurationConstants$SessionsCpuCaptureFrequencyForegroundMs != null) {
                            j = Long.valueOf(100).longValue();
                        } else {
                            throw null;
                        }
                    } else {
                        DeviceCacheManager deviceCacheManager = configResolver2.deviceCacheManager;
                        if (configurationConstants$SessionsCpuCaptureFrequencyForegroundMs != null) {
                            j = ((Long) GeneratedOutlineSupport.outline28((Long) remoteConfigLong.get(), deviceCacheManager, "com.google.firebase.perf.SessionsCpuCaptureFrequencyForegroundMs", remoteConfigLong)).longValue();
                        } else {
                            throw null;
                        }
                    }
                } else {
                    j = ((Long) metadataLong.get()).longValue();
                }
            } else {
                throw null;
            }
        } else if (ordinal != 2) {
            j = -1;
        } else {
            ConfigResolver configResolver3 = this.configResolver;
            if (configResolver3 != null) {
                synchronized (ConfigurationConstants$SessionsCpuCaptureFrequencyBackgroundMs.class) {
                    if (ConfigurationConstants$SessionsCpuCaptureFrequencyBackgroundMs.instance == null) {
                        ConfigurationConstants$SessionsCpuCaptureFrequencyBackgroundMs.instance = new ConfigurationConstants$SessionsCpuCaptureFrequencyBackgroundMs();
                    }
                    configurationConstants$SessionsCpuCaptureFrequencyBackgroundMs = ConfigurationConstants$SessionsCpuCaptureFrequencyBackgroundMs.instance;
                }
                Optional<Long> metadataLong2 = configResolver3.getMetadataLong(configurationConstants$SessionsCpuCaptureFrequencyBackgroundMs);
                if (!metadataLong2.isAvailable() || !configResolver3.isGaugeCaptureFrequencyMsValid(((Long) metadataLong2.get()).longValue())) {
                    Optional<Long> remoteConfigLong2 = configResolver3.getRemoteConfigLong(configurationConstants$SessionsCpuCaptureFrequencyBackgroundMs);
                    if (!remoteConfigLong2.isAvailable() || !configResolver3.isGaugeCaptureFrequencyMsValid(((Long) remoteConfigLong2.get()).longValue())) {
                        Optional<Long> deviceCacheLong2 = configResolver3.getDeviceCacheLong(configurationConstants$SessionsCpuCaptureFrequencyBackgroundMs);
                        if (deviceCacheLong2.isAvailable() && configResolver3.isGaugeCaptureFrequencyMsValid(((Long) deviceCacheLong2.get()).longValue())) {
                            j = ((Long) deviceCacheLong2.get()).longValue();
                        } else if (configurationConstants$SessionsCpuCaptureFrequencyBackgroundMs != null) {
                            j = Long.valueOf(0).longValue();
                        } else {
                            throw null;
                        }
                    } else {
                        DeviceCacheManager deviceCacheManager2 = configResolver3.deviceCacheManager;
                        if (configurationConstants$SessionsCpuCaptureFrequencyBackgroundMs != null) {
                            j = ((Long) GeneratedOutlineSupport.outline28((Long) remoteConfigLong2.get(), deviceCacheManager2, "com.google.firebase.perf.SessionsCpuCaptureFrequencyBackgroundMs", remoteConfigLong2)).longValue();
                        } else {
                            throw null;
                        }
                    }
                } else {
                    j = ((Long) metadataLong2.get()).longValue();
                }
            } else {
                throw null;
            }
        }
        if (CpuGaugeCollector.isInvalidCollectionFrequency(j)) {
            return -1;
        }
        return j;
    }

    private GaugeMetadata getGaugeMetadata() {
        Builder builder = (Builder) GaugeMetadata.DEFAULT_INSTANCE.createBuilder();
        String str = this.gaugeMetadataManager.currentProcessName;
        builder.copyOnWrite();
        GaugeMetadata.access$100((GaugeMetadata) builder.instance, str);
        GaugeMetadataManager gaugeMetadataManager2 = this.gaugeMetadataManager;
        if (gaugeMetadataManager2 != null) {
            int saturatedIntCast = Utils.saturatedIntCast(StorageUnit.BYTES.toKilobytes(gaugeMetadataManager2.memoryInfo.totalMem));
            builder.copyOnWrite();
            GaugeMetadata gaugeMetadata = (GaugeMetadata) builder.instance;
            gaugeMetadata.bitField0_ |= 8;
            gaugeMetadata.deviceRamSizeKb_ = saturatedIntCast;
            GaugeMetadataManager gaugeMetadataManager3 = this.gaugeMetadataManager;
            if (gaugeMetadataManager3 != null) {
                int saturatedIntCast2 = Utils.saturatedIntCast(StorageUnit.BYTES.toKilobytes(gaugeMetadataManager3.runtime.maxMemory()));
                builder.copyOnWrite();
                GaugeMetadata gaugeMetadata2 = (GaugeMetadata) builder.instance;
                gaugeMetadata2.bitField0_ |= 16;
                gaugeMetadata2.maxAppJavaHeapMemoryKb_ = saturatedIntCast2;
                GaugeMetadataManager gaugeMetadataManager4 = this.gaugeMetadataManager;
                if (gaugeMetadataManager4 != null) {
                    int saturatedIntCast3 = Utils.saturatedIntCast(StorageUnit.MEGABYTES.toKilobytes((long) gaugeMetadataManager4.activityManager.getMemoryClass()));
                    builder.copyOnWrite();
                    GaugeMetadata gaugeMetadata3 = (GaugeMetadata) builder.instance;
                    gaugeMetadata3.bitField0_ |= 32;
                    gaugeMetadata3.maxEncouragedAppJavaHeapMemoryKb_ = saturatedIntCast3;
                    return (GaugeMetadata) builder.build();
                }
                throw null;
            }
            throw null;
        }
        throw null;
    }

    public static synchronized GaugeManager getInstance() {
        GaugeManager gaugeManager;
        synchronized (GaugeManager.class) {
            try {
                gaugeManager = instance;
            }
        }
        return gaugeManager;
    }

    private long getMemoryGaugeCollectionFrequencyMs(ApplicationProcessState applicationProcessState2) {
        long j;
        ConfigurationConstants$SessionsMemoryCaptureFrequencyForegroundMs configurationConstants$SessionsMemoryCaptureFrequencyForegroundMs;
        ConfigurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs configurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs;
        int ordinal = applicationProcessState2.ordinal();
        if (ordinal == 1) {
            ConfigResolver configResolver2 = this.configResolver;
            if (configResolver2 != null) {
                synchronized (ConfigurationConstants$SessionsMemoryCaptureFrequencyForegroundMs.class) {
                    if (ConfigurationConstants$SessionsMemoryCaptureFrequencyForegroundMs.instance == null) {
                        ConfigurationConstants$SessionsMemoryCaptureFrequencyForegroundMs.instance = new ConfigurationConstants$SessionsMemoryCaptureFrequencyForegroundMs();
                    }
                    configurationConstants$SessionsMemoryCaptureFrequencyForegroundMs = ConfigurationConstants$SessionsMemoryCaptureFrequencyForegroundMs.instance;
                }
                Optional<Long> metadataLong = configResolver2.getMetadataLong(configurationConstants$SessionsMemoryCaptureFrequencyForegroundMs);
                if (!metadataLong.isAvailable() || !configResolver2.isGaugeCaptureFrequencyMsValid(((Long) metadataLong.get()).longValue())) {
                    Optional<Long> remoteConfigLong = configResolver2.getRemoteConfigLong(configurationConstants$SessionsMemoryCaptureFrequencyForegroundMs);
                    if (!remoteConfigLong.isAvailable() || !configResolver2.isGaugeCaptureFrequencyMsValid(((Long) remoteConfigLong.get()).longValue())) {
                        Optional<Long> deviceCacheLong = configResolver2.getDeviceCacheLong(configurationConstants$SessionsMemoryCaptureFrequencyForegroundMs);
                        if (deviceCacheLong.isAvailable() && configResolver2.isGaugeCaptureFrequencyMsValid(((Long) deviceCacheLong.get()).longValue())) {
                            j = ((Long) deviceCacheLong.get()).longValue();
                        } else if (configurationConstants$SessionsMemoryCaptureFrequencyForegroundMs != null) {
                            j = Long.valueOf(100).longValue();
                        } else {
                            throw null;
                        }
                    } else {
                        DeviceCacheManager deviceCacheManager = configResolver2.deviceCacheManager;
                        if (configurationConstants$SessionsMemoryCaptureFrequencyForegroundMs != null) {
                            j = ((Long) GeneratedOutlineSupport.outline28((Long) remoteConfigLong.get(), deviceCacheManager, "com.google.firebase.perf.SessionsMemoryCaptureFrequencyForegroundMs", remoteConfigLong)).longValue();
                        } else {
                            throw null;
                        }
                    }
                } else {
                    j = ((Long) metadataLong.get()).longValue();
                }
            } else {
                throw null;
            }
        } else if (ordinal != 2) {
            j = -1;
        } else {
            ConfigResolver configResolver3 = this.configResolver;
            if (configResolver3 != null) {
                synchronized (ConfigurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs.class) {
                    if (ConfigurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs.instance == null) {
                        ConfigurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs.instance = new ConfigurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs();
                    }
                    configurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs = ConfigurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs.instance;
                }
                Optional<Long> metadataLong2 = configResolver3.getMetadataLong(configurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs);
                if (!metadataLong2.isAvailable() || !configResolver3.isGaugeCaptureFrequencyMsValid(((Long) metadataLong2.get()).longValue())) {
                    Optional<Long> remoteConfigLong2 = configResolver3.getRemoteConfigLong(configurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs);
                    if (!remoteConfigLong2.isAvailable() || !configResolver3.isGaugeCaptureFrequencyMsValid(((Long) remoteConfigLong2.get()).longValue())) {
                        Optional<Long> deviceCacheLong2 = configResolver3.getDeviceCacheLong(configurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs);
                        if (deviceCacheLong2.isAvailable() && configResolver3.isGaugeCaptureFrequencyMsValid(((Long) deviceCacheLong2.get()).longValue())) {
                            j = ((Long) deviceCacheLong2.get()).longValue();
                        } else if (configurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs != null) {
                            j = Long.valueOf(0).longValue();
                        } else {
                            throw null;
                        }
                    } else {
                        DeviceCacheManager deviceCacheManager2 = configResolver3.deviceCacheManager;
                        if (configurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs != null) {
                            j = ((Long) GeneratedOutlineSupport.outline28((Long) remoteConfigLong2.get(), deviceCacheManager2, "com.google.firebase.perf.SessionsMemoryCaptureFrequencyBackgroundMs", remoteConfigLong2)).longValue();
                        } else {
                            throw null;
                        }
                    }
                } else {
                    j = ((Long) metadataLong2.get()).longValue();
                }
            } else {
                throw null;
            }
        }
        if (MemoryGaugeCollector.isInvalidCollectionFrequency(j)) {
            return -1;
        }
        return j;
    }

    public static /* synthetic */ CpuGaugeCollector lambda$new$1() {
        return new CpuGaugeCollector();
    }

    public static /* synthetic */ MemoryGaugeCollector lambda$new$2() {
        return new MemoryGaugeCollector();
    }

    private boolean startCollectingCpuMetrics(long j, Timer timer) {
        if (j == -1) {
            logger.debug("Invalid Cpu Metrics collection frequency. Did not collect Cpu Metrics.");
            return false;
        }
        CpuGaugeCollector cpuGaugeCollector2 = (CpuGaugeCollector) this.cpuGaugeCollector.get();
        long j2 = cpuGaugeCollector2.clockTicksPerSecond;
        if (!(j2 == -1 || j2 == 0)) {
            if (!(j <= 0)) {
                ScheduledFuture scheduledFuture = cpuGaugeCollector2.cpuMetricCollectorJob;
                if (scheduledFuture == null) {
                    cpuGaugeCollector2.scheduleCpuMetricCollectionWithRate(j, timer);
                } else if (cpuGaugeCollector2.cpuMetricCollectionRateMs != j) {
                    scheduledFuture.cancel(false);
                    cpuGaugeCollector2.cpuMetricCollectorJob = null;
                    cpuGaugeCollector2.cpuMetricCollectionRateMs = -1;
                    cpuGaugeCollector2.scheduleCpuMetricCollectionWithRate(j, timer);
                }
            }
        }
        return true;
    }

    private boolean startCollectingMemoryMetrics(long j, Timer timer) {
        if (j == -1) {
            logger.debug("Invalid Memory Metrics collection frequency. Did not collect Memory Metrics.");
            return false;
        }
        MemoryGaugeCollector memoryGaugeCollector2 = (MemoryGaugeCollector) this.memoryGaugeCollector.get();
        if (memoryGaugeCollector2 != null) {
            if (!(j <= 0)) {
                ScheduledFuture scheduledFuture = memoryGaugeCollector2.memoryMetricCollectorJob;
                if (scheduledFuture == null) {
                    memoryGaugeCollector2.scheduleMemoryMetricCollectionWithRate(j, timer);
                } else if (memoryGaugeCollector2.memoryMetricCollectionRateMs != j) {
                    scheduledFuture.cancel(false);
                    memoryGaugeCollector2.memoryMetricCollectorJob = null;
                    memoryGaugeCollector2.memoryMetricCollectionRateMs = -1;
                    memoryGaugeCollector2.scheduleMemoryMetricCollectionWithRate(j, timer);
                }
            }
            return true;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    /* renamed from: syncFlush */
    public void lambda$stopCollectingGauges$4$GaugeManager(String str, ApplicationProcessState applicationProcessState2) {
        GaugeMetric.Builder builder = (GaugeMetric.Builder) GaugeMetric.DEFAULT_INSTANCE.createBuilder();
        while (!((CpuGaugeCollector) this.cpuGaugeCollector.get()).cpuMetricReadings.isEmpty()) {
            builder.copyOnWrite();
            GaugeMetric.access$800((GaugeMetric) builder.instance, ((CpuGaugeCollector) this.cpuGaugeCollector.get()).cpuMetricReadings.poll());
        }
        while (!((MemoryGaugeCollector) this.memoryGaugeCollector.get()).memoryMetricReadings.isEmpty()) {
            builder.copyOnWrite();
            GaugeMetric.access$1400((GaugeMetric) builder.instance, ((MemoryGaugeCollector) this.memoryGaugeCollector.get()).memoryMetricReadings.poll());
        }
        builder.copyOnWrite();
        GaugeMetric.access$100((GaugeMetric) builder.instance, str);
        TransportManager transportManager2 = this.transportManager;
        transportManager2.executorService.execute(new Runnable((GaugeMetric) builder.build(), applicationProcessState2) {
            public final /* synthetic */ GaugeMetric f$1;
            public final /* synthetic */ ApplicationProcessState f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                TransportManager.this.lambda$log$4$TransportManager(this.f$1, this.f$2);
            }
        });
    }

    public void initializeGaugeMetadataManager(Context context) {
        this.gaugeMetadataManager = new GaugeMetadataManager(context);
    }

    public boolean logGaugeMetadata(String str, ApplicationProcessState applicationProcessState2) {
        if (this.gaugeMetadataManager == null) {
            return false;
        }
        GaugeMetric.Builder builder = (GaugeMetric.Builder) GaugeMetric.DEFAULT_INSTANCE.createBuilder();
        builder.copyOnWrite();
        GaugeMetric.access$100((GaugeMetric) builder.instance, str);
        GaugeMetadata gaugeMetadata = getGaugeMetadata();
        builder.copyOnWrite();
        GaugeMetric.access$400((GaugeMetric) builder.instance, gaugeMetadata);
        TransportManager transportManager2 = this.transportManager;
        transportManager2.executorService.execute(new Runnable((GaugeMetric) builder.build(), applicationProcessState2) {
            public final /* synthetic */ GaugeMetric f$1;
            public final /* synthetic */ ApplicationProcessState f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                TransportManager.this.lambda$log$4$TransportManager(this.f$1, this.f$2);
            }
        });
        return true;
    }

    public void startCollectingGauges(PerfSession perfSession, ApplicationProcessState applicationProcessState2) {
        if (this.sessionId != null) {
            stopCollectingGauges();
        }
        long startCollectingGauges = startCollectingGauges(applicationProcessState2, perfSession.creationTime);
        if (startCollectingGauges == -1) {
            logger.warn("Invalid gauge collection frequency. Unable to start collecting Gauges.");
            return;
        }
        String str = perfSession.sessionId;
        this.sessionId = str;
        this.applicationProcessState = applicationProcessState2;
        try {
            long j = startCollectingGauges * 20;
            this.gaugeManagerDataCollectionJob = ((ScheduledExecutorService) this.gaugeManagerExecutor.get()).scheduleAtFixedRate(new Runnable(str, applicationProcessState2) {
                public final /* synthetic */ String f$1;
                public final /* synthetic */ ApplicationProcessState f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    GaugeManager.this.lambda$startCollectingGauges$3$GaugeManager(this.f$1, this.f$2);
                }
            }, j, j, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e2) {
            AndroidLogger androidLogger = logger;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Unable to start collecting Gauges: ");
            outline73.append(e2.getMessage());
            androidLogger.warn(outline73.toString());
        }
    }

    public void stopCollectingGauges() {
        String str = this.sessionId;
        if (str != null) {
            ApplicationProcessState applicationProcessState2 = this.applicationProcessState;
            CpuGaugeCollector cpuGaugeCollector2 = (CpuGaugeCollector) this.cpuGaugeCollector.get();
            ScheduledFuture scheduledFuture = cpuGaugeCollector2.cpuMetricCollectorJob;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
                cpuGaugeCollector2.cpuMetricCollectorJob = null;
                cpuGaugeCollector2.cpuMetricCollectionRateMs = -1;
            }
            MemoryGaugeCollector memoryGaugeCollector2 = (MemoryGaugeCollector) this.memoryGaugeCollector.get();
            ScheduledFuture scheduledFuture2 = memoryGaugeCollector2.memoryMetricCollectorJob;
            if (scheduledFuture2 != null) {
                scheduledFuture2.cancel(false);
                memoryGaugeCollector2.memoryMetricCollectorJob = null;
                memoryGaugeCollector2.memoryMetricCollectionRateMs = -1;
            }
            ScheduledFuture scheduledFuture3 = this.gaugeManagerDataCollectionJob;
            if (scheduledFuture3 != null) {
                scheduledFuture3.cancel(false);
            }
            ((ScheduledExecutorService) this.gaugeManagerExecutor.get()).schedule(new Runnable(str, applicationProcessState2) {
                public final /* synthetic */ String f$1;
                public final /* synthetic */ ApplicationProcessState f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    GaugeManager.this.lambda$stopCollectingGauges$4$GaugeManager(this.f$1, this.f$2);
                }
            }, 20, TimeUnit.MILLISECONDS);
            this.sessionId = null;
            this.applicationProcessState = ApplicationProcessState.APPLICATION_PROCESS_STATE_UNKNOWN;
        }
    }

    public GaugeManager(Lazy<ScheduledExecutorService> lazy, TransportManager transportManager2, ConfigResolver configResolver2, GaugeMetadataManager gaugeMetadataManager2, Lazy<CpuGaugeCollector> lazy2, Lazy<MemoryGaugeCollector> lazy3) {
        this.gaugeManagerDataCollectionJob = null;
        this.sessionId = null;
        this.applicationProcessState = ApplicationProcessState.APPLICATION_PROCESS_STATE_UNKNOWN;
        this.gaugeManagerExecutor = lazy;
        this.transportManager = transportManager2;
        this.configResolver = configResolver2;
        this.gaugeMetadataManager = gaugeMetadataManager2;
        this.cpuGaugeCollector = lazy2;
        this.memoryGaugeCollector = lazy3;
    }

    public void collectGaugeMetricOnce(Timer timer) {
        collectGaugeMetricOnce((CpuGaugeCollector) this.cpuGaugeCollector.get(), (MemoryGaugeCollector) this.memoryGaugeCollector.get(), timer);
    }

    private long startCollectingGauges(ApplicationProcessState applicationProcessState2, Timer timer) {
        long cpuGaugeCollectionFrequencyMs = getCpuGaugeCollectionFrequencyMs(applicationProcessState2);
        if (!startCollectingCpuMetrics(cpuGaugeCollectionFrequencyMs, timer)) {
            cpuGaugeCollectionFrequencyMs = -1;
        }
        long memoryGaugeCollectionFrequencyMs = getMemoryGaugeCollectionFrequencyMs(applicationProcessState2);
        if (!startCollectingMemoryMetrics(memoryGaugeCollectionFrequencyMs, timer)) {
            return cpuGaugeCollectionFrequencyMs;
        }
        if (cpuGaugeCollectionFrequencyMs == -1) {
            return memoryGaugeCollectionFrequencyMs;
        }
        return Math.min(cpuGaugeCollectionFrequencyMs, memoryGaugeCollectionFrequencyMs);
    }
}
