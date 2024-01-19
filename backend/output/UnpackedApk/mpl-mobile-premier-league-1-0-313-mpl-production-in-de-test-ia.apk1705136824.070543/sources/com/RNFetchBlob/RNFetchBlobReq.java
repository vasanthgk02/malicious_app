package com.RNFetchBlob;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import co.hyperverge.hypersnapsdk.c.k;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.mpl.androidapp.utils.Constant;
import java.util.ArrayList;
import java.util.HashMap;
import okhttp3.Call;
import okhttp3.ConnectionPool;
import okhttp3.Headers;
import okhttp3.OkHttpClient;

public class RNFetchBlobReq extends BroadcastReceiver implements Runnable {
    public static HashMap<String, Long> androidDownloadManagerTaskTable = new HashMap<>();
    public static ConnectionPool pool = new ConnectionPool();
    public static HashMap<String, RNFetchBlobProgressConfig> progressReport = new HashMap<>();
    public static HashMap<String, Call> taskTable = new HashMap<>();
    public static HashMap<String, RNFetchBlobProgressConfig> uploadProgressReport = new HashMap<>();
    public Callback callback;
    public OkHttpClient client;
    public long contentLength;
    public String destPath;
    public long downloadManagerId;
    public ReadableMap headers;
    public String method;
    public RNFetchBlobConfig options;
    public String rawRequestBody;
    public ReadableArray rawRequestBodyArray;
    public ArrayList<String> redirects = new ArrayList<>();
    public RNFetchBlobBody requestBody;
    public RequestType requestType;
    public WritableMap respInfo;
    public ResponseFormat responseFormat = ResponseFormat.Auto;
    public ResponseType responseType;
    public String taskId;
    public boolean timeout = false;
    public String url;

    public enum RequestType {
        Form,
        SingleFile,
        AsIs,
        WithoutBody,
        Others
    }

    public enum ResponseFormat {
        Auto,
        UTF8,
        BASE64
    }

    public enum ResponseType {
        KeepInMemory,
        FileStorage
    }

    public RNFetchBlobReq(ReadableMap readableMap, String str, String str2, String str3, ReadableMap readableMap2, String str4, ReadableArray readableArray, OkHttpClient okHttpClient, Callback callback2) {
        this.method = str2.toUpperCase();
        RNFetchBlobConfig rNFetchBlobConfig = new RNFetchBlobConfig(readableMap);
        this.options = rNFetchBlobConfig;
        this.taskId = str;
        this.url = str3;
        this.headers = readableMap2;
        this.callback = callback2;
        this.rawRequestBody = str4;
        this.rawRequestBodyArray = readableArray;
        this.client = okHttpClient;
        if (rNFetchBlobConfig.fileCache.booleanValue() || this.options.path != null) {
            this.responseType = ResponseType.FileStorage;
        } else {
            this.responseType = ResponseType.KeepInMemory;
        }
        if (str4 != null) {
            this.requestType = RequestType.SingleFile;
        } else if (readableArray != null) {
            this.requestType = RequestType.Form;
        } else {
            this.requestType = RequestType.WithoutBody;
        }
    }

    public static void cancelTask(String str) {
        if (taskTable.containsKey(str)) {
            taskTable.get(str).cancel();
            taskTable.remove(str);
        }
        if (androidDownloadManagerTaskTable.containsKey(str)) {
            ((DownloadManager) RNFetchBlob.RCTContext.getApplicationContext().getSystemService(Constant.DOWNLOAD)).remove(new long[]{androidDownloadManagerTaskTable.get(str).longValue()});
        }
    }

    public static RNFetchBlobProgressConfig getReportProgress(String str) {
        if (!progressReport.containsKey(str)) {
            return null;
        }
        return progressReport.get(str);
    }

