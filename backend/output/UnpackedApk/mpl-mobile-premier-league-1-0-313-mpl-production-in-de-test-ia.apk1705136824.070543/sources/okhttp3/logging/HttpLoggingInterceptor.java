package okhttp3.logging;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.Set;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.CharsKt__CharKt;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.internal.platform.Platform;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\u001e\u001fB\u0011\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\r\u0010\u000b\u001a\u00020\tH\u0007¢\u0006\u0002\b\u0012J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u000e\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0007J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u0002\n\u0000R$\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@GX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\n\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lokhttp3/logging/HttpLoggingInterceptor;", "Lokhttp3/Interceptor;", "logger", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "(Lokhttp3/logging/HttpLoggingInterceptor$Logger;)V", "headersToRedact", "", "", "<set-?>", "Lokhttp3/logging/HttpLoggingInterceptor$Level;", "level", "getLevel", "()Lokhttp3/logging/HttpLoggingInterceptor$Level;", "(Lokhttp3/logging/HttpLoggingInterceptor$Level;)V", "bodyHasUnknownEncoding", "", "headers", "Lokhttp3/Headers;", "-deprecated_level", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "logHeader", "", "i", "", "redactHeader", "name", "setLevel", "Level", "Logger", "okhttp-logging-interceptor"}, k = 1, mv = {1, 4, 0})
/* compiled from: HttpLoggingInterceptor.kt */
public final class HttpLoggingInterceptor implements Interceptor {
    public volatile Set<String> headersToRedact;
    public volatile Level level;
    public final Logger logger;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$Level;", "", "(Ljava/lang/String;I)V", "NONE", "BASIC", "HEADERS", "BODY", "okhttp-logging-interceptor"}, k = 1, mv = {1, 4, 0})
    /* compiled from: HttpLoggingInterceptor.kt */
    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bæ\u0001\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "", "log", "", "message", "", "Companion", "okhttp-logging-interceptor"}, k = 1, mv = {1, 4, 0})
    /* compiled from: HttpLoggingInterceptor.kt */
    public interface Logger {
        public static final Companion Companion = new Companion(null);
        public static final Logger DEFAULT = new DefaultLogger();

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000¨\u0006\u0001\u0002\u0007\n\u0005\bF0\u0001¨\u0006\u0006"}, d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$Logger$Companion;", "", "()V", "DEFAULT", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "DefaultLogger", "okhttp-logging-interceptor"}, k = 1, mv = {1, 4, 0})
        /* compiled from: HttpLoggingInterceptor.kt */
        public static final class Companion {
            public static final /* synthetic */ Companion $$INSTANCE = null;

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$Logger$Companion$DefaultLogger;", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "()V", "log", "", "message", "", "okhttp-logging-interceptor"}, k = 1, mv = {1, 4, 0})
            /* compiled from: HttpLoggingInterceptor.kt */
            public static final class DefaultLogger implements Logger {
                public void log(String str) {
                    Intrinsics.checkNotNullParameter(str, "message");
                    Platform.log$default(Platform.Companion.get(), str, 0, null, 6, null);
                }
            }

            public Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        void log(String str);
    }

    public HttpLoggingInterceptor() {
        this(null, 1, null);
    }

    public HttpLoggingInterceptor(Logger logger2) {
        Intrinsics.checkNotNullParameter(logger2, "logger");
        this.logger = logger2;
        this.headersToRedact = EmptySet.INSTANCE;
        this.level = Level.NONE;
    }

    private final boolean bodyHasUnknownEncoding(Headers headers) {
        String str = headers.get("Content-Encoding");
        if (str == null || CharsKt__CharKt.equals(str, (String) "identity", true) || CharsKt__CharKt.equals(str, (String) "gzip", true)) {
            return false;
        }
        return true;
    }

    private final void logHeader(Headers headers, int i) {
        String value = this.headersToRedact.contains(headers.name(i)) ? "██" : headers.value(i);
        Logger logger2 = this.logger;
        logger2.log(headers.name(i) + ": " + value);
    }

    /* renamed from: -deprecated_level  reason: not valid java name */
    public final Level m1125deprecated_level() {
        return this.level;
    }

    public final Level getLevel() {
        return this.level;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:105:0x031b, code lost:
        if (r2 != null) goto L_0x0323;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x016f, code lost:
        if (r13 != null) goto L_0x0177;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain r22) throws java.io.IOException {
        /*
            r21 = this;
            r1 = r21
            r0 = r22
            java.lang.String r2 = "chain"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            okhttp3.logging.HttpLoggingInterceptor$Level r2 = r1.level
            okhttp3.Request r3 = r22.request()
            okhttp3.logging.HttpLoggingInterceptor$Level r4 = okhttp3.logging.HttpLoggingInterceptor.Level.NONE
            if (r2 != r4) goto L_0x0018
            okhttp3.Response r0 = r0.proceed(r3)
            return r0
        L_0x0018:
            okhttp3.logging.HttpLoggingInterceptor$Level r4 = okhttp3.logging.HttpLoggingInterceptor.Level.BODY
            if (r2 != r4) goto L_0x001e
            r4 = 1
            goto L_0x001f
        L_0x001e:
            r4 = 0
        L_0x001f:
            if (r4 != 0) goto L_0x0028
            okhttp3.logging.HttpLoggingInterceptor$Level r5 = okhttp3.logging.HttpLoggingInterceptor.Level.HEADERS
            if (r2 != r5) goto L_0x0026
            goto L_0x0028
        L_0x0026:
            r2 = 0
            goto L_0x0029
        L_0x0028:
            r2 = 1
        L_0x0029:
            okhttp3.RequestBody r5 = r3.body()
            okhttp3.Connection r6 = r22.connection()
            java.lang.String r7 = "--> "
            java.lang.StringBuilder r7 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r7)
            java.lang.String r8 = r3.method()
            r7.append(r8)
            r8 = 32
            r7.append(r8)
            okhttp3.HttpUrl r8 = r3.url()
            r7.append(r8)
            java.lang.String r8 = ""
            if (r6 == 0) goto L_0x0060
            java.lang.String r9 = " "
            java.lang.StringBuilder r9 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r9)
            okhttp3.Protocol r6 = r6.protocol()
            r9.append(r6)
            java.lang.String r6 = r9.toString()
            goto L_0x0061
        L_0x0060:
            r6 = r8
        L_0x0061:
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            java.lang.String r7 = "-byte body)"
            java.lang.String r9 = " ("
            if (r2 != 0) goto L_0x0082
            if (r5 == 0) goto L_0x0082
            java.lang.StringBuilder r6 = com.android.tools.r8.GeneratedOutlineSupport.outline78(r6, r9)
            long r10 = r5.contentLength()
            r6.append(r10)
            r6.append(r7)
            java.lang.String r6 = r6.toString()
        L_0x0082:
            okhttp3.logging.HttpLoggingInterceptor$Logger r10 = r1.logger
            r10.log(r6)
            java.lang.String r6 = "-byte body omitted)"
            java.lang.String r10 = "UTF_8"
            if (r2 == 0) goto L_0x01e5
            okhttp3.Headers r11 = r3.headers()
            if (r5 == 0) goto L_0x00df
            okhttp3.MediaType r12 = r5.contentType()
            if (r12 == 0) goto L_0x00b7
            java.lang.String r13 = "Content-Type"
            java.lang.String r13 = r11.get(r13)
            if (r13 != 0) goto L_0x00b7
            okhttp3.logging.HttpLoggingInterceptor$Logger r13 = r1.logger
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r15 = "Content-Type: "
            r14.append(r15)
            r14.append(r12)
            java.lang.String r12 = r14.toString()
            r13.log(r12)
        L_0x00b7:
            long r12 = r5.contentLength()
            r14 = -1
            int r16 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r16 == 0) goto L_0x00df
            java.lang.String r12 = "Content-Length"
            java.lang.String r12 = r11.get(r12)
            if (r12 != 0) goto L_0x00df
            okhttp3.logging.HttpLoggingInterceptor$Logger r12 = r1.logger
            java.lang.String r13 = "Content-Length: "
            java.lang.StringBuilder r13 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r13)
            long r14 = r5.contentLength()
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            r12.log(r13)
        L_0x00df:
            int r12 = r11.size()
            r13 = 0
        L_0x00e4:
            if (r13 >= r12) goto L_0x00ec
            r1.logHeader(r11, r13)
            int r13 = r13 + 1
            goto L_0x00e4
        L_0x00ec:
            java.lang.String r11 = "--> END "
            if (r4 == 0) goto L_0x01d1
            if (r5 != 0) goto L_0x00f4
            goto L_0x01d1
        L_0x00f4:
            okhttp3.Headers r12 = r3.headers()
            boolean r12 = r1.bodyHasUnknownEncoding(r12)
            if (r12 == 0) goto L_0x0119
            okhttp3.logging.HttpLoggingInterceptor$Logger r5 = r1.logger
            java.lang.StringBuilder r11 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r11)
            java.lang.String r12 = r3.method()
            r11.append(r12)
            java.lang.String r12 = " (encoded body omitted)"
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            r5.log(r11)
            goto L_0x01e5
        L_0x0119:
            boolean r12 = r5.isDuplex()
            if (r12 == 0) goto L_0x013a
            okhttp3.logging.HttpLoggingInterceptor$Logger r5 = r1.logger
            java.lang.StringBuilder r11 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r11)
            java.lang.String r12 = r3.method()
            r11.append(r12)
            java.lang.String r12 = " (duplex request body omitted)"
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            r5.log(r11)
            goto L_0x01e5
        L_0x013a:
            boolean r12 = r5.isOneShot()
            if (r12 == 0) goto L_0x015b
            okhttp3.logging.HttpLoggingInterceptor$Logger r5 = r1.logger
            java.lang.StringBuilder r11 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r11)
            java.lang.String r12 = r3.method()
            r11.append(r12)
            java.lang.String r12 = " (one-shot body omitted)"
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            r5.log(r11)
            goto L_0x01e5
        L_0x015b:
            okio.Buffer r12 = new okio.Buffer
            r12.<init>()
            r5.writeTo(r12)
            okhttp3.MediaType r13 = r5.contentType()
            if (r13 == 0) goto L_0x0172
            java.nio.charset.Charset r14 = java.nio.charset.StandardCharsets.UTF_8
            java.nio.charset.Charset r13 = r13.charset(r14)
            if (r13 == 0) goto L_0x0172
            goto L_0x0177
        L_0x0172:
            java.nio.charset.Charset r13 = java.nio.charset.StandardCharsets.UTF_8
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r10)
        L_0x0177:
            okhttp3.logging.HttpLoggingInterceptor$Logger r14 = r1.logger
            r14.log(r8)
            boolean r14 = okhttp3.logging.Utf8Kt.isProbablyUtf8(r12)
            if (r14 == 0) goto L_0x01ad
            okhttp3.logging.HttpLoggingInterceptor$Logger r14 = r1.logger
            java.lang.String r12 = r12.readString(r13)
            r14.log(r12)
            okhttp3.logging.HttpLoggingInterceptor$Logger r12 = r1.logger
            java.lang.StringBuilder r11 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r11)
            java.lang.String r13 = r3.method()
            r11.append(r13)
            r11.append(r9)
            long r13 = r5.contentLength()
            r11.append(r13)
            r11.append(r7)
            java.lang.String r5 = r11.toString()
            r12.log(r5)
            goto L_0x01e5
        L_0x01ad:
            okhttp3.logging.HttpLoggingInterceptor$Logger r12 = r1.logger
            java.lang.StringBuilder r11 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r11)
            java.lang.String r13 = r3.method()
            r11.append(r13)
            java.lang.String r13 = " (binary "
            r11.append(r13)
            long r13 = r5.contentLength()
            r11.append(r13)
            r11.append(r6)
            java.lang.String r5 = r11.toString()
            r12.log(r5)
            goto L_0x01e5
        L_0x01d1:
            okhttp3.logging.HttpLoggingInterceptor$Logger r5 = r1.logger
            java.lang.StringBuilder r11 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r11)
            java.lang.String r12 = r3.method()
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            r5.log(r11)
        L_0x01e5:
            long r11 = java.lang.System.nanoTime()
            okhttp3.Response r0 = r0.proceed(r3)     // Catch:{ Exception -> 0x03aa }
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r13 = java.lang.System.nanoTime()
            long r13 = r13 - r11
            long r11 = r3.toMillis(r13)
            okhttp3.ResponseBody r3 = r0.body()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            long r13 = r3.contentLength()
            r15 = -1
            int r5 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r5 == 0) goto L_0x021b
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r13)
            java.lang.String r15 = "-byte"
            r5.append(r15)
            java.lang.String r5 = r5.toString()
            goto L_0x021e
        L_0x021b:
            java.lang.String r5 = "unknown-length"
        L_0x021e:
            okhttp3.logging.HttpLoggingInterceptor$Logger r15 = r1.logger
            java.lang.String r16 = "<-- "
            r17 = r7
            java.lang.StringBuilder r7 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r16)
            r18 = r13
            int r13 = r0.code()
            r7.append(r13)
            java.lang.String r13 = r0.message()
            int r13 = r13.length()
            if (r13 != 0) goto L_0x023d
            r13 = 1
            goto L_0x023e
        L_0x023d:
            r13 = 0
        L_0x023e:
            if (r13 == 0) goto L_0x0244
            r20 = r6
            r6 = r8
            goto L_0x025f
        L_0x0244:
            java.lang.String r13 = r0.message()
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r16 = 32
            r20 = r6
            java.lang.String r6 = java.lang.String.valueOf(r16)
            r14.append(r6)
            r14.append(r13)
            java.lang.String r6 = r14.toString()
        L_0x025f:
            r7.append(r6)
            r6 = 32
            r7.append(r6)
            okhttp3.Request r6 = r0.request()
            okhttp3.HttpUrl r6 = r6.url()
            r7.append(r6)
            r7.append(r9)
            r7.append(r11)
            java.lang.String r6 = "ms"
            r7.append(r6)
            if (r2 != 0) goto L_0x0288
            java.lang.String r6 = ", "
            java.lang.String r9 = " body"
            java.lang.String r5 = com.android.tools.r8.GeneratedOutlineSupport.outline52(r6, r5, r9)
            goto L_0x0289
        L_0x0288:
            r5 = r8
        L_0x0289:
            r7.append(r5)
            r5 = 41
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            r15.log(r5)
            if (r2 == 0) goto L_0x03a9
            okhttp3.Headers r2 = r0.headers()
            int r5 = r2.size()
            r6 = 0
        L_0x02a3:
            if (r6 >= r5) goto L_0x02ab
            r1.logHeader(r2, r6)
            int r6 = r6 + 1
            goto L_0x02a3
        L_0x02ab:
            if (r4 == 0) goto L_0x03a2
            boolean r4 = okhttp3.internal.http.HttpHeaders.promisesBody(r0)
            if (r4 != 0) goto L_0x02b5
            goto L_0x03a2
        L_0x02b5:
            okhttp3.Headers r4 = r0.headers()
            boolean r4 = r1.bodyHasUnknownEncoding(r4)
            if (r4 == 0) goto L_0x02c8
            okhttp3.logging.HttpLoggingInterceptor$Logger r2 = r1.logger
            java.lang.String r3 = "<-- END HTTP (encoded body omitted)"
            r2.log(r3)
            goto L_0x03a9
        L_0x02c8:
            okio.BufferedSource r4 = r3.source()
            r5 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r4.request(r5)
            okio.Buffer r4 = r4.getBuffer()
            java.lang.String r5 = "Content-Encoding"
            java.lang.String r2 = r2.get(r5)
            java.lang.String r5 = "gzip"
            r6 = 1
            boolean r2 = kotlin.text.CharsKt__CharKt.equals(r5, r2, r6)
            r5 = 0
            if (r2 == 0) goto L_0x030f
            long r6 = r4.size()
            java.lang.Long r2 = java.lang.Long.valueOf(r6)
            okio.GzipSource r6 = new okio.GzipSource
            okio.Buffer r4 = r4.clone()
            r6.<init>(r4)
            okio.Buffer r4 = new okio.Buffer     // Catch:{ all -> 0x0306 }
            r4.<init>()     // Catch:{ all -> 0x0306 }
            r4.writeAll(r6)     // Catch:{ all -> 0x0306 }
            com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r6, r5)
            r5 = r2
            goto L_0x030f
        L_0x0306:
            r0 = move-exception
            r2 = r0
            throw r2     // Catch:{ all -> 0x0309 }
        L_0x0309:
            r0 = move-exception
            r3 = r0
            com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r6, r2)
            throw r3
        L_0x030f:
            okhttp3.MediaType r2 = r3.contentType()
            if (r2 == 0) goto L_0x031e
            java.nio.charset.Charset r3 = java.nio.charset.StandardCharsets.UTF_8
            java.nio.charset.Charset r2 = r2.charset(r3)
            if (r2 == 0) goto L_0x031e
            goto L_0x0323
        L_0x031e:
            java.nio.charset.Charset r2 = java.nio.charset.StandardCharsets.UTF_8
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r10)
        L_0x0323:
            boolean r3 = okhttp3.logging.Utf8Kt.isProbablyUtf8(r4)
            if (r3 != 0) goto L_0x034a
            okhttp3.logging.HttpLoggingInterceptor$Logger r2 = r1.logger
            r2.log(r8)
            okhttp3.logging.HttpLoggingInterceptor$Logger r2 = r1.logger
            java.lang.String r3 = "<-- END HTTP (binary "
            java.lang.StringBuilder r3 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r3)
            long r4 = r4.size()
            r3.append(r4)
            r4 = r20
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.log(r3)
            return r0
        L_0x034a:
            r6 = 0
            int r3 = (r18 > r6 ? 1 : (r18 == r6 ? 0 : -1))
            if (r3 == 0) goto L_0x0362
            okhttp3.logging.HttpLoggingInterceptor$Logger r3 = r1.logger
            r3.log(r8)
            okhttp3.logging.HttpLoggingInterceptor$Logger r3 = r1.logger
            okio.Buffer r6 = r4.clone()
            java.lang.String r2 = r6.readString(r2)
            r3.log(r2)
        L_0x0362:
            java.lang.String r2 = "<-- END HTTP ("
            if (r5 == 0) goto L_0x0388
            okhttp3.logging.HttpLoggingInterceptor$Logger r3 = r1.logger
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r2)
            long r6 = r4.size()
            r2.append(r6)
            java.lang.String r4 = "-byte, "
            r2.append(r4)
            r2.append(r5)
            java.lang.String r4 = "-gzipped-byte body)"
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r3.log(r2)
            goto L_0x03a9
        L_0x0388:
            okhttp3.logging.HttpLoggingInterceptor$Logger r3 = r1.logger
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r2)
            long r4 = r4.size()
            r2.append(r4)
            r4 = r17
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r3.log(r2)
            goto L_0x03a9
        L_0x03a2:
            okhttp3.logging.HttpLoggingInterceptor$Logger r2 = r1.logger
            java.lang.String r3 = "<-- END HTTP"
            r2.log(r3)
        L_0x03a9:
            return r0
        L_0x03aa:
            r0 = move-exception
            r2 = r0
            okhttp3.logging.HttpLoggingInterceptor$Logger r0 = r1.logger
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "<-- HTTP FAILED: "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r3 = r3.toString()
            r0.log(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.logging.HttpLoggingInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }

    public final void level(Level level2) {
        Intrinsics.checkNotNullParameter(level2, "<set-?>");
        this.level = level2;
    }

    public final void redactHeader(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        TreeSet treeSet = new TreeSet(CharsKt__CharKt.getCASE_INSENSITIVE_ORDER(StringCompanionObject.INSTANCE));
        TweetUtils.addAll(treeSet, this.headersToRedact);
        treeSet.add(str);
        this.headersToRedact = treeSet;
    }

    public final HttpLoggingInterceptor setLevel(Level level2) {
        Intrinsics.checkNotNullParameter(level2, "level");
        this.level = level2;
        return this;
    }

    public /* synthetic */ HttpLoggingInterceptor(Logger logger2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Logger.DEFAULT : logger2);
    }
}
