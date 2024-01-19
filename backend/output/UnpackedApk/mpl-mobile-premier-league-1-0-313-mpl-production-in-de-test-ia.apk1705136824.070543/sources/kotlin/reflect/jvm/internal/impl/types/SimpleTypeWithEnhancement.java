package kotlin.reflect.jvm.internal.impl.types;

import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: TypeWithEnhancement.kt */
public final class SimpleTypeWithEnhancement extends DelegatingSimpleType implements TypeWithEnhancement {
    public final SimpleType delegate;
    public final KotlinType enhancement;

    public SimpleTypeWithEnhancement(SimpleType simpleType, KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(simpleType, "delegate");
        Intrinsics.checkNotNullParameter(kotlinType, "enhancement");
        this.delegate = simpleType;
        this.enhancement = kotlinType;
    }

    public SimpleType getDelegate() {
        return this.delegate;
    }

    public KotlinType getEnhancement() {
        return this.enhancement;
    }

    public UnwrappedType getOrigin() {
        return this.delegate;
    }

    public DelegatingSimpleType replaceDelegate(SimpleType simpleType) {
        Intrinsics.checkNotNullParameter(simpleType, "delegate");
        return new SimpleTypeWithEnhancement(simpleType, this.enhancement);
    }

    public SimpleType makeNullableAsSpecified(boolean z) {
        return (SimpleType) TweetUtils.wrapEnhancement(this.delegate.makeNullableAsSpecified(z), this.enhancement.unwrap().makeNullableAsSpecified(z));
    }

    public SimpleType replaceAnnotations(Annotations annotations) {
        Intrinsics.checkNotNullParameter(annotations, "newAnnotations");
        return (SimpleType) TweetUtils.wrapEnhancement(this.delegate.replaceAnnotations(annotations), this.enhancement);
    }

    public SimpleTypeWithEnhancement refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        SimpleType simpleType = this.delegate;
        Intrinsics.checkNotNullParameter(simpleType, "type");
        KotlinType kotlinType = this.enhancement;
        Intrinsics.checkNotNullParameter(kotlinType, "type");
        return new SimpleTypeWithEnhancement(simpleType, kotlinType);
    }
}
