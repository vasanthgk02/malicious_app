package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.Unit;
import kotlin.collections.EmptySet;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: DescriptorRenderer.kt */
public final class DescriptorRenderer$Companion$COMPACT_WITHOUT_SUPERTYPES$1 extends Lambda implements Function1<DescriptorRendererOptions, Unit> {
    public static final DescriptorRenderer$Companion$COMPACT_WITHOUT_SUPERTYPES$1 INSTANCE = new DescriptorRenderer$Companion$COMPACT_WITHOUT_SUPERTYPES$1();

    public DescriptorRenderer$Companion$COMPACT_WITHOUT_SUPERTYPES$1() {
        super(1);
    }

    public Object invoke(Object obj) {
        DescriptorRendererOptions descriptorRendererOptions = (DescriptorRendererOptions) obj;
        Intrinsics.checkNotNullParameter(descriptorRendererOptions, "<this>");
        descriptorRendererOptions.setWithDefinedIn(false);
        descriptorRendererOptions.setModifiers(EmptySet.INSTANCE);
        descriptorRendererOptions.setWithoutSuperTypes(true);
        return Unit.INSTANCE;
    }
}
