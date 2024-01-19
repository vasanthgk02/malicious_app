package org.spongycastle.bcpg;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import org.spongycastle.util.io.Streams;

public class BCPGInputStream extends InputStream {

    /* renamed from: in  reason: collision with root package name */
    public InputStream f6248in;
    public boolean next = false;
    public int nextB;

    public static class PartialInputStream extends InputStream {
        public int dataLength;

        /* renamed from: in  reason: collision with root package name */
        public BCPGInputStream f6249in;
        public boolean partial;

        public PartialInputStream(BCPGInputStream bCPGInputStream, boolean z, int i) {
            this.f6249in = bCPGInputStream;
            this.partial = z;
            this.dataLength = i;
        }

        public int available() throws IOException {
            int available = this.f6249in.available();
            int i = this.dataLength;
            if (available > i && i >= 0) {
                if (this.partial && i == 0) {
                    return 1;
                }
                available = this.dataLength;
            }
            return available;
        }

        public final int loadDataLength() throws IOException {
            int read = this.f6249in.read();
            if (read < 0) {
                return -1;
            }
            this.partial = false;
            if (read < 192) {
                this.dataLength = read;
            } else if (read <= 223) {
                this.dataLength = this.f6249in.read() + ((read - 192) << 8) + 192;
            } else if (read == 255) {
                this.dataLength = (this.f6249in.read() << 24) | (this.f6249in.read() << 16) | (this.f6249in.read() << 8) | this.f6249in.read();
            } else {
                this.partial = true;
                this.dataLength = 1 << (read & 31);
            }
            return this.dataLength;
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            do {
                int i3 = this.dataLength;
                if (i3 == 0) {
                    if (!this.partial) {
                        break;
                    }
                } else {
                    if (i3 <= i2 && i3 >= 0) {
                        i2 = i3;
                    }
                    int read = this.f6249in.read(bArr, i, i2);
                    if (read >= 0) {
                        this.dataLength -= read;
                        return read;
                    }
                    throw new EOFException("premature end of stream in PartialInputStream");
                }
            } while (loadDataLength() >= 0);
            return -1;
        }

        public int read() throws IOException {
            while (this.dataLength == 0) {
                if (this.partial) {
                    if (loadDataLength() < 0) {
                    }
                }
                return -1;
            }
            int read = this.f6249in.read();
            if (read >= 0) {
                this.dataLength--;
                return read;
            }
            throw new EOFException("premature end of stream in PartialInputStream");
        }
    }

    public BCPGInputStream(InputStream inputStream) {
        this.f6248in = inputStream;
    }

    public int available() throws IOException {
        return this.f6248in.available();
    }

    public void close() throws IOException {
        this.f6248in.close();
    }

    public int nextPacketTag() throws IOException {
        if (!this.next) {
            try {
                this.nextB = this.f6248in.read();
            } catch (EOFException unused) {
                this.nextB = -1;
            }
            this.next = true;
        }
        int i = this.nextB;
        if (i < 0) {
            return i;
        }
        int i2 = i & 63;
        if ((i & 64) == 0) {
            i2 >>= 2;
        }
        return i2;
    }

    public int read() throws IOException {
        if (!this.next) {
            return this.f6248in.read();
        }
        this.next = false;
        return this.nextB;
    }

