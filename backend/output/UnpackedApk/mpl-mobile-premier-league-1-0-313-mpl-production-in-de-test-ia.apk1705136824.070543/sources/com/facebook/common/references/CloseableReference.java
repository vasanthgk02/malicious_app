package com.facebook.common.references;

import android.graphics.Bitmap;
import co.hyperverge.hypersnapsdk.c.k;
import com.facebook.common.internal.Closeables;
import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class CloseableReference<T> implements Cloneable, Closeable {
    public static final ResourceReleaser<Closeable> DEFAULT_CLOSEABLE_RELEASER = new ResourceReleaser<Closeable>() {
        public void release(Object obj) {
            try {
                Closeables.close((Closeable) obj, true);
            } catch (IOException unused) {
            }
        }
    };
    public static final LeakHandler DEFAULT_LEAK_HANDLER = new LeakHandler() {
        public void reportLeak(SharedReference<Object> sharedReference, Throwable th) {
            FLog.w(CloseableReference.TAG, (String) "Finalized without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(sharedReference)), sharedReference.get().getClass().getName());
        }

        public boolean requiresStacktrace() {
            return false;
        }
    };
    public static Class<CloseableReference> TAG = CloseableReference.class;
    public static int sBitmapCloseableRefType = 0;
    public boolean mIsClosed = false;
    public final LeakHandler mLeakHandler;
    public final SharedReference<T> mSharedReference;
    public final Throwable mStacktrace;

    public interface LeakHandler {
        void reportLeak(SharedReference<Object> sharedReference, Throwable th);

        boolean requiresStacktrace();
    }

    public CloseableReference(SharedReference<T> sharedReference, LeakHandler leakHandler, Throwable th) {
        if (sharedReference != null) {
            this.mSharedReference = sharedReference;
            synchronized (sharedReference) {
                sharedReference.ensureValid();
                sharedReference.mRefCount++;
            }
            this.mLeakHandler = leakHandler;
            this.mStacktrace = th;
            return;
        }
        throw null;
    }

    public static void closeSafely(CloseableReference<?> closeableReference) {
        if (closeableReference != null) {
            closeableReference.close();
        }
    }

    public static <T extends Closeable> CloseableReference<T> of(T t) {
        return of(t, DEFAULT_CLOSEABLE_RELEASER);
    }

    public abstract CloseableReference<T> clone();

    public synchronized CloseableReference<T> cloneOrNull() {
        if (!isValid()) {
            return null;
        }
        return clone();
    }

    public void close() {
        synchronized (this) {
            if (!this.mIsClosed) {
                this.mIsClosed = true;
                this.mSharedReference.deleteReference();
            }
        }
    }

    public void finalize() throws Throwable {
        try {
            synchronized (this) {
                if (this.mIsClosed) {
                    super.finalize();
                    return;
                }
                this.mLeakHandler.reportLeak(this.mSharedReference, this.mStacktrace);
                close();
                super.finalize();
            }
        } catch (Throwable th) {
            super.finalize();
            throw th;
        }
    }

    public synchronized T get() {
        try {
            k.checkState(!this.mIsClosed);
        }
        return this.mSharedReference.get();
    }

    public synchronized boolean isValid() {
        return !this.mIsClosed;
    }

    public static void closeSafely(Iterable<? extends CloseableReference<?>> iterable) {
        if (iterable != null) {
            for (CloseableReference closeableReference : iterable) {
                if (closeableReference != null) {
                    closeableReference.close();
                }
            }
        }
    }

    public static boolean isValid(CloseableReference<?> closeableReference) {
        return closeableReference != null && closeableReference.isValid();
    }

    public static <T> CloseableReference<T> of(T t, ResourceReleaser<T> resourceReleaser) {
        return of(t, resourceReleaser, DEFAULT_LEAK_HANDLER);
    }

    public static <T extends Closeable> CloseableReference<T> of(T t, LeakHandler leakHandler) {
        Throwable th = null;
        if (t == null) {
            return null;
        }
        ResourceReleaser<Closeable> resourceReleaser = DEFAULT_CLOSEABLE_RELEASER;
        if (leakHandler.requiresStacktrace()) {
            th = new Throwable();
        }
        return of(t, resourceReleaser, leakHandler, th);
    }

    public static <T> CloseableReference<T> cloneOrNull(CloseableReference<T> closeableReference) {
        if (closeableReference != null) {
            return closeableReference.cloneOrNull();
        }
        return null;
    }

    public static <T> List<CloseableReference<T>> cloneOrNull(Collection<CloseableReference<T>> collection) {
        if (collection == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (CloseableReference<T> cloneOrNull : collection) {
            arrayList.add(cloneOrNull(cloneOrNull));
        }
        return arrayList;
    }

    public static <T> CloseableReference<T> of(T t, ResourceReleaser<T> resourceReleaser, LeakHandler leakHandler) {
        Throwable th = null;
        if (t == null) {
            return null;
        }
        if (leakHandler.requiresStacktrace()) {
            th = new Throwable();
        }
        return of(t, resourceReleaser, leakHandler, th);
    }

    public static <T> CloseableReference<T> of(T t, ResourceReleaser<T> resourceReleaser, LeakHandler leakHandler, Throwable th) {
        if ((t instanceof Bitmap) || (t instanceof CloseableStaticBitmap)) {
            int i = sBitmapCloseableRefType;
            if (i == 1) {
                return new FinalizerCloseableReference(t, resourceReleaser, leakHandler, th);
            }
            if (i == 2) {
                return new RefCountCloseableReference(t, resourceReleaser, leakHandler, th);
            }
            if (i == 3) {
                return new NoOpCloseableReference(t, resourceReleaser, leakHandler, th);
            }
        }
        return new DefaultCloseableReference(t, resourceReleaser, leakHandler, th);
    }

    public CloseableReference(T t, ResourceReleaser<T> resourceReleaser, LeakHandler leakHandler, Throwable th) {
        this.mSharedReference = new SharedReference<>(t, resourceReleaser);
        this.mLeakHandler = leakHandler;
        this.mStacktrace = th;
    }
}
