package io.sentry.transport;

import com.android.tools.r8.GeneratedOutlineSupport;
import io.sentry.ILogger;
import io.sentry.RequestDetails;
import io.sentry.SentryEnvelope;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.cache.IEnvelopeCache;
import io.sentry.hints.Cached;
import io.sentry.hints.DiskFlushNotification;
import io.sentry.hints.Retryable;
import io.sentry.hints.SubmissionResult;
import io.sentry.transport.ITransport.CC;
import io.sentry.util.LogUtils;
import io.sentry.util.Objects;
import java.io.IOException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class AsyncHttpTransport implements ITransport {
    public final HttpConnection connection;
    public final IEnvelopeCache envelopeCache;
    public final QueuedThreadPoolExecutor executor;
    public final SentryOptions options;
    public final RateLimiter rateLimiter;
    public final ITransportGate transportGate;

    public static final class AsyncConnectionThreadFactory implements ThreadFactory {
        public int cnt;

        public AsyncConnectionThreadFactory() {
        }

        public Thread newThread(Runnable runnable) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("SentryAsyncConnection-");
            int i = this.cnt;
            this.cnt = i + 1;
            outline73.append(i);
            Thread thread = new Thread(runnable, outline73.toString());
            thread.setDaemon(true);
            return thread;
        }
    }

    public final class EnvelopeSender implements Runnable {
        public final SentryEnvelope envelope;
        public final IEnvelopeCache envelopeCache;
        public final TransportResult failedResult = TransportResult.error();
        public final Object hint;

        public EnvelopeSender(SentryEnvelope sentryEnvelope, Object obj, IEnvelopeCache iEnvelopeCache) {
            this.envelope = (SentryEnvelope) Objects.requireNonNull(sentryEnvelope, "Envelope is required.");
            this.hint = obj;
            this.envelopeCache = (IEnvelopeCache) Objects.requireNonNull(iEnvelopeCache, "EnvelopeCache is required.");
        }

        private TransportResult flush() {
            TransportResult transportResult = this.failedResult;
            this.envelopeCache.store(this.envelope, this.hint);
            Object obj = this.hint;
            if (obj instanceof DiskFlushNotification) {
                ((DiskFlushNotification) obj).markFlushed();
                AsyncHttpTransport.this.options.getLogger().log(SentryLevel.DEBUG, (String) "Disk flush envelope fired", new Object[0]);
            }
            if (AsyncHttpTransport.this.transportGate.isConnected()) {
                try {
                    transportResult = AsyncHttpTransport.this.connection.send(this.envelope);
                    if (transportResult.isSuccess()) {
                        this.envelopeCache.discard(this.envelope);
                    } else {
                        String str = "The transport failed to send the envelope with response code " + transportResult.getResponseCode();
                        AsyncHttpTransport.this.options.getLogger().log(SentryLevel.ERROR, str, new Object[0]);
                        throw new IllegalStateException(str);
                    }
                } catch (IOException e2) {
                    Object obj2 = this.hint;
                    if (obj2 instanceof Retryable) {
                        ((Retryable) obj2).setRetry(true);
                    } else {
                        LogUtils.logIfNotRetryable(AsyncHttpTransport.this.options.getLogger(), this.hint);
                    }
                    throw new IllegalStateException("Sending the event failed.", e2);
                }
            } else {
                Object obj3 = this.hint;
                if (obj3 instanceof Retryable) {
                    ((Retryable) obj3).setRetry(true);
                } else {
                    LogUtils.logIfNotRetryable(AsyncHttpTransport.this.options.getLogger(), this.hint);
                }
            }
            return transportResult;
        }

        public void run() {
            TransportResult transportResult = this.failedResult;
            try {
                transportResult = flush();
                AsyncHttpTransport.this.options.getLogger().log(SentryLevel.DEBUG, (String) "Envelope flushed", new Object[0]);
                if (this.hint instanceof SubmissionResult) {
                    AsyncHttpTransport.this.options.getLogger().log(SentryLevel.DEBUG, (String) "Marking envelope submission result: %s", Boolean.valueOf(transportResult.isSuccess()));
                    ((SubmissionResult) this.hint).setResult(transportResult.isSuccess());
                }
            } catch (Exception e2) {
                AsyncHttpTransport.this.options.getLogger().log(SentryLevel.ERROR, e2, "Envelope submission failed", new Object[0]);
                throw e2;
            } catch (Throwable th) {
                if (this.hint instanceof SubmissionResult) {
                    AsyncHttpTransport.this.options.getLogger().log(SentryLevel.DEBUG, (String) "Marking envelope submission result: %s", Boolean.valueOf(transportResult.isSuccess()));
                    ((SubmissionResult) this.hint).setResult(transportResult.isSuccess());
                }
                throw th;
            }
        }
    }

    public AsyncHttpTransport(SentryOptions sentryOptions, RateLimiter rateLimiter2, ITransportGate iTransportGate, RequestDetails requestDetails) {
        this(initExecutor(sentryOptions.getMaxQueueSize(), sentryOptions.getEnvelopeDiskCache(), sentryOptions.getLogger()), sentryOptions, rateLimiter2, iTransportGate, new HttpConnection(sentryOptions, requestDetails, rateLimiter2));
    }

    public static QueuedThreadPoolExecutor initExecutor(int i, IEnvelopeCache iEnvelopeCache, ILogger iLogger) {
        int i2 = i;
        QueuedThreadPoolExecutor queuedThreadPoolExecutor = new QueuedThreadPoolExecutor(1, i2, new AsyncConnectionThreadFactory(), new RejectedExecutionHandler(iLogger) {
            public final /* synthetic */ ILogger f$1;

            {
                this.f$1 = r2;
            }

            public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                AsyncHttpTransport.lambda$initExecutor$0(IEnvelopeCache.this, this.f$1, runnable, threadPoolExecutor);
            }
        }, iLogger);
        return queuedThreadPoolExecutor;
    }

    public static /* synthetic */ void lambda$initExecutor$0(IEnvelopeCache iEnvelopeCache, ILogger iLogger, Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        if (runnable instanceof EnvelopeSender) {
            EnvelopeSender envelopeSender = (EnvelopeSender) runnable;
            if (!(envelopeSender.hint instanceof Cached)) {
                iEnvelopeCache.store(envelopeSender.envelope, envelopeSender.hint);
            }
            markHintWhenSendingFailed(envelopeSender.hint, true);
            iLogger.log(SentryLevel.WARNING, (String) "Envelope rejected", new Object[0]);
        }
    }

    public static void markHintWhenSendingFailed(Object obj, boolean z) {
        if (obj instanceof SubmissionResult) {
            ((SubmissionResult) obj).setResult(false);
        }
        if (obj instanceof Retryable) {
            ((Retryable) obj).setRetry(z);
        }
    }

    public void close() throws IOException {
        this.executor.shutdown();
        this.options.getLogger().log(SentryLevel.DEBUG, (String) "Shutting down", new Object[0]);
        try {
            if (!this.executor.awaitTermination(1, TimeUnit.MINUTES)) {
                this.options.getLogger().log(SentryLevel.WARNING, (String) "Failed to shutdown the async connection async sender within 1 minute. Trying to force it now.", new Object[0]);
                this.executor.shutdownNow();
            }
        } catch (InterruptedException unused) {
            this.options.getLogger().log(SentryLevel.DEBUG, (String) "Thread interrupted while closing the connection.", new Object[0]);
            Thread.currentThread().interrupt();
        }
    }

    public void flush(long j) {
        this.executor.waitTillIdle(j);
    }

    public /* synthetic */ void send(SentryEnvelope sentryEnvelope) throws IOException {
        CC.$default$send(this, sentryEnvelope);
    }

    public void send(SentryEnvelope sentryEnvelope, Object obj) throws IOException {
        IEnvelopeCache iEnvelopeCache = this.envelopeCache;
        boolean z = false;
        if (obj instanceof Cached) {
            iEnvelopeCache = NoOpEnvelopeCache.getInstance();
            this.options.getLogger().log(SentryLevel.DEBUG, (String) "Captured Envelope is already cached", new Object[0]);
            z = true;
        }
        SentryEnvelope filter = this.rateLimiter.filter(sentryEnvelope, obj);
        if (filter != null) {
            this.executor.submit(new EnvelopeSender(filter, obj, iEnvelopeCache));
        } else if (z) {
            this.envelopeCache.discard(sentryEnvelope);
        }
    }

    public AsyncHttpTransport(QueuedThreadPoolExecutor queuedThreadPoolExecutor, SentryOptions sentryOptions, RateLimiter rateLimiter2, ITransportGate iTransportGate, HttpConnection httpConnection) {
        this.executor = (QueuedThreadPoolExecutor) Objects.requireNonNull(queuedThreadPoolExecutor, "executor is required");
        this.envelopeCache = (IEnvelopeCache) Objects.requireNonNull(sentryOptions.getEnvelopeDiskCache(), "envelopeCache is required");
        this.options = (SentryOptions) Objects.requireNonNull(sentryOptions, "options is required");
        this.rateLimiter = (RateLimiter) Objects.requireNonNull(rateLimiter2, "rateLimiter is required");
        this.transportGate = (ITransportGate) Objects.requireNonNull(iTransportGate, "transportGate is required");
        this.connection = (HttpConnection) Objects.requireNonNull(httpConnection, "httpConnection is required");
    }
}
