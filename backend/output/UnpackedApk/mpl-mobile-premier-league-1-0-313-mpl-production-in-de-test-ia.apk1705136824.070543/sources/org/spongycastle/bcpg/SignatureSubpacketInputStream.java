package org.spongycastle.bcpg;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public class SignatureSubpacketInputStream extends InputStream {

    /* renamed from: in  reason: collision with root package name */
    public InputStream f6252in;

    public SignatureSubpacketInputStream(InputStream inputStream) {
        this.f6252in = inputStream;
    }

    public int available() throws IOException {
        return this.f6252in.available();
    }

    public final byte[] checkData(byte[] bArr, int i, int i2, String str) throws EOFException {
        if (i2 == i) {
            int i3 = i + 0;
            if (i3 >= 0) {
                byte[] bArr2 = new byte[i3];
                if (bArr.length - 0 < i3) {
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length - 0);
                } else {
                    System.arraycopy(bArr, 0, bArr2, 0, i3);
                }
                return bArr2;
            }
            StringBuffer stringBuffer = new StringBuffer(0);
            stringBuffer.append(" > ");
            stringBuffer.append(i);
            throw new IllegalArgumentException(stringBuffer.toString());
        }
        throw new EOFException(GeneratedOutlineSupport.outline52("truncated ", str, " subpacket data."));
    }

    public int read() throws IOException {
        return this.f6252in.read();
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0106  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.spongycastle.bcpg.SignatureSubpacket readPacket() throws java.io.IOException {
        /*
            r12 = this;
            int r0 = r12.read()
            if (r0 >= 0) goto L_0x0008
            r0 = 0
            return r0
        L_0x0008:
            r1 = 16
            r2 = 1
            r3 = 8
            r4 = 192(0xc0, float:2.69E-43)
            r5 = 0
            if (r0 >= r4) goto L_0x0014
        L_0x0012:
            r4 = 0
            goto L_0x0049
        L_0x0014:
            r6 = 223(0xdf, float:3.12E-43)
            if (r0 > r6) goto L_0x0025
            int r0 = r0 + -192
            int r0 = r0 << r3
            java.io.InputStream r6 = r12.f6252in
            int r6 = r6.read()
            int r6 = r6 + r0
            int r0 = r6 + 192
            goto L_0x0012
        L_0x0025:
            r4 = 255(0xff, float:3.57E-43)
            if (r0 != r4) goto L_0x010f
            java.io.InputStream r0 = r12.f6252in
            int r0 = r0.read()
            int r0 = r0 << 24
            java.io.InputStream r4 = r12.f6252in
            int r4 = r4.read()
            int r4 = r4 << r1
            r0 = r0 | r4
            java.io.InputStream r4 = r12.f6252in
            int r4 = r4.read()
            int r4 = r4 << r3
            r0 = r0 | r4
            java.io.InputStream r4 = r12.f6252in
            int r4 = r4.read()
            r0 = r0 | r4
            r4 = 1
        L_0x0049:
            java.io.InputStream r6 = r12.f6252in
            int r6 = r6.read()
            if (r6 < 0) goto L_0x0106
            int r0 = r0 - r2
            byte[] r7 = new byte[r0]
            java.io.InputStream r8 = r12.f6252in
            int r8 = org.spongycastle.util.io.Streams.readFully(r8, r7, r5, r0)
            r9 = r6 & 128(0x80, float:1.8E-43)
            if (r9 == 0) goto L_0x005f
            goto L_0x0060
        L_0x005f:
            r2 = 0
        L_0x0060:
            r5 = r6 & 127(0x7f, float:1.78E-43)
            r6 = 9
            r9 = 3
            r10 = 2
            r11 = 4
            if (r8 == r0) goto L_0x0095
            if (r5 == r10) goto L_0x008f
            if (r5 == r9) goto L_0x0088
            if (r5 == r6) goto L_0x0081
            if (r5 != r1) goto L_0x0078
            java.lang.String r0 = "Issuer"
            byte[] r7 = r12.checkData(r7, r3, r8, r0)
            goto L_0x0095
        L_0x0078:
            java.io.EOFException r0 = new java.io.EOFException
            java.lang.String r1 = "truncated subpacket data."
            r0.<init>(r1)
            throw r0
        L_0x0081:
            java.lang.String r0 = "Signature Key Expiration Time"
            byte[] r7 = r12.checkData(r7, r11, r8, r0)
            goto L_0x0095
        L_0x0088:
            java.lang.String r0 = "Signature Expiration Time"
            byte[] r7 = r12.checkData(r7, r11, r8, r0)
            goto L_0x0095
        L_0x008f:
            java.lang.String r0 = "Signature Creation Time"
            byte[] r7 = r12.checkData(r7, r11, r8, r0)
        L_0x0095:
            if (r5 == r10) goto L_0x0100
            if (r5 == r9) goto L_0x00fa
            if (r5 == r11) goto L_0x00f4
            r0 = 5
            if (r5 == r0) goto L_0x00ee
            r0 = 7
            if (r5 == r0) goto L_0x00e8
            if (r5 == r6) goto L_0x00e2
            r0 = 11
            if (r5 == r0) goto L_0x00dc
            if (r5 == r1) goto L_0x00d6
            r0 = 25
            if (r5 == r0) goto L_0x00d0
            r0 = 27
            if (r5 == r0) goto L_0x00ca
            r0 = 28
            if (r5 == r0) goto L_0x00c4
            switch(r5) {
                case 20: goto L_0x00be;
                case 21: goto L_0x00dc;
                case 22: goto L_0x00dc;
                default: goto L_0x00b8;
            }
        L_0x00b8:
            org.spongycastle.bcpg.SignatureSubpacket r0 = new org.spongycastle.bcpg.SignatureSubpacket
            r0.<init>(r5, r2, r4, r7)
            return r0
        L_0x00be:
            org.spongycastle.bcpg.sig.NotationData r0 = new org.spongycastle.bcpg.sig.NotationData
            r0.<init>(r2, r4, r7)
            return r0
        L_0x00c4:
            org.spongycastle.bcpg.sig.SignerUserID r0 = new org.spongycastle.bcpg.sig.SignerUserID
            r0.<init>(r2, r4, r7)
            return r0
        L_0x00ca:
            org.spongycastle.bcpg.sig.KeyFlags r0 = new org.spongycastle.bcpg.sig.KeyFlags
            r0.<init>(r2, r4, r7)
            return r0
        L_0x00d0:
            org.spongycastle.bcpg.sig.PrimaryUserID r0 = new org.spongycastle.bcpg.sig.PrimaryUserID
            r0.<init>(r2, r4, r7)
            return r0
        L_0x00d6:
            org.spongycastle.bcpg.sig.IssuerKeyID r0 = new org.spongycastle.bcpg.sig.IssuerKeyID
            r0.<init>(r2, r4, r7)
            return r0
        L_0x00dc:
            org.spongycastle.bcpg.sig.PreferredAlgorithms r0 = new org.spongycastle.bcpg.sig.PreferredAlgorithms
            r0.<init>(r5, r2, r4, r7)
            return r0
        L_0x00e2:
            org.spongycastle.bcpg.sig.KeyExpirationTime r0 = new org.spongycastle.bcpg.sig.KeyExpirationTime
            r0.<init>(r2, r4, r7)
            return r0
        L_0x00e8:
            org.spongycastle.bcpg.sig.Revocable r0 = new org.spongycastle.bcpg.sig.Revocable
            r0.<init>(r2, r4, r7)
            return r0
        L_0x00ee:
            org.spongycastle.bcpg.sig.TrustSignature r0 = new org.spongycastle.bcpg.sig.TrustSignature
            r0.<init>(r2, r4, r7)
            return r0
        L_0x00f4:
            org.spongycastle.bcpg.sig.Exportable r0 = new org.spongycastle.bcpg.sig.Exportable
            r0.<init>(r2, r4, r7)
            return r0
        L_0x00fa:
            org.spongycastle.bcpg.sig.SignatureExpirationTime r0 = new org.spongycastle.bcpg.sig.SignatureExpirationTime
            r0.<init>(r2, r4, r7)
            return r0
        L_0x0100:
            org.spongycastle.bcpg.sig.SignatureCreationTime r0 = new org.spongycastle.bcpg.sig.SignatureCreationTime
            r0.<init>(r2, r4, r7)
            return r0
        L_0x0106:
            java.io.EOFException r0 = new java.io.EOFException
            java.lang.String r1 = "unexpected EOF reading signature sub packet"
            r0.<init>(r1)
            throw r0
        L_0x010f:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "unexpected length header"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.bcpg.SignatureSubpacketInputStream.readPacket():org.spongycastle.bcpg.SignatureSubpacket");
    }
}
