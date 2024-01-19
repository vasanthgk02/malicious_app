package com.google.firebase.perf.session.gauges;

import android.os.Process;
import android.system.Os;
import android.system.OsConstants;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.v1.CpuMetricReading;
import com.google.firebase.perf.v1.CpuMetricReading.Builder;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.apache.fontbox.cmap.CMap;

public class CpuGaugeCollector {
    public static final long MICROSECONDS_PER_SECOND = TimeUnit.SECONDS.toMicros(1);
    public static final AndroidLogger logger = AndroidLogger.getInstance();
    public final long clockTicksPerSecond;
    public long cpuMetricCollectionRateMs = -1;
    public final ScheduledExecutorService cpuMetricCollectorExecutor = Executors.newSingleThreadScheduledExecutor();
    public ScheduledFuture cpuMetricCollectorJob = null;
    public final ConcurrentLinkedQueue<CpuMetricReading> cpuMetricReadings = new ConcurrentLinkedQueue<>();
    public final String procFileName;

    public CpuGaugeCollector() {
        int myPid = Process.myPid();
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("/proc/");
        outline73.append(Integer.toString(myPid));
        outline73.append("/stat");
        this.procFileName = outline73.toString();
        this.clockTicksPerSecond = Os.sysconf(OsConstants._SC_CLK_TCK);
    }

    public static boolean isInvalidCollectionFrequency(long j) {
        return j <= 0;
    }

    public /* synthetic */ void lambda$scheduleCpuMetricCollectionOnce$1$CpuGaugeCollector(Timer timer) {
        CpuMetricReading syncCollectCpuMetric = syncCollectCpuMetric(timer);
        if (syncCollectCpuMetric != null) {
            this.cpuMetricReadings.add(syncCollectCpuMetric);
        }
    }

    public /* synthetic */ void lambda$scheduleCpuMetricCollectionWithRate$0$CpuGaugeCollector(Timer timer) {
        CpuMetricReading syncCollectCpuMetric = syncCollectCpuMetric(timer);
        if (syncCollectCpuMetric != null) {
            this.cpuMetricReadings.add(syncCollectCpuMetric);
        }
    }

    public final synchronized void scheduleCpuMetricCollectionWithRate(long j, Timer timer) {
        this.cpuMetricCollectionRateMs = j;
        try {
            this.cpuMetricCollectorJob = this.cpuMetricCollectorExecutor.scheduleAtFixedRate(new Runnable(timer) {
                public final /* synthetic */ Timer f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    CpuGaugeCollector.this.lambda$scheduleCpuMetricCollectionWithRate$0$CpuGaugeCollector(this.f$1);
                }
            }, 0, j, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e2) {
            AndroidLogger androidLogger = logger;
            androidLogger.warn("Unable to start collecting Cpu Metrics: " + e2.getMessage());
        }
        return;
    }

    public final CpuMetricReading syncCollectCpuMetric(Timer timer) {
        BufferedReader bufferedReader;
        if (timer == null) {
            return null;
        }
        try {
            bufferedReader = new BufferedReader(new FileReader(this.procFileName));
            long durationMicros = timer.getDurationMicros() + timer.timeInMicros;
            String[] split = bufferedReader.readLine().split(CMap.SPACE);
            long parseLong = Long.parseLong(split[13]);
            long parseLong2 = Long.parseLong(split[15]);
            long parseLong3 = Long.parseLong(split[14]);
            long parseLong4 = Long.parseLong(split[16]);
            Builder builder = (Builder) CpuMetricReading.DEFAULT_INSTANCE.createBuilder();
            builder.copyOnWrite();
            CpuMetricReading cpuMetricReading = (CpuMetricReading) builder.instance;
            cpuMetricReading.bitField0_ |= 1;
            cpuMetricReading.clientTimeUs_ = durationMicros;
            long round = Math.round((((double) (parseLong3 + parseLong4)) / ((double) this.clockTicksPerSecond)) * ((double) MICROSECONDS_PER_SECOND));
            builder.copyOnWrite();
            CpuMetricReading cpuMetricReading2 = (CpuMetricReading) builder.instance;
            cpuMetricReading2.bitField0_ |= 4;
            cpuMetricReading2.systemTimeUs_ = round;
            long round2 = Math.round((((double) (parseLong + parseLong2)) / ((double) this.clockTicksPerSecond)) * ((double) MICROSECONDS_PER_SECOND));
            builder.copyOnWrite();
            CpuMetricReading cpuMetricReading3 = (CpuMetricReading) builder.instance;
            cpuMetricReading3.bitField0_ |= 2;
            cpuMetricReading3.userTimeUs_ = round2;
            CpuMetricReading cpuMetricReading4 = (CpuMetricReading) builder.build();
            bufferedReader.close();
            return cpuMetricReading4;
        } catch (IOException e2) {
            AndroidLogger androidLogger = logger;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Unable to read 'proc/[pid]/stat' file: ");
            outline73.append(e2.getMessage());
            androidLogger.warn(outline73.toString());
            return null;
        } catch (ArrayIndexOutOfBoundsException | NullPointerException | NumberFormatException e3) {
            AndroidLogger androidLogger2 = logger;
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("Unexpected '/proc/[pid]/stat' file format encountered: ");
            outline732.append(e3.getMessage());
            androidLogger2.warn(outline732.toString());
            return null;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }
}
