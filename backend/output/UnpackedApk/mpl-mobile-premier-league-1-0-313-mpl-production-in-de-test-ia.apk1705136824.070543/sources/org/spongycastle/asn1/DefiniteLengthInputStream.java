package org.spongycastle.asn1;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import org.spongycastle.util.io.Streams;

public class DefiniteLengthInputStream extends LimitedInputStream {
    public static final byte[] EMPTY_BYTES = new byte[0];
    public final int _originalLength;
    public int _remaining;

    public DefiniteLengthInputStream(InputStream inputStream, int i) {
        super(inputStream, i);
        if (i >= 0) {
            this._originalLength = i;
            this._remaining = i;
            if (i == 0) {
                setParentEofDetect(true);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("negative lengths not allowed");
    }

    public int getRemaining() {
        return this._remaining;
    }

    public int read() throws IOException {
        if (this._remaining == 0) {
            return -1;
        }
        int read = this._in.read();
        if (read >= 0) {
            int i = this._remaining - 1;
            this._remaining = i;
            if (i == 0) {
                setParentEofDetect(true);
            }
            return read;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("DEF length ");
        outline73.append(this._originalLength);
        outline73.append(" object truncated by ");
        outline73.append(this._remaining);
        throw new EOFException(outline73.toString());
    }

    public byte[] toByteArray() throws IOException {
        int i = this._remaining;
        if (i == 0) {
            return EMPTY_BYTES;
        }
        byte[] bArr = new byte[i];
        int readFully = i - Streams.readFully(this._in, bArr, 0, i);
        this._remaining = readFully;
        if (readFully == 0) {
            setParentEofDetect(true);
            return bArr;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("DEF length ");
        outline73.append(this._originalLength);
        outline73.append(" object truncated by ");
        outline73.append(this._remaining);
        throw new EOFException(outline73.toString());
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this._remaining;
        if (i3 == 0) {
            return -1;
        }
        int read = this._in.read(bArr, i, Math.min(i2, i3));
        if (read >= 0) {
            int i4 = this._remaining - read;
            this._remaining = i4;
            if (i4 == 0) {
                setParentEofDetect(true);
            }
            return read;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("DEF length ");
        outline73.append(this._originalLength);
        outline73.append(" object truncated by ");
        outline73.append(this._remaining);
        throw new EOFException(outline73.toString());
    }
}
