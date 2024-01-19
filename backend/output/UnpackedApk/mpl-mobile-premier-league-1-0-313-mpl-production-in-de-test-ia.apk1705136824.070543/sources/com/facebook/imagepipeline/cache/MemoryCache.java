package com.facebook.imagepipeline.cache;

import com.facebook.common.internal.Predicate;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.references.CloseableReference;

public interface MemoryCache<K, V> {

    public interface CacheTrimStrategy {
        double getTrimRatio(MemoryTrimType memoryTrimType);
    }

    CloseableReference<V> cache(K k, CloseableReference<V> closeableReference);

    boolean contains(Predicate<K> predicate);

    boolean contains(K k);

    CloseableReference<V> get(K k);

    int getCount();

    int getSizeInBytes();

    int removeAll(Predicate<K> predicate);
}
