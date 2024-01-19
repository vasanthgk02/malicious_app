package io.sentry.util;

import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public final class Objects {
    public static <T> T requireNonNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException(str);
    }
}
