package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: PackageFragmentProviderImpl.kt */
public final class PackageFragmentProviderImpl$getSubPackagesOf$1 extends Lambda implements Function1<PackageFragmentDescriptor, FqName> {
    public static final PackageFragmentProviderImpl$getSubPackagesOf$1 INSTANCE = new PackageFragmentProviderImpl$getSubPackagesOf$1();

    public PackageFragmentProviderImpl$getSubPackagesOf$1() {
        super(1);
    }

    public Object invoke(Object obj) {
        PackageFragmentDescriptor packageFragmentDescriptor = (PackageFragmentDescriptor) obj;
        Intrinsics.checkNotNullParameter(packageFragmentDescriptor, "it");
        return packageFragmentDescriptor.getFqName();
    }
}
