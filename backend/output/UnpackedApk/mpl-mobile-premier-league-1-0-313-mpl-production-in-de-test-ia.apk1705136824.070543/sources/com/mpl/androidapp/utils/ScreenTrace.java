package com.mpl.androidapp.utils;

import android.app.Activity;
import androidx.core.app.FrameMetricsAggregator;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.metrics.Trace;
import com.xiaomi.mipush.sdk.Constants;
import org.apache.fontbox.cmap.CMapParser;

public class ScreenTrace {
    public static final String FRAME_METRICS_AGGREGATOR_CLASSNAME = "androidx.core.app.FrameMetricsAggregator";
    public static final String TAG = "ScreenTrace";
    public final Activity activity;
    public FrameMetricsAggregator frameMetricsAggregator;
    public final boolean isScreenTraceSupported;
    public Trace perfScreenTrace;
    public final String traceName;

    public ScreenTrace(Activity activity2, String str) {
        this.activity = activity2;
        this.traceName = activity2.getLocalClassName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str;
        enableHardwareAcceleration(activity2);
        boolean isScreenTraceSupported2 = isScreenTraceSupported(activity2);
        this.isScreenTraceSupported = isScreenTraceSupported2;
        if (isScreenTraceSupported2) {
            this.frameMetricsAggregator = new FrameMetricsAggregator();
        }
    }

    public static void enableHardwareAcceleration(Activity activity2) {
        activity2.getWindow().setFlags(16777216, 16777216);
    }

    private String getScreenTraceName() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("_st_");
        outline73.append(this.traceName);
        return outline73.toString();
    }

    public static boolean hasFrameMetricsAggregatorClass() {
        try {
            Class.forName(FRAME_METRICS_AGGREGATOR_CLASSNAME);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public boolean isScreenTraceSupported() {
        return this.isScreenTraceSupported;
    }

    public void recordScreenTrace() {
        if (this.isScreenTraceSupported) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Recording screen trace start ");
            outline73.append(this.traceName);
            MLogger.d(TAG, outline73.toString());
            this.frameMetricsAggregator.add(this.activity);
            this.perfScreenTrace = FirebasePerformance.startTrace(getScreenTraceName());
            return;
        }
        throw new IllegalArgumentException("Trying to record screen trace when it's not supported!");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0055  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void sendScreenTrace() {
        /*
            r9 = this;
            com.google.firebase.perf.metrics.Trace r0 = r9.perfScreenTrace
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            androidx.core.app.FrameMetricsAggregator r0 = r9.frameMetricsAggregator
            android.app.Activity r1 = r9.activity
            android.util.SparseIntArray[] r0 = r0.remove(r1)
            r1 = 0
            if (r0 == 0) goto L_0x0034
            r0 = r0[r1]
            if (r0 == 0) goto L_0x0034
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
        L_0x0018:
            int r6 = r0.size()
            if (r2 >= r6) goto L_0x0037
            int r6 = r0.keyAt(r2)
            int r7 = r0.valueAt(r2)
            int r3 = r3 + r7
            r8 = 700(0x2bc, float:9.81E-43)
            if (r6 <= r8) goto L_0x002c
            int r5 = r5 + r7
        L_0x002c:
            r8 = 16
            if (r6 <= r8) goto L_0x0031
            int r4 = r4 + r7
        L_0x0031:
            int r2 = r2 + 1
            goto L_0x0018
        L_0x0034:
            r3 = 0
            r4 = 0
            r5 = 0
        L_0x0037:
            if (r3 <= 0) goto L_0x0045
            com.google.firebase.perf.metrics.Trace r0 = r9.perfScreenTrace
            com.google.firebase.perf.util.Constants$CounterNames r2 = com.google.firebase.perf.util.Constants$CounterNames.FRAMES_TOTAL
            java.lang.String r2 = r2.toString()
            long r6 = (long) r3
            r0.putMetric(r2, r6)
        L_0x0045:
            if (r4 <= 0) goto L_0x0053
            com.google.firebase.perf.metrics.Trace r0 = r9.perfScreenTrace
            com.google.firebase.perf.util.Constants$CounterNames r2 = com.google.firebase.perf.util.Constants$CounterNames.FRAMES_SLOW
            java.lang.String r2 = r2.toString()
            long r6 = (long) r4
            r0.putMetric(r2, r6)
        L_0x0053:
            if (r5 <= 0) goto L_0x0061
            com.google.firebase.perf.metrics.Trace r0 = r9.perfScreenTrace
            com.google.firebase.perf.util.Constants$CounterNames r2 = com.google.firebase.perf.util.Constants$CounterNames.FRAMES_FROZEN
            java.lang.String r2 = r2.toString()
            long r6 = (long) r5
            r0.putMetric(r2, r6)
        L_0x0061:
            r0 = 1
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r2 = "sendScreenTrace "
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r2)
            java.lang.String r6 = r9.traceName
            r2.append(r6)
            java.lang.String r6 = ", name: "
            r2.append(r6)
            java.lang.String r6 = r9.getScreenTraceName()
            r2.append(r6)
            java.lang.String r6 = ", total_frames: "
            r2.append(r6)
            r2.append(r3)
            java.lang.String r3 = ", slow_frames: "
            r2.append(r3)
            r2.append(r4)
            java.lang.String r3 = ", frozen_frames: "
            r2.append(r3)
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            r0[r1] = r2
            java.lang.String r1 = "ScreenTrace"
            com.mpl.androidapp.utils.MLogger.d(r1, r0)
            com.google.firebase.perf.metrics.Trace r0 = r9.perfScreenTrace
            r0.stop()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.utils.ScreenTrace.sendScreenTrace():void");
    }

    public static boolean isScreenTraceSupported(Activity activity2) {
        boolean hasFrameMetricsAggregatorClass = hasFrameMetricsAggregatorClass();
        boolean z = (activity2.getWindow() == null || (activity2.getWindow().getAttributes().flags & 16777216) == 0) ? false : true;
        boolean z2 = hasFrameMetricsAggregatorClass && z;
        MLogger.d(TAG, "isScreenTraceSupported(" + activity2 + "): " + z2 + " [hasFrameMetricsAggregatorClass: " + hasFrameMetricsAggregatorClass + ", isActivityHardwareAccelerated: " + z + CMapParser.MARK_END_OF_ARRAY);
        return z2;
    }
}
