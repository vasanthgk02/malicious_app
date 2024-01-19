package org.apache.pdfbox.io;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RandomAccessBuffer implements RandomAccess, Closeable, Cloneable {
    public static final int CHUNK_SIZE = 1024;
    public List<byte[]> bufferList = null;
    public int bufferListIndex;
    public int bufferListMaxIndex;
    public byte[] currentBuffer;
    public long currentBufferPointer;
    public long pointer;
    public long size;

    public RandomAccessBuffer() {
        ArrayList arrayList = new ArrayList();
        this.bufferList = arrayList;
        byte[] bArr = new byte[1024];
        this.currentBuffer = bArr;
        arrayList.add(bArr);
        this.pointer = 0;
        this.currentBufferPointer = 0;
        this.size = 0;
        this.bufferListIndex = 0;
        this.bufferListMaxIndex = 0;
    }

    private void checkClosed() throws IOException {
        if (this.currentBuffer == null) {
            throw new IOException("RandomAccessBuffer already closed");
        }
    }

    private void expandBuffer() {
        if (this.bufferListMaxIndex > this.bufferListIndex) {
            nextBuffer();
            return;
        }
        byte[] bArr = new byte[1024];
        this.currentBuffer = bArr;
        this.bufferList.add(bArr);
        this.currentBufferPointer = 0;
        this.bufferListMaxIndex++;
        this.bufferListIndex++;
    }

    private void nextBuffer() {
        this.currentBufferPointer = 0;
        List<byte[]> list = this.bufferList;
        int i = this.bufferListIndex + 1;
        this.bufferListIndex = i;
        this.currentBuffer = list.get(i);
    }

    public void close() throws IOException {
        this.currentBuffer = null;
        this.bufferList.clear();
        this.pointer = 0;
        this.currentBufferPointer = 0;
        this.size = 0;
        this.bufferListIndex = 0;
    }

    public long getPosition() throws IOException {
        checkClosed();
        return this.pointer;
    }

    public boolean isClosed() {
        return this.currentBuffer == null;
    }

    public long length() throws IOException {
        checkClosed();
        return this.size;
    }

    public int read() throws IOException {
        checkClosed();
        if (this.pointer >= this.size) {
            return -1;
        }
        if (this.currentBufferPointer >= 1024) {
            int i = this.bufferListIndex;
            if (i >= this.bufferListMaxIndex) {
                return -1;
            }
            List<byte[]> list = this.bufferList;
            int i2 = i + 1;
            this.bufferListIndex = i2;
            this.currentBuffer = list.get(i2);
            this.currentBufferPointer = 0;
        }
        this.pointer++;
        byte[] bArr = this.currentBuffer;
        long j = this.currentBufferPointer;
        this.currentBufferPointer = 1 + j;
        return bArr[(int) j] & 255;
    }

    public void seek(long j) throws IOException {
        checkClosed();
        this.pointer = j;
        int i = (int) (j / 1024);
        this.bufferListIndex = i;
        this.currentBufferPointer = j % 1024;
        this.currentBuffer = this.bufferList.get(i);
    }

    public void write(int i) throws IOException {
        checkClosed();
        if (this.currentBufferPointer >= 1024) {
            if (this.pointer + 1024 < 2147483647L) {
                expandBuffer();
            } else {
                throw new IOException("RandomAccessBuffer overflow");
            }
        }
        byte[] bArr = this.currentBuffer;
        long j = this.currentBufferPointer;
        this.currentBufferPointer = j + 1;
        bArr[(int) j] = (byte) i;
        long j2 = this.pointer + 1;
        this.pointer = j2;
        if (j2 > this.size) {
            this.size = j2;
        }
        if (this.currentBufferPointer < 1024) {
            return;
        }
        if (this.pointer + 1024 < 2147483647L) {
            expandBuffer();
            return;
        }
        throw new IOException("RandomAccessBuffer overflow");
    }

    public RandomAccessBuffer clone() {
        RandomAccessBuffer randomAccessBuffer = new RandomAccessBuffer();
        randomAccessBuffer.bufferList = new ArrayList(this.bufferList.size());
        for (byte[] next : this.bufferList) {
            byte[] bArr = new byte[next.length];
            System.arraycopy(next, 0, bArr, 0, next.length);
            randomAccessBuffer.bufferList.add(bArr);
        }
        if (this.currentBuffer != null) {
            randomAccessBuffer.currentBuffer = (byte[]) GeneratedOutlineSupport.outline29(randomAccessBuffer.bufferList, -1);
        } else {
            randomAccessBuffer.currentBuffer = null;
        }
        randomAccessBuffer.pointer = this.pointer;
        randomAccessBuffer.currentBufferPointer = this.currentBufferPointer;
        randomAccessBuffer.size = this.size;
        randomAccessBuffer.bufferListIndex = this.bufferListIndex;
        randomAccessBuffer.bufferListMaxIndex = this.bufferListMaxIndex;
        return randomAccessBuffer;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        checkClosed();
        long j = this.pointer;
        long j2 = this.size;
        if (j >= j2) {
            return 0;
        }
        long j3 = (long) i2;
        int min = (int) Math.min(j3, j2 - j);
        long j4 = this.currentBufferPointer;
        long j5 = 1024 - j4;
        long j6 = (long) min;
        if (j6 >= j5) {
            int i3 = (int) j4;
            int i4 = (int) j5;
            System.arraycopy(this.currentBuffer, i3, bArr, i, i4);
            int i5 = i + i4;
            long j7 = j3 - j5;
            int i6 = ((int) j7) / 1024;
            for (int i7 = 0; i7 < i6; i7++) {
                nextBuffer();
                System.arraycopy(this.currentBuffer, 0, bArr, i5, 1024);
                i5 += 1024;
            }
            long j8 = j7 % 1024;
            if (j8 > 0) {
                nextBuffer();
                System.arraycopy(this.currentBuffer, 0, bArr, i5, (int) j8);
                this.currentBufferPointer += j8;
            }
        } else {
            System.arraycopy(this.currentBuffer, (int) j4, bArr, i, min);
            this.currentBufferPointer += j6;
        }
        this.pointer += j6;
        return min;
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        checkClosed();
        long j = (long) i2;
        long j2 = this.pointer + j;
        long j3 = this.currentBufferPointer;
        long j4 = 1024 - j3;
        if (j < j4) {
            System.arraycopy(bArr, i, this.currentBuffer, (int) j3, i2);
            this.currentBufferPointer += j;
        } else if (j2 <= 2147483647L) {
            int i3 = (int) j4;
            System.arraycopy(bArr, i, this.currentBuffer, (int) j3, i3);
            int i4 = i + i3;
            long j5 = j - j4;
            int i5 = ((int) j5) / 1024;
            for (int i6 = 0; i6 < i5; i6++) {
                expandBuffer();
                System.arraycopy(bArr, i4, this.currentBuffer, (int) this.currentBufferPointer, 1024);
                i4 += 1024;
            }
            long j6 = j5 - (((long) i5) * 1024);
            int i7 = (j6 > 0 ? 1 : (j6 == 0 ? 0 : -1));
            if (i7 >= 0) {
                expandBuffer();
                if (i7 > 0) {
                    System.arraycopy(bArr, i4, this.currentBuffer, (int) this.currentBufferPointer, (int) j6);
                }
                this.currentBufferPointer = j6;
            }
        } else {
            throw new IOException("RandomAccessBuffer overflow");
        }
        long j7 = this.pointer + j;
        this.pointer = j7;
        if (j7 > this.size) {
            this.size = j7;
        }
    }
}
