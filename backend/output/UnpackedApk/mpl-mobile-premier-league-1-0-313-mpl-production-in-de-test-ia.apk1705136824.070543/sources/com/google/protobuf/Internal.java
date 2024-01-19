package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite.Builder;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.List;
import java.util.RandomAccess;

public final class Internal {
    public static final byte[] EMPTY_BYTE_ARRAY;
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    public interface EnumLite {
        int getNumber();
    }

    public interface EnumLiteMap<T extends EnumLite> {
    }

    public interface EnumVerifier {
        boolean isInRange(int i);
    }

    public interface IntList extends ProtobufList<Integer> {
    }

    public interface ProtobufList<E> extends List<E>, RandomAccess {
        boolean isModifiable();

        void makeImmutable();

        ProtobufList<E> mutableCopyWithCapacity(int i);
    }

    static {
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        ByteBuffer.wrap(bArr);
        byte[] bArr2 = EMPTY_BYTE_ARRAY;
        CodedInputStream.newInstance(bArr2, 0, bArr2.length, false);
    }

    public static <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }

    public static int hashBoolean(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int hashCode(byte[] bArr) {
        int length = bArr.length;
        int i = length;
        for (int i2 = 0; i2 < 0 + length; i2++) {
            i = (i * 31) + bArr[i2];
        }
        if (i == 0) {
            return 1;
        }
        return i;
    }

    public static int hashLong(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static Object mergeMessage(Object obj, Object obj2) {
        MessageLite messageLite = (MessageLite) obj2;
        Builder builder = (Builder) ((MessageLite) obj).toBuilder();
        if (builder != null) {
            GeneratedMessageLite.Builder builder2 = (GeneratedMessageLite.Builder) builder;
            if (builder2.defaultInstance.getClass().isInstance(messageLite)) {
                builder2.copyOnWrite();
                MessageType messagetype = builder2.instance;
                Protobuf.INSTANCE.schemaFor(messagetype).mergeFrom(messagetype, (GeneratedMessageLite) ((AbstractMessageLite) messageLite));
                return builder2.buildPartial();
            }
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
        throw null;
    }

    public static int partialHash(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    public static String toStringUtf8(byte[] bArr) {
        return new String(bArr, UTF_8);
    }

    public static <T> T checkNotNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }
}
