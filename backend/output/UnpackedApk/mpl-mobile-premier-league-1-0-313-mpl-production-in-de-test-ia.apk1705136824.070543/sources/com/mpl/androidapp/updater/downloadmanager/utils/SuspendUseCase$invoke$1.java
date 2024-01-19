package com.mpl.androidapp.updater.downloadmanager.utils;

import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.updater.downloadmanager.utils.SuspendUseCase", f = "SuspendUseCase.kt", l = {29}, m = "invoke")
/* compiled from: SuspendUseCase.kt */
public final class SuspendUseCase$invoke$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ SuspendUseCase<P, R> this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public SuspendUseCase$invoke$1(SuspendUseCase<? super P, R> suspendUseCase, Continuation<? super SuspendUseCase$invoke$1> continuation) {
        // this.this$0 = suspendUseCase;
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= LinearLayoutManager.INVALID_OFFSET;
        return this.this$0.invoke(null, this);
    }
}
