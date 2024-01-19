package com.bumptech.glide.load;

import android.text.TextUtils;
import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.security.MessageDigest;
import org.apache.commons.lang.text.ExtendedMessageFormat;

public final class Option<T> {
    public static final CacheKeyUpdater<Object> EMPTY_UPDATER = new CacheKeyUpdater<Object>() {
        public void update(byte[] bArr, Object obj, MessageDigest messageDigest) {
        }
    };
    public final CacheKeyUpdater<T> cacheKeyUpdater;
    public final T defaultValue;
    public final String key;
    public volatile byte[] keyBytes;

    public interface CacheKeyUpdater<T> {
        void update(byte[] bArr, T t, MessageDigest messageDigest);
    }

    public Option(String str, T t, CacheKeyUpdater<T> cacheKeyUpdater2) {
        if (!TextUtils.isEmpty(str)) {
            this.key = str;
            this.defaultValue = t;
            k.checkNotNull(cacheKeyUpdater2, (String) "Argument must not be null");
            this.cacheKeyUpdater = cacheKeyUpdater2;
            return;
        }
        throw new IllegalArgumentException("Must not be null or empty");
    }

    public static <T> Option<T> memory(String str, T t) {
        return new Option<>(str, t, EMPTY_UPDATER);
    }

    public boolean equals(Object obj) {
        if (obj instanceof Option) {
            return this.key.equals(((Option) obj).key);
        }
        return false;
    }

    public int hashCode() {
        return this.key.hashCode();
    }

    public String toString() {
        return GeneratedOutlineSupport.outline60(GeneratedOutlineSupport.outline73("Option{key='"), this.key, ExtendedMessageFormat.QUOTE, '}');
    }
}
