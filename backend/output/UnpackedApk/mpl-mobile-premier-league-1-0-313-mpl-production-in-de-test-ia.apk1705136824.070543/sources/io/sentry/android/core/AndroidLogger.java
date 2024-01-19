package io.sentry.android.core;

import android.util.Log;
import io.sentry.ILogger;
import io.sentry.SentryLevel;

public final class AndroidLogger implements ILogger {
    public static final String tag = "Sentry";

    /* renamed from: io.sentry.android.core.AndroidLogger$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$io$sentry$SentryLevel;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0015 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0023 */
        static {
            /*
                io.sentry.SentryLevel[] r0 = io.sentry.SentryLevel.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$sentry$SentryLevel = r0
                io.sentry.SentryLevel r1 = io.sentry.SentryLevel.INFO     // Catch:{ NoSuchFieldError -> 0x000e }
                r1 = 1
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                int[] r0 = $SwitchMap$io$sentry$SentryLevel     // Catch:{ NoSuchFieldError -> 0x0015 }
                io.sentry.SentryLevel r1 = io.sentry.SentryLevel.WARNING     // Catch:{ NoSuchFieldError -> 0x0015 }
                r1 = 2
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x0015 }
            L_0x0015:
                int[] r0 = $SwitchMap$io$sentry$SentryLevel     // Catch:{ NoSuchFieldError -> 0x001c }
                io.sentry.SentryLevel r1 = io.sentry.SentryLevel.ERROR     // Catch:{ NoSuchFieldError -> 0x001c }
                r1 = 3
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x001c }
            L_0x001c:
                int[] r0 = $SwitchMap$io$sentry$SentryLevel     // Catch:{ NoSuchFieldError -> 0x0023 }
                io.sentry.SentryLevel r1 = io.sentry.SentryLevel.FATAL     // Catch:{ NoSuchFieldError -> 0x0023 }
                r1 = 4
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x0023 }
            L_0x0023:
                int[] r0 = $SwitchMap$io$sentry$SentryLevel     // Catch:{ NoSuchFieldError -> 0x002b }
                io.sentry.SentryLevel r1 = io.sentry.SentryLevel.DEBUG     // Catch:{ NoSuchFieldError -> 0x002b }
                r1 = 0
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.AndroidLogger.AnonymousClass1.<clinit>():void");
        }
    }

    private int toLogcatLevel(SentryLevel sentryLevel) {
        int ordinal = sentryLevel.ordinal();
        if (ordinal == 1) {
            return 4;
        }
        if (ordinal != 2) {
            return ordinal != 4 ? 3 : 7;
        }
        return 5;
    }

    public boolean isEnabled(SentryLevel sentryLevel) {
        return true;
    }

    public void log(SentryLevel sentryLevel, String str, Object... objArr) {
        Log.println(toLogcatLevel(sentryLevel), tag, String.format(str, objArr));
    }

    public void log(SentryLevel sentryLevel, Throwable th, String str, Object... objArr) {
        log(sentryLevel, String.format(str, objArr), th);
    }

    public void log(SentryLevel sentryLevel, String str, Throwable th) {
        if (sentryLevel.ordinal() == 4) {
            Log.wtf(tag, str, th);
        }
    }
}
