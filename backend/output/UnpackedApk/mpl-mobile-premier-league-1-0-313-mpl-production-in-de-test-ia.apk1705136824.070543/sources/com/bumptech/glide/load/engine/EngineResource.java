package com.bumptech.glide.load.engine;

import co.hyperverge.hypersnapsdk.c.k;
import com.bumptech.glide.load.Key;

public class EngineResource<Z> implements Resource<Z> {
    public int acquired;
    public final boolean isMemoryCacheable;
    public final boolean isRecyclable;
    public boolean isRecycled;
    public final Key key;
    public final ResourceListener listener;
    public final Resource<Z> resource;

    public interface ResourceListener {
        void onResourceReleased(Key key, EngineResource<?> engineResource);
    }

    public EngineResource(Resource<Z> resource2, boolean z, boolean z2, Key key2, ResourceListener resourceListener) {
        k.checkNotNull(resource2, (String) "Argument must not be null");
        this.resource = resource2;
        this.isMemoryCacheable = z;
        this.isRecyclable = z2;
        this.key = key2;
        k.checkNotNull(resourceListener, (String) "Argument must not be null");
        this.listener = resourceListener;
    }

    public synchronized void acquire() {
        if (!this.isRecycled) {
            this.acquired++;
        } else {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
    }

    public Z get() {
        return this.resource.get();
    }

    public Class<Z> getResourceClass() {
        return this.resource.getResourceClass();
    }

    public int getSize() {
        return this.resource.getSize();
    }

    public synchronized void recycle() {
        if (this.acquired > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        } else if (!this.isRecycled) {
            this.isRecycled = true;
            if (this.isRecyclable) {
                this.resource.recycle();
            }
        } else {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
    }

    public void release() {
        boolean z;
        synchronized (this) {
            if (this.acquired > 0) {
                z = true;
                int i = this.acquired - 1;
                this.acquired = i;
                if (i != 0) {
                    z = false;
                }
            } else {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
        }
        if (z) {
            this.listener.onResourceReleased(this.key, this);
        }
    }

    public synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.isMemoryCacheable + ", listener=" + this.listener + ", key=" + this.key + ", acquired=" + this.acquired + ", isRecycled=" + this.isRecycled + ", resource=" + this.resource + '}';
    }
}
