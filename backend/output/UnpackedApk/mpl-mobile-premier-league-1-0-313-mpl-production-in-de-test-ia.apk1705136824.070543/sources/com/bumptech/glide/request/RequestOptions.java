package com.bumptech.glide.request;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;

public class RequestOptions extends BaseRequestOptions<RequestOptions> {
    public static RequestOptions centerCropOptions;
    public static RequestOptions centerInsideOptions;
    public static RequestOptions circleCropOptions;
    public static RequestOptions fitCenterOptions;
    public static RequestOptions noAnimationOptions;
    public static RequestOptions noTransformOptions;
    public static RequestOptions skipMemoryCacheFalseOptions;
    public static RequestOptions skipMemoryCacheTrueOptions;

    public static RequestOptions bitmapTransform(Transformation<Bitmap> transformation) {
        return (RequestOptions) new RequestOptions().transform(transformation);
    }

    public static RequestOptions centerCropTransform() {
        if (centerCropOptions == null) {
            centerCropOptions = (RequestOptions) ((RequestOptions) new RequestOptions().centerCrop()).autoClone();
        }
        return centerCropOptions;
    }

    public static RequestOptions centerInsideTransform() {
        if (centerInsideOptions == null) {
            centerInsideOptions = (RequestOptions) ((RequestOptions) new RequestOptions().centerInside()).autoClone();
        }
        return centerInsideOptions;
    }

    public static RequestOptions circleCropTransform() {
        if (circleCropOptions == null) {
            circleCropOptions = (RequestOptions) ((RequestOptions) new RequestOptions().circleCrop()).autoClone();
        }
        return circleCropOptions;
    }

    public static RequestOptions decodeTypeOf(Class<?> cls) {
        return (RequestOptions) new RequestOptions().decode(cls);
    }

    public static RequestOptions diskCacheStrategyOf(DiskCacheStrategy diskCacheStrategy) {
        return (RequestOptions) new RequestOptions().diskCacheStrategy(diskCacheStrategy);
    }

    public static RequestOptions downsampleOf(DownsampleStrategy downsampleStrategy) {
        return (RequestOptions) new RequestOptions().downsample(downsampleStrategy);
    }

    public static RequestOptions encodeFormatOf(CompressFormat compressFormat) {
        return (RequestOptions) new RequestOptions().encodeFormat(compressFormat);
    }

    public static RequestOptions encodeQualityOf(int i) {
        return (RequestOptions) new RequestOptions().encodeQuality(i);
    }

    public static RequestOptions errorOf(Drawable drawable) {
        return (RequestOptions) new RequestOptions().error(drawable);
    }

    public static RequestOptions fitCenterTransform() {
        if (fitCenterOptions == null) {
            fitCenterOptions = (RequestOptions) ((RequestOptions) new RequestOptions().fitCenter()).autoClone();
        }
        return fitCenterOptions;
    }

    public static RequestOptions formatOf(DecodeFormat decodeFormat) {
        return (RequestOptions) new RequestOptions().format(decodeFormat);
    }

    public static RequestOptions frameOf(long j) {
        return (RequestOptions) new RequestOptions().frame(j);
    }

    public static RequestOptions noAnimation() {
        if (noAnimationOptions == null) {
            noAnimationOptions = (RequestOptions) ((RequestOptions) new RequestOptions().dontAnimate()).autoClone();
        }
        return noAnimationOptions;
    }

    public static RequestOptions noTransformation() {
        if (noTransformOptions == null) {
            noTransformOptions = (RequestOptions) ((RequestOptions) new RequestOptions().dontTransform()).autoClone();
        }
        return noTransformOptions;
    }

    public static <T> RequestOptions option(Option<T> option, T t) {
        return (RequestOptions) new RequestOptions().set(option, t);
    }

    public static RequestOptions overrideOf(int i, int i2) {
        return (RequestOptions) new RequestOptions().override(i, i2);
    }

    public static RequestOptions placeholderOf(Drawable drawable) {
        return (RequestOptions) new RequestOptions().placeholder(drawable);
    }

    public static RequestOptions priorityOf(Priority priority) {
        return (RequestOptions) new RequestOptions().priority(priority);
    }

    public static RequestOptions signatureOf(Key key) {
        return (RequestOptions) new RequestOptions().signature(key);
    }

    public static RequestOptions sizeMultiplierOf(float f2) {
        return (RequestOptions) new RequestOptions().sizeMultiplier(f2);
    }

    public static RequestOptions skipMemoryCacheOf(boolean z) {
        if (z) {
            if (skipMemoryCacheTrueOptions == null) {
                skipMemoryCacheTrueOptions = (RequestOptions) ((RequestOptions) new RequestOptions().skipMemoryCache(true)).autoClone();
            }
            return skipMemoryCacheTrueOptions;
        }
        if (skipMemoryCacheFalseOptions == null) {
            skipMemoryCacheFalseOptions = (RequestOptions) ((RequestOptions) new RequestOptions().skipMemoryCache(false)).autoClone();
        }
        return skipMemoryCacheFalseOptions;
    }

    public static RequestOptions timeoutOf(int i) {
        return (RequestOptions) new RequestOptions().timeout(i);
    }

    public static RequestOptions errorOf(int i) {
        return (RequestOptions) new RequestOptions().error(i);
    }

    public static RequestOptions overrideOf(int i) {
        return overrideOf(i, i);
    }

    public static RequestOptions placeholderOf(int i) {
        return (RequestOptions) new RequestOptions().placeholder(i);
    }
}