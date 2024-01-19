package io.hansel.core.network.request.a;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import org.apache.fontbox.ttf.GlyfDescript;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f5206a = new byte[256];

    /* renamed from: b  reason: collision with root package name */
    public ByteBuffer f5207b;

    /* renamed from: c  reason: collision with root package name */
    public c f5208c;

    /* renamed from: d  reason: collision with root package name */
    public int f5209d = 0;

    private boolean a() {
        return this.f5208c.f5201b != 0;
    }

    private int[] a(int i) {
        int[] iArr;
        byte[] bArr = new byte[(i * 3)];
        try {
            this.f5207b.get(bArr);
            iArr = new int[256];
            int i2 = 0;
            int i3 = 0;
            while (i2 < i) {
                int i4 = i3 + 1;
                try {
                    int i5 = i4 + 1;
                    int i6 = i5 + 1;
                    int i7 = i2 + 1;
                    iArr[i2] = ((bArr[i3] & 255) << GlyfDescript.X_DUAL) | -16777216 | ((bArr[i4] & 255) << 8) | (bArr[i5] & 255);
                    i3 = i6;
                    i2 = i7;
                } catch (BufferUnderflowException unused) {
                    this.f5208c.f5201b = 1;
                    return iArr;
                }
            }
        } catch (BufferUnderflowException unused2) {
            iArr = null;
            this.f5208c.f5201b = 1;
            return iArr;
        }
        return iArr;
    }

    private void b(int i) {
        boolean z = false;
        while (!z && !a() && this.f5208c.f5202c <= i) {
            int c2 = c();
            if (c2 == 33) {
                int c3 = c();
                if (c3 != 1) {
                    if (c3 == 249) {
                        this.f5208c.f5203d = new b();
                        g();
                    } else if (c3 != 254 && c3 == 255) {
                        e();
                        String str = "";
                        for (int i2 = 0; i2 < 11; i2++) {
                            StringBuilder outline73 = GeneratedOutlineSupport.outline73(str);
                            outline73.append((char) this.f5206a[i2]);
                            str = outline73.toString();
                        }
                        if (str.equals("NETSCAPE2.0")) {
                            j();
                        }
                    }
                }
                m();
            } else if (c2 == 44) {
                c cVar = this.f5208c;
                if (cVar.f5203d == null) {
                    cVar.f5203d = new b();
                }
                d();
            } else if (c2 != 59) {
                this.f5208c.f5201b = 1;
            } else {
                z = true;
            }
        }
    }

    private int c() {
        try {
            return this.f5207b.get() & 255;
        } catch (Exception unused) {
            this.f5208c.f5201b = 1;
            return 0;
        }
    }

    private void d() {
        this.f5208c.f5203d.f5194a = k();
        this.f5208c.f5203d.f5195b = k();
        this.f5208c.f5203d.f5196c = k();
        this.f5208c.f5203d.f5197d = k();
        int c2 = c();
        boolean z = false;
        boolean z2 = (c2 & 128) != 0;
        int pow = (int) Math.pow(2.0d, (double) ((c2 & 7) + 1));
        b bVar = this.f5208c.f5203d;
        if ((c2 & 64) != 0) {
            z = true;
        }
        bVar.f5198e = z;
        if (z2) {
            bVar.k = a(pow);
        } else {
            bVar.k = null;
        }
        this.f5208c.f5203d.j = this.f5207b.position();
        n();
        if (!a()) {
            c cVar = this.f5208c;
            cVar.f5202c++;
            cVar.f5204e.add(cVar.f5203d);
        }
    }

    private int e() {
        int c2 = c();
        this.f5209d = c2;
        int i = 0;
        if (c2 > 0) {
            while (true) {
                try {
                    int i2 = this.f5209d;
                    if (i >= i2) {
                        break;
                    }
                    int i3 = i2 - i;
                    this.f5207b.get(this.f5206a, i, i3);
                    i += i3;
                } catch (Exception unused) {
                    this.f5208c.f5201b = 1;
                }
            }
        }
        return i;
    }

    private void f() {
        b(Integer.MAX_VALUE);
    }

    private void g() {
        c();
        int c2 = c();
        b bVar = this.f5208c.f5203d;
        int i = (c2 & 28) >> 2;
        bVar.g = i;
        boolean z = true;
        if (i == 0) {
            bVar.g = 1;
        }
        if ((c2 & 1) == 0) {
            z = false;
        }
        bVar.f5199f = z;
        int k = k();
        if (k < 2) {
            k = 10;
        }
        b bVar2 = this.f5208c.f5203d;
        bVar2.i = k * 10;
        bVar2.h = c();
        c();
    }

    private void h() {
        String str = "";
        for (int i = 0; i < 6; i++) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73(str);
            outline73.append((char) c());
            str = outline73.toString();
        }
        if (!str.startsWith("GIF")) {
            this.f5208c.f5201b = 1;
            return;
        }
        i();
        if (this.f5208c.h && !a()) {
            c cVar = this.f5208c;
            cVar.f5200a = a(cVar.i);
            c cVar2 = this.f5208c;
            cVar2.l = cVar2.f5200a[cVar2.j];
        }
    }

    private void i() {
        this.f5208c.f5205f = k();
        this.f5208c.g = k();
        int c2 = c();
        c cVar = this.f5208c;
        cVar.h = (c2 & 128) != 0;
        cVar.i = 2 << (c2 & 7);
        cVar.j = c();
        this.f5208c.k = c();
    }

    private void j() {
        do {
            e();
            byte[] bArr = this.f5206a;
            if (bArr[0] == 1) {
                c cVar = this.f5208c;
                byte b2 = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
                cVar.m = b2;
                if (b2 == 0) {
                    cVar.m = -1;
                }
            }
            if (this.f5209d <= 0) {
                return;
            }
        } while (!a());
    }

    private int k() {
        return this.f5207b.getShort();
    }

    private void l() {
        this.f5207b = null;
        Arrays.fill(this.f5206a, 0);
        this.f5208c = new c();
        this.f5209d = 0;
    }

    private void m() {
        int c2;
        do {
            try {
                c2 = c();
                ByteBuffer byteBuffer = this.f5207b;
                byteBuffer.position(byteBuffer.position() + c2);
            } catch (IllegalArgumentException unused) {
                return;
            }
        } while (c2 > 0);
    }

    private void n() {
        c();
        m();
    }

    public d a(ByteBuffer byteBuffer) {
        l();
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.f5207b = asReadOnlyBuffer;
        asReadOnlyBuffer.position(0);
        this.f5207b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    public d a(byte[] bArr) {
        if (bArr != null) {
            a(ByteBuffer.wrap(bArr));
        } else {
            this.f5207b = null;
            this.f5208c.f5201b = 2;
        }
        return this;
    }

    public c b() {
        if (this.f5207b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        } else if (a()) {
            return this.f5208c;
        } else {
            h();
            if (!a()) {
                f();
                c cVar = this.f5208c;
                if (cVar.f5202c < 0) {
                    cVar.f5201b = 1;
                }
            }
            return this.f5208c;
        }
    }
}
