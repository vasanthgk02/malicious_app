package com.xiaomi.push.service;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.xiaomi.channel.commonutils.android.j;
import com.xiaomi.push.ag;
import com.xiaomi.push.aj;
import com.xiaomi.push.ak;
import com.xiaomi.push.bt;
import com.xiaomi.push.cu;
import com.xiaomi.push.y;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public class be extends com.xiaomi.push.service.bn.a implements com.xiaomi.push.ak.a {

    /* renamed from: a  reason: collision with root package name */
    public long f4904a;

    /* renamed from: a  reason: collision with other field name */
    public XMPushService f880a;

    public static class a implements com.xiaomi.push.ak.b {
        public String a(String str) {
            Builder buildUpon = Uri.parse(str).buildUpon();
            buildUpon.appendQueryParameter("sdkver", String.valueOf(48));
            buildUpon.appendQueryParameter("osver", String.valueOf(VERSION.SDK_INT));
            buildUpon.appendQueryParameter("os", cu.a(Build.MODEL + ":" + VERSION.INCREMENTAL));
            buildUpon.appendQueryParameter("mi", String.valueOf(j.a()));
            URL url = new URL(buildUpon.toString());
            if (url.getPort() != -1) {
                url.getPort();
            }
            try {
                System.currentTimeMillis();
                String a2 = y.a(j.a(), url);
                System.currentTimeMillis();
                return a2;
            } catch (IOException e2) {
                throw e2;
            }
        }
    }

    public static class b extends ak {
        public b(Context context, aj ajVar, com.xiaomi.push.ak.b bVar, String str) {
            super(context, ajVar, bVar, str);
        }

        public String a(ArrayList<String> arrayList, String str, String str2, boolean z) {
            try {
                return super.a(arrayList, str, str2, z);
            } catch (IOException e2) {
                y.b(ak.f4404a);
                throw e2;
            }
        }
    }

    public be(XMPushService xMPushService) {
        this.f880a = xMPushService;
    }

    public static void a(XMPushService xMPushService) {
        be beVar = new be(xMPushService);
        bn.a().a((com.xiaomi.push.service.bn.a) beVar);
        synchronized (ak.class) {
            ak.a((com.xiaomi.push.ak.a) beVar);
            ak.a(xMPushService, null, new a(), "0", "push", "2.2");
        }
    }

    public ak a(Context context, aj ajVar, com.xiaomi.push.ak.b bVar, String str) {
        return new b(context, ajVar, bVar, str);
    }

    public void a(com.xiaomi.push.at.a aVar) {
    }

    public void a(com.xiaomi.push.au.b bVar) {
        if (bVar.b() && bVar.a() && System.currentTimeMillis() - this.f4904a > 3600000) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("fetch bucket :");
            outline73.append(bVar.a());
            com.xiaomi.channel.commonutils.logger.b.a(outline73.toString());
            this.f4904a = System.currentTimeMillis();
            ak a2 = ak.a();
            a2.a();
            a2.c();
            bt a3 = this.f880a.a();
            if (a3 != null) {
                ag b2 = a2.b(a3.a().c());
                if (b2 != null) {
                    ArrayList a4 = b2.a();
                    boolean z = true;
                    Iterator it = a4.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (((String) it.next()).equals(a3.a())) {
                                z = false;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (z && !a4.isEmpty()) {
                        com.xiaomi.channel.commonutils.logger.b.a((String) "bucket changed, force reconnect");
                        this.f880a.a(0, (Exception) null);
                        this.f880a.a(false);
                    }
                }
            }
        }
    }
}
