package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;

/* compiled from: TypeDeserializer.kt */
public final class TypeDeserializer$simpleType$annotations$1 extends Lambda implements Function0<List<? extends AnnotationDescriptor>> {
    public final /* synthetic */ ProtoBuf$Type $proto;
    public final /* synthetic */ TypeDeserializer this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public TypeDeserializer$simpleType$annotations$1(TypeDeserializer typeDeserializer, ProtoBuf$Type protoBuf$Type) {
        // this.this$0 = typeDeserializer;
        // this.$proto = protoBuf$Type;
        super(0);
    }

    public Object invoke() {
        DeserializationContext deserializationContext = this.this$0.f5949c;
        return deserializationContext.components.annotationAndConstantLoader.loadTypeAnnotations(this.$proto, deserializationContext.nameResolver);
    }
}
