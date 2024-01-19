package org.apache.pdfbox.cos;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import org.apache.pdfbox.util.Charsets;
import org.apache.pdfbox.util.Hex;
import sfs2x.client.entities.invitation.InvitationReply;

public final class COSString extends COSBase {
    public static final boolean FORCE_PARSING = Boolean.getBoolean("org.apache.pdfbox.forceParsing");
    public byte[] bytes;
    public boolean forceHexForm;

    public COSString(byte[] bArr) {
        setValue(bArr);
    }

    public static COSString parseHex(String str) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        StringBuilder sb = new StringBuilder(str.trim());
        if (sb.length() % 2 != 0) {
            sb.append('0');
        }
        int length = sb.length();
        int i = 0;
        while (i < length) {
            int i2 = i + 2;
            try {
                byteArrayOutputStream.write(Integer.parseInt(sb.substring(i, i2), 16));
            } catch (NumberFormatException e2) {
                if (FORCE_PARSING) {
                    byteArrayOutputStream.write(63);
                } else {
                    throw new IOException(GeneratedOutlineSupport.outline50("Invalid hex string: ", str), e2);
                }
            }
            i = i2;
        }
        return new COSString(byteArrayOutputStream.toByteArray());
    }

    public Object accept(ICOSVisitor iCOSVisitor) throws IOException {
        return iCOSVisitor.visitFromString(this);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof COSString)) {
            return false;
        }
        COSString cOSString = (COSString) obj;
        if (!getString().equals(cOSString.getString()) || this.forceHexForm != cOSString.forceHexForm) {
            return false;
        }
        return true;
    }

    public String getASCII() {
        return new String(this.bytes, Charsets.US_ASCII);
    }

    public byte[] getBytes() {
        return this.bytes;
    }

    public boolean getForceHexForm() {
        return this.forceHexForm;
    }

    public String getString() {
        byte[] bArr = this.bytes;
        if (bArr.length > 2) {
            if ((bArr[0] & 255) == 254 && (bArr[1] & 255) == 255) {
                byte[] bArr2 = this.bytes;
                return new String(bArr2, 2, bArr2.length - 2, Charsets.UTF_16BE);
            }
            byte[] bArr3 = this.bytes;
            if ((bArr3[0] & 255) == 255 && (bArr3[1] & 255) == 254) {
                byte[] bArr4 = this.bytes;
                return new String(bArr4, 2, bArr4.length - 2, Charsets.UTF_16LE);
            }
        }
        return PDFDocEncoding.toString(this.bytes);
    }

    public int hashCode() {
        return Arrays.hashCode(this.bytes) + (this.forceHexForm ? 17 : 0);
    }

    public void setForceHexForm(boolean z) {
        this.forceHexForm = z;
    }

    public void setValue(byte[] bArr) {
        this.bytes = (byte[]) bArr.clone();
    }

    public String toHexString() {
        StringBuilder sb = new StringBuilder(this.bytes.length * 2);
        for (byte string : this.bytes) {
            sb.append(Hex.getString(string));
        }
        return sb.toString();
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("COSString{");
        outline73.append(getString());
        outline73.append("}");
        return outline73.toString();
    }

    public COSString(String str) {
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = true;
                break;
            } else if (!PDFDocEncoding.containsChar(charArray[i])) {
                break;
            } else {
                i++;
            }
        }
        if (z) {
            this.bytes = PDFDocEncoding.getBytes(str);
            return;
        }
        byte[] bytes2 = str.getBytes(Charsets.UTF_16BE);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bytes2.length + 2);
        byteArrayOutputStream.write(254);
        byteArrayOutputStream.write(InvitationReply.EXPIRED);
        try {
            byteArrayOutputStream.write(bytes2);
            this.bytes = byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }
}
