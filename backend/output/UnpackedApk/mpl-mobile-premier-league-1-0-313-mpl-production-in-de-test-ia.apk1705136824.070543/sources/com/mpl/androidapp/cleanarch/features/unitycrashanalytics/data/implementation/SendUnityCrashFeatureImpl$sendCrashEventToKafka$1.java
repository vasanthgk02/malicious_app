package com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.implementation;

import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.implementation.SendUnityCrashFeatureImpl", f = "SendUnityCrashFeatureImpl.kt", l = {40, 57, 61}, m = "sendCrashEventToKafka")
/* compiled from: SendUnityCrashFeatureImpl.kt */
public final class SendUnityCrashFeatureImpl$sendCrashEventToKafka$1 extends ContinuationImpl {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ SendUnityCrashFeatureImpl this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public SendUnityCrashFeatureImpl$sendCrashEventToKafka$1(SendUnityCrashFeatureImpl sendUnityCrashFeatureImpl, Continuation<? super SendUnityCrashFeatureImpl$sendCrashEventToKafka$1> continuation) {
        // this.this$0 = sendUnityCrashFeatureImpl;
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= LinearLayoutManager.INVALID_OFFSET;
        return this.this$0.sendCrashEventToKafka(this);
    }
}
