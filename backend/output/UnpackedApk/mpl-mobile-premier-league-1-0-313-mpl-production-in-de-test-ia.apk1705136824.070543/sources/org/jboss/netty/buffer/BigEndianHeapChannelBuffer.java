package org.jboss.netty.buffer;

import java.nio.ByteOrder;
import org.apache.fontbox.ttf.GlyfDescript;

public class BigEndianHeapChannelBuffer extends HeapChannelBuffer {
    public BigEndianHeapChannelBuffer(int i) {
        super(i);
    }

    public ChannelBuffer copy(int i, int i2) {
        if (i >= 0 && i2 >= 0) {
            int i3 = i + i2;
            byte[] bArr = this.array;
            if (i3 <= bArr.length) {
                byte[] bArr2 = new byte[i2];
                System.arraycopy(bArr, i, bArr2, 0, i2);
                return new BigEndianHeapChannelBuffer(bArr2);
            }
        }
        throw new IndexOutOfBoundsException();
    }

    public ChannelBuffer duplicate() {
        return new BigEndianHeapChannelBuffer(this.array, readerIndex(), writerIndex());
    }

    public ChannelBufferFactory factory() {
        return HeapChannelBufferFactory.getInstance(ByteOrder.BIG_ENDIAN);
    }

    public int getInt(int i) {
        byte[] bArr = this.array;
        return ((bArr[i + 3] & 255) << 0) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << GlyfDescript.X_DUAL) | ((bArr[i + 2] & 255) << 8);
    }

    public long getLong(int i) {
        byte[] bArr = this.array;
        return ((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i + 1]) & 255) << 48) | ((((long) bArr[i + 2]) & 255) << 40) | ((((long) bArr[i + 3]) & 255) << 32) | ((((long) bArr[i + 4]) & 255) << 24) | ((((long) bArr[i + 5]) & 255) << 16) | ((((long) bArr[i + 6]) & 255) << 8) | ((255 & ((long) bArr[i + 7])) << 0);
    }

    public short getShort(int i) {
        byte[] bArr = this.array;
        return (short) ((bArr[i + 1] & 255) | (bArr[i] << 8));
    }

    public int getUnsignedMedium(int i) {
        byte[] bArr = this.array;
        return ((bArr[i + 2] & 255) << 0) | ((bArr[i] & 255) << GlyfDescript.X_DUAL) | ((bArr[i + 1] & 255) << 8);
    }

    public ByteOrder order() {
        return ByteOrder.BIG_ENDIAN;
    }

    public void setInt(int i, int i2) {
        byte[] bArr = this.array;
        bArr[i] = (byte) (i2 >>> 24);
        bArr[i + 1] = (byte) (i2 >>> 16);
        bArr[i + 2] = (byte) (i2 >>> 8);
        bArr[i + 3] = (byte) (i2 >>> 0);
    }

    public void setLong(int i, long j) {
        byte[] bArr = this.array;
        bArr[i] = (byte) ((int) (j >>> 56));
        bArr[i + 1] = (byte) ((int) (j >>> 48));
        bArr[i + 2] = (byte) ((int) (j >>> 40));
        bArr[i + 3] = (byte) ((int) (j >>> 32));
        bArr[i + 4] = (byte) ((int) (j >>> 24));
        bArr[i + 5] = (byte) ((int) (j >>> 16));
        bArr[i + 6] = (byte) ((int) (j >>> 8));
        bArr[i + 7] = (byte) ((int) (j >>> 0));
    }

    public void setMedium(int i, int i2) {
        byte[] bArr = this.array;
        bArr[i] = (byte) (i2 >>> 16);
        bArr[i + 1] = (byte) (i2 >>> 8);
        bArr[i + 2] = (byte) (i2 >>> 0);
    }

    public void setShort(int i, int i2) {
        byte[] bArr = this.array;
        bArr[i] = (byte) (i2 >>> 8);
        bArr[i + 1] = (byte) (i2 >>> 0);
    }

    public BigEndianHeapChannelBuffer(byte[] bArr) {
        super(bArr);
    }

    public BigEndianHeapChannelBuffer(byte[] bArr, int i, int i2) {
        super(bArr, i, i2);
    }
}
