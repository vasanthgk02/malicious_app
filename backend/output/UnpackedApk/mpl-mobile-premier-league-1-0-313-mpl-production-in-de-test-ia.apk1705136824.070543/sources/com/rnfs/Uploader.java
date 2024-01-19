package com.rnfs;

import android.os.AsyncTask;
import com.rnfs.RNFSManager.AnonymousClass6;
import java.util.concurrent.atomic.AtomicBoolean;

public class Uploader extends AsyncTask<UploadParams, int[], UploadResult> {
    public AtomicBoolean mAbort = new AtomicBoolean(false);
    public UploadParams mParams;
    public UploadResult res;

    /* JADX WARNING: Can't wrap try/catch for region: R(5:51|52|(1:54)(1:55)|(1:57)|58) */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0308, code lost:
        r17 = r1;
        r19 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x030c, code lost:
        if (r6 != false) goto L_0x0314;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x030e, code lost:
        r1 = r16;
        r2.writeBytes(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0314, code lost:
        r1 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0316, code lost:
        r12 = r12 + 1;
        r8.close();
        r15 = r1;
        r9 = r13;
        r1 = r17;
        r8 = r18;
        r4 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        r20 = r7.getString(r4);
        r22 = r7.getString(r3);
        r12 = android.webkit.MimeTypeMap.getFileExtensionFromUrl(r7.getString("filepath"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0113, code lost:
        if (r12 != null) goto L_0x0115;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0115, code lost:
        r24 = r3;
        r3 = android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(r12.toLowerCase());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0124, code lost:
        r24 = r3;
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0127, code lost:
        if (r3 == null) goto L_0x0129;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0129, code lost:
        r3 = "*/*";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x012b, code lost:
        r12 = r3;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x0103 */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x03cf  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x03d4  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x03d9  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x03de  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void access$200(com.rnfs.Uploader r28, com.rnfs.UploadParams r29, com.rnfs.UploadResult r30) throws java.lang.Exception {
        /*
            r0 = r28
            r1 = r29
            if (r0 == 0) goto L_0x03e2
            java.lang.String r3 = "filename"
            java.lang.String r4 = "name"
            java.util.ArrayList<com.facebook.react.bridge.ReadableMap> r5 = r1.files     // Catch:{ all -> 0x03c8 }
            java.lang.Object[] r5 = r5.toArray()     // Catch:{ all -> 0x03c8 }
            boolean r6 = r1.binaryStreamOnly     // Catch:{ all -> 0x03c8 }
            java.net.URL r7 = r1.src     // Catch:{ all -> 0x03c8 }
            java.net.URLConnection r7 = r7.openConnection()     // Catch:{ all -> 0x03c8 }
            java.lang.Object r7 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r7)     // Catch:{ all -> 0x03c8 }
            java.net.URLConnection r7 = (java.net.URLConnection) r7     // Catch:{ all -> 0x03c8 }
            java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch:{ all -> 0x03c8 }
            r8 = 1
            r7.setDoOutput(r8)     // Catch:{ all -> 0x03bc }
            com.facebook.react.bridge.ReadableMap r9 = r1.headers     // Catch:{ all -> 0x03bc }
            com.facebook.react.bridge.ReadableMapKeySetIterator r9 = r9.keySetIterator()     // Catch:{ all -> 0x03bc }
            java.lang.String r10 = r1.method     // Catch:{ all -> 0x03bc }
            r7.setRequestMethod(r10)     // Catch:{ all -> 0x03bc }
            if (r6 != 0) goto L_0x003d
            java.lang.String r10 = "Content-Type"
            java.lang.String r11 = "multipart/form-data;boundary=*****"
            r7.setRequestProperty(r10, r11)     // Catch:{ all -> 0x0039 }
            goto L_0x003d
        L_0x0039:
            r0 = move-exception
            r8 = r7
            goto L_0x0234
        L_0x003d:
            boolean r10 = r9.hasNextKey()     // Catch:{ all -> 0x03bc }
            if (r10 == 0) goto L_0x0051
            java.lang.String r10 = r9.nextKey()     // Catch:{ all -> 0x0039 }
            com.facebook.react.bridge.ReadableMap r11 = r1.headers     // Catch:{ all -> 0x0039 }
            java.lang.String r11 = r11.getString(r10)     // Catch:{ all -> 0x0039 }
            r7.setRequestProperty(r10, r11)     // Catch:{ all -> 0x0039 }
            goto L_0x003d
        L_0x0051:
            com.facebook.react.bridge.ReadableMap r9 = r1.fields     // Catch:{ all -> 0x03bc }
            com.facebook.react.bridge.ReadableMapKeySetIterator r9 = r9.keySetIterator()     // Catch:{ all -> 0x03bc }
            java.lang.String r10 = ""
            r11 = r10
        L_0x005a:
            boolean r12 = r9.hasNextKey()     // Catch:{ all -> 0x03bc }
            java.lang.String r13 = "\""
            java.lang.String r14 = "Content-Disposition: form-data; name=\""
            java.lang.String r15 = "\r\n"
            java.lang.String r2 = "--"
            java.lang.String r8 = "*****"
            if (r12 == 0) goto L_0x00ad
            java.lang.String r12 = r9.nextKey()     // Catch:{ all -> 0x00a8 }
            r17 = r9
            com.facebook.react.bridge.ReadableMap r9 = r1.fields     // Catch:{ all -> 0x00a8 }
            java.lang.String r9 = r9.getString(r12)     // Catch:{ all -> 0x00a8 }
            r18 = r7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0232 }
            r7.<init>()     // Catch:{ all -> 0x0232 }
            r7.append(r11)     // Catch:{ all -> 0x0232 }
            r7.append(r2)     // Catch:{ all -> 0x0232 }
            r7.append(r8)     // Catch:{ all -> 0x0232 }
            r7.append(r15)     // Catch:{ all -> 0x0232 }
            r7.append(r14)     // Catch:{ all -> 0x0232 }
            r7.append(r12)     // Catch:{ all -> 0x0232 }
            r7.append(r13)     // Catch:{ all -> 0x0232 }
            r7.append(r15)     // Catch:{ all -> 0x0232 }
            r7.append(r15)     // Catch:{ all -> 0x0232 }
            r7.append(r9)     // Catch:{ all -> 0x0232 }
            r7.append(r15)     // Catch:{ all -> 0x0232 }
            java.lang.String r11 = r7.toString()     // Catch:{ all -> 0x0232 }
            r9 = r17
            r7 = r18
            r8 = 1
            goto L_0x005a
        L_0x00a8:
            r0 = move-exception
            r18 = r7
            goto L_0x0204
        L_0x00ad:
            r18 = r7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x03ba }
            r7.<init>()     // Catch:{ all -> 0x03ba }
            r7.append(r10)     // Catch:{ all -> 0x03ba }
            r7.append(r11)     // Catch:{ all -> 0x03ba }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x03ba }
            int r9 = r5.length     // Catch:{ all -> 0x03ba }
            java.lang.String[] r9 = new java.lang.String[r9]     // Catch:{ all -> 0x03ba }
            java.util.ArrayList<com.facebook.react.bridge.ReadableMap> r12 = r1.files     // Catch:{ all -> 0x03ba }
            java.util.Iterator r12 = r12.iterator()     // Catch:{ all -> 0x03ba }
            r19 = 0
            r17 = r7
            r7 = r17
            r1 = 0
            r17 = r11
            r26 = r19
            r19 = r10
            r10 = r26
        L_0x00d6:
            boolean r20 = r12.hasNext()     // Catch:{ all -> 0x03ba }
            java.lang.String r0 = "filepath"
            r21 = r7
            java.lang.String r7 = "\r\n--*****--\r\n"
            if (r20 == 0) goto L_0x01d6
            java.lang.Object r7 = r12.next()     // Catch:{ all -> 0x03ba }
            com.facebook.react.bridge.ReadableMap r7 = (com.facebook.react.bridge.ReadableMap) r7     // Catch:{ all -> 0x03ba }
            java.lang.String r20 = r7.getString(r4)     // Catch:{ NoSuchKeyException -> 0x0101 }
            java.lang.String r22 = r7.getString(r3)     // Catch:{ NoSuchKeyException -> 0x0101 }
            r23 = r12
            java.lang.String r12 = "filetype"
            java.lang.String r12 = r7.getString(r12)     // Catch:{ NoSuchKeyException -> 0x0103 }
            r24 = r3
        L_0x00fa:
            r3 = r20
            r20 = r4
            r4 = r22
            goto L_0x012d
        L_0x0101:
            r23 = r12
        L_0x0103:
            java.lang.String r20 = r7.getString(r4)     // Catch:{ all -> 0x03ba }
            java.lang.String r22 = r7.getString(r3)     // Catch:{ all -> 0x03ba }
            java.lang.String r12 = r7.getString(r0)     // Catch:{ all -> 0x03ba }
            java.lang.String r12 = android.webkit.MimeTypeMap.getFileExtensionFromUrl(r12)     // Catch:{ all -> 0x03ba }
            if (r12 == 0) goto L_0x0124
            r24 = r3
            android.webkit.MimeTypeMap r3 = android.webkit.MimeTypeMap.getSingleton()     // Catch:{ all -> 0x03ba }
            java.lang.String r12 = r12.toLowerCase()     // Catch:{ all -> 0x03ba }
            java.lang.String r3 = r3.getMimeTypeFromExtension(r12)     // Catch:{ all -> 0x03ba }
            goto L_0x0127
        L_0x0124:
            r24 = r3
            r3 = 0
        L_0x0127:
            if (r3 != 0) goto L_0x012b
            java.lang.String r3 = "*/*"
        L_0x012b:
            r12 = r3
            goto L_0x00fa
        L_0x012d:
            r22 = r9
            java.io.File r9 = new java.io.File     // Catch:{ all -> 0x03ba }
            java.lang.String r0 = r7.getString(r0)     // Catch:{ all -> 0x03ba }
            r9.<init>(r0)     // Catch:{ all -> 0x03ba }
            r25 = r1
            long r0 = r9.length()     // Catch:{ all -> 0x03ba }
            long r10 = r10 + r0
            if (r6 != 0) goto L_0x01c1
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x03ba }
            r7.<init>()     // Catch:{ all -> 0x03ba }
            r7.append(r2)     // Catch:{ all -> 0x03ba }
            r7.append(r8)     // Catch:{ all -> 0x03ba }
            r7.append(r15)     // Catch:{ all -> 0x03ba }
            r7.append(r14)     // Catch:{ all -> 0x03ba }
            r7.append(r3)     // Catch:{ all -> 0x03ba }
            java.lang.String r3 = "\"; filename=\""
            r7.append(r3)     // Catch:{ all -> 0x03ba }
            r7.append(r4)     // Catch:{ all -> 0x03ba }
            r7.append(r13)     // Catch:{ all -> 0x03ba }
            r7.append(r15)     // Catch:{ all -> 0x03ba }
            java.lang.String r3 = "Content-Type: "
            r7.append(r3)     // Catch:{ all -> 0x03ba }
            r7.append(r12)     // Catch:{ all -> 0x03ba }
            r7.append(r15)     // Catch:{ all -> 0x03ba }
            java.lang.String r3 = r7.toString()     // Catch:{ all -> 0x03ba }
            int r4 = r5.length     // Catch:{ all -> 0x03ba }
            r7 = 1
            int r4 = r4 - r7
            r9 = r25
            if (r4 != r9) goto L_0x017f
            r4 = 13
            r12 = r8
            long r7 = (long) r4     // Catch:{ all -> 0x03ba }
            long r10 = r10 + r7
            goto L_0x0180
        L_0x017f:
            r12 = r8
        L_0x0180:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x03ba }
            r4.<init>()     // Catch:{ all -> 0x03ba }
            java.lang.String r7 = "Content-length: "
            r4.append(r7)     // Catch:{ all -> 0x03ba }
            r4.append(r0)     // Catch:{ all -> 0x03ba }
            r4.append(r15)     // Catch:{ all -> 0x03ba }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x03ba }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x03ba }
            r1.<init>()     // Catch:{ all -> 0x03ba }
            r1.append(r3)     // Catch:{ all -> 0x03ba }
            r1.append(r0)     // Catch:{ all -> 0x03ba }
            r1.append(r15)     // Catch:{ all -> 0x03ba }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x03ba }
            r22[r9] = r1     // Catch:{ all -> 0x03ba }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x03ba }
            r1.<init>()     // Catch:{ all -> 0x03ba }
            r4 = r21
            r1.append(r4)     // Catch:{ all -> 0x03ba }
            r1.append(r3)     // Catch:{ all -> 0x03ba }
            r1.append(r0)     // Catch:{ all -> 0x03ba }
            r1.append(r15)     // Catch:{ all -> 0x03ba }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x03ba }
            r7 = r0
            goto L_0x01c7
        L_0x01c1:
            r12 = r8
            r4 = r21
            r9 = r25
            r7 = r4
        L_0x01c7:
            int r1 = r9 + 1
            r0 = r28
            r8 = r12
            r4 = r20
            r9 = r22
            r12 = r23
            r3 = r24
            goto L_0x00d6
        L_0x01d6:
            r22 = r9
            r4 = r21
            r1 = r0
            r0 = r28
            com.rnfs.UploadParams r2 = r0.mParams     // Catch:{ all -> 0x03ba }
            com.rnfs.UploadParams$onUploadBegin r2 = r2.onUploadBegin     // Catch:{ all -> 0x03ba }
            java.lang.String r3 = "jobId"
            if (r2 == 0) goto L_0x0207
            com.rnfs.UploadParams r2 = r0.mParams     // Catch:{ all -> 0x0232 }
            com.rnfs.UploadParams$onUploadBegin r2 = r2.onUploadBegin     // Catch:{ all -> 0x0232 }
            com.rnfs.RNFSManager$7 r2 = (com.rnfs.RNFSManager.AnonymousClass7) r2     // Catch:{ all -> 0x0232 }
            if (r2 == 0) goto L_0x0202
            com.facebook.react.bridge.WritableMap r8 = com.facebook.react.bridge.Arguments.createMap()     // Catch:{ all -> 0x0232 }
            int r9 = r6     // Catch:{ all -> 0x0232 }
            r8.putInt(r3, r9)     // Catch:{ all -> 0x0232 }
            com.rnfs.RNFSManager r2 = com.rnfs.RNFSManager.this     // Catch:{ all -> 0x0232 }
            com.facebook.react.bridge.ReactApplicationContext r9 = r2.getReactApplicationContext()     // Catch:{ all -> 0x0232 }
            java.lang.String r12 = "UploadBegin"
            r2.sendEvent(r9, r12, r8)     // Catch:{ all -> 0x0232 }
            goto L_0x0207
        L_0x0202:
            r1 = 0
            throw r1     // Catch:{ all -> 0x0232 }
        L_0x0204:
            r8 = r18
            goto L_0x0234
        L_0x0207:
            if (r6 != 0) goto L_0x0238
            int r2 = r4.length()     // Catch:{ all -> 0x0232 }
            int r4 = r5.length     // Catch:{ all -> 0x0232 }
            int r4 = r4 * 2
            int r4 = r4 + r2
            long r4 = (long) r4     // Catch:{ all -> 0x0232 }
            long r4 = r4 + r10
            java.lang.String r2 = "Content-length"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0232 }
            r8.<init>()     // Catch:{ all -> 0x0232 }
            r9 = r19
            r8.append(r9)     // Catch:{ all -> 0x0232 }
            int r5 = (int) r4     // Catch:{ all -> 0x0232 }
            r8.append(r5)     // Catch:{ all -> 0x0232 }
            java.lang.String r4 = r8.toString()     // Catch:{ all -> 0x0232 }
            r8 = r18
            r8.setRequestProperty(r2, r4)     // Catch:{ all -> 0x0230 }
            r8.setFixedLengthStreamingMode(r5)     // Catch:{ all -> 0x0230 }
            goto L_0x023a
        L_0x0230:
            r0 = move-exception
            goto L_0x0234
        L_0x0232:
            r0 = move-exception
            goto L_0x0204
        L_0x0234:
            r2 = r8
            r1 = 0
            goto L_0x03cb
        L_0x0238:
            r8 = r18
        L_0x023a:
            r8.connect()     // Catch:{ all -> 0x03b6 }
            java.io.DataOutputStream r2 = new java.io.DataOutputStream     // Catch:{ all -> 0x03b6 }
            java.io.OutputStream r4 = r8.getOutputStream()     // Catch:{ all -> 0x03b6 }
            r2.<init>(r4)     // Catch:{ all -> 0x03b6 }
            if (r6 != 0) goto L_0x0250
            r4 = r17
            r2.writeBytes(r4)     // Catch:{ all -> 0x024e }
            goto L_0x0250
        L_0x024e:
            r0 = move-exception
            goto L_0x0272
        L_0x0250:
            java.lang.Runtime r4 = java.lang.Runtime.getRuntime()     // Catch:{ all -> 0x03b1 }
            r5 = r29
            java.util.ArrayList<com.facebook.react.bridge.ReadableMap> r5 = r5.files     // Catch:{ all -> 0x03b1 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x03b1 }
            r9 = 0
            r12 = 0
        L_0x025e:
            boolean r13 = r5.hasNext()     // Catch:{ all -> 0x03b1 }
            if (r13 == 0) goto L_0x0325
            java.lang.Object r13 = r5.next()     // Catch:{ all -> 0x03b1 }
            com.facebook.react.bridge.ReadableMap r13 = (com.facebook.react.bridge.ReadableMap) r13     // Catch:{ all -> 0x03b1 }
            if (r6 != 0) goto L_0x0275
            r14 = r22[r12]     // Catch:{ all -> 0x024e }
            r2.writeBytes(r14)     // Catch:{ all -> 0x024e }
            goto L_0x0275
        L_0x0272:
            r18 = r8
            goto L_0x02b8
        L_0x0275:
            java.io.File r14 = new java.io.File     // Catch:{ all -> 0x03b1 }
            java.lang.String r13 = r13.getString(r1)     // Catch:{ all -> 0x03b1 }
            r14.<init>(r13)     // Catch:{ all -> 0x03b1 }
            r18 = r8
            r29 = r9
            long r8 = r14.length()     // Catch:{ all -> 0x0305 }
            int r9 = (int) r8     // Catch:{ all -> 0x0305 }
            java.io.BufferedInputStream r8 = new java.io.BufferedInputStream     // Catch:{ all -> 0x0305 }
            java.io.FileInputStream r13 = new java.io.FileInputStream     // Catch:{ all -> 0x0305 }
            r13.<init>(r14)     // Catch:{ all -> 0x0305 }
            r8.<init>(r13)     // Catch:{ all -> 0x0305 }
            float r9 = (float) r9     // Catch:{ all -> 0x0305 }
            r13 = 1120403456(0x42c80000, float:100.0)
            float r9 = r9 / r13
            double r13 = (double) r9     // Catch:{ all -> 0x0305 }
            double r13 = java.lang.Math.ceil(r13)     // Catch:{ all -> 0x0305 }
            int r9 = (int) r13     // Catch:{ all -> 0x0305 }
            float r13 = (float) r9     // Catch:{ all -> 0x0305 }
            r16 = r15
            long r14 = r4.freeMemory()     // Catch:{ all -> 0x0305 }
            float r14 = (float) r14
            r15 = 1092616192(0x41200000, float:10.0)
            float r14 = r14 / r15
            int r13 = (r13 > r14 ? 1 : (r13 == r14 ? 0 : -1))
            if (r13 <= 0) goto L_0x02bd
            long r13 = r4.freeMemory()     // Catch:{ all -> 0x02b7 }
            float r9 = (float) r13     // Catch:{ all -> 0x02b7 }
            float r9 = r9 / r15
            double r13 = (double) r9     // Catch:{ all -> 0x02b7 }
            double r13 = java.lang.Math.ceil(r13)     // Catch:{ all -> 0x02b7 }
            int r9 = (int) r13
            goto L_0x02bd
        L_0x02b7:
            r0 = move-exception
        L_0x02b8:
            r1 = r2
            r2 = r18
            goto L_0x03cb
        L_0x02bd:
            byte[] r9 = new byte[r9]     // Catch:{ all -> 0x0305 }
            r13 = r29
        L_0x02c1:
            int r14 = r8.read(r9)     // Catch:{ all -> 0x0305 }
            r15 = -1
            if (r14 == r15) goto L_0x0308
            r15 = 0
            r2.write(r9, r15, r14)     // Catch:{ all -> 0x0305 }
            com.rnfs.UploadParams r15 = r0.mParams     // Catch:{ all -> 0x0305 }
            com.rnfs.UploadParams$onUploadProgress r15 = r15.onUploadProgress     // Catch:{ all -> 0x0305 }
            if (r15 == 0) goto L_0x02c1
            int r13 = r13 + r14
            com.rnfs.UploadParams r14 = r0.mParams     // Catch:{ all -> 0x0305 }
            com.rnfs.UploadParams$onUploadProgress r14 = r14.onUploadProgress     // Catch:{ all -> 0x0305 }
            int r15 = (int) r10     // Catch:{ all -> 0x0305 }
            com.rnfs.RNFSManager$8 r14 = (com.rnfs.RNFSManager.AnonymousClass8) r14     // Catch:{ all -> 0x0305 }
            if (r14 == 0) goto L_0x0303
            r17 = r1
            com.facebook.react.bridge.WritableMap r1 = com.facebook.react.bridge.Arguments.createMap()     // Catch:{ all -> 0x0305 }
            r19 = r4
            int r4 = r6     // Catch:{ all -> 0x0305 }
            r1.putInt(r3, r4)     // Catch:{ all -> 0x0305 }
            java.lang.String r4 = "totalBytesExpectedToSend"
            r1.putInt(r4, r15)     // Catch:{ all -> 0x0305 }
            java.lang.String r4 = "totalBytesSent"
            r1.putInt(r4, r13)     // Catch:{ all -> 0x0305 }
            com.rnfs.RNFSManager r4 = com.rnfs.RNFSManager.this     // Catch:{ all -> 0x0305 }
            com.facebook.react.bridge.ReactApplicationContext r14 = r4.getReactApplicationContext()     // Catch:{ all -> 0x0305 }
            java.lang.String r15 = "UploadProgress"
            r4.sendEvent(r14, r15, r1)     // Catch:{ all -> 0x0305 }
            r1 = r17
            r4 = r19
            goto L_0x02c1
        L_0x0303:
            r1 = 0
            throw r1     // Catch:{ all -> 0x0305 }
        L_0x0305:
            r0 = move-exception
            goto L_0x03b4
        L_0x0308:
            r17 = r1
            r19 = r4
            if (r6 != 0) goto L_0x0314
            r1 = r16
            r2.writeBytes(r1)     // Catch:{ all -> 0x0305 }
            goto L_0x0316
        L_0x0314:
            r1 = r16
        L_0x0316:
            int r12 = r12 + 1
            r8.close()     // Catch:{ all -> 0x0305 }
            r15 = r1
            r9 = r13
            r1 = r17
            r8 = r18
            r4 = r19
            goto L_0x025e
        L_0x0325:
            r18 = r8
            if (r6 != 0) goto L_0x032c
            r2.writeBytes(r7)     // Catch:{ all -> 0x0305 }
        L_0x032c:
            r2.flush()     // Catch:{ all -> 0x0305 }
            r2.close()     // Catch:{ all -> 0x0305 }
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch:{ all -> 0x0305 }
            java.io.InputStream r3 = r18.getInputStream()     // Catch:{ all -> 0x0305 }
            r1.<init>(r3)     // Catch:{ all -> 0x0305 }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ all -> 0x03af }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ all -> 0x03af }
            r4.<init>(r1)     // Catch:{ all -> 0x03af }
            r3.<init>(r4)     // Catch:{ all -> 0x03af }
            com.facebook.react.bridge.WritableMap r4 = com.facebook.react.bridge.Arguments.createMap()     // Catch:{ all -> 0x03ad }
            java.util.Map r5 = r18.getHeaderFields()     // Catch:{ all -> 0x03ad }
            java.util.Set r5 = r5.entrySet()     // Catch:{ all -> 0x03ad }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x03ad }
        L_0x0355:
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x03ad }
            if (r6 == 0) goto L_0x0378
            java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x03ad }
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6     // Catch:{ all -> 0x03ad }
            java.lang.Object r7 = r6.getKey()     // Catch:{ all -> 0x03ad }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x03ad }
            java.lang.Object r6 = r6.getValue()     // Catch:{ all -> 0x03ad }
            java.util.List r6 = (java.util.List) r6     // Catch:{ all -> 0x03ad }
            r8 = 0
            java.lang.Object r6 = r6.get(r8)     // Catch:{ all -> 0x03ad }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x03ad }
            r4.putString(r7, r6)     // Catch:{ all -> 0x03ad }
            goto L_0x0355
        L_0x0378:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x03ad }
            r5.<init>()     // Catch:{ all -> 0x03ad }
        L_0x037d:
            java.lang.String r6 = r3.readLine()     // Catch:{ all -> 0x03ad }
            if (r6 == 0) goto L_0x038c
            r5.append(r6)     // Catch:{ all -> 0x03ad }
            java.lang.String r6 = "\n"
            r5.append(r6)     // Catch:{ all -> 0x03ad }
            goto L_0x037d
        L_0x038c:
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x03ad }
            int r6 = r18.getResponseCode()     // Catch:{ all -> 0x03ad }
            com.rnfs.UploadResult r7 = r0.res     // Catch:{ all -> 0x03ad }
            r7.headers = r4     // Catch:{ all -> 0x03ad }
            com.rnfs.UploadResult r4 = r0.res     // Catch:{ all -> 0x03ad }
            r4.body = r5     // Catch:{ all -> 0x03ad }
            com.rnfs.UploadResult r0 = r0.res     // Catch:{ all -> 0x03ad }
            r0.statusCode = r6     // Catch:{ all -> 0x03ad }
            r18.disconnect()
            r2.close()
            r1.close()
            r3.close()
            return
        L_0x03ad:
            r0 = move-exception
            goto L_0x03c2
        L_0x03af:
            r0 = move-exception
            goto L_0x03c1
        L_0x03b1:
            r0 = move-exception
            r18 = r8
        L_0x03b4:
            r1 = 0
            goto L_0x03c1
        L_0x03b6:
            r0 = move-exception
            r18 = r8
            goto L_0x03bf
        L_0x03ba:
            r0 = move-exception
            goto L_0x03bf
        L_0x03bc:
            r0 = move-exception
            r18 = r7
        L_0x03bf:
            r1 = 0
            r2 = 0
        L_0x03c1:
            r3 = 0
        L_0x03c2:
            r4 = r3
            r3 = r1
            r1 = r2
            r2 = r18
            goto L_0x03cd
        L_0x03c8:
            r0 = move-exception
            r1 = 0
            r2 = 0
        L_0x03cb:
            r3 = 0
            r4 = 0
        L_0x03cd:
            if (r2 == 0) goto L_0x03d2
            r2.disconnect()
        L_0x03d2:
            if (r1 == 0) goto L_0x03d7
            r1.close()
        L_0x03d7:
            if (r3 == 0) goto L_0x03dc
            r3.close()
        L_0x03dc:
            if (r4 == 0) goto L_0x03e1
            r4.close()
        L_0x03e1:
            throw r0
        L_0x03e2:
            r1 = 0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rnfs.Uploader.access$200(com.rnfs.Uploader, com.rnfs.UploadParams, com.rnfs.UploadResult):void");
    }

    public Object doInBackground(Object[] objArr) {
        this.mParams = ((UploadParams[]) objArr)[0];
        this.res = new UploadResult();
        new Thread(new Runnable() {
            public void run() {
                try {
                    Uploader.access$200(Uploader.this, Uploader.this.mParams, Uploader.this.res);
                    ((AnonymousClass6) Uploader.this.mParams.onUploadComplete).onUploadComplete(Uploader.this.res);
                } catch (Exception e2) {
                    Uploader uploader = Uploader.this;
                    UploadResult uploadResult = uploader.res;
                    uploadResult.exception = e2;
                    ((AnonymousClass6) uploader.mParams.onUploadComplete).onUploadComplete(uploadResult);
                }
            }
        }).start();
        return this.res;
    }
}
