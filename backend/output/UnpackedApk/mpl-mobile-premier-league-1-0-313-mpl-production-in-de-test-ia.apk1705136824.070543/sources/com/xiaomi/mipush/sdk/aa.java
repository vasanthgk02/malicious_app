package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.android.b;
import com.xiaomi.push.cz;
import com.xiaomi.push.dk;
import com.xiaomi.push.dl;
import com.xiaomi.push.dm;
import com.xiaomi.push.dp;
import com.xiaomi.push.dq;
import com.xiaomi.push.dt;
import com.xiaomi.push.dv;
import com.xiaomi.push.dw;
import com.xiaomi.push.dx;
import com.xiaomi.push.dz;
import com.xiaomi.push.eb;
import com.xiaomi.push.ed;
import com.xiaomi.push.ee;
import com.xiaomi.push.ef;
import java.nio.ByteBuffer;

public class aa {
    public static <T extends ef<T, ?>> dq a(Context context, T t, cz czVar) {
        return a(context, t, czVar, !czVar.equals(cz.Registration), context.getPackageName(), a.a(context).a());
    }

    public static <T extends ef<T, ?>> dq a(Context context, T t, cz czVar, boolean z, String str, String str2) {
        return a(context, t, czVar, z, str, str2, true);
    }

    public static <T extends ef<T, ?>> dq a(Context context, T t, cz czVar, boolean z, String str, String str2, boolean z2) {
        String str3;
        byte[] a2 = ee.a(t);
        if (a2 == null) {
            str3 = "invoke convertThriftObjectToBytes method, return null.";
        } else {
            dq dqVar = new dq();
            if (z) {
                String d2 = a.a(context).d();
                if (TextUtils.isEmpty(d2)) {
                    str3 = "regSecret is empty, return null";
                } else {
                    try {
                        a2 = b.b(com.xiaomi.push.aa.a(d2), a2);
                    } catch (Exception unused) {
                        com.xiaomi.channel.commonutils.logger.b.d("encryption error. ");
                    }
                }
            }
            dk dkVar = new dk();
            dkVar.f506a = 5;
            dkVar.f507a = "fakeid";
            dqVar.a(dkVar);
            dqVar.a(ByteBuffer.wrap(a2));
            dqVar.a(czVar);
            dqVar.b(z2);
            dqVar.b(str);
            dqVar.a(z);
            dqVar.a(str2);
            return dqVar;
        }
        com.xiaomi.channel.commonutils.logger.b.a(str3);
        return null;
    }

    public static ef a(Context context, dq dqVar) {
        byte[] bArr;
        if (dqVar.b()) {
            byte[] a2 = g.a(context, dqVar, c.ASSEMBLE_PUSH_FCM);
            if (a2 == null) {
                a2 = com.xiaomi.push.aa.a(a.a(context).d());
            }
            try {
                bArr = b.a(a2, dqVar.a());
            } catch (Exception e2) {
                throw new o("the aes decrypt failed.", e2);
            }
        } else {
            bArr = dqVar.a();
        }
        ef a3 = a(dqVar.a(), dqVar.f584b);
        if (a3 != null) {
            ee.a(a3, bArr);
        }
        return a3;
    }

    public static ef a(cz czVar, boolean z) {
        switch (ab.f4340a[czVar.ordinal()]) {
            case 1:
                return new dv();
            case 2:
                return new eb();
            case 3:
                return new dz();
            case 4:
                return new ed();
            case 5:
                return new dx();
            case 6:
                return new dl();
            case 7:
                return new dp();
            case 8:
                return new dw();
            case 9:
                if (z) {
                    return new dt();
                }
                dm dmVar = new dm();
                dmVar.a(true);
                return dmVar;
            case 10:
                return new dp();
            default:
                return null;
        }
    }

    public static <T extends ef<T, ?>> dq b(Context context, T t, cz czVar, boolean z, String str, String str2) {
        return a(context, t, czVar, z, str, str2, false);
    }
}
