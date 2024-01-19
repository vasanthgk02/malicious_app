package org.objectweb.asm;

import com.android.tools.r8.GeneratedOutlineSupport;

public class Label {

    /* renamed from: a  reason: collision with root package name */
    public int f6230a;

    /* renamed from: b  reason: collision with root package name */
    public int f6231b;

    /* renamed from: c  reason: collision with root package name */
    public int f6232c;

    /* renamed from: d  reason: collision with root package name */
    public int f6233d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f6234e;

    /* renamed from: f  reason: collision with root package name */
    public int f6235f;
    public int g;
    public Frame h;
    public Label i;
    public Edge j;
    public Label k;

    public Label a() {
        Frame frame = this.h;
        return frame == null ? this : frame.f6211b;
    }

    public final void a(int i2, int i3) {
        if (this.f6234e == null) {
            this.f6234e = new int[6];
        }
        int i4 = this.f6233d;
        int[] iArr = this.f6234e;
        if (i4 >= iArr.length) {
            int[] iArr2 = new int[(iArr.length + 6)];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.f6234e = iArr2;
        }
        int[] iArr3 = this.f6234e;
        int i5 = this.f6233d;
        int i6 = i5 + 1;
        this.f6233d = i6;
        iArr3[i5] = i2;
        this.f6233d = i6 + 1;
        iArr3[i6] = i3;
    }

    public void a(ByteVector byteVector, int i2, boolean z) {
        if ((this.f6230a & 2) == 0) {
            if (z) {
                a(-1 - i2, byteVector.f6185b);
                byteVector.putInt(-1);
                return;
            }
            a(i2, byteVector.f6185b);
            byteVector.putShort(-1);
        } else if (z) {
            byteVector.putInt(this.f6232c - i2);
        } else {
            byteVector.putShort(this.f6232c - i2);
        }
    }

    public boolean a(int i2, byte[] bArr) {
        this.f6230a |= 2;
        this.f6232c = i2;
        int i3 = 0;
        boolean z = false;
        while (i3 < this.f6233d) {
            int[] iArr = this.f6234e;
            int i4 = i3 + 1;
            int i5 = iArr[i3];
            int i6 = i4 + 1;
            int i7 = iArr[i4];
            if (i5 >= 0) {
                int i8 = i2 - i5;
                if (i8 < -32768 || i8 > 32767) {
                    int i9 = i7 - 1;
                    byte b2 = bArr[i9] & 255;
                    if (b2 <= 168) {
                        bArr[i9] = (byte) (b2 + 49);
                    } else {
                        bArr[i9] = (byte) (b2 + 20);
                    }
                    z = true;
                }
                bArr[i7] = (byte) (i8 >>> 8);
                bArr[i7 + 1] = (byte) i8;
            } else {
                int i10 = i5 + i2 + 1;
                int i11 = i7 + 1;
                bArr[i7] = (byte) (i10 >>> 24);
                int i12 = i11 + 1;
                bArr[i11] = (byte) (i10 >>> 16);
                bArr[i12] = (byte) (i10 >>> 8);
                bArr[i12 + 1] = (byte) i10;
            }
            i3 = i6;
        }
        return z;
    }

