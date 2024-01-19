package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsLoader;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker.DO_NOTHING;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolverImpl;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoaderImpl;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer.Companion;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration.Default;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedClassDataFinder;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer.ThrowException;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.LocalClassifierTypeSettings;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: BuiltInsLoaderImpl.kt */
public final class BuiltInsLoaderImpl implements BuiltInsLoader {
    public final BuiltInsResourceLoader resourceLoader = new BuiltInsResourceLoader();

    public PackageFragmentProvider createPackageFragmentProvider(StorageManager storageManager, ModuleDescriptor moduleDescriptor, Iterable<? extends ClassDescriptorFactory> iterable, PlatformDependentDeclarationFilter platformDependentDeclarationFilter, AdditionalClassPartsProvider additionalClassPartsProvider, boolean z) {
        StorageManager storageManager2 = storageManager;
        ModuleDescriptor moduleDescriptor2 = moduleDescriptor;
        Iterable<? extends ClassDescriptorFactory> iterable2 = iterable;
        PlatformDependentDeclarationFilter platformDependentDeclarationFilter2 = platformDependentDeclarationFilter;
        AdditionalClassPartsProvider additionalClassPartsProvider2 = additionalClassPartsProvider;
        Intrinsics.checkNotNullParameter(storageManager2, "storageManager");
        Intrinsics.checkNotNullParameter(moduleDescriptor2, "builtInsModule");
        Intrinsics.checkNotNullParameter(iterable2, "classDescriptorFactories");
        Intrinsics.checkNotNullParameter(platformDependentDeclarationFilter2, "platformDependentDeclarationFilter");
        Intrinsics.checkNotNullParameter(additionalClassPartsProvider2, "additionalClassPartsProvider");
        Set<FqName> set = StandardNames.BUILT_INS_PACKAGE_FQ_NAMES;
        BuiltInsLoaderImpl$createPackageFragmentProvider$1 builtInsLoaderImpl$createPackageFragmentProvider$1 = new BuiltInsLoaderImpl$createPackageFragmentProvider$1(this.resourceLoader);
        Intrinsics.checkNotNullParameter(storageManager2, "storageManager");
        Intrinsics.checkNotNullParameter(moduleDescriptor2, "module");
        Intrinsics.checkNotNullParameter(set, "packageFqNames");
        Intrinsics.checkNotNullParameter(iterable2, "classDescriptorFactories");
        Intrinsics.checkNotNullParameter(platformDependentDeclarationFilter2, "platformDependentDeclarationFilter");
        Intrinsics.checkNotNullParameter(additionalClassPartsProvider2, "additionalClassPartsProvider");
        Intrinsics.checkNotNullParameter(builtInsLoaderImpl$createPackageFragmentProvider$1, "loadResource");
        ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(set, 10));
        for (FqName fqName : set) {
            String builtInsFilePath = BuiltInSerializerProtocol.INSTANCE.getBuiltInsFilePath(fqName);
            InputStream inputStream = (InputStream) builtInsLoaderImpl$createPackageFragmentProvider$1.invoke(builtInsFilePath);
            if (inputStream != null) {
                arrayList.add(BuiltInsPackageFragmentImpl.create(fqName, storageManager2, moduleDescriptor2, inputStream, z));
            } else {
                throw new IllegalStateException(Intrinsics.stringPlus("Resource not found in classpath: ", builtInsFilePath));
            }
        }
        PackageFragmentProviderImpl packageFragmentProviderImpl = new PackageFragmentProviderImpl(arrayList);
        NotFoundClasses notFoundClasses = new NotFoundClasses(storageManager2, moduleDescriptor2);
        Default defaultR = Default.INSTANCE;
        DeserializedClassDataFinder deserializedClassDataFinder = new DeserializedClassDataFinder(packageFragmentProviderImpl);
        AnnotationAndConstantLoaderImpl annotationAndConstantLoaderImpl = new AnnotationAndConstantLoaderImpl(moduleDescriptor2, notFoundClasses, BuiltInSerializerProtocol.INSTANCE);
        LocalClassifierTypeSettings.Default defaultR2 = LocalClassifierTypeSettings.Default.INSTANCE;
        ErrorReporter errorReporter = ErrorReporter.DO_NOTHING;
        Intrinsics.checkNotNullExpressionValue(errorReporter, "DO_NOTHING");
        DO_NOTHING do_nothing = DO_NOTHING.INSTANCE;
        ThrowException throwException = ThrowException.INSTANCE;
        if (ContractDeserializer.Companion != null) {
            ContractDeserializer contractDeserializer = Companion.DEFAULT;
            ExtensionRegistryLite extensionRegistryLite = BuiltInSerializerProtocol.INSTANCE.extensionRegistry;
            SamConversionResolverImpl samConversionResolverImpl = r0;
            SamConversionResolverImpl samConversionResolverImpl2 = new SamConversionResolverImpl(storageManager2, EmptyList.INSTANCE);
            ErrorReporter errorReporter2 = errorReporter;
            PackageFragmentProviderImpl packageFragmentProviderImpl2 = packageFragmentProviderImpl;
            DeserializationComponents deserializationComponents = r0;
            LocalClassifierTypeSettings.Default defaultR3 = defaultR2;
            NotFoundClasses notFoundClasses2 = notFoundClasses;
            ErrorReporter errorReporter3 = errorReporter2;
            PackageFragmentProviderImpl packageFragmentProviderImpl3 = packageFragmentProviderImpl;
            DO_NOTHING do_nothing2 = do_nothing;
            DeserializationComponents deserializationComponents2 = new DeserializationComponents(storageManager, moduleDescriptor, defaultR, deserializedClassDataFinder, annotationAndConstantLoaderImpl, packageFragmentProviderImpl2, defaultR3, errorReporter3, do_nothing2, throwException, iterable, notFoundClasses2, contractDeserializer, additionalClassPartsProvider, platformDependentDeclarationFilter, extensionRegistryLite, null, samConversionResolverImpl, null, 327680);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((BuiltInsPackageFragmentImpl) it.next()).initialize(deserializationComponents);
            }
            return packageFragmentProviderImpl3;
        }
        throw null;
    }
}
