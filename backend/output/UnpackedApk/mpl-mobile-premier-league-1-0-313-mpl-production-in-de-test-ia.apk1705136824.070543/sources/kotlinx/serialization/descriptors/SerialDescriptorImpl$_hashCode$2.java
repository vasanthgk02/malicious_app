package kotlinx.serialization.descriptors;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: SerialDescriptors.kt */
public final class SerialDescriptorImpl$_hashCode$2 extends Lambda implements Function0<Integer> {
    public final /* synthetic */ SerialDescriptorImpl this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public SerialDescriptorImpl$_hashCode$2(SerialDescriptorImpl serialDescriptorImpl) {
        // this.this$0 = serialDescriptorImpl;
        super(0);
    }

    public Object invoke() {
        SerialDescriptorImpl serialDescriptorImpl = this.this$0;
        return Integer.valueOf(TypeUtilsKt.hashCodeImpl(serialDescriptorImpl, serialDescriptorImpl.typeParametersDescriptors));
    }
}
