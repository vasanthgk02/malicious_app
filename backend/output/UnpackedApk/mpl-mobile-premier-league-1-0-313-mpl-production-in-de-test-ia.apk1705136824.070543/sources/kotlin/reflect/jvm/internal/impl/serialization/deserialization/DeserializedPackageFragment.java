package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: DeserializedPackageFragment.kt */
public abstract class DeserializedPackageFragment extends PackageFragmentDescriptorImpl {
    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DeserializedPackageFragment(FqName fqName, StorageManager storageManager, ModuleDescriptor moduleDescriptor) {
        // Intrinsics.checkNotNullParameter(fqName, "fqName");
        // Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        // Intrinsics.checkNotNullParameter(moduleDescriptor, "module");
        super(moduleDescriptor, fqName);
    }

    public abstract void initialize(DeserializationComponents deserializationComponents);
}
