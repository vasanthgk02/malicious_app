package com.google.crypto.tink.shaded.protobuf;

public final class RawMessageInfo implements MessageInfo {
    public final MessageLite defaultInstance;
    public final int flags;
    public final String info;
    public final Object[] objects;

    public RawMessageInfo(MessageLite messageLite, String str, Object[] objArr) {
        this.defaultInstance = messageLite;
        this.info = str;
        this.objects = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.flags = charAt;
            return;
        }
        char c2 = charAt & 8191;
        int i = 13;
        int i2 = 1;
        while (true) {
            int i3 = i2 + 1;
            char charAt2 = str.charAt(i2);
            if (charAt2 >= 55296) {
                c2 |= (charAt2 & 8191) << i;
                i += 13;
                i2 = i3;
            } else {
                this.flags = c2 | (charAt2 << i);
                return;
            }
        }
    }

    public MessageLite getDefaultInstance() {
        return this.defaultInstance;
    }

    public ProtoSyntax getSyntax() {
        return (this.flags & 1) == 1 ? ProtoSyntax.PROTO2 : ProtoSyntax.PROTO3;
    }

    public boolean isMessageSetWireFormat() {
        return (this.flags & 2) == 2;
    }
}
