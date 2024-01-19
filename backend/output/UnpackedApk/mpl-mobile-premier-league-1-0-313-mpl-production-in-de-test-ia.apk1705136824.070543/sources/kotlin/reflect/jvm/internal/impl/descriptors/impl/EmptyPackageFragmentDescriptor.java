package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Empty;

/* compiled from: EmptyPackageFragmentDesciptor.kt */
public final class EmptyPackageFragmentDescriptor extends PackageFragmentDescriptorImpl {
    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public EmptyPackageFragmentDescriptor(ModuleDescriptor moduleDescriptor, FqName fqName) {
        // Intrinsics.checkNotNullParameter(moduleDescriptor, "module");
        // Intrinsics.checkNotNullParameter(fqName, "fqName");
        super(moduleDescriptor, fqName);
    }

    public MemberScope getMemberScope() {
        return Empty.INSTANCE;
    }
}
