package com.google.protobuf;

import com.google.protobuf.ByteString.LiteralByteString;
import com.google.protobuf.MessageLite;

public abstract class AbstractParser<MessageType extends MessageLite> implements Parser<MessageType> {
    static {
        ExtensionRegistryLite.getEmptyRegistry();
    }

    public Object parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        UninitializedMessageException uninitializedMessageException;
        try {
            LiteralByteString literalByteString = (LiteralByteString) byteString;
            CodedInputStream newInstance = CodedInputStream.newInstance(literalByteString.bytes, literalByteString.getOffsetIntoBytes(), literalByteString.size(), true);
            MessageLite messageLite = (MessageLite) parsePartialFrom(newInstance, null);
            newInstance.checkLastTagWas(0);
            if (messageLite == null || messageLite.isInitialized()) {
                return messageLite;
            }
            if (messageLite instanceof AbstractMessageLite) {
                AbstractMessageLite abstractMessageLite = (AbstractMessageLite) messageLite;
                uninitializedMessageException = new UninitializedMessageException();
            } else {
                uninitializedMessageException = new UninitializedMessageException();
            }
            throw new InvalidProtocolBufferException(uninitializedMessageException.getMessage());
        } catch (InvalidProtocolBufferException e2) {
            throw e2;
        } catch (InvalidProtocolBufferException e3) {
            throw e3;
        }
    }
}
