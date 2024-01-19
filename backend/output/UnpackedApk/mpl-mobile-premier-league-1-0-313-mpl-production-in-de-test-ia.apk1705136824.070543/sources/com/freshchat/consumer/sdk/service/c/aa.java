package com.freshchat.consumer.sdk.service.c;

import com.freshchat.consumer.sdk.b.c;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.j.w;
import com.freshchat.consumer.sdk.service.a.a;
import com.freshchat.consumer.sdk.service.e.ad;
import com.freshchat.consumer.sdk.service.e.k;

public class aa extends a<ad, k> {
    private void c(ad adVar) {
        try {
            if (adVar.dT()) {
                ai.d("FRESHCHAT", "Backlogging user session request failure");
                com.freshchat.consumer.sdk.j.aa.c(getContext(), new a(3));
            }
        } catch (Exception e2) {
            q.a(e2);
        }
    }

    public boolean a(ad adVar) {
        if (!w.ay(getContext())) {
            return false;
        }
        if (dw().bl()) {
            return true;
        }
        ai.d("FRESHCHAT", c.USER_NOT_REGISTERED_ACTIVITY_NOT_SENT.toString());
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002c, code lost:
        if (r2 != false) goto L_0x002e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.freshchat.consumer.sdk.service.e.k b(com.freshchat.consumer.sdk.service.e.ad r5) {
        /*
            r4 = this;
            android.content.Context r0 = r4.getContext()
            r1 = 1
            r2 = 0
            boolean r3 = r4.a(r5)     // Catch:{ DeletedException -> 0x003c, Exception -> 0x0035 }
            if (r3 == 0) goto L_0x002c
            android.content.Context r3 = r4.getContext()     // Catch:{ DeletedException -> 0x003c, Exception -> 0x0035 }
            boolean r3 = com.freshchat.consumer.sdk.j.al.aS(r3)     // Catch:{ DeletedException -> 0x003c, Exception -> 0x0035 }
            if (r3 == 0) goto L_0x0020
            com.freshchat.consumer.sdk.e.a r3 = new com.freshchat.consumer.sdk.e.a     // Catch:{ DeletedException -> 0x003c, Exception -> 0x0035 }
            r3.<init>(r0)     // Catch:{ DeletedException -> 0x003c, Exception -> 0x0035 }
            boolean r0 = r3.cV()     // Catch:{ DeletedException -> 0x003c, Exception -> 0x0035 }
            goto L_0x0021
        L_0x0020:
            r0 = 0
        L_0x0021:
            if (r0 == 0) goto L_0x002b
            java.lang.String r0 = "FRESHCHAT"
            java.lang.String r3 = "Registered user session"
            com.freshchat.consumer.sdk.j.ai.d(r0, r3)     // Catch:{ DeletedException -> 0x003c, Exception -> 0x0035 }
            goto L_0x002c
        L_0x002b:
            r2 = 1
        L_0x002c:
            if (r2 == 0) goto L_0x0040
        L_0x002e:
            r4.c(r5)
            goto L_0x0040
        L_0x0032:
            r0 = move-exception
            r1 = 0
            goto L_0x0046
        L_0x0035:
            r0 = move-exception
            com.freshchat.consumer.sdk.j.q.a(r0)     // Catch:{ all -> 0x003a }
            goto L_0x002e
        L_0x003a:
            r0 = move-exception
            goto L_0x0046
        L_0x003c:
            r0 = move-exception
            com.freshchat.consumer.sdk.j.q.a(r0)     // Catch:{ all -> 0x0032 }
        L_0x0040:
            com.freshchat.consumer.sdk.service.e.h r5 = new com.freshchat.consumer.sdk.service.e.h
            r5.<init>(r1)
            return r5
        L_0x0046:
            if (r1 == 0) goto L_0x004b
            r4.c(r5)
        L_0x004b:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.service.c.aa.b(com.freshchat.consumer.sdk.service.e.ad):com.freshchat.consumer.sdk.service.e.k");
    }
}
