package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.load.engine.bitmap_recycle.Poolable;
import com.bumptech.glide.util.Util;
import java.util.Queue;

public abstract class BaseKeyPool<T extends Poolable> {
    public final Queue<T> keyPool = Util.createQueue(20);

    public abstract T create();

    public T get() {
        T t = (Poolable) this.keyPool.poll();
        return t == null ? create() : t;
    }

    public void offer(T t) {
        if (this.keyPool.size() < 20) {
            this.keyPool.offer(t);
        }
    }
}
