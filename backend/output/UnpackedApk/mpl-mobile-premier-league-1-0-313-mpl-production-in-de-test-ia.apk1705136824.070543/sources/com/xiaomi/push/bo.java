package com.xiaomi.push;

import java.nio.ByteBuffer;

public final class bo extends bi {
    public bo() {
        a((String) "PING", (String) null);
        a((String) "0");
        a(0);
    }

    public ByteBuffer a(ByteBuffer byteBuffer) {
        return a().length == 0 ? byteBuffer : super.a(byteBuffer);
    }

    public int c() {
        if (a().length == 0) {
            return 0;
        }
        return super.c();
    }
}
