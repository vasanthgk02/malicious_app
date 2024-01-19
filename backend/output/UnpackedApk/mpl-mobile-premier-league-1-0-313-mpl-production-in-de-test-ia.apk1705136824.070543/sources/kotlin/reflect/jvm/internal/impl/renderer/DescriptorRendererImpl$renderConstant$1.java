package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;

/* compiled from: DescriptorRendererImpl.kt */
public final class DescriptorRendererImpl$renderConstant$1 extends Lambda implements Function1<ConstantValue<?>, CharSequence> {
    public final /* synthetic */ DescriptorRendererImpl this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DescriptorRendererImpl$renderConstant$1(DescriptorRendererImpl descriptorRendererImpl) {
        // this.this$0 = descriptorRendererImpl;
        super(1);
    }

    public Object invoke(Object obj) {
        ConstantValue constantValue = (ConstantValue) obj;
        Intrinsics.checkNotNullParameter(constantValue, "it");
        return this.this$0.renderConstant(constantValue);
    }
}
