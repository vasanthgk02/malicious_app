package com.appsflyer.internal;

public final class bm {
    public final int AFKeystoreWrapper;

    public bm(int i) {
        this.AFKeystoreWrapper = i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0051  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String AFInAppEventParameterName(java.net.HttpURLConnection r4, boolean r5) throws java.io.IOException {
        /*
            r0 = 0
            if (r5 == 0) goto L_0x0008
            java.io.InputStream r4 = r4.getInputStream()     // Catch:{ all -> 0x0048 }
            goto L_0x000c
        L_0x0008:
            java.io.InputStream r4 = r4.getErrorStream()     // Catch:{ all -> 0x0048 }
        L_0x000c:
            if (r4 != 0) goto L_0x0011
            java.lang.String r4 = ""
            return r4
        L_0x0011:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0048 }
            r5.<init>()     // Catch:{ all -> 0x0048 }
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ all -> 0x0048 }
            r1.<init>(r4)     // Catch:{ all -> 0x0048 }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ all -> 0x0044 }
            r4.<init>(r1)     // Catch:{ all -> 0x0044 }
            r0 = 1
        L_0x0021:
            java.lang.String r2 = r4.readLine()     // Catch:{ all -> 0x003e }
            if (r2 == 0) goto L_0x0033
            if (r0 != 0) goto L_0x002e
            r0 = 10
            r5.append(r0)     // Catch:{ all -> 0x003e }
        L_0x002e:
            r5.append(r2)     // Catch:{ all -> 0x003e }
            r0 = 0
            goto L_0x0021
        L_0x0033:
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x003e }
            r1.close()
            r4.close()
            return r5
        L_0x003e:
            r5 = move-exception
            r0 = r1
            r3 = r5
            r5 = r4
            r4 = r3
            goto L_0x004a
        L_0x0044:
            r4 = move-exception
            r5 = r0
            r0 = r1
            goto L_0x004a
        L_0x0048:
            r4 = move-exception
            r5 = r0
        L_0x004a:
            if (r0 == 0) goto L_0x004f
            r0.close()
        L_0x004f:
            if (r5 == 0) goto L_0x0054
            r5.close()
        L_0x0054:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.bm.AFInAppEventParameterName(java.net.HttpURLConnection, boolean):java.lang.String");
    }

    /* JADX WARNING: type inference failed for: r8v0 */
    /* JADX WARNING: type inference failed for: r8v1, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r8v2 */
    /* JADX WARNING: type inference failed for: r9v7, types: [java.net.HttpURLConnection, java.net.URLConnection] */
    /* JADX WARNING: type inference failed for: r8v3 */
    /* JADX WARNING: type inference failed for: r8v4 */
    /* JADX WARNING: type inference failed for: r8v6, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r13v13, types: [java.io.OutputStream, java.io.BufferedOutputStream] */
    /* JADX WARNING: type inference failed for: r8v7 */
    /* JADX WARNING: type inference failed for: r8v8 */
    /* JADX WARNING: type inference failed for: r8v9 */
    /* JADX WARNING: type inference failed for: r8v10 */
    /* JADX WARNING: type inference failed for: r8v11 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r8v2
      assigns: []
      uses: []
      mth insns count: 185
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x012f A[Catch:{ Exception -> 0x01c2, all -> 0x01c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x021a  */
    /* JADX WARNING: Unknown variable types count: 6 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.appsflyer.internal.br<java.lang.String> AFInAppEventType(com.appsflyer.internal.z r21) throws java.io.IOException {
        /*
            r20 = this;
            r1 = r21
            java.lang.String r2 = "ms"
            java.lang.String r3 = "\n took "
            java.lang.String r4 = "] "
            java.lang.String r5 = "HTTP: ["
            long r6 = java.lang.System.currentTimeMillis()
            r8 = 0
            byte[] r0 = r21.AFKeystoreWrapper()     // Catch:{ Exception -> 0x01d2, all -> 0x01ce }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01d2, all -> 0x01ce }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01d2, all -> 0x01ce }
            r10.<init>()     // Catch:{ Exception -> 0x01d2, all -> 0x01ce }
            java.lang.String r11 = r1.AFKeystoreWrapper     // Catch:{ Exception -> 0x01d2, all -> 0x01ce }
            r10.append(r11)     // Catch:{ Exception -> 0x01d2, all -> 0x01ce }
            java.lang.String r11 = ":"
            r10.append(r11)     // Catch:{ Exception -> 0x01d2, all -> 0x01ce }
            java.lang.String r11 = r1.values     // Catch:{ Exception -> 0x01d2, all -> 0x01ce }
            r10.append(r11)     // Catch:{ Exception -> 0x01d2, all -> 0x01ce }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x01d2, all -> 0x01ce }
            r9.<init>(r10)     // Catch:{ Exception -> 0x01d2, all -> 0x01ce }
            byte[] r10 = r21.AFKeystoreWrapper()     // Catch:{ Exception -> 0x01d2, all -> 0x01ce }
            if (r10 == 0) goto L_0x004d
            boolean r11 = r21.AFInAppEventType()     // Catch:{ Exception -> 0x01d2, all -> 0x01ce }
            if (r11 == 0) goto L_0x003f
            java.lang.String r10 = "<encrypted>"
            goto L_0x0045
        L_0x003f:
            java.lang.String r11 = new java.lang.String     // Catch:{ Exception -> 0x01d2, all -> 0x01ce }
            r11.<init>(r10)     // Catch:{ Exception -> 0x01d2, all -> 0x01ce }
            r10 = r11
        L_0x0045:
            java.lang.String r11 = "\n payload: "
            r9.append(r11)     // Catch:{ Exception -> 0x01d2, all -> 0x01ce }
            r9.append(r10)     // Catch:{ Exception -> 0x01d2, all -> 0x01ce }
        L_0x004d:
            java.util.Map<java.lang.String, java.lang.String> r10 = r1.AFInAppEventType     // Catch:{ Exception -> 0x01d2, all -> 0x01ce }
            java.util.Set r10 = r10.entrySet()     // Catch:{ Exception -> 0x01d2, all -> 0x01ce }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ Exception -> 0x01d2, all -> 0x01ce }
        L_0x0057:
            boolean r11 = r10.hasNext()     // Catch:{ Exception -> 0x01d2, all -> 0x01ce }
            if (r11 == 0) goto L_0x0080
            java.lang.Object r11 = r10.next()     // Catch:{ Exception -> 0x01d2, all -> 0x01ce }
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11     // Catch:{ Exception -> 0x01d2, all -> 0x01ce }
            java.lang.String r12 = "\n "
            r9.append(r12)     // Catch:{ Exception -> 0x01d2, all -> 0x01ce }
            java.lang.Object r12 = r11.getKey()     // Catch:{ Exception -> 0x01d2, all -> 0x01ce }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ Exception -> 0x01d2, all -> 0x01ce }
            r9.append(r12)     // Catch:{ Exception -> 0x01d2, all -> 0x01ce }
            java.lang.String r12 = ": "
            r9.append(r12)     // Catch:{ Exception -> 0x01d2, all -> 0x01ce }
            java.lang.Object r11 = r11.getValue()     // Catch:{ Exception -> 0x01d2, all -> 0x01ce }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ Exception -> 0x01d2, all -> 0x01ce }
            r9.append(r11)     // Catch:{ Exception -> 0x01d2, all -> 0x01ce }
            goto L_0x0057
        L_0x0080:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01d2, all -> 0x01ce }
            r10.<init>(r5)     // Catch:{ Exception -> 0x01d2, all -> 0x01ce }
            int r11 = r21.hashCode()     // Catch:{ Exception -> 0x01d2, all -> 0x01ce }
            r10.append(r11)     // Catch:{ Exception -> 0x01d2, all -> 0x01ce }
            r10.append(r4)     // Catch:{ Exception -> 0x01d2, all -> 0x01ce }
            r10.append(r9)     // Catch:{ Exception -> 0x01d2, all -> 0x01ce }
            java.lang.String r9 = r10.toString()     // Catch:{ Exception -> 0x01d2, all -> 0x01ce }
            com.appsflyer.AFLogger.AFInAppEventParameterName(r9)     // Catch:{ Exception -> 0x01d2, all -> 0x01ce }
            java.net.URL r9 = new java.net.URL     // Catch:{ Exception -> 0x01d2, all -> 0x01ce }
            java.lang.String r10 = r1.values     // Catch:{ Exception -> 0x01d2, all -> 0x01ce }
            r9.<init>(r10)     // Catch:{ Exception -> 0x01d2, all -> 0x01ce }
            java.net.URLConnection r9 = r9.openConnection()     // Catch:{ Exception -> 0x01d2, all -> 0x01ce }
            java.lang.Object r9 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r9)     // Catch:{ Exception -> 0x01d2, all -> 0x01ce }
            java.net.URLConnection r9 = (java.net.URLConnection) r9     // Catch:{ Exception -> 0x01d2, all -> 0x01ce }
            java.net.HttpURLConnection r9 = (java.net.HttpURLConnection) r9     // Catch:{ Exception -> 0x01d2, all -> 0x01ce }
            java.lang.String r10 = r1.AFKeystoreWrapper     // Catch:{ Exception -> 0x01c9, all -> 0x01c4 }
            r9.setRequestMethod(r10)     // Catch:{ Exception -> 0x01c9, all -> 0x01c4 }
            boolean r10 = r21.values()     // Catch:{ Exception -> 0x01c9, all -> 0x01c4 }
            r11 = 0
            if (r10 == 0) goto L_0x00bb
            r9.setUseCaches(r11)     // Catch:{ Exception -> 0x01c9, all -> 0x01c4 }
        L_0x00bb:
            r10 = r20
            int r12 = r10.AFKeystoreWrapper     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            int r13 = r1.valueOf     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            r14 = -1
            if (r13 == r14) goto L_0x00c5
            r12 = r13
        L_0x00c5:
            r9.setConnectTimeout(r12)     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            r9.setReadTimeout(r12)     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            boolean r12 = r21.AFInAppEventType()     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            if (r12 == 0) goto L_0x00d4
            java.lang.String r12 = "application/octet-stream"
            goto L_0x00d6
        L_0x00d4:
            java.lang.String r12 = "application/json"
        L_0x00d6:
            java.lang.String r13 = "Content-Type"
            r9.addRequestProperty(r13, r12)     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            java.util.Map<java.lang.String, java.lang.String> r12 = r1.AFInAppEventType     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            java.util.Set r12 = r12.entrySet()     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            java.util.Iterator r12 = r12.iterator()     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
        L_0x00e5:
            boolean r13 = r12.hasNext()     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            if (r13 == 0) goto L_0x0101
            java.lang.Object r13 = r12.next()     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            java.util.Map$Entry r13 = (java.util.Map.Entry) r13     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            java.lang.Object r14 = r13.getKey()     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            java.lang.Object r13 = r13.getValue()     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            r9.setRequestProperty(r14, r13)     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            goto L_0x00e5
        L_0x0101:
            r12 = 1
            if (r0 == 0) goto L_0x0133
            r9.setDoOutput(r12)     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            java.lang.String r13 = "Content-Length"
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            r14.<init>()     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            int r15 = r0.length     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            r14.append(r15)     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            java.lang.String r14 = r14.toString()     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            r9.setRequestProperty(r13, r14)     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            java.io.BufferedOutputStream r13 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x012c }
            java.io.OutputStream r14 = r9.getOutputStream()     // Catch:{ all -> 0x012c }
            r13.<init>(r14)     // Catch:{ all -> 0x012c }
            r13.write(r0)     // Catch:{ all -> 0x0129 }
            r13.close()     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            goto L_0x0133
        L_0x0129:
            r0 = move-exception
            r8 = r13
            goto L_0x012d
        L_0x012c:
            r0 = move-exception
        L_0x012d:
            if (r8 == 0) goto L_0x0132
            r8.close()     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
        L_0x0132:
            throw r0     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
        L_0x0133:
            int r0 = r9.getResponseCode()     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            int r0 = r0 / 100
            r13 = 2
            if (r0 != r13) goto L_0x013d
            r11 = 1
        L_0x013d:
            boolean r0 = r21.AFInAppEventParameterName()     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            java.lang.String r12 = ""
            if (r0 == 0) goto L_0x014b
            java.lang.String r0 = AFInAppEventParameterName(r9, r11)     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            r15 = r0
            goto L_0x014c
        L_0x014b:
            r15 = r12
        L_0x014c:
            long r12 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            long r12 = r12 - r6
            com.appsflyer.internal.bk r0 = new com.appsflyer.internal.bk     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            r0.<init>(r12)     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            java.lang.String r13 = "response code:"
            r12.<init>(r13)     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            int r13 = r9.getResponseCode()     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            r12.append(r13)     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            java.lang.String r13 = " "
            r12.append(r13)     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            java.lang.String r13 = r9.getResponseMessage()     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            r12.append(r13)     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            java.lang.String r13 = "\n body:"
            r12.append(r13)     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            r12.append(r15)     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            r12.append(r3)     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            long r13 = r0.AFKeystoreWrapper     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            r12.append(r13)     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            r12.append(r2)     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            r13.<init>(r5)     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            int r14 = r21.hashCode()     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            r13.append(r14)     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            r13.append(r4)     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            r13.append(r12)     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            java.lang.String r12 = r13.toString()     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            com.appsflyer.AFLogger.AFInAppEventParameterName(r12)     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            java.util.HashMap r12 = new java.util.HashMap     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            java.util.Map r13 = r9.getHeaderFields()     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            r12.<init>(r13)     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            r12.remove(r8)     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            com.appsflyer.internal.br r8 = new com.appsflyer.internal.br     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            int r16 = r9.getResponseCode()     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            r14 = r8
            r17 = r11
            r18 = r12
            r19 = r0
            r14.<init>(r15, r16, r17, r18, r19)     // Catch:{ Exception -> 0x01c2, all -> 0x01c0 }
            r9.disconnect()
            return r8
        L_0x01c0:
            r0 = move-exception
            goto L_0x01c7
        L_0x01c2:
            r0 = move-exception
            goto L_0x01cc
        L_0x01c4:
            r0 = move-exception
            r10 = r20
        L_0x01c7:
            r8 = r9
            goto L_0x0218
        L_0x01c9:
            r0 = move-exception
            r10 = r20
        L_0x01cc:
            r8 = r9
            goto L_0x01d5
        L_0x01ce:
            r0 = move-exception
            r10 = r20
            goto L_0x0218
        L_0x01d2:
            r0 = move-exception
            r10 = r20
        L_0x01d5:
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0217 }
            long r11 = r11 - r6
            com.appsflyer.internal.bk r6 = new com.appsflyer.internal.bk     // Catch:{ all -> 0x0217 }
            r6.<init>(r11)     // Catch:{ all -> 0x0217 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0217 }
            java.lang.String r9 = "error: "
            r7.<init>(r9)     // Catch:{ all -> 0x0217 }
            r7.append(r0)     // Catch:{ all -> 0x0217 }
            r7.append(r3)     // Catch:{ all -> 0x0217 }
            long r11 = r6.AFKeystoreWrapper     // Catch:{ all -> 0x0217 }
            r7.append(r11)     // Catch:{ all -> 0x0217 }
            r7.append(r2)     // Catch:{ all -> 0x0217 }
            java.lang.String r2 = r7.toString()     // Catch:{ all -> 0x0217 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0217 }
            r3.<init>(r5)     // Catch:{ all -> 0x0217 }
            int r1 = r21.hashCode()     // Catch:{ all -> 0x0217 }
            r3.append(r1)     // Catch:{ all -> 0x0217 }
            r3.append(r4)     // Catch:{ all -> 0x0217 }
            r3.append(r2)     // Catch:{ all -> 0x0217 }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x0217 }
            com.appsflyer.AFLogger.valueOf(r1, r0)     // Catch:{ all -> 0x0217 }
            com.appsflyer.internal.components.network.http.exceptions.HttpException r1 = new com.appsflyer.internal.components.network.http.exceptions.HttpException     // Catch:{ all -> 0x0217 }
            r1.<init>(r0, r6)     // Catch:{ all -> 0x0217 }
            throw r1     // Catch:{ all -> 0x0217 }
        L_0x0217:
            r0 = move-exception
        L_0x0218:
            if (r8 == 0) goto L_0x021d
            r8.disconnect()
        L_0x021d:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.bm.AFInAppEventType(com.appsflyer.internal.z):com.appsflyer.internal.br");
    }
}
