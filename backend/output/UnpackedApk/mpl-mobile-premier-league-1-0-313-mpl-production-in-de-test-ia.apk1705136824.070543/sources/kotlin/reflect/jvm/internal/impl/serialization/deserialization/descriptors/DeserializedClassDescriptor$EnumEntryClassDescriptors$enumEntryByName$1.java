package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EnumEntrySyntheticClassDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.EnumEntryClassDescriptors;

/* compiled from: DeserializedClassDescriptor.kt */
public final class DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1 extends Lambda implements Function1<Name, ClassDescriptor> {
    public final /* synthetic */ EnumEntryClassDescriptors this$0;
    public final /* synthetic */ DeserializedClassDescriptor this$1;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1(EnumEntryClassDescriptors enumEntryClassDescriptors, DeserializedClassDescriptor deserializedClassDescriptor) {
        // this.this$0 = enumEntryClassDescriptors;
        // this.this$1 = deserializedClassDescriptor;
        super(1);
    }

    public Object invoke(Object obj) {
        Name name = (Name) obj;
        Intrinsics.checkNotNullParameter(name, "name");
        ProtoBuf$EnumEntry protoBuf$EnumEntry = this.this$0.enumEntryProtos.get(name);
        if (protoBuf$EnumEntry == null) {
            return null;
        }
        DeserializedClassDescriptor deserializedClassDescriptor = this.this$1;
        EnumEntryClassDescriptors enumEntryClassDescriptors = this.this$0;
        return EnumEntrySyntheticClassDescriptor.create(deserializedClassDescriptor.f5950c.components.storageManager, deserializedClassDescriptor, name, enumEntryClassDescriptors.enumMemberNames, new DeserializedAnnotations(deserializedClassDescriptor.f5950c.components.storageManager, new DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1$1$1(deserializedClassDescriptor, protoBuf$EnumEntry)), SourceElement.NO_SOURCE);
    }
}
