package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: MemberDeserializer.kt */
public final class MemberDeserializer$loadProperty$3 extends Lambda implements Function0<ConstantValue<?>> {
    public final /* synthetic */ DeserializedPropertyDescriptor $property;
    public final /* synthetic */ ProtoBuf$Property $proto;
    public final /* synthetic */ MemberDeserializer this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public MemberDeserializer$loadProperty$3(MemberDeserializer memberDeserializer, ProtoBuf$Property protoBuf$Property, DeserializedPropertyDescriptor deserializedPropertyDescriptor) {
        // this.this$0 = memberDeserializer;
        // this.$proto = protoBuf$Property;
        // this.$property = deserializedPropertyDescriptor;
        super(0);
    }

    public Object invoke() {
        MemberDeserializer memberDeserializer = this.this$0;
        ProtoContainer asProtoContainer = memberDeserializer.asProtoContainer(memberDeserializer.f5948c.containingDeclaration);
        Intrinsics.checkNotNull(asProtoContainer);
        AnnotationAndConstantLoader<AnnotationDescriptor, ConstantValue<?>> annotationAndConstantLoader = this.this$0.f5948c.components.annotationAndConstantLoader;
        ProtoBuf$Property protoBuf$Property = this.$proto;
        KotlinType returnType = this.$property.getReturnType();
        Intrinsics.checkNotNullExpressionValue(returnType, "property.returnType");
        return (ConstantValue) annotationAndConstantLoader.loadPropertyConstant(asProtoContainer, protoBuf$Property, returnType);
    }
}
