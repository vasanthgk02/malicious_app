package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.at;
import com.xiaomi.push.service.at.a;
import java.util.HashMap;
import java.util.Map;

public class d implements AbstractPushManager {

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f4363a;

    /* renamed from: a  reason: collision with other field name */
    public Context f221a;

    /* renamed from: a  reason: collision with other field name */
    public PushConfiguration f222a;

    /* renamed from: a  reason: collision with other field name */
    public Map<c, AbstractPushManager> f223a = new HashMap();

    /* renamed from: a  reason: collision with other field name */
    public boolean f224a = false;

    public d(Context context) {
        this.f221a = context.getApplicationContext();
    }

    public static d a(Context context) {
        if (f4363a == null) {
            synchronized (d.class) {
                try {
                    if (f4363a == null) {
                        f4363a = new d(context);
                    }
                }
            }
        }
        return f4363a;
    }

    private void a() {
        PushConfiguration pushConfiguration = this.f222a;
        if (pushConfiguration != null) {
            if (pushConfiguration.getOpenHmsPush()) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73(" HW user switch : ");
                outline73.append(this.f222a.getOpenHmsPush());
                outline73.append(" HW online switch : ");
                outline73.append(g.a(this.f221a, c.ASSEMBLE_PUSH_HUAWEI));
                outline73.append(" HW isSupport : ");
                outline73.append(y.HUAWEI.equals(l.a(this.f221a)));
                b.a("ASSEMBLE_PUSH : " + outline73.toString());
            }
            if (this.f222a.getOpenHmsPush() && g.a(this.f221a, c.ASSEMBLE_PUSH_HUAWEI) && y.HUAWEI.equals(l.a(this.f221a))) {
                if (!a(c.ASSEMBLE_PUSH_HUAWEI)) {
                    c cVar = c.ASSEMBLE_PUSH_HUAWEI;
                    a(cVar, ac.a(this.f221a, cVar));
                }
                b.c("hw manager add to list");
            } else if (a(c.ASSEMBLE_PUSH_HUAWEI)) {
                AbstractPushManager a2 = a(c.ASSEMBLE_PUSH_HUAWEI);
                if (a2 != null) {
                    a(c.ASSEMBLE_PUSH_HUAWEI);
                    a2.unregister();
                }
            }
            if (this.f222a.getOpenFCMPush()) {
                StringBuilder outline732 = GeneratedOutlineSupport.outline73(" FCM user switch : ");
                outline732.append(this.f222a.getOpenFCMPush());
                outline732.append(" FCM online switch : ");
                outline732.append(g.a(this.f221a, c.ASSEMBLE_PUSH_FCM));
                outline732.append(" FCM isSupport : ");
                outline732.append(l.a(this.f221a));
                b.a("ASSEMBLE_PUSH : " + outline732.toString());
            }
            if (this.f222a.getOpenFCMPush() && g.a(this.f221a, c.ASSEMBLE_PUSH_FCM) && l.a(this.f221a)) {
                if (!a(c.ASSEMBLE_PUSH_FCM)) {
                    c cVar2 = c.ASSEMBLE_PUSH_FCM;
                    a(cVar2, ac.a(this.f221a, cVar2));
                }
                FCMPushHelper.saveSenderId(this.f221a, this.f222a.getFCMSenderId());
                b.c("fcm manager add to list");
            } else if (a(c.ASSEMBLE_PUSH_FCM)) {
                AbstractPushManager a3 = a(c.ASSEMBLE_PUSH_FCM);
                if (a3 != null) {
                    a(c.ASSEMBLE_PUSH_FCM);
                    a3.unregister();
                }
            }
            if (this.f222a.getOpenCOSPush()) {
                StringBuilder outline733 = GeneratedOutlineSupport.outline73(" COS user switch : ");
                outline733.append(this.f222a.getOpenCOSPush());
                outline733.append(" COS online switch : ");
                outline733.append(g.a(this.f221a, c.ASSEMBLE_PUSH_COS));
                outline733.append(" COS isSupport : ");
                outline733.append(l.b(this.f221a));
                b.a("ASSEMBLE_PUSH : " + outline733.toString());
            }
            if (this.f222a.getOpenCOSPush() && g.a(this.f221a, c.ASSEMBLE_PUSH_COS) && l.b(this.f221a)) {
                c cVar3 = c.ASSEMBLE_PUSH_COS;
                a(cVar3, ac.a(this.f221a, cVar3));
            } else if (a(c.ASSEMBLE_PUSH_COS)) {
                AbstractPushManager a4 = a(c.ASSEMBLE_PUSH_COS);
                if (a4 != null) {
                    a(c.ASSEMBLE_PUSH_COS);
                    a4.unregister();
                }
            }
            if (this.f222a.getOpenFTOSPush() && g.a(this.f221a, c.ASSEMBLE_PUSH_FTOS) && l.c(this.f221a)) {
                c cVar4 = c.ASSEMBLE_PUSH_FTOS;
                a(cVar4, ac.a(this.f221a, cVar4));
            } else if (a(c.ASSEMBLE_PUSH_FTOS)) {
                AbstractPushManager a5 = a(c.ASSEMBLE_PUSH_FTOS);
                if (a5 != null) {
                    a(c.ASSEMBLE_PUSH_FTOS);
                    a5.unregister();
                }
            }
        }
    }

    public AbstractPushManager a(c cVar) {
        return this.f223a.get(cVar);
    }

    public void a(PushConfiguration pushConfiguration) {
        this.f222a = pushConfiguration;
        this.f224a = true;
        if (pushConfiguration.getOpenHmsPush() || this.f222a.getOpenFCMPush() || this.f222a.getOpenCOSPush() || this.f222a.getOpenFTOSPush()) {
            at.a(this.f221a).a((a) new e(this, 101, "assemblePush"));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m373a(c cVar) {
        this.f223a.remove(cVar);
    }

    public void a(c cVar, AbstractPushManager abstractPushManager) {
        if (abstractPushManager != null) {
            if (this.f223a.containsKey(cVar)) {
                this.f223a.remove(cVar);
            }
            this.f223a.put(cVar, abstractPushManager);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m374a(c cVar) {
        return this.f223a.containsKey(cVar);
    }

    public boolean b(c cVar) {
        int i = f.f4365a[cVar.ordinal()];
        boolean z = false;
        if (i == 1) {
            PushConfiguration pushConfiguration = this.f222a;
            if (pushConfiguration != null) {
                return pushConfiguration.getOpenHmsPush();
            }
            return false;
        } else if (i != 2) {
            if (i == 3) {
                PushConfiguration pushConfiguration2 = this.f222a;
                if (pushConfiguration2 != null) {
                    z = pushConfiguration2.getOpenCOSPush();
                }
            } else if (i != 4) {
                return false;
            }
            PushConfiguration pushConfiguration3 = this.f222a;
            return pushConfiguration3 != null ? pushConfiguration3.getOpenFTOSPush() : z;
        } else {
            PushConfiguration pushConfiguration4 = this.f222a;
            if (pushConfiguration4 != null) {
                return pushConfiguration4.getOpenFCMPush();
            }
            return false;
        }
    }

    public void register() {
        b.a((String) "ASSEMBLE_PUSH : assemble push register");
        if (this.f223a.size() <= 0) {
            a();
        }
        if (this.f223a.size() > 0) {
            for (AbstractPushManager next : this.f223a.values()) {
                if (next != null) {
                    next.register();
                }
            }
            g.a(this.f221a);
        }
    }

    public void unregister() {
        b.a((String) "ASSEMBLE_PUSH : assemble push unregister");
        for (AbstractPushManager next : this.f223a.values()) {
            if (next != null) {
                next.unregister();
            }
        }
        this.f223a.clear();
    }
}
