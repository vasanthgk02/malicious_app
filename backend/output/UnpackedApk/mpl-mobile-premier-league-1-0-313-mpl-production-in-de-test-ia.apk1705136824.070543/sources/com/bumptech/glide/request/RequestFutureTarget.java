package com.bumptech.glide.request;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class RequestFutureTarget<R> implements FutureTarget<R>, RequestListener<R> {
    public static final Waiter DEFAULT_WAITER = new Waiter();
    public final boolean assertBackgroundThread = true;
    public GlideException exception;
    public final int height;
    public boolean isCancelled;
    public boolean loadFailed;
    public Request request;
    public R resource;
    public boolean resultReceived;
    public final Waiter waiter;
    public final int width;

    public static class Waiter {
    }

    public RequestFutureTarget(int i, int i2) {
        Waiter waiter2 = DEFAULT_WAITER;
        this.width = i;
        this.height = i2;
        this.waiter = waiter2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001d, code lost:
        if (r2 == null) goto L_0x0022;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001f, code lost:
        r2.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0022, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean cancel(boolean r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.isDone()     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x000a
            r4 = 0
            monitor-exit(r3)     // Catch:{ all -> 0x0024 }
            return r4
        L_0x000a:
            r0 = 1
            r3.isCancelled = r0     // Catch:{ all -> 0x0024 }
            com.bumptech.glide.request.RequestFutureTarget$Waiter r1 = r3.waiter     // Catch:{ all -> 0x0024 }
            r2 = 0
            if (r1 == 0) goto L_0x0023
            r3.notifyAll()     // Catch:{ all -> 0x0024 }
            if (r4 == 0) goto L_0x001c
            com.bumptech.glide.request.Request r4 = r3.request     // Catch:{ all -> 0x0024 }
            r3.request = r2     // Catch:{ all -> 0x0024 }
            r2 = r4
        L_0x001c:
            monitor-exit(r3)     // Catch:{ all -> 0x0024 }
            if (r2 == 0) goto L_0x0022
            r2.clear()
        L_0x0022:
            return r0
        L_0x0023:
            throw r2     // Catch:{ all -> 0x0024 }
        L_0x0024:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0024 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.RequestFutureTarget.cancel(boolean):boolean");
    }

    public final synchronized R doGet(Long l) throws ExecutionException, InterruptedException, TimeoutException {
        if (this.assertBackgroundThread && !isDone()) {
            if (!Util.isOnBackgroundThread()) {
                throw new IllegalArgumentException("You must call this method on a background thread");
            }
        }
        if (this.isCancelled) {
            throw new CancellationException();
        } else if (this.loadFailed) {
            throw new ExecutionException(this.exception);
        } else if (this.resultReceived) {
            return this.resource;
        } else {
            if (l == null) {
                if (this.waiter != null) {
                    wait(0);
                } else {
                    throw null;
                }
            } else if (l.longValue() > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                long longValue = l.longValue() + currentTimeMillis;
                while (!isDone() && currentTimeMillis < longValue) {
                    long j = longValue - currentTimeMillis;
                    if (this.waiter != null) {
                        wait(j);
                        currentTimeMillis = System.currentTimeMillis();
                    } else {
                        throw null;
                    }
                }
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            } else if (this.loadFailed) {
                throw new ExecutionException(this.exception);
            } else if (this.isCancelled) {
                throw new CancellationException();
            } else if (this.resultReceived) {
                return this.resource;
            } else {
                throw new TimeoutException();
            }
        }
    }

    public R get() throws InterruptedException, ExecutionException {
        try {
            return doGet(null);
        } catch (TimeoutException e2) {
            throw new AssertionError(e2);
        }
    }

    public synchronized Request getRequest() {
        return this.request;
    }

    public void getSize(SizeReadyCallback sizeReadyCallback) {
        sizeReadyCallback.onSizeReady(this.width, this.height);
    }

    public synchronized boolean isCancelled() {
        return this.isCancelled;
    }

    public synchronized boolean isDone() {
        return this.isCancelled || this.resultReceived || this.loadFailed;
    }

    public void onDestroy() {
    }

    public void onLoadCleared(Drawable drawable) {
    }

    public synchronized void onLoadFailed(Drawable drawable) {
    }

    public void onLoadStarted(Drawable drawable) {
    }

    public synchronized void onResourceReady(R r, Transition<? super R> transition) {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void removeCallback(SizeReadyCallback sizeReadyCallback) {
    }

    public synchronized void setRequest(Request request2) {
        this.request = request2;
    }

    public synchronized boolean onLoadFailed(GlideException glideException, Object obj, Target<R> target, boolean z) {
        this.loadFailed = true;
        this.exception = glideException;
        if (this.waiter != null) {
            notifyAll();
        } else {
            throw null;
        }
        return false;
    }

    public synchronized boolean onResourceReady(R r, Object obj, Target<R> target, DataSource dataSource, boolean z) {
        this.resultReceived = true;
        this.resource = r;
        if (this.waiter != null) {
            notifyAll();
        } else {
            throw null;
        }
        return false;
    }

    public R get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return doGet(Long.valueOf(timeUnit.toMillis(j)));
    }
}
