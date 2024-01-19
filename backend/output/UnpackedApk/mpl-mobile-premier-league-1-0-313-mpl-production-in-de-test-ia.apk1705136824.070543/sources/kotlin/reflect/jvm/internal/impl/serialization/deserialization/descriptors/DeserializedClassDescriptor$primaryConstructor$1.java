package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory$DefaultClassConstructorDescriptor;

/* compiled from: DeserializedClassDescriptor.kt */
public final class DeserializedClassDescriptor$primaryConstructor$1 extends Lambda implements Function0<ClassConstructorDescriptor> {
    public final /* synthetic */ DeserializedClassDescriptor this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DeserializedClassDescriptor$primaryConstructor$1(DeserializedClassDescriptor deserializedClassDescriptor) {
        // this.this$0 = deserializedClassDescriptor;
        super(0);
    }

    public Object invoke() {
        T t;
        DeserializedClassDescriptor deserializedClassDescriptor = this.this$0;
        if (deserializedClassDescriptor.kind.isSingleton()) {
            DescriptorFactory$DefaultClassConstructorDescriptor descriptorFactory$DefaultClassConstructorDescriptor = new DescriptorFactory$DefaultClassConstructorDescriptor(deserializedClassDescriptor, SourceElement.NO_SOURCE, false);
            descriptorFactory$DefaultClassConstructorDescriptor.setReturnType(deserializedClassDescriptor.getDefaultType());
            return descriptorFactory$DefaultClassConstructorDescriptor;
        }
        List<ProtoBuf$Constructor> list = deserializedClassDescriptor.classProto.constructor_;
        Intrinsics.checkNotNullExpressionValue(list, "classProto.constructorList");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (!Flags.IS_SECONDARY.get(((ProtoBuf$Constructor) t).flags_).booleanValue()) {
                break;
            }
        }
        ProtoBuf$Constructor protoBuf$Constructor = (ProtoBuf$Constructor) t;
        if (protoBuf$Constructor == null) {
            return null;
        }
        return deserializedClassDescriptor.f5950c.memberDeserializer.loadConstructor(protoBuf$Constructor, true);
    }
}
