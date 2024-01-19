package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: PackageFragmentProviderImpl.kt */
public final class PackageFragmentProviderImpl$getSubPackagesOf$2 extends Lambda implements Function1<FqName, Boolean> {
    public final /* synthetic */ FqName $fqName;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public PackageFragmentProviderImpl$getSubPackagesOf$2(FqName fqName) {
        // this.$fqName = fqName;
        super(1);
    }

    public Object invoke(Object obj) {
        FqName fqName = (FqName) obj;
        Intrinsics.checkNotNullParameter(fqName, "it");
        return Boolean.valueOf(!fqName.isRoot() && Intrinsics.areEqual(fqName.parent(), this.$fqName));
    }
}