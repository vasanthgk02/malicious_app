package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: JsonElementMarker.kt */
public /* synthetic */ class JsonElementMarker$origin$1 extends FunctionReferenceImpl implements Function2<SerialDescriptor, Integer, Boolean> {
    public JsonElementMarker$origin$1(Object obj) {
        super(2, obj, JsonElementMarker.class, "readIfAbsent", "readIfAbsent(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", 0);
    }

    public Object invoke(Object obj, Object obj2) {
        SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
        int intValue = ((Number) obj2).intValue();
        Intrinsics.checkNotNullParameter(serialDescriptor, "p0");
        JsonElementMarker jsonElementMarker = (JsonElementMarker) this.receiver;
        if (jsonElementMarker != null) {
            boolean z = !serialDescriptor.isElementOptional(intValue) && serialDescriptor.getElementDescriptor(intValue).isNullable();
            jsonElementMarker.isUnmarkedNull = z;
            return Boolean.valueOf(z);
        }
        throw null;
    }
}
