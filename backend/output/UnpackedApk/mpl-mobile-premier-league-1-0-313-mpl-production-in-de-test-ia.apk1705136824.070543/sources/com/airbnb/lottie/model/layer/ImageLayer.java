package com.airbnb.lottie.model.layer;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable.Callback;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.manager.ImageAssetManager;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.io.IOException;

public class ImageLayer extends BaseLayer {
    public BaseKeyframeAnimation<ColorFilter, ColorFilter> colorFilterAnimation;
    public final Rect dst = new Rect();
    public final Paint paint = new LPaint(3);
    public final Rect src = new Rect();

    public ImageLayer(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
    }

    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        this.transform.applyValueCallback(t, lottieValueCallback);
        if (t != LottieProperty.COLOR_FILTER) {
            return;
        }
        if (lottieValueCallback == null) {
            this.colorFilterAnimation = null;
        } else {
            this.colorFilterAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
        }
    }

    public void drawLayer(Canvas canvas, Matrix matrix, int i) {
        Bitmap bitmap = getBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            float dpScale = Utils.dpScale();
            this.paint.setAlpha(i);
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.colorFilterAnimation;
            if (baseKeyframeAnimation != null) {
                this.paint.setColorFilter((ColorFilter) baseKeyframeAnimation.getValue());
            }
            canvas.save();
            canvas.concat(matrix);
            this.src.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            this.dst.set(0, 0, (int) (((float) bitmap.getWidth()) * dpScale), (int) (((float) bitmap.getHeight()) * dpScale));
            canvas.drawBitmap(bitmap, this.src, this.dst, this.paint);
            canvas.restore();
        }
    }

    public final Bitmap getBitmap() {
        ImageAssetManager imageAssetManager;
        String str = this.layerModel.refId;
        LottieDrawable lottieDrawable = this.lottieDrawable;
        if (lottieDrawable.getCallback() == null) {
            imageAssetManager = null;
        } else {
            ImageAssetManager imageAssetManager2 = lottieDrawable.imageAssetManager;
            if (imageAssetManager2 != null) {
                Callback callback = lottieDrawable.getCallback();
                Object context = (callback != null && (callback instanceof View)) ? ((View) callback).getContext() : null;
                if (!((context == null && imageAssetManager2.context == null) || imageAssetManager2.context.equals(context))) {
                    lottieDrawable.imageAssetManager = null;
                }
            }
            if (lottieDrawable.imageAssetManager == null) {
                lottieDrawable.imageAssetManager = new ImageAssetManager(lottieDrawable.getCallback(), lottieDrawable.imageAssetsFolder, lottieDrawable.imageAssetDelegate, lottieDrawable.composition.images);
            }
            imageAssetManager = lottieDrawable.imageAssetManager;
        }
        if (imageAssetManager == null) {
            return null;
        }
        LottieImageAsset lottieImageAsset = imageAssetManager.imageAssets.get(str);
        if (lottieImageAsset == null) {
            return null;
        }
        Bitmap bitmap = lottieImageAsset.bitmap;
        if (bitmap != null) {
            return bitmap;
        }
        ImageAssetDelegate imageAssetDelegate = imageAssetManager.delegate;
        if (imageAssetDelegate != null) {
            Bitmap fetchBitmap = imageAssetDelegate.fetchBitmap(lottieImageAsset);
            if (fetchBitmap == null) {
                return fetchBitmap;
            }
            imageAssetManager.putBitmap(str, fetchBitmap);
            return fetchBitmap;
        }
        String str2 = lottieImageAsset.fileName;
        Options options = new Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (!str2.startsWith("data:") || str2.indexOf("base64,") <= 0) {
            try {
                if (!TextUtils.isEmpty(imageAssetManager.imagesFolder)) {
                    try {
                        Bitmap resizeBitmapIfNeeded = Utils.resizeBitmapIfNeeded(BitmapFactory.decodeStream(imageAssetManager.context.getAssets().open(imageAssetManager.imagesFolder + str2), null, options), lottieImageAsset.width, lottieImageAsset.height);
                        imageAssetManager.putBitmap(str, resizeBitmapIfNeeded);
                        return resizeBitmapIfNeeded;
                    } catch (IllegalArgumentException e2) {
                        Logger.warning("Unable to decode image.", e2);
                        return null;
                    }
                } else {
                    throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
                }
            } catch (IOException e3) {
                Logger.warning("Unable to open asset.", e3);
                return null;
            }
        } else {
            try {
                byte[] decode = Base64.decode(str2.substring(str2.indexOf(44) + 1), 0);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length, options);
                imageAssetManager.putBitmap(str, decodeByteArray);
                return decodeByteArray;
            } catch (IllegalArgumentException e4) {
                Logger.warning("data URL did not have correct base64 format.", e4);
                return null;
            }
        }
    }

    public void getBounds(RectF rectF, Matrix matrix, boolean z) {
        super.getBounds(rectF, matrix, z);
        Bitmap bitmap = getBitmap();
        if (bitmap != null) {
            rectF.set(0.0f, 0.0f, Utils.dpScale() * ((float) bitmap.getWidth()), Utils.dpScale() * ((float) bitmap.getHeight()));
            this.boundsMatrix.mapRect(rectF);
        }
    }
}
