package com.freshchat.consumer.sdk.service.c;

import com.freshchat.consumer.sdk.JwtTokenStatus;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.o;
import com.freshchat.consumer.sdk.j.w;
import com.freshchat.consumer.sdk.service.e.k;

public class ac extends a<com.freshchat.consumer.sdk.service.e.ac, k> {
    public boolean a(com.freshchat.consumer.sdk.service.e.ac acVar) {
        if (!w.ay(getContext())) {
            return false;
        }
        return (!o.bB(getContext()) || o.bz(getContext()) == JwtTokenStatus.TOKEN_VALID) && !com.freshchat.consumer.sdk.j.k.c(acVar.gM()) && !as.isEmpty(acVar.bj());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x004d, code lost:
        if (r3 != false) goto L_0x004f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.freshchat.consumer.sdk.service.e.k b(com.freshchat.consumer.sdk.service.e.ac r8) {
        /*
            r7 = this;
            com.freshchat.consumer.sdk.j.by r0 = com.freshchat.consumer.sdk.j.by.gN()
            java.util.Map r1 = r8.gM()
            r2 = 0
            r3 = 1
            boolean r4 = r7.a(r8)     // Catch:{ DeletedException -> 0x006a, Exception -> 0x005a, all -> 0x0057 }
            if (r4 == 0) goto L_0x0041
            android.content.Context r4 = r7.getContext()     // Catch:{ DeletedException -> 0x006a, Exception -> 0x005a, all -> 0x0057 }
            boolean r4 = com.freshchat.consumer.sdk.j.al.aS(r4)     // Catch:{ DeletedException -> 0x006a, Exception -> 0x005a, all -> 0x0057 }
            if (r4 == 0) goto L_0x0042
            java.util.Collection r4 = r1.values()     // Catch:{ DeletedException -> 0x006a, Exception -> 0x005a, all -> 0x0057 }
            com.freshchat.consumer.sdk.j.ab r5 = new com.freshchat.consumer.sdk.j.ab     // Catch:{ DeletedException -> 0x006a, Exception -> 0x005a, all -> 0x0057 }
            r5.<init>()     // Catch:{ DeletedException -> 0x006a, Exception -> 0x005a, all -> 0x0057 }
            java.lang.String r4 = r5.toJson(r4)     // Catch:{ DeletedException -> 0x006a, Exception -> 0x005a, all -> 0x0057 }
            com.freshchat.consumer.sdk.e.a r5 = new com.freshchat.consumer.sdk.e.a     // Catch:{ DeletedException -> 0x006a, Exception -> 0x005a, all -> 0x0057 }
            android.content.Context r6 = r7.getContext()     // Catch:{ DeletedException -> 0x006a, Exception -> 0x005a, all -> 0x0057 }
            r5.<init>(r6)     // Catch:{ DeletedException -> 0x006a, Exception -> 0x005a, all -> 0x0057 }
            java.lang.String r8 = r8.bj()     // Catch:{ DeletedException -> 0x006a, Exception -> 0x005a, all -> 0x0057 }
            com.freshchat.consumer.sdk.beans.reqres.UploadInboundEventsResponse r8 = r5.h(r4, r8)     // Catch:{ DeletedException -> 0x006a, Exception -> 0x005a, all -> 0x0057 }
            boolean r8 = r8.isSuccess()     // Catch:{ DeletedException -> 0x006a, Exception -> 0x005a, all -> 0x0057 }
            r2 = r8 ^ 1
            r3 = r2
            r2 = r8
            goto L_0x0042
        L_0x0041:
            r3 = 0
        L_0x0042:
            android.content.Context r8 = r7.getContext()
            java.util.Set r1 = r1.keySet()
            r0.a(r8, r1, r2)
            if (r3 == 0) goto L_0x006f
        L_0x004f:
            android.content.Context r8 = r7.getContext()
            r0.bQ(r8)
            goto L_0x006f
        L_0x0057:
            r8 = move-exception
            r3 = 0
            goto L_0x0076
        L_0x005a:
            r8 = move-exception
            com.freshchat.consumer.sdk.j.q.a(r8)     // Catch:{ all -> 0x0075 }
        L_0x005e:
            android.content.Context r8 = r7.getContext()
            java.util.Set r1 = r1.keySet()
            r0.a(r8, r1, r2)
            goto L_0x004f
        L_0x006a:
            r8 = move-exception
            com.freshchat.consumer.sdk.j.q.a(r8)     // Catch:{ all -> 0x0075 }
            goto L_0x005e
        L_0x006f:
            com.freshchat.consumer.sdk.service.e.h r8 = new com.freshchat.consumer.sdk.service.e.h
            r8.<init>(r2)
            return r8
        L_0x0075:
            r8 = move-exception
        L_0x0076:
            android.content.Context r4 = r7.getContext()
            java.util.Set r1 = r1.keySet()
            r0.a(r4, r1, r2)
            if (r3 == 0) goto L_0x008a
            android.content.Context r1 = r7.getContext()
            r0.bQ(r1)
        L_0x008a:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.service.c.ac.b(com.freshchat.consumer.sdk.service.e.ac):com.freshchat.consumer.sdk.service.e.k");
    }
}
