package org.jboss.netty.channel;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.jboss.netty.logging.InternalLogger;
import org.jboss.netty.logging.InternalLoggerFactory;
import org.jboss.netty.util.internal.IoWorkerRunnable;

public class DefaultChannelFuture implements ChannelFuture {
    public static final Throwable CANCELLED = new Throwable();
    public static boolean disabledDeadLockCheckerOnce;
    public static final InternalLogger logger = InternalLoggerFactory.getInstance(DefaultChannelFuture.class);
    public static volatile boolean useDeadLockChecker = true;
    public final boolean cancellable;
    public Throwable cause;
    public final Channel channel;
    public boolean done;
    public ChannelFutureListener firstListener;
    public List<ChannelFutureListener> otherListeners;
    public List<ChannelFutureProgressListener> progressListeners;
    public int waiters;

    public DefaultChannelFuture(Channel channel2, boolean z) {
        this.channel = channel2;
        this.cancellable = z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x005a, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x006e, code lost:
        if (r6 == false) goto L_0x0077;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0070, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0077, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean await0(long r15, boolean r17) throws java.lang.InterruptedException {
        /*
            r14 = this;
            r1 = r14
            if (r17 == 0) goto L_0x0010
            boolean r0 = java.lang.Thread.interrupted()
            if (r0 != 0) goto L_0x000a
            goto L_0x0010
        L_0x000a:
            java.lang.InterruptedException r0 = new java.lang.InterruptedException
            r0.<init>()
            throw r0
        L_0x0010:
            r2 = 0
            int r0 = (r15 > r2 ? 1 : (r15 == r2 ? 0 : -1))
            if (r0 > 0) goto L_0x0018
            r4 = r2
            goto L_0x001c
        L_0x0018:
            long r4 = java.lang.System.nanoTime()
        L_0x001c:
            r6 = 0
            monitor-enter(r14)     // Catch:{ all -> 0x0082 }
            boolean r7 = r1.done     // Catch:{ all -> 0x007f }
            if (r7 == 0) goto L_0x0026
            boolean r0 = r1.done     // Catch:{ all -> 0x007f }
            monitor-exit(r14)     // Catch:{ all -> 0x007f }
            return r0
        L_0x0026:
            if (r0 > 0) goto L_0x002c
            boolean r0 = r1.done     // Catch:{ all -> 0x007f }
            monitor-exit(r14)     // Catch:{ all -> 0x007f }
            return r0
        L_0x002c:
            r14.checkDeadLock()     // Catch:{ all -> 0x007f }
            int r0 = r1.waiters     // Catch:{ all -> 0x007f }
            r7 = 1
            int r0 = r0 + r7
            r1.waiters = r0     // Catch:{ all -> 0x007f }
            r8 = r15
        L_0x0036:
            r10 = 1000000(0xf4240, double:4.940656E-318)
            long r12 = r8 / r10
            long r8 = r8 % r10
            int r0 = (int) r8     // Catch:{ InterruptedException -> 0x0043 }
            r14.wait(r12, r0)     // Catch:{ InterruptedException -> 0x0043 }
            goto L_0x0047
        L_0x0041:
            r0 = move-exception
            goto L_0x0079
        L_0x0043:
            r0 = move-exception
            if (r17 != 0) goto L_0x0078
            r6 = 1
        L_0x0047:
            boolean r0 = r1.done     // Catch:{ all -> 0x0041 }
            if (r0 == 0) goto L_0x005b
            int r0 = r1.waiters     // Catch:{ all -> 0x007f }
            int r0 = r0 - r7
            r1.waiters = r0     // Catch:{ all -> 0x007f }
            monitor-exit(r14)     // Catch:{ all -> 0x007f }
            if (r6 == 0) goto L_0x005a
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x005a:
            return r7
        L_0x005b:
            long r8 = java.lang.System.nanoTime()     // Catch:{ all -> 0x0041 }
            long r8 = r8 - r4
            long r8 = r15 - r8
            int r0 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r0 > 0) goto L_0x0036
            boolean r0 = r1.done     // Catch:{ all -> 0x0041 }
            int r2 = r1.waiters     // Catch:{ all -> 0x007f }
            int r2 = r2 - r7
            r1.waiters = r2     // Catch:{ all -> 0x007f }
            monitor-exit(r14)     // Catch:{ all -> 0x007f }
            if (r6 == 0) goto L_0x0077
            java.lang.Thread r2 = java.lang.Thread.currentThread()
            r2.interrupt()
        L_0x0077:
            return r0
        L_0x0078:
            throw r0     // Catch:{ all -> 0x0041 }
        L_0x0079:
            int r2 = r1.waiters     // Catch:{ all -> 0x007f }
            int r2 = r2 - r7
            r1.waiters = r2     // Catch:{ all -> 0x007f }
            throw r0     // Catch:{ all -> 0x007f }
        L_0x007f:
            r0 = move-exception
            monitor-exit(r14)     // Catch:{ all -> 0x007f }
            throw r0     // Catch:{ all -> 0x0082 }
        L_0x0082:
            r0 = move-exception
            if (r6 == 0) goto L_0x008c
            java.lang.Thread r2 = java.lang.Thread.currentThread()
            r2.interrupt()
        L_0x008c:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.channel.DefaultChannelFuture.await0(long, boolean):boolean");
    }

    private void checkDeadLock() {
        if (isUseDeadLockChecker() && IoWorkerRunnable.IN_IO_THREAD.get().booleanValue()) {
            throw new IllegalStateException("await*() in I/O thread causes a dead lock or sudden performance drop. Use addListener() instead or call await*() from a different thread.");
        }
    }

    public static boolean isUseDeadLockChecker() {
        return useDeadLockChecker;
    }

    private void notifyListener(ChannelFutureListener channelFutureListener) {
        try {
            channelFutureListener.operationComplete(this);
        } catch (Throwable th) {
            InternalLogger internalLogger = logger;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("An exception was thrown by ");
            outline73.append(ChannelFutureListener.class.getSimpleName());
            outline73.append(".");
            internalLogger.warn(outline73.toString(), th);
        }
    }

    private void notifyListeners() {
        ChannelFutureListener channelFutureListener = this.firstListener;
        if (channelFutureListener != null) {
            notifyListener(channelFutureListener);
            this.firstListener = null;
            List<ChannelFutureListener> list = this.otherListeners;
            if (list != null) {
                for (ChannelFutureListener notifyListener : list) {
                    notifyListener(notifyListener);
                }
                this.otherListeners = null;
            }
        }
    }

    private void notifyProgressListener(ChannelFutureProgressListener channelFutureProgressListener, long j, long j2, long j3) {
        try {
            channelFutureProgressListener.operationProgressed(this, j, j2, j3);
        } catch (Throwable th) {
            InternalLogger internalLogger = logger;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("An exception was thrown by ");
            outline73.append(ChannelFutureProgressListener.class.getSimpleName());
            outline73.append(".");
            internalLogger.warn(outline73.toString(), th);
        }
    }

    public static void setUseDeadLockChecker(boolean z) {
        if (!z && !disabledDeadLockCheckerOnce) {
            disabledDeadLockCheckerOnce = true;
            InternalLogger internalLogger = logger;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("The dead lock checker in ");
            outline73.append(DefaultChannelFuture.class.getSimpleName());
            outline73.append(" has been disabled as requested at your own risk.");
            internalLogger.debug(outline73.toString());
        }
        useDeadLockChecker = z;
    }

    public void addListener(ChannelFutureListener channelFutureListener) {
        if (channelFutureListener != null) {
            boolean z = false;
            synchronized (this) {
                if (this.done) {
                    z = true;
                } else {
                    if (this.firstListener == null) {
                        this.firstListener = channelFutureListener;
                    } else {
                        if (this.otherListeners == null) {
                            this.otherListeners = new ArrayList(1);
                        }
                        this.otherListeners.add(channelFutureListener);
                    }
                    if (channelFutureListener instanceof ChannelFutureProgressListener) {
                        if (this.progressListeners == null) {
                            this.progressListeners = new ArrayList(1);
                        }
                        this.progressListeners.add((ChannelFutureProgressListener) channelFutureListener);
                    }
                }
            }
            if (z) {
                notifyListener(channelFutureListener);
                return;
            }
            return;
        }
        throw new NullPointerException("listener");
    }

    /* JADX INFO: finally extract failed */
    public ChannelFuture await() throws InterruptedException {
        if (!Thread.interrupted()) {
            synchronized (this) {
                while (!this.done) {
                    checkDeadLock();
                    this.waiters++;
                    try {
                        wait();
                        this.waiters--;
                    } catch (Throwable th) {
                        this.waiters--;
                        throw th;
                    }
                }
            }
            return this;
        }
        throw new InterruptedException();
    }

    public ChannelFuture awaitUninterruptibly() {
        boolean z;
        synchronized (this) {
            z = false;
            while (!this.done) {
                checkDeadLock();
                this.waiters++;
                try {
                    wait();
                    this.waiters--;
                } catch (InterruptedException unused) {
                    this.waiters--;
                    z = true;
                } catch (Throwable th) {
                    this.waiters--;
                    throw th;
                }
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001c, code lost:
        notifyListeners();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001f, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean cancel() {
        /*
            r2 = this;
            boolean r0 = r2.cancellable
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            monitor-enter(r2)
            boolean r0 = r2.done     // Catch:{ all -> 0x0020 }
            if (r0 == 0) goto L_0x000d
            monitor-exit(r2)     // Catch:{ all -> 0x0020 }
            return r1
        L_0x000d:
            java.lang.Throwable r0 = CANCELLED     // Catch:{ all -> 0x0020 }
            r2.cause = r0     // Catch:{ all -> 0x0020 }
            r0 = 1
            r2.done = r0     // Catch:{ all -> 0x0020 }
            int r1 = r2.waiters     // Catch:{ all -> 0x0020 }
            if (r1 <= 0) goto L_0x001b
            r2.notifyAll()     // Catch:{ all -> 0x0020 }
        L_0x001b:
            monitor-exit(r2)     // Catch:{ all -> 0x0020 }
            r2.notifyListeners()
            return r0
        L_0x0020:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0020 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.channel.DefaultChannelFuture.cancel():boolean");
    }

    public synchronized Throwable getCause() {
        if (this.cause == CANCELLED) {
            return null;
        }
        return this.cause;
    }

    public Channel getChannel() {
        return this.channel;
    }

    public synchronized boolean isCancelled() {
        return this.cause == CANCELLED;
    }

    public synchronized boolean isDone() {
        try {
        }
        return this.done;
    }

    public synchronized boolean isSuccess() {
        return this.done && this.cause == null;
    }

    public void removeListener(ChannelFutureListener channelFutureListener) {
        if (channelFutureListener != null) {
            synchronized (this) {
                if (!this.done) {
                    if (channelFutureListener == this.firstListener) {
                        if (this.otherListeners == null || this.otherListeners.isEmpty()) {
                            this.firstListener = null;
                        } else {
                            this.firstListener = this.otherListeners.remove(0);
                        }
                    } else if (this.otherListeners != null) {
                        this.otherListeners.remove(channelFutureListener);
                    }
                    if (channelFutureListener instanceof ChannelFutureProgressListener) {
                        this.progressListeners.remove(channelFutureListener);
                    }
                }
            }
            return;
        }
        throw new NullPointerException("listener");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0015, code lost:
        notifyListeners();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0018, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean setFailure(java.lang.Throwable r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.done     // Catch:{ all -> 0x0019 }
            if (r0 == 0) goto L_0x0008
            r2 = 0
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            return r2
        L_0x0008:
            r1.cause = r2     // Catch:{ all -> 0x0019 }
            r2 = 1
            r1.done = r2     // Catch:{ all -> 0x0019 }
            int r0 = r1.waiters     // Catch:{ all -> 0x0019 }
            if (r0 <= 0) goto L_0x0014
            r1.notifyAll()     // Catch:{ all -> 0x0019 }
        L_0x0014:
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            r1.notifyListeners()
            return r2
        L_0x0019:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.channel.DefaultChannelFuture.setFailure(java.lang.Throwable):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0022, code lost:
        r11 = r0.length;
        r12 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0024, code lost:
        if (r12 >= r11) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0026, code lost:
        notifyProgressListener(r0[r12], r14, r16, r18);
        r12 = r12 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0034, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean setProgress(long r14, long r16, long r18) {
        /*
            r13 = this;
            r9 = r13
            monitor-enter(r13)
            boolean r0 = r9.done     // Catch:{ all -> 0x0037 }
            r1 = 0
            if (r0 == 0) goto L_0x0009
            monitor-exit(r13)     // Catch:{ all -> 0x0037 }
            return r1
        L_0x0009:
            java.util.List<org.jboss.netty.channel.ChannelFutureProgressListener> r0 = r9.progressListeners     // Catch:{ all -> 0x0037 }
            r10 = 1
            if (r0 == 0) goto L_0x0035
            boolean r2 = r0.isEmpty()     // Catch:{ all -> 0x0037 }
            if (r2 == 0) goto L_0x0015
            goto L_0x0035
        L_0x0015:
            int r2 = r0.size()     // Catch:{ all -> 0x0037 }
            org.jboss.netty.channel.ChannelFutureProgressListener[] r2 = new org.jboss.netty.channel.ChannelFutureProgressListener[r2]     // Catch:{ all -> 0x0037 }
            java.lang.Object[] r0 = r0.toArray(r2)     // Catch:{ all -> 0x0037 }
            org.jboss.netty.channel.ChannelFutureProgressListener[] r0 = (org.jboss.netty.channel.ChannelFutureProgressListener[]) r0     // Catch:{ all -> 0x0037 }
            monitor-exit(r13)     // Catch:{ all -> 0x0037 }
            int r11 = r0.length
            r12 = 0
        L_0x0024:
            if (r12 >= r11) goto L_0x0034
            r2 = r0[r12]
            r1 = r13
            r3 = r14
            r5 = r16
            r7 = r18
            r1.notifyProgressListener(r2, r3, r5, r7)
            int r12 = r12 + 1
            goto L_0x0024
        L_0x0034:
            return r10
        L_0x0035:
            monitor-exit(r13)     // Catch:{ all -> 0x0037 }
            return r10
        L_0x0037:
            r0 = move-exception
            monitor-exit(r13)     // Catch:{ all -> 0x0037 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.channel.DefaultChannelFuture.setProgress(long, long, long):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0013, code lost:
        notifyListeners();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0016, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean setSuccess() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.done     // Catch:{ all -> 0x0017 }
            if (r0 == 0) goto L_0x0008
            r0 = 0
            monitor-exit(r2)     // Catch:{ all -> 0x0017 }
            return r0
        L_0x0008:
            r0 = 1
            r2.done = r0     // Catch:{ all -> 0x0017 }
            int r1 = r2.waiters     // Catch:{ all -> 0x0017 }
            if (r1 <= 0) goto L_0x0012
            r2.notifyAll()     // Catch:{ all -> 0x0017 }
        L_0x0012:
            monitor-exit(r2)     // Catch:{ all -> 0x0017 }
            r2.notifyListeners()
            return r0
        L_0x0017:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0017 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.channel.DefaultChannelFuture.setSuccess():boolean");
    }

    public boolean await(long j, TimeUnit timeUnit) throws InterruptedException {
        return await0(timeUnit.toNanos(j), true);
    }

    public boolean awaitUninterruptibly(long j, TimeUnit timeUnit) {
        try {
            return await0(timeUnit.toNanos(j), false);
        } catch (InterruptedException unused) {
            throw new InternalError();
        }
    }

    public boolean await(long j) throws InterruptedException {
        return await0(TimeUnit.MILLISECONDS.toNanos(j), true);
    }

    public boolean awaitUninterruptibly(long j) {
        try {
            return await0(TimeUnit.MILLISECONDS.toNanos(j), false);
        } catch (InterruptedException unused) {
            throw new InternalError();
        }
    }
}
