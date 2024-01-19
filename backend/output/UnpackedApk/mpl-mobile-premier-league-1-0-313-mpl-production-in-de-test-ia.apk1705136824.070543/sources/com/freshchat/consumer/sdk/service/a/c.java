package com.freshchat.consumer.sdk.service.a;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.b.e;
import com.freshchat.consumer.sdk.beans.Message;
import com.freshchat.consumer.sdk.c.a;
import com.freshchat.consumer.sdk.j.aa;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.service.e.y;

public class c {
    public static b a(Context context, a aVar) {
        int type = aVar.getType();
        if (type == 1) {
            return new e(context, aVar);
        }
        if (type == 2) {
            return new f(context, aVar);
        }
        if (type == 3) {
            return new n(context, aVar);
        }
        if (type == 4) {
            return new j(context, aVar);
        }
        if (type == 6) {
            return new k(context, aVar);
        }
        if (type == 7) {
            return new i(context, aVar);
        }
        if (type == 9) {
            return new g(context, aVar);
        }
        if (type == 11) {
            return new h(context, aVar);
        }
        aa.l(context, aVar.dr());
        throw new RuntimeException(GeneratedOutlineSupport.outline41("Unknown type ", type));
    }

    public static void a(Context context, y yVar) {
        try {
            String bj = e.i(context).bj();
            ai.d("FRESHCHAT", "Failed to send FCM device token for user " + bj);
            aa.c(context, new a(4, yVar.dP()));
            ai.d("FRESHCHAT", "Adding FCM device token to backlog for user " + bj);
        } catch (Exception e2) {
            q.a(e2);
        }
    }

    public static void b(Context context, a aVar) {
        if (context != null && aVar != null) {
            a aVar2 = new a(context);
            int type = aVar.getType();
            if (type != 1) {
                if (!(type == 2 || type == 3)) {
                    if (type != 4) {
                        if (type == 6) {
                            aVar2.d(aVar);
                            return;
                        } else if (type == 7) {
                            aVar2.b(aVar);
                            return;
                        } else if (!(type == 9 || type == 11)) {
                            return;
                        }
                    }
                }
                aVar2.f(aVar);
                return;
            }
            aVar2.a(aVar);
        }
    }

    public static boolean bd(Context context) {
        return f(context, 2);
    }

    public static void d(Context context, Message message) {
        try {
            aa.c(context, new a(2, message.getAlias()));
        } catch (Exception e2) {
            q.a(e2);
        }
    }

    public static boolean f(Context context, int i) {
        if (context == null) {
            return false;
        }
        return new a(context).l(i);
    }

    public static boolean f(Context context, String str) {
        if (context == null || as.isEmpty(str)) {
            return false;
        }
        return new a(context).S(str);
    }

    public static a m(Context context, int i) {
        a aVar = new a(context);
        if (aVar.l(i)) {
            return aVar.C(i);
        }
        return null;
    }

    public static boolean s(Context context) {
        boolean z = false;
        if (context == null) {
            return false;
        }
        e i = e.i(context);
        a aVar = new a(context);
        if (i.bl()) {
            return k.a(aVar.cp());
        }
        if (t(context) && bd(context)) {
            z = true;
        }
        return z;
    }

    public static boolean t(Context context) {
        return f(context, 1);
    }
}
