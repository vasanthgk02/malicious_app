package com.freshchat.consumer.sdk.service.c;

import com.freshchat.consumer.sdk.j.aa;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.al;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.service.a.a;
import com.freshchat.consumer.sdk.service.a.c;
import com.freshchat.consumer.sdk.service.e.h;
import com.freshchat.consumer.sdk.service.e.k;
import com.freshchat.consumer.sdk.service.e.m;
import java.util.List;

public class l extends b<m, k> {
    public static String TAG = "FRESHCHAT";

    /* renamed from: a */
    public k b(m mVar) {
        boolean z = false;
        if (!al.aS(getContext())) {
            return new h(false);
        }
        boolean z2 = true;
        try {
            aa.fF();
            List<a> cp = new com.freshchat.consumer.sdk.c.a(getContext()).cp();
            if (ai.ck()) {
                ai.d(TAG, "*********************************************");
                String str = TAG;
                ai.d(str, "There are " + cp.size() + " back log events");
                ai.d(TAG, "*********************************************");
            }
            for (a next : cp) {
                try {
                    try {
                        String str2 = TAG;
                        ai.i(str2, "Processing Backlog : " + next.getType() + " p: " + next.getPriority());
                        if (ai.ck()) {
                            ai.d(TAG, "#############################################");
                            String str3 = TAG;
                            ai.d(str3, "Processing backlog " + next);
                            ai.d(TAG, "#############################################");
                        }
                        c.a(getContext(), next).ds();
                    } catch (Exception e2) {
                        try {
                            q.a(e2);
                            z2 = false;
                        } catch (Exception e3) {
                            e = e3;
                            q.a(e);
                            z2 = z;
                            return new h(z2);
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                    z = z2;
                    q.a(e);
                    z2 = z;
                    return new h(z2);
                }
            }
        } catch (Exception e5) {
            e = e5;
            z = true;
            q.a(e);
            z2 = z;
            return new h(z2);
        }
        return new h(z2);
    }
}
