package org.spongycastle.bcpg;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import okio.Utf8;
import org.spongycastle.util.StringList;
import org.spongycastle.util.Strings;
import sfs2x.client.entities.invitation.InvitationReply;

public class ArmoredInputStream extends InputStream {
    public static final byte[] decodingTable = new byte[128];
    public int bufPtr = 3;
    public boolean clearText = false;
    public CRC24 crc = new CRC24();
    public boolean crcFound = false;
    public boolean hasHeaders = true;
    public String header = null;
    public StringList headerList = Strings.newList();

    /* renamed from: in  reason: collision with root package name */
    public InputStream f6247in;
    public int lastC = 0;
    public boolean newLineFound = false;
    public int[] outBuf = new int[3];
    public boolean restart = false;
    public boolean start = true;

    static {
        for (int i = 65; i <= 90; i++) {
            decodingTable[i] = (byte) (i - 65);
        }
        for (int i2 = 97; i2 <= 122; i2++) {
            decodingTable[i2] = (byte) ((i2 - 97) + 26);
        }
        for (int i3 = 48; i3 <= 57; i3++) {
            decodingTable[i3] = (byte) ((i3 - 48) + 52);
        }
        byte[] bArr = decodingTable;
        bArr[43] = 62;
        bArr[47] = Utf8.REPLACEMENT_BYTE;
    }

    public ArmoredInputStream(InputStream inputStream, boolean z) throws IOException {
        this.f6247in = inputStream;
        this.hasHeaders = z;
        if (z) {
            parseHeaders();
        }
        this.start = false;
    }

    public int available() throws IOException {
        return this.f6247in.available();
    }

    public void close() throws IOException {
        this.f6247in.close();
    }

