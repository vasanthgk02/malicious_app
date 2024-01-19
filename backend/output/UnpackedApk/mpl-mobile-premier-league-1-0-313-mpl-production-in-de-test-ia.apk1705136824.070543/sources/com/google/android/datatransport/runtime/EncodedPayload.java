package com.google.android.datatransport.runtime;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.datatransport.Encoding;
import java.util.Arrays;

public final class EncodedPayload {
    public final byte[] bytes;
    public final Encoding encoding;

    public EncodedPayload(Encoding encoding2, byte[] bArr) {
        if (encoding2 == null) {
            throw new NullPointerException("encoding is null");
        } else if (bArr != null) {
            this.encoding = encoding2;
            this.bytes = bArr;
        } else {
            throw new NullPointerException("bytes is null");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EncodedPayload)) {
            return false;
        }
        EncodedPayload encodedPayload = (EncodedPayload) obj;
        if (!this.encoding.equals(encodedPayload.encoding)) {
            return false;
        }
        return Arrays.equals(this.bytes, encodedPayload.bytes);
    }

    public int hashCode() {
        return ((this.encoding.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.bytes);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("EncodedPayload{encoding=");
        outline73.append(this.encoding);
        outline73.append(", bytes=[...]}");
        return outline73.toString();
    }
}
