package com.xiaomi.push.service;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.facebook.react.bridge.BaseJavaModule;
import com.xiaomi.channel.commonutils.android.f;
import com.xiaomi.channel.commonutils.android.j;
import com.xiaomi.channel.commonutils.android.k.a;
import com.xiaomi.push.BuildConfig;
import com.xiaomi.push.service.az.b;
import java.util.Locale;

public class q {

    /* renamed from: a  reason: collision with root package name */
    public final int f4967a;

    /* renamed from: a  reason: collision with other field name */
    public final String f936a;

    /* renamed from: b  reason: collision with root package name */
    public final String f4968b;

    /* renamed from: c  reason: collision with root package name */
    public final String f4969c;

    /* renamed from: d  reason: collision with root package name */
    public final String f4970d;

    /* renamed from: e  reason: collision with root package name */
    public final String f4971e;

    /* renamed from: f  reason: collision with root package name */
    public final String f4972f;

    public q(String str, String str2, String str3, String str4, String str5, String str6, int i) {
        this.f936a = str;
        this.f4968b = str2;
        this.f4969c = str3;
        this.f4970d = str4;
        this.f4971e = str5;
        this.f4972f = str6;
        this.f4967a = i;
    }

    public static String a(Context context) {
        if (!"com.xiaomi.xmsf".equals(context)) {
            return f.b();
        }
        if (!TextUtils.isEmpty(null)) {
            return null;
        }
        String a2 = f.a((String) "ro.miui.region");
        return TextUtils.isEmpty(a2) ? f.a((String) "ro.product.locale.region") : a2;
    }

    public static boolean a() {
        try {
            return j.a(null, "miui.os.Build").getField("IS_ALPHA_BUILD").getBoolean(null);
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m867a(Context context) {
        return "com.xiaomi.xmsf".equals(context.getPackageName()) && a();
    }

    public static boolean b(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }

    public b a(XMPushService xMPushService) {
        b bVar = new b(xMPushService);
        a(bVar, xMPushService, xMPushService.b(), "c");
        return bVar;
    }

    public b a(b bVar, Context context, j jVar, String str) {
        bVar.f869a = context.getPackageName();
        bVar.f872b = this.f936a;
        bVar.h = this.f4969c;
        bVar.f4882c = this.f4968b;
        bVar.g = "5";
        bVar.f4883d = "XMPUSH-PASS";
        bVar.f871a = false;
        a aVar = new a();
        aVar.a("sdk_ver", Integer.valueOf(48)).a("cpvn", BuildConfig.VERSION_NAME).a("cpvc", Integer.valueOf(BuildConfig.VERSION_CODE)).a("country_code", a.a(context).b()).a("region", a.a(context).a()).a("miui_vn", f.c()).a("miui_vc", Integer.valueOf(f.a(context))).a("xmsf_vc", Integer.valueOf(com.xiaomi.channel.commonutils.android.a.a(context, (String) "com.xiaomi.xmsf"))).a("android_ver", Integer.valueOf(VERSION.SDK_INT)).a("n_belong_to_app", Boolean.valueOf(aq.a(context))).a("systemui_vc", Integer.valueOf(com.xiaomi.channel.commonutils.android.a.a(context)));
        String a2 = a(context);
        if (!TextUtils.isEmpty(a2)) {
            aVar.a("latest_country_code", a2);
        }
        bVar.f4884e = aVar.toString();
        String str2 = b(context) ? "1000271" : this.f4970d;
        a aVar2 = new a();
        aVar2.a("appid", str2).a("locale", Locale.getDefault().toString()).a(BaseJavaModule.METHOD_TYPE_SYNC, Integer.valueOf(1));
        if (a(context)) {
            aVar2.a("ab", str);
        }
        bVar.f4885f = aVar2.toString();
        bVar.f868a = jVar;
        return bVar;
    }
}
