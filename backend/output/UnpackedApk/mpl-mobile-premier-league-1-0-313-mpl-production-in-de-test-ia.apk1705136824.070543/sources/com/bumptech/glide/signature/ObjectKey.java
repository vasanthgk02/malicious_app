package com.bumptech.glide.signature;

import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.bumptech.glide.load.Key;
import java.security.MessageDigest;

public final class ObjectKey implements Key {
    public final Object object;

    public ObjectKey(Object obj) {
        k.checkNotNull(obj, (String) "Argument must not be null");
        this.object = obj;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ObjectKey) {
            return this.object.equals(((ObjectKey) obj).object);
        }
        return false;
    }

    public int hashCode() {
        return this.object.hashCode();
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("ObjectKey{object=");
        outline73.append(this.object);
        outline73.append('}');
        return outline73.toString();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(this.object.toString().getBytes(Key.CHARSET));
    }
}
