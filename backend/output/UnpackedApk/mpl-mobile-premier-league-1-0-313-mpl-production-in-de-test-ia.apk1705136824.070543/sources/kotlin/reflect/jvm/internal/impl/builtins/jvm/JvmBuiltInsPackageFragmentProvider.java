package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.functions.BuiltInFictitiousFunctionClassFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker.DO_NOTHING;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AbstractDeserializedPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoaderImpl;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer.Companion;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedClassDataFinder;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer.ThrowException;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.LocalClassifierTypeSettings.Default;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInSerializerProtocol;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;

/* compiled from: JvmBuiltInsPackageFragmentProvider.kt */
public final class JvmBuiltInsPackageFragmentProvider extends AbstractDeserializedPackageFragmentProvider {
    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public JvmBuiltInsPackageFragmentProvider(StorageManager storageManager, KotlinClassFinder kotlinClassFinder, ModuleDescriptor moduleDescriptor, NotFoundClasses notFoundClasses, AdditionalClassPartsProvider additionalClassPartsProvider, PlatformDependentDeclarationFilter platformDependentDeclarationFilter, DeserializationConfiguration deserializationConfiguration, NewKotlinTypeChecker newKotlinTypeChecker, SamConversionResolver samConversionResolver) {
        // StorageManager storageManager2 = storageManager;
        // ModuleDescriptor moduleDescriptor2 = moduleDescriptor;
        // NotFoundClasses notFoundClasses2 = notFoundClasses;
        // Intrinsics.checkNotNullParameter(storageManager2, "storageManager");
        // Intrinsics.checkNotNullParameter(kotlinClassFinder, "finder");
        // Intrinsics.checkNotNullParameter(moduleDescriptor2, "moduleDescriptor");
        // Intrinsics.checkNotNullParameter(notFoundClasses2, "notFoundClasses");
        // Intrinsics.checkNotNullParameter(additionalClassPartsProvider, "additionalClassPartsProvider");
        // Intrinsics.checkNotNullParameter(platformDependentDeclarationFilter, "platformDependentDeclarationFilter");
        // Intrinsics.checkNotNullParameter(deserializationConfiguration, "deserializationConfiguration");
        // Intrinsics.checkNotNullParameter(newKotlinTypeChecker, "kotlinTypeChecker");
        // Intrinsics.checkNotNullParameter(samConversionResolver, "samConversionResolver");
        super(storageManager, kotlinClassFinder, moduleDescriptor);
        DeserializedClassDataFinder deserializedClassDataFinder = new DeserializedClassDataFinder(this);
        AnnotationAndConstantLoaderImpl annotationAndConstantLoaderImpl = new AnnotationAndConstantLoaderImpl(moduleDescriptor2, notFoundClasses2, BuiltInSerializerProtocol.INSTANCE);
        Default defaultR = Default.INSTANCE;
        ErrorReporter errorReporter = ErrorReporter.DO_NOTHING;
        Intrinsics.checkNotNullExpressionValue(errorReporter, "DO_NOTHING");
        DO_NOTHING do_nothing = DO_NOTHING.INSTANCE;
        ThrowException throwException = ThrowException.INSTANCE;
        ErrorReporter errorReporter2 = errorReporter;
        List listOf = TweetUtils.listOf((T[]) new ClassDescriptorFactory[]{new BuiltInFictitiousFunctionClassFactory(storageManager2, moduleDescriptor2), new JvmBuiltInClassDescriptorFactory(storageManager2, moduleDescriptor2, null, 4)});
        if (ContractDeserializer.Companion != null) {
            DeserializationComponents deserializationComponents = r0;
            DeserializationComponents deserializationComponents2 = new DeserializationComponents(storageManager, moduleDescriptor, deserializationConfiguration, deserializedClassDataFinder, annotationAndConstantLoaderImpl, this, defaultR, errorReporter2, do_nothing, throwException, listOf, notFoundClasses, Companion.DEFAULT, additionalClassPartsProvider, platformDependentDeclarationFilter, BuiltInSerializerProtocol.INSTANCE.extensionRegistry, newKotlinTypeChecker, samConversionResolver, null, 262144);
            DeserializationComponents deserializationComponents3 = deserializationComponents;
            Intrinsics.checkNotNullParameter(deserializationComponents3, "<set-?>");
            this.components = deserializationComponents3;
            return;
        }
        throw null;
    }
}
