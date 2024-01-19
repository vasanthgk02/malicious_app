package com.freshchat.consumer.sdk.service.c;

import android.content.Context;
import com.freshchat.consumer.sdk.b.e;
import com.freshchat.consumer.sdk.beans.User;
import com.freshchat.consumer.sdk.beans.config.RemoteConfig;
import com.freshchat.consumer.sdk.c.g;
import com.freshchat.consumer.sdk.j.aa;
import com.freshchat.consumer.sdk.j.ah;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.al;
import com.freshchat.consumer.sdk.j.ap;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.b;
import com.freshchat.consumer.sdk.j.by;
import com.freshchat.consumer.sdk.j.d;
import com.freshchat.consumer.sdk.j.w;
import com.freshchat.consumer.sdk.j.x;
import com.freshchat.consumer.sdk.j.y;
import com.freshchat.consumer.sdk.service.a.c;
import com.freshchat.consumer.sdk.service.e.af;
import com.freshchat.consumer.sdk.service.e.b.a;
import com.freshchat.consumer.sdk.service.e.f;
import com.freshchat.consumer.sdk.service.e.h;
import com.freshchat.consumer.sdk.service.e.l;
import java.util.concurrent.atomic.AtomicBoolean;

public class k extends b<l, com.freshchat.consumer.sdk.service.e.k> {
    public static AtomicBoolean fL = new AtomicBoolean(false);

    public static void b(Context context, l lVar) {
        ai.i("AppStateListener", "Initialise SDK called ");
        y.a(context, lVar);
        fL.set(true);
        e i = e.i(context);
        if (as.isEmpty(i.bj())) {
            i.t(d.C(context));
        }
        b.L(context);
        b.S(context);
        b.a(context, a.LAID_BACK);
        if (i.bl()) {
            g gVar = new g(context);
            RemoteConfig bD = ap.bD(context);
            boolean z = false;
            if (!(bD == null || bD.getConversationConfig() == null)) {
                z = gVar.p(bD.getConversationConfig().getActiveConvWindow());
            }
            if (z || w.aC(context)) {
                b.a(context, 2, com.freshchat.consumer.sdk.service.e.d.a.LAID_BACK);
            }
        } else if (w.aB(context)) {
            b.a(context, (User) null, true);
        }
        b.a(context, f.a.LAID_BACK);
        if (ah.aQ(context) || com.freshchat.consumer.sdk.j.g.ag(context)) {
            b.u(context);
        }
        b.T(context);
        by.gN().d(context, true);
        b.R(context);
        if (i.eO()) {
            ai.i("FRESHCHAT", "Scheduling Prefs Migration");
            com.freshchat.consumer.sdk.service.d.d.b(context, new af());
        }
    }

    /* renamed from: a */
    public com.freshchat.consumer.sdk.service.e.k b(l lVar) {
        Context context = getContext();
        e i = e.i(context);
        boolean z = false;
        if (fL.get() && i.bl()) {
            return new h(false);
        }
        boolean z2 = (as.m(i.getAppId(), lVar.getAppId()) ^ true) || (as.m(i.getAppKey(), lVar.getAppKey()) ^ true) || (as.q(i.getDomain(), lVar.getDomain()) ^ true);
        if (as.isEmpty(i.getAppId()) || as.isEmpty(i.getAppKey())) {
            z = true;
        }
        if (z) {
            b(context, lVar);
            return new h(true);
        } else if (z2) {
            aa.aK(context);
            b(context, lVar);
            return new h(true);
        } else {
            com.freshchat.consumer.sdk.l.a gR = com.freshchat.consumer.sdk.l.a.gR();
            if (gR.bW(context)) {
                b(context, lVar);
            } else {
                gR.bX(context);
            }
            if (c.s(context)) {
                if (al.aS(context)) {
                    b.M(context);
                }
                aa.aM(context);
                com.freshchat.consumer.sdk.j.e.Y(context);
            } else {
                aa.aN(context);
            }
            aa.a(context, new g(context).cC());
            x.cl(context);
            return new h(true);
        }
    }
}
