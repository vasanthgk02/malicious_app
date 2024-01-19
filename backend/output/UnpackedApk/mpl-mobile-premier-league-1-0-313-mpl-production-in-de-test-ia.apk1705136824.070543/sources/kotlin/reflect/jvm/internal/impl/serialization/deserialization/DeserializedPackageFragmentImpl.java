package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolverImpl;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPackageMemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: DeserializedPackageFragmentImpl.kt */
public abstract class DeserializedPackageFragmentImpl extends DeserializedPackageFragment {
    public MemberScope _memberScope;
    public ProtoBuf$PackageFragment _proto;
    public final ProtoBasedClassDataFinder classDataFinder;
    public final DeserializedContainerSource containerSource = null;
    public final BinaryVersion metadataVersion;
    public final NameResolverImpl nameResolver;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DeserializedPackageFragmentImpl(FqName fqName, StorageManager storageManager, ModuleDescriptor moduleDescriptor, ProtoBuf$PackageFragment protoBuf$PackageFragment, BinaryVersion binaryVersion, DeserializedContainerSource deserializedContainerSource) {
        // Intrinsics.checkNotNullParameter(fqName, "fqName");
        // Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        // Intrinsics.checkNotNullParameter(moduleDescriptor, "module");
        // Intrinsics.checkNotNullParameter(protoBuf$PackageFragment, "proto");
        // Intrinsics.checkNotNullParameter(binaryVersion, "metadataVersion");
        super(fqName, storageManager, moduleDescriptor);
        this.metadataVersion = binaryVersion;
        ProtoBuf$StringTable protoBuf$StringTable = protoBuf$PackageFragment.strings_;
        Intrinsics.checkNotNullExpressionValue(protoBuf$StringTable, "proto.strings");
        ProtoBuf$QualifiedNameTable protoBuf$QualifiedNameTable = protoBuf$PackageFragment.qualifiedNames_;
        Intrinsics.checkNotNullExpressionValue(protoBuf$QualifiedNameTable, "proto.qualifiedNames");
        NameResolverImpl nameResolverImpl = new NameResolverImpl(protoBuf$StringTable, protoBuf$QualifiedNameTable);
        this.nameResolver = nameResolverImpl;
        this.classDataFinder = new ProtoBasedClassDataFinder(protoBuf$PackageFragment, nameResolverImpl, this.metadataVersion, new DeserializedPackageFragmentImpl$classDataFinder$1(this));
        this._proto = protoBuf$PackageFragment;
    }

    public MemberScope getMemberScope() {
        MemberScope memberScope = this._memberScope;
        if (memberScope != null) {
            return memberScope;
        }
        Intrinsics.throwUninitializedPropertyAccessException("_memberScope");
        throw null;
    }

    public void initialize(DeserializationComponents deserializationComponents) {
        Intrinsics.checkNotNullParameter(deserializationComponents, "components");
        ProtoBuf$PackageFragment protoBuf$PackageFragment = this._proto;
        if (protoBuf$PackageFragment != null) {
            this._proto = null;
            ProtoBuf$Package protoBuf$Package = protoBuf$PackageFragment.package_;
            Intrinsics.checkNotNullExpressionValue(protoBuf$Package, "proto.`package`");
            DeserializedPackageMemberScope deserializedPackageMemberScope = new DeserializedPackageMemberScope(this, protoBuf$Package, this.nameResolver, this.metadataVersion, this.containerSource, deserializationComponents, new DeserializedPackageFragmentImpl$initialize$1(this));
            this._memberScope = deserializedPackageMemberScope;
            return;
        }
        throw new IllegalStateException("Repeated call to DeserializedPackageFragmentImpl::initialize".toString());
    }
}
