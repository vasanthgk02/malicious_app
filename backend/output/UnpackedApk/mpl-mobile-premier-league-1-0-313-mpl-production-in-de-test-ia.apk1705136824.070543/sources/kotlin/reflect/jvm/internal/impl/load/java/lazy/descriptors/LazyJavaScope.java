package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.login.LoginReactModule;
import com.razorpay.AnalyticsConstants;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator;
import kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator.AnonymousClass1;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: LazyJavaScope.kt */
public abstract class LazyJavaScope extends MemberScopeImpl {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    public final NotNullLazyValue<Collection<DeclarationDescriptor>> allDescriptors;

    /* renamed from: c  reason: collision with root package name */
    public final LazyJavaResolverContext f5943c;
    public final NotNullLazyValue classNamesLazy$delegate = this.f5943c.components.storageManager.createLazyValue(new LazyJavaScope$classNamesLazy$2(this));
    public final MemoizedFunctionToNullable<Name, PropertyDescriptor> declaredField = this.f5943c.components.storageManager.createMemoizedFunctionWithNullableValues(new LazyJavaScope$declaredField$1(this));
    public final MemoizedFunctionToNotNull<Name, Collection<SimpleFunctionDescriptor>> declaredFunctions = this.f5943c.components.storageManager.createMemoizedFunction(new LazyJavaScope$declaredFunctions$1(this));
    public final NotNullLazyValue<DeclaredMemberIndex> declaredMemberIndex = this.f5943c.components.storageManager.createLazyValue(new LazyJavaScope$declaredMemberIndex$1(this));
    public final NotNullLazyValue functionNamesLazy$delegate = this.f5943c.components.storageManager.createLazyValue(new LazyJavaScope$functionNamesLazy$2(this));
    public final MemoizedFunctionToNotNull<Name, Collection<SimpleFunctionDescriptor>> functions = this.f5943c.components.storageManager.createMemoizedFunction(new LazyJavaScope$functions$1(this));
    public final LazyJavaScope mainScope;
    public final MemoizedFunctionToNotNull<Name, List<PropertyDescriptor>> properties = this.f5943c.components.storageManager.createMemoizedFunction(new LazyJavaScope$properties$1(this));
    public final NotNullLazyValue propertyNamesLazy$delegate = this.f5943c.components.storageManager.createLazyValue(new LazyJavaScope$propertyNamesLazy$2(this));

    /* compiled from: LazyJavaScope.kt */
    public static final class MethodSignatureData {
        public final List<String> errors;
        public final boolean hasStableParameterNames;
        public final KotlinType receiverType = null;
        public final KotlinType returnType;
        public final List<TypeParameterDescriptor> typeParameters;
        public final List<ValueParameterDescriptor> valueParameters;

