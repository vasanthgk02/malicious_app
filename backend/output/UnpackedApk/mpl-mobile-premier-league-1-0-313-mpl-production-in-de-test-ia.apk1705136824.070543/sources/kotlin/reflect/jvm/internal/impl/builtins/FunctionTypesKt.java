package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin._Assertions;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind.Companion;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind.Companion.KindWithArity;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;

/* compiled from: functionTypes.kt */
public final class FunctionTypesKt {
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0066, code lost:
        if (r8.special != false) goto L_0x0069;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.reflect.jvm.internal.impl.types.SimpleType createFunctionType(kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns r16, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r17, kotlin.reflect.jvm.internal.impl.types.KotlinType r18, java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.KotlinType> r19, java.util.List<kotlin.reflect.jvm.internal.impl.name.Name> r20, kotlin.reflect.jvm.internal.impl.types.KotlinType r21, boolean r22) {
        /*
            r0 = r16
            r1 = r17
            r2 = r19
            r3 = r20
            r4 = r21
            java.lang.String r5 = "builtIns"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r5)
            java.lang.String r6 = "annotations"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r6)
            java.lang.String r6 = "parameterTypes"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r6)
            java.lang.String r7 = "returnType"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r7)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r6)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r7)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r5)
            java.util.ArrayList r6 = new java.util.ArrayList
            int r7 = r19.size()
            r8 = 0
            r9 = 1
            if (r18 == 0) goto L_0x0033
            r10 = 1
            goto L_0x0034
        L_0x0033:
            r10 = 0
        L_0x0034:
            int r7 = r7 + r10
            int r7 = r7 + r9
            r6.<init>(r7)
            if (r18 != 0) goto L_0x003d
            r10 = 0
            goto L_0x0041
        L_0x003d:
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r10 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.asTypeProjection(r18)
        L_0x0041:
            kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.addIfNotNull(r6, r10)
            java.util.Iterator r10 = r19.iterator()
        L_0x0048:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x00b1
            java.lang.Object r11 = r10.next()
            int r12 = r8 + 1
            if (r8 < 0) goto L_0x00ac
            kotlin.reflect.jvm.internal.impl.types.KotlinType r11 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r11
            if (r3 != 0) goto L_0x005b
            goto L_0x0069
        L_0x005b:
            java.lang.Object r8 = r3.get(r8)
            kotlin.reflect.jvm.internal.impl.name.Name r8 = (kotlin.reflect.jvm.internal.impl.name.Name) r8
            if (r8 != 0) goto L_0x0064
            goto L_0x0069
        L_0x0064:
            boolean r13 = r8.special
            if (r13 != 0) goto L_0x0069
            goto L_0x006a
        L_0x0069:
            r8 = 0
        L_0x006a:
            if (r8 == 0) goto L_0x00a2
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.BuiltInAnnotationDescriptor r13 = new kotlin.reflect.jvm.internal.impl.descriptors.annotations.BuiltInAnnotationDescriptor
            kotlin.reflect.jvm.internal.impl.name.FqName r14 = kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.parameterName
            java.lang.String r15 = "name"
            kotlin.reflect.jvm.internal.impl.name.Name r15 = kotlin.reflect.jvm.internal.impl.name.Name.identifier(r15)
            kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue r9 = new kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue
            java.lang.String r8 = r8.asString()
            java.lang.String r7 = "name.asString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r7)
            r9.<init>(r8)
            kotlin.Pair r7 = new kotlin.Pair
            r7.<init>(r15, r9)
            java.util.Map r7 = com.twitter.sdk.android.tweetui.TweetUtils.mapOf(r7)
            r13.<init>(r0, r14, r7)
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations$Companion r7 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r8 = r11.getAnnotations()
            java.util.List r8 = kotlin.collections.ArraysKt___ArraysJvmKt.plus(r8, r13)
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r7 = r7.create(r8)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r11 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.replaceAnnotations(r11, r7)
        L_0x00a2:
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r7 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.asTypeProjection(r11)
            r6.add(r7)
            r8 = r12
            r9 = 1
            goto L_0x0048
        L_0x00ac:
            com.twitter.sdk.android.tweetui.TweetUtils.throwIndexOverflow()
            r0 = 0
            throw r0
        L_0x00b1:
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r3 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.asTypeProjection(r21)
            r6.add(r3)
            int r2 = r19.size()
            if (r18 != 0) goto L_0x00bf
            goto L_0x00c1
        L_0x00bf:
            r3 = 1
            int r2 = r2 + r3
        L_0x00c1:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r5)
            if (r22 == 0) goto L_0x00cb
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r2 = r0.getSuspendFunction(r2)
            goto L_0x00d3
        L_0x00cb:
            java.lang.String r2 = kotlin.reflect.jvm.internal.impl.builtins.StandardNames.getFunctionName(r2)
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r2 = r0.getBuiltInClassByName(r2)
        L_0x00d3:
            java.lang.String r3 = "if (isSuspendFunction) builtIns.getSuspendFunction(parameterCount) else builtIns.getFunction(parameterCount)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            if (r18 == 0) goto L_0x0101
            java.lang.String r3 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r5)
            kotlin.reflect.jvm.internal.impl.name.FqName r3 = kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.extensionFunctionType
            boolean r3 = r1.hasAnnotation(r3)
            if (r3 == 0) goto L_0x00eb
            goto L_0x0101
        L_0x00eb:
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations$Companion r3 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.BuiltInAnnotationDescriptor r4 = new kotlin.reflect.jvm.internal.impl.descriptors.annotations.BuiltInAnnotationDescriptor
            kotlin.reflect.jvm.internal.impl.name.FqName r5 = kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.extensionFunctionType
            java.util.Map r7 = kotlin.collections.ArraysKt___ArraysJvmKt.emptyMap()
            r4.<init>(r0, r5, r7)
            java.util.List r0 = kotlin.collections.ArraysKt___ArraysJvmKt.plus(r1, r4)
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r0 = r3.create(r0)
            goto L_0x0102
        L_0x0101:
            r0 = r1
        L_0x0102:
            kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory r1 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.INSTANCE
            kotlin.reflect.jvm.internal.impl.types.SimpleType r0 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.simpleNotNullType(r0, r2, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt.createFunctionType(kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations, kotlin.reflect.jvm.internal.impl.types.KotlinType, java.util.List, java.util.List, kotlin.reflect.jvm.internal.impl.types.KotlinType, boolean):kotlin.reflect.jvm.internal.impl.types.SimpleType");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0035, code lost:
        if (kotlin.reflect.jvm.internal.impl.name.Name.isValidIdentifier(r2) == false) goto L_0x0038;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.reflect.jvm.internal.impl.name.Name extractParameterNameFromFunctionTypeArgument(kotlin.reflect.jvm.internal.impl.types.KotlinType r2) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r2 = r2.getAnnotations()
            kotlin.reflect.jvm.internal.impl.name.FqName r0 = kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.parameterName
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor r2 = r2.findAnnotation(r0)
            r0 = 0
            if (r2 != 0) goto L_0x0013
            return r0
        L_0x0013:
            java.util.Map r2 = r2.getAllValueArguments()
            java.util.Collection r2 = r2.values()
            java.lang.Object r2 = kotlin.collections.ArraysKt___ArraysJvmKt.singleOrNull(r2)
            boolean r1 = r2 instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue
            if (r1 == 0) goto L_0x0026
            kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue r2 = (kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue) r2
            goto L_0x0027
        L_0x0026:
            r2 = r0
        L_0x0027:
            if (r2 != 0) goto L_0x002a
            goto L_0x0038
        L_0x002a:
            T r2 = r2.value
            java.lang.String r2 = (java.lang.String) r2
            if (r2 != 0) goto L_0x0031
            goto L_0x0038
        L_0x0031:
            boolean r1 = kotlin.reflect.jvm.internal.impl.name.Name.isValidIdentifier(r2)
            if (r1 == 0) goto L_0x0038
            goto L_0x0039
        L_0x0038:
            r2 = r0
        L_0x0039:
            if (r2 != 0) goto L_0x003c
            return r0
        L_0x003c:
            kotlin.reflect.jvm.internal.impl.name.Name r2 = kotlin.reflect.jvm.internal.impl.name.Name.identifier(r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt.extractParameterNameFromFunctionTypeArgument(kotlin.reflect.jvm.internal.impl.types.KotlinType):kotlin.reflect.jvm.internal.impl.name.Name");
    }

    public static final FunctionClassKind getFunctionalClassKind(DeclarationDescriptor declarationDescriptor) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "<this>");
        FunctionClassKind functionClassKind = null;
        if (!(declarationDescriptor instanceof ClassDescriptor) || !KotlinBuiltIns.isUnderKotlinPackage(declarationDescriptor)) {
            return null;
        }
        FqNameUnsafe fqNameUnsafe = DescriptorUtilsKt.getFqNameUnsafe(declarationDescriptor);
        if (fqNameUnsafe.isSafe() && !fqNameUnsafe.isRoot()) {
            Companion companion = FunctionClassKind.Companion;
            String asString = fqNameUnsafe.shortName().asString();
            Intrinsics.checkNotNullExpressionValue(asString, "shortName().asString()");
            FqName parent = fqNameUnsafe.toSafe().parent();
            Intrinsics.checkNotNullExpressionValue(parent, "toSafe().parent()");
            if (companion != null) {
                Intrinsics.checkNotNullParameter(asString, "className");
                Intrinsics.checkNotNullParameter(parent, "packageFqName");
                KindWithArity parseClassName = companion.parseClassName(asString, parent);
                if (parseClassName != null) {
                    functionClassKind = parseClassName.kind;
                }
            } else {
                throw null;
            }
        }
        return functionClassKind;
    }

    public static final KotlinType getReceiverTypeFromFunctionType(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        boolean isBuiltinFunctionalType = isBuiltinFunctionalType(kotlinType);
        if (!_Assertions.ENABLED || isBuiltinFunctionalType) {
            if (kotlinType.getAnnotations().findAnnotation(FqNames.extensionFunctionType) != null) {
                return ((TypeProjection) ArraysKt___ArraysJvmKt.first(kotlinType.getArguments())).getType();
            }
            return null;
        }
        throw new AssertionError(Intrinsics.stringPlus("Not a function type: ", kotlinType));
    }

    public static final KotlinType getReturnTypeFromFunctionType(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        boolean isBuiltinFunctionalType = isBuiltinFunctionalType(kotlinType);
        if (!_Assertions.ENABLED || isBuiltinFunctionalType) {
            KotlinType type = ((TypeProjection) ArraysKt___ArraysJvmKt.last(kotlinType.getArguments())).getType();
            Intrinsics.checkNotNullExpressionValue(type, "arguments.last().type");
            return type;
        }
        throw new AssertionError(Intrinsics.stringPlus("Not a function type: ", kotlinType));
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.List<kotlin.reflect.jvm.internal.impl.types.TypeProjection> getValueParameterTypesFromFunctionType(kotlin.reflect.jvm.internal.impl.types.KotlinType r5) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            boolean r1 = isBuiltinFunctionalType(r5)
            boolean r2 = kotlin._Assertions.ENABLED
            if (r2 == 0) goto L_0x001c
            if (r1 == 0) goto L_0x0010
            goto L_0x001c
        L_0x0010:
            java.lang.String r0 = "Not a function type: "
            java.lang.String r5 = kotlin.jvm.internal.Intrinsics.stringPlus(r0, r5)
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>(r5)
            throw r0
        L_0x001c:
            java.util.List r1 = r5.getArguments()
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            boolean r0 = isBuiltinFunctionalType(r5)
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x003e
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r0 = r5.getAnnotations()
            kotlin.reflect.jvm.internal.impl.name.FqName r4 = kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.extensionFunctionType
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor r0 = r0.findAnnotation(r4)
            if (r0 == 0) goto L_0x0039
            r0 = 1
            goto L_0x003a
        L_0x0039:
            r0 = 0
        L_0x003a:
            if (r0 == 0) goto L_0x003e
            r0 = 1
            goto L_0x003f
        L_0x003e:
            r0 = 0
        L_0x003f:
            int r4 = r1.size()
            int r4 = r4 - r3
            if (r0 > r4) goto L_0x0047
            r2 = 1
        L_0x0047:
            boolean r3 = kotlin._Assertions.ENABLED
            if (r3 == 0) goto L_0x005a
            if (r2 == 0) goto L_0x004e
            goto L_0x005a
        L_0x004e:
            java.lang.String r0 = "Not an exact function type: "
            java.lang.String r5 = kotlin.jvm.internal.Intrinsics.stringPlus(r0, r5)
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>(r5)
            throw r0
        L_0x005a:
            java.util.List r5 = r1.subList(r0, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt.getValueParameterTypesFromFunctionType(kotlin.reflect.jvm.internal.impl.types.KotlinType):java.util.List");
    }

    public static final boolean isBuiltinFunctionalType(KotlinType kotlinType) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor == null) {
            bool = null;
        } else {
            Intrinsics.checkNotNullParameter(declarationDescriptor, "<this>");
            FunctionClassKind functionalClassKind = getFunctionalClassKind(declarationDescriptor);
            bool = Boolean.valueOf(functionalClassKind == FunctionClassKind.Function || functionalClassKind == FunctionClassKind.SuspendFunction);
        }
        return Intrinsics.areEqual(bool, Boolean.TRUE);
    }

    public static final boolean isSuspendFunctionType(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        return (declarationDescriptor == null ? null : getFunctionalClassKind(declarationDescriptor)) == FunctionClassKind.SuspendFunction;
    }
}
