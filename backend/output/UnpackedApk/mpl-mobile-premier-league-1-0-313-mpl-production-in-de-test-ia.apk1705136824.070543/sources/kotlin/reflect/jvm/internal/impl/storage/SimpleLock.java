package kotlin.reflect.jvm.internal.impl.storage;

/* compiled from: locks.kt */
public interface SimpleLock {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: locks.kt */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
    }

    void lock();

    void unlock();
}
