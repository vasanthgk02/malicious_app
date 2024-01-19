package com.xiaomi.push.service;

import android.content.Context;
import android.os.Messenger;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ColorPropConverter;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.bi;
import com.xiaomi.push.bt;
import com.xiaomi.push.cd;
import com.xiaomi.push.cj;
import com.xiaomi.push.cz;
import com.xiaomi.push.df;
import com.xiaomi.push.di;
import com.xiaomi.push.dk;
import com.xiaomi.push.dq;
import com.xiaomi.push.dt;
import com.xiaomi.push.ee;
import com.xiaomi.push.ef;
import com.xiaomi.push.ej;
import com.xiaomi.push.service.bp.a;
import java.nio.ByteBuffer;
import java.util.Map;

public final class ad {
    public static bi a(XMPushService xMPushService, byte[] bArr) {
        dq dqVar = new dq();
        try {
            ee.a(dqVar, bArr);
            return a(r.a((Context) xMPushService), (Context) xMPushService, dqVar);
        } catch (ej e2) {
            b.a((Throwable) e2);
            return null;
        }
    }

    public static bi a(q qVar, Context context, dq dqVar) {
        try {
            bi biVar = new bi();
            biVar.a(5);
            biVar.c(qVar.f936a);
            biVar.b(a(dqVar));
            biVar.a((String) "SECMSG", (String) "message");
            String str = qVar.f936a;
            dqVar.f578a.f507a = str.substring(0, str.indexOf(ColorPropConverter.PREFIX_RESOURCE));
            dqVar.f578a.f511c = str.substring(str.indexOf("/") + 1);
            biVar.a(ee.a(dqVar), qVar.f4969c);
            biVar.a(1);
            b.a("try send mi push message. packagename:" + dqVar.f583b + " action:" + dqVar.f576a);
            return biVar;
        } catch (NullPointerException e2) {
            b.a((Throwable) e2);
            return null;
        }
    }

    public static dq a(String str, String str2) {
        dt dtVar = new dt();
        dtVar.b(str2);
        dtVar.c((String) "package uninstalled");
        dtVar.a(cj.i());
        dtVar.a(false);
        return a(str, str2, dtVar, cz.Notification);
    }

    public static <T extends ef<T, ?>> dq a(String str, String str2, T t, cz czVar) {
        return a(str, str2, t, czVar, true);
    }

    public static <T extends ef<T, ?>> dq a(String str, String str2, T t, cz czVar, boolean z) {
        byte[] a2 = ee.a(t);
        dq dqVar = new dq();
        dk dkVar = new dk();
        dkVar.f506a = 5;
        dkVar.f507a = "fakeid";
        dqVar.a(dkVar);
        dqVar.a(ByteBuffer.wrap(a2));
        dqVar.a(czVar);
        dqVar.b(z);
        dqVar.b(str);
        dqVar.a(false);
        dqVar.a(str2);
        return dqVar;
    }

    public static String a(dq dqVar) {
        di diVar = dqVar.f577a;
        if (diVar != null) {
            Map<String, String> map = diVar.f497b;
            if (map != null) {
                String str = map.get("ext_traffic_source_pkg");
                if (!TextUtils.isEmpty(str)) {
                    return str;
                }
            }
        }
        return dqVar.f583b;
    }

    public static String a(String str) {
        return GeneratedOutlineSupport.outline50(str, ".permission.MIPUSH_RECEIVE");
    }

    public static void a(XMPushService xMPushService) {
        q a2 = r.a(xMPushService.getApplicationContext());
        if (a2 != null) {
            az.b a3 = r.a(xMPushService.getApplicationContext()).a(xMPushService);
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("prepare account. ");
            outline73.append(a3.f869a);
            b.a(outline73.toString());
            a(xMPushService, a3);
            az.a().a(a3);
            bp a4 = bp.a((Context) xMPushService);
            ae aeVar = new ae("GAID", 172800, xMPushService, a2);
            a4.a((a) aeVar);
        }
    }

    public static void a(XMPushService xMPushService, dq dqVar) {
        bt a2 = xMPushService.a();
        if (a2 == null) {
            throw new cd((String) "try send msg while connection is null.");
        } else if (a2.a()) {
            bi a3 = a(r.a((Context) xMPushService), (Context) xMPushService, dqVar);
            if (a3 != null) {
                a2.b(a3);
            }
        } else {
            throw new cd((String) "Don't support XMPP connection.");
        }
    }

    public static void a(XMPushService xMPushService, az.b bVar) {
        bVar.a((Messenger) null);
        bVar.a((az.b.a) new af(xMPushService));
    }

    public static void a(XMPushService xMPushService, String str, byte[] bArr) {
        bt a2 = xMPushService.a();
        if (a2 == null) {
            throw new cd((String) "try send msg while connection is null.");
        } else if (a2.a()) {
            bi a3 = a(xMPushService, bArr);
            if (a3 != null) {
                a2.b(a3);
            } else {
                u.a(xMPushService, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, "not a valid message");
            }
        } else {
            throw new cd((String) "Don't support XMPP connection.");
        }
    }

    public static dq b(String str, String str2) {
        dt dtVar = new dt();
        dtVar.b(str2);
        dtVar.c(df.AppDataCleared.f458a);
        dtVar.a(aw.a());
        dtVar.a(false);
        return a(str, str2, dtVar, cz.Notification);
    }

    public static <T extends ef<T, ?>> dq b(String str, String str2, T t, cz czVar) {
        return a(str, str2, t, czVar, false);
    }
}
