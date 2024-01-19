package com.mpl.androidapp.unity.vm;

import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.unity.vm.MiniProfileContainerVm", f = "MiniProfileContainerVm.kt", l = {30}, m = "getUnityDeepLink")
/* compiled from: MiniProfileContainerVm.kt */
public final class MiniProfileContainerVm$getUnityDeepLink$1 extends ContinuationImpl {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ MiniProfileContainerVm this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public MiniProfileContainerVm$getUnityDeepLink$1(MiniProfileContainerVm miniProfileContainerVm, Continuation<? super MiniProfileContainerVm$getUnityDeepLink$1> continuation) {
        // this.this$0 = miniProfileContainerVm;
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= LinearLayoutManager.INVALID_OFFSET;
        return this.this$0.getUnityDeepLink(null, 0, this);
    }
}
