package androidx.lifecycle;

import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.Lifecycle.State;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.coroutines.Job;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "source", "Landroidx/lifecycle/LifecycleOwner;", "<anonymous parameter 1>", "Landroidx/lifecycle/Lifecycle$Event;", "onStateChanged"}, k = 3, mv = {1, 4, 1})
/* compiled from: LifecycleController.kt */
public final class LifecycleController$observer$1 implements LifecycleEventObserver {
    public final /* synthetic */ Job $parentJob;
    public final /* synthetic */ LifecycleController this$0;

    public LifecycleController$observer$1(LifecycleController lifecycleController, Job job) {
        this.this$0 = lifecycleController;
        this.$parentJob = job;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, DefaultSettingsSpiCall.SOURCE_PARAM);
        Intrinsics.checkNotNullParameter(event, "<anonymous parameter 1>");
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "source.lifecycle");
        if (((LifecycleRegistry) lifecycle).mState == State.DESTROYED) {
            LifecycleController lifecycleController = this.this$0;
            TypeUtilsKt.cancel$default(this.$parentJob, (CancellationException) null, 1, (Object) null);
            lifecycleController.finish();
            return;
        }
        Lifecycle lifecycle2 = lifecycleOwner.getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle2, "source.lifecycle");
        if (((LifecycleRegistry) lifecycle2).mState.compareTo(this.this$0.minState) < 0) {
            this.this$0.dispatchQueue.paused = true;
            return;
        }
        DispatchQueue dispatchQueue = this.this$0.dispatchQueue;
        if (dispatchQueue.paused) {
            if (!dispatchQueue.finished) {
                dispatchQueue.paused = false;
                dispatchQueue.drainQueue();
                return;
            }
            throw new IllegalStateException("Cannot resume a finished dispatcher".toString());
        }
    }
}
