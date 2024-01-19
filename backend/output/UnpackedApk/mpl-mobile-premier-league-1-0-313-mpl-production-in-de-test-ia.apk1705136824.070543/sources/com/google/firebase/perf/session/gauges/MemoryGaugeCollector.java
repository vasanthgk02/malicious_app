package com.google.firebase.perf.session.gauges;

import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.StorageUnit;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.util.Utils;
import com.google.firebase.perf.v1.AndroidMemoryReading;
import com.google.firebase.perf.v1.AndroidMemoryReading.Builder;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class MemoryGaugeCollector {
    public static final AndroidLogger logger = AndroidLogger.getInstance();
    public long memoryMetricCollectionRateMs = -1;
    public final ScheduledExecutorService memoryMetricCollectorExecutor;
    public ScheduledFuture memoryMetricCollectorJob = null;
    public final ConcurrentLinkedQueue<AndroidMemoryReading> memoryMetricReadings;
    public final Runtime runtime;

    public MemoryGaugeCollector() {
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        Runtime runtime2 = Runtime.getRuntime();
        this.memoryMetricCollectorExecutor = newSingleThreadScheduledExecutor;
        this.memoryMetricReadings = new ConcurrentLinkedQueue<>();
        this.runtime = runtime2;
    }

    public static boolean isInvalidCollectionFrequency(long j) {
        return j <= 0;
    }

    public /* synthetic */ void lambda$scheduleMemoryMetricCollectionOnce$1$MemoryGaugeCollector(Timer timer) {
        AndroidMemoryReading syncCollectMemoryMetric = syncCollectMemoryMetric(timer);
        if (syncCollectMemoryMetric != null) {
            this.memoryMetricReadings.add(syncCollectMemoryMetric);
        }
    }

    public /* synthetic */ void lambda$scheduleMemoryMetricCollectionWithRate$0$MemoryGaugeCollector(Timer timer) {
        AndroidMemoryReading syncCollectMemoryMetric = syncCollectMemoryMetric(timer);
        if (syncCollectMemoryMetric != null) {
            this.memoryMetricReadings.add(syncCollectMemoryMetric);
        }
    }

    public final synchronized void scheduleMemoryMetricCollectionWithRate(long j, Timer timer) {
        this.memoryMetricCollectionRateMs = j;
        try {
            this.memoryMetricCollectorJob = this.memoryMetricCollectorExecutor.scheduleAtFixedRate(new Runnable(timer) {
                public final /* synthetic */ Timer f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    MemoryGaugeCollector.this.lambda$scheduleMemoryMetricCollectionWithRate$0$MemoryGaugeCollector(this.f$1);
                }
            }, 0, j, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e2) {
            AndroidLogger androidLogger = logger;
            androidLogger.warn("Unable to start collecting Memory Metrics: " + e2.getMessage());
        }
        return;
    }

    public final AndroidMemoryReading syncCollectMemoryMetric(Timer timer) {
        if (timer == null) {
            return null;
        }
        long durationMicros = timer.getDurationMicros() + timer.timeInMicros;
        Builder builder = (Builder) AndroidMemoryReading.DEFAULT_INSTANCE.createBuilder();
        builder.copyOnWrite();
        AndroidMemoryReading androidMemoryReading = (AndroidMemoryReading) builder.instance;
        androidMemoryReading.bitField0_ |= 1;
        androidMemoryReading.clientTimeUs_ = durationMicros;
        int saturatedIntCast = Utils.saturatedIntCast(StorageUnit.BYTES.toKilobytes(this.runtime.totalMemory() - this.runtime.freeMemory()));
        builder.copyOnWrite();
        AndroidMemoryReading androidMemoryReading2 = (AndroidMemoryReading) builder.instance;
        androidMemoryReading2.bitField0_ |= 2;
        androidMemoryReading2.usedAppJavaHeapMemoryKb_ = saturatedIntCast;
        return (AndroidMemoryReading) builder.build();
    }
}
