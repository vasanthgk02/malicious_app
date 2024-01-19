package com.yalantis.ucrop.task;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import com.yalantis.ucrop.UCropActivity;
import com.yalantis.ucrop.UCropActivity.AnonymousClass1;
import com.yalantis.ucrop.callback.BitmapLoadCallback;
import com.yalantis.ucrop.model.ExifInfo;
import com.yalantis.ucrop.view.TransformImageView;
import com.yalantis.ucrop.view.TransformImageView.TransformImageListener;

public class BitmapLoadTask extends AsyncTask<Void, Void, BitmapWorkerResult> {
    public final BitmapLoadCallback mBitmapLoadCallback;
    public final Context mContext;
    public Uri mInputUri;
    public Uri mOutputUri;
    public final int mRequiredHeight;
    public final int mRequiredWidth;

    public static class BitmapWorkerResult {
        public Bitmap mBitmapResult;
        public Exception mBitmapWorkerException;
        public ExifInfo mExifInfo;

        public BitmapWorkerResult(Bitmap bitmap, ExifInfo exifInfo) {
            this.mBitmapResult = bitmap;
            this.mExifInfo = exifInfo;
        }

        public BitmapWorkerResult(Exception exc) {
            this.mBitmapWorkerException = exc;
        }
    }

    public BitmapLoadTask(Context context, Uri uri, Uri uri2, int i, int i2, BitmapLoadCallback bitmapLoadCallback) {
        this.mContext = context;
        this.mInputUri = uri;
        this.mOutputUri = uri2;
        this.mRequiredWidth = i;
        this.mRequiredHeight = i2;
        this.mBitmapLoadCallback = bitmapLoadCallback;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:13|14|15|16|17|19) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x002f */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0048 A[SYNTHETIC, Splitter:B:29:0x0048] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x004d A[SYNTHETIC, Splitter:B:33:0x004d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void copyFile(android.net.Uri r4, android.net.Uri r5) throws java.lang.NullPointerException, java.io.IOException {
        /*
            r3 = this;
            if (r5 == 0) goto L_0x0055
            r0 = 0
            android.content.Context r1 = r3.mContext     // Catch:{ all -> 0x0044 }
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch:{ all -> 0x0044 }
            java.io.InputStream r4 = r1.openInputStream(r4)     // Catch:{ all -> 0x0044 }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ all -> 0x0042 }
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x0042 }
            java.lang.String r5 = r5.getPath()     // Catch:{ all -> 0x0042 }
            r2.<init>(r5)     // Catch:{ all -> 0x0042 }
            r1.<init>(r2)     // Catch:{ all -> 0x0042 }
            if (r4 == 0) goto L_0x003a
            r5 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r5]     // Catch:{ all -> 0x0037 }
        L_0x0021:
            int r0 = r4.read(r5)     // Catch:{ all -> 0x0037 }
            if (r0 <= 0) goto L_0x002c
            r2 = 0
            r1.write(r5, r2, r0)     // Catch:{ all -> 0x0037 }
            goto L_0x0021
        L_0x002c:
            r1.close()     // Catch:{ IOException -> 0x002f }
        L_0x002f:
            r4.close()     // Catch:{ IOException -> 0x0032 }
        L_0x0032:
            android.net.Uri r4 = r3.mOutputUri
            r3.mInputUri = r4
            return
        L_0x0037:
            r5 = move-exception
            r0 = r1
            goto L_0x0046
        L_0x003a:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException     // Catch:{ all -> 0x0037 }
            java.lang.String r0 = "InputStream for given input Uri is null"
            r5.<init>(r0)     // Catch:{ all -> 0x0037 }
            throw r5     // Catch:{ all -> 0x0037 }
        L_0x0042:
            r5 = move-exception
            goto L_0x0046
        L_0x0044:
            r5 = move-exception
            r4 = r0
        L_0x0046:
            if (r0 == 0) goto L_0x004b
            r0.close()     // Catch:{ IOException -> 0x004b }
        L_0x004b:
            if (r4 == 0) goto L_0x0050
            r4.close()     // Catch:{ IOException -> 0x0050 }
        L_0x0050:
            android.net.Uri r4 = r3.mOutputUri
            r3.mInputUri = r4
            throw r5
        L_0x0055:
            java.lang.NullPointerException r4 = new java.lang.NullPointerException
            java.lang.String r5 = "Output Uri is null - cannot copy image"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yalantis.ucrop.task.BitmapLoadTask.copyFile(android.net.Uri, android.net.Uri):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:73:0x010a, code lost:
        if (r6.sameAs(r15) == false) goto L_0x010f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0114  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object doInBackground(java.lang.Object[] r18) {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            java.lang.Void[] r0 = (java.lang.Void[]) r0
            android.net.Uri r0 = r1.mInputUri
            if (r0 != 0) goto L_0x0018
            com.yalantis.ucrop.task.BitmapLoadTask$BitmapWorkerResult r0 = new com.yalantis.ucrop.task.BitmapLoadTask$BitmapWorkerResult
            java.lang.NullPointerException r2 = new java.lang.NullPointerException
            java.lang.String r3 = "Input Uri cannot be null"
            r2.<init>(r3)
            r0.<init>(r2)
            goto L_0x0169
        L_0x0018:
            r17.processInputUri()     // Catch:{ NullPointerException -> 0x0162, IOException -> 0x0160 }
            android.content.Context r0 = r1.mContext     // Catch:{ FileNotFoundException -> 0x0159 }
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch:{ FileNotFoundException -> 0x0159 }
            android.net.Uri r2 = r1.mInputUri     // Catch:{ FileNotFoundException -> 0x0159 }
            java.lang.String r3 = "r"
            android.os.ParcelFileDescriptor r0 = r0.openFileDescriptor(r2, r3)     // Catch:{ FileNotFoundException -> 0x0159 }
            java.lang.String r2 = "]"
            if (r0 == 0) goto L_0x013c
            java.io.FileDescriptor r3 = r0.getFileDescriptor()
            android.graphics.BitmapFactory$Options r4 = new android.graphics.BitmapFactory$Options
            r4.<init>()
            r5 = 1
            r4.inJustDecodeBounds = r5
            r6 = 0
            android.graphics.BitmapFactory.decodeFileDescriptor(r3, r6, r4)
            int r7 = r4.outWidth
            r8 = -1
            if (r7 == r8) goto L_0x011f
            int r9 = r4.outHeight
            if (r9 != r8) goto L_0x0048
            goto L_0x011f
        L_0x0048:
            int r10 = r1.mRequiredWidth
            int r11 = r1.mRequiredHeight
            if (r9 > r11) goto L_0x0053
            if (r7 <= r10) goto L_0x0051
            goto L_0x0053
        L_0x0051:
            r7 = 1
            goto L_0x005f
        L_0x0053:
            r12 = 1
        L_0x0054:
            int r13 = r9 / r12
            if (r13 > r11) goto L_0x011b
            int r13 = r7 / r12
            if (r13 <= r10) goto L_0x005e
            goto L_0x011b
        L_0x005e:
            r7 = r12
        L_0x005f:
            r4.inSampleSize = r7
            r7 = 0
            r4.inJustDecodeBounds = r7
            r9 = 0
            r15 = r6
        L_0x0066:
            r10 = 2
            if (r9 != 0) goto L_0x0076
            android.graphics.Bitmap r15 = android.graphics.BitmapFactory.decodeFileDescriptor(r3, r6, r4)     // Catch:{ OutOfMemoryError -> 0x006f }
            r9 = 1
            goto L_0x0066
        L_0x006f:
            int r10 = r4.inSampleSize
            int r10 = r10 * 2
            r4.inSampleSize = r10
            goto L_0x0066
        L_0x0076:
            if (r15 != 0) goto L_0x0096
            com.yalantis.ucrop.task.BitmapLoadTask$BitmapWorkerResult r0 = new com.yalantis.ucrop.task.BitmapLoadTask$BitmapWorkerResult
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.String r4 = "Bitmap could not be decoded from the Uri: ["
            java.lang.StringBuilder r4 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r4)
            android.net.Uri r5 = r1.mInputUri
            r4.append(r5)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            r3.<init>(r2)
            r0.<init>(r3)
            goto L_0x0169
        L_0x0096:
            r0.close()     // Catch:{ IOException -> 0x0099 }
        L_0x0099:
            android.content.Context r0 = r1.mContext
            android.net.Uri r2 = r1.mInputUri
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch:{ IOException -> 0x00b7 }
            java.io.InputStream r0 = r0.openInputStream(r2)     // Catch:{ IOException -> 0x00b7 }
            if (r0 != 0) goto L_0x00a8
            goto L_0x00ba
        L_0x00a8:
            com.yalantis.ucrop.util.ImageHeaderParser r3 = new com.yalantis.ucrop.util.ImageHeaderParser     // Catch:{ IOException -> 0x00b7 }
            r3.<init>(r0)     // Catch:{ IOException -> 0x00b7 }
            int r2 = r3.getOrientation()     // Catch:{ IOException -> 0x00b7 }
            r0.close()     // Catch:{ IOException -> 0x00b5 }
            goto L_0x00bb
        L_0x00b5:
            goto L_0x00bb
        L_0x00b7:
            r2.toString()
        L_0x00ba:
            r2 = 0
        L_0x00bb:
            switch(r2) {
                case 3: goto L_0x00c5;
                case 4: goto L_0x00c5;
                case 5: goto L_0x00c2;
                case 6: goto L_0x00c2;
                case 7: goto L_0x00bf;
                case 8: goto L_0x00bf;
                default: goto L_0x00be;
            }
        L_0x00be:
            goto L_0x00c7
        L_0x00bf:
            r7 = 270(0x10e, float:3.78E-43)
            goto L_0x00c7
        L_0x00c2:
            r7 = 90
            goto L_0x00c7
        L_0x00c5:
            r7 = 180(0xb4, float:2.52E-43)
        L_0x00c7:
            if (r2 == r10) goto L_0x00d3
            r0 = 7
            if (r2 == r0) goto L_0x00d3
            r0 = 4
            if (r2 == r0) goto L_0x00d3
            r0 = 5
            if (r2 == r0) goto L_0x00d3
            r8 = 1
        L_0x00d3:
            com.yalantis.ucrop.model.ExifInfo r0 = new com.yalantis.ucrop.model.ExifInfo
            r0.<init>(r2, r7, r8)
            android.graphics.Matrix r2 = new android.graphics.Matrix
            r2.<init>()
            if (r7 == 0) goto L_0x00e3
            float r3 = (float) r7
            r2.preRotate(r3)
        L_0x00e3:
            if (r8 == r5) goto L_0x00eb
            float r3 = (float) r8
            r4 = 1065353216(0x3f800000, float:1.0)
            r2.postScale(r3, r4)
        L_0x00eb:
            boolean r3 = r2.isIdentity()
            if (r3 != 0) goto L_0x0114
            com.yalantis.ucrop.task.BitmapLoadTask$BitmapWorkerResult r3 = new com.yalantis.ucrop.task.BitmapLoadTask$BitmapWorkerResult
            r11 = 0
            r12 = 0
            int r13 = r15.getWidth()     // Catch:{ OutOfMemoryError -> 0x010d }
            int r14 = r15.getHeight()     // Catch:{ OutOfMemoryError -> 0x010d }
            r16 = 1
            r10 = r15
            r6 = r15
            r15 = r2
            android.graphics.Bitmap r15 = android.graphics.Bitmap.createBitmap(r10, r11, r12, r13, r14, r15, r16)     // Catch:{ OutOfMemoryError -> 0x010e }
            boolean r2 = r6.sameAs(r15)     // Catch:{ OutOfMemoryError -> 0x010e }
            if (r2 != 0) goto L_0x010e
            goto L_0x010f
        L_0x010d:
            r6 = r15
        L_0x010e:
            r15 = r6
        L_0x010f:
            r3.<init>(r15, r0)
            r0 = r3
            goto L_0x0169
        L_0x0114:
            r6 = r15
            com.yalantis.ucrop.task.BitmapLoadTask$BitmapWorkerResult r2 = new com.yalantis.ucrop.task.BitmapLoadTask$BitmapWorkerResult
            r2.<init>(r6, r0)
            goto L_0x0168
        L_0x011b:
            int r12 = r12 * 2
            goto L_0x0054
        L_0x011f:
            com.yalantis.ucrop.task.BitmapLoadTask$BitmapWorkerResult r0 = new com.yalantis.ucrop.task.BitmapLoadTask$BitmapWorkerResult
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.String r4 = "Bounds for bitmap could not be retrieved from the Uri: ["
            java.lang.StringBuilder r4 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r4)
            android.net.Uri r5 = r1.mInputUri
            r4.append(r5)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            r3.<init>(r2)
            r0.<init>(r3)
            goto L_0x0169
        L_0x013c:
            com.yalantis.ucrop.task.BitmapLoadTask$BitmapWorkerResult r0 = new com.yalantis.ucrop.task.BitmapLoadTask$BitmapWorkerResult
            java.lang.NullPointerException r3 = new java.lang.NullPointerException
            java.lang.String r4 = "ParcelFileDescriptor was null for given Uri: ["
            java.lang.StringBuilder r4 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r4)
            android.net.Uri r5 = r1.mInputUri
            r4.append(r5)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            r3.<init>(r2)
            r0.<init>(r3)
            goto L_0x0169
        L_0x0159:
            r0 = move-exception
            com.yalantis.ucrop.task.BitmapLoadTask$BitmapWorkerResult r2 = new com.yalantis.ucrop.task.BitmapLoadTask$BitmapWorkerResult
            r2.<init>(r0)
            goto L_0x0168
        L_0x0160:
            r0 = move-exception
            goto L_0x0163
        L_0x0162:
            r0 = move-exception
        L_0x0163:
            com.yalantis.ucrop.task.BitmapLoadTask$BitmapWorkerResult r2 = new com.yalantis.ucrop.task.BitmapLoadTask$BitmapWorkerResult
            r2.<init>(r0)
        L_0x0168:
            r0 = r2
        L_0x0169:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yalantis.ucrop.task.BitmapLoadTask.doInBackground(java.lang.Object[]):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0070 A[SYNTHETIC, Splitter:B:34:0x0070] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0075 A[SYNTHETIC, Splitter:B:38:0x0075] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x007a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void downloadFile(android.net.Uri r6, android.net.Uri r7) throws java.lang.NullPointerException, java.io.IOException {
        /*
            r5 = this;
            if (r7 == 0) goto L_0x008f
            okhttp3.OkHttpClient r0 = new okhttp3.OkHttpClient
            r0.<init>()
            r1 = 0
            okhttp3.Request$Builder r2 = new okhttp3.Request$Builder     // Catch:{ all -> 0x006b }
            r2.<init>()     // Catch:{ all -> 0x006b }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x006b }
            okhttp3.Request$Builder r6 = r2.url(r6)     // Catch:{ all -> 0x006b }
            okhttp3.Request r6 = r6.build()     // Catch:{ all -> 0x006b }
            okhttp3.Call r6 = r0.newCall(r6)     // Catch:{ all -> 0x006b }
            okhttp3.Response r6 = com.google.firebase.perf.network.FirebasePerfOkHttpClient.execute(r6)     // Catch:{ all -> 0x006b }
            okhttp3.ResponseBody r2 = r6.body()     // Catch:{ all -> 0x0067 }
            okio.BufferedSource r2 = r2.source()     // Catch:{ all -> 0x0067 }
            android.content.Context r3 = r5.mContext     // Catch:{ all -> 0x0061 }
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch:{ all -> 0x0061 }
            java.io.OutputStream r7 = r3.openOutputStream(r7)     // Catch:{ all -> 0x0061 }
            if (r7 == 0) goto L_0x0059
            okio.Sink r1 = okio.Okio.sink(r7)     // Catch:{ all -> 0x0061 }
            r2.readAll(r1)     // Catch:{ all -> 0x0061 }
            r2.close()     // Catch:{ IOException -> 0x003f }
        L_0x003f:
            if (r1 == 0) goto L_0x0044
            r1.close()     // Catch:{ IOException -> 0x0044 }
        L_0x0044:
            okhttp3.ResponseBody r6 = r6.body()
            if (r6 == 0) goto L_0x004d
            r6.close()     // Catch:{ IOException -> 0x004d }
        L_0x004d:
            okhttp3.Dispatcher r6 = r0.dispatcher()
            r6.cancelAll()
            android.net.Uri r6 = r5.mOutputUri
            r5.mInputUri = r6
            return
        L_0x0059:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException     // Catch:{ all -> 0x0061 }
            java.lang.String r3 = "OutputStream for given output Uri is null"
            r7.<init>(r3)     // Catch:{ all -> 0x0061 }
            throw r7     // Catch:{ all -> 0x0061 }
        L_0x0061:
            r7 = move-exception
            r4 = r2
            r2 = r6
            r6 = r1
            r1 = r4
            goto L_0x006e
        L_0x0067:
            r7 = move-exception
            r2 = r6
            r6 = r1
            goto L_0x006e
        L_0x006b:
            r7 = move-exception
            r6 = r1
            r2 = r6
        L_0x006e:
            if (r1 == 0) goto L_0x0073
            r1.close()     // Catch:{ IOException -> 0x0073 }
        L_0x0073:
            if (r6 == 0) goto L_0x0078
            r6.close()     // Catch:{ IOException -> 0x0078 }
        L_0x0078:
            if (r2 == 0) goto L_0x0083
            okhttp3.ResponseBody r6 = r2.body()
            if (r6 == 0) goto L_0x0083
            r6.close()     // Catch:{ IOException -> 0x0083 }
        L_0x0083:
            okhttp3.Dispatcher r6 = r0.dispatcher()
            r6.cancelAll()
            android.net.Uri r6 = r5.mOutputUri
            r5.mInputUri = r6
            throw r7
        L_0x008f:
            java.lang.NullPointerException r6 = new java.lang.NullPointerException
            java.lang.String r7 = "Output Uri is null - cannot download image"
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yalantis.ucrop.task.BitmapLoadTask.downloadFile(android.net.Uri, android.net.Uri):void");
    }

    public void onPostExecute(Object obj) {
        BitmapWorkerResult bitmapWorkerResult = (BitmapWorkerResult) obj;
        Exception exc = bitmapWorkerResult.mBitmapWorkerException;
        if (exc == null) {
            BitmapLoadCallback bitmapLoadCallback = this.mBitmapLoadCallback;
            Bitmap bitmap = bitmapWorkerResult.mBitmapResult;
            ExifInfo exifInfo = bitmapWorkerResult.mExifInfo;
            String path = this.mInputUri.getPath();
            Uri uri = this.mOutputUri;
            String path2 = uri == null ? null : uri.getPath();
            TransformImageView transformImageView = TransformImageView.this;
            transformImageView.mImageInputPath = path;
            transformImageView.mImageOutputPath = path2;
            transformImageView.mExifInfo = exifInfo;
            transformImageView.mBitmapDecoded = true;
            transformImageView.setImageBitmap(bitmap);
            return;
        }
        TransformImageListener transformImageListener = TransformImageView.this.mTransformImageListener;
        if (transformImageListener != null) {
            AnonymousClass1 r5 = (AnonymousClass1) transformImageListener;
            UCropActivity.this.setResultError(exc);
            UCropActivity.this.finish();
        }
    }

    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: type inference failed for: r2v4, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARNING: type inference failed for: r2v5, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r2v6, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r2v7, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r2v8, types: [android.net.Uri] */
    /* JADX WARNING: type inference failed for: r2v9, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r2v10, types: [android.net.Uri] */
    /* JADX WARNING: type inference failed for: r2v11, types: [android.net.Uri] */
    /* JADX WARNING: type inference failed for: r2v12, types: [android.net.Uri] */
    /* JADX WARNING: type inference failed for: r2v13, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r2v16, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r2v17 */
    /* JADX WARNING: type inference failed for: r2v18 */
    /* JADX WARNING: type inference failed for: r2v19 */
    /* JADX WARNING: type inference failed for: r2v20 */
    /* JADX WARNING: type inference failed for: r2v21 */
    /* JADX WARNING: type inference failed for: r2v22 */
    /* JADX WARNING: type inference failed for: r2v23 */
    /* JADX WARNING: type inference failed for: r2v24 */
    /* JADX WARNING: type inference failed for: r2v25 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r2v3
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], java.lang.String, android.net.Uri]
      uses: [java.lang.CharSequence, java.lang.String, android.net.Uri]
      mth insns count: 112
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void processInputUri() throws java.lang.NullPointerException, java.io.IOException {
        /*
            r8 = this;
            android.net.Uri r0 = r8.mInputUri
            java.lang.String r0 = r0.getScheme()
            java.lang.String r1 = "http"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x0157
            java.lang.String r1 = "https"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0018
            goto L_0x0157
        L_0x0018:
            java.lang.String r1 = "content"
            boolean r2 = r1.equals(r0)
            java.lang.String r3 = "file"
            if (r2 == 0) goto L_0x0144
            android.content.Context r0 = r8.mContext
            java.lang.String r2 = "android.permission.READ_EXTERNAL_STORAGE"
            int r0 = androidx.core.content.ContextCompat.checkSelfPermission(r0, r2)
            r2 = 0
            if (r0 != 0) goto L_0x011b
            android.content.Context r0 = r8.mContext
            android.net.Uri r4 = r8.mInputUri
            r5 = 1
            boolean r6 = android.provider.DocumentsContract.isDocumentUri(r0, r4)
            if (r6 == 0) goto L_0x00ed
            java.lang.String r1 = r4.getAuthority()
            java.lang.String r3 = "com.android.externalstorage.documents"
            boolean r1 = r3.equals(r1)
            java.lang.String r3 = ":"
            r6 = 0
            if (r1 == 0) goto L_0x0075
            java.lang.String r0 = android.provider.DocumentsContract.getDocumentId(r4)
            java.lang.String[] r0 = r0.split(r3)
            r1 = r0[r6]
            java.lang.String r3 = "primary"
            boolean r1 = r3.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x011b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.io.File r2 = android.os.Environment.getExternalStorageDirectory()
            r1.append(r2)
            java.lang.String r2 = "/"
            r1.append(r2)
            r0 = r0[r5]
            r1.append(r0)
            java.lang.String r2 = r1.toString()
            goto L_0x011b
        L_0x0075:
            java.lang.String r1 = r4.getAuthority()
            java.lang.String r7 = "com.android.providers.downloads.documents"
            boolean r1 = r7.equals(r1)
            if (r1 == 0) goto L_0x00a9
            java.lang.String r1 = android.provider.DocumentsContract.getDocumentId(r4)
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 != 0) goto L_0x011b
            java.lang.String r3 = "content://downloads/public_downloads"
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch:{ NumberFormatException -> 0x00a3 }
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ NumberFormatException -> 0x00a3 }
            long r4 = r1.longValue()     // Catch:{ NumberFormatException -> 0x00a3 }
            android.net.Uri r1 = android.content.ContentUris.withAppendedId(r3, r4)     // Catch:{ NumberFormatException -> 0x00a3 }
            java.lang.String r2 = com.twitter.sdk.android.tweetui.TweetUtils.getDataColumn(r0, r1, r2, r2)     // Catch:{ NumberFormatException -> 0x00a3 }
            goto L_0x011b
        L_0x00a3:
            r0 = move-exception
            r0.getMessage()
            goto L_0x011b
        L_0x00a9:
            java.lang.String r1 = r4.getAuthority()
            java.lang.String r7 = "com.android.providers.media.documents"
            boolean r1 = r7.equals(r1)
            if (r1 == 0) goto L_0x011b
            java.lang.String r1 = android.provider.DocumentsContract.getDocumentId(r4)
            java.lang.String[] r1 = r1.split(r3)
            r3 = r1[r6]
            java.lang.String r4 = "image"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x00ca
            android.net.Uri r2 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            goto L_0x00e0
        L_0x00ca:
            java.lang.String r4 = "video"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x00d6
            android.net.Uri r2 = android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI
            goto L_0x00e0
        L_0x00d6:
            java.lang.String r4 = "audio"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x00e0
            android.net.Uri r2 = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
        L_0x00e0:
            java.lang.String[] r3 = new java.lang.String[r5]
            r1 = r1[r5]
            r3[r6] = r1
            java.lang.String r1 = "_id=?"
            java.lang.String r2 = com.twitter.sdk.android.tweetui.TweetUtils.getDataColumn(r0, r2, r1, r3)
            goto L_0x011b
        L_0x00ed:
            java.lang.String r5 = r4.getScheme()
            boolean r1 = r1.equalsIgnoreCase(r5)
            if (r1 == 0) goto L_0x010d
            java.lang.String r1 = r4.getAuthority()
            java.lang.String r3 = "com.google.android.apps.photos.content"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x0108
            java.lang.String r2 = r4.getLastPathSegment()
            goto L_0x011b
        L_0x0108:
            java.lang.String r2 = com.twitter.sdk.android.tweetui.TweetUtils.getDataColumn(r0, r4, r2, r2)
            goto L_0x011b
        L_0x010d:
            java.lang.String r0 = r4.getScheme()
            boolean r0 = r3.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x011b
            java.lang.String r2 = r4.getPath()
        L_0x011b:
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 != 0) goto L_0x0138
            java.io.File r0 = new java.io.File
            r0.<init>(r2)
            boolean r0 = r0.exists()
            if (r0 == 0) goto L_0x0138
            java.io.File r0 = new java.io.File
            r0.<init>(r2)
            android.net.Uri r0 = android.net.Uri.fromFile(r0)
            r8.mInputUri = r0
            goto L_0x015e
        L_0x0138:
            android.net.Uri r0 = r8.mInputUri     // Catch:{ NullPointerException -> 0x0142, IOException -> 0x0140 }
            android.net.Uri r1 = r8.mOutputUri     // Catch:{ NullPointerException -> 0x0142, IOException -> 0x0140 }
            r8.copyFile(r0, r1)     // Catch:{ NullPointerException -> 0x0142, IOException -> 0x0140 }
            goto L_0x015e
        L_0x0140:
            r0 = move-exception
            goto L_0x0143
        L_0x0142:
            r0 = move-exception
        L_0x0143:
            throw r0
        L_0x0144:
            boolean r1 = r3.equals(r0)
            if (r1 == 0) goto L_0x014b
            goto L_0x015e
        L_0x014b:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Invalid Uri scheme"
            java.lang.String r0 = com.android.tools.r8.GeneratedOutlineSupport.outline50(r2, r0)
            r1.<init>(r0)
            throw r1
        L_0x0157:
            android.net.Uri r0 = r8.mInputUri     // Catch:{ NullPointerException -> 0x0161, IOException -> 0x015f }
            android.net.Uri r1 = r8.mOutputUri     // Catch:{ NullPointerException -> 0x0161, IOException -> 0x015f }
            r8.downloadFile(r0, r1)     // Catch:{ NullPointerException -> 0x0161, IOException -> 0x015f }
        L_0x015e:
            return
        L_0x015f:
            r0 = move-exception
            goto L_0x0162
        L_0x0161:
            r0 = move-exception
        L_0x0162:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yalantis.ucrop.task.BitmapLoadTask.processInputUri():void");
    }
}
