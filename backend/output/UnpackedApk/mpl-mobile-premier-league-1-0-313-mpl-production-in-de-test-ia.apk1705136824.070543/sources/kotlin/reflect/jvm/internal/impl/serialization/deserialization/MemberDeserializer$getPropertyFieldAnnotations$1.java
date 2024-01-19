package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;

/* compiled from: MemberDeserializer.kt */
public final class MemberDeserializer$getPropertyFieldAnnotations$1 extends Lambda implements Function0<List<? extends AnnotationDescriptor>> {
    public final /* synthetic */ boolean $isDelegate;
    public final /* synthetic */ ProtoBuf$Property $proto;
    public final /* synthetic */ MemberDeserializer this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public MemberDeserializer$getPropertyFieldAnnotations$1(MemberDeserializer memberDeserializer, boolean z, ProtoBuf$Property protoBuf$Property) {
        // this.this$0 = memberDeserializer;
        // this.$isDelegate = z;
        // this.$proto = protoBuf$Property;
        super(0);
    }

    public Object invoke() {
        List list;
        MemberDeserializer memberDeserializer = this.this$0;
        ProtoContainer asProtoContainer = memberDeserializer.asProtoContainer(memberDeserializer.f5948c.containingDeclaration);
        if (asProtoContainer == null) {
            list = null;
        } else {
            boolean z = this.$isDelegate;
            MemberDeserializer memberDeserializer2 = this.this$0;
            ProtoBuf$Property protoBuf$Property = this.$proto;
            if (z) {
                list = ArraysKt___ArraysJvmKt.toList(memberDeserializer2.f5948c.components.annotationAndConstantLoader.loadPropertyDelegateFieldAnnotations(asProtoContainer, protoBuf$Property));
            } else {
                list = ArraysKt___ArraysJvmKt.toList(memberDeserializer2.f5948c.components.annotationAndConstantLoader.loadPropertyBackingFieldAnnotations(asProtoContainer, protoBuf$Property));
            }
        }
        return list != null ? list : EmptyList.INSTANCE;
    }
}
