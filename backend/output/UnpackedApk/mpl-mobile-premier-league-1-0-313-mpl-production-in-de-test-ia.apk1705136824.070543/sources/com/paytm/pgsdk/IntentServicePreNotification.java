package com.paytm.pgsdk;

import android.app.IntentService;

public class IntentServicePreNotification extends IntentService {
    public IntentServicePreNotification() {
        super("IntentServicePreNotification");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onHandleIntent(android.content.Intent r6) {
        /*
            r5 = this;
            if (r6 == 0) goto L_0x0055
            android.os.Bundle r6 = r6.getExtras()
            java.lang.String r0 = "url"
            java.lang.String r6 = r6.getString(r0)
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x003e, all -> 0x003c }
            r1.<init>(r6)     // Catch:{ Exception -> 0x003e, all -> 0x003c }
            java.net.URLConnection r6 = r1.openConnection()     // Catch:{ Exception -> 0x003e, all -> 0x003c }
            java.lang.Object r6 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r6)     // Catch:{ Exception -> 0x003e, all -> 0x003c }
            java.net.URLConnection r6 = (java.net.URLConnection) r6     // Catch:{ Exception -> 0x003e, all -> 0x003c }
            java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6     // Catch:{ Exception -> 0x003e, all -> 0x003c }
            java.io.InputStream r0 = r6.getInputStream()     // Catch:{ Exception -> 0x003a }
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x003a }
            r1.<init>(r0)     // Catch:{ Exception -> 0x003a }
            int r0 = r1.read()     // Catch:{ Exception -> 0x003a }
        L_0x002b:
            r2 = -1
            if (r0 == r2) goto L_0x0047
            char r0 = (char) r0     // Catch:{ Exception -> 0x003a }
            int r2 = r1.read()     // Catch:{ Exception -> 0x003a }
            java.io.PrintStream r3 = java.lang.System.out     // Catch:{ Exception -> 0x003a }
            r3.print(r0)     // Catch:{ Exception -> 0x003a }
            r0 = r2
            goto L_0x002b
        L_0x003a:
            r0 = move-exception
            goto L_0x0042
        L_0x003c:
            r6 = move-exception
            goto L_0x004f
        L_0x003e:
            r6 = move-exception
            r4 = r0
            r0 = r6
            r6 = r4
        L_0x0042:
            r0.printStackTrace()     // Catch:{ all -> 0x004b }
            if (r6 == 0) goto L_0x0055
        L_0x0047:
            r6.disconnect()
            goto L_0x0055
        L_0x004b:
            r0 = move-exception
            r4 = r0
            r0 = r6
            r6 = r4
        L_0x004f:
            if (r0 == 0) goto L_0x0054
            r0.disconnect()
        L_0x0054:
            throw r6
        L_0x0055:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.pgsdk.IntentServicePreNotification.onHandleIntent(android.content.Intent):void");
    }
}
