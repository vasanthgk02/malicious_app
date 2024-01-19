package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.z;

public class l {

    /* renamed from: a  reason: collision with root package name */
    public static int f4373a = -1;

    public static y a(Context context) {
        return y.OTHER;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m384a(Context context) {
        return a(context, "com.google.android.gms.common.GoogleApiAvailability") || a(context, "com.google.android.gms.common.GoogleApiAvailabilityLight");
    }

    public static boolean a(Context context, String str) {
        Class<Integer> cls = Integer.class;
        boolean z = false;
        Object a2 = z.a(z.a(str, (String) "getInstance", new Object[0]), (String) "isGooglePlayServicesAvailable", context);
        Object a3 = z.a((String) "com.google.android.gms.common.ConnectionResult", (String) "SUCCESS");
        if (a3 == null || !(a3 instanceof Integer)) {
            b.c("google service is not avaliable");
            f4373a = 0;
            return false;
        }
        int intValue = cls.cast(a3).intValue();
        if (a2 != null) {
            if (a2 instanceof Integer) {
                f4373a = cls.cast(a2).intValue() == intValue ? 1 : 0;
            } else {
                f4373a = 0;
                b.c("google service is not avaliable");
            }
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("is google service can be used");
        outline73.append(f4373a > 0);
        b.c(outline73.toString());
        if (f4373a > 0) {
            z = true;
        }
        return z;
    }

    public static boolean b(Context context) {
        boolean z = false;
        Object a2 = z.a((String) "com.xiaomi.assemble.control.COSPushManager", (String) "isSupportPush", context);
        if (a2 != null && (a2 instanceof Boolean)) {
            z = Boolean.class.cast(a2).booleanValue();
        }
        b.c("color os push  is avaliable ? :" + z);
        return z;
    }

    public static boolean c(Context context) {
        boolean z = false;
        Object a2 = z.a((String) "com.xiaomi.assemble.control.FTOSPushManager", (String) "isSupportPush", context);
        if (a2 != null && (a2 instanceof Boolean)) {
            z = Boolean.class.cast(a2).booleanValue();
        }
        b.c("fun touch os push  is avaliable ? :" + z);
        return z;
    }
}
