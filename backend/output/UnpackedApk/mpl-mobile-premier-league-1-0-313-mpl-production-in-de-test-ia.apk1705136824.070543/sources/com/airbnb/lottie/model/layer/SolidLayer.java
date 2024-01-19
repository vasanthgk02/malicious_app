package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.value.LottieValueCallback;

public class SolidLayer extends BaseLayer {
    public BaseKeyframeAnimation<ColorFilter, ColorFilter> colorFilterAnimation;
    public final Layer layerModel;
    public final Paint paint = new LPaint();
    public final Path path = new Path();
    public final float[] points = new float[8];
    public final RectF rect = new RectF();

    public SolidLayer(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        this.layerModel = layer;
        this.paint.setAlpha(0);
        this.paint.setStyle(Style.FILL);
        this.paint.setColor(layer.solidColor);
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
        int i2;
        int alpha = Color.alpha(this.layerModel.solidColor);
        if (alpha != 0) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.transform.opacity;
            if (baseKeyframeAnimation == null) {
                i2 = 100;
            } else {
                i2 = ((Integer) baseKeyframeAnimation.getValue()).intValue();
            }
            int i3 = (int) ((((((float) alpha) / 255.0f) * ((float) i2)) / 100.0f) * (((float) i) / 255.0f) * 255.0f);
            this.paint.setAlpha(i3);
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation2 = this.colorFilterAnimation;
            if (baseKeyframeAnimation2 != null) {
                this.paint.setColorFilter((ColorFilter) baseKeyframeAnimation2.getValue());
            }
            if (i3 > 0) {
                float[] fArr = this.points;
                fArr[0] = 0.0f;
                fArr[1] = 0.0f;
                Layer layer = this.layerModel;
                int i4 = layer.solidWidth;
                fArr[2] = (float) i4;
                fArr[3] = 0.0f;
                fArr[4] = (float) i4;
                int i5 = layer.solidHeight;
                fArr[5] = (float) i5;
                fArr[6] = 0.0f;
                fArr[7] = (float) i5;
                matrix.mapPoints(fArr);
                this.path.reset();
                Path path2 = this.path;
                float[] fArr2 = this.points;
                path2.moveTo(fArr2[0], fArr2[1]);
                Path path3 = this.path;
                float[] fArr3 = this.points;
                path3.lineTo(fArr3[2], fArr3[3]);
                Path path4 = this.path;
                float[] fArr4 = this.points;
                path4.lineTo(fArr4[4], fArr4[5]);
                Path path5 = this.path;
                float[] fArr5 = this.points;
                path5.lineTo(fArr5[6], fArr5[7]);
                Path path6 = this.path;
                float[] fArr6 = this.points;
                path6.lineTo(fArr6[0], fArr6[1]);
                this.path.close();
                canvas.drawPath(this.path, this.paint);
            }
        }
    }

    public void getBounds(RectF rectF, Matrix matrix, boolean z) {
        super.getBounds(rectF, matrix, z);
        RectF rectF2 = this.rect;
        Layer layer = this.layerModel;
        rectF2.set(0.0f, 0.0f, (float) layer.solidWidth, (float) layer.solidHeight);
        this.boundsMatrix.mapRect(this.rect);
        rectF.set(this.rect);
    }
}
