package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.mpl.androidapp.login.LoginReactModule;
import com.razorpay.AnalyticsConstants;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin._Assertions;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithDifferentJvmName;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature;
import kotlin.reflect.jvm.internal.impl.load.java.ClassicBuiltinSpecialProperties;
import kotlin.reflect.jvm.internal.impl.load.java.JavaDescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.load.java.JavaIncompatibilityRulesOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAbi;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache.AnonymousClass1;
import kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator;
import kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator.PropagatedSignature;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaForKotlinOverridePropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope.MethodSignatureData;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.Result;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner.Default;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;

/* compiled from: LazyJavaClassMemberScope.kt */
public final class LazyJavaClassMemberScope extends LazyJavaScope {
    public final NotNullLazyValue<List<ClassConstructorDescriptor>> constructors;
    public final NotNullLazyValue<Map<Name, JavaField>> enumEntryIndex;
    public final JavaClass jClass;
    public final NotNullLazyValue<Set<Name>> nestedClassIndex;
    public final MemoizedFunctionToNullable<Name, ClassDescriptorBase> nestedClasses;
    public final ClassDescriptor ownerDescriptor;
    public final boolean skipRefinement;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public LazyJavaClassMemberScope(LazyJavaResolverContext lazyJavaResolverContext, ClassDescriptor classDescriptor, JavaClass javaClass, boolean z, LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        // Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "c");
        // Intrinsics.checkNotNullParameter(classDescriptor, "ownerDescriptor");
        // Intrinsics.checkNotNullParameter(javaClass, "jClass");
        super(lazyJavaResolverContext, lazyJavaClassMemberScope);
        this.ownerDescriptor = classDescriptor;
        this.jClass = javaClass;
        this.skipRefinement = z;
        this.constructors = lazyJavaResolverContext.components.storageManager.createLazyValue(new LazyJavaClassMemberScope$constructors$1(this, lazyJavaResolverContext));
        this.nestedClassIndex = lazyJavaResolverContext.components.storageManager.createLazyValue(new LazyJavaClassMemberScope$nestedClassIndex$1(this));
        this.enumEntryIndex = lazyJavaResolverContext.components.storageManager.createLazyValue(new LazyJavaClassMemberScope$enumEntryIndex$1(this));
        this.nestedClasses = lazyJavaResolverContext.components.storageManager.createMemoizedFunctionWithNullableValues(new LazyJavaClassMemberScope$nestedClasses$1(this, lazyJavaResolverContext));
    }

