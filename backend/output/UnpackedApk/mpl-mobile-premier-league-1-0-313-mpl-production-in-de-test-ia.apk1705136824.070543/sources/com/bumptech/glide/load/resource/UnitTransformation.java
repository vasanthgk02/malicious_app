package com.bumptech.glide.load.resource;

import android.content.Context;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import java.security.MessageDigest;

public final class UnitTransformation<T> implements Transformation<T> {
    public static final Transformation<?> TRANSFORMATION = new UnitTransformation();

    public Resource<T> transform(Context context, Resource<T> resource, int i, int i2) {
        return resource;
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
    }
}
