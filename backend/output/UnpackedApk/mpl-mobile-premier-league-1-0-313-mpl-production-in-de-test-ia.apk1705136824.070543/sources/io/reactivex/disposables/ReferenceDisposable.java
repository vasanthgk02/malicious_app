package io.reactivex.disposables;

import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

public abstract class ReferenceDisposable<T> extends AtomicReference<T> implements Disposable {
    public static final long serialVersionUID = 6537757548749041217L;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ReferenceDisposable(T t) {
        // ObjectHelper.requireNonNull(t, "value is null");
        super(t);
    }

    public final void dispose() {
        if (get() != null) {
            Object andSet = getAndSet(null);
            if (andSet != null) {
                ((Runnable) andSet).run();
            }
        }
    }

    public final boolean isDisposed() {
        return get() == null;
    }
}
