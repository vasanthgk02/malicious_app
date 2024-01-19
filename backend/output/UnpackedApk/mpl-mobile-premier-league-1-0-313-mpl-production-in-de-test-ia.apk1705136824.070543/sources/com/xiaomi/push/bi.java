package com.xiaomi.push;

import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ColorPropConverter;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.au.a;
import com.xiaomi.push.service.aw;
import com.xiaomi.push.service.bh;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class bi {

    /* renamed from: a  reason: collision with root package name */
    public static long f4492a = 0;

    /* renamed from: a  reason: collision with other field name */
    public static final byte[] f351a = new byte[0];

    /* renamed from: b  reason: collision with root package name */
    public static String f4493b = (cu.a(5) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);

    /* renamed from: a  reason: collision with other field name */
    public int f352a;

    /* renamed from: a  reason: collision with other field name */
    public a f353a;

    /* renamed from: a  reason: collision with other field name */
    public String f354a;

    /* renamed from: a  reason: collision with other field name */
    public short f355a;

    /* renamed from: b  reason: collision with other field name */
    public byte[] f356b;

    public bi() {
        this.f355a = 2;
        this.f356b = f351a;
        this.f354a = null;
        this.f353a = new a();
        this.f352a = 1;
    }

    public bi(a aVar, short s, byte[] bArr) {
        this.f355a = 2;
        this.f356b = f351a;
        this.f354a = null;
        this.f353a = aVar;
        this.f355a = s;
        this.f356b = bArr;
        this.f352a = 2;
    }

    @Deprecated
    public static bi a(cj cjVar, String str) {
        int i;
        bi biVar = new bi();
        try {
            i = Integer.parseInt(cjVar.k());
        } catch (Exception e2) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Blob parse chid err ");
            outline73.append(e2.getMessage());
            b.a(outline73.toString());
            i = 1;
        }
        biVar.a(i);
        biVar.a(cjVar.j());
        biVar.c(cjVar.m());
        biVar.b(cjVar.n());
        biVar.a((String) "XMLMSG", (String) null);
        try {
            biVar.a(cjVar.a().getBytes("utf8"), str);
            if (TextUtils.isEmpty(str)) {
                biVar.a(3);
            } else {
                biVar.a(2);
                biVar.a((String) "SECMSG", (String) null);
            }
        } catch (UnsupportedEncodingException e3) {
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("Blob setPayload err： ");
            outline732.append(e3.getMessage());
            b.a(outline732.toString());
        }
        return biVar;
    }

    public static bi a(ByteBuffer byteBuffer) {
        try {
            ByteBuffer slice = byteBuffer.slice();
            short s = slice.getShort(0);
            short s2 = slice.getShort(2);
            int i = slice.getInt(4);
            a aVar = new a();
            aVar.a(slice.array(), slice.arrayOffset() + 8, (int) s2);
            byte[] bArr = new byte[i];
            slice.position(s2 + 8);
            slice.get(bArr, 0, i);
            return new bi(aVar, s, bArr);
        } catch (Exception e2) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("read Blob err :");
            outline73.append(e2.getMessage());
            b.a(outline73.toString());
            throw new IOException("Malformed Input");
        }
    }

    public static synchronized String d() {
        String sb;
        synchronized (bi.class) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(f4493b);
            long j = f4492a;
            f4492a = 1 + j;
            sb2.append(Long.toString(j));
            sb = sb2.toString();
        }
        return sb;
    }

    public int a() {
        return this.f353a.c();
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m517a() {
        return this.f353a.c();
    }

    /* renamed from: a  reason: collision with other method in class */
    public ByteBuffer m518a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            byteBuffer = ByteBuffer.allocate(c());
        }
        byteBuffer.putShort(this.f355a);
        byteBuffer.putShort((short) this.f353a.a());
        byteBuffer.putInt(this.f356b.length);
        int position = byteBuffer.position();
        this.f353a.a(byteBuffer.array(), byteBuffer.arrayOffset() + position, this.f353a.a());
        byteBuffer.position(this.f353a.a() + position);
        byteBuffer.put(this.f356b);
        return byteBuffer;
    }

    /* renamed from: a  reason: collision with other method in class */
    public short m519a() {
        return this.f355a;
    }

    public void a(int i) {
        this.f353a.a(i);
    }

    public void a(long j, String str, String str2) {
        if (j != 0) {
            this.f353a.a(j);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f353a.a(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.f353a.b(str2);
        }
    }

    public void a(String str) {
        this.f353a.e(str);
    }

    public void a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.f353a.c(str);
            this.f353a.a();
            if (!TextUtils.isEmpty(str2)) {
                this.f353a.d(str2);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("command should not be empty");
    }

    public void a(short s) {
        this.f355a = s;
    }

    public void a(byte[] bArr, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f353a.c(1);
            this.f356b = bh.a(bh.a(str, e()), bArr);
            return;
        }
        this.f353a.c(0);
        this.f356b = bArr;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m520a() {
        return this.f353a.j();
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m521a() {
        return bj.a(this, this.f356b);
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m522a(String str) {
        if (this.f353a.e() == 1) {
            return bj.a(this, bh.a(bh.a(str, e()), this.f356b));
        }
        if (this.f353a.e() == 0) {
            return bj.a(this, this.f356b);
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("unknow cipher = ");
        outline73.append(this.f353a.e());
        b.a(outline73.toString());
        return bj.a(this, this.f356b);
    }

    public int b() {
        return this.f353a.f();
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m523b() {
        return this.f353a.d();
    }

    public void b(String str) {
        this.f354a = str;
    }

    public int c() {
        return this.f353a.b() + 8 + this.f356b.length;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m524c() {
        return this.f353a.f();
    }

    public void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            int indexOf = str.indexOf(ColorPropConverter.PREFIX_RESOURCE);
            try {
                long parseLong = Long.parseLong(str.substring(0, indexOf));
                int indexOf2 = str.indexOf("/", indexOf);
                String substring = str.substring(indexOf + 1, indexOf2);
                String substring2 = str.substring(indexOf2 + 1);
                this.f353a.a(parseLong);
                this.f353a.a(substring);
                this.f353a.b(substring2);
            } catch (Exception e2) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Blob parse user err ");
                outline73.append(e2.getMessage());
                b.a(outline73.toString());
            }
        }
    }

    public String e() {
        String e2 = this.f353a.e();
        if ("ID_NOT_AVAILABLE".equals(e2)) {
            return null;
        }
        if (!this.f353a.g()) {
            e2 = d();
            this.f353a.e(e2);
        }
        return e2;
    }

    public String f() {
        return this.f354a;
    }

    public String g() {
        if (!this.f353a.b()) {
            return null;
        }
        return Long.toString(this.f353a.a()) + ColorPropConverter.PREFIX_RESOURCE + this.f353a.a() + "/" + this.f353a.b();
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Blob [chid=");
        outline73.append(a());
        outline73.append("; Id=");
        outline73.append(aw.a(e()));
        outline73.append("; cmd=");
        outline73.append(a());
        outline73.append("; type=");
        outline73.append(a());
        outline73.append("; from=");
        outline73.append(g());
        outline73.append(" ]");
        return outline73.toString();
    }
}
