package kotlin.reflect.jvm.internal.impl.types;

import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin._Assertions;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext.SupertypesPolicy.LowerIfFlexible;
import kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeCheckerContext;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType;
import kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker;

/* compiled from: SpecialTypes.kt */
public final class DefinitelyNotNullType extends DelegatingSimpleType implements CustomTypeVariable, DefinitelyNotNullTypeMarker {
    public final SimpleType original;
    public final boolean useCorrectedNullabilityForTypeParameters;

    public DefinitelyNotNullType(SimpleType simpleType, boolean z) {
        this.original = simpleType;
        this.useCorrectedNullabilityForTypeParameters = z;
    }

    public static final DefinitelyNotNullType makeDefinitelyNotNull$descriptors(UnwrappedType unwrappedType, boolean z) {
        Intrinsics.checkNotNullParameter(unwrappedType, "type");
        if (unwrappedType instanceof DefinitelyNotNullType) {
            return (DefinitelyNotNullType) unwrappedType;
        }
        unwrappedType.getConstructor();
        boolean z2 = false;
        if ((unwrappedType.getConstructor().getDeclarationDescriptor() instanceof TypeParameterDescriptor) || (unwrappedType instanceof NewCapturedType)) {
            if (!z || !(unwrappedType.getConstructor().getDeclarationDescriptor() instanceof TypeParameterDescriptor)) {
                Intrinsics.checkNotNullParameter(unwrappedType, "type");
                ClassicTypeCheckerContext classicTypeCheckerContext = new ClassicTypeCheckerContext(false, true, false, null, 12);
                z2 = !AbstractNullabilityChecker.hasNotNullSupertype(classicTypeCheckerContext, TweetUtils.lowerIfFlexible(unwrappedType), LowerIfFlexible.INSTANCE);
            } else {
                z2 = TypeUtils.isNullableType(unwrappedType);
            }
        }
        if (!z2) {
            return null;
        }
        if (unwrappedType instanceof FlexibleType) {
            FlexibleType flexibleType = (FlexibleType) unwrappedType;
            boolean areEqual = Intrinsics.areEqual(flexibleType.lowerBound.getConstructor(), flexibleType.upperBound.getConstructor());
            if (_Assertions.ENABLED && !areEqual) {
                throw new AssertionError("DefinitelyNotNullType for flexible type (" + unwrappedType + ") can be created only from type variable with the same constructor for bounds");
            }
        }
        return new DefinitelyNotNullType(TweetUtils.lowerIfFlexible(unwrappedType), z, null);
    }

    public SimpleType getDelegate() {
        return this.original;
    }

    public boolean isMarkedNullable() {
        return false;
    }

    public boolean isTypeVariable() {
        this.original.getConstructor();
        return this.original.getConstructor().getDeclarationDescriptor() instanceof TypeParameterDescriptor;
    }

    /* renamed from: replaceAnnotations  reason: collision with other method in class */
    public SimpleType m974replaceAnnotations(Annotations annotations) {
        Intrinsics.checkNotNullParameter(annotations, "newAnnotations");
        return new DefinitelyNotNullType(this.original.replaceAnnotations(annotations), this.useCorrectedNullabilityForTypeParameters);
    }

    public DelegatingSimpleType replaceDelegate(SimpleType simpleType) {
        Intrinsics.checkNotNullParameter(simpleType, "delegate");
        return new DefinitelyNotNullType(simpleType, this.useCorrectedNullabilityForTypeParameters);
    }

    public KotlinType substitutionResult(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "replacement");
        return SpecialTypesKt.makeDefinitelyNotNullOrNotNull(kotlinType.unwrap(), this.useCorrectedNullabilityForTypeParameters);
    }

    public String toString() {
        return this.original + "!!";
    }

    public SimpleType makeNullableAsSpecified(boolean z) {
        return z ? this.original.makeNullableAsSpecified(z) : this;
    }

    public DefinitelyNotNullType(SimpleType simpleType, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this.original = simpleType;
        this.useCorrectedNullabilityForTypeParameters = z;
    }

    public DefinitelyNotNullType replaceAnnotations(Annotations annotations) {
        Intrinsics.checkNotNullParameter(annotations, "newAnnotations");
        return new DefinitelyNotNullType(this.original.replaceAnnotations(annotations), this.useCorrectedNullabilityForTypeParameters);
    }
}
