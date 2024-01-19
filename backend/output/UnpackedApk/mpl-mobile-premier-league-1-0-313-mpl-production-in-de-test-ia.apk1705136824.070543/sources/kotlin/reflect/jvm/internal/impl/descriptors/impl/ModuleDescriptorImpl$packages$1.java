package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: ModuleDescriptorImpl.kt */
public final class ModuleDescriptorImpl$packages$1 extends Lambda implements Function1<FqName, PackageViewDescriptor> {
    public final /* synthetic */ ModuleDescriptorImpl this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ModuleDescriptorImpl$packages$1(ModuleDescriptorImpl moduleDescriptorImpl) {
        // this.this$0 = moduleDescriptorImpl;
        super(1);
    }

    public Object invoke(Object obj) {
        FqName fqName = (FqName) obj;
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        ModuleDescriptorImpl moduleDescriptorImpl = this.this$0;
        return new LazyPackageViewDescriptorImpl(moduleDescriptorImpl, fqName, moduleDescriptorImpl.storageManager);
    }
}
