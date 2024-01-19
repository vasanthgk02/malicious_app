package io.sentry.android.core.util;

import android.os.Looper;
import io.sentry.protocol.SentryThread;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public final class MainThreadChecker {
    public static boolean isMainThread(Thread thread) {
        return isMainThread(thread.getId());
    }

    public static boolean isMainThread() {
        return isMainThread(Thread.currentThread());
    }

    public static boolean isMainThread(SentryThread sentryThread) {
        Long id = sentryThread.getId();
        return id != null && isMainThread(id.longValue());
    }

    public static boolean isMainThread(long j) {
        return Looper.getMainLooper().getThread().getId() == j;
    }
}
