package com.xiaomi.push;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class ev extends el {

    /* renamed from: b  reason: collision with root package name */
    public static int f4774b = 10000;

    /* renamed from: c  reason: collision with root package name */
    public static int f4775c = 10000;

    /* renamed from: d  reason: collision with root package name */
    public static int f4776d = 10000;

    /* renamed from: e  reason: collision with root package name */
    public static int f4777e = 10485760;

    /* renamed from: f  reason: collision with root package name */
    public static int f4778f = 104857600;

    public static class a extends com.xiaomi.push.el.a {
        public a() {
            super(false, true);
        }

        public a(boolean z, boolean z2, int i) {
            super(z, z2, i);
        }

        public ep a(ey eyVar) {
            ev evVar = new ev(eyVar, this.f753a, this.f4764b);
            int i = this.f4763a;
            if (i != 0) {
                evVar.b(i);
            }
            return evVar;
        }
    }

    public ev(ey eyVar, boolean z, boolean z2) {
        super(eyVar, z, z2);
    }

    public en a() {
        byte a2 = a();
        int a3 = a();
        if (a3 <= f4775c) {
            return new en(a2, a3);
        }
        throw new eq(3, GeneratedOutlineSupport.outline42("Thrift list size ", a3, " out of range!"));
    }

    /* renamed from: a  reason: collision with other method in class */
    public eo m738a() {
        byte a2 = a();
        byte a3 = a();
        int a4 = a();
        if (a4 <= f4774b) {
            return new eo(a2, a3, a4);
        }
        throw new eq(3, GeneratedOutlineSupport.outline42("Thrift map size ", a4, " out of range!"));
    }

    /* renamed from: a  reason: collision with other method in class */
    public et m739a() {
        byte a2 = a();
        int a3 = a();
        if (a3 <= f4776d) {
            return new et(a2, a3);
        }
        throw new eq(3, GeneratedOutlineSupport.outline42("Thrift set size ", a3, " out of range!"));
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m740a() {
        int a2 = a();
        if (a2 > f4777e) {
            throw new eq(3, GeneratedOutlineSupport.outline42("Thrift string size ", a2, " out of range!"));
        } else if (this.f4769a.b() < a2) {
            return a(a2);
        } else {
            try {
                String str = new String(this.f4769a.a(), this.f4769a.a(), a2, "UTF-8");
                this.f4769a.a(a2);
                return str;
            } catch (UnsupportedEncodingException unused) {
                throw new ej((String) "JVM DOES NOT SUPPORT UTF-8");
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public ByteBuffer m741a() {
        int a2 = a();
        if (a2 <= f4778f) {
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
        throw new eq(3, GeneratedOutlineSupport.outline42("Thrift binary size ", a2, " out of range!"));
    }
}
