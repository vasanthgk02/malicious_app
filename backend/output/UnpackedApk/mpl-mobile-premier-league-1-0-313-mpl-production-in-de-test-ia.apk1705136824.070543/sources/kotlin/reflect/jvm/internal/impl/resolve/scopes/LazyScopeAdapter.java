package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: LazyScopeAdapter.kt */
public final class LazyScopeAdapter extends AbstractScopeAdapter {
    public final NotNullLazyValue<MemberScope> lazyScope;

    public LazyScopeAdapter(StorageManager storageManager, Function0<? extends MemberScope> function0) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(function0, "getScope");
        this.lazyScope = storageManager.createLazyValue(new LazyScopeAdapter$lazyScope$1(function0));
    }

    public MemberScope getWorkerScope() {
        return (MemberScope) this.lazyScope.invoke();
    }
}
