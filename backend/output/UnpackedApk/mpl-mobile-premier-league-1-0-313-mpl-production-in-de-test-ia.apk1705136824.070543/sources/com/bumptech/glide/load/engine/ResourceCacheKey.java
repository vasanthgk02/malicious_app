package com.bumptech.glide.load.engine;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import org.apache.commons.lang.text.ExtendedMessageFormat;

public final class ResourceCacheKey implements Key {
    public static final LruCache<Class<?>, byte[]> RESOURCE_CLASS_BYTES = new LruCache<>(50);
    public final ArrayPool arrayPool;
    public final Class<?> decodedResourceClass;
    public final int height;
    public final Options options;
    public final Key signature;
    public final Key sourceKey;
    public final Transformation<?> transformation;
    public final int width;

    public ResourceCacheKey(ArrayPool arrayPool2, Key key, Key key2, int i, int i2, Transformation<?> transformation2, Class<?> cls, Options options2) {
        this.arrayPool = arrayPool2;
        this.sourceKey = key;
        this.signature = key2;
        this.width = i;
        this.height = i2;
        this.transformation = transformation2;
        this.decodedResourceClass = cls;
        this.options = options2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ResourceCacheKey)) {
            return false;
        }
        ResourceCacheKey resourceCacheKey = (ResourceCacheKey) obj;
        if (this.height != resourceCacheKey.height || this.width != resourceCacheKey.width || !Util.bothNullOrEqual(this.transformation, resourceCacheKey.transformation) || !this.decodedResourceClass.equals(resourceCacheKey.decodedResourceClass) || !this.sourceKey.equals(resourceCacheKey.sourceKey) || !this.signature.equals(resourceCacheKey.signature) || !this.options.equals(resourceCacheKey.options)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = ((((this.signature.hashCode() + (this.sourceKey.hashCode() * 31)) * 31) + this.width) * 31) + this.height;
        Transformation<?> transformation2 = this.transformation;
        if (transformation2 != null) {
            hashCode = (hashCode * 31) + transformation2.hashCode();
        }
        int hashCode2 = this.decodedResourceClass.hashCode();
        return this.options.hashCode() + ((hashCode2 + (hashCode * 31)) * 31);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("ResourceCacheKey{sourceKey=");
        outline73.append(this.sourceKey);
        outline73.append(", signature=");
        outline73.append(this.signature);
        outline73.append(", width=");
        outline73.append(this.width);
        outline73.append(", height=");
        outline73.append(this.height);
        outline73.append(", decodedResourceClass=");
        outline73.append(this.decodedResourceClass);
        outline73.append(", transformation='");
        outline73.append(this.transformation);
        outline73.append(ExtendedMessageFormat.QUOTE);
        outline73.append(", options=");
        outline73.append(this.options);
        outline73.append('}');
        return outline73.toString();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.arrayPool.getExact(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.width).putInt(this.height).array();
        this.signature.updateDiskCacheKey(messageDigest);
        this.sourceKey.updateDiskCacheKey(messageDigest);
        messageDigest.update(bArr);
        Transformation<?> transformation2 = this.transformation;
        if (transformation2 != null) {
            transformation2.updateDiskCacheKey(messageDigest);
        }
        this.options.updateDiskCacheKey(messageDigest);
        byte[] bArr2 = (byte[]) RESOURCE_CLASS_BYTES.get(this.decodedResourceClass);
        if (bArr2 == null) {
            bArr2 = this.decodedResourceClass.getName().getBytes(Key.CHARSET);
            RESOURCE_CLASS_BYTES.put(this.decodedResourceClass, bArr2);
        }
        messageDigest.update(bArr2);
        this.arrayPool.put(bArr);
    }
}
