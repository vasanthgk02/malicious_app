package com.netcore.android.network;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/netcore/android/network/SMTThreadPoolManager;", "", "Ljava/util/concurrent/ScheduledExecutorService;", "getIntance", "()Ljava/util/concurrent/ScheduledExecutorService;", "mExecutorService", "Ljava/util/concurrent/ScheduledExecutorService;", "<init>", "()V", "smartech_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: SMTThreadPoolManager.kt */
public final class SMTThreadPoolManager {
    public static final SMTThreadPoolManager INSTANCE = new SMTThreadPoolManager();
    public static ScheduledExecutorService mExecutorService;

    static {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors() + 1);
        Intrinsics.checkNotNullExpressionValue(newScheduledThreadPool, "Executors.newScheduledTh…Pool(NUMBER_OF_CORES + 1)");
        mExecutorService = newScheduledThreadPool;
    }

    public final ScheduledExecutorService getIntance() {
        return mExecutorService;
    }
}
