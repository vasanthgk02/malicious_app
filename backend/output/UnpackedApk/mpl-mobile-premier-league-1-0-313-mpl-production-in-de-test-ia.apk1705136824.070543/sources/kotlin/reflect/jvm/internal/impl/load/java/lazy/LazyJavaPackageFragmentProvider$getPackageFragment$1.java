package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;

/* compiled from: LazyJavaPackageFragmentProvider.kt */
public final class LazyJavaPackageFragmentProvider$getPackageFragment$1 extends Lambda implements Function0<LazyJavaPackageFragment> {
    public final /* synthetic */ JavaPackage $jPackage;
    public final /* synthetic */ LazyJavaPackageFragmentProvider this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public LazyJavaPackageFragmentProvider$getPackageFragment$1(LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProvider, JavaPackage javaPackage) {
        // this.this$0 = lazyJavaPackageFragmentProvider;
        // this.$jPackage = javaPackage;
        super(0);
    }

    public Object invoke() {
        return new LazyJavaPackageFragment(this.this$0.f5937c, this.$jPackage);
    }
}
