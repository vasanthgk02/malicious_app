package androidx.lifecycle;

import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.Lifecycle.State;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import in.juspay.hypersdk.core.PaymentConstants.LogCategory;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0006\u0010\u0012\u001a\u00020\rR\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Landroidx/lifecycle/LifecycleCoroutineScopeImpl;", "Landroidx/lifecycle/LifecycleCoroutineScope;", "Landroidx/lifecycle/LifecycleEventObserver;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroidx/lifecycle/Lifecycle;Lkotlin/coroutines/CoroutineContext;)V", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "getLifecycle$lifecycle_runtime_ktx_release", "()Landroidx/lifecycle/Lifecycle;", "onStateChanged", "", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "register", "lifecycle-runtime-ktx_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: Lifecycle.kt */
public final class LifecycleCoroutineScopeImpl extends LifecycleCoroutineScope implements LifecycleEventObserver {
    public final CoroutineContext coroutineContext;
    public final Lifecycle lifecycle;

    public LifecycleCoroutineScopeImpl(Lifecycle lifecycle2, CoroutineContext coroutineContext2) {
        Intrinsics.checkNotNullParameter(lifecycle2, LogCategory.LIFECYCLE);
        Intrinsics.checkNotNullParameter(coroutineContext2, "coroutineContext");
        this.lifecycle = lifecycle2;
        this.coroutineContext = coroutineContext2;
        if (((LifecycleRegistry) lifecycle2).mState == State.DESTROYED) {
            TypeUtilsKt.cancel$default(coroutineContext2, (CancellationException) null, 1, (Object) null);
        }
    }

    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, DefaultSettingsSpiCall.SOURCE_PARAM);
        Intrinsics.checkNotNullParameter(event, "event");
        if (((LifecycleRegistry) this.lifecycle).mState.compareTo(State.DESTROYED) <= 0) {
            LifecycleRegistry lifecycleRegistry = (LifecycleRegistry) this.lifecycle;
            lifecycleRegistry.enforceMainThreadIfNeeded("removeObserver");
            lifecycleRegistry.mObserverMap.remove(this);
            TypeUtilsKt.cancel$default(this.coroutineContext, (CancellationException) null, 1, (Object) null);
        }
    }
}