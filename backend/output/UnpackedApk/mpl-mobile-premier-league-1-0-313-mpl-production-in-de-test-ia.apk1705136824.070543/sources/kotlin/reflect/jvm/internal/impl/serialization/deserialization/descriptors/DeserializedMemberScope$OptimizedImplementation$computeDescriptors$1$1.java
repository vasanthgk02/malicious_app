package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.io.ByteArrayInputStream;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractParser;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

/* compiled from: DeserializedMemberScope.kt */
public final class DeserializedMemberScope$OptimizedImplementation$computeDescriptors$1$1 extends Lambda implements Function0<M> {
    public final /* synthetic */ ByteArrayInputStream $inputStream;
    public final /* synthetic */ Parser<M> $parser;
    public final /* synthetic */ DeserializedMemberScope this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DeserializedMemberScope$OptimizedImplementation$computeDescriptors$1$1(Parser<M> parser, ByteArrayInputStream byteArrayInputStream, DeserializedMemberScope deserializedMemberScope) {
        // this.$parser = parser;
        // this.$inputStream = byteArrayInputStream;
        // this.this$0 = deserializedMemberScope;
        super(0);
    }

    public Object invoke() {
        return (MessageLite) ((AbstractParser) this.$parser).parseDelimitedFrom(this.$inputStream, this.this$0.f5951c.components.extensionRegistryLite);
    }
}
