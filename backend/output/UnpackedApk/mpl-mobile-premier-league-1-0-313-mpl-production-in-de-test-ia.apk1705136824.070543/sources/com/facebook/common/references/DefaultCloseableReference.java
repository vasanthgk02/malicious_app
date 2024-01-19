package com.facebook.common.references;

import co.hyperverge.hypersnapsdk.c.k;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference.LeakHandler;

public class DefaultCloseableReference<T> extends CloseableReference<T> {
    public DefaultCloseableReference(SharedReference<T> sharedReference, LeakHandler leakHandler, Throwable th) {
        super(sharedReference, leakHandler, th);
    }

    public void finalize() throws Throwable {
        try {
            synchronized (this) {
                if (this.mIsClosed) {
                    super.finalize();
                    return;
                }
                FLog.w((String) "DefaultCloseableReference", (String) "Finalized without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.mSharedReference)), this.mSharedReference.get().getClass().getName());
                this.mLeakHandler.reportLeak(this.mSharedReference, this.mStacktrace);
                close();
                super.finalize();
            }
        } catch (Throwable th) {
            super.finalize();
            throw th;
        }
    }

    public DefaultCloseableReference(T t, ResourceReleaser<T> resourceReleaser, LeakHandler leakHandler, Throwable th) {
        super(t, resourceReleaser, leakHandler, th);
    }

    public CloseableReference<T> clone() {
        k.checkState(isValid());
        return new DefaultCloseableReference(this.mSharedReference, this.mLeakHandler, this.mStacktrace);
    }
}
