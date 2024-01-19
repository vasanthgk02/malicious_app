package com.google.firebase.perf.application;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import androidx.core.app.FrameMetricsAggregator;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.metrics.Trace;
import com.google.firebase.perf.session.SessionManager;
import com.google.firebase.perf.session.gauges.GaugeManager;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Clock;
import com.google.firebase.perf.util.Constants$CounterNames;
import com.google.firebase.perf.util.Constants$TraceNames;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.PerfSession;
import com.google.firebase.perf.v1.TraceMetric;
import com.google.firebase.perf.v1.TraceMetric.Builder;
import com.google.protobuf.MapFieldLite;
import com.mpl.androidapp.utils.ScreenTrace;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class AppStateMonitor implements ActivityLifecycleCallbacks {
    public static volatile AppStateMonitor instance;
    public static final AndroidLogger logger = AndroidLogger.getInstance();
    public final WeakHashMap<Activity, Boolean> activityToResumedMap = new WeakHashMap<>();
    public final WeakHashMap<Activity, Trace> activityToScreenTraceMap = new WeakHashMap<>();
    public Set<AppColdStartCallback> appColdStartSubscribers = new HashSet();
    public final Set<WeakReference<AppStateCallback>> appStateSubscribers = new HashSet();
    public final Clock clock;
    public final ConfigResolver configResolver;
    public ApplicationProcessState currentAppState;
    public FrameMetricsAggregator frameMetricsAggregator;
    public boolean hasFrameMetricsAggregator;
    public boolean isColdStart;
    public boolean isRegisteredForLifecycleCallbacks;
    public final Map<String, Long> metricToCountMap = new HashMap();
    public Timer resumeTime;
    public Timer stopTime;
    public final TransportManager transportManager;
    public final AtomicInteger tsnsCount;

    public interface AppColdStartCallback {
        void onAppColdStart();
    }

    public interface AppStateCallback {
        void onUpdateAppState(ApplicationProcessState applicationProcessState);
    }

    public AppStateMonitor(TransportManager transportManager2, Clock clock2) {
        boolean z = false;
        this.tsnsCount = new AtomicInteger(0);
        this.currentAppState = ApplicationProcessState.BACKGROUND;
        this.isRegisteredForLifecycleCallbacks = false;
        this.isColdStart = true;
        this.hasFrameMetricsAggregator = false;
        this.transportManager = transportManager2;
        this.clock = clock2;
        this.configResolver = ConfigResolver.getInstance();
        try {
            Class.forName(ScreenTrace.FRAME_METRICS_AGGREGATOR_CLASSNAME);
            z = true;
        } catch (ClassNotFoundException unused) {
        }
        this.hasFrameMetricsAggregator = z;
        if (z) {
            this.frameMetricsAggregator = new FrameMetricsAggregator();
        }
    }

    public static AppStateMonitor getInstance() {
        if (instance == null) {
            synchronized (AppStateMonitor.class) {
                try {
                    if (instance == null) {
                        instance = new AppStateMonitor(TransportManager.instance, new Clock());
                    }
                }
            }
        }
        return instance;
    }

    public static String getScreenTraceName(Activity activity) {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("_st_");
        outline73.append(activity.getClass().getSimpleName());
        return outline73.toString();
    }

    public void incrementCount(String str, long j) {
        synchronized (this.metricToCountMap) {
            Long l = this.metricToCountMap.get(str);
            if (l == null) {
                this.metricToCountMap.put(str, Long.valueOf(j));
            } else {
                this.metricToCountMap.put(str, Long.valueOf(l.longValue() + j));
            }
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public synchronized void onActivityResumed(Activity activity) {
        if (!this.activityToResumedMap.isEmpty()) {
            this.activityToResumedMap.put(activity, Boolean.TRUE);
        } else if (this.clock != null) {
            this.resumeTime = new Timer();
            this.activityToResumedMap.put(activity, Boolean.TRUE);
            if (this.isColdStart) {
                updateAppState(ApplicationProcessState.FOREGROUND);
                synchronized (this.appStateSubscribers) {
                    for (AppColdStartCallback next : this.appColdStartSubscribers) {
                        if (next != null) {
                            next.onAppColdStart();
                        }
                    }
                }
                this.isColdStart = false;
            } else {
                sendSessionLog(Constants$TraceNames.BACKGROUND_TRACE_NAME.toString(), this.stopTime, this.resumeTime);
                updateAppState(ApplicationProcessState.FOREGROUND);
            }
        } else {
            throw null;
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public synchronized void onActivityStarted(Activity activity) {
        if (this.hasFrameMetricsAggregator && this.configResolver.isPerformanceMonitoringEnabled()) {
            this.frameMetricsAggregator.add(activity);
            Trace trace = new Trace(getScreenTraceName(activity), this.transportManager, this.clock, this, GaugeManager.getInstance());
            trace.start();
            this.activityToScreenTraceMap.put(activity, trace);
        }
    }

    public synchronized void onActivityStopped(Activity activity) {
        if (this.hasFrameMetricsAggregator) {
            sendScreenTrace(activity);
        }
        if (this.activityToResumedMap.containsKey(activity)) {
            this.activityToResumedMap.remove(activity);
            if (this.activityToResumedMap.isEmpty()) {
                if (this.clock != null) {
                    this.stopTime = new Timer();
                    sendSessionLog(Constants$TraceNames.FOREGROUND_TRACE_NAME.toString(), this.resumeTime, this.stopTime);
                    updateAppState(ApplicationProcessState.BACKGROUND);
                } else {
                    throw null;
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0077  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void sendScreenTrace(android.app.Activity r10) {
        /*
            r9 = this;
            java.util.WeakHashMap<android.app.Activity, com.google.firebase.perf.metrics.Trace> r0 = r9.activityToScreenTraceMap
            boolean r0 = r0.containsKey(r10)
            if (r0 != 0) goto L_0x0009
            return
        L_0x0009:
            java.util.WeakHashMap<android.app.Activity, com.google.firebase.perf.metrics.Trace> r0 = r9.activityToScreenTraceMap
            java.lang.Object r0 = r0.get(r10)
            com.google.firebase.perf.metrics.Trace r0 = (com.google.firebase.perf.metrics.Trace) r0
            if (r0 != 0) goto L_0x0014
            return
        L_0x0014:
            java.util.WeakHashMap<android.app.Activity, com.google.firebase.perf.metrics.Trace> r1 = r9.activityToScreenTraceMap
            r1.remove(r10)
            androidx.core.app.FrameMetricsAggregator r1 = r9.frameMetricsAggregator
            android.util.SparseIntArray[] r1 = r1.reset()
            r2 = 0
            if (r1 == 0) goto L_0x0047
            r1 = r1[r2]
            if (r1 == 0) goto L_0x0047
            r3 = 0
            r4 = 0
            r5 = 0
        L_0x0029:
            int r6 = r1.size()
            if (r2 >= r6) goto L_0x0045
            int r6 = r1.keyAt(r2)
            int r7 = r1.valueAt(r2)
            int r3 = r3 + r7
            r8 = 700(0x2bc, float:9.81E-43)
            if (r6 <= r8) goto L_0x003d
            int r5 = r5 + r7
        L_0x003d:
            r8 = 16
            if (r6 <= r8) goto L_0x0042
            int r4 = r4 + r7
        L_0x0042:
            int r2 = r2 + 1
            goto L_0x0029
        L_0x0045:
            r2 = r3
            goto L_0x0049
        L_0x0047:
            r4 = 0
            r5 = 0
        L_0x0049:
            if (r2 <= 0) goto L_0x0055
            com.google.firebase.perf.util.Constants$CounterNames r1 = com.google.firebase.perf.util.Constants$CounterNames.FRAMES_TOTAL
            java.lang.String r1 = r1.toString()
            long r6 = (long) r2
            r0.putMetric(r1, r6)
        L_0x0055:
            if (r4 <= 0) goto L_0x0061
            com.google.firebase.perf.util.Constants$CounterNames r1 = com.google.firebase.perf.util.Constants$CounterNames.FRAMES_SLOW
            java.lang.String r1 = r1.toString()
            long r6 = (long) r4
            r0.putMetric(r1, r6)
        L_0x0061:
            if (r5 <= 0) goto L_0x006d
            com.google.firebase.perf.util.Constants$CounterNames r1 = com.google.firebase.perf.util.Constants$CounterNames.FRAMES_FROZEN
            java.lang.String r1 = r1.toString()
            long r6 = (long) r5
            r0.putMetric(r1, r6)
        L_0x006d:
            android.content.Context r1 = r10.getApplicationContext()
            boolean r1 = com.google.firebase.perf.util.Utils.isDebugLoggingEnabled(r1)
            if (r1 == 0) goto L_0x00a5
            com.google.firebase.perf.logging.AndroidLogger r1 = logger
            java.lang.String r3 = "sendScreenTrace name:"
            java.lang.StringBuilder r3 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r3)
            java.lang.String r10 = getScreenTraceName(r10)
            r3.append(r10)
            java.lang.String r10 = " _fr_tot:"
            r3.append(r10)
            r3.append(r2)
            java.lang.String r10 = " _fr_slo:"
            r3.append(r10)
            r3.append(r4)
            java.lang.String r10 = " _fr_fzn:"
            r3.append(r10)
            r3.append(r5)
            java.lang.String r10 = r3.toString()
            r1.debug(r10)
        L_0x00a5:
            r0.stop()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.application.AppStateMonitor.sendScreenTrace(android.app.Activity):void");
    }

    public final void sendSessionLog(String str, Timer timer, Timer timer2) {
        if (this.configResolver.isPerformanceMonitoringEnabled()) {
            Builder newBuilder = TraceMetric.newBuilder();
            newBuilder.copyOnWrite();
            TraceMetric.access$100((TraceMetric) newBuilder.instance, str);
            newBuilder.setClientStartTimeUs(timer.timeInMicros);
            newBuilder.setDurationUs(timer.getDurationMicros(timer2));
            PerfSession build = SessionManager.getInstance().perfSession().build();
            newBuilder.copyOnWrite();
            TraceMetric.access$1900((TraceMetric) newBuilder.instance, build);
            int andSet = this.tsnsCount.getAndSet(0);
            synchronized (this.metricToCountMap) {
                Map<String, Long> map = this.metricToCountMap;
                newBuilder.copyOnWrite();
                TraceMetric traceMetric = (TraceMetric) newBuilder.instance;
                MapFieldLite<String, Long> mapFieldLite = traceMetric.counters_;
                if (!mapFieldLite.isMutable) {
                    traceMetric.counters_ = mapFieldLite.mutableCopy();
                }
                traceMetric.counters_.putAll(map);
                if (andSet != 0) {
                    newBuilder.putCounters(Constants$CounterNames.TRACE_STARTED_NOT_STOPPED.toString(), (long) andSet);
                }
                this.metricToCountMap.clear();
            }
            TransportManager transportManager2 = this.transportManager;
            transportManager2.executorService.execute(new Runnable((TraceMetric) newBuilder.build(), ApplicationProcessState.FOREGROUND_BACKGROUND) {
                public final /* synthetic */ TraceMetric f$1;
                public final /* synthetic */ ApplicationProcessState f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    TransportManager.this.lambda$log$2$TransportManager(this.f$1, this.f$2);
                }
            });
        }
    }

    public final void updateAppState(ApplicationProcessState applicationProcessState) {
        this.currentAppState = applicationProcessState;
        synchronized (this.appStateSubscribers) {
            Iterator<WeakReference<AppStateCallback>> it = this.appStateSubscribers.iterator();
            while (it.hasNext()) {
                AppStateCallback appStateCallback = (AppStateCallback) it.next().get();
                if (appStateCallback != null) {
                    appStateCallback.onUpdateAppState(this.currentAppState);
                } else {
                    it.remove();
                }
            }
        }
    }
}
