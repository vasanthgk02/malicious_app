package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.NoReorderImplementation;

/* compiled from: DeserializedMemberScope.kt */
public final class DeserializedMemberScope$NoReorderImplementation$declaredFunctions$2 extends Lambda implements Function0<List<? extends SimpleFunctionDescriptor>> {
    public final /* synthetic */ NoReorderImplementation this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DeserializedMemberScope$NoReorderImplementation$declaredFunctions$2(NoReorderImplementation noReorderImplementation) {
        // this.this$0 = noReorderImplementation;
        super(0);
    }

    public Object invoke() {
        NoReorderImplementation noReorderImplementation = this.this$0;
        List<ProtoBuf$Function> list = noReorderImplementation.functionList;
        DeserializedMemberScope deserializedMemberScope = noReorderImplementation.this$0;
        ArrayList arrayList = new ArrayList();
        for (MessageLite messageLite : list) {
            SimpleFunctionDescriptor loadFunction = deserializedMemberScope.f5951c.memberDeserializer.loadFunction((ProtoBuf$Function) messageLite);
            if (!deserializedMemberScope.isDeclaredFunctionAvailable(loadFunction)) {
                loadFunction = null;
            }
            if (loadFunction != null) {
                arrayList.add(loadFunction);
            }
        }
        return arrayList;
    }
}
