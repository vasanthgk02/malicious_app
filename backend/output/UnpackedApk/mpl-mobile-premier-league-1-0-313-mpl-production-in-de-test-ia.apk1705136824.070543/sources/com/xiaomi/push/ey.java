package com.xiaomi.push;

import com.android.tools.r8.GeneratedOutlineSupport;

public abstract class ey {
    public int a() {
        return 0;
    }

    public abstract int a(byte[] bArr, int i, int i2);

    public void a(int i) {
    }

    /* renamed from: a  reason: collision with other method in class */
    public abstract void m745a(byte[] bArr, int i, int i2);

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m746a() {
        return null;
    }

    public int b() {
        return -1;
    }

    public int b(byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            int a2 = a(bArr, i + i3, i2 - i3);
            if (a2 > 0) {
                i3 += a2;
            } else {
                throw new ez(GeneratedOutlineSupport.outline44("Cannot read. Remote side has closed. Tried to read ", i2, " bytes, but only got ", i3, " bytes."));
            }
        }
        return i3;
    }
}
