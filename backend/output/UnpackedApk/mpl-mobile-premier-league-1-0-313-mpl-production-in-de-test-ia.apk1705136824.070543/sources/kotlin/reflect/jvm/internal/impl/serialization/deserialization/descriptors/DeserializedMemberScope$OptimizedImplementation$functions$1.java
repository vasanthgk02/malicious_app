package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.OptimizedImplementation;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.sequences.GeneratorSequence;
import kotlin.sequences.SequencesKt__SequencesKt$generateSequence$1;

/* compiled from: DeserializedMemberScope.kt */
public final class DeserializedMemberScope$OptimizedImplementation$functions$1 extends Lambda implements Function1<Name, Collection<? extends SimpleFunctionDescriptor>> {
    public final /* synthetic */ OptimizedImplementation this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DeserializedMemberScope$OptimizedImplementation$functions$1(OptimizedImplementation optimizedImplementation) {
        // this.this$0 = optimizedImplementation;
        super(1);
    }

    public Object invoke(Object obj) {
        Collection<ProtoBuf$Function> collection;
        Name name = (Name) obj;
        Intrinsics.checkNotNullParameter(name, "it");
        OptimizedImplementation optimizedImplementation = this.this$0;
        Map<Name, byte[]> map = optimizedImplementation.functionProtosBytes;
        Parser<ProtoBuf$Function> parser = ProtoBuf$Function.PARSER;
        Intrinsics.checkNotNullExpressionValue(parser, "PARSER");
        DeserializedMemberScope deserializedMemberScope = optimizedImplementation.this$0;
        byte[] bArr = map.get(name);
        if (bArr == null) {
            collection = null;
        } else {
            DeserializedMemberScope$OptimizedImplementation$computeDescriptors$1$1 deserializedMemberScope$OptimizedImplementation$computeDescriptors$1$1 = new DeserializedMemberScope$OptimizedImplementation$computeDescriptors$1$1(parser, new ByteArrayInputStream(bArr), optimizedImplementation.this$0);
            Intrinsics.checkNotNullParameter(deserializedMemberScope$OptimizedImplementation$computeDescriptors$1$1, "nextFunction");
            collection = TypeUtilsKt.toList(TypeUtilsKt.constrainOnce(new GeneratorSequence(deserializedMemberScope$OptimizedImplementation$computeDescriptors$1$1, new SequencesKt__SequencesKt$generateSequence$1(deserializedMemberScope$OptimizedImplementation$computeDescriptors$1$1))));
        }
        if (collection == null) {
            collection = EmptyList.INSTANCE;
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (ProtoBuf$Function protoBuf$Function : collection) {
            MemberDeserializer memberDeserializer = deserializedMemberScope.f5951c.memberDeserializer;
            Intrinsics.checkNotNullExpressionValue(protoBuf$Function, "it");
            SimpleFunctionDescriptor loadFunction = memberDeserializer.loadFunction(protoBuf$Function);
            if (!deserializedMemberScope.isDeclaredFunctionAvailable(loadFunction)) {
                loadFunction = null;
            }
            if (loadFunction != null) {
                arrayList.add(loadFunction);
            }
        }
        deserializedMemberScope.computeNonDeclaredFunctions(name, arrayList);
        return TypeUtilsKt.compact(arrayList);
    }
}
