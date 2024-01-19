package com.google.firebase.perf.metrics.validator;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.v1.TraceMetric;
import java.util.Iterator;

public final class FirebasePerfTraceValidator extends PerfMetricValidator {
    public static final AndroidLogger logger = AndroidLogger.getInstance();
    public final TraceMetric traceMetric;

    public FirebasePerfTraceValidator(TraceMetric traceMetric2) {
        this.traceMetric = traceMetric2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0058 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean areCountersValid(com.google.firebase.perf.v1.TraceMetric r7, int r8) {
        /*
            r6 = this;
            r0 = 0
            if (r7 != 0) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 1
            if (r8 <= r1) goto L_0x000f
            com.google.firebase.perf.logging.AndroidLogger r7 = logger
            java.lang.String r8 = "Exceed MAX_SUBTRACE_DEEP:1"
            r7.warn(r8)
            return r0
        L_0x000f:
            com.google.protobuf.MapFieldLite<java.lang.String, java.lang.Long> r2 = r7.counters_
            java.util.Map r2 = java.util.Collections.unmodifiableMap(r2)
            java.util.Set r2 = r2.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x001d:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0095
            java.lang.Object r3 = r2.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            java.lang.String r4 = (java.lang.String) r4
            if (r4 != 0) goto L_0x0032
            goto L_0x0053
        L_0x0032:
            java.lang.String r4 = r4.trim()
            boolean r5 = r4.isEmpty()
            if (r5 == 0) goto L_0x0044
            com.google.firebase.perf.logging.AndroidLogger r4 = logger
            java.lang.String r5 = "counterId is empty"
            r4.warn(r5)
            goto L_0x0053
        L_0x0044:
            int r4 = r4.length()
            r5 = 100
            if (r4 <= r5) goto L_0x0055
            com.google.firebase.perf.logging.AndroidLogger r4 = logger
            java.lang.String r5 = "counterId exceeded max length 100"
            r4.warn(r5)
        L_0x0053:
            r4 = 0
            goto L_0x0056
        L_0x0055:
            r4 = 1
        L_0x0056:
            if (r4 != 0) goto L_0x0071
            com.google.firebase.perf.logging.AndroidLogger r7 = logger
            java.lang.String r8 = "invalid CounterId:"
            java.lang.StringBuilder r8 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r8)
            java.lang.Object r1 = r3.getKey()
            java.lang.String r1 = (java.lang.String) r1
            r8.append(r1)
            java.lang.String r8 = r8.toString()
            r7.warn(r8)
            return r0
        L_0x0071:
            java.lang.Object r4 = r3.getValue()
            java.lang.Long r4 = (java.lang.Long) r4
            if (r4 == 0) goto L_0x007b
            r4 = 1
            goto L_0x007c
        L_0x007b:
            r4 = 0
        L_0x007c:
            if (r4 != 0) goto L_0x001d
            com.google.firebase.perf.logging.AndroidLogger r7 = logger
            java.lang.String r8 = "invalid CounterValue:"
            java.lang.StringBuilder r8 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r8)
            java.lang.Object r1 = r3.getValue()
            r8.append(r1)
            java.lang.String r8 = r8.toString()
            r7.warn(r8)
            return r0
        L_0x0095:
            com.google.protobuf.Internal$ProtobufList<com.google.firebase.perf.v1.TraceMetric> r7 = r7.subtraces_
            java.util.Iterator r7 = r7.iterator()
        L_0x009b:
            boolean r2 = r7.hasNext()
            if (r2 == 0) goto L_0x00b0
            java.lang.Object r2 = r7.next()
            com.google.firebase.perf.v1.TraceMetric r2 = (com.google.firebase.perf.v1.TraceMetric) r2
            int r3 = r8 + 1
            boolean r2 = r6.areCountersValid(r2, r3)
            if (r2 != 0) goto L_0x009b
            return r0
        L_0x00b0:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.metrics.validator.FirebasePerfTraceValidator.areCountersValid(com.google.firebase.perf.v1.TraceMetric, int):boolean");
    }

    public boolean isValidPerfMetric() {
        boolean z;
        boolean z2;
        if (!isValidTrace(this.traceMetric, 0)) {
            AndroidLogger androidLogger = logger;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Invalid Trace:");
            outline73.append(this.traceMetric.name_);
            androidLogger.warn(outline73.toString());
            return false;
        }
        TraceMetric traceMetric2 = this.traceMetric;
        if (traceMetric2.getCountersCount() > 0) {
            z = true;
        } else {
            Iterator it = traceMetric2.subtraces_.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                if (((TraceMetric) it.next()).getCountersCount() > 0) {
                    z2 = true;
                    continue;
                } else {
                    z2 = false;
                    continue;
                }
                if (z2) {
                    break;
                }
            }
            z = true;
        }
        if (!z || areCountersValid(this.traceMetric, 0)) {
            return true;
        }
        AndroidLogger androidLogger2 = logger;
        StringBuilder outline732 = GeneratedOutlineSupport.outline73("Invalid Counters for Trace:");
        outline732.append(this.traceMetric.name_);
        androidLogger2.warn(outline732.toString());
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0047  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isValidTrace(com.google.firebase.perf.v1.TraceMetric r8, int r9) {
        /*
            r7 = this;
            r0 = 0
            if (r8 != 0) goto L_0x000b
            com.google.firebase.perf.logging.AndroidLogger r8 = logger
            java.lang.String r9 = "TraceMetric is null"
            r8.warn(r9)
            return r0
        L_0x000b:
            r1 = 1
            if (r9 <= r1) goto L_0x0016
            com.google.firebase.perf.logging.AndroidLogger r8 = logger
            java.lang.String r9 = "Exceed MAX_SUBTRACE_DEEP:1"
            r8.warn(r9)
            return r0
        L_0x0016:
            java.lang.String r2 = r8.name_
            if (r2 != 0) goto L_0x001b
            goto L_0x002f
        L_0x001b:
            java.lang.String r2 = r2.trim()
            boolean r3 = r2.isEmpty()
            if (r3 != 0) goto L_0x002f
            int r2 = r2.length()
            r3 = 100
            if (r2 > r3) goto L_0x002f
            r2 = 1
            goto L_0x0030
        L_0x002f:
            r2 = 0
        L_0x0030:
            if (r2 != 0) goto L_0x0047
            com.google.firebase.perf.logging.AndroidLogger r9 = logger
            java.lang.String r1 = "invalid TraceId:"
            java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r1)
            java.lang.String r8 = r8.name_
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            r9.warn(r8)
            return r0
        L_0x0047:
            long r2 = r8.durationUs_
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x0051
            r2 = 1
            goto L_0x0052
        L_0x0051:
            r2 = 0
        L_0x0052:
            if (r2 != 0) goto L_0x0069
            com.google.firebase.perf.logging.AndroidLogger r9 = logger
            java.lang.String r1 = "invalid TraceDuration:"
            java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r1)
            long r2 = r8.durationUs_
            r1.append(r2)
            java.lang.String r8 = r1.toString()
            r9.warn(r8)
            return r0
        L_0x0069:
            int r2 = r8.bitField0_
            r2 = r2 & 4
            if (r2 == 0) goto L_0x0071
            r2 = 1
            goto L_0x0072
        L_0x0071:
            r2 = 0
        L_0x0072:
            if (r2 != 0) goto L_0x007c
            com.google.firebase.perf.logging.AndroidLogger r8 = logger
            java.lang.String r9 = "clientStartTimeUs is null."
            r8.warn(r9)
            return r0
        L_0x007c:
            java.lang.String r2 = r8.name_
            java.lang.String r3 = "_st_"
            boolean r2 = r2.startsWith(r3)
            if (r2 == 0) goto L_0x00be
            com.google.protobuf.MapFieldLite<java.lang.String, java.lang.Long> r2 = r8.counters_
            java.util.Map r2 = java.util.Collections.unmodifiableMap(r2)
            com.google.firebase.perf.util.Constants$CounterNames r3 = com.google.firebase.perf.util.Constants$CounterNames.FRAMES_TOTAL
            java.lang.String r3 = r3.toString()
            java.lang.Object r2 = r2.get(r3)
            java.lang.Long r2 = (java.lang.Long) r2
            if (r2 == 0) goto L_0x00a6
            java.lang.Long r3 = java.lang.Long.valueOf(r4)
            int r2 = r2.compareTo(r3)
            if (r2 <= 0) goto L_0x00a6
            r2 = 1
            goto L_0x00a7
        L_0x00a6:
            r2 = 0
        L_0x00a7:
            if (r2 != 0) goto L_0x00be
            com.google.firebase.perf.logging.AndroidLogger r9 = logger
            java.lang.String r1 = "non-positive totalFrames in screen trace "
            java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r1)
            java.lang.String r8 = r8.name_
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            r9.warn(r8)
            return r0
        L_0x00be:
            com.google.protobuf.Internal$ProtobufList<com.google.firebase.perf.v1.TraceMetric> r2 = r8.subtraces_
            java.util.Iterator r2 = r2.iterator()
        L_0x00c4:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x00d9
            java.lang.Object r3 = r2.next()
            com.google.firebase.perf.v1.TraceMetric r3 = (com.google.firebase.perf.v1.TraceMetric) r3
            int r4 = r9 + 1
            boolean r3 = r7.isValidTrace(r3, r4)
            if (r3 != 0) goto L_0x00c4
            return r0
        L_0x00d9:
            com.google.protobuf.MapFieldLite<java.lang.String, java.lang.String> r8 = r8.customAttributes_
            java.util.Map r8 = java.util.Collections.unmodifiableMap(r8)
            java.util.Set r8 = r8.entrySet()
            java.util.Iterator r8 = r8.iterator()
        L_0x00e7:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x0100
            java.lang.Object r9 = r8.next()
            java.util.Map$Entry r9 = (java.util.Map.Entry) r9
            java.lang.String r9 = com.google.firebase.perf.metrics.validator.PerfMetricValidator.validateAttribute(r9)
            if (r9 == 0) goto L_0x00e7
            com.google.firebase.perf.logging.AndroidLogger r8 = logger
            r8.warn(r9)
            r8 = 0
            goto L_0x0101
        L_0x0100:
            r8 = 1
        L_0x0101:
            if (r8 != 0) goto L_0x0104
            return r0
        L_0x0104:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.metrics.validator.FirebasePerfTraceValidator.isValidTrace(com.google.firebase.perf.v1.TraceMetric, int):boolean");
    }
}
