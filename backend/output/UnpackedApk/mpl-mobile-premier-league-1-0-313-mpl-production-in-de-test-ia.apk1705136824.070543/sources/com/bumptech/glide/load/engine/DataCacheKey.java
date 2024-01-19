package com.bumptech.glide.load.engine;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.bumptech.glide.load.Key;
import java.security.MessageDigest;

public final class DataCacheKey implements Key {
    public final Key signature;
    public final Key sourceKey;

    public DataCacheKey(Key key, Key key2) {
        this.sourceKey = key;
        this.signature = key2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DataCacheKey)) {
            return false;
        }
        DataCacheKey dataCacheKey = (DataCacheKey) obj;
        if (!this.sourceKey.equals(dataCacheKey.sourceKey) || !this.signature.equals(dataCacheKey.signature)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.signature.hashCode() + (this.sourceKey.hashCode() * 31);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("DataCacheKey{sourceKey=");
        outline73.append(this.sourceKey);
        outline73.append(", signature=");
        outline73.append(this.signature);
        outline73.append('}');
        return outline73.toString();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        this.sourceKey.updateDiskCacheKey(messageDigest);
        this.signature.updateDiskCacheKey(messageDigest);
    }
}
