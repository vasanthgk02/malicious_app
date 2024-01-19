package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;

/* compiled from: LazyJavaClassMemberScope.kt */
public final class LazyJavaClassMemberScope$constructors$1 extends Lambda implements Function0<List<? extends ClassConstructorDescriptor>> {
    public final /* synthetic */ LazyJavaResolverContext $c;
    public final /* synthetic */ LazyJavaClassMemberScope this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public LazyJavaClassMemberScope$constructors$1(LazyJavaClassMemberScope lazyJavaClassMemberScope, LazyJavaResolverContext lazyJavaResolverContext) {
        // this.this$0 = lazyJavaClassMemberScope;
        // this.$c = lazyJavaResolverContext;
        super(0);
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [java.util.Collection] */
    /* JADX WARNING: type inference failed for: r2v4, types: [java.util.List] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object invoke() {
        /*
            r27 = this;
            r0 = r27
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope r1 = r0.this$0
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass r1 = r1.jClass
            java.util.Collection r1 = r1.getConstructors()
            java.util.ArrayList r2 = new java.util.ArrayList
            int r3 = r1.size()
            r2.<init>(r3)
            java.util.Iterator r1 = r1.iterator()
        L_0x0017:
            boolean r3 = r1.hasNext()
            r4 = 0
            if (r3 == 0) goto L_0x00cc
            java.lang.Object r3 = r1.next()
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor r3 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor) r3
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope r5 = r0.this$0
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r6 = r5.ownerDescriptor
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r7 = r5.f5943c
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r7 = com.twitter.sdk.android.tweetui.TweetUtils.resolveAnnotations(r7, r3)
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r8 = r5.f5943c
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r8 = r8.components
            kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory r8 = r8.sourceElementFactory
            kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement r8 = r8.source(r3)
            kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassConstructorDescriptor r7 = kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassConstructorDescriptor.createJavaConstructor(r6, r7, r4, r8)
            java.lang.String r8 = "createJavaConstructor(\n            classDescriptor,\n            c.resolveAnnotations(constructor), /* isPrimary = */\n            false,\n            c.components.sourceElementFactory.source(constructor)\n        )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r8 = r5.f5943c
            java.util.List r9 = r6.getDeclaredTypeParameters()
            int r9 = r9.size()
            java.lang.String r10 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r10)
            java.lang.String r10 = "containingDeclaration"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r10)
            java.lang.String r10 = "typeParameterOwner"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r10)
            kotlin.Lazy<kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType> r10 = r8.delegateForDefaultTypeQualifiers
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r8 = com.twitter.sdk.android.tweetui.TweetUtils.child(r8, r7, r3, r9, r10)
            java.util.List r9 = r3.getValueParameters()
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$ResolvedValueParameters r5 = r5.resolveValueParameters(r8, r7, r9)
            java.util.List r9 = r6.getDeclaredTypeParameters()
            java.lang.String r10 = "classDescriptor.declaredTypeParameters"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)
            java.util.List r10 = r3.getTypeParameters()
            java.util.ArrayList r11 = new java.util.ArrayList
            r12 = 10
            int r12 = com.twitter.sdk.android.tweetui.TweetUtils.collectionSizeOrDefault(r10, r12)
            r11.<init>(r12)
            java.util.Iterator r10 = r10.iterator()
        L_0x0085:
            boolean r12 = r10.hasNext()
            if (r12 == 0) goto L_0x009e
            java.lang.Object r12 = r10.next()
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter r12 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter) r12
            kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver r13 = r8.typeParameterResolver
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r12 = r13.resolveTypeParameter(r12)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            r11.add(r12)
            goto L_0x0085
        L_0x009e:
            java.util.List r9 = kotlin.collections.ArraysKt___ArraysJvmKt.plus(r9, r11)
            java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> r10 = r5.descriptors
            kotlin.reflect.jvm.internal.impl.descriptors.Visibility r11 = r3.getVisibility()
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r11 = com.twitter.sdk.android.tweetui.TweetUtils.toDescriptorVisibility(r11)
            r7.initialize(r10, r11, r9)
            r7.setHasStableParameterNames(r4)
            boolean r4 = r5.hasSynthesizedNames
            r7.setHasSynthesizedParameterNames(r4)
            kotlin.reflect.jvm.internal.impl.types.SimpleType r4 = r6.getDefaultType()
            r7.setReturnType(r4)
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r4 = r8.components
            kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache r4 = r4.javaResolverCache
            kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache$1 r4 = (kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache.AnonymousClass1) r4
            r4.recordConstructor(r3, r7)
            r2.add(r7)
            goto L_0x0017
        L_0x00cc:
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope r1 = r0.this$0
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass r1 = r1.jClass
            boolean r1 = r1.isRecord()
            java.lang.String r3 = "createJavaConstructor(\n            classDescriptor, Annotations.EMPTY, /* isPrimary = */ true, c.components.sourceElementFactory.source(jClass)\n        )"
            r5 = 0
            r6 = 2
            r7 = 1
            if (r1 == 0) goto L_0x01e6
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope r1 = r0.this$0
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r8 = r1.ownerDescriptor
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations$Companion r9 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion
            if (r9 == 0) goto L_0x01e5
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r9 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.EMPTY
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r10 = r1.f5943c
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r10 = r10.components
            kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory r10 = r10.sourceElementFactory
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass r11 = r1.jClass
            kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement r10 = r10.source(r11)
            kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassConstructorDescriptor r9 = kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassConstructorDescriptor.createJavaConstructor(r8, r9, r7, r10)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r3)
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass r10 = r1.jClass
            java.util.Collection r10 = r10.getRecordComponents()
            java.util.ArrayList r15 = new java.util.ArrayList
            int r11 = r10.size()
            r15.<init>(r11)
            kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage r11 = kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage.COMMON
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes r14 = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt.toAttributes$default(r11, r4, r5, r6)
            java.util.Iterator r10 = r10.iterator()
            r16 = 0
        L_0x0113:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x018e
            int r23 = r16 + 1
            java.lang.Object r11 = r10.next()
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent r11 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent) r11
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r12 = r1.f5943c
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver r12 = r12.typeResolver
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType r13 = r11.getType()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r13 = r12.transformJavaType(r13, r14)
            boolean r12 = r11.isVararg()
            if (r12 == 0) goto L_0x0144
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r12 = r1.f5943c
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r12 = r12.components
            kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor r12 = r12.module
            kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns r12 = r12.getBuiltIns()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r12 = r12.getArrayElementType(r13)
            r21 = r12
            goto L_0x0146
        L_0x0144:
            r21 = r5
        L_0x0146:
            kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl r12 = new kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl
            r17 = 0
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations$Companion r18 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion
            if (r18 == 0) goto L_0x018d
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r18 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.EMPTY
            kotlin.reflect.jvm.internal.impl.name.Name r19 = r11.getName()
            r20 = 0
            r22 = 0
            r24 = 0
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r7 = r1.f5943c
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r7 = r7.components
            kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory r7 = r7.sourceElementFactory
            kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement r7 = r7.source(r11)
            r11 = r12
            r6 = r12
            r12 = r9
            r25 = r13
            r13 = r17
            r26 = r14
            r14 = r16
            r4 = r15
            r15 = r18
            r16 = r19
            r17 = r25
            r18 = r20
            r19 = r22
            r20 = r24
            r22 = r7
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            r4.add(r6)
            r15 = r4
            r16 = r23
            r14 = r26
            r4 = 0
            r6 = 2
            r7 = 1
            goto L_0x0113
        L_0x018d:
            throw r5
        L_0x018e:
            r4 = r15
            r6 = 0
            r9.setHasSynthesizedParameterNames(r6)
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r1 = r1.getConstructorVisibility(r8)
            r9.initialize(r4, r1)
            r9.setHasStableParameterNames(r6)
            kotlin.reflect.jvm.internal.impl.types.SimpleType r1 = r8.getDefaultType()
            r9.setReturnType(r1)
            r1 = 2
            java.lang.String r4 = kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt.computeJvmDescriptor$default(r9, r6, r6, r1)
            boolean r7 = r2.isEmpty()
            if (r7 == 0) goto L_0x01b0
            goto L_0x01cf
        L_0x01b0:
            java.util.Iterator r7 = r2.iterator()
        L_0x01b4:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x01cf
            java.lang.Object r8 = r7.next()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor r8 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor) r8
            java.lang.String r8 = kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt.computeJvmDescriptor$default(r8, r6, r6, r1)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r4)
            if (r1 == 0) goto L_0x01cc
            r1 = 0
            goto L_0x01d0
        L_0x01cc:
            r1 = 2
            r6 = 0
            goto L_0x01b4
        L_0x01cf:
            r1 = 1
        L_0x01d0:
            if (r1 == 0) goto L_0x01e6
            r2.add(r9)
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r1 = r0.$c
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r1 = r1.components
            kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache r1 = r1.javaResolverCache
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope r4 = r0.this$0
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass r4 = r4.jClass
            kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache$1 r1 = (kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache.AnonymousClass1) r1
            r1.recordConstructor(r4, r9)
            goto L_0x01e6
        L_0x01e5:
            throw r5
        L_0x01e6:
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r1 = r0.$c
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r4 = r1.components
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement r4 = r4.signatureEnhancement
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope r13 = r0.this$0
            boolean r6 = r2.isEmpty()
            if (r6 == 0) goto L_0x0346
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass r2 = r13.jClass
            boolean r2 = r2.isAnnotationType()
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass r6 = r13.jClass
            boolean r6 = r6.isInterface()
            if (r6 != 0) goto L_0x020a
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass r6 = r13.jClass
            boolean r6 = r6.hasDefaultConstructor()
            if (r6 != 0) goto L_0x020e
        L_0x020a:
            if (r2 != 0) goto L_0x020e
            goto L_0x0340
        L_0x020e:
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r14 = r13.ownerDescriptor
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations$Companion r6 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion
            if (r6 == 0) goto L_0x0345
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r6 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.EMPTY
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r7 = r13.f5943c
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r7 = r7.components
            kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory r7 = r7.sourceElementFactory
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass r8 = r13.jClass
            kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement r7 = r7.source(r8)
            r8 = 1
            kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassConstructorDescriptor r15 = kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassConstructorDescriptor.createJavaConstructor(r14, r6, r8, r7)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, r3)
            if (r2 == 0) goto L_0x0318
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass r2 = r13.jClass
            java.util.Collection r2 = r2.getMethods()
            java.util.ArrayList r3 = new java.util.ArrayList
            int r6 = r2.size()
            r3.<init>(r6)
            kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage r6 = kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage.COMMON
            r7 = 2
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes r12 = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt.toAttributes$default(r6, r8, r5, r7)
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.util.Iterator r2 = r2.iterator()
        L_0x0250:
            boolean r7 = r2.hasNext()
            if (r7 == 0) goto L_0x0271
            java.lang.Object r7 = r2.next()
            r8 = r7
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod r8 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod) r8
            kotlin.reflect.jvm.internal.impl.name.Name r8 = r8.getName()
            kotlin.reflect.jvm.internal.impl.name.Name r9 = kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames.DEFAULT_ANNOTATION_MEMBER_NAME
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r9)
            if (r8 == 0) goto L_0x026d
            r6.add(r7)
            goto L_0x0250
        L_0x026d:
            r11.add(r7)
            goto L_0x0250
        L_0x0271:
            int r2 = r6.size()
            r7 = 1
            if (r2 > r7) goto L_0x027a
            r2 = 1
            goto L_0x027b
        L_0x027a:
            r2 = 0
        L_0x027b:
            boolean r7 = kotlin._Assertions.ENABLED
            if (r7 == 0) goto L_0x0290
            if (r2 == 0) goto L_0x0282
            goto L_0x0290
        L_0x0282:
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass r1 = r13.jClass
            java.lang.String r2 = "There can't be more than one method named 'value' in annotation class: "
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r1)
            java.lang.AssertionError r2 = new java.lang.AssertionError
            r2.<init>(r1)
            throw r2
        L_0x0290:
            java.lang.Object r2 = kotlin.collections.ArraysKt___ArraysJvmKt.firstOrNull(r6)
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod r2 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod) r2
            if (r2 == 0) goto L_0x02e4
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType r6 = r2.getReturnType()
            boolean r7 = r6 instanceof kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType
            if (r7 == 0) goto L_0x02bd
            kotlin.Pair r5 = new kotlin.Pair
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r7 = r13.f5943c
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver r7 = r7.typeResolver
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType r6 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType) r6
            r8 = 1
            kotlin.reflect.jvm.internal.impl.types.KotlinType r7 = r7.transformArrayType(r6, r12, r8)
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r8 = r13.f5943c
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver r8 = r8.typeResolver
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType r6 = r6.getComponentType()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r6 = r8.transformJavaType(r6, r12)
            r5.<init>(r7, r6)
            goto L_0x02cb
        L_0x02bd:
            kotlin.Pair r7 = new kotlin.Pair
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r8 = r13.f5943c
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver r8 = r8.typeResolver
            kotlin.reflect.jvm.internal.impl.types.KotlinType r6 = r8.transformJavaType(r6, r12)
            r7.<init>(r6, r5)
            r5 = r7
        L_0x02cb:
            A r6 = r5.first
            r16 = r6
            kotlin.reflect.jvm.internal.impl.types.KotlinType r16 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r16
            B r5 = r5.second
            kotlin.reflect.jvm.internal.impl.types.KotlinType r5 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r5
            r9 = 0
            r6 = r13
            r7 = r3
            r8 = r15
            r10 = r2
            r17 = r11
            r11 = r16
            r0 = r12
            r12 = r5
            r6.addAnnotationValueParameter(r7, r8, r9, r10, r11, r12)
            goto L_0x02e7
        L_0x02e4:
            r17 = r11
            r0 = r12
        L_0x02e7:
            if (r2 == 0) goto L_0x02eb
            r2 = 1
            goto L_0x02ec
        L_0x02eb:
            r2 = 0
        L_0x02ec:
            java.util.Iterator r5 = r17.iterator()
            r6 = 0
        L_0x02f1:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x031c
            int r16 = r6 + 1
            java.lang.Object r7 = r5.next()
            r10 = r7
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod r10 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod) r10
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r7 = r13.f5943c
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver r7 = r7.typeResolver
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType r8 = r10.getReturnType()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r11 = r7.transformJavaType(r8, r0)
            int r9 = r6 + r2
            r12 = 0
            r6 = r13
            r7 = r3
            r8 = r15
            r6.addAnnotationValueParameter(r7, r8, r9, r10, r11, r12)
            r6 = r16
            goto L_0x02f1
        L_0x0318:
            java.util.List r3 = java.util.Collections.emptyList()
        L_0x031c:
            r0 = 0
            r15.setHasSynthesizedParameterNames(r0)
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r0 = r13.getConstructorVisibility(r14)
            r15.initialize(r3, r0)
            r0 = 1
            r15.setHasStableParameterNames(r0)
            kotlin.reflect.jvm.internal.impl.types.SimpleType r0 = r14.getDefaultType()
            r15.setReturnType(r0)
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r0 = r13.f5943c
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r0 = r0.components
            kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache r0 = r0.javaResolverCache
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass r2 = r13.jClass
            kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache$1 r0 = (kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache.AnonymousClass1) r0
            r0.recordConstructor(r2, r15)
            r5 = r15
        L_0x0340:
            java.util.List r2 = com.twitter.sdk.android.tweetui.TweetUtils.listOfNotNull(r5)
            goto L_0x0346
        L_0x0345:
            throw r5
        L_0x0346:
            java.util.Collection r0 = r4.enhanceSignatures(r1, r2)
            java.util.List r0 = kotlin.collections.ArraysKt___ArraysJvmKt.toList(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$constructors$1.invoke():java.lang.Object");
    }
}
