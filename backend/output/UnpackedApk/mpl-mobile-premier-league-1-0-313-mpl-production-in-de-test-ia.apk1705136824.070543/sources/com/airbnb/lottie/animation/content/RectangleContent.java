package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.RectangleShape;
import com.airbnb.lottie.model.content.ShapeTrimPath.Type;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class RectangleContent implements AnimationListener, KeyPathElementContent, PathContent {
    public final BaseKeyframeAnimation<?, Float> cornerRadiusAnimation;
    public final boolean hidden;
    public boolean isPathValid;
    public final LottieDrawable lottieDrawable;
    public final String name;
    public final Path path = new Path();
    public final BaseKeyframeAnimation<?, PointF> positionAnimation;
    public final RectF rect = new RectF();
    public final BaseKeyframeAnimation<?, PointF> sizeAnimation;
    public CompoundTrimPathContent trimPaths = new CompoundTrimPathContent();

    public RectangleContent(LottieDrawable lottieDrawable2, BaseLayer baseLayer, RectangleShape rectangleShape) {
        this.name = rectangleShape.name;
        this.hidden = rectangleShape.hidden;
        this.lottieDrawable = lottieDrawable2;
        this.positionAnimation = rectangleShape.position.createAnimation();
        this.sizeAnimation = rectangleShape.size.createAnimation();
        this.cornerRadiusAnimation = rectangleShape.cornerRadius.createAnimation();
        baseLayer.addAnimation(this.positionAnimation);
        baseLayer.addAnimation(this.sizeAnimation);
        baseLayer.addAnimation(this.cornerRadiusAnimation);
        this.positionAnimation.listeners.add(this);
        this.sizeAnimation.listeners.add(this);
        this.cornerRadiusAnimation.listeners.add(this);
    }

    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        if (t == LottieProperty.RECTANGLE_SIZE) {
            this.sizeAnimation.setValueCallback(lottieValueCallback);
        } else if (t == LottieProperty.POSITION) {
            this.positionAnimation.setValueCallback(lottieValueCallback);
        } else if (t == LottieProperty.CORNER_RADIUS) {
            this.cornerRadiusAnimation.setValueCallback(lottieValueCallback);
        }
    }

    public String getName() {
        return this.name;
    }

    public Path getPath() {
        float f2;
        if (this.isPathValid) {
            return this.path;
        }
        this.path.reset();
        if (this.hidden) {
            this.isPathValid = true;
            return this.path;
        }
        PointF pointF = (PointF) this.sizeAnimation.getValue();
        float f3 = pointF.x / 2.0f;
        float f4 = pointF.y / 2.0f;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.cornerRadiusAnimation;
        if (baseKeyframeAnimation == null) {
            f2 = 0.0f;
        } else {
            f2 = ((FloatKeyframeAnimation) baseKeyframeAnimation).getFloatValue();
        }
        float min = Math.min(f3, f4);
        if (f2 > min) {
            f2 = min;
        }
        PointF pointF2 = (PointF) this.positionAnimation.getValue();
        this.path.moveTo(pointF2.x + f3, (pointF2.y - f4) + f2);
        this.path.lineTo(pointF2.x + f3, (pointF2.y + f4) - f2);
        int i = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
        if (i > 0) {
            RectF rectF = this.rect;
            float f5 = pointF2.x;
            float f6 = f2 * 2.0f;
            float f7 = pointF2.y;
            rectF.set((f5 + f3) - f6, (f7 + f4) - f6, f5 + f3, f7 + f4);
            this.path.arcTo(this.rect, 0.0f, 90.0f, false);
        }
        this.path.lineTo((pointF2.x - f3) + f2, pointF2.y + f4);
        if (i > 0) {
            RectF rectF2 = this.rect;
            float f8 = pointF2.x;
            float f9 = pointF2.y;
            float f10 = f2 * 2.0f;
            rectF2.set(f8 - f3, (f9 + f4) - f10, (f8 - f3) + f10, f9 + f4);
            this.path.arcTo(this.rect, 90.0f, 90.0f, false);
        }
        this.path.lineTo(pointF2.x - f3, (pointF2.y - f4) + f2);
        if (i > 0) {
            RectF rectF3 = this.rect;
            float f11 = pointF2.x;
            float f12 = pointF2.y;
            float f13 = f2 * 2.0f;
            rectF3.set(f11 - f3, f12 - f4, (f11 - f3) + f13, (f12 - f4) + f13);
            this.path.arcTo(this.rect, 180.0f, 90.0f, false);
        }
        this.path.lineTo((pointF2.x + f3) - f2, pointF2.y - f4);
        if (i > 0) {
            RectF rectF4 = this.rect;
            float f14 = pointF2.x;
            float f15 = f2 * 2.0f;
            float f16 = pointF2.y;
            rectF4.set((f14 + f3) - f15, f16 - f4, f14 + f3, (f16 - f4) + f15);
            this.path.arcTo(this.rect, 270.0f, 90.0f, false);
        }
        this.path.close();
        this.trimPaths.apply(this.path);
        this.isPathValid = true;
        return this.path;
    }

    public void onValueChanged() {
        this.isPathValid = false;
        this.lottieDrawable.invalidateSelf();
    }

    public void resolveKeyPath(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.resolveKeyPath(keyPath, i, list, keyPath2, this);
    }

    public void setContents(List<Content> list, List<Content> list2) {
        for (int i = 0; i < list.size(); i++) {
            Content content = list.get(i);
            if (content instanceof TrimPathContent) {
                TrimPathContent trimPathContent = (TrimPathContent) content;
                if (trimPathContent.type == Type.SIMULTANEOUSLY) {
                    this.trimPaths.contents.add(trimPathContent);
                    trimPathContent.listeners.add(this);
                }
            }
        }
    }
}
