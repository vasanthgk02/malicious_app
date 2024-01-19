package com.facebook.common.references;

import com.facebook.common.references.CloseableReference.LeakHandler;

public class NoOpCloseableReference<T> extends CloseableReference<T> {
    public NoOpCloseableReference(T t, ResourceReleaser<T> resourceReleaser, LeakHandler leakHandler, Throwable th) {
        super(t, resourceReleaser, leakHandler, th);
    }

    public CloseableReference<T> clone() {
        return this;
    }

    /* renamed from: clone  reason: collision with other method in class */
    public Object m189clone() throws CloneNotSupportedException {
        return this;
    }

    public void close() {
    }
}
