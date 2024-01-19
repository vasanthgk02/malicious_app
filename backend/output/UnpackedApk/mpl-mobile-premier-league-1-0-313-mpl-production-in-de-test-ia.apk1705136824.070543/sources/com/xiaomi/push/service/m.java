package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Base64;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.aa;
import com.xiaomi.push.dq;
import com.xiaomi.push.dv;
import com.xiaomi.push.ee;
import com.xiaomi.push.ej;

public class m {
    public static dv a(dq dqVar) {
        byte[] a2 = dqVar.a();
        dv dvVar = new dv();
        try {
            ee.a(dvVar, a2);
            return dvVar;
        } catch (ej unused) {
            return null;
        }
    }

    public static void a(Context context, Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("ext_fcm_container_buffer");
            String stringExtra2 = intent.getStringExtra("mipush_app_package");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                try {
                    byte[] b2 = b(Base64.decode(stringExtra, 2), context.getSharedPreferences("mipush_apps_scrt", 0).getString(stringExtra2, null));
                    if (b2 != null) {
                        ag.a(context, v.a(b2), b2);
                    } else {
                        b.a((String) "notify fcm notification error ：dencrypt failed");
                    }
                } catch (Throwable th) {
                    b.a((String) "notify fcm notification error ", th);
                }
            }
        }
    }

    public static void a(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            context.getSharedPreferences("mipush_apps_scrt", 0).edit().putString(str, str2).apply();
        }
    }

    public static byte[] a(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            b.a((String) "secret is empty, return null");
            return null;
        }
        try {
            return com.xiaomi.channel.commonutils.android.b.b(aa.a(str), bArr);
        } catch (Exception e2) {
            b.a((String) "encryption error. ", (Throwable) e2);
            return null;
        }
    }

    public static byte[] b(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            b.a((String) "secret is empty, return null");
            return null;
        }
        try {
            return com.xiaomi.channel.commonutils.android.b.a(aa.a(str), bArr);
        } catch (Exception e2) {
            b.a((String) "dencryption error. ", (Throwable) e2);
            return null;
        }
    }
}
