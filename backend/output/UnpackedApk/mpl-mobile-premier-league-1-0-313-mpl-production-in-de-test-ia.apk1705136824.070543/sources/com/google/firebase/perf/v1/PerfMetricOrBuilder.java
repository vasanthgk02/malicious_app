package com.google.firebase.perf.v1;

import com.google.protobuf.MessageLiteOrBuilder;

public interface PerfMetricOrBuilder extends MessageLiteOrBuilder {
    GaugeMetric getGaugeMetric();

    NetworkRequestMetric getNetworkRequestMetric();

    TraceMetric getTraceMetric();

    boolean hasGaugeMetric();

    boolean hasNetworkRequestMetric();

    boolean hasTraceMetric();
}
