package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import co.hyperverge.hypersnapsdk.c.k;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;

public final class LazyBitmapDrawableResource implements Resource<BitmapDrawable>, Initializable {
    public final Resource<Bitmap> bitmapResource;
    public final Resources resources;

    public LazyBitmapDrawableResource(Resources resources2, Resource<Bitmap> resource) {
        k.checkNotNull(resources2, (String) "Argument must not be null");
        this.resources = resources2;
        k.checkNotNull(resource, (String) "Argument must not be null");
        this.bitmapResource = resource;
    }

    public static Resource<BitmapDrawable> obtain(Resources resources2, Resource<Bitmap> resource) {
        if (resource == null) {
            return null;
        }
        return new LazyBitmapDrawableResource(resources2, resource);
    }

    public Object get() {
        return new BitmapDrawable(this.resources, (Bitmap) this.bitmapResource.get());
    }

    public Class<BitmapDrawable> getResourceClass() {
        return BitmapDrawable.class;
    }

    public int getSize() {
        return this.bitmapResource.getSize();
    }

    public void initialize() {
        Resource<Bitmap> resource = this.bitmapResource;
        if (resource instanceof Initializable) {
            ((Initializable) resource).initialize();
        }
    }

    public void recycle() {
        this.bitmapResource.recycle();
    }
}
