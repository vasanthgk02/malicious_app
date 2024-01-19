package com.facebook.common.references;

import android.graphics.Bitmap;
import co.hyperverge.hypersnapsdk.c.k;
import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import java.util.IdentityHashMap;
import java.util.Map;

public class SharedReference<T> {
    public static final Map<Object, Integer> sLiveObjects = new IdentityHashMap();
    public int mRefCount;
    public final ResourceReleaser<T> mResourceReleaser;
    public T mValue;

    public static class NullReferenceException extends RuntimeException {
        public NullReferenceException() {
            super("Null shared reference");
        }
    }

    public SharedReference(T t, ResourceReleaser<T> resourceReleaser) {
        if (t != null) {
            this.mValue = t;
            if (resourceReleaser != null) {
                this.mResourceReleaser = resourceReleaser;
                this.mRefCount = 1;
                if (!(CloseableReference.sBitmapCloseableRefType == 3) || (!(t instanceof Bitmap) && !(t instanceof CloseableStaticBitmap))) {
                    synchronized (sLiveObjects) {
                        Integer num = sLiveObjects.get(t);
                        if (num == null) {
                            sLiveObjects.put(t, Integer.valueOf(1));
                        } else {
                            sLiveObjects.put(t, Integer.valueOf(num.intValue() + 1));
                        }
                    }
                    return;
                }
                return;
            }
            throw null;
        }
        throw null;
    }

    public void deleteReference() {
        int i;
        T t;
        synchronized (this) {
            ensureValid();
            k.checkArgument(this.mRefCount > 0);
            i = this.mRefCount - 1;
            this.mRefCount = i;
        }
        if (i == 0) {
            synchronized (this) {
                t = this.mValue;
                this.mValue = null;
            }
            this.mResourceReleaser.release(t);
            synchronized (sLiveObjects) {
                Integer num = sLiveObjects.get(t);
                if (num == null) {
                    FLog.wtf("SharedReference", "No entry in sLiveObjects for value of type %s", t.getClass());
                } else if (num.intValue() == 1) {
                    sLiveObjects.remove(t);
                } else {
                    sLiveObjects.put(t, Integer.valueOf(num.intValue() - 1));
                }
            }
        }
    }

    public final void ensureValid() {
        boolean z;
        boolean z2;
        synchronized (this) {
            z = false;
            z2 = this.mRefCount > 0;
        }
        if (z2) {
            z = true;
        }
        if (!z) {
            throw new NullReferenceException();
        }
    }

    public synchronized T get() {
        try {
        }
        return this.mValue;
    }
}
