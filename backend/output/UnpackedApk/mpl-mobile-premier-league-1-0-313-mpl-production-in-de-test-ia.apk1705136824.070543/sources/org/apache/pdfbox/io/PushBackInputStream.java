package org.apache.pdfbox.io;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

public class PushBackInputStream extends PushbackInputStream {
    public long offset = 0;
    public final RandomAccessRead raInput;

    public PushBackInputStream(InputStream inputStream, int i) throws IOException {
        super(inputStream, i);
        if (inputStream != null) {
            this.raInput = inputStream instanceof RandomAccessRead ? (RandomAccessRead) inputStream : null;
            return;
        }
        throw new IOException("Error: input was null");
    }

    public void fillBuffer() throws IOException {
        int length = this.buf.length;
        byte[] bArr = new byte[length];
        int i = 0;
        int i2 = 0;
        while (i != -1 && i2 < length) {
            i = read(bArr, i2, length - i2);
            if (i != -1) {
                i2 += i;
            }
        }
        unread(bArr, 0, i2);
    }

    public long getOffset() {
        return this.offset;
    }

    public boolean isEOF() throws IOException {
        return peek() == -1;
    }

    public int peek() throws IOException {
        int read = read();
        if (read != -1) {
            unread(read);
        }
        return read;
    }

    public int read() throws IOException {
        int read = super.read();
        if (read != -1) {
            this.offset++;
        }
        return read;
    }

    public byte[] readFully(int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = read(bArr, i2, i - i2);
            if (read >= 0) {
                i2 += read;
            } else {
                throw new EOFException("Premature end of file");
            }
        }
        return bArr;
    }

    public void seek(long j) throws IOException {
        if (this.raInput != null) {
            int length = this.buf.length - this.pos;
            if (length > 0) {
                skip((long) length);
            }
            this.raInput.seek(j);
            this.offset = j;
            return;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Provided stream of type ");
        outline73.append(this.in.getClass().getSimpleName());
        outline73.append(" is not seekable.");
        throw new IOException(outline73.toString());
    }

    public void unread(int i) throws IOException {
        this.offset--;
        super.unread(i);
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public void unread(byte[] bArr) throws IOException {
        unread(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = super.read(bArr, i, i2);
        if (read != -1) {
            this.offset += (long) read;
        }
        return read;
    }

    public void unread(byte[] bArr, int i, int i2) throws IOException {
        if (i2 > 0) {
            this.offset -= (long) i2;
            super.unread(bArr, i, i2);
        }
    }
}
