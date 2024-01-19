package androidx.datastore.preferences.protobuf;

import java.io.IOException;

public abstract class UnknownFieldSchema<T, B> {
    public abstract void addLengthDelimited(B b2, int i, ByteString byteString);

    public abstract B getBuilderFromMessage(Object obj);

    public final boolean mergeOneFieldFrom(B b2, Reader reader) throws IOException {
        int tag = reader.getTag();
        int i = tag >>> 3;
        int i2 = tag & 7;
        if (i2 == 0) {
            ((UnknownFieldSetLite) b2).storeField((i << 3) | 0, Long.valueOf(reader.readInt64()));
            return true;
        } else if (i2 == 1) {
            ((UnknownFieldSetLite) b2).storeField((i << 3) | 1, Long.valueOf(reader.readFixed64()));
            return true;
        } else if (i2 == 2) {
            addLengthDelimited(b2, i, reader.readBytes());
            return true;
        } else if (i2 == 3) {
            Object newBuilder = newBuilder();
            int i3 = i << 3;
            int i4 = i3 | 4;
            while (reader.getFieldNumber() != Integer.MAX_VALUE) {
                if (!mergeOneFieldFrom(newBuilder, reader)) {
                    break;
                }
            }
            if (i4 == reader.getTag()) {
                UnknownFieldSetLite unknownFieldSetLite = (UnknownFieldSetLite) newBuilder;
                unknownFieldSetLite.isMutable = false;
                ((UnknownFieldSetLite) b2).storeField(i3 | 3, unknownFieldSetLite);
                return true;
            }
            throw InvalidProtocolBufferException.invalidEndTag();
        } else if (i2 == 4) {
            return false;
        } else {
            if (i2 == 5) {
                ((UnknownFieldSetLite) b2).storeField((i << 3) | 5, Integer.valueOf(reader.readFixed32()));
                return true;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
    }

    public abstract B newBuilder();

    public abstract void setBuilderToMessage(Object obj, B b2);

    public abstract boolean shouldDiscardUnknownFields(Reader reader);
}
