package com.google.firebase.perf.metrics.validator;

import android.content.Context;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.v1.NetworkRequestMetric;

public final class FirebasePerfNetworkValidator extends PerfMetricValidator {
    public static final AndroidLogger logger = AndroidLogger.getInstance();
    public final Context appContext;
    public final NetworkRequestMetric networkMetric;

    public FirebasePerfNetworkValidator(NetworkRequestMetric networkRequestMetric, Context context) {
        this.appContext = context;
        this.networkMetric = networkRequestMetric;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isValidPerfMetric() {
        /*
            r9 = this;
            com.google.firebase.perf.v1.NetworkRequestMetric r0 = r9.networkMetric
            java.lang.String r0 = r0.url_
            r1 = 1
            if (r0 != 0) goto L_0x0009
            r0 = 1
            goto L_0x0011
        L_0x0009:
            java.lang.String r0 = r0.trim()
            boolean r0 = r0.isEmpty()
        L_0x0011:
            r2 = 0
            if (r0 == 0) goto L_0x002b
            com.google.firebase.perf.logging.AndroidLogger r0 = logger
            java.lang.String r1 = "URL is missing:"
            java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r1)
            com.google.firebase.perf.v1.NetworkRequestMetric r3 = r9.networkMetric
            java.lang.String r3 = r3.url_
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r0.warn(r1)
            return r2
        L_0x002b:
            com.google.firebase.perf.v1.NetworkRequestMetric r0 = r9.networkMetric
            java.lang.String r0 = r0.url_
            r3 = 0
            if (r0 != 0) goto L_0x0033
            goto L_0x004a
        L_0x0033:
            java.net.URI r0 = java.net.URI.create(r0)     // Catch:{ IllegalArgumentException -> 0x003a, IllegalStateException -> 0x0038 }
            goto L_0x004b
        L_0x0038:
            r0 = move-exception
            goto L_0x003b
        L_0x003a:
            r0 = move-exception
        L_0x003b:
            com.google.firebase.perf.logging.AndroidLogger r4 = logger
            java.lang.Object[] r5 = new java.lang.Object[r1]
            java.lang.String r0 = r0.getMessage()
            r5[r2] = r0
            java.lang.String r0 = "getResultUrl throws exception %s"
            r4.warn(r0, r5)
        L_0x004a:
            r0 = r3
        L_0x004b:
            if (r0 != 0) goto L_0x0055
            com.google.firebase.perf.logging.AndroidLogger r0 = logger
            java.lang.String r1 = "URL cannot be parsed"
            r0.warn(r1)
            return r2
        L_0x0055:
            android.content.Context r4 = r9.appContext
            android.content.res.Resources r5 = r4.getResources()
            java.lang.String r4 = r4.getPackageName()
            java.lang.String r6 = "firebase_performance_whitelisted_domains"
            java.lang.String r7 = "array"
            int r4 = r5.getIdentifier(r6, r7, r4)
            if (r4 != 0) goto L_0x006a
            goto L_0x0092
        L_0x006a:
            com.google.firebase.perf.logging.AndroidLogger r6 = com.google.firebase.perf.logging.AndroidLogger.getInstance()
            java.lang.String r7 = "Detected domain allowlist, only allowlisted domains will be measured."
            r6.debug(r7)
            java.lang.String[] r6 = com.google.android.material.resources.TextAppearanceConfig.allowlistedDomains
            if (r6 != 0) goto L_0x007d
            java.lang.String[] r4 = r5.getStringArray(r4)
            com.google.android.material.resources.TextAppearanceConfig.allowlistedDomains = r4
        L_0x007d:
            java.lang.String r4 = r0.getHost()
            if (r4 != 0) goto L_0x0084
            goto L_0x0092
        L_0x0084:
            java.lang.String[] r5 = com.google.android.material.resources.TextAppearanceConfig.allowlistedDomains
            int r6 = r5.length
            r7 = 0
        L_0x0088:
            if (r7 >= r6) goto L_0x0097
            r8 = r5[r7]
            boolean r8 = r4.contains(r8)
            if (r8 == 0) goto L_0x0094
        L_0x0092:
            r4 = 1
            goto L_0x0098
        L_0x0094:
            int r7 = r7 + 1
            goto L_0x0088
        L_0x0097:
            r4 = 0
        L_0x0098:
            if (r4 != 0) goto L_0x00b1
            com.google.firebase.perf.logging.AndroidLogger r1 = logger
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "URL fails allowlist rule: "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r1.warn(r0)
            return r2
        L_0x00b1:
            java.lang.String r4 = r0.getHost()
            if (r4 == 0) goto L_0x00cb
            java.lang.String r5 = r4.trim()
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x00cb
            int r4 = r4.length()
            r5 = 255(0xff, float:3.57E-43)
            if (r4 > r5) goto L_0x00cb
            r4 = 1
            goto L_0x00cc
        L_0x00cb:
            r4 = 0
        L_0x00cc:
            if (r4 != 0) goto L_0x00d6
            com.google.firebase.perf.logging.AndroidLogger r0 = logger
            java.lang.String r1 = "URL host is null or invalid"
            r0.warn(r1)
            return r2
        L_0x00d6:
            java.lang.String r4 = r0.getScheme()
            if (r4 != 0) goto L_0x00dd
            goto L_0x00ee
        L_0x00dd:
            java.lang.String r5 = "http"
            boolean r5 = r5.equalsIgnoreCase(r4)
            if (r5 != 0) goto L_0x00f0
            java.lang.String r5 = "https"
            boolean r4 = r5.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x00ee
            goto L_0x00f0
        L_0x00ee:
            r4 = 0
            goto L_0x00f1
        L_0x00f0:
            r4 = 1
        L_0x00f1:
            if (r4 != 0) goto L_0x00fb
            com.google.firebase.perf.logging.AndroidLogger r0 = logger
            java.lang.String r1 = "URL scheme is null or invalid"
            r0.warn(r1)
            return r2
        L_0x00fb:
            java.lang.String r4 = r0.getUserInfo()
            if (r4 != 0) goto L_0x0103
            r4 = 1
            goto L_0x0104
        L_0x0103:
            r4 = 0
        L_0x0104:
            if (r4 != 0) goto L_0x010e
            com.google.firebase.perf.logging.AndroidLogger r0 = logger
            java.lang.String r1 = "URL user info is null"
            r0.warn(r1)
            return r2
        L_0x010e:
            int r0 = r0.getPort()
            r4 = -1
            if (r0 == r4) goto L_0x011a
            if (r0 <= 0) goto L_0x0118
            goto L_0x011a
        L_0x0118:
            r0 = 0
            goto L_0x011b
        L_0x011a:
            r0 = 1
        L_0x011b:
            if (r0 != 0) goto L_0x0125
            com.google.firebase.perf.logging.AndroidLogger r0 = logger
            java.lang.String r1 = "URL port is less than or equal to 0"
            r0.warn(r1)
            return r2
        L_0x0125:
            com.google.firebase.perf.v1.NetworkRequestMetric r0 = r9.networkMetric
            int r0 = r0.bitField0_
            r0 = r0 & 2
            if (r0 == 0) goto L_0x012f
            r0 = 1
            goto L_0x0130
        L_0x012f:
            r0 = 0
        L_0x0130:
            if (r0 == 0) goto L_0x013f
            com.google.firebase.perf.v1.NetworkRequestMetric r0 = r9.networkMetric
            int r0 = r0.httpMethod_
            com.google.firebase.perf.v1.NetworkRequestMetric$HttpMethod r0 = com.google.firebase.perf.v1.NetworkRequestMetric.HttpMethod.forNumber(r0)
            if (r0 != 0) goto L_0x013e
            com.google.firebase.perf.v1.NetworkRequestMetric$HttpMethod r0 = com.google.firebase.perf.v1.NetworkRequestMetric.HttpMethod.HTTP_METHOD_UNKNOWN
        L_0x013e:
            r3 = r0
        L_0x013f:
            if (r3 == 0) goto L_0x0147
            com.google.firebase.perf.v1.NetworkRequestMetric$HttpMethod r0 = com.google.firebase.perf.v1.NetworkRequestMetric.HttpMethod.HTTP_METHOD_UNKNOWN
            if (r3 == r0) goto L_0x0147
            r0 = 1
            goto L_0x0148
        L_0x0147:
            r0 = 0
        L_0x0148:
            if (r0 != 0) goto L_0x0169
            com.google.firebase.perf.logging.AndroidLogger r0 = logger
            java.lang.String r1 = "HTTP Method is null or invalid: "
            java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r1)
            com.google.firebase.perf.v1.NetworkRequestMetric r3 = r9.networkMetric
            int r3 = r3.httpMethod_
            com.google.firebase.perf.v1.NetworkRequestMetric$HttpMethod r3 = com.google.firebase.perf.v1.NetworkRequestMetric.HttpMethod.forNumber(r3)
            if (r3 != 0) goto L_0x015e
            com.google.firebase.perf.v1.NetworkRequestMetric$HttpMethod r3 = com.google.firebase.perf.v1.NetworkRequestMetric.HttpMethod.HTTP_METHOD_UNKNOWN
        L_0x015e:
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r0.warn(r1)
            return r2
        L_0x0169:
            com.google.firebase.perf.v1.NetworkRequestMetric r0 = r9.networkMetric
            boolean r0 = r0.hasHttpResponseCode()
            if (r0 == 0) goto L_0x0193
            com.google.firebase.perf.v1.NetworkRequestMetric r0 = r9.networkMetric
            int r0 = r0.httpResponseCode_
            if (r0 <= 0) goto L_0x0179
            r0 = 1
            goto L_0x017a
        L_0x0179:
            r0 = 0
        L_0x017a:
            if (r0 != 0) goto L_0x0193
            com.google.firebase.perf.logging.AndroidLogger r0 = logger
            java.lang.String r1 = "HTTP ResponseCode is a negative value:"
            java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r1)
            com.google.firebase.perf.v1.NetworkRequestMetric r3 = r9.networkMetric
            int r3 = r3.httpResponseCode_
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r0.warn(r1)
            return r2
        L_0x0193:
            com.google.firebase.perf.v1.NetworkRequestMetric r0 = r9.networkMetric
            int r0 = r0.bitField0_
            r0 = r0 & 4
            if (r0 == 0) goto L_0x019d
            r0 = 1
            goto L_0x019e
        L_0x019d:
            r0 = 0
        L_0x019e:
            r3 = 0
            if (r0 == 0) goto L_0x01c6
            com.google.firebase.perf.v1.NetworkRequestMetric r0 = r9.networkMetric
            long r5 = r0.requestPayloadBytes_
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 < 0) goto L_0x01ac
            r0 = 1
            goto L_0x01ad
        L_0x01ac:
            r0 = 0
        L_0x01ad:
            if (r0 != 0) goto L_0x01c6
            com.google.firebase.perf.logging.AndroidLogger r0 = logger
            java.lang.String r1 = "Request Payload is a negative value:"
            java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r1)
            com.google.firebase.perf.v1.NetworkRequestMetric r3 = r9.networkMetric
            long r3 = r3.requestPayloadBytes_
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r0.warn(r1)
            return r2
        L_0x01c6:
            com.google.firebase.perf.v1.NetworkRequestMetric r0 = r9.networkMetric
            int r0 = r0.bitField0_
            r0 = r0 & 8
            if (r0 == 0) goto L_0x01d0
            r0 = 1
            goto L_0x01d1
        L_0x01d0:
            r0 = 0
        L_0x01d1:
            if (r0 == 0) goto L_0x01f7
            com.google.firebase.perf.v1.NetworkRequestMetric r0 = r9.networkMetric
            long r5 = r0.responsePayloadBytes_
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 < 0) goto L_0x01dd
            r0 = 1
            goto L_0x01de
        L_0x01dd:
            r0 = 0
        L_0x01de:
            if (r0 != 0) goto L_0x01f7
            com.google.firebase.perf.logging.AndroidLogger r0 = logger
            java.lang.String r1 = "Response Payload is a negative value:"
            java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r1)
            com.google.firebase.perf.v1.NetworkRequestMetric r3 = r9.networkMetric
            long r3 = r3.responsePayloadBytes_
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r0.warn(r1)
            return r2
        L_0x01f7:
            com.google.firebase.perf.v1.NetworkRequestMetric r0 = r9.networkMetric
            int r0 = r0.bitField0_
            r0 = r0 & 128(0x80, float:1.8E-43)
            if (r0 == 0) goto L_0x0201
            r0 = 1
            goto L_0x0202
        L_0x0201:
            r0 = 0
        L_0x0202:
            if (r0 == 0) goto L_0x02a5
            com.google.firebase.perf.v1.NetworkRequestMetric r0 = r9.networkMetric
            long r5 = r0.clientStartTimeUs_
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 > 0) goto L_0x020e
            goto L_0x02a5
        L_0x020e:
            int r0 = r0.bitField0_
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0216
            r0 = 1
            goto L_0x0217
        L_0x0216:
            r0 = 0
        L_0x0217:
            if (r0 == 0) goto L_0x023d
            com.google.firebase.perf.v1.NetworkRequestMetric r0 = r9.networkMetric
            long r5 = r0.timeToRequestCompletedUs_
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 < 0) goto L_0x0223
            r0 = 1
            goto L_0x0224
        L_0x0223:
            r0 = 0
        L_0x0224:
            if (r0 != 0) goto L_0x023d
            com.google.firebase.perf.logging.AndroidLogger r0 = logger
            java.lang.String r1 = "Time to complete the request is a negative value:"
            java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r1)
            com.google.firebase.perf.v1.NetworkRequestMetric r3 = r9.networkMetric
            long r3 = r3.timeToRequestCompletedUs_
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r0.warn(r1)
            return r2
        L_0x023d:
            com.google.firebase.perf.v1.NetworkRequestMetric r0 = r9.networkMetric
            int r0 = r0.bitField0_
            r0 = r0 & 512(0x200, float:7.17E-43)
            if (r0 == 0) goto L_0x0247
            r0 = 1
            goto L_0x0248
        L_0x0247:
            r0 = 0
        L_0x0248:
            if (r0 == 0) goto L_0x026e
            com.google.firebase.perf.v1.NetworkRequestMetric r0 = r9.networkMetric
            long r5 = r0.timeToResponseInitiatedUs_
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 < 0) goto L_0x0254
            r0 = 1
            goto L_0x0255
        L_0x0254:
            r0 = 0
        L_0x0255:
            if (r0 != 0) goto L_0x026e
            com.google.firebase.perf.logging.AndroidLogger r0 = logger
            java.lang.String r1 = "Time from the start of the request to the start of the response is null or a negative value:"
            java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r1)
            com.google.firebase.perf.v1.NetworkRequestMetric r3 = r9.networkMetric
            long r3 = r3.timeToResponseInitiatedUs_
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r0.warn(r1)
            return r2
        L_0x026e:
            com.google.firebase.perf.v1.NetworkRequestMetric r0 = r9.networkMetric
            boolean r0 = r0.hasTimeToResponseCompletedUs()
            if (r0 == 0) goto L_0x028e
            com.google.firebase.perf.v1.NetworkRequestMetric r0 = r9.networkMetric
            long r5 = r0.timeToResponseCompletedUs_
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 > 0) goto L_0x027f
            goto L_0x028e
        L_0x027f:
            boolean r0 = r0.hasHttpResponseCode()
            if (r0 != 0) goto L_0x028d
            com.google.firebase.perf.logging.AndroidLogger r0 = logger
            java.lang.String r1 = "Did not receive a HTTP Response Code"
            r0.warn(r1)
            return r2
        L_0x028d:
            return r1
        L_0x028e:
            com.google.firebase.perf.logging.AndroidLogger r0 = logger
            java.lang.String r1 = "Time from the start of the request to the end of the response is null, negative or zero:"
            java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r1)
            com.google.firebase.perf.v1.NetworkRequestMetric r3 = r9.networkMetric
            long r3 = r3.timeToResponseCompletedUs_
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r0.warn(r1)
            return r2
        L_0x02a5:
            com.google.firebase.perf.logging.AndroidLogger r0 = logger
            java.lang.String r1 = "Start time of the request is null, or zero, or a negative value:"
            java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r1)
            com.google.firebase.perf.v1.NetworkRequestMetric r3 = r9.networkMetric
            long r3 = r3.clientStartTimeUs_
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r0.warn(r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.metrics.validator.FirebasePerfNetworkValidator.isValidPerfMetric():boolean");
    }
}