        public MethodSignatureData(KotlinType kotlinType, KotlinType kotlinType2, List<? extends ValueParameterDescriptor> list, List<? extends TypeParameterDescriptor> list2, boolean z, List<String> list3) {
            Intrinsics.checkNotNullParameter(kotlinType, "returnType");
            Intrinsics.checkNotNullParameter(list, "valueParameters");
            Intrinsics.checkNotNullParameter(list2, "typeParameters");
            Intrinsics.checkNotNullParameter(list3, "errors");
            this.returnType = kotlinType;
            this.valueParameters = list;
            this.typeParameters = list2;
            this.hasStableParameterNames = z;
            this.errors = list3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MethodSignatureData)) {
                return false;
            }
            MethodSignatureData methodSignatureData = (MethodSignatureData) obj;
            return Intrinsics.areEqual(this.returnType, methodSignatureData.returnType) && Intrinsics.areEqual(this.receiverType, methodSignatureData.receiverType) && Intrinsics.areEqual(this.valueParameters, methodSignatureData.valueParameters) && Intrinsics.areEqual(this.typeParameters, methodSignatureData.typeParameters) && this.hasStableParameterNames == methodSignatureData.hasStableParameterNames && Intrinsics.areEqual(this.errors, methodSignatureData.errors);
        }

        public int hashCode() {
            int hashCode = this.returnType.hashCode() * 31;
            KotlinType kotlinType = this.receiverType;
            int hashCode2 = kotlinType == null ? 0 : kotlinType.hashCode();
            int hashCode3 = (this.typeParameters.hashCode() + ((this.valueParameters.hashCode() + ((hashCode + hashCode2) * 31)) * 31)) * 31;
            boolean z = this.hasStableParameterNames;
            if (z) {
                z = true;
            }
            return this.errors.hashCode() + ((hashCode3 + (z ? 1 : 0)) * 31);
        }

        public String toString() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("MethodSignatureData(returnType=");
            outline73.append(this.returnType);
            outline73.append(", receiverType=");
            outline73.append(this.receiverType);
            outline73.append(", valueParameters=");
            outline73.append(this.valueParameters);
            outline73.append(", typeParameters=");
            outline73.append(this.typeParameters);
            outline73.append(", hasStableParameterNames=");
            outline73.append(this.hasStableParameterNames);
            outline73.append(", errors=");
            outline73.append(this.errors);
            outline73.append(')');
            return outline73.toString();
        }
    }

    /* compiled from: LazyJavaScope.kt */
    public static final class ResolvedValueParameters {
        public final List<ValueParameterDescriptor> descriptors;
        public final boolean hasSynthesizedNames;

        public ResolvedValueParameters(List<? extends ValueParameterDescriptor> list, boolean z) {
            Intrinsics.checkNotNullParameter(list, "descriptors");
            this.descriptors = list;
            this.hasSynthesizedNames = z;
        }
    }

    static {
        Class<LazyJavaScope> cls = LazyJavaScope.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "functionNamesLazy", "getFunctionNamesLazy()Ljava/util/Set;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "propertyNamesLazy", "getPropertyNamesLazy()Ljava/util/Set;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "classNamesLazy", "getClassNamesLazy()Ljava/util/Set;"))};
    }

    public LazyJavaScope(LazyJavaResolverContext lazyJavaResolverContext, LazyJavaScope lazyJavaScope) {
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "c");
        this.f5943c = lazyJavaResolverContext;
        this.mainScope = lazyJavaScope;
        this.allDescriptors = lazyJavaResolverContext.components.storageManager.createRecursionTolerantLazyValue(new LazyJavaScope$allDescriptors$1(this), EmptyList.INSTANCE);
    }

    public abstract Set<Name> computeClassNames(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1);

    public abstract Set<Name> computeFunctionNames(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1);

    public void computeImplicitlyDeclaredFunctions(Collection<SimpleFunctionDescriptor> collection, Name name) {
        Intrinsics.checkNotNullParameter(collection, LoginReactModule.RESULT);
        Intrinsics.checkNotNullParameter(name, "name");
    }

    public abstract DeclaredMemberIndex computeMemberIndex();

    public final KotlinType computeMethodReturnType(JavaMethod javaMethod, LazyJavaResolverContext lazyJavaResolverContext) {
        Intrinsics.checkNotNullParameter(javaMethod, AnalyticsConstants.METHOD);
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "c");
        return lazyJavaResolverContext.typeResolver.transformJavaType(javaMethod.getReturnType(), JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, javaMethod.getContainingClass().isAnnotationType(), null, 2));
    }

    public abstract void computeNonDeclaredFunctions(Collection<SimpleFunctionDescriptor> collection, Name name);

    public abstract void computeNonDeclaredProperties(Name name, Collection<PropertyDescriptor> collection);

    public abstract Set<Name> computePropertyNames(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1);

    public Set<Name> getClassifierNames() {
        return (Set) TweetUtils.getValue(this.classNamesLazy$delegate, $$delegatedProperties[2]);
    }

    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        return (Collection) this.allDescriptors.invoke();
    }

    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        if (!getFunctionNames().contains(name)) {
            return EmptyList.INSTANCE;
        }
        return (Collection) this.functions.invoke(name);
    }

    public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        if (!getVariableNames().contains(name)) {
            return EmptyList.INSTANCE;
        }
        return (Collection) this.properties.invoke(name);
    }

    public abstract ReceiverParameterDescriptor getDispatchReceiverParameter();

    public Set<Name> getFunctionNames() {
        return (Set) TweetUtils.getValue(this.functionNamesLazy$delegate, $$delegatedProperties[0]);
    }

    public abstract DeclarationDescriptor getOwnerDescriptor();

    public Set<Name> getVariableNames() {
        return (Set) TweetUtils.getValue(this.propertyNamesLazy$delegate, $$delegatedProperties[1]);
    }

    public boolean isVisibleAsFunction(JavaMethodDescriptor javaMethodDescriptor) {
        Intrinsics.checkNotNullParameter(javaMethodDescriptor, "<this>");
        return true;
    }

    public abstract MethodSignatureData resolveMethodSignature(JavaMethod javaMethod, List<? extends TypeParameterDescriptor> list, KotlinType kotlinType, List<? extends ValueParameterDescriptor> list2);

    public final JavaMethodDescriptor resolveMethodToFunctionDescriptor(JavaMethod javaMethod) {
        ReceiverParameterDescriptor receiverParameterDescriptor;
        Map map;
        JavaMethod javaMethod2 = javaMethod;
        Intrinsics.checkNotNullParameter(javaMethod2, AnalyticsConstants.METHOD);
        JavaMethodDescriptor createJavaMethod = JavaMethodDescriptor.createJavaMethod(getOwnerDescriptor(), TweetUtils.resolveAnnotations(this.f5943c, javaMethod2), javaMethod.getName(), this.f5943c.components.sourceElementFactory.source(javaMethod2), ((DeclaredMemberIndex) this.declaredMemberIndex.invoke()).findRecordComponentByName(javaMethod.getName()) != null && javaMethod.getValueParameters().isEmpty());
        Intrinsics.checkNotNullExpressionValue(createJavaMethod, "createJavaMethod(\n            ownerDescriptor, annotations, method.name, c.components.sourceElementFactory.source(method),\n            declaredMemberIndex().findRecordComponentByName(method.name) != null && method.valueParameters.isEmpty()\n        )");
        LazyJavaResolverContext childForMethod$default = TweetUtils.childForMethod$default(this.f5943c, createJavaMethod, javaMethod2, 0, 4);
        List<JavaTypeParameter> typeParameters = javaMethod.getTypeParameters();
        ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(typeParameters, 10));
        for (JavaTypeParameter resolveTypeParameter : typeParameters) {
            TypeParameterDescriptor resolveTypeParameter2 = childForMethod$default.typeParameterResolver.resolveTypeParameter(resolveTypeParameter);
            Intrinsics.checkNotNull(resolveTypeParameter2);
            arrayList.add(resolveTypeParameter2);
        }
        ResolvedValueParameters resolveValueParameters = resolveValueParameters(childForMethod$default, createJavaMethod, javaMethod.getValueParameters());
        MethodSignatureData resolveMethodSignature = resolveMethodSignature(javaMethod2, arrayList, computeMethodReturnType(javaMethod2, childForMethod$default), resolveValueParameters.descriptors);
        KotlinType kotlinType = resolveMethodSignature.receiverType;
        if (kotlinType == null) {
            receiverParameterDescriptor = null;
        } else if (Annotations.Companion != null) {
            receiverParameterDescriptor = TweetUtils.createExtensionReceiverParameterForCallable(createJavaMethod, kotlinType, Companion.EMPTY);
        } else {
            throw null;
        }
        ReceiverParameterDescriptor dispatchReceiverParameter = getDispatchReceiverParameter();
        List<TypeParameterDescriptor> list = resolveMethodSignature.typeParameters;
        List<ValueParameterDescriptor> list2 = resolveMethodSignature.valueParameters;
        KotlinType kotlinType2 = resolveMethodSignature.returnType;
        Modality convertFromFlags = Modality.Companion.convertFromFlags(false, javaMethod.isAbstract(), !javaMethod.isFinal());
        DescriptorVisibility descriptorVisibility = TweetUtils.toDescriptorVisibility(javaMethod.getVisibility());
        if (resolveMethodSignature.receiverType != null) {
            map = TweetUtils.mapOf(new Pair(JavaMethodDescriptor.ORIGINAL_VALUE_PARAMETER_FOR_EXTENSION_RECEIVER, ArraysKt___ArraysJvmKt.first(resolveValueParameters.descriptors)));
        } else {
            map = ArraysKt___ArraysJvmKt.emptyMap();
        }
        createJavaMethod.initialize(receiverParameterDescriptor, dispatchReceiverParameter, list, list2, kotlinType2, convertFromFlags, descriptorVisibility, map);
        createJavaMethod.setParameterNamesStatus(resolveMethodSignature.hasStableParameterNames, resolveValueParameters.hasSynthesizedNames);
        if (!(!resolveMethodSignature.errors.isEmpty())) {
            return createJavaMethod;
        }
        SignaturePropagator signaturePropagator = childForMethod$default.components.signaturePropagator;
        List<String> list3 = resolveMethodSignature.errors;
        if (((AnonymousClass1) signaturePropagator) == null) {
            throw null;
        } else if (list3 == null) {
            AnonymousClass1.$$$reportNull$$$0(6);
            throw null;
        } else {
            throw new UnsupportedOperationException("Should not be called");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0130 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope.ResolvedValueParameters resolveValueParameters(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r23, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r24, java.util.List<? extends kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter> r25) {
        /*
            r22 = this;
            r0 = r23
            java.lang.String r1 = "c"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            java.lang.String r1 = "function"
            r14 = r24
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r1)
            java.lang.String r1 = "jValueParameters"
            r15 = r25
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r1)
            java.util.LinkedHashSet r1 = new java.util.LinkedHashSet
            r1.<init>()
            java.lang.Iterable r2 = kotlin.collections.ArraysKt___ArraysJvmKt.withIndex(r25)
            java.util.ArrayList r13 = new java.util.ArrayList
            r3 = 10
            int r3 = com.twitter.sdk.android.tweetui.TweetUtils.collectionSizeOrDefault(r2, r3)
            r13.<init>(r3)
            kotlin.collections.IndexingIterable r2 = (kotlin.collections.IndexingIterable) r2
            java.util.Iterator r16 = r2.iterator()
            r12 = 0
            r2 = 0
        L_0x0031:
            r3 = r16
            kotlin.collections.IndexingIterator r3 = (kotlin.collections.IndexingIterator) r3
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0165
            java.lang.Object r3 = r3.next()
            kotlin.collections.IndexedValue r3 = (kotlin.collections.IndexedValue) r3
            int r5 = r3.index
            T r3 = r3.value
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter r3 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter) r3
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r6 = com.twitter.sdk.android.tweetui.TweetUtils.resolveAnnotations(r0, r3)
            kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage r4 = kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage.COMMON
            r7 = 3
            r8 = 0
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes r4 = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt.toAttributes$default(r4, r12, r8, r7)
            kotlin.reflect.jvm.internal.impl.name.FqName r7 = kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames.PARAMETER_NAME_FQ_NAME
            java.lang.String r9 = "PARAMETER_NAME_FQ_NAME"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r9)
            r9 = r6
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations r9 = (kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations) r9
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor r7 = r9.findAnnotation(r7)
            if (r7 != 0) goto L_0x0065
            r7 = r8
            goto L_0x0069
        L_0x0065:
            kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue r7 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.firstArgument(r7)
        L_0x0069:
            if (r7 != 0) goto L_0x006c
            goto L_0x0075
        L_0x006c:
            boolean r9 = r7 instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue
            if (r9 != 0) goto L_0x0071
            r7 = r8
        L_0x0071:
            kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue r7 = (kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue) r7
            if (r7 != 0) goto L_0x0077
        L_0x0075:
            r7 = r8
            goto L_0x007b
        L_0x0077:
            T r7 = r7.value
            java.lang.String r7 = (java.lang.String) r7
        L_0x007b:
            boolean r9 = r3.isVararg()
            r10 = 1
            if (r9 == 0) goto L_0x00b3
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType r9 = r3.getType()
            boolean r11 = r9 instanceof kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType
            if (r11 == 0) goto L_0x008d
            r8 = r9
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType r8 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType) r8
        L_0x008d:
            if (r8 == 0) goto L_0x00a7
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver r9 = r0.typeResolver
            kotlin.reflect.jvm.internal.impl.types.KotlinType r4 = r9.transformArrayType(r8, r4, r10)
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r8 = r0.components
            kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor r8 = r8.module
            kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns r8 = r8.getBuiltIns()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r8 = r8.getArrayElementType(r4)
            kotlin.Pair r9 = new kotlin.Pair
            r9.<init>(r4, r8)
            goto L_0x00c2
        L_0x00a7:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            java.lang.String r1 = "Vararg parameter should be an array: "
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r3)
            r0.<init>(r1)
            throw r0
        L_0x00b3:
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver r9 = r0.typeResolver
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType r11 = r3.getType()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r4 = r9.transformJavaType(r11, r4)
            kotlin.Pair r9 = new kotlin.Pair
            r9.<init>(r4, r8)
        L_0x00c2:
            A r4 = r9.first
            r8 = r4
            kotlin.reflect.jvm.internal.impl.types.KotlinType r8 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r8
            B r4 = r9.second
            r17 = r4
            kotlin.reflect.jvm.internal.impl.types.KotlinType r17 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r17
            kotlin.reflect.jvm.internal.impl.name.Name r4 = r24.getName()
            java.lang.String r4 = r4.asString()
            java.lang.String r9 = "equals"
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r9)
            if (r4 == 0) goto L_0x00fc
            int r4 = r25.size()
            if (r4 != r10) goto L_0x00fc
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r4 = r0.components
            kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor r4 = r4.module
            kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns r4 = r4.getBuiltIns()
            kotlin.reflect.jvm.internal.impl.types.SimpleType r4 = r4.getNullableAnyType()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r8)
            if (r4 == 0) goto L_0x00fc
            java.lang.String r4 = "other"
            kotlin.reflect.jvm.internal.impl.name.Name r4 = kotlin.reflect.jvm.internal.impl.name.Name.identifier(r4)
            goto L_0x0130
        L_0x00fc:
            if (r7 == 0) goto L_0x0114
            int r4 = r7.length()
            if (r4 <= 0) goto L_0x0106
            r4 = 1
            goto L_0x0107
        L_0x0106:
            r4 = 0
        L_0x0107:
            if (r4 == 0) goto L_0x0114
            boolean r4 = r1.add(r7)
            if (r4 == 0) goto L_0x0114
            kotlin.reflect.jvm.internal.impl.name.Name r4 = kotlin.reflect.jvm.internal.impl.name.Name.identifier(r7)
            goto L_0x0130
        L_0x0114:
            kotlin.reflect.jvm.internal.impl.name.Name r4 = r3.getName()
            if (r4 != 0) goto L_0x011b
            r2 = 1
        L_0x011b:
            if (r4 != 0) goto L_0x0130
            java.lang.Integer r4 = java.lang.Integer.valueOf(r5)
            java.lang.String r7 = "p"
            java.lang.String r4 = kotlin.jvm.internal.Intrinsics.stringPlus(r7, r4)
            kotlin.reflect.jvm.internal.impl.name.Name r4 = kotlin.reflect.jvm.internal.impl.name.Name.identifier(r4)
            java.lang.String r7 = "identifier(\"p$index\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r7)
        L_0x0130:
            r18 = r2
            r7 = r4
            java.lang.String r2 = "if (function.name.asString() == \"equals\" &&\n                jValueParameters.size == 1 &&\n                c.module.builtIns.nullableAnyType == outType\n            ) {\n                // This is a hack to prevent numerous warnings on Kotlin classes that inherit Java classes: if you override \"equals\" in such\n                // class without this hack, you'll be warned that in the superclass the name is \"p0\" (regardless of the fact that it's\n                // \"other\" in Any)\n                // TODO: fix Java parameter name loading logic somehow (don't always load \"p0\", \"p1\", etc.)\n                Name.identifier(\"other\")\n            } else if (parameterName != null && parameterName.isNotEmpty() && usedNames.add(parameterName)) {\n                Name.identifier(parameterName)\n            } else {\n                // TODO: parameter names may be drawn from attached sources, which is slow; it's better to make them lazy\n                val javaName = javaParameter.name\n                if (javaName == null) synthesizedNames = true\n                javaName ?: Name.identifier(\"p$index\")\n            }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r2)
            kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl r11 = new kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl
            r4 = 0
            r9 = 0
            r10 = 0
            r19 = 0
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r2 = r0.components
            kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory r2 = r2.sourceElementFactory
            kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement r20 = r2.source(r3)
            r2 = r11
            r3 = r24
            r21 = r11
            r11 = r19
            r19 = 0
            r12 = r17
            r0 = r13
            r13 = r20
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            r2 = r21
            r0.add(r2)
            r13 = r0
            r2 = r18
            r12 = 0
            r0 = r23
            goto L_0x0031
        L_0x0165:
            r0 = r13
            java.util.List r0 = kotlin.collections.ArraysKt___ArraysJvmKt.toList(r0)
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$ResolvedValueParameters r1 = new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$ResolvedValueParameters
            r1.<init>(r0, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope.resolveValueParameters(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, java.util.List):kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$ResolvedValueParameters");
    }

    public String toString() {
        return Intrinsics.stringPlus("Lazy scope for ", getOwnerDescriptor());
    }
}
