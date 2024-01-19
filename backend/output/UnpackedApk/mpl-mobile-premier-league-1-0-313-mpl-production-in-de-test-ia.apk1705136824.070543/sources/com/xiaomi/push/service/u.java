package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.util.Pair;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.cd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class u {

    /* renamed from: a  reason: collision with root package name */
    public static ArrayList<Pair<String, byte[]>> f4983a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    public static final Map<String, byte[]> f943a = new HashMap();

    public static void a(Context context, int i, String str) {
        synchronized (f943a) {
            for (String next : f943a.keySet()) {
                b.a("notify registration error. " + next);
                a(context, next, f943a.get(next), i, str);
            }
            f943a.clear();
        }
    }

    public static void a(Context context, String str, byte[] bArr, int i, String str2) {
        Intent intent = new Intent("com.xiaomi.mipush.ERROR");
        intent.setPackage(str);
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mipush_error_code", i);
        intent.putExtra("mipush_error_msg", str2);
        context.sendBroadcast(intent, ad.a(str));
    }

    public static void a(XMPushService xMPushService) {
        try {
            synchronized (f943a) {
                for (String next : f943a.keySet()) {
                    b.a("processing pending registration request. " + next);
                    ad.a(xMPushService, next, f943a.get(next));
                }
                f943a.clear();
            }
        } catch (cd e2) {
            b.d("fail to deal with pending register request. " + e2);
            xMPushService.a(10, (Exception) e2);
        }
    }

    public static void a(String str, byte[] bArr) {
        synchronized (f943a) {
            b.a("pending registration request. " + str);
            f943a.put(str, bArr);
        }
    }

    public static void b(XMPushService xMPushService) {
        ArrayList<Pair<String, byte[]>> arrayList;
        try {
            synchronized (f4983a) {
                arrayList = f4983a;
                f4983a = new ArrayList<>();
            }
            boolean z = Thread.currentThread() == Looper.getMainLooper().getThread();
            Iterator<Pair<String, byte[]>> it = arrayList.iterator();
            while (it.hasNext()) {
                Pair next = it.next();
                ad.a(xMPushService, (String) next.first, (byte[]) next.second);
                if (!z) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        } catch (cd e2) {
            b.d("meet error when process pending message. " + e2);
            xMPushService.a(10, (Exception) e2);
        }
    }

    public static void b(String str, byte[] bArr) {
        synchronized (f4983a) {
            f4983a.add(new Pair(str, bArr));
            if (f4983a.size() > 50) {
                f4983a.remove(0);
            }
        }
    }
}
