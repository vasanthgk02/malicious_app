package com.facebook.imagepipeline.animated.impl;

import android.net.Uri;
import co.hyperverge.hypersnapsdk.c.k;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Objects$ToStringHelper;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.CountingMemoryCache.EntryStateObserver;
import com.facebook.imagepipeline.image.CloseableImage;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class AnimatedFrameCache {
    public final CountingMemoryCache<CacheKey, CloseableImage> mBackingCache;
    public final EntryStateObserver<CacheKey> mEntryStateObserver = new EntryStateObserver<CacheKey>() {
        public void onExclusivityChanged(CacheKey cacheKey, boolean z) {
            AnimatedFrameCache.this.onReusabilityChange(cacheKey, z);
        }
    };
    public final LinkedHashSet<CacheKey> mFreeItemsPool = new LinkedHashSet<>();
    public final CacheKey mImageCacheKey;

    public static class FrameKey implements CacheKey {
        public final int mFrameIndex;
        public final CacheKey mImageCacheKey;

        public FrameKey(CacheKey cacheKey, int i) {
            this.mImageCacheKey = cacheKey;
            this.mFrameIndex = i;
        }

        public boolean containsUri(Uri uri) {
            return this.mImageCacheKey.containsUri(uri);
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof FrameKey)) {
                return false;
            }
            FrameKey frameKey = (FrameKey) obj;
            if (this.mFrameIndex != frameKey.mFrameIndex || !this.mImageCacheKey.equals(frameKey.mImageCacheKey)) {
                z = false;
            }
            return z;
        }

        public String getUriString() {
            return null;
        }

        public int hashCode() {
            return (this.mImageCacheKey.hashCode() * 1013) + this.mFrameIndex;
        }

        public abstract /* synthetic */ boolean isResourceIdForDebugging();

        public String toString() {
            Objects$ToStringHelper stringHelper = k.toStringHelper(this);
            stringHelper.addHolder("imageCacheKey", this.mImageCacheKey);
            stringHelper.add((String) "frameIndex", this.mFrameIndex);
            return stringHelper.toString();
        }
    }

    public AnimatedFrameCache(CacheKey cacheKey, CountingMemoryCache<CacheKey, CloseableImage> countingMemoryCache) {
        this.mImageCacheKey = cacheKey;
        this.mBackingCache = countingMemoryCache;
    }

    private FrameKey keyFor(int i) {
        return new FrameKey(this.mImageCacheKey, i);
    }

    private synchronized CacheKey popFirstFreeItemKey() {
        CacheKey cacheKey;
        cacheKey = null;
        Iterator it = this.mFreeItemsPool.iterator();
        if (it.hasNext()) {
            cacheKey = (CacheKey) it.next();
            it.remove();
        }
        return cacheKey;
    }

    public CloseableReference<CloseableImage> cache(int i, CloseableReference<CloseableImage> closeableReference) {
        return this.mBackingCache.cache(keyFor(i), closeableReference, this.mEntryStateObserver);
    }

    public boolean contains(int i) {
        return this.mBackingCache.contains(keyFor(i));
    }

    public CloseableReference<CloseableImage> get(int i) {
        return this.mBackingCache.get(keyFor(i));
    }

    public CloseableReference<CloseableImage> getForReuse() {
        CloseableReference<CloseableImage> reuse;
        do {
            CacheKey popFirstFreeItemKey = popFirstFreeItemKey();
            if (popFirstFreeItemKey == null) {
                return null;
            }
            reuse = this.mBackingCache.reuse(popFirstFreeItemKey);
        } while (reuse == null);
        return reuse;
    }

    public synchronized void onReusabilityChange(CacheKey cacheKey, boolean z) {
        if (z) {
            this.mFreeItemsPool.add(cacheKey);
        } else {
            this.mFreeItemsPool.remove(cacheKey);
        }
    }
}
