package io.hansel.core.network.request.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import sfs2x.client.entities.invitation.InvitationReply;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public final int[] f5188a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f5189b;

    /* renamed from: c  reason: collision with root package name */
    public ByteBuffer f5190c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f5191d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f5192e;

    /* renamed from: f  reason: collision with root package name */
    public int f5193f;
    public int g;
    public d h;
    public short[] i;
    public byte[] j;
    public byte[] k;
    public byte[] l;
    public int[] m;
    public int n;
    public int o;
    public c p;
    public C0077a q;
    public Bitmap r;
    public boolean s;
    public int t;
    public int u;
    public int v;
    public int w;
    public boolean x;

    /* renamed from: io.hansel.core.network.request.a.a$a  reason: collision with other inner class name */
    public interface C0077a {
        Bitmap a(int i, int i2, Config config);

        byte[] a(int i);

        int[] b(int i);
    }

    public a() {
        this(new f());
    }

    public a(C0077a aVar) {
        this.f5188a = new int[256];
        this.f5193f = 0;
        this.g = 0;
        this.q = aVar;
        this.p = new c();
    }

    private int a(int i2, int i3, int i4) {
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = i2; i10 < this.u + i2; i10++) {
            byte[] bArr = this.l;
            if (i10 >= bArr.length || i10 >= i3) {
                break;
            }
            int i11 = this.f5189b[bArr[i10] & 255];
            if (i11 != 0) {
                i8 += (i11 >> 24) & InvitationReply.EXPIRED;
                i7 += (i11 >> 16) & InvitationReply.EXPIRED;
                i6 += (i11 >> 8) & InvitationReply.EXPIRED;
                i5 += i11 & InvitationReply.EXPIRED;
                i9++;
            }
        }
        int i12 = i2 + i4;
        for (int i13 = i12; i13 < this.u + i12; i13++) {
            byte[] bArr2 = this.l;
            if (i13 >= bArr2.length || i13 >= i3) {
                break;
            }
            int i14 = this.f5189b[bArr2[i13] & 255];
            if (i14 != 0) {
                i8 += (i14 >> 24) & InvitationReply.EXPIRED;
                i7 += (i14 >> 16) & InvitationReply.EXPIRED;
                i6 += (i14 >> 8) & InvitationReply.EXPIRED;
                i5 += i14 & InvitationReply.EXPIRED;
                i9++;
            }
        }
        if (i9 == 0) {
            return 0;
        }
        return ((i8 / i9) << 24) | ((i7 / i9) << 16) | ((i6 / i9) << 8) | (i5 / i9);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0029, code lost:
        if (r3.j == r1.h) goto L_0x0032;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Bitmap a(io.hansel.core.network.request.a.b r18, io.hansel.core.network.request.a.b r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            int[] r10 = r0.m
            r11 = 0
            if (r2 != 0) goto L_0x000e
            java.util.Arrays.fill(r10, r11)
        L_0x000e:
            r12 = 3
            r13 = 2
            r14 = 1
            if (r2 == 0) goto L_0x005e
            int r3 = r2.g
            if (r3 <= 0) goto L_0x005e
            if (r3 != r13) goto L_0x0037
            boolean r3 = r1.f5199f
            if (r3 != 0) goto L_0x002c
            io.hansel.core.network.request.a.c r3 = r0.p
            int r4 = r3.l
            int[] r5 = r1.k
            if (r5 == 0) goto L_0x0033
            int r3 = r3.j
            int r5 = r1.h
            if (r3 != r5) goto L_0x0033
            goto L_0x0032
        L_0x002c:
            int r3 = r0.n
            if (r3 != 0) goto L_0x0032
            r0.x = r14
        L_0x0032:
            r4 = 0
        L_0x0033:
            r0.a(r10, r2, r4)
            goto L_0x005e
        L_0x0037:
            if (r3 != r12) goto L_0x005e
            android.graphics.Bitmap r3 = r0.r
            if (r3 != 0) goto L_0x0041
            r0.a(r10, r2, r11)
            goto L_0x005e
        L_0x0041:
            int r4 = r2.f5197d
            int r5 = r0.u
            int r9 = r4 / r5
            int r4 = r2.f5195b
            int r7 = r4 / r5
            int r4 = r2.f5196c
            int r8 = r4 / r5
            int r2 = r2.f5194a
            int r6 = r2 / r5
            int r5 = r0.w
            int r2 = r7 * r5
            int r4 = r2 + r6
            r2 = r3
            r3 = r10
            r2.getPixels(r3, r4, r5, r6, r7, r8, r9)
        L_0x005e:
            r17.a(r18)
            int r2 = r1.f5197d
            int r3 = r0.u
            int r2 = r2 / r3
            int r4 = r1.f5195b
            int r4 = r4 / r3
            int r5 = r1.f5196c
            int r5 = r5 / r3
            int r6 = r1.f5194a
            int r6 = r6 / r3
            r3 = 8
            int r7 = r0.n
            if (r7 != 0) goto L_0x0077
            r7 = 1
            goto L_0x0078
        L_0x0077:
            r7 = 0
        L_0x0078:
            r8 = 0
            r9 = 1
        L_0x007a:
            if (r11 >= r2) goto L_0x00fc
            boolean r15 = r1.f5198e
            if (r15 == 0) goto L_0x0096
            r15 = 4
            if (r8 < r2) goto L_0x0093
            int r9 = r9 + 1
            if (r9 == r13) goto L_0x0092
            if (r9 == r12) goto L_0x008f
            if (r9 == r15) goto L_0x008c
            goto L_0x0093
        L_0x008c:
            r3 = 2
            r8 = 1
            goto L_0x0093
        L_0x008f:
            r3 = 4
            r8 = 2
            goto L_0x0093
        L_0x0092:
            r8 = 4
        L_0x0093:
            int r15 = r8 + r3
            goto L_0x0098
        L_0x0096:
            r15 = r8
            r8 = r11
        L_0x0098:
            int r8 = r8 + r4
            int r12 = r0.v
            if (r8 >= r12) goto L_0x00ec
            int r12 = r0.w
            int r8 = r8 * r12
            int r16 = r8 + r6
            int r13 = r16 + r5
            int r8 = r8 + r12
            if (r8 >= r13) goto L_0x00a9
            r13 = r8
        L_0x00a9:
            int r8 = r0.u
            int r12 = r11 * r8
            int r14 = r1.f5196c
            int r12 = r12 * r14
            int r14 = r13 - r16
            int r14 = r14 * r8
            int r14 = r14 + r12
            r8 = r16
        L_0x00b8:
            if (r8 >= r13) goto L_0x00ec
            r19 = r2
            int r2 = r0.u
            r16 = r3
            r3 = 1
            if (r2 != r3) goto L_0x00ce
            byte[] r2 = r0.l
            byte r2 = r2[r12]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int[] r3 = r0.f5189b
            r2 = r3[r2]
            goto L_0x00d4
        L_0x00ce:
            int r2 = r1.f5196c
            int r2 = r0.a(r12, r14, r2)
        L_0x00d4:
            if (r2 == 0) goto L_0x00d9
            r10[r8] = r2
            goto L_0x00e2
        L_0x00d9:
            boolean r2 = r0.x
            if (r2 != 0) goto L_0x00e2
            if (r7 == 0) goto L_0x00e2
            r2 = 1
            r0.x = r2
        L_0x00e2:
            int r2 = r0.u
            int r12 = r12 + r2
            int r8 = r8 + 1
            r2 = r19
            r3 = r16
            goto L_0x00b8
        L_0x00ec:
            r19 = r2
            r16 = r3
            int r11 = r11 + 1
            r2 = r19
            r8 = r15
            r3 = r16
            r12 = 3
            r13 = 2
            r14 = 1
            goto L_0x007a
        L_0x00fc:
            boolean r2 = r0.s
            if (r2 == 0) goto L_0x011f
            int r1 = r1.g
            if (r1 == 0) goto L_0x0107
            r2 = 1
            if (r1 != r2) goto L_0x011f
        L_0x0107:
            android.graphics.Bitmap r1 = r0.r
            if (r1 != 0) goto L_0x0111
            android.graphics.Bitmap r1 = r17.f()
            r0.r = r1
        L_0x0111:
            android.graphics.Bitmap r1 = r0.r
            int r7 = r0.w
            int r8 = r0.v
            r3 = 0
            r5 = 0
            r6 = 0
            r2 = r10
            r4 = r7
            r1.setPixels(r2, r3, r4, r5, r6, r7, r8)
        L_0x011f:
            android.graphics.Bitmap r9 = r17.f()
            int r7 = r0.w
            int r8 = r0.v
            r3 = 0
            r5 = 0
            r6 = 0
            r1 = r9
            r2 = r10
            r4 = r7
            r1.setPixels(r2, r3, r4, r5, r6, r7, r8)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.hansel.core.network.request.a.a.a(io.hansel.core.network.request.a.b, io.hansel.core.network.request.a.b):android.graphics.Bitmap");
    }

    public static void a(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
    }

    /* JADX WARNING: type inference failed for: r19v0 */
    /* JADX WARNING: type inference failed for: r19v1 */
    /* JADX WARNING: type inference failed for: r5v2 */
    /* JADX WARNING: type inference failed for: r5v3, types: [int] */
    /* JADX WARNING: type inference failed for: r19v2 */
    /* JADX WARNING: type inference failed for: r19v3 */
    /* JADX WARNING: type inference failed for: r14v4 */
    /* JADX WARNING: type inference failed for: r5v6 */
    /* JADX WARNING: type inference failed for: r4v9 */
    /* JADX WARNING: type inference failed for: r19v4 */
    /* JADX WARNING: type inference failed for: r1v17 */
    /* JADX WARNING: type inference failed for: r25v0 */
    /* JADX WARNING: type inference failed for: r4v11 */
    /* JADX WARNING: type inference failed for: r25v1 */
    /* JADX WARNING: type inference failed for: r1v25, types: [short[]] */
    /* JADX WARNING: type inference failed for: r5v12, types: [short] */
    /* JADX WARNING: type inference failed for: r1v26 */
    /* JADX WARNING: type inference failed for: r4v15 */
    /* JADX WARNING: type inference failed for: r5v17 */
    /* JADX WARNING: type inference failed for: r4v16 */
    /* JADX WARNING: type inference failed for: r19v5 */
    /* JADX WARNING: type inference failed for: r5v18 */
    /* JADX WARNING: type inference failed for: r19v6 */
    /* JADX WARNING: type inference failed for: r14v6 */
    /* JADX WARNING: type inference failed for: r5v19 */
    /* JADX WARNING: type inference failed for: r4v18 */
    /* JADX WARNING: type inference failed for: r5v20 */
    /* JADX WARNING: type inference failed for: r4v19 */
    /* JADX WARNING: type inference failed for: r4v20 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r19v3
      assigns: []
      uses: []
      mth insns count: 189
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x013c A[LOOP:4: B:58:0x013a->B:59:0x013c, LOOP_END] */
    /* JADX WARNING: Unknown variable types count: 10 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(io.hansel.core.network.request.a.b r28) {
        /*
            r27 = this;
            r0 = r27
            r1 = r28
            r2 = 0
            r0.f5193f = r2
            r0.g = r2
            if (r1 == 0) goto L_0x0012
            java.nio.ByteBuffer r3 = r0.f5190c
            int r4 = r1.j
            r3.position(r4)
        L_0x0012:
            if (r1 != 0) goto L_0x001b
            io.hansel.core.network.request.a.c r1 = r0.p
            int r3 = r1.f5205f
            int r1 = r1.g
            goto L_0x001f
        L_0x001b:
            int r3 = r1.f5196c
            int r1 = r1.f5197d
        L_0x001f:
            int r3 = r3 * r1
            byte[] r1 = r0.l
            if (r1 == 0) goto L_0x0028
            int r1 = r1.length
            if (r1 >= r3) goto L_0x0030
        L_0x0028:
            io.hansel.core.network.request.a.a$a r1 = r0.q
            byte[] r1 = r1.a(r3)
            r0.l = r1
        L_0x0030:
            short[] r1 = r0.i
            r4 = 4096(0x1000, float:5.74E-42)
            if (r1 != 0) goto L_0x003a
            short[] r1 = new short[r4]
            r0.i = r1
        L_0x003a:
            byte[] r1 = r0.j
            if (r1 != 0) goto L_0x0042
            byte[] r1 = new byte[r4]
            r0.j = r1
        L_0x0042:
            byte[] r1 = r0.k
            if (r1 != 0) goto L_0x004c
            r1 = 4097(0x1001, float:5.741E-42)
            byte[] r1 = new byte[r1]
            r0.k = r1
        L_0x004c:
            int r1 = r27.j()
            r5 = 1
            int r6 = r5 << r1
            int r7 = r6 + 1
            int r8 = r6 + 2
            int r1 = r1 + r5
            int r9 = r5 << r1
            int r9 = r9 - r5
            r10 = 0
        L_0x005c:
            if (r10 >= r6) goto L_0x006a
            short[] r11 = r0.i
            r11[r10] = r2
            byte[] r11 = r0.j
            byte r12 = (byte) r10
            r11[r10] = r12
            int r10 = r10 + 1
            goto L_0x005c
        L_0x006a:
            r10 = -1
            r20 = r1
            r22 = r8
            r21 = r9
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = -1
            r18 = 0
            r19 = 0
        L_0x007e:
            if (r11 >= r3) goto L_0x0166
            r2 = 3
            if (r12 != 0) goto L_0x008e
            int r12 = r27.i()
            if (r12 > 0) goto L_0x008d
            r0.t = r2
            goto L_0x0166
        L_0x008d:
            r15 = 0
        L_0x008e:
            byte[] r4 = r0.f5191d
            byte r4 = r4[r15]
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r4 = r4 << r14
            int r13 = r13 + r4
            int r14 = r14 + 8
            int r15 = r15 + r5
            int r12 = r12 + r10
            r4 = r17
            r5 = r19
            r10 = r20
            r2 = r22
        L_0x00a2:
            if (r14 < r10) goto L_0x0157
            r22 = r1
            r1 = r13 & r21
            int r13 = r13 >> r10
            int r14 = r14 - r10
            if (r1 != r6) goto L_0x00b4
            r2 = r8
            r21 = r9
            r1 = r22
            r10 = r1
            r4 = -1
            goto L_0x00a2
        L_0x00b4:
            r23 = r8
            r8 = 3
            if (r1 <= r2) goto L_0x00bc
            r0.t = r8
            goto L_0x00be
        L_0x00bc:
            if (r1 != r7) goto L_0x00d0
        L_0x00be:
            r17 = r4
            r19 = r5
            r20 = r10
            r1 = r22
            r8 = r23
            r4 = 4096(0x1000, float:5.74E-42)
            r5 = 1
            r10 = -1
            r22 = r2
            r2 = 0
            goto L_0x007e
        L_0x00d0:
            r8 = -1
            if (r4 != r8) goto L_0x00e6
            byte[] r4 = r0.k
            int r5 = r18 + 1
            byte[] r8 = r0.j
            byte r8 = r8[r1]
            r4[r18] = r8
            r4 = r1
            r18 = r5
            r8 = r23
            r5 = r4
            r1 = r22
            goto L_0x00a2
        L_0x00e6:
            if (r1 < r2) goto L_0x00f3
            byte[] r8 = r0.k
            int r24 = r18 + 1
            byte r5 = (byte) r5
            r8[r18] = r5
            r5 = r4
            r18 = r24
            goto L_0x00f4
        L_0x00f3:
            r5 = r1
        L_0x00f4:
            if (r5 < r6) goto L_0x010b
            byte[] r8 = r0.k
            int r24 = r18 + 1
            r25 = r1
            byte[] r1 = r0.j
            byte r1 = r1[r5]
            r8[r18] = r1
            short[] r1 = r0.i
            short r5 = r1[r5]
            r18 = r24
            r1 = r25
            goto L_0x00f4
        L_0x010b:
            r25 = r1
            byte[] r1 = r0.j
            byte r5 = r1[r5]
            r5 = r5 & 255(0xff, float:3.57E-43)
            byte[] r8 = r0.k
            int r24 = r18 + 1
            r26 = r6
            byte r6 = (byte) r5
            r8[r18] = r6
            r8 = 4096(0x1000, float:5.74E-42)
            if (r2 >= r8) goto L_0x0136
            short[] r8 = r0.i
            short r4 = (short) r4
            r8[r2] = r4
            r1[r2] = r6
            int r2 = r2 + 1
            r1 = r2 & r21
            if (r1 != 0) goto L_0x0136
            r1 = 4096(0x1000, float:5.74E-42)
            if (r2 >= r1) goto L_0x0138
            int r10 = r10 + 1
            int r21 = r21 + r2
            goto L_0x0138
        L_0x0136:
            r1 = 4096(0x1000, float:5.74E-42)
        L_0x0138:
            r18 = r24
        L_0x013a:
            if (r18 <= 0) goto L_0x014d
            byte[] r4 = r0.l
            int r6 = r16 + 1
            byte[] r8 = r0.k
            int r18 = r18 + -1
            byte r8 = r8[r18]
            r4[r16] = r8
            int r11 = r11 + 1
            r16 = r6
            goto L_0x013a
        L_0x014d:
            r1 = r22
            r8 = r23
            r4 = r25
            r6 = r26
            goto L_0x00a2
        L_0x0157:
            r22 = r2
            r17 = r4
            r19 = r5
            r20 = r10
            r2 = 0
            r4 = 4096(0x1000, float:5.74E-42)
            r5 = 1
            r10 = -1
            goto L_0x007e
        L_0x0166:
            r1 = r16
        L_0x0168:
            if (r1 >= r3) goto L_0x0172
            byte[] r2 = r0.l
            r4 = 0
            r2[r1] = r4
            int r1 = r1 + 1
            goto L_0x0168
        L_0x0172:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.hansel.core.network.request.a.a.a(io.hansel.core.network.request.a.b):void");
    }

    private void a(int[] iArr, b bVar, int i2) {
        int i3 = bVar.f5197d;
        int i4 = this.u;
        int i5 = i3 / i4;
        int i6 = bVar.f5195b / i4;
        int i7 = bVar.f5196c / i4;
        int i8 = bVar.f5194a / i4;
        int i9 = this.w;
        int i10 = (i6 * i9) + i8;
        int i11 = (i5 * i9) + i10;
        while (i10 < i11) {
            int i12 = i10 + i7;
            for (int i13 = i10; i13 < i12; i13++) {
                iArr[i13] = i2;
            }
            i10 += this.w;
        }
    }

    private d e() {
        if (this.h == null) {
            this.h = new d();
        }
        return this.h;
    }

    private Bitmap f() {
        Bitmap a2 = this.q.a(this.w, this.v, this.x ? Config.ARGB_8888 : Config.RGB_565);
        a(a2);
        return a2;
    }

    private int i() {
        int i2;
        int j2 = j();
        if (j2 > 0) {
            try {
                if (this.f5191d == null) {
                    this.f5191d = this.q.a(InvitationReply.EXPIRED);
                }
                int i3 = this.f5193f;
                int i4 = this.g;
                int i5 = i3 - i4;
                if (i5 >= j2) {
                    System.arraycopy(this.f5192e, i4, this.f5191d, 0, j2);
                    i2 = this.g + j2;
                } else if (this.f5190c.remaining() + i5 >= j2) {
                    System.arraycopy(this.f5192e, this.g, this.f5191d, 0, i5);
                    this.g = this.f5193f;
                    k();
                    int i6 = j2 - i5;
                    System.arraycopy(this.f5192e, 0, this.f5191d, i5, i6);
                    i2 = this.g + i6;
                } else {
                    this.t = 1;
                }
                this.g = i2;
            } catch (Exception unused) {
                this.t = 1;
            }
        }
        return j2;
    }

    private int j() {
        try {
            k();
            byte[] bArr = this.f5192e;
            int i2 = this.g;
            this.g = i2 + 1;
            return bArr[i2] & 255;
        } catch (Exception unused) {
            this.t = 1;
            return 0;
        }
    }

    private void k() {
        if (this.f5193f <= this.g) {
            if (this.f5192e == null) {
                this.f5192e = this.q.a(16384);
            }
            this.g = 0;
            int min = Math.min(this.f5190c.remaining(), 16384);
            this.f5193f = min;
            this.f5190c.get(this.f5192e, 0, min);
        }
    }

    public int a(int i2) {
        if (i2 >= 0) {
            c cVar = this.p;
            if (i2 < cVar.f5202c) {
                return cVar.f5204e.get(i2).i;
            }
        }
        return -1;
    }

    public synchronized int a(byte[] bArr) {
        c b2 = e().a(bArr).b();
        this.p = b2;
        if (bArr != null) {
            a(b2, bArr);
        }
        return this.t;
    }

    public synchronized void a(c cVar, ByteBuffer byteBuffer) {
        a(cVar, byteBuffer, 1);
    }

    public synchronized void a(c cVar, ByteBuffer byteBuffer, int i2) {
        if (i2 > 0) {
            int highestOneBit = Integer.highestOneBit(2);
            this.t = 0;
            this.p = cVar;
            this.x = false;
            this.n = -1;
            l();
            ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            this.f5190c = asReadOnlyBuffer;
            asReadOnlyBuffer.position(0);
            this.f5190c.order(ByteOrder.LITTLE_ENDIAN);
            this.s = false;
            Iterator<b> it = cVar.f5204e.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().g == 3) {
                        this.s = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            this.u = highestOneBit;
            int i3 = cVar.f5205f;
            this.w = i3 / highestOneBit;
            int i4 = cVar.g;
            this.v = i4 / highestOneBit;
            this.l = this.q.a(i3 * i4);
            this.m = this.q.b(this.w * this.v);
        } else {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i2);
        }
    }

    public synchronized void a(c cVar, byte[] bArr) {
        a(cVar, ByteBuffer.wrap(bArr));
    }

    public boolean a() {
        if (this.p.f5202c <= 0) {
            return false;
        }
        if (this.n == c() - 1) {
            this.o++;
        }
        c cVar = this.p;
        int i2 = cVar.m;
        if (i2 != -1 && this.o > i2) {
            return false;
        }
        this.n = (this.n + 1) % cVar.f5202c;
        return true;
    }

    public int b() {
        return this.n;
    }

    public boolean b(int i2) {
        if (i2 < -1 || i2 >= c()) {
            return false;
        }
        this.n = i2;
        return true;
    }

    public int c() {
        return this.p.f5202c;
    }

    public int d() {
        return this.n;
    }

    public int g() {
        if (this.p.f5202c > 0) {
            int i2 = this.n;
            if (i2 >= 0) {
                return a(i2);
            }
        }
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x005f, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized android.graphics.Bitmap h() {
        /*
            r6 = this;
            monitor-enter(r6)
            io.hansel.core.network.request.a.c r0 = r6.p     // Catch:{ all -> 0x0060 }
            int r1 = r0.f5202c     // Catch:{ all -> 0x0060 }
            r2 = 1
            if (r1 <= 0) goto L_0x000c
            int r1 = r6.n     // Catch:{ all -> 0x0060 }
            if (r1 >= 0) goto L_0x000e
        L_0x000c:
            r6.t = r2     // Catch:{ all -> 0x0060 }
        L_0x000e:
            int r1 = r6.t     // Catch:{ all -> 0x0060 }
            r3 = 0
            if (r1 == r2) goto L_0x005e
            r4 = 2
            if (r1 != r4) goto L_0x0017
            goto L_0x005e
        L_0x0017:
            r1 = 0
            r6.t = r1     // Catch:{ all -> 0x0060 }
            java.util.List<io.hansel.core.network.request.a.b> r0 = r0.f5204e     // Catch:{ all -> 0x0060 }
            int r4 = r6.n     // Catch:{ all -> 0x0060 }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x0060 }
            io.hansel.core.network.request.a.b r0 = (io.hansel.core.network.request.a.b) r0     // Catch:{ all -> 0x0060 }
            int r4 = r6.n     // Catch:{ all -> 0x0060 }
            int r4 = r4 - r2
            if (r4 < 0) goto L_0x0034
            io.hansel.core.network.request.a.c r5 = r6.p     // Catch:{ all -> 0x0060 }
            java.util.List<io.hansel.core.network.request.a.b> r5 = r5.f5204e     // Catch:{ all -> 0x0060 }
            java.lang.Object r4 = r5.get(r4)     // Catch:{ all -> 0x0060 }
            io.hansel.core.network.request.a.b r4 = (io.hansel.core.network.request.a.b) r4     // Catch:{ all -> 0x0060 }
            goto L_0x0035
        L_0x0034:
            r4 = r3
        L_0x0035:
            int[] r5 = r0.k     // Catch:{ all -> 0x0060 }
            if (r5 == 0) goto L_0x003a
            goto L_0x003e
        L_0x003a:
            io.hansel.core.network.request.a.c r5 = r6.p     // Catch:{ all -> 0x0060 }
            int[] r5 = r5.f5200a     // Catch:{ all -> 0x0060 }
        L_0x003e:
            r6.f5189b = r5     // Catch:{ all -> 0x0060 }
            if (r5 != 0) goto L_0x0046
            r6.t = r2     // Catch:{ all -> 0x0060 }
            monitor-exit(r6)
            return r3
        L_0x0046:
            boolean r2 = r0.f5199f     // Catch:{ all -> 0x0060 }
            if (r2 == 0) goto L_0x0058
            int[] r2 = r6.f5188a     // Catch:{ all -> 0x0060 }
            int r3 = r5.length     // Catch:{ all -> 0x0060 }
            java.lang.System.arraycopy(r5, r1, r2, r1, r3)     // Catch:{ all -> 0x0060 }
            int[] r2 = r6.f5188a     // Catch:{ all -> 0x0060 }
            r6.f5189b = r2     // Catch:{ all -> 0x0060 }
            int r3 = r0.h     // Catch:{ all -> 0x0060 }
            r2[r3] = r1     // Catch:{ all -> 0x0060 }
        L_0x0058:
            android.graphics.Bitmap r0 = r6.a(r0, r4)     // Catch:{ all -> 0x0060 }
            monitor-exit(r6)
            return r0
        L_0x005e:
            monitor-exit(r6)
            return r3
        L_0x0060:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.hansel.core.network.request.a.a.h():android.graphics.Bitmap");
    }

    public void l() {
        this.o = 0;
    }
}
