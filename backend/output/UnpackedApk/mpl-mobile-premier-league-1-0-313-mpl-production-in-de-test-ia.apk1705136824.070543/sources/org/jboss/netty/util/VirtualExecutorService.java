package org.jboss.netty.util;

import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

public class VirtualExecutorService extends AbstractExecutorService {
    public Set<Thread> activeThreads = new MapBackedSet(new IdentityHashMap());

    /* renamed from: e  reason: collision with root package name */
    public final Executor f6174e;
    public final ExecutorService s;
    public volatile boolean shutdown;
    public final Object startStopLock = new Object();

    public class ChildExecutorRunnable implements Runnable {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public final Runnable runnable;

        static {
            Class<VirtualExecutorService> cls = VirtualExecutorService.class;
        }

        public ChildExecutorRunnable(Runnable runnable2) {
            this.runnable = runnable2;
        }

        public void run() {
            Thread currentThread = Thread.currentThread();
            synchronized (VirtualExecutorService.this.startStopLock) {
                VirtualExecutorService.this.activeThreads.add(currentThread);
            }
            try {
                this.runnable.run();
                synchronized (VirtualExecutorService.this.startStopLock) {
                    VirtualExecutorService.this.activeThreads.remove(currentThread);
                    if (VirtualExecutorService.this.isTerminated()) {
                        VirtualExecutorService.this.startStopLock.notifyAll();
                    }
                }
            } catch (Throwable th) {
                synchronized (VirtualExecutorService.this.startStopLock) {
                    VirtualExecutorService.this.activeThreads.remove(currentThread);
                    if (VirtualExecutorService.this.isTerminated()) {
                        VirtualExecutorService.this.startStopLock.notifyAll();
                    }
                    throw th;
                }
            }
        }
    }

    public VirtualExecutorService(Executor executor) {
        if (executor == null) {
            throw new NullPointerException("parent");
        } else if (executor instanceof ExecutorService) {
            this.f6174e = null;
            this.s = (ExecutorService) executor;
        } else {
            this.f6174e = executor;
            this.s = null;
        }
    }

    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        boolean isTerminated;
        synchronized (this.startStopLock) {
            while (!isTerminated()) {
                this.startStopLock.wait(TimeUnit.MILLISECONDS.convert(j, timeUnit));
            }
            isTerminated = isTerminated();
        }
        return isTerminated;
    }

    public void execute(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException(MiPushCommandMessage.KEY_COMMAND);
        } else if (!this.shutdown) {
            ExecutorService executorService = this.s;
            if (executorService != null) {
                executorService.execute(new ChildExecutorRunnable(runnable));
            } else {
                this.f6174e.execute(new ChildExecutorRunnable(runnable));
            }
        } else {
            throw new RejectedExecutionException();
        }
    }

    public boolean isShutdown() {
        boolean z;
        synchronized (this.startStopLock) {
            z = this.shutdown;
        }
        return z;
    }

    public boolean isTerminated() {
        boolean z;
        synchronized (this.startStopLock) {
            z = this.shutdown && this.activeThreads.isEmpty();
        }
        return z;
    }

    public void shutdown() {
        synchronized (this.startStopLock) {
            if (!this.shutdown) {
                this.shutdown = true;
            }
        }
    }

    public List<Runnable> shutdownNow() {
        synchronized (this.startStopLock) {
            if (!isTerminated()) {
                shutdown();
                for (Thread interrupt : this.activeThreads) {
                    interrupt.interrupt();
                }
            }
        }
        return Collections.emptyList();
    }
}
