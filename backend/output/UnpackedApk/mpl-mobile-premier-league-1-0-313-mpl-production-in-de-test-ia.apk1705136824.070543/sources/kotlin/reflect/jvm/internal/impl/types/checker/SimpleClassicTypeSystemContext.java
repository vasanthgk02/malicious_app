package kotlin.reflect.jvm.internal.impl.types.checker;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
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
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;

/* compiled from: NewKotlinTypeChecker.kt */
public final class SimpleClassicTypeSystemContext implements ClassicTypeSystemContext {
    public static final SimpleClassicTypeSystemContext INSTANCE = new SimpleClassicTypeSystemContext();

    public boolean areEqualTypeConstructors(TypeConstructorMarker typeConstructorMarker, TypeConstructorMarker typeConstructorMarker2) {
        Intrinsics.checkNotNullParameter(this, "this");
        Intrinsics.checkNotNullParameter(typeConstructorMarker, "c1");
        Intrinsics.checkNotNullParameter(typeConstructorMarker2, "c2");
        if (!(typeConstructorMarker instanceof TypeConstructor)) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline68(typeConstructorMarker, GeneratedOutlineSupport.outline84("ClassicTypeSystemContext couldn't handle: ", typeConstructorMarker, ", ")).toString());
        } else if (typeConstructorMarker2 instanceof TypeConstructor) {
            return Intrinsics.areEqual(typeConstructorMarker, typeConstructorMarker2);
        } else {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline68(typeConstructorMarker2, GeneratedOutlineSupport.outline84("ClassicTypeSystemContext couldn't handle: ", typeConstructorMarker2, ", ")).toString());
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

    public TypeArgumentMarker get(TypeArgumentListMarker typeArgumentListMarker, int i) {
        return TweetUtils.get(this, typeArgumentListMarker, i);
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

    public SimpleTypeMarker lowerBoundIfFlexible(KotlinTypeMarker kotlinTypeMarker) {
        return TweetUtils.lowerBoundIfFlexible(this, kotlinTypeMarker);
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

    public int size(TypeArgumentListMarker typeArgumentListMarker) {
        return TweetUtils.size(this, typeArgumentListMarker);
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

    public SimpleTypeMarker upperBoundIfFlexible(KotlinTypeMarker kotlinTypeMarker) {
        return TweetUtils.upperBoundIfFlexible(this, kotlinTypeMarker);
    }

    public KotlinTypeMarker withNullability(KotlinTypeMarker kotlinTypeMarker, boolean z) {
        return TweetUtils.withNullability((ClassicTypeSystemContext) this, kotlinTypeMarker, z);
    }

    public TypeVariance getVariance(TypeParameterMarker typeParameterMarker) {
        return TweetUtils.getVariance((ClassicTypeSystemContext) this, typeParameterMarker);
    }

    public boolean isMarkedNullable(KotlinTypeMarker kotlinTypeMarker) {
        return TweetUtils.isMarkedNullable((TypeSystemContext) this, kotlinTypeMarker);
    }

    public TypeConstructorMarker typeConstructor(KotlinTypeMarker kotlinTypeMarker) {
        return TweetUtils.typeConstructor((TypeSystemContext) this, kotlinTypeMarker);
    }

    public SimpleTypeMarker withNullability(SimpleTypeMarker simpleTypeMarker, boolean z) {
        return TweetUtils.withNullability((ClassicTypeSystemContext) this, simpleTypeMarker, z);
    }
}
