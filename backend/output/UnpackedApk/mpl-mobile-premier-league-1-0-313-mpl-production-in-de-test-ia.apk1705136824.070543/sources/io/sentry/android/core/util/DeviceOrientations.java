package io.sentry.android.core.util;

import io.sentry.protocol.Device.DeviceOrientation;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public final class DeviceOrientations {
    public static DeviceOrientation getOrientation(int i) {
        if (i == 1) {
            return DeviceOrientation.PORTRAIT;
        }
        if (i != 2) {
            return null;
        }
        return DeviceOrientation.LANDSCAPE;
    }
}
