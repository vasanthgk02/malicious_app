package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;

/* compiled from: LazyJavaScope.kt */
public final class LazyJavaScope$propertyNamesLazy$2 extends Lambda implements Function0<Set<? extends Name>> {
    public final /* synthetic */ LazyJavaScope this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public LazyJavaScope$propertyNamesLazy$2(LazyJavaScope lazyJavaScope) {
        // this.this$0 = lazyJavaScope;
        super(0);
    }

    public Object invoke() {
        return this.this$0.computePropertyNames(DescriptorKindFilter.VARIABLES, null);
    }
}
