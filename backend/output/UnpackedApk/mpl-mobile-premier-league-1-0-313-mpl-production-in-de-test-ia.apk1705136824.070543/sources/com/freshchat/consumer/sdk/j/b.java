package com.freshchat.consumer.sdk.j;

import android.content.Context;
import com.freshchat.consumer.sdk.beans.BotFAQFetchRequest;
import com.freshchat.consumer.sdk.beans.FAQCategoryFetchRequest;
import com.freshchat.consumer.sdk.beans.FAQFetchRequest;
import com.freshchat.consumer.sdk.beans.MarketingMessageStatus;
import com.freshchat.consumer.sdk.beans.Message;
import com.freshchat.consumer.sdk.beans.User;
import com.freshchat.consumer.sdk.beans.UserEvent;
import com.freshchat.consumer.sdk.beans.fragment.CallbackButtonFragment;
import com.freshchat.consumer.sdk.l.a;
import com.freshchat.consumer.sdk.service.a.c;
import com.freshchat.consumer.sdk.service.d.d;
import com.freshchat.consumer.sdk.service.e.aa;
import com.freshchat.consumer.sdk.service.e.ab;
import com.freshchat.consumer.sdk.service.e.ac;
import com.freshchat.consumer.sdk.service.e.ad;
import com.freshchat.consumer.sdk.service.e.ah;
import com.freshchat.consumer.sdk.service.e.ak;
import com.freshchat.consumer.sdk.service.e.am;
import com.freshchat.consumer.sdk.service.e.ap;
import com.freshchat.consumer.sdk.service.e.e;
import com.freshchat.consumer.sdk.service.e.f;
import com.freshchat.consumer.sdk.service.e.m;
import com.freshchat.consumer.sdk.service.e.p;
import com.freshchat.consumer.sdk.service.e.q;
import com.freshchat.consumer.sdk.service.e.u;
import com.freshchat.consumer.sdk.service.e.v;
import com.freshchat.consumer.sdk.service.e.x;
import com.freshchat.consumer.sdk.service.e.y;
import com.freshchat.consumer.sdk.service.e.z;
import java.util.List;
import java.util.Map;

public class b {
    public static void L(Context context) {
        if (context != null) {
            d.b(context, new e());
        }
    }

    public static void M(Context context) {
        if (context != null) {
            d.b(context, new m());
        }
    }

    public static void Q(Context context, String str) {
        if (context != null && !as.isEmpty(str)) {
            y yVar = new y();
            yVar.K(str);
            if (a.gR().bW(context)) {
                d.b(context, yVar);
            } else {
                c.a(context, yVar);
            }
        }
    }

    public static void R(Context context) {
    }

    public static void S(Context context) {
        if (context != null) {
            d.b(context, new u());
        }
    }

    public static void T(Context context) {
        if (context != null) {
            d.b(context, new p());
        }
    }

    public static void U(Context context) {
        a(context, (com.freshchat.consumer.sdk.service.a) null);
    }

    public static void V(Context context) {
        if (context != null) {
            d.b(context, new com.freshchat.consumer.sdk.service.e.c());
        }
    }

    public static void a(Context context, int i, com.freshchat.consumer.sdk.service.e.d.a aVar) {
        a(context, i, aVar, (com.freshchat.consumer.sdk.service.a) null);
    }

    public static void a(Context context, int i, com.freshchat.consumer.sdk.service.e.d.a aVar, com.freshchat.consumer.sdk.service.a aVar2) {
        if (context != null) {
            if (aVar == null) {
                aVar = com.freshchat.consumer.sdk.service.e.d.a.NORMAL;
            }
            com.freshchat.consumer.sdk.service.e.d dVar = new com.freshchat.consumer.sdk.service.e.d();
            dVar.p(i);
            dVar.b(aVar);
            if (aVar2 == null) {
                d.b(context, dVar);
            } else {
                d.c(context, dVar, aVar2);
            }
        }
    }

    public static void a(Context context, MarketingMessageStatus marketingMessageStatus) {
        if (context != null && marketingMessageStatus != null) {
            aa aaVar = new aa();
            aaVar.a(marketingMessageStatus);
            d.b(context, aaVar);
        }
    }

    public static void a(Context context, Message message) {
        a(context, message, (com.freshchat.consumer.sdk.service.a) null);
    }

    public static void a(Context context, Message message, com.freshchat.consumer.sdk.service.a aVar) {
        if (context != null) {
            q j = new q().j(message);
            if (aVar == null) {
                d.b(context, j);
            } else {
                d.c(context, j, aVar);
            }
        }
    }

    public static void a(Context context, User user) {
        a(context, user, false);
    }

    public static void a(Context context, User user, boolean z) {
        a(context, user, z, false);
    }

    public static void a(Context context, User user, boolean z, boolean z2) {
        if (context != null) {
            com.freshchat.consumer.sdk.service.e.a aVar = new com.freshchat.consumer.sdk.service.e.a();
            aVar.setUser(user);
            aVar.n(z);
            aVar.o(z2);
            d.b(context, aVar);
        }
    }

    public static void a(Context context, com.freshchat.consumer.sdk.service.a aVar) {
        ad adVar = new ad();
        adVar.p(true);
        if (aVar == null) {
            d.b(context, adVar);
        } else {
            d.c(context, adVar, aVar);
        }
    }

    public static void a(Context context, com.freshchat.consumer.sdk.service.e.b.a aVar) {
        a(context, aVar, (com.freshchat.consumer.sdk.service.a) null);
    }

