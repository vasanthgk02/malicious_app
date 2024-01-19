package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.Collection;
import java.util.List;
import kotlin._Assertions;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor;

/* compiled from: CapturedTypeConstructor.kt */
public final class CapturedTypeConstructorImpl implements CapturedTypeConstructor {
    public NewCapturedTypeConstructor newTypeConstructor;
    public final TypeProjection projection;

    public CapturedTypeConstructorImpl(TypeProjection typeProjection) {
        Intrinsics.checkNotNullParameter(typeProjection, "projection");
        this.projection = typeProjection;
        boolean z = typeProjection.getProjectionKind() != Variance.INVARIANT;
        if (_Assertions.ENABLED && !z) {
            throw new AssertionError(Intrinsics.stringPlus("Only nontrivial projections can be captured, not: ", this.projection));
        }
    }

    public KotlinBuiltIns getBuiltIns() {
        KotlinBuiltIns builtIns = this.projection.getType().getConstructor().getBuiltIns();
        Intrinsics.checkNotNullExpressionValue(builtIns, "projection.type.constructor.builtIns");
        return builtIns;
    }

    public ClassifierDescriptor getDeclarationDescriptor() {
        return null;
    }

    public List<TypeParameterDescriptor> getParameters() {
        return EmptyList.INSTANCE;
    }

    public TypeProjection getProjection() {
        return this.projection;
    }

    public Collection<KotlinType> getSupertypes() {
        Object obj;
        if (this.projection.getProjectionKind() == Variance.OUT_VARIANCE) {
            obj = this.projection.getType();
        } else {
            obj = getBuiltIns().getNullableAnyType();
        }
        Intrinsics.checkNotNullExpressionValue(obj, "if (projection.projectionKind == Variance.OUT_VARIANCE)\n            projection.type\n        else\n            builtIns.nullableAnyType");
        return TweetUtils.listOf(obj);
    }

    public boolean isDenotable() {
        return false;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("CapturedTypeConstructor(");
        outline73.append(this.projection);
        outline73.append(')');
        return outline73.toString();
    }
}
