package extern.okhttp3;

import extern.okhttp3.internal.NamedRunnable;
import extern.okhttp3.internal.Util;
import extern.okhttp3.internal.cache.CacheInterceptor;
import extern.okhttp3.internal.connection.ConnectInterceptor;
import extern.okhttp3.internal.connection.StreamAllocation;
import extern.okhttp3.internal.http.BridgeInterceptor;
import extern.okhttp3.internal.http.CallServerInterceptor;
import extern.okhttp3.internal.http.RealInterceptorChain;
import extern.okhttp3.internal.http.RetryAndFollowUpInterceptor;
import extern.okhttp3.internal.platform.Platform;
import extern.okio.AsyncTimeout;
import extern.okio.Timeout;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders.Values;

final class RealCall implements Call {
    final OkHttpClient client;
    /* access modifiers changed from: private */
    @Nullable
    public EventListener eventListener;
    private boolean executed;
    final boolean forWebSocket;
    final Request originalRequest;
    final RetryAndFollowUpInterceptor retryAndFollowUpInterceptor;
    final AsyncTimeout timeout = new AsyncTimeout() {
        /* access modifiers changed from: protected */
        public void timedOut() {
            RealCall.this.cancel();
        }
    };

    final class AsyncCall extends NamedRunnable {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final Callback responseCallback;

        AsyncCall(Callback callback) {
            super("OkHttp %s", RealCall.this.redactedUrl());
            this.responseCallback = callback;
        }

        /* access modifiers changed from: 0000 */
        public String host() {
            return RealCall.this.originalRequest.url().host();
        }

        /* access modifiers changed from: 0000 */
        public Request request() {
            return RealCall.this.originalRequest;
        }

        /* access modifiers changed from: 0000 */
        public RealCall get() {
            return RealCall.this;
        }