    /*  JADX ERROR: JadxOverflowException in pass: LoopRegionVisitor
        jadx.core.utils.exceptions.JadxOverflowException: LoopRegionVisitor.assignOnlyInLoop endless recursion
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008a  */
    public void b(org.objectweb.asm.Label r9, long r10, int r12) {
        /*
            r8 = this;
            r0 = r8
        L_0x0001:
            if (r0 == 0) goto L_0x00a2
            org.objectweb.asm.Label r1 = r0.k
            r2 = 0
            r0.k = r2
            r2 = 0
            r3 = 1
            if (r9 == 0) goto L_0x0052
            int r4 = r0.f6230a
            r5 = r4 & 2048(0x800, float:2.87E-42)
            if (r5 == 0) goto L_0x0013
            goto L_0x0068
        L_0x0013:
            r4 = r4 | 2048(0x800, float:2.87E-42)
            r0.f6230a = r4
            r5 = r4 & 256(0x100, float:3.59E-43)
            if (r5 == 0) goto L_0x0086
            r4 = r4 & 1024(0x400, float:1.435E-42)
            if (r4 == 0) goto L_0x003a
            int r4 = r9.f6230a
            r4 = r4 & 1024(0x400, float:1.435E-42)
            if (r4 != 0) goto L_0x0026
            goto L_0x003a
        L_0x0026:
            r4 = 0
        L_0x0027:
            int[] r5 = r0.f6234e
            int r6 = r5.length
            if (r4 >= r6) goto L_0x003a
            r5 = r5[r4]
            int[] r6 = r9.f6234e
            r6 = r6[r4]
            r5 = r5 & r6
            if (r5 == 0) goto L_0x0037
            r2 = 1
            goto L_0x003a
        L_0x0037:
            int r4 = r4 + 1
            goto L_0x0027
        L_0x003a:
            if (r2 != 0) goto L_0x0086
            org.objectweb.asm.Edge r2 = new org.objectweb.asm.Edge
            r2.<init>()
            int r3 = r0.f6235f
            r2.f6202a = r3
            org.objectweb.asm.Edge r3 = r9.j
            org.objectweb.asm.Label r3 = r3.f6203b
            r2.f6203b = r3
            org.objectweb.asm.Edge r3 = r0.j
            r2.f6204c = r3
            r0.j = r2
            goto L_0x0086
        L_0x0052:
            int r4 = r0.f6230a
            r4 = r4 & 1024(0x400, float:1.435E-42)
            r5 = 32
            if (r4 == 0) goto L_0x0066
            int[] r4 = r0.f6234e
            long r6 = r10 >>> r5
            int r7 = (int) r6
            r4 = r4[r7]
            int r6 = (int) r10
            r4 = r4 & r6
            if (r4 == 0) goto L_0x0066
            r2 = 1
        L_0x0066:
            if (r2 == 0) goto L_0x006a
        L_0x0068:
            r0 = r1
            goto L_0x0001
        L_0x006a:
            int r2 = r0.f6230a
            r4 = r2 & 1024(0x400, float:1.435E-42)
            if (r4 != 0) goto L_0x007b
            r2 = r2 | 1024(0x400, float:1.435E-42)
            r0.f6230a = r2
            int r2 = r12 / 32
            int r2 = r2 + r3
            int[] r2 = new int[r2]
            r0.f6234e = r2
        L_0x007b:
            int[] r2 = r0.f6234e
            long r3 = r10 >>> r5
            int r4 = (int) r3
            r3 = r2[r4]
            int r5 = (int) r10
            r3 = r3 | r5
            r2[r4] = r3
        L_0x0086:
            org.objectweb.asm.Edge r2 = r0.j
        L_0x0088:
            if (r2 == 0) goto L_0x0068
            int r3 = r0.f6230a
            r3 = r3 & 128(0x80, float:1.8E-43)
            if (r3 == 0) goto L_0x0096
            org.objectweb.asm.Edge r3 = r0.j
            org.objectweb.asm.Edge r3 = r3.f6204c
            if (r2 == r3) goto L_0x009f
        L_0x0096:
            org.objectweb.asm.Label r3 = r2.f6203b
            org.objectweb.asm.Label r4 = r3.k
            if (r4 != 0) goto L_0x009f
            r3.k = r1
            r1 = r3
        L_0x009f:
            org.objectweb.asm.Edge r2 = r2.f6204c
            goto L_0x0088
        L_0x00a2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.objectweb.asm.Label.b(org.objectweb.asm.Label, long, int):void");
    }

    public String toString() {
        StringBuffer outline71 = GeneratedOutlineSupport.outline71("L");
        outline71.append(System.identityHashCode(this));
        return outline71.toString();
    }
}