    public final String getHeaderIgnoreCases(Headers headers2, String str) {
        String str2 = headers2.get(str);
        if (str2 != null) {
            return str2;
        }
        return headers2.get(str.toLowerCase()) == null ? "" : headers2.get(str.toLowerCase());
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0109 A[SYNTHETIC, Splitter:B:37:0x0109] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0146  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReceive(android.content.Context r18, android.content.Intent r19) {
        /*
            r17 = this;
            r1 = r17
            java.lang.String r0 = "mime"
            java.lang.String r2 = r19.getAction()
            java.lang.String r3 = "android.intent.action.DOWNLOAD_COMPLETE"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x016b
            com.facebook.react.bridge.ReactApplicationContext r2 = com.RNFetchBlob.RNFetchBlob.RCTContext
            android.content.Context r2 = r2.getApplicationContext()
            android.os.Bundle r3 = r19.getExtras()
            java.lang.String r4 = "extra_download_id"
            long r3 = r3.getLong(r4)
            long r5 = r1.downloadManagerId
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x016b
            r17.releaseTaskResource()
            android.app.DownloadManager$Query r3 = new android.app.DownloadManager$Query
            r3.<init>()
            r4 = 1
            long[] r5 = new long[r4]
            long r6 = r1.downloadManagerId
            r8 = 0
            r5[r8] = r6
            r3.setFilterById(r5)
            java.lang.String r5 = "download"
            java.lang.Object r5 = r2.getSystemService(r5)
            android.app.DownloadManager r5 = (android.app.DownloadManager) r5
            r5.query(r3)
            android.database.Cursor r3 = r5.query(r3)
            java.lang.String r5 = ". Query was unsuccessful "
            java.lang.String r6 = "Download manager failed to download from  "
            r7 = 3
            r9 = 2
            r10 = 0
            if (r3 != 0) goto L_0x0073
            com.facebook.react.bridge.Callback r0 = r1.callback     // Catch:{ Exception -> 0x0072 }
            java.lang.Object[] r2 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x0072 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0072 }
            r3.<init>()     // Catch:{ Exception -> 0x0072 }
            r3.append(r6)     // Catch:{ Exception -> 0x0072 }
            java.lang.String r6 = r1.url     // Catch:{ Exception -> 0x0072 }
            r3.append(r6)     // Catch:{ Exception -> 0x0072 }
            r3.append(r5)     // Catch:{ Exception -> 0x0072 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0072 }
            r2[r8] = r3     // Catch:{ Exception -> 0x0072 }
            r2[r4] = r10     // Catch:{ Exception -> 0x0072 }
            r2[r9] = r10     // Catch:{ Exception -> 0x0072 }
            r0.invoke(r2)     // Catch:{ Exception -> 0x0072 }
        L_0x0072:
            return
        L_0x0073:
            boolean r11 = r3.moveToFirst()     // Catch:{ all -> 0x0166 }
            if (r11 == 0) goto L_0x00f9
            java.lang.String r11 = "status"
            int r11 = r3.getColumnIndex(r11)     // Catch:{ all -> 0x0166 }
            int r11 = r3.getInt(r11)     // Catch:{ all -> 0x0166 }
            r12 = 16
            if (r11 != r12) goto L_0x00b0
            com.facebook.react.bridge.Callback r0 = r1.callback     // Catch:{ Exception -> 0x00ac }
            java.lang.Object[] r2 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x00ac }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ac }
            r7.<init>()     // Catch:{ Exception -> 0x00ac }
            r7.append(r6)     // Catch:{ Exception -> 0x00ac }
            java.lang.String r6 = r1.url     // Catch:{ Exception -> 0x00ac }
            r7.append(r6)     // Catch:{ Exception -> 0x00ac }
            r7.append(r5)     // Catch:{ Exception -> 0x00ac }
            java.lang.String r5 = r7.toString()     // Catch:{ Exception -> 0x00ac }
            r2[r8] = r5     // Catch:{ Exception -> 0x00ac }
            r2[r4] = r10     // Catch:{ Exception -> 0x00ac }
            r2[r9] = r10     // Catch:{ Exception -> 0x00ac }
            r0.invoke(r2)     // Catch:{ Exception -> 0x00ac }
            r3.close()
            return
        L_0x00ac:
            r3.close()
            return
        L_0x00b0:
            java.lang.String r5 = "local_uri"
            int r5 = r3.getColumnIndex(r5)     // Catch:{ all -> 0x0166 }
            java.lang.String r5 = r3.getString(r5)     // Catch:{ all -> 0x0166 }
            if (r5 == 0) goto L_0x00f9
            com.RNFetchBlob.RNFetchBlobConfig r6 = r1.options     // Catch:{ all -> 0x0166 }
            com.facebook.react.bridge.ReadableMap r6 = r6.addAndroidDownloads     // Catch:{ all -> 0x0166 }
            boolean r6 = r6.hasKey(r0)     // Catch:{ all -> 0x0166 }
            if (r6 == 0) goto L_0x00f9
            com.RNFetchBlob.RNFetchBlobConfig r6 = r1.options     // Catch:{ all -> 0x0166 }
            com.facebook.react.bridge.ReadableMap r6 = r6.addAndroidDownloads     // Catch:{ all -> 0x0166 }
            java.lang.String r0 = r6.getString(r0)     // Catch:{ all -> 0x0166 }
            java.lang.String r6 = "image"
            boolean r0 = r0.contains(r6)     // Catch:{ all -> 0x0166 }
            if (r0 == 0) goto L_0x00f9
            android.net.Uri r12 = android.net.Uri.parse(r5)     // Catch:{ all -> 0x0166 }
            android.content.ContentResolver r11 = r2.getContentResolver()     // Catch:{ all -> 0x0166 }
            java.lang.String r0 = "_data"
            java.lang.String[] r13 = new java.lang.String[]{r0}     // Catch:{ all -> 0x0166 }
            r14 = 0
            r15 = 0
            r16 = 0
            android.database.Cursor r0 = r11.query(r12, r13, r14, r15, r16)     // Catch:{ all -> 0x0166 }
            if (r0 == 0) goto L_0x00f9
            r0.moveToFirst()     // Catch:{ all -> 0x0166 }
            java.lang.String r2 = r0.getString(r8)     // Catch:{ all -> 0x0166 }
            r0.close()     // Catch:{ all -> 0x0166 }
            goto L_0x00fa
        L_0x00f9:
            r2 = r10
        L_0x00fa:
            r3.close()
            com.RNFetchBlob.RNFetchBlobConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r3 = "path"
            boolean r0 = r0.hasKey(r3)
            if (r0 == 0) goto L_0x0146
            com.RNFetchBlob.RNFetchBlobConfig r0 = r1.options     // Catch:{ Exception -> 0x0132 }
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads     // Catch:{ Exception -> 0x0132 }
            java.lang.String r0 = r0.getString(r3)     // Catch:{ Exception -> 0x0132 }
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x0132 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x0132 }
            boolean r2 = r2.exists()     // Catch:{ Exception -> 0x0132 }
            if (r2 == 0) goto L_0x012a
            com.facebook.react.bridge.Callback r2 = r1.callback     // Catch:{ Exception -> 0x0132 }
            java.lang.Object[] r5 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x0132 }
            r5[r8] = r10     // Catch:{ Exception -> 0x0132 }
            r5[r4] = r3     // Catch:{ Exception -> 0x0132 }
            r5[r9] = r0     // Catch:{ Exception -> 0x0132 }
            r2.invoke(r5)     // Catch:{ Exception -> 0x0132 }
            goto L_0x016b
        L_0x012a:
            java.lang.Exception r0 = new java.lang.Exception     // Catch:{ Exception -> 0x0132 }
            java.lang.String r2 = "Download manager download failed, the file does not downloaded to destination."
            r0.<init>(r2)     // Catch:{ Exception -> 0x0132 }
            throw r0     // Catch:{ Exception -> 0x0132 }
        L_0x0132:
            r0 = move-exception
            r0.printStackTrace()
            com.facebook.react.bridge.Callback r2 = r1.callback
            java.lang.Object[] r3 = new java.lang.Object[r9]
            java.lang.String r0 = r0.getLocalizedMessage()
            r3[r8] = r0
            r3[r4] = r10
            r2.invoke(r3)
            goto L_0x016b
        L_0x0146:
            if (r2 != 0) goto L_0x0158
            com.facebook.react.bridge.Callback r0 = r1.callback
            java.lang.Object[] r2 = new java.lang.Object[r7]
            java.lang.String r5 = "Download manager could not resolve downloaded file path."
            r2[r8] = r5
            r2[r4] = r3
            r2[r9] = r10
            r0.invoke(r2)
            goto L_0x016b
        L_0x0158:
            com.facebook.react.bridge.Callback r0 = r1.callback
            java.lang.Object[] r5 = new java.lang.Object[r7]
            r5[r8] = r10
            r5[r4] = r3
            r5[r9] = r2
            r0.invoke(r5)
            goto L_0x016b
        L_0x0166:
            r0 = move-exception
            r3.close()
            throw r0
        L_0x016b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.RNFetchBlob.RNFetchBlobReq.onReceive(android.content.Context, android.content.Intent):void");
    }

    public final void releaseTaskResource() {
        if (taskTable.containsKey(this.taskId)) {
            taskTable.remove(this.taskId);
        }
        if (androidDownloadManagerTaskTable.containsKey(this.taskId)) {
            androidDownloadManagerTaskTable.remove(this.taskId);
        }
        if (uploadProgressReport.containsKey(this.taskId)) {
            uploadProgressReport.remove(this.taskId);
        }
        if (progressReport.containsKey(this.taskId)) {
            progressReport.remove(this.taskId);
        }
        RNFetchBlobBody rNFetchBlobBody = this.requestBody;
        if (rNFetchBlobBody == null) {
            return;
        }
        if (rNFetchBlobBody != null) {
            try {
                if (rNFetchBlobBody.bodyCache != null && rNFetchBlobBody.bodyCache.exists()) {
                    rNFetchBlobBody.bodyCache.delete();
                }
            } catch (Exception e2) {
                k.emitWarningEvent(e2.getLocalizedMessage());
            }
        } else {
            throw null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:110:0x02c0 A[SYNTHETIC, Splitter:B:110:0x02c0] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x02e3 A[Catch:{ Exception -> 0x049b }] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x02e8 A[Catch:{ Exception -> 0x049b }] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0301 A[Catch:{ Exception -> 0x049b }] */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x036b A[Catch:{ Exception -> 0x049b }] */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x03ee A[Catch:{ Exception -> 0x049b }] */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x0450 A[Catch:{ Exception -> 0x049b }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0198  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01b6  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01dd A[Catch:{ Exception -> 0x049b }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01e4 A[Catch:{ Exception -> 0x049b }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01f4 A[Catch:{ Exception -> 0x049b }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x026b A[Catch:{ Exception -> 0x049b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r15 = this;
            java.lang.String r0 = ";base64"
            java.lang.String r1 = "post"
            java.lang.String r2 = "Content-Type"
            com.RNFetchBlob.RNFetchBlobConfig r3 = r15.options
            com.facebook.react.bridge.ReadableMap r3 = r3.addAndroidDownloads
            java.lang.String r4 = "path"
            r5 = 2
            r6 = 1
            if (r3 == 0) goto L_0x0112
            java.lang.String r7 = "useDownloadManager"
            boolean r3 = r3.hasKey(r7)
            if (r3 == 0) goto L_0x0112
            com.RNFetchBlob.RNFetchBlobConfig r3 = r15.options
            com.facebook.react.bridge.ReadableMap r3 = r3.addAndroidDownloads
            boolean r3 = r3.getBoolean(r7)
            if (r3 == 0) goto L_0x0112
            java.lang.String r0 = r15.url
            android.net.Uri r0 = android.net.Uri.parse(r0)
            android.app.DownloadManager$Request r1 = new android.app.DownloadManager$Request
            r1.<init>(r0)
            com.RNFetchBlob.RNFetchBlobConfig r0 = r15.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r2 = "notification"
            boolean r0 = r0.hasKey(r2)
            if (r0 == 0) goto L_0x0047
            com.RNFetchBlob.RNFetchBlobConfig r0 = r15.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            boolean r0 = r0.getBoolean(r2)
            if (r0 == 0) goto L_0x0047
            r1.setNotificationVisibility(r6)
            goto L_0x004a
        L_0x0047:
            r1.setNotificationVisibility(r5)
        L_0x004a:
            com.RNFetchBlob.RNFetchBlobConfig r0 = r15.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r2 = "title"
            boolean r0 = r0.hasKey(r2)
            if (r0 == 0) goto L_0x0061
            com.RNFetchBlob.RNFetchBlobConfig r0 = r15.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r0 = r0.getString(r2)
            r1.setTitle(r0)
        L_0x0061:
            com.RNFetchBlob.RNFetchBlobConfig r0 = r15.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r2 = "description"
            boolean r0 = r0.hasKey(r2)
            if (r0 == 0) goto L_0x0078
            com.RNFetchBlob.RNFetchBlobConfig r0 = r15.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r0 = r0.getString(r2)
            r1.setDescription(r0)
        L_0x0078:
            com.RNFetchBlob.RNFetchBlobConfig r0 = r15.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            boolean r0 = r0.hasKey(r4)
            if (r0 == 0) goto L_0x009e
            java.lang.String r0 = "file://"
            java.lang.StringBuilder r0 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r0)
            com.RNFetchBlob.RNFetchBlobConfig r2 = r15.options
            com.facebook.react.bridge.ReadableMap r2 = r2.addAndroidDownloads
            java.lang.String r2 = r2.getString(r4)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            android.net.Uri r0 = android.net.Uri.parse(r0)
            r1.setDestinationUri(r0)
        L_0x009e:
            com.RNFetchBlob.RNFetchBlobConfig r0 = r15.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r2 = "mime"
            boolean r0 = r0.hasKey(r2)
            if (r0 == 0) goto L_0x00b5
            com.RNFetchBlob.RNFetchBlobConfig r0 = r15.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r0 = r0.getString(r2)
            r1.setMimeType(r0)
        L_0x00b5:
            com.facebook.react.bridge.ReadableMap r0 = r15.headers
            com.facebook.react.bridge.ReadableMapKeySetIterator r0 = r0.keySetIterator()
            com.RNFetchBlob.RNFetchBlobConfig r2 = r15.options
            com.facebook.react.bridge.ReadableMap r2 = r2.addAndroidDownloads
            java.lang.String r3 = "mediaScannable"
            boolean r2 = r2.hasKey(r3)
            if (r2 == 0) goto L_0x00d4
            com.RNFetchBlob.RNFetchBlobConfig r2 = r15.options
            com.facebook.react.bridge.ReadableMap r2 = r2.addAndroidDownloads
            boolean r2 = r2.hasKey(r3)
            if (r2 == 0) goto L_0x00d4
            r1.allowScanningByMediaScanner()
        L_0x00d4:
            boolean r2 = r0.hasNextKey()
            if (r2 == 0) goto L_0x00e8
            java.lang.String r2 = r0.nextKey()
            com.facebook.react.bridge.ReadableMap r3 = r15.headers
            java.lang.String r3 = r3.getString(r2)
            r1.addRequestHeader(r2, r3)
            goto L_0x00d4
        L_0x00e8:
            com.facebook.react.bridge.ReactApplicationContext r0 = com.RNFetchBlob.RNFetchBlob.RCTContext
            android.content.Context r0 = r0.getApplicationContext()
            java.lang.String r2 = "download"
            java.lang.Object r2 = r0.getSystemService(r2)
            android.app.DownloadManager r2 = (android.app.DownloadManager) r2
            long r1 = r2.enqueue(r1)
            r15.downloadManagerId = r1
            java.util.HashMap<java.lang.String, java.lang.Long> r3 = androidDownloadManagerTaskTable
            java.lang.String r4 = r15.taskId
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            r3.put(r4, r1)
            android.content.IntentFilter r1 = new android.content.IntentFilter
            java.lang.String r2 = "android.intent.action.DOWNLOAD_COMPLETE"
            r1.<init>(r2)
            r0.registerReceiver(r15, r1)
            return
        L_0x0112:
            java.lang.String r3 = r15.taskId
            com.RNFetchBlob.RNFetchBlobConfig r5 = r15.options
            java.lang.String r5 = r5.appendExt
            boolean r5 = r5.isEmpty()
            java.lang.String r7 = ""
            if (r5 == 0) goto L_0x0122
            r5 = r7
            goto L_0x0133
        L_0x0122:
            java.lang.String r5 = "."
            java.lang.StringBuilder r5 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r5)
            com.RNFetchBlob.RNFetchBlobConfig r8 = r15.options
            java.lang.String r8 = r8.appendExt
            r5.append(r8)
            java.lang.String r5 = r5.toString()
        L_0x0133:
            com.RNFetchBlob.RNFetchBlobConfig r8 = r15.options
            java.lang.String r8 = r8.key
            r9 = 0
            if (r8 == 0) goto L_0x01ad
            java.lang.String r3 = "MD5"
            java.security.MessageDigest r3 = java.security.MessageDigest.getInstance(r3)     // Catch:{ Exception -> 0x0171 }
            byte[] r8 = r8.getBytes()     // Catch:{ Exception -> 0x0171 }
            r3.update(r8)     // Catch:{ Exception -> 0x0171 }
            byte[] r3 = r3.digest()     // Catch:{ Exception -> 0x0171 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0171 }
            r8.<init>()     // Catch:{ Exception -> 0x0171 }
            int r10 = r3.length     // Catch:{ Exception -> 0x0171 }
            r11 = 0
        L_0x0152:
            if (r11 >= r10) goto L_0x016c
            byte r12 = r3[r11]     // Catch:{ Exception -> 0x0171 }
            java.lang.String r13 = "%02x"
            java.lang.Object[] r14 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x0171 }
            r12 = r12 & 255(0xff, float:3.57E-43)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ Exception -> 0x0171 }
            r14[r9] = r12     // Catch:{ Exception -> 0x0171 }
            java.lang.String r12 = java.lang.String.format(r13, r14)     // Catch:{ Exception -> 0x0171 }
            r8.append(r12)     // Catch:{ Exception -> 0x0171 }
            int r11 = r11 + 1
            goto L_0x0152
        L_0x016c:
            java.lang.String r3 = r8.toString()     // Catch:{ Exception -> 0x0171 }
            goto L_0x0176
        L_0x0171:
            r3 = move-exception
            r3.printStackTrace()     // Catch:{ all -> 0x0175 }
        L_0x0175:
            r3 = 0
        L_0x0176:
            if (r3 != 0) goto L_0x017a
            java.lang.String r3 = r15.taskId
        L_0x017a:
            java.io.File r8 = new java.io.File
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = com.RNFetchBlob.RNFetchBlobFS.getTmpPath(r3)
            r10.append(r11)
            r10.append(r5)
            java.lang.String r10 = r10.toString()
            r8.<init>(r10)
            boolean r10 = r8.exists()
            if (r10 == 0) goto L_0x01ad
            com.facebook.react.bridge.Callback r0 = r15.callback
            r1 = 3
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r2 = 0
            r1[r9] = r2
            r1[r6] = r4
            java.lang.String r2 = r8.getAbsolutePath()
            r3 = 2
            r1[r3] = r2
            r0.invoke(r1)
            return
        L_0x01ad:
            com.RNFetchBlob.RNFetchBlobConfig r4 = r15.options
            java.lang.String r8 = r4.path
            if (r8 == 0) goto L_0x01b6
            r15.destPath = r8
            goto L_0x01d3
        L_0x01b6:
            java.lang.Boolean r4 = r4.fileCache
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x01d3
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r3 = com.RNFetchBlob.RNFetchBlobFS.getTmpPath(r3)
            r4.append(r3)
            r4.append(r5)
            java.lang.String r3 = r4.toString()
            r15.destPath = r3
        L_0x01d3:
            com.RNFetchBlob.RNFetchBlobConfig r3 = r15.options     // Catch:{ Exception -> 0x049b }
            java.lang.Boolean r3 = r3.trusty     // Catch:{ Exception -> 0x049b }
            boolean r3 = r3.booleanValue()     // Catch:{ Exception -> 0x049b }
            if (r3 == 0) goto L_0x01e4
            okhttp3.OkHttpClient r3 = r15.client     // Catch:{ Exception -> 0x049b }
            okhttp3.OkHttpClient$Builder r3 = co.hyperverge.hypersnapsdk.c.k.getUnsafeOkHttpClient(r3)     // Catch:{ Exception -> 0x049b }
            goto L_0x01ea
        L_0x01e4:
            okhttp3.OkHttpClient r3 = r15.client     // Catch:{ Exception -> 0x049b }
            okhttp3.OkHttpClient$Builder r3 = r3.newBuilder()     // Catch:{ Exception -> 0x049b }
        L_0x01ea:
            com.RNFetchBlob.RNFetchBlobConfig r4 = r15.options     // Catch:{ Exception -> 0x049b }
            java.lang.Boolean r4 = r4.wifiOnly     // Catch:{ Exception -> 0x049b }
            boolean r4 = r4.booleanValue()     // Catch:{ Exception -> 0x049b }
            if (r4 == 0) goto L_0x024e
            com.facebook.react.bridge.ReactApplicationContext r4 = com.RNFetchBlob.RNFetchBlob.RCTContext     // Catch:{ Exception -> 0x049b }
            com.facebook.react.bridge.ReactApplicationContext r5 = com.RNFetchBlob.RNFetchBlob.RCTContext     // Catch:{ Exception -> 0x049b }
            java.lang.String r5 = "connectivity"
            java.lang.Object r4 = r4.getSystemService(r5)     // Catch:{ Exception -> 0x049b }
            android.net.ConnectivityManager r4 = (android.net.ConnectivityManager) r4     // Catch:{ Exception -> 0x049b }
            android.net.Network[] r5 = r4.getAllNetworks()     // Catch:{ Exception -> 0x049b }
            int r8 = r5.length     // Catch:{ Exception -> 0x049b }
            r10 = 0
        L_0x0206:
            if (r10 >= r8) goto L_0x0235
            r11 = r5[r10]     // Catch:{ Exception -> 0x049b }
            android.net.NetworkInfo r12 = r4.getNetworkInfo(r11)     // Catch:{ Exception -> 0x049b }
            android.net.NetworkCapabilities r13 = r4.getNetworkCapabilities(r11)     // Catch:{ Exception -> 0x049b }
            if (r13 == 0) goto L_0x0232
            if (r12 != 0) goto L_0x0217
            goto L_0x0232
        L_0x0217:
            boolean r12 = r12.isConnected()     // Catch:{ Exception -> 0x049b }
            if (r12 != 0) goto L_0x021e
            goto L_0x0232
        L_0x021e:
            boolean r12 = r13.hasTransport(r6)     // Catch:{ Exception -> 0x049b }
            if (r12 == 0) goto L_0x0232
            java.net.Proxy r4 = java.net.Proxy.NO_PROXY     // Catch:{ Exception -> 0x049b }
            r3.proxy(r4)     // Catch:{ Exception -> 0x049b }
            javax.net.SocketFactory r4 = r11.getSocketFactory()     // Catch:{ Exception -> 0x049b }
            r3.socketFactory(r4)     // Catch:{ Exception -> 0x049b }
            r4 = 1
            goto L_0x0236
        L_0x0232:
            int r10 = r10 + 1
            goto L_0x0206
        L_0x0235:
            r4 = 0
        L_0x0236:
            if (r4 != 0) goto L_0x024e
            com.facebook.react.bridge.Callback r0 = r15.callback     // Catch:{ Exception -> 0x049b }
            r1 = 3
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x049b }
            java.lang.String r2 = "No available WiFi connections."
            r1[r9] = r2     // Catch:{ Exception -> 0x049b }
            r2 = 0
            r1[r6] = r2     // Catch:{ Exception -> 0x049b }
            r3 = 2
            r1[r3] = r2     // Catch:{ Exception -> 0x049b }
            r0.invoke(r1)     // Catch:{ Exception -> 0x049b }
            r15.releaseTaskResource()     // Catch:{ Exception -> 0x049b }
            return
        L_0x024e:
            okhttp3.Request$Builder r4 = new okhttp3.Request$Builder     // Catch:{ Exception -> 0x049b }
            r4.<init>()     // Catch:{ Exception -> 0x049b }
            java.net.URL r5 = new java.net.URL     // Catch:{ MalformedURLException -> 0x025e }
            java.lang.String r8 = r15.url     // Catch:{ MalformedURLException -> 0x025e }
            r5.<init>(r8)     // Catch:{ MalformedURLException -> 0x025e }
            r4.url(r5)     // Catch:{ MalformedURLException -> 0x025e }
            goto L_0x0262
        L_0x025e:
            r5 = move-exception
            r5.printStackTrace()     // Catch:{ Exception -> 0x049b }
        L_0x0262:
            java.util.HashMap r5 = new java.util.HashMap     // Catch:{ Exception -> 0x049b }
            r5.<init>()     // Catch:{ Exception -> 0x049b }
            com.facebook.react.bridge.ReadableMap r8 = r15.headers     // Catch:{ Exception -> 0x049b }
            if (r8 == 0) goto L_0x02b2
            com.facebook.react.bridge.ReadableMap r8 = r15.headers     // Catch:{ Exception -> 0x049b }
            com.facebook.react.bridge.ReadableMapKeySetIterator r8 = r8.keySetIterator()     // Catch:{ Exception -> 0x049b }
        L_0x0271:
            boolean r10 = r8.hasNextKey()     // Catch:{ Exception -> 0x049b }
            if (r10 == 0) goto L_0x02b2
            java.lang.String r10 = r8.nextKey()     // Catch:{ Exception -> 0x049b }
            com.facebook.react.bridge.ReadableMap r11 = r15.headers     // Catch:{ Exception -> 0x049b }
            java.lang.String r11 = r11.getString(r10)     // Catch:{ Exception -> 0x049b }
            java.lang.String r12 = "RNFB-Response"
            boolean r12 = r10.equalsIgnoreCase(r12)     // Catch:{ Exception -> 0x049b }
            if (r12 == 0) goto L_0x02a3
            java.lang.String r10 = "base64"
            boolean r10 = r11.equalsIgnoreCase(r10)     // Catch:{ Exception -> 0x049b }
            if (r10 == 0) goto L_0x0296
            com.RNFetchBlob.RNFetchBlobReq$ResponseFormat r10 = com.RNFetchBlob.RNFetchBlobReq.ResponseFormat.BASE64     // Catch:{ Exception -> 0x049b }
            r15.responseFormat = r10     // Catch:{ Exception -> 0x049b }
            goto L_0x0271
        L_0x0296:
            java.lang.String r10 = "utf8"
            boolean r10 = r11.equalsIgnoreCase(r10)     // Catch:{ Exception -> 0x049b }
            if (r10 == 0) goto L_0x0271
            com.RNFetchBlob.RNFetchBlobReq$ResponseFormat r10 = com.RNFetchBlob.RNFetchBlobReq.ResponseFormat.UTF8     // Catch:{ Exception -> 0x049b }
            r15.responseFormat = r10     // Catch:{ Exception -> 0x049b }
            goto L_0x0271
        L_0x02a3:
            java.lang.String r12 = r10.toLowerCase()     // Catch:{ Exception -> 0x049b }
            r4.header(r12, r11)     // Catch:{ Exception -> 0x049b }
            java.lang.String r10 = r10.toLowerCase()     // Catch:{ Exception -> 0x049b }
            r5.put(r10, r11)     // Catch:{ Exception -> 0x049b }
            goto L_0x0271
        L_0x02b2:
            java.lang.String r8 = r15.method     // Catch:{ Exception -> 0x049b }
            boolean r8 = r8.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x049b }
            java.lang.String r10 = "patch"
            java.lang.String r11 = "put"
            java.lang.String r12 = "content-type"
            if (r8 != 0) goto L_0x02d7
            java.lang.String r8 = r15.method     // Catch:{ Exception -> 0x049b }
            boolean r8 = r8.equalsIgnoreCase(r11)     // Catch:{ Exception -> 0x049b }
            if (r8 != 0) goto L_0x02d7
            java.lang.String r8 = r15.method     // Catch:{ Exception -> 0x049b }
            boolean r8 = r8.equalsIgnoreCase(r10)     // Catch:{ Exception -> 0x049b }
            if (r8 == 0) goto L_0x02d1
            goto L_0x02d7
        L_0x02d1:
            com.RNFetchBlob.RNFetchBlobReq$RequestType r0 = com.RNFetchBlob.RNFetchBlobReq.RequestType.WithoutBody     // Catch:{ Exception -> 0x049b }
            r15.requestType = r0     // Catch:{ Exception -> 0x049b }
            goto L_0x0357
        L_0x02d7:
            java.lang.String r8 = r15.getHeaderIgnoreCases(r5, r2)     // Catch:{ Exception -> 0x049b }
            java.lang.String r8 = r8.toLowerCase()     // Catch:{ Exception -> 0x049b }
            com.facebook.react.bridge.ReadableArray r13 = r15.rawRequestBodyArray     // Catch:{ Exception -> 0x049b }
            if (r13 == 0) goto L_0x02e8
            com.RNFetchBlob.RNFetchBlobReq$RequestType r13 = com.RNFetchBlob.RNFetchBlobReq.RequestType.Form     // Catch:{ Exception -> 0x049b }
            r15.requestType = r13     // Catch:{ Exception -> 0x049b }
            goto L_0x02fd
        L_0x02e8:
            boolean r13 = r8.isEmpty()     // Catch:{ Exception -> 0x049b }
            if (r13 == 0) goto L_0x02fd
            boolean r13 = r8.equalsIgnoreCase(r7)     // Catch:{ Exception -> 0x049b }
            if (r13 != 0) goto L_0x02f9
            java.lang.String r13 = "application/octet-stream"
            r4.header(r2, r13)     // Catch:{ Exception -> 0x049b }
        L_0x02f9:
            com.RNFetchBlob.RNFetchBlobReq$RequestType r13 = com.RNFetchBlob.RNFetchBlobReq.RequestType.SingleFile     // Catch:{ Exception -> 0x049b }
            r15.requestType = r13     // Catch:{ Exception -> 0x049b }
        L_0x02fd:
            java.lang.String r13 = r15.rawRequestBody     // Catch:{ Exception -> 0x049b }
            if (r13 == 0) goto L_0x0357
            java.lang.String r13 = r15.rawRequestBody     // Catch:{ Exception -> 0x049b }
            java.lang.String r14 = "RNFetchBlob-file://"
            boolean r13 = r13.startsWith(r14)     // Catch:{ Exception -> 0x049b }
            if (r13 != 0) goto L_0x0353
            java.lang.String r13 = r15.rawRequestBody     // Catch:{ Exception -> 0x049b }
            java.lang.String r14 = "RNFetchBlob-content://"
            boolean r13 = r13.startsWith(r14)     // Catch:{ Exception -> 0x049b }
            if (r13 == 0) goto L_0x0316
            goto L_0x0353
        L_0x0316:
            java.lang.String r13 = r8.toLowerCase()     // Catch:{ Exception -> 0x049b }
            boolean r13 = r13.contains(r0)     // Catch:{ Exception -> 0x049b }
            if (r13 != 0) goto L_0x0332
            java.lang.String r13 = r8.toLowerCase()     // Catch:{ Exception -> 0x049b }
            java.lang.String r14 = "application/octet"
            boolean r13 = r13.startsWith(r14)     // Catch:{ Exception -> 0x049b }
            if (r13 == 0) goto L_0x032d
            goto L_0x0332
        L_0x032d:
            com.RNFetchBlob.RNFetchBlobReq$RequestType r0 = com.RNFetchBlob.RNFetchBlobReq.RequestType.AsIs     // Catch:{ Exception -> 0x049b }
            r15.requestType = r0     // Catch:{ Exception -> 0x049b }
            goto L_0x0357
        L_0x0332:
            java.lang.String r0 = r8.replace(r0, r7)     // Catch:{ Exception -> 0x049b }
            java.lang.String r8 = ";BASE64"
            java.lang.String r0 = r0.replace(r8, r7)     // Catch:{ Exception -> 0x049b }
            boolean r7 = r5.containsKey(r12)     // Catch:{ Exception -> 0x049b }
            if (r7 == 0) goto L_0x0345
            r5.put(r12, r0)     // Catch:{ Exception -> 0x049b }
        L_0x0345:
            boolean r7 = r5.containsKey(r2)     // Catch:{ Exception -> 0x049b }
            if (r7 == 0) goto L_0x034e
            r5.put(r2, r0)     // Catch:{ Exception -> 0x049b }
        L_0x034e:
            com.RNFetchBlob.RNFetchBlobReq$RequestType r0 = com.RNFetchBlob.RNFetchBlobReq.RequestType.SingleFile     // Catch:{ Exception -> 0x049b }
            r15.requestType = r0     // Catch:{ Exception -> 0x049b }
            goto L_0x0357
        L_0x0353:
            com.RNFetchBlob.RNFetchBlobReq$RequestType r0 = com.RNFetchBlob.RNFetchBlobReq.RequestType.SingleFile     // Catch:{ Exception -> 0x049b }
            r15.requestType = r0     // Catch:{ Exception -> 0x049b }
        L_0x0357:
            java.lang.String r0 = "Transfer-Encoding"
            java.lang.String r0 = r15.getHeaderIgnoreCases(r5, r0)     // Catch:{ Exception -> 0x049b }
            java.lang.String r2 = "chunked"
            boolean r0 = r0.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x049b }
            com.RNFetchBlob.RNFetchBlobReq$RequestType r2 = r15.requestType     // Catch:{ Exception -> 0x049b }
            int r2 = r2.ordinal()     // Catch:{ Exception -> 0x049b }
            if (r2 == 0) goto L_0x03ee
            if (r2 == r6) goto L_0x03c9
            r7 = 2
            if (r2 == r7) goto L_0x03a4
            r0 = 3
            if (r2 == r0) goto L_0x0375
            goto L_0x0432
        L_0x0375:
            java.lang.String r0 = r15.method     // Catch:{ Exception -> 0x049b }
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x049b }
            if (r0 != 0) goto L_0x0396
            java.lang.String r0 = r15.method     // Catch:{ Exception -> 0x049b }
            boolean r0 = r0.equalsIgnoreCase(r11)     // Catch:{ Exception -> 0x049b }
            if (r0 != 0) goto L_0x0396
            java.lang.String r0 = r15.method     // Catch:{ Exception -> 0x049b }
            boolean r0 = r0.equalsIgnoreCase(r10)     // Catch:{ Exception -> 0x049b }
            if (r0 == 0) goto L_0x038e
            goto L_0x0396
        L_0x038e:
            java.lang.String r0 = r15.method     // Catch:{ Exception -> 0x049b }
            r1 = 0
            r4.method(r0, r1)     // Catch:{ Exception -> 0x049b }
            goto L_0x0432
        L_0x0396:
            java.lang.String r0 = r15.method     // Catch:{ Exception -> 0x049b }
            byte[] r1 = new byte[r9]     // Catch:{ Exception -> 0x049b }
            r2 = 0
            okhttp3.RequestBody r1 = okhttp3.RequestBody.create(r2, r1)     // Catch:{ Exception -> 0x049b }
            r4.method(r0, r1)     // Catch:{ Exception -> 0x049b }
            goto L_0x0432
        L_0x03a4:
            com.RNFetchBlob.RNFetchBlobBody r1 = new com.RNFetchBlob.RNFetchBlobBody     // Catch:{ Exception -> 0x049b }
            java.lang.String r2 = r15.taskId     // Catch:{ Exception -> 0x049b }
            r1.<init>(r2)     // Catch:{ Exception -> 0x049b }
            r1.chunkedEncoding(r0)     // Catch:{ Exception -> 0x049b }
            com.RNFetchBlob.RNFetchBlobReq$RequestType r0 = r15.requestType     // Catch:{ Exception -> 0x049b }
            r1.requestType = r0     // Catch:{ Exception -> 0x049b }
            java.lang.String r0 = r15.rawRequestBody     // Catch:{ Exception -> 0x049b }
            r1.setBody(r0)     // Catch:{ Exception -> 0x049b }
            java.lang.String r0 = r15.getHeaderIgnoreCases(r5, r12)     // Catch:{ Exception -> 0x049b }
            okhttp3.MediaType r0 = okhttp3.MediaType.parse(r0)     // Catch:{ Exception -> 0x049b }
            r1.mime = r0     // Catch:{ Exception -> 0x049b }
            r15.requestBody = r1     // Catch:{ Exception -> 0x049b }
            java.lang.String r0 = r15.method     // Catch:{ Exception -> 0x049b }
            r4.method(r0, r1)     // Catch:{ Exception -> 0x049b }
            goto L_0x0432
        L_0x03c9:
            com.RNFetchBlob.RNFetchBlobBody r1 = new com.RNFetchBlob.RNFetchBlobBody     // Catch:{ Exception -> 0x049b }
            java.lang.String r2 = r15.taskId     // Catch:{ Exception -> 0x049b }
            r1.<init>(r2)     // Catch:{ Exception -> 0x049b }
            r1.chunkedEncoding(r0)     // Catch:{ Exception -> 0x049b }
            com.RNFetchBlob.RNFetchBlobReq$RequestType r0 = r15.requestType     // Catch:{ Exception -> 0x049b }
            r1.requestType = r0     // Catch:{ Exception -> 0x049b }
            java.lang.String r0 = r15.rawRequestBody     // Catch:{ Exception -> 0x049b }
            r1.setBody(r0)     // Catch:{ Exception -> 0x049b }
            java.lang.String r0 = r15.getHeaderIgnoreCases(r5, r12)     // Catch:{ Exception -> 0x049b }
            okhttp3.MediaType r0 = okhttp3.MediaType.parse(r0)     // Catch:{ Exception -> 0x049b }
            r1.mime = r0     // Catch:{ Exception -> 0x049b }
            r15.requestBody = r1     // Catch:{ Exception -> 0x049b }
            java.lang.String r0 = r15.method     // Catch:{ Exception -> 0x049b }
            r4.method(r0, r1)     // Catch:{ Exception -> 0x049b }
            goto L_0x0432
        L_0x03ee:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x049b }
            r1.<init>()     // Catch:{ Exception -> 0x049b }
            java.lang.String r2 = "RNFetchBlob-"
            r1.append(r2)     // Catch:{ Exception -> 0x049b }
            java.lang.String r2 = r15.taskId     // Catch:{ Exception -> 0x049b }
            r1.append(r2)     // Catch:{ Exception -> 0x049b }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x049b }
            com.RNFetchBlob.RNFetchBlobBody r2 = new com.RNFetchBlob.RNFetchBlobBody     // Catch:{ Exception -> 0x049b }
            java.lang.String r5 = r15.taskId     // Catch:{ Exception -> 0x049b }
            r2.<init>(r5)     // Catch:{ Exception -> 0x049b }
            r2.chunkedEncoding(r0)     // Catch:{ Exception -> 0x049b }
            com.RNFetchBlob.RNFetchBlobReq$RequestType r0 = r15.requestType     // Catch:{ Exception -> 0x049b }
            r2.requestType = r0     // Catch:{ Exception -> 0x049b }
            com.facebook.react.bridge.ReadableArray r0 = r15.rawRequestBodyArray     // Catch:{ Exception -> 0x049b }
            r2.setBody(r0)     // Catch:{ Exception -> 0x049b }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x049b }
            r0.<init>()     // Catch:{ Exception -> 0x049b }
            java.lang.String r5 = "multipart/form-data; boundary="
            r0.append(r5)     // Catch:{ Exception -> 0x049b }
            r0.append(r1)     // Catch:{ Exception -> 0x049b }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x049b }
            okhttp3.MediaType r0 = okhttp3.MediaType.parse(r0)     // Catch:{ Exception -> 0x049b }
            r2.mime = r0     // Catch:{ Exception -> 0x049b }
            r15.requestBody = r2     // Catch:{ Exception -> 0x049b }
            java.lang.String r0 = r15.method     // Catch:{ Exception -> 0x049b }
            r4.method(r0, r2)     // Catch:{ Exception -> 0x049b }
        L_0x0432:
            okhttp3.Request r0 = r4.build()     // Catch:{ Exception -> 0x049b }
            com.RNFetchBlob.RNFetchBlobReq$1 r1 = new com.RNFetchBlob.RNFetchBlobReq$1     // Catch:{ Exception -> 0x049b }
            r1.<init>()     // Catch:{ Exception -> 0x049b }
            r3.addNetworkInterceptor(r1)     // Catch:{ Exception -> 0x049b }
            com.RNFetchBlob.RNFetchBlobReq$2 r1 = new com.RNFetchBlob.RNFetchBlobReq$2     // Catch:{ Exception -> 0x049b }
            r1.<init>(r0)     // Catch:{ Exception -> 0x049b }
            r3.addInterceptor(r1)     // Catch:{ Exception -> 0x049b }
            com.RNFetchBlob.RNFetchBlobConfig r1 = r15.options     // Catch:{ Exception -> 0x049b }
            long r1 = r1.timeout     // Catch:{ Exception -> 0x049b }
            r4 = 0
            int r7 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r7 < 0) goto L_0x0462
            com.RNFetchBlob.RNFetchBlobConfig r1 = r15.options     // Catch:{ Exception -> 0x049b }
            long r1 = r1.timeout     // Catch:{ Exception -> 0x049b }
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ Exception -> 0x049b }
            r3.connectTimeout(r1, r4)     // Catch:{ Exception -> 0x049b }
            com.RNFetchBlob.RNFetchBlobConfig r1 = r15.options     // Catch:{ Exception -> 0x049b }
            long r1 = r1.timeout     // Catch:{ Exception -> 0x049b }
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ Exception -> 0x049b }
            r3.readTimeout(r1, r4)     // Catch:{ Exception -> 0x049b }
        L_0x0462:
            okhttp3.ConnectionPool r1 = pool     // Catch:{ Exception -> 0x049b }
            r3.connectionPool(r1)     // Catch:{ Exception -> 0x049b }
            r3.retryOnConnectionFailure(r9)     // Catch:{ Exception -> 0x049b }
            com.RNFetchBlob.RNFetchBlobConfig r1 = r15.options     // Catch:{ Exception -> 0x049b }
            java.lang.Boolean r1 = r1.followRedirect     // Catch:{ Exception -> 0x049b }
            boolean r1 = r1.booleanValue()     // Catch:{ Exception -> 0x049b }
            r3.followRedirects(r1)     // Catch:{ Exception -> 0x049b }
            com.RNFetchBlob.RNFetchBlobConfig r1 = r15.options     // Catch:{ Exception -> 0x049b }
            java.lang.Boolean r1 = r1.followRedirect     // Catch:{ Exception -> 0x049b }
            boolean r1 = r1.booleanValue()     // Catch:{ Exception -> 0x049b }
            r3.followSslRedirects(r1)     // Catch:{ Exception -> 0x049b }
            r3.retryOnConnectionFailure(r6)     // Catch:{ Exception -> 0x049b }
            okhttp3.OkHttpClient r1 = r3.build()     // Catch:{ Exception -> 0x049b }
            okhttp3.Call r0 = r1.newCall(r0)     // Catch:{ Exception -> 0x049b }
            java.util.HashMap<java.lang.String, okhttp3.Call> r1 = taskTable     // Catch:{ Exception -> 0x049b }
            java.lang.String r2 = r15.taskId     // Catch:{ Exception -> 0x049b }
            r1.put(r2, r0)     // Catch:{ Exception -> 0x049b }
            com.RNFetchBlob.RNFetchBlobReq$3 r1 = new com.RNFetchBlob.RNFetchBlobReq$3     // Catch:{ Exception -> 0x049b }
            r1.<init>()     // Catch:{ Exception -> 0x049b }
            com.google.firebase.perf.network.FirebasePerfOkHttpClient.enqueue(r0, r1)     // Catch:{ Exception -> 0x049b }
            goto L_0x04c3
        L_0x049b:
            r0 = move-exception
            r0.printStackTrace()
            r15.releaseTaskResource()
            com.facebook.react.bridge.Callback r1 = r15.callback
            java.lang.Object[] r2 = new java.lang.Object[r6]
            java.lang.String r3 = "RNFetchBlob request error: "
            java.lang.StringBuilder r3 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r3)
            java.lang.String r4 = r0.getMessage()
            r3.append(r4)
            java.lang.Throwable r0 = r0.getCause()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2[r9] = r0
            r1.invoke(r2)
        L_0x04c3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.RNFetchBlob.RNFetchBlobReq.run():void");
    }

    public final String getHeaderIgnoreCases(HashMap<String, String> hashMap, String str) {
        String str2 = hashMap.get(str);
        if (str2 != null) {
            return str2;
        }
        String str3 = hashMap.get(str.toLowerCase());
        if (str3 == null) {
            str3 = "";
        }
        return str3;
    }
}
