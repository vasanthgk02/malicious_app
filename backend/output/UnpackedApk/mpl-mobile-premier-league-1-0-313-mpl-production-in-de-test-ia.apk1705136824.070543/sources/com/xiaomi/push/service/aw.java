package com.xiaomi.push.service;

import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ad;

public class aw {

    /* renamed from: a  reason: collision with root package name */
    public static long f4876a = 0;

    /* renamed from: a  reason: collision with other field name */
    public static String f858a = "";

    public static String a() {
        if (TextUtils.isEmpty(f858a)) {
            f858a = ad.a(4);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(f858a);
        long j = f4876a;
        f4876a = 1 + j;
        sb.append(j);
        return sb.toString();
    }

    public static String a(String str) {
        if (!TextUtils.isEmpty(str) && str.length() >= 32) {
            try {
                return "BlockId_" + str.substring(8);
            } catch (Exception e2) {
                b.d("Exception occurred when filtering registration packet id for log. " + e2);
                str = "UnexpectedId";
            }
        }
        return str;
    }

    public static String b() {
        return ad.a(32);
    }
}
