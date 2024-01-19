package androidx.lifecycle;

import in.juspay.hypersdk.core.PaymentConstants.LogCategory;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext.Element.DefaultImpls;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.internal.MainDispatcherLoader;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"lifecycleScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "Landroidx/lifecycle/LifecycleOwner;", "getLifecycleScope", "(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;", "lifecycle-runtime-ktx_release"}, k = 2, mv = {1, 4, 1})
/* compiled from: LifecycleOwner.kt */
public final class LifecycleOwnerKt {
    public static final LifecycleCoroutineScope getLifecycleScope(LifecycleOwner lifecycleOwner) {
        LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl;
        Intrinsics.checkNotNullParameter(lifecycleOwner, "$this$lifecycleScope");
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, LogCategory.LIFECYCLE);
        Intrinsics.checkNotNullParameter(lifecycle, "$this$coroutineScope");
        while (true) {
            lifecycleCoroutineScopeImpl = (LifecycleCoroutineScopeImpl) lifecycle.mInternalScopeRef.get();
            if (lifecycleCoroutineScopeImpl == null) {
                lifecycleCoroutineScopeImpl = new LifecycleCoroutineScopeImpl(lifecycle, DefaultImpls.plus((JobSupport) TypeUtilsKt.SupervisorJob$default(null, 1), Dispatchers.getMain().getImmediate()));
                if (lifecycle.mInternalScopeRef.compareAndSet(null, lifecycleCoroutineScopeImpl)) {
                    TypeUtilsKt.launch$default(lifecycleCoroutineScopeImpl, MainDispatcherLoader.dispatcher.getImmediate(), null, new LifecycleCoroutineScopeImpl$register$1(lifecycleCoroutineScopeImpl, null), 2, null);
                    break;
                }
            } else {
                break;
            }
        }
        return lifecycleCoroutineScopeImpl;
    }
}
