package io.hansel.userjourney;

import android.content.Context;
import io.hansel.core.json.CoreJSONException;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogger;
import io.hansel.userjourney.models.d;
import io.hansel.userjourney.r.f;
import sfs2x.client.requests.CreateRoomRequest;

public class g {
    public static d a(String str, String str2, CoreJSONObject coreJSONObject, Context context) {
        try {
            String optString = coreJSONObject.optString("jh");
            String optString2 = coreJSONObject.optString("jn");
            p.a(context, optString, coreJSONObject.optLong("ad_in_mins", 1440));
            d dVar = new d(str, optString, new f(optString, str2, coreJSONObject.getJSONObject("dt"), context), coreJSONObject.optJSONArray(CreateRoomRequest.KEY_EVENTS), optString2);
            return dVar;
        } catch (CoreJSONException e2) {
            HSLLogger.printStackTrace(e2);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0075 A[Catch:{ CoreJSONException -> 0x00aa }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0091 A[Catch:{ CoreJSONException -> 0x00aa }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ArrayList<io.hansel.userjourney.r.c> a(java.lang.String r17, java.lang.String r18, io.hansel.core.json.CoreJSONArray r19, android.content.Context r20) {
        /*
            r1 = r17
            r2 = r18
            r3 = r19
            r4 = r20
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            if (r3 != 0) goto L_0x0010
            return r5
        L_0x0010:
            int r6 = r19.length()
            r8 = 0
        L_0x0015:
            if (r8 >= r6) goto L_0x00ba
            io.hansel.core.json.CoreJSONObject r0 = r3.getJSONObject(r8)     // Catch:{ CoreJSONException -> 0x00ac }
            java.util.Set r9 = r0.keySet()     // Catch:{ CoreJSONException -> 0x00ac }
            int r10 = r9.size()     // Catch:{ CoreJSONException -> 0x00ac }
            r11 = 1
            if (r10 <= r11) goto L_0x002b
            java.lang.String r10 = "Set<String> size cannot be greater than one for parseStatementArray. "
            io.hansel.core.logger.HSLLogger.e(r10)     // Catch:{ CoreJSONException -> 0x00ac }
        L_0x002b:
            r10 = 0
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ CoreJSONException -> 0x00ac }
            r12.<init>(r9)     // Catch:{ CoreJSONException -> 0x00ac }
            int r9 = r12.size()     // Catch:{ CoreJSONException -> 0x00ac }
            r13 = 0
        L_0x0036:
            if (r13 >= r9) goto L_0x00a4
            java.lang.Object r14 = r12.get(r13)     // Catch:{ CoreJSONException -> 0x00ac }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ CoreJSONException -> 0x00ac }
            int r7 = r14.hashCode()     // Catch:{ CoreJSONException -> 0x00ac }
            r15 = 99330(0x18402, float:1.39191E-40)
            java.lang.String r11 = "leaf"
            java.lang.String r3 = "rol"
            r16 = r6
            java.lang.String r6 = "dec"
            if (r7 == r15) goto L_0x006a
            r15 = 113103(0x1b9cf, float:1.58491E-40)
            if (r7 == r15) goto L_0x0062
            r15 = 3317598(0x329f5e, float:4.648945E-39)
            if (r7 == r15) goto L_0x005a
            goto L_0x0072
        L_0x005a:
            boolean r7 = r14.equals(r11)     // Catch:{ CoreJSONException -> 0x00aa }
            if (r7 == 0) goto L_0x0072
            r15 = 2
            goto L_0x0073
        L_0x0062:
            boolean r7 = r14.equals(r3)     // Catch:{ CoreJSONException -> 0x00aa }
            if (r7 == 0) goto L_0x0072
            r15 = 1
            goto L_0x0073
        L_0x006a:
            boolean r7 = r14.equals(r6)     // Catch:{ CoreJSONException -> 0x00aa }
            if (r7 == 0) goto L_0x0072
            r15 = 0
            goto L_0x0073
        L_0x0072:
            r15 = -1
        L_0x0073:
            if (r15 == 0) goto L_0x0091
            r7 = 1
            if (r15 == r7) goto L_0x0086
            r6 = 2
            if (r15 == r6) goto L_0x007c
            goto L_0x009c
        L_0x007c:
            io.hansel.userjourney.r.d r3 = new io.hansel.userjourney.r.d     // Catch:{ CoreJSONException -> 0x00aa }
            io.hansel.core.json.CoreJSONObject r6 = r0.optJSONObject(r11)     // Catch:{ CoreJSONException -> 0x00aa }
            r3.<init>(r1, r2, r6, r4)     // Catch:{ CoreJSONException -> 0x00aa }
            goto L_0x009b
        L_0x0086:
            io.hansel.userjourney.r.e r6 = new io.hansel.userjourney.r.e     // Catch:{ CoreJSONException -> 0x00aa }
            io.hansel.core.json.CoreJSONObject r3 = r0.optJSONObject(r3)     // Catch:{ CoreJSONException -> 0x00aa }
            r6.<init>(r1, r2, r3, r4)     // Catch:{ CoreJSONException -> 0x00aa }
            r10 = r6
            goto L_0x009c
        L_0x0091:
            r7 = 1
            io.hansel.userjourney.r.b r3 = new io.hansel.userjourney.r.b     // Catch:{ CoreJSONException -> 0x00aa }
            io.hansel.core.json.CoreJSONObject r6 = r0.optJSONObject(r6)     // Catch:{ CoreJSONException -> 0x00aa }
            r3.<init>(r1, r2, r6, r4)     // Catch:{ CoreJSONException -> 0x00aa }
        L_0x009b:
            r10 = r3
        L_0x009c:
            int r13 = r13 + 1
            r3 = r19
            r6 = r16
            r11 = 1
            goto L_0x0036
        L_0x00a4:
            r16 = r6
            r5.add(r10)     // Catch:{ CoreJSONException -> 0x00aa }
            goto L_0x00b2
        L_0x00aa:
            r0 = move-exception
            goto L_0x00af
        L_0x00ac:
            r0 = move-exception
            r16 = r6
        L_0x00af:
            io.hansel.core.logger.HSLLogger.printStackTrace(r0)
        L_0x00b2:
            int r8 = r8 + 1
            r3 = r19
            r6 = r16
            goto L_0x0015
        L_0x00ba:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.hansel.userjourney.g.a(java.lang.String, java.lang.String, io.hansel.core.json.CoreJSONArray, android.content.Context):java.util.ArrayList");
    }
}
