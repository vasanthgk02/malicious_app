package com.xiaomi.push;

import android.os.Build;
import android.os.Build.VERSION;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.au.e;
import com.xiaomi.push.service.bh;
import com.xiaomi.push.service.bn;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.TimeZone;
import java.util.zip.Adler32;

public class bl {

    /* renamed from: a  reason: collision with root package name */
    public int f4497a;

    /* renamed from: a  reason: collision with other field name */
    public bp f363a;

    /* renamed from: a  reason: collision with other field name */
    public OutputStream f364a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f365a = ByteBuffer.allocate(2048);

    /* renamed from: a  reason: collision with other field name */
    public Adler32 f366a = new Adler32();

    /* renamed from: a  reason: collision with other field name */
    public byte[] f367a;

    /* renamed from: b  reason: collision with root package name */
    public int f4498b;

    /* renamed from: b  reason: collision with other field name */
    public ByteBuffer f368b = ByteBuffer.allocate(4);

    public bl(OutputStream outputStream, bp bpVar) {
        this.f364a = new BufferedOutputStream(outputStream);
        this.f363a = bpVar;
        TimeZone timeZone = TimeZone.getDefault();
        this.f4497a = timeZone.getRawOffset() / 3600000;
        this.f4498b = timeZone.useDaylightTime() ? 1 : 0;
    }

    public int a(bi biVar) {
        int c2 = biVar.c();
        if (c2 > 32768) {
            StringBuilder outline75 = GeneratedOutlineSupport.outline75("Blob size=", c2, " should be less than ", 32768, " Drop blob chid=");
            outline75.append(biVar.a());
            outline75.append(" id=");
            outline75.append(biVar.e());
            b.a(outline75.toString());
            return 0;
        }
        this.f365a.clear();
        int i = c2 + 8 + 4;
        if (i > this.f365a.capacity() || this.f365a.capacity() > 4096) {
            this.f365a = ByteBuffer.allocate(i);
        }
        this.f365a.putShort(-15618);
        this.f365a.putShort(5);
        this.f365a.putInt(c2);
        int position = this.f365a.position();
        this.f365a = biVar.a(this.f365a);
        if (!"CONN".equals(biVar.a())) {
            if (this.f367a == null) {
                this.f367a = this.f363a.a();
            }
            bh.a(this.f367a, this.f365a.array(), true, position, c2);
        }
        this.f366a.reset();
        this.f366a.update(this.f365a.array(), 0, this.f365a.position());
        this.f368b.putInt(0, (int) this.f366a.getValue());
        this.f364a.write(this.f365a.array(), 0, this.f365a.position());
        this.f364a.write(this.f368b.array(), 0, 4);
        this.f364a.flush();
        int position2 = this.f365a.position() + 4;
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("[Slim] Wrote {cmd=");
        outline73.append(biVar.a());
        outline73.append(";chid=");
        outline73.append(biVar.a());
        outline73.append(";len=");
        outline73.append(position2);
        outline73.append("}");
        b.c(outline73.toString());
        return position2;
    }

    public void a() {
        e eVar = new e();
        eVar.a(106);
        eVar.c(bn.a());
        eVar.b(48);
        eVar.d(this.f363a.b());
        eVar.c(VERSION.SDK_INT);
        byte[] a2 = this.f363a.a().a();
        if (a2 != null) {
            eVar.a(au.b.a(a2));
        }
        bi biVar = new bi();
        biVar.a(0);
        biVar.a((String) "CONN", (String) null);
        biVar.a(0, "xiaomi.com", null);
        biVar.a(eVar.a(), (String) null);
        a(biVar);
        b.a("[slim] open conn: andver=" + VERSION.SDK_INT + " sdk=" + 48 + " tz=" + this.f4497a + ":" + this.f4498b + " Model=" + Build.MODEL);
    }

    public void b() {
        bi biVar = new bi();
        biVar.a((String) "CLOSE", (String) null);
        a(biVar);
        this.f364a.close();
    }
}
