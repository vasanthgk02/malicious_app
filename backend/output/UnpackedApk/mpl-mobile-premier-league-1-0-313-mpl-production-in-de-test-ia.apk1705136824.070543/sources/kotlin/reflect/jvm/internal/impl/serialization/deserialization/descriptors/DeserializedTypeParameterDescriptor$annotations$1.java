package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;

/* compiled from: DeserializedTypeParameterDescriptor.kt */
public final class DeserializedTypeParameterDescriptor$annotations$1 extends Lambda implements Function0<List<? extends AnnotationDescriptor>> {
    public final /* synthetic */ DeserializedTypeParameterDescriptor this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DeserializedTypeParameterDescriptor$annotations$1(DeserializedTypeParameterDescriptor deserializedTypeParameterDescriptor) {
        // this.this$0 = deserializedTypeParameterDescriptor;
        super(0);
    }

    public Object invoke() {
        DeserializedTypeParameterDescriptor deserializedTypeParameterDescriptor = this.this$0;
        DeserializationContext deserializationContext = deserializedTypeParameterDescriptor.f5952c;
        return ArraysKt___ArraysJvmKt.toList(deserializationContext.components.annotationAndConstantLoader.loadTypeParameterAnnotations(deserializedTypeParameterDescriptor.proto, deserializationContext.nameResolver));
    }
}
