package com.freshchat.consumer.sdk.service.b;

import com.freshchat.consumer.sdk.beans.BotFAQFetchRequest;
import com.freshchat.consumer.sdk.beans.FAQCategoryFetchRequest;
import com.freshchat.consumer.sdk.beans.FAQFetchRequest;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.service.c.aa;
import com.freshchat.consumer.sdk.service.c.ab;
import com.freshchat.consumer.sdk.service.c.af;
import com.freshchat.consumer.sdk.service.c.ag;
import com.freshchat.consumer.sdk.service.c.aj;
import com.freshchat.consumer.sdk.service.c.c;
import com.freshchat.consumer.sdk.service.c.d;
import com.freshchat.consumer.sdk.service.c.f;
import com.freshchat.consumer.sdk.service.c.g;
import com.freshchat.consumer.sdk.service.c.h;
import com.freshchat.consumer.sdk.service.c.i;
import com.freshchat.consumer.sdk.service.c.j;
import com.freshchat.consumer.sdk.service.c.k;
import com.freshchat.consumer.sdk.service.c.p;
import com.freshchat.consumer.sdk.service.c.r;
import com.freshchat.consumer.sdk.service.c.v;
import com.freshchat.consumer.sdk.service.c.w;
import com.freshchat.consumer.sdk.service.e.ac;
import com.freshchat.consumer.sdk.service.e.ad;
import com.freshchat.consumer.sdk.service.e.ae;
import com.freshchat.consumer.sdk.service.e.ah;
import com.freshchat.consumer.sdk.service.e.ak;
import com.freshchat.consumer.sdk.service.e.al;
import com.freshchat.consumer.sdk.service.e.am;
import com.freshchat.consumer.sdk.service.e.ap;
import com.freshchat.consumer.sdk.service.e.b;
import com.freshchat.consumer.sdk.service.e.e;
import com.freshchat.consumer.sdk.service.e.l;
import com.freshchat.consumer.sdk.service.e.m;
import com.freshchat.consumer.sdk.service.e.n;
import com.freshchat.consumer.sdk.service.e.o;
import com.freshchat.consumer.sdk.service.e.q;
import com.freshchat.consumer.sdk.service.e.s;
import com.freshchat.consumer.sdk.service.e.t;
import com.freshchat.consumer.sdk.service.e.u;
import com.freshchat.consumer.sdk.service.e.x;
import com.freshchat.consumer.sdk.service.e.y;
import com.freshchat.consumer.sdk.service.e.z;
import java.util.HashMap;
import java.util.Map;

public class a {
    public static Map<String, Class<? extends j>> fH;

    static {
        HashMap hashMap = new HashMap();
        fH = hashMap;
        hashMap.put(com.freshchat.consumer.sdk.service.e.a.class.getName(), c.class);
        fH.put(b.class.getName(), d.class);
        fH.put(com.freshchat.consumer.sdk.service.e.d.class.getName(), f.class);
        fH.put(e.class.getName(), g.class);
        fH.put(com.freshchat.consumer.sdk.service.e.f.class.getName(), h.class);
        fH.put(com.freshchat.consumer.sdk.service.e.g.class.getName(), i.class);
        fH.put(l.class.getName(), k.class);
        fH.put(m.class.getName(), com.freshchat.consumer.sdk.service.c.l.class);
        fH.put(n.class.getName(), com.freshchat.consumer.sdk.service.c.m.class);
        fH.put(o.class.getName(), com.freshchat.consumer.sdk.service.c.n.class);
        fH.put(q.class.getName(), p.class);
        fH.put(ad.class.getName(), aa.class);
        fH.put(com.freshchat.consumer.sdk.service.e.p.class.getName(), com.freshchat.consumer.sdk.service.c.o.class);
        fH.put(s.class.getName(), com.freshchat.consumer.sdk.service.c.q.class);
        fH.put(t.class.getName(), r.class);
        fH.put(u.class.getName(), com.freshchat.consumer.sdk.service.c.s.class);
        fH.put(x.class.getName(), com.freshchat.consumer.sdk.service.c.u.class);
        fH.put(y.class.getName(), v.class);
        fH.put(z.class.getName(), w.class);
        fH.put(com.freshchat.consumer.sdk.service.e.aa.class.getName(), com.freshchat.consumer.sdk.service.c.x.class);
        fH.put(ae.class.getName(), ab.class);
        fH.put(com.freshchat.consumer.sdk.service.e.v.class.getName(), com.freshchat.consumer.sdk.service.c.t.class);
        fH.put(com.freshchat.consumer.sdk.service.e.ab.class.getName(), com.freshchat.consumer.sdk.service.c.z.class);
        fH.put(com.freshchat.consumer.sdk.service.e.c.class.getName(), com.freshchat.consumer.sdk.service.c.e.class);
        fH.put(ac.class.getName(), com.freshchat.consumer.sdk.service.c.ac.class);
        fH.put(FAQCategoryFetchRequest.class.getName(), com.freshchat.consumer.sdk.service.c.ae.class);
        fH.put(ah.class.getName(), ag.class);
        fH.put(FAQFetchRequest.class.getName(), af.class);
        fH.put(BotFAQFetchRequest.class.getName(), aj.class);
        fH.put(ak.class.getName(), al.class);
        fH.put(am.class.getName(), com.freshchat.consumer.sdk.service.c.ah.class);
        fH.put(com.freshchat.consumer.sdk.service.e.af.class.getName(), com.freshchat.consumer.sdk.service.c.ad.class);
        fH.put(ap.class.getName(), com.freshchat.consumer.sdk.service.c.ak.class);
    }

    public static j a(com.freshchat.consumer.sdk.service.e.j jVar) {
        String name = jVar.getClass().getName();
        if (fH.containsKey(name)) {
            try {
                return (j) fH.get(name).newInstance();
            } catch (IllegalAccessException | InstantiationException e2) {
                ai.e("Service", "Exception occured", e2);
            }
        }
        return null;
    }
}
