package io.sentry.android.core.util;

import android.content.Context;
import android.os.Process;
import io.sentry.util.Objects;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public final class Permissions {
    public static boolean hasPermission(Context context, String str) {
        Objects.requireNonNull(context, "The application context is required.");
        return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }
}
