package io.reactivex.disposables;

import com.android.tools.r8.GeneratedOutlineSupport;

public final class RunnableDisposable extends ReferenceDisposable<Runnable> {
    public static final long serialVersionUID = -8219729196779211169L;

    public RunnableDisposable(Runnable runnable) {
        super(runnable);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("RunnableDisposable(disposed=");
        outline73.append(isDisposed());
        outline73.append(", ");
        outline73.append(get());
        outline73.append(")");
        return outline73.toString();
    }
}
