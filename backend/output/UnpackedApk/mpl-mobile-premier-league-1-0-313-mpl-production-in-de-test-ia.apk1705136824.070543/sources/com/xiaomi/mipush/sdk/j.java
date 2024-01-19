package com.xiaomi.mipush.sdk;

import com.xiaomi.push.db;
import java.util.HashMap;

public class j {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<c, a> f4369a = new HashMap<>();

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f4370a;

        /* renamed from: b  reason: collision with root package name */
        public String f4371b;

        public a(String str, String str2) {
            this.f4370a = str;
            this.f4371b = str2;
        }
    }

    static {
        a(c.ASSEMBLE_PUSH_HUAWEI, new a("com.xiaomi.assemble.control.HmsPushManager", "newInstance"));
        a(c.ASSEMBLE_PUSH_FCM, new a("com.xiaomi.assemble.control.FCMPushManager", "newInstance"));
        a(c.ASSEMBLE_PUSH_COS, new a("com.xiaomi.assemble.control.COSPushManager", "newInstance"));
        a(c.ASSEMBLE_PUSH_FTOS, new a("com.xiaomi.assemble.control.FTOSPushManager", "newInstance"));
    }

    public static am a(c cVar) {
        int i = k.f4372a[cVar.ordinal()];
        if (i == 1) {
            return am.UPLOAD_HUAWEI_TOKEN;
        }
        if (i == 2) {
            return am.UPLOAD_FCM_TOKEN;
        }
        if (i == 3) {
            return am.UPLOAD_COS_TOKEN;
        }
        if (i != 4) {
            return null;
        }
        return am.UPLOAD_FTOS_TOKEN;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static a m382a(c cVar) {
        return f4369a.get(cVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static db m383a(c cVar) {
        return null;
    }

    public static void a(c cVar, a aVar) {
        if (aVar != null) {
            f4369a.put(cVar, aVar);
        }
    }
}