    public static final Collection access$searchMethodsByNameWithoutBuiltinMagic(LazyJavaClassMemberScope lazyJavaClassMemberScope, Name name) {
        Collection<JavaMethod> findMethodsByName = ((DeclaredMemberIndex) lazyJavaClassMemberScope.declaredMemberIndex.invoke()).findMethodsByName(name);
        ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(findMethodsByName, 10));
        for (JavaMethod resolveMethodToFunctionDescriptor : findMethodsByName) {
            arrayList.add(lazyJavaClassMemberScope.resolveMethodToFunctionDescriptor(resolveMethodToFunctionDescriptor));
        }
        return arrayList;
    }

    public static final Collection access$searchMethodsInSupertypesWithoutBuiltinMagic(LazyJavaClassMemberScope lazyJavaClassMemberScope, Name name) {
        Set<SimpleFunctionDescriptor> functionsFromSupertypes = lazyJavaClassMemberScope.getFunctionsFromSupertypes(name);
        ArrayList arrayList = new ArrayList();
        Iterator it = ((HashSet) functionsFromSupertypes).iterator();
        while (it.hasNext()) {
            Object next = it.next();
            SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) next;
            Intrinsics.checkNotNullParameter(simpleFunctionDescriptor, "<this>");
            boolean z = true;
            if (!(TweetUtils.getOverriddenBuiltinWithDifferentJvmName(simpleFunctionDescriptor) != null)) {
                BuiltinMethodsWithSpecialGenericSignature builtinMethodsWithSpecialGenericSignature = BuiltinMethodsWithSpecialGenericSignature.INSTANCE;
                if (BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava(simpleFunctionDescriptor) == null) {
                    z = false;
                }
            }
            if (!z) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public final void addAnnotationValueParameter(List<ValueParameterDescriptor> list, ConstructorDescriptor constructorDescriptor, int i, JavaMethod javaMethod, KotlinType kotlinType, KotlinType kotlinType2) {
        KotlinType kotlinType3 = null;
        if (Annotations.Companion != null) {
            Annotations annotations = Companion.EMPTY;
            Name name = javaMethod.getName();
            KotlinType makeNotNullable = TypeUtils.makeNotNullable(kotlinType);
            Intrinsics.checkNotNullExpressionValue(makeNotNullable, "makeNotNullable(returnType)");
            boolean hasAnnotationParameterDefaultValue = javaMethod.getHasAnnotationParameterDefaultValue();
            if (kotlinType2 != null) {
                kotlinType3 = TypeUtils.makeNotNullable(kotlinType2);
            }
            ValueParameterDescriptorImpl valueParameterDescriptorImpl = new ValueParameterDescriptorImpl(constructorDescriptor, null, i, annotations, name, makeNotNullable, hasAnnotationParameterDefaultValue, false, false, kotlinType3, this.f5943c.components.sourceElementFactory.source(javaMethod));
            List<ValueParameterDescriptor> list2 = list;
            list.add(valueParameterDescriptorImpl);
            return;
        }
        throw null;
    }

    public final void addFunctionFromSupertypes(Collection<SimpleFunctionDescriptor> collection, Name name, Collection<? extends SimpleFunctionDescriptor> collection2, boolean z) {
        ClassDescriptor classDescriptor = this.ownerDescriptor;
        JavaResolverComponents javaResolverComponents = this.f5943c.components;
        Collection<D> resolveOverridesForNonStaticMembers = TweetUtils.resolveOverridesForNonStaticMembers(name, collection2, collection, classDescriptor, javaResolverComponents.errorReporter, javaResolverComponents.kotlinTypeChecker.getOverridingUtil());
        Intrinsics.checkNotNullExpressionValue(resolveOverridesForNonStaticMembers, "resolveOverridesForNonStaticMembers(\n            name, functionsFromSupertypes, result, ownerDescriptor, c.components.errorReporter,\n            c.components.kotlinTypeChecker.overridingUtil\n        )");
        if (!z) {
            collection.addAll(resolveOverridesForNonStaticMembers);
            return;
        }
        List<T> plus = ArraysKt___ArraysJvmKt.plus(collection, (Iterable<? extends T>) resolveOverridesForNonStaticMembers);
        ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(resolveOverridesForNonStaticMembers, 10));
        Iterator it = ((HashSet) resolveOverridesForNonStaticMembers).iterator();
        while (it.hasNext()) {
            SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) it.next();
            SimpleFunctionDescriptor simpleFunctionDescriptor2 = (SimpleFunctionDescriptor) TweetUtils.getOverriddenSpecialBuiltin(simpleFunctionDescriptor);
            if (simpleFunctionDescriptor2 == null) {
                Intrinsics.checkNotNullExpressionValue(simpleFunctionDescriptor, "resolvedOverride");
            } else {
                Intrinsics.checkNotNullExpressionValue(simpleFunctionDescriptor, "resolvedOverride");
                simpleFunctionDescriptor = createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden(simpleFunctionDescriptor, simpleFunctionDescriptor2, plus);
            }
            arrayList.add(simpleFunctionDescriptor);
        }
        collection.addAll(arrayList);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x011f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void addOverriddenSpecialMethods(kotlin.reflect.jvm.internal.impl.name.Name r17, java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> r18, java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> r19, java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> r20, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, ? extends java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor>> r21) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            r2 = r20
            r3 = r21
            java.util.Iterator r4 = r19.iterator()
        L_0x000c:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0156
            java.lang.Object r5 = r4.next()
            kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r5 = (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) r5
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r6 = com.twitter.sdk.android.tweetui.TweetUtils.getOverriddenBuiltinWithDifferentJvmName(r5)
            kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r6 = (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) r6
            if (r6 != 0) goto L_0x0023
        L_0x0020:
            r10 = r17
            goto L_0x006c
        L_0x0023:
            java.lang.String r8 = com.twitter.sdk.android.tweetui.TweetUtils.getJvmMethodNameIfSpecial(r6)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            kotlin.reflect.jvm.internal.impl.name.Name r8 = kotlin.reflect.jvm.internal.impl.name.Name.identifier(r8)
            java.lang.String r9 = "identifier(nameInJava)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)
            java.lang.Object r8 = r3.invoke(r8)
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r8 = r8.iterator()
        L_0x003d:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x0020
            java.lang.Object r9 = r8.next()
            kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r9 = (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) r9
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor$CopyBuilder r9 = r9.newCopyBuilder()
            r10 = r17
            r9.setName(r10)
            r9.setSignatureChange()
            r9.setPreserveSourceElement()
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r9 = r9.build()
            kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r9 = (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) r9
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            boolean r11 = r0.doesOverrideRenamedDescriptor(r6, r9)
            if (r11 == 0) goto L_0x003d
            kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r6 = r0.createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden(r9, r6, r1)
            goto L_0x006d
        L_0x006c:
            r6 = 0
        L_0x006d:
            kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.addIfNotNull(r2, r6)
            kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature r6 = kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature.INSTANCE
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r6 = kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava(r5)
            if (r6 != 0) goto L_0x007a
            goto L_0x010f
        L_0x007a:
            kotlin.reflect.jvm.internal.impl.name.Name r8 = r6.getName()
            java.lang.String r9 = "overridden.name"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)
            java.lang.Object r8 = r3.invoke(r8)
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r8 = r8.iterator()
        L_0x008d:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x00a1
            java.lang.Object r9 = r8.next()
            r11 = r9
            kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r11 = (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) r11
            boolean r11 = r0.hasSameJvmDescriptorButDoesNotOverride(r11, r6)
            if (r11 == 0) goto L_0x008d
            goto L_0x00a2
        L_0x00a1:
            r9 = 0
        L_0x00a2:
            kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r9 = (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) r9
            if (r9 != 0) goto L_0x00a8
            r7 = 0
            goto L_0x0102
        L_0x00a8:
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor$CopyBuilder r8 = r9.newCopyBuilder()
            java.util.List r11 = r6.getValueParameters()
            java.lang.String r12 = "overridden.valueParameters"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r12)
            java.util.ArrayList r12 = new java.util.ArrayList
            r13 = 10
            int r13 = com.twitter.sdk.android.tweetui.TweetUtils.collectionSizeOrDefault(r11, r13)
            r12.<init>(r13)
            java.util.Iterator r11 = r11.iterator()
        L_0x00c4:
            boolean r13 = r11.hasNext()
            if (r13 == 0) goto L_0x00e6
            java.lang.Object r13 = r11.next()
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r13 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r13
            kotlin.reflect.jvm.internal.impl.load.java.descriptors.ValueParameterData r14 = new kotlin.reflect.jvm.internal.impl.load.java.descriptors.ValueParameterData
            kotlin.reflect.jvm.internal.impl.types.KotlinType r15 = r13.getType()
            java.lang.String r7 = "it.type"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, r7)
            boolean r7 = r13.declaresDefaultValue()
            r14.<init>(r15, r7)
            r12.add(r14)
            goto L_0x00c4
        L_0x00e6:
            java.util.List r7 = r9.getValueParameters()
            java.lang.String r9 = "override.valueParameters"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r9)
            java.util.List r7 = com.twitter.sdk.android.tweetui.TweetUtils.copyValueParameters(r12, r7, r6)
            r8.setValueParameters(r7)
            r8.setSignatureChange()
            r8.setPreserveSourceElement()
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r7 = r8.build()
            kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r7 = (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) r7
        L_0x0102:
            if (r7 != 0) goto L_0x0105
            goto L_0x010f
        L_0x0105:
            boolean r8 = r0.isVisibleAsFunctionInCurrentClass(r7)
            if (r8 == 0) goto L_0x010c
            goto L_0x010d
        L_0x010c:
            r7 = 0
        L_0x010d:
            if (r7 != 0) goto L_0x0111
        L_0x010f:
            r6 = 0
            goto L_0x0115
        L_0x0111:
            kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r6 = r0.createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden(r7, r6, r1)
        L_0x0115:
            kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.addIfNotNull(r2, r6)
            boolean r6 = r5.isSuspend()
            if (r6 != 0) goto L_0x011f
            goto L_0x0150
        L_0x011f:
            kotlin.reflect.jvm.internal.impl.name.Name r6 = r5.getName()
            java.lang.String r7 = "descriptor.name"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            java.lang.Object r6 = r3.invoke(r6)
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r6 = r6.iterator()
        L_0x0132:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0150
            java.lang.Object r7 = r6.next()
            kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r7 = (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) r7
            kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r7 = r0.createSuspendView(r7)
            if (r7 != 0) goto L_0x0145
            goto L_0x014c
        L_0x0145:
            boolean r8 = r0.doesOverride(r7, r5)
            if (r8 == 0) goto L_0x014c
            goto L_0x014d
        L_0x014c:
            r7 = 0
        L_0x014d:
            if (r7 == 0) goto L_0x0132
            goto L_0x0151
        L_0x0150:
            r7 = 0
        L_0x0151:
            kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.addIfNotNull(r2, r7)
            goto L_0x000c
        L_0x0156:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope.addOverriddenSpecialMethods(kotlin.reflect.jvm.internal.impl.name.Name, java.util.Collection, java.util.Collection, java.util.Collection, kotlin.jvm.functions.Function1):void");
    }

    public final void addPropertyOverrideByMethod(Set<? extends PropertyDescriptor> set, Collection<PropertyDescriptor> collection, Set<PropertyDescriptor> set2, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        SimpleFunctionDescriptor simpleFunctionDescriptor;
        PropertySetterDescriptorImpl propertySetterDescriptorImpl;
        PropertyGetterDescriptorImpl propertyGetterDescriptorImpl;
        PropertyDescriptorImpl propertyDescriptorImpl;
        Set<PropertyDescriptor> set3 = set2;
        Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function12 = function1;
        for (PropertyDescriptor propertyDescriptor : set) {
            Object obj = 0;
            if (doesClassOverridesProperty(propertyDescriptor, function12)) {
                SimpleFunctionDescriptor findGetterOverride = findGetterOverride(propertyDescriptor, function12);
                Intrinsics.checkNotNull(findGetterOverride);
                if (propertyDescriptor.isVar()) {
                    simpleFunctionDescriptor = findSetterOverride(propertyDescriptor, function12);
                    Intrinsics.checkNotNull(simpleFunctionDescriptor);
                } else {
                    simpleFunctionDescriptor = null;
                }
                boolean z = true;
                if (!(simpleFunctionDescriptor == null || simpleFunctionDescriptor.getModality() == findGetterOverride.getModality())) {
                    z = false;
                }
                if (!_Assertions.ENABLED || z) {
                    PropertyDescriptorImpl javaForKotlinOverridePropertyDescriptor = new JavaForKotlinOverridePropertyDescriptor(this.ownerDescriptor, findGetterOverride, simpleFunctionDescriptor, propertyDescriptor);
                    KotlinType returnType = findGetterOverride.getReturnType();
                    Intrinsics.checkNotNull(returnType);
                    javaForKotlinOverridePropertyDescriptor.setType(returnType, EmptyList.INSTANCE, getDispatchReceiverParameter(), null);
                    PropertyGetterDescriptorImpl createGetter = TweetUtils.createGetter(javaForKotlinOverridePropertyDescriptor, findGetterOverride.getAnnotations(), false, false, false, findGetterOverride.getSource());
                    createGetter.initialSignatureDescriptor = findGetterOverride;
                    createGetter.initialize(javaForKotlinOverridePropertyDescriptor.getType());
                    Intrinsics.checkNotNullExpressionValue(createGetter, "createGetter(\n            propertyDescriptor, getterMethod.annotations, /* isDefault = */false,\n            /* isExternal = */ false, /* isInline = */ false, getterMethod.source\n        ).apply {\n            initialSignatureDescriptor = getterMethod\n            initialize(propertyDescriptor.type)\n        }");
                    if (simpleFunctionDescriptor != null) {
                        List<ValueParameterDescriptor> valueParameters = simpleFunctionDescriptor.getValueParameters();
                        Intrinsics.checkNotNullExpressionValue(valueParameters, "setterMethod.valueParameters");
                        ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) ArraysKt___ArraysJvmKt.firstOrNull(valueParameters);
                        if (valueParameterDescriptor != null) {
                            propertyGetterDescriptorImpl = createGetter;
                            propertyDescriptorImpl = javaForKotlinOverridePropertyDescriptor;
                            propertySetterDescriptorImpl = TweetUtils.createSetter(javaForKotlinOverridePropertyDescriptor, simpleFunctionDescriptor.getAnnotations(), valueParameterDescriptor.getAnnotations(), false, false, false, simpleFunctionDescriptor.getVisibility(), simpleFunctionDescriptor.getSource());
                            propertySetterDescriptorImpl.initialSignatureDescriptor = simpleFunctionDescriptor;
                        } else {
                            throw new AssertionError(Intrinsics.stringPlus("No parameter found for ", simpleFunctionDescriptor));
                        }
                    } else {
                        propertyGetterDescriptorImpl = createGetter;
                        propertyDescriptorImpl = javaForKotlinOverridePropertyDescriptor;
                        propertySetterDescriptorImpl = null;
                    }
                    propertyDescriptorImpl.getter = propertyGetterDescriptorImpl;
                    propertyDescriptorImpl.setter = propertySetterDescriptorImpl;
                    propertyDescriptorImpl.backingField = null;
                    propertyDescriptorImpl.delegateField = null;
                    obj = propertyDescriptorImpl;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Different accessors modalities when creating overrides for ");
                    sb.append(propertyDescriptor);
                    sb.append(" in ");
                    sb.append(this.ownerDescriptor);
                    sb.append("for getter is ");
                    sb.append(findGetterOverride.getModality());
                    sb.append(", but for setter is ");
                    if (simpleFunctionDescriptor != null) {
                        obj = simpleFunctionDescriptor.getModality();
                    }
                    sb.append(obj);
                    throw new AssertionError(sb.toString());
                }
            }
            Collection<PropertyDescriptor> collection2 = collection;
            if (obj != 0) {
                collection2.add(obj);
                if (set3 != null) {
                    set3.add(propertyDescriptor);
                    return;
                }
                return;
            }
        }
    }

    public Set<Name> computeClassNames(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        return ArraysKt___ArraysJvmKt.plus((Set) this.nestedClassIndex.invoke(), (Iterable<? extends T>) ((Map) this.enumEntryIndex.invoke()).keySet());
    }

    public Set computeFunctionNames(DescriptorKindFilter descriptorKindFilter, Function1 function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        Collection<KotlinType> supertypes = this.ownerDescriptor.getTypeConstructor().getSupertypes();
        Intrinsics.checkNotNullExpressionValue(supertypes, "ownerDescriptor.typeConstructor.supertypes");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (KotlinType memberScope : supertypes) {
            TweetUtils.addAll(linkedHashSet, memberScope.getMemberScope().getFunctionNames());
        }
        linkedHashSet.addAll(((DeclaredMemberIndex) this.declaredMemberIndex.invoke()).getMethodNames());
        linkedHashSet.addAll(((DeclaredMemberIndex) this.declaredMemberIndex.invoke()).getRecordComponentNames());
        linkedHashSet.addAll(computeClassNames(descriptorKindFilter, function1));
        return linkedHashSet;
    }

    public void computeImplicitlyDeclaredFunctions(Collection<SimpleFunctionDescriptor> collection, Name name) {
        boolean z;
        Collection<SimpleFunctionDescriptor> collection2 = collection;
        Name name2 = name;
        Intrinsics.checkNotNullParameter(collection2, LoginReactModule.RESULT);
        Intrinsics.checkNotNullParameter(name2, "name");
        if (this.jClass.isRecord() && ((DeclaredMemberIndex) this.declaredMemberIndex.invoke()).findRecordComponentByName(name2) != null) {
            if (!collection.isEmpty()) {
                Iterator<T> it = collection.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (((SimpleFunctionDescriptor) it.next()).getValueParameters().isEmpty()) {
                            z = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            z = true;
            if (z) {
                JavaRecordComponent findRecordComponentByName = ((DeclaredMemberIndex) this.declaredMemberIndex.invoke()).findRecordComponentByName(name2);
                Intrinsics.checkNotNull(findRecordComponentByName);
                JavaMethodDescriptor createJavaMethod = JavaMethodDescriptor.createJavaMethod(this.ownerDescriptor, TweetUtils.resolveAnnotations(this.f5943c, findRecordComponentByName), findRecordComponentByName.getName(), this.f5943c.components.sourceElementFactory.source(findRecordComponentByName), true);
                Intrinsics.checkNotNullExpressionValue(createJavaMethod, "createJavaMethod(\n            ownerDescriptor, annotations, recordComponent.name, c.components.sourceElementFactory.source(recordComponent), true\n        )");
                KotlinType transformJavaType = this.f5943c.typeResolver.transformJavaType(findRecordComponentByName.getType(), JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, false, null, 2));
                ReceiverParameterDescriptor dispatchReceiverParameter = getDispatchReceiverParameter();
                EmptyList emptyList = EmptyList.INSTANCE;
                createJavaMethod.initialize(null, dispatchReceiverParameter, emptyList, emptyList, transformJavaType, Modality.Companion.convertFromFlags(false, false, true), DescriptorVisibilities.PUBLIC, null);
                createJavaMethod.setParameterNamesStatus(false, false);
                if (((AnonymousClass1) this.f5943c.components.javaResolverCache) != null) {
                    collection2.add(createJavaMethod);
                    return;
                }
                throw null;
            }
        }
    }

    public DeclaredMemberIndex computeMemberIndex() {
        return new ClassDeclaredMemberIndex(this.jClass, LazyJavaClassMemberScope$computeMemberIndex$1.INSTANCE);
    }

    public void computeNonDeclaredFunctions(Collection<SimpleFunctionDescriptor> collection, Name name) {
        boolean z;
        Intrinsics.checkNotNullParameter(collection, LoginReactModule.RESULT);
        Intrinsics.checkNotNullParameter(name, "name");
        Set<SimpleFunctionDescriptor> functionsFromSupertypes = getFunctionsFromSupertypes(name);
        BuiltinMethodsWithDifferentJvmName builtinMethodsWithDifferentJvmName = BuiltinMethodsWithDifferentJvmName.INSTANCE;
        Intrinsics.checkNotNullParameter(name, "<this>");
        if (!SpecialGenericSignatures.ORIGINAL_SHORT_NAMES.contains(name) && !BuiltinMethodsWithSpecialGenericSignature.INSTANCE.getSameAsBuiltinMethodWithErasedValueParameters(name)) {
            HashSet hashSet = (HashSet) functionsFromSupertypes;
            if (!hashSet.isEmpty()) {
                Iterator it = hashSet.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (((FunctionDescriptor) it.next()).isSuspend()) {
                            z = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            z = true;
            if (z) {
                ArrayList arrayList = new ArrayList();
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    Object next = it2.next();
                    if (isVisibleAsFunctionInCurrentClass((SimpleFunctionDescriptor) next)) {
                        arrayList.add(next);
                    }
                }
                addFunctionFromSupertypes(collection, name, arrayList, false);
                return;
            }
        }
        SmartSet create = SmartSet.Companion.create();
        Collection<D> resolveOverridesForNonStaticMembers = TweetUtils.resolveOverridesForNonStaticMembers(name, functionsFromSupertypes, EmptyList.INSTANCE, this.ownerDescriptor, ErrorReporter.DO_NOTHING, this.f5943c.components.kotlinTypeChecker.getOverridingUtil());
        Intrinsics.checkNotNullExpressionValue(resolveOverridesForNonStaticMembers, "resolveOverridesForNonStaticMembers(\n            name, functionsFromSupertypes, emptyList(), ownerDescriptor, ErrorReporter.DO_NOTHING,\n            c.components.kotlinTypeChecker.overridingUtil\n        )");
        Name name2 = name;
        Collection<SimpleFunctionDescriptor> collection2 = collection;
        Collection<D> collection3 = resolveOverridesForNonStaticMembers;
        addOverriddenSpecialMethods(name2, collection2, collection3, collection, new LazyJavaClassMemberScope$computeNonDeclaredFunctions$3(this));
        addOverriddenSpecialMethods(name2, collection2, collection3, create, new LazyJavaClassMemberScope$computeNonDeclaredFunctions$4(this));
        ArrayList arrayList2 = new ArrayList();
        Iterator it3 = ((HashSet) functionsFromSupertypes).iterator();
        while (it3.hasNext()) {
            Object next2 = it3.next();
            if (isVisibleAsFunctionInCurrentClass((SimpleFunctionDescriptor) next2)) {
                arrayList2.add(next2);
            }
        }
        addFunctionFromSupertypes(collection, name, ArraysKt___ArraysJvmKt.plus((Collection<? extends T>) arrayList2, (Iterable<? extends T>) create), true);
    }

    /* JADX WARNING: type inference failed for: r2v3, types: [java.util.Set] */
    /* JADX WARNING: type inference failed for: r4v6 */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r4v8, types: [java.util.HashSet, java.util.LinkedHashSet] */
    /* JADX WARNING: type inference failed for: r2v5, types: [java.util.Set] */
    /* JADX WARNING: type inference failed for: r4v14 */
    /* JADX WARNING: type inference failed for: r4v15 */
    /* JADX WARNING: type inference failed for: r2v9 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void computeNonDeclaredProperties(kotlin.reflect.jvm.internal.impl.name.Name r12, java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> r13) {
        /*
            r11 = this;
            java.lang.String r0 = "name"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "result"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass r0 = r11.jClass
            boolean r0 = r0.isAnnotationType()
            r1 = 0
            if (r0 == 0) goto L_0x0086
            kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue<kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex> r0 = r11.declaredMemberIndex
            java.lang.Object r0 = r0.invoke()
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex r0 = (kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex) r0
            java.util.Collection r0 = r0.findMethodsByName(r12)
            java.lang.Object r0 = kotlin.collections.ArraysKt___ArraysJvmKt.singleOrNull(r0)
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod r0 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod) r0
            if (r0 != 0) goto L_0x0028
            goto L_0x0086
        L_0x0028:
            kotlin.reflect.jvm.internal.impl.descriptors.Modality r4 = kotlin.reflect.jvm.internal.impl.descriptors.Modality.FINAL
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r2 = r11.f5943c
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r3 = com.twitter.sdk.android.tweetui.TweetUtils.resolveAnnotations(r2, r0)
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r2 = r11.ownerDescriptor
            kotlin.reflect.jvm.internal.impl.descriptors.Visibility r5 = r0.getVisibility()
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r5 = com.twitter.sdk.android.tweetui.TweetUtils.toDescriptorVisibility(r5)
            r6 = 0
            kotlin.reflect.jvm.internal.impl.name.Name r7 = r0.getName()
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r8 = r11.f5943c
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r8 = r8.components
            kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory r8 = r8.sourceElementFactory
            kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement r8 = r8.source(r0)
            r9 = 0
            kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor r2 = kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor.create(r2, r3, r4, r5, r6, r7, r8, r9)
            java.lang.String r3 = "create(\n            ownerDescriptor, annotations, modality, method.visibility.toDescriptorVisibility(),\n            /* isVar = */ false, method.name, c.components.sourceElementFactory.source(method),\n            /* isStaticFinal = */ false\n        )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations$Companion r3 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion
            if (r3 == 0) goto L_0x0085
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r3 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.EMPTY
            kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl r3 = com.twitter.sdk.android.tweetui.TweetUtils.createDefaultGetter(r2, r3)
            java.lang.String r4 = "createDefaultGetter(propertyDescriptor, Annotations.EMPTY)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r2.getter = r3
            r2.setter = r1
            r2.backingField = r1
            r2.delegateField = r1
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r4 = r11.f5943c
            r5 = 0
            r6 = 4
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r4 = com.twitter.sdk.android.tweetui.TweetUtils.childForMethod$default(r4, r2, r0, r5, r6)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = r11.computeMethodReturnType(r0, r4)
            kotlin.collections.EmptyList r4 = kotlin.collections.EmptyList.INSTANCE
            kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r5 = r11.getDispatchReceiverParameter()
            r2.setType(r0, r4, r5, r1)
            r3.returnType = r0
            r13.add(r2)
            goto L_0x0086
        L_0x0085:
            throw r1
        L_0x0086:
            java.util.Set r0 = r11.getPropertiesFromSupertypes(r12)
            boolean r2 = r0.isEmpty()
            if (r2 == 0) goto L_0x0091
            return
        L_0x0091:
            kotlin.reflect.jvm.internal.impl.utils.SmartSet r2 = kotlin.reflect.jvm.internal.impl.utils.SmartSet.Companion.create()
            kotlin.reflect.jvm.internal.impl.utils.SmartSet r3 = kotlin.reflect.jvm.internal.impl.utils.SmartSet.Companion.create()
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$computeNonDeclaredProperties$1 r4 = new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$computeNonDeclaredProperties$1
            r4.<init>(r11)
            r11.addPropertyOverrideByMethod(r0, r13, r2, r4)
            java.lang.String r4 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r4)
            java.lang.String r4 = "elements"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r4)
            java.util.Collection r2 = com.twitter.sdk.android.tweetui.TweetUtils.convertToSetForSetOperationWith(r2, r0)
            boolean r4 = r2.isEmpty()
            if (r4 == 0) goto L_0x00ba
            java.util.Set r2 = kotlin.collections.ArraysKt___ArraysJvmKt.toSet(r0)
            goto L_0x00e4
        L_0x00ba:
            boolean r4 = r2 instanceof java.util.Set
            if (r4 == 0) goto L_0x00db
            java.util.LinkedHashSet r4 = new java.util.LinkedHashSet
            r4.<init>()
            java.util.Iterator r5 = r0.iterator()
        L_0x00c7:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x00e3
            java.lang.Object r6 = r5.next()
            boolean r7 = r2.contains(r6)
            if (r7 != 0) goto L_0x00c7
            r4.add(r6)
            goto L_0x00c7
        L_0x00db:
            java.util.LinkedHashSet r4 = new java.util.LinkedHashSet
            r4.<init>(r0)
            r4.removeAll(r2)
        L_0x00e3:
            r2 = r4
        L_0x00e4:
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$computeNonDeclaredProperties$2 r4 = new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$computeNonDeclaredProperties$2
            r4.<init>(r11)
            r11.addPropertyOverrideByMethod(r2, r3, r1, r4)
            java.util.Set r6 = kotlin.collections.ArraysKt___ArraysJvmKt.plus(r0, r3)
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r8 = r11.ownerDescriptor
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r0 = r11.f5943c
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r0 = r0.components
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter r9 = r0.errorReporter
            kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker r0 = r0.kotlinTypeChecker
            kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil r10 = r0.getOverridingUtil()
            r5 = r12
            r7 = r13
            java.util.Collection r12 = com.twitter.sdk.android.tweetui.TweetUtils.resolveOverridesForNonStaticMembers(r5, r6, r7, r8, r9, r10)
            java.lang.String r0 = "resolveOverridesForNonStaticMembers(\n                name,\n                propertiesFromSupertypes + propertiesOverridesFromSuperTypes,\n                result,\n                ownerDescriptor,\n                c.components.errorReporter,\n                c.components.kotlinTypeChecker.overridingUtil\n            )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r0)
            r13.addAll(r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope.computeNonDeclaredProperties(kotlin.reflect.jvm.internal.impl.name.Name, java.util.Collection):void");
    }

    public Set<Name> computePropertyNames(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        if (this.jClass.isAnnotationType()) {
            return getFunctionNames();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(((DeclaredMemberIndex) this.declaredMemberIndex.invoke()).getFieldNames());
        Collection<KotlinType> supertypes = this.ownerDescriptor.getTypeConstructor().getSupertypes();
        Intrinsics.checkNotNullExpressionValue(supertypes, "ownerDescriptor.typeConstructor.supertypes");
        for (KotlinType memberScope : supertypes) {
            TweetUtils.addAll(linkedHashSet, memberScope.getMemberScope().getVariableNames());
        }
        return linkedHashSet;
    }

    public final Collection<KotlinType> computeSupertypes() {
        if (this.skipRefinement) {
            Collection<KotlinType> supertypes = this.ownerDescriptor.getTypeConstructor().getSupertypes();
            Intrinsics.checkNotNullExpressionValue(supertypes, "ownerDescriptor.typeConstructor.supertypes");
            return supertypes;
        }
        KotlinTypeRefiner kotlinTypeRefiner = this.f5943c.components.kotlinTypeChecker.getKotlinTypeRefiner();
        ClassDescriptor classDescriptor = this.ownerDescriptor;
        if (((Default) kotlinTypeRefiner) != null) {
            Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
            Collection<KotlinType> supertypes2 = classDescriptor.getTypeConstructor().getSupertypes();
            Intrinsics.checkNotNullExpressionValue(supertypes2, "classDescriptor.typeConstructor.supertypes");
            return supertypes2;
        }
        throw null;
    }

    public final SimpleFunctionDescriptor createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden(SimpleFunctionDescriptor simpleFunctionDescriptor, CallableDescriptor callableDescriptor, Collection<? extends SimpleFunctionDescriptor> collection) {
        boolean z;
        boolean z2 = true;
        if (!(collection instanceof Collection) || !collection.isEmpty()) {
            Iterator<T> it = collection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                SimpleFunctionDescriptor simpleFunctionDescriptor2 = (SimpleFunctionDescriptor) it.next();
                if (Intrinsics.areEqual(simpleFunctionDescriptor, simpleFunctionDescriptor2) || simpleFunctionDescriptor2.getInitialSignatureDescriptor() != null || !doesOverride(simpleFunctionDescriptor2, callableDescriptor)) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (z) {
                    z2 = false;
                    break;
                }
            }
        }
        if (z2) {
            return simpleFunctionDescriptor;
        }
        SimpleFunctionDescriptor simpleFunctionDescriptor3 = (SimpleFunctionDescriptor) simpleFunctionDescriptor.newCopyBuilder().setHiddenToOvercomeSignatureClash().build();
        Intrinsics.checkNotNull(simpleFunctionDescriptor3);
        return simpleFunctionDescriptor3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004a, code lost:
        if (kotlin.reflect.jvm.internal.impl.builtins.SuspendFunctionTypesKt.isContinuation(r3, r5.f5943c.components.settings.isReleaseCoroutines()) == false) goto L_0x0013;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor createSuspendView(kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r6) {
        /*
            r5 = this;
            java.util.List r0 = r6.getValueParameters()
            java.lang.String r1 = "valueParameters"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Object r0 = kotlin.collections.ArraysKt___ArraysJvmKt.lastOrNull(r0)
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r0
            r2 = 0
            if (r0 != 0) goto L_0x0015
        L_0x0013:
            r0 = r2
            goto L_0x004c
        L_0x0015:
            kotlin.reflect.jvm.internal.impl.types.KotlinType r3 = r0.getType()
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r3 = r3.getConstructor()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r3 = r3.getDeclarationDescriptor()
            if (r3 != 0) goto L_0x0025
            r3 = r2
            goto L_0x0029
        L_0x0025:
            kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe r3 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getFqNameUnsafe(r3)
        L_0x0029:
            if (r3 != 0) goto L_0x002d
        L_0x002b:
            r3 = r2
            goto L_0x003c
        L_0x002d:
            boolean r4 = r3.isSafe()
            if (r4 == 0) goto L_0x0034
            goto L_0x0035
        L_0x0034:
            r3 = r2
        L_0x0035:
            if (r3 != 0) goto L_0x0038
            goto L_0x002b
        L_0x0038:
            kotlin.reflect.jvm.internal.impl.name.FqName r3 = r3.toSafe()
        L_0x003c:
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r4 = r5.f5943c
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r4 = r4.components
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings r4 = r4.settings
            boolean r4 = r4.isReleaseCoroutines()
            boolean r3 = kotlin.reflect.jvm.internal.impl.builtins.SuspendFunctionTypesKt.isContinuation(r3, r4)
            if (r3 == 0) goto L_0x0013
        L_0x004c:
            if (r0 != 0) goto L_0x004f
            return r2
        L_0x004f:
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor$CopyBuilder r2 = r6.newCopyBuilder()
            java.util.List r6 = r6.getValueParameters()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r1)
            r1 = 1
            java.util.List r6 = kotlin.collections.ArraysKt___ArraysJvmKt.dropLast(r6, r1)
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor$CopyBuilder r6 = r2.setValueParameters(r6)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = r0.getType()
            java.util.List r0 = r0.getArguments()
            r2 = 0
            java.lang.Object r0 = r0.get(r2)
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r0 = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) r0
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = r0.getType()
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor$CopyBuilder r6 = r6.setReturnType(r0)
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r6 = r6.build()
            kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r6 = (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) r6
            r0 = r6
            kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl r0 = (kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl) r0
            if (r0 != 0) goto L_0x0086
            goto L_0x0088
        L_0x0086:
            r0.isSuspend = r1
        L_0x0088:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope.createSuspendView(kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor):kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor");
    }

    public final boolean doesClassOverridesProperty(PropertyDescriptor propertyDescriptor, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        boolean z = false;
        if (TweetUtils.isJavaField(propertyDescriptor)) {
            return false;
        }
        SimpleFunctionDescriptor findGetterOverride = findGetterOverride(propertyDescriptor, function1);
        SimpleFunctionDescriptor findSetterOverride = findSetterOverride(propertyDescriptor, function1);
        if (findGetterOverride == null) {
            return false;
        }
        if (!propertyDescriptor.isVar()) {
            return true;
        }
        if (findSetterOverride != null && findSetterOverride.getModality() == findGetterOverride.getModality()) {
            z = true;
        }
        return z;
    }

    public final boolean doesOverride(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
        Result result = OverridingUtil.DEFAULT.isOverridableByWithoutExternalConditions(callableDescriptor2, callableDescriptor, true).getResult();
        Intrinsics.checkNotNullExpressionValue(result, "DEFAULT.isOverridableByWithoutExternalConditions(superDescriptor, this, true).result");
        if (result != Result.OVERRIDABLE || JavaIncompatibilityRulesOverridabilityCondition.doesJavaOverrideHaveIncompatibleValueParameterKinds(callableDescriptor2, callableDescriptor)) {
            return false;
        }
        return true;
    }

    public final boolean doesOverrideRenamedDescriptor(SimpleFunctionDescriptor simpleFunctionDescriptor, FunctionDescriptor functionDescriptor) {
        BuiltinMethodsWithDifferentJvmName builtinMethodsWithDifferentJvmName = BuiltinMethodsWithDifferentJvmName.INSTANCE;
        Intrinsics.checkNotNullParameter(simpleFunctionDescriptor, "<this>");
        if (Intrinsics.areEqual(simpleFunctionDescriptor.getName().asString(), "removeAt") && Intrinsics.areEqual(MethodSignatureMappingKt.computeJvmSignature(simpleFunctionDescriptor), SpecialGenericSignatures.REMOVE_AT_NAME_AND_SIGNATURE.signature)) {
            functionDescriptor = functionDescriptor.getOriginal();
        }
        Intrinsics.checkNotNullExpressionValue(functionDescriptor, "if (superDescriptor.isRemoveAtByIndex) subDescriptor.original else subDescriptor");
        return doesOverride(functionDescriptor, simpleFunctionDescriptor);
    }

    public final SimpleFunctionDescriptor findGetterByName(PropertyDescriptor propertyDescriptor, String str, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        SimpleFunctionDescriptor simpleFunctionDescriptor;
        Name identifier = Name.identifier(str);
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(getterName)");
        Iterator it = ((Iterable) function1.invoke(identifier)).iterator();
        do {
            simpleFunctionDescriptor = null;
            if (!it.hasNext()) {
                break;
            }
            SimpleFunctionDescriptor simpleFunctionDescriptor2 = (SimpleFunctionDescriptor) it.next();
            if (simpleFunctionDescriptor2.getValueParameters().size() == 0) {
                KotlinTypeChecker kotlinTypeChecker = KotlinTypeChecker.DEFAULT;
                KotlinType returnType = simpleFunctionDescriptor2.getReturnType();
                if (returnType == null ? false : kotlinTypeChecker.isSubtypeOf(returnType, propertyDescriptor.getType())) {
                    simpleFunctionDescriptor = simpleFunctionDescriptor2;
                    continue;
                } else {
                    continue;
                }
            }
        } while (simpleFunctionDescriptor == null);
        return simpleFunctionDescriptor;
    }

    public final SimpleFunctionDescriptor findGetterOverride(PropertyDescriptor propertyDescriptor, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        PropertyGetterDescriptor getter = propertyDescriptor.getGetter();
        String str = null;
        CallableMemberDescriptor callableMemberDescriptor = getter == null ? null : (PropertyGetterDescriptor) TweetUtils.getOverriddenBuiltinWithDifferentJvmName(getter);
        if (callableMemberDescriptor != null) {
            str = ClassicBuiltinSpecialProperties.INSTANCE.getBuiltinSpecialPropertyGetterName(callableMemberDescriptor);
        }
        if (str != null && !TweetUtils.hasRealKotlinSuperClassWithOverrideOf(this.ownerDescriptor, callableMemberDescriptor)) {
            return findGetterByName(propertyDescriptor, str, function1);
        }
        JvmAbi jvmAbi = JvmAbi.INSTANCE;
        String asString = propertyDescriptor.getName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "name.asString()");
        return findGetterByName(propertyDescriptor, JvmAbi.getterName(asString), function1);
    }

    public final SimpleFunctionDescriptor findSetterOverride(PropertyDescriptor propertyDescriptor, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        SimpleFunctionDescriptor simpleFunctionDescriptor;
        JvmAbi jvmAbi = JvmAbi.INSTANCE;
        String asString = propertyDescriptor.getName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "name.asString()");
        Name identifier = Name.identifier(JvmAbi.setterName(asString));
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(JvmAbi.setterName(name.asString()))");
        Iterator it = ((Iterable) function1.invoke(identifier)).iterator();
        do {
            simpleFunctionDescriptor = null;
            if (!it.hasNext()) {
                break;
            }
            SimpleFunctionDescriptor simpleFunctionDescriptor2 = (SimpleFunctionDescriptor) it.next();
            if (simpleFunctionDescriptor2.getValueParameters().size() == 1) {
                KotlinType returnType = simpleFunctionDescriptor2.getReturnType();
                if (returnType != null && KotlinBuiltIns.isUnit(returnType)) {
                    KotlinTypeChecker kotlinTypeChecker = KotlinTypeChecker.DEFAULT;
                    List<ValueParameterDescriptor> valueParameters = simpleFunctionDescriptor2.getValueParameters();
                    Intrinsics.checkNotNullExpressionValue(valueParameters, "descriptor.valueParameters");
                    if (kotlinTypeChecker.equalTypes(((ValueParameterDescriptor) ArraysKt___ArraysJvmKt.single(valueParameters)).getType(), propertyDescriptor.getType())) {
                        simpleFunctionDescriptor = simpleFunctionDescriptor2;
                        continue;
                    } else {
                        continue;
                    }
                }
            }
        } while (simpleFunctionDescriptor == null);
        return simpleFunctionDescriptor;
    }

    public final DescriptorVisibility getConstructorVisibility(ClassDescriptor classDescriptor) {
        DescriptorVisibility visibility = classDescriptor.getVisibility();
        Intrinsics.checkNotNullExpressionValue(visibility, "classDescriptor.visibility");
        if (!Intrinsics.areEqual(visibility, JavaDescriptorVisibilities.PROTECTED_STATIC_VISIBILITY)) {
            return visibility;
        }
        DescriptorVisibility descriptorVisibility = JavaDescriptorVisibilities.PROTECTED_AND_PACKAGE;
        Intrinsics.checkNotNullExpressionValue(descriptorVisibility, "PROTECTED_AND_PACKAGE");
        return descriptorVisibility;
    }

    public ClassifierDescriptor getContributedClassifier(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        recordLookup(name, lookupLocation);
        LazyJavaClassMemberScope lazyJavaClassMemberScope = (LazyJavaClassMemberScope) this.mainScope;
        ClassDescriptorBase classDescriptorBase = null;
        if (lazyJavaClassMemberScope != null) {
            MemoizedFunctionToNullable<Name, ClassDescriptorBase> memoizedFunctionToNullable = lazyJavaClassMemberScope.nestedClasses;
            if (memoizedFunctionToNullable != null) {
                classDescriptorBase = (ClassDescriptorBase) memoizedFunctionToNullable.invoke(name);
            }
        }
        return classDescriptorBase == null ? (ClassifierDescriptor) this.nestedClasses.invoke(name) : classDescriptorBase;
    }

    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        recordLookup(name, lookupLocation);
        return super.getContributedFunctions(name, lookupLocation);
    }

    public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        recordLookup(name, lookupLocation);
        return super.getContributedVariables(name, lookupLocation);
    }

    public ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return DescriptorUtils.getDispatchReceiverParameterIfNeeded(this.ownerDescriptor);
    }

    public final Set<SimpleFunctionDescriptor> getFunctionsFromSupertypes(Name name) {
        Collection<KotlinType> computeSupertypes = computeSupertypes();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (KotlinType memberScope : computeSupertypes) {
            TweetUtils.addAll(linkedHashSet, memberScope.getMemberScope().getContributedFunctions(name, NoLookupLocation.WHEN_GET_SUPER_MEMBERS));
        }
        return linkedHashSet;
    }

    public DeclarationDescriptor getOwnerDescriptor() {
        return this.ownerDescriptor;
    }

    public final Set<PropertyDescriptor> getPropertiesFromSupertypes(Name name) {
        Collection<KotlinType> computeSupertypes = computeSupertypes();
        ArrayList arrayList = new ArrayList();
        for (KotlinType memberScope : computeSupertypes) {
            Collection<? extends PropertyDescriptor> contributedVariables = memberScope.getMemberScope().getContributedVariables(name, NoLookupLocation.WHEN_GET_SUPER_MEMBERS);
            ArrayList arrayList2 = new ArrayList(TweetUtils.collectionSizeOrDefault(contributedVariables, 10));
            for (PropertyDescriptor add : contributedVariables) {
                arrayList2.add(add);
            }
            TweetUtils.addAll(arrayList, arrayList2);
        }
        return ArraysKt___ArraysJvmKt.toSet(arrayList);
    }

    public final boolean hasSameJvmDescriptorButDoesNotOverride(SimpleFunctionDescriptor simpleFunctionDescriptor, FunctionDescriptor functionDescriptor) {
        String computeJvmDescriptor$default = MethodSignatureMappingKt.computeJvmDescriptor$default(simpleFunctionDescriptor, false, false, 2);
        FunctionDescriptor original = functionDescriptor.getOriginal();
        Intrinsics.checkNotNullExpressionValue(original, "builtinWithErasedParameters.original");
        if (!Intrinsics.areEqual(computeJvmDescriptor$default, MethodSignatureMappingKt.computeJvmDescriptor$default(original, false, false, 2)) || doesOverride(simpleFunctionDescriptor, functionDescriptor)) {
            return false;
        }
        return true;
    }

    public boolean isVisibleAsFunction(JavaMethodDescriptor javaMethodDescriptor) {
        Intrinsics.checkNotNullParameter(javaMethodDescriptor, "<this>");
        if (this.jClass.isAnnotationType()) {
            return false;
        }
        return isVisibleAsFunctionInCurrentClass(javaMethodDescriptor);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00dd, code lost:
        if (kotlin.text.CharsKt__CharKt.startsWith$default(r3, (java.lang.String) "set", false, 2) == false) goto L_0x00df;
     */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0234  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x00e4 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00ee A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01f3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isVisibleAsFunctionInCurrentClass(kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r12) {
        /*
            r11 = this;
            kotlin.reflect.jvm.internal.impl.name.Name r0 = r12.getName()
            java.lang.String r1 = "function.name"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.String r1 = "name"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            java.lang.String r2 = r0.asString()
            java.lang.String r3 = "name.asString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            kotlin.reflect.jvm.internal.impl.load.java.JvmAbi r3 = kotlin.reflect.jvm.internal.impl.load.java.JvmAbi.INSTANCE
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)
            java.lang.String r3 = "get"
            r4 = 0
            r5 = 2
            boolean r6 = kotlin.text.CharsKt__CharKt.startsWith$default(r2, r3, r4, r5)
            r7 = 1
            java.lang.String r8 = "is"
            if (r6 != 0) goto L_0x0032
            boolean r6 = kotlin.text.CharsKt__CharKt.startsWith$default(r2, r8, r4, r5)
            if (r6 == 0) goto L_0x0030
            goto L_0x0032
        L_0x0030:
            r6 = 0
            goto L_0x0033
        L_0x0032:
            r6 = 1
        L_0x0033:
            java.lang.String r9 = "methodName"
            java.lang.String r10 = "set"
            if (r6 == 0) goto L_0x0050
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r9)
            r2 = 0
            r6 = 12
            kotlin.reflect.jvm.internal.impl.name.Name r3 = com.twitter.sdk.android.tweetui.TweetUtils.propertyNameFromAccessorMethodName$default(r0, r3, r4, r2, r6)
            if (r3 != 0) goto L_0x004b
            r3 = 8
            kotlin.reflect.jvm.internal.impl.name.Name r3 = com.twitter.sdk.android.tweetui.TweetUtils.propertyNameFromAccessorMethodName$default(r0, r8, r4, r2, r3)
        L_0x004b:
            java.util.List r0 = com.twitter.sdk.android.tweetui.TweetUtils.listOfNotNull(r3)
            goto L_0x0084
        L_0x0050:
            kotlin.reflect.jvm.internal.impl.load.java.JvmAbi r3 = kotlin.reflect.jvm.internal.impl.load.java.JvmAbi.INSTANCE
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)
            boolean r2 = kotlin.text.CharsKt__CharKt.startsWith$default(r2, r10, r4, r5)
            if (r2 == 0) goto L_0x0071
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r9)
            kotlin.reflect.jvm.internal.impl.name.Name[] r2 = new kotlin.reflect.jvm.internal.impl.name.Name[r5]
            kotlin.reflect.jvm.internal.impl.name.Name r3 = com.twitter.sdk.android.tweetui.TweetUtils.propertyNameBySetMethodName(r0, r4)
            r2[r4] = r3
            kotlin.reflect.jvm.internal.impl.name.Name r0 = com.twitter.sdk.android.tweetui.TweetUtils.propertyNameBySetMethodName(r0, r7)
            r2[r7] = r0
            java.util.List r0 = com.twitter.sdk.android.tweetui.TweetUtils.listOfNotNull((T[]) r2)
            goto L_0x0084
        L_0x0071:
            kotlin.reflect.jvm.internal.impl.load.java.BuiltinSpecialProperties r2 = kotlin.reflect.jvm.internal.impl.load.java.BuiltinSpecialProperties.INSTANCE
            java.lang.String r2 = "name1"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            java.util.Map<kotlin.reflect.jvm.internal.impl.name.Name, java.util.List<kotlin.reflect.jvm.internal.impl.name.Name>> r2 = kotlin.reflect.jvm.internal.impl.load.java.BuiltinSpecialProperties.GETTER_JVM_NAME_TO_PROPERTIES_SHORT_NAME_MAP
            java.lang.Object r0 = r2.get(r0)
            java.util.List r0 = (java.util.List) r0
            if (r0 != 0) goto L_0x0084
            kotlin.collections.EmptyList r0 = kotlin.collections.EmptyList.INSTANCE
        L_0x0084:
            boolean r2 = r0.isEmpty()
            if (r2 == 0) goto L_0x008b
            goto L_0x00eb
        L_0x008b:
            java.util.Iterator r0 = r0.iterator()
        L_0x008f:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x00eb
            java.lang.Object r2 = r0.next()
            kotlin.reflect.jvm.internal.impl.name.Name r2 = (kotlin.reflect.jvm.internal.impl.name.Name) r2
            java.util.Set r2 = r11.getPropertiesFromSupertypes(r2)
            boolean r3 = r2.isEmpty()
            if (r3 == 0) goto L_0x00a6
            goto L_0x00e6
        L_0x00a6:
            java.util.Iterator r2 = r2.iterator()
        L_0x00aa:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x00e6
            java.lang.Object r3 = r2.next()
            kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor) r3
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$isVisibleAsFunctionInCurrentClass$1$1$1 r6 = new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$isVisibleAsFunctionInCurrentClass$1$1$1
            r6.<init>(r12, r11)
            boolean r6 = r11.doesClassOverridesProperty(r3, r6)
            if (r6 == 0) goto L_0x00e1
            boolean r3 = r3.isVar()
            if (r3 != 0) goto L_0x00df
            kotlin.reflect.jvm.internal.impl.load.java.JvmAbi r3 = kotlin.reflect.jvm.internal.impl.load.java.JvmAbi.INSTANCE
            kotlin.reflect.jvm.internal.impl.name.Name r3 = r12.getName()
            java.lang.String r3 = r3.asString()
            java.lang.String r6 = "function.name.asString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r6)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r1)
            boolean r3 = kotlin.text.CharsKt__CharKt.startsWith$default(r3, r10, r4, r5)
            if (r3 != 0) goto L_0x00e1
        L_0x00df:
            r3 = 1
            goto L_0x00e2
        L_0x00e1:
            r3 = 0
        L_0x00e2:
            if (r3 == 0) goto L_0x00aa
            r2 = 1
            goto L_0x00e7
        L_0x00e6:
            r2 = 0
        L_0x00e7:
            if (r2 == 0) goto L_0x008f
            r0 = 1
            goto L_0x00ec
        L_0x00eb:
            r0 = 0
        L_0x00ec:
            if (r0 == 0) goto L_0x00ef
            return r4
        L_0x00ef:
            kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithDifferentJvmName r0 = kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithDifferentJvmName.INSTANCE
            kotlin.reflect.jvm.internal.impl.name.Name r0 = r12.getName()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            java.util.Map<kotlin.reflect.jvm.internal.impl.name.Name, java.util.List<kotlin.reflect.jvm.internal.impl.name.Name>> r2 = kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.JVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP
            java.lang.Object r0 = r2.get(r0)
            java.util.List r0 = (java.util.List) r0
            if (r0 != 0) goto L_0x0107
            kotlin.collections.EmptyList r0 = kotlin.collections.EmptyList.INSTANCE
        L_0x0107:
            boolean r2 = r0.isEmpty()
            if (r2 == 0) goto L_0x010f
            goto L_0x0190
        L_0x010f:
            java.util.Iterator r0 = r0.iterator()
        L_0x0113:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0190
            java.lang.Object r2 = r0.next()
            kotlin.reflect.jvm.internal.impl.name.Name r2 = (kotlin.reflect.jvm.internal.impl.name.Name) r2
            java.util.Set r3 = r11.getFunctionsFromSupertypes(r2)
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.HashSet r3 = (java.util.HashSet) r3
            java.util.Iterator r3 = r3.iterator()
        L_0x012e:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L_0x014f
            java.lang.Object r6 = r3.next()
            r7 = r6
            kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r7 = (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) r7
            java.lang.String r8 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r8)
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r7 = com.twitter.sdk.android.tweetui.TweetUtils.getOverriddenBuiltinWithDifferentJvmName(r7)
            if (r7 == 0) goto L_0x0148
            r7 = 1
            goto L_0x0149
        L_0x0148:
            r7 = 0
        L_0x0149:
            if (r7 == 0) goto L_0x012e
            r5.add(r6)
            goto L_0x012e
        L_0x014f:
            boolean r3 = r5.isEmpty()
            if (r3 == 0) goto L_0x0156
            goto L_0x018b
        L_0x0156:
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor$CopyBuilder r3 = r12.newCopyBuilder()
            r3.setName(r2)
            r3.setSignatureChange()
            r3.setPreserveSourceElement()
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r2 = r3.build()
            kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) r2
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            boolean r3 = r5.isEmpty()
            if (r3 == 0) goto L_0x0173
            goto L_0x018b
        L_0x0173:
            java.util.Iterator r3 = r5.iterator()
        L_0x0177:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x018b
            java.lang.Object r5 = r3.next()
            kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r5 = (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) r5
            boolean r5 = r11.doesOverrideRenamedDescriptor(r5, r2)
            if (r5 == 0) goto L_0x0177
            r2 = 1
            goto L_0x018c
        L_0x018b:
            r2 = 0
        L_0x018c:
            if (r2 == 0) goto L_0x0113
            r0 = 1
            goto L_0x0191
        L_0x0190:
            r0 = 0
        L_0x0191:
            if (r0 != 0) goto L_0x0235
            kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature r0 = kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature.INSTANCE
            kotlin.reflect.jvm.internal.impl.name.Name r2 = r12.getName()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)
            boolean r0 = r0.getSameAsBuiltinMethodWithErasedValueParameters(r2)
            if (r0 != 0) goto L_0x01a3
            goto L_0x01f0
        L_0x01a3:
            kotlin.reflect.jvm.internal.impl.name.Name r0 = r12.getName()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.util.Set r0 = r11.getFunctionsFromSupertypes(r0)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.HashSet r0 = (java.util.HashSet) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x01b9:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x01d1
            java.lang.Object r3 = r0.next()
            kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) r3
            kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature r5 = kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature.INSTANCE
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r3 = kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava(r3)
            if (r3 == 0) goto L_0x01b9
            r2.add(r3)
            goto L_0x01b9
        L_0x01d1:
            boolean r0 = r2.isEmpty()
            if (r0 == 0) goto L_0x01d8
            goto L_0x01f0
        L_0x01d8:
            java.util.Iterator r0 = r2.iterator()
        L_0x01dc:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x01f0
            java.lang.Object r2 = r0.next()
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r2
            boolean r2 = r11.hasSameJvmDescriptorButDoesNotOverride(r12, r2)
            if (r2 == 0) goto L_0x01dc
            r0 = 1
            goto L_0x01f1
        L_0x01f0:
            r0 = 0
        L_0x01f1:
            if (r0 != 0) goto L_0x0235
            kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r0 = r11.createSuspendView(r12)
            if (r0 != 0) goto L_0x01fa
            goto L_0x0231
        L_0x01fa:
            kotlin.reflect.jvm.internal.impl.name.Name r12 = r12.getName()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r1)
            java.util.Set r12 = r11.getFunctionsFromSupertypes(r12)
            java.util.HashSet r12 = (java.util.HashSet) r12
            boolean r1 = r12.isEmpty()
            if (r1 == 0) goto L_0x020e
            goto L_0x0231
        L_0x020e:
            java.util.Iterator r12 = r12.iterator()
        L_0x0212:
            boolean r1 = r12.hasNext()
            if (r1 == 0) goto L_0x0231
            java.lang.Object r1 = r12.next()
            kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r1 = (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) r1
            boolean r2 = r1.isSuspend()
            if (r2 == 0) goto L_0x022c
            boolean r1 = r11.doesOverride(r0, r1)
            if (r1 == 0) goto L_0x022c
            r1 = 1
            goto L_0x022d
        L_0x022c:
            r1 = 0
        L_0x022d:
            if (r1 == 0) goto L_0x0212
            r12 = 1
            goto L_0x0232
        L_0x0231:
            r12 = 0
        L_0x0232:
            if (r12 != 0) goto L_0x0235
            r4 = 1
        L_0x0235:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope.isVisibleAsFunctionInCurrentClass(kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor):boolean");
    }

    public void recordLookup(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        TweetUtils.record(this.f5943c.components.lookupTracker, lookupLocation, this.ownerDescriptor, name);
    }

    public MethodSignatureData resolveMethodSignature(JavaMethod javaMethod, List<? extends TypeParameterDescriptor> list, KotlinType kotlinType, List<? extends ValueParameterDescriptor> list2) {
        Intrinsics.checkNotNullParameter(javaMethod, AnalyticsConstants.METHOD);
        Intrinsics.checkNotNullParameter(list, "methodTypeParameters");
        Intrinsics.checkNotNullParameter(kotlinType, "returnType");
        Intrinsics.checkNotNullParameter(list2, "valueParameters");
        SignaturePropagator signaturePropagator = this.f5943c.components.signaturePropagator;
        ClassDescriptor classDescriptor = this.ownerDescriptor;
        if (((SignaturePropagator.AnonymousClass1) signaturePropagator) == null) {
            throw null;
        } else if (classDescriptor != null) {
            List emptyList = Collections.emptyList();
            if (emptyList != null) {
                Intrinsics.checkNotNullExpressionValue(kotlinType, "propagated.returnType");
                Intrinsics.checkNotNullExpressionValue(list2, "propagated.valueParameters");
                Intrinsics.checkNotNullExpressionValue(list, "propagated.typeParameters");
                Intrinsics.checkNotNullExpressionValue(emptyList, "propagated.errors");
                MethodSignatureData methodSignatureData = new MethodSignatureData(kotlinType, null, list2, list, false, emptyList);
                return methodSignatureData;
            }
            PropagatedSignature.$$$reportNull$$$0(3);
            throw null;
        } else {
            SignaturePropagator.AnonymousClass1.$$$reportNull$$$0(1);
            throw null;
        }
    }

    public String toString() {
        return Intrinsics.stringPlus("Lazy Java member scope for ", this.jClass.getFqName());
    }
}
