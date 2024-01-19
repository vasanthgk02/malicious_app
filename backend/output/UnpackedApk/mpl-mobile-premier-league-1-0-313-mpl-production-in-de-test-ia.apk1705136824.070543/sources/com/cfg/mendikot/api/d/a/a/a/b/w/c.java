package com.cfg.mendikot.api.d.a.a.a.b.w;

import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;

public final class c implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f2315a;

    /* renamed from: b  reason: collision with root package name */
    public int f2316b;

    public c(int i) {
        k.a(i, (String) "Buffer capacity");
        this.f2315a = new byte[i];
    }

    public void a(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            if (i >= 0 && i <= bArr.length && i2 >= 0) {
                int i3 = i + i2;
                if (i3 >= 0 && i3 <= bArr.length) {
                    if (i2 != 0) {
                        int i4 = this.f2316b + i2;
                        byte[] bArr2 = this.f2315a;
                        if (i4 > bArr2.length) {
                            byte[] bArr3 = new byte[Math.max(bArr2.length << 1, i4)];
                            System.arraycopy(this.f2315a, 0, bArr3, 0, this.f2316b);
                            this.f2315a = bArr3;
                        }
                        System.arraycopy(bArr, i, this.f2315a, this.f2316b, i2);
                        this.f2316b = i4;
                        return;
                    }
                    return;
                }
            }
            StringBuilder outline75 = GeneratedOutlineSupport.outline75("off: ", i, " len: ", i2, " b.length: ");
            outline75.append(bArr.length);
            throw new IndexOutOfBoundsException(outline75.toString());
        }
    }
}
