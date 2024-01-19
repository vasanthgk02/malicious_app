package okhttp3.internal.http;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\b¢\u0006\u0002\u0010\u0010J\b\u0010\u0002\u001a\u00020\u001cH\u0016J\b\u0010\r\u001a\u00020\bH\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016JK\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\bH\u0000¢\u0006\u0002\b J\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010#\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020&H\u0016J\u0018\u0010'\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020&H\u0016J\u0018\u0010(\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020&H\u0016J\b\u0010\u000f\u001a\u00020\bH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0014\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u000f\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015¨\u0006)"}, d2 = {"Lokhttp3/internal/http/RealInterceptorChain;", "Lokhttp3/Interceptor$Chain;", "call", "Lokhttp3/internal/connection/RealCall;", "interceptors", "", "Lokhttp3/Interceptor;", "index", "", "exchange", "Lokhttp3/internal/connection/Exchange;", "request", "Lokhttp3/Request;", "connectTimeoutMillis", "readTimeoutMillis", "writeTimeoutMillis", "(Lokhttp3/internal/connection/RealCall;Ljava/util/List;ILokhttp3/internal/connection/Exchange;Lokhttp3/Request;III)V", "getCall$okhttp", "()Lokhttp3/internal/connection/RealCall;", "calls", "getConnectTimeoutMillis$okhttp", "()I", "getExchange$okhttp", "()Lokhttp3/internal/connection/Exchange;", "getReadTimeoutMillis$okhttp", "getRequest$okhttp", "()Lokhttp3/Request;", "getWriteTimeoutMillis$okhttp", "Lokhttp3/Call;", "connection", "Lokhttp3/Connection;", "copy", "copy$okhttp", "proceed", "Lokhttp3/Response;", "withConnectTimeout", "timeout", "unit", "Ljava/util/concurrent/TimeUnit;", "withReadTimeout", "withWriteTimeout", "okhttp"}, k = 1, mv = {1, 4, 0})
/* compiled from: RealInterceptorChain.kt */
public final class RealInterceptorChain implements Chain {
    public final RealCall call;
    public int calls;
    public final int connectTimeoutMillis;
    public final Exchange exchange;
    public final int index;
    public final List<Interceptor> interceptors;
    public final int readTimeoutMillis;
    public final Request request;
    public final int writeTimeoutMillis;

    public RealInterceptorChain(RealCall realCall, List<? extends Interceptor> list, int i, Exchange exchange2, Request request2, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(realCall, "call");
        Intrinsics.checkNotNullParameter(list, "interceptors");
        Intrinsics.checkNotNullParameter(request2, "request");
        this.call = realCall;
        this.interceptors = list;
        this.index = i;
        this.exchange = exchange2;
        this.request = request2;
        this.connectTimeoutMillis = i2;
        this.readTimeoutMillis = i3;
        this.writeTimeoutMillis = i4;
    }

