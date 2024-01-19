package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.DelegatedTypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;

/* compiled from: CapturedTypeConstructor.kt */
public final class CapturedTypeConstructorKt$wrapWithCapturingSubstitution$2 extends DelegatedTypeSubstitution {
    public final /* synthetic */ boolean $needApproximation;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public CapturedTypeConstructorKt$wrapWithCapturingSubstitution$2(boolean z, TypeSubstitution typeSubstitution) {
        // this.$needApproximation = z;
        super(typeSubstitution);
    }

    public boolean approximateContravariantCapturedTypes() {
        return this.$needApproximation;
    }

    public TypeProjection get(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "key");
        TypeProjection typeProjection = super.get(kotlinType);
        TypeParameterDescriptor typeParameterDescriptor = null;
        if (typeProjection == null) {
            return null;
        }
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor instanceof TypeParameterDescriptor) {
            typeParameterDescriptor = (TypeParameterDescriptor) declarationDescriptor;
        }
        return TweetUtils.createCapturedIfNeeded(typeProjection, typeParameterDescriptor);
    }
}
