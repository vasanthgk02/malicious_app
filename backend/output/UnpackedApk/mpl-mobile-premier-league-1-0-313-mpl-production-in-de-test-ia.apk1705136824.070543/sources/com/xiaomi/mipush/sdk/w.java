package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.cz;
import com.xiaomi.push.dc;
import com.xiaomi.push.df;
import com.xiaomi.push.di;
import com.xiaomi.push.dn;
import com.xiaomi.push.dt;
import com.xiaomi.push.ee;
import com.xiaomi.push.o.a;
import com.xiaomi.push.service.at;
import com.xiaomi.push.service.au;

public class w extends a {

    /* renamed from: a  reason: collision with root package name */
    public Context f4383a;

    public w(Context context) {
        this.f4383a = context;
    }

    public String a() {
        return "2";
    }

    public void run() {
        at a2 = at.a(this.f4383a);
        dn dnVar = new dn();
        dnVar.a(au.a(a2, dc.MISC_CONFIG));
        dnVar.b(au.a(a2, dc.PLUGIN_CONFIG));
        dt dtVar = new dt("-1", false);
        dtVar.c(df.DailyCheckClientConfig.f458a);
        dtVar.a(ee.a(dnVar));
        ag.a(this.f4383a).a(dtVar, cz.Notification, (di) null);
    }
}
