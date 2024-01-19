package com.google.firebase.perf.transport;

import com.google.android.datatransport.Transformer;
import com.google.firebase.perf.v1.PerfMetric;

/* renamed from: com.google.firebase.perf.transport.-$$Lambda$Itu3_v5Z-Xtk9hzoqKGtXZ9cnAw  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$Itu3_v5ZXtk9hzoqKGtXZ9cnAw implements Transformer {
    public static final /* synthetic */ $$Lambda$Itu3_v5ZXtk9hzoqKGtXZ9cnAw INSTANCE = new $$Lambda$Itu3_v5ZXtk9hzoqKGtXZ9cnAw();

    private /* synthetic */ $$Lambda$Itu3_v5ZXtk9hzoqKGtXZ9cnAw() {
    }

    public final Object apply(Object obj) {
        return ((PerfMetric) obj).toByteArray();
    }
}
