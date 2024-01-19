package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.android.a;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.aq;

public class ee {
    public static short a(Context context, dq dqVar) {
        return a(context, dqVar.f583b);
    }

    public static short a(Context context, String str) {
        int i = 0;
        int a2 = a.a(context, str, false).a() + 0 + (n.b(context) ? 4 : 0) + (n.a(context) ? 8 : 0);
        if (aq.a(context)) {
            i = 16;
        }
        return (short) (a2 + i);
    }

    public static <T extends ef<T, ?>> void a(T t, byte[] bArr) {
        if (bArr != null) {
            new ei(new ev.a(true, true, bArr.length)).a(t, bArr);
            return;
        }
        throw new ej((String) "the message byte is empty.");
    }

    public static <T extends ef<T, ?>> byte[] a(T t) {
        if (t == null) {
            return null;
        }
        try {
            return new ek(new el.a()).a(t);
        } catch (ej e2) {
            b.a((String) "convertThriftObjectToBytes catch TException.", (Throwable) e2);
            return null;
        }
    }
}
