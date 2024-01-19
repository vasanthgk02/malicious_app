package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.CustomTypeVariable;
import kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: typeEnhancement.kt */
public final class NotNullTypeParameter extends DelegatingSimpleType implements CustomTypeVariable {
    public final SimpleType delegate;

    public NotNullTypeParameter(SimpleType simpleType) {
        Intrinsics.checkNotNullParameter(simpleType, "delegate");
        this.delegate = simpleType;
    }

    public SimpleType getDelegate() {
        return this.delegate;
    }

    public boolean isMarkedNullable() {
        return false;
    }

    public boolean isTypeVariable() {
        return true;
    }

    public SimpleType makeNullableAsSpecified(boolean z) {
        return z ? this.delegate.makeNullableAsSpecified(true) : this;
    }

    public final SimpleType prepareReplacement(SimpleType simpleType) {
        SimpleType makeNullableAsSpecified = simpleType.makeNullableAsSpecified(false);
        if (!TypeUtilsKt.isTypeParameter(simpleType)) {
            return makeNullableAsSpecified;
        }
        return new NotNullTypeParameter(makeNullableAsSpecified);
    }

    /* renamed from: replaceAnnotations  reason: collision with other method in class */
    public SimpleType m906replaceAnnotations(Annotations annotations) {
        Intrinsics.checkNotNullParameter(annotations, "newAnnotations");
        return new NotNullTypeParameter(this.delegate.replaceAnnotations(annotations));
    }

    public DelegatingSimpleType replaceDelegate(SimpleType simpleType) {
        Intrinsics.checkNotNullParameter(simpleType, "delegate");
        return new NotNullTypeParameter(simpleType);
    }

    public KotlinType substitutionResult(KotlinType kotlinType) {
        KotlinType kotlinType2;
        Intrinsics.checkNotNullParameter(kotlinType, "replacement");
        UnwrappedType unwrap = kotlinType.unwrap();
        if (!TypeUtilsKt.isTypeParameter(unwrap) && !TypeUtils.isNullableType(unwrap)) {
            return unwrap;
        }
        if (unwrap instanceof SimpleType) {
            kotlinType2 = prepareReplacement((SimpleType) unwrap);
        } else if (unwrap instanceof FlexibleType) {
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
            FlexibleType flexibleType = (FlexibleType) unwrap;
            kotlinType2 = TweetUtils.wrapEnhancement(KotlinTypeFactory.flexibleType(prepareReplacement(flexibleType.lowerBound), prepareReplacement(flexibleType.upperBound)), TweetUtils.getEnhancement(unwrap));
        } else {
            throw new IllegalStateException(Intrinsics.stringPlus("Incorrect type: ", unwrap).toString());
        }
        return kotlinType2;
    }

    public NotNullTypeParameter replaceAnnotations(Annotations annotations) {
        Intrinsics.checkNotNullParameter(annotations, "newAnnotations");
        return new NotNullTypeParameter(this.delegate.replaceAnnotations(annotations));
    }
}
