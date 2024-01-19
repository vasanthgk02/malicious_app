package com.mpl.androidapp.unity.features;

import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.unity.features.MplUnityFeatures", f = "MplUnityFeatures.kt", l = {122, 130}, m = "sendEventForGames")
/* compiled from: MplUnityFeatures.kt */
public final class MplUnityFeatures$sendEventForGames$1 extends ContinuationImpl {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ MplUnityFeatures this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public MplUnityFeatures$sendEventForGames$1(MplUnityFeatures mplUnityFeatures, Continuation<? super MplUnityFeatures$sendEventForGames$1> continuation) {
        // this.this$0 = mplUnityFeatures;
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= LinearLayoutManager.INVALID_OFFSET;
        return this.this$0.sendEventForGames(null, this);
    }
}
