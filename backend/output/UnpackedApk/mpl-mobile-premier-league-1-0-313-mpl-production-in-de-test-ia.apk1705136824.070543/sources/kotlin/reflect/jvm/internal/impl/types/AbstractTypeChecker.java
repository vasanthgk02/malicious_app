package kotlin.reflect.jvm.internal.impl.types;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin._Assertions;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext.SupertypesPolicy;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext.SupertypesPolicy.LowerIfFlexible;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext.SupertypesPolicy.None;
import kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeCheckerContext;
import kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeCheckerContext$Companion$classicSubstitutionSupertypePolicy$2;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;

/* compiled from: AbstractTypeChecker.kt */
public final class AbstractTypeChecker {
    public static final AbstractTypeChecker INSTANCE = new AbstractTypeChecker();

    public static final boolean checkSubtypeForIntegerLiteralType$isTypeInIntegerLiteralType(AbstractTypeCheckerContext abstractTypeCheckerContext, AbstractTypeChecker abstractTypeChecker, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2, boolean z) {
        boolean z2;
        Collection<KotlinTypeMarker> possibleIntegerTypes = abstractTypeCheckerContext.possibleIntegerTypes(simpleTypeMarker);
        if ((possibleIntegerTypes instanceof Collection) && possibleIntegerTypes.isEmpty()) {
            return false;
        }
        for (KotlinTypeMarker kotlinTypeMarker : possibleIntegerTypes) {
            if (Intrinsics.areEqual(TweetUtils.typeConstructor((TypeSystemContext) abstractTypeCheckerContext, kotlinTypeMarker), abstractTypeCheckerContext.typeConstructor(simpleTypeMarker2)) || (z && isSubtypeOf$default(abstractTypeChecker, abstractTypeCheckerContext, simpleTypeMarker2, kotlinTypeMarker, false, 8))) {
                z2 = true;
                continue;
            } else {
                z2 = false;
                continue;
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:223:0x0474, code lost:
        if ((r7.getVariance(r14) == kotlin.reflect.jvm.internal.impl.types.model.TypeVariance.INV) != false) goto L_0x0478;
     */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x025f  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x02f0  */
    /* JADX WARNING: Removed duplicated region for block: B:276:0x05be  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isSubtypeOf$default(kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker r21, kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext r22, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r23, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r24, boolean r25, int r26) {
        /*
            r6 = r21
            r7 = r22
            r0 = r23
            r1 = r24
            if (r6 == 0) goto L_0x05cf
            java.lang.String r8 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r8)
            java.lang.String r9 = "subType"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r9)
            java.lang.String r10 = "superType"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r10)
            r11 = 1
            r2 = 0
            if (r0 != r1) goto L_0x0021
            goto L_0x05ce
        L_0x0021:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r9)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r10)
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r0 = r22.refineType(r23)
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r12 = r7.prepareType(r0)
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r0 = r7.refineType(r1)
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r13 = r7.prepareType(r0)
            kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r14 = com.twitter.sdk.android.tweetui.TweetUtils.lowerBoundIfFlexible(r7, r12)
            kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r15 = com.twitter.sdk.android.tweetui.TweetUtils.upperBoundIfFlexible(r7, r13)
            boolean r0 = r7.isError(r14)
            if (r0 != 0) goto L_0x010b
            boolean r0 = r7.isError(r15)
            if (r0 == 0) goto L_0x004d
            goto L_0x010b
        L_0x004d:
            boolean r0 = r7.isStubType(r14)
            if (r0 != 0) goto L_0x0101
            boolean r0 = r7.isStubType(r15)
            if (r0 == 0) goto L_0x005b
            goto L_0x0101
        L_0x005b:
            kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker r0 = r7.asDefinitelyNotNullType(r15)
            if (r0 != 0) goto L_0x0063
            r0 = r15
            goto L_0x0067
        L_0x0063:
            kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r0 = r7.original(r0)
        L_0x0067:
            kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker r0 = r7.asCapturedType(r0)
            if (r0 != 0) goto L_0x006f
            r1 = 0
            goto L_0x0073
        L_0x006f:
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r1 = r7.lowerType(r0)
        L_0x0073:
            if (r0 == 0) goto L_0x00a7
            if (r1 == 0) goto L_0x00a7
            boolean r2 = r7.isMarkedNullable(r15)
            if (r2 == 0) goto L_0x0082
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r1 = r7.withNullability(r1, r11)
            goto L_0x008c
        L_0x0082:
            boolean r2 = r7.isDefinitelyNotNullType(r15)
            if (r2 == 0) goto L_0x008c
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r1 = r7.makeDefinitelyNotNullOrNotNull(r1)
        L_0x008c:
            r3 = r1
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r9)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r10)
            kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext$LowerCapturedTypePolicy r0 = kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext.LowerCapturedTypePolicy.CHECK_SUBTYPE_AND_LOWER
            r4 = 0
            r5 = 8
            r0 = r21
            r1 = r22
            r2 = r14
            boolean r0 = isSubtypeOf$default(r0, r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x00a7
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            goto L_0x0141
        L_0x00a7:
            kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker r0 = r7.typeConstructor(r15)
            boolean r1 = r7.isIntersection(r0)
            if (r1 == 0) goto L_0x00ff
            boolean r1 = r7.isMarkedNullable(r15)
            r1 = r1 ^ r11
            boolean r2 = kotlin._Assertions.ENABLED
            if (r2 == 0) goto L_0x00c9
            if (r1 == 0) goto L_0x00bd
            goto L_0x00c9
        L_0x00bd:
            java.lang.String r0 = "Intersection type should not be marked nullable!: "
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r0, r15)
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>(r0)
            throw r1
        L_0x00c9:
            java.util.Collection r0 = r7.supertypes(r0)
            boolean r1 = r0 instanceof java.util.Collection
            if (r1 == 0) goto L_0x00d8
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x00d8
            goto L_0x00f9
        L_0x00d8:
            java.util.Iterator r15 = r0.iterator()
        L_0x00dc:
            boolean r0 = r15.hasNext()
            if (r0 == 0) goto L_0x00f9
            java.lang.Object r0 = r15.next()
            r3 = r0
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r3 = (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r3
            r4 = 0
            r5 = 8
            r0 = r21
            r1 = r22
            r2 = r14
            boolean r0 = isSubtypeOf$default(r0, r1, r2, r3, r4, r5)
            if (r0 != 0) goto L_0x00dc
            r0 = 0
            goto L_0x00fa
        L_0x00f9:
            r0 = 1
        L_0x00fa:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x0141
        L_0x00ff:
            r0 = 0
            goto L_0x0141
        L_0x0101:
            r0 = r7
            kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeCheckerContext r0 = (kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeCheckerContext) r0
            boolean r0 = r0.stubTypeEqualsToAnything
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x0141
        L_0x010b:
            r0 = r7
            kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeCheckerContext r0 = (kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeCheckerContext) r0
            boolean r0 = r0.errorTypeEqualsToAnything
            if (r0 == 0) goto L_0x0115
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            goto L_0x0141
        L_0x0115:
            boolean r0 = r7.isMarkedNullable(r14)
            if (r0 == 0) goto L_0x0124
            boolean r0 = r7.isMarkedNullable(r15)
            if (r0 != 0) goto L_0x0124
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            goto L_0x0141
        L_0x0124:
            kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r0 = r7.withNullability(r14, r2)
            kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r1 = r7.withNullability(r15, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r8)
            java.lang.String r2 = "a"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            java.lang.String r2 = "b"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            boolean r0 = kotlin.reflect.jvm.internal.impl.types.AbstractStrictEqualityTypeChecker.strictEqualTypesInternal(r7, r0, r1)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
        L_0x0141:
            if (r0 != 0) goto L_0x05c6
            r7.addSubtypeConstraint(r12, r13)
            kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r0 = com.twitter.sdk.android.tweetui.TweetUtils.lowerBoundIfFlexible(r7, r12)
            kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r1 = com.twitter.sdk.android.tweetui.TweetUtils.upperBoundIfFlexible(r7, r13)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r8)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r9)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r10)
            boolean r2 = r7.isMarkedNullable(r1)
            java.lang.String r3 = "<this>"
            java.lang.String r4 = "current"
            java.lang.String r5 = ". Supertypes = "
            java.lang.String r8 = "Too many supertypes for type: "
            r10 = 1000(0x3e8, float:1.401E-42)
            if (r2 == 0) goto L_0x0169
            goto L_0x0229
        L_0x0169:
            boolean r2 = r7.isDefinitelyNotNullType(r0)
            if (r2 == 0) goto L_0x0171
            goto L_0x0229
        L_0x0171:
            boolean r2 = r0 instanceof kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker
            if (r2 == 0) goto L_0x0180
            r2 = r0
            kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker r2 = (kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker) r2
            boolean r2 = r7.isProjectionNotNull(r2)
            if (r2 == 0) goto L_0x0180
            goto L_0x0229
        L_0x0180:
            kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext$SupertypesPolicy$LowerIfFlexible r2 = kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext.SupertypesPolicy.LowerIfFlexible.INSTANCE
            boolean r2 = kotlin.reflect.jvm.internal.impl.types.AbstractNullabilityChecker.hasNotNullSupertype(r7, r0, r2)
            if (r2 == 0) goto L_0x018a
            goto L_0x0229
        L_0x018a:
            boolean r2 = r7.isDefinitelyNotNullType(r1)
            if (r2 == 0) goto L_0x0192
            goto L_0x025a
        L_0x0192:
            kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext$SupertypesPolicy$UpperIfFlexible r2 = kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext.SupertypesPolicy.UpperIfFlexible.INSTANCE
            boolean r2 = kotlin.reflect.jvm.internal.impl.types.AbstractNullabilityChecker.hasNotNullSupertype(r7, r1, r2)
            if (r2 == 0) goto L_0x019c
            goto L_0x025a
        L_0x019c:
            boolean r2 = r7.isClassType(r0)
            if (r2 == 0) goto L_0x01a4
            goto L_0x025a
        L_0x01a4:
            kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker r2 = r7.typeConstructor(r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r3)
            java.lang.String r12 = "start"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r12)
            java.lang.String r12 = "end"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r12)
            boolean r12 = kotlin.reflect.jvm.internal.impl.types.AbstractNullabilityChecker.isApplicableAsEndNode(r7, r0, r2)
            if (r12 == 0) goto L_0x01bd
            goto L_0x0229
        L_0x01bd:
            r22.initialize()
            java.util.ArrayDeque<kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker> r12 = r7.supertypesDeque
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            java.util.Set<kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker> r13 = r7.supertypesSet
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
            r12.push(r0)
        L_0x01cd:
            boolean r14 = r12.isEmpty()
            r14 = r14 ^ 1
            if (r14 == 0) goto L_0x0257
            int r14 = r13.size()
            if (r14 > r10) goto L_0x0232
            java.lang.Object r10 = r12.pop()
            kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r10 = (kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) r10
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r4)
            boolean r14 = r13.add(r10)
            if (r14 != 0) goto L_0x01eb
            goto L_0x022f
        L_0x01eb:
            boolean r14 = r7.isMarkedNullable(r10)
            if (r14 == 0) goto L_0x01f4
            kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext$SupertypesPolicy$None r14 = kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE
            goto L_0x01f6
        L_0x01f4:
            kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext$SupertypesPolicy$LowerIfFlexible r14 = kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext.SupertypesPolicy.LowerIfFlexible.INSTANCE
        L_0x01f6:
            kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext$SupertypesPolicy$None r15 = kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE
            boolean r15 = kotlin.jvm.internal.Intrinsics.areEqual(r14, r15)
            r15 = r15 ^ r11
            if (r15 == 0) goto L_0x0200
            goto L_0x0201
        L_0x0200:
            r14 = 0
        L_0x0201:
            if (r14 != 0) goto L_0x0204
            goto L_0x022f
        L_0x0204:
            kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker r10 = r7.typeConstructor(r10)
            java.util.Collection r10 = r7.supertypes(r10)
            java.util.Iterator r10 = r10.iterator()
        L_0x0210:
            boolean r15 = r10.hasNext()
            if (r15 == 0) goto L_0x022f
            java.lang.Object r15 = r10.next()
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r15 = (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r15
            kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r15 = r14.transformType(r7, r15)
            boolean r16 = kotlin.reflect.jvm.internal.impl.types.AbstractNullabilityChecker.isApplicableAsEndNode(r7, r15, r2)
            if (r16 == 0) goto L_0x022b
            r22.clear()
        L_0x0229:
            r2 = 1
            goto L_0x025b
        L_0x022b:
            r12.add(r15)
            goto L_0x0210
        L_0x022f:
            r10 = 1000(0x3e8, float:1.401E-42)
            goto L_0x01cd
        L_0x0232:
            java.lang.StringBuilder r0 = com.android.tools.r8.GeneratedOutlineSupport.outline83(r8, r0, r5)
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 63
            java.lang.String r1 = kotlin.collections.ArraysKt___ArraysJvmKt.joinToString$default(r13, r14, r15, r16, r17, r18, r19, r20)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x0257:
            r22.clear()
        L_0x025a:
            r2 = 0
        L_0x025b:
            if (r2 != 0) goto L_0x025f
            goto L_0x05bc
        L_0x025f:
            kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r2 = com.twitter.sdk.android.tweetui.TweetUtils.lowerBoundIfFlexible(r7, r0)
            kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r10 = com.twitter.sdk.android.tweetui.TweetUtils.upperBoundIfFlexible(r7, r1)
            boolean r12 = r7.isIntegerLiteralType(r2)
            if (r12 != 0) goto L_0x0275
            boolean r12 = r7.isIntegerLiteralType(r10)
            if (r12 != 0) goto L_0x0275
            goto L_0x02ed
        L_0x0275:
            boolean r12 = r7.isIntegerLiteralType(r2)
            if (r12 == 0) goto L_0x0285
            boolean r12 = r7.isIntegerLiteralType(r10)
            if (r12 == 0) goto L_0x0285
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            goto L_0x02ee
        L_0x0285:
            boolean r12 = r7.isIntegerLiteralType(r2)
            if (r12 == 0) goto L_0x0295
            r12 = 0
            boolean r2 = checkSubtypeForIntegerLiteralType$isTypeInIntegerLiteralType(r7, r6, r2, r10, r12)
            if (r2 == 0) goto L_0x02ed
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            goto L_0x02ee
        L_0x0295:
            boolean r12 = r7.isIntegerLiteralType(r10)
            if (r12 == 0) goto L_0x02ed
            kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker r12 = r7.typeConstructor(r2)
            boolean r13 = r12 instanceof kotlin.reflect.jvm.internal.impl.types.model.IntersectionTypeConstructorMarker
            if (r13 == 0) goto L_0x02e1
            java.util.Collection r12 = r7.supertypes(r12)
            boolean r13 = r12 instanceof java.util.Collection
            if (r13 == 0) goto L_0x02b2
            boolean r13 = r12.isEmpty()
            if (r13 == 0) goto L_0x02b2
            goto L_0x02dc
        L_0x02b2:
            java.util.Iterator r12 = r12.iterator()
        L_0x02b6:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x02dc
            java.lang.Object r13 = r12.next()
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r13 = (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r13
            kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r13 = r7.asSimpleType(r13)
            if (r13 != 0) goto L_0x02ca
            r13 = 0
            goto L_0x02d2
        L_0x02ca:
            boolean r13 = r7.isIntegerLiteralType(r13)
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r13)
        L_0x02d2:
            java.lang.Boolean r14 = java.lang.Boolean.TRUE
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual(r13, r14)
            if (r13 == 0) goto L_0x02b6
            r12 = 1
            goto L_0x02dd
        L_0x02dc:
            r12 = 0
        L_0x02dd:
            if (r12 == 0) goto L_0x02e1
            r12 = 1
            goto L_0x02e2
        L_0x02e1:
            r12 = 0
        L_0x02e2:
            if (r12 != 0) goto L_0x02ea
            boolean r2 = checkSubtypeForIntegerLiteralType$isTypeInIntegerLiteralType(r7, r6, r10, r2, r11)
            if (r2 == 0) goto L_0x02ed
        L_0x02ea:
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            goto L_0x02ee
        L_0x02ed:
            r2 = 0
        L_0x02ee:
            if (r2 != 0) goto L_0x05be
            kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker r2 = r7.typeConstructor(r1)
            kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker r10 = r7.typeConstructor(r0)
            boolean r10 = r7.areEqualTypeConstructors(r10, r2)
            if (r10 == 0) goto L_0x0306
            int r10 = r7.parametersCount(r2)
            if (r10 != 0) goto L_0x0306
            goto L_0x0592
        L_0x0306:
            kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker r10 = r7.typeConstructor(r1)
            boolean r10 = r7.isAnyConstructor(r10)
            if (r10 == 0) goto L_0x0312
            goto L_0x0592
        L_0x0312:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r9)
            java.lang.String r3 = "superConstructor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            boolean r3 = r7.isClassType(r0)
            if (r3 == 0) goto L_0x032a
            java.util.List r3 = r6.collectAndFilter(r7, r0, r2)
            goto L_0x03f6
        L_0x032a:
            boolean r3 = r7.isClassTypeConstructor(r2)
            if (r3 != 0) goto L_0x033c
            boolean r3 = r7.isIntegerLiteralTypeConstructor(r2)
            if (r3 != 0) goto L_0x033c
            java.util.List r3 = r6.collectAllSupertypesWithGivenTypeConstructor(r7, r0, r2)
            goto L_0x03f6
        L_0x033c:
            kotlin.reflect.jvm.internal.impl.utils.SmartList r3 = new kotlin.reflect.jvm.internal.impl.utils.SmartList
            r3.<init>()
            r22.initialize()
            java.util.ArrayDeque<kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker> r9 = r7.supertypesDeque
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            java.util.Set<kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker> r12 = r7.supertypesSet
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            r9.push(r0)
        L_0x0351:
            boolean r10 = r9.isEmpty()
            r10 = r10 ^ r11
            if (r10 == 0) goto L_0x03d0
            int r10 = r12.size()
            r13 = 1000(0x3e8, float:1.401E-42)
            if (r10 > r13) goto L_0x03ac
            java.lang.Object r10 = r9.pop()
            kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r10 = (kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) r10
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r4)
            boolean r13 = r12.add(r10)
            if (r13 != 0) goto L_0x0370
            goto L_0x0351
        L_0x0370:
            boolean r13 = r7.isClassType(r10)
            if (r13 == 0) goto L_0x037c
            r3.add(r10)
            kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext$SupertypesPolicy$None r13 = kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE
            goto L_0x037e
        L_0x037c:
            kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext$SupertypesPolicy$LowerIfFlexible r13 = kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext.SupertypesPolicy.LowerIfFlexible.INSTANCE
        L_0x037e:
            kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext$SupertypesPolicy$None r14 = kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE
            boolean r14 = kotlin.jvm.internal.Intrinsics.areEqual(r13, r14)
            r14 = r14 ^ r11
            if (r14 == 0) goto L_0x0388
            goto L_0x0389
        L_0x0388:
            r13 = 0
        L_0x0389:
            if (r13 != 0) goto L_0x038c
            goto L_0x0351
        L_0x038c:
            kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker r10 = r7.typeConstructor(r10)
            java.util.Collection r10 = r7.supertypes(r10)
            java.util.Iterator r10 = r10.iterator()
        L_0x0398:
            boolean r14 = r10.hasNext()
            if (r14 == 0) goto L_0x0351
            java.lang.Object r14 = r10.next()
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r14 = (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r14
            kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r14 = r13.transformType(r7, r14)
            r9.add(r14)
            goto L_0x0398
        L_0x03ac:
            java.lang.StringBuilder r0 = com.android.tools.r8.GeneratedOutlineSupport.outline83(r8, r0, r5)
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 63
            java.lang.String r1 = kotlin.collections.ArraysKt___ArraysJvmKt.joinToString$default(r12, r13, r14, r15, r16, r17, r18, r19)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x03d0:
            r22.clear()
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.Iterator r3 = r3.iterator()
        L_0x03dc:
            boolean r10 = r3.hasNext()
            if (r10 == 0) goto L_0x03f5
            java.lang.Object r10 = r3.next()
            kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r10 = (kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) r10
            java.lang.String r12 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r12)
            java.util.List r10 = r6.collectAndFilter(r7, r10, r2)
            com.twitter.sdk.android.tweetui.TweetUtils.addAll(r9, r10)
            goto L_0x03dc
        L_0x03f5:
            r3 = r9
        L_0x03f6:
            int r9 = r3.size()
            if (r9 == 0) goto L_0x0503
            if (r9 == r11) goto L_0x04f3
            kotlin.reflect.jvm.internal.impl.types.model.ArgumentList r4 = new kotlin.reflect.jvm.internal.impl.types.model.ArgumentList
            int r5 = r7.parametersCount(r2)
            r4.<init>(r5)
            int r5 = r7.parametersCount(r2)
            if (r5 <= 0) goto L_0x04c4
            r8 = 0
            r9 = 0
        L_0x040f:
            int r10 = r8 + 1
            if (r9 != 0) goto L_0x0422
            kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker r9 = r7.getParameter(r2, r8)
            kotlin.reflect.jvm.internal.impl.types.model.TypeVariance r9 = r7.getVariance(r9)
            kotlin.reflect.jvm.internal.impl.types.model.TypeVariance r11 = kotlin.reflect.jvm.internal.impl.types.model.TypeVariance.OUT
            if (r9 == r11) goto L_0x0420
            goto L_0x0422
        L_0x0420:
            r9 = 0
            goto L_0x0423
        L_0x0422:
            r9 = 1
        L_0x0423:
            if (r9 == 0) goto L_0x0429
            r23 = r2
            goto L_0x04bc
        L_0x0429:
            java.util.ArrayList r11 = new java.util.ArrayList
            r12 = 10
            int r12 = com.twitter.sdk.android.tweetui.TweetUtils.collectionSizeOrDefault(r3, r12)
            r11.<init>(r12)
            java.util.Iterator r12 = r3.iterator()
        L_0x0438:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x04af
            java.lang.Object r13 = r12.next()
            kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r13 = (kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) r13
            java.lang.String r14 = "this"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r14)
            java.lang.String r14 = "receiver"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r14)
            if (r8 < 0) goto L_0x0459
            int r14 = r7.argumentsCount(r13)
            if (r8 >= r14) goto L_0x0459
            r14 = 1
            goto L_0x045a
        L_0x0459:
            r14 = 0
        L_0x045a:
            if (r14 == 0) goto L_0x0461
            kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker r14 = r7.getArgument(r13, r8)
            goto L_0x0462
        L_0x0461:
            r14 = 0
        L_0x0462:
            if (r14 != 0) goto L_0x0467
            r23 = r2
            goto L_0x0477
        L_0x0467:
            kotlin.reflect.jvm.internal.impl.types.model.TypeVariance r15 = r7.getVariance(r14)
            r23 = r2
            kotlin.reflect.jvm.internal.impl.types.model.TypeVariance r2 = kotlin.reflect.jvm.internal.impl.types.model.TypeVariance.INV
            if (r15 != r2) goto L_0x0473
            r2 = 1
            goto L_0x0474
        L_0x0473:
            r2 = 0
        L_0x0474:
            if (r2 == 0) goto L_0x0477
            goto L_0x0478
        L_0x0477:
            r14 = 0
        L_0x0478:
            if (r14 == 0) goto L_0x0484
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r2 = r7.getType(r14)
            r11.add(r2)
            r2 = r23
            goto L_0x0438
        L_0x0484:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Incorrect type: "
            r2.append(r3)
            r2.append(r13)
            java.lang.String r3 = ", subType: "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = ", superType: "
            r2.append(r0)
            r2.append(r1)
            java.lang.String r0 = r2.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x04af:
            r23 = r2
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r2 = r7.intersectTypes(r11)
            kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker r2 = r7.asTypeArgument(r2)
            r4.add(r2)
        L_0x04bc:
            if (r10 < r5) goto L_0x04bf
            goto L_0x04c5
        L_0x04bf:
            r2 = r23
            r8 = r10
            goto L_0x040f
        L_0x04c4:
            r9 = 0
        L_0x04c5:
            if (r9 != 0) goto L_0x04cf
            boolean r0 = r6.isSubtypeForSameConstructor(r7, r4, r1)
            if (r0 == 0) goto L_0x04cf
            goto L_0x0592
        L_0x04cf:
            boolean r0 = r3.isEmpty()
            if (r0 == 0) goto L_0x04d7
            goto L_0x05bc
        L_0x04d7:
            java.util.Iterator r0 = r3.iterator()
        L_0x04db:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x05bc
            java.lang.Object r2 = r0.next()
            kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r2 = (kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) r2
            kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker r2 = r7.asArgumentList(r2)
            boolean r2 = r6.isSubtypeForSameConstructor(r7, r2, r1)
            if (r2 == 0) goto L_0x04db
            goto L_0x0592
        L_0x04f3:
            java.lang.Object r0 = kotlin.collections.ArraysKt___ArraysJvmKt.first(r3)
            kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r0 = (kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) r0
            kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker r0 = r7.asArgumentList(r0)
            boolean r0 = r6.isSubtypeForSameConstructor(r7, r0, r1)
            goto L_0x05cd
        L_0x0503:
            kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker r1 = r7.typeConstructor(r0)
            boolean r2 = r7.isClassTypeConstructor(r1)
            if (r2 == 0) goto L_0x0513
            boolean r0 = r7.isNothingConstructor(r1)
            goto L_0x05cd
        L_0x0513:
            kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker r1 = r7.typeConstructor(r0)
            boolean r1 = r7.isNothingConstructor(r1)
            if (r1 == 0) goto L_0x051f
            goto L_0x0592
        L_0x051f:
            r22.initialize()
            java.util.ArrayDeque<kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker> r1 = r7.supertypesDeque
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            java.util.Set<kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker> r9 = r7.supertypesSet
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            r1.push(r0)
        L_0x052f:
            boolean r2 = r1.isEmpty()
            r2 = r2 ^ 1
            if (r2 == 0) goto L_0x05b9
            int r2 = r9.size()
            r3 = 1000(0x3e8, float:1.401E-42)
            if (r2 > r3) goto L_0x0598
            java.lang.Object r2 = r1.pop()
            kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r2 = (kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) r2
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            boolean r3 = r9.add(r2)
            if (r3 != 0) goto L_0x054f
            goto L_0x052f
        L_0x054f:
            boolean r3 = r7.isClassType(r2)
            if (r3 == 0) goto L_0x0558
            kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext$SupertypesPolicy$None r3 = kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE
            goto L_0x055a
        L_0x0558:
            kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext$SupertypesPolicy$LowerIfFlexible r3 = kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext.SupertypesPolicy.LowerIfFlexible.INSTANCE
        L_0x055a:
            kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext$SupertypesPolicy$None r6 = kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r6)
            r6 = r6 ^ 1
            if (r6 == 0) goto L_0x0565
            goto L_0x0566
        L_0x0565:
            r3 = 0
        L_0x0566:
            if (r3 != 0) goto L_0x0569
            goto L_0x052f
        L_0x0569:
            kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker r2 = r7.typeConstructor(r2)
            java.util.Collection r2 = r7.supertypes(r2)
            java.util.Iterator r2 = r2.iterator()
        L_0x0575:
            boolean r6 = r2.hasNext()
            if (r6 == 0) goto L_0x052f
            java.lang.Object r6 = r2.next()
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r6 = (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r6
            kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r6 = r3.transformType(r7, r6)
            kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker r10 = r7.typeConstructor(r6)
            boolean r10 = r7.isNothingConstructor(r10)
            if (r10 == 0) goto L_0x0594
            r22.clear()
        L_0x0592:
            r11 = 1
            goto L_0x05ce
        L_0x0594:
            r1.add(r6)
            goto L_0x0575
        L_0x0598:
            java.lang.StringBuilder r0 = com.android.tools.r8.GeneratedOutlineSupport.outline83(r8, r0, r5)
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 63
            java.lang.String r1 = kotlin.collections.ArraysKt___ArraysJvmKt.joinToString$default(r9, r10, r11, r12, r13, r14, r15, r16)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x05b9:
            r22.clear()
        L_0x05bc:
            r11 = 0
            goto L_0x05ce
        L_0x05be:
            boolean r11 = r2.booleanValue()
            r7.addSubtypeConstraint(r0, r1)
            goto L_0x05ce
        L_0x05c6:
            boolean r0 = r0.booleanValue()
            r7.addSubtypeConstraint(r12, r13)
        L_0x05cd:
            r11 = r0
        L_0x05ce:
            return r11
        L_0x05cf:
            r0 = 0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker.isSubtypeOf$default(kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker, kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker, boolean, int):boolean");
    }

    public final List<SimpleTypeMarker> collectAllSupertypesWithGivenTypeConstructor(AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker, TypeConstructorMarker typeConstructorMarker) {
        SupertypesPolicy supertypesPolicy;
        List<SimpleTypeMarker> list;
        if (abstractTypeCheckerContext != null) {
            Intrinsics.checkNotNullParameter(abstractTypeCheckerContext, "this");
            Intrinsics.checkNotNullParameter(simpleTypeMarker, "receiver");
            Intrinsics.checkNotNullParameter(typeConstructorMarker, "constructor");
            if (!abstractTypeCheckerContext.isClassTypeConstructor(typeConstructorMarker) && abstractTypeCheckerContext.isClassType(simpleTypeMarker)) {
                return EmptyList.INSTANCE;
            }
            if (abstractTypeCheckerContext.isCommonFinalClassConstructor(typeConstructorMarker)) {
                if (abstractTypeCheckerContext.areEqualTypeConstructors(abstractTypeCheckerContext.typeConstructor(simpleTypeMarker), typeConstructorMarker)) {
                    SimpleTypeMarker captureFromArguments = abstractTypeCheckerContext.captureFromArguments(simpleTypeMarker, CaptureStatus.FOR_SUBTYPING);
                    if (captureFromArguments != null) {
                        simpleTypeMarker = captureFromArguments;
                    }
                    list = TweetUtils.listOf(simpleTypeMarker);
                } else {
                    list = EmptyList.INSTANCE;
                }
                return list;
            }
            SmartList smartList = new SmartList();
            abstractTypeCheckerContext.initialize();
            ArrayDeque<SimpleTypeMarker> arrayDeque = abstractTypeCheckerContext.supertypesDeque;
            Intrinsics.checkNotNull(arrayDeque);
            Set<SimpleTypeMarker> set = abstractTypeCheckerContext.supertypesSet;
            Intrinsics.checkNotNull(set);
            arrayDeque.push(simpleTypeMarker);
            while (!arrayDeque.isEmpty()) {
                if (set.size() <= 1000) {
                    SimpleTypeMarker pop = arrayDeque.pop();
                    Intrinsics.checkNotNullExpressionValue(pop, "current");
                    if (set.add(pop)) {
                        SimpleTypeMarker captureFromArguments2 = abstractTypeCheckerContext.captureFromArguments(pop, CaptureStatus.FOR_SUBTYPING);
                        if (captureFromArguments2 == null) {
                            captureFromArguments2 = pop;
                        }
                        if (abstractTypeCheckerContext.areEqualTypeConstructors(abstractTypeCheckerContext.typeConstructor(captureFromArguments2), typeConstructorMarker)) {
                            smartList.add(captureFromArguments2);
                            supertypesPolicy = None.INSTANCE;
                        } else if (abstractTypeCheckerContext.argumentsCount(captureFromArguments2) == 0) {
                            supertypesPolicy = LowerIfFlexible.INSTANCE;
                        } else {
                            ClassicTypeCheckerContext classicTypeCheckerContext = (ClassicTypeCheckerContext) abstractTypeCheckerContext;
                            Intrinsics.checkNotNullParameter(captureFromArguments2, "type");
                            Intrinsics.checkNotNullParameter(classicTypeCheckerContext, "<this>");
                            Intrinsics.checkNotNullParameter(captureFromArguments2, "type");
                            if (captureFromArguments2 instanceof SimpleType) {
                                supertypesPolicy = new ClassicTypeCheckerContext$Companion$classicSubstitutionSupertypePolicy$2(classicTypeCheckerContext, TypeConstructorSubstitution.Companion.create((KotlinType) captureFromArguments2).buildSubstitutor());
                            } else {
                                throw new IllegalArgumentException(TweetUtils.access$errorMessage(captureFromArguments2).toString());
                            }
                        }
                        if (!(!Intrinsics.areEqual(supertypesPolicy, None.INSTANCE))) {
                            supertypesPolicy = null;
                        }
                        if (supertypesPolicy != null) {
                            for (KotlinTypeMarker transformType : abstractTypeCheckerContext.supertypes(abstractTypeCheckerContext.typeConstructor(pop))) {
                                arrayDeque.add(supertypesPolicy.transformType(abstractTypeCheckerContext, transformType));
                            }
                        }
                    }
                } else {
                    StringBuilder outline83 = GeneratedOutlineSupport.outline83("Too many supertypes for type: ", simpleTypeMarker, ". Supertypes = ");
                    outline83.append(ArraysKt___ArraysJvmKt.joinToString$default(set, null, null, null, 0, null, null, 63));
                    throw new IllegalStateException(outline83.toString().toString());
                }
            }
            abstractTypeCheckerContext.clear();
            return smartList;
        }
        throw null;
    }

    public final List<SimpleTypeMarker> collectAndFilter(AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker, TypeConstructorMarker typeConstructorMarker) {
        List<SimpleTypeMarker> collectAllSupertypesWithGivenTypeConstructor = collectAllSupertypesWithGivenTypeConstructor(abstractTypeCheckerContext, simpleTypeMarker, typeConstructorMarker);
        if (collectAllSupertypesWithGivenTypeConstructor.size() < 2) {
            return collectAllSupertypesWithGivenTypeConstructor;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = collectAllSupertypesWithGivenTypeConstructor.iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            TypeArgumentListMarker asArgumentList = abstractTypeCheckerContext.asArgumentList((SimpleTypeMarker) next);
            int size = abstractTypeCheckerContext.size(asArgumentList);
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                if (!(abstractTypeCheckerContext.asFlexibleType(abstractTypeCheckerContext.getType(abstractTypeCheckerContext.get(asArgumentList, i))) == null)) {
                    z = false;
                    break;
                }
                i++;
            }
            if (z) {
                arrayList.add(next);
            }
        }
        return arrayList.isEmpty() ^ true ? arrayList : collectAllSupertypesWithGivenTypeConstructor;
    }

    public final boolean equalTypes(AbstractTypeCheckerContext abstractTypeCheckerContext, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2) {
        Intrinsics.checkNotNullParameter(abstractTypeCheckerContext, "context");
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "a");
        Intrinsics.checkNotNullParameter(kotlinTypeMarker2, "b");
        boolean z = true;
        if (kotlinTypeMarker == kotlinTypeMarker2) {
            return true;
        }
        if (isCommonDenotableType(abstractTypeCheckerContext, kotlinTypeMarker) && isCommonDenotableType(abstractTypeCheckerContext, kotlinTypeMarker2)) {
            KotlinTypeMarker refineType = abstractTypeCheckerContext.refineType(kotlinTypeMarker);
            KotlinTypeMarker refineType2 = abstractTypeCheckerContext.refineType(kotlinTypeMarker2);
            SimpleTypeMarker lowerBoundIfFlexible = TweetUtils.lowerBoundIfFlexible(abstractTypeCheckerContext, refineType);
            if (!abstractTypeCheckerContext.areEqualTypeConstructors(TweetUtils.typeConstructor((TypeSystemContext) abstractTypeCheckerContext, refineType), TweetUtils.typeConstructor((TypeSystemContext) abstractTypeCheckerContext, refineType2))) {
                return false;
            }
            if (abstractTypeCheckerContext.argumentsCount(lowerBoundIfFlexible) == 0) {
                if (!abstractTypeCheckerContext.hasFlexibleNullability(refineType) && !abstractTypeCheckerContext.hasFlexibleNullability(refineType2) && abstractTypeCheckerContext.isMarkedNullable(lowerBoundIfFlexible) != abstractTypeCheckerContext.isMarkedNullable(TweetUtils.lowerBoundIfFlexible(abstractTypeCheckerContext, refineType2))) {
                    z = false;
                }
                return z;
            }
        }
        if (!isSubtypeOf$default(this, abstractTypeCheckerContext, kotlinTypeMarker, kotlinTypeMarker2, false, 8) || !isSubtypeOf$default(this, abstractTypeCheckerContext, kotlinTypeMarker2, kotlinTypeMarker, false, 8)) {
            z = false;
        }
        return z;
    }

    public final boolean isCommonDenotableType(AbstractTypeCheckerContext abstractTypeCheckerContext, KotlinTypeMarker kotlinTypeMarker) {
        if (!abstractTypeCheckerContext.isDenotable(TweetUtils.typeConstructor((TypeSystemContext) abstractTypeCheckerContext, kotlinTypeMarker))) {
            return false;
        }
        Intrinsics.checkNotNullParameter(abstractTypeCheckerContext, "this");
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "receiver");
        FlexibleTypeMarker asFlexibleType = abstractTypeCheckerContext.asFlexibleType(kotlinTypeMarker);
        if (((asFlexibleType == null ? null : abstractTypeCheckerContext.asDynamicType(asFlexibleType)) != null) || abstractTypeCheckerContext.isDefinitelyNotNullType(kotlinTypeMarker) || !Intrinsics.areEqual(abstractTypeCheckerContext.typeConstructor(TweetUtils.lowerBoundIfFlexible(abstractTypeCheckerContext, kotlinTypeMarker)), abstractTypeCheckerContext.typeConstructor(TweetUtils.upperBoundIfFlexible(abstractTypeCheckerContext, kotlinTypeMarker)))) {
            return false;
        }
        return true;
    }

    public final boolean isSubtypeForSameConstructor(AbstractTypeCheckerContext abstractTypeCheckerContext, TypeArgumentListMarker typeArgumentListMarker, SimpleTypeMarker simpleTypeMarker) {
        boolean z;
        AbstractTypeCheckerContext abstractTypeCheckerContext2 = abstractTypeCheckerContext;
        TypeArgumentListMarker typeArgumentListMarker2 = typeArgumentListMarker;
        SimpleTypeMarker simpleTypeMarker2 = simpleTypeMarker;
        Intrinsics.checkNotNullParameter(abstractTypeCheckerContext2, "<this>");
        Intrinsics.checkNotNullParameter(typeArgumentListMarker2, "capturedSubArguments");
        Intrinsics.checkNotNullParameter(simpleTypeMarker2, "superType");
        TypeConstructorMarker typeConstructor = abstractTypeCheckerContext2.typeConstructor(simpleTypeMarker2);
        int parametersCount = abstractTypeCheckerContext2.parametersCount(typeConstructor);
        if (parametersCount > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                TypeArgumentMarker argument = abstractTypeCheckerContext2.getArgument(simpleTypeMarker2, i);
                if (!abstractTypeCheckerContext2.isStarProjection(argument)) {
                    KotlinTypeMarker type = abstractTypeCheckerContext2.getType(argument);
                    TypeArgumentMarker typeArgumentMarker = TweetUtils.get(abstractTypeCheckerContext2, typeArgumentListMarker2, i);
                    boolean z2 = abstractTypeCheckerContext2.getVariance(typeArgumentMarker) == TypeVariance.INV;
                    if (!_Assertions.ENABLED || z2) {
                        KotlinTypeMarker type2 = abstractTypeCheckerContext2.getType(typeArgumentMarker);
                        TypeVariance variance = abstractTypeCheckerContext2.getVariance(abstractTypeCheckerContext2.getParameter(typeConstructor, i));
                        TypeVariance variance2 = abstractTypeCheckerContext2.getVariance(argument);
                        Intrinsics.checkNotNullParameter(variance, "declared");
                        Intrinsics.checkNotNullParameter(variance2, "useSite");
                        TypeVariance typeVariance = TypeVariance.INV;
                        if (variance == typeVariance) {
                            variance = variance2;
                        } else if (!(variance2 == typeVariance || variance == variance2)) {
                            variance = null;
                        }
                        if (variance == null) {
                            return ((ClassicTypeCheckerContext) abstractTypeCheckerContext2).errorTypeEqualsToAnything;
                        }
                        int i3 = abstractTypeCheckerContext2.argumentsDepth;
                        if (i3 <= 100) {
                            abstractTypeCheckerContext2.argumentsDepth = i3 + 1;
                            int ordinal = variance.ordinal();
                            if (ordinal == 0) {
                                z = isSubtypeOf$default(this, abstractTypeCheckerContext, type, type2, false, 8);
                            } else if (ordinal == 1) {
                                z = isSubtypeOf$default(this, abstractTypeCheckerContext, type2, type, false, 8);
                            } else if (ordinal == 2) {
                                z = equalTypes(abstractTypeCheckerContext2, type2, type);
                            } else {
                                throw new NoWhenBranchMatchedException();
                            }
                            abstractTypeCheckerContext2.argumentsDepth--;
                            if (!z) {
                                return false;
                            }
                        } else {
                            throw new IllegalStateException(Intrinsics.stringPlus("Arguments depth is too high. Some related argument: ", type2).toString());
                        }
                    } else {
                        throw new AssertionError(Intrinsics.stringPlus("Incorrect sub argument: ", typeArgumentMarker));
                    }
                }
                if (i2 >= parametersCount) {
                    break;
                }
                i = i2;
            }
        }
        return true;
    }
}
