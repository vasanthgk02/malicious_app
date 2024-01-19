package okhttp3;

import android.support.v4.media.session.PlaybackStateCompat;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.mpl.androidapp.utils.Constant;
import com.netcore.android.notification.SMTNotificationConstants;
import com.smartfoxserver.bitswarm.util.Logging;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http1.HeadersReader;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Options;
import okio.Source;
import okio.Timeout;
import org.apache.fontbox.cmap.CMap;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u0001:\u0003\u001c\u001d\u001eB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bR\u0013\u0010\u0007\u001a\u00020\b8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0018\u00010\u0010R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lokhttp3/MultipartReader;", "Ljava/io/Closeable;", "response", "Lokhttp3/ResponseBody;", "(Lokhttp3/ResponseBody;)V", "source", "Lokio/BufferedSource;", "boundary", "", "(Lokio/BufferedSource;Ljava/lang/String;)V", "()Ljava/lang/String;", "closed", "", "crlfDashDashBoundary", "Lokio/ByteString;", "currentPart", "Lokhttp3/MultipartReader$PartSource;", "dashDashBoundary", "noMoreParts", "partCount", "", "close", "", "currentPartBytesRemaining", "", "maxResult", "nextPart", "Lokhttp3/MultipartReader$Part;", "Companion", "Part", "PartSource", "okhttp"}, k = 1, mv = {1, 4, 0})
/* compiled from: MultipartReader.kt */
public final class MultipartReader implements Closeable {
    public static final Companion Companion = new Companion(null);
    public static final Options afterBoundaryOptions = Options.Companion.of(ByteString.Companion.encodeUtf8("\r\n"), ByteString.Companion.encodeUtf8("--"), ByteString.Companion.encodeUtf8(CMap.SPACE), ByteString.Companion.encodeUtf8(Logging.TAB));
    public final String boundary;
    public boolean closed;
    public final ByteString crlfDashDashBoundary;
    public PartSource currentPart;
    public final ByteString dashDashBoundary;
    public boolean noMoreParts;
    public int partCount;
    public final BufferedSource source;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lokhttp3/MultipartReader$Companion;", "", "()V", "afterBoundaryOptions", "Lokio/Options;", "getAfterBoundaryOptions", "()Lokio/Options;", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* compiled from: MultipartReader.kt */
    public static final class Companion {
        public Companion() {
        }

