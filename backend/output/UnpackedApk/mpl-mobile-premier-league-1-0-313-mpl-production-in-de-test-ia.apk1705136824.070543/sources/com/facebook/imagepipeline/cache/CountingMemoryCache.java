package com.facebook.imagepipeline.cache;

import android.graphics.Bitmap;
import android.os.SystemClock;
import co.hyperverge.hypersnapsdk.c.k;
import com.facebook.common.internal.Objects$ToStringHelper;
import com.facebook.common.internal.Predicate;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imagepipeline.cache.MemoryCache.CacheTrimStrategy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

public class CountingMemoryCache<K, V> implements MemoryCache<K, V>, MemoryTrimmable {
    public final CacheTrimStrategy mCacheTrimStrategy;
    public final CountingLruMap<K, Entry<K, V>> mCachedEntries;
    public final CountingLruMap<K, Entry<K, V>> mExclusiveEntries;
    public long mLastCacheParamsCheck;
    public MemoryCacheParams mMemoryCacheParams;
    public final Supplier<MemoryCacheParams> mMemoryCacheParamsSupplier;
    public final Map<Bitmap, Object> mOtherEntries = new WeakHashMap();
    public final ValueDescriptor<V> mValueDescriptor;

    public static class Entry<K, V> {
        public int clientCount;
        public boolean isOrphan;
        public final K key;
        public final EntryStateObserver<K> observer;
        public final CloseableReference<V> valueRef;

        public Entry(K k, CloseableReference<V> closeableReference, EntryStateObserver<K> entryStateObserver) {
            if (k != null) {
                this.key = k;
                CloseableReference<V> cloneOrNull = CloseableReference.cloneOrNull(closeableReference);
                k.checkNotNull1(cloneOrNull);
                this.valueRef = cloneOrNull;
                this.clientCount = 0;
                this.isOrphan = false;
                this.observer = entryStateObserver;
                return;
            }
            throw null;
        }

        public static <K, V> Entry<K, V> of(K k, CloseableReference<V> closeableReference, EntryStateObserver<K> entryStateObserver) {
            return new Entry<>(k, closeableReference, entryStateObserver);
        }
    }

    public interface EntryStateObserver<K> {
        void onExclusivityChanged(K k, boolean z);
    }

    public CountingMemoryCache(ValueDescriptor<V> valueDescriptor, CacheTrimStrategy cacheTrimStrategy, Supplier<MemoryCacheParams> supplier) {
        this.mValueDescriptor = valueDescriptor;
        this.mExclusiveEntries = new CountingLruMap<>(wrapValueDescriptor(valueDescriptor));
        this.mCachedEntries = new CountingLruMap<>(wrapValueDescriptor(valueDescriptor));
        this.mCacheTrimStrategy = cacheTrimStrategy;
        this.mMemoryCacheParamsSupplier = supplier;
        this.mMemoryCacheParams = (MemoryCacheParams) supplier.get();
        this.mLastCacheParamsCheck = SystemClock.uptimeMillis();
    }

    private synchronized boolean canCacheNewValue(V v) {
        boolean z;
        int sizeInBytes = this.mValueDescriptor.getSizeInBytes(v);
        z = true;
        if (sizeInBytes > this.mMemoryCacheParams.maxCacheEntrySize || getInUseCount() > this.mMemoryCacheParams.maxCacheEntries - 1 || getInUseSizeInBytes() > this.mMemoryCacheParams.maxCacheSize - sizeInBytes) {
            z = false;
        }
        return z;
    }

    private synchronized void decreaseClientCount(Entry<K, V> entry) {
        if (entry != null) {
            k.checkState(entry.clientCount > 0);
            entry.clientCount--;
        } else {
            throw null;
        }
    }

    private synchronized void increaseClientCount(Entry<K, V> entry) {
        if (entry != null) {
            k.checkState(!entry.isOrphan);
            entry.clientCount++;
        } else {
            throw null;
        }
    }

