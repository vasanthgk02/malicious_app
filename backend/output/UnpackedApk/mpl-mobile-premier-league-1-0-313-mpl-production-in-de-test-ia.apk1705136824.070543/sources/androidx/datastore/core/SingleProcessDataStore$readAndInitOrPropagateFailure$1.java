package androidx.datastore.core;

import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {311}, m = "readAndInitOrPropagateFailure")
/* compiled from: SingleProcessDataStore.kt */
public final class SingleProcessDataStore$readAndInitOrPropagateFailure$1 extends ContinuationImpl {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ SingleProcessDataStore<T> this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public SingleProcessDataStore$readAndInitOrPropagateFailure$1(SingleProcessDataStore<T> singleProcessDataStore, Continuation<? super SingleProcessDataStore$readAndInitOrPropagateFailure$1> continuation) {
        // this.this$0 = singleProcessDataStore;
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= LinearLayoutManager.INVALID_OFFSET;
        return this.this$0.readAndInitOrPropagateFailure(this);
    }
}
