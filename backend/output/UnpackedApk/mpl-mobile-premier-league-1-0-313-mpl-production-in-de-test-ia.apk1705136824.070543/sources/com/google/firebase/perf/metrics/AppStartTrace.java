package com.google.firebase.perf.metrics;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.firebase.perf.session.PerfSession;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Clock;
import com.google.firebase.perf.util.Constants$TraceNames;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.TraceMetric;
import com.google.firebase.perf.v1.TraceMetric.Builder;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal.ProtobufList;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class AppStartTrace implements ActivityLifecycleCallbacks {
    public static final long MAX_LATENCY_BEFORE_UI_INIT = TimeUnit.MINUTES.toMicros(1);
    public static ExecutorService executorService;
    public static volatile AppStartTrace instance;
    public Context appContext;
    public Timer appStartTime = null;
    public final Clock clock;
    public boolean isRegisteredForLifecycleCallbacks = false;
    public boolean isStartedFromBackground = false;
    public boolean isTooLateToInitUI = false;
    public Timer onCreateTime = null;
    public Timer onResumeTime = null;
    public Timer onStartTime = null;
    public PerfSession startSession;
    public final TransportManager transportManager;

    public static class StartFromBackgroundRunnable implements Runnable {
        public final AppStartTrace trace;

        public StartFromBackgroundRunnable(AppStartTrace appStartTrace) {
            this.trace = appStartTrace;
        }

        public void run() {
            AppStartTrace appStartTrace = this.trace;
            if (appStartTrace.onCreateTime == null) {
                appStartTrace.isStartedFromBackground = true;
            }
        }
    }

    public AppStartTrace(TransportManager transportManager2, Clock clock2, ExecutorService executorService2) {
        this.transportManager = transportManager2;
        this.clock = clock2;
        executorService = executorService2;
    }

    @Keep
    public static void setLauncherActivityOnCreateTime(String str) {
    }

    @Keep
    public static void setLauncherActivityOnResumeTime(String str) {
    }

    @Keep
    public static void setLauncherActivityOnStartTime(String str) {
    }

    public final void logAppStartTrace() {
        Builder newBuilder = TraceMetric.newBuilder();
        newBuilder.setName(Constants$TraceNames.APP_START_TRACE_NAME.toString());
        newBuilder.setClientStartTimeUs(this.appStartTime.timeInMicros);
        newBuilder.setDurationUs(this.appStartTime.getDurationMicros(this.onResumeTime));
        ArrayList arrayList = new ArrayList(3);
        Builder newBuilder2 = TraceMetric.newBuilder();
        newBuilder2.setName(Constants$TraceNames.ON_CREATE_TRACE_NAME.toString());
        newBuilder2.setClientStartTimeUs(this.appStartTime.timeInMicros);
        newBuilder2.setDurationUs(this.appStartTime.getDurationMicros(this.onCreateTime));
        arrayList.add((TraceMetric) newBuilder2.build());
        Builder newBuilder3 = TraceMetric.newBuilder();
        newBuilder3.setName(Constants$TraceNames.ON_START_TRACE_NAME.toString());
        newBuilder3.setClientStartTimeUs(this.onCreateTime.timeInMicros);
        newBuilder3.setDurationUs(this.onCreateTime.getDurationMicros(this.onStartTime));
        arrayList.add((TraceMetric) newBuilder3.build());
        Builder newBuilder4 = TraceMetric.newBuilder();
        newBuilder4.setName(Constants$TraceNames.ON_RESUME_TRACE_NAME.toString());
        newBuilder4.setClientStartTimeUs(this.onStartTime.timeInMicros);
        newBuilder4.setDurationUs(this.onStartTime.getDurationMicros(this.onResumeTime));
        arrayList.add((TraceMetric) newBuilder4.build());
        newBuilder.copyOnWrite();
        TraceMetric traceMetric = (TraceMetric) newBuilder.instance;
        ProtobufList<TraceMetric> protobufList = traceMetric.subtraces_;
        if (!protobufList.isModifiable()) {
            traceMetric.subtraces_ = GeneratedMessageLite.mutableCopy(protobufList);
        }
        AbstractMessageLite.addAll(arrayList, traceMetric.subtraces_);
        com.google.firebase.perf.v1.PerfSession build = this.startSession.build();
        newBuilder.copyOnWrite();
        TraceMetric.access$1900((TraceMetric) newBuilder.instance, build);
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

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002e, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0032, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onActivityCreated(android.app.Activity r4, android.os.Bundle r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r5 = r3.isStartedFromBackground     // Catch:{ all -> 0x0033 }
            if (r5 != 0) goto L_0x0031
            com.google.firebase.perf.util.Timer r5 = r3.onCreateTime     // Catch:{ all -> 0x0033 }
            if (r5 == 0) goto L_0x000a
            goto L_0x0031
        L_0x000a:
            java.lang.ref.WeakReference r5 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x0033 }
            r5.<init>(r4)     // Catch:{ all -> 0x0033 }
            com.google.firebase.perf.util.Clock r4 = r3.clock     // Catch:{ all -> 0x0033 }
            if (r4 == 0) goto L_0x002f
            com.google.firebase.perf.util.Timer r4 = new com.google.firebase.perf.util.Timer     // Catch:{ all -> 0x0033 }
            r4.<init>()     // Catch:{ all -> 0x0033 }
            r3.onCreateTime = r4     // Catch:{ all -> 0x0033 }
            com.google.firebase.perf.util.Timer r4 = com.google.firebase.perf.provider.FirebasePerfProvider.getAppStartTime()     // Catch:{ all -> 0x0033 }
            com.google.firebase.perf.util.Timer r5 = r3.onCreateTime     // Catch:{ all -> 0x0033 }
            long r4 = r4.getDurationMicros(r5)     // Catch:{ all -> 0x0033 }
            long r0 = MAX_LATENCY_BEFORE_UI_INIT     // Catch:{ all -> 0x0033 }
            int r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x002d
            r4 = 1
            r3.isTooLateToInitUI = r4     // Catch:{ all -> 0x0033 }
        L_0x002d:
            monitor-exit(r3)
            return
        L_0x002f:
            r4 = 0
            throw r4     // Catch:{ all -> 0x0033 }
        L_0x0031:
            monitor-exit(r3)
            return
        L_0x0033:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.metrics.AppStartTrace.onActivityCreated(android.app.Activity, android.os.Bundle):void");
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0089, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x008d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onActivityResumed(android.app.Activity r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.isStartedFromBackground     // Catch:{ all -> 0x008e }
            if (r0 != 0) goto L_0x008c
            com.google.firebase.perf.util.Timer r0 = r4.onResumeTime     // Catch:{ all -> 0x008e }
            if (r0 != 0) goto L_0x008c
            boolean r0 = r4.isTooLateToInitUI     // Catch:{ all -> 0x008e }
            if (r0 == 0) goto L_0x000f
            goto L_0x008c
        L_0x000f:
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x008e }
            r0.<init>(r5)     // Catch:{ all -> 0x008e }
            com.google.firebase.perf.util.Clock r0 = r4.clock     // Catch:{ all -> 0x008e }
            if (r0 == 0) goto L_0x008a
            com.google.firebase.perf.util.Timer r0 = new com.google.firebase.perf.util.Timer     // Catch:{ all -> 0x008e }
            r0.<init>()     // Catch:{ all -> 0x008e }
            r4.onResumeTime = r0     // Catch:{ all -> 0x008e }
            com.google.firebase.perf.util.Timer r0 = com.google.firebase.perf.provider.FirebasePerfProvider.getAppStartTime()     // Catch:{ all -> 0x008e }
            r4.appStartTime = r0     // Catch:{ all -> 0x008e }
            com.google.firebase.perf.session.SessionManager r0 = com.google.firebase.perf.session.SessionManager.getInstance()     // Catch:{ all -> 0x008e }
            com.google.firebase.perf.session.PerfSession r0 = r0.perfSession()     // Catch:{ all -> 0x008e }
            r4.startSession = r0     // Catch:{ all -> 0x008e }
            com.google.firebase.perf.logging.AndroidLogger r0 = com.google.firebase.perf.logging.AndroidLogger.getInstance()     // Catch:{ all -> 0x008e }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x008e }
            r1.<init>()     // Catch:{ all -> 0x008e }
            java.lang.String r2 = "onResume(): "
            r1.append(r2)     // Catch:{ all -> 0x008e }
            java.lang.Class r5 = r5.getClass()     // Catch:{ all -> 0x008e }
            java.lang.String r5 = r5.getName()     // Catch:{ all -> 0x008e }
            r1.append(r5)     // Catch:{ all -> 0x008e }
            java.lang.String r5 = ": "
            r1.append(r5)     // Catch:{ all -> 0x008e }
            com.google.firebase.perf.util.Timer r5 = r4.appStartTime     // Catch:{ all -> 0x008e }
            com.google.firebase.perf.util.Timer r2 = r4.onResumeTime     // Catch:{ all -> 0x008e }
            long r2 = r5.getDurationMicros(r2)     // Catch:{ all -> 0x008e }
            r1.append(r2)     // Catch:{ all -> 0x008e }
            java.lang.String r5 = " microseconds"
            r1.append(r5)     // Catch:{ all -> 0x008e }
            java.lang.String r5 = r1.toString()     // Catch:{ all -> 0x008e }
            r0.debug(r5)     // Catch:{ all -> 0x008e }
            java.util.concurrent.ExecutorService r5 = executorService     // Catch:{ all -> 0x008e }
            com.google.firebase.perf.metrics.-$$Lambda$Ai0tw8aGARXhizFha8JGavyiRhg r0 = new com.google.firebase.perf.metrics.-$$Lambda$Ai0tw8aGARXhizFha8JGavyiRhg     // Catch:{ all -> 0x008e }
            r0.<init>()     // Catch:{ all -> 0x008e }
            r5.execute(r0)     // Catch:{ all -> 0x008e }
            boolean r5 = r4.isRegisteredForLifecycleCallbacks     // Catch:{ all -> 0x008e }
            if (r5 == 0) goto L_0x0088
            monitor-enter(r4)     // Catch:{ all -> 0x008e }
            boolean r5 = r4.isRegisteredForLifecycleCallbacks     // Catch:{ all -> 0x0085 }
            if (r5 != 0) goto L_0x0079
            monitor-exit(r4)     // Catch:{ all -> 0x008e }
            goto L_0x0088
        L_0x0079:
            android.content.Context r5 = r4.appContext     // Catch:{ all -> 0x0085 }
            android.app.Application r5 = (android.app.Application) r5     // Catch:{ all -> 0x0085 }
            r5.unregisterActivityLifecycleCallbacks(r4)     // Catch:{ all -> 0x0085 }
            r5 = 0
            r4.isRegisteredForLifecycleCallbacks = r5     // Catch:{ all -> 0x0085 }
            monitor-exit(r4)     // Catch:{ all -> 0x008e }
            goto L_0x0088
        L_0x0085:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x008e }
            throw r5     // Catch:{ all -> 0x008e }
        L_0x0088:
            monitor-exit(r4)
            return
        L_0x008a:
            r5 = 0
            throw r5     // Catch:{ all -> 0x008e }
        L_0x008c:
            monitor-exit(r4)
            return
        L_0x008e:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.metrics.AppStartTrace.onActivityResumed(android.app.Activity):void");
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x001e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onActivityStarted(android.app.Activity r1) {
        /*
            r0 = this;
            monitor-enter(r0)
            boolean r1 = r0.isStartedFromBackground     // Catch:{ all -> 0x001f }
            if (r1 != 0) goto L_0x001d
            com.google.firebase.perf.util.Timer r1 = r0.onStartTime     // Catch:{ all -> 0x001f }
            if (r1 != 0) goto L_0x001d
            boolean r1 = r0.isTooLateToInitUI     // Catch:{ all -> 0x001f }
            if (r1 == 0) goto L_0x000e
            goto L_0x001d
        L_0x000e:
            com.google.firebase.perf.util.Clock r1 = r0.clock     // Catch:{ all -> 0x001f }
            if (r1 == 0) goto L_0x001b
            com.google.firebase.perf.util.Timer r1 = new com.google.firebase.perf.util.Timer     // Catch:{ all -> 0x001f }
            r1.<init>()     // Catch:{ all -> 0x001f }
            r0.onStartTime = r1     // Catch:{ all -> 0x001f }
            monitor-exit(r0)
            return
        L_0x001b:
            r1 = 0
            throw r1     // Catch:{ all -> 0x001f }
        L_0x001d:
            monitor-exit(r0)
            return
        L_0x001f:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.metrics.AppStartTrace.onActivityStarted(android.app.Activity):void");
    }

    public synchronized void onActivityStopped(Activity activity) {
    }
}
