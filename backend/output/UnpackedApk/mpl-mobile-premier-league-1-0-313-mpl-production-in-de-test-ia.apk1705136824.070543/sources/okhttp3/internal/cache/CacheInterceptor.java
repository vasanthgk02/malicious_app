package okhttp3.internal.cache;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;
import okhttp3.Cache;
import okhttp3.Headers;
import okhttp3.Headers.Builder;
import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.RealResponseBody;
import okio.Okio;
import okio.Sink;
import okio.Source;
import org.jboss.netty.handler.codec.http.HttpHeaders.Names;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lokhttp3/internal/cache/CacheInterceptor;", "Lokhttp3/Interceptor;", "cache", "Lokhttp3/Cache;", "(Lokhttp3/Cache;)V", "getCache$okhttp", "()Lokhttp3/Cache;", "cacheWritingResponse", "Lokhttp3/Response;", "cacheRequest", "Lokhttp3/internal/cache/CacheRequest;", "response", "intercept", "chain", "Lokhttp3/Interceptor$Chain;", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
/* compiled from: CacheInterceptor.kt */
public final class CacheInterceptor implements Interceptor {
    public static final Companion Companion = new Companion(null);
    public final Cache cache;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0014\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¨\u0006\u000f"}, d2 = {"Lokhttp3/internal/cache/CacheInterceptor$Companion;", "", "()V", "combine", "Lokhttp3/Headers;", "cachedHeaders", "networkHeaders", "isContentSpecificHeader", "", "fieldName", "", "isEndToEnd", "stripBody", "Lokhttp3/Response;", "response", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* compiled from: CacheInterceptor.kt */
    public static final class Companion {
        public Companion() {
        }

