package com.mpl.androidapp.share;

import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.share.MplShareFeature", f = "MplShareFeature.kt", l = {73, 80, 83}, m = "checkSharePlatform")
/* compiled from: MplShareFeature.kt */
public final class MplShareFeature$checkSharePlatform$1 extends ContinuationImpl {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ MplShareFeature this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public MplShareFeature$checkSharePlatform$1(MplShareFeature mplShareFeature, Continuation<? super MplShareFeature$checkSharePlatform$1> continuation) {
        // this.this$0 = mplShareFeature;
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= LinearLayoutManager.INVALID_OFFSET;
        return this.this$0.checkSharePlatform(this);
    }
}
