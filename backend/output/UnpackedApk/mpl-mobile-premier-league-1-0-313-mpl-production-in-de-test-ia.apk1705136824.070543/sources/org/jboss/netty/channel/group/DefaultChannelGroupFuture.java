package org.jboss.netty.channel.group;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;
import org.jboss.netty.logging.InternalLogger;
import org.jboss.netty.logging.InternalLoggerFactory;
import org.jboss.netty.util.internal.IoWorkerRunnable;

public class DefaultChannelGroupFuture implements ChannelGroupFuture {
    public static final InternalLogger logger = InternalLoggerFactory.getInstance(DefaultChannelGroupFuture.class);
    public final ChannelFutureListener childListener = new ChannelFutureListener() {
        public static final /* synthetic */ boolean $assertionsDisabled = false;

        static {
            Class<DefaultChannelGroupFuture> cls = DefaultChannelGroupFuture.class;
        }

        public void operationComplete(ChannelFuture channelFuture) throws Exception {
            boolean z;
            boolean isSuccess = channelFuture.isSuccess();
            synchronized (DefaultChannelGroupFuture.this) {
                z = true;
                if (isSuccess) {
                    DefaultChannelGroupFuture.this.successCount++;
                } else {
                    DefaultChannelGroupFuture.this.failureCount++;
                }
                if (DefaultChannelGroupFuture.this.successCount + DefaultChannelGroupFuture.this.failureCount != DefaultChannelGroupFuture.this.futures.size()) {
                    z = false;
                }
            }
            if (z) {
                DefaultChannelGroupFuture.this.setDone();
            }
        }
    };
    public boolean done;
    public int failureCount;
    public ChannelGroupFutureListener firstListener;
    public final Map<Integer, ChannelFuture> futures;
    public final ChannelGroup group;
    public List<ChannelGroupFutureListener> otherListeners;
    public int successCount;
    public int waiters;

    public DefaultChannelGroupFuture(ChannelGroup channelGroup, Collection<ChannelFuture> collection) {
        if (channelGroup == null) {
            throw new NullPointerException("group");
        } else if (collection != null) {
            this.group = channelGroup;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (ChannelFuture next : collection) {
                linkedHashMap.put(next.getChannel().getId(), next);
            }
            Map<Integer, ChannelFuture> unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
            this.futures = unmodifiableMap;
            for (ChannelFuture addListener : unmodifiableMap.values()) {
                addListener.addListener(this.childListener);
            }
            if (this.futures.isEmpty()) {
                setDone();
            }
        } else {
            throw new NullPointerException("futures");
        }
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
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.channel.group.DefaultChannelGroupFuture.await0(long, boolean):boolean");
    }

    private void checkDeadLock() {
        if (IoWorkerRunnable.IN_IO_THREAD.get().booleanValue()) {
            throw new IllegalStateException("await*() in I/O thread causes a dead lock or sudden performance drop. Use addListener() instead or call await*() from a different thread.");
        }
    }

    private void notifyListener(ChannelGroupFutureListener channelGroupFutureListener) {
        try {
            channelGroupFutureListener.operationComplete(this);
        } catch (Throwable th) {
            InternalLogger internalLogger = logger;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("An exception was thrown by ");
            outline73.append(ChannelFutureListener.class.getSimpleName());
            outline73.append(".");
            internalLogger.warn(outline73.toString(), th);
        }
    }

    private void notifyListeners() {
        ChannelGroupFutureListener channelGroupFutureListener = this.firstListener;
        if (channelGroupFutureListener != null) {
            notifyListener(channelGroupFutureListener);
            this.firstListener = null;
            List<ChannelGroupFutureListener> list = this.otherListeners;
            if (list != null) {
                for (ChannelGroupFutureListener notifyListener : list) {
                    notifyListener(notifyListener);
                }
                this.otherListeners = null;
            }
        }
    }

    public void addListener(ChannelGroupFutureListener channelGroupFutureListener) {
        if (channelGroupFutureListener != null) {
            boolean z = false;
            synchronized (this) {
                if (this.done) {
                    z = true;
                } else if (this.firstListener == null) {
                    this.firstListener = channelGroupFutureListener;
                } else {
                    if (this.otherListeners == null) {
                        this.otherListeners = new ArrayList(1);
                    }
                    this.otherListeners.add(channelGroupFutureListener);
                }
            }
            if (z) {
                notifyListener(channelGroupFutureListener);
                return;
            }
            return;
        }
        throw new NullPointerException("listener");
    }

    /* JADX INFO: finally extract failed */
    public ChannelGroupFuture await() throws InterruptedException {
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

    public ChannelGroupFuture awaitUninterruptibly() {
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

    public ChannelFuture find(Integer num) {
        return this.futures.get(num);
    }

    public ChannelGroup getGroup() {
        return this.group;
    }

    public synchronized boolean isCompleteFailure() {
        return this.failureCount == this.futures.size();
    }

    public synchronized boolean isCompleteSuccess() {
        return this.successCount == this.futures.size();
    }

    public synchronized boolean isDone() {
        return this.done;
    }

    public synchronized boolean isPartialFailure() {
        return !this.futures.isEmpty() && this.failureCount != 0;
    }

    public synchronized boolean isPartialSuccess() {
        return !this.futures.isEmpty() && this.successCount != 0;
    }

    public Iterator<ChannelFuture> iterator() {
        return this.futures.values().iterator();
    }

    public void removeListener(ChannelGroupFutureListener channelGroupFutureListener) {
        if (channelGroupFutureListener != null) {
            synchronized (this) {
                if (!this.done) {
                    if (channelGroupFutureListener == this.firstListener) {
                        if (this.otherListeners == null || this.otherListeners.isEmpty()) {
                            this.firstListener = null;
                        } else {
                            this.firstListener = this.otherListeners.remove(0);
                        }
                    } else if (this.otherListeners != null) {
                        this.otherListeners.remove(channelGroupFutureListener);
                    }
                }
            }
            return;
        }
        throw new NullPointerException("listener");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0013, code lost:
        notifyListeners();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0016, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean setDone() {
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
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.channel.group.DefaultChannelGroupFuture.setDone():boolean");
    }

    public ChannelFuture find(Channel channel) {
        return this.futures.get(channel.getId());
    }

    public boolean await(long j, TimeUnit timeUnit) throws InterruptedException {
        return await0(timeUnit.toNanos(j), true);
    }

    public boolean await(long j) throws InterruptedException {
        return await0(TimeUnit.MILLISECONDS.toNanos(j), true);
    }

    public boolean awaitUninterruptibly(long j, TimeUnit timeUnit) {
        try {
            return await0(timeUnit.toNanos(j), false);
        } catch (InterruptedException unused) {
            throw new InternalError();
        }
    }

    public DefaultChannelGroupFuture(ChannelGroup channelGroup, Map<Integer, ChannelFuture> map) {
        this.group = channelGroup;
        Map<Integer, ChannelFuture> unmodifiableMap = Collections.unmodifiableMap(map);
        this.futures = unmodifiableMap;
        for (ChannelFuture addListener : unmodifiableMap.values()) {
            addListener.addListener(this.childListener);
        }
        if (this.futures.isEmpty()) {
            setDone();
        }
    }

    public boolean awaitUninterruptibly(long j) {
        try {
            return await0(TimeUnit.MILLISECONDS.toNanos(j), false);
        } catch (InterruptedException unused) {
            throw new InternalError();
        }
    }
}
