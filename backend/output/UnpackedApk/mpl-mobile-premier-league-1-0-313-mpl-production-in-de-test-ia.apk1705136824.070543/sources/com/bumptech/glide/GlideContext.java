package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.Glide.RequestOptionsFactory;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.bumptech.glide.request.target.DrawableImageViewTarget;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import com.bumptech.glide.request.target.ViewTarget;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class GlideContext extends ContextWrapper {
    public static final TransitionOptions<?, ?> DEFAULT_TRANSITION_OPTIONS = new GenericTransitionOptions();
    public final ArrayPool arrayPool;
    public final List<RequestListener<Object>> defaultRequestListeners;
    public RequestOptions defaultRequestOptions;
    public final RequestOptionsFactory defaultRequestOptionsFactory;
    public final Map<Class<?>, TransitionOptions<?, ?>> defaultTransitionOptions;
    public final Engine engine;
    public final ImageViewTargetFactory imageViewTargetFactory;
    public final boolean isLoggingRequestOriginsEnabled;
    public final int logLevel;
    public final Registry registry;

    public GlideContext(Context context, ArrayPool arrayPool2, Registry registry2, ImageViewTargetFactory imageViewTargetFactory2, RequestOptionsFactory requestOptionsFactory, Map<Class<?>, TransitionOptions<?, ?>> map, List<RequestListener<Object>> list, Engine engine2, boolean z, int i) {
        super(context.getApplicationContext());
        this.arrayPool = arrayPool2;
        this.registry = registry2;
        this.imageViewTargetFactory = imageViewTargetFactory2;
        this.defaultRequestOptionsFactory = requestOptionsFactory;
        this.defaultRequestListeners = list;
        this.defaultTransitionOptions = map;
        this.engine = engine2;
        this.isLoggingRequestOriginsEnabled = z;
        this.logLevel = i;
    }

    public <X> ViewTarget<ImageView, X> buildImageViewTarget(ImageView imageView, Class<X> cls) {
        if (this.imageViewTargetFactory == null) {
            throw null;
        } else if (Bitmap.class.equals(cls)) {
            return new BitmapImageViewTarget(imageView);
        } else {
            if (Drawable.class.isAssignableFrom(cls)) {
                return new DrawableImageViewTarget(imageView);
            }
            throw new IllegalArgumentException("Unhandled class: " + cls + ", try .as*(Class).transcode(ResourceTranscoder)");
        }
    }

    public ArrayPool getArrayPool() {
        return this.arrayPool;
    }

    public List<RequestListener<Object>> getDefaultRequestListeners() {
        return this.defaultRequestListeners;
    }

    public synchronized RequestOptions getDefaultRequestOptions() {
        try {
            if (this.defaultRequestOptions == null) {
                this.defaultRequestOptions = (RequestOptions) this.defaultRequestOptionsFactory.build().lock();
            }
        }
        return this.defaultRequestOptions;
    }

    public <T> TransitionOptions<?, T> getDefaultTransitionOptions(Class<T> cls) {
        TransitionOptions<?, T> transitionOptions = this.defaultTransitionOptions.get(cls);
        if (transitionOptions == null) {
            for (Entry next : this.defaultTransitionOptions.entrySet()) {
                if (((Class) next.getKey()).isAssignableFrom(cls)) {
                    transitionOptions = (TransitionOptions) next.getValue();
                }
            }
        }
        return transitionOptions == null ? DEFAULT_TRANSITION_OPTIONS : transitionOptions;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public int getLogLevel() {
        return this.logLevel;
    }

    public Registry getRegistry() {
        return this.registry;
    }

    public boolean isLoggingRequestOriginsEnabled() {
        return this.isLoggingRequestOriginsEnabled;
    }
}
