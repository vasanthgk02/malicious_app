package org.spongycastle.asn1;

import java.io.IOException;
import org.apache.commons.net.ftp.FTPReply;

public class DERBMPString extends ASN1Primitive {
    public final char[] string;

    public DERBMPString(char[] cArr) {
        this.string = cArr;
    }

    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        boolean z = false;
        if (!(aSN1Primitive instanceof DERBMPString)) {
            return false;
        }
        char[] cArr = this.string;
        char[] cArr2 = ((DERBMPString) aSN1Primitive).string;
        if (cArr != cArr2) {
            if (cArr != null && cArr2 != null && cArr.length == cArr2.length) {
                int i = 0;
                while (true) {
                    if (i == cArr.length) {
                        break;
                    } else if (cArr[i] != cArr2[i]) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
            return z;
        }
        z = true;
        return z;
    }

    public void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        aSN1OutputStream.write(30);
        aSN1OutputStream.writeLength(this.string.length * 2);
        int i = 0;
        while (true) {
            char[] cArr = this.string;
            if (i != cArr.length) {
                char c2 = cArr[i];
                aSN1OutputStream.write((byte) (c2 >> 8));
                aSN1OutputStream.write((byte) c2);
                i++;
            } else {
                return;
            }
        }
    }

    public int encodedLength() {
        return (this.string.length * 2) + StreamUtil.calculateBodyLength(this.string.length * 2) + 1;
    }

    public int hashCode() {
        char[] cArr = this.string;
        if (cArr == null) {
            return 0;
        }
        int length = cArr.length;
        int i = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return i;
            }
            i = (i * FTPReply.PATHNAME_CREATED) ^ cArr[length];
        }
    }

    public boolean isConstructed() {
        return false;
    }

    public String toString() {
        return new String(this.string);
    }
}
