package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns.Settings;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilterKt;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Empty;
import kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.LazyWrappedType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: JvmBuiltInsCustomizer.kt */
public final class JvmBuiltInsCustomizer implements AdditionalClassPartsProvider, PlatformDependentDeclarationFilter {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    public final NotNullLazyValue cloneableType$delegate;
    public final JavaToKotlinClassMapper j2kClassMapper = JavaToKotlinClassMapper.INSTANCE;
    public final CacheWithNotNullValues<FqName, ClassDescriptor> javaAnalogueClassesWithCustomSupertypeCache;
    public final KotlinType mockSerializableType;
    public final ModuleDescriptor moduleDescriptor;
    public final NotNullLazyValue notConsideredDeprecation$delegate;
    public final NotNullLazyValue settings$delegate;

    /* compiled from: JvmBuiltInsCustomizer.kt */
    public enum JDKMemberStatus {
        HIDDEN,
        VISIBLE,
        NOT_CONSIDERED,
        DROP
    }

    static {
        Class<JvmBuiltInsCustomizer> cls = JvmBuiltInsCustomizer.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "settings", "getSettings()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltIns$Settings;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "cloneableType", "getCloneableType()Lorg/jetbrains/kotlin/types/SimpleType;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "notConsideredDeprecation", "getNotConsideredDeprecation()Lorg/jetbrains/kotlin/descriptors/annotations/Annotations;"))};
    }

    public JvmBuiltInsCustomizer(ModuleDescriptor moduleDescriptor2, StorageManager storageManager, Function0<Settings> function0) {
        Intrinsics.checkNotNullParameter(moduleDescriptor2, "moduleDescriptor");
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(function0, "settingsComputation");
        this.moduleDescriptor = moduleDescriptor2;
        this.settings$delegate = storageManager.createLazyValue(function0);
        ClassDescriptorImpl classDescriptorImpl = new ClassDescriptorImpl(new JvmBuiltInsCustomizer$createMockJavaIoSerializableType$mockJavaIoPackageFragment$1(this.moduleDescriptor, new FqName((String) "java.io")), Name.identifier("Serializable"), Modality.ABSTRACT, ClassKind.INTERFACE, TweetUtils.listOf(new LazyWrappedType(storageManager, new JvmBuiltInsCustomizer$createMockJavaIoSerializableType$superTypes$1(this))), SourceElement.NO_SOURCE, false, storageManager);
        classDescriptorImpl.initialize(Empty.INSTANCE, EmptySet.INSTANCE, null);
        SimpleType defaultType = classDescriptorImpl.getDefaultType();
        Intrinsics.checkNotNullExpressionValue(defaultType, "mockSerializableClass.defaultType");
        this.mockSerializableType = defaultType;
        this.cloneableType$delegate = storageManager.createLazyValue(new JvmBuiltInsCustomizer$cloneableType$2(this, storageManager));
        this.javaAnalogueClassesWithCustomSupertypeCache = storageManager.createCacheWithNotNullValues();
        this.notConsideredDeprecation$delegate = storageManager.createLazyValue(new JvmBuiltInsCustomizer$notConsideredDeprecation$2(this));
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x0100  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor> getConstructors(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r15) {
        /*
            r14 = this;
            java.lang.String r0 = "classDescriptor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r0 = r15.getKind()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r1 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.CLASS
            if (r0 != r1) goto L_0x0175
            kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns$Settings r0 = r14.getSettings()
            boolean r0 = r0.isAdditionalBuiltInsFeatureSupported
            if (r0 != 0) goto L_0x0017
            goto L_0x0175
        L_0x0017:
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor r0 = r14.getJavaAnalogue(r15)
            if (r0 != 0) goto L_0x0020
            kotlin.collections.EmptyList r15 = kotlin.collections.EmptyList.INSTANCE
            return r15
        L_0x0020:
            kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper r1 = r14.j2kClassMapper
            kotlin.reflect.jvm.internal.impl.name.FqName r2 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getFqNameSafe(r0)
            kotlin.reflect.jvm.internal.impl.builtins.jvm.FallbackBuiltIns r3 = kotlin.reflect.jvm.internal.impl.builtins.jvm.FallbackBuiltIns.Companion
            kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns r3 = kotlin.reflect.jvm.internal.impl.builtins.jvm.FallbackBuiltIns.Instance
            r4 = 4
            r5 = 0
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r1 = kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper.mapJavaToKotlin$default(r1, r2, r3, r5, r4)
            if (r1 != 0) goto L_0x0035
            kotlin.collections.EmptyList r15 = kotlin.collections.EmptyList.INSTANCE
            return r15
        L_0x0035:
            kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution r2 = com.twitter.sdk.android.tweetui.TweetUtils.createMappedTypeParametersSubstitution(r1, r0)
            kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor r2 = r2.buildSubstitutor()
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope r3 = r0.unsubstitutedMemberScope
            kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue<java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor>> r3 = r3.constructors
            java.lang.Object r3 = r3.invoke()
            java.util.List r3 = (java.util.List) r3
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Iterator r3 = r3.iterator()
        L_0x0050:
            boolean r6 = r3.hasNext()
            r7 = 3
            r8 = 0
            if (r6 == 0) goto L_0x0109
            java.lang.Object r6 = r3.next()
            r9 = r6
            kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor r9 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor) r9
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r10 = r9.getVisibility()
            if (r10 == 0) goto L_0x0108
            kotlin.reflect.jvm.internal.impl.descriptors.DelegatedDescriptorVisibility r10 = (kotlin.reflect.jvm.internal.impl.descriptors.DelegatedDescriptorVisibility) r10
            kotlin.reflect.jvm.internal.impl.descriptors.Visibility r10 = r10.delegate
            boolean r10 = r10.isPublicAPI
            r11 = 1
            if (r10 == 0) goto L_0x0101
            java.util.Collection r10 = r1.getConstructors()
            java.lang.String r12 = "defaultKotlinVersion.constructors"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r12)
            boolean r12 = r10.isEmpty()
            if (r12 == 0) goto L_0x007e
            goto L_0x00a6
        L_0x007e:
            java.util.Iterator r10 = r10.iterator()
        L_0x0082:
            boolean r12 = r10.hasNext()
            if (r12 == 0) goto L_0x00a6
            java.lang.Object r12 = r10.next()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor r12 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor) r12
            java.lang.String r13 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r13)
            kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor r13 = r9.substitute(r2)
            kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil$OverrideCompatibilityInfo$Result r12 = kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.getBothWaysOverridability(r12, r13)
            kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil$OverrideCompatibilityInfo$Result r13 = kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE
            if (r12 != r13) goto L_0x00a1
            r12 = 1
            goto L_0x00a2
        L_0x00a1:
            r12 = 0
        L_0x00a2:
            if (r12 == 0) goto L_0x0082
            r10 = 0
            goto L_0x00a7
        L_0x00a6:
            r10 = 1
        L_0x00a7:
            if (r10 == 0) goto L_0x0101
            java.util.List r10 = r9.getValueParameters()
            int r10 = r10.size()
            if (r10 != r11) goto L_0x00e3
            java.util.List r10 = r9.getValueParameters()
            java.lang.String r11 = "valueParameters"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r11)
            java.lang.Object r10 = kotlin.collections.ArraysKt___ArraysJvmKt.single(r10)
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r10 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r10
            kotlin.reflect.jvm.internal.impl.types.KotlinType r10 = r10.getType()
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r10 = r10.getConstructor()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r10 = r10.getDeclarationDescriptor()
            if (r10 != 0) goto L_0x00d3
            r10 = r5
            goto L_0x00d7
        L_0x00d3:
            kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe r10 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getFqNameUnsafe(r10)
        L_0x00d7:
            kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe r11 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getFqNameUnsafe(r15)
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual(r10, r11)
            if (r10 == 0) goto L_0x00e3
            r10 = 1
            goto L_0x00e4
        L_0x00e3:
            r10 = 0
        L_0x00e4:
            if (r10 != 0) goto L_0x0101
            boolean r10 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isDeprecated(r9)
            if (r10 != 0) goto L_0x0101
            kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsSignatures r10 = kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsSignatures.INSTANCE
            java.util.Set<java.lang.String> r10 = kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsSignatures.HIDDEN_CONSTRUCTOR_SIGNATURES
            kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents r11 = kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents.INSTANCE
            java.lang.String r7 = kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt.computeJvmDescriptor$default(r9, r8, r8, r7)
            java.lang.String r7 = com.twitter.sdk.android.tweetui.TweetUtils.signature(r11, r0, r7)
            boolean r7 = r10.contains(r7)
            if (r7 != 0) goto L_0x0101
            r8 = 1
        L_0x0101:
            if (r8 == 0) goto L_0x0050
            r4.add(r6)
            goto L_0x0050
        L_0x0108:
            throw r5
        L_0x0109:
            java.util.ArrayList r1 = new java.util.ArrayList
            r3 = 10
            int r3 = com.twitter.sdk.android.tweetui.TweetUtils.collectionSizeOrDefault(r4, r3)
            r1.<init>(r3)
            java.util.Iterator r3 = r4.iterator()
        L_0x0118:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0174
            java.lang.Object r4 = r3.next()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor) r4
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor$CopyBuilder r5 = r4.newCopyBuilder()
            r5.setOwner(r15)
            kotlin.reflect.jvm.internal.impl.types.SimpleType r6 = r15.getDefaultType()
            r5.setReturnType(r6)
            r5.setPreserveSourceElement()
            kotlin.reflect.jvm.internal.impl.types.TypeSubstitution r6 = r2.getSubstitution()
            r5.setSubstitution(r6)
            kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsSignatures r6 = kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsSignatures.INSTANCE
            java.util.Set<java.lang.String> r6 = kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsSignatures.VISIBLE_CONSTRUCTOR_SIGNATURES
            kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents r9 = kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents.INSTANCE
            java.lang.String r4 = kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt.computeJvmDescriptor$default(r4, r8, r8, r7)
            java.lang.String r4 = com.twitter.sdk.android.tweetui.TweetUtils.signature(r9, r0, r4)
            boolean r4 = r6.contains(r4)
            if (r4 != 0) goto L_0x0160
            kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue r4 = r14.notConsideredDeprecation$delegate
            kotlin.reflect.KProperty<java.lang.Object>[] r6 = $$delegatedProperties
            r9 = 2
            r6 = r6[r9]
            java.lang.Object r4 = com.twitter.sdk.android.tweetui.TweetUtils.getValue(r4, r6)
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r4 = (kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations) r4
            r5.setAdditionalAnnotations(r4)
        L_0x0160:
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r4 = r5.build()
            if (r4 == 0) goto L_0x016c
            kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor) r4
            r1.add(r4)
            goto L_0x0118
        L_0x016c:
            java.lang.NullPointerException r15 = new java.lang.NullPointerException
            java.lang.String r0 = "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor"
            r15.<init>(r0)
            throw r15
        L_0x0174:
            return r1
        L_0x0175:
            kotlin.collections.EmptyList r15 = kotlin.collections.EmptyList.INSTANCE
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer.getConstructors(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor):java.util.Collection");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:95:0x02bf, code lost:
        if (r2 != 3) goto L_0x02dd;
     */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x02e8  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x01a8 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x025c A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x024c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> getFunctions(kotlin.reflect.jvm.internal.impl.name.Name r14, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r15) {
        /*
            r13 = this;
            java.lang.String r0 = "name"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "classDescriptor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            kotlin.reflect.jvm.internal.impl.builtins.jvm.CloneableClassScope r0 = kotlin.reflect.jvm.internal.impl.builtins.jvm.CloneableClassScope.Companion
            kotlin.reflect.jvm.internal.impl.name.Name r0 = kotlin.reflect.jvm.internal.impl.builtins.jvm.CloneableClassScope.CLONE_NAME
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r14, r0)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x00a0
            boolean r0 = r15 instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor
            if (r0 == 0) goto L_0x00a0
            boolean r0 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isArrayOrPrimitiveArray(r15)
            if (r0 == 0) goto L_0x00a0
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor r15 = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor) r15
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r0 = r15.classProto
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function> r0 = r0.function_
            java.lang.String r3 = "classDescriptor.classProto.functionList"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            boolean r3 = r0.isEmpty()
            if (r3 == 0) goto L_0x0032
            goto L_0x0057
        L_0x0032:
            java.util.Iterator r0 = r0.iterator()
        L_0x0036:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0057
            java.lang.Object r3 = r0.next()
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function) r3
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r4 = r15.f5950c
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r4 = r4.nameResolver
            int r3 = r3.name_
            kotlin.reflect.jvm.internal.impl.name.Name r3 = com.twitter.sdk.android.tweetui.TweetUtils.getName(r4, r3)
            kotlin.reflect.jvm.internal.impl.builtins.jvm.CloneableClassScope r4 = kotlin.reflect.jvm.internal.impl.builtins.jvm.CloneableClassScope.Companion
            kotlin.reflect.jvm.internal.impl.name.Name r4 = kotlin.reflect.jvm.internal.impl.builtins.jvm.CloneableClassScope.CLONE_NAME
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r4)
            if (r3 == 0) goto L_0x0036
            r1 = 1
        L_0x0057:
            if (r1 == 0) goto L_0x005c
            kotlin.collections.EmptyList r14 = kotlin.collections.EmptyList.INSTANCE
            return r14
        L_0x005c:
            kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue r0 = r13.cloneableType$delegate
            kotlin.reflect.KProperty<java.lang.Object>[] r1 = $$delegatedProperties
            r1 = r1[r2]
            java.lang.Object r0 = com.twitter.sdk.android.tweetui.TweetUtils.getValue(r0, r1)
            kotlin.reflect.jvm.internal.impl.types.SimpleType r0 = (kotlin.reflect.jvm.internal.impl.types.SimpleType) r0
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r0 = r0.getMemberScope()
            kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation r1 = kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_BUILTINS
            java.util.Collection r14 = r0.getContributedFunctions(r14, r1)
            java.lang.Object r14 = kotlin.collections.ArraysKt___ArraysJvmKt.single(r14)
            kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r14 = (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) r14
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor$CopyBuilder r14 = r14.newCopyBuilder()
            r14.setOwner(r15)
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r0 = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.PUBLIC
            r14.setVisibility(r0)
            kotlin.reflect.jvm.internal.impl.types.SimpleType r0 = r15.getDefaultType()
            r14.setReturnType(r0)
            kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r15 = r15.getThisAsReceiverParameter()
            r14.setDispatchReceiverParameter(r15)
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r14 = r14.build()
            kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r14 = (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) r14
            kotlin.jvm.internal.Intrinsics.checkNotNull(r14)
            java.util.List r14 = com.twitter.sdk.android.tweetui.TweetUtils.listOf(r14)
            return r14
        L_0x00a0:
            kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns$Settings r0 = r13.getSettings()
            boolean r0 = r0.isAdditionalBuiltInsFeatureSupported
            if (r0 != 0) goto L_0x00ab
            kotlin.collections.EmptyList r14 = kotlin.collections.EmptyList.INSTANCE
            return r14
        L_0x00ab:
            kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$getFunctions$2 r0 = new kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$getFunctions$2
            r0.<init>(r14)
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor r14 = r13.getJavaAnalogue(r15)
            r3 = 3
            r4 = 2
            r5 = 0
            if (r14 != 0) goto L_0x00bd
            kotlin.collections.EmptyList r14 = kotlin.collections.EmptyList.INSTANCE
            goto L_0x0253
        L_0x00bd:
            kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper r6 = r13.j2kClassMapper
            kotlin.reflect.jvm.internal.impl.name.FqName r7 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getFqNameSafe(r14)
            kotlin.reflect.jvm.internal.impl.builtins.jvm.FallbackBuiltIns r8 = kotlin.reflect.jvm.internal.impl.builtins.jvm.FallbackBuiltIns.Companion
            kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns r8 = kotlin.reflect.jvm.internal.impl.builtins.jvm.FallbackBuiltIns.Instance
            if (r6 == 0) goto L_0x02f6
            java.lang.String r9 = "fqName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r9)
            java.lang.String r9 = "builtIns"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r9)
            r9 = 4
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r6 = kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper.mapJavaToKotlin$default(r6, r7, r8, r5, r9)
            if (r6 != 0) goto L_0x00dd
            kotlin.collections.EmptySet r2 = kotlin.collections.EmptySet.INSTANCE
            goto L_0x0105
        L_0x00dd:
            kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap r7 = kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap.INSTANCE
            kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe r7 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getFqNameUnsafe(r6)
            java.util.HashMap<kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe, kotlin.reflect.jvm.internal.impl.name.FqName> r9 = kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap.readOnlyToMutable
            java.lang.Object r7 = r9.get(r7)
            kotlin.reflect.jvm.internal.impl.name.FqName r7 = (kotlin.reflect.jvm.internal.impl.name.FqName) r7
            if (r7 != 0) goto L_0x00f2
            java.util.Set r2 = com.twitter.sdk.android.tweetui.TweetUtils.setOf(r6)
            goto L_0x0105
        L_0x00f2:
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor[] r9 = new kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor[r4]
            r9[r1] = r6
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r6 = r8.getBuiltInClassByFqName(r7)
            java.lang.String r7 = "builtIns.getBuiltInClassByFqName(kotlinMutableAnalogFqName)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            r9[r2] = r6
            java.util.List r2 = com.twitter.sdk.android.tweetui.TweetUtils.listOf((T[]) r9)
        L_0x0105:
            java.lang.String r6 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r6)
            boolean r6 = r2 instanceof java.util.List
            if (r6 == 0) goto L_0x0123
            r6 = r2
            java.util.List r6 = (java.util.List) r6
            boolean r7 = r6.isEmpty()
            if (r7 == 0) goto L_0x0118
            goto L_0x012d
        L_0x0118:
            int r7 = r6.size()
            int r7 = r7 + -1
            java.lang.Object r6 = r6.get(r7)
            goto L_0x013f
        L_0x0123:
            java.util.Iterator r6 = r2.iterator()
            boolean r7 = r6.hasNext()
            if (r7 != 0) goto L_0x012f
        L_0x012d:
            r6 = r5
            goto L_0x013f
        L_0x012f:
            java.lang.Object r7 = r6.next()
        L_0x0133:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x013e
            java.lang.Object r7 = r6.next()
            goto L_0x0133
        L_0x013e:
            r6 = r7
        L_0x013f:
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r6 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r6
            if (r6 != 0) goto L_0x0147
            kotlin.collections.EmptyList r14 = kotlin.collections.EmptyList.INSTANCE
            goto L_0x0253
        L_0x0147:
            java.util.ArrayList r7 = new java.util.ArrayList
            r8 = 10
            int r8 = com.twitter.sdk.android.tweetui.TweetUtils.collectionSizeOrDefault(r2, r8)
            r7.<init>(r8)
            java.util.Iterator r2 = r2.iterator()
        L_0x0156:
            boolean r8 = r2.hasNext()
            if (r8 == 0) goto L_0x016a
            java.lang.Object r8 = r2.next()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r8 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r8
            kotlin.reflect.jvm.internal.impl.name.FqName r8 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getFqNameSafe(r8)
            r7.add(r8)
            goto L_0x0156
        L_0x016a:
            java.lang.String r2 = "set"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r2)
            kotlin.reflect.jvm.internal.impl.utils.SmartSet r2 = new kotlin.reflect.jvm.internal.impl.utils.SmartSet
            r2.<init>(r5)
            r2.addAll(r7)
            kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper r7 = r13.j2kClassMapper
            boolean r7 = r7.isMutable(r15)
            kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues<kotlin.reflect.jvm.internal.impl.name.FqName, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor> r8 = r13.javaAnalogueClassesWithCustomSupertypeCache
            kotlin.reflect.jvm.internal.impl.name.FqName r9 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getFqNameSafe(r14)
            kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$getAdditionalFunctions$fakeJavaClassDescriptor$1 r10 = new kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$getAdditionalFunctions$fakeJavaClassDescriptor$1
            r10.<init>(r14, r6)
            kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction r8 = (kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.CacheWithNotNullValuesBasedOnMemoizedFunction) r8
            java.lang.Object r14 = r8.computeIfAbsent(r9, r10)
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r14 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r14
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r14 = r14.getUnsubstitutedMemberScope()
            java.lang.String r6 = "fakeJavaClassDescriptor.unsubstitutedMemberScope"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r6)
            java.lang.Object r14 = r0.invoke(r14)
            java.lang.Iterable r14 = (java.lang.Iterable) r14
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r14 = r14.iterator()
        L_0x01a8:
            boolean r6 = r14.hasNext()
            if (r6 == 0) goto L_0x0252
            java.lang.Object r6 = r14.next()
            r8 = r6
            kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r8 = (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) r8
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind r9 = r8.getKind()
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind r10 = kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind.DECLARATION
            if (r9 == r10) goto L_0x01bf
            goto L_0x0249
        L_0x01bf:
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r9 = r8.getVisibility()
            if (r9 == 0) goto L_0x0251
            kotlin.reflect.jvm.internal.impl.descriptors.DelegatedDescriptorVisibility r9 = (kotlin.reflect.jvm.internal.impl.descriptors.DelegatedDescriptorVisibility) r9
            kotlin.reflect.jvm.internal.impl.descriptors.Visibility r9 = r9.delegate
            boolean r9 = r9.isPublicAPI
            if (r9 != 0) goto L_0x01cf
            goto L_0x0249
        L_0x01cf:
            boolean r9 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isDeprecated(r8)
            if (r9 == 0) goto L_0x01d7
            goto L_0x0249
        L_0x01d7:
            java.util.Collection r9 = r8.getOverriddenDescriptors()
            java.lang.String r10 = "analogueMember.overriddenDescriptors"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)
            boolean r10 = r9.isEmpty()
            if (r10 == 0) goto L_0x01e7
            goto L_0x020c
        L_0x01e7:
            java.util.Iterator r9 = r9.iterator()
        L_0x01eb:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x020c
            java.lang.Object r10 = r9.next()
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r10 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r10
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r10 = r10.getContainingDeclaration()
            java.lang.String r11 = "it.containingDeclaration"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r11)
            kotlin.reflect.jvm.internal.impl.name.FqName r10 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getFqNameSafe(r10)
            boolean r10 = r2.contains(r10)
            if (r10 == 0) goto L_0x01eb
            r9 = 1
            goto L_0x020d
        L_0x020c:
            r9 = 0
        L_0x020d:
            if (r9 == 0) goto L_0x0210
            goto L_0x0249
        L_0x0210:
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r9 = r8.getContainingDeclaration()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r9 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r9
            java.lang.String r10 = kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt.computeJvmDescriptor$default(r8, r1, r1, r3)
            kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsSignatures r11 = kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsSignatures.INSTANCE
            java.util.Set<java.lang.String> r11 = kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsSignatures.MUTABLE_METHOD_SIGNATURES
            kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents r12 = kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents.INSTANCE
            java.lang.String r9 = com.twitter.sdk.android.tweetui.TweetUtils.signature(r12, r9, r10)
            boolean r9 = r11.contains(r9)
            r9 = r9 ^ r7
            if (r9 == 0) goto L_0x022d
            r8 = 1
            goto L_0x0245
        L_0x022d:
            java.util.List r8 = com.twitter.sdk.android.tweetui.TweetUtils.listOf(r8)
            kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$isMutabilityViolation$1 r9 = kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$isMutabilityViolation$1.INSTANCE
            kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$isMutabilityViolation$2 r10 = new kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$isMutabilityViolation$2
            r10.<init>(r13)
            java.lang.Boolean r8 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.ifAny(r8, r9, r10)
            java.lang.String r9 = "private fun SimpleFunctionDescriptor.isMutabilityViolation(isMutable: Boolean): Boolean {\n        val owner = containingDeclaration as ClassDescriptor\n        val jvmDescriptor = computeJvmDescriptor()\n\n        if ((SignatureBuildingComponents.signature(owner, jvmDescriptor) in MUTABLE_METHOD_SIGNATURES) xor isMutable) return true\n\n        return DFS.ifAny<CallableMemberDescriptor>(\n            listOf(this),\n            { it.original.overriddenDescriptors }\n        ) { overridden ->\n            overridden.kind == CallableMemberDescriptor.Kind.DECLARATION &&\n                    j2kClassMapper.isMutable(overridden.containingDeclaration as ClassDescriptor)\n        }\n    }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)
            boolean r8 = r8.booleanValue()
        L_0x0245:
            if (r8 != 0) goto L_0x0249
            r8 = 1
            goto L_0x024a
        L_0x0249:
            r8 = 0
        L_0x024a:
            if (r8 == 0) goto L_0x01a8
            r0.add(r6)
            goto L_0x01a8
        L_0x0251:
            throw r5
        L_0x0252:
            r14 = r0
        L_0x0253:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r14 = r14.iterator()
        L_0x025c:
            boolean r2 = r14.hasNext()
            if (r2 == 0) goto L_0x02f5
            java.lang.Object r2 = r14.next()
            kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) r2
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r6 = r2.getContainingDeclaration()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r6 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r6
            kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution r6 = com.twitter.sdk.android.tweetui.TweetUtils.createMappedTypeParametersSubstitution(r6, r15)
            kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor r6 = r6.buildSubstitutor()
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r6 = r2.substitute(r6)
            if (r6 == 0) goto L_0x02ed
            kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r6 = (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) r6
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor$CopyBuilder r6 = r6.newCopyBuilder()
            r6.setOwner(r15)
            kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r7 = r15.getThisAsReceiverParameter()
            r6.setDispatchReceiverParameter(r7)
            r6.setPreserveSourceElement()
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r7 = r2.getContainingDeclaration()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r7 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r7
            java.lang.String r2 = kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt.computeJvmDescriptor$default(r2, r1, r1, r3)
            kotlin.jvm.internal.Ref$ObjectRef r8 = new kotlin.jvm.internal.Ref$ObjectRef
            r8.<init>()
            java.util.List r7 = com.twitter.sdk.android.tweetui.TweetUtils.listOf(r7)
            kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$getJdkMethodStatus$1 r9 = new kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$getJdkMethodStatus$1
            r9.<init>(r13)
            kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$getJdkMethodStatus$2 r10 = new kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$getJdkMethodStatus$2
            r10.<init>(r2, r8)
            java.lang.Object r2 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.dfs(r7, r9, r10)
            java.lang.String r7 = "private fun FunctionDescriptor.getJdkMethodStatus(): JDKMemberStatus {\n        val owner = containingDeclaration as ClassDescriptor\n        val jvmDescriptor = computeJvmDescriptor()\n        var result: JDKMemberStatus? = null\n        return DFS.dfs<ClassDescriptor, JDKMemberStatus>(\n            listOf(owner),\n            {\n                // Search through mapped supertypes to determine that Set.toArray should be invisible, while we have only\n                // Collection.toArray there explicitly\n                // Note, that we can't find j.u.Collection.toArray within overriddenDescriptors of j.u.Set.toArray\n                it.typeConstructor.supertypes.mapNotNull {\n                    (it.constructor.declarationDescriptor?.original as? ClassDescriptor)?.getJavaAnalogue()\n                }\n            },\n            object : DFS.AbstractNodeHandler<ClassDescriptor, JDKMemberStatus>() {\n                override fun beforeChildren(javaClassDescriptor: ClassDescriptor): Boolean {\n                    val signature = SignatureBuildingComponents.signature(javaClassDescriptor, jvmDescriptor)\n                    when (signature) {\n                        in HIDDEN_METHOD_SIGNATURES -> result = JDKMemberStatus.HIDDEN\n                        in VISIBLE_METHOD_SIGNATURES -> result = JDKMemberStatus.VISIBLE\n                        in DROP_LIST_METHOD_SIGNATURES -> result = JDKMemberStatus.DROP\n                    }\n\n                    return result == null\n                }\n\n                override fun result() = result ?: JDKMemberStatus.NOT_CONSIDERED\n            })\n    }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r7)
            kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$JDKMemberStatus r2 = (kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer.JDKMemberStatus) r2
            int r2 = r2.ordinal()
            if (r2 == 0) goto L_0x02d2
            if (r2 == r4) goto L_0x02c2
            if (r2 == r3) goto L_0x02d8
            goto L_0x02dd
        L_0x02c2:
            kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue r2 = r13.notConsideredDeprecation$delegate
            kotlin.reflect.KProperty<java.lang.Object>[] r7 = $$delegatedProperties
            r7 = r7[r4]
            java.lang.Object r2 = com.twitter.sdk.android.tweetui.TweetUtils.getValue(r2, r7)
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r2 = (kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations) r2
            r6.setAdditionalAnnotations(r2)
            goto L_0x02dd
        L_0x02d2:
            boolean r2 = com.twitter.sdk.android.tweetui.TweetUtils.isFinalClass(r15)
            if (r2 == 0) goto L_0x02da
        L_0x02d8:
            r2 = r5
            goto L_0x02e6
        L_0x02da:
            r6.setHiddenForResolutionEverywhereBesideSupercalls()
        L_0x02dd:
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r2 = r6.build()
            kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) r2
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
        L_0x02e6:
            if (r2 == 0) goto L_0x025c
            r0.add(r2)
            goto L_0x025c
        L_0x02ed:
            java.lang.NullPointerException r14 = new java.lang.NullPointerException
            java.lang.String r15 = "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.SimpleFunctionDescriptor"
            r14.<init>(r15)
            throw r14
        L_0x02f5:
            return r0
        L_0x02f6:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer.getFunctions(kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor):java.util.Collection");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Collection getFunctionsNames(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r2) {
        /*
            r1 = this;
            java.lang.String r0 = "classDescriptor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns$Settings r0 = r1.getSettings()
            boolean r0 = r0.isAdditionalBuiltInsFeatureSupported
            if (r0 != 0) goto L_0x0010
            kotlin.collections.EmptySet r2 = kotlin.collections.EmptySet.INSTANCE
            goto L_0x0028
        L_0x0010:
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor r2 = r1.getJavaAnalogue(r2)
            r0 = 0
            if (r2 != 0) goto L_0x0018
            goto L_0x001e
        L_0x0018:
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope r2 = r2.getUnsubstitutedMemberScope()
            if (r2 != 0) goto L_0x0020
        L_0x001e:
            r2 = r0
            goto L_0x0024
        L_0x0020:
            java.util.Set r2 = r2.getFunctionNames()
        L_0x0024:
            if (r2 != 0) goto L_0x0028
            kotlin.collections.EmptySet r2 = kotlin.collections.EmptySet.INSTANCE
        L_0x0028:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer.getFunctionsNames(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor):java.util.Collection");
    }

    public final LazyJavaClassDescriptor getJavaAnalogue(ClassDescriptor classDescriptor) {
        LazyJavaClassDescriptor lazyJavaClassDescriptor = null;
        if (KotlinBuiltIns.isAny(classDescriptor) || !KotlinBuiltIns.isUnderKotlinPackage(classDescriptor)) {
            return null;
        }
        FqNameUnsafe fqNameUnsafe = DescriptorUtilsKt.getFqNameUnsafe(classDescriptor);
        if (!fqNameUnsafe.isSafe()) {
            return null;
        }
        ClassId mapKotlinToJava = JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(fqNameUnsafe);
        FqName asSingleFqName = mapKotlinToJava == null ? null : mapKotlinToJava.asSingleFqName();
        if (asSingleFqName == null) {
            return null;
        }
        ClassDescriptor resolveClassByFqName = TweetUtils.resolveClassByFqName(getSettings().ownerModuleDescriptor, asSingleFqName, NoLookupLocation.FROM_BUILTINS);
        if (resolveClassByFqName instanceof LazyJavaClassDescriptor) {
            lazyJavaClassDescriptor = (LazyJavaClassDescriptor) resolveClassByFqName;
        }
        return lazyJavaClassDescriptor;
    }

    public final Settings getSettings() {
        return (Settings) TweetUtils.getValue(this.settings$delegate, $$delegatedProperties[0]);
    }

    public Collection<KotlinType> getSupertypes(ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
        FqNameUnsafe fqNameUnsafe = DescriptorUtilsKt.getFqNameUnsafe(classDescriptor);
        boolean z = true;
        if (JvmBuiltInsSignatures.INSTANCE.isArrayOrPrimitiveArray(fqNameUnsafe)) {
            SimpleType simpleType = (SimpleType) TweetUtils.getValue(this.cloneableType$delegate, $$delegatedProperties[1]);
            Intrinsics.checkNotNullExpressionValue(simpleType, "cloneableType");
            return TweetUtils.listOf((T[]) new KotlinType[]{simpleType, this.mockSerializableType});
        }
        JvmBuiltInsSignatures jvmBuiltInsSignatures = JvmBuiltInsSignatures.INSTANCE;
        Intrinsics.checkNotNullParameter(fqNameUnsafe, "fqName");
        if (!jvmBuiltInsSignatures.isArrayOrPrimitiveArray(fqNameUnsafe)) {
            ClassId mapKotlinToJava = JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(fqNameUnsafe);
            if (mapKotlinToJava != null) {
                try {
                    z = Serializable.class.isAssignableFrom(Class.forName(mapKotlinToJava.asSingleFqName().asString()));
                } catch (ClassNotFoundException unused) {
                }
            }
            z = false;
        }
        if (z) {
            return TweetUtils.listOf(this.mockSerializableType);
        }
        return EmptyList.INSTANCE;
    }

    public boolean isFunctionAvailable(ClassDescriptor classDescriptor, SimpleFunctionDescriptor simpleFunctionDescriptor) {
        Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
        Intrinsics.checkNotNullParameter(simpleFunctionDescriptor, "functionDescriptor");
        LazyJavaClassDescriptor javaAnalogue = getJavaAnalogue(classDescriptor);
        boolean z = true;
        if (javaAnalogue == null || !simpleFunctionDescriptor.getAnnotations().hasAnnotation(PlatformDependentDeclarationFilterKt.PLATFORM_DEPENDENT_ANNOTATION_FQ_NAME)) {
            return true;
        }
        if (!getSettings().isAdditionalBuiltInsFeatureSupported) {
            return false;
        }
        String computeJvmDescriptor$default = MethodSignatureMappingKt.computeJvmDescriptor$default(simpleFunctionDescriptor, false, false, 3);
        LazyJavaClassMemberScope unsubstitutedMemberScope = javaAnalogue.getUnsubstitutedMemberScope();
        Name name = simpleFunctionDescriptor.getName();
        Intrinsics.checkNotNullExpressionValue(name, "functionDescriptor.name");
        Collection<SimpleFunctionDescriptor> contributedFunctions = unsubstitutedMemberScope.getContributedFunctions(name, NoLookupLocation.FROM_BUILTINS);
        if (!(contributedFunctions instanceof Collection) || !contributedFunctions.isEmpty()) {
            Iterator<T> it = contributedFunctions.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (Intrinsics.areEqual(MethodSignatureMappingKt.computeJvmDescriptor$default((SimpleFunctionDescriptor) it.next(), false, false, 3), computeJvmDescriptor$default)) {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        z = false;
        return z;
    }
}
