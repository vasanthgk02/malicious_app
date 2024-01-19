package io.reactivex.internal.disposables;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReference;

public final class SequentialDisposable extends AtomicReference<Disposable> implements Disposable {
    public static final long serialVersionUID = -754898800686245608L;

    public void dispose() {
        DisposableHelper.dispose(this);
    }
}