    public static void a(Context context, com.freshchat.consumer.sdk.service.e.b.a aVar, com.freshchat.consumer.sdk.service.a aVar2) {
        if (context != null) {
            if (aVar == null) {
                aVar = com.freshchat.consumer.sdk.service.e.b.a.LAID_BACK;
            }
            com.freshchat.consumer.sdk.service.e.b bVar = new com.freshchat.consumer.sdk.service.e.b();
            bVar.b(aVar);
            d.b(context, bVar);
        }
    }

    public static void a(Context context, f.a aVar) {
        if (context != null && !y.cp(context)) {
            if (aVar == null) {
                aVar = f.a.LAID_BACK;
            }
            f fVar = new f();
            fVar.b(aVar);
            d.b(context, fVar);
        }
    }

    public static void a(Context context, z.a aVar) {
        if (context != null && aVar != null) {
            z zVar = new z();
            zVar.a(aVar);
            d.b(context, zVar);
        }
    }

    public static void a(Context context, String str, int i, List<String> list) {
        if (context != null && !as.isEmpty(str)) {
            d.b(context, new ak(str, i, list));
        }
    }

    public static void a(Context context, String str, CallbackButtonFragment callbackButtonFragment) {
        a(context, str, callbackButtonFragment, (String) null);
    }

    public static void a(Context context, String str, CallbackButtonFragment callbackButtonFragment, String str2) {
        if (!as.isEmpty(str) && callbackButtonFragment != null) {
            d.b(context, new ap(str, callbackButtonFragment, str2));
        }
    }

    public static void a(Context context, String str, String str2, am.a aVar, String str3, String str4) {
        if (context != null && aVar != null && !as.isEmpty(str) && !as.isEmpty(str2) && !as.isEmpty(str3)) {
            am amVar = new am(str, str2, str3, aVar, str4);
            d.b(context, amVar);
        }
    }

    public static void a(Context context, String str, Map<String, UserEvent> map) {
        if (context != null && !as.isEmpty(str) && !k.c(map)) {
            d.b(context, new ac(str, map));
        }
    }

    public static void b(Context context, int i, List<String> list) {
        if (context != null) {
            d.b(context, new FAQCategoryFetchRequest(i, list));
        }
    }

    public static void b(Context context, long j, long j2) {
        if (context != null) {
            d.b(context, new x(j, j2));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003f, code lost:
        if ((java.lang.System.currentTimeMillis() - java.lang.Long.parseLong(r1)) > r2.getRefreshIntervals().getMsgFetchIntervalNormal()) goto L_0x0013;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0048  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void bJ(android.content.Context r8) {
        /*
            if (r8 != 0) goto L_0x0003
            return
        L_0x0003:
            r0 = 0
            com.freshchat.consumer.sdk.b.e r1 = com.freshchat.consumer.sdk.b.e.i(r8)
            java.lang.String r1 = r1.bJ()
            boolean r2 = com.freshchat.consumer.sdk.j.as.isEmpty(r1)
            r3 = 1
            if (r2 == 0) goto L_0x0015
        L_0x0013:
            r0 = 1
            goto L_0x0046
        L_0x0015:
            com.freshchat.consumer.sdk.beans.config.RemoteConfig r2 = com.freshchat.consumer.sdk.j.ap.bD(r8)     // Catch:{ Exception -> 0x0042 }
            com.freshchat.consumer.sdk.c.g r4 = new com.freshchat.consumer.sdk.c.g     // Catch:{ Exception -> 0x0042 }
            r4.<init>(r8)     // Catch:{ Exception -> 0x0042 }
            com.freshchat.consumer.sdk.beans.config.ConversationConfig r5 = r2.getConversationConfig()     // Catch:{ Exception -> 0x0042 }
            long r5 = r5.getActiveConvWindow()     // Catch:{ Exception -> 0x0042 }
            boolean r4 = r4.p(r5)     // Catch:{ Exception -> 0x0042 }
            if (r4 == 0) goto L_0x0046
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0042 }
            long r6 = java.lang.Long.parseLong(r1)     // Catch:{ Exception -> 0x0042 }
            com.freshchat.consumer.sdk.beans.config.RefreshIntervals r1 = r2.getRefreshIntervals()     // Catch:{ Exception -> 0x0042 }
            long r1 = r1.getMsgFetchIntervalNormal()     // Catch:{ Exception -> 0x0042 }
            long r4 = r4 - r6
            int r6 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r6 <= 0) goto L_0x0046
            goto L_0x0013
        L_0x0042:
            r1 = move-exception
            com.freshchat.consumer.sdk.j.q.a(r1)
        L_0x0046:
            if (r0 == 0) goto L_0x004f
            r0 = 14
            com.freshchat.consumer.sdk.service.e.d$a r1 = com.freshchat.consumer.sdk.service.e.d.a.IMMEDIATE
            a(r8, r0, r1)
        L_0x004f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.j.b.bJ(android.content.Context):void");
    }

    public static void c(Context context, int i, String str, List<String> list) {
        if (context != null && !as.isEmpty(str)) {
            d.b(context, new ah(i, str, list));
        }
    }

    public static void h(Context context, String str, String str2) {
        if (context != null && !as.isEmpty(str2) && !as.isEmpty(str)) {
            d.b(context, new FAQFetchRequest(str, str2));
        }
    }

    public static void k(Context context, String str, String str2) {
        if (context != null && !as.isEmpty(str) && !as.isEmpty(str2)) {
            d.b(context, new BotFAQFetchRequest(str, str2));
        }
    }

    public static void r(Context context, String str) {
        if (context != null && !as.isEmpty(str)) {
            v vVar = new v();
            vVar.t(str);
            d.b(context, vVar);
        }
    }

    public static void t(Context context, String str) {
        d.b(context, new ab(str));
    }

    public static void u(Context context) {
        if (context != null) {
            a(context, new User(), false, true);
        }
    }
}
