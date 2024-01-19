package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: LazyScopeAdapter.kt */
public final class LazyScopeAdapter$lazyScope$1 extends Lambda implements Function0<MemberScope> {
    public final /* synthetic */ Function0<MemberScope> $getScope;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public LazyScopeAdapter$lazyScope$1(Function0<? extends MemberScope> function0) {
        // this.$getScope = function0;
        super(0);
    }

    public Object invoke() {
        MemberScope memberScope = (MemberScope) this.$getScope.invoke();
        return memberScope instanceof AbstractScopeAdapter ? ((AbstractScopeAdapter) memberScope).getActualScope() : memberScope;
    }
}
