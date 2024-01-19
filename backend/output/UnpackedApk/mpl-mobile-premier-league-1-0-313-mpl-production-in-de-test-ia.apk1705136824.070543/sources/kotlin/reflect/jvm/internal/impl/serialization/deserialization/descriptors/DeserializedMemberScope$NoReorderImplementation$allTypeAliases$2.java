package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.NoReorderImplementation;

/* compiled from: DeserializedMemberScope.kt */
public final class DeserializedMemberScope$NoReorderImplementation$allTypeAliases$2 extends Lambda implements Function0<List<? extends TypeAliasDescriptor>> {
    public final /* synthetic */ NoReorderImplementation this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DeserializedMemberScope$NoReorderImplementation$allTypeAliases$2(NoReorderImplementation noReorderImplementation) {
        // this.this$0 = noReorderImplementation;
        super(0);
    }

    public Object invoke() {
        NoReorderImplementation noReorderImplementation = this.this$0;
        List<ProtoBuf$TypeAlias> list = noReorderImplementation.typeAliasList;
        DeserializedMemberScope deserializedMemberScope = noReorderImplementation.this$0;
        ArrayList arrayList = new ArrayList();
        for (MessageLite messageLite : list) {
            arrayList.add(deserializedMemberScope.f5951c.memberDeserializer.loadTypeAlias((ProtoBuf$TypeAlias) messageLite));
        }
        return arrayList;
    }
}
