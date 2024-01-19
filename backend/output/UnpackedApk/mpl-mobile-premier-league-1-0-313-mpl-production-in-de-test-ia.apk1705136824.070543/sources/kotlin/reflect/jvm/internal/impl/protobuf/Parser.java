package kotlin.reflect.jvm.internal.impl.protobuf;

public interface Parser<MessageType> {
    MessageType parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException;
}
