package com.xiaomi.push;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import org.apache.fontbox.ttf.GlyfDescript;
import sfs2x.client.entities.invitation.InvitationReply;

public class el extends ep {

    /* renamed from: a  reason: collision with root package name */
    public static final eu f4757a = new eu();

    /* renamed from: a  reason: collision with other field name */
    public int f748a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f749a = false;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f750a = new byte[1];

    /* renamed from: b  reason: collision with root package name */
    public boolean f4758b = true;

    /* renamed from: b  reason: collision with other field name */
    public byte[] f751b = new byte[2];

    /* renamed from: c  reason: collision with root package name */
    public boolean f4759c = false;

    /* renamed from: c  reason: collision with other field name */
    public byte[] f752c = new byte[4];

    /* renamed from: d  reason: collision with root package name */
    public byte[] f4760d = new byte[8];

    /* renamed from: e  reason: collision with root package name */
    public byte[] f4761e = new byte[1];

    /* renamed from: f  reason: collision with root package name */
    public byte[] f4762f = new byte[2];
    public byte[] g = new byte[4];
    public byte[] h = new byte[8];

    public static class a implements er {

        /* renamed from: a  reason: collision with root package name */
        public int f4763a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f753a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f4764b;

        public a() {
            this(false, true);
        }

        public a(boolean z, boolean z2) {
            this(z, z2, 0);
        }

        public a(boolean z, boolean z2, int i) {
            this.f753a = false;
            this.f4764b = true;
            this.f753a = z;
            this.f4764b = z2;
            this.f4763a = i;
        }

        public ep a(ey eyVar) {
            el elVar = new el(eyVar, this.f753a, this.f4764b);
            int i = this.f4763a;
            if (i != 0) {
                elVar.b(i);
            }
            return elVar;
        }
    }

    public el(ey eyVar, boolean z, boolean z2) {
        super(eyVar);
        this.f749a = z;
        this.f4758b = z2;
    }

    private int a(byte[] bArr, int i, int i2) {
        c(i2);
        return this.f4769a.b(bArr, i, i2);
    }

    public byte a() {
        if (this.f4769a.b() >= 1) {
            byte b2 = this.f4769a.a()[this.f4769a.a()];
            this.f4769a.a(1);
            return b2;
        }
        a(this.f4761e, 0, 1);
        return this.f4761e[0];
    }

    /* renamed from: a  reason: collision with other method in class */
    public double m711a() {
        return Double.longBitsToDouble(a());
    }

    /* renamed from: a  reason: collision with other method in class */
    public int m712a() {
        byte[] bArr = this.g;
        int i = 0;
        if (this.f4769a.b() >= 4) {
            bArr = this.f4769a.a();
            i = this.f4769a.a();
            this.f4769a.a(4);
        } else {
            a(this.g, 0, 4);
        }
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << GlyfDescript.X_DUAL) | ((bArr[i + 2] & 255) << 8);
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m713a() {
        byte[] bArr = this.h;
        int i = 0;
        if (this.f4769a.b() >= 8) {
            bArr = this.f4769a.a();
            i = this.f4769a.a();
            this.f4769a.a(8);
        } else {
            a(this.h, 0, 8);
        }
        return ((long) (bArr[i + 7] & 255)) | (((long) (bArr[i] & 255)) << 56) | (((long) (bArr[i + 1] & 255)) << 48) | (((long) (bArr[i + 2] & 255)) << 40) | (((long) (bArr[i + 3] & 255)) << 32) | (((long) (bArr[i + 4] & 255)) << 24) | (((long) (bArr[i + 5] & 255)) << 16) | (((long) (bArr[i + 6] & 255)) << 8);
    }

    /* renamed from: a  reason: collision with other method in class */
    public em m714a() {
        byte a2 = a();
        return new em("", a2, a2 == 0 ? 0 : a());
    }

    /* renamed from: a  reason: collision with other method in class */
    public en m715a() {
        return new en(a(), a());
    }

    /* renamed from: a  reason: collision with other method in class */
    public eo m716a() {
        return new eo(a(), a(), a());
    }

    /* renamed from: a  reason: collision with other method in class */
    public et m717a() {
        return new et(a(), a());
    }

