package io.sentry;

import io.sentry.util.Objects;
import java.util.Random;

public final class TracesSampler {
    public final SentryOptions options;
    public final Random random;

    public TracesSampler(SentryOptions sentryOptions) {
        this((SentryOptions) Objects.requireNonNull(sentryOptions, "options are required"), new Random());
    }

    public boolean sample(SamplingContext samplingContext) {
        if (samplingContext.getTransactionContext().getSampled() != null) {
            return samplingContext.getTransactionContext().getSampled().booleanValue();
        }
        if (this.options.getTracesSampler() != null) {
            Double sample = this.options.getTracesSampler().sample(samplingContext);
            if (sample != null) {
                return sample(sample);
            }
        }
        if (samplingContext.getTransactionContext().getParentSampled() != null) {
            return samplingContext.getTransactionContext().getParentSampled().booleanValue();
        }
        if (this.options.getTracesSampleRate() != null) {
            return sample(this.options.getTracesSampleRate());
        }
        return false;
    }

    public TracesSampler(SentryOptions sentryOptions, Random random2) {
        this.options = sentryOptions;
        this.random = random2;
    }

    private boolean sample(Double d2) {
        return d2.doubleValue() >= this.random.nextDouble();
    }
}
