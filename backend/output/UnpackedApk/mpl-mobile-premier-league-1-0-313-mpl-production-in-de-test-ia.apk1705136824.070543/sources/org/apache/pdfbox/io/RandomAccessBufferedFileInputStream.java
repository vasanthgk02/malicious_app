package org.apache.pdfbox.io;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class RandomAccessBufferedFileInputStream extends InputStream implements RandomAccessRead {
    public byte[] curPage = new byte[this.pageSize];
    public long curPageOffset = -1;
    public final long fileLength;
    public long fileOffset = 0;
    public boolean isClosed;
    public byte[] lastRemovedCachePage = null;
    public int maxCachedPages = 1000;
    public int offsetWithinPage = 0;
    public final Map<Long, byte[]> pageCache = new LinkedHashMap<Long, byte[]>(this.maxCachedPages, 0.75f, true) {
        public static final long serialVersionUID = -6302488539257741101L;

        public boolean removeEldestEntry(Entry<Long, byte[]> entry) {
            boolean z = size() > RandomAccessBufferedFileInputStream.this.maxCachedPages;
            if (z) {
                RandomAccessBufferedFileInputStream.this.lastRemovedCachePage = entry.getValue();
            }
            return z;
        }
    };
    public long pageOffsetMask = (-1 << 12);
    public int pageSize = (1 << 12);
    public int pageSizeShift = 12;
    public final RandomAccessFile raFile;

    public RandomAccessBufferedFileInputStream(File file) throws IOException {
        this.raFile = new RandomAccessFile(file, "r");
        this.fileLength = file.length();
        seek(0);
    }

    private byte[] readPage() throws IOException {
        byte[] bArr = this.lastRemovedCachePage;
        if (bArr != null) {
            this.lastRemovedCachePage = null;
        } else {
            bArr = new byte[this.pageSize];
        }
        int i = 0;
        while (true) {
            int i2 = this.pageSize;
            if (i >= i2) {
                break;
            }
            int read = this.raFile.read(bArr, i, i2 - i);
            if (read < 0) {
                break;
            }
            i += read;
        }
        return bArr;
    }

    public int available() throws IOException {
        return (int) Math.min(this.fileLength - this.fileOffset, 2147483647L);
    }

    public void close() throws IOException {
        this.raFile.close();
        this.pageCache.clear();
        this.isClosed = true;
    }

    public long getFilePointer() {
        return this.fileOffset;
    }

    public long getPosition() {
        return this.fileOffset;
    }

    public boolean isClosed() {
        return this.isClosed;
    }

    public long length() throws IOException {
        return this.fileLength;
    }

    public int read() throws IOException {
        long j = this.fileOffset;
        if (j >= this.fileLength) {
            return -1;
        }
        if (this.offsetWithinPage == this.pageSize) {
            seek(j);
        }
        this.fileOffset++;
        byte[] bArr = this.curPage;
        int i = this.offsetWithinPage;
        this.offsetWithinPage = i + 1;
        return bArr[i] & 255;
    }

    public void seek(long j) throws IOException {
        long j2 = this.pageOffsetMask & j;
        if (j2 != this.curPageOffset) {
            byte[] bArr = this.pageCache.get(Long.valueOf(j2));
            if (bArr == null) {
                this.raFile.seek(j2);
                bArr = readPage();
                this.pageCache.put(Long.valueOf(j2), bArr);
            }
            this.curPageOffset = j2;
            this.curPage = bArr;
        }
        this.offsetWithinPage = (int) (j - this.curPageOffset);
        this.fileOffset = j;
    }

    public long skip(long j) throws IOException {
        long j2 = this.fileLength;
        long j3 = this.fileOffset;
        if (j2 - j3 < j) {
            j = j2 - j3;
        }
        int i = this.pageSize;
        if (j < ((long) i)) {
            int i2 = this.offsetWithinPage;
            if (((long) i2) + j <= ((long) i)) {
                this.offsetWithinPage = (int) (((long) i2) + j);
                this.fileOffset += j;
                return j;
            }
        }
        seek(this.fileOffset + j);
        return j;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        long j = this.fileOffset;
        if (j >= this.fileLength) {
            return -1;
        }
        if (this.offsetWithinPage == this.pageSize) {
            seek(j);
        }
        int min = Math.min(this.pageSize - this.offsetWithinPage, i2);
        long j2 = this.fileLength;
        long j3 = this.fileOffset;
        if (j2 - j3 < ((long) this.pageSize)) {
            min = Math.min(min, (int) (j2 - j3));
        }
        System.arraycopy(this.curPage, this.offsetWithinPage, bArr, i, min);
        this.offsetWithinPage += min;
        this.fileOffset += (long) min;
        return min;
    }
}
