package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;

/* compiled from: ContractDeserializer.kt */
public final class ContractDeserializer$Companion$DEFAULT$1 implements ContractDeserializer {
    public Pair deserializeContractFromFunction(ProtoBuf$Function protoBuf$Function, FunctionDescriptor functionDescriptor, TypeTable typeTable, TypeDeserializer typeDeserializer) {
        Intrinsics.checkNotNullParameter(protoBuf$Function, "proto");
        Intrinsics.checkNotNullParameter(functionDescriptor, "ownerFunction");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        Intrinsics.checkNotNullParameter(typeDeserializer, "typeDeserializer");
        return null;
    }
}
