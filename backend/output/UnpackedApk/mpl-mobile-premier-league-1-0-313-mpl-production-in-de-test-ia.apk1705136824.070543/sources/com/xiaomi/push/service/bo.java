package com.xiaomi.push.service;

import android.util.Base64;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.xiaomi.channel.commonutils.android.j;
import com.xiaomi.push.C0097r.b;
import com.xiaomi.push.ao;
import com.xiaomi.push.at.a;
import com.xiaomi.push.x;
import java.util.List;

public class bo extends b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ bn f4920a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f892a = false;

    public bo(bn bnVar) {
        this.f4920a = bnVar;
    }

    public void b() {
        try {
            a.a(j.a()).a();
            a a2 = a.a(Base64.decode(ao.a(j.a(), (String) "https://resolver.msg.global.xiaomi.net/psc/?t=a", (List<x>) null), 10));
            if (a2 != null) {
                this.f4920a.f889a = a2;
                this.f892a = true;
                bn.a(this.f4920a);
            }
        } catch (Exception e2) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("fetch config failure: ");
            outline73.append(e2.getMessage());
            com.xiaomi.channel.commonutils.logger.b.a(outline73.toString());
        }
    }

    public void c() {
        bn.a[] aVarArr;
        this.f4920a.f890a = null;
        if (this.f892a) {
            synchronized (this.f4920a) {
                aVarArr = (bn.a[]) bn.a(this.f4920a).toArray(new bn.a[bn.a(this.f4920a).size()]);
            }
            for (bn.a a2 : aVarArr) {
                a2.a(bn.a(this.f4920a));
            }
        }
    }
}
