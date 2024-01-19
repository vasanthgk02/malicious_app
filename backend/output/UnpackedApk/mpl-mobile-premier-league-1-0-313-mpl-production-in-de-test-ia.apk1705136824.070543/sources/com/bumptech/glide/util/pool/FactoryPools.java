package com.bumptech.glide.util.pool;

import android.util.Log;
import androidx.core.util.Pools$Pool;
import androidx.core.util.Pools$SynchronizedPool;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.bumptech.glide.util.pool.StateVerifier.DefaultStateVerifier;

public final class FactoryPools {
    public static final Resetter<Object> EMPTY_RESETTER = new Resetter<Object>() {
        public void reset(Object obj) {
        }
    };

    public interface Factory<T> {
        T create();
    }

    public static final class FactoryPool<T> implements Pools$Pool<T> {
        public final Factory<T> factory;
        public final Pools$Pool<T> pool;
        public final Resetter<T> resetter;

        public FactoryPool(Pools$Pool<T> pools$Pool, Factory<T> factory2, Resetter<T> resetter2) {
            this.pool = pools$Pool;
            this.factory = factory2;
            this.resetter = resetter2;
        }

        public T acquire() {
            T acquire = this.pool.acquire();
            if (acquire == null) {
                acquire = this.factory.create();
                if (Log.isLoggable("FactoryPools", 2)) {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Created new ");
                    outline73.append(acquire.getClass());
                    outline73.toString();
                }
            }
            if (acquire instanceof Poolable) {
                ((DefaultStateVerifier) ((Poolable) acquire).getVerifier()).isReleased = false;
            }
            return acquire;
        }

        public boolean release(T t) {
            if (t instanceof Poolable) {
                ((DefaultStateVerifier) ((Poolable) t).getVerifier()).isReleased = true;
            }
            this.resetter.reset(t);
            return this.pool.release(t);
        }
    }

    public interface Poolable {
        StateVerifier getVerifier();
    }

    public interface Resetter<T> {
        void reset(T t);
    }

    public static <T extends Poolable> Pools$Pool<T> threadSafe(int i, Factory<T> factory) {
        return new FactoryPool(new Pools$SynchronizedPool(i), factory, EMPTY_RESETTER);
    }
}
