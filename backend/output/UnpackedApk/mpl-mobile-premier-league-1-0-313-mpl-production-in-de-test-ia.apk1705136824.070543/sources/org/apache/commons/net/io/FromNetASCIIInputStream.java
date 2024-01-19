package org.apache.commons.net.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.io.UnsupportedEncodingException;

public final class FromNetASCIIInputStream extends PushbackInputStream {
    static final String _lineSeparator = System.getProperty("line.separator");
    static final byte[] _lineSeparatorBytes;
    static final boolean _noConversionRequired = _lineSeparator.equals("\r\n");
    private int __length = 0;

    static {
        try {
            _lineSeparatorBytes = _lineSeparator.getBytes("US-ASCII");
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("Broken JVM - cannot find US-ASCII charset!", e2);
        }
    }

    public static final boolean isConversionRequired() {
        return !_noConversionRequired;
    }

    public FromNetASCIIInputStream(InputStream inputStream) {
        super(inputStream, _lineSeparatorBytes.length + 1);
    }

    private int __read() throws IOException {
        int read = super.read();
        if (read == 13) {
            int read2 = super.read();
            if (read2 == 10) {
                unread(_lineSeparatorBytes);
                read = super.read();
                this.__length--;
            } else {
                if (read2 != -1) {
                    unread(read2);
                }
                return 13;
            }
        }
        return read;
    }

    public int read() throws IOException {
        if (_noConversionRequired) {
            return super.read();
        }
        return __read();
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        if (_noConversionRequired) {
            return super.read(bArr, i, i2);
        }
        if (i2 < 1) {
            return 0;
        }
        int available = available();
        if (i2 > available) {
            i2 = available;
        }
        this.__length = i2;
        if (this.__length < 1) {
            this.__length = 1;
        }
        int __read = __read();
        if (__read == -1) {
            return -1;
        }
        int i4 = __read;
        int i5 = i;
        while (true) {
            i3 = i5 + 1;
            bArr[i5] = (byte) i4;
            int i6 = this.__length - 1;
            this.__length = i6;
            if (i6 <= 0) {
                break;
            }
            i4 = __read();
            if (i4 == -1) {
                break;
            }
            i5 = i3;
        }
        return i3 - i;
    }

    public int available() throws IOException {
        if (this.in != null) {
            return (this.buf.length - this.pos) + this.in.available();
        }
        throw new IOException("Stream closed");
    }
}
