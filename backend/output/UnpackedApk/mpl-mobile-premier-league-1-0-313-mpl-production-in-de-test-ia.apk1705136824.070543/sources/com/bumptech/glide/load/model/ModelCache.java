package com.bumptech.glide.load.model;

import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import java.util.Queue;

public class ModelCache<A, B> {
    public final LruCache<ModelKey<A>, B> cache;

    public static final class ModelKey<A> {
        public static final Queue<ModelKey<?>> KEY_QUEUE = Util.createQueue(0);
        public int height;
        public A model;
        public int width;

        public static <A> ModelKey<A> get(A a2, int i, int i2) {
            ModelKey<A> poll;
            synchronized (KEY_QUEUE) {
                try {
                    poll = KEY_QUEUE.poll();
                }
            }
            if (poll == null) {
                poll = new ModelKey<>();
            }
            poll.model = a2;
            poll.width = i;
            poll.height = i2;
            return poll;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ModelKey)) {
                return false;
            }
            ModelKey modelKey = (ModelKey) obj;
            if (this.width == modelKey.width && this.height == modelKey.height && this.model.equals(modelKey.model)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.model.hashCode() + (((this.height * 31) + this.width) * 31);
        }
    }

    public ModelCache(long j) {
        this.cache = new LruCache<ModelKey<A>, B>(this, j) {
            public void onItemEvicted(Object obj, Object obj2) {
                ModelKey modelKey = (ModelKey) obj;
                if (modelKey != null) {
                    synchronized (ModelKey.KEY_QUEUE) {
                        ModelKey.KEY_QUEUE.offer(modelKey);
                    }
                    return;
                }
                throw null;
            }
        };
    }
}
