package io.sentry.android.core;

import io.sentry.EventProcessor;
import io.sentry.EventProcessor.CC;
import io.sentry.SentryEvent;
import io.sentry.protocol.MeasurementValue;
import io.sentry.protocol.SentrySpan;
import io.sentry.protocol.SentryTransaction;
import java.util.List;

public final class PerformanceAndroidEventProcessor implements EventProcessor {
    public boolean sentStartMeasurement = false;
    public final boolean tracingEnabled;

    public PerformanceAndroidEventProcessor(SentryAndroidOptions sentryAndroidOptions) {
        this.tracingEnabled = sentryAndroidOptions.isTracingEnabled();
    }

    private boolean hasAppStartSpan(List<SentrySpan> list) {
        for (SentrySpan next : list) {
            if (!next.getOp().contentEquals(ActivityLifecycleIntegration.APP_START_COLD)) {
                if (next.getOp().contentEquals(ActivityLifecycleIntegration.APP_START_WARM)) {
                }
            }
            return true;
        }
        return false;
    }

    public /* synthetic */ SentryEvent process(SentryEvent sentryEvent, Object obj) {
        return CC.$default$process((EventProcessor) this, sentryEvent, obj);
    }

    public synchronized SentryTransaction process(SentryTransaction sentryTransaction, Object obj) {
        if (!this.sentStartMeasurement && this.tracingEnabled && hasAppStartSpan(sentryTransaction.getSpans())) {
            Long appStartInterval = AppStartState.getInstance().getAppStartInterval();
            if (appStartInterval != null) {
                sentryTransaction.getMeasurements().put(AppStartState.getInstance().isColdStart() ? "app_start_cold" : "app_start_warm", new MeasurementValue((float) appStartInterval.longValue()));
                this.sentStartMeasurement = true;
            }
        }
        return sentryTransaction;
    }
}
