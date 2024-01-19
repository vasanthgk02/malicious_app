package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider.None;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter.All;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentTypeTransformer;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker.Companion;

/* compiled from: context.kt */
public final class DeserializationComponents {
    public final AdditionalClassPartsProvider additionalClassPartsProvider;
    public final AnnotationAndConstantLoader<AnnotationDescriptor, ConstantValue<?>> annotationAndConstantLoader;
    public final ClassDataFinder classDataFinder;
    public final ClassDeserializer classDeserializer;
    public final DeserializationConfiguration configuration;
    public final ContractDeserializer contractDeserializer;
    public final ErrorReporter errorReporter;
    public final ExtensionRegistryLite extensionRegistryLite;
    public final Iterable<ClassDescriptorFactory> fictitiousClassDescriptorFactories;
    public final FlexibleTypeDeserializer flexibleTypeDeserializer;
    public final NewKotlinTypeChecker kotlinTypeChecker;
    public final LocalClassifierTypeSettings localClassifierTypeSettings;
    public final LookupTracker lookupTracker;
    public final ModuleDescriptor moduleDescriptor;
    public final NotFoundClasses notFoundClasses;
    public final PackageFragmentProvider packageFragmentProvider;
    public final PlatformDependentDeclarationFilter platformDependentDeclarationFilter;
    public final PlatformDependentTypeTransformer platformDependentTypeTransformer;
    public final StorageManager storageManager;

