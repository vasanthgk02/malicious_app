package com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.services;

import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.services.UnityCrashSyncService", f = "UnityCrashSyncService.kt", l = {27}, m = "doWork")
/* compiled from: UnityCrashSyncService.kt */
public final class UnityCrashSyncService$doWork$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ UnityCrashSyncService this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public UnityCrashSyncService$doWork$1(UnityCrashSyncService unityCrashSyncService, Continuation<? super UnityCrashSyncService$doWork$1> continuation) {
        // this.this$0 = unityCrashSyncService;
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= LinearLayoutManager.INVALID_OFFSET;
        return this.this$0.doWork(this);
    }
}
