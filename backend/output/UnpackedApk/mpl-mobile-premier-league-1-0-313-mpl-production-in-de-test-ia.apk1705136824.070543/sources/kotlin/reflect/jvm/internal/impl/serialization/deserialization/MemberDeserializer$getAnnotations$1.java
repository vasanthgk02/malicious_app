package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;

/* compiled from: MemberDeserializer.kt */
public final class MemberDeserializer$getAnnotations$1 extends Lambda implements Function0<List<? extends AnnotationDescriptor>> {
    public final /* synthetic */ AnnotatedCallableKind $kind;
    public final /* synthetic */ MessageLite $proto;
    public final /* synthetic */ MemberDeserializer this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public MemberDeserializer$getAnnotations$1(MemberDeserializer memberDeserializer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        // this.this$0 = memberDeserializer;
        // this.$proto = messageLite;
        // this.$kind = annotatedCallableKind;
        super(0);
    }

    public Object invoke() {
        List list;
        MemberDeserializer memberDeserializer = this.this$0;
        ProtoContainer asProtoContainer = memberDeserializer.asProtoContainer(memberDeserializer.f5948c.containingDeclaration);
        if (asProtoContainer == null) {
            list = null;
        } else {
            list = ArraysKt___ArraysJvmKt.toList(this.this$0.f5948c.components.annotationAndConstantLoader.loadCallableAnnotations(asProtoContainer, this.$proto, this.$kind));
        }
        return list != null ? list : EmptyList.INSTANCE;
    }
}
