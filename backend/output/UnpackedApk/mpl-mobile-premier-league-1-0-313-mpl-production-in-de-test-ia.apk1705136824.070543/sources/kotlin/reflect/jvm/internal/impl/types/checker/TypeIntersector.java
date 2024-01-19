package kotlin.reflect.jvm.internal.impl.types.checker;

import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.AbstractNullabilityChecker;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext.SupertypesPolicy.LowerIfFlexible;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

/* compiled from: IntersectionType.kt */
public final class TypeIntersector {
    public static final TypeIntersector INSTANCE = new TypeIntersector();

    /* compiled from: IntersectionType.kt */
    public enum ResultNullability {
        ;

        /* compiled from: IntersectionType.kt */
        public static final class ACCEPT_NULL extends ResultNullability {
            public ACCEPT_NULL(String str, int i) {
                super(str, i, null);
            }

            public ResultNullability combine(UnwrappedType unwrappedType) {
                Intrinsics.checkNotNullParameter(unwrappedType, "nextType");
                return getResultNullability(unwrappedType);
            }
        }

        /* compiled from: IntersectionType.kt */
        public static final class NOT_NULL extends ResultNullability {
            public NOT_NULL(String str, int i) {
                super(str, i, null);
            }

            public ResultNullability combine(UnwrappedType unwrappedType) {
                Intrinsics.checkNotNullParameter(unwrappedType, "nextType");
                return this;
            }
        }

        /* compiled from: IntersectionType.kt */
        public static final class START extends ResultNullability {
            public START(String str, int i) {
                super(str, i, null);
            }

            public ResultNullability combine(UnwrappedType unwrappedType) {
                Intrinsics.checkNotNullParameter(unwrappedType, "nextType");
                return getResultNullability(unwrappedType);
            }
        }

        /* compiled from: IntersectionType.kt */
        public static final class UNKNOWN extends ResultNullability {
            public UNKNOWN(String str, int i) {
                super(str, i, null);
            }

            public ResultNullability combine(UnwrappedType unwrappedType) {
                Intrinsics.checkNotNullParameter(unwrappedType, "nextType");
                ResultNullability resultNullability = getResultNullability(unwrappedType);
                return resultNullability == ResultNullability.ACCEPT_NULL ? this : resultNullability;
            }
        }

        public abstract ResultNullability combine(UnwrappedType unwrappedType);

