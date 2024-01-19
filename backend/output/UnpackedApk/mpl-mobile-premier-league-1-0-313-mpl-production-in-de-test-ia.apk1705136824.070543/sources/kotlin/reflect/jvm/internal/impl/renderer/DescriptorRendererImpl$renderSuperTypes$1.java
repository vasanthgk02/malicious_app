package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: DescriptorRendererImpl.kt */
public final class DescriptorRendererImpl$renderSuperTypes$1 extends Lambda implements Function1<KotlinType, CharSequence> {
    public final /* synthetic */ DescriptorRendererImpl this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DescriptorRendererImpl$renderSuperTypes$1(DescriptorRendererImpl descriptorRendererImpl) {
        // this.this$0 = descriptorRendererImpl;
        super(1);
    }

    public Object invoke(Object obj) {
        KotlinType kotlinType = (KotlinType) obj;
        DescriptorRendererImpl descriptorRendererImpl = this.this$0;
        Intrinsics.checkNotNullExpressionValue(kotlinType, "it");
        return descriptorRendererImpl.renderType(kotlinType);
    }
}
