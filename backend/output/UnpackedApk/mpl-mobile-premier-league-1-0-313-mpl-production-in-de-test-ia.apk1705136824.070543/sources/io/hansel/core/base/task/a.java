package io.hansel.core.base.task;

import io.hansel.core.logger.HSLLogger;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class a extends ThreadPoolExecutor {

    /* renamed from: a  reason: collision with root package name */
    public boolean f5112a;

    /* renamed from: b  reason: collision with root package name */
    public ReentrantLock f5113b;

    /* renamed from: c  reason: collision with root package name */
    public Condition f5114c;

    /* renamed from: io.hansel.core.base.task.a$a  reason: collision with other inner class name */
    public interface C0072a extends Runnable {
        boolean executerShouldPause();
    }

    public a(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue) {
        super(i, i2, j, timeUnit, blockingQueue);
        ReentrantLock reentrantLock = new ReentrantLock();
        this.f5113b = reentrantLock;
        this.f5114c = reentrantLock.newCondition();
    }

    public boolean a() {
        return this.f5112a;
    }

    public void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        if (runnable instanceof C0072a) {
            try {
                if (((C0072a) runnable).executerShouldPause()) {
                    b();
                }
            } catch (Exception e2) {
                HSLLogger.printStackTrace(e2);
            }
        }
    }

    public void b() {
        this.f5113b.lock();
        try {
            this.f5112a = true;
        } finally {
            this.f5113b.unlock();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:7|8) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001f, code lost:
        r0.f5113b.unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0024, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0018, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        r1.interrupt();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void beforeExecute(java.lang.Thread r1, java.lang.Runnable r2) {
        /*
            r0 = this;
            super.beforeExecute(r1, r2)
            java.util.concurrent.locks.ReentrantLock r2 = r0.f5113b
            r2.lock()
        L_0x0008:
            boolean r2 = r0.f5112a     // Catch:{ InterruptedException -> 0x001a }
            if (r2 == 0) goto L_0x0012
            java.util.concurrent.locks.Condition r2 = r0.f5114c     // Catch:{ InterruptedException -> 0x001a }
            r2.await()     // Catch:{ InterruptedException -> 0x001a }
            goto L_0x0008
        L_0x0012:
            java.util.concurrent.locks.ReentrantLock r1 = r0.f5113b
            r1.unlock()
            goto L_0x001e
        L_0x0018:
            r1 = move-exception
            goto L_0x001f
        L_0x001a:
            r1.interrupt()     // Catch:{ all -> 0x0018 }
            goto L_0x0012
        L_0x001e:
            return
        L_0x001f:
            java.util.concurrent.locks.ReentrantLock r2 = r0.f5113b
            r2.unlock()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.hansel.core.base.task.a.beforeExecute(java.lang.Thread, java.lang.Runnable):void");
    }

    public void c() {
        this.f5113b.lock();
        try {
            this.f5112a = false;
            this.f5114c.signalAll();
        } finally {
            this.f5113b.unlock();
        }
    }
}
