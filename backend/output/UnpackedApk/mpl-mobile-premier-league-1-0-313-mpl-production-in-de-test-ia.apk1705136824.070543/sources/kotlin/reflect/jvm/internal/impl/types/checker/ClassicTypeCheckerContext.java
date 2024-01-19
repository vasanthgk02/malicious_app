package kotlin.reflect.jvm.internal.impl.types.checker;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner.Default;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker.Companion;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DynamicTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;

/* compiled from: ClassicTypeCheckerContext.kt */
public class ClassicTypeCheckerContext extends AbstractTypeCheckerContext implements ClassicTypeSystemContext {
    public final boolean allowedTypeVariable;
    public final boolean errorTypeEqualsToAnything;
    public final KotlinTypeRefiner kotlinTypeRefiner;
    public final boolean stubTypeEqualsToAnything;

    public ClassicTypeCheckerContext(boolean z, boolean z2, boolean z3, KotlinTypeRefiner kotlinTypeRefiner2, int i) {
        z2 = (i & 2) != 0 ? true : z2;
        z3 = (i & 4) != 0 ? true : z3;
        kotlinTypeRefiner2 = (i & 8) != 0 ? Default.INSTANCE : kotlinTypeRefiner2;
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner2, "kotlinTypeRefiner");
        this.errorTypeEqualsToAnything = z;
        this.stubTypeEqualsToAnything = z2;
        this.allowedTypeVariable = z3;
        this.kotlinTypeRefiner = kotlinTypeRefiner2;
    }

    public boolean areEqualTypeConstructors(TypeConstructorMarker typeConstructorMarker, TypeConstructorMarker typeConstructorMarker2) {
        Intrinsics.checkNotNullParameter(typeConstructorMarker, "c1");
        Intrinsics.checkNotNullParameter(typeConstructorMarker2, "c2");
        if (!(typeConstructorMarker instanceof TypeConstructor)) {
            throw new IllegalArgumentException(TweetUtils.access$errorMessage(typeConstructorMarker).toString());
        } else if (typeConstructorMarker2 instanceof TypeConstructor) {
            return areEqualTypeConstructors((TypeConstructor) typeConstructorMarker, (TypeConstructor) typeConstructorMarker2);
        } else {
            throw new IllegalArgumentException(TweetUtils.access$errorMessage(typeConstructorMarker2).toString());
        }
    }

    public int argumentsCount(KotlinTypeMarker kotlinTypeMarker) {
        return TweetUtils.argumentsCount(this, kotlinTypeMarker);
    }

    public TypeArgumentListMarker asArgumentList(SimpleTypeMarker simpleTypeMarker) {
        return TweetUtils.asArgumentList(this, simpleTypeMarker);
    }

    public CapturedTypeMarker asCapturedType(SimpleTypeMarker simpleTypeMarker) {
        return TweetUtils.asCapturedType(this, simpleTypeMarker);
    }

    public DefinitelyNotNullTypeMarker asDefinitelyNotNullType(SimpleTypeMarker simpleTypeMarker) {
        return TweetUtils.asDefinitelyNotNullType(this, simpleTypeMarker);
    }

    public DynamicTypeMarker asDynamicType(FlexibleTypeMarker flexibleTypeMarker) {
        return TweetUtils.asDynamicType(this, flexibleTypeMarker);
    }

    public FlexibleTypeMarker asFlexibleType(KotlinTypeMarker kotlinTypeMarker) {
        return TweetUtils.asFlexibleType(this, kotlinTypeMarker);
    }

    public SimpleTypeMarker asSimpleType(KotlinTypeMarker kotlinTypeMarker) {
        return TweetUtils.asSimpleType(this, kotlinTypeMarker);
    }

    public TypeArgumentMarker asTypeArgument(KotlinTypeMarker kotlinTypeMarker) {
        return TweetUtils.asTypeArgument(this, kotlinTypeMarker);
    }

    public SimpleTypeMarker captureFromArguments(SimpleTypeMarker simpleTypeMarker, CaptureStatus captureStatus) {
        return TweetUtils.captureFromArguments(this, simpleTypeMarker, captureStatus);
    }

    public KotlinTypeMarker createFlexibleType(SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
        return TweetUtils.createFlexibleType(this, simpleTypeMarker, simpleTypeMarker2);
    }

    public TypeArgumentMarker getArgument(KotlinTypeMarker kotlinTypeMarker, int i) {
        return TweetUtils.getArgument(this, kotlinTypeMarker, i);
    }

    public TypeParameterMarker getParameter(TypeConstructorMarker typeConstructorMarker, int i) {
        return TweetUtils.getParameter(this, typeConstructorMarker, i);
    }

    public KotlinTypeMarker getRepresentativeUpperBound(TypeParameterMarker typeParameterMarker) {
        return TweetUtils.getRepresentativeUpperBound(this, typeParameterMarker);
    }

    public KotlinTypeMarker getSubstitutedUnderlyingType(KotlinTypeMarker kotlinTypeMarker) {
        return TweetUtils.getSubstitutedUnderlyingType(this, kotlinTypeMarker);
    }

    public KotlinTypeMarker getType(TypeArgumentMarker typeArgumentMarker) {
        return TweetUtils.getType(this, typeArgumentMarker);
    }

    public TypeParameterMarker getTypeParameterClassifier(TypeConstructorMarker typeConstructorMarker) {
        return TweetUtils.getTypeParameterClassifier(this, typeConstructorMarker);
    }

    public TypeVariance getVariance(TypeArgumentMarker typeArgumentMarker) {
        return TweetUtils.getVariance((ClassicTypeSystemContext) this, typeArgumentMarker);
    }

    public boolean identicalArguments(SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
        return TweetUtils.identicalArguments(this, simpleTypeMarker, simpleTypeMarker2);
    }

    public KotlinTypeMarker intersectTypes(List<? extends KotlinTypeMarker> list) {
        return TweetUtils.intersectTypes(this, list);
    }

    public boolean isAnyConstructor(TypeConstructorMarker typeConstructorMarker) {
        return TweetUtils.isAnyConstructor(this, typeConstructorMarker);
    }

    public boolean isClassTypeConstructor(TypeConstructorMarker typeConstructorMarker) {
        return TweetUtils.isClassTypeConstructor(this, typeConstructorMarker);
    }

    public boolean isCommonFinalClassConstructor(TypeConstructorMarker typeConstructorMarker) {
        return TweetUtils.isCommonFinalClassConstructor(this, typeConstructorMarker);
    }

    public boolean isDenotable(TypeConstructorMarker typeConstructorMarker) {
        return TweetUtils.isDenotable(this, typeConstructorMarker);
    }

    public boolean isError(KotlinTypeMarker kotlinTypeMarker) {
        return TweetUtils.isError(this, kotlinTypeMarker);
    }

    public boolean isInlineClass(TypeConstructorMarker typeConstructorMarker) {
        return TweetUtils.isInlineClass(this, typeConstructorMarker);
    }

    public boolean isIntegerLiteralTypeConstructor(TypeConstructorMarker typeConstructorMarker) {
        return TweetUtils.isIntegerLiteralTypeConstructor(this, typeConstructorMarker);
    }

    public boolean isIntersection(TypeConstructorMarker typeConstructorMarker) {
        return TweetUtils.isIntersection(this, typeConstructorMarker);
    }

    public boolean isMarkedNullable(SimpleTypeMarker simpleTypeMarker) {
        return TweetUtils.isMarkedNullable((ClassicTypeSystemContext) this, simpleTypeMarker);
    }

    public boolean isNothingConstructor(TypeConstructorMarker typeConstructorMarker) {
        return TweetUtils.isNothingConstructor(this, typeConstructorMarker);
    }

    public boolean isNullableType(KotlinTypeMarker kotlinTypeMarker) {
        return TweetUtils.isNullableType(this, kotlinTypeMarker);
    }

    public boolean isPrimitiveType(SimpleTypeMarker simpleTypeMarker) {
        return TweetUtils.isPrimitiveType(this, simpleTypeMarker);
    }

    public boolean isProjectionNotNull(CapturedTypeMarker capturedTypeMarker) {
        return TweetUtils.isProjectionNotNull(this, capturedTypeMarker);
    }

    public boolean isStarProjection(TypeArgumentMarker typeArgumentMarker) {
        return TweetUtils.isStarProjection(this, typeArgumentMarker);
    }

    public boolean isStubType(SimpleTypeMarker simpleTypeMarker) {
        TweetUtils.isStubType(this, simpleTypeMarker);
        return false;
    }

    public SimpleTypeMarker lowerBound(FlexibleTypeMarker flexibleTypeMarker) {
        return TweetUtils.lowerBound(this, flexibleTypeMarker);
    }

    public KotlinTypeMarker lowerType(CapturedTypeMarker capturedTypeMarker) {
        return TweetUtils.lowerType(this, capturedTypeMarker);
    }

    public KotlinTypeMarker makeDefinitelyNotNullOrNotNull(KotlinTypeMarker kotlinTypeMarker) {
        return TweetUtils.makeDefinitelyNotNullOrNotNull(this, kotlinTypeMarker);
    }

    public KotlinTypeMarker makeNullable(KotlinTypeMarker kotlinTypeMarker) {
        return TweetUtils.makeNullable(this, kotlinTypeMarker);
    }

    public SimpleTypeMarker original(DefinitelyNotNullTypeMarker definitelyNotNullTypeMarker) {
        return TweetUtils.original(this, definitelyNotNullTypeMarker);
    }

    public int parametersCount(TypeConstructorMarker typeConstructorMarker) {
        return TweetUtils.parametersCount(this, typeConstructorMarker);
    }

    public Collection<KotlinTypeMarker> possibleIntegerTypes(SimpleTypeMarker simpleTypeMarker) {
        return TweetUtils.possibleIntegerTypes(this, simpleTypeMarker);
    }

    public KotlinTypeMarker prepareType(KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "type");
        if (NewKotlinTypeChecker.Companion != null) {
            return Companion.Default.transformToNewType(((KotlinType) kotlinTypeMarker).unwrap());
        }
        throw null;
    }

    public KotlinTypeMarker refineType(KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "type");
        if (kotlinTypeMarker instanceof KotlinType) {
            KotlinType kotlinType = (KotlinType) kotlinTypeMarker;
            if (((Default) this.kotlinTypeRefiner) != null) {
                Intrinsics.checkNotNullParameter(kotlinType, "type");
                return kotlinType;
            }
            throw null;
        }
        throw new IllegalArgumentException(TweetUtils.access$errorMessage(kotlinTypeMarker).toString());
    }

    public Collection<KotlinTypeMarker> supertypes(TypeConstructorMarker typeConstructorMarker) {
        return TweetUtils.supertypes(this, typeConstructorMarker);
    }

    public TypeConstructorMarker typeConstructor(SimpleTypeMarker simpleTypeMarker) {
        return TweetUtils.typeConstructor((ClassicTypeSystemContext) this, simpleTypeMarker);
    }

    public SimpleTypeMarker upperBound(FlexibleTypeMarker flexibleTypeMarker) {
        return TweetUtils.upperBound(this, flexibleTypeMarker);
    }

    public KotlinTypeMarker withNullability(KotlinTypeMarker kotlinTypeMarker, boolean z) {
        return TweetUtils.withNullability((ClassicTypeSystemContext) this, kotlinTypeMarker, z);
    }

    public TypeVariance getVariance(TypeParameterMarker typeParameterMarker) {
        return TweetUtils.getVariance((ClassicTypeSystemContext) this, typeParameterMarker);
    }

    public SimpleTypeMarker withNullability(SimpleTypeMarker simpleTypeMarker, boolean z) {
        return TweetUtils.withNullability((ClassicTypeSystemContext) this, simpleTypeMarker, z);
    }

    public boolean areEqualTypeConstructors(TypeConstructor typeConstructor, TypeConstructor typeConstructor2) {
        Intrinsics.checkNotNullParameter(typeConstructor, "a");
        Intrinsics.checkNotNullParameter(typeConstructor2, "b");
        if (typeConstructor instanceof IntegerLiteralTypeConstructor) {
            return ((IntegerLiteralTypeConstructor) typeConstructor).checkConstructor(typeConstructor2);
        }
        if (typeConstructor2 instanceof IntegerLiteralTypeConstructor) {
            return ((IntegerLiteralTypeConstructor) typeConstructor2).checkConstructor(typeConstructor);
        }
        return Intrinsics.areEqual(typeConstructor, typeConstructor2);
    }

    public ClassicTypeCheckerContext(boolean z, boolean z2, boolean z3, KotlinTypeRefiner kotlinTypeRefiner2) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner2, "kotlinTypeRefiner");
        this.errorTypeEqualsToAnything = z;
        this.stubTypeEqualsToAnything = z2;
        this.allowedTypeVariable = z3;
        this.kotlinTypeRefiner = kotlinTypeRefiner2;
    }
}
