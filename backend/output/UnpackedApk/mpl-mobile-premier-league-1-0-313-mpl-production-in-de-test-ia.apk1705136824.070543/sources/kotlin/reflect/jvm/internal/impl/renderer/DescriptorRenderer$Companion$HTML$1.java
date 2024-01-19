package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: DescriptorRenderer.kt */
public final class DescriptorRenderer$Companion$HTML$1 extends Lambda implements Function1<DescriptorRendererOptions, Unit> {
    public static final DescriptorRenderer$Companion$HTML$1 INSTANCE = new DescriptorRenderer$Companion$HTML$1();

    public DescriptorRenderer$Companion$HTML$1() {
        super(1);
    }

    public Object invoke(Object obj) {
        DescriptorRendererOptions descriptorRendererOptions = (DescriptorRendererOptions) obj;
        Intrinsics.checkNotNullParameter(descriptorRendererOptions, "<this>");
        descriptorRendererOptions.setTextFormat(RenderingFormat.HTML);
        descriptorRendererOptions.setModifiers(DescriptorRendererModifier.ALL);
        return Unit.INSTANCE;
    }
}