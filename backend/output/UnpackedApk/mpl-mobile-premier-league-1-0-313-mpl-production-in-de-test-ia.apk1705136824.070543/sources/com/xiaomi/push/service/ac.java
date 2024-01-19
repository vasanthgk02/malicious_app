package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.dq;
import java.util.Map;

public class ac {

    /* renamed from: a  reason: collision with root package name */
    public static a f4843a;

    /* renamed from: a  reason: collision with other field name */
    public static b f829a;

    public interface a {
        Map<String, String> a(Context context, dq dqVar);

        /* renamed from: a  reason: collision with other method in class */
        void m790a(Context context, dq dqVar);

        boolean a(Context context, dq dqVar, boolean z);
    }

    public interface b {
        void a(dq dqVar);

        void a(String str);

        /* renamed from: a  reason: collision with other method in class */
        boolean m791a(dq dqVar);
    }

    public static Map<String, String> a(Context context, dq dqVar) {
        a aVar = f4843a;
        if (aVar != null && dqVar != null) {
            return aVar.a(context, dqVar);
        }
        com.xiaomi.channel.commonutils.logger.b.a((String) "pepa listener or container is null");
        return null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m788a(Context context, dq dqVar) {
        a aVar = f4843a;
        if (aVar == null || dqVar == null) {
            com.xiaomi.channel.commonutils.logger.b.a((String) "handle msg wrong");
        } else {
            aVar.a(context, dqVar);
        }
    }

    public static void a(dq dqVar) {
        b bVar = f829a;
        if (bVar == null || dqVar == null) {
            com.xiaomi.channel.commonutils.logger.b.a((String) "pepa clearMessage is null");
        } else {
            bVar.a(dqVar);
        }
    }

    public static void a(String str) {
        b bVar = f829a;
        if (bVar == null || str == null) {
            com.xiaomi.channel.commonutils.logger.b.a((String) "pepa clearMessage is null");
        } else {
            bVar.a(str);
        }
    }

    public static boolean a(Context context, dq dqVar, boolean z) {
        a aVar = f4843a;
        if (aVar != null && dqVar != null) {
            return aVar.a(context, dqVar, z);
        }
        com.xiaomi.channel.commonutils.logger.b.a((String) "pepa judement listener or container is null");
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m789a(dq dqVar) {
        b bVar = f829a;
        if (bVar != null && dqVar != null) {
            return bVar.a(dqVar);
        }
        com.xiaomi.channel.commonutils.logger.b.a((String) "pepa handleReceiveMessage is null");
        return false;
    }
}
