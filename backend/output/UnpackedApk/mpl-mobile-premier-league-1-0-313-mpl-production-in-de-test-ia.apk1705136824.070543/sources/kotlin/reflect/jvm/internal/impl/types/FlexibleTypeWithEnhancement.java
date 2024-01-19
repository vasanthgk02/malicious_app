package kotlin.reflect.jvm.internal.impl.types;

import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: TypeWithEnhancement.kt */
public final class FlexibleTypeWithEnhancement extends FlexibleType implements TypeWithEnhancement {
    public final KotlinType enhancement;
    public final FlexibleType origin;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public FlexibleTypeWithEnhancement(FlexibleType flexibleType, KotlinType kotlinType) {
        // Intrinsics.checkNotNullParameter(flexibleType, "origin");
        // Intrinsics.checkNotNullParameter(kotlinType, "enhancement");
        super(flexibleType.lowerBound, flexibleType.upperBound);
        this.origin = flexibleType;
        this.enhancement = kotlinType;
    }

    public SimpleType getDelegate() {
        return this.origin.getDelegate();
    }

    public KotlinType getEnhancement() {
        return this.enhancement;
    }

    public UnwrappedType getOrigin() {
        return this.origin;
    }

    public UnwrappedType makeNullableAsSpecified(boolean z) {
        return TweetUtils.wrapEnhancement(this.origin.makeNullableAsSpecified(z), this.enhancement.unwrap().makeNullableAsSpecified(z));
    }

    public KotlinType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        FlexibleType flexibleType = this.origin;
        Intrinsics.checkNotNullParameter(flexibleType, "type");
        KotlinType kotlinType = this.enhancement;
        Intrinsics.checkNotNullParameter(kotlinType, "type");
        return new FlexibleTypeWithEnhancement(flexibleType, kotlinType);
    }

    public String render(DescriptorRenderer descriptorRenderer, DescriptorRendererOptions descriptorRendererOptions) {
        Intrinsics.checkNotNullParameter(descriptorRenderer, "renderer");
        Intrinsics.checkNotNullParameter(descriptorRendererOptions, "options");
        if (descriptorRendererOptions.getEnhancedTypes()) {
            return descriptorRenderer.renderType(this.enhancement);
        }
        return this.origin.render(descriptorRenderer, descriptorRendererOptions);
    }

    public UnwrappedType replaceAnnotations(Annotations annotations) {
        Intrinsics.checkNotNullParameter(annotations, "newAnnotations");
        return TweetUtils.wrapEnhancement(this.origin.replaceAnnotations(annotations), this.enhancement);
    }

    /* renamed from: refine  reason: collision with other method in class */
    public UnwrappedType m980refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        FlexibleType flexibleType = this.origin;
        Intrinsics.checkNotNullParameter(flexibleType, "type");
        KotlinType kotlinType = this.enhancement;
        Intrinsics.checkNotNullParameter(kotlinType, "type");
        return new FlexibleTypeWithEnhancement(flexibleType, kotlinType);
    }
}
