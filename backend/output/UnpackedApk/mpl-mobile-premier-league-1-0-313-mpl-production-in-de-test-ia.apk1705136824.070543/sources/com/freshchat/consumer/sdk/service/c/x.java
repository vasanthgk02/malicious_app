package com.freshchat.consumer.sdk.service.c;

import com.freshchat.consumer.sdk.beans.MarketingMessageStatus;
import com.freshchat.consumer.sdk.j.ab;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.j.w;
import com.freshchat.consumer.sdk.service.a.a;
import com.freshchat.consumer.sdk.service.e.aa;
import com.freshchat.consumer.sdk.service.e.k;
import java.util.HashMap;

public class x extends a<aa, k> {
    private void c(aa aaVar) {
        try {
            ai.d("FRESHCHAT", "Failed to update marketing message status. Backlogging");
            MarketingMessageStatus dS = aaVar.dS();
            String json = new ab().toJson(dS);
            HashMap hashMap = new HashMap();
            hashMap.put("fc_marketing_metrics", json);
            com.freshchat.consumer.sdk.j.aa.c(getContext(), new a(6, String.valueOf(dS.getMarketingId())).b(hashMap));
        } catch (Exception e2) {
            q.a(e2);
        }
    }

    public boolean a(aa aaVar) {
        return w.ay(getContext());
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x006f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.freshchat.consumer.sdk.service.e.k b(com.freshchat.consumer.sdk.service.e.aa r9) {
        /*
            r8 = this;
            boolean r0 = r8.a(r9)
            r1 = 0
            if (r0 != 0) goto L_0x000d
            com.freshchat.consumer.sdk.service.e.h r9 = new com.freshchat.consumer.sdk.service.e.h
            r9.<init>(r1)
            return r9
        L_0x000d:
            com.freshchat.consumer.sdk.beans.MarketingMessageStatus r0 = r9.dS()     // Catch:{ Exception -> 0x005d, all -> 0x005b }
            long r2 = r0.getMarketingId()     // Catch:{ Exception -> 0x005d, all -> 0x005b }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x005d, all -> 0x005b }
            int r3 = r0.getDelivered()     // Catch:{ Exception -> 0x005d, all -> 0x005b }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ Exception -> 0x005d, all -> 0x005b }
            int r4 = r0.getClicked()     // Catch:{ Exception -> 0x005d, all -> 0x005b }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x005d, all -> 0x005b }
            int r5 = r0.getSeen()     // Catch:{ Exception -> 0x005d, all -> 0x005b }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x005d, all -> 0x005b }
            com.freshchat.consumer.sdk.e.a r6 = new com.freshchat.consumer.sdk.e.a     // Catch:{ Exception -> 0x005d, all -> 0x005b }
            android.content.Context r7 = r8.getContext()     // Catch:{ Exception -> 0x005d, all -> 0x005b }
            r6.<init>(r7)     // Catch:{ Exception -> 0x005d, all -> 0x005b }
            r6.a(r2, r3, r4, r5)     // Catch:{ Exception -> 0x005d, all -> 0x005b }
            r2 = 1
            java.lang.String r3 = "FRESHCHAT"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            r4.<init>()     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            java.lang.String r5 = "Marketing message status updated => "
            r4.append(r5)     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            r4.append(r0)     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            java.lang.String r0 = r4.toString()     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            com.freshchat.consumer.sdk.j.ai.d(r3, r0)     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            r1 = 1
            goto L_0x0065
        L_0x0056:
            r0 = move-exception
            r1 = 1
            goto L_0x006d
        L_0x0059:
            r0 = move-exception
            goto L_0x005f
        L_0x005b:
            r0 = move-exception
            goto L_0x006d
        L_0x005d:
            r0 = move-exception
            r2 = 0
        L_0x005f:
            com.freshchat.consumer.sdk.j.q.a(r0)     // Catch:{ all -> 0x006b }
            r8.c(r9)
        L_0x0065:
            com.freshchat.consumer.sdk.service.e.h r9 = new com.freshchat.consumer.sdk.service.e.h
            r9.<init>(r1)
            return r9
        L_0x006b:
            r0 = move-exception
            r1 = r2
        L_0x006d:
            if (r1 != 0) goto L_0x0072
            r8.c(r9)
        L_0x0072:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.service.c.x.b(com.freshchat.consumer.sdk.service.e.aa):com.freshchat.consumer.sdk.service.e.k");
    }
}
