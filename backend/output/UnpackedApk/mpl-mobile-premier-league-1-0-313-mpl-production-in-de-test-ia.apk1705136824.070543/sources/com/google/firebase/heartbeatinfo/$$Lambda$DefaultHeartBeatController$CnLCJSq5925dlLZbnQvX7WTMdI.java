package com.google.firebase.heartbeatinfo;

import java.util.concurrent.ThreadFactory;

/* renamed from: com.google.firebase.heartbeatinfo.-$$Lambda$DefaultHeartBeatController$Cn-LCJSq5925dlLZbnQvX7WTMdI  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$DefaultHeartBeatController$CnLCJSq5925dlLZbnQvX7WTMdI implements ThreadFactory {
    public static final /* synthetic */ $$Lambda$DefaultHeartBeatController$CnLCJSq5925dlLZbnQvX7WTMdI INSTANCE = new $$Lambda$DefaultHeartBeatController$CnLCJSq5925dlLZbnQvX7WTMdI();

    private /* synthetic */ $$Lambda$DefaultHeartBeatController$CnLCJSq5925dlLZbnQvX7WTMdI() {
    }

    public final Thread newThread(Runnable runnable) {
        return DefaultHeartBeatController.lambda$static$0(runnable);
    }
}
