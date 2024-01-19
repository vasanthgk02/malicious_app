package com.mpl.androidapp.unity.features;

import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.unity.features.MplUnityFeatures", f = "MplUnityFeatures.kt", l = {106, 114}, m = "createScreenShotFile")
/* compiled from: MplUnityFeatures.kt */
public final class MplUnityFeatures$createScreenShotFile$1 extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ MplUnityFeatures this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public MplUnityFeatures$createScreenShotFile$1(MplUnityFeatures mplUnityFeatures, Continuation<? super MplUnityFeatures$createScreenShotFile$1> continuation) {
        // this.this$0 = mplUnityFeatures;
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= LinearLayoutManager.INVALID_OFFSET;
        return this.this$0.createScreenShotFile(null, this);
    }
}
