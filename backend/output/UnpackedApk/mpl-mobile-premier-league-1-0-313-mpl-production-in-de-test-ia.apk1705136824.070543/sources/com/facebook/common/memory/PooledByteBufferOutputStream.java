package com.facebook.common.memory;

import co.hyperverge.hypersnapsdk.c.k;
import java.io.IOException;
import java.io.OutputStream;

public abstract class PooledByteBufferOutputStream extends OutputStream {
    public void close() {
        try {
            super.close();
        } catch (IOException e2) {
            k.propagateIfPossible(e2);
            throw new RuntimeException(e2);
        }
    }

    public abstract int size();

    public abstract PooledByteBuffer toByteBuffer();
}
