package com.facebook.internal;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.facebook.internal.ImageRequest.Callback;
import com.facebook.internal.WorkQueue.WorkItem;
import com.facebook.internal.WorkQueue.WorkNode;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import in.juspay.hypersdk.mystique.AnimationHolder.InlineAnimation;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004-./0B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\b\u0010\u0015\u001a\u00020\u0016H\u0007J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u000fH\u0002J\u0012\u0010\u0019\u001a\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0007J \u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u0012H\u0002J\u0018\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u000fH\u0002J(\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0014\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\"H\u0007J2\u0010#\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u000f2\u000e\u0010$\u001a\n\u0018\u00010%j\u0004\u0018\u0001`&2\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020\u0012H\u0002J\u0010\u0010*\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u0018\u0010+\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u0012H\u0002J\u0012\u0010,\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0018\u001a\u00020\u000fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eX\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/facebook/internal/ImageDownloader;", "", "()V", "CACHE_READ_QUEUE_MAX_CONCURRENT", "", "DOWNLOAD_QUEUE_MAX_CONCURRENT", "cacheReadQueue", "Lcom/facebook/internal/WorkQueue;", "downloadQueue", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "pendingRequests", "", "Lcom/facebook/internal/ImageDownloader$RequestKey;", "Lcom/facebook/internal/ImageDownloader$DownloaderContext;", "cancelRequest", "", "request", "Lcom/facebook/internal/ImageRequest;", "clearCache", "", "download", "key", "downloadAsync", "enqueueCacheRead", "allowCachedRedirects", "enqueueDownload", "enqueueRequest", "workQueue", "workItem", "Ljava/lang/Runnable;", "getPendingRequests", "", "issueResponse", "error", "Ljava/lang/Exception;", "Lkotlin/Exception;", "bitmap", "Landroid/graphics/Bitmap;", "isCachedRedirect", "prioritizeRequest", "readFromCache", "removePendingRequest", "CacheReadWorkItem", "DownloadImageWorkItem", "DownloaderContext", "RequestKey", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ImageDownloader.kt */
public final class ImageDownloader {
    public static final ImageDownloader INSTANCE = new ImageDownloader();
    public static final WorkQueue cacheReadQueue = new WorkQueue(2, null, 2);
    public static final WorkQueue downloadQueue = new WorkQueue(8, null, 2);
    public static Handler handler;
    public static final Map<RequestKey, DownloaderContext> pendingRequests = new HashMap();

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/facebook/internal/ImageDownloader$CacheReadWorkItem;", "Ljava/lang/Runnable;", "key", "Lcom/facebook/internal/ImageDownloader$RequestKey;", "allowCachedRedirects", "", "(Lcom/facebook/internal/ImageDownloader$RequestKey;Z)V", "run", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ImageDownloader.kt */
    public static final class CacheReadWorkItem implements Runnable {
        public final boolean allowCachedRedirects;
        public final RequestKey key;

        public CacheReadWorkItem(RequestKey requestKey, boolean z) {
            Intrinsics.checkNotNullParameter(requestKey, "key");
            this.key = requestKey;
            this.allowCachedRedirects = z;
        }

        public void run() {
            if (!CrashShieldHandler.isObjectCrashing(this)) {
                try {
                    ImageDownloader.access$readFromCache(ImageDownloader.INSTANCE, this.key, this.allowCachedRedirects);
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, this);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/facebook/internal/ImageDownloader$DownloadImageWorkItem;", "Ljava/lang/Runnable;", "key", "Lcom/facebook/internal/ImageDownloader$RequestKey;", "(Lcom/facebook/internal/ImageDownloader$RequestKey;)V", "run", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ImageDownloader.kt */
    public static final class DownloadImageWorkItem implements Runnable {
        public final RequestKey key;

        public DownloadImageWorkItem(RequestKey requestKey) {
            Intrinsics.checkNotNullParameter(requestKey, "key");
            this.key = requestKey;
        }

        public void run() {
            if (!CrashShieldHandler.isObjectCrashing(this)) {
                try {
                    ImageDownloader.access$download(ImageDownloader.INSTANCE, this.key);
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, this);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\u0004R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/facebook/internal/ImageDownloader$DownloaderContext;", "", "request", "Lcom/facebook/internal/ImageRequest;", "(Lcom/facebook/internal/ImageRequest;)V", "isCancelled", "", "()Z", "setCancelled", "(Z)V", "getRequest", "()Lcom/facebook/internal/ImageRequest;", "setRequest", "workItem", "Lcom/facebook/internal/WorkQueue$WorkItem;", "getWorkItem", "()Lcom/facebook/internal/WorkQueue$WorkItem;", "setWorkItem", "(Lcom/facebook/internal/WorkQueue$WorkItem;)V", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ImageDownloader.kt */
    public static final class DownloaderContext {
        public boolean isCancelled;
        public ImageRequest request;
        public WorkItem workItem;

        public DownloaderContext(ImageRequest imageRequest) {
            Intrinsics.checkNotNullParameter(imageRequest, "request");
            this.request = imageRequest;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0002\u0010\u0005J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u001a\u0010\u0004\u001a\u00020\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/facebook/internal/ImageDownloader$RequestKey;", "", "uri", "Landroid/net/Uri;", "tag", "(Landroid/net/Uri;Ljava/lang/Object;)V", "getTag", "()Ljava/lang/Object;", "setTag", "(Ljava/lang/Object;)V", "getUri", "()Landroid/net/Uri;", "setUri", "(Landroid/net/Uri;)V", "equals", "", "o", "hashCode", "", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ImageDownloader.kt */
    public static final class RequestKey {
        public Object tag;
        public Uri uri;

        public RequestKey(Uri uri2, Object obj) {
            Intrinsics.checkNotNullParameter(uri2, "uri");
            Intrinsics.checkNotNullParameter(obj, InlineAnimation.TAG);
            this.uri = uri2;
            this.tag = obj;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof RequestKey)) {
                return false;
            }
            RequestKey requestKey = (RequestKey) obj;
            if (requestKey.uri == this.uri && requestKey.tag == this.tag) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.tag.hashCode() + ((this.uri.hashCode() + 1073) * 37);
        }
    }

    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v1, types: [android.graphics.Bitmap] */
    /* JADX WARNING: type inference failed for: r4v0, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r4v1 */
    /* JADX WARNING: type inference failed for: r4v2 */
    /* JADX WARNING: type inference failed for: r2v2, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r4v5 */
    /* JADX WARNING: type inference failed for: r4v7 */
    /* JADX WARNING: type inference failed for: r4v8 */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: type inference failed for: r5v3 */
    /* JADX WARNING: type inference failed for: r2v4, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: type inference failed for: r5v4 */
    /* JADX WARNING: type inference failed for: r4v9 */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: type inference failed for: r4v10, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r5v5, types: [android.graphics.Bitmap] */
    /* JADX WARNING: type inference failed for: r4v12 */
    /* JADX WARNING: type inference failed for: r5v8 */
    /* JADX WARNING: type inference failed for: r4v18, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r5v14 */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: type inference failed for: r2v9 */
    /* JADX WARNING: type inference failed for: r2v10 */
    /* JADX WARNING: type inference failed for: r4v19 */
    /* JADX WARNING: type inference failed for: r4v20 */
    /* JADX WARNING: type inference failed for: r5v15 */
    /* JADX WARNING: type inference failed for: r4v21 */
    /* JADX WARNING: type inference failed for: r4v22 */
    /* JADX WARNING: type inference failed for: r4v23 */
    /* JADX WARNING: type inference failed for: r5v16 */
    /* JADX WARNING: type inference failed for: r4v24 */
    /* JADX WARNING: type inference failed for: r4v25 */
    /* JADX WARNING: type inference failed for: r4v26 */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00ba, code lost:
        r10 = th;
        r2 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00bc, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00bd, code lost:
        r4 = 0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r4v1
      assigns: []
      uses: []
      mth insns count: 103
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ba A[ExcHandler: all (th java.lang.Throwable), Splitter:B:5:0x001c] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 14 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void access$download(com.facebook.internal.ImageDownloader r10, com.facebook.internal.ImageDownloader.RequestKey r11) {
        /*
            r0 = 1
            r1 = 0
            r2 = 0
            java.net.URL r3 = new java.net.URL     // Catch:{ IOException -> 0x00d0, all -> 0x00c7 }
            android.net.Uri r4 = r11.uri     // Catch:{ IOException -> 0x00d0, all -> 0x00c7 }
            java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x00d0, all -> 0x00c7 }
            r3.<init>(r4)     // Catch:{ IOException -> 0x00d0, all -> 0x00c7 }
            java.net.URLConnection r3 = r3.openConnection()     // Catch:{ IOException -> 0x00d0, all -> 0x00c7 }
            java.lang.Object r3 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r3)     // Catch:{ IOException -> 0x00d0, all -> 0x00c7 }
            java.net.URLConnection r3 = (java.net.URLConnection) r3     // Catch:{ IOException -> 0x00d0, all -> 0x00c7 }
            if (r3 == 0) goto L_0x00bf
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch:{ IOException -> 0x00d0, all -> 0x00c7 }
            r3.setInstanceFollowRedirects(r1)     // Catch:{ IOException -> 0x00bc, all -> 0x00ba }
            int r4 = r3.getResponseCode()     // Catch:{ IOException -> 0x00bc, all -> 0x00ba }
            r5 = 200(0xc8, float:2.8E-43)
            if (r4 == r5) goto L_0x00a3
            r5 = 301(0x12d, float:4.22E-43)
            if (r4 == r5) goto L_0x0061
            r5 = 302(0x12e, float:4.23E-43)
            if (r4 == r5) goto L_0x0061
            java.io.InputStream r4 = r3.getErrorStream()     // Catch:{ IOException -> 0x00bc, all -> 0x00ba }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00b8, all -> 0x00b5 }
            r5.<init>()     // Catch:{ IOException -> 0x00b8, all -> 0x00b5 }
            if (r4 == 0) goto L_0x0051
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00b8, all -> 0x00b5 }
            r6.<init>(r4)     // Catch:{ IOException -> 0x00b8, all -> 0x00b5 }
            r7 = 128(0x80, float:1.8E-43)
            char[] r8 = new char[r7]     // Catch:{ IOException -> 0x00b8, all -> 0x00b5 }
        L_0x0043:
            int r9 = r6.read(r8, r1, r7)     // Catch:{ IOException -> 0x00b8, all -> 0x00b5 }
            if (r9 <= 0) goto L_0x004d
            r5.append(r8, r1, r9)     // Catch:{ IOException -> 0x00b8, all -> 0x00b5 }
            goto L_0x0043
        L_0x004d:
            com.facebook.internal.Utility.closeQuietly(r6)     // Catch:{ IOException -> 0x00b8, all -> 0x00b5 }
            goto L_0x0056
        L_0x0051:
            java.lang.String r6 = "Unexpected error while downloading an image."
            r5.append(r6)     // Catch:{ IOException -> 0x00b8, all -> 0x00b5 }
        L_0x0056:
            com.facebook.FacebookException r6 = new com.facebook.FacebookException     // Catch:{ IOException -> 0x00b8, all -> 0x00b5 }
            java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x00b8, all -> 0x00b5 }
            r6.<init>(r5)     // Catch:{ IOException -> 0x00b8, all -> 0x00b5 }
            r5 = r2
            goto L_0x00ac
        L_0x0061:
            java.lang.String r0 = "location"
            java.lang.String r0 = r3.getHeaderField(r0)     // Catch:{ IOException -> 0x009e, all -> 0x00ba }
            boolean r4 = com.facebook.internal.Utility.isNullOrEmpty(r0)     // Catch:{ IOException -> 0x009e, all -> 0x00ba }
            if (r4 != 0) goto L_0x009a
            android.net.Uri r0 = android.net.Uri.parse(r0)     // Catch:{ IOException -> 0x009e, all -> 0x00ba }
            com.facebook.internal.UrlRedirectCache r4 = com.facebook.internal.UrlRedirectCache.INSTANCE     // Catch:{ IOException -> 0x009e, all -> 0x00ba }
            android.net.Uri r4 = r11.uri     // Catch:{ IOException -> 0x009e, all -> 0x00ba }
            com.facebook.internal.UrlRedirectCache.cacheUriRedirect(r4, r0)     // Catch:{ IOException -> 0x009e, all -> 0x00ba }
            com.facebook.internal.ImageDownloader$DownloaderContext r4 = r10.removePendingRequest(r11)     // Catch:{ IOException -> 0x009e, all -> 0x00ba }
            if (r4 == 0) goto L_0x009a
            boolean r5 = r4.isCancelled     // Catch:{ IOException -> 0x009e, all -> 0x00ba }
            if (r5 != 0) goto L_0x009a
            com.facebook.internal.ImageRequest r4 = r4.request     // Catch:{ IOException -> 0x009e, all -> 0x00ba }
            com.facebook.internal.ImageDownloader$RequestKey r5 = new com.facebook.internal.ImageDownloader$RequestKey     // Catch:{ IOException -> 0x009e, all -> 0x00ba }
            java.lang.String r6 = "redirectUri"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r6)     // Catch:{ IOException -> 0x009e, all -> 0x00ba }
            java.lang.Object r6 = r11.tag     // Catch:{ IOException -> 0x009e, all -> 0x00ba }
            r5.<init>(r0, r6)     // Catch:{ IOException -> 0x009e, all -> 0x00ba }
            com.facebook.internal.WorkQueue r0 = cacheReadQueue     // Catch:{ IOException -> 0x009e, all -> 0x00ba }
            com.facebook.internal.ImageDownloader$CacheReadWorkItem r6 = new com.facebook.internal.ImageDownloader$CacheReadWorkItem     // Catch:{ IOException -> 0x009e, all -> 0x00ba }
            r6.<init>(r5, r1)     // Catch:{ IOException -> 0x009e, all -> 0x00ba }
            r10.enqueueRequest(r4, r5, r0, r6)     // Catch:{ IOException -> 0x009e, all -> 0x00ba }
        L_0x009a:
            r0 = 0
            r5 = r2
            r6 = r5
            goto L_0x00ad
        L_0x009e:
            r0 = move-exception
            r4 = 0
            r4 = r2
            r5 = 0
            goto L_0x00d4
        L_0x00a3:
            java.io.InputStream r4 = com.facebook.internal.ImageResponseCache.interceptAndCacheImageStream(r3)     // Catch:{ IOException -> 0x00bc, all -> 0x00ba }
            android.graphics.Bitmap r5 = android.graphics.BitmapFactory.decodeStream(r4)     // Catch:{ IOException -> 0x00b8, all -> 0x00b5 }
            r6 = r2
        L_0x00ac:
            r2 = r4
        L_0x00ad:
            com.facebook.internal.Utility.closeQuietly(r2)
            com.facebook.internal.Utility.disconnectQuietly(r3)
            r2 = r5
            goto L_0x00dc
        L_0x00b5:
            r10 = move-exception
            r2 = r4
            goto L_0x00c9
        L_0x00b8:
            r0 = move-exception
            goto L_0x00d3
        L_0x00ba:
            r10 = move-exception
            goto L_0x00c9
        L_0x00bc:
            r0 = move-exception
            r4 = r2
            goto L_0x00d3
        L_0x00bf:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException     // Catch:{ IOException -> 0x00d0, all -> 0x00c7 }
            java.lang.String r3 = "null cannot be cast to non-null type java.net.HttpURLConnection"
            r0.<init>(r3)     // Catch:{ IOException -> 0x00d0, all -> 0x00c7 }
            throw r0     // Catch:{ IOException -> 0x00d0, all -> 0x00c7 }
        L_0x00c7:
            r10 = move-exception
            r3 = r2
        L_0x00c9:
            com.facebook.internal.Utility.closeQuietly(r2)
            com.facebook.internal.Utility.disconnectQuietly(r3)
            throw r10
        L_0x00d0:
            r0 = move-exception
            r3 = r2
            r4 = r3
        L_0x00d3:
            r5 = 1
        L_0x00d4:
            com.facebook.internal.Utility.closeQuietly(r4)
            com.facebook.internal.Utility.disconnectQuietly(r3)
            r6 = r0
            r0 = r5
        L_0x00dc:
            if (r0 == 0) goto L_0x00e1
            r10.issueResponse(r11, r6, r2, r1)
        L_0x00e1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.ImageDownloader.access$download(com.facebook.internal.ImageDownloader, com.facebook.internal.ImageDownloader$RequestKey):void");
    }

    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [com.facebook.internal.ImageRequest] */
    /* JADX WARNING: type inference failed for: r1v2, types: [com.facebook.internal.ImageRequest] */
    /* JADX WARNING: type inference failed for: r1v3, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r6v0, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r5v0 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r6v2 */
    /* JADX WARNING: type inference failed for: r5v1 */
    /* JADX WARNING: type inference failed for: r6v3 */
    /* JADX WARNING: type inference failed for: r6v4 */
    /* JADX WARNING: type inference failed for: r6v5, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r6v6 */
    /* JADX WARNING: type inference failed for: r5v5 */
    /* JADX WARNING: type inference failed for: r6v7 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r5v6, types: [java.io.Closeable, java.io.InputStreamReader] */
    /* JADX WARNING: type inference failed for: r6v12 */
    /* JADX WARNING: type inference failed for: r6v14 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r6v15 */
    /* JADX WARNING: type inference failed for: r6v16 */
    /* JADX WARNING: type inference failed for: r6v17 */
    /* JADX WARNING: type inference failed for: r6v18 */
    /* JADX WARNING: type inference failed for: r6v19 */
    /* JADX WARNING: type inference failed for: r5v9 */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008a, code lost:
        if (r5 == false) goto L_0x00af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        r12 = android.net.Uri.parse(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0090, code lost:
        com.facebook.internal.Utility.closeQuietly(r6);
     */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r1v0
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], ?[OBJECT, ARRAY], com.facebook.internal.ImageRequest]
      uses: [?[int, boolean, OBJECT, ARRAY, byte, short, char], com.facebook.internal.ImageRequest, java.io.Closeable]
      mth insns count: 108
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00d9  */
    /* JADX WARNING: Unknown variable types count: 7 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void access$readFromCache(com.facebook.internal.ImageDownloader r10, com.facebook.internal.ImageDownloader.RequestKey r11, boolean r12) {
        /*
            r0 = 0
            r1 = 0
            if (r12 == 0) goto L_0x00c3
            com.facebook.internal.UrlRedirectCache r12 = com.facebook.internal.UrlRedirectCache.INSTANCE
            android.net.Uri r12 = r11.uri
            if (r12 != 0) goto L_0x000c
            goto L_0x00b2
        L_0x000c:
            java.lang.String r12 = r12.toString()
            java.lang.String r2 = "uri.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r2)
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
            r2.add(r12)
            com.facebook.internal.FileLruCache r3 = com.facebook.internal.UrlRedirectCache.getCache()     // Catch:{ IOException -> 0x0098, all -> 0x0096 }
            java.lang.String r4 = com.facebook.internal.UrlRedirectCache.redirectContentTag     // Catch:{ IOException -> 0x0098, all -> 0x0096 }
            java.io.InputStream r4 = r3.get(r12, r4)     // Catch:{ IOException -> 0x0098, all -> 0x0096 }
            r5 = 0
            r6 = r1
        L_0x0029:
            if (r4 == 0) goto L_0x008a
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0088, all -> 0x0085 }
            r5.<init>(r4)     // Catch:{ IOException -> 0x0088, all -> 0x0085 }
            r4 = 128(0x80, float:1.8E-43)
            char[] r6 = new char[r4]     // Catch:{ IOException -> 0x0083 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0083 }
            r7.<init>()     // Catch:{ IOException -> 0x0083 }
            int r8 = r5.read(r6, r0, r4)     // Catch:{ IOException -> 0x0083 }
        L_0x003d:
            if (r8 <= 0) goto L_0x0047
            r7.append(r6, r0, r8)     // Catch:{ IOException -> 0x0083 }
            int r8 = r5.read(r6, r0, r4)     // Catch:{ IOException -> 0x0083 }
            goto L_0x003d
        L_0x0047:
            com.facebook.internal.Utility.closeQuietly(r5)     // Catch:{ IOException -> 0x0083 }
            java.lang.String r4 = r7.toString()     // Catch:{ IOException -> 0x0083 }
            java.lang.String r6 = "urlBuilder.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r6)     // Catch:{ IOException -> 0x0083 }
            boolean r6 = r2.contains(r4)     // Catch:{ IOException -> 0x0083 }
            if (r6 == 0) goto L_0x0073
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r12)     // Catch:{ IOException -> 0x0083 }
            if (r2 == 0) goto L_0x0063
            r2 = 1
            r6 = r5
            r5 = 1
            goto L_0x008a
        L_0x0063:
            com.facebook.internal.Logger$Companion r12 = com.facebook.internal.Logger.Companion     // Catch:{ IOException -> 0x0083 }
            com.facebook.LoggingBehavior r2 = com.facebook.LoggingBehavior.CACHE     // Catch:{ IOException -> 0x0083 }
            r3 = 6
            java.lang.String r4 = com.facebook.internal.UrlRedirectCache.tag     // Catch:{ IOException -> 0x0083 }
            java.lang.String r6 = "A loop detected in UrlRedirectCache"
            r12.log(r2, r3, r4, r6)     // Catch:{ IOException -> 0x0083 }
            com.facebook.internal.Utility.closeQuietly(r5)
            goto L_0x00b2
        L_0x0073:
            r2.add(r4)     // Catch:{ IOException -> 0x0083 }
            java.lang.String r12 = com.facebook.internal.UrlRedirectCache.redirectContentTag     // Catch:{ IOException -> 0x0083 }
            java.io.InputStream r12 = r3.get(r4, r12)     // Catch:{ IOException -> 0x0083 }
            r6 = 1
            r6 = r5
            r5 = 1
            r9 = r4
            r4 = r12
            r12 = r9
            goto L_0x0029
        L_0x0083:
            r12 = move-exception
            goto L_0x009a
        L_0x0085:
            r10 = move-exception
            r1 = r6
            goto L_0x00bf
        L_0x0088:
            r12 = move-exception
            goto L_0x0094
        L_0x008a:
            if (r5 == 0) goto L_0x00af
            android.net.Uri r12 = android.net.Uri.parse(r12)     // Catch:{ IOException -> 0x0088, all -> 0x0085 }
            com.facebook.internal.Utility.closeQuietly(r6)
            goto L_0x00b3
        L_0x0094:
            r5 = r6
            goto L_0x009a
        L_0x0096:
            r10 = move-exception
            goto L_0x00bf
        L_0x0098:
            r12 = move-exception
            r5 = r1
        L_0x009a:
            com.facebook.internal.Logger$Companion r2 = com.facebook.internal.Logger.Companion     // Catch:{ all -> 0x00bd }
            com.facebook.LoggingBehavior r3 = com.facebook.LoggingBehavior.CACHE     // Catch:{ all -> 0x00bd }
            r4 = 4
            java.lang.String r6 = com.facebook.internal.UrlRedirectCache.tag     // Catch:{ all -> 0x00bd }
            java.lang.String r7 = "IOException when accessing cache: "
            java.lang.String r12 = r12.getMessage()     // Catch:{ all -> 0x00bd }
            java.lang.String r12 = kotlin.jvm.internal.Intrinsics.stringPlus(r7, r12)     // Catch:{ all -> 0x00bd }
            r2.log(r3, r4, r6, r12)     // Catch:{ all -> 0x00bd }
            r6 = r5
        L_0x00af:
            com.facebook.internal.Utility.closeQuietly(r6)
        L_0x00b2:
            r12 = r1
        L_0x00b3:
            if (r12 == 0) goto L_0x00c3
            java.io.InputStream r12 = com.facebook.internal.ImageResponseCache.getCachedImageStream(r12)
            if (r12 == 0) goto L_0x00c4
            r0 = 1
            goto L_0x00c4
        L_0x00bd:
            r10 = move-exception
            r1 = r5
        L_0x00bf:
            com.facebook.internal.Utility.closeQuietly(r1)
            throw r10
        L_0x00c3:
            r12 = r1
        L_0x00c4:
            if (r0 != 0) goto L_0x00cc
            android.net.Uri r12 = r11.uri
            java.io.InputStream r12 = com.facebook.internal.ImageResponseCache.getCachedImageStream(r12)
        L_0x00cc:
            if (r12 == 0) goto L_0x00d9
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeStream(r12)
            com.facebook.internal.Utility.closeQuietly(r12)
            r10.issueResponse(r11, r1, r2, r0)
            goto L_0x00f4
        L_0x00d9:
            com.facebook.internal.ImageDownloader$DownloaderContext r12 = r10.removePendingRequest(r11)
            if (r12 != 0) goto L_0x00e0
            goto L_0x00e2
        L_0x00e0:
            com.facebook.internal.ImageRequest r1 = r12.request
        L_0x00e2:
            if (r12 == 0) goto L_0x00f4
            boolean r12 = r12.isCancelled
            if (r12 != 0) goto L_0x00f4
            if (r1 == 0) goto L_0x00f4
            com.facebook.internal.WorkQueue r12 = downloadQueue
            com.facebook.internal.ImageDownloader$DownloadImageWorkItem r0 = new com.facebook.internal.ImageDownloader$DownloadImageWorkItem
            r0.<init>(r11)
            r10.enqueueRequest(r1, r11, r12, r0)
        L_0x00f4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.ImageDownloader.access$readFromCache(com.facebook.internal.ImageDownloader, com.facebook.internal.ImageDownloader$RequestKey, boolean):void");
    }

    public static final boolean cancelRequest(ImageRequest imageRequest) {
        boolean z;
        Intrinsics.checkNotNullParameter(imageRequest, "request");
        RequestKey requestKey = new RequestKey(imageRequest.imageUri, imageRequest.callerTag);
        synchronized (pendingRequests) {
            DownloaderContext downloaderContext = pendingRequests.get(requestKey);
            z = true;
            if (downloaderContext != null) {
                WorkItem workItem = downloaderContext.workItem;
                if (workItem == null || !workItem.cancel()) {
                    downloaderContext.isCancelled = true;
                } else {
                    pendingRequests.remove(requestKey);
                }
            } else {
                z = false;
            }
        }
        return z;
    }

    /* JADX INFO: finally extract failed */
    public static final void downloadAsync(ImageRequest imageRequest) {
        RequestKey requestKey = new RequestKey(imageRequest.imageUri, imageRequest.callerTag);
        synchronized (pendingRequests) {
            DownloaderContext downloaderContext = pendingRequests.get(requestKey);
            if (downloaderContext != null) {
                Intrinsics.checkNotNullParameter(imageRequest, "<set-?>");
                downloaderContext.request = imageRequest;
                downloaderContext.isCancelled = false;
                WorkItem workItem = downloaderContext.workItem;
                if (workItem != null) {
                    workItem.moveToFront();
                }
            } else {
                boolean z = imageRequest.allowCachedRedirects;
                WorkQueue workQueue = cacheReadQueue;
                CacheReadWorkItem cacheReadWorkItem = new CacheReadWorkItem(requestKey, z);
                synchronized (pendingRequests) {
                    DownloaderContext downloaderContext2 = new DownloaderContext(imageRequest);
                    pendingRequests.put(requestKey, downloaderContext2);
                    if (workQueue != null) {
                        Intrinsics.checkNotNullParameter(cacheReadWorkItem, "callback");
                        WorkNode workNode = new WorkNode(workQueue, cacheReadWorkItem);
                        ReentrantLock reentrantLock = workQueue.workLock;
                        reentrantLock.lock();
                        try {
                            workQueue.pendingJobs = workNode.addToList(workQueue.pendingJobs, true);
                            reentrantLock.unlock();
                            workQueue.finishItemAndStartNew(null);
                            downloaderContext2.workItem = workNode;
                        } catch (Throwable th) {
                            reentrantLock.unlock();
                            throw th;
                        }
                    } else {
                        throw null;
                    }
                }
            }
        }
    }

    /* renamed from: issueResponse$lambda-4  reason: not valid java name */
    public static final void m202issueResponse$lambda4(ImageRequest imageRequest, Exception exc, boolean z, Bitmap bitmap, Callback callback) {
        Intrinsics.checkNotNullParameter(imageRequest, "$request");
        callback.onCompleted(new ImageResponse(imageRequest, exc, z, bitmap));
    }

    /* JADX INFO: finally extract failed */
    public final void enqueueRequest(ImageRequest imageRequest, RequestKey requestKey, WorkQueue workQueue, Runnable runnable) {
        synchronized (pendingRequests) {
            DownloaderContext downloaderContext = new DownloaderContext(imageRequest);
            pendingRequests.put(requestKey, downloaderContext);
            if (workQueue != null) {
                Intrinsics.checkNotNullParameter(runnable, "callback");
                WorkNode workNode = new WorkNode(workQueue, runnable);
                ReentrantLock reentrantLock = workQueue.workLock;
                reentrantLock.lock();
                try {
                    workQueue.pendingJobs = workNode.addToList(workQueue.pendingJobs, true);
                    reentrantLock.unlock();
                    workQueue.finishItemAndStartNew(null);
                    downloaderContext.workItem = workNode;
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    throw th;
                }
            } else {
                throw null;
            }
        }
    }

    public final void issueResponse(RequestKey requestKey, Exception exc, Bitmap bitmap, boolean z) {
        Callback callback;
        Handler handler2;
        DownloaderContext removePendingRequest = removePendingRequest(requestKey);
        if (removePendingRequest != null && !removePendingRequest.isCancelled) {
            ImageRequest imageRequest = removePendingRequest.request;
            if (imageRequest == null) {
                callback = null;
            } else {
                callback = imageRequest.callback;
            }
            Callback callback2 = callback;
            if (callback2 != null) {
                synchronized (this) {
                    if (handler == null) {
                        handler = new Handler(Looper.getMainLooper());
                    }
                    handler2 = handler;
                }
                if (handler2 != null) {
                    $$Lambda$Jkme0WLX_6cx83WwyIvG6N6VNU r1 = new Runnable(exc, z, bitmap, callback2) {
                        public final /* synthetic */ Exception f$1;
                        public final /* synthetic */ boolean f$2;
                        public final /* synthetic */ Bitmap f$3;
                        public final /* synthetic */ Callback f$4;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                            this.f$3 = r4;
                            this.f$4 = r5;
                        }

                        public final void run() {
                            ImageDownloader.m202issueResponse$lambda4(ImageRequest.this, this.f$1, this.f$2, this.f$3, this.f$4);
                        }
                    };
                    handler2.post(r1);
                }
            }
        }
    }

    public final DownloaderContext removePendingRequest(RequestKey requestKey) {
        DownloaderContext remove;
        synchronized (pendingRequests) {
            remove = pendingRequests.remove(requestKey);
        }
        return remove;
    }
}
