package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* compiled from: DescriptorRendererImpl.kt */
public final class DescriptorRendererImpl$appendTypeProjections$1 extends Lambda implements Function1<TypeProjection, CharSequence> {
    public final /* synthetic */ DescriptorRendererImpl this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DescriptorRendererImpl$appendTypeProjections$1(DescriptorRendererImpl descriptorRendererImpl) {
        // this.this$0 = descriptorRendererImpl;
        super(1);
    }

    public Object invoke(Object obj) {
        TypeProjection typeProjection = (TypeProjection) obj;
        Intrinsics.checkNotNullParameter(typeProjection, "it");
        if (typeProjection.isStarProjection()) {
            return "*";
        }
        DescriptorRendererImpl descriptorRendererImpl = this.this$0;
        KotlinType type = typeProjection.getType();
        Intrinsics.checkNotNullExpressionValue(type, "it.type");
        String renderType = descriptorRendererImpl.renderType(type);
        if (typeProjection.getProjectionKind() == Variance.INVARIANT) {
            return renderType;
        }
        return typeProjection.getProjectionKind() + ' ' + renderType;
    }
}
