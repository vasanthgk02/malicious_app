package com.netcore.android.mediadownloader;

import android.content.Context;
import android.graphics.Bitmap;
import com.netcore.android.logger.SMTLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0019\u0010\f\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000eR\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0004R\u0016\u0010\u0012\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\nR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0004R\u0019\u0010\u0015\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\u0018\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/netcore/android/mediadownloader/SMTImageDownloader;", "", "", "download", "()Ljava/lang/String;", "Landroid/graphics/Bitmap;", "downloadBitmap", "()Landroid/graphics/Bitmap;", "", "defaultImageWidth", "I", "", "isForInbox", "Z", "()Z", "TAG", "Ljava/lang/String;", "getTAG", "defaultImageHeight", "url", "getUrl", "type", "getType", "Landroid/content/Context;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)V", "smartech_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: SMTImageDownloader.kt */
public final class SMTImageDownloader {
    public final String TAG;
    public final Context context;
    public int defaultImageHeight;
    public int defaultImageWidth;
    public final boolean isForInbox;
    public final String type;
    public final String url;

    public SMTImageDownloader(Context context2, String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(str2, "type");
        this.context = context2;
        this.url = str;
        this.type = str2;
        this.isForInbox = z;
        String simpleName = SMTImageDownloader.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "SMTImageDownloader::class.java.simpleName");
        this.TAG = simpleName;
        this.defaultImageWidth = 500;
        this.defaultImageHeight = 250;
    }

    public final String download() {
        SMTLogger.INSTANCE.d(this.TAG, "Image downloading called");
        if (this.url != null) {
            Bitmap downloadBitmap = downloadBitmap();
            if (downloadBitmap != null) {
                SMTDownloaderUtility sMTDownloaderUtility = SMTDownloaderUtility.INSTANCE;
                int calculateInSampleSize = sMTDownloaderUtility.calculateInSampleSize(downloadBitmap.getWidth(), downloadBitmap.getHeight(), this.defaultImageWidth, this.defaultImageHeight);
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(downloadBitmap, downloadBitmap.getWidth() / calculateInSampleSize, downloadBitmap.getHeight() / calculateInSampleSize, false);
                Intrinsics.checkNotNullExpressionValue(createScaledBitmap, "scaledBitmap");
                return sMTDownloaderUtility.saveBitmapToInternalStorage(createScaledBitmap, sMTDownloaderUtility.getDownloadFile(this.context, this.url, this.type, this.isForInbox));
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x00dd A[SYNTHETIC, Splitter:B:48:0x00dd] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00e5 A[Catch:{ Exception -> 0x00e1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00fc A[SYNTHETIC, Splitter:B:57:0x00fc] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0104 A[Catch:{ Exception -> 0x0100 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.Bitmap downloadBitmap() {
        /*
            r15 = this;
            java.lang.String r0 = r15.url
            r1 = 0
            if (r0 == 0) goto L_0x0118
            java.net.URL r0 = new java.net.URL     // Catch:{ Exception -> 0x00bc, all -> 0x00b7 }
            java.lang.String r2 = r15.url     // Catch:{ Exception -> 0x00bc, all -> 0x00b7 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x00bc, all -> 0x00b7 }
            java.net.URLConnection r0 = r0.openConnection()     // Catch:{ Exception -> 0x00bc, all -> 0x00b7 }
            java.lang.Object r0 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r0)     // Catch:{ Exception -> 0x00bc, all -> 0x00b7 }
            java.net.URLConnection r0 = (java.net.URLConnection) r0     // Catch:{ Exception -> 0x00bc, all -> 0x00b7 }
            if (r0 == 0) goto L_0x00af
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ Exception -> 0x00bc, all -> 0x00b7 }
            r2 = 1
            r0.setDoInput(r2)     // Catch:{ Exception -> 0x00ac, all -> 0x00a7 }
            r0.connect()     // Catch:{ Exception -> 0x00ac, all -> 0x00a7 }
            java.io.InputStream r2 = r0.getInputStream()     // Catch:{ Exception -> 0x00ac, all -> 0x00a7 }
            int r3 = r0.getContentLength()     // Catch:{ Exception -> 0x00a5 }
            com.netcore.android.logger.SMTLogger r4 = com.netcore.android.logger.SMTLogger.INSTANCE     // Catch:{ Exception -> 0x00a5 }
            java.lang.String r5 = r15.TAG     // Catch:{ Exception -> 0x00a5 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a5 }
            r6.<init>()     // Catch:{ Exception -> 0x00a5 }
            java.lang.String r7 = "Image content length "
            r6.append(r7)     // Catch:{ Exception -> 0x00a5 }
            r6.append(r3)     // Catch:{ Exception -> 0x00a5 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x00a5 }
            r4.i(r5, r6)     // Catch:{ Exception -> 0x00a5 }
            java.io.BufferedInputStream r4 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x00a5 }
            r4.<init>(r2, r3)     // Catch:{ Exception -> 0x00a5 }
            java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x00a5 }
            r5.<init>()     // Catch:{ Exception -> 0x00a5 }
            byte[] r6 = new byte[r3]     // Catch:{ Exception -> 0x00a5 }
            r7 = 0
        L_0x004f:
            int r9 = r4.read(r6)     // Catch:{ Exception -> 0x00a5 }
            r10 = -1
            r11 = 0
            if (r9 == r10) goto L_0x005d
            long r12 = (long) r9     // Catch:{ Exception -> 0x00a5 }
            long r7 = r7 + r12
            r5.write(r6, r11, r9)     // Catch:{ Exception -> 0x00a5 }
            goto L_0x004f
        L_0x005d:
            if (r3 == 0) goto L_0x008b
            long r3 = (long) r3     // Catch:{ Exception -> 0x00a5 }
            int r6 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r6 >= 0) goto L_0x0065
            goto L_0x008b
        L_0x0065:
            byte[] r3 = r5.toByteArray()     // Catch:{ Exception -> 0x00a5 }
            int r4 = r5.size()     // Catch:{ Exception -> 0x00a5 }
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeByteArray(r3, r11, r4)     // Catch:{ Exception -> 0x00a5 }
            r0.disconnect()     // Catch:{ Exception -> 0x007a }
            if (r2 == 0) goto L_0x008a
            r2.close()     // Catch:{ Exception -> 0x007a }
            goto L_0x008a
        L_0x007a:
            r0 = move-exception
            com.netcore.android.logger.SMTLogger r2 = com.netcore.android.logger.SMTLogger.INSTANCE
            java.lang.String r3 = r15.TAG
            java.lang.String r0 = r0.getMessage()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r2.e(r3, r0)
        L_0x008a:
            return r1
        L_0x008b:
            r0.disconnect()     // Catch:{ Exception -> 0x0094 }
            if (r2 == 0) goto L_0x00a4
            r2.close()     // Catch:{ Exception -> 0x0094 }
            goto L_0x00a4
        L_0x0094:
            r0 = move-exception
            com.netcore.android.logger.SMTLogger r2 = com.netcore.android.logger.SMTLogger.INSTANCE
            java.lang.String r3 = r15.TAG
            java.lang.String r0 = r0.getMessage()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r2.e(r3, r0)
        L_0x00a4:
            return r1
        L_0x00a5:
            r3 = move-exception
            goto L_0x00bf
        L_0x00a7:
            r2 = move-exception
            r14 = r2
            r2 = r1
            r1 = r14
            goto L_0x00fa
        L_0x00ac:
            r3 = move-exception
            r2 = r1
            goto L_0x00bf
        L_0x00af:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException     // Catch:{ Exception -> 0x00bc, all -> 0x00b7 }
            java.lang.String r2 = "null cannot be cast to non-null type java.net.HttpURLConnection"
            r0.<init>(r2)     // Catch:{ Exception -> 0x00bc, all -> 0x00b7 }
            throw r0     // Catch:{ Exception -> 0x00bc, all -> 0x00b7 }
        L_0x00b7:
            r0 = move-exception
            r2 = r1
            r1 = r0
            r0 = r2
            goto L_0x00fa
        L_0x00bc:
            r3 = move-exception
            r0 = r1
            r2 = r0
        L_0x00bf:
            com.netcore.android.logger.SMTLogger r4 = com.netcore.android.logger.SMTLogger.INSTANCE     // Catch:{ all -> 0x00f9 }
            java.lang.String r5 = r15.TAG     // Catch:{ all -> 0x00f9 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f9 }
            r6.<init>()     // Catch:{ all -> 0x00f9 }
            java.lang.String r7 = "Image downloading failed "
            r6.append(r7)     // Catch:{ all -> 0x00f9 }
            java.lang.String r3 = r3.getLocalizedMessage()     // Catch:{ all -> 0x00f9 }
            r6.append(r3)     // Catch:{ all -> 0x00f9 }
            java.lang.String r3 = r6.toString()     // Catch:{ all -> 0x00f9 }
            r4.e(r5, r3)     // Catch:{ all -> 0x00f9 }
            if (r0 == 0) goto L_0x00e3
            r0.disconnect()     // Catch:{ Exception -> 0x00e1 }
            goto L_0x00e3
        L_0x00e1:
            r0 = move-exception
            goto L_0x00e9
        L_0x00e3:
            if (r2 == 0) goto L_0x0118
            r2.close()     // Catch:{ Exception -> 0x00e1 }
            goto L_0x0118
        L_0x00e9:
            com.netcore.android.logger.SMTLogger r2 = com.netcore.android.logger.SMTLogger.INSTANCE
            java.lang.String r3 = r15.TAG
            java.lang.String r0 = r0.getMessage()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r2.e(r3, r0)
            goto L_0x0118
        L_0x00f9:
            r1 = move-exception
        L_0x00fa:
            if (r0 == 0) goto L_0x0102
            r0.disconnect()     // Catch:{ Exception -> 0x0100 }
            goto L_0x0102
        L_0x0100:
            r0 = move-exception
            goto L_0x0108
        L_0x0102:
            if (r2 == 0) goto L_0x0117
            r2.close()     // Catch:{ Exception -> 0x0100 }
            goto L_0x0117
        L_0x0108:
            com.netcore.android.logger.SMTLogger r2 = com.netcore.android.logger.SMTLogger.INSTANCE
            java.lang.String r3 = r15.TAG
            java.lang.String r0 = r0.getMessage()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r2.e(r3, r0)
        L_0x0117:
            throw r1
        L_0x0118:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netcore.android.mediadownloader.SMTImageDownloader.downloadBitmap():android.graphics.Bitmap");
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getTAG() {
        return this.TAG;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }

    public final boolean isForInbox() {
        return this.isForInbox;
    }

    public /* synthetic */ SMTImageDownloader(Context context2, String str, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context2, str, str2, (i & 8) != 0 ? false : z);
    }
}
