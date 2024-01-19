package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: typeEnhancement.kt */
public final class JavaTypeEnhancement {
    public final JavaResolverSettings javaResolverSettings;

    /* compiled from: typeEnhancement.kt */
    public static class Result {
        public final int subtreeSize;
        public final KotlinType type;
        public final boolean wereChanges;

        public Result(KotlinType kotlinType, int i, boolean z) {
            Intrinsics.checkNotNullParameter(kotlinType, "type");
            this.type = kotlinType;
            this.subtreeSize = i;
            this.wereChanges = z;
        }

        public KotlinType getType() {
            return this.type;
        }
    }

    /* compiled from: typeEnhancement.kt */
    public static final class SimpleResult extends Result {
        public final SimpleType type;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public SimpleResult(SimpleType simpleType, int i, boolean z) {
            // Intrinsics.checkNotNullParameter(simpleType, "type");
            super(simpleType, i, z);
            this.type = simpleType;
        }

        public KotlinType getType() {
            return this.type;
        }
    }

    public JavaTypeEnhancement(JavaResolverSettings javaResolverSettings2) {
        Intrinsics.checkNotNullParameter(javaResolverSettings2, "javaResolverSettings");
        this.javaResolverSettings = javaResolverSettings2;
    }

    /* JADX WARNING: type inference failed for: r3v9, types: [kotlin.reflect.jvm.internal.impl.types.KotlinType] */
    /* JADX WARNING: type inference failed for: r3v10 */
    /* JADX WARNING: type inference failed for: r3v12, types: [kotlin.reflect.jvm.internal.impl.types.UnwrappedType] */
    /* JADX WARNING: type inference failed for: r3v20 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement.SimpleResult enhanceInflexible(kotlin.reflect.jvm.internal.impl.types.SimpleType r19, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers> r20, int r21, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition r22, boolean r23) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            boolean r3 = com.twitter.sdk.android.tweetui.TweetUtils.shouldEnhance(r22)
            r4 = 0
            r5 = 1
            if (r3 != 0) goto L_0x001e
            java.util.List r3 = r19.getArguments()
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x001e
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$SimpleResult r2 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$SimpleResult
            r2.<init>(r1, r5, r4)
            return r2
        L_0x001e:
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r3 = r19.getConstructor()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r3 = r3.getDeclarationDescriptor()
            if (r3 != 0) goto L_0x002e
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$SimpleResult r2 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$SimpleResult
            r2.<init>(r1, r5, r4)
            return r2
        L_0x002e:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r21)
            java.lang.Object r6 = r2.invoke(r6)
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers r6 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers) r6
            r7 = r22
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.EnhancementResult r3 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementKt.access$enhanceMutability(r3, r6, r7)
            T r8 = r3.result
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r8 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor) r8
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r3 = r3.enhancementAnnotations
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r10 = r8.getTypeConstructor()
            java.lang.String r9 = "enhancedClassifier.typeConstructor"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r9)
            int r9 = r21 + 1
            if (r3 == 0) goto L_0x0053
            r11 = 1
            goto L_0x0054
        L_0x0053:
            r11 = 0
        L_0x0054:
            java.util.List r12 = r19.getArguments()
            java.util.ArrayList r13 = new java.util.ArrayList
            r14 = 10
            int r14 = com.twitter.sdk.android.tweetui.TweetUtils.collectionSizeOrDefault(r12, r14)
            r13.<init>(r14)
            java.util.Iterator r12 = r12.iterator()
            r14 = 0
        L_0x0068:
            boolean r15 = r12.hasNext()
            if (r15 == 0) goto L_0x0112
            java.lang.Object r15 = r12.next()
            int r16 = r14 + 1
            if (r14 < 0) goto L_0x010d
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r15 = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) r15
            boolean r17 = r15.isStarProjection()
            java.lang.String r4 = "arg.projectionKind"
            if (r17 == 0) goto L_0x00cf
            java.lang.Integer r5 = java.lang.Integer.valueOf(r9)
            java.lang.Object r5 = r2.invoke(r5)
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers r5 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers) r5
            int r9 = r9 + 1
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r5 = r5.nullability
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r7 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL
            if (r5 != r7) goto L_0x00b6
            if (r23 != 0) goto L_0x00b6
            kotlin.reflect.jvm.internal.impl.types.KotlinType r5 = r15.getType()
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r5 = r5.unwrap()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r5 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.makeNotNullable(r5)
            kotlin.reflect.jvm.internal.impl.types.Variance r7 = r15.getProjectionKind()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r4)
            java.util.List r4 = r10.getParameters()
            java.lang.Object r4 = r4.get(r14)
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r4
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r4 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.createProjection(r5, r7, r4)
            goto L_0x0102
        L_0x00b6:
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r4 = r8.getTypeConstructor()
            java.util.List r4 = r4.getParameters()
            java.lang.Object r4 = r4.get(r14)
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r4
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r4 = kotlin.reflect.jvm.internal.impl.types.TypeUtils.makeStarProjection(r4)
            java.lang.String r5 = "{\n                    TypeUtils.makeStarProjection(enhancedClassifier.typeConstructor.parameters[localArgIndex])\n                }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            goto L_0x0102
        L_0x00cf:
            kotlin.reflect.jvm.internal.impl.types.KotlinType r5 = r15.getType()
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r5 = r5.unwrap()
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$Result r5 = r0.enhancePossiblyFlexible(r5, r2, r9)
            if (r11 != 0) goto L_0x00e4
            boolean r7 = r5.wereChanges
            if (r7 == 0) goto L_0x00e2
            goto L_0x00e4
        L_0x00e2:
            r7 = 0
            goto L_0x00e5
        L_0x00e4:
            r7 = 1
        L_0x00e5:
            int r11 = r5.subtreeSize
            int r9 = r9 + r11
            kotlin.reflect.jvm.internal.impl.types.KotlinType r5 = r5.getType()
            kotlin.reflect.jvm.internal.impl.types.Variance r11 = r15.getProjectionKind()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r4)
            java.util.List r4 = r10.getParameters()
            java.lang.Object r4 = r4.get(r14)
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r4
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r4 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.createProjection(r5, r11, r4)
            r11 = r7
        L_0x0102:
            r13.add(r4)
            r7 = r22
            r14 = r16
            r4 = 0
            r5 = 1
            goto L_0x0068
        L_0x010d:
            com.twitter.sdk.android.tweetui.TweetUtils.throwIndexOverflow()
            r1 = 0
            throw r1
        L_0x0112:
            boolean r2 = com.twitter.sdk.android.tweetui.TweetUtils.shouldEnhance(r22)
            r4 = 2
            if (r2 != 0) goto L_0x0126
            boolean r2 = r19.isMarkedNullable()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.EnhancementResult r2 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementKt.noChange(r2)
            goto L_0x015a
        L_0x0126:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r2 = r6.nullability
            if (r2 != 0) goto L_0x012c
            r2 = -1
            goto L_0x0134
        L_0x012c:
            int[] r5 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementKt.WhenMappings.$EnumSwitchMapping$1
            int r2 = r2.ordinal()
            r2 = r5[r2]
        L_0x0134:
            r5 = 1
            if (r2 == r5) goto L_0x0150
            if (r2 == r4) goto L_0x0146
            boolean r2 = r19.isMarkedNullable()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.EnhancementResult r2 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementKt.noChange(r2)
            goto L_0x015a
        L_0x0146:
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.EnhancementResult r5 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.EnhancementResult
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.EnhancedTypeAnnotations r7 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementKt.ENHANCED_NULLABILITY_ANNOTATIONS
            r5.<init>(r2, r7)
            goto L_0x0159
        L_0x0150:
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.EnhancementResult r5 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.EnhancementResult
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.EnhancedTypeAnnotations r7 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementKt.ENHANCED_NULLABILITY_ANNOTATIONS
            r5.<init>(r2, r7)
        L_0x0159:
            r2 = r5
        L_0x015a:
            T r5 = r2.result
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r12 = r5.booleanValue()
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r2 = r2.enhancementAnnotations
            if (r11 != 0) goto L_0x016b
            if (r2 == 0) goto L_0x0169
            goto L_0x016b
        L_0x0169:
            r5 = 0
            goto L_0x016c
        L_0x016b:
            r5 = 1
        L_0x016c:
            int r7 = r9 - r21
            if (r5 != 0) goto L_0x0177
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$SimpleResult r2 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$SimpleResult
            r5 = 0
            r2.<init>(r1, r7, r5)
            return r2
        L_0x0177:
            r5 = 0
            r8 = 3
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations[] r8 = new kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations[r8]
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r9 = r19.getAnnotations()
            r8[r5] = r9
            r9 = 1
            r8[r9] = r3
            r8[r4] = r2
            java.util.List r3 = com.twitter.sdk.android.tweetui.TweetUtils.listOfNotNull((T[]) r8)
            r4 = r3
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            int r4 = r4.size()
            if (r4 == 0) goto L_0x01e2
            if (r4 == r9) goto L_0x01a0
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations r4 = new kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations
            java.util.List r3 = kotlin.collections.ArraysKt___ArraysJvmKt.toList(r3)
            r4.<init>(r3)
            r9 = r4
            goto L_0x01a7
        L_0x01a0:
            java.lang.Object r3 = kotlin.collections.ArraysKt___ArraysJvmKt.single(r3)
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r3 = (kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations) r3
            r9 = r3
        L_0x01a7:
            kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory r3 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.INSTANCE
            r3 = 0
            r14 = 16
            r11 = r13
            r13 = r3
            kotlin.reflect.jvm.internal.impl.types.SimpleType r3 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.simpleType$default(r9, r10, r11, r12, r13, r14)
            boolean r4 = r6.isNotNullTypeParameter
            if (r4 == 0) goto L_0x01ca
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings r4 = r0.javaResolverSettings
            boolean r4 = r4.getCorrectNullabilityForNotNullTypeParameter()
            if (r4 == 0) goto L_0x01c4
            r4 = 1
            kotlin.reflect.jvm.internal.impl.types.SimpleType r3 = kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt.makeSimpleTypeDefinitelyNotNullOrNotNull(r3, r4)
            goto L_0x01ca
        L_0x01c4:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NotNullTypeParameter r4 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NotNullTypeParameter
            r4.<init>(r3)
            r3 = r4
        L_0x01ca:
            if (r2 == 0) goto L_0x01d2
            boolean r2 = r6.isNullabilityQualifierForWarning
            if (r2 == 0) goto L_0x01d2
            r4 = 1
            goto L_0x01d3
        L_0x01d2:
            r4 = 0
        L_0x01d3:
            if (r4 == 0) goto L_0x01d9
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r3 = com.twitter.sdk.android.tweetui.TweetUtils.wrapEnhancement(r1, r3)
        L_0x01d9:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$SimpleResult r1 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$SimpleResult
            kotlin.reflect.jvm.internal.impl.types.SimpleType r3 = (kotlin.reflect.jvm.internal.impl.types.SimpleType) r3
            r2 = 1
            r1.<init>(r3, r7, r2)
            return r1
        L_0x01e2:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "At least one Annotations object expected"
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement.enhanceInflexible(kotlin.reflect.jvm.internal.impl.types.SimpleType, kotlin.jvm.functions.Function1, int, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition, boolean):kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$SimpleResult");
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x009a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement.Result enhancePossiblyFlexible(kotlin.reflect.jvm.internal.impl.types.UnwrappedType r11, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers> r12, int r13) {
        /*
            r10 = this;
            boolean r0 = com.twitter.sdk.android.tweetui.TweetUtils.isError(r11)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x000e
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$Result r12 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$Result
            r12.<init>(r11, r2, r1)
            return r12
        L_0x000e:
            boolean r0 = r11 instanceof kotlin.reflect.jvm.internal.impl.types.FlexibleType
            if (r0 == 0) goto L_0x00be
            boolean r0 = r11 instanceof kotlin.reflect.jvm.internal.impl.types.RawType
            r8 = r11
            kotlin.reflect.jvm.internal.impl.types.FlexibleType r8 = (kotlin.reflect.jvm.internal.impl.types.FlexibleType) r8
            kotlin.reflect.jvm.internal.impl.types.SimpleType r3 = r8.lowerBound
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition r6 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition.FLEXIBLE_LOWER
            r2 = r10
            r4 = r12
            r5 = r13
            r7 = r0
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$SimpleResult r9 = r2.enhanceInflexible(r3, r4, r5, r6, r7)
            kotlin.reflect.jvm.internal.impl.types.SimpleType r3 = r8.upperBound
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition r6 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition.FLEXIBLE_UPPER
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$SimpleResult r12 = r2.enhanceInflexible(r3, r4, r5, r6, r7)
            int r13 = r9.subtreeSize
            int r0 = r12.subtreeSize
            if (r13 != r0) goto L_0x0033
            r13 = 1
            goto L_0x0034
        L_0x0033:
            r13 = 0
        L_0x0034:
            boolean r0 = kotlin._Assertions.ENABLED
            if (r0 == 0) goto L_0x006b
            if (r13 == 0) goto L_0x003b
            goto L_0x006b
        L_0x003b:
            java.lang.String r11 = "Different tree sizes of bounds: lower = ("
            java.lang.StringBuilder r11 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r11)
            kotlin.reflect.jvm.internal.impl.types.SimpleType r13 = r8.lowerBound
            r11.append(r13)
            java.lang.String r13 = ", "
            r11.append(r13)
            int r0 = r9.subtreeSize
            r11.append(r0)
            java.lang.String r0 = "), upper = ("
            r11.append(r0)
            kotlin.reflect.jvm.internal.impl.types.SimpleType r0 = r8.upperBound
            r11.append(r0)
            r11.append(r13)
            int r12 = r12.subtreeSize
            r13 = 41
            java.lang.String r11 = com.android.tools.r8.GeneratedOutlineSupport.outline56(r11, r12, r13)
            java.lang.AssertionError r12 = new java.lang.AssertionError
            r12.<init>(r11)
            throw r12
        L_0x006b:
            boolean r13 = r9.wereChanges
            if (r13 != 0) goto L_0x0073
            boolean r13 = r12.wereChanges
            if (r13 == 0) goto L_0x0074
        L_0x0073:
            r1 = 1
        L_0x0074:
            kotlin.reflect.jvm.internal.impl.types.SimpleType r13 = r9.type
            kotlin.reflect.jvm.internal.impl.types.SimpleType r0 = r12.type
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = com.twitter.sdk.android.tweetui.TweetUtils.getEnhancement(r0)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r13 = com.twitter.sdk.android.tweetui.TweetUtils.getEnhancement(r13)
            if (r13 != 0) goto L_0x0087
            if (r0 != 0) goto L_0x0086
            r13 = 0
            goto L_0x0098
        L_0x0086:
            r13 = r0
        L_0x0087:
            if (r0 != 0) goto L_0x008a
            goto L_0x0098
        L_0x008a:
            kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory r2 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.INSTANCE
            kotlin.reflect.jvm.internal.impl.types.SimpleType r13 = com.twitter.sdk.android.tweetui.TweetUtils.lowerIfFlexible(r13)
            kotlin.reflect.jvm.internal.impl.types.SimpleType r0 = com.twitter.sdk.android.tweetui.TweetUtils.upperIfFlexible(r0)
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r13 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.flexibleType(r13, r0)
        L_0x0098:
            if (r1 == 0) goto L_0x00b6
            boolean r11 = r11 instanceof kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl
            if (r11 == 0) goto L_0x00a8
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl r11 = new kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl
            kotlin.reflect.jvm.internal.impl.types.SimpleType r0 = r9.type
            kotlin.reflect.jvm.internal.impl.types.SimpleType r12 = r12.type
            r11.<init>(r0, r12)
            goto L_0x00b2
        L_0x00a8:
            kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory r11 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.INSTANCE
            kotlin.reflect.jvm.internal.impl.types.SimpleType r11 = r9.type
            kotlin.reflect.jvm.internal.impl.types.SimpleType r12 = r12.type
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r11 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.flexibleType(r11, r12)
        L_0x00b2:
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r11 = com.twitter.sdk.android.tweetui.TweetUtils.wrapEnhancement(r11, r13)
        L_0x00b6:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$Result r12 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$Result
            int r13 = r9.subtreeSize
            r12.<init>(r11, r13, r1)
            goto L_0x00cf
        L_0x00be:
            boolean r0 = r11 instanceof kotlin.reflect.jvm.internal.impl.types.SimpleType
            if (r0 == 0) goto L_0x00d0
            r2 = r11
            kotlin.reflect.jvm.internal.impl.types.SimpleType r2 = (kotlin.reflect.jvm.internal.impl.types.SimpleType) r2
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition r5 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition.INFLEXIBLE
            r6 = 0
            r1 = r10
            r3 = r12
            r4 = r13
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$SimpleResult r12 = r1.enhanceInflexible(r2, r3, r4, r5, r6)
        L_0x00cf:
            return r12
        L_0x00d0:
            kotlin.NoWhenBranchMatchedException r11 = new kotlin.NoWhenBranchMatchedException
            r11.<init>()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement.enhancePossiblyFlexible(kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.jvm.functions.Function1, int):kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$Result");
    }
}
