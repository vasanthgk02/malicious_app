package io.sentry;

import com.android.tools.r8.GeneratedOutlineSupport;
import io.sentry.util.Objects;
import java.net.InetAddress;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

public final class HostnameCache {
    public static final long GET_HOSTNAME_TIMEOUT = TimeUnit.SECONDS.toMillis(1);
    public static final long HOSTNAME_CACHE_DURATION = TimeUnit.HOURS.toMillis(5);
    public final long cacheDuration;
    public final ExecutorService executorService;
    public volatile long expirationTimestamp;
    public final Callable<InetAddress> getLocalhost;
    public volatile String hostname;
    public final AtomicBoolean updateRunning;

    public static final class HostnameCacheThreadFactory implements ThreadFactory {
        public int cnt;

        public HostnameCacheThreadFactory() {
        }

        public Thread newThread(Runnable runnable) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("SentryHostnameCache-");
            int i = this.cnt;
            this.cnt = i + 1;
            outline73.append(i);
            Thread thread = new Thread(runnable, outline73.toString());
            thread.setDaemon(true);
            return thread;
        }
    }

    public HostnameCache() {
        this(HOSTNAME_CACHE_DURATION);
    }

    private void handleCacheUpdateFailure() {
        this.expirationTimestamp = TimeUnit.SECONDS.toMillis(1) + System.currentTimeMillis();
    }

    private void updateCache() {
        try {
            this.executorService.submit(new Callable() {
                public final Object call() {
                    return HostnameCache.this.lambda$updateCache$1$HostnameCache();
                }
            }).get(GET_HOSTNAME_TIMEOUT, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            handleCacheUpdateFailure();
        } catch (RuntimeException | ExecutionException | TimeoutException unused2) {
            handleCacheUpdateFailure();
        }
    }

    public String getHostname() {
        if (this.expirationTimestamp < System.currentTimeMillis() && this.updateRunning.compareAndSet(false, true)) {
            updateCache();
        }
        return this.hostname;
    }

    /* JADX INFO: finally extract failed */
    public /* synthetic */ Void lambda$updateCache$1$HostnameCache() throws Exception {
        try {
            this.hostname = this.getLocalhost.call().getCanonicalHostName();
            this.expirationTimestamp = System.currentTimeMillis() + this.cacheDuration;
            this.updateRunning.set(false);
            return null;
        } catch (Throwable th) {
            this.updateRunning.set(false);
            throw th;
        }
    }

    public HostnameCache(long j) {
        this(j, $$Lambda$HostnameCache$0Rf2wMKlMTm1paSpRhBPXF4RBZk.INSTANCE);
    }

    public HostnameCache(long j, Callable<InetAddress> callable) {
        this.updateRunning = new AtomicBoolean(false);
        this.executorService = Executors.newSingleThreadExecutor(new HostnameCacheThreadFactory());
        this.cacheDuration = j;
        this.getLocalhost = (Callable) Objects.requireNonNull(callable, "getLocalhost is required");
        updateCache();
    }
}
