package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.login.LoginReactModule;
import com.xiaomi.channel.commonutils.android.f;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.cz;
import com.xiaomi.push.df;
import com.xiaomi.push.dq;
import com.xiaomi.push.dt;
import java.util.HashMap;

public class n {

    /* renamed from: a  reason: collision with root package name */
    public static volatile n f4374a;

    /* renamed from: a  reason: collision with other field name */
    public final Context f227a;

    public n(Context context) {
        this.f227a = context.getApplicationContext();
    }

    public static n a(Context context) {
        if (f4374a == null) {
            synchronized (n.class) {
                if (f4374a == null) {
                    f4374a = new n(context);
                }
            }
        }
        return f4374a;
    }

    public static void a(Context context, dq dqVar) {
        a(context).a(dqVar, 0, true);
    }

    public static void a(Context context, dq dqVar, boolean z) {
        a(context).a(dqVar, 1, z);
    }

    private void a(dq dqVar, int i, boolean z) {
        if (!f.a(this.f227a) && f.a() && dqVar != null && dqVar.f576a == cz.SendMessage && dqVar.a() != null && z) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("click to start activity result:");
            outline73.append(String.valueOf(i));
            b.a(outline73.toString());
            dt dtVar = new dt(dqVar.a().a(), false);
            dtVar.c(df.SDK_START_ACTIVITY.f458a);
            dtVar.b(dqVar.a());
            dtVar.d(dqVar.f583b);
            HashMap hashMap = new HashMap();
            dtVar.f595a = hashMap;
            hashMap.put(LoginReactModule.RESULT, String.valueOf(i));
            ag.a(this.f227a).a(dtVar, cz.Notification, false, false, null, true, dqVar.f583b, dqVar.f579a, true, false);
        }
    }

    public static void b(Context context, dq dqVar, boolean z) {
        a(context).a(dqVar, 2, z);
    }

    public static void c(Context context, dq dqVar, boolean z) {
        a(context).a(dqVar, 3, z);
    }

    public static void d(Context context, dq dqVar, boolean z) {
        a(context).a(dqVar, 4, z);
    }

    public static void e(Context context, dq dqVar, boolean z) {
        n nVar;
        int i;
        a a2 = a.a(context);
        if (TextUtils.isEmpty(a2.c()) || TextUtils.isEmpty(a2.d())) {
            nVar = a(context);
            i = 6;
        } else {
            boolean f2 = a2.f();
            nVar = a(context);
            i = f2 ? 7 : 5;
        }
        nVar.a(dqVar, i, z);
    }
}
