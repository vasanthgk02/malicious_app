package com.google.crypto.tink.shaded.protobuf;

public class LazyFieldLite {
    public ByteString delayedBytes;
    public volatile ByteString memoizedBytes;
    public volatile MessageLite value;

    static {
        ExtensionRegistryLite.getEmptyRegistry();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LazyFieldLite)) {
            return false;
        }
        LazyFieldLite lazyFieldLite = (LazyFieldLite) obj;
        MessageLite messageLite = this.value;
        MessageLite messageLite2 = lazyFieldLite.value;
        if (messageLite == null && messageLite2 == null) {
            return toByteString().equals(lazyFieldLite.toByteString());
        }
        if (messageLite != null && messageLite2 != null) {
            return messageLite.equals(messageLite2);
        }
        if (messageLite != null) {
            return messageLite.equals(lazyFieldLite.getValue(messageLite.getDefaultInstanceForType()));
        }
        return getValue(messageLite2.getDefaultInstanceForType()).equals(messageLite2);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:12|13) */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r3.value = r4;
        r3.memoizedBytes = com.google.crypto.tink.shaded.protobuf.ByteString.EMPTY;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x002b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.crypto.tink.shaded.protobuf.MessageLite getValue(com.google.crypto.tink.shaded.protobuf.MessageLite r4) {
        /*
            r3 = this;
            com.google.crypto.tink.shaded.protobuf.MessageLite r0 = r3.value
            if (r0 == 0) goto L_0x0005
            goto L_0x0032
        L_0x0005:
            monitor-enter(r3)
            com.google.crypto.tink.shaded.protobuf.MessageLite r0 = r3.value     // Catch:{ all -> 0x0035 }
            if (r0 == 0) goto L_0x000c
            monitor-exit(r3)     // Catch:{ all -> 0x0035 }
            goto L_0x0032
        L_0x000c:
            com.google.crypto.tink.shaded.protobuf.ByteString r0 = r3.delayedBytes     // Catch:{ InvalidProtocolBufferException -> 0x002b }
            if (r0 == 0) goto L_0x0024
            com.google.crypto.tink.shaded.protobuf.Parser r0 = r4.getParserForType()     // Catch:{ InvalidProtocolBufferException -> 0x002b }
            com.google.crypto.tink.shaded.protobuf.ByteString r1 = r3.delayedBytes     // Catch:{ InvalidProtocolBufferException -> 0x002b }
            r2 = 0
            java.lang.Object r0 = r0.parseFrom(r1, r2)     // Catch:{ InvalidProtocolBufferException -> 0x002b }
            com.google.crypto.tink.shaded.protobuf.MessageLite r0 = (com.google.crypto.tink.shaded.protobuf.MessageLite) r0     // Catch:{ InvalidProtocolBufferException -> 0x002b }
            r3.value = r0     // Catch:{ InvalidProtocolBufferException -> 0x002b }
            com.google.crypto.tink.shaded.protobuf.ByteString r0 = r3.delayedBytes     // Catch:{ InvalidProtocolBufferException -> 0x002b }
            r3.memoizedBytes = r0     // Catch:{ InvalidProtocolBufferException -> 0x002b }
            goto L_0x0031
        L_0x0024:
            r3.value = r4     // Catch:{ InvalidProtocolBufferException -> 0x002b }
            com.google.crypto.tink.shaded.protobuf.ByteString r0 = com.google.crypto.tink.shaded.protobuf.ByteString.EMPTY     // Catch:{ InvalidProtocolBufferException -> 0x002b }
            r3.memoizedBytes = r0     // Catch:{ InvalidProtocolBufferException -> 0x002b }
            goto L_0x0031
        L_0x002b:
            r3.value = r4     // Catch:{ all -> 0x0035 }
            com.google.crypto.tink.shaded.protobuf.ByteString r4 = com.google.crypto.tink.shaded.protobuf.ByteString.EMPTY     // Catch:{ all -> 0x0035 }
            r3.memoizedBytes = r4     // Catch:{ all -> 0x0035 }
        L_0x0031:
            monitor-exit(r3)     // Catch:{ all -> 0x0035 }
        L_0x0032:
            com.google.crypto.tink.shaded.protobuf.MessageLite r4 = r3.value
            return r4
        L_0x0035:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0035 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.LazyFieldLite.getValue(com.google.crypto.tink.shaded.protobuf.MessageLite):com.google.crypto.tink.shaded.protobuf.MessageLite");
    }

    public int hashCode() {
        return 1;
    }

    public ByteString toByteString() {
        if (this.memoizedBytes != null) {
            return this.memoizedBytes;
        }
        ByteString byteString = this.delayedBytes;
        if (byteString != null) {
            return byteString;
        }
        synchronized (this) {
            if (this.memoizedBytes != null) {
                ByteString byteString2 = this.memoizedBytes;
                return byteString2;
            }
            if (this.value == null) {
                this.memoizedBytes = ByteString.EMPTY;
            } else {
                this.memoizedBytes = this.value.toByteString();
            }
            ByteString byteString3 = this.memoizedBytes;
            return byteString3;
        }
    }
}
