package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.xiaomi.channel.commonutils.android.f;
import com.xiaomi.push.bi;
import com.xiaomi.push.ch;
import com.xiaomi.push.ci;
import com.xiaomi.push.cj;
import com.xiaomi.push.cl;
import com.xiaomi.push.service.az.b;
import java.util.Collection;
import java.util.Iterator;

public class j {

    /* renamed from: a  reason: collision with root package name */
    public v f4950a = new v();

    public static String a(b bVar) {
        String str;
        StringBuilder sb;
        if (!"9".equals(bVar.g)) {
            sb = new StringBuilder();
            sb.append(bVar.f869a);
            str = ".permission.MIPUSH_RECEIVE";
        } else {
            sb = new StringBuilder();
            sb.append(bVar.f869a);
            str = ".permission.MIMC_RECEIVE";
        }
        sb.append(str);
        return sb.toString();
    }

    public static void a(Context context, Intent intent, b bVar) {
        if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
            context.sendBroadcast(intent);
        } else {
            context.sendBroadcast(intent, a(bVar));
        }
    }

    public b a(bi biVar) {
        Collection a2 = az.a().a(Integer.toString(biVar.a()));
        if (a2.isEmpty()) {
            return null;
        }
        Iterator it = a2.iterator();
        if (a2.size() == 1) {
            return (b) it.next();
        }
        String g = biVar.g();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (TextUtils.equals(g, bVar.f872b)) {
                return bVar;
            }
        }
        return null;
    }

    public b a(cj cjVar) {
        Collection a2 = az.a().a(cjVar.k());
        if (a2.isEmpty()) {
            return null;
        }
        Iterator it = a2.iterator();
        if (a2.size() == 1) {
            return (b) it.next();
        }
        String m = cjVar.m();
        String l = cjVar.l();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (!TextUtils.equals(m, bVar.f872b)) {
                if (TextUtils.equals(l, bVar.f872b)) {
                }
            }
            return bVar;
        }
        return null;
    }

    @SuppressLint({"WrongConstant"})
    public void a(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.service_started");
        if (f.b()) {
            intent.addFlags(16777216);
        }
        com.xiaomi.channel.commonutils.logger.b.a((String) "[Bcst] send ***.push.service_started broadcast to inform push service has started.");
        context.sendBroadcast(intent);
    }

    @SuppressLint({"DefaultLocale"})
    public void a(Context context, b bVar, int i) {
        if (!"5".equalsIgnoreCase(bVar.g)) {
            Intent intent = new Intent();
            intent.setAction("com.xiaomi.push.channel_closed");
            intent.setPackage(bVar.f869a);
            intent.putExtra(bd.u, bVar.g);
            intent.putExtra("ext_reason", i);
            intent.putExtra(bd.r, bVar.f872b);
            intent.putExtra(bd.G, bVar.i);
            if (bVar.f863a == null || !"9".equals(bVar.g)) {
                com.xiaomi.channel.commonutils.logger.b.a(String.format("[Bcst] notify channel closed. %s,%s,%d", new Object[]{bVar.g, bVar.f869a, Integer.valueOf(i)}));
                a(context, intent, bVar);
            } else {
                try {
                    bVar.f863a.send(Message.obtain(null, 17, intent));
                } catch (RemoteException unused) {
                    bVar.f863a = null;
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("peer may died: ");
                    String str = bVar.f872b;
                    outline73.append(str.substring(str.lastIndexOf(64)));
                    com.xiaomi.channel.commonutils.logger.b.a(outline73.toString());
                }
            }
        }
    }

    public void a(Context context, b bVar, String str, String str2) {
        if (bVar == null) {
            com.xiaomi.channel.commonutils.logger.b.d("error while notify kick by server!");
            return;
        }
        if ("5".equalsIgnoreCase(bVar.g)) {
            com.xiaomi.channel.commonutils.logger.b.d("mipush kicked by server");
        } else {
            Intent intent = new Intent();
            intent.setAction("com.xiaomi.push.kicked");
            intent.setPackage(bVar.f869a);
            intent.putExtra("ext_kick_type", str);
            intent.putExtra("ext_kick_reason", str2);
            intent.putExtra("ext_chid", bVar.g);
            intent.putExtra(bd.r, bVar.f872b);
            intent.putExtra(bd.G, bVar.i);
            com.xiaomi.channel.commonutils.logger.b.a(String.format("[Bcst] notify packet(blob) arrival. %s,%s,%s", new Object[]{bVar.g, bVar.f869a, str2}));
            a(context, intent, bVar);
        }
    }

    @SuppressLint({"DefaultLocale"})
    public void a(Context context, b bVar, boolean z, int i, String str) {
        if ("5".equalsIgnoreCase(bVar.g)) {
            this.f4950a.a(context, bVar, z, i, str);
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.channel_opened");
        intent.setPackage(bVar.f869a);
        intent.putExtra("ext_succeeded", z);
        if (!z) {
            intent.putExtra("ext_reason", i);
        }
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("ext_reason_msg", str);
        }
        intent.putExtra("ext_chid", bVar.g);
        intent.putExtra(bd.r, bVar.f872b);
        intent.putExtra(bd.G, bVar.i);
        com.xiaomi.channel.commonutils.logger.b.a(String.format("[Bcst] notify channel open result. %s,%s,%b,%d", new Object[]{bVar.g, bVar.f869a, Boolean.valueOf(z), Integer.valueOf(i)}));
        a(context, intent, bVar);
    }

    public void a(XMPushService xMPushService, String str, bi biVar) {
        b a2 = a(biVar);
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.d("error while notify channel closed! channel " + str + " not registered");
            return;
        }
        if ("5".equalsIgnoreCase(str)) {
            this.f4950a.a(xMPushService, biVar, a2);
        } else {
            String str2 = a2.f869a;
            Intent intent = new Intent();
            intent.setAction("com.xiaomi.push.new_msg");
            intent.setPackage(str2);
            intent.putExtra("ext_rcv_timestamp", SystemClock.elapsedRealtime());
            intent.putExtra("ext_chid", str);
            intent.putExtra("ext_raw_packet", biVar.a(a2.h));
            intent.putExtra(bd.G, a2.i);
            intent.putExtra(bd.y, a2.h);
            if (a2.f863a != null) {
                try {
                    a2.f863a.send(Message.obtain(null, 17, intent));
                    com.xiaomi.channel.commonutils.logger.b.a("message was sent by messenger for chid=" + str);
                    return;
                } catch (RemoteException unused) {
                    a2.f863a = null;
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("peer may died: ");
                    String str3 = a2.f872b;
                    outline73.append(str3.substring(str3.lastIndexOf(64)));
                    com.xiaomi.channel.commonutils.logger.b.a(outline73.toString());
                }
            }
            if (!"com.xiaomi.xmsf".equals(str2)) {
                com.xiaomi.channel.commonutils.logger.b.a(String.format("[Bcst] notify packet(blob) arrival. %s,%s,%s", new Object[]{a2.g, a2.f869a, biVar.e()}));
                a((Context) xMPushService, intent, a2);
            }
        }
    }

    public void a(XMPushService xMPushService, String str, cj cjVar) {
        String str2;
        String str3;
        b a2 = a(cjVar);
        if (a2 == null) {
            str3 = "error while notify channel closed! channel " + str + " not registered";
        } else {
            if ("5".equalsIgnoreCase(str)) {
                this.f4950a.a(xMPushService, cjVar, a2);
            } else {
                String str4 = a2.f869a;
                if (cjVar instanceof ci) {
                    str2 = "com.xiaomi.push.new_msg";
                } else if (cjVar instanceof ch) {
                    str2 = "com.xiaomi.push.new_iq";
                } else if (cjVar instanceof cl) {
                    str2 = "com.xiaomi.push.new_pres";
                } else {
                    str3 = "unknown packet type, drop it";
                }
                Intent intent = new Intent();
                intent.setAction(str2);
                intent.setPackage(str4);
                intent.putExtra("ext_chid", str);
                intent.putExtra("ext_packet", cjVar.a());
                intent.putExtra(bd.G, a2.i);
                intent.putExtra(bd.y, a2.h);
                com.xiaomi.channel.commonutils.logger.b.a(String.format("[Bcst] notify packet arrival. %s,%s,%s", new Object[]{a2.g, a2.f869a, cjVar.j()}));
                a((Context) xMPushService, intent, a2);
            }
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.d(str3);
    }
}
