package kotlin.reflect.jvm.internal;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin._Assertions;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns$initialize$1;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns.Kind;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker.EMPTY;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider.None;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter.NoPlatformDependent;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.CompositePackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.PackagePartScopeCache;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectJavaClassFinder;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeErrorReporter;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeSourceElementFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker.DO_NOTHING;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassesTracker;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaPropertyInitializerEvaluator.DoNothing;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings.Default;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.SingleModuleClassResolver;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JavaClassDataFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JavaFlexibleTypeDeserializer;
import kotlin.reflect.jvm.internal.impl.load.kotlin.PackagePartProvider.Empty;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JavaDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolverImpl;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.LocalClassifierTypeSettings;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker.Companion;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeCheckerImpl;
import kotlin.reflect.jvm.internal.impl.utils.JavaTypeEnhancementState;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\u0010\u0010\u0007\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\bH\u0000\" \u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"moduleByClassLoader", "Ljava/util/concurrent/ConcurrentMap;", "Lkotlin/reflect/jvm/internal/WeakClassLoaderBox;", "Ljava/lang/ref/WeakReference;", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/RuntimeModuleData;", "clearModuleByClassLoaderCache", "", "getOrCreateModule", "Ljava/lang/Class;", "kotlin-reflection"}, k = 2, mv = {1, 4, 1})
/* compiled from: moduleByClassLoader.kt */
public final class ModuleByClassLoaderKt {
    public static final ConcurrentMap<WeakClassLoaderBox, WeakReference<RuntimeModuleData>> moduleByClassLoader = new ConcurrentHashMap();