        /* access modifiers changed from: 0000 */
        public void executeOn(ExecutorService executorService) {
            try {
                executorService.execute(this);
            } catch (RejectedExecutionException e2) {
                InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                interruptedIOException.initCause(e2);
                RealCall.this.eventListener.callFailed(RealCall.this, interruptedIOException);
                this.responseCallback.onFailure(RealCall.this, interruptedIOException);
                RealCall.this.client.dispatcher().finished(this);
            } catch (Throwable th) {
                RealCall.this.client.dispatcher().finished(this);
                throw th;
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0032 A[Catch:{ IOException -> 0x0050, Throwable -> 0x0028, all -> 0x0026 }] */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x005b A[Catch:{ IOException -> 0x0050, Throwable -> 0x0028, all -> 0x0026 }] */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x007b A[Catch:{ IOException -> 0x0050, Throwable -> 0x0028, all -> 0x0026 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void execute() {
            /*
                r5 = this;
                extern.okhttp3.RealCall r0 = extern.okhttp3.RealCall.this
                extern.okio.AsyncTimeout r0 = r0.timeout
                r0.enter()
                r0 = 0
                extern.okhttp3.RealCall r1 = extern.okhttp3.RealCall.this     // Catch:{ IOException -> 0x0050, Throwable -> 0x0028 }
                extern.okhttp3.Response r0 = r1.getResponseWithInterceptorChain()     // Catch:{ IOException -> 0x0050, Throwable -> 0x0028 }
                r1 = 1
                extern.okhttp3.Callback r2 = r5.responseCallback     // Catch:{ IOException -> 0x0024, Throwable -> 0x0022 }
                extern.okhttp3.RealCall r3 = extern.okhttp3.RealCall.this     // Catch:{ IOException -> 0x0024, Throwable -> 0x0022 }
                r2.onResponse(r3, r0)     // Catch:{ IOException -> 0x0024, Throwable -> 0x0022 }
            L_0x0016:
                extern.okhttp3.RealCall r0 = extern.okhttp3.RealCall.this
                extern.okhttp3.OkHttpClient r0 = r0.client
                extern.okhttp3.Dispatcher r0 = r0.dispatcher()
                r0.finished(r5)
                goto L_0x008e
            L_0x0022:
                r0 = move-exception
                goto L_0x002b
            L_0x0024:
                r0 = move-exception
                goto L_0x0053
            L_0x0026:
                r0 = move-exception
                goto L_0x008f
            L_0x0028:
                r1 = move-exception
                r0 = r1
                r1 = 0
            L_0x002b:
                extern.okhttp3.RealCall r2 = extern.okhttp3.RealCall.this     // Catch:{ all -> 0x0026 }
                r2.cancel()     // Catch:{ all -> 0x0026 }
                if (r1 != 0) goto L_0x004f
                java.io.IOException r1 = new java.io.IOException     // Catch:{ all -> 0x0026 }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0026 }
                r2.<init>()     // Catch:{ all -> 0x0026 }
                java.lang.String r3 = "canceled due to "
                r2.append(r3)     // Catch:{ all -> 0x0026 }
                r2.append(r0)     // Catch:{ all -> 0x0026 }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0026 }
                r1.<init>(r2)     // Catch:{ all -> 0x0026 }
                extern.okhttp3.Callback r2 = r5.responseCallback     // Catch:{ all -> 0x0026 }
                extern.okhttp3.RealCall r3 = extern.okhttp3.RealCall.this     // Catch:{ all -> 0x0026 }
                r2.onFailure(r3, r1)     // Catch:{ all -> 0x0026 }
            L_0x004f:
                throw r0     // Catch:{ all -> 0x0026 }
            L_0x0050:
                r1 = move-exception
                r0 = r1
                r1 = 0
            L_0x0053:
                extern.okhttp3.RealCall r2 = extern.okhttp3.RealCall.this     // Catch:{ all -> 0x0026 }
                java.io.IOException r0 = r2.timeoutExit(r0)     // Catch:{ all -> 0x0026 }
                if (r1 == 0) goto L_0x007b
                extern.okhttp3.internal.platform.Platform r1 = extern.okhttp3.internal.platform.Platform.get()     // Catch:{ all -> 0x0026 }
                r2 = 4
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0026 }
                r3.<init>()     // Catch:{ all -> 0x0026 }
                java.lang.String r4 = "Callback failure for "
                r3.append(r4)     // Catch:{ all -> 0x0026 }
                extern.okhttp3.RealCall r4 = extern.okhttp3.RealCall.this     // Catch:{ all -> 0x0026 }
                java.lang.String r4 = r4.toLoggableString()     // Catch:{ all -> 0x0026 }
                r3.append(r4)     // Catch:{ all -> 0x0026 }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0026 }
                r1.log(r2, r3, r0)     // Catch:{ all -> 0x0026 }
                goto L_0x0016
            L_0x007b:
                extern.okhttp3.RealCall r1 = extern.okhttp3.RealCall.this     // Catch:{ all -> 0x0026 }
                extern.okhttp3.EventListener r1 = r1.eventListener     // Catch:{ all -> 0x0026 }
                extern.okhttp3.RealCall r2 = extern.okhttp3.RealCall.this     // Catch:{ all -> 0x0026 }
                r1.callFailed(r2, r0)     // Catch:{ all -> 0x0026 }
                extern.okhttp3.Callback r1 = r5.responseCallback     // Catch:{ all -> 0x0026 }
                extern.okhttp3.RealCall r2 = extern.okhttp3.RealCall.this     // Catch:{ all -> 0x0026 }
                r1.onFailure(r2, r0)     // Catch:{ all -> 0x0026 }
                goto L_0x0016
            L_0x008e:
                return
            L_0x008f:
                extern.okhttp3.RealCall r1 = extern.okhttp3.RealCall.this
                extern.okhttp3.OkHttpClient r1 = r1.client
                extern.okhttp3.Dispatcher r1 = r1.dispatcher()
                r1.finished(r5)
                goto L_0x009c
            L_0x009b:
                throw r0
            L_0x009c:
                goto L_0x009b
            */
            throw new UnsupportedOperationException("Method not decompiled: extern.okhttp3.RealCall.AsyncCall.execute():void");
        }
    }

    private RealCall(OkHttpClient okHttpClient, Request request, boolean z) {
        this.client = okHttpClient;
        this.originalRequest = request;
        this.forWebSocket = z;
        this.retryAndFollowUpInterceptor = new RetryAndFollowUpInterceptor(okHttpClient, z);
        this.timeout.timeout((long) okHttpClient.callTimeoutMillis(), TimeUnit.MILLISECONDS);
    }

    static RealCall newRealCall(OkHttpClient okHttpClient, Request request, boolean z) {
        RealCall realCall = new RealCall(okHttpClient, request, z);
        realCall.eventListener = okHttpClient.eventListenerFactory().create(realCall);
        return realCall;
    }

    public Request request() {
        return this.originalRequest;
    }

    public Response execute() throws IOException {
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        captureCallStackTrace();
        this.timeout.enter();
        this.eventListener.callStart(this);
        try {
            this.client.dispatcher().executed(this);
            Response responseWithInterceptorChain = getResponseWithInterceptorChain();
            if (responseWithInterceptorChain != null) {
                this.client.dispatcher().finished(this);
                return responseWithInterceptorChain;
            }
            throw new IOException("Canceled");
        } catch (IOException e2) {
            IOException timeoutExit = timeoutExit(e2);
            this.eventListener.callFailed(this, timeoutExit);
            throw timeoutExit;
        } catch (Throwable th) {
            this.client.dispatcher().finished(this);
            throw th;
        }
    }

    /* access modifiers changed from: 0000 */
    @Nullable
    public IOException timeoutExit(@Nullable IOException iOException) {
        if (!this.timeout.exit()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException(Values.TIMEOUT);
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    private void captureCallStackTrace() {
        this.retryAndFollowUpInterceptor.setCallStackTrace(Platform.get().getStackTraceForCloseable("response.body().close()"));
    }

    public void enqueue(Callback callback) {
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        captureCallStackTrace();
        this.eventListener.callStart(this);
        this.client.dispatcher().enqueue(new AsyncCall(callback));
    }

    public void cancel() {
        this.retryAndFollowUpInterceptor.cancel();
    }

    public Timeout timeout() {
        return this.timeout;
    }

    public synchronized boolean isExecuted() {
        return this.executed;
    }

    public boolean isCanceled() {
        return this.retryAndFollowUpInterceptor.isCanceled();
    }

    public RealCall clone() {
        return newRealCall(this.client, this.originalRequest, this.forWebSocket);
    }

    /* access modifiers changed from: 0000 */
    public StreamAllocation streamAllocation() {
        return this.retryAndFollowUpInterceptor.streamAllocation();
    }

    /* access modifiers changed from: 0000 */
    public String toLoggableString() {
        StringBuilder sb = new StringBuilder();
        sb.append(isCanceled() ? "canceled " : "");
        sb.append(this.forWebSocket ? "web socket" : "call");
        sb.append(" to ");
        sb.append(redactedUrl());
        return sb.toString();
    }

    /* access modifiers changed from: 0000 */
    public String redactedUrl() {
        return this.originalRequest.url().redact();
    }

    /* access modifiers changed from: 0000 */
    public Response getResponseWithInterceptorChain() throws IOException {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.client.interceptors());
        arrayList.add(this.retryAndFollowUpInterceptor);
        arrayList.add(new BridgeInterceptor(this.client.cookieJar()));
        arrayList.add(new CacheInterceptor(this.client.internalCache()));
        arrayList.add(new ConnectInterceptor(this.client));
        if (!this.forWebSocket) {
            arrayList.addAll(this.client.networkInterceptors());
        }
        arrayList.add(new CallServerInterceptor(this.forWebSocket));
        RealInterceptorChain realInterceptorChain = new RealInterceptorChain(arrayList, null, null, null, 0, this.originalRequest, this, this.eventListener, this.client.connectTimeoutMillis(), this.client.readTimeoutMillis(), this.client.writeTimeoutMillis());
        Response proceed = realInterceptorChain.proceed(this.originalRequest);
        if (!this.retryAndFollowUpInterceptor.isCanceled()) {
            return proceed;
        }
        Util.closeQuietly((Closeable) proceed);
        throw new IOException("Canceled");
    }
}
