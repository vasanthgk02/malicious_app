package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import com.facebook.react.bridge.ColorPropConverter;
import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPrimitiveType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;

/* compiled from: JavaTypeResolver.kt */
public final class JavaTypeResolver {

    /* renamed from: c  reason: collision with root package name */
    public final LazyJavaResolverContext f5945c;
    public final TypeParameterResolver typeParameterResolver;

    public JavaTypeResolver(LazyJavaResolverContext lazyJavaResolverContext, TypeParameterResolver typeParameterResolver2) {
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "c");
        Intrinsics.checkNotNullParameter(typeParameterResolver2, "typeParameterResolver");
        this.f5945c = lazyJavaResolverContext;
        this.typeParameterResolver = typeParameterResolver2;
    }

    public static final SimpleType transformJavaClassifierType$errorType(JavaClassifierType javaClassifierType) {
        SimpleType createErrorType = ErrorUtils.createErrorType(Intrinsics.stringPlus("Unresolved java class ", javaClassifierType.getPresentableText()));
        Intrinsics.checkNotNullExpressionValue(createErrorType, "createErrorType(\"Unresolved java class ${javaType.presentableText}\")");
        return createErrorType;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01eb, code lost:
        if ((!r2.isEmpty()) != false) goto L_0x01f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x012d, code lost:
        if (r2 == false) goto L_0x015a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x01fe  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0245  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x019a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x019b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.reflect.jvm.internal.impl.types.SimpleType computeSimpleJavaClassifierType(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType r13, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes r14, kotlin.reflect.jvm.internal.impl.types.SimpleType r15) {
        /*
            r12 = this;
            r0 = 0
            if (r15 != 0) goto L_0x0005
            r1 = r0
            goto L_0x0009
        L_0x0005:
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r1 = r15.getAnnotations()
        L_0x0009:
            r2 = 4
            r3 = 0
            if (r1 != 0) goto L_0x0014
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations r1 = new kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r4 = r12.f5945c
            r1.<init>(r4, r13, r3, r2)
        L_0x0014:
            r5 = r1
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifier r1 = r13.getClassifier()
            r4 = 1
            if (r1 != 0) goto L_0x0023
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r1 = r12.createNotFoundClass(r13)
        L_0x0020:
            r6 = r1
            goto L_0x0198
        L_0x0023:
            boolean r6 = r1 instanceof kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
            if (r6 == 0) goto L_0x0182
            r6 = r1
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass r6 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass) r6
            kotlin.reflect.jvm.internal.impl.name.FqName r7 = r6.getFqName()
            if (r7 == 0) goto L_0x0176
            boolean r1 = r14.isForAnnotationParameter
            if (r1 == 0) goto L_0x0098
            kotlin.reflect.jvm.internal.impl.name.FqName r1 = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt.JAVA_LANG_CLASS_FQ_NAME
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r1)
            if (r1 == 0) goto L_0x0098
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r1 = r12.f5945c
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r1 = r1.components
            kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes r1 = r1.reflectionTypes
            kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes$ClassLookup r2 = r1.kClass$delegate
            kotlin.reflect.KProperty<java.lang.Object>[] r7 = kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes.$$delegatedProperties
            r7 = r7[r4]
            if (r2 == 0) goto L_0x0097
            java.lang.String r8 = "types"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r8)
            java.lang.String r8 = "property"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r8)
            java.lang.String r7 = r7.getName()
            java.lang.String r7 = kotlin.text.CharsKt__CharKt.capitalize(r7)
            int r2 = r2.numberOfTypeParameters
            kotlin.reflect.jvm.internal.impl.name.Name r7 = kotlin.reflect.jvm.internal.impl.name.Name.identifier(r7)
            java.lang.String r8 = "identifier(className)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
            kotlin.Lazy r8 = r1.kotlinReflectScope$delegate
            java.lang.Object r8 = r8.getValue()
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r8 = (kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope) r8
            kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation r9 = kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_REFLECTION
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r8 = r8.getContributedClassifier(r7, r9)
            boolean r9 = r8 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r9 == 0) goto L_0x007d
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r8 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r8
            goto L_0x007e
        L_0x007d:
            r8 = r0
        L_0x007e:
            if (r8 != 0) goto L_0x015a
            kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses r1 = r1.notFoundClasses
            kotlin.reflect.jvm.internal.impl.name.ClassId r8 = new kotlin.reflect.jvm.internal.impl.name.ClassId
            kotlin.reflect.jvm.internal.impl.name.FqName r9 = kotlin.reflect.jvm.internal.impl.builtins.StandardNames.KOTLIN_REFLECT_FQ_NAME
            r8.<init>(r9, r7)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.util.List r2 = com.twitter.sdk.android.tweetui.TweetUtils.listOf(r2)
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r8 = r1.getClass(r8, r2)
            goto L_0x015a
        L_0x0097:
            throw r0
        L_0x0098:
            kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper r1 = kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper.INSTANCE
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r8 = r12.f5945c
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r8 = r8.components
            kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor r8 = r8.module
            kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns r8 = r8.getBuiltIns()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r8 = kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper.mapJavaToKotlin$default(r1, r7, r8, r0, r2)
            if (r8 != 0) goto L_0x00ad
            r8 = r0
            goto L_0x015a
        L_0x00ad:
            boolean r2 = r1.isReadOnly(r8)
            if (r2 == 0) goto L_0x015a
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeFlexibility r2 = r14.flexibility
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeFlexibility r7 = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND
            if (r2 == r7) goto L_0x0156
            kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage r2 = r14.howThisTypeIsUsed
            kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage r7 = kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage.SUPERTYPE
            if (r2 == r7) goto L_0x0156
            java.util.List r2 = r13.getTypeArguments()
            java.lang.Object r2 = kotlin.collections.ArraysKt___ArraysJvmKt.lastOrNull(r2)
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType r2 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType) r2
            boolean r7 = r2 instanceof kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType
            if (r7 == 0) goto L_0x00d0
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType r2 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType) r2
            goto L_0x00d1
        L_0x00d0:
            r2 = r0
        L_0x00d1:
            if (r2 != 0) goto L_0x00d4
            goto L_0x00e2
        L_0x00d4:
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType r7 = r2.getBound()
            if (r7 == 0) goto L_0x00e2
            boolean r2 = r2.isExtends()
            if (r2 != 0) goto L_0x00e2
            r2 = 1
            goto L_0x00e3
        L_0x00e2:
            r2 = 0
        L_0x00e3:
            if (r2 != 0) goto L_0x00e6
            goto L_0x012c
        L_0x00e6:
            java.lang.String r2 = "readOnly"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r2)
            kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe r2 = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.getFqName(r8)
            kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap r7 = kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap.INSTANCE
            java.util.HashMap<kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe, kotlin.reflect.jvm.internal.impl.name.FqName> r7 = kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap.readOnlyToMutable
            java.lang.Object r2 = r7.get(r2)
            kotlin.reflect.jvm.internal.impl.name.FqName r2 = (kotlin.reflect.jvm.internal.impl.name.FqName) r2
            if (r2 == 0) goto L_0x0130
            kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns r7 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getBuiltIns(r8)
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r2 = r7.getBuiltInClassByFqName(r2)
            java.lang.String r7 = "descriptor.builtIns.getBuiltInClassByFqName(oppositeClassFqName)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r7)
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r2 = r2.getTypeConstructor()
            java.util.List r2 = r2.getParameters()
            java.lang.String r7 = "JavaToKotlinClassMapper.convertReadOnlyToMutable(readOnlyContainer)\n            .typeConstructor.parameters"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r7)
            java.lang.Object r2 = kotlin.collections.ArraysKt___ArraysJvmKt.lastOrNull(r2)
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r2
            if (r2 != 0) goto L_0x011f
            r2 = r0
            goto L_0x0123
        L_0x011f:
            kotlin.reflect.jvm.internal.impl.types.Variance r2 = r2.getVariance()
        L_0x0123:
            if (r2 != 0) goto L_0x0126
            goto L_0x012c
        L_0x0126:
            kotlin.reflect.jvm.internal.impl.types.Variance r7 = kotlin.reflect.jvm.internal.impl.types.Variance.OUT_VARIANCE
            if (r2 == r7) goto L_0x012c
            r2 = 1
            goto L_0x012d
        L_0x012c:
            r2 = 0
        L_0x012d:
            if (r2 == 0) goto L_0x015a
            goto L_0x0156
        L_0x0130:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r15 = "Given class "
            r14.append(r15)
            r14.append(r8)
            java.lang.String r15 = " is not a "
            r14.append(r15)
            java.lang.String r15 = "read-only"
            r14.append(r15)
            java.lang.String r15 = " collection"
            r14.append(r15)
            java.lang.String r14 = r14.toString()
            r13.<init>(r14)
            throw r13
        L_0x0156:
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r8 = r1.convertReadOnlyToMutable(r8)
        L_0x015a:
            if (r8 != 0) goto L_0x0166
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r1 = r12.f5945c
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r1 = r1.components
            kotlin.reflect.jvm.internal.impl.load.java.lazy.ModuleClassResolver r1 = r1.moduleClassResolver
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r8 = r1.resolveClass(r6)
        L_0x0166:
            if (r8 != 0) goto L_0x016a
            r1 = r0
            goto L_0x016e
        L_0x016a:
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r1 = r8.getTypeConstructor()
        L_0x016e:
            if (r1 != 0) goto L_0x0020
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r1 = r12.createNotFoundClass(r13)
            goto L_0x0020
        L_0x0176:
            java.lang.String r13 = "Class type should have a FQ name: "
            java.lang.String r13 = kotlin.jvm.internal.Intrinsics.stringPlus(r13, r1)
            java.lang.AssertionError r14 = new java.lang.AssertionError
            r14.<init>(r13)
            throw r14
        L_0x0182:
            boolean r2 = r1 instanceof kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter
            if (r2 == 0) goto L_0x034f
            kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver r2 = r12.typeParameterResolver
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter r1 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter) r1
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r1 = r2.resolveTypeParameter(r1)
            if (r1 != 0) goto L_0x0192
            r6 = r0
            goto L_0x0198
        L_0x0192:
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r1 = r1.getTypeConstructor()
            goto L_0x0020
        L_0x0198:
            if (r6 != 0) goto L_0x019b
            return r0
        L_0x019b:
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeFlexibility r1 = r14.flexibility
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeFlexibility r2 = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND
            if (r1 != r2) goto L_0x01a4
            r1 = 0
            r8 = 0
            goto L_0x01b2
        L_0x01a4:
            boolean r1 = r14.isForAnnotationParameter
            if (r1 != 0) goto L_0x01b0
            kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage r1 = r14.howThisTypeIsUsed
            kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage r2 = kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage.SUPERTYPE
            if (r1 == r2) goto L_0x01b0
            r1 = 1
            goto L_0x01b1
        L_0x01b0:
            r1 = 0
        L_0x01b1:
            r8 = r1
        L_0x01b2:
            if (r15 != 0) goto L_0x01b6
            r1 = r0
            goto L_0x01ba
        L_0x01b6:
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r1 = r15.getConstructor()
        L_0x01ba:
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r6)
            if (r1 == 0) goto L_0x01cd
            boolean r1 = r13.isRaw()
            if (r1 != 0) goto L_0x01cd
            if (r8 == 0) goto L_0x01cd
            kotlin.reflect.jvm.internal.impl.types.SimpleType r13 = r15.makeNullableAsSpecified(r4)
            return r13
        L_0x01cd:
            boolean r15 = r13.isRaw()
            java.lang.String r1 = "constructor.parameters"
            if (r15 != 0) goto L_0x01f0
            java.util.List r2 = r13.getTypeArguments()
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x01ee
            java.util.List r2 = r6.getParameters()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)
            boolean r2 = r2.isEmpty()
            r2 = r2 ^ r4
            if (r2 == 0) goto L_0x01ee
            goto L_0x01f0
        L_0x01ee:
            r2 = 0
            goto L_0x01f1
        L_0x01f0:
            r2 = 1
        L_0x01f1:
            java.util.List r4 = r6.getParameters()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r1)
            java.lang.String r1 = "parameter"
            r7 = 10
            if (r2 == 0) goto L_0x0245
            java.util.ArrayList r13 = new java.util.ArrayList
            int r0 = com.twitter.sdk.android.tweetui.TweetUtils.collectionSizeOrDefault(r4, r7)
            r13.<init>(r0)
            java.util.Iterator r0 = r4.iterator()
        L_0x020b:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x023e
            java.lang.Object r2 = r0.next()
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r2
            kotlin.reflect.jvm.internal.impl.types.LazyWrappedType r3 = new kotlin.reflect.jvm.internal.impl.types.LazyWrappedType
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r4 = r12.f5945c
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r4 = r4.components
            kotlin.reflect.jvm.internal.impl.storage.StorageManager r4 = r4.storageManager
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver$computeArguments$1$erasedUpperBound$1 r7 = new kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver$computeArguments$1$erasedUpperBound$1
            r7.<init>(r2, r14, r6)
            r3.<init>(r4, r7)
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawSubstitution r4 = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawSubstitution.INSTANCE
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)
            if (r15 == 0) goto L_0x0230
            r7 = r14
            goto L_0x0236
        L_0x0230:
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeFlexibility r7 = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeFlexibility.INFLEXIBLE
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes r7 = r14.withFlexibility(r7)
        L_0x0236:
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r2 = r4.computeProjection(r2, r7, r3)
            r13.add(r2)
            goto L_0x020b
        L_0x023e:
            java.util.List r13 = kotlin.collections.ArraysKt___ArraysJvmKt.toList(r13)
        L_0x0242:
            r7 = r13
            goto L_0x0345
        L_0x0245:
            int r14 = r4.size()
            java.util.List r15 = r13.getTypeArguments()
            int r15 = r15.size()
            if (r14 == r15) goto L_0x0286
            java.util.ArrayList r13 = new java.util.ArrayList
            int r14 = com.twitter.sdk.android.tweetui.TweetUtils.collectionSizeOrDefault(r4, r7)
            r13.<init>(r14)
            java.util.Iterator r14 = r4.iterator()
        L_0x0260:
            boolean r15 = r14.hasNext()
            if (r15 == 0) goto L_0x0281
            java.lang.Object r15 = r14.next()
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r15 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r15
            kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl r0 = new kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl
            kotlin.reflect.jvm.internal.impl.name.Name r15 = r15.getName()
            java.lang.String r15 = r15.asString()
            kotlin.reflect.jvm.internal.impl.types.SimpleType r15 = kotlin.reflect.jvm.internal.impl.types.ErrorUtils.createErrorType(r15)
            r0.<init>(r15)
            r13.add(r0)
            goto L_0x0260
        L_0x0281:
            java.util.List r13 = kotlin.collections.ArraysKt___ArraysJvmKt.toList(r13)
            goto L_0x0242
        L_0x0286:
            java.util.List r13 = r13.getTypeArguments()
            java.lang.Iterable r13 = kotlin.collections.ArraysKt___ArraysJvmKt.withIndex(r13)
            java.util.ArrayList r14 = new java.util.ArrayList
            int r15 = com.twitter.sdk.android.tweetui.TweetUtils.collectionSizeOrDefault(r13, r7)
            r14.<init>(r15)
            kotlin.collections.IndexingIterable r13 = (kotlin.collections.IndexingIterable) r13
            java.util.Iterator r13 = r13.iterator()
        L_0x029d:
            r15 = r13
            kotlin.collections.IndexingIterator r15 = (kotlin.collections.IndexingIterator) r15
            boolean r2 = r15.hasNext()
            if (r2 == 0) goto L_0x033f
            java.lang.Object r15 = r15.next()
            kotlin.collections.IndexedValue r15 = (kotlin.collections.IndexedValue) r15
            int r2 = r15.index
            T r15 = r15.value
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType r15 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType) r15
            int r7 = r4.size()
            if (r2 >= r7) goto L_0x02ba
            r7 = 1
            goto L_0x02bb
        L_0x02ba:
            r7 = 0
        L_0x02bb:
            boolean r9 = kotlin._Assertions.ENABLED
            if (r9 == 0) goto L_0x02db
            if (r7 == 0) goto L_0x02c2
            goto L_0x02db
        L_0x02c2:
            java.lang.String r13 = "Argument index should be less then type parameters count, but "
            java.lang.String r14 = " > "
            java.lang.StringBuilder r13 = com.android.tools.r8.GeneratedOutlineSupport.outline74(r13, r2, r14)
            int r14 = r4.size()
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            java.lang.AssertionError r14 = new java.lang.AssertionError
            r14.<init>(r13)
            throw r14
        L_0x02db:
            java.lang.Object r2 = r4.get(r2)
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r2
            kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage r7 = kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage.COMMON
            r9 = 3
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes r7 = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt.toAttributes$default(r7, r3, r0, r9)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)
            boolean r10 = r15 instanceof kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType
            if (r10 == 0) goto L_0x032e
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType r15 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType) r15
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType r10 = r15.getBound()
            boolean r15 = r15.isExtends()
            if (r15 == 0) goto L_0x02fe
            kotlin.reflect.jvm.internal.impl.types.Variance r15 = kotlin.reflect.jvm.internal.impl.types.Variance.OUT_VARIANCE
            goto L_0x0300
        L_0x02fe:
            kotlin.reflect.jvm.internal.impl.types.Variance r15 = kotlin.reflect.jvm.internal.impl.types.Variance.IN_VARIANCE
        L_0x0300:
            if (r10 == 0) goto L_0x0329
            kotlin.reflect.jvm.internal.impl.types.Variance r0 = r2.getVariance()
            kotlin.reflect.jvm.internal.impl.types.Variance r11 = kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT
            if (r0 != r11) goto L_0x030b
            goto L_0x0313
        L_0x030b:
            kotlin.reflect.jvm.internal.impl.types.Variance r0 = r2.getVariance()
            if (r15 == r0) goto L_0x0313
            r0 = 1
            goto L_0x0314
        L_0x0313:
            r0 = 0
        L_0x0314:
            if (r0 == 0) goto L_0x0318
            r0 = 0
            goto L_0x0329
        L_0x0318:
            kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage r0 = kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage.COMMON
            r7 = 0
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes r0 = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt.toAttributes$default(r0, r3, r7, r9)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = r12.transformJavaType(r10, r0)
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r15 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.createProjection(r0, r15, r2)
            r0 = r7
            goto L_0x033a
        L_0x0329:
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r15 = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt.makeStarProjection(r2, r7)
            goto L_0x033a
        L_0x032e:
            kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl r2 = new kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl
            kotlin.reflect.jvm.internal.impl.types.Variance r9 = kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT
            kotlin.reflect.jvm.internal.impl.types.KotlinType r15 = r12.transformJavaType(r15, r7)
            r2.<init>(r9, r15)
            r15 = r2
        L_0x033a:
            r14.add(r15)
            goto L_0x029d
        L_0x033f:
            java.util.List r13 = kotlin.collections.ArraysKt___ArraysJvmKt.toList(r14)
            goto L_0x0242
        L_0x0345:
            kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory r13 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.INSTANCE
            r9 = 0
            r10 = 16
            kotlin.reflect.jvm.internal.impl.types.SimpleType r13 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.simpleType$default(r5, r6, r7, r8, r9, r10)
            return r13
        L_0x034f:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "Unknown classifier kind: "
            java.lang.String r14 = kotlin.jvm.internal.Intrinsics.stringPlus(r14, r1)
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver.computeSimpleJavaClassifierType(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes, kotlin.reflect.jvm.internal.impl.types.SimpleType):kotlin.reflect.jvm.internal.impl.types.SimpleType");
    }

    public final TypeConstructor createNotFoundClass(JavaClassifierType javaClassifierType) {
        ClassId classId = ClassId.topLevel(new FqName(javaClassifierType.getClassifierQualifiedName()));
        Intrinsics.checkNotNullExpressionValue(classId, "topLevel(FqName(javaType.classifierQualifiedName))");
        TypeConstructor typeConstructor = this.f5945c.components.deserializedDescriptorResolver.getComponents().notFoundClasses.getClass(classId, TweetUtils.listOf(Integer.valueOf(0))).getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(typeConstructor, "c.components.deserializedDescriptorResolver.components.notFoundClasses.getClass(classId, listOf(0)).typeConstructor");
        return typeConstructor;
    }

    /* JADX WARNING: type inference failed for: r7v14, types: [kotlin.reflect.jvm.internal.impl.types.UnwrappedType] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.reflect.jvm.internal.impl.types.KotlinType transformArrayType(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType r7, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes r8, boolean r9) {
        /*
            r6 = this;
            java.lang.String r0 = "arrayType"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "attr"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType r0 = r7.getComponentType()
            boolean r1 = r0 instanceof kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPrimitiveType
            r2 = 0
            if (r1 == 0) goto L_0x0017
            r1 = r0
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPrimitiveType r1 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPrimitiveType) r1
            goto L_0x0018
        L_0x0017:
            r1 = r2
        L_0x0018:
            if (r1 != 0) goto L_0x001c
            r1 = r2
            goto L_0x0020
        L_0x001c:
            kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType r1 = r1.getType()
        L_0x0020:
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations r3 = new kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r4 = r6.f5945c
            r5 = 1
            r3.<init>(r4, r7, r5)
            if (r1 == 0) goto L_0x005e
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r7 = r6.f5945c
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r7 = r7.components
            kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor r7 = r7.module
            kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns r7 = r7.getBuiltIns()
            kotlin.reflect.jvm.internal.impl.types.SimpleType r7 = r7.getPrimitiveArrayKotlinType(r1)
            java.lang.String r9 = "c.module.builtIns.getPrimitiveArrayKotlinType(primitiveType)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r9)
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations$Companion r9 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r0 = r7.getAnnotations()
            java.util.List r0 = kotlin.collections.ArraysKt___ArraysJvmKt.plus(r3, r0)
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r9 = r9.create(r0)
            r7.replaceAnnotations(r9)
            boolean r8 = r8.isForAnnotationParameter
            if (r8 == 0) goto L_0x0053
            goto L_0x005d
        L_0x0053:
            kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory r8 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.INSTANCE
            kotlin.reflect.jvm.internal.impl.types.SimpleType r8 = r7.makeNullableAsSpecified(r5)
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r7 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.flexibleType(r7, r8)
        L_0x005d:
            return r7
        L_0x005e:
            kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage r7 = kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage.COMMON
            boolean r1 = r8.isForAnnotationParameter
            r4 = 2
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes r7 = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt.toAttributes$default(r7, r1, r2, r4)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r7 = r6.transformJavaType(r0, r7)
            boolean r8 = r8.isForAnnotationParameter
            if (r8 == 0) goto L_0x008a
            if (r9 == 0) goto L_0x0074
            kotlin.reflect.jvm.internal.impl.types.Variance r8 = kotlin.reflect.jvm.internal.impl.types.Variance.OUT_VARIANCE
            goto L_0x0076
        L_0x0074:
            kotlin.reflect.jvm.internal.impl.types.Variance r8 = kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT
        L_0x0076:
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r9 = r6.f5945c
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r9 = r9.components
            kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor r9 = r9.module
            kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns r9 = r9.getBuiltIns()
            kotlin.reflect.jvm.internal.impl.types.SimpleType r7 = r9.getArrayType(r8, r7, r3)
            java.lang.String r8 = "c.module.builtIns.getArrayType(projectionKind, componentType, annotations)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
            return r7
        L_0x008a:
            kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory r8 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.INSTANCE
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r8 = r6.f5945c
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r8 = r8.components
            kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor r8 = r8.module
            kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns r8 = r8.getBuiltIns()
            kotlin.reflect.jvm.internal.impl.types.Variance r9 = kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT
            kotlin.reflect.jvm.internal.impl.types.SimpleType r8 = r8.getArrayType(r9, r7, r3)
            java.lang.String r9 = "c.module.builtIns.getArrayType(INVARIANT, componentType, annotations)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r9 = r6.f5945c
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r9 = r9.components
            kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor r9 = r9.module
            kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns r9 = r9.getBuiltIns()
            kotlin.reflect.jvm.internal.impl.types.Variance r0 = kotlin.reflect.jvm.internal.impl.types.Variance.OUT_VARIANCE
            kotlin.reflect.jvm.internal.impl.types.SimpleType r7 = r9.getArrayType(r0, r7, r3)
            kotlin.reflect.jvm.internal.impl.types.SimpleType r7 = r7.makeNullableAsSpecified(r5)
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r7 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.flexibleType(r8, r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver.transformArrayType(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes, boolean):kotlin.reflect.jvm.internal.impl.types.KotlinType");
    }

    public final KotlinType transformJavaType(JavaType javaType, JavaTypeAttributes javaTypeAttributes) {
        SimpleType simpleType;
        Intrinsics.checkNotNullParameter(javaTypeAttributes, ColorPropConverter.ATTR);
        if (javaType instanceof JavaPrimitiveType) {
            PrimitiveType type = ((JavaPrimitiveType) javaType).getType();
            if (type != null) {
                simpleType = this.f5945c.components.module.getBuiltIns().getPrimitiveKotlinType(type);
            } else {
                simpleType = this.f5945c.components.module.getBuiltIns().getUnitType();
            }
            Intrinsics.checkNotNullExpressionValue(simpleType, "{\n                val primitiveType = javaType.type\n                if (primitiveType != null) c.module.builtIns.getPrimitiveKotlinType(primitiveType)\n                else c.module.builtIns.unitType\n            }");
            return simpleType;
        }
        boolean z = false;
        if (javaType instanceof JavaClassifierType) {
            JavaClassifierType javaClassifierType = (JavaClassifierType) javaType;
            if (!javaTypeAttributes.isForAnnotationParameter && javaTypeAttributes.howThisTypeIsUsed != TypeUsage.SUPERTYPE) {
                z = true;
            }
            boolean isRaw = javaClassifierType.isRaw();
            if (isRaw || z) {
                SimpleType computeSimpleJavaClassifierType = computeSimpleJavaClassifierType(javaClassifierType, javaTypeAttributes.withFlexibility(JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND), null);
                if (computeSimpleJavaClassifierType == null) {
                    return transformJavaClassifierType$errorType(javaClassifierType);
                }
                SimpleType computeSimpleJavaClassifierType2 = computeSimpleJavaClassifierType(javaClassifierType, javaTypeAttributes.withFlexibility(JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND), computeSimpleJavaClassifierType);
                if (computeSimpleJavaClassifierType2 == null) {
                    return transformJavaClassifierType$errorType(javaClassifierType);
                }
                if (isRaw) {
                    return new RawTypeImpl(computeSimpleJavaClassifierType, computeSimpleJavaClassifierType2);
                }
                KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
                return KotlinTypeFactory.flexibleType(computeSimpleJavaClassifierType, computeSimpleJavaClassifierType2);
            }
            SimpleType computeSimpleJavaClassifierType3 = computeSimpleJavaClassifierType(javaClassifierType, javaTypeAttributes, null);
            if (computeSimpleJavaClassifierType3 == null) {
                computeSimpleJavaClassifierType3 = transformJavaClassifierType$errorType(javaClassifierType);
            }
            return computeSimpleJavaClassifierType3;
        } else if (javaType instanceof JavaArrayType) {
            return transformArrayType((JavaArrayType) javaType, javaTypeAttributes, false);
        } else {
            if (javaType instanceof JavaWildcardType) {
                JavaType bound = ((JavaWildcardType) javaType).getBound();
                KotlinType transformJavaType = bound == null ? null : transformJavaType(bound, javaTypeAttributes);
                if (transformJavaType != null) {
                    return transformJavaType;
                }
                SimpleType defaultBound = this.f5945c.components.module.getBuiltIns().getDefaultBound();
                Intrinsics.checkNotNullExpressionValue(defaultBound, "c.module.builtIns.defaultBound");
                return defaultBound;
            } else if (javaType == null) {
                SimpleType defaultBound2 = this.f5945c.components.module.getBuiltIns().getDefaultBound();
                Intrinsics.checkNotNullExpressionValue(defaultBound2, "c.module.builtIns.defaultBound");
                return defaultBound2;
            } else {
                throw new UnsupportedOperationException(Intrinsics.stringPlus("Unsupported type: ", javaType));
            }
        }
    }
}
