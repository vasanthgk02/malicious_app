package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ColorKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.value.LottieValueCallback;

public class StrokeContent extends BaseStrokeContent {
    public final BaseKeyframeAnimation<Integer, Integer> colorAnimation;
    public BaseKeyframeAnimation<ColorFilter, ColorFilter> colorFilterAnimation;
    public final boolean hidden;
    public final BaseLayer layer;
    public final String name;

    public StrokeContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, ShapeStroke shapeStroke) {
        super(lottieDrawable, baseLayer, shapeStroke.capType.toPaintCap(), shapeStroke.joinType.toPaintJoin(), shapeStroke.miterLimit, shapeStroke.opacity, shapeStroke.width, shapeStroke.lineDashPattern, shapeStroke.offset);
        this.layer = baseLayer;
        this.name = shapeStroke.name;
        this.hidden = shapeStroke.hidden;
        BaseKeyframeAnimation<Integer, Integer> createAnimation = shapeStroke.color.createAnimation();
        this.colorAnimation = createAnimation;
        createAnimation.listeners.add(this);
        baseLayer.addAnimation(this.colorAnimation);
    }

    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        super.addValueCallback(t, lottieValueCallback);
        if (t == LottieProperty.STROKE_COLOR) {
            this.colorAnimation.setValueCallback(lottieValueCallback);
        } else if (t == LottieProperty.COLOR_FILTER) {
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.colorFilterAnimation;
            if (baseKeyframeAnimation != null) {
                this.layer.animations.remove(baseKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.colorFilterAnimation = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.colorFilterAnimation = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.listeners.add(this);
            this.layer.addAnimation(this.colorAnimation);
        }
    }

    public void draw(Canvas canvas, Matrix matrix, int i) {
        if (!this.hidden) {
            Paint paint = this.paint;
            ColorKeyframeAnimation colorKeyframeAnimation = (ColorKeyframeAnimation) this.colorAnimation;
            paint.setColor(colorKeyframeAnimation.getIntValue(colorKeyframeAnimation.getCurrentKeyframe(), colorKeyframeAnimation.getInterpolatedCurrentKeyframeProgress()));
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.colorFilterAnimation;
            if (baseKeyframeAnimation != null) {
                this.paint.setColorFilter((ColorFilter) baseKeyframeAnimation.getValue());
            }
            super.draw(canvas, matrix, i);
        }
    }

    public String getName() {
        return this.name;
    }
}
