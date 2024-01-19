package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "androidx/lifecycle/DispatchQueue$dispatchAndEnqueue$1$1"}, k = 3, mv = {1, 4, 1})
/* compiled from: DispatchQueue.kt */
public final class DispatchQueue$dispatchAndEnqueue$$inlined$with$lambda$1 implements Runnable {
    public final /* synthetic */ Runnable $runnable$inlined;
    public final /* synthetic */ DispatchQueue this$0;

    public DispatchQueue$dispatchAndEnqueue$$inlined$with$lambda$1(DispatchQueue dispatchQueue, CoroutineContext coroutineContext, Runnable runnable) {
        this.this$0 = dispatchQueue;
        this.$runnable$inlined = runnable;
    }

    public final void run() {
        this.this$0.enqueue(this.$runnable$inlined);
    }
}
