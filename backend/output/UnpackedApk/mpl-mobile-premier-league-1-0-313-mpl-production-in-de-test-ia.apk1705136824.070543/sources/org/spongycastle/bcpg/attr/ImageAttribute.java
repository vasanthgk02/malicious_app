package org.spongycastle.bcpg.attr;

import org.spongycastle.bcpg.UserAttributeSubpacket;

public class ImageAttribute extends UserAttributeSubpacket {
    public int hdrLength;
    public byte[] imageData;

    public ImageAttribute(boolean z, byte[] bArr) {
        super(1, z, bArr);
        byte b2 = ((bArr[1] & 255) << 8) | (bArr[0] & 255);
        this.hdrLength = b2;
        byte b3 = bArr[2];
        byte b4 = bArr[3];
        int length = bArr.length - b2;
        byte[] bArr2 = new byte[length];
        this.imageData = bArr2;
        System.arraycopy(bArr, b2, bArr2, 0, length);
    }
}
