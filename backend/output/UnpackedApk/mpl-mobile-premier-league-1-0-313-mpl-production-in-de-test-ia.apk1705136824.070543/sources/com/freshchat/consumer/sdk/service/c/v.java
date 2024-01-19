package com.freshchat.consumer.sdk.service.c;

import com.freshchat.consumer.sdk.j.aa;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.w;
import com.freshchat.consumer.sdk.service.a.a;
import com.freshchat.consumer.sdk.service.a.c;
import com.freshchat.consumer.sdk.service.e.k;
import com.freshchat.consumer.sdk.service.e.y;

public class v extends a<y, k> {
    private void dQ() {
        a m = c.m(getContext(), 4);
        if (m != null && as.a(m.dr())) {
            aa.l(getContext(), m.dr());
        }
    }

    public boolean a(y yVar) {
        return w.ay(getContext()) && w.aA(getContext());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0073, code lost:
        if (r1 != false) goto L_0x0075;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.freshchat.consumer.sdk.service.e.k b(com.freshchat.consumer.sdk.service.e.y r8) {
        /*
            r7 = this;
            java.lang.String r0 = "FRESHCHAT"
            r1 = 1
            r2 = 0
            boolean r3 = r7.a(r8)     // Catch:{ DeletedException -> 0x0087, Exception -> 0x0080 }
            if (r3 != 0) goto L_0x0017
            com.freshchat.consumer.sdk.service.e.h r0 = new com.freshchat.consumer.sdk.service.e.h     // Catch:{ DeletedException -> 0x0087, Exception -> 0x0080 }
            r0.<init>(r2)     // Catch:{ DeletedException -> 0x0087, Exception -> 0x0080 }
            android.content.Context r1 = r7.getContext()
            com.freshchat.consumer.sdk.service.a.c.a(r1, r8)
            return r0
        L_0x0017:
            com.freshchat.consumer.sdk.b.e r3 = r7.dw()     // Catch:{ DeletedException -> 0x0087, Exception -> 0x0080 }
            java.lang.String r4 = r3.bj()     // Catch:{ DeletedException -> 0x0087, Exception -> 0x0080 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ DeletedException -> 0x0087, Exception -> 0x0080 }
            r5.<init>()     // Catch:{ DeletedException -> 0x0087, Exception -> 0x0080 }
            java.lang.String r6 = "Sending GCM device token for user "
            r5.append(r6)     // Catch:{ DeletedException -> 0x0087, Exception -> 0x0080 }
            r5.append(r4)     // Catch:{ DeletedException -> 0x0087, Exception -> 0x0080 }
            java.lang.String r5 = r5.toString()     // Catch:{ DeletedException -> 0x0087, Exception -> 0x0080 }
            com.freshchat.consumer.sdk.j.ai.d(r0, r5)     // Catch:{ DeletedException -> 0x0087, Exception -> 0x0080 }
            boolean r5 = r3.bl()     // Catch:{ DeletedException -> 0x0087, Exception -> 0x0080 }
            if (r5 == 0) goto L_0x0073
            boolean r5 = com.freshchat.consumer.sdk.j.as.isEmpty(r4)     // Catch:{ DeletedException -> 0x0087, Exception -> 0x0080 }
            if (r5 == 0) goto L_0x0040
            goto L_0x0073
        L_0x0040:
            com.freshchat.consumer.sdk.e.a r5 = new com.freshchat.consumer.sdk.e.a     // Catch:{ DeletedException -> 0x0087, Exception -> 0x0080 }
            android.content.Context r6 = r7.getContext()     // Catch:{ DeletedException -> 0x0087, Exception -> 0x0080 }
            r5.<init>(r6)     // Catch:{ DeletedException -> 0x0087, Exception -> 0x0080 }
            java.lang.String r3 = r3.bP()     // Catch:{ DeletedException -> 0x0087, Exception -> 0x0080 }
            boolean r3 = r5.ad(r3)     // Catch:{ DeletedException -> 0x0087, Exception -> 0x0080 }
            if (r3 == 0) goto L_0x0072
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ DeletedException -> 0x0070, Exception -> 0x006d }
            r5.<init>()     // Catch:{ DeletedException -> 0x0070, Exception -> 0x006d }
            java.lang.String r6 = "Sent GCM device token successfully for user "
            r5.append(r6)     // Catch:{ DeletedException -> 0x0070, Exception -> 0x006d }
            r5.append(r4)     // Catch:{ DeletedException -> 0x0070, Exception -> 0x006d }
            java.lang.String r4 = r5.toString()     // Catch:{ DeletedException -> 0x0070, Exception -> 0x006d }
            com.freshchat.consumer.sdk.j.ai.d(r0, r4)     // Catch:{ DeletedException -> 0x0070, Exception -> 0x006d }
            r7.dQ()     // Catch:{ DeletedException -> 0x0070, Exception -> 0x006d }
            r2 = r3
            r1 = 0
            goto L_0x0073
        L_0x006d:
            r0 = move-exception
            r2 = r3
            goto L_0x0081
        L_0x0070:
            r0 = move-exception
            goto L_0x0089
        L_0x0072:
            r2 = r3
        L_0x0073:
            if (r1 == 0) goto L_0x008d
        L_0x0075:
            android.content.Context r0 = r7.getContext()
            com.freshchat.consumer.sdk.service.a.c.a(r0, r8)
            goto L_0x008d
        L_0x007d:
            r0 = move-exception
            r1 = 0
            goto L_0x0093
        L_0x0080:
            r0 = move-exception
        L_0x0081:
            com.freshchat.consumer.sdk.j.q.a(r0)     // Catch:{ all -> 0x0085 }
            goto L_0x0075
        L_0x0085:
            r0 = move-exception
            goto L_0x0093
        L_0x0087:
            r0 = move-exception
            r3 = 0
        L_0x0089:
            com.freshchat.consumer.sdk.j.q.a(r0)     // Catch:{ all -> 0x007d }
            r2 = r3
        L_0x008d:
            com.freshchat.consumer.sdk.service.e.h r8 = new com.freshchat.consumer.sdk.service.e.h
            r8.<init>(r2)
            return r8
        L_0x0093:
            if (r1 == 0) goto L_0x009c
            android.content.Context r1 = r7.getContext()
            com.freshchat.consumer.sdk.service.a.c.a(r1, r8)
        L_0x009c:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.service.c.v.b(com.freshchat.consumer.sdk.service.e.y):com.freshchat.consumer.sdk.service.e.k");
    }
}
