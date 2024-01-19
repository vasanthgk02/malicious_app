package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: DescriptorRendererOptionsImpl.kt */
public final class DescriptorRendererOptionsImpl$typeNormalizer$2 extends Lambda implements Function1<KotlinType, KotlinType> {
    public static final DescriptorRendererOptionsImpl$typeNormalizer$2 INSTANCE = new DescriptorRendererOptionsImpl$typeNormalizer$2();

    public DescriptorRendererOptionsImpl$typeNormalizer$2() {
        super(1);
    }

    public Object invoke(Object obj) {
        KotlinType kotlinType = (KotlinType) obj;
        Intrinsics.checkNotNullParameter(kotlinType, "it");
        return kotlinType;
    }
}
