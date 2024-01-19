package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.InputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;

public abstract class AbstractParser<MessageType extends MessageLite> implements Parser<MessageType> {
    static {
        ExtensionRegistryLite extensionRegistryLite = ExtensionRegistryLite.EMPTY;
    }

    public final MessageType checkMessageInitialized(MessageType messagetype) throws InvalidProtocolBufferException {
        UninitializedMessageException uninitializedMessageException;
        if (messagetype == null || messagetype.isInitialized()) {
            return messagetype;
        }
        if (messagetype instanceof AbstractMessageLite) {
            AbstractMessageLite abstractMessageLite = (AbstractMessageLite) messagetype;
            uninitializedMessageException = new UninitializedMessageException();
        } else {
            uninitializedMessageException = new UninitializedMessageException();
        }
        InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException(uninitializedMessageException.getMessage());
        invalidProtocolBufferException.unfinishedMessage = messagetype;
        throw invalidProtocolBufferException;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002e, code lost:
        if (r2 >= 64) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0030, code lost:
        r3 = r6.read();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0034, code lost:
        if (r3 == -1) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0038, code lost:
        if ((r3 & 128) != 0) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0047, code lost:
        r2 = r2 + 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x004e, code lost:
        throw kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException.truncatedMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0056, code lost:
        throw new kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException("CodedInputStream encountered a malformed varint.");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object parseDelimitedFrom(java.io.InputStream r6, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r7) throws kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException {
        /*
            r5 = this;
            int r0 = r6.read()     // Catch:{ IOException -> 0x0057 }
            r1 = -1
            if (r0 != r1) goto L_0x0009
            r6 = 0
            goto L_0x0043
        L_0x0009:
            r2 = r0 & 128(0x80, float:1.8E-43)
            if (r2 != 0) goto L_0x000e
            goto L_0x003a
        L_0x000e:
            r0 = r0 & 127(0x7f, float:1.78E-43)
            r2 = 7
        L_0x0011:
            r3 = 32
            if (r2 >= r3) goto L_0x002c
            int r3 = r6.read()     // Catch:{ IOException -> 0x0057 }
            if (r3 == r1) goto L_0x0027
            r4 = r3 & 127(0x7f, float:1.78E-43)
            int r4 = r4 << r2
            r0 = r0 | r4
            r3 = r3 & 128(0x80, float:1.8E-43)
            if (r3 != 0) goto L_0x0024
            goto L_0x003a
        L_0x0024:
            int r2 = r2 + 7
            goto L_0x0011
        L_0x0027:
            kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException r6 = kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException.truncatedMessage()     // Catch:{ IOException -> 0x0057 }
            throw r6     // Catch:{ IOException -> 0x0057 }
        L_0x002c:
            r3 = 64
            if (r2 >= r3) goto L_0x004f
            int r3 = r6.read()     // Catch:{ IOException -> 0x0057 }
            if (r3 == r1) goto L_0x004a
            r3 = r3 & 128(0x80, float:1.8E-43)
            if (r3 != 0) goto L_0x0047
        L_0x003a:
            kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite$Builder$LimitedInputStream r1 = new kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite$Builder$LimitedInputStream
            r1.<init>(r6, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r6 = r5.parsePartialFrom(r1, r7)
        L_0x0043:
            r5.checkMessageInitialized(r6)
            return r6
        L_0x0047:
            int r2 = r2 + 7
            goto L_0x002c
        L_0x004a:
            kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException r6 = kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException.truncatedMessage()     // Catch:{ IOException -> 0x0057 }
            throw r6     // Catch:{ IOException -> 0x0057 }
        L_0x004f:
            kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException r6 = new kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException     // Catch:{ IOException -> 0x0057 }
            java.lang.String r7 = "CodedInputStream encountered a malformed varint."
            r6.<init>(r7)     // Catch:{ IOException -> 0x0057 }
            throw r6     // Catch:{ IOException -> 0x0057 }
        L_0x0057:
            r6 = move-exception
            kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException r7 = new kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException
            java.lang.String r6 = r6.getMessage()
            r7.<init>(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.AbstractParser.parseDelimitedFrom(java.io.InputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):java.lang.Object");
    }

    public MessageType parsePartialFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        CodedInputStream codedInputStream = new CodedInputStream(inputStream);
        MessageType messagetype = (MessageLite) parsePartialFrom(codedInputStream, extensionRegistryLite);
        try {
            codedInputStream.checkLastTagWas(0);
            return messagetype;
        } catch (InvalidProtocolBufferException e2) {
            e2.unfinishedMessage = messagetype;
            throw e2;
        }
    }
}
