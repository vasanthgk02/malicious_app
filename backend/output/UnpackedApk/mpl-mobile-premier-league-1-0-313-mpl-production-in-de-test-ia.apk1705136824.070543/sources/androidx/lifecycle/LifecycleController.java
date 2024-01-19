package androidx.lifecycle;

import androidx.lifecycle.Lifecycle.State;
import in.juspay.hypersdk.core.PaymentConstants.LogCategory;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.coroutines.Job;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\r\u001a\u00020\u000eH\u0007J\u0011\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/lifecycle/LifecycleController;", "", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "minState", "Landroidx/lifecycle/Lifecycle$State;", "dispatchQueue", "Landroidx/lifecycle/DispatchQueue;", "parentJob", "Lkotlinx/coroutines/Job;", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Landroidx/lifecycle/DispatchQueue;Lkotlinx/coroutines/Job;)V", "observer", "Landroidx/lifecycle/LifecycleEventObserver;", "finish", "", "handleDestroy", "lifecycle-runtime-ktx_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: LifecycleController.kt */
public final class LifecycleController {
    public final DispatchQueue dispatchQueue;
    public final Lifecycle lifecycle;
    public final State minState;
    public final LifecycleEventObserver observer;

    public LifecycleController(Lifecycle lifecycle2, State state, DispatchQueue dispatchQueue2, Job job) {
        Intrinsics.checkNotNullParameter(lifecycle2, LogCategory.LIFECYCLE);
        Intrinsics.checkNotNullParameter(state, "minState");
        Intrinsics.checkNotNullParameter(dispatchQueue2, "dispatchQueue");
        Intrinsics.checkNotNullParameter(job, "parentJob");
        this.lifecycle = lifecycle2;
        this.minState = state;
        this.dispatchQueue = dispatchQueue2;
        LifecycleController$observer$1 lifecycleController$observer$1 = new LifecycleController$observer$1(this, job);
        this.observer = lifecycleController$observer$1;
        Lifecycle lifecycle3 = this.lifecycle;
        if (((LifecycleRegistry) lifecycle3).mState == State.DESTROYED) {
            TypeUtilsKt.cancel$default(job, (CancellationException) null, 1, (Object) null);
            finish();
            return;
        }
        lifecycle3.addObserver(lifecycleController$observer$1);
    }

    public final void finish() {
        this.lifecycle.removeObserver(this.observer);
        DispatchQueue dispatchQueue2 = this.dispatchQueue;
        dispatchQueue2.finished = true;
        dispatchQueue2.drainQueue();
    }
}