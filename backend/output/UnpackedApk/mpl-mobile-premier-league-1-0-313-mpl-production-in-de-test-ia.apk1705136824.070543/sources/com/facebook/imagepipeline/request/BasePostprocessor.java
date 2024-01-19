package com.facebook.imagepipeline.request;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.core.NativeCodeSetup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class BasePostprocessor implements Postprocessor {
    public static final Config FALLBACK_BITMAP_CONFIGURATION = Config.ARGB_8888;
    public static Method sCopyBitmap;

    public static void internalCopyBitmap(Bitmap bitmap, Bitmap bitmap2) {
        if (!NativeCodeSetup.getUseNativeCode() || bitmap.getConfig() != bitmap2.getConfig()) {
            new Canvas(bitmap).drawBitmap(bitmap2, 0.0f, 0.0f, null);
            return;
        }
        try {
            if (sCopyBitmap == null) {
                sCopyBitmap = Class.forName("com.facebook.imagepipeline.nativecode.Bitmaps").getDeclaredMethod("copyBitmap", new Class[]{Bitmap.class, Bitmap.class});
            }
            sCopyBitmap.invoke(null, new Object[]{bitmap, bitmap2});
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException("Wrong Native code setup, reflection failed.", e2);
        } catch (IllegalAccessException e3) {
            throw new RuntimeException("Wrong Native code setup, reflection failed.", e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException("Wrong Native code setup, reflection failed.", e4);
        } catch (InvocationTargetException e5) {
            throw new RuntimeException("Wrong Native code setup, reflection failed.", e5);
        }
    }

    public String getName() {
        return "Unknown postprocessor";
    }

    public CacheKey getPostprocessorCacheKey() {
        return null;
    }

    public CloseableReference<Bitmap> process(Bitmap bitmap, PlatformBitmapFactory platformBitmapFactory) {
        Config config = bitmap.getConfig();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (config == null) {
            config = FALLBACK_BITMAP_CONFIGURATION;
        }
        CloseableReference<Bitmap> createBitmapInternal = platformBitmapFactory.createBitmapInternal(width, height, config);
        try {
            process((Bitmap) createBitmapInternal.get(), bitmap);
            return CloseableReference.cloneOrNull(createBitmapInternal);
        } finally {
            CloseableReference.closeSafely(createBitmapInternal);
        }
    }

    public void process(Bitmap bitmap) {
    }

    public void process(Bitmap bitmap, Bitmap bitmap2) {
        internalCopyBitmap(bitmap, bitmap2);
        process(bitmap);
    }
}
