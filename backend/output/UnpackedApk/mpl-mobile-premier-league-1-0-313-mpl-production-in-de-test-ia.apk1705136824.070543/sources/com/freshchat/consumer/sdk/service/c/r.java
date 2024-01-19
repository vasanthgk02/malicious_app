package com.freshchat.consumer.sdk.service.c;

import com.freshchat.consumer.sdk.beans.CsatResponse;
import com.freshchat.consumer.sdk.beans.reqres.CsatResponseRequest;
import com.freshchat.consumer.sdk.j.aa;
import com.freshchat.consumer.sdk.j.ab;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.j.w;
import com.freshchat.consumer.sdk.service.a.a;
import com.freshchat.consumer.sdk.service.e.k;
import com.freshchat.consumer.sdk.service.e.t;
import java.util.HashMap;

public class r extends a<t, k> {
    private void b(CsatResponseRequest csatResponseRequest) {
        try {
            CsatResponse csatResponse = csatResponseRequest.getCsatResponse();
            if (csatResponse != null) {
                if (csatResponse.getConversationId() != 0) {
                    String json = new ab().toJson(csatResponseRequest);
                    HashMap hashMap = new HashMap();
                    hashMap.put("fc_csat_response", json);
                    aa.c(getContext(), new a(9, "csat_" + Long.toString(csatResponse.getConversationId())).b(hashMap));
                }
            }
        } catch (Exception e2) {
            q.a(e2);
        }
    }

    public boolean a(t tVar) {
        return w.ay(getContext());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005f, code lost:
        if (r1 != false) goto L_0x0061;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.freshchat.consumer.sdk.service.e.k b(com.freshchat.consumer.sdk.service.e.t r9) {
        /*
            r8 = this;
            boolean r0 = r8.a(r9)
            r1 = 0
            if (r0 != 0) goto L_0x000d
            com.freshchat.consumer.sdk.service.e.h r9 = new com.freshchat.consumer.sdk.service.e.h
            r9.<init>(r1)
            return r9
        L_0x000d:
            com.freshchat.consumer.sdk.beans.reqres.CsatResponseRequest r9 = r9.dN()
            com.freshchat.consumer.sdk.beans.CsatResponse r0 = r9.getCsatResponse()
            if (r0 == 0) goto L_0x0082
            long r2 = r0.getConversationId()
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x0022
            goto L_0x0082
        L_0x0022:
            r2 = 1
            long r3 = r0.getConversationId()     // Catch:{ DeletedException -> 0x0071, Exception -> 0x0067 }
            java.lang.String r5 = java.lang.Long.toString(r3)     // Catch:{ DeletedException -> 0x0071, Exception -> 0x0067 }
            long r6 = r0.getCsatId()     // Catch:{ DeletedException -> 0x0071, Exception -> 0x0067 }
            java.lang.String r0 = java.lang.Long.toString(r6)     // Catch:{ DeletedException -> 0x0071, Exception -> 0x0067 }
            com.freshchat.consumer.sdk.e.a r6 = new com.freshchat.consumer.sdk.e.a     // Catch:{ DeletedException -> 0x0071, Exception -> 0x0067 }
            android.content.Context r7 = r8.getContext()     // Catch:{ DeletedException -> 0x0071, Exception -> 0x0067 }
            r6.<init>(r7)     // Catch:{ DeletedException -> 0x0071, Exception -> 0x0067 }
            boolean r0 = r6.a(r9, r5, r0)     // Catch:{ DeletedException -> 0x0071, Exception -> 0x0067 }
            if (r0 == 0) goto L_0x005e
            com.freshchat.consumer.sdk.c.e r5 = new com.freshchat.consumer.sdk.c.e     // Catch:{ DeletedException -> 0x005c, Exception -> 0x005a }
            android.content.Context r6 = r8.getContext()     // Catch:{ DeletedException -> 0x005c, Exception -> 0x005a }
            r5.<init>(r6)     // Catch:{ DeletedException -> 0x005c, Exception -> 0x005a }
            r5.t(r3)     // Catch:{ DeletedException -> 0x005c, Exception -> 0x005a }
            android.content.Context r3 = r8.getContext()     // Catch:{ DeletedException -> 0x005c, Exception -> 0x005a }
            r4 = 15
            com.freshchat.consumer.sdk.service.e.d$a r5 = com.freshchat.consumer.sdk.service.e.d.a.IMMEDIATE     // Catch:{ DeletedException -> 0x005c, Exception -> 0x005a }
            com.freshchat.consumer.sdk.j.b.a(r3, r4, r5)     // Catch:{ DeletedException -> 0x005c, Exception -> 0x005a }
            goto L_0x005f
        L_0x005a:
            r1 = move-exception
            goto L_0x006a
        L_0x005c:
            r2 = move-exception
            goto L_0x0073
        L_0x005e:
            r1 = 1
        L_0x005f:
            if (r1 == 0) goto L_0x0076
        L_0x0061:
            r8.b(r9)
            goto L_0x0076
        L_0x0065:
            r0 = move-exception
            goto L_0x007c
        L_0x0067:
            r0 = move-exception
            r1 = r0
            r0 = 0
        L_0x006a:
            com.freshchat.consumer.sdk.j.q.a(r1)     // Catch:{ all -> 0x006e }
            goto L_0x0061
        L_0x006e:
            r0 = move-exception
            r1 = 1
            goto L_0x007c
        L_0x0071:
            r2 = move-exception
            r0 = 0
        L_0x0073:
            com.freshchat.consumer.sdk.j.q.a(r2)     // Catch:{ all -> 0x0065 }
        L_0x0076:
            com.freshchat.consumer.sdk.service.e.h r9 = new com.freshchat.consumer.sdk.service.e.h
            r9.<init>(r0)
            return r9
        L_0x007c:
            if (r1 == 0) goto L_0x0081
            r8.b(r9)
        L_0x0081:
            throw r0
        L_0x0082:
            com.freshchat.consumer.sdk.service.e.h r9 = new com.freshchat.consumer.sdk.service.e.h
            r9.<init>(r1)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.service.c.r.b(com.freshchat.consumer.sdk.service.e.t):com.freshchat.consumer.sdk.service.e.k");
    }
}