        /* access modifiers changed from: private */
        public final Headers combine(Headers headers, Headers headers2) {
            Builder builder = new Builder();
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                String name = headers.name(i);
                String value = headers.value(i);
                if ((!CharsKt__CharKt.equals((String) Names.WARNING, name, true) || !CharsKt__CharKt.startsWith$default(value, (String) "1", false, 2)) && (isContentSpecificHeader(name) || !isEndToEnd(name) || headers2.get(name) == null)) {
                    builder.addLenient$okhttp(name, value);
                }
            }
            int size2 = headers2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                String name2 = headers2.name(i2);
                if (!isContentSpecificHeader(name2) && isEndToEnd(name2)) {
                    builder.addLenient$okhttp(name2, headers2.value(i2));
                }
            }
            return builder.build();
        }

        private final boolean isContentSpecificHeader(String str) {
            if (CharsKt__CharKt.equals((String) "Content-Length", str, true) || CharsKt__CharKt.equals((String) "Content-Encoding", str, true) || CharsKt__CharKt.equals((String) "Content-Type", str, true)) {
                return true;
            }
            return false;
        }

        private final boolean isEndToEnd(String str) {
            if (CharsKt__CharKt.equals((String) "Connection", str, true) || CharsKt__CharKt.equals((String) "Keep-Alive", str, true) || CharsKt__CharKt.equals((String) "Proxy-Authenticate", str, true) || CharsKt__CharKt.equals((String) Names.PROXY_AUTHORIZATION, str, true) || CharsKt__CharKt.equals((String) Names.TE, str, true) || CharsKt__CharKt.equals((String) "Trailers", str, true) || CharsKt__CharKt.equals((String) Names.TRANSFER_ENCODING, str, true) || CharsKt__CharKt.equals((String) "Upgrade", str, true)) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: private */
        public final Response stripBody(Response response) {
            return (response != null ? response.body() : null) != null ? response.newBuilder().body(null).build() : response;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CacheInterceptor(Cache cache2) {
        this.cache = cache2;
    }

    private final Response cacheWritingResponse(CacheRequest cacheRequest, Response response) throws IOException {
        if (cacheRequest == null) {
            return response;
        }
        Sink body = cacheRequest.body();
        ResponseBody body2 = response.body();
        Intrinsics.checkNotNull(body2);
        CacheInterceptor$cacheWritingResponse$cacheWritingSource$1 cacheInterceptor$cacheWritingResponse$cacheWritingSource$1 = new CacheInterceptor$cacheWritingResponse$cacheWritingSource$1(body2.source(), cacheRequest, Okio.buffer(body));
        return response.newBuilder().body(new RealResponseBody(Response.header$default(response, "Content-Type", null, 2, null), response.body().contentLength(), Okio.buffer((Source) cacheInterceptor$cacheWritingResponse$cacheWritingSource$1))).build();
    }

    public final Cache getCache$okhttp() {
        return this.cache;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0046, code lost:
        if (r2 != null) goto L_0x004b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain r8) throws java.io.IOException {
        /*
            r7 = this;
            java.lang.String r0 = "chain"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            okhttp3.Call r0 = r8.call()
            okhttp3.Cache r1 = r7.cache
            r2 = 0
            if (r1 == 0) goto L_0x0017
            okhttp3.Request r3 = r8.request()
            okhttp3.Response r1 = r1.get$okhttp(r3)
            goto L_0x0018
        L_0x0017:
            r1 = r2
        L_0x0018:
            long r3 = java.lang.System.currentTimeMillis()
            okhttp3.internal.cache.CacheStrategy$Factory r5 = new okhttp3.internal.cache.CacheStrategy$Factory
            okhttp3.Request r6 = r8.request()
            r5.<init>(r3, r6, r1)
            okhttp3.internal.cache.CacheStrategy r3 = r5.compute()
            okhttp3.Request r4 = r3.getNetworkRequest()
            okhttp3.Response r5 = r3.getCacheResponse()
            okhttp3.Cache r6 = r7.cache
            if (r6 == 0) goto L_0x0038
            r6.trackResponse$okhttp(r3)
        L_0x0038:
            boolean r3 = r0 instanceof okhttp3.internal.connection.RealCall
            if (r3 != 0) goto L_0x003d
            goto L_0x003e
        L_0x003d:
            r2 = r0
        L_0x003e:
            okhttp3.internal.connection.RealCall r2 = (okhttp3.internal.connection.RealCall) r2
            if (r2 == 0) goto L_0x0049
            okhttp3.EventListener r2 = r2.getEventListener$okhttp()
            if (r2 == 0) goto L_0x0049
            goto L_0x004b
        L_0x0049:
            okhttp3.EventListener r2 = okhttp3.EventListener.NONE
        L_0x004b:
            if (r1 == 0) goto L_0x0058
            if (r5 != 0) goto L_0x0058
            okhttp3.ResponseBody r3 = r1.body()
            if (r3 == 0) goto L_0x0058
            okhttp3.internal.Util.closeQuietly(r3)
        L_0x0058:
            if (r4 != 0) goto L_0x0097
            if (r5 != 0) goto L_0x0097
            okhttp3.Response$Builder r1 = new okhttp3.Response$Builder
            r1.<init>()
            okhttp3.Request r8 = r8.request()
            okhttp3.Response$Builder r8 = r1.request(r8)
            okhttp3.Protocol r1 = okhttp3.Protocol.HTTP_1_1
            okhttp3.Response$Builder r8 = r8.protocol(r1)
            r1 = 504(0x1f8, float:7.06E-43)
            okhttp3.Response$Builder r8 = r8.code(r1)
            java.lang.String r1 = "Unsatisfiable Request (only-if-cached)"
            okhttp3.Response$Builder r8 = r8.message(r1)
            okhttp3.ResponseBody r1 = okhttp3.internal.Util.EMPTY_RESPONSE
            okhttp3.Response$Builder r8 = r8.body(r1)
            r3 = -1
            okhttp3.Response$Builder r8 = r8.sentRequestAtMillis(r3)
            long r3 = java.lang.System.currentTimeMillis()
            okhttp3.Response$Builder r8 = r8.receivedResponseAtMillis(r3)
            okhttp3.Response r8 = r8.build()
            r2.satisfactionFailure(r0, r8)
            return r8
        L_0x0097:
            if (r4 != 0) goto L_0x00b2
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            okhttp3.Response$Builder r8 = r5.newBuilder()
            okhttp3.internal.cache.CacheInterceptor$Companion r1 = Companion
            okhttp3.Response r1 = r1.stripBody(r5)
            okhttp3.Response$Builder r8 = r8.cacheResponse(r1)
            okhttp3.Response r8 = r8.build()
            r2.cacheHit(r0, r8)
            return r8
        L_0x00b2:
            if (r5 == 0) goto L_0x00b8
            r2.cacheConditionalHit(r0, r5)
            goto L_0x00bf
        L_0x00b8:
            okhttp3.Cache r3 = r7.cache
            if (r3 == 0) goto L_0x00bf
            r2.cacheMiss(r0)
        L_0x00bf:
            okhttp3.Response r8 = r8.proceed(r4)     // Catch:{ all -> 0x0191 }
            if (r8 != 0) goto L_0x00d0
            if (r1 == 0) goto L_0x00d0
            okhttp3.ResponseBody r1 = r1.body()
            if (r1 == 0) goto L_0x00d0
            okhttp3.internal.Util.closeQuietly(r1)
        L_0x00d0:
            if (r5 == 0) goto L_0x013e
            if (r8 == 0) goto L_0x0135
            int r1 = r8.code()
            r3 = 304(0x130, float:4.26E-43)
            if (r1 != r3) goto L_0x0135
            okhttp3.Response$Builder r1 = r5.newBuilder()
            okhttp3.internal.cache.CacheInterceptor$Companion r3 = Companion
            okhttp3.Headers r4 = r5.headers()
            okhttp3.Headers r6 = r8.headers()
            okhttp3.Headers r3 = r3.combine(r4, r6)
            okhttp3.Response$Builder r1 = r1.headers(r3)
            long r3 = r8.sentRequestAtMillis()
            okhttp3.Response$Builder r1 = r1.sentRequestAtMillis(r3)
            long r3 = r8.receivedResponseAtMillis()
            okhttp3.Response$Builder r1 = r1.receivedResponseAtMillis(r3)
            okhttp3.internal.cache.CacheInterceptor$Companion r3 = Companion
            okhttp3.Response r3 = r3.stripBody(r5)
            okhttp3.Response$Builder r1 = r1.cacheResponse(r3)
            okhttp3.internal.cache.CacheInterceptor$Companion r3 = Companion
            okhttp3.Response r3 = r3.stripBody(r8)
            okhttp3.Response$Builder r1 = r1.networkResponse(r3)
            okhttp3.Response r1 = r1.build()
            okhttp3.ResponseBody r8 = r8.body()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            r8.close()
            okhttp3.Cache r8 = r7.cache
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            r8.trackConditionalCacheHit$okhttp()
            okhttp3.Cache r8 = r7.cache
            r8.update$okhttp(r5, r1)
            r2.cacheHit(r0, r1)
            return r1
        L_0x0135:
            okhttp3.ResponseBody r1 = r5.body()
            if (r1 == 0) goto L_0x013e
            okhttp3.internal.Util.closeQuietly(r1)
        L_0x013e:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            okhttp3.Response$Builder r1 = r8.newBuilder()
            okhttp3.internal.cache.CacheInterceptor$Companion r3 = Companion
            okhttp3.Response r3 = r3.stripBody(r5)
            okhttp3.Response$Builder r1 = r1.cacheResponse(r3)
            okhttp3.internal.cache.CacheInterceptor$Companion r3 = Companion
            okhttp3.Response r8 = r3.stripBody(r8)
            okhttp3.Response$Builder r8 = r1.networkResponse(r8)
            okhttp3.Response r8 = r8.build()
            okhttp3.Cache r1 = r7.cache
            if (r1 == 0) goto L_0x0190
            boolean r1 = okhttp3.internal.http.HttpHeaders.promisesBody(r8)
            if (r1 == 0) goto L_0x017f
            okhttp3.internal.cache.CacheStrategy$Companion r1 = okhttp3.internal.cache.CacheStrategy.Companion
            boolean r1 = r1.isCacheable(r8, r4)
            if (r1 == 0) goto L_0x017f
            okhttp3.Cache r1 = r7.cache
            okhttp3.internal.cache.CacheRequest r1 = r1.put$okhttp(r8)
            okhttp3.Response r8 = r7.cacheWritingResponse(r1, r8)
            if (r5 == 0) goto L_0x017e
            r2.cacheMiss(r0)
        L_0x017e:
            return r8
        L_0x017f:
            okhttp3.internal.http.HttpMethod r0 = okhttp3.internal.http.HttpMethod.INSTANCE
            java.lang.String r1 = r4.method()
            boolean r0 = r0.invalidatesCache(r1)
            if (r0 == 0) goto L_0x0190
            okhttp3.Cache r0 = r7.cache     // Catch:{ IOException -> 0x0190 }
            r0.remove$okhttp(r4)     // Catch:{ IOException -> 0x0190 }
        L_0x0190:
            return r8
        L_0x0191:
            r8 = move-exception
            if (r1 == 0) goto L_0x019d
            okhttp3.ResponseBody r0 = r1.body()
            if (r0 == 0) goto L_0x019d
            okhttp3.internal.Util.closeQuietly(r0)
        L_0x019d:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.CacheInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }
}