    public void readFully(byte[] bArr, int i, int i2) throws IOException {
        if (Streams.readFully(this, bArr, i, i2) < i2) {
            throw new EOFException();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a4 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x011c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.spongycastle.bcpg.Packet readPacket() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.read()
            if (r0 >= 0) goto L_0x0008
            r0 = 0
            return r0
        L_0x0008:
            r1 = r0 & 128(0x80, float:1.8E-43)
            if (r1 == 0) goto L_0x013a
            r1 = r0 & 64
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0014
            r1 = 1
            goto L_0x0015
        L_0x0014:
            r1 = 0
        L_0x0015:
            if (r1 == 0) goto L_0x005e
            r0 = r0 & 63
            int r1 = r5.read()
            r3 = 192(0xc0, float:2.69E-43)
            if (r1 >= r3) goto L_0x0023
            goto L_0x00a0
        L_0x0023:
            r4 = 223(0xdf, float:3.12E-43)
            if (r1 > r4) goto L_0x0034
            java.io.InputStream r2 = r5.f6248in
            int r2 = r2.read()
            int r1 = r1 + -192
            int r1 = r1 << 8
            int r1 = r1 + r2
            int r1 = r1 + r3
            goto L_0x00a0
        L_0x0034:
            r3 = 255(0xff, float:3.57E-43)
            if (r1 != r3) goto L_0x0059
            java.io.InputStream r1 = r5.f6248in
            int r1 = r1.read()
            int r1 = r1 << 24
            java.io.InputStream r2 = r5.f6248in
            int r2 = r2.read()
            int r2 = r2 << 16
            r1 = r1 | r2
            java.io.InputStream r2 = r5.f6248in
            int r2 = r2.read()
            int r2 = r2 << 8
            r1 = r1 | r2
            java.io.InputStream r2 = r5.f6248in
            int r2 = r2.read()
            goto L_0x009a
        L_0x0059:
            r1 = r1 & 31
            int r3 = r2 << r1
            goto L_0x00a2
        L_0x005e:
            r1 = r0 & 3
            r0 = r0 & 63
            r4 = 2
            int r0 = r0 >> r4
            if (r1 == 0) goto L_0x009c
            if (r1 == r2) goto L_0x0090
            if (r1 == r4) goto L_0x0077
            r4 = 3
            if (r1 != r4) goto L_0x006e
            goto L_0x00a2
        L_0x006e:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "unknown length type encountered"
            r0.<init>(r1)
            throw r0
        L_0x0077:
            int r1 = r5.read()
            int r1 = r1 << 24
            int r2 = r5.read()
            int r2 = r2 << 16
            r1 = r1 | r2
            int r2 = r5.read()
            int r2 = r2 << 8
            r1 = r1 | r2
            int r2 = r5.read()
            goto L_0x009a
        L_0x0090:
            int r1 = r5.read()
            int r1 = r1 << 8
            int r2 = r5.read()
        L_0x009a:
            r1 = r1 | r2
            goto L_0x00a0
        L_0x009c:
            int r1 = r5.read()
        L_0x00a0:
            r3 = r1
            r2 = 0
        L_0x00a2:
            if (r3 != 0) goto L_0x00a8
            if (r2 == 0) goto L_0x00a8
            r1 = r5
            goto L_0x00b2
        L_0x00a8:
            org.spongycastle.bcpg.BCPGInputStream r1 = new org.spongycastle.bcpg.BCPGInputStream
            org.spongycastle.bcpg.BCPGInputStream$PartialInputStream r4 = new org.spongycastle.bcpg.BCPGInputStream$PartialInputStream
            r4.<init>(r5, r2, r3)
            r1.<init>(r4)
        L_0x00b2:
            switch(r0) {
                case 0: goto L_0x011c;
                case 1: goto L_0x0116;
                case 2: goto L_0x0110;
                case 3: goto L_0x010a;
                case 4: goto L_0x0104;
                case 5: goto L_0x00fe;
                case 6: goto L_0x00f8;
                case 7: goto L_0x00f2;
                case 8: goto L_0x00ec;
                case 9: goto L_0x00e6;
                case 10: goto L_0x00e0;
                case 11: goto L_0x00da;
                case 12: goto L_0x00d4;
                case 13: goto L_0x00ce;
                case 14: goto L_0x00c8;
                default: goto L_0x00b5;
            }
        L_0x00b5:
            switch(r0) {
                case 17: goto L_0x012e;
                case 18: goto L_0x0128;
                case 19: goto L_0x0122;
                default: goto L_0x00b8;
            }
        L_0x00b8:
            switch(r0) {
                case 60: goto L_0x0134;
                case 61: goto L_0x0134;
                case 62: goto L_0x0134;
                case 63: goto L_0x0134;
                default: goto L_0x00bb;
            }
        L_0x00bb:
            java.io.IOException r1 = new java.io.IOException
            java.lang.String r2 = "unknown packet type encountered: "
            java.lang.String r0 = com.android.tools.r8.GeneratedOutlineSupport.outline41(r2, r0)
            r1.<init>(r0)
            throw r1
        L_0x00c8:
            org.spongycastle.bcpg.PublicSubkeyPacket r0 = new org.spongycastle.bcpg.PublicSubkeyPacket
            r0.<init>(r1)
            return r0
        L_0x00ce:
            org.spongycastle.bcpg.UserIDPacket r0 = new org.spongycastle.bcpg.UserIDPacket
            r0.<init>(r1)
            return r0
        L_0x00d4:
            org.spongycastle.bcpg.TrustPacket r0 = new org.spongycastle.bcpg.TrustPacket
            r0.<init>(r1)
            return r0
        L_0x00da:
            org.spongycastle.bcpg.LiteralDataPacket r0 = new org.spongycastle.bcpg.LiteralDataPacket
            r0.<init>(r1)
            return r0
        L_0x00e0:
            org.spongycastle.bcpg.MarkerPacket r0 = new org.spongycastle.bcpg.MarkerPacket
            r0.<init>(r1)
            return r0
        L_0x00e6:
            org.spongycastle.bcpg.SymmetricEncDataPacket r0 = new org.spongycastle.bcpg.SymmetricEncDataPacket
            r0.<init>(r1)
            return r0
        L_0x00ec:
            org.spongycastle.bcpg.CompressedDataPacket r0 = new org.spongycastle.bcpg.CompressedDataPacket
            r0.<init>(r1)
            return r0
        L_0x00f2:
            org.spongycastle.bcpg.SecretSubkeyPacket r0 = new org.spongycastle.bcpg.SecretSubkeyPacket
            r0.<init>(r1)
            return r0
        L_0x00f8:
            org.spongycastle.bcpg.PublicKeyPacket r0 = new org.spongycastle.bcpg.PublicKeyPacket
            r0.<init>(r1)
            return r0
        L_0x00fe:
            org.spongycastle.bcpg.SecretKeyPacket r0 = new org.spongycastle.bcpg.SecretKeyPacket
            r0.<init>(r1)
            return r0
        L_0x0104:
            org.spongycastle.bcpg.OnePassSignaturePacket r0 = new org.spongycastle.bcpg.OnePassSignaturePacket
            r0.<init>(r1)
            return r0
        L_0x010a:
            org.spongycastle.bcpg.SymmetricKeyEncSessionPacket r0 = new org.spongycastle.bcpg.SymmetricKeyEncSessionPacket
            r0.<init>(r1)
            return r0
        L_0x0110:
            org.spongycastle.bcpg.SignaturePacket r0 = new org.spongycastle.bcpg.SignaturePacket
            r0.<init>(r1)
            return r0
        L_0x0116:
            org.spongycastle.bcpg.PublicKeyEncSessionPacket r0 = new org.spongycastle.bcpg.PublicKeyEncSessionPacket
            r0.<init>(r1)
            return r0
        L_0x011c:
            org.spongycastle.bcpg.InputStreamPacket r0 = new org.spongycastle.bcpg.InputStreamPacket
            r0.<init>(r1)
            return r0
        L_0x0122:
            org.spongycastle.bcpg.ModDetectionCodePacket r0 = new org.spongycastle.bcpg.ModDetectionCodePacket
            r0.<init>(r1)
            return r0
        L_0x0128:
            org.spongycastle.bcpg.SymmetricEncIntegrityPacket r0 = new org.spongycastle.bcpg.SymmetricEncIntegrityPacket
            r0.<init>(r1)
            return r0
        L_0x012e:
            org.spongycastle.bcpg.UserAttributePacket r0 = new org.spongycastle.bcpg.UserAttributePacket
            r0.<init>(r1)
            return r0
        L_0x0134:
            org.spongycastle.bcpg.ExperimentalPacket r2 = new org.spongycastle.bcpg.ExperimentalPacket
            r2.<init>(r0, r1)
            return r2
        L_0x013a:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "invalid header encountered"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.bcpg.BCPGInputStream.readPacket():org.spongycastle.bcpg.Packet");
    }

    public void readFully(byte[] bArr) throws IOException {
        readFully(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        if (!this.next) {
            return this.f6248in.read(bArr, i, i2);
        }
        int i3 = this.nextB;
        if (i3 < 0) {
            return -1;
        }
        bArr[i] = (byte) i3;
        this.next = false;
        return 1;
    }
}
