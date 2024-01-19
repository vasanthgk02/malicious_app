package kotlin.reflect.jvm.internal.impl.types.checker;

import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

/* compiled from: NewKotlinTypeChecker.kt */
public final class NewKotlinTypeCheckerImpl implements NewKotlinTypeChecker {
    public final KotlinTypeRefiner kotlinTypeRefiner;
    public final OverridingUtil overridingUtil;

    public NewKotlinTypeCheckerImpl(KotlinTypeRefiner kotlinTypeRefiner2) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner2, "kotlinTypeRefiner");
        this.kotlinTypeRefiner = kotlinTypeRefiner2;
        if (kotlinTypeRefiner2 != null) {
            OverridingUtil overridingUtil2 = new OverridingUtil(OverridingUtil.DEFAULT_TYPE_CONSTRUCTOR_EQUALITY, kotlinTypeRefiner2);
            Intrinsics.checkNotNullExpressionValue(overridingUtil2, "createWithTypeRefiner(kotlinTypeRefiner)");
            this.overridingUtil = overridingUtil2;
            return;
        }
        OverridingUtil.$$$reportNull$$$0(1);
        throw null;
    }

    public boolean equalTypes(KotlinType kotlinType, KotlinType kotlinType2) {
        Intrinsics.checkNotNullParameter(kotlinType, "a");
        Intrinsics.checkNotNullParameter(kotlinType2, "b");
        ClassicTypeCheckerContext classicTypeCheckerContext = new ClassicTypeCheckerContext(false, false, false, this.kotlinTypeRefiner, 6);
        return equalTypes(classicTypeCheckerContext, kotlinType.unwrap(), kotlinType2.unwrap());
    }

    public KotlinTypeRefiner getKotlinTypeRefiner() {
        return this.kotlinTypeRefiner;
    }

    public OverridingUtil getOverridingUtil() {
        return this.overridingUtil;
    }

    public boolean isSubtypeOf(KotlinType kotlinType, KotlinType kotlinType2) {
        Intrinsics.checkNotNullParameter(kotlinType, "subtype");
        Intrinsics.checkNotNullParameter(kotlinType2, "supertype");
        ClassicTypeCheckerContext classicTypeCheckerContext = new ClassicTypeCheckerContext(true, false, false, this.kotlinTypeRefiner, 6);
        return isSubtypeOf(classicTypeCheckerContext, kotlinType.unwrap(), kotlinType2.unwrap());
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [java.lang.Throwable, java.lang.Iterable] */
    /* JADX WARNING: type inference failed for: r0v4, types: [kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor] */
    /* JADX WARNING: type inference failed for: r6v1 */
    /* JADX WARNING: type inference failed for: r0v5, types: [kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor] */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r6v2, types: [kotlin.reflect.jvm.internal.impl.types.KotlinType] */
    /* JADX WARNING: type inference failed for: r2v5, types: [kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor] */
    /* JADX WARNING: type inference failed for: r6v3 */
    /* JADX WARNING: type inference failed for: r6v4, types: [kotlin.reflect.jvm.internal.impl.types.KotlinType] */
    /* JADX WARNING: type inference failed for: r2v9, types: [kotlin.reflect.jvm.internal.impl.types.TypeProjection] */
    /* JADX WARNING: type inference failed for: r2v10, types: [kotlin.reflect.jvm.internal.impl.types.TypeProjection] */
    /* JADX WARNING: type inference failed for: r6v5 */
    /* JADX WARNING: type inference failed for: r10v0, types: [kotlin.reflect.jvm.internal.impl.types.UnwrappedType] */
    /* JADX WARNING: type inference failed for: r6v6, types: [kotlin.reflect.jvm.internal.impl.types.UnwrappedType] */
    /* JADX WARNING: type inference failed for: r2v17 */
    /* JADX WARNING: type inference failed for: r6v7 */
    /* JADX WARNING: type inference failed for: r6v8 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r6v0, types: [java.lang.Throwable, java.lang.Iterable]
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], ?[OBJECT, ARRAY], kotlin.reflect.jvm.internal.impl.types.KotlinType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType]
      uses: [java.lang.Throwable, java.lang.Iterable, ?[OBJECT, ARRAY], ?[int, boolean, OBJECT, ARRAY, byte, short, char], kotlin.reflect.jvm.internal.impl.types.KotlinType]
      mth insns count: 108
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Unknown variable types count: 5 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.reflect.jvm.internal.impl.types.SimpleType transformToNewType(kotlin.reflect.jvm.internal.impl.types.SimpleType r18) {
        /*
            r17 = this;
            java.lang.String r0 = "type"
            r1 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r0 = r18.getConstructor()
            boolean r2 = r0 instanceof kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorImpl
            r3 = 0
            r4 = 1
            r5 = 10
            r6 = 0
            if (r2 == 0) goto L_0x0096
            kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorImpl r0 = (kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorImpl) r0
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r2 = r0.projection
            kotlin.reflect.jvm.internal.impl.types.Variance r7 = r2.getProjectionKind()
            kotlin.reflect.jvm.internal.impl.types.Variance r8 = kotlin.reflect.jvm.internal.impl.types.Variance.IN_VARIANCE
            if (r7 != r8) goto L_0x0022
            r3 = 1
        L_0x0022:
            if (r3 == 0) goto L_0x0025
            goto L_0x0026
        L_0x0025:
            r2 = r6
        L_0x0026:
            if (r2 != 0) goto L_0x0029
            goto L_0x002f
        L_0x0029:
            kotlin.reflect.jvm.internal.impl.types.KotlinType r2 = r2.getType()
            if (r2 != 0) goto L_0x0031
        L_0x002f:
            r10 = r6
            goto L_0x0036
        L_0x0031:
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r6 = r2.unwrap()
            goto L_0x002f
        L_0x0036:
            kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor r2 = r0.newTypeConstructor
            if (r2 != 0) goto L_0x007d
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r12 = r0.projection
            java.util.Collection r2 = r0.getSupertypes()
            java.util.ArrayList r3 = new java.util.ArrayList
            int r4 = com.twitter.sdk.android.tweetui.TweetUtils.collectionSizeOrDefault(r2, r5)
            r3.<init>(r4)
            java.util.Iterator r2 = r2.iterator()
        L_0x004d:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0061
            java.lang.Object r4 = r2.next()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r4 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r4
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r4 = r4.unwrap()
            r3.add(r4)
            goto L_0x004d
        L_0x0061:
            kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor r2 = new kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor
            r14 = 0
            java.lang.String r4 = "projection"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r4)
            java.lang.String r4 = "supertypes"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r4)
            kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor$1 r13 = new kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor$1
            r13.<init>(r3)
            r15 = 0
            r16 = 8
            r11 = r2
            r11.<init>(r12, r13, r14, r15, r16)
            r0.newTypeConstructor = r2
        L_0x007d:
            kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType r2 = new kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType
            kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus r8 = kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus.FOR_SUBTYPING
            kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor r9 = r0.newTypeConstructor
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r11 = r18.getAnnotations()
            boolean r12 = r18.isMarkedNullable()
            r13 = 0
            r14 = 32
            r7 = r2
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            return r2
        L_0x0096:
            boolean r2 = r0 instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerValueTypeConstructor
            if (r2 == 0) goto L_0x00df
            kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerValueTypeConstructor r0 = (kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerValueTypeConstructor) r0
            if (r0 == 0) goto L_0x00de
            java.util.ArrayList r0 = new java.util.ArrayList
            int r2 = com.twitter.sdk.android.tweetui.TweetUtils.collectionSizeOrDefault(r6, r5)
            r0.<init>(r2)
            java.util.Iterator r2 = r6.iterator()
        L_0x00ab:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x00c8
            java.lang.Object r4 = r2.next()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r4 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r4
            boolean r5 = r18.isMarkedNullable()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r4 = kotlin.reflect.jvm.internal.impl.types.TypeUtils.makeNullableAsSpecified(r4, r5)
            java.lang.String r5 = "makeNullableAsSpecified(it, type.isMarkedNullable)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            r0.add(r4)
            goto L_0x00ab
        L_0x00c8:
            kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor r2 = new kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor
            r2.<init>(r0)
            kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory r0 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.INSTANCE
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r0 = r18.getAnnotations()
            kotlin.collections.EmptyList r4 = kotlin.collections.EmptyList.INSTANCE
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r1 = r18.getMemberScope()
            kotlin.reflect.jvm.internal.impl.types.SimpleType r0 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(r0, r2, r4, r3, r1)
            return r0
        L_0x00de:
            throw r6
        L_0x00df:
            boolean r2 = r0 instanceof kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor
            if (r2 == 0) goto L_0x014e
            boolean r2 = r18.isMarkedNullable()
            if (r2 == 0) goto L_0x014e
            kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor r0 = (kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor) r0
            java.util.LinkedHashSet<kotlin.reflect.jvm.internal.impl.types.KotlinType> r1 = r0.intersectedTypes
            java.util.ArrayList r2 = new java.util.ArrayList
            int r5 = com.twitter.sdk.android.tweetui.TweetUtils.collectionSizeOrDefault(r1, r5)
            r2.<init>(r5)
            java.util.Iterator r1 = r1.iterator()
        L_0x00fa:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x010f
            java.lang.Object r3 = r1.next()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r3 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r3
            kotlin.reflect.jvm.internal.impl.types.KotlinType r3 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.makeNullable(r3)
            r2.add(r3)
            r3 = 1
            goto L_0x00fa
        L_0x010f:
            if (r3 != 0) goto L_0x0112
            goto L_0x0145
        L_0x0112:
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = r0.alternative
            if (r1 != 0) goto L_0x0117
            goto L_0x011b
        L_0x0117:
            kotlin.reflect.jvm.internal.impl.types.KotlinType r6 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.makeNullable(r1)
        L_0x011b:
            java.lang.String r1 = "typesToIntersect"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)
            boolean r1 = r2.isEmpty()
            r1 = r1 ^ r4
            boolean r3 = kotlin._Assertions.ENABLED
            if (r3 == 0) goto L_0x0135
            if (r1 == 0) goto L_0x012d
            goto L_0x0135
        L_0x012d:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            java.lang.String r1 = "Attempt to create an empty intersection"
            r0.<init>(r1)
            throw r0
        L_0x0135:
            java.util.LinkedHashSet r1 = new java.util.LinkedHashSet
            r1.<init>(r2)
            r1.hashCode()
            kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor r2 = new kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor
            r2.<init>(r1)
            r2.alternative = r6
            r6 = r2
        L_0x0145:
            if (r6 != 0) goto L_0x0148
            goto L_0x0149
        L_0x0148:
            r0 = r6
        L_0x0149:
            kotlin.reflect.jvm.internal.impl.types.SimpleType r0 = r0.createType()
            goto L_0x014f
        L_0x014e:
            r0 = r1
        L_0x014f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeCheckerImpl.transformToNewType(kotlin.reflect.jvm.internal.impl.types.SimpleType):kotlin.reflect.jvm.internal.impl.types.SimpleType");
    }

    public final boolean equalTypes(ClassicTypeCheckerContext classicTypeCheckerContext, UnwrappedType unwrappedType, UnwrappedType unwrappedType2) {
        Intrinsics.checkNotNullParameter(classicTypeCheckerContext, "<this>");
        Intrinsics.checkNotNullParameter(unwrappedType, "a");
        Intrinsics.checkNotNullParameter(unwrappedType2, "b");
        return AbstractTypeChecker.INSTANCE.equalTypes(classicTypeCheckerContext, unwrappedType, unwrappedType2);
    }

    public final boolean isSubtypeOf(ClassicTypeCheckerContext classicTypeCheckerContext, UnwrappedType unwrappedType, UnwrappedType unwrappedType2) {
        Intrinsics.checkNotNullParameter(classicTypeCheckerContext, "<this>");
        Intrinsics.checkNotNullParameter(unwrappedType, "subType");
        Intrinsics.checkNotNullParameter(unwrappedType2, "superType");
        return AbstractTypeChecker.isSubtypeOf$default(AbstractTypeChecker.INSTANCE, classicTypeCheckerContext, unwrappedType, unwrappedType2, false, 8);
    }

    public UnwrappedType transformToNewType(UnwrappedType unwrappedType) {
        UnwrappedType unwrappedType2;
        Intrinsics.checkNotNullParameter(unwrappedType, "type");
        if (unwrappedType instanceof SimpleType) {
            unwrappedType2 = transformToNewType((SimpleType) unwrappedType);
        } else if (unwrappedType instanceof FlexibleType) {
            FlexibleType flexibleType = (FlexibleType) unwrappedType;
            SimpleType transformToNewType = transformToNewType(flexibleType.lowerBound);
            SimpleType transformToNewType2 = transformToNewType(flexibleType.upperBound);
            if (transformToNewType == flexibleType.lowerBound && transformToNewType2 == flexibleType.upperBound) {
                unwrappedType2 = unwrappedType;
            } else {
                KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
                unwrappedType2 = KotlinTypeFactory.flexibleType(transformToNewType, transformToNewType2);
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return TweetUtils.inheritEnhancement(unwrappedType2, unwrappedType);
    }
}
