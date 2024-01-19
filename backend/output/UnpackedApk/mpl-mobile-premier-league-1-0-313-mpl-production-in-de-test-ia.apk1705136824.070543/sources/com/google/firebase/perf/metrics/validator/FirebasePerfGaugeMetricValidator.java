package com.google.firebase.perf.metrics.validator;

import com.google.firebase.perf.v1.GaugeMetadata;
import com.google.firebase.perf.v1.GaugeMetric;

public final class FirebasePerfGaugeMetricValidator extends PerfMetricValidator {
    public final GaugeMetric gaugeMetric;

    public FirebasePerfGaugeMetricValidator(GaugeMetric gaugeMetric2) {
        this.gaugeMetric = gaugeMetric2;
    }

    public boolean isValidPerfMetric() {
        if ((this.gaugeMetric.bitField0_ & 1) != 0) {
            if (this.gaugeMetric.cpuMetricReadings_.size() > 0 || this.gaugeMetric.androidMemoryReadings_.size() > 0) {
                return true;
            }
            if ((this.gaugeMetric.bitField0_ & 2) != 0) {
                GaugeMetadata gaugeMetadata = this.gaugeMetric.gaugeMetadata_;
                if (gaugeMetadata == null) {
                    gaugeMetadata = GaugeMetadata.DEFAULT_INSTANCE;
                }
                if ((gaugeMetadata.bitField0_ & 16) != 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
