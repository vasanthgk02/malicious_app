package okio;

import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"okio/RealBufferedSource$inputStream$1", "Ljava/io/InputStream;", "available", "", "close", "", "read", "data", "", "offset", "byteCount", "toString", "", "okio"}, k = 1, mv = {1, 4, 1})
/* compiled from: RealBufferedSource.kt */
public final class RealBufferedSource$inputStream$1 extends InputStream {
    public final /* synthetic */ RealBufferedSource this$0;

    public RealBufferedSource$inputStream$1(RealBufferedSource realBufferedSource) {
        this.this$0 = realBufferedSource;
    }

    public int available() {
        RealBufferedSource realBufferedSource = this.this$0;
        if (!realBufferedSource.closed) {
            return (int) Math.min(realBufferedSource.bufferField.size(), (long) Integer.MAX_VALUE);
        }
        throw new IOException("closed");
    }

    public void close() {
        this.this$0.close();
    }

    public int read() {
        RealBufferedSource realBufferedSource = this.this$0;
        if (!realBufferedSource.closed) {
            if (realBufferedSource.bufferField.size() == 0) {
                RealBufferedSource realBufferedSource2 = this.this$0;
                if (realBufferedSource2.source.read(realBufferedSource2.bufferField, (long) 8192) == -1) {
                    return -1;
                }
            }
            return this.this$0.bufferField.readByte() & 255;
        }
        throw new IOException("closed");
    }

    public String toString() {
        return this.this$0 + ".inputStream()";
    }

    public int read(byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "data");
        if (!this.this$0.closed) {
            Util.checkOffsetAndCount((long) bArr.length, (long) i, (long) i2);
            if (this.this$0.bufferField.size() == 0) {
                RealBufferedSource realBufferedSource = this.this$0;
                if (realBufferedSource.source.read(realBufferedSource.bufferField, (long) 8192) == -1) {
                    return -1;
                }
            }
            return this.this$0.bufferField.read(bArr, i, i2);
        }
        throw new IOException("closed");
    }
}
