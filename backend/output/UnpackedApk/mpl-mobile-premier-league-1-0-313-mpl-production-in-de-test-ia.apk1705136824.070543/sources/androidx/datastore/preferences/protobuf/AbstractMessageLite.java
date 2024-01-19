package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.AbstractMessageLite;
import androidx.datastore.preferences.protobuf.AbstractMessageLite.Builder;
import androidx.datastore.preferences.protobuf.ByteString.CodedBuilder;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;

public abstract class AbstractMessageLite<MessageType extends AbstractMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> implements MessageLite {
    public int memoizedHashCode = 0;

    public static abstract class Builder<MessageType extends AbstractMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> implements androidx.datastore.preferences.protobuf.MessageLite.Builder {
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

    public ByteString toByteString() {
        try {
            CodedBuilder newCodedBuilder = ByteString.newCodedBuilder(getSerializedSize());
            writeTo(newCodedBuilder.output);
            return newCodedBuilder.build();
        } catch (IOException e2) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Serializing ");
            outline73.append(getClass().getName());
            outline73.append(" to a ");
            outline73.append("ByteString");
            outline73.append(" threw an IOException (should never happen).");
            throw new RuntimeException(outline73.toString(), e2);
        }
    }
}
