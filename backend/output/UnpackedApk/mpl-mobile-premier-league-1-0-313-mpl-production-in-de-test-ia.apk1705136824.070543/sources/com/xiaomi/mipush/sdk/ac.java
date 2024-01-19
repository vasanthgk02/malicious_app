package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.j.a;
import com.xiaomi.push.z;

public class ac {
    public static AbstractPushManager a(Context context, c cVar) {
        return b(context, cVar);
    }

    public static AbstractPushManager b(Context context, c cVar) {
        a a2 = j.a(cVar);
        if (a2 == null || TextUtils.isEmpty(a2.f4370a) || TextUtils.isEmpty(a2.f4371b)) {
            return null;
        }
        return (AbstractPushManager) z.a(a2.f4370a, a2.f4371b, context);
    }
}
