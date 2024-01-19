package com.facebook.react.modules.fresco;

import com.facebook.imagepipeline.backends.okhttp3.OkHttpNetworkFetcher;
import okhttp3.OkHttpClient;

public class ReactOkHttpNetworkFetcher extends OkHttpNetworkFetcher {
    public final OkHttpClient mOkHttpClient;

    public ReactOkHttpNetworkFetcher(OkHttpClient okHttpClient) {
        super(okHttpClient);
        this.mOkHttpClient = okHttpClient;
        okHttpClient.dispatcher().executorService();
    }

    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v1 */
    /* JADX WARNING: type inference failed for: r2v2, types: [java.util.Map] */
    /* JADX WARNING: type inference failed for: r2v3, types: [java.util.Map] */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void fetch(com.facebook.imagepipeline.backends.okhttp3.OkHttpNetworkFetcher.OkHttpNetworkFetchState r7, com.facebook.imagepipeline.producers.NetworkFetcher.Callback r8) {
        /*
            r6 = this;
            long r0 = android.os.SystemClock.elapsedRealtime()
            r7.submitTime = r0
            android.net.Uri r0 = r7.getUri()
            com.facebook.imagepipeline.producers.ProducerContext r1 = r7.getContext()
            com.facebook.imagepipeline.request.ImageRequest r1 = r1.getImageRequest()
            boolean r1 = r1 instanceof com.facebook.react.modules.fresco.ReactNetworkImageRequest
            r2 = 0
            if (r1 == 0) goto L_0x0042
            com.facebook.imagepipeline.producers.ProducerContext r1 = r7.getContext()
            com.facebook.imagepipeline.request.ImageRequest r1 = r1.getImageRequest()
            com.facebook.react.modules.fresco.ReactNetworkImageRequest r1 = (com.facebook.react.modules.fresco.ReactNetworkImageRequest) r1
            com.facebook.react.bridge.ReadableMap r1 = r1.mHeaders
            if (r1 != 0) goto L_0x0026
            goto L_0x0042
        L_0x0026:
            com.facebook.react.bridge.ReadableMapKeySetIterator r2 = r1.keySetIterator()
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
        L_0x002f:
            boolean r4 = r2.hasNextKey()
            if (r4 == 0) goto L_0x0041
            java.lang.String r4 = r2.nextKey()
            java.lang.String r5 = r1.getString(r4)
            r3.put(r4, r5)
            goto L_0x002f
        L_0x0041:
            r2 = r3
        L_0x0042:
            if (r2 != 0) goto L_0x0048
            java.util.Map r2 = java.util.Collections.emptyMap()
        L_0x0048:
            okhttp3.Request$Builder r1 = new okhttp3.Request$Builder
            r1.<init>()
            okhttp3.CacheControl$Builder r3 = new okhttp3.CacheControl$Builder
            r3.<init>()
            okhttp3.CacheControl$Builder r3 = r3.noStore()
            okhttp3.CacheControl r3 = r3.build()
            okhttp3.Request$Builder r1 = r1.cacheControl(r3)
            java.lang.String r0 = r0.toString()
            okhttp3.Request$Builder r0 = r1.url(r0)
            okhttp3.Headers r1 = okhttp3.Headers.of(r2)
            okhttp3.Request$Builder r0 = r0.headers(r1)
            okhttp3.Request$Builder r0 = r0.get()
            okhttp3.Request r0 = r0.build()
            r6.fetchWithRequest(r7, r8, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.fresco.ReactOkHttpNetworkFetcher.fetch(com.facebook.imagepipeline.backends.okhttp3.OkHttpNetworkFetcher$OkHttpNetworkFetchState, com.facebook.imagepipeline.producers.NetworkFetcher$Callback):void");
    }
}
