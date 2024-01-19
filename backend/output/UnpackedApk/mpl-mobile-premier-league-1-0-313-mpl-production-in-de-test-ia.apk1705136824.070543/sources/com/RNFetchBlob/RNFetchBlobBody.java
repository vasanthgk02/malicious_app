package com.RNFetchBlob;

import android.net.Uri;
import android.util.Base64;
import co.hyperverge.hypersnapsdk.c.k;
import com.RNFetchBlob.RNFetchBlobReq.RequestType;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.graphics.GL20;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.rudderstack.android.sdk.core.ecomm.ECommerceParamNames;
import io.sentry.Attachment;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;

public class RNFetchBlobBody extends RequestBody {
    public File bodyCache;
    public Boolean chunkedEncoding = Boolean.FALSE;
    public long contentLength = 0;
    public ReadableArray form;
    public String mTaskId;
    public MediaType mime;
    public String rawBody;
    public InputStream requestStream;
    public RequestType requestType;

    public class FormField {
        public String data;
        public String filename;
        public String mime;
        public String name;

        public FormField(RNFetchBlobBody rNFetchBlobBody, ReadableMap readableMap) {
            if (readableMap.hasKey("name")) {
                this.name = readableMap.getString("name");
            }
            if (readableMap.hasKey("filename")) {
                this.filename = readableMap.getString("filename");
            }
            if (readableMap.hasKey("type")) {
                this.mime = readableMap.getString("type");
            } else {
                this.mime = this.filename == null ? "text/plain" : Attachment.DEFAULT_CONTENT_TYPE;
            }
            if (readableMap.hasKey("data")) {
                this.data = readableMap.getString("data");
            }
        }
    }

    public RNFetchBlobBody(String str) {
        this.mTaskId = str;
    }

    public RNFetchBlobBody chunkedEncoding(boolean z) {
        this.chunkedEncoding = Boolean.valueOf(z);
        return this;
    }

    public long contentLength() {
        if (this.chunkedEncoding.booleanValue()) {
            return -1;
        }
        return this.contentLength;
    }