    public static /* synthetic */ RealInterceptorChain copy$okhttp$default(RealInterceptorChain realInterceptorChain, int i, Exchange exchange2, Request request2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = realInterceptorChain.index;
        }
        if ((i5 & 2) != 0) {
            exchange2 = realInterceptorChain.exchange;
        }
        Exchange exchange3 = exchange2;
        if ((i5 & 4) != 0) {
            request2 = realInterceptorChain.request;
        }
        Request request3 = request2;
        if ((i5 & 8) != 0) {
            i2 = realInterceptorChain.connectTimeoutMillis;
        }
        int i6 = i2;
        if ((i5 & 16) != 0) {
            i3 = realInterceptorChain.readTimeoutMillis;
        }
        int i7 = i3;
        if ((i5 & 32) != 0) {
            i4 = realInterceptorChain.writeTimeoutMillis;
        }
        return realInterceptorChain.copy$okhttp(i, exchange3, request3, i6, i7, i4);
    }

    public Call call() {
        return this.call;
    }

    public int connectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    public Connection connection() {
        Exchange exchange2 = this.exchange;
        if (exchange2 != null) {
            return exchange2.getConnection$okhttp();
        }
        return null;
    }

    public final RealInterceptorChain copy$okhttp(int i, Exchange exchange2, Request request2, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(request2, "request");
        RealInterceptorChain realInterceptorChain = new RealInterceptorChain(this.call, this.interceptors, i, exchange2, request2, i2, i3, i4);
        return realInterceptorChain;
    }

    public final RealCall getCall$okhttp() {
        return this.call;
    }

    public final int getConnectTimeoutMillis$okhttp() {
        return this.connectTimeoutMillis;
    }

    public final Exchange getExchange$okhttp() {
        return this.exchange;
    }

    public final int getReadTimeoutMillis$okhttp() {
        return this.readTimeoutMillis;
    }

    public final Request getRequest$okhttp() {
        return this.request;
    }

    public final int getWriteTimeoutMillis$okhttp() {
        return this.writeTimeoutMillis;
    }

    public Response proceed(Request request2) throws IOException {
        Intrinsics.checkNotNullParameter(request2, "request");
        boolean z = false;
        if (this.index < this.interceptors.size()) {
            this.calls++;
            Exchange exchange2 = this.exchange;
            if (exchange2 != null) {
                if (exchange2.getFinder$okhttp().sameHostAndPort(request2.url())) {
                    if (!(this.calls == 1)) {
                        StringBuilder outline73 = GeneratedOutlineSupport.outline73("network interceptor ");
                        outline73.append(this.interceptors.get(this.index - 1));
                        outline73.append(" must call proceed() exactly once");
                        throw new IllegalStateException(outline73.toString().toString());
                    }
                } else {
                    StringBuilder outline732 = GeneratedOutlineSupport.outline73("network interceptor ");
                    outline732.append(this.interceptors.get(this.index - 1));
                    outline732.append(" must retain the same host and port");
                    throw new IllegalStateException(outline732.toString().toString());
                }
            }
            RealInterceptorChain copy$okhttp$default = copy$okhttp$default(this, this.index + 1, null, request2, 0, 0, 0, 58, null);
            Response intercept = this.interceptors.get(this.index).intercept(copy$okhttp$default);
            if (intercept != null) {
                if (this.exchange != null) {
                    if (!(this.index + 1 >= this.interceptors.size() || copy$okhttp$default.calls == 1)) {
                        throw new IllegalStateException(("network interceptor " + r0 + " must call proceed() exactly once").toString());
                    }
                }
                if (intercept.body() != null) {
                    z = true;
                }
                if (z) {
                    return intercept;
                }
                throw new IllegalStateException(("interceptor " + r0 + " returned a response with no body").toString());
            }
            throw new NullPointerException("interceptor " + r0 + " returned null");
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public int readTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    public Request request() {
        return this.request;
    }

    public Chain withConnectTimeout(int i, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(timeUnit, "unit");
        if (this.exchange == null) {
            return copy$okhttp$default(this, 0, null, null, Util.checkDuration("connectTimeout", (long) i, timeUnit), 0, 0, 55, null);
        }
        throw new IllegalStateException("Timeouts can't be adjusted in a network interceptor".toString());
    }

    public Chain withReadTimeout(int i, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(timeUnit, "unit");
        if (this.exchange == null) {
            return copy$okhttp$default(this, 0, null, null, 0, Util.checkDuration("readTimeout", (long) i, timeUnit), 0, 47, null);
        }
        throw new IllegalStateException("Timeouts can't be adjusted in a network interceptor".toString());
    }

    public Chain withWriteTimeout(int i, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(timeUnit, "unit");
        if (this.exchange == null) {
            return copy$okhttp$default(this, 0, null, null, 0, 0, Util.checkDuration("writeTimeout", (long) i, timeUnit), 31, null);
        }
        throw new IllegalStateException("Timeouts can't be adjusted in a network interceptor".toString());
    }

    public int writeTimeoutMillis() {
        return this.writeTimeoutMillis;
    }
}
