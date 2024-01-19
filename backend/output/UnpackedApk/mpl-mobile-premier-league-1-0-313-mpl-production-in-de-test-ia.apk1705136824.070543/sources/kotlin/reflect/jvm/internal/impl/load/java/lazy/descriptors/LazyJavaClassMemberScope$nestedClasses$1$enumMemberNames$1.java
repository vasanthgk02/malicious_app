package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Set;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: LazyJavaClassMemberScope.kt */
public final class LazyJavaClassMemberScope$nestedClasses$1$enumMemberNames$1 extends Lambda implements Function0<Set<? extends Name>> {
    public final /* synthetic */ LazyJavaClassMemberScope this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public LazyJavaClassMemberScope$nestedClasses$1$enumMemberNames$1(LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        // this.this$0 = lazyJavaClassMemberScope;
        super(0);
    }

    public Object invoke() {
        return ArraysKt___ArraysJvmKt.plus(this.this$0.getFunctionNames(), (Iterable<? extends T>) this.this$0.getVariableNames());
    }
}
