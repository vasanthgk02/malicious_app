package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.KSerializer;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\u0010\u0000\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/serialization/KSerializer;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: PluginGeneratedSerialDescriptor.kt */
public final class PluginGeneratedSerialDescriptor$childSerializers$2 extends Lambda implements Function0<KSerializer<?>[]> {
    public final /* synthetic */ PluginGeneratedSerialDescriptor this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public PluginGeneratedSerialDescriptor$childSerializers$2(PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor) {
        // this.this$0 = pluginGeneratedSerialDescriptor;
        super(0);
    }

    public Object invoke() {
        KSerializer[] kSerializerArr;
        GeneratedSerializer<?> generatedSerializer = this.this$0.generatedSerializer;
        if (generatedSerializer == null) {
            kSerializerArr = null;
        } else {
            kSerializerArr = generatedSerializer.childSerializers();
        }
        return kSerializerArr == null ? PluginHelperInterfacesKt.EMPTY_SERIALIZER_ARRAY : kSerializerArr;
    }
}
