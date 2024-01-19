package com.bumptech.glide.load;

import androidx.collection.ArrayMap;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.bumptech.glide.load.Option.CacheKeyUpdater;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import java.security.MessageDigest;

public final class Options implements Key {
    public final ArrayMap<Option<?>, Object> values = new CachedHashCodeArrayMap();

    public boolean equals(Object obj) {
        if (obj instanceof Options) {
            return this.values.equals(((Options) obj).values);
        }
        return false;
    }

    public <T> T get(Option<T> option) {
        if (this.values.indexOfKey(option) >= 0) {
            return this.values.getOrDefault(option, null);
        }
        return option.defaultValue;
    }

    public int hashCode() {
        return this.values.hashCode();
    }

    public void putAll(Options options) {
        this.values.putAll(options.values);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Options{values=");
        outline73.append(this.values);
        outline73.append('}');
        return outline73.toString();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        int i = 0;
        while (true) {
            ArrayMap<Option<?>, Object> arrayMap = this.values;
            if (i < arrayMap.mSize) {
                Option option = (Option) arrayMap.keyAt(i);
                Object valueAt = this.values.valueAt(i);
                CacheKeyUpdater<T> cacheKeyUpdater = option.cacheKeyUpdater;
                if (option.keyBytes == null) {
                    option.keyBytes = option.key.getBytes(Key.CHARSET);
                }
                cacheKeyUpdater.update(option.keyBytes, valueAt, messageDigest);
                i++;
            } else {
                return;
            }
        }
    }
}
