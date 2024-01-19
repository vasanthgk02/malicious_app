package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;

/* compiled from: DescriptorRendererImpl.kt */
public final class DescriptorRendererImpl$renderConstructor$1 extends Lambda implements Function1<ValueParameterDescriptor, CharSequence> {
    public static final DescriptorRendererImpl$renderConstructor$1 INSTANCE = new DescriptorRendererImpl$renderConstructor$1();

    public DescriptorRendererImpl$renderConstructor$1() {
        super(1);
    }

    public Object invoke(Object obj) {
        ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) obj;
        return "";
    }
}
