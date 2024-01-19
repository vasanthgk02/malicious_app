package io.sentry.transport;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public final class ReusableCountLatch {
    public final Sync sync;

    public static final class Sync extends AbstractQueuedSynchronizer {
        public static final long serialVersionUID = 5970133580157457018L;

        public Sync(int i) {
            setState(i);
        }

        /* access modifiers changed from: private */
        public void decrement() {
            releaseShared(1);
        }

        /* access modifiers changed from: private */
        public int getCount() {
            return getState();
        }

        /* access modifiers changed from: private */
        public void increment() {
            int state;
            do {
                state = getState();
            } while (!compareAndSetState(state, state + 1));
        }

        public int tryAcquireShared(int i) {
            return getState() == 0 ? 1 : -1;
        }

        public boolean tryReleaseShared(int i) {
            int state;
            boolean z;
            int i2;
            do {
                state = getState();
                z = false;
                if (state == 0) {
                    return false;
                }
                i2 = state - 1;
            } while (!compareAndSetState(state, i2));
            if (i2 == 0) {
                z = true;
            }
            return z;
        }
    }

    public ReusableCountLatch(int i) {
        if (i >= 0) {
            this.sync = new Sync(i);
            return;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline42("negative initial count '", i, "' is not allowed"));
    }

    public void decrement() {
        this.sync.decrement();
    }

    public int getCount() {
        return this.sync.getCount();
    }

    public void increment() {
        this.sync.increment();
    }

    public void waitTillZero() throws InterruptedException {
        this.sync.acquireSharedInterruptibly(1);
    }

    public boolean waitTillZero(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.sync.tryAcquireSharedNanos(1, timeUnit.toNanos(j));
    }

    public ReusableCountLatch() {
        this(0);
    }
}
