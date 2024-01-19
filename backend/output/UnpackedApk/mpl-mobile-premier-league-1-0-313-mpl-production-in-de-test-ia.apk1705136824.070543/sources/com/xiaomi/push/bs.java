package com.xiaomi.push;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.xiaomi.channel.commonutils.logger.b;
import java.util.Date;

public class bs implements bv {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ br f4508a;

    public bs(br brVar) {
        this.f4508a = brVar;
    }

    public void a(bt btVar) {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("[Slim] ");
        outline73.append(br.a(this.f4508a).format(new Date()));
        outline73.append(" Connection started (");
        outline73.append(br.a(this.f4508a).hashCode());
        outline73.append(")");
        b.c(outline73.toString());
    }

    public void a(bt btVar, int i, Exception exc) {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("[Slim] ");
        outline73.append(br.a(this.f4508a).format(new Date()));
        outline73.append(" Connection closed (");
        outline73.append(br.a(this.f4508a).hashCode());
        outline73.append(")");
        b.c(outline73.toString());
    }

    public void a(bt btVar, Exception exc) {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("[Slim] ");
        outline73.append(br.a(this.f4508a).format(new Date()));
        outline73.append(" Reconnection failed due to an exception (");
        outline73.append(br.a(this.f4508a).hashCode());
        outline73.append(")");
        b.c(outline73.toString());
        exc.printStackTrace();
    }

    public void b(bt btVar) {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("[Slim] ");
        outline73.append(br.a(this.f4508a).format(new Date()));
        outline73.append(" Connection reconnected (");
        outline73.append(br.a(this.f4508a).hashCode());
        outline73.append(")");
        b.c(outline73.toString());
    }
}
