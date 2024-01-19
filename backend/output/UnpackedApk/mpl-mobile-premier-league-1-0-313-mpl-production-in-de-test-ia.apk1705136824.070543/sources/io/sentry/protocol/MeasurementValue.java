package io.sentry.protocol;

import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public final class MeasurementValue {
    public final float value;

    public MeasurementValue(float f2) {
        this.value = f2;
    }
}