        public final Options getAfterBoundaryOptions() {
            return MultipartReader.afterBoundaryOptions;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\t\u001a\u00020\nH\u0001R\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\b¨\u0006\u000b"}, d2 = {"Lokhttp3/MultipartReader$Part;", "Ljava/io/Closeable;", "headers", "Lokhttp3/Headers;", "body", "Lokio/BufferedSource;", "(Lokhttp3/Headers;Lokio/BufferedSource;)V", "()Lokio/BufferedSource;", "()Lokhttp3/Headers;", "close", "", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* compiled from: MultipartReader.kt */
    public static final class Part implements Closeable {
        public final BufferedSource body;
        public final Headers headers;

        public Part(Headers headers2, BufferedSource bufferedSource) {
            Intrinsics.checkNotNullParameter(headers2, Constant.HEADER);
            Intrinsics.checkNotNullParameter(bufferedSource, SMTNotificationConstants.NOTIF_BODY_KEY);
            this.headers = headers2;
            this.body = bufferedSource;
        }

        public final BufferedSource body() {
            return this.body;
        }

        public void close() {
            this.body.close();
        }

        public final Headers headers() {
            return this.headers;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\u0003\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lokhttp3/MultipartReader$PartSource;", "Lokio/Source;", "(Lokhttp3/MultipartReader;)V", "timeout", "Lokio/Timeout;", "close", "", "read", "", "sink", "Lokio/Buffer;", "byteCount", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* compiled from: MultipartReader.kt */
    public final class PartSource implements Source {
        public final Timeout timeout = new Timeout();

        public PartSource() {
        }

        public void close() {
            if (Intrinsics.areEqual(MultipartReader.this.currentPart, this)) {
                MultipartReader.this.currentPart = null;
            }
        }

        public long read(Buffer buffer, long j) {
            long j2;
            long j3;
            Intrinsics.checkNotNullParameter(buffer, "sink");
            if (!(j >= 0)) {
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline45("byteCount < 0: ", j).toString());
            } else if (Intrinsics.areEqual(MultipartReader.this.currentPart, this)) {
                Timeout timeout2 = MultipartReader.this.source.timeout();
                Timeout timeout3 = this.timeout;
                long timeoutNanos = timeout2.timeoutNanos();
                timeout2.timeout(Timeout.Companion.minTimeout(timeout3.timeoutNanos(), timeout2.timeoutNanos()), TimeUnit.NANOSECONDS);
                if (timeout2.hasDeadline()) {
                    long deadlineNanoTime = timeout2.deadlineNanoTime();
                    if (timeout3.hasDeadline()) {
                        timeout2.deadlineNanoTime(Math.min(timeout2.deadlineNanoTime(), timeout3.deadlineNanoTime()));
                    }
                    try {
                        long access$currentPartBytesRemaining = MultipartReader.this.currentPartBytesRemaining(j);
                        if (access$currentPartBytesRemaining == 0) {
                            j3 = -1;
                        } else {
                            j3 = MultipartReader.this.source.read(buffer, access$currentPartBytesRemaining);
                        }
                        return j3;
                    } finally {
                        timeout2.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                        if (timeout3.hasDeadline()) {
                            timeout2.deadlineNanoTime(deadlineNanoTime);
                        }
                    }
                } else {
                    if (timeout3.hasDeadline()) {
                        timeout2.deadlineNanoTime(timeout3.deadlineNanoTime());
                    }
                    try {
                        long access$currentPartBytesRemaining2 = MultipartReader.this.currentPartBytesRemaining(j);
                        if (access$currentPartBytesRemaining2 == 0) {
                            j2 = -1;
                        } else {
                            j2 = MultipartReader.this.source.read(buffer, access$currentPartBytesRemaining2);
                        }
                        return j2;
                    } finally {
                        timeout2.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                        if (timeout3.hasDeadline()) {
                            timeout2.clearDeadline();
                        }
                    }
                }
            } else {
                throw new IllegalStateException("closed".toString());
            }
        }

        public Timeout timeout() {
            return this.timeout;
        }
    }

    public MultipartReader(BufferedSource bufferedSource, String str) throws IOException {
        Intrinsics.checkNotNullParameter(bufferedSource, DefaultSettingsSpiCall.SOURCE_PARAM);
        Intrinsics.checkNotNullParameter(str, "boundary");
        this.source = bufferedSource;
        this.boundary = str;
        this.dashDashBoundary = new Buffer().writeUtf8((String) "--").writeUtf8(this.boundary).readByteString();
        this.crlfDashDashBoundary = new Buffer().writeUtf8((String) "\r\n--").writeUtf8(this.boundary).readByteString();
    }

    /* access modifiers changed from: private */
    public final long currentPartBytesRemaining(long j) {
        this.source.require((long) this.crlfDashDashBoundary.size());
        long indexOf = this.source.getBuffer().indexOf(this.crlfDashDashBoundary);
        if (indexOf == -1) {
            return Math.min(j, (this.source.getBuffer().size() - ((long) this.crlfDashDashBoundary.size())) + 1);
        }
        return Math.min(j, indexOf);
    }

    public final String boundary() {
        return this.boundary;
    }

    public void close() throws IOException {
        if (!this.closed) {
            this.closed = true;
            this.currentPart = null;
            this.source.close();
        }
    }

    public final Part nextPart() throws IOException {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        } else if (this.noMoreParts) {
            return null;
        } else {
            if (this.partCount != 0 || !this.source.rangeEquals(0, this.dashDashBoundary)) {
                while (true) {
                    long currentPartBytesRemaining = currentPartBytesRemaining(PlaybackStateCompat.ACTION_PLAY_FROM_URI);
                    if (currentPartBytesRemaining == 0) {
                        break;
                    }
                    this.source.skip(currentPartBytesRemaining);
                }
                this.source.skip((long) this.crlfDashDashBoundary.size());
            } else {
                this.source.skip((long) this.dashDashBoundary.size());
            }
            boolean z = false;
            while (true) {
                int select = this.source.select(afterBoundaryOptions);
                if (select == -1) {
                    throw new ProtocolException("unexpected characters after boundary");
                } else if (select == 0) {
                    this.partCount++;
                    Headers readHeaders = new HeadersReader(this.source).readHeaders();
                    PartSource partSource = new PartSource();
                    this.currentPart = partSource;
                    return new Part(readHeaders, Okio.buffer((Source) partSource));
                } else if (select != 1) {
                    if (select == 2 || select == 3) {
                        z = true;
                    }
                } else if (z) {
                    throw new ProtocolException("unexpected characters after boundary");
                } else if (this.partCount != 0) {
                    this.noMoreParts = true;
                    return null;
                } else {
                    throw new ProtocolException("expected at least 1 part");
                }
            }
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MultipartReader(okhttp3.ResponseBody r3) throws java.io.IOException {
        /*
            r2 = this;
            java.lang.String r0 = "response"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            okio.BufferedSource r0 = r3.source()
            okhttp3.MediaType r3 = r3.contentType()
            if (r3 == 0) goto L_0x001b
            java.lang.String r1 = "boundary"
            java.lang.String r3 = r3.parameter(r1)
            if (r3 == 0) goto L_0x001b
            r2.<init>(r0, r3)
            return
        L_0x001b:
            java.net.ProtocolException r3 = new java.net.ProtocolException
            java.lang.String r0 = "expected the Content-Type to have a boundary parameter"
            r3.<init>(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.MultipartReader.<init>(okhttp3.ResponseBody):void");
    }
}