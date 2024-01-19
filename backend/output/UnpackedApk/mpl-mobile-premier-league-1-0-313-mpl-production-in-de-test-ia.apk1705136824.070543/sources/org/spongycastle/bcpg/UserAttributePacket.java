package org.spongycastle.bcpg;

public class UserAttributePacket extends ContainedPacket {
    public UserAttributeSubpacket[] subpackets;

    /* JADX WARNING: Removed duplicated region for block: B:15:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00b7 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public UserAttributePacket(org.spongycastle.bcpg.BCPGInputStream r10) throws java.io.IOException {
        /*
            r9 = this;
            r9.<init>()
            org.spongycastle.bcpg.UserAttributeSubpacketInputStream r0 = new org.spongycastle.bcpg.UserAttributeSubpacketInputStream
            r0.<init>(r10)
            java.util.Vector r10 = new java.util.Vector
            r10.<init>()
        L_0x000d:
            int r1 = r0.read()
            r2 = 0
            if (r1 >= 0) goto L_0x0017
            r1 = 0
            goto L_0x0097
        L_0x0017:
            r3 = 192(0xc0, float:2.69E-43)
            r4 = 1
            if (r1 >= r3) goto L_0x001d
            goto L_0x002e
        L_0x001d:
            r5 = 223(0xdf, float:3.12E-43)
            if (r1 > r5) goto L_0x0030
            int r1 = r1 + -192
            int r1 = r1 << 8
            java.io.InputStream r5 = r0.f6253in
            int r5 = r5.read()
            int r5 = r5 + r1
            int r1 = r5 + 192
        L_0x002e:
            r3 = 0
            goto L_0x0056
        L_0x0030:
            r3 = 255(0xff, float:3.57E-43)
            if (r1 != r3) goto L_0x00c0
            java.io.InputStream r1 = r0.f6253in
            int r1 = r1.read()
            int r1 = r1 << 24
            java.io.InputStream r3 = r0.f6253in
            int r3 = r3.read()
            int r3 = r3 << 16
            r1 = r1 | r3
            java.io.InputStream r3 = r0.f6253in
            int r3 = r3.read()
            int r3 = r3 << 8
            r1 = r1 | r3
            java.io.InputStream r3 = r0.f6253in
            int r3 = r3.read()
            r1 = r1 | r3
            r3 = 1
        L_0x0056:
            java.io.InputStream r5 = r0.f6253in
            int r5 = r5.read()
            if (r5 < 0) goto L_0x00b7
            int r1 = r1 - r4
            byte[] r6 = new byte[r1]
            if (r1 <= 0) goto L_0x0076
            int r7 = r0.read()
            if (r7 < 0) goto L_0x0070
            byte r7 = (byte) r7
            r6[r2] = r7
            int r1 = r1 + -1
            r7 = 1
            goto L_0x0077
        L_0x0070:
            java.io.EOFException r10 = new java.io.EOFException
            r10.<init>()
            throw r10
        L_0x0076:
            r7 = 0
        L_0x0077:
            if (r1 <= 0) goto L_0x008a
            java.io.InputStream r8 = r0.f6253in
            int r8 = r8.read(r6, r7, r1)
            if (r8 < 0) goto L_0x0084
            int r7 = r7 + r8
            int r1 = r1 - r8
            goto L_0x0077
        L_0x0084:
            java.io.EOFException r10 = new java.io.EOFException
            r10.<init>()
            throw r10
        L_0x008a:
            if (r5 == r4) goto L_0x0092
            org.spongycastle.bcpg.UserAttributeSubpacket r1 = new org.spongycastle.bcpg.UserAttributeSubpacket
            r1.<init>(r5, r3, r6)
            goto L_0x0097
        L_0x0092:
            org.spongycastle.bcpg.attr.ImageAttribute r1 = new org.spongycastle.bcpg.attr.ImageAttribute
            r1.<init>(r3, r6)
        L_0x0097:
            if (r1 == 0) goto L_0x009e
            r10.addElement(r1)
            goto L_0x000d
        L_0x009e:
            int r0 = r10.size()
            org.spongycastle.bcpg.UserAttributeSubpacket[] r0 = new org.spongycastle.bcpg.UserAttributeSubpacket[r0]
            r9.subpackets = r0
        L_0x00a6:
            org.spongycastle.bcpg.UserAttributeSubpacket[] r0 = r9.subpackets
            int r1 = r0.length
            if (r2 == r1) goto L_0x00b6
            java.lang.Object r1 = r10.elementAt(r2)
            org.spongycastle.bcpg.UserAttributeSubpacket r1 = (org.spongycastle.bcpg.UserAttributeSubpacket) r1
            r0[r2] = r1
            int r2 = r2 + 1
            goto L_0x00a6
        L_0x00b6:
            return
        L_0x00b7:
            java.io.EOFException r10 = new java.io.EOFException
            java.lang.String r0 = "unexpected EOF reading user attribute sub packet"
            r10.<init>(r0)
            throw r10
        L_0x00c0:
            java.io.IOException r10 = new java.io.IOException
            java.lang.String r0 = "unrecognised length reading user attribute sub packet"
            r10.<init>(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.bcpg.UserAttributePacket.<init>(org.spongycastle.bcpg.BCPGInputStream):void");
    }
}
