package com.xiaomi.push;

import android.util.Log;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.bm.a;

public class bj {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f4494a = Log.isLoggable("BCompressed", 3);

    public static byte[] a(bi biVar, byte[] bArr) {
        try {
            byte[] a2 = a.a(bArr);
            if (f4494a) {
                b.a((String) "BCompressed", "decompress " + bArr.length + " to " + a2.length + " for " + biVar);
                if (biVar.f352a == 1) {
                    b.a((String) "BCompressed", (String) "decompress not support upStream");
                }
            }
            return a2;
        } catch (Exception e2) {
            b.a((String) "BCompressed", "decompress error " + e2);
            return bArr;
        }
    }
}
