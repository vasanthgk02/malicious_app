package com.twitter.sdk.android.core;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.twitter.sdk.android.core.models.ApiError;
import com.twitter.sdk.android.core.models.ApiErrors;
import com.twitter.sdk.android.core.models.SafeListAdapter;
import com.twitter.sdk.android.core.models.SafeMapAdapter;

public class TwitterApiException extends TwitterException {
    public final ApiError apiError;

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TwitterApiException(retrofit2.Response r6) {
        /*
            r5 = this;
            okhttp3.ResponseBody r0 = r6.errorBody     // Catch:{ Exception -> 0x001d }
            okio.BufferedSource r0 = r0.source()     // Catch:{ Exception -> 0x001d }
            okio.Buffer r0 = r0.buffer()     // Catch:{ Exception -> 0x001d }
            okio.Buffer r0 = r0.clone()     // Catch:{ Exception -> 0x001d }
            java.lang.String r0 = r0.readUtf8()     // Catch:{ Exception -> 0x001d }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x001d }
            if (r1 != 0) goto L_0x001d
            com.twitter.sdk.android.core.models.ApiError r0 = parseApiError(r0)     // Catch:{ Exception -> 0x001d }
            goto L_0x001e
        L_0x001d:
            r0 = 0
        L_0x001e:
            okhttp3.Headers r1 = r6.headers()
            if (r1 == 0) goto L_0x0088
            r2 = 0
        L_0x0025:
            int r3 = r1.size()
            if (r2 >= r3) goto L_0x0078
            java.lang.String r3 = r1.name(r2)
            java.lang.String r4 = "x-rate-limit-limit"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x0044
            java.lang.String r3 = r1.value(r2)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r3.intValue()
            goto L_0x0075
        L_0x0044:
            java.lang.String r3 = r1.name(r2)
            java.lang.String r4 = "x-rate-limit-remaining"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x005d
            java.lang.String r3 = r1.value(r2)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r3.intValue()
            goto L_0x0075
        L_0x005d:
            java.lang.String r3 = r1.name(r2)
            java.lang.String r4 = "x-rate-limit-reset"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x0075
            java.lang.String r3 = r1.value(r2)
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r3.longValue()
        L_0x0075:
            int r2 = r2 + 1
            goto L_0x0025
        L_0x0078:
            int r6 = r6.code()
            java.lang.String r1 = "HTTP request failed, Status: "
            java.lang.String r6 = com.android.tools.r8.GeneratedOutlineSupport.outline41(r1, r6)
            r5.<init>(r6)
            r5.apiError = r0
            return
        L_0x0088:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "headers must not be null"
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.core.TwitterApiException.<init>(retrofit2.Response):void");
    }

    public static ApiError parseApiError(String str) {
        try {
            ApiErrors apiErrors = (ApiErrors) new GsonBuilder().registerTypeAdapterFactory(new SafeListAdapter()).registerTypeAdapterFactory(new SafeMapAdapter()).create().fromJson(str, ApiErrors.class);
            if (!apiErrors.errors.isEmpty()) {
                return apiErrors.errors.get(0);
            }
        } catch (JsonSyntaxException unused) {
        }
        return null;
    }
}
