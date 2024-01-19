package dagger.internal;

import javax.inject.Provider;

public final class DoubleCheck<T> implements Provider<T> {
    public static final Object UNINITIALIZED = new Object();
    public volatile Object instance = UNINITIALIZED;
    public volatile Provider<T> provider;

    public DoubleCheck(Provider<T> provider2) {
        this.provider = provider2;
    }

    public static <P extends Provider<T>, T> Provider<T> provider(P p) {
        if (p == null) {
            throw null;
        } else if (p instanceof DoubleCheck) {
            return p;
        } else {
            return new DoubleCheck(p);
        }
    }

    public static Object reentrantCheck(Object obj, Object obj2) {
        if (!(obj != UNINITIALIZED) || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    public T get() {
        T t = this.instance;
        if (t == UNINITIALIZED) {
            synchronized (this) {
                t = this.instance;
                if (t == UNINITIALIZED) {
                    t = this.provider.get();
                    reentrantCheck(this.instance, t);
                    this.instance = t;
                    this.provider = null;
                }
            }
        }
        return t;
    }
}
