package com.freshchat.consumer.sdk.service.c;

import com.freshchat.consumer.sdk.j.w;
import com.freshchat.consumer.sdk.service.e.k;
import com.freshchat.consumer.sdk.service.e.n;

public class m extends a<n, k> {
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0051, code lost:
        if (r2 != false) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x006f, code lost:
        if (0 == 0) goto L_0x0057;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.freshchat.consumer.sdk.service.e.k b(com.freshchat.consumer.sdk.service.e.n r9) {
        /*
            r8 = this;
            java.lang.String r0 = "com.freshchat.consumer.sdk.actions.ArticleVoted"
            boolean r1 = r8.b(r9)
            r2 = 0
            if (r1 != 0) goto L_0x000f
            com.freshchat.consumer.sdk.service.e.h r9 = new com.freshchat.consumer.sdk.service.e.h
            r9.<init>(r2)
            return r9
        L_0x000f:
            android.content.Context r1 = r8.getContext()
            java.lang.String r3 = r9.dJ()     // Catch:{ DeletedException -> 0x006b, JSONException -> 0x0064, Exception -> 0x005d }
            java.lang.String r4 = r9.getCategoryId()     // Catch:{ DeletedException -> 0x006b, JSONException -> 0x0064, Exception -> 0x005d }
            com.freshchat.consumer.sdk.service.e.n$a r5 = r9.dK()     // Catch:{ DeletedException -> 0x006b, JSONException -> 0x0064, Exception -> 0x005d }
            if (r5 == 0) goto L_0x0051
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ DeletedException -> 0x006b, JSONException -> 0x0064, Exception -> 0x005d }
            r5.<init>()     // Catch:{ DeletedException -> 0x006b, JSONException -> 0x0064, Exception -> 0x005d }
            com.freshchat.consumer.sdk.service.e.n$a r6 = r9.dK()     // Catch:{ DeletedException -> 0x006b, JSONException -> 0x0064, Exception -> 0x005d }
            java.lang.String r6 = r6.toString()     // Catch:{ DeletedException -> 0x006b, JSONException -> 0x0064, Exception -> 0x005d }
            java.lang.String r6 = r6.toLowerCase()     // Catch:{ DeletedException -> 0x006b, JSONException -> 0x0064, Exception -> 0x005d }
            r7 = 1
            r5.put(r6, r7)     // Catch:{ DeletedException -> 0x006b, JSONException -> 0x0064, Exception -> 0x005d }
            com.freshchat.consumer.sdk.e.a r6 = new com.freshchat.consumer.sdk.e.a     // Catch:{ DeletedException -> 0x006b, JSONException -> 0x0064, Exception -> 0x005d }
            android.content.Context r7 = r8.getContext()     // Catch:{ DeletedException -> 0x006b, JSONException -> 0x0064, Exception -> 0x005d }
            r6.<init>(r7)     // Catch:{ DeletedException -> 0x006b, JSONException -> 0x0064, Exception -> 0x005d }
            boolean r2 = r6.a(r4, r3, r5)     // Catch:{ DeletedException -> 0x006b, JSONException -> 0x0064, Exception -> 0x005d }
            if (r2 == 0) goto L_0x0051
            com.freshchat.consumer.sdk.b.j r4 = new com.freshchat.consumer.sdk.b.j     // Catch:{ DeletedException -> 0x006b, JSONException -> 0x0064, Exception -> 0x005d }
            r4.<init>(r1)     // Catch:{ DeletedException -> 0x006b, JSONException -> 0x0064, Exception -> 0x005d }
            com.freshchat.consumer.sdk.service.e.n$a r9 = r9.dK()     // Catch:{ DeletedException -> 0x006b, JSONException -> 0x0064, Exception -> 0x005d }
            r4.a(r3, r9)     // Catch:{ DeletedException -> 0x006b, JSONException -> 0x0064, Exception -> 0x005d }
        L_0x0051:
            if (r2 == 0) goto L_0x0057
        L_0x0053:
            com.freshchat.consumer.sdk.b.a.b(r1, r0)
            goto L_0x0072
        L_0x0057:
            com.freshchat.consumer.sdk.b.a.c(r1, r0)
            goto L_0x0072
        L_0x005b:
            r9 = move-exception
            goto L_0x0078
        L_0x005d:
            r9 = move-exception
            com.freshchat.consumer.sdk.j.q.a(r9)     // Catch:{ all -> 0x005b }
            if (r2 == 0) goto L_0x0057
            goto L_0x0053
        L_0x0064:
            r9 = move-exception
            com.freshchat.consumer.sdk.j.q.a(r9)     // Catch:{ all -> 0x005b }
            if (r2 == 0) goto L_0x0057
            goto L_0x0053
        L_0x006b:
            r9 = move-exception
            com.freshchat.consumer.sdk.j.q.a(r9)     // Catch:{ all -> 0x005b }
            if (r2 == 0) goto L_0x0057
            goto L_0x0053
        L_0x0072:
            com.freshchat.consumer.sdk.service.e.h r9 = new com.freshchat.consumer.sdk.service.e.h
            r9.<init>(r2)
            return r9
        L_0x0078:
            if (r2 == 0) goto L_0x007e
            com.freshchat.consumer.sdk.b.a.b(r1, r0)
            goto L_0x0081
        L_0x007e:
            com.freshchat.consumer.sdk.b.a.c(r1, r0)
        L_0x0081:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.service.c.m.b(com.freshchat.consumer.sdk.service.e.n):com.freshchat.consumer.sdk.service.e.k");
    }

    public boolean b(n nVar) {
        return w.ay(getContext()) && w.az(getContext());
    }
}
