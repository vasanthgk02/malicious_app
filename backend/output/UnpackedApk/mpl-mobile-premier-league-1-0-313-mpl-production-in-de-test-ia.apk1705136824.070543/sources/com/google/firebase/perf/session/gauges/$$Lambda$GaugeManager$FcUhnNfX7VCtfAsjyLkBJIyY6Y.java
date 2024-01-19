package com.google.firebase.perf.session.gauges;

import com.google.firebase.inject.Provider;
import java.util.concurrent.Executors;

/* renamed from: com.google.firebase.perf.session.gauges.-$$Lambda$GaugeManager$FcUhnNfX7VCtfAsjy-LkBJIyY6Y  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$GaugeManager$FcUhnNfX7VCtfAsjyLkBJIyY6Y implements Provider {
    public static final /* synthetic */ $$Lambda$GaugeManager$FcUhnNfX7VCtfAsjyLkBJIyY6Y INSTANCE = new $$Lambda$GaugeManager$FcUhnNfX7VCtfAsjyLkBJIyY6Y();

    private /* synthetic */ $$Lambda$GaugeManager$FcUhnNfX7VCtfAsjyLkBJIyY6Y() {
    }

    public final Object get() {
        return Executors.newSingleThreadScheduledExecutor();
    }
}
