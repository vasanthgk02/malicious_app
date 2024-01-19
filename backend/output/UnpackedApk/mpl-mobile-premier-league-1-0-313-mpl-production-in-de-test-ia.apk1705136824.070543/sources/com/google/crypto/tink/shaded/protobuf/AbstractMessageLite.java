package com.google.crypto.tink.shaded.protobuf;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.crypto.tink.shaded.protobuf.AbstractMessageLite;
import com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder;
import com.google.crypto.tink.shaded.protobuf.ByteString.CodedBuilder;
import java.io.IOException;

public abstract class AbstractMessageLite<MessageType extends AbstractMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> implements MessageLite {
    public int memoizedHashCode = 0;

    public static abstract class Builder<MessageType extends AbstractMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> implements com.google.crypto.tink.shaded.protobuf.MessageLite.Builder {
    }

    public int getSerializedSize(Schema schema) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) this;
        int i = generatedMessageLite.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int serializedSize = schema.getSerializedSize(this);
        generatedMessageLite.memoizedSerializedSize = serializedSize;
        return serializedSize;
    }

    public final String getSerializingExceptionMessage(String str) {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Serializing ");
        outline73.append(getClass().getName());
        outline73.append(" to a ");
        outline73.append(str);
        outline73.append(" threw an IOException (should never happen).");
        return outline73.toString();
    }

    public byte[] toByteArray() {
        try {
            byte[] bArr = new byte[getSerializedSize()];
            CodedOutputStream newInstance = CodedOutputStream.newInstance(bArr);
            writeTo(newInstance);
            if (newInstance.spaceLeft() == 0) {
                return bArr;
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e2) {
            throw new RuntimeException(getSerializingExceptionMessage("byte array"), e2);
        }
    }

    public ByteString toByteString() {
        try {
            CodedBuilder newCodedBuilder = ByteString.newCodedBuilder(getSerializedSize());
            writeTo(newCodedBuilder.output);
            return newCodedBuilder.build();
        } catch (IOException e2) {
            throw new RuntimeException(getSerializingExceptionMessage("ByteString"), e2);
        }
    }
}
