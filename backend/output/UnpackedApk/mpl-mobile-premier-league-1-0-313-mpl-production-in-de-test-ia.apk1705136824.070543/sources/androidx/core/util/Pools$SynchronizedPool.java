package androidx.core.util;

public class Pools$SynchronizedPool<T> extends Pools$SimplePool<T> {
    public final Object mLock = new Object();

    public Pools$SynchronizedPool(int i) {
        super(i);
    }

    public T acquire() {
        T acquire;
        synchronized (this.mLock) {
            try {
                acquire = super.acquire();
            }
        }
        return acquire;
    }

    public boolean release(T t) {
        boolean release;
        synchronized (this.mLock) {
            release = super.release(t);
        }
        return release;
    }
}
