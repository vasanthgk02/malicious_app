package com.xiaomi.push.service;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.aa;
import in.juspay.hypersdk.core.InflateView;
import org.apache.fontbox.cmap.CMap;

public class bh {

    /* renamed from: a  reason: collision with root package name */
    public static int f4908a = 8;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f883a = new byte[256];

    /* renamed from: b  reason: collision with root package name */
    public int f4909b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f4910c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f4911d = -666;

    public static int a(byte b2) {
        return b2 >= 0 ? b2 : b2 + 256;
    }

    private void a() {
        this.f4910c = 0;
        this.f4909b = 0;
    }

    private void a(int i, byte[] bArr, boolean z) {
        int length = bArr.length;
        for (int i2 = 0; i2 < 256; i2++) {
            this.f883a[i2] = (byte) i2;
        }
        this.f4910c = 0;
        this.f4909b = 0;
        while (true) {
            int i3 = this.f4909b;
            if (i3 >= i) {
                break;
            }
            int a2 = (a(bArr[this.f4909b % length]) + (a(this.f883a[i3]) + this.f4910c)) % 256;
            this.f4910c = a2;
            a(this.f883a, this.f4909b, a2);
            this.f4909b++;
        }
        if (i != 256) {
            this.f4911d = (a(bArr[i % length]) + (a(this.f883a[i]) + this.f4910c)) % 256;
        }
        if (z) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("S_");
            int i4 = i - 1;
            outline73.append(i4);
            outline73.append(":");
            for (int i5 = 0; i5 <= i; i5++) {
                outline73.append(CMap.SPACE);
                outline73.append(a(this.f883a[i5]));
            }
            outline73.append("   j_");
            outline73.append(i4);
            outline73.append(InflateView.SETTER_EQUALS);
            outline73.append(this.f4910c);
            outline73.append("   j_");
            outline73.append(i);
            outline73.append(InflateView.SETTER_EQUALS);
            outline73.append(this.f4911d);
            outline73.append("   S_");
            outline73.append(i4);
            outline73.append("[j_");
            outline73.append(i4);
            outline73.append("]=");
            outline73.append(a(this.f883a[this.f4910c]));
            outline73.append("   S_");
            outline73.append(i4);
            outline73.append("[j_");
            outline73.append(i);
            outline73.append("]=");
            outline73.append(a(this.f883a[this.f4911d]));
            if (this.f883a[1] != 0) {
                outline73.append("   S[1]!=0");
            }
            b.a(outline73.toString());
        }
    }

    private void a(byte[] bArr) {
        a(256, bArr, false);
    }

    public static void a(byte[] bArr, int i, int i2) {
        byte b2 = bArr[i];
        bArr[i] = bArr[i2];
        bArr[i2] = b2;
    }

    public static byte[] a(String str, String str2) {
        byte[] a2 = aa.a(str);
        byte[] bytes = str2.getBytes();
        byte[] bArr = new byte[(a2.length + 1 + bytes.length)];
        for (int i = 0; i < a2.length; i++) {
            bArr[i] = a2[i];
        }
        bArr[a2.length] = 95;
        for (int i2 = 0; i2 < bytes.length; i2++) {
            bArr[a2.length + 1 + i2] = bytes[i2];
        }
        return bArr;
    }

    public static byte[] a(byte[] bArr, String str) {
        return a(bArr, aa.a(str));
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr2.length];
        bh bhVar = new bh();
        bhVar.a(bArr);
        bhVar.a();
        for (int i = 0; i < bArr2.length; i++) {
            bArr3[i] = (byte) (bArr2[i] ^ bhVar.a());
        }
        return bArr3;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, boolean z, int i, int i2) {
        byte[] bArr3;
        int i3;
        if (i < 0 || i > bArr2.length || i + i2 > bArr2.length) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline43("start = ", i, " len = ", i2));
        }
        if (!z) {
            bArr3 = new byte[i2];
            i3 = 0;
        } else {
            bArr3 = bArr2;
            i3 = i;
        }
        bh bhVar = new bh();
        bhVar.a(bArr);
        bhVar.a();
        for (int i4 = 0; i4 < i2; i4++) {
            bArr3[i3 + i4] = (byte) (bArr2[i + i4] ^ bhVar.a());
        }
        return bArr3;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte m834a() {
        int i = (this.f4909b + 1) % 256;
        this.f4909b = i;
        int a2 = (a(this.f883a[i]) + this.f4910c) % 256;
        this.f4910c = a2;
        a(this.f883a, this.f4909b, a2);
        byte[] bArr = this.f883a;
        return bArr[(a(this.f883a[this.f4910c]) + a(bArr[this.f4909b])) % 256];
    }
}
