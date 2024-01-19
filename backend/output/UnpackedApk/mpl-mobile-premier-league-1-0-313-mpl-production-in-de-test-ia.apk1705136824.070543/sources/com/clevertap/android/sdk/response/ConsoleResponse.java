package com.clevertap.android.sdk.response;

import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.Logger;

public class ConsoleResponse extends CleverTapResponseDecorator {
    public final CleverTapResponse cleverTapResponse;
    public final CleverTapInstanceConfig config;
    public final Logger logger;

    public ConsoleResponse(CleverTapResponse cleverTapResponse2, CleverTapInstanceConfig cleverTapInstanceConfig) {
        this.cleverTapResponse = cleverTapResponse2;
        this.config = cleverTapInstanceConfig;
        this.logger = cleverTapInstanceConfig.getLogger();
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0031 */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0037 A[Catch:{ all -> 0x005e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void processResponse(org.json.JSONObject r7, java.lang.String r8, android.content.Context r9) {
        /*
            r6 = this;
            java.lang.String r0 = "dbg_lvl"
            java.lang.String r1 = "console"
            boolean r2 = r7.has(r1)     // Catch:{ all -> 0x0031 }
            if (r2 == 0) goto L_0x0031
            java.lang.Object r1 = r7.get(r1)     // Catch:{ all -> 0x0031 }
            org.json.JSONArray r1 = (org.json.JSONArray) r1     // Catch:{ all -> 0x0031 }
            int r2 = r1.length()     // Catch:{ all -> 0x0031 }
            if (r2 <= 0) goto L_0x0031
            r2 = 0
        L_0x0017:
            int r3 = r1.length()     // Catch:{ all -> 0x0031 }
            if (r2 >= r3) goto L_0x0031
            com.clevertap.android.sdk.Logger r3 = r6.logger     // Catch:{ all -> 0x0031 }
            com.clevertap.android.sdk.CleverTapInstanceConfig r4 = r6.config     // Catch:{ all -> 0x0031 }
            java.lang.String r4 = r4.accountId     // Catch:{ all -> 0x0031 }
            java.lang.Object r5 = r1.get(r2)     // Catch:{ all -> 0x0031 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0031 }
            r3.debug(r4, r5)     // Catch:{ all -> 0x0031 }
            int r2 = r2 + 1
            goto L_0x0017
        L_0x0031:
            boolean r1 = r7.has(r0)     // Catch:{ all -> 0x005e }
            if (r1 == 0) goto L_0x005e
            int r0 = r7.getInt(r0)     // Catch:{ all -> 0x005e }
            if (r0 < 0) goto L_0x005e
            com.clevertap.android.sdk.CleverTapAPI.debugLevel = r0     // Catch:{ all -> 0x005e }
            com.clevertap.android.sdk.Logger r1 = r6.logger     // Catch:{ all -> 0x005e }
            com.clevertap.android.sdk.CleverTapInstanceConfig r2 = r6.config     // Catch:{ all -> 0x005e }
            java.lang.String r2 = r2.accountId     // Catch:{ all -> 0x005e }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x005e }
            r3.<init>()     // Catch:{ all -> 0x005e }
            java.lang.String r4 = "Set debug level to "
            r3.append(r4)     // Catch:{ all -> 0x005e }
            r3.append(r0)     // Catch:{ all -> 0x005e }
            java.lang.String r0 = " for this session (set by upstream)"
            r3.append(r0)     // Catch:{ all -> 0x005e }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x005e }
            r1.verbose(r2, r0)     // Catch:{ all -> 0x005e }
        L_0x005e:
            com.clevertap.android.sdk.response.CleverTapResponse r0 = r6.cleverTapResponse
            r0.processResponse(r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.response.ConsoleResponse.processResponse(org.json.JSONObject, java.lang.String, android.content.Context):void");
    }
}
