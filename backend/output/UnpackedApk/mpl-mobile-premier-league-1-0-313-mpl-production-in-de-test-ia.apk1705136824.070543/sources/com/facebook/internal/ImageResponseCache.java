package com.facebook.internal;

import android.net.Uri;
import com.facebook.LoggingBehavior;
import com.facebook.internal.FileLruCache.Limits;
import com.facebook.internal.Logger.Companion;
import com.userexperior.models.recording.enums.UeCustomType;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\f\u001a\u00020\tH\u0007J\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/facebook/internal/ImageResponseCache;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "imageCache", "Lcom/facebook/internal/FileLruCache;", "clearCache", "", "getCache", "getCachedImageStream", "Ljava/io/InputStream;", "uri", "Landroid/net/Uri;", "interceptAndCacheImageStream", "connection", "Ljava/net/HttpURLConnection;", "isCDNURL", "", "BufferedHttpInputStream", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ImageResponseCache.kt */
public final class ImageResponseCache {
    public static FileLruCache imageCache;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/facebook/internal/ImageResponseCache$BufferedHttpInputStream;", "Ljava/io/BufferedInputStream;", "stream", "Ljava/io/InputStream;", "connection", "Ljava/net/HttpURLConnection;", "(Ljava/io/InputStream;Ljava/net/HttpURLConnection;)V", "getConnection", "()Ljava/net/HttpURLConnection;", "setConnection", "(Ljava/net/HttpURLConnection;)V", "close", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ImageResponseCache.kt */
    public static final class BufferedHttpInputStream extends BufferedInputStream {
        public HttpURLConnection connection;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public BufferedHttpInputStream(InputStream inputStream, HttpURLConnection httpURLConnection) {
            // Intrinsics.checkNotNullParameter(httpURLConnection, "connection");
            super(inputStream, 8192);
            this.connection = httpURLConnection;
        }

        public void close() throws IOException {
            super.close();
            Utility.disconnectQuietly(this.connection);
        }
    }

    public static final synchronized FileLruCache getCache() throws IOException {
        FileLruCache fileLruCache;
        synchronized (ImageResponseCache.class) {
            if (imageCache == null) {
                Intrinsics.checkNotNullExpressionValue("ImageResponseCache", UeCustomType.TAG);
                imageCache = new FileLruCache("ImageResponseCache", new Limits());
            }
            fileLruCache = imageCache;
            if (fileLruCache == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageCache");
                throw null;
            }
        }
        return fileLruCache;
    }

    public static final InputStream getCachedImageStream(Uri uri) {
        if (uri == null) {
            return null;
        }
        boolean z = false;
        String host = uri.getHost();
        if (host != null && (Intrinsics.areEqual(host, "fbcdn.net") || CharsKt__CharKt.endsWith$default(host, (String) ".fbcdn.net", false, 2) || (CharsKt__CharKt.startsWith$default(host, (String) "fbcdn", false, 2) && CharsKt__CharKt.endsWith$default(host, (String) ".akamaihd.net", false, 2)))) {
            z = true;
        }
        if (!z) {
            return null;
        }
        try {
            FileLruCache cache = getCache();
            String uri2 = uri.toString();
            Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
            return FileLruCache.get$default(cache, uri2, null, 2);
        } catch (IOException e2) {
            Companion companion = Logger.Companion;
            LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
            Intrinsics.checkNotNullExpressionValue("ImageResponseCache", UeCustomType.TAG);
            companion.log(loggingBehavior, 5, (String) "ImageResponseCache", e2.toString());
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0047, code lost:
        if (kotlin.text.CharsKt__CharKt.endsWith$default(r4, (java.lang.String) ".akamaihd.net", false, 2) != false) goto L_0x0049;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.io.InputStream interceptAndCacheImageStream(java.net.HttpURLConnection r7) throws java.io.IOException {
        /*
            java.lang.String r0 = "connection"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            int r0 = r7.getResponseCode()
            r1 = 0
            r2 = 200(0xc8, float:2.8E-43)
            if (r0 != r2) goto L_0x0073
            java.net.URL r0 = r7.getURL()
            java.lang.String r0 = r0.toString()
            android.net.Uri r0 = android.net.Uri.parse(r0)
            java.io.InputStream r2 = r7.getInputStream()
            r3 = 0
            if (r0 == 0) goto L_0x004a
            java.lang.String r4 = r0.getHost()     // Catch:{ IOException -> 0x0072 }
            if (r4 == 0) goto L_0x004a
            java.lang.String r5 = "fbcdn.net"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)     // Catch:{ IOException -> 0x0072 }
            if (r5 != 0) goto L_0x0049
            java.lang.String r5 = ".fbcdn.net"
            r6 = 2
            boolean r5 = kotlin.text.CharsKt__CharKt.endsWith$default(r4, r5, r3, r6)     // Catch:{ IOException -> 0x0072 }
            if (r5 == 0) goto L_0x0039
            goto L_0x0049
        L_0x0039:
            java.lang.String r5 = "fbcdn"
            boolean r5 = kotlin.text.CharsKt__CharKt.startsWith$default(r4, r5, r3, r6)     // Catch:{ IOException -> 0x0072 }
            if (r5 == 0) goto L_0x004a
            java.lang.String r5 = ".akamaihd.net"
            boolean r4 = kotlin.text.CharsKt__CharKt.endsWith$default(r4, r5, r3, r6)     // Catch:{ IOException -> 0x0072 }
            if (r4 == 0) goto L_0x004a
        L_0x0049:
            r3 = 1
        L_0x004a:
            if (r3 == 0) goto L_0x0072
            com.facebook.internal.FileLruCache r3 = getCache()     // Catch:{ IOException -> 0x0072 }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x0072 }
            java.lang.String r4 = "uri.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)     // Catch:{ IOException -> 0x0072 }
            com.facebook.internal.ImageResponseCache$BufferedHttpInputStream r4 = new com.facebook.internal.ImageResponseCache$BufferedHttpInputStream     // Catch:{ IOException -> 0x0072 }
            r4.<init>(r2, r7)     // Catch:{ IOException -> 0x0072 }
            java.lang.String r7 = "key"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r7)     // Catch:{ IOException -> 0x0072 }
            java.lang.String r7 = "input"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r7)     // Catch:{ IOException -> 0x0072 }
            java.io.OutputStream r7 = r3.openPutStream(r0, r1)     // Catch:{ IOException -> 0x0072 }
            com.facebook.internal.FileLruCache$CopyingInputStream r1 = new com.facebook.internal.FileLruCache$CopyingInputStream     // Catch:{ IOException -> 0x0072 }
            r1.<init>(r4, r7)     // Catch:{ IOException -> 0x0072 }
            goto L_0x0073
        L_0x0072:
            r1 = r2
        L_0x0073:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.ImageResponseCache.interceptAndCacheImageStream(java.net.HttpURLConnection):java.io.InputStream");
    }
}
