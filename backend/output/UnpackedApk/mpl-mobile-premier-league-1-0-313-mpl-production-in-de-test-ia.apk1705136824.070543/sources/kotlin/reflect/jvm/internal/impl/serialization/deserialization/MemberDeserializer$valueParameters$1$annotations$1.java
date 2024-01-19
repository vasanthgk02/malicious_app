package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;

/* compiled from: MemberDeserializer.kt */
public final class MemberDeserializer$valueParameters$1$annotations$1 extends Lambda implements Function0<List<? extends AnnotationDescriptor>> {
    public final /* synthetic */ MessageLite $callable;
    public final /* synthetic */ ProtoContainer $containerOfCallable;
    public final /* synthetic */ int $i;
    public final /* synthetic */ AnnotatedCallableKind $kind;
    public final /* synthetic */ ProtoBuf$ValueParameter $proto;
    public final /* synthetic */ MemberDeserializer this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public MemberDeserializer$valueParameters$1$annotations$1(MemberDeserializer memberDeserializer, ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind, int i, ProtoBuf$ValueParameter protoBuf$ValueParameter) {
        // this.this$0 = memberDeserializer;
        // this.$containerOfCallable = protoContainer;
        // this.$callable = messageLite;
        // this.$kind = annotatedCallableKind;
        // this.$i = i;
        // this.$proto = protoBuf$ValueParameter;
        super(0);
    }

    public Object invoke() {
        return ArraysKt___ArraysJvmKt.toList(this.this$0.f5948c.components.annotationAndConstantLoader.loadValueParameterAnnotations(this.$containerOfCallable, this.$callable, this.$kind, this.$i, this.$proto));
    }
}
