package kotlin.reflect.jvm.internal.impl.types;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: flexibleTypes.kt */
public final class FlexibleTypeImpl extends FlexibleType implements CustomTypeVariable {
    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public FlexibleTypeImpl(SimpleType simpleType, SimpleType simpleType2) {
        // Intrinsics.checkNotNullParameter(simpleType, "lowerBound");
        // Intrinsics.checkNotNullParameter(simpleType2, "upperBound");
        super(simpleType, simpleType2);
    }

    public SimpleType getDelegate() {
        return this.lowerBound;
    }

    public boolean isTypeVariable() {
        return (this.lowerBound.getConstructor().getDeclarationDescriptor() instanceof TypeParameterDescriptor) && Intrinsics.areEqual(this.lowerBound.getConstructor(), this.upperBound.getConstructor());
    }

    public UnwrappedType makeNullableAsSpecified(boolean z) {
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
        return KotlinTypeFactory.flexibleType(this.lowerBound.makeNullableAsSpecified(z), this.upperBound.makeNullableAsSpecified(z));
    }

    public KotlinType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        SimpleType simpleType = this.lowerBound;
        Intrinsics.checkNotNullParameter(simpleType, "type");
        SimpleType simpleType2 = this.upperBound;
        Intrinsics.checkNotNullParameter(simpleType2, "type");
        return new FlexibleTypeImpl(simpleType, simpleType2);
    }

    public String render(DescriptorRenderer descriptorRenderer, DescriptorRendererOptions descriptorRendererOptions) {
        Intrinsics.checkNotNullParameter(descriptorRenderer, "renderer");
        Intrinsics.checkNotNullParameter(descriptorRendererOptions, "options");
        if (!descriptorRendererOptions.getDebugMode()) {
            return descriptorRenderer.renderFlexibleType(descriptorRenderer.renderType(this.lowerBound), descriptorRenderer.renderType(this.upperBound), TypeUtilsKt.getBuiltIns(this));
        }
        StringBuilder outline72 = GeneratedOutlineSupport.outline72('(');
        outline72.append(descriptorRenderer.renderType(this.lowerBound));
        outline72.append("..");
        outline72.append(descriptorRenderer.renderType(this.upperBound));
        outline72.append(')');
        return outline72.toString();
    }

    public UnwrappedType replaceAnnotations(Annotations annotations) {
        Intrinsics.checkNotNullParameter(annotations, "newAnnotations");
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
        return KotlinTypeFactory.flexibleType(this.lowerBound.replaceAnnotations(annotations), this.upperBound.replaceAnnotations(annotations));
    }

    public KotlinType substitutionResult(KotlinType kotlinType) {
        UnwrappedType unwrappedType;
        Intrinsics.checkNotNullParameter(kotlinType, "replacement");
        UnwrappedType unwrap = kotlinType.unwrap();
        if (unwrap instanceof FlexibleType) {
            unwrappedType = unwrap;
        } else if (unwrap instanceof SimpleType) {
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
            SimpleType simpleType = (SimpleType) unwrap;
            unwrappedType = KotlinTypeFactory.flexibleType(simpleType, simpleType.makeNullableAsSpecified(true));
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return TweetUtils.inheritEnhancement(unwrappedType, unwrap);
    }

    /* renamed from: refine  reason: collision with other method in class */
    public UnwrappedType m979refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        SimpleType simpleType = this.lowerBound;
        Intrinsics.checkNotNullParameter(simpleType, "type");
        SimpleType simpleType2 = this.upperBound;
        Intrinsics.checkNotNullParameter(simpleType2, "type");
        return new FlexibleTypeImpl(simpleType, simpleType2);
    }
}