    public final int decode(int i, int i2, int i3, int i4, int[] iArr) throws EOFException {
        if (i4 < 0) {
            throw new EOFException("unexpected end of file in armored stream.");
        } else if (i3 == 61) {
            byte[] bArr = decodingTable;
            iArr[2] = (((bArr[i] & 255) << 2) | ((bArr[i2] & 255) >> 4)) & InvitationReply.EXPIRED;
            return 2;
        } else if (i4 == 61) {
            byte[] bArr2 = decodingTable;
            byte b2 = bArr2[i];
            byte b3 = bArr2[i2];
            byte b4 = bArr2[i3];
            iArr[1] = ((b2 << 2) | (b3 >> 4)) & InvitationReply.EXPIRED;
            iArr[2] = ((b3 << 4) | (b4 >> 2)) & InvitationReply.EXPIRED;
            return 1;
        } else {
            byte[] bArr3 = decodingTable;
            byte b5 = bArr3[i];
            byte b6 = bArr3[i2];
            byte b7 = bArr3[i3];
            byte b8 = bArr3[i4];
            iArr[0] = ((b5 << 2) | (b6 >> 4)) & InvitationReply.EXPIRED;
            iArr[1] = ((b6 << 4) | (b7 >> 2)) & InvitationReply.EXPIRED;
            iArr[2] = ((b7 << 6) | b8) & 255;
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x009b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean parseHeaders() throws java.io.IOException {
        /*
            r12 = this;
            r0 = 0
            r12.header = r0
            org.spongycastle.util.StringList r0 = org.spongycastle.util.Strings.newList()
            r12.headerList = r0
            boolean r0 = r12.restart
            r1 = 1
            r2 = 0
            r3 = 45
            r4 = 10
            r5 = 13
            if (r0 == 0) goto L_0x0017
            r0 = 0
            goto L_0x0028
        L_0x0017:
            r0 = 0
        L_0x0018:
            java.io.InputStream r6 = r12.f6247in
            int r6 = r6.read()
            if (r6 < 0) goto L_0x002c
            if (r6 != r3) goto L_0x002a
            if (r0 == 0) goto L_0x0028
            if (r0 == r4) goto L_0x0028
            if (r0 != r5) goto L_0x002a
        L_0x0028:
            r6 = 1
            goto L_0x002d
        L_0x002a:
            r0 = r6
            goto L_0x0018
        L_0x002c:
            r6 = 0
        L_0x002d:
            if (r6 == 0) goto L_0x0091
            java.lang.StringBuffer r7 = new java.lang.StringBuffer
            java.lang.String r8 = "-"
            r7.<init>(r8)
            boolean r8 = r12.restart
            if (r8 == 0) goto L_0x003d
            r7.append(r3)
        L_0x003d:
            r3 = 0
            r8 = 0
        L_0x003f:
            java.io.InputStream r9 = r12.f6247in
            int r9 = r9.read()
            if (r9 < 0) goto L_0x008a
            if (r0 != r5) goto L_0x004c
            if (r9 != r4) goto L_0x004c
            r8 = 1
        L_0x004c:
            if (r3 == 0) goto L_0x0053
            if (r0 == r5) goto L_0x0053
            if (r9 != r4) goto L_0x0053
            goto L_0x008a
        L_0x0053:
            if (r3 == 0) goto L_0x0058
            if (r9 != r5) goto L_0x0058
            goto L_0x008a
        L_0x0058:
            if (r9 == r5) goto L_0x005e
            if (r0 == r5) goto L_0x0077
            if (r9 != r4) goto L_0x0077
        L_0x005e:
            java.lang.String r10 = r7.toString()
            java.lang.String r11 = r10.trim()
            int r11 = r11.length()
            if (r11 != 0) goto L_0x006d
            goto L_0x008a
        L_0x006d:
            org.spongycastle.util.StringList r11 = r12.headerList
            org.spongycastle.util.Strings$StringListImpl r11 = (org.spongycastle.util.Strings.StringListImpl) r11
            r11.add(r10)
            r7.setLength(r2)
        L_0x0077:
            if (r9 == r4) goto L_0x0081
            if (r9 == r5) goto L_0x0081
            char r0 = (char) r9
            r7.append(r0)
            r3 = 0
            goto L_0x0088
        L_0x0081:
            if (r9 == r5) goto L_0x0087
            if (r0 == r5) goto L_0x0088
            if (r9 != r4) goto L_0x0088
        L_0x0087:
            r3 = 1
        L_0x0088:
            r0 = r9
            goto L_0x003f
        L_0x008a:
            if (r8 == 0) goto L_0x0091
            java.io.InputStream r0 = r12.f6247in
            r0.read()
        L_0x0091:
            org.spongycastle.util.StringList r0 = r12.headerList
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x00a5
            org.spongycastle.util.StringList r0 = r12.headerList
            org.spongycastle.util.Strings$StringListImpl r0 = (org.spongycastle.util.Strings.StringListImpl) r0
            java.lang.String r0 = r0.get(r2)
            r12.header = r0
        L_0x00a5:
            java.lang.String r0 = r12.header
            java.lang.String r2 = "-----BEGIN PGP SIGNED MESSAGE-----"
            boolean r0 = r2.equals(r0)
            r12.clearText = r0
            r12.newLineFound = r1
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.bcpg.ArmoredInputStream.parseHeaders():boolean");
    }

    public int read() throws IOException {
        int read;
        if (this.start) {
            if (this.hasHeaders) {
                parseHeaders();
            }
            this.crc.crc = 11994318;
            this.start = false;
        }
        if (this.clearText) {
            int read2 = this.f6247in.read();
            if (read2 == 13 || (read2 == 10 && this.lastC != 13)) {
                this.newLineFound = true;
            } else if (this.newLineFound && read2 == 45) {
                read2 = this.f6247in.read();
                if (read2 == 45) {
                    this.clearText = false;
                    this.start = true;
                    this.restart = true;
                } else {
                    read2 = this.f6247in.read();
                }
                this.newLineFound = false;
            } else if (!(read2 == 10 || this.lastC == 13)) {
                this.newLineFound = false;
            }
            this.lastC = read2;
            return read2;
        }
        if (this.bufPtr > 2 || this.crcFound) {
            int readIgnoreSpace = readIgnoreSpace();
            if (readIgnoreSpace == 13 || readIgnoreSpace == 10) {
                int readIgnoreSpace2 = readIgnoreSpace();
                while (true) {
                    if (readIgnoreSpace2 != 10 && readIgnoreSpace2 != 13) {
                        break;
                    }
                    readIgnoreSpace2 = readIgnoreSpace();
                }
                if (readIgnoreSpace2 < 0) {
                    return -1;
                }
                if (readIgnoreSpace2 == 61) {
                    int decode = decode(readIgnoreSpace(), readIgnoreSpace(), readIgnoreSpace(), readIgnoreSpace(), this.outBuf);
                    this.bufPtr = decode;
                    if (decode == 0) {
                        int[] iArr = this.outBuf;
                        int i = (iArr[2] & InvitationReply.EXPIRED) | ((iArr[0] & InvitationReply.EXPIRED) << 16) | ((iArr[1] & InvitationReply.EXPIRED) << 8);
                        this.crcFound = true;
                        if (i == this.crc.crc) {
                            return read();
                        }
                        throw new IOException("crc check failed in armored message.");
                    }
                    throw new IOException("no crc found in armored message.");
                } else if (readIgnoreSpace2 == 45) {
                    do {
                        read = this.f6247in.read();
                        if (read < 0 || read == 10) {
                        }
                    } while (read != 13);
                    if (this.crcFound) {
                        this.crcFound = false;
                        this.start = true;
                        this.bufPtr = 3;
                        return -1;
                    }
                    throw new IOException("crc check not found.");
                } else {
                    this.bufPtr = decode(readIgnoreSpace2, readIgnoreSpace(), readIgnoreSpace(), readIgnoreSpace(), this.outBuf);
                }
            } else if (readIgnoreSpace < 0) {
                return -1;
            } else {
                this.bufPtr = decode(readIgnoreSpace, readIgnoreSpace(), readIgnoreSpace(), readIgnoreSpace(), this.outBuf);
            }
        }
        int[] iArr2 = this.outBuf;
        int i2 = this.bufPtr;
        this.bufPtr = i2 + 1;
        int i3 = iArr2[i2];
        CRC24 crc24 = this.crc;
        crc24.crc ^= i3 << 16;
        for (int i4 = 0; i4 < 8; i4++) {
            int i5 = crc24.crc << 1;
            crc24.crc = i5;
            if ((16777216 & i5) != 0) {
                crc24.crc = i5 ^ 25578747;
            }
        }
        return i3;
    }

    public final int readIgnoreSpace() throws IOException {
        int read = this.f6247in.read();
        while (true) {
            if (read != 32 && read != 9) {
                return read;
            }
            read = this.f6247in.read();
        }
    }
}
