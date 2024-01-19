package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EmptyPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: NotFoundClasses.kt */
public final class NotFoundClasses$packageFragments$1 extends Lambda implements Function1<FqName, PackageFragmentDescriptor> {
    public final /* synthetic */ NotFoundClasses this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public NotFoundClasses$packageFragments$1(NotFoundClasses notFoundClasses) {
        // this.this$0 = notFoundClasses;
        super(1);
    }

    public Object invoke(Object obj) {
        FqName fqName = (FqName) obj;
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        return new EmptyPackageFragmentDescriptor(this.this$0.module, fqName);
    }
}
