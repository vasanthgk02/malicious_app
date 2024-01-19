package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: LazyJavaScope.kt */
public final class LazyJavaScope$declaredMemberIndex$1 extends Lambda implements Function0<DeclaredMemberIndex> {
    public final /* synthetic */ LazyJavaScope this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public LazyJavaScope$declaredMemberIndex$1(LazyJavaScope lazyJavaScope) {
        // this.this$0 = lazyJavaScope;
        super(0);
    }

    public Object invoke() {
        return this.this$0.computeMemberIndex();
    }
}
