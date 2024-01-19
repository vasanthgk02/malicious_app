package com.google.firebase.perf.transport;

import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.PerfMetric.Builder;

public final class PendingPerfEvent {
    public final ApplicationProcessState appState;
    public final Builder perfMetricBuilder;

    public PendingPerfEvent(Builder builder, ApplicationProcessState applicationProcessState) {
        this.perfMetricBuilder = builder;
        this.appState = applicationProcessState;
    }
}
