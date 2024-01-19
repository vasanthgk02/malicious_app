package io.sentry.android.core;

import android.content.Context;
import io.sentry.ILogger;
import io.sentry.android.core.util.ConnectivityChecker;
import io.sentry.android.core.util.ConnectivityChecker.Status;
import io.sentry.transport.ITransportGate;

public final class AndroidTransportGate implements ITransportGate {
    public final Context context;
    public final ILogger logger;

    /* renamed from: io.sentry.android.core.AndroidTransportGate$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$io$sentry$android$core$util$ConnectivityChecker$Status;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|(2:1|2)|3|5|6|7|8|10) */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0017 */
        static {
            /*
                io.sentry.android.core.util.ConnectivityChecker$Status[] r0 = io.sentry.android.core.util.ConnectivityChecker.Status.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$sentry$android$core$util$ConnectivityChecker$Status = r0
                io.sentry.android.core.util.ConnectivityChecker$Status r1 = io.sentry.android.core.util.ConnectivityChecker.Status.CONNECTED     // Catch:{ NoSuchFieldError -> 0x000f }
                r1 = 0
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                r1 = 3
                int[] r2 = $SwitchMap$io$sentry$android$core$util$ConnectivityChecker$Status     // Catch:{ NoSuchFieldError -> 0x0017 }
                io.sentry.android.core.util.ConnectivityChecker$Status r3 = io.sentry.android.core.util.ConnectivityChecker.Status.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0017 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0017 }
            L_0x0017:
                int[] r2 = $SwitchMap$io$sentry$android$core$util$ConnectivityChecker$Status     // Catch:{ NoSuchFieldError -> 0x001d }
                io.sentry.android.core.util.ConnectivityChecker$Status r3 = io.sentry.android.core.util.ConnectivityChecker.Status.NO_PERMISSION     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.AndroidTransportGate.AnonymousClass1.<clinit>():void");
        }
    }

    public AndroidTransportGate(Context context2, ILogger iLogger) {
        this.context = context2;
        this.logger = iLogger;
    }

    public boolean isConnected() {
        return isConnected(ConnectivityChecker.getConnectionStatus(this.context, this.logger));
    }

    public boolean isConnected(Status status) {
        int ordinal = status.ordinal();
        return ordinal == 0 || ordinal == 2 || ordinal == 3;
    }
}
