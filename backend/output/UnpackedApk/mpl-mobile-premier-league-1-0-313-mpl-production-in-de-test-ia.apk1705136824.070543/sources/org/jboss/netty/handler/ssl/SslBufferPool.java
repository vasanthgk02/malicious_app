package org.jboss.netty.handler.ssl;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.nio.ByteBuffer;

public class SslBufferPool {
    public static final int DEFAULT_POOL_SIZE = 18113536;
    public static final int MAX_PACKET_SIZE = 17689;
    public int index;
    public final int maxBufferCount;
    public final ByteBuffer[] pool;

    public SslBufferPool() {
        this(DEFAULT_POOL_SIZE);
    }

    public synchronized ByteBuffer acquire() {
        try {
            if (this.index == 0) {
                return ByteBuffer.allocate(MAX_PACKET_SIZE);
            }
            ByteBuffer[] byteBufferArr = this.pool;
            int i = this.index - 1;
            this.index = i;
            return (ByteBuffer) byteBufferArr[i].clear();
        }
    }

    public int getMaxPoolSize() {
        return this.maxBufferCount * MAX_PACKET_SIZE;
    }

    public synchronized int getUnacquiredPoolSize() {
        return this.index * MAX_PACKET_SIZE;
    }

    public synchronized void release(ByteBuffer byteBuffer) {
        if (this.index < this.maxBufferCount) {
            ByteBuffer[] byteBufferArr = this.pool;
            int i = this.index;
            this.index = i + 1;
            byteBufferArr[i] = byteBuffer;
        }
    }

    public SslBufferPool(int i) {
        if (i > 0) {
            int i2 = i / MAX_PACKET_SIZE;
            i2 = i % MAX_PACKET_SIZE != 0 ? i2 + 1 : i2;
            this.pool = new ByteBuffer[i2];
            this.maxBufferCount = i2;
            return;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("maxPoolSize: ", i));
    }
}
