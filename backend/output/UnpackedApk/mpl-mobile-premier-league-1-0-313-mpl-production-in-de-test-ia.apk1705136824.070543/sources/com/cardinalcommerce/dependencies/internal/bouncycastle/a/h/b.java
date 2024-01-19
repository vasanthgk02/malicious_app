package com.cardinalcommerce.dependencies.internal.bouncycastle.a.h;

import co.hyperverge.hypersnapsdk.c.k;
import com.cardinalcommerce.dependencies.internal.bouncycastle.a.e;
import com.cardinalcommerce.dependencies.internal.bouncycastle.a.h.a.a;
import com.cardinalcommerce.dependencies.internal.bouncycastle.a.y;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public e f1911a;

    /* renamed from: b  reason: collision with root package name */
    public com.cardinalcommerce.dependencies.internal.bouncycastle.a.h.a.e f1912b;

    /* renamed from: c  reason: collision with root package name */
    public a f1913c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1914d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1915e;

    /* renamed from: f  reason: collision with root package name */
    public int f1916f;
    public byte[] g;
    public byte[] h;
    public byte[] i;
    public byte[] j;
    public byte[] k;
    public byte[] l;
    public byte[] m;
    public byte[] n;
    public byte[] o;
    public byte[] p;
    public byte[] q;
    public int r;
    public int s;
    public long t;
    public byte[] u;
    public int v;
    public long w;
    public long x;

    public b(e eVar) {
        com.cardinalcommerce.dependencies.internal.bouncycastle.a.e.a aVar = (com.cardinalcommerce.dependencies.internal.bouncycastle.a.e.a) eVar;
        com.cardinalcommerce.dependencies.internal.bouncycastle.a.h.a.e eVar2 = new com.cardinalcommerce.dependencies.internal.bouncycastle.a.h.a.e();
        this.f1911a = eVar;
        this.f1912b = eVar2;
    }

    public int a(int i2) {
        int i3 = i2 + this.s;
        if (this.f1914d) {
            return i3 + this.f1916f;
        }
        int i4 = this.f1916f;
        return i3 < i4 ? 0 : i3 - i4;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01d5, code lost:
        if (r6 == 0) goto L_0x01da;
     */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x022a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int a(byte[] r32, int r33) {
        /*
            r31 = this;
            r0 = r31
            r1 = r32
            r2 = r33
            r31.b()
            long r3 = r0.t
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x0014
            r31.a()
        L_0x0014:
            int r3 = r0.s
            boolean r4 = r0.f1914d
            java.lang.String r7 = "Output buffer too short"
            if (r4 == 0) goto L_0x002a
            int r4 = r1.length
            int r4 = r4 - r2
            int r8 = r0.f1916f
            int r8 = r8 + r3
            if (r4 < r8) goto L_0x0024
            goto L_0x0033
        L_0x0024:
            com.cardinalcommerce.dependencies.internal.bouncycastle.a.y r1 = new com.cardinalcommerce.dependencies.internal.bouncycastle.a.y
            r1.<init>(r7)
            throw r1
        L_0x002a:
            int r4 = r0.f1916f
            if (r3 < r4) goto L_0x0238
            int r3 = r3 - r4
            int r4 = r1.length
            int r4 = r4 - r2
            if (r4 < r3) goto L_0x0232
        L_0x0033:
            r4 = 16
            r7 = 0
            if (r3 <= 0) goto L_0x005d
            byte[] r8 = r0.l
            byte[] r9 = new byte[r4]
            r0.a(r9)
            boolean r10 = r0.f1914d
            if (r10 == 0) goto L_0x004c
            co.hyperverge.hypersnapsdk.c.k.a(r8, r7, r9, r7, r3)
            byte[] r9 = r0.n
            r0.a(r9, r8, r7, r3)
            goto L_0x0054
        L_0x004c:
            byte[] r10 = r0.n
            r0.a(r10, r8, r7, r3)
            co.hyperverge.hypersnapsdk.c.k.a(r8, r7, r9, r7, r3)
        L_0x0054:
            java.lang.System.arraycopy(r8, r7, r1, r2, r3)
            long r8 = r0.t
            long r10 = (long) r3
            long r8 = r8 + r10
            r0.t = r8
        L_0x005d:
            long r8 = r0.w
            int r10 = r0.v
            long r11 = (long) r10
            long r8 = r8 + r11
            r0.w = r8
            long r11 = r0.x
            r14 = 8
            r16 = 1
            int r17 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r17 <= 0) goto L_0x0161
            if (r10 <= 0) goto L_0x0078
            byte[] r8 = r0.o
            byte[] r9 = r0.u
            r0.a(r8, r9, r7, r10)
        L_0x0078:
            long r8 = r0.x
            int r10 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r10 <= 0) goto L_0x0085
            byte[] r8 = r0.o
            byte[] r9 = r0.p
            co.hyperverge.hypersnapsdk.c.k.b(r8, r9)
        L_0x0085:
            long r8 = r0.t
            long r8 = r8 * r14
            r10 = 127(0x7f, double:6.27E-322)
            long r8 = r8 + r10
            r10 = 7
            long r8 = r8 >>> r10
            byte[] r11 = new byte[r4]
            com.cardinalcommerce.dependencies.internal.bouncycastle.a.h.a.a r12 = r0.f1913c
            if (r12 != 0) goto L_0x00a3
            com.cardinalcommerce.dependencies.internal.bouncycastle.a.h.a.a r12 = new com.cardinalcommerce.dependencies.internal.bouncycastle.a.h.a.a
            r12.<init>()
            r0.f1913c = r12
            byte[] r14 = r0.j
            long[] r14 = co.hyperverge.hypersnapsdk.c.k.a(r14)
            r12.f1908a = r14
        L_0x00a3:
            com.cardinalcommerce.dependencies.internal.bouncycastle.a.h.a.a r12 = r0.f1913c
            if (r12 == 0) goto L_0x015f
            r14 = 2
            long[] r15 = new long[r14]
            r18 = -9223372036854775808
            r15[r7] = r18
            int r18 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r18 <= 0) goto L_0x0129
            long[] r12 = r12.f1908a
            if (r12 != 0) goto L_0x00b8
            r4 = 0
            goto L_0x00bf
        L_0x00b8:
            int r4 = r12.length
            long[] r4 = new long[r4]
            int r13 = r12.length
            java.lang.System.arraycopy(r12, r7, r4, r7, r13)
        L_0x00bf:
            r12 = 1
            long r12 = r12 & r8
            int r20 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r20 == 0) goto L_0x00c9
            co.hyperverge.hypersnapsdk.c.k.b(r15, r4)
        L_0x00c9:
            r12 = 4
            long[] r12 = new long[r12]
            r5 = r4[r7]
            co.hyperverge.hypersnapsdk.c.k.b(r5, r12, r7)
            r5 = r4[r16]
            co.hyperverge.hypersnapsdk.c.k.b(r5, r12, r14)
            r5 = r12[r7]
            r21 = r12[r16]
            r23 = r12[r14]
            r13 = 3
            r25 = r12[r13]
            long r12 = r25 >>> r16
            long r12 = r12 ^ r25
            long r27 = r25 >>> r14
            long r12 = r12 ^ r27
            long r27 = r25 >>> r10
            long r12 = r12 ^ r27
            long r12 = r21 ^ r12
            r21 = 63
            long r27 = r25 << r21
            r22 = 62
            long r29 = r25 << r22
            long r27 = r27 ^ r29
            r29 = 57
            long r25 = r25 << r29
            long r25 = r25 ^ r27
            long r23 = r23 ^ r25
            long r25 = r23 >>> r16
            long r25 = r25 ^ r23
            long r27 = r23 >>> r14
            long r25 = r25 ^ r27
            long r27 = r23 >>> r10
            long r25 = r25 ^ r27
            long r5 = r5 ^ r25
            long r25 = r23 << r21
            long r21 = r23 << r22
            long r21 = r25 ^ r21
            long r23 = r23 << r29
            long r21 = r23 ^ r21
            long r12 = r12 ^ r21
            r4[r7] = r5
            r4[r16] = r12
            long r8 = r8 >>> r16
            r5 = 0
            int r12 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r12 > 0) goto L_0x0126
            goto L_0x0129
        L_0x0126:
            r5 = 0
            goto L_0x00bf
        L_0x0129:
            r4 = 0
            r5 = 0
        L_0x012b:
            if (r4 >= r14) goto L_0x0138
            r8 = r15[r4]
            co.hyperverge.hypersnapsdk.c.k.a(r8, r11, r5)
            r6 = 8
            int r5 = r5 + r6
            int r4 = r4 + 1
            goto L_0x012b
        L_0x0138:
            byte[] r4 = r0.o
            long[] r5 = co.hyperverge.hypersnapsdk.c.k.a(r4)
            long[] r6 = co.hyperverge.hypersnapsdk.c.k.a(r11)
            co.hyperverge.hypersnapsdk.c.k.b(r5, r6)
            r6 = 0
            r8 = 0
        L_0x0147:
            int r9 = r5.length
            if (r6 >= r9) goto L_0x0155
            r9 = r5[r6]
            co.hyperverge.hypersnapsdk.c.k.a(r9, r4, r8)
            r9 = 8
            int r8 = r8 + r9
            int r6 = r6 + 1
            goto L_0x0147
        L_0x0155:
            byte[] r4 = r0.n
            byte[] r5 = r0.o
            co.hyperverge.hypersnapsdk.c.k.b(r4, r5)
            r4 = 16
            goto L_0x0161
        L_0x015f:
            r4 = 0
            throw r4
        L_0x0161:
            byte[] r5 = new byte[r4]
            long r8 = r0.w
            r10 = 8
            long r8 = r8 * r10
            co.hyperverge.hypersnapsdk.c.k.a(r8, r5, r7)
            long r8 = r0.t
            long r8 = r8 * r10
            r6 = 8
            co.hyperverge.hypersnapsdk.c.k.a(r8, r5, r6)
            byte[] r6 = r0.n
            r0.a(r6, r5)
            byte[] r5 = new byte[r4]
            com.cardinalcommerce.dependencies.internal.bouncycastle.a.e r4 = r0.f1911a
            byte[] r6 = r0.k
            com.cardinalcommerce.dependencies.internal.bouncycastle.a.e.a r4 = (com.cardinalcommerce.dependencies.internal.bouncycastle.a.e.a) r4
            r4.a(r6, r7, r5, r7)
            byte[] r4 = r0.n
            co.hyperverge.hypersnapsdk.c.k.b(r5, r4)
            int r4 = r0.f1916f
            byte[] r6 = new byte[r4]
            r0.m = r6
            java.lang.System.arraycopy(r5, r7, r6, r7, r4)
            boolean r4 = r0.f1914d
            if (r4 == 0) goto L_0x01a5
            byte[] r4 = r0.m
            int r5 = r0.s
            int r2 = r2 + r5
            int r5 = r0.f1916f
            java.lang.System.arraycopy(r4, r7, r1, r2, r5)
            int r1 = r0.f1916f
            int r3 = r3 + r1
            goto L_0x01dc
        L_0x01a5:
            int r1 = r0.f1916f
            byte[] r2 = new byte[r1]
            byte[] r4 = r0.l
            java.lang.System.arraycopy(r4, r3, r2, r7, r1)
            byte[] r4 = r0.m
            if (r4 == 0) goto L_0x01d8
            if (r4 != r2) goto L_0x01b5
            goto L_0x01da
        L_0x01b5:
            int r5 = r4.length
            if (r5 >= r1) goto L_0x01ba
            int r5 = r4.length
            goto L_0x01bb
        L_0x01ba:
            r5 = r1
        L_0x01bb:
            int r6 = r4.length
            r6 = r6 ^ r1
            r8 = 0
        L_0x01be:
            if (r8 == r5) goto L_0x01c9
            byte r9 = r4[r8]
            byte r10 = r2[r8]
            r9 = r9 ^ r10
            r6 = r6 | r9
            int r8 = r8 + 1
            goto L_0x01be
        L_0x01c9:
            if (r5 >= r1) goto L_0x01d5
            byte r4 = r2[r5]
            byte r8 = r2[r5]
            int r8 = ~r8
            r4 = r4 ^ r8
            r6 = r6 | r4
            int r5 = r5 + 1
            goto L_0x01c9
        L_0x01d5:
            if (r6 != 0) goto L_0x01d8
            goto L_0x01da
        L_0x01d8:
            r16 = 0
        L_0x01da:
            if (r16 == 0) goto L_0x022a
        L_0x01dc:
            com.cardinalcommerce.dependencies.internal.bouncycastle.a.e r1 = r0.f1911a
            com.cardinalcommerce.dependencies.internal.bouncycastle.a.e.a r1 = (com.cardinalcommerce.dependencies.internal.bouncycastle.a.e.a) r1
            if (r1 == 0) goto L_0x0228
            r1 = 16
            byte[] r2 = new byte[r1]
            r0.n = r2
            byte[] r2 = new byte[r1]
            r0.o = r2
            byte[] r2 = new byte[r1]
            r0.p = r2
            byte[] r1 = new byte[r1]
            r0.u = r1
            r0.v = r7
            r1 = 0
            r0.w = r1
            r0.x = r1
            byte[] r4 = r0.k
            byte[] r4 = co.hyperverge.hypersnapsdk.c.k.b(r4)
            r0.q = r4
            r4 = -2
            r0.r = r4
            r0.s = r7
            r0.t = r1
            byte[] r1 = r0.l
            if (r1 == 0) goto L_0x0218
            r2 = 0
        L_0x0210:
            int r4 = r1.length
            if (r2 >= r4) goto L_0x0218
            r1[r2] = r7
            int r2 = r2 + 1
            goto L_0x0210
        L_0x0218:
            boolean r1 = r0.f1914d
            if (r1 == 0) goto L_0x021f
            r0.f1915e = r7
            goto L_0x0227
        L_0x021f:
            byte[] r1 = r0.i
            if (r1 == 0) goto L_0x0227
            int r2 = r1.length
            r0.a(r1, r7, r2)
        L_0x0227:
            return r3
        L_0x0228:
            r1 = 0
            throw r1
        L_0x022a:
            com.cardinalcommerce.dependencies.internal.bouncycastle.a.t r1 = new com.cardinalcommerce.dependencies.internal.bouncycastle.a.t
            java.lang.String r2 = "mac check in GCM failed"
            r1.<init>(r2)
            throw r1
        L_0x0232:
            com.cardinalcommerce.dependencies.internal.bouncycastle.a.y r1 = new com.cardinalcommerce.dependencies.internal.bouncycastle.a.y
            r1.<init>(r7)
            throw r1
        L_0x0238:
            com.cardinalcommerce.dependencies.internal.bouncycastle.a.t r1 = new com.cardinalcommerce.dependencies.internal.bouncycastle.a.t
            java.lang.String r2 = "data too short"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.dependencies.internal.bouncycastle.a.h.b.a(byte[], int):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0034 A[LOOP:1: B:12:0x0032->B:13:0x0034, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int a(byte[] r8, int r9, int r10, byte[] r11, int r12) {
        /*
            r7 = this;
            r7.b()
            int r0 = r8.length
            int r0 = r0 - r9
            if (r0 < r10) goto L_0x0076
            boolean r0 = r7.f1914d
            r1 = 0
            r2 = 16
            if (r0 == 0) goto L_0x004a
            int r0 = r7.s
            if (r0 == 0) goto L_0x0030
        L_0x0012:
            if (r10 <= 0) goto L_0x0030
            int r10 = r10 + -1
            byte[] r0 = r7.l
            int r3 = r7.s
            int r4 = r9 + 1
            byte r9 = r8[r9]
            r0[r3] = r9
            int r3 = r3 + 1
            r7.s = r3
            if (r3 != r2) goto L_0x002e
            r7.a(r0, r1, r11, r12)
            r7.s = r1
            r9 = 16
            goto L_0x0032
        L_0x002e:
            r9 = r4
            goto L_0x0012
        L_0x0030:
            r4 = r9
            r9 = 0
        L_0x0032:
            if (r10 < r2) goto L_0x0040
            int r0 = r12 + r9
            r7.a(r8, r4, r11, r0)
            int r4 = r4 + 16
            int r10 = r10 + -16
            int r9 = r9 + 16
            goto L_0x0032
        L_0x0040:
            if (r10 <= 0) goto L_0x0075
            byte[] r11 = r7.l
            java.lang.System.arraycopy(r8, r4, r11, r1, r10)
            r7.s = r10
            goto L_0x0075
        L_0x004a:
            r0 = 0
            r3 = 0
        L_0x004c:
            if (r3 >= r10) goto L_0x0074
            byte[] r4 = r7.l
            int r5 = r7.s
            int r6 = r9 + r3
            byte r6 = r8[r6]
            r4[r5] = r6
            int r5 = r5 + 1
            r7.s = r5
            int r6 = r4.length
            if (r5 != r6) goto L_0x0071
            int r5 = r12 + r0
            r7.a(r4, r1, r11, r5)
            byte[] r4 = r7.l
            int r5 = r7.f1916f
            java.lang.System.arraycopy(r4, r2, r4, r1, r5)
            int r4 = r7.f1916f
            r7.s = r4
            int r0 = r0 + 16
        L_0x0071:
            int r3 = r3 + 1
            goto L_0x004c
        L_0x0074:
            r9 = r0
        L_0x0075:
            return r9
        L_0x0076:
            com.cardinalcommerce.dependencies.internal.bouncycastle.a.m r8 = new com.cardinalcommerce.dependencies.internal.bouncycastle.a.m
            java.lang.String r9 = "Input buffer too short"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.dependencies.internal.bouncycastle.a.h.b.a(byte[], int, int, byte[], int):int");
    }

    public final void a() {
        if (this.w > 0) {
            System.arraycopy(this.o, 0, this.p, 0, 16);
            this.x = this.w;
        }
        int i2 = this.v;
        if (i2 > 0) {
            a(this.p, this.u, 0, i2);
            this.x += (long) this.v;
        }
        if (this.x > 0) {
            System.arraycopy(this.p, 0, this.n, 0, 16);
        }
    }

    public final void a(byte[] bArr) {
        int i2 = this.r;
        if (i2 != 0) {
            this.r = i2 - 1;
            byte[] bArr2 = this.q;
            int i3 = (bArr2[15] & 255) + 1;
            bArr2[15] = (byte) i3;
            int i4 = (i3 >>> 8) + (bArr2[14] & 255);
            bArr2[14] = (byte) i4;
            int i5 = (i4 >>> 8) + (bArr2[13] & 255);
            bArr2[13] = (byte) i5;
            bArr2[12] = (byte) ((i5 >>> 8) + (bArr2[12] & 255));
            ((com.cardinalcommerce.dependencies.internal.bouncycastle.a.e.a) this.f1911a).a(bArr2, 0, bArr, 0);
            return;
        }
        throw new IllegalStateException("Attempt to process too many blocks");
    }

    public void a(byte[] bArr, int i2, int i3) {
        b();
        for (int i4 = 0; i4 < i3; i4++) {
            byte[] bArr2 = this.u;
            int i5 = this.v;
            bArr2[i5] = bArr[i2 + i4];
            int i6 = i5 + 1;
            this.v = i6;
            if (i6 == 16) {
                a(this.o, bArr2);
                this.v = 0;
                this.w += 16;
            }
        }
    }

    public final void a(byte[] bArr, byte[] bArr2) {
        k.b(bArr, bArr2);
        this.f1912b.b(bArr);
    }

    public final void b() {
        if (this.f1915e) {
            return;
        }
        if (this.f1914d) {
            throw new IllegalStateException("GCM cipher cannot be reused for encryption");
        }
        throw new IllegalStateException("GCM cipher needs to be initialised");
    }

    public final void a(byte[] bArr, int i2, byte[] bArr2, int i3) {
        if (bArr2.length - i3 >= 16) {
            if (this.t == 0) {
                a();
            }
            byte[] bArr3 = new byte[16];
            a(bArr3);
            if (this.f1914d) {
                k.a(bArr3, bArr, i2);
                a(this.n, bArr3);
                System.arraycopy(bArr3, 0, bArr2, i3, 16);
            } else {
                byte[] bArr4 = this.n;
                k.a(bArr4, bArr, i2);
                this.f1912b.b(bArr4);
                int i4 = 0;
                do {
                    bArr2[i3 + i4] = (byte) (bArr3[0 + i4] ^ bArr[i2 + i4]);
                    int i5 = i4 + 1;
                    bArr2[i3 + i5] = (byte) (bArr3[0 + i5] ^ bArr[i2 + i5]);
                    int i6 = i5 + 1;
                    bArr2[i3 + i6] = (byte) (bArr3[0 + i6] ^ bArr[i2 + i6]);
                    int i7 = i6 + 1;
                    bArr2[i3 + i7] = (byte) (bArr3[0 + i7] ^ bArr[i2 + i7]);
                    i4 = i7 + 1;
                } while (i4 < 16);
            }
            this.t += 16;
            return;
        }
        throw new y("Output buffer too short");
    }

    public final void a(byte[] bArr, byte[] bArr2, int i2, int i3) {
        while (true) {
            i3--;
            if (i3 >= 0) {
                bArr[i3] = (byte) (bArr[i3] ^ bArr2[i2 + i3]);
            } else {
                this.f1912b.b(bArr);
                return;
            }
        }
    }
}
