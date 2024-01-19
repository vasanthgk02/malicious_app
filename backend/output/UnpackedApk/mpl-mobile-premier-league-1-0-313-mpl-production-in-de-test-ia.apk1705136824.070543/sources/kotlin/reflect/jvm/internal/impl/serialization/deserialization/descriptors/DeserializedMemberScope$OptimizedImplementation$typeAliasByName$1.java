package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.io.ByteArrayInputStream;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractParser;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.OptimizedImplementation;

/* compiled from: DeserializedMemberScope.kt */
public final class DeserializedMemberScope$OptimizedImplementation$typeAliasByName$1 extends Lambda implements Function1<Name, TypeAliasDescriptor> {
    public final /* synthetic */ OptimizedImplementation this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DeserializedMemberScope$OptimizedImplementation$typeAliasByName$1(OptimizedImplementation optimizedImplementation) {
        // this.this$0 = optimizedImplementation;
        super(1);
    }

    public Object invoke(Object obj) {
        Name name = (Name) obj;
        Intrinsics.checkNotNullParameter(name, "it");
        OptimizedImplementation optimizedImplementation = this.this$0;
        byte[] bArr = optimizedImplementation.typeAliasBytes.get(name);
        if (bArr == null) {
            return null;
        }
        ProtoBuf$TypeAlias protoBuf$TypeAlias = (ProtoBuf$TypeAlias) ((AbstractParser) ProtoBuf$TypeAlias.PARSER).parseDelimitedFrom(new ByteArrayInputStream(bArr), optimizedImplementation.this$0.f5951c.components.extensionRegistryLite);
        if (protoBuf$TypeAlias == null) {
            return null;
        }
        return optimizedImplementation.this$0.f5951c.memberDeserializer.loadTypeAlias(protoBuf$TypeAlias);
    }
}
