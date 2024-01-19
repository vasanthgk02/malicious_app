package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry;

/* compiled from: DeserializedClassDescriptor.kt */
public final class DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1$1$1 extends Lambda implements Function0<List<? extends AnnotationDescriptor>> {
    public final /* synthetic */ ProtoBuf$EnumEntry $proto;
    public final /* synthetic */ DeserializedClassDescriptor this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1$1$1(DeserializedClassDescriptor deserializedClassDescriptor, ProtoBuf$EnumEntry protoBuf$EnumEntry) {
        // this.this$0 = deserializedClassDescriptor;
        // this.$proto = protoBuf$EnumEntry;
        super(0);
    }

    public Object invoke() {
        DeserializedClassDescriptor deserializedClassDescriptor = this.this$0;
        return ArraysKt___ArraysJvmKt.toList(deserializedClassDescriptor.f5950c.components.annotationAndConstantLoader.loadEnumEntryAnnotations(deserializedClassDescriptor.thisAsProtoContainer, this.$proto));
    }
}