    public static final RuntimeModuleData getOrCreateModule(Class<?> cls) {
        JavaResolverComponents javaResolverComponents;
        AdditionalClassPartsProvider additionalClassPartsProvider;
        PlatformDependentDeclarationFilter platformDependentDeclarationFilter;
        Intrinsics.checkNotNullParameter(cls, "$this$getOrCreateModule");
        ClassLoader safeClassLoader = ReflectClassUtilKt.getSafeClassLoader(cls);
        WeakClassLoaderBox weakClassLoaderBox = new WeakClassLoaderBox(safeClassLoader);
        WeakReference weakReference = (WeakReference) moduleByClassLoader.get(weakClassLoaderBox);
        if (weakReference != null) {
            RuntimeModuleData runtimeModuleData = (RuntimeModuleData) weakReference.get();
            if (runtimeModuleData != null) {
                Intrinsics.checkNotNullExpressionValue(runtimeModuleData, "it");
                return runtimeModuleData;
            }
            moduleByClassLoader.remove(weakClassLoaderBox, weakReference);
        }
        Intrinsics.checkNotNullParameter(safeClassLoader, "classLoader");
        LockBasedStorageManager lockBasedStorageManager = new LockBasedStorageManager("RuntimeModuleData");
        JvmBuiltIns jvmBuiltIns = new JvmBuiltIns(lockBasedStorageManager, Kind.FROM_DEPENDENCIES);
        Name special = Name.special("<runtime module for " + safeClassLoader + '>');
        Intrinsics.checkNotNullExpressionValue(special, "special(\"<runtime module for $classLoader>\")");
        ModuleDescriptorImpl moduleDescriptorImpl = new ModuleDescriptorImpl(special, lockBasedStorageManager, jvmBuiltIns, null, null, 56);
        jvmBuiltIns.storageManager.compute(new Function0<Void>(moduleDescriptorImpl) {
            public final /* synthetic */ ModuleDescriptorImpl val$module;

            {
                this.val$module = r2;
            }

            public Object invoke() {
                KotlinBuiltIns kotlinBuiltIns = KotlinBuiltIns.this;
                if (kotlinBuiltIns.builtInsModule == null) {
                    kotlinBuiltIns.builtInsModule = this.val$module;
                    return null;
                }
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Built-ins module is already set: ");
                outline73.append(KotlinBuiltIns.this.builtInsModule);
                outline73.append(" (attempting to reset to ");
                outline73.append(this.val$module);
                outline73.append(")");
                throw new AssertionError(outline73.toString());
            }
        });
        Intrinsics.checkNotNullParameter(moduleDescriptorImpl, "moduleDescriptor");
        JvmBuiltIns$initialize$1 jvmBuiltIns$initialize$1 = new JvmBuiltIns$initialize$1(moduleDescriptorImpl, true);
        Intrinsics.checkNotNullParameter(jvmBuiltIns$initialize$1, "computation");
        boolean z = jvmBuiltIns.settingsComputation == null;
        if (!_Assertions.ENABLED || z) {
            jvmBuiltIns.settingsComputation = jvmBuiltIns$initialize$1;
            ReflectKotlinClassFinder reflectKotlinClassFinder = new ReflectKotlinClassFinder(safeClassLoader);
            DeserializedDescriptorResolver deserializedDescriptorResolver = new DeserializedDescriptorResolver();
            SingleModuleClassResolver singleModuleClassResolver = new SingleModuleClassResolver();
            NotFoundClasses notFoundClasses = new NotFoundClasses(lockBasedStorageManager, moduleDescriptorImpl);
            Empty empty = Empty.INSTANCE;
            Intrinsics.checkNotNullParameter(safeClassLoader, "classLoader");
            Intrinsics.checkNotNullParameter(moduleDescriptorImpl, "module");
            Intrinsics.checkNotNullParameter(lockBasedStorageManager, "storageManager");
            Intrinsics.checkNotNullParameter(notFoundClasses, "notFoundClasses");
            Intrinsics.checkNotNullParameter(reflectKotlinClassFinder, "reflectKotlinClassFinder");
            WeakClassLoaderBox weakClassLoaderBox2 = weakClassLoaderBox;
            Intrinsics.checkNotNullParameter(deserializedDescriptorResolver, "deserializedDescriptorResolver");
            Intrinsics.checkNotNullParameter(singleModuleClassResolver, "singleModuleClassResolver");
            Intrinsics.checkNotNullParameter(empty, "packagePartProvider");
            String str = "reflectKotlinClassFinder";
            AnnotationTypeQualifierResolver annotationTypeQualifierResolver = new AnnotationTypeQualifierResolver(lockBasedStorageManager, JavaTypeEnhancementState.DISABLED_JSR_305);
            JavaTypeEnhancementState javaTypeEnhancementState = JavaTypeEnhancementState.DISABLED_JSR_305;
            String str2 = "storageManager";
            ReflectJavaClassFinder reflectJavaClassFinder = new ReflectJavaClassFinder(safeClassLoader);
            SignaturePropagator signaturePropagator = SignaturePropagator.DO_NOTHING;
            JavaResolverComponents javaResolverComponents2 = javaResolverComponents;
            Intrinsics.checkNotNullExpressionValue(signaturePropagator, "DO_NOTHING");
            RuntimeErrorReporter runtimeErrorReporter = RuntimeErrorReporter.INSTANCE;
            JavaResolverCache javaResolverCache = JavaResolverCache.EMPTY;
            String str3 = "deserializedDescriptorResolver";
            Intrinsics.checkNotNullExpressionValue(javaResolverCache, "EMPTY");
            DoNothing doNothing = DoNothing.INSTANCE;
            String str4 = "moduleDescriptor";
            JavaResolverCache javaResolverCache2 = javaResolverCache;
            SamConversionResolverImpl samConversionResolverImpl = new SamConversionResolverImpl(lockBasedStorageManager, EmptyList.INSTANCE);
            RuntimeSourceElementFactory runtimeSourceElementFactory = RuntimeSourceElementFactory.INSTANCE;
            EMPTY empty2 = EMPTY.INSTANCE;
            DO_NOTHING do_nothing = DO_NOTHING.INSTANCE;
            String str5 = "EMPTY";
            ReflectionTypes reflectionTypes = new ReflectionTypes(moduleDescriptorImpl, notFoundClasses);
            String str6 = "notFoundClasses";
            Empty empty3 = empty;
            SignatureEnhancement signatureEnhancement = new SignatureEnhancement(annotationTypeQualifierResolver, JavaTypeEnhancementState.DISABLED_JSR_305, new JavaTypeEnhancement(Default.INSTANCE));
            JavaClassesTracker.Default defaultR = JavaClassesTracker.Default.INSTANCE;
            Default defaultR2 = Default.INSTANCE;
            if (NewKotlinTypeChecker.Companion != null) {
                String str7 = str6;
                String str8 = str2;
                Empty empty4 = empty3;
                SingleModuleClassResolver singleModuleClassResolver2 = singleModuleClassResolver;
                SignaturePropagator signaturePropagator2 = signaturePropagator;
                DeserializedDescriptorResolver deserializedDescriptorResolver2 = deserializedDescriptorResolver;
                String str9 = str4;
                ModuleDescriptorImpl moduleDescriptorImpl2 = moduleDescriptorImpl;
                RuntimeSourceElementFactory runtimeSourceElementFactory2 = runtimeSourceElementFactory;
                JvmBuiltIns jvmBuiltIns2 = jvmBuiltIns;
                ReflectKotlinClassFinder reflectKotlinClassFinder2 = reflectKotlinClassFinder;
                LockBasedStorageManager lockBasedStorageManager2 = lockBasedStorageManager;
                javaResolverComponents = new JavaResolverComponents(lockBasedStorageManager, reflectJavaClassFinder, reflectKotlinClassFinder, deserializedDescriptorResolver, signaturePropagator2, runtimeErrorReporter, javaResolverCache2, doNothing, samConversionResolverImpl, runtimeSourceElementFactory2, singleModuleClassResolver2, empty4, empty2, do_nothing, moduleDescriptorImpl2, reflectionTypes, annotationTypeQualifierResolver, signatureEnhancement, defaultR, defaultR2, Companion.Default, javaTypeEnhancementState);
                LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProvider = new LazyJavaPackageFragmentProvider(javaResolverComponents);
                ModuleDescriptorImpl moduleDescriptorImpl3 = moduleDescriptorImpl2;
                Intrinsics.checkNotNullParameter(moduleDescriptorImpl3, "module");
                String str10 = str8;
                Intrinsics.checkNotNullParameter(lockBasedStorageManager2, str10);
                String str11 = str7;
                NotFoundClasses notFoundClasses2 = notFoundClasses;
                Intrinsics.checkNotNullParameter(notFoundClasses2, str11);
                Intrinsics.checkNotNullParameter(lazyJavaPackageFragmentProvider, "lazyJavaPackageFragmentProvider");
                ReflectKotlinClassFinder reflectKotlinClassFinder3 = reflectKotlinClassFinder2;
                Intrinsics.checkNotNullParameter(reflectKotlinClassFinder3, str);
                DeserializedDescriptorResolver deserializedDescriptorResolver3 = deserializedDescriptorResolver2;
                Intrinsics.checkNotNullParameter(deserializedDescriptorResolver3, str3);
                JavaClassDataFinder javaClassDataFinder = new JavaClassDataFinder(reflectKotlinClassFinder3, deserializedDescriptorResolver3);
                BinaryClassAnnotationAndConstantLoaderImpl binaryClassAnnotationAndConstantLoaderImpl = new BinaryClassAnnotationAndConstantLoaderImpl(moduleDescriptorImpl3, notFoundClasses2, lockBasedStorageManager2, reflectKotlinClassFinder3);
                DeserializationConfiguration.Default defaultR3 = DeserializationConfiguration.Default.INSTANCE;
                RuntimeErrorReporter runtimeErrorReporter2 = RuntimeErrorReporter.INSTANCE;
                DO_NOTHING do_nothing2 = DO_NOTHING.INSTANCE;
                if (ContractDeserializer.Companion != null) {
                    ContractDeserializer contractDeserializer = ContractDeserializer.Companion.DEFAULT;
                    if (NewKotlinTypeChecker.Companion != null) {
                        NewKotlinTypeCheckerImpl newKotlinTypeCheckerImpl = Companion.Default;
                        Intrinsics.checkNotNullParameter(lockBasedStorageManager2, str10);
                        Intrinsics.checkNotNullParameter(moduleDescriptorImpl3, str9);
                        Intrinsics.checkNotNullParameter(defaultR3, "configuration");
                        Intrinsics.checkNotNullParameter(javaClassDataFinder, "classDataFinder");
                        Intrinsics.checkNotNullParameter(binaryClassAnnotationAndConstantLoaderImpl, "annotationAndConstantLoader");
                        Intrinsics.checkNotNullParameter(lazyJavaPackageFragmentProvider, "packageFragmentProvider");
                        Intrinsics.checkNotNullParameter(notFoundClasses2, str11);
                        Intrinsics.checkNotNullParameter(runtimeErrorReporter2, "errorReporter");
                        Intrinsics.checkNotNullParameter(do_nothing2, "lookupTracker");
                        Intrinsics.checkNotNullParameter(contractDeserializer, "contractDeserializer");
                        Intrinsics.checkNotNullParameter(newKotlinTypeCheckerImpl, "kotlinTypeChecker");
                        KotlinBuiltIns builtIns = moduleDescriptorImpl3.getBuiltIns();
                        JvmBuiltIns jvmBuiltIns3 = builtIns instanceof JvmBuiltIns ? (JvmBuiltIns) builtIns : null;
                        LocalClassifierTypeSettings.Default defaultR4 = LocalClassifierTypeSettings.Default.INSTANCE;
                        JavaFlexibleTypeDeserializer javaFlexibleTypeDeserializer = JavaFlexibleTypeDeserializer.INSTANCE;
                        EmptyList emptyList = EmptyList.INSTANCE;
                        if (jvmBuiltIns3 == null) {
                            additionalClassPartsProvider = null;
                        } else {
                            additionalClassPartsProvider = jvmBuiltIns3.getCustomizer();
                        }
                        if (additionalClassPartsProvider == null) {
                            additionalClassPartsProvider = None.INSTANCE;
                        }
                        AdditionalClassPartsProvider additionalClassPartsProvider2 = additionalClassPartsProvider;
                        if (jvmBuiltIns3 == null) {
                            platformDependentDeclarationFilter = null;
                        } else {
                            platformDependentDeclarationFilter = jvmBuiltIns3.getCustomizer();
                        }
                        if (platformDependentDeclarationFilter == null) {
                            platformDependentDeclarationFilter = NoPlatformDependent.INSTANCE;
                        }
                        JvmProtoBufUtil jvmProtoBufUtil = JvmProtoBufUtil.INSTANCE;
                        SamConversionResolverImpl samConversionResolverImpl2 = r3;
                        SamConversionResolverImpl samConversionResolverImpl3 = new SamConversionResolverImpl(lockBasedStorageManager2, EmptyList.INSTANCE);
                        LockBasedStorageManager lockBasedStorageManager3 = lockBasedStorageManager2;
                        LockBasedStorageManager lockBasedStorageManager4 = lockBasedStorageManager2;
                        DeserializationComponents deserializationComponents = r3;
                        LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProvider2 = lazyJavaPackageFragmentProvider;
                        DeserializedDescriptorResolver deserializedDescriptorResolver4 = deserializedDescriptorResolver3;
                        ReflectKotlinClassFinder reflectKotlinClassFinder4 = reflectKotlinClassFinder3;
                        NotFoundClasses notFoundClasses3 = notFoundClasses2;
                        ModuleDescriptorImpl moduleDescriptorImpl4 = moduleDescriptorImpl3;
                        DeserializationComponents deserializationComponents2 = new DeserializationComponents(lockBasedStorageManager3, moduleDescriptorImpl3, defaultR3, javaClassDataFinder, binaryClassAnnotationAndConstantLoaderImpl, lazyJavaPackageFragmentProvider, defaultR4, runtimeErrorReporter2, do_nothing2, javaFlexibleTypeDeserializer, emptyList, notFoundClasses3, contractDeserializer, additionalClassPartsProvider2, platformDependentDeclarationFilter, JvmProtoBufUtil.EXTENSION_REGISTRY, newKotlinTypeCheckerImpl, samConversionResolverImpl2, null, 262144);
                        Intrinsics.checkNotNullParameter(deserializationComponents, "<set-?>");
                        deserializedDescriptorResolver4.components = deserializationComponents;
                        JavaResolverCache javaResolverCache3 = JavaResolverCache.EMPTY;
                        Intrinsics.checkNotNullExpressionValue(javaResolverCache3, str5);
                        JavaDescriptorResolver javaDescriptorResolver = new JavaDescriptorResolver(lazyJavaPackageFragmentProvider2, javaResolverCache3);
                        Intrinsics.checkNotNullParameter(javaDescriptorResolver, "<set-?>");
                        singleModuleClassResolver2.resolver = javaDescriptorResolver;
                        ClassLoader classLoader = Unit.class.getClassLoader();
                        Intrinsics.checkNotNullExpressionValue(classLoader, "stdlibClassLoader");
                        ReflectKotlinClassFinder reflectKotlinClassFinder5 = new ReflectKotlinClassFinder(classLoader);
                        JvmBuiltInsCustomizer customizer = jvmBuiltIns2.getCustomizer();
                        JvmBuiltInsCustomizer customizer2 = jvmBuiltIns2.getCustomizer();
                        DeserializationConfiguration.Default defaultR5 = DeserializationConfiguration.Default.INSTANCE;
                        if (NewKotlinTypeChecker.Companion != null) {
                            LockBasedStorageManager lockBasedStorageManager5 = lockBasedStorageManager4;
                            JvmBuiltInsPackageFragmentProvider jvmBuiltInsPackageFragmentProvider = new JvmBuiltInsPackageFragmentProvider(lockBasedStorageManager5, reflectKotlinClassFinder5, moduleDescriptorImpl4, notFoundClasses3, customizer, customizer2, defaultR5, Companion.Default, new SamConversionResolverImpl(lockBasedStorageManager5, EmptyList.INSTANCE));
                            ModuleDescriptorImpl moduleDescriptorImpl5 = moduleDescriptorImpl4;
                            moduleDescriptorImpl5.setDependencies(moduleDescriptorImpl5);
                            moduleDescriptorImpl5.initialize(new CompositePackageFragmentProvider(TweetUtils.listOf((T[]) new PackageFragmentProviderOptimized[]{javaDescriptorResolver.packageFragmentProvider, jvmBuiltInsPackageFragmentProvider})));
                            RuntimeModuleData runtimeModuleData2 = new RuntimeModuleData(deserializationComponents, new PackagePartScopeCache(deserializedDescriptorResolver4, reflectKotlinClassFinder4), null);
                            while (true) {
                                try {
                                    WeakClassLoaderBox weakClassLoaderBox3 = weakClassLoaderBox2;
                                    WeakReference putIfAbsent = moduleByClassLoader.putIfAbsent(weakClassLoaderBox3, new WeakReference(runtimeModuleData2));
                                    if (putIfAbsent == null) {
                                        return runtimeModuleData2;
                                    }
                                    RuntimeModuleData runtimeModuleData3 = (RuntimeModuleData) putIfAbsent.get();
                                    if (runtimeModuleData3 != null) {
                                        return runtimeModuleData3;
                                    }
                                    moduleByClassLoader.remove(weakClassLoaderBox3, putIfAbsent);
                                    weakClassLoaderBox2 = weakClassLoaderBox3;
                                }
                            }
                        } else {
                            throw null;
                        }
                    } else {
                        throw null;
                    }
                } else {
                    throw null;
                }
            } else {
                throw null;
            }
        } else {
            throw new AssertionError("JvmBuiltins repeated initialization");
        }
    }
}
