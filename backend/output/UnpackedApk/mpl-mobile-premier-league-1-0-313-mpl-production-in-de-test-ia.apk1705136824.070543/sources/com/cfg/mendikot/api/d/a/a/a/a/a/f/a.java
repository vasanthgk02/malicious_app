package com.cfg.mendikot.api.d.a.a.a.a.a.f;

import com.cfg.mendikot.api.d.a.a.a.a.a.c;
import java.nio.charset.Charset;
import okio.Utf8;
import org.apache.fontbox.ttf.GlyfDescript;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;
import org.jboss.netty.handler.codec.http.HttpCodecUtil;

public class a extends b {
    public static final byte[] j = {13, 10};
    public static final byte[] k = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, BaseParser.ASCII_ZERO, 49, 50, 51, 52, 53, 54, 55, 56, BaseParser.ASCII_NINE, 43, 47};
    public static final byte[] l = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, BaseParser.ASCII_ZERO, 49, 50, 51, 52, 53, 54, 55, 56, BaseParser.ASCII_NINE, 45, 95};
    public static final byte[] m = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, Utf8.REPLACEMENT_BYTE, 52, 53, 54, 55, 56, BaseParser.ASCII_NINE, HttpCodecUtil.COLON, HttpCodecUtil.SEMICOLON, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 13, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 15, GlyfDescript.X_DUAL, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, Utf8.REPLACEMENT_BYTE, -1, 26, 27, 28, 29, 30, 31, 32, 33, HttpCodecUtil.DOUBLE_QUOTE, 35, 36, 37, 38, 39, 40, 41, 42, 43, HttpCodecUtil.COMMA, 45, 46, 47, BaseParser.ASCII_ZERO, 49, 50, 51};

    /* renamed from: f  reason: collision with root package name */
    public final byte[] f2257f;
    public final byte[] g = m;
    public final byte[] h;
    public final int i;

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0028 A[LOOP:0: B:1:0x000d->B:13:0x0028, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x002c A[EDGE_INSN: B:26:0x002c->B:15:0x002c ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a(int r9, byte[] r10, boolean r11) {
        /*
            r8 = this;
            int r0 = r10.length
            r1 = 3
            r2 = 4
            r8.<init>(r1, r2, r9, r0)
            byte[] r0 = m
            r8.g = r0
            int r0 = r10.length
            r1 = 0
            r3 = 0
        L_0x000d:
            r4 = 1
            if (r3 >= r0) goto L_0x002b
            byte r5 = r10[r3]
            byte r6 = r8.f2258a
            if (r6 == r5) goto L_0x002c
            if (r5 < 0) goto L_0x0024
            byte[] r6 = r8.g
            int r7 = r6.length
            if (r5 >= r7) goto L_0x0024
            byte r5 = r6[r5]
            r6 = -1
            if (r5 == r6) goto L_0x0024
            r5 = 1
            goto L_0x0025
        L_0x0024:
            r5 = 0
        L_0x0025:
            if (r5 == 0) goto L_0x0028
            goto L_0x002c
        L_0x0028:
            int r3 = r3 + 1
            goto L_0x000d
        L_0x002b:
            r4 = 0
        L_0x002c:
            if (r4 != 0) goto L_0x004d
            if (r9 <= 0) goto L_0x003e
            int r9 = r10.length
            int r9 = r9 + r2
            r8.i = r9
            int r9 = r10.length
            byte[] r9 = new byte[r9]
            r8.h = r9
            int r0 = r10.length
            java.lang.System.arraycopy(r10, r1, r9, r1, r0)
            goto L_0x0043
        L_0x003e:
            r8.i = r2
            r9 = 0
            r8.h = r9
        L_0x0043:
            if (r11 == 0) goto L_0x0048
            byte[] r9 = l
            goto L_0x004a
        L_0x0048:
            byte[] r9 = k
        L_0x004a:
            r8.f2257f = r9
            return
        L_0x004d:
            java.nio.charset.Charset r9 = com.cfg.mendikot.api.d.a.a.a.a.a.c.f2256a
            java.lang.String r11 = new java.lang.String
            r11.<init>(r10, r9)
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r10 = "lineSeparator must not contain base64 characters: ["
            java.lang.String r0 = "]"
            java.lang.String r10 = com.android.tools.r8.GeneratedOutlineSupport.outline52(r10, r11, r0)
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cfg.mendikot.api.d.a.a.a.a.a.f.a.<init>(int, byte[], boolean):void");
    }

    public static String d(byte[] bArr) {
        if (!(bArr == null || bArr.length == 0)) {
            a aVar = new a(0, j, false);
            int length = bArr.length;
            int i2 = aVar.f2259b;
            long j2 = ((long) (((length + i2) - 1) / i2)) * ((long) aVar.f2260c);
            int i3 = aVar.f2261d;
            if (i3 > 0) {
                long j3 = (long) i3;
                j2 += (((j2 + j3) - 1) / j3) * ((long) aVar.f2262e);
            }
            if (j2 > ((long) Integer.MAX_VALUE)) {
                throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + j2 + ") than the specified maximum size of " + Integer.MAX_VALUE);
            } else if (bArr.length != 0) {
                com.cfg.mendikot.api.d.a.a.a.a.a.f.b.a aVar2 = new com.cfg.mendikot.api.d.a.a.a.a.a.f.b.a();
                aVar.a(bArr, 0, bArr.length, aVar2);
                aVar.a(bArr, 0, -1, aVar2);
                int i4 = aVar2.f2265d - aVar2.f2266e;
                byte[] bArr2 = new byte[i4];
                if (aVar2.f2264c != null) {
                    int min = Math.min(i4, i4);
                    System.arraycopy(aVar2.f2264c, aVar2.f2266e, bArr2, 0, min);
                    int i5 = aVar2.f2266e + min;
                    aVar2.f2266e = i5;
                    if (i5 >= aVar2.f2265d) {
                        aVar2.f2264c = null;
                    }
                }
                bArr = bArr2;
            }
        }
        Charset charset = c.f2256a;
        if (bArr == null) {
            return null;
        }
        return new String(bArr, charset);
    }

    /* JADX WARNING: type inference failed for: r11v21 */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r11v2, types: [byte, int] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(byte[] r10, int r11, int r12, com.cfg.mendikot.api.d.a.a.a.a.a.f.b.a r13) {
        /*
            r9 = this;
            boolean r0 = r13.f2267f
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 0
            r1 = 1
            if (r12 >= 0) goto L_0x00bc
            r13.f2267f = r1
            int r10 = r13.h
            if (r10 != 0) goto L_0x0014
            int r10 = r9.f2261d
            if (r10 != 0) goto L_0x0014
            return
        L_0x0014:
            int r10 = r9.i
            byte[] r10 = r9.a(r10, r13)
            int r11 = r13.f2265d
            int r12 = r13.h
            if (r12 == 0) goto L_0x009d
            if (r12 == r1) goto L_0x006f
            r1 = 2
            if (r12 != r1) goto L_0x005a
            int r12 = r11 + 1
            r13.f2265d = r12
            byte[] r1 = r9.f2257f
            int r2 = r13.f2263a
            int r3 = r2 >> 10
            r3 = r3 & 63
            byte r3 = r1[r3]
            r10[r11] = r3
            int r3 = r12 + 1
            r13.f2265d = r3
            int r4 = r2 >> 4
            r4 = r4 & 63
            byte r4 = r1[r4]
            r10[r12] = r4
            int r12 = r3 + 1
            r13.f2265d = r12
            int r2 = r2 << 2
            r2 = r2 & 63
            byte r2 = r1[r2]
            r10[r3] = r2
            byte[] r2 = k
            if (r1 != r2) goto L_0x009d
            int r1 = r12 + 1
            r13.f2265d = r1
            byte r1 = r9.f2258a
            r10[r12] = r1
            goto L_0x009d
        L_0x005a:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "Impossible modulus "
            java.lang.StringBuilder r11 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r11)
            int r12 = r13.h
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        L_0x006f:
            int r12 = r11 + 1
            r13.f2265d = r12
            byte[] r1 = r9.f2257f
            int r2 = r13.f2263a
            int r3 = r2 >> 2
            r3 = r3 & 63
            byte r3 = r1[r3]
            r10[r11] = r3
            int r3 = r12 + 1
            r13.f2265d = r3
            int r2 = r2 << 4
            r2 = r2 & 63
            byte r2 = r1[r2]
            r10[r12] = r2
            byte[] r12 = k
            if (r1 != r12) goto L_0x009d
            int r12 = r3 + 1
            r13.f2265d = r12
            byte r1 = r9.f2258a
            r10[r3] = r1
            int r2 = r12 + 1
            r13.f2265d = r2
            r10[r12] = r1
        L_0x009d:
            int r12 = r13.g
            int r1 = r13.f2265d
            int r11 = r1 - r11
            int r11 = r11 + r12
            r13.g = r11
            int r12 = r9.f2261d
            if (r12 <= 0) goto L_0x0131
            if (r11 <= 0) goto L_0x0131
            byte[] r11 = r9.h
            int r12 = r11.length
            java.lang.System.arraycopy(r11, r0, r10, r1, r12)
            int r10 = r13.f2265d
            byte[] r11 = r9.h
            int r11 = r11.length
            int r10 = r10 + r11
            r13.f2265d = r10
            goto L_0x0131
        L_0x00bc:
            r2 = 0
        L_0x00bd:
            if (r2 >= r12) goto L_0x0131
            int r3 = r9.i
            byte[] r3 = r9.a(r3, r13)
            int r4 = r13.h
            int r4 = r4 + r1
            int r4 = r4 % 3
            r13.h = r4
            int r4 = r11 + 1
            byte r11 = r10[r11]
            if (r11 >= 0) goto L_0x00d4
            int r11 = r11 + 256
        L_0x00d4:
            int r5 = r13.f2263a
            int r5 = r5 << 8
            int r5 = r5 + r11
            r13.f2263a = r5
            int r11 = r13.h
            if (r11 != 0) goto L_0x012d
            int r11 = r13.f2265d
            int r6 = r11 + 1
            r13.f2265d = r6
            byte[] r7 = r9.f2257f
            int r8 = r5 >> 18
            r8 = r8 & 63
            byte r8 = r7[r8]
            r3[r11] = r8
            int r11 = r6 + 1
            r13.f2265d = r11
            int r8 = r5 >> 12
            r8 = r8 & 63
            byte r8 = r7[r8]
            r3[r6] = r8
            int r6 = r11 + 1
            r13.f2265d = r6
            int r8 = r5 >> 6
            r8 = r8 & 63
            byte r8 = r7[r8]
            r3[r11] = r8
            int r11 = r6 + 1
            r13.f2265d = r11
            r5 = r5 & 63
            byte r5 = r7[r5]
            r3[r6] = r5
            int r5 = r13.g
            int r5 = r5 + 4
            r13.g = r5
            int r6 = r9.f2261d
            if (r6 <= 0) goto L_0x012d
            if (r6 > r5) goto L_0x012d
            byte[] r5 = r9.h
            int r6 = r5.length
            java.lang.System.arraycopy(r5, r0, r3, r11, r6)
            int r11 = r13.f2265d
            byte[] r3 = r9.h
            int r3 = r3.length
            int r11 = r11 + r3
            r13.f2265d = r11
            r13.g = r0
        L_0x012d:
            int r2 = r2 + 1
            r11 = r4
            goto L_0x00bd
        L_0x0131:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cfg.mendikot.api.d.a.a.a.a.a.f.a.a(byte[], int, int, com.cfg.mendikot.api.d.a.a.a.a.a.f.b$a):void");
    }
}
