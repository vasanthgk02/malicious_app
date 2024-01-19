package kotlin.reflect.jvm.internal.impl.storage;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: locks.kt */
public class DefaultSimpleLock implements SimpleLock {
    public final Lock lock;

    public DefaultSimpleLock(Lock lock2, int i) {
        ReentrantLock reentrantLock = (i & 1) != 0 ? new ReentrantLock() : null;
        Intrinsics.checkNotNullParameter(reentrantLock, "lock");
        this.lock = reentrantLock;
    }

    public void lock() {
        this.lock.lock();
    }

    public void unlock() {
        this.lock.unlock();
    }
}
