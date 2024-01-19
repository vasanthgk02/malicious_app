package com.facebook.common.references;

import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference.LeakHandler;

public class FinalizerCloseableReference<T> extends CloseableReference<T> {
    public FinalizerCloseableReference(T t, ResourceReleaser<T> resourceReleaser, LeakHandler leakHandler, Throwable th) {
        super(t, resourceReleaser, leakHandler, th);
    }

    public CloseableReference<T> clone() {
        return this;
    }

    /* renamed from: clone  reason: collision with other method in class */
    public Object m188clone() throws CloneNotSupportedException {
        return this;
    }

    public void close() {
    }

    public void finalize() throws Throwable {
        try {
            synchronized (this) {
                if (this.mIsClosed) {
                    super.finalize();
                    return;
                }
                FLog.w((String) "FinalizerCloseableReference", (String) "Finalized without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.mSharedReference)), this.mSharedReference.get().getClass().getName());
                this.mSharedReference.deleteReference();
                super.finalize();
            }
        } catch (Throwable th) {
            super.finalize();
            throw th;
        }
    }
}