    public MediaType contentType() {
        return this.mime;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0227, code lost:
        if (r3 == null) goto L_0x0264;
     */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0231  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0111 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.io.File createMultipartBodyCache() throws java.io.IOException {
        /*
            r21 = this;
            r1 = r21
            java.lang.String r0 = "RNFetchBlob-"
            java.lang.StringBuilder r0 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r0)
            java.lang.String r2 = r1.mTaskId
            r0.append(r2)
            java.lang.String r2 = r0.toString()
            com.facebook.react.bridge.ReactApplicationContext r0 = com.RNFetchBlob.RNFetchBlob.RCTContext
            java.io.File r0 = r0.getCacheDir()
            java.lang.String r3 = "rnfb-form-tmp"
            java.lang.String r4 = ""
            java.io.File r3 = java.io.File.createTempFile(r3, r4, r0)
            java.io.FileOutputStream r5 = new java.io.FileOutputStream
            r5.<init>(r3)
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            com.facebook.react.bridge.ReactApplicationContext r7 = com.RNFetchBlob.RNFetchBlob.RCTContext
            r8 = 0
            r0 = 0
            r9 = r8
            r8 = 0
        L_0x0030:
            com.facebook.react.bridge.ReadableArray r0 = r1.form
            int r0 = r0.size()
            java.lang.String r11 = "bundle-assets://"
            java.lang.String r12 = "RNFetchBlob-content://"
            java.lang.String r13 = "RNFetchBlob-file://"
            java.lang.String r14 = ", "
            if (r8 >= r0) goto L_0x0115
            com.RNFetchBlob.RNFetchBlobBody$FormField r0 = new com.RNFetchBlob.RNFetchBlobBody$FormField
            com.facebook.react.bridge.ReadableArray r15 = r1.form
            com.facebook.react.bridge.ReadableMap r15 = r15.getMap(r8)
            r0.<init>(r1, r15)
            r6.add(r0)
            java.lang.String r15 = r0.data
            if (r15 != 0) goto L_0x006b
            java.lang.String r11 = "RNFetchBlob multipart request builder has found a field without `data` property, the field `"
            java.lang.StringBuilder r11 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r11)
            java.lang.String r0 = r0.name
            r11.append(r0)
            java.lang.String r0 = "` will be removed implicitly."
            r11.append(r0)
            java.lang.String r0 = r11.toString()
            co.hyperverge.hypersnapsdk.c.k.emitWarningEvent(r0)
            goto L_0x0111
        L_0x006b:
            java.lang.String r0 = r0.filename
            if (r0 == 0) goto L_0x010a
            boolean r0 = r15.startsWith(r13)
            if (r0 == 0) goto L_0x00b1
            r0 = 19
            java.lang.String r0 = r15.substring(r0)
            java.lang.String r0 = com.RNFetchBlob.RNFetchBlobFS.normalizePath(r0)
            boolean r12 = com.RNFetchBlob.RNFetchBlobFS.isAsset(r0)
            if (r12 == 0) goto L_0x00a1
            java.lang.String r0 = r0.replace(r11, r4)     // Catch:{ IOException -> 0x0097 }
            android.content.res.AssetManager r11 = r7.getAssets()     // Catch:{ IOException -> 0x0097 }
            java.io.InputStream r0 = r11.open(r0)     // Catch:{ IOException -> 0x0097 }
            int r0 = r0.available()     // Catch:{ IOException -> 0x0097 }
            goto L_0x010f
        L_0x0097:
            r0 = move-exception
            java.lang.String r0 = r0.getLocalizedMessage()
            co.hyperverge.hypersnapsdk.c.k.emitWarningEvent(r0)
            goto L_0x0111
        L_0x00a1:
            java.io.File r11 = new java.io.File
            java.lang.String r0 = com.RNFetchBlob.RNFetchBlobFS.normalizePath(r0)
            r11.<init>(r0)
            long r11 = r11.length()
            long r11 = r11 + r9
            r9 = r11
            goto L_0x0111
        L_0x00b1:
            boolean r0 = r15.startsWith(r12)
            if (r0 == 0) goto L_0x0103
            r0 = 22
            java.lang.String r11 = r15.substring(r0)
            android.content.ContentResolver r0 = r7.getContentResolver()     // Catch:{ Exception -> 0x00d5, all -> 0x00d2 }
            android.net.Uri r12 = android.net.Uri.parse(r11)     // Catch:{ Exception -> 0x00d5, all -> 0x00d2 }
            java.io.InputStream r12 = r0.openInputStream(r12)     // Catch:{ Exception -> 0x00d5, all -> 0x00d2 }
            int r0 = r12.available()     // Catch:{ Exception -> 0x00d0 }
            long r13 = (long) r0
            long r9 = r9 + r13
            goto L_0x00f7
        L_0x00d0:
            r0 = move-exception
            goto L_0x00d7
        L_0x00d2:
            r0 = move-exception
            r2 = 0
            goto L_0x00fd
        L_0x00d5:
            r0 = move-exception
            r12 = 0
        L_0x00d7:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fb }
            r13.<init>()     // Catch:{ all -> 0x00fb }
            java.lang.String r15 = "Failed to estimate form data length from content URI:"
            r13.append(r15)     // Catch:{ all -> 0x00fb }
            r13.append(r11)     // Catch:{ all -> 0x00fb }
            r13.append(r14)     // Catch:{ all -> 0x00fb }
            java.lang.String r0 = r0.getLocalizedMessage()     // Catch:{ all -> 0x00fb }
            r13.append(r0)     // Catch:{ all -> 0x00fb }
            java.lang.String r0 = r13.toString()     // Catch:{ all -> 0x00fb }
            co.hyperverge.hypersnapsdk.c.k.emitWarningEvent(r0)     // Catch:{ all -> 0x00fb }
            if (r12 == 0) goto L_0x0111
        L_0x00f7:
            r12.close()
            goto L_0x0111
        L_0x00fb:
            r0 = move-exception
            r2 = r12
        L_0x00fd:
            if (r2 == 0) goto L_0x0102
            r2.close()
        L_0x0102:
            throw r0
        L_0x0103:
            r0 = 0
            byte[] r0 = android.util.Base64.decode(r15, r0)
            int r0 = r0.length
            goto L_0x010f
        L_0x010a:
            byte[] r0 = r15.getBytes()
            int r0 = r0.length
        L_0x010f:
            long r11 = (long) r0
            long r9 = r9 + r11
        L_0x0111:
            int r8 = r8 + 1
            goto L_0x0030
        L_0x0115:
            r1.contentLength = r9
            com.facebook.react.bridge.ReactApplicationContext r7 = com.RNFetchBlob.RNFetchBlob.RCTContext
            java.util.Iterator r6 = r6.iterator()
        L_0x011d:
            boolean r0 = r6.hasNext()
            java.lang.String r8 = "--"
            if (r0 == 0) goto L_0x0274
            java.lang.Object r0 = r6.next()
            com.RNFetchBlob.RNFetchBlobBody$FormField r0 = (com.RNFetchBlob.RNFetchBlobBody.FormField) r0
            java.lang.String r9 = r0.data
            java.lang.String r10 = r0.name
            if (r10 == 0) goto L_0x011d
            if (r9 != 0) goto L_0x0134
            goto L_0x011d
        L_0x0134:
            java.lang.String r15 = "\r\n"
            java.lang.String r8 = com.android.tools.r8.GeneratedOutlineSupport.outline52(r8, r2, r15)
            r16 = r6
            java.lang.String r6 = r0.filename
            r17 = r3
            java.lang.String r3 = "\r\n\r\n"
            r18 = r2
            java.lang.String r2 = "Content-Type: "
            r19 = r15
            java.lang.String r15 = "\"\r\n"
            r20 = r12
            java.lang.String r12 = "Content-Disposition: form-data; name=\""
            if (r6 == 0) goto L_0x023e
            java.lang.String r6 = "\"; filename=\""
            java.lang.StringBuilder r6 = com.android.tools.r8.GeneratedOutlineSupport.outline81(r8, r12, r10, r6)
            java.lang.String r8 = r0.filename
            java.lang.String r6 = com.android.tools.r8.GeneratedOutlineSupport.outline62(r6, r8, r15)
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline78(r6, r2)
            java.lang.String r0 = r0.mime
            r2.append(r0)
            r2.append(r3)
            java.lang.String r0 = r2.toString()
            byte[] r0 = r0.getBytes()
            r5.write(r0)
            boolean r0 = r9.startsWith(r13)
            if (r0 == 0) goto L_0x01e4
            r0 = 19
            java.lang.String r0 = r9.substring(r0)
            java.lang.String r2 = com.RNFetchBlob.RNFetchBlobFS.normalizePath(r0)
            boolean r0 = com.RNFetchBlob.RNFetchBlobFS.isAsset(r2)
            if (r0 == 0) goto L_0x01af
            java.lang.String r0 = r2.replace(r11, r4)     // Catch:{ IOException -> 0x0199 }
            android.content.res.AssetManager r3 = r7.getAssets()     // Catch:{ IOException -> 0x0199 }
            java.io.InputStream r0 = r3.open(r0)     // Catch:{ IOException -> 0x0199 }
            r1.pipeStreamToFileStream(r0, r5)     // Catch:{ IOException -> 0x0199 }
            goto L_0x01e0
        L_0x0199:
            r0 = move-exception
            java.lang.String r3 = "Failed to create form data asset :"
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline80(r3, r2, r14)
            java.lang.String r0 = r0.getLocalizedMessage()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            co.hyperverge.hypersnapsdk.c.k.emitWarningEvent(r0)
            goto L_0x01e0
        L_0x01af:
            java.io.File r0 = new java.io.File
            java.lang.String r3 = com.RNFetchBlob.RNFetchBlobFS.normalizePath(r2)
            r0.<init>(r3)
            boolean r3 = r0.exists()
            if (r3 == 0) goto L_0x01c7
            java.io.FileInputStream r2 = new java.io.FileInputStream
            r2.<init>(r0)
            r1.pipeStreamToFileStream(r2, r5)
            goto L_0x01e0
        L_0x01c7:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "Failed to create form data from path :"
            r0.append(r3)
            r0.append(r2)
            java.lang.String r2 = ", file not exists."
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            co.hyperverge.hypersnapsdk.c.k.emitWarningEvent(r0)
        L_0x01e0:
            r6 = r20
            goto L_0x0264
        L_0x01e4:
            r6 = r20
            boolean r0 = r9.startsWith(r6)
            if (r0 == 0) goto L_0x0235
            r0 = 22
            java.lang.String r2 = r9.substring(r0)
            android.content.ContentResolver r0 = r7.getContentResolver()     // Catch:{ Exception -> 0x0207, all -> 0x0204 }
            android.net.Uri r3 = android.net.Uri.parse(r2)     // Catch:{ Exception -> 0x0207, all -> 0x0204 }
            java.io.InputStream r3 = r0.openInputStream(r3)     // Catch:{ Exception -> 0x0207, all -> 0x0204 }
            r1.pipeStreamToFileStream(r3, r5)     // Catch:{ Exception -> 0x0202 }
            goto L_0x0229
        L_0x0202:
            r0 = move-exception
            goto L_0x0209
        L_0x0204:
            r0 = move-exception
            r2 = 0
            goto L_0x022f
        L_0x0207:
            r0 = move-exception
            r3 = 0
        L_0x0209:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x022d }
            r8.<init>()     // Catch:{ all -> 0x022d }
            java.lang.String r9 = "Failed to create form data from content URI:"
            r8.append(r9)     // Catch:{ all -> 0x022d }
            r8.append(r2)     // Catch:{ all -> 0x022d }
            r8.append(r14)     // Catch:{ all -> 0x022d }
            java.lang.String r0 = r0.getLocalizedMessage()     // Catch:{ all -> 0x022d }
            r8.append(r0)     // Catch:{ all -> 0x022d }
            java.lang.String r0 = r8.toString()     // Catch:{ all -> 0x022d }
            co.hyperverge.hypersnapsdk.c.k.emitWarningEvent(r0)     // Catch:{ all -> 0x022d }
            if (r3 == 0) goto L_0x0264
        L_0x0229:
            r3.close()
            goto L_0x0264
        L_0x022d:
            r0 = move-exception
            r2 = r3
        L_0x022f:
            if (r2 == 0) goto L_0x0234
            r2.close()
        L_0x0234:
            throw r0
        L_0x0235:
            r0 = 0
            byte[] r0 = android.util.Base64.decode(r9, r0)
            r5.write(r0)
            goto L_0x0264
        L_0x023e:
            r6 = r20
            java.lang.String r8 = com.android.tools.r8.GeneratedOutlineSupport.outline53(r8, r12, r10, r15)
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline78(r8, r2)
            java.lang.String r8 = r0.mime
            r2.append(r8)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            byte[] r2 = r2.getBytes()
            r5.write(r2)
            java.lang.String r0 = r0.data
            byte[] r0 = r0.getBytes()
            r5.write(r0)
        L_0x0264:
            byte[] r0 = r19.getBytes()
            r5.write(r0)
            r12 = r6
            r6 = r16
            r3 = r17
            r2 = r18
            goto L_0x011d
        L_0x0274:
            r18 = r2
            r17 = r3
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r8)
            r0.append(r2)
            java.lang.String r2 = "--\r\n"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            byte[] r0 = r0.getBytes()
            r5.write(r0)
            r5.flush()
            r5.close()
            return r17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.RNFetchBlob.RNFetchBlobBody.createMultipartBodyCache():java.io.File");
    }

    public final InputStream getRequestStream() throws Exception {
        if (this.rawBody.startsWith("RNFetchBlob-file://")) {
            String normalizePath = RNFetchBlobFS.normalizePath(this.rawBody.substring(19));
            if (RNFetchBlobFS.isAsset(normalizePath)) {
                try {
                    return RNFetchBlob.RCTContext.getAssets().open(normalizePath.replace("bundle-assets://", ""));
                } catch (Exception e2) {
                    throw new Exception(GeneratedOutlineSupport.outline38(e2, GeneratedOutlineSupport.outline73("error when getting request stream from asset : ")));
                }
            } else {
                File file = new File(RNFetchBlobFS.normalizePath(normalizePath));
                try {
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    return new FileInputStream(file);
                } catch (Exception e3) {
                    throw new Exception(GeneratedOutlineSupport.outline38(e3, GeneratedOutlineSupport.outline73("error when getting request stream: ")));
                }
            }
        } else if (this.rawBody.startsWith("RNFetchBlob-content://")) {
            String substring = this.rawBody.substring(22);
            try {
                return RNFetchBlob.RCTContext.getContentResolver().openInputStream(Uri.parse(substring));
            } catch (Exception e4) {
                throw new Exception(GeneratedOutlineSupport.outline50("error when getting request stream for content URI: ", substring), e4);
            }
        } else {
            try {
                return new ByteArrayInputStream(Base64.decode(this.rawBody, 0));
            } catch (Exception e5) {
                throw new Exception(GeneratedOutlineSupport.outline38(e5, GeneratedOutlineSupport.outline73("error when getting request stream: ")));
            }
        }
    }

    public final void pipeStreamToFileStream(InputStream inputStream, FileOutputStream fileOutputStream) throws IOException {
        byte[] bArr = new byte[GL20.GL_TEXTURE_MAG_FILTER];
        while (true) {
            int read = inputStream.read(bArr);
            if (read > 0) {
                fileOutputStream.write(bArr, 0, read);
            } else {
                inputStream.close();
                return;
            }
        }
    }

    public final void pipeStreamToSink(InputStream inputStream, BufferedSink bufferedSink) throws IOException {
        RNFetchBlobProgressConfig rNFetchBlobProgressConfig;
        byte[] bArr = new byte[GL20.GL_TEXTURE_MAG_FILTER];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr, 0, GL20.GL_TEXTURE_MAG_FILTER);
            if (read > 0) {
                bufferedSink.write(bArr, 0, read);
                j += (long) read;
                String str = this.mTaskId;
                if (!RNFetchBlobReq.uploadProgressReport.containsKey(str)) {
                    rNFetchBlobProgressConfig = null;
                } else {
                    rNFetchBlobProgressConfig = RNFetchBlobReq.uploadProgressReport.get(str);
                }
                if (rNFetchBlobProgressConfig != null) {
                    long j2 = this.contentLength;
                    if (j2 != 0 && rNFetchBlobProgressConfig.shouldReport(((float) j) / ((float) j2))) {
                        WritableMap createMap = Arguments.createMap();
                        createMap.putString("taskId", this.mTaskId);
                        createMap.putString("written", String.valueOf(j));
                        createMap.putString(ECommerceParamNames.TOTAL, String.valueOf(this.contentLength));
                        ((RCTDeviceEventEmitter) RNFetchBlob.RCTContext.getJSModule(RCTDeviceEventEmitter.class)).emit("RNFetchBlobProgress-upload", createMap);
                    }
                }
            } else {
                inputStream.close();
                return;
            }
        }
    }

    public RNFetchBlobBody setBody(String str) {
        this.rawBody = str;
        if (str == null) {
            this.rawBody = "";
            this.requestType = RequestType.AsIs;
        }
        try {
            int ordinal = this.requestType.ordinal();
            if (ordinal == 1) {
                InputStream requestStream2 = getRequestStream();
                this.requestStream = requestStream2;
                this.contentLength = (long) requestStream2.available();
            } else if (ordinal == 2) {
                this.contentLength = (long) this.rawBody.getBytes().length;
                this.requestStream = new ByteArrayInputStream(this.rawBody.getBytes());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            k.emitWarningEvent("RNFetchBlob failed to create single content request body :" + e2.getLocalizedMessage() + "\r\n");
        }
        return this;
    }

    public void writeTo(BufferedSink bufferedSink) {
        try {
            pipeStreamToSink(this.requestStream, bufferedSink);
        } catch (Exception e2) {
            k.emitWarningEvent(e2.getLocalizedMessage());
            e2.printStackTrace();
        }
    }

    public RNFetchBlobBody setBody(ReadableArray readableArray) {
        this.form = readableArray;
        try {
            this.bodyCache = createMultipartBodyCache();
            this.requestStream = new FileInputStream(this.bodyCache);
            this.contentLength = this.bodyCache.length();
        } catch (Exception e2) {
            e2.printStackTrace();
            k.emitWarningEvent("RNFetchBlob failed to create request multipart body :" + e2.getLocalizedMessage());
        }
        return this;
    }
}