    private synchronized void makeOrphan(Entry<K, V> entry) {
        if (entry != null) {
            k.checkState(!entry.isOrphan);
            entry.isOrphan = true;
        } else {
            throw null;
        }
    }

    private synchronized void makeOrphans(ArrayList<Entry<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<Entry<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                makeOrphan(it.next());
            }
        }
    }

    private synchronized boolean maybeAddToExclusives(Entry<K, V> entry) {
        if (entry.isOrphan || entry.clientCount != 0) {
            return false;
        }
        this.mExclusiveEntries.put(entry.key, entry);
        return true;
    }

    private void maybeClose(ArrayList<Entry<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<Entry<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                CloseableReference.closeSafely(referenceToClose(it.next()));
            }
        }
    }

    private void maybeEvictEntries() {
        ArrayList trimExclusivelyOwnedEntries;
        synchronized (this) {
            trimExclusivelyOwnedEntries = trimExclusivelyOwnedEntries(Math.min(this.mMemoryCacheParams.maxEvictionQueueEntries, this.mMemoryCacheParams.maxCacheEntries - getInUseCount()), Math.min(this.mMemoryCacheParams.maxEvictionQueueSize, this.mMemoryCacheParams.maxCacheSize - getInUseSizeInBytes()));
            makeOrphans(trimExclusivelyOwnedEntries);
        }
        maybeClose(trimExclusivelyOwnedEntries);
        maybeNotifyExclusiveEntryRemoval(trimExclusivelyOwnedEntries);
    }

    public static <K, V> void maybeNotifyExclusiveEntryInsertion(Entry<K, V> entry) {
        if (entry != null) {
            EntryStateObserver<K> entryStateObserver = entry.observer;
            if (entryStateObserver != null) {
                entryStateObserver.onExclusivityChanged(entry.key, true);
            }
        }
    }

    private void maybeNotifyExclusiveEntryRemoval(ArrayList<Entry<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<Entry<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                maybeNotifyExclusiveEntryRemoval(it.next());
            }
        }
    }

    private synchronized void maybeUpdateCacheParams() {
        if (this.mLastCacheParamsCheck + this.mMemoryCacheParams.paramsCheckIntervalMs <= SystemClock.uptimeMillis()) {
            this.mLastCacheParamsCheck = SystemClock.uptimeMillis();
            this.mMemoryCacheParams = (MemoryCacheParams) this.mMemoryCacheParamsSupplier.get();
        }
    }

    private synchronized CloseableReference<V> newClientReference(final Entry<K, V> entry) {
        increaseClientCount(entry);
        return CloseableReference.of(entry.valueRef.get(), (ResourceReleaser<T>) new ResourceReleaser<V>() {
            public void release(V v) {
                CountingMemoryCache.this.releaseClientReference(entry);
            }
        });
    }

    private synchronized CloseableReference<V> referenceToClose(Entry<K, V> entry) {
        CloseableReference<V> closeableReference;
        closeableReference = null;
        if (entry == null) {
            throw null;
        } else if (entry.isOrphan && entry.clientCount == 0) {
            closeableReference = entry.valueRef;
        }
        return closeableReference;
    }

    /* access modifiers changed from: private */
    public void releaseClientReference(Entry<K, V> entry) {
        boolean maybeAddToExclusives;
        CloseableReference referenceToClose;
        if (entry != null) {
            synchronized (this) {
                decreaseClientCount(entry);
                maybeAddToExclusives = maybeAddToExclusives(entry);
                referenceToClose = referenceToClose(entry);
            }
            CloseableReference.closeSafely(referenceToClose);
            if (!maybeAddToExclusives) {
                entry = null;
            }
            maybeNotifyExclusiveEntryInsertion(entry);
            maybeUpdateCacheParams();
            maybeEvictEntries();
            return;
        }
        throw null;
    }

    private synchronized ArrayList<Entry<K, V>> trimExclusivelyOwnedEntries(int i, int i2) {
        int max = Math.max(i, 0);
        int max2 = Math.max(i2, 0);
        if (this.mExclusiveEntries.getCount() <= max && this.mExclusiveEntries.getSizeInBytes() <= max2) {
            return null;
        }
        ArrayList<Entry<K, V>> arrayList = new ArrayList<>();
        while (true) {
            if (this.mExclusiveEntries.getCount() <= max && this.mExclusiveEntries.getSizeInBytes() <= max2) {
                return arrayList;
            }
            Object firstKey = this.mExclusiveEntries.getFirstKey();
            this.mExclusiveEntries.remove(firstKey);
            arrayList.add(this.mCachedEntries.remove(firstKey));
        }
    }

    private ValueDescriptor<Entry<K, V>> wrapValueDescriptor(final ValueDescriptor<V> valueDescriptor) {
        return new ValueDescriptor<Entry<K, V>>() {
            public int getSizeInBytes(Entry<K, V> entry) {
                return valueDescriptor.getSizeInBytes(entry.valueRef.get());
            }
        };
    }

    public CloseableReference<V> cache(K k, CloseableReference<V> closeableReference) {
        return cache(k, closeableReference, null);
    }

    public void clear() {
        ArrayList clear;
        ArrayList clear2;
        synchronized (this) {
            clear = this.mExclusiveEntries.clear();
            clear2 = this.mCachedEntries.clear();
            makeOrphans(clear2);
        }
        maybeClose(clear2);
        maybeNotifyExclusiveEntryRemoval(clear);
        maybeUpdateCacheParams();
    }

    public synchronized boolean contains(Predicate<K> predicate) {
        return !this.mCachedEntries.getMatchingEntries(predicate).isEmpty();
    }

    public CloseableReference<V> get(K k) {
        Entry entry;
        CloseableReference<V> closeableReference = null;
        if (k != null) {
            synchronized (this) {
                try {
                    entry = (Entry) this.mExclusiveEntries.remove(k);
                    Entry entry2 = (Entry) this.mCachedEntries.get(k);
                    if (entry2 != null) {
                        closeableReference = newClientReference(entry2);
                    }
                }
            }
            maybeNotifyExclusiveEntryRemoval(entry);
            maybeUpdateCacheParams();
            maybeEvictEntries();
            return closeableReference;
        }
        throw null;
    }

    public synchronized int getCount() {
        return this.mCachedEntries.getCount();
    }

    public synchronized int getEvictionQueueCount() {
        return this.mExclusiveEntries.getCount();
    }

    public synchronized int getEvictionQueueSizeInBytes() {
        return this.mExclusiveEntries.getSizeInBytes();
    }

    public synchronized int getInUseCount() {
        return this.mCachedEntries.getCount() - this.mExclusiveEntries.getCount();
    }

    public synchronized int getInUseSizeInBytes() {
        return this.mCachedEntries.getSizeInBytes() - this.mExclusiveEntries.getSizeInBytes();
    }

    public MemoryCacheParams getMemoryCacheParams() {
        return this.mMemoryCacheParams;
    }

    public synchronized int getSizeInBytes() {
        return this.mCachedEntries.getSizeInBytes();
    }

    public int removeAll(Predicate<K> predicate) {
        ArrayList removeAll;
        ArrayList removeAll2;
        synchronized (this) {
            removeAll = this.mExclusiveEntries.removeAll(predicate);
            removeAll2 = this.mCachedEntries.removeAll(predicate);
            makeOrphans(removeAll2);
        }
        maybeClose(removeAll2);
        maybeNotifyExclusiveEntryRemoval(removeAll);
        maybeUpdateCacheParams();
        maybeEvictEntries();
        return removeAll2.size();
    }

    public String reportData() {
        Objects$ToStringHelper objects$ToStringHelper = new Objects$ToStringHelper("CountingMemoryCache", null);
        objects$ToStringHelper.add((String) "cached_entries_count:", this.mCachedEntries.getCount());
        objects$ToStringHelper.add((String) "cached_entries_size_bytes", this.mCachedEntries.getSizeInBytes());
        objects$ToStringHelper.add((String) "exclusive_entries_count", this.mExclusiveEntries.getCount());
        objects$ToStringHelper.add((String) "exclusive_entries_size_bytes", this.mExclusiveEntries.getSizeInBytes());
        return objects$ToStringHelper.toString();
    }

    public CloseableReference<V> reuse(K k) {
        Entry entry;
        boolean z;
        CloseableReference<V> closeableReference = null;
        if (k != null) {
            synchronized (this) {
                try {
                    entry = (Entry) this.mExclusiveEntries.remove(k);
                    z = true;
                    boolean z2 = false;
                    if (entry != null) {
                        Entry entry2 = (Entry) this.mCachedEntries.remove(k);
                        k.checkNotNull1(entry2);
                        if (entry2.clientCount == 0) {
                            z2 = true;
                        }
                        k.checkState(z2);
                        closeableReference = entry2.valueRef;
                    } else {
                        z = false;
                    }
                }
            }
            if (z) {
                maybeNotifyExclusiveEntryRemoval(entry);
            }
            return closeableReference;
        }
        throw null;
    }

    public void trim(MemoryTrimType memoryTrimType) {
        ArrayList trimExclusivelyOwnedEntries;
        double trimRatio = this.mCacheTrimStrategy.getTrimRatio(memoryTrimType);
        synchronized (this) {
            trimExclusivelyOwnedEntries = trimExclusivelyOwnedEntries(Integer.MAX_VALUE, Math.max(0, ((int) ((1.0d - trimRatio) * ((double) this.mCachedEntries.getSizeInBytes()))) - getInUseSizeInBytes()));
            makeOrphans(trimExclusivelyOwnedEntries);
        }
        maybeClose(trimExclusivelyOwnedEntries);
        maybeNotifyExclusiveEntryRemoval(trimExclusivelyOwnedEntries);
        maybeUpdateCacheParams();
        maybeEvictEntries();
    }

    public CloseableReference<V> cache(K k, CloseableReference<V> closeableReference, EntryStateObserver<K> entryStateObserver) {
        Entry entry;
        CloseableReference closeableReference2;
        CloseableReference<V> closeableReference3 = null;
        if (k == null) {
            throw null;
        } else if (closeableReference != null) {
            maybeUpdateCacheParams();
            synchronized (this) {
                try {
                    entry = (Entry) this.mExclusiveEntries.remove(k);
                    Entry entry2 = (Entry) this.mCachedEntries.remove(k);
                    if (entry2 != null) {
                        makeOrphan(entry2);
                        closeableReference2 = referenceToClose(entry2);
                    } else {
                        closeableReference2 = null;
                    }
                    if (canCacheNewValue(closeableReference.get())) {
                        Entry of = Entry.of(k, closeableReference, entryStateObserver);
                        this.mCachedEntries.put(k, of);
                        closeableReference3 = newClientReference(of);
                    }
                }
            }
            if (closeableReference2 != null) {
                closeableReference2.close();
            }
            maybeNotifyExclusiveEntryRemoval(entry);
            maybeEvictEntries();
            return closeableReference3;
        } else {
            throw null;
        }
    }

    public synchronized boolean contains(K k) {
        try {
        }
        return this.mCachedEntries.contains(k);
    }

    public static <K, V> void maybeNotifyExclusiveEntryRemoval(Entry<K, V> entry) {
        if (entry != null) {
            EntryStateObserver<K> entryStateObserver = entry.observer;
            if (entryStateObserver != null) {
                entryStateObserver.onExclusivityChanged(entry.key, false);
            }
        }
    }
}
