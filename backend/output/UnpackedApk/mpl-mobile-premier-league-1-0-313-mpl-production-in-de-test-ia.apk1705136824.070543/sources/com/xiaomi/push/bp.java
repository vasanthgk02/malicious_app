package com.xiaomi.push;

import android.os.SystemClock;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.bt.a;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.az;
import com.xiaomi.push.service.bh;
import com.xiaomi.push.service.bn;

public class bp extends bz {

    /* renamed from: a  reason: collision with root package name */
    public bk f4503a;

    /* renamed from: a  reason: collision with other field name */
    public bl f373a;

    /* renamed from: a  reason: collision with other field name */
    public Thread f374a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f375a;

    public bp(XMPushService xMPushService, bu buVar) {
        super(xMPushService, buVar);
    }

    private bi a(boolean z) {
        bo boVar = new bo();
        if (z) {
            boVar.a((String) "1");
        }
        return boVar;
    }

    private void h() {
        try {
            this.f4503a = new bk(this.f403a.getInputStream(), this);
            this.f373a = new bl(this.f403a.getOutputStream(), this);
            bq bqVar = new bq(this, "Blob Reader (" + this.f4510b + ")");
            this.f374a = bqVar;
            bqVar.start();
        } catch (Exception e2) {
            throw new cd("Error to init reader and writer", e2);
        }
    }

    public synchronized void a() {
        try {
            h();
            this.f373a.a();
        }
    }

    public synchronized void a(int i, Exception exc) {
        if (this.f4503a != null) {
            this.f4503a.b();
            this.f4503a = null;
        }
        if (this.f373a != null) {
            try {
                this.f373a.b();
            } catch (Exception e2) {
                b.a((Throwable) e2);
            }
            this.f373a = null;
        }
        this.f375a = null;
        super.a(i, exc);
    }

    public void a(bi biVar) {
        if (biVar != null) {
            if (biVar.a()) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("[Slim] RCV blob chid=");
                outline73.append(biVar.a());
                outline73.append("; id=");
                outline73.append(biVar.e());
                outline73.append("; errCode=");
                outline73.append(biVar.b());
                outline73.append("; err=");
                outline73.append(biVar.c());
                b.a(outline73.toString());
            }
            if (biVar.a() == 0) {
                if ("PING".equals(biVar.a())) {
                    StringBuilder outline732 = GeneratedOutlineSupport.outline73("[Slim] RCV ping id=");
                    outline732.append(biVar.e());
                    b.a(outline732.toString());
                    g();
                } else if ("CLOSE".equals(biVar.a())) {
                    c(13, null);
                }
            }
            for (a a2 : this.f392a.values()) {
                a2.a(biVar);
            }
        }
    }

    @Deprecated
    public void a(cj cjVar) {
        b(bi.a(cjVar, (String) null));
    }

    public synchronized void a(az.b bVar) {
        bh.a(bVar, c(), (bt) this);
    }

    public synchronized void a(String str, String str2) {
        bh.a(str, str2, (bt) this);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m528a(boolean z) {
        if (this.f373a != null) {
            bi a2 = a(z);
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("[Slim] SND ping id=");
            outline73.append(a2.e());
            b.a(outline73.toString());
            b(a2);
            f();
            return;
        }
        throw new cd((String) "The BlobWriter is null.");
    }

    public void a(bi[] biVarArr) {
        for (bi b2 : biVarArr) {
            b(b2);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m529a() {
        return true;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized byte[] m530a() {
        if (this.f375a == null && !TextUtils.isEmpty(this.f389a)) {
            String a2 = bn.a();
            this.f375a = bh.a(this.f389a.getBytes(), (this.f389a.substring(this.f389a.length() / 2) + a2.substring(a2.length() / 2)).getBytes());
        }
        return this.f375a;
    }

    public void b(bi biVar) {
        bl blVar = this.f373a;
        if (blVar != null) {
            try {
                int a2 = blVar.a(biVar);
                this.f4512d = SystemClock.elapsedRealtime();
                String f2 = biVar.f();
                if (!TextUtils.isEmpty(f2)) {
                    cx.a(this.f388a, f2, (long) a2, false, true, System.currentTimeMillis());
                }
                for (a a3 : this.f395b.values()) {
                    a3.a(biVar);
                }
            } catch (Exception e2) {
                throw new cd((Throwable) e2);
            }
        } else {
            throw new cd((String) "the writer is null.");
        }
    }

    public void b(cj cjVar) {
        if (cjVar != null) {
            for (a a2 : this.f392a.values()) {
                a2.a(cjVar);
            }
        }
    }
}
