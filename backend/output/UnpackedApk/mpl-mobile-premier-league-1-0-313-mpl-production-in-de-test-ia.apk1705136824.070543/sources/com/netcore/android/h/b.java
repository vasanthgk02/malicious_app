package com.netcore.android.h;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: PausableThreadPoolExecutor */
public class b extends ThreadPoolExecutor {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1171a;

    /* renamed from: b  reason: collision with root package name */
    public ReentrantLock f1172b;

    /* renamed from: c  reason: collision with root package name */
    public Condition f1173c;

    /* compiled from: PausableThreadPoolExecutor */
    public interface a extends Runnable {
        boolean a();
    }

    public b(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue) {
        super(i, i2, j, timeUnit, blockingQueue);
        ReentrantLock reentrantLock = new ReentrantLock();
        this.f1172b = reentrantLock;
        this.f1173c = reentrantLock.newCondition();
    }

    public void a() {
        this.f1172b.lock();
        try {
            this.f1171a = true;
        } finally {
            this.f1172b.unlock();
        }
    }

    public void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        if (runnable instanceof a) {
            try {
                if (((a) runnable).a()) {
                    a();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:7|8|9|13) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0023, code lost:
        r0.f1172b.unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0028, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        return;
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
            java.util.concurrent.locks.ReentrantLock r2 = r0.f1172b
            r2.lock()
        L_0x0008:
            boolean r2 = r0.f1171a     // Catch:{ InterruptedException -> 0x001a }
            if (r2 == 0) goto L_0x0012
            java.util.concurrent.locks.Condition r2 = r0.f1173c     // Catch:{ InterruptedException -> 0x001a }
            r2.await()     // Catch:{ InterruptedException -> 0x001a }
            goto L_0x0008
        L_0x0012:
            java.util.concurrent.locks.ReentrantLock r1 = r0.f1172b
            r1.unlock()
            goto L_0x0022
        L_0x0018:
            r1 = move-exception
            goto L_0x0023
        L_0x001a:
            r1.interrupt()     // Catch:{ all -> 0x0018 }
            java.util.concurrent.locks.ReentrantLock r1 = r0.f1172b
            r1.unlock()
        L_0x0022:
            return
        L_0x0023:
            java.util.concurrent.locks.ReentrantLock r2 = r0.f1172b
            r2.unlock()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netcore.android.h.b.beforeExecute(java.lang.Thread, java.lang.Runnable):void");
    }
}