    public DeserializationComponents(StorageManager storageManager2, ModuleDescriptor moduleDescriptor2, DeserializationConfiguration deserializationConfiguration, ClassDataFinder classDataFinder2, AnnotationAndConstantLoader annotationAndConstantLoader2, PackageFragmentProvider packageFragmentProvider2, LocalClassifierTypeSettings localClassifierTypeSettings2, ErrorReporter errorReporter2, LookupTracker lookupTracker2, FlexibleTypeDeserializer flexibleTypeDeserializer2, Iterable iterable, NotFoundClasses notFoundClasses2, ContractDeserializer contractDeserializer2, AdditionalClassPartsProvider additionalClassPartsProvider2, PlatformDependentDeclarationFilter platformDependentDeclarationFilter2, ExtensionRegistryLite extensionRegistryLite2, NewKotlinTypeChecker newKotlinTypeChecker, SamConversionResolver samConversionResolver, PlatformDependentTypeTransformer platformDependentTypeTransformer2, int i) {
        NewKotlinTypeChecker newKotlinTypeChecker2;
        StorageManager storageManager3 = storageManager2;
        ModuleDescriptor moduleDescriptor3 = moduleDescriptor2;
        DeserializationConfiguration deserializationConfiguration2 = deserializationConfiguration;
        ClassDataFinder classDataFinder3 = classDataFinder2;
        AnnotationAndConstantLoader annotationAndConstantLoader3 = annotationAndConstantLoader2;
        PackageFragmentProvider packageFragmentProvider3 = packageFragmentProvider2;
        LocalClassifierTypeSettings localClassifierTypeSettings3 = localClassifierTypeSettings2;
        ErrorReporter errorReporter3 = errorReporter2;
        LookupTracker lookupTracker3 = lookupTracker2;
        FlexibleTypeDeserializer flexibleTypeDeserializer3 = flexibleTypeDeserializer2;
        Iterable iterable2 = iterable;
        NotFoundClasses notFoundClasses3 = notFoundClasses2;
        ContractDeserializer contractDeserializer3 = contractDeserializer2;
        ExtensionRegistryLite extensionRegistryLite3 = extensionRegistryLite2;
        int i2 = i;
        AdditionalClassPartsProvider additionalClassPartsProvider3 = (i2 & 8192) != 0 ? None.INSTANCE : additionalClassPartsProvider2;
        PlatformDependentDeclarationFilter platformDependentDeclarationFilter3 = (i2 & 16384) != 0 ? All.INSTANCE : platformDependentDeclarationFilter2;
        PlatformDependentTypeTransformer.None none = null;
        if ((i2 & 65536) == 0) {
            newKotlinTypeChecker2 = newKotlinTypeChecker;
        } else if (NewKotlinTypeChecker.Companion != null) {
            newKotlinTypeChecker2 = Companion.Default;
        } else {
            throw null;
        }
        PlatformDependentTypeTransformer.None none2 = (i2 & 262144) != 0 ? PlatformDependentTypeTransformer.None.INSTANCE : none;
        Intrinsics.checkNotNullParameter(storageManager3, "storageManager");
        Intrinsics.checkNotNullParameter(moduleDescriptor3, "moduleDescriptor");
        Intrinsics.checkNotNullParameter(deserializationConfiguration2, "configuration");
        Intrinsics.checkNotNullParameter(classDataFinder3, "classDataFinder");
        Intrinsics.checkNotNullParameter(annotationAndConstantLoader3, "annotationAndConstantLoader");
        Intrinsics.checkNotNullParameter(packageFragmentProvider3, "packageFragmentProvider");
        Intrinsics.checkNotNullParameter(localClassifierTypeSettings3, "localClassifierTypeSettings");
        Intrinsics.checkNotNullParameter(errorReporter3, "errorReporter");
        Intrinsics.checkNotNullParameter(lookupTracker3, "lookupTracker");
        Intrinsics.checkNotNullParameter(flexibleTypeDeserializer3, "flexibleTypeDeserializer");
        Intrinsics.checkNotNullParameter(iterable2, "fictitiousClassDescriptorFactories");
        Intrinsics.checkNotNullParameter(notFoundClasses3, "notFoundClasses");
        Intrinsics.checkNotNullParameter(contractDeserializer3, "contractDeserializer");
        Intrinsics.checkNotNullParameter(additionalClassPartsProvider3, "additionalClassPartsProvider");
        Intrinsics.checkNotNullParameter(platformDependentDeclarationFilter3, "platformDependentDeclarationFilter");
        PlatformDependentDeclarationFilter platformDependentDeclarationFilter4 = platformDependentDeclarationFilter3;
        Intrinsics.checkNotNullParameter(extensionRegistryLite2, "extensionRegistryLite");
        Intrinsics.checkNotNullParameter(newKotlinTypeChecker2, "kotlinTypeChecker");
        Intrinsics.checkNotNullParameter(samConversionResolver, "samConversionResolver");
        PlatformDependentTypeTransformer.None none3 = none2;
        Intrinsics.checkNotNullParameter(none3, "platformDependentTypeTransformer");
        this.storageManager = storageManager3;
        this.moduleDescriptor = moduleDescriptor3;
        this.configuration = deserializationConfiguration2;
        this.classDataFinder = classDataFinder3;
        this.annotationAndConstantLoader = annotationAndConstantLoader3;
        this.packageFragmentProvider = packageFragmentProvider3;
        this.localClassifierTypeSettings = localClassifierTypeSettings3;
        this.errorReporter = errorReporter3;
        this.lookupTracker = lookupTracker3;
        this.flexibleTypeDeserializer = flexibleTypeDeserializer3;
        this.fictitiousClassDescriptorFactories = iterable2;
        this.notFoundClasses = notFoundClasses3;
        this.contractDeserializer = contractDeserializer3;
        this.additionalClassPartsProvider = additionalClassPartsProvider3;
        this.platformDependentDeclarationFilter = platformDependentDeclarationFilter4;
        this.extensionRegistryLite = extensionRegistryLite2;
        this.kotlinTypeChecker = newKotlinTypeChecker2;
        this.platformDependentTypeTransformer = none3;
        this.classDeserializer = new ClassDeserializer(this);
    }

    public final DeserializationContext createContext(PackageFragmentDescriptor packageFragmentDescriptor, NameResolver nameResolver, TypeTable typeTable, VersionRequirementTable versionRequirementTable, BinaryVersion binaryVersion, DeserializedContainerSource deserializedContainerSource) {
        Intrinsics.checkNotNullParameter(packageFragmentDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        Intrinsics.checkNotNullParameter(versionRequirementTable, "versionRequirementTable");
        BinaryVersion binaryVersion2 = binaryVersion;
        Intrinsics.checkNotNullParameter(binaryVersion2, "metadataVersion");
        DeserializationContext deserializationContext = new DeserializationContext(this, nameResolver, packageFragmentDescriptor, typeTable, versionRequirementTable, binaryVersion2, deserializedContainerSource, null, EmptyList.INSTANCE);
        return deserializationContext;
    }

    public final ClassDescriptor deserializeClass(ClassId classId) {
        Intrinsics.checkNotNullParameter(classId, "classId");
        return ClassDeserializer.deserializeClass$default(this.classDeserializer, classId, null, 2);
    }
}
