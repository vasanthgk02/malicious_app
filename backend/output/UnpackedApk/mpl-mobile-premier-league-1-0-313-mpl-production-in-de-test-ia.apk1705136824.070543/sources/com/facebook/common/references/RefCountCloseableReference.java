package com.facebook.common.references;

import co.hyperverge.hypersnapsdk.c.k;
import com.facebook.common.references.CloseableReference.LeakHandler;

public class RefCountCloseableReference<T> extends CloseableReference<T> {
    public RefCountCloseableReference(SharedReference<T> sharedReference, LeakHandler leakHandler, Throwable th) {
        super(sharedReference, leakHandler, th);
    }

    public RefCountCloseableReference(T t, ResourceReleaser<T> resourceReleaser, LeakHandler leakHandler, Throwable th) {
        super(t, resourceReleaser, leakHandler, th);
    }

    public CloseableReference<T> clone() {
        k.checkState(isValid());
        return new RefCountCloseableReference(this.mSharedReference, this.mLeakHandler, this.mStacktrace);
    }
}
