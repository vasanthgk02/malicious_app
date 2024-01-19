package com.bumptech.glide.load.engine;

import androidx.core.util.Pools$Pool;
import co.hyperverge.hypersnapsdk.c.k;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.FactoryPools.Factory;
import com.bumptech.glide.util.pool.FactoryPools.Poolable;
import com.bumptech.glide.util.pool.StateVerifier;
import com.bumptech.glide.util.pool.StateVerifier.DefaultStateVerifier;

public final class LockedResource<Z> implements Resource<Z>, Poolable {
    public static final Pools$Pool<LockedResource<?>> POOL = FactoryPools.threadSafe(20, new Factory<LockedResource<?>>() {
        public Object create() {
            return new LockedResource();
        }
    });
    public boolean isLocked;
    public boolean isRecycled;
    public final StateVerifier stateVerifier = new DefaultStateVerifier();
    public Resource<Z> toWrap;

    public static <Z> LockedResource<Z> obtain(Resource<Z> resource) {
        LockedResource<Z> lockedResource = (LockedResource) POOL.acquire();
        k.checkNotNull(lockedResource, (String) "Argument must not be null");
        lockedResource.isRecycled = false;
        lockedResource.isLocked = true;
        lockedResource.toWrap = resource;
        return lockedResource;
    }

    public Z get() {
        return this.toWrap.get();
    }

    public Class<Z> getResourceClass() {
        return this.toWrap.getResourceClass();
    }

    public int getSize() {
        return this.toWrap.getSize();
    }

    public StateVerifier getVerifier() {
        return this.stateVerifier;
    }

    public synchronized void recycle() {
        this.stateVerifier.throwIfRecycled();
        this.isRecycled = true;
        if (!this.isLocked) {
            this.toWrap.recycle();
            this.toWrap = null;
            POOL.release(this);
        }
    }

    public synchronized void unlock() {
        this.stateVerifier.throwIfRecycled();
        if (this.isLocked) {
            this.isLocked = false;
            if (this.isRecycled) {
                recycle();
            }
        } else {
            throw new IllegalStateException("Already unlocked");
        }
    }
}
