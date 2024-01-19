package org.apache.pdfbox.filter;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class ASCII85InputStream extends FilterInputStream {
    public static final char NEWLINE = '\n';
    public static final char OFFSET = '!';
    public static final char PADDING_U = 'u';
    public static final char RETURN = '\r';
    public static final char SPACE = ' ';
    public static final char TERMINATOR = '~';
    public static final char Z = 'z';
    public byte[] ascii = new byte[5];

    /* renamed from: b  reason: collision with root package name */
    public byte[] f6149b = new byte[4];
    public boolean eof = false;
    public int index = 0;
    public int n = 0;

    public ASCII85InputStream(InputStream inputStream) {
        super(inputStream);
    }

    public int available() {
        return 0;
    }

    public void close() throws IOException {
        this.ascii = null;
        this.eof = true;
        this.f6149b = null;
        super.close();
    }

    public void mark(int i) {
    }

    public boolean markSupported() {
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0069, code lost:
        r13 = r14.ascii;
        r13[r2] = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x006d, code lost:
        if (r12 != 126) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x006f, code lost:
        r13[r2] = 117;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int read() throws java.io.IOException {
        /*
            r14 = this;
            int r0 = r14.index
            int r1 = r14.n
            if (r0 < r1) goto L_0x00cc
            boolean r0 = r14.eof
            r1 = -1
            if (r0 == 0) goto L_0x000c
            return r1
        L_0x000c:
            r0 = 0
            r14.index = r0
        L_0x000f:
            java.io.InputStream r2 = r14.in
            int r2 = r2.read()
            byte r2 = (byte) r2
            r3 = 1
            if (r2 != r1) goto L_0x001c
            r14.eof = r3
            return r1
        L_0x001c:
            byte r2 = (byte) r2
            r4 = 10
            if (r2 == r4) goto L_0x000f
            r5 = 13
            if (r2 == r5) goto L_0x000f
            r6 = 32
            if (r2 == r6) goto L_0x000f
            r7 = 126(0x7e, float:1.77E-43)
            r8 = 0
            if (r2 != r7) goto L_0x0037
            r14.eof = r3
            r14.f6149b = r8
            r14.ascii = r8
            r14.n = r0
            return r1
        L_0x0037:
            r9 = 122(0x7a, float:1.71E-43)
            r10 = 3
            if (r2 != r9) goto L_0x004c
            byte[] r1 = r14.f6149b
            r2 = 2
            r1[r10] = r0
            r1[r2] = r0
            r1[r3] = r0
            r1[r0] = r0
            r0 = 4
            r14.n = r0
            goto L_0x00cc
        L_0x004c:
            byte[] r9 = r14.ascii
            r9[r0] = r2
            r2 = 1
        L_0x0051:
            r9 = 117(0x75, float:1.64E-43)
            r11 = 5
            if (r2 >= r11) goto L_0x0075
        L_0x0056:
            java.io.InputStream r12 = r14.in
            int r12 = r12.read()
            byte r12 = (byte) r12
            if (r12 != r1) goto L_0x0062
            r14.eof = r3
            return r1
        L_0x0062:
            byte r12 = (byte) r12
            if (r12 == r4) goto L_0x0056
            if (r12 == r5) goto L_0x0056
            if (r12 == r6) goto L_0x0056
            byte[] r13 = r14.ascii
            r13[r2] = r12
            if (r12 != r7) goto L_0x0072
            r13[r2] = r9
            goto L_0x0075
        L_0x0072:
            int r2 = r2 + 1
            goto L_0x0051
        L_0x0075:
            int r4 = r2 + -1
            r14.n = r4
            if (r4 != 0) goto L_0x0082
            r14.eof = r3
            r14.ascii = r8
            r14.f6149b = r8
            return r1
        L_0x0082:
            if (r2 >= r11) goto L_0x0090
            int r2 = r2 + r3
        L_0x0085:
            if (r2 >= r11) goto L_0x008e
            byte[] r1 = r14.ascii
            r1[r2] = r9
            int r2 = r2 + 1
            goto L_0x0085
        L_0x008e:
            r14.eof = r3
        L_0x0090:
            r1 = 0
            r4 = 0
        L_0x0093:
            if (r4 >= r11) goto L_0x00bb
            byte[] r5 = r14.ascii
            byte r5 = r5[r4]
            int r5 = r5 + -33
            byte r5 = (byte) r5
            if (r5 < 0) goto L_0x00ab
            r6 = 93
            if (r5 > r6) goto L_0x00ab
            r6 = 85
            long r1 = r1 * r6
            long r5 = (long) r5
            long r1 = r1 + r5
            int r4 = r4 + 1
            goto L_0x0093
        L_0x00ab:
            r14.n = r0
            r14.eof = r3
            r14.ascii = r8
            r14.f6149b = r8
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "Invalid data in Ascii85 stream"
            r0.<init>(r1)
            throw r0
        L_0x00bb:
            if (r10 < 0) goto L_0x00cc
            byte[] r0 = r14.f6149b
            r3 = 255(0xff, double:1.26E-321)
            long r3 = r3 & r1
            int r4 = (int) r3
            byte r3 = (byte) r4
            r0[r10] = r3
            r0 = 8
            long r1 = r1 >>> r0
            int r10 = r10 + -1
            goto L_0x00bb
        L_0x00cc:
            byte[] r0 = r14.f6149b
            int r1 = r14.index
            int r2 = r1 + 1
            r14.index = r2
            byte r0 = r0[r1]
            r0 = r0 & 255(0xff, float:3.57E-43)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.pdfbox.filter.ASCII85InputStream.read():int");
    }

    public void reset() throws IOException {
        throw new IOException("Reset is not supported");
    }

    public long skip(long j) {
        return 0;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.eof && this.index >= this.n) {
            return -1;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = this.index;
            if (i4 < this.n) {
                byte[] bArr2 = this.f6149b;
                this.index = i4 + 1;
                bArr[i3 + i] = bArr2[i4];
            } else {
                int read = read();
                if (read == -1) {
                    return i3;
                }
                bArr[i3 + i] = (byte) read;
            }
        }
        return i2;
    }
}
