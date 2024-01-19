package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;

/* compiled from: LazyJavaPackageScope.kt */
public final class LazyJavaPackageScope$knownClassNamesInPackage$1 extends Lambda implements Function0<Set<? extends String>> {
    public final /* synthetic */ LazyJavaResolverContext $c;
    public final /* synthetic */ LazyJavaPackageScope this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public LazyJavaPackageScope$knownClassNamesInPackage$1(LazyJavaResolverContext lazyJavaResolverContext, LazyJavaPackageScope lazyJavaPackageScope) {
        // this.$c = lazyJavaResolverContext;
        // this.this$0 = lazyJavaPackageScope;
        super(0);
    }

    public Object invoke() {
        return this.$c.components.finder.knownClassNamesInPackage(this.this$0.ownerDescriptor.fqName);
    }
}