        public final ResultNullability getResultNullability(UnwrappedType unwrappedType) {
            Intrinsics.checkNotNullParameter(unwrappedType, "<this>");
            if (unwrappedType.isMarkedNullable()) {
                return ACCEPT_NULL;
            }
            Intrinsics.checkNotNullParameter(unwrappedType, "type");
            ClassicTypeCheckerContext classicTypeCheckerContext = new ClassicTypeCheckerContext(false, true, false, null, 12);
            if (AbstractNullabilityChecker.hasNotNullSupertype(classicTypeCheckerContext, TweetUtils.lowerIfFlexible(unwrappedType), LowerIfFlexible.INSTANCE)) {
                return NOT_NULL;
            }
            return UNKNOWN;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0051 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Collection<kotlin.reflect.jvm.internal.impl.types.SimpleType> filterTypes(java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.types.SimpleType> r8, kotlin.jvm.functions.Function2<? super kotlin.reflect.jvm.internal.impl.types.SimpleType, ? super kotlin.reflect.jvm.internal.impl.types.SimpleType, java.lang.Boolean> r9) {
        /*
            r7 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r8)
            java.util.Iterator r8 = r0.iterator()
            java.lang.String r1 = "filteredTypes.iterator()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r1)
        L_0x000e:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L_0x0058
            java.lang.Object r1 = r8.next()
            kotlin.reflect.jvm.internal.impl.types.SimpleType r1 = (kotlin.reflect.jvm.internal.impl.types.SimpleType) r1
            boolean r2 = r0.isEmpty()
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0023
            goto L_0x0052
        L_0x0023:
            java.util.Iterator r2 = r0.iterator()
        L_0x0027:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L_0x0052
            java.lang.Object r5 = r2.next()
            kotlin.reflect.jvm.internal.impl.types.SimpleType r5 = (kotlin.reflect.jvm.internal.impl.types.SimpleType) r5
            if (r5 == r1) goto L_0x004e
            java.lang.String r6 = "lower"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            java.lang.String r6 = "upper"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r6)
            java.lang.Object r5 = r9.invoke(r5, r1)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x004e
            r5 = 1
            goto L_0x004f
        L_0x004e:
            r5 = 0
        L_0x004f:
            if (r5 == 0) goto L_0x0027
            r3 = 1
        L_0x0052:
            if (r3 == 0) goto L_0x000e
            r8.remove()
            goto L_0x000e
        L_0x0058:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.filterTypes(java.util.Collection, kotlin.jvm.functions.Function2):java.util.Collection");
    }

    /* JADX WARNING: type inference failed for: r7v5, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r7v6 */
    /* JADX WARNING: type inference failed for: r10v3, types: [kotlin.reflect.jvm.internal.impl.types.KotlinType, kotlin.reflect.jvm.internal.impl.types.SimpleType, java.lang.Object] */
    /* JADX WARNING: type inference failed for: r7v8, types: [kotlin.reflect.jvm.internal.impl.types.KotlinType, kotlin.reflect.jvm.internal.impl.types.SimpleType, java.lang.Object] */
    /* JADX WARNING: type inference failed for: r7v9 */
    /* JADX WARNING: type inference failed for: r7v10 */
    /* JADX WARNING: type inference failed for: r7v13 */
    /* JADX WARNING: type inference failed for: r7v19, types: [kotlin.reflect.jvm.internal.impl.types.SimpleType] */
    /* JADX WARNING: type inference failed for: r7v21, types: [kotlin.reflect.jvm.internal.impl.types.SimpleType] */
    /* JADX WARNING: type inference failed for: r7v22, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r7v23, types: [kotlin.reflect.jvm.internal.impl.types.SimpleType] */
    /* JADX WARNING: type inference failed for: r7v24, types: [kotlin.reflect.jvm.internal.impl.types.SimpleType] */
    /* JADX WARNING: type inference failed for: r9v5, types: [kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType] */
    /* JADX WARNING: type inference failed for: r7v26 */
    /* JADX WARNING: type inference failed for: r7v34 */
    /* JADX WARNING: type inference failed for: r7v35 */
    /* JADX WARNING: type inference failed for: r7v36 */
    /* JADX WARNING: type inference failed for: r7v37 */
    /* JADX WARNING: type inference failed for: r7v38 */
    /* JADX WARNING: type inference failed for: r7v39 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r7v9
      assigns: []
      uses: []
      mth insns count: 179
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Unknown variable types count: 7 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.reflect.jvm.internal.impl.types.SimpleType intersectTypes$descriptors(java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.SimpleType> r20) {
        /*
            r19 = this;
            r0 = r19
            java.lang.String r1 = "types"
            r2 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)
            int r3 = r20.size()
            r4 = 1
            r5 = 0
            if (r3 <= r4) goto L_0x0014
            r3 = 1
            goto L_0x0015
        L_0x0014:
            r3 = 0
        L_0x0015:
            boolean r6 = kotlin._Assertions.ENABLED
            if (r6 == 0) goto L_0x0030
            if (r3 == 0) goto L_0x001c
            goto L_0x0030
        L_0x001c:
            int r1 = r20.size()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r2 = "Size should be at least 2, but it is "
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r1)
            java.lang.AssertionError r2 = new java.lang.AssertionError
            r2.<init>(r1)
            throw r2
        L_0x0030:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Iterator r2 = r20.iterator()
        L_0x0039:
            boolean r6 = r2.hasNext()
            if (r6 == 0) goto L_0x0095
            java.lang.Object r6 = r2.next()
            kotlin.reflect.jvm.internal.impl.types.SimpleType r6 = (kotlin.reflect.jvm.internal.impl.types.SimpleType) r6
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r7 = r6.getConstructor()
            boolean r7 = r7 instanceof kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor
            if (r7 == 0) goto L_0x0091
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r7 = r6.getConstructor()
            java.util.Collection r7 = r7.getSupertypes()
            java.lang.String r8 = "type.constructor.supertypes"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
            java.util.ArrayList r8 = new java.util.ArrayList
            r9 = 10
            int r9 = com.twitter.sdk.android.tweetui.TweetUtils.collectionSizeOrDefault(r7, r9)
            r8.<init>(r9)
            java.util.Iterator r7 = r7.iterator()
        L_0x006a:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x008d
            java.lang.Object r9 = r7.next()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r9 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r9
            java.lang.String r10 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)
            kotlin.reflect.jvm.internal.impl.types.SimpleType r9 = com.twitter.sdk.android.tweetui.TweetUtils.upperIfFlexible(r9)
            boolean r10 = r6.isMarkedNullable()
            if (r10 == 0) goto L_0x0089
            kotlin.reflect.jvm.internal.impl.types.SimpleType r9 = r9.makeNullableAsSpecified(r4)
        L_0x0089:
            r8.add(r9)
            goto L_0x006a
        L_0x008d:
            r3.addAll(r8)
            goto L_0x0039
        L_0x0091:
            r3.add(r6)
            goto L_0x0039
        L_0x0095:
            kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector$ResultNullability r2 = kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability.START
            java.util.Iterator r6 = r3.iterator()
        L_0x009b:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x00ac
            java.lang.Object r7 = r6.next()
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r7 = (kotlin.reflect.jvm.internal.impl.types.UnwrappedType) r7
            kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector$ResultNullability r2 = r2.combine(r7)
            goto L_0x009b
        L_0x00ac:
            java.util.LinkedHashSet r6 = new java.util.LinkedHashSet
            r6.<init>()
            java.util.Iterator r3 = r3.iterator()
        L_0x00b5:
            boolean r7 = r3.hasNext()
            java.lang.String r8 = "<this>"
            if (r7 == 0) goto L_0x00ea
            java.lang.Object r7 = r3.next()
            kotlin.reflect.jvm.internal.impl.types.SimpleType r7 = (kotlin.reflect.jvm.internal.impl.types.SimpleType) r7
            kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector$ResultNullability r9 = kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability.NOT_NULL
            if (r2 != r9) goto L_0x00e6
            boolean r9 = r7 instanceof kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType
            if (r9 == 0) goto L_0x00e2
            kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType r7 = (kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType) r7
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r8)
            kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType r8 = new kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType
            kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus r10 = r7.captureStatus
            kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor r11 = r7.constructor
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r12 = r7.lowerType
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r13 = r7.annotations
            boolean r14 = r7.isMarkedNullable
            r15 = 1
            r9 = r8
            r9.<init>(r10, r11, r12, r13, r14, r15)
            r7 = r8
        L_0x00e2:
            kotlin.reflect.jvm.internal.impl.types.SimpleType r7 = kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt.makeSimpleTypeDefinitelyNotNullOrNotNull(r7, r5)
        L_0x00e6:
            r6.add(r7)
            goto L_0x00b5
        L_0x00ea:
            int r2 = r6.size()
            if (r2 != r4) goto L_0x00f8
            java.lang.Object r1 = kotlin.collections.ArraysKt___ArraysJvmKt.single(r6)
            kotlin.reflect.jvm.internal.impl.types.SimpleType r1 = (kotlin.reflect.jvm.internal.impl.types.SimpleType) r1
            goto L_0x01f9
        L_0x00f8:
            kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector$intersectTypesWithoutIntersectionType$errorMessage$1 r2 = new kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector$intersectTypesWithoutIntersectionType$errorMessage$1
            r2.<init>(r6)
            kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector$intersectTypesWithoutIntersectionType$filteredEqualTypes$1 r3 = new kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector$intersectTypesWithoutIntersectionType$filteredEqualTypes$1
            r3.<init>(r0)
            java.util.Collection r3 = r0.filterTypes(r6, r3)
            r7 = r3
            java.util.ArrayList r7 = (java.util.ArrayList) r7
            boolean r9 = r7.isEmpty()
            r9 = r9 ^ r4
            boolean r10 = kotlin._Assertions.ENABLED
            if (r10 == 0) goto L_0x011f
            if (r9 == 0) goto L_0x0115
            goto L_0x011f
        L_0x0115:
            java.lang.Object r1 = r2.invoke()
            java.lang.AssertionError r2 = new java.lang.AssertionError
            r2.<init>(r1)
            throw r2
        L_0x011f:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r1)
            kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor$Companion$Mode r1 = kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor$Companion$Mode.INTERSECTION_TYPE
            boolean r1 = r7.isEmpty()
            r9 = 0
            if (r1 == 0) goto L_0x012e
            r1 = r9
            goto L_0x01b6
        L_0x012e:
            java.util.Iterator r1 = r7.iterator()
            boolean r7 = r1.hasNext()
            if (r7 == 0) goto L_0x01fa
            java.lang.Object r7 = r1.next()
        L_0x013c:
            boolean r10 = r1.hasNext()
            if (r10 == 0) goto L_0x01b3
            java.lang.Object r10 = r1.next()
            kotlin.reflect.jvm.internal.impl.types.SimpleType r10 = (kotlin.reflect.jvm.internal.impl.types.SimpleType) r10
            kotlin.reflect.jvm.internal.impl.types.SimpleType r7 = (kotlin.reflect.jvm.internal.impl.types.SimpleType) r7
            if (r7 == 0) goto L_0x01b1
            if (r10 != 0) goto L_0x014f
            goto L_0x01b1
        L_0x014f:
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r11 = r7.getConstructor()
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r12 = r10.getConstructor()
            boolean r13 = r11 instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor
            if (r13 == 0) goto L_0x0194
            boolean r14 = r12 instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor
            if (r14 == 0) goto L_0x0194
            kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor r11 = (kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor) r11
            kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor r12 = (kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor) r12
            java.util.Set<kotlin.reflect.jvm.internal.impl.types.KotlinType> r7 = r11.possibleTypes
            java.util.Set<kotlin.reflect.jvm.internal.impl.types.KotlinType> r10 = r12.possibleTypes
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r8)
            java.lang.String r12 = "other"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r12)
            java.util.Set r7 = kotlin.collections.ArraysKt___ArraysJvmKt.toMutableSet(r7)
            com.twitter.sdk.android.tweetui.TweetUtils.addAll(r7, r10)
            kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor r10 = new kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor
            long r14 = r11.value
            kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor r11 = r11.module
            r18 = 0
            r13 = r10
            r16 = r11
            r17 = r7
            r13.<init>(r14, r16, r17, r18)
            kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory r7 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.INSTANCE
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations$Companion r7 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion
            if (r7 == 0) goto L_0x0193
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r7 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.EMPTY
            kotlin.reflect.jvm.internal.impl.types.SimpleType r7 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.integerLiteralType(r7, r10, r5)
            goto L_0x013c
        L_0x0193:
            throw r9
        L_0x0194:
            if (r13 == 0) goto L_0x01a2
            kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor r11 = (kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor) r11
            java.util.Set<kotlin.reflect.jvm.internal.impl.types.KotlinType> r7 = r11.possibleTypes
            boolean r7 = r7.contains(r10)
            if (r7 == 0) goto L_0x01b1
            r7 = r10
            goto L_0x013c
        L_0x01a2:
            boolean r10 = r12 instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor
            if (r10 == 0) goto L_0x01b1
            kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor r12 = (kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor) r12
            java.util.Set<kotlin.reflect.jvm.internal.impl.types.KotlinType> r10 = r12.possibleTypes
            boolean r10 = r10.contains(r7)
            if (r10 == 0) goto L_0x01b1
            goto L_0x013c
        L_0x01b1:
            r7 = r9
            goto L_0x013c
        L_0x01b3:
            kotlin.reflect.jvm.internal.impl.types.SimpleType r7 = (kotlin.reflect.jvm.internal.impl.types.SimpleType) r7
            r1 = r7
        L_0x01b6:
            if (r1 != 0) goto L_0x01f9
            kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector$intersectTypesWithoutIntersectionType$filteredSuperAndEqualTypes$1 r1 = new kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector$intersectTypesWithoutIntersectionType$filteredSuperAndEqualTypes$1
            kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker$Companion r5 = kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker.Companion
            if (r5 == 0) goto L_0x01f8
            kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeCheckerImpl r5 = kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker.Companion.Default
            r1.<init>(r5)
            java.util.Collection r1 = r0.filterTypes(r3, r1)
            r3 = r1
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            boolean r5 = r3.isEmpty()
            r4 = r4 ^ r5
            boolean r5 = kotlin._Assertions.ENABLED
            if (r5 == 0) goto L_0x01e0
            if (r4 == 0) goto L_0x01d6
            goto L_0x01e0
        L_0x01d6:
            java.lang.Object r1 = r2.invoke()
            java.lang.AssertionError r2 = new java.lang.AssertionError
            r2.<init>(r1)
            throw r2
        L_0x01e0:
            int r2 = r3.size()
            r3 = 2
            if (r2 >= r3) goto L_0x01ee
            java.lang.Object r1 = kotlin.collections.ArraysKt___ArraysJvmKt.single(r1)
            kotlin.reflect.jvm.internal.impl.types.SimpleType r1 = (kotlin.reflect.jvm.internal.impl.types.SimpleType) r1
            goto L_0x01f9
        L_0x01ee:
            kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor r1 = new kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor
            r1.<init>(r6)
            kotlin.reflect.jvm.internal.impl.types.SimpleType r1 = r1.createType()
            goto L_0x01f9
        L_0x01f8:
            throw r9
        L_0x01f9:
            return r1
        L_0x01fa:
            java.lang.UnsupportedOperationException r1 = new java.lang.UnsupportedOperationException
            java.lang.String r2 = "Empty collection can't be reduced."
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.intersectTypes$descriptors(java.util.List):kotlin.reflect.jvm.internal.impl.types.SimpleType");
    }
}