    /* renamed from: a  reason: collision with other method in class */
    public eu m718a() {
        return f4757a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m719a() {
        int a2 = a();
        if (this.f4769a.b() < a2) {
            return a(a2);
        }
        try {
            String str = new String(this.f4769a.a(), this.f4769a.a(), a2, "UTF-8");
            this.f4769a.a(a2);
            return str;
        } catch (UnsupportedEncodingException unused) {
            throw new ej((String) "JVM DOES NOT SUPPORT UTF-8");
        }
    }

    public String a(int i) {
        try {
            c(i);
            byte[] bArr = new byte[i];
            this.f4769a.b(bArr, 0, i);
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new ej((String) "JVM DOES NOT SUPPORT UTF-8");
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public ByteBuffer m720a() {
        int a2 = a();
        c(a2);
        if (this.f4769a.b() >= a2) {
            ByteBuffer wrap = ByteBuffer.wrap(this.f4769a.a(), this.f4769a.a(), a2);
            this.f4769a.a(a2);
            return wrap;
        }
        byte[] bArr = new byte[a2];
        this.f4769a.b(bArr, 0, a2);
        return ByteBuffer.wrap(bArr);
    }

    /* renamed from: a  reason: collision with other method in class */
    public short m721a() {
        byte[] bArr = this.f4762f;
        int i = 0;
        if (this.f4769a.b() >= 2) {
            bArr = this.f4769a.a();
            i = this.f4769a.a();
            this.f4769a.a(2);
        } else {
            a(this.f4762f, 0, 2);
        }
        return (short) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m722a() {
    }

    public void a(byte b2) {
        byte[] bArr = this.f750a;
        bArr[0] = b2;
        this.f4769a.a(bArr, 0, 1);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m723a(int i) {
        byte[] bArr = this.f752c;
        bArr[0] = (byte) ((i >> 24) & InvitationReply.EXPIRED);
        bArr[1] = (byte) ((i >> 16) & InvitationReply.EXPIRED);
        bArr[2] = (byte) ((i >> 8) & InvitationReply.EXPIRED);
        bArr[3] = (byte) (i & InvitationReply.EXPIRED);
        this.f4769a.a(bArr, 0, 4);
    }

    public void a(long j) {
        byte[] bArr = this.f4760d;
        bArr[0] = (byte) ((int) ((j >> 56) & 255));
        bArr[1] = (byte) ((int) ((j >> 48) & 255));
        bArr[2] = (byte) ((int) ((j >> 40) & 255));
        bArr[3] = (byte) ((int) ((j >> 32) & 255));
        bArr[4] = (byte) ((int) ((j >> 24) & 255));
        bArr[5] = (byte) ((int) ((j >> 16) & 255));
        bArr[6] = (byte) ((int) ((j >> 8) & 255));
        bArr[7] = (byte) ((int) (j & 255));
        this.f4769a.a(bArr, 0, 8);
    }

    public void a(em emVar) {
        a(emVar.f4765a);
        a(emVar.f755a);
    }

    public void a(en enVar) {
        a(enVar.f4766a);
        a(enVar.f756a);
    }

    public void a(eo eoVar) {
        a(eoVar.f4767a);
        a(eoVar.f4768b);
        a(eoVar.f757a);
    }

    public void a(eu euVar) {
    }

    public void a(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            a(bytes.length);
            this.f4769a.a(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new ej((String) "JVM DOES NOT SUPPORT UTF-8");
        }
    }

    public void a(ByteBuffer byteBuffer) {
        int limit = (byteBuffer.limit() - byteBuffer.position()) - byteBuffer.arrayOffset();
        a(limit);
        this.f4769a.a(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), limit);
    }

    public void a(short s) {
        byte[] bArr = this.f751b;
        bArr[0] = (byte) ((s >> 8) & InvitationReply.EXPIRED);
        bArr[1] = (byte) (s & 255);
        this.f4769a.a(bArr, 0, 2);
    }

    public void a(boolean z) {
        a(z ? (byte) 1 : 0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m724a() {
        return a() == 1;
    }

    public void b() {
    }

    public void b(int i) {
        this.f748a = i;
        this.f4759c = true;
    }

    public void c() {
        a(0);
    }

    public void c(int i) {
        if (i < 0) {
            throw new ej(GeneratedOutlineSupport.outline41("Negative length: ", i));
        } else if (this.f4759c) {
            int i2 = this.f748a - i;
            this.f748a = i2;
            if (i2 < 0) {
                throw new ej(GeneratedOutlineSupport.outline41("Message length exceeded: ", i));
            }
        }
    }

    public void d() {
    }

    public void e() {
    }

    public void f() {
    }

    public void g() {
    }

    public void h() {
    }

    public void i() {
    }

    public void j() {
    }
}
