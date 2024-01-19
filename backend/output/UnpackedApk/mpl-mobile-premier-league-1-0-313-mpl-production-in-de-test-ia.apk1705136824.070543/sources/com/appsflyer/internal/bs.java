package com.appsflyer.internal;

import com.appsflyer.internal.components.network.http.exceptions.HttpException;
import java.io.InterruptedIOException;

public final class bs extends bn<bu> {
    public final bw AFInAppEventParameterName;
    public final aa AFInAppEventType;
    public bu AFKeystoreWrapper = null;
    public final bd AFLogger$LogLevel;
    public final String AFVersionDeclaration;
    public final cb getLevel;
    public ap valueOf;
    public final bx values;

    public bs(bw bwVar, aa aaVar, ca caVar, bx bxVar, bd bdVar, cb cbVar, String str) {
        super(bt.RC_CDN, new bt[0], "UpdateRemoteConfiguration");
        this.AFInAppEventParameterName = bwVar;
        this.AFInAppEventType = aaVar;
        this.values = bxVar;
        this.AFLogger$LogLevel = bdVar;
        this.getLevel = cbVar;
        this.AFVersionDeclaration = str;
    }

    private void AFInAppEventType(String str, long j, br<?> brVar, ao aoVar, cw cwVar, Throwable th) {
        int i;
        long j2;
        Throwable th2;
        long j3;
        br<?> brVar2 = brVar;
        ao aoVar2 = aoVar;
        Throwable th3 = th;
        if (brVar2 != null) {
            j2 = brVar2.AFInAppEventType.AFKeystoreWrapper;
            i = brVar2.values;
        } else {
            j2 = 0;
            i = 0;
        }
        if (th3 instanceof HttpException) {
            th2 = th.getCause();
            j3 = ((HttpException) th3).getMetrics().AFKeystoreWrapper;
        } else {
            th2 = th3;
            j3 = j2;
        }
        ap apVar = new ap(aoVar2 != null ? aoVar2.valueOf : null, str, j3, System.currentTimeMillis() - j, i, cwVar, th2);
        this.valueOf = apVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0057 A[SYNTHETIC, Splitter:B:12:0x0057] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.appsflyer.internal.bu AFKeystoreWrapper() throws java.lang.InterruptedException, java.io.InterruptedIOException {
        /*
            r16 = this;
            r9 = r16
            java.lang.String r0 = " seconds"
            long r10 = java.lang.System.currentTimeMillis()
            java.lang.String r1 = r9.AFVersionDeclaration
            com.appsflyer.AppsFlyerProperties r2 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r2 = r2.getDevKey()
            r3 = 2
            r4 = 1
            r5 = 0
            java.lang.String r6 = "CFG: Dev key is not set, SDK is not started."
            if (r2 == 0) goto L_0x0049
            java.lang.String r7 = r2.trim()
            int r7 = r7.length()
            if (r7 != 0) goto L_0x0024
            goto L_0x0049
        L_0x0024:
            if (r1 != 0) goto L_0x002c
            java.lang.String r1 = "CFG: Can't create CDN token, domain or version is not provided."
            com.appsflyer.AFLogger.AppsFlyer2dXConversionCallback(r1)
            goto L_0x004c
        L_0x002c:
            r7 = 3
            java.lang.String[] r7 = new java.lang.String[r7]
            java.lang.String r8 = "appsflyersdk.com"
            r7[r5] = r8
            r7[r4] = r1
            com.appsflyer.internal.aa r1 = r9.AFInAppEventType
            android.content.Context r1 = r1.AFInAppEventParameterName
            java.lang.String r1 = r1.getPackageName()
            r7[r3] = r1
            java.lang.String r1 = com.appsflyer.internal.ag.AFInAppEventParameterName(r7)
            java.lang.String r1 = com.appsflyer.internal.ag.valueOf(r1, r2)
            r13 = r1
            goto L_0x004d
        L_0x0049:
            com.appsflyer.AFLogger.AppsFlyer2dXConversionCallback(r6)
        L_0x004c:
            r13 = 0
        L_0x004d:
            if (r13 != 0) goto L_0x0057
            java.lang.String r0 = "CFG: can't create CDN token, skipping fetch config"
            com.appsflyer.AFLogger.AFKeystoreWrapper(r0)
            com.appsflyer.internal.bu r0 = com.appsflyer.internal.bu.FAILURE
            return r0
        L_0x0057:
            com.appsflyer.internal.cb r1 = r9.getLevel     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            boolean r1 = r1.AFInAppEventParameterName()     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            if (r1 == 0) goto L_0x01d9
            java.lang.String r1 = "CFG: Cached config is expired, updating..."
            com.appsflyer.AFLogger.values(r1)     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            com.appsflyer.internal.cb r1 = r9.getLevel     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            boolean r1 = r1.AFInAppEventType()     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            com.appsflyer.internal.bd r2 = r9.AFLogger$LogLevel     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            if (r1 == 0) goto L_0x0071
            java.lang.String r1 = com.appsflyer.internal.bd.AFKeystoreWrapper     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            goto L_0x0073
        L_0x0071:
            java.lang.String r1 = com.appsflyer.internal.bd.values     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
        L_0x0073:
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            r4[r5] = r13     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            java.lang.String r1 = java.lang.String.format(r1, r4)     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            com.appsflyer.internal.z r4 = new com.appsflyer.internal.z     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            java.lang.String r5 = "GET"
            r4.<init>(r1, r5)     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            r1 = 500(0x1f4, float:7.0E-43)
            r4.valueOf = r1     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            com.appsflyer.internal.bp r1 = new com.appsflyer.internal.bp     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            r1.<init>()     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            boolean r5 = r2.AFInAppEventType()     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            r4.AFInAppEventParameterName = r5     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            com.appsflyer.internal.ab r2 = r2.AFInAppEventType     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            com.appsflyer.internal.bl r5 = new com.appsflyer.internal.bl     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            java.util.concurrent.ExecutorService r7 = r2.AFKeystoreWrapper     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            com.appsflyer.internal.bm r2 = r2.valueOf     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            r5.<init>(r4, r7, r2, r1)     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            com.appsflyer.internal.br r14 = r5.AFKeystoreWrapper()     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            boolean r1 = r14.values()     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            if (r1 == 0) goto L_0x01b4
            Body r1 = r14.valueOf     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            com.appsflyer.internal.ao r1 = (com.appsflyer.internal.ao) r1     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            java.lang.String r2 = "x-amz-meta-af-auth-v1"
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> r4 = r14.AFInAppEventParameterName     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            java.util.Set r4 = r4.keySet()     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
        L_0x00b6:
            boolean r5 = r4.hasNext()     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            if (r5 == 0) goto L_0x00d3
            java.lang.Object r5 = r4.next()     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            if (r5 == 0) goto L_0x00b6
            boolean r7 = r5.equalsIgnoreCase(r2)     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            if (r7 == 0) goto L_0x00b6
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> r2 = r14.AFInAppEventParameterName     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            java.lang.Object r2 = r2.get(r5)     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            java.util.List r2 = (java.util.List) r2     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            goto L_0x00d4
        L_0x00d3:
            r2 = 0
        L_0x00d4:
            if (r2 == 0) goto L_0x0105
            boolean r4 = r2.isEmpty()     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            if (r4 != 0) goto L_0x0105
            java.util.Iterator r2 = r2.iterator()     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            java.lang.Object r5 = r2.next()     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            r4.<init>(r5)     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
        L_0x00eb:
            boolean r5 = r2.hasNext()     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            if (r5 == 0) goto L_0x0100
            java.lang.String r5 = ", "
            r4.append(r5)     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            java.lang.Object r5 = r2.next()     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            r4.append(r5)     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            goto L_0x00eb
        L_0x0100:
            java.lang.String r2 = r4.toString()     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            goto L_0x0106
        L_0x0105:
            r2 = 0
        L_0x0106:
            com.appsflyer.AppsFlyerProperties r4 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            java.lang.String r4 = r4.getDevKey()     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            if (r4 == 0) goto L_0x01ae
            java.lang.String r5 = r4.trim()     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            int r5 = r5.length()     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            if (r5 != 0) goto L_0x011c
            goto L_0x01ae
        L_0x011c:
            com.appsflyer.internal.bw r5 = r9.AFInAppEventParameterName     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            com.appsflyer.internal.ay r2 = r5.AFKeystoreWrapper(r1, r2, r13, r4)     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            boolean r4 = r2.AFInAppEventParameterName()     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            if (r4 == 0) goto L_0x0196
            com.appsflyer.internal.cb r4 = r9.getLevel     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            long r4 = r4.valueOf()     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            java.lang.String r7 = "CFG: using max-age fallback: "
            r6.<init>(r7)     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            r6.append(r4)     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            r6.append(r0)     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            java.lang.String r6 = r6.toString()     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            com.appsflyer.AFLogger.AFKeystoreWrapper(r6)     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            com.appsflyer.internal.bx r8 = r9.values     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            java.lang.String r15 = r1.AFInAppEventParameterName     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            java.nio.charset.Charset r12 = com.appsflyer.internal.bx.AFInAppEventParameterName     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            byte[] r12 = r15.getBytes(r12)     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            java.lang.String r3 = android.util.Base64.encodeToString(r12, r3)     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            com.appsflyer.internal.bv r12 = r8.AFKeystoreWrapper     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            java.lang.String r15 = "af_remote_config"
            r12.AFInAppEventParameterName(r15, r3)     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            com.appsflyer.internal.bv r3 = r8.AFKeystoreWrapper     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            java.lang.String r12 = "af_rc_timestamp"
            r3.AFKeystoreWrapper(r12, r6)     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            com.appsflyer.internal.bv r3 = r8.AFKeystoreWrapper     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            java.lang.String r12 = "af_rc_max_age"
            r3.AFKeystoreWrapper(r12, r4)     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            r8.values = r1     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            r8.AFInAppEventType = r6     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            r8.valueOf = r4     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            java.lang.String r3 = "CFG: Config successfully updated, timeToLive: "
            r1.<init>(r3)     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            r1.append(r4)     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            r1.append(r0)     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            java.lang.String r0 = r1.toString()     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            com.appsflyer.AFLogger.AFInAppEventParameterName(r0)     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            com.appsflyer.internal.cw r7 = r2.AFInAppEventType     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            Body r0 = r14.valueOf     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            r6 = r0
            com.appsflyer.internal.ao r6 = (com.appsflyer.internal.ao) r6     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            r8 = 0
            r1 = r16
            r2 = r13
            r3 = r10
            r5 = r14
            r1.AFInAppEventType(r2, r3, r5, r6, r7, r8)     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            com.appsflyer.internal.bu r0 = com.appsflyer.internal.bu.SUCCESS     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            return r0
        L_0x0196:
            com.appsflyer.internal.cw r7 = r2.AFInAppEventType     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            Body r0 = r14.valueOf     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            r6 = r0
            com.appsflyer.internal.ao r6 = (com.appsflyer.internal.ao) r6     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            r8 = 0
            r1 = r16
            r2 = r13
            r3 = r10
            r5 = r14
            r1.AFInAppEventType(r2, r3, r5, r6, r7, r8)     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            java.lang.String r0 = "CFG: fetched config is not valid (MITM?) refuse to use it."
            com.appsflyer.AFLogger.AppsFlyer2dXConversionCallback(r0)     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            com.appsflyer.internal.bu r0 = com.appsflyer.internal.bu.FAILURE     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            return r0
        L_0x01ae:
            com.appsflyer.AFLogger.AppsFlyer2dXConversionCallback(r6)     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            com.appsflyer.internal.bu r0 = com.appsflyer.internal.bu.FAILURE     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            return r0
        L_0x01b4:
            r7 = 0
            Body r0 = r14.valueOf     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            r6 = r0
            com.appsflyer.internal.ao r6 = (com.appsflyer.internal.ao) r6     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            r8 = 0
            r1 = r16
            r2 = r13
            r3 = r10
            r5 = r14
            r1.AFInAppEventType(r2, r3, r5, r6, r7, r8)     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            java.lang.String r1 = "CFG: failed to fetch remote config from CDN with status code: "
            r0.<init>(r1)     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            int r1 = r14.values     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            r0.append(r1)     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            com.appsflyer.AFLogger.AppsFlyer2dXConversionCallback(r0)     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            com.appsflyer.internal.bu r0 = com.appsflyer.internal.bu.FAILURE     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            return r0
        L_0x01d9:
            java.lang.String r0 = "CFG: active config is valid, skipping fetch"
            com.appsflyer.AFLogger.AFInAppEventParameterName(r0)     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            com.appsflyer.internal.bu r0 = com.appsflyer.internal.bu.USE_CACHED     // Catch:{ IOException -> 0x0214, all -> 0x01e1 }
            return r0
        L_0x01e1:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "CFG: failed to update remote config: "
            r1.<init>(r2)
            java.lang.String r2 = r0.getMessage()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.appsflyer.AFLogger.valueOf(r1, r0)
            r5 = 0
            r6 = 0
            r7 = 0
            r1 = r16
            r2 = r13
            r3 = r10
            r8 = r0
            r1.AFInAppEventType(r2, r3, r5, r6, r7, r8)
            java.lang.Throwable r1 = r0.getCause()
            boolean r1 = r1 instanceof java.lang.InterruptedException
            if (r1 != 0) goto L_0x020d
            com.appsflyer.internal.bu r0 = com.appsflyer.internal.bu.FAILURE
            return r0
        L_0x020d:
            java.lang.Throwable r0 = r0.getCause()
            java.lang.InterruptedException r0 = (java.lang.InterruptedException) r0
            throw r0
        L_0x0214:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "CFG: failed to fetch remote config: "
            r1.<init>(r2)
            java.lang.String r2 = r0.getMessage()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.appsflyer.AFLogger.valueOf(r1, r0)
            boolean r1 = r0 instanceof com.appsflyer.internal.components.network.http.exceptions.ParsingException
            if (r1 == 0) goto L_0x0237
            r1 = r0
            com.appsflyer.internal.components.network.http.exceptions.ParsingException r1 = (com.appsflyer.internal.components.network.http.exceptions.ParsingException) r1
            com.appsflyer.internal.br r1 = r1.getRawResponse()
            r5 = r1
            goto L_0x0238
        L_0x0237:
            r5 = 0
        L_0x0238:
            r6 = 0
            r7 = 0
            r1 = r16
            r2 = r13
            r3 = r10
            r8 = r0
            r1.AFInAppEventType(r2, r3, r5, r6, r7, r8)
            java.lang.Throwable r1 = r0.getCause()
            boolean r1 = r1 instanceof java.io.InterruptedIOException
            if (r1 != 0) goto L_0x024d
            com.appsflyer.internal.bu r0 = com.appsflyer.internal.bu.FAILURE
            return r0
        L_0x024d:
            java.lang.Throwable r0 = r0.getCause()
            java.io.InterruptedIOException r0 = (java.io.InterruptedIOException) r0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.bs.AFKeystoreWrapper():com.appsflyer.internal.bu");
    }

    public final bo values() throws Exception {
        try {
            bu AFKeystoreWrapper2 = AFKeystoreWrapper();
            this.AFKeystoreWrapper = AFKeystoreWrapper2;
            if (AFKeystoreWrapper2 == bu.FAILURE) {
                return bo.FAILURE;
            }
            return bo.SUCCESS;
        } catch (InterruptedIOException | InterruptedException unused) {
            this.AFKeystoreWrapper = bu.FAILURE;
            return bo.TIMEOUT;
        }
    }
}
