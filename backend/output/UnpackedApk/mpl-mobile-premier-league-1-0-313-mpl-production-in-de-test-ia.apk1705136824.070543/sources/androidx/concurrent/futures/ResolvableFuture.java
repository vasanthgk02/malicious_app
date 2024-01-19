package androidx.concurrent.futures;

public final class ResolvableFuture<V> extends AbstractResolvableFuture<V> {
    public boolean set(V v) {
        return super.set(v);
    }

    public boolean setException(Throwable th) {
        return super.setException(th);
    }
}
