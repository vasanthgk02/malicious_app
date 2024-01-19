package com.facebook.imagepipeline.cache;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CountingMemoryCacheInspector<K, V> {
    public final CountingMemoryCache<K, V> mCountingBitmapCache;

    public static class DumpInfo<K, V> {
        public final List<DumpInfoEntry<K, V>> lruEntries = new ArrayList();
        public final int lruSize;
        public final int maxEntriesCount;
        public final int maxEntrySize;
        public final int maxSize;
        public final Map<Bitmap, Object> otherEntries = new HashMap();
        public final List<DumpInfoEntry<K, V>> sharedEntries = new ArrayList();
        public final int size;

        public DumpInfo(int i, int i2, MemoryCacheParams memoryCacheParams) {
            this.maxSize = memoryCacheParams.maxCacheSize;
            this.maxEntriesCount = memoryCacheParams.maxCacheEntries;
            this.maxEntrySize = memoryCacheParams.maxCacheEntrySize;
            this.size = i;
            this.lruSize = i2;
        }

        public void release() {
            for (DumpInfoEntry<K, V> release : this.lruEntries) {
                release.release();
            }
            for (DumpInfoEntry<K, V> release2 : this.sharedEntries) {
                release2.release();
            }
        }
    }

    public static class DumpInfoEntry<K, V> {
        public final K key;
        public final CloseableReference<V> value;

        public DumpInfoEntry(K k, CloseableReference<V> closeableReference) {
            if (k != null) {
                this.key = k;
                this.value = CloseableReference.cloneOrNull(closeableReference);
                return;
            }
            throw null;
        }

        public void release() {
            CloseableReference.closeSafely(this.value);
        }
    }

    public CountingMemoryCacheInspector(CountingMemoryCache<K, V> countingMemoryCache) {
        this.mCountingBitmapCache = countingMemoryCache;
    }

    public DumpInfo dumpCacheContent() {
        DumpInfo dumpInfo;
        synchronized (this.mCountingBitmapCache) {
            dumpInfo = new DumpInfo(this.mCountingBitmapCache.getSizeInBytes(), this.mCountingBitmapCache.getEvictionQueueSizeInBytes(), this.mCountingBitmapCache.mMemoryCacheParams);
            for (Entry value : this.mCountingBitmapCache.mCachedEntries.getMatchingEntries(null)) {
                CountingMemoryCache.Entry entry = (CountingMemoryCache.Entry) value.getValue();
                DumpInfoEntry dumpInfoEntry = new DumpInfoEntry(entry.key, entry.valueRef);
                if (entry.clientCount > 0) {
                    dumpInfo.sharedEntries.add(dumpInfoEntry);
                } else {
                    dumpInfo.lruEntries.add(dumpInfoEntry);
                }
            }
            for (Entry next : this.mCountingBitmapCache.mOtherEntries.entrySet()) {
                if (next != null && !((Bitmap) next.getKey()).isRecycled()) {
                    dumpInfo.otherEntries.put(next.getKey(), next.getValue());
                }
            }
        }
        return dumpInfo;
    }
}
