package com.bumptech.glide.load.engine;

import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import java.security.MessageDigest;
import java.util.Map;

public class EngineKey implements Key {
    public int hashCode;
    public final int height;
    public final Object model;
    public final Options options;
    public final Class<?> resourceClass;
    public final Key signature;
    public final Class<?> transcodeClass;
    public final Map<Class<?>, Transformation<?>> transformations;
    public final int width;

    public EngineKey(Object obj, Key key, int i, int i2, Map<Class<?>, Transformation<?>> map, Class<?> cls, Class<?> cls2, Options options2) {
        k.checkNotNull(obj, (String) "Argument must not be null");
        this.model = obj;
        k.checkNotNull(key, (String) "Signature must not be null");
        this.signature = key;
        this.width = i;
        this.height = i2;
        k.checkNotNull(map, (String) "Argument must not be null");
        this.transformations = map;
        k.checkNotNull(cls, (String) "Resource class must not be null");
        this.resourceClass = cls;
        k.checkNotNull(cls2, (String) "Transcode class must not be null");
        this.transcodeClass = cls2;
        k.checkNotNull(options2, (String) "Argument must not be null");
        this.options = options2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof EngineKey)) {
            return false;
        }
        EngineKey engineKey = (EngineKey) obj;
        if (!this.model.equals(engineKey.model) || !this.signature.equals(engineKey.signature) || this.height != engineKey.height || this.width != engineKey.width || !this.transformations.equals(engineKey.transformations) || !this.resourceClass.equals(engineKey.resourceClass) || !this.transcodeClass.equals(engineKey.transcodeClass) || !this.options.equals(engineKey.options)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            int hashCode2 = this.model.hashCode();
            this.hashCode = hashCode2;
            int hashCode3 = this.signature.hashCode() + (hashCode2 * 31);
            this.hashCode = hashCode3;
            int i = (hashCode3 * 31) + this.width;
            this.hashCode = i;
            int i2 = (i * 31) + this.height;
            this.hashCode = i2;
            int hashCode4 = this.transformations.hashCode() + (i2 * 31);
            this.hashCode = hashCode4;
            int hashCode5 = this.resourceClass.hashCode() + (hashCode4 * 31);
            this.hashCode = hashCode5;
            int hashCode6 = this.transcodeClass.hashCode() + (hashCode5 * 31);
            this.hashCode = hashCode6;
            this.hashCode = this.options.hashCode() + (hashCode6 * 31);
        }
        return this.hashCode;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("EngineKey{model=");
        outline73.append(this.model);
        outline73.append(", width=");
        outline73.append(this.width);
        outline73.append(", height=");
        outline73.append(this.height);
        outline73.append(", resourceClass=");
        outline73.append(this.resourceClass);
        outline73.append(", transcodeClass=");
        outline73.append(this.transcodeClass);
        outline73.append(", signature=");
        outline73.append(this.signature);
        outline73.append(", hashCode=");
        outline73.append(this.hashCode);
        outline73.append(", transformations=");
        outline73.append(this.transformations);
        outline73.append(", options=");
        outline73.append(this.options);
        outline73.append('}');
        return outline73.toString();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }
}
