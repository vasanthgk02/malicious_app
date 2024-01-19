package kotlinx.serialization.internal;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/serialization/descriptors/SerialDescriptor;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: PluginGeneratedSerialDescriptor.kt */
public final class PluginGeneratedSerialDescriptor$typeParameterDescriptors$2 extends Lambda implements Function0<SerialDescriptor[]> {
    public final /* synthetic */ PluginGeneratedSerialDescriptor this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public PluginGeneratedSerialDescriptor$typeParameterDescriptors$2(PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor) {
        // this.this$0 = pluginGeneratedSerialDescriptor;
        super(0);
    }

    public Object invoke() {
        GeneratedSerializer<?> generatedSerializer = this.this$0.generatedSerializer;
        ArrayList arrayList = null;
        if (generatedSerializer != null) {
            KSerializer[] typeParametersSerializers = generatedSerializer.typeParametersSerializers();
            if (typeParametersSerializers != null) {
                arrayList = new ArrayList(typeParametersSerializers.length);
                for (KSerializer descriptor : typeParametersSerializers) {
                    arrayList.add(descriptor.getDescriptor());
                }
            }
        }
        return Platform_commonKt.compactArray(arrayList);
    }
}
