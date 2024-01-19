package com.rnfs;

import android.os.AsyncTask;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.rnfs.DownloadParams.OnDownloadProgress;
import com.rnfs.RNFSManager.AnonymousClass3;
import com.rnfs.RNFSManager.AnonymousClass5;
import java.util.concurrent.atomic.AtomicBoolean;

public class Downloader extends AsyncTask<DownloadParams, long[], DownloadResult> {
    public AtomicBoolean mAbort = new AtomicBoolean(false);
    public DownloadParams mParam;
    public DownloadResult res;

    /* JADX WARNING: type inference failed for: r12v0, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r12v1 */
    /* JADX WARNING: type inference failed for: r4v4, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r12v2 */
    /* JADX WARNING: type inference failed for: r4v7, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r12v4, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r12v5 */
    /* JADX WARNING: type inference failed for: r12v6 */
    /* JADX WARNING: type inference failed for: r12v8 */
    /* JADX WARNING: type inference failed for: r12v9 */
    /* JADX WARNING: type inference failed for: r12v10 */
    /* JADX WARNING: type inference failed for: r12v11 */
    /* JADX WARNING: type inference failed for: r4v9 */
    /* JADX WARNING: type inference failed for: r12v16 */
    /* JADX WARNING: type inference failed for: r12v17 */
    /* JADX WARNING: type inference failed for: r12v18 */
    /* JADX WARNING: type inference failed for: r4v11 */
    /* JADX WARNING: type inference failed for: r12v20 */
    /* JADX WARNING: type inference failed for: r12v21 */
    /* JADX WARNING: type inference failed for: r12v22 */
    /* JADX WARNING: type inference failed for: r12v23 */
    /* JADX WARNING: type inference failed for: r12v26 */
    /* JADX WARNING: type inference failed for: r12v27 */
    /* JADX WARNING: type inference failed for: r5v13, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r12v38 */
    /* JADX WARNING: type inference failed for: r29v0 */
    /* JADX WARNING: type inference failed for: r4v19 */
    /* JADX WARNING: type inference failed for: r4v20 */
    /* JADX WARNING: type inference failed for: r12v42 */
    /* JADX WARNING: type inference failed for: r12v43 */
    /* JADX WARNING: type inference failed for: r12v44 */
    /* JADX WARNING: type inference failed for: r12v45 */
    /* JADX WARNING: type inference failed for: r12v46 */
    /* JADX WARNING: type inference failed for: r12v47 */
    /* JADX WARNING: type inference failed for: r12v48 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r12v9
      assigns: []
      uses: []
      mth insns count: 234
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0214  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0219  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x021e  */
    /* JADX WARNING: Unknown variable types count: 12 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void access$100(com.rnfs.Downloader r30, com.rnfs.DownloadParams r31, com.rnfs.DownloadResult r32) throws java.lang.Exception {
        /*
            r0 = r30
            r1 = r31
            r2 = r32
            r3 = 0
            if (r0 == 0) goto L_0x0222
            java.net.URL r4 = r1.src     // Catch:{ all -> 0x020f }
            java.net.URLConnection r4 = r4.openConnection()     // Catch:{ all -> 0x020f }
            java.lang.Object r4 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r4)     // Catch:{ all -> 0x020f }
            java.net.URLConnection r4 = (java.net.URLConnection) r4     // Catch:{ all -> 0x020f }
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch:{ all -> 0x020f }
            com.facebook.react.bridge.ReadableMap r5 = r1.headers     // Catch:{ all -> 0x020b }
            com.facebook.react.bridge.ReadableMapKeySetIterator r5 = r5.keySetIterator()     // Catch:{ all -> 0x020b }
        L_0x001d:
            boolean r6 = r5.hasNextKey()     // Catch:{ all -> 0x020b }
            if (r6 == 0) goto L_0x0031
            java.lang.String r6 = r5.nextKey()     // Catch:{ all -> 0x020b }
            com.facebook.react.bridge.ReadableMap r7 = r1.headers     // Catch:{ all -> 0x020b }
            java.lang.String r7 = r7.getString(r6)     // Catch:{ all -> 0x020b }
            r4.setRequestProperty(r6, r7)     // Catch:{ all -> 0x020b }
            goto L_0x001d
        L_0x0031:
            int r5 = r1.connectionTimeout     // Catch:{ all -> 0x020b }
            r4.setConnectTimeout(r5)     // Catch:{ all -> 0x020b }
            int r5 = r1.readTimeout     // Catch:{ all -> 0x020b }
            r4.setReadTimeout(r5)     // Catch:{ all -> 0x020b }
            r4.connect()     // Catch:{ all -> 0x020b }
            int r5 = r4.getResponseCode()     // Catch:{ all -> 0x020b }
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x020b }
            r7 = 24
            if (r6 < r7) goto L_0x004d
            long r8 = r4.getContentLengthLong()     // Catch:{ all -> 0x020b }
            goto L_0x0052
        L_0x004d:
            int r6 = r4.getContentLength()     // Catch:{ all -> 0x020b }
            long r8 = (long) r6     // Catch:{ all -> 0x020b }
        L_0x0052:
            r6 = 200(0xc8, float:2.8E-43)
            r11 = 0
            if (r5 == r6) goto L_0x0069
            r12 = 301(0x12d, float:4.22E-43)
            if (r5 == r12) goto L_0x0067
            r12 = 302(0x12e, float:4.23E-43)
            if (r5 == r12) goto L_0x0067
            r12 = 307(0x133, float:4.3E-43)
            if (r5 == r12) goto L_0x0067
            r12 = 308(0x134, float:4.32E-43)
            if (r5 != r12) goto L_0x0069
        L_0x0067:
            r12 = 1
            goto L_0x006a
        L_0x0069:
            r12 = 0
        L_0x006a:
            if (r12 == 0) goto L_0x00ac
            java.lang.String r5 = "Location"
            java.lang.String r5 = r4.getHeaderField(r5)     // Catch:{ all -> 0x020b }
            r4.disconnect()     // Catch:{ all -> 0x020b }
            java.net.URL r8 = new java.net.URL     // Catch:{ all -> 0x020b }
            r8.<init>(r5)     // Catch:{ all -> 0x020b }
            java.net.URLConnection r5 = r8.openConnection()     // Catch:{ all -> 0x020b }
            java.lang.Object r5 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r5)     // Catch:{ all -> 0x020b }
            java.net.URLConnection r5 = (java.net.URLConnection) r5     // Catch:{ all -> 0x020b }
            java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch:{ all -> 0x020b }
            r4 = 5000(0x1388, float:7.006E-42)
            r5.setConnectTimeout(r4)     // Catch:{ all -> 0x00a7 }
            r5.connect()     // Catch:{ all -> 0x00a7 }
            int r4 = r5.getResponseCode()     // Catch:{ all -> 0x00a7 }
            int r8 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x00a7 }
            if (r8 < r7) goto L_0x009b
            long r7 = r5.getContentLengthLong()     // Catch:{ all -> 0x00a7 }
            goto L_0x00a0
        L_0x009b:
            int r7 = r5.getContentLength()     // Catch:{ all -> 0x00a7 }
            long r7 = (long) r7
        L_0x00a0:
            r8 = r7
            r29 = r5
            r5 = r4
            r4 = r29
            goto L_0x00ac
        L_0x00a7:
            r0 = move-exception
            r6 = r3
            r12 = r5
            goto L_0x0212
        L_0x00ac:
            if (r5 < r6) goto L_0x01f3
            r6 = 300(0x12c, float:4.2E-43)
            if (r5 >= r6) goto L_0x01f3
            java.util.Map r6 = r4.getHeaderFields()     // Catch:{ all -> 0x01ef }
            java.util.HashMap r7 = new java.util.HashMap     // Catch:{ all -> 0x01ef }
            r7.<init>()     // Catch:{ all -> 0x01ef }
            java.util.Set r6 = r6.entrySet()     // Catch:{ all -> 0x01ef }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x01ef }
        L_0x00c3:
            boolean r12 = r6.hasNext()     // Catch:{ all -> 0x01ef }
            if (r12 == 0) goto L_0x00e9
            java.lang.Object r12 = r6.next()     // Catch:{ all -> 0x020b }
            java.util.Map$Entry r12 = (java.util.Map.Entry) r12     // Catch:{ all -> 0x020b }
            java.lang.Object r13 = r12.getKey()     // Catch:{ all -> 0x020b }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ all -> 0x020b }
            java.lang.Object r12 = r12.getValue()     // Catch:{ all -> 0x020b }
            java.util.List r12 = (java.util.List) r12     // Catch:{ all -> 0x020b }
            java.lang.Object r12 = r12.get(r11)     // Catch:{ all -> 0x020b }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x020b }
            if (r13 == 0) goto L_0x00c3
            if (r12 == 0) goto L_0x00c3
            r7.put(r13, r12)     // Catch:{ all -> 0x020b }
            goto L_0x00c3
        L_0x00e9:
            com.rnfs.DownloadParams r6 = r0.mParam     // Catch:{ all -> 0x01ef }
            com.rnfs.DownloadParams$OnDownloadBegin r6 = r6.onDownloadBegin     // Catch:{ all -> 0x01ef }
            if (r6 == 0) goto L_0x00f8
            com.rnfs.DownloadParams r6 = r0.mParam     // Catch:{ all -> 0x020b }
            com.rnfs.DownloadParams$OnDownloadBegin r6 = r6.onDownloadBegin     // Catch:{ all -> 0x020b }
            com.rnfs.RNFSManager$4 r6 = (com.rnfs.RNFSManager.AnonymousClass4) r6
            r6.onDownloadBegin(r5, r8, r7)     // Catch:{ all -> 0x020b }
        L_0x00f8:
            java.io.BufferedInputStream r6 = new java.io.BufferedInputStream     // Catch:{ all -> 0x01ef }
            java.io.InputStream r7 = r4.getInputStream()     // Catch:{ all -> 0x01ef }
            r12 = 8192(0x2000, float:1.148E-41)
            r6.<init>(r7, r12)     // Catch:{ all -> 0x01ef }
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ all -> 0x01ed }
            java.io.File r13 = r1.dest     // Catch:{ all -> 0x01ed }
            r7.<init>(r13)     // Catch:{ all -> 0x01ed }
            byte[] r3 = new byte[r12]     // Catch:{ all -> 0x01bf }
            com.rnfs.DownloadParams r12 = r0.mParam     // Catch:{ all -> 0x01bf }
            com.rnfs.DownloadParams$OnDownloadProgress r12 = r12.onDownloadProgress     // Catch:{ all -> 0x01bf }
            if (r12 == 0) goto L_0x0114
            r12 = 1
            goto L_0x0115
        L_0x0114:
            r12 = 0
        L_0x0115:
            r13 = 0
            r17 = r13
            r19 = 0
        L_0x011b:
            int r15 = r6.read(r3)     // Catch:{ all -> 0x01bf }
            r11 = -1
            if (r15 == r11) goto L_0x01e0
            java.util.concurrent.atomic.AtomicBoolean r11 = r0.mAbort     // Catch:{ all -> 0x01bf }
            boolean r11 = r11.get()     // Catch:{ all -> 0x01bf }
            if (r11 != 0) goto L_0x01d7
            long r10 = (long) r15     // Catch:{ all -> 0x01bf }
            long r13 = r13 + r10
            if (r12 == 0) goto L_0x01c2
            int r10 = r1.progressInterval     // Catch:{ all -> 0x01bf }
            if (r10 <= 0) goto L_0x015e
            long r24 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x01bf }
            long r26 = r24 - r17
            int r10 = r1.progressInterval     // Catch:{ all -> 0x01bf }
            r28 = r12
            long r11 = (long) r10     // Catch:{ all -> 0x01bf }
            int r10 = (r26 > r11 ? 1 : (r26 == r11 ? 0 : -1))
            if (r10 <= 0) goto L_0x0154
            r10 = 1
            long[][] r11 = new long[r10][]     // Catch:{ all -> 0x01bf }
            r12 = 2
            long[] r12 = new long[r12]     // Catch:{ all -> 0x01bf }
            r16 = 0
            r12[r16] = r8     // Catch:{ all -> 0x01bf }
            r12[r10] = r13     // Catch:{ all -> 0x01bf }
            r11[r16] = r12     // Catch:{ all -> 0x01bf }
            r0.publishProgress(r11)     // Catch:{ all -> 0x01bf }
            r17 = r24
        L_0x0154:
            r12 = r4
            r24 = r5
            r4 = 0
            r21 = 0
            r23 = 1
            goto L_0x01cc
        L_0x015e:
            r28 = r12
            float r10 = r1.progressDivider     // Catch:{ all -> 0x01bf }
            r11 = 0
            int r10 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
            if (r10 > 0) goto L_0x017e
            r10 = 1
            long[][] r11 = new long[r10][]     // Catch:{ all -> 0x01bf }
            r12 = 2
            long[] r12 = new long[r12]     // Catch:{ all -> 0x01bf }
            r16 = 0
            r12[r16] = r8     // Catch:{ all -> 0x01bf }
            r12[r10] = r13     // Catch:{ all -> 0x01bf }
            r11[r16] = r12     // Catch:{ all -> 0x01bf }
            r0.publishProgress(r11)     // Catch:{ all -> 0x01bf }
            r12 = r4
            r24 = r5
            r21 = 0
            goto L_0x01bc
        L_0x017e:
            double r10 = (double) r13
            r24 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r10 = r10 * r24
            r12 = r4
            r24 = r5
            double r4 = (double) r8
            double r10 = r10 / r4
            long r4 = java.lang.Math.round(r10)     // Catch:{ all -> 0x01ea }
            double r4 = (double) r4     // Catch:{ all -> 0x01ea }
            float r10 = r1.progressDivider     // Catch:{ all -> 0x01ea }
            double r10 = (double) r10     // Catch:{ all -> 0x01ea }
            double r10 = r4 % r10
            r21 = 0
            int r25 = (r10 > r21 ? 1 : (r10 == r21 ? 0 : -1))
            if (r25 != 0) goto L_0x01bc
            int r10 = (r4 > r19 ? 1 : (r4 == r19 ? 0 : -1))
            if (r10 != 0) goto L_0x01a0
            int r10 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
            if (r10 != 0) goto L_0x01bc
        L_0x01a0:
            java.lang.String.valueOf(r4)     // Catch:{ all -> 0x01ea }
            java.lang.String.valueOf(r13)     // Catch:{ all -> 0x01ea }
            r10 = 1
            long[][] r11 = new long[r10][]     // Catch:{ all -> 0x01ea }
            r10 = 2
            long[] r10 = new long[r10]     // Catch:{ all -> 0x01ea }
            r16 = 0
            r10[r16] = r8     // Catch:{ all -> 0x01ea }
            r23 = 1
            r10[r23] = r13     // Catch:{ all -> 0x01ea }
            r11[r16] = r10     // Catch:{ all -> 0x01ea }
            r0.publishProgress(r11)     // Catch:{ all -> 0x01ea }
            r19 = r4
            goto L_0x01cb
        L_0x01bc:
            r23 = 1
            goto L_0x01cb
        L_0x01bf:
            r0 = move-exception
            r12 = r4
            goto L_0x01eb
        L_0x01c2:
            r24 = r5
            r28 = r12
            r21 = 0
            r23 = 1
            r12 = r4
        L_0x01cb:
            r4 = 0
        L_0x01cc:
            r7.write(r3, r4, r15)     // Catch:{ all -> 0x01ea }
            r4 = r12
            r5 = r24
            r12 = r28
            r11 = 0
            goto L_0x011b
        L_0x01d7:
            r12 = r4
            java.lang.Exception r0 = new java.lang.Exception     // Catch:{ all -> 0x01ea }
            java.lang.String r1 = "Download has been aborted"
            r0.<init>(r1)     // Catch:{ all -> 0x01ea }
            throw r0     // Catch:{ all -> 0x01ea }
        L_0x01e0:
            r12 = r4
            r24 = r5
            r7.flush()     // Catch:{ all -> 0x01ea }
            r2.bytesWritten = r13     // Catch:{ all -> 0x01ea }
            r3 = r7
            goto L_0x01f7
        L_0x01ea:
            r0 = move-exception
        L_0x01eb:
            r3 = r7
            goto L_0x0212
        L_0x01ed:
            r0 = move-exception
            goto L_0x020d
        L_0x01ef:
            r0 = move-exception
            r12 = r4
            r6 = r3
            goto L_0x0212
        L_0x01f3:
            r12 = r4
            r24 = r5
            r6 = r3
        L_0x01f7:
            r4 = r24
            r2.statusCode = r4     // Catch:{ all -> 0x0209 }
            if (r3 == 0) goto L_0x0200
            r3.close()
        L_0x0200:
            if (r6 == 0) goto L_0x0205
            r6.close()
        L_0x0205:
            r12.disconnect()
            return
        L_0x0209:
            r0 = move-exception
            goto L_0x0212
        L_0x020b:
            r0 = move-exception
            r6 = r3
        L_0x020d:
            r12 = r4
            goto L_0x0212
        L_0x020f:
            r0 = move-exception
            r6 = r3
            r12 = r6
        L_0x0212:
            if (r3 == 0) goto L_0x0217
            r3.close()
        L_0x0217:
            if (r6 == 0) goto L_0x021c
            r6.close()
        L_0x021c:
            if (r12 == 0) goto L_0x0221
            r12.disconnect()
        L_0x0221:
            throw r0
        L_0x0222:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rnfs.Downloader.access$100(com.rnfs.Downloader, com.rnfs.DownloadParams, com.rnfs.DownloadResult):void");
    }

    public Object doInBackground(Object[] objArr) {
        this.mParam = ((DownloadParams[]) objArr)[0];
        this.res = new DownloadResult();
        new Thread(new Runnable() {
            public void run() {
                try {
                    Downloader.access$100(Downloader.this, Downloader.this.mParam, Downloader.this.res);
                    ((AnonymousClass3) Downloader.this.mParam.onTaskCompleted).onTaskCompleted(Downloader.this.res);
                } catch (Exception e2) {
                    Downloader downloader = Downloader.this;
                    DownloadResult downloadResult = downloader.res;
                    downloadResult.exception = e2;
                    ((AnonymousClass3) downloader.mParam.onTaskCompleted).onTaskCompleted(downloadResult);
                }
            }
        }).start();
        return this.res;
    }

    public void onProgressUpdate(Object[] objArr) {
        long[][] jArr = (long[][]) objArr;
        super.onProgressUpdate(jArr);
        OnDownloadProgress onDownloadProgress = this.mParam.onDownloadProgress;
        if (onDownloadProgress != null) {
            long j = jArr[0][0];
            long j2 = jArr[0][1];
            AnonymousClass5 r0 = (AnonymousClass5) onDownloadProgress;
            WritableMap createMap = Arguments.createMap();
            createMap.putInt("jobId", r3);
            createMap.putDouble("contentLength", (double) j);
            createMap.putDouble("bytesWritten", (double) j2);
            RNFSManager rNFSManager = RNFSManager.this;
            rNFSManager.sendEvent(rNFSManager.getReactApplicationContext(), "DownloadProgress", createMap);
        }
    }
}
