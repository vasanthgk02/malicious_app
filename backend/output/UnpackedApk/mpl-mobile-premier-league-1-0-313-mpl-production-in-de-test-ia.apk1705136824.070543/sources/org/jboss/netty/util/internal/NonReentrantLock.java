package org.jboss.netty.util.internal;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.AbstractQueuedSynchronizer.ConditionObject;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public final class NonReentrantLock extends AbstractQueuedSynchronizer implements Lock {
    public static final long serialVersionUID = -833780837233068610L;
    public Thread owner;

    public boolean isHeldByCurrentThread() {
        return isHeldExclusively();
    }

    public final boolean isHeldExclusively() {
        return getState() != 0 && this.owner == Thread.currentThread();
    }

    public void lock() {
        acquire(1);
    }

    public void lockInterruptibly() throws InterruptedException {
        acquireInterruptibly(1);
    }

    public Condition newCondition() {
        return new ConditionObject(this);
    }

    public final boolean tryAcquire(int i) {
        if (!compareAndSetState(0, 1)) {
            return false;
        }
        this.owner = Thread.currentThread();
        return true;
    }

    public boolean tryLock() {
        return tryAcquire(1);
    }

    public final boolean tryRelease(int i) {
        if (Thread.currentThread() == this.owner) {
            this.owner = null;
            setState(0);
            return true;
        }
        throw new IllegalMonitorStateException();
    }

    public void unlock() {
        release(1);
    }

    public boolean tryLock(long j, TimeUnit timeUnit) throws InterruptedException {
        return tryAcquireNanos(1, timeUnit.toNanos(j));
    }
}
