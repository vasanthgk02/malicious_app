package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: PluginGeneratedSerialDescriptor.kt */
public final class PluginGeneratedSerialDescriptor$_hashCode$2 extends Lambda implements Function0<Integer> {
    public final /* synthetic */ PluginGeneratedSerialDescriptor this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public PluginGeneratedSerialDescriptor$_hashCode$2(PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor) {
        // this.this$0 = pluginGeneratedSerialDescriptor;
        super(0);
    }

    public Object invoke() {
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = this.this$0;
        return Integer.valueOf(TypeUtilsKt.hashCodeImpl(pluginGeneratedSerialDescriptor, pluginGeneratedSerialDescriptor.getTypeParameterDescriptors$kotlinx_serialization_core()));
    }
}
