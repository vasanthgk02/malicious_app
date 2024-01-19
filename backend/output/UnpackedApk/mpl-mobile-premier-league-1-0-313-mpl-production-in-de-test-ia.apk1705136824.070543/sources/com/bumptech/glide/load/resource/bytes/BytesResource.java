package com.bumptech.glide.load.resource.bytes;

import co.hyperverge.hypersnapsdk.c.k;
import com.bumptech.glide.load.engine.Resource;

public class BytesResource implements Resource<byte[]> {
    public final byte[] bytes;

    public BytesResource(byte[] bArr) {
        k.checkNotNull(bArr, (String) "Argument must not be null");
        this.bytes = bArr;
    }

    public Object get() {
        return this.bytes;
    }

    public Class<byte[]> getResourceClass() {
        return byte[].class;
    }

    public int getSize() {
        return this.bytes.length;
    }

    public void recycle() {
    }
}
