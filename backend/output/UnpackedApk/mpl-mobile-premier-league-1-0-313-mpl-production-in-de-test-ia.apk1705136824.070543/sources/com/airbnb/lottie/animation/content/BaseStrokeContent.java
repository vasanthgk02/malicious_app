package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.IntegerKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.ShapeTrimPath.Type;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;
import sfs2x.client.entities.invitation.InvitationReply;

public abstract class BaseStrokeContent implements AnimationListener, KeyPathElementContent, DrawingContent {
    public BaseKeyframeAnimation<ColorFilter, ColorFilter> colorFilterAnimation;
    public final List<BaseKeyframeAnimation<?, Float>> dashPatternAnimations;
    public final BaseKeyframeAnimation<?, Float> dashPatternOffsetAnimation;
    public final float[] dashPatternValues;
    public final BaseLayer layer;
    public final LottieDrawable lottieDrawable;
    public final BaseKeyframeAnimation<?, Integer> opacityAnimation;
    public final Paint paint;
    public final Path path = new Path();
    public final List<PathGroup> pathGroups = new ArrayList();
    public final PathMeasure pm = new PathMeasure();
    public final RectF rect = new RectF();
    public final Path trimPathPath = new Path();
    public final BaseKeyframeAnimation<?, Float> widthAnimation;

    public static final class PathGroup {
        public final List<PathContent> paths = new ArrayList();
        public final TrimPathContent trimPath;

        public PathGroup(TrimPathContent trimPathContent, AnonymousClass1 r2) {
            this.trimPath = trimPathContent;
        }
    }

    public BaseStrokeContent(LottieDrawable lottieDrawable2, BaseLayer baseLayer, Cap cap, Join join, float f2, AnimatableIntegerValue animatableIntegerValue, AnimatableFloatValue animatableFloatValue, List<AnimatableFloatValue> list, AnimatableFloatValue animatableFloatValue2) {
        LPaint lPaint = new LPaint(1);
        this.paint = lPaint;
        this.lottieDrawable = lottieDrawable2;
        this.layer = baseLayer;
        lPaint.setStyle(Style.STROKE);
        this.paint.setStrokeCap(cap);
        this.paint.setStrokeJoin(join);
        this.paint.setStrokeMiter(f2);
        this.opacityAnimation = animatableIntegerValue.createAnimation();
        this.widthAnimation = animatableFloatValue.createAnimation();
        if (animatableFloatValue2 == null) {
            this.dashPatternOffsetAnimation = null;
        } else {
            this.dashPatternOffsetAnimation = animatableFloatValue2.createAnimation();
        }
        this.dashPatternAnimations = new ArrayList(list.size());
        this.dashPatternValues = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.dashPatternAnimations.add(list.get(i).createAnimation());
        }
        baseLayer.addAnimation(this.opacityAnimation);
        baseLayer.addAnimation(this.widthAnimation);
        for (int i2 = 0; i2 < this.dashPatternAnimations.size(); i2++) {
            baseLayer.addAnimation(this.dashPatternAnimations.get(i2));
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.dashPatternOffsetAnimation;
        if (baseKeyframeAnimation != null) {
            baseLayer.addAnimation(baseKeyframeAnimation);
        }
        this.opacityAnimation.listeners.add(this);
        this.widthAnimation.listeners.add(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.dashPatternAnimations.get(i3).listeners.add(this);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.dashPatternOffsetAnimation;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.listeners.add(this);
        }
    }

    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        if (t == LottieProperty.OPACITY) {
            this.opacityAnimation.setValueCallback(lottieValueCallback);
        } else if (t == LottieProperty.STROKE_WIDTH) {
            this.widthAnimation.setValueCallback(lottieValueCallback);
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
            this.layer.addAnimation(this.colorFilterAnimation);
        }
    }

    public void draw(Canvas canvas, Matrix matrix, int i) {
        Canvas canvas2 = canvas;
        Matrix matrix2 = matrix;
        float[] fArr = Utils.threadLocalPoints.get();
        boolean z = false;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 37394.73f;
        fArr[3] = 39575.234f;
        matrix2.mapPoints(fArr);
        if (fArr[0] == fArr[2] || fArr[1] == fArr[3]) {
            L.endSection("StrokeContent#draw");
            return;
        }
        IntegerKeyframeAnimation integerKeyframeAnimation = (IntegerKeyframeAnimation) this.opacityAnimation;
        float intValue = (((float) i) / 255.0f) * ((float) integerKeyframeAnimation.getIntValue(integerKeyframeAnimation.getCurrentKeyframe(), integerKeyframeAnimation.getInterpolatedCurrentKeyframeProgress()));
        float f2 = 100.0f;
        this.paint.setAlpha(MiscUtils.clamp((int) ((intValue / 100.0f) * 255.0f), 0, (int) InvitationReply.EXPIRED));
        this.paint.setStrokeWidth(Utils.getScale(matrix) * ((FloatKeyframeAnimation) this.widthAnimation).getFloatValue());
        if (this.paint.getStrokeWidth() <= 0.0f) {
            L.endSection("StrokeContent#draw");
            return;
        }
        float f3 = 1.0f;
        if (this.dashPatternAnimations.isEmpty()) {
            L.endSection("StrokeContent#applyDashPattern");
        } else {
            float scale = Utils.getScale(matrix);
            for (int i2 = 0; i2 < this.dashPatternAnimations.size(); i2++) {
                this.dashPatternValues[i2] = ((Float) this.dashPatternAnimations.get(i2).getValue()).floatValue();
                if (i2 % 2 == 0) {
                    float[] fArr2 = this.dashPatternValues;
                    if (fArr2[i2] < 1.0f) {
                        fArr2[i2] = 1.0f;
                    }
                } else {
                    float[] fArr3 = this.dashPatternValues;
                    if (fArr3[i2] < 0.1f) {
                        fArr3[i2] = 0.1f;
                    }
                }
                float[] fArr4 = this.dashPatternValues;
                fArr4[i2] = fArr4[i2] * scale;
            }
            BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.dashPatternOffsetAnimation;
            this.paint.setPathEffect(new DashPathEffect(this.dashPatternValues, baseKeyframeAnimation == null ? 0.0f : ((Float) baseKeyframeAnimation.getValue()).floatValue() * scale));
            L.endSection("StrokeContent#applyDashPattern");
        }
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation2 = this.colorFilterAnimation;
        if (baseKeyframeAnimation2 != null) {
            this.paint.setColorFilter((ColorFilter) baseKeyframeAnimation2.getValue());
        }
        int i3 = 0;
        while (i3 < this.pathGroups.size()) {
            PathGroup pathGroup = this.pathGroups.get(i3);
            TrimPathContent trimPathContent = pathGroup.trimPath;
            if (trimPathContent == null) {
                this.path.reset();
                for (int size = pathGroup.paths.size() - 1; size >= 0; size--) {
                    this.path.addPath(pathGroup.paths.get(size).getPath(), matrix2);
                }
                L.endSection("StrokeContent#buildPath");
                canvas2.drawPath(this.path, this.paint);
                L.endSection("StrokeContent#drawPath");
            } else if (trimPathContent == null) {
                L.endSection("StrokeContent#applyTrimPath");
            } else {
                this.path.reset();
                int size2 = pathGroup.paths.size();
                while (true) {
                    size2--;
                    if (size2 < 0) {
                        break;
                    }
                    this.path.addPath(pathGroup.paths.get(size2).getPath(), matrix2);
                }
                this.pm.setPath(this.path, z);
                float length = this.pm.getLength();
                while (this.pm.nextContour()) {
                    length += this.pm.getLength();
                }
                float floatValue = (((Float) pathGroup.trimPath.offsetAnimation.getValue()).floatValue() * length) / 360.0f;
                float floatValue2 = ((((Float) pathGroup.trimPath.startAnimation.getValue()).floatValue() * length) / f2) + floatValue;
                float floatValue3 = ((((Float) pathGroup.trimPath.endAnimation.getValue()).floatValue() * length) / f2) + floatValue;
                int size3 = pathGroup.paths.size() - 1;
                float f4 = 0.0f;
                while (size3 >= 0) {
                    this.trimPathPath.set(pathGroup.paths.get(size3).getPath());
                    this.trimPathPath.transform(matrix2);
                    this.pm.setPath(this.trimPathPath, z);
                    float length2 = this.pm.getLength();
                    if (floatValue3 > length) {
                        float f5 = floatValue3 - length;
                        if (f5 < f4 + length2 && f4 < f5) {
                            Utils.applyTrimPathIfNeeded(this.trimPathPath, floatValue2 > length ? (floatValue2 - length) / length2 : 0.0f, Math.min(f5 / length2, f3), 0.0f);
                            canvas2.drawPath(this.trimPathPath, this.paint);
                            f4 += length2;
                            size3--;
                            z = false;
                            f3 = 1.0f;
                        }
                    }
                    float f6 = f4 + length2;
                    if (f6 >= floatValue2 && f4 <= floatValue3) {
                        if (f6 > floatValue3 || floatValue2 >= f4) {
                            Utils.applyTrimPathIfNeeded(this.trimPathPath, floatValue2 < f4 ? 0.0f : (floatValue2 - f4) / length2, floatValue3 > f6 ? 1.0f : (floatValue3 - f4) / length2, 0.0f);
                            canvas2.drawPath(this.trimPathPath, this.paint);
                        } else {
                            canvas2.drawPath(this.trimPathPath, this.paint);
                        }
                    }
                    f4 += length2;
                    size3--;
                    z = false;
                    f3 = 1.0f;
                }
                L.endSection("StrokeContent#applyTrimPath");
            }
            i3++;
            z = false;
            f2 = 100.0f;
            f3 = 1.0f;
        }
        L.endSection("StrokeContent#draw");
    }

    public void getBounds(RectF rectF, Matrix matrix, boolean z) {
        this.path.reset();
        for (int i = 0; i < this.pathGroups.size(); i++) {
            PathGroup pathGroup = this.pathGroups.get(i);
            for (int i2 = 0; i2 < pathGroup.paths.size(); i2++) {
                this.path.addPath(pathGroup.paths.get(i2).getPath(), matrix);
            }
        }
        this.path.computeBounds(this.rect, false);
        float floatValue = ((FloatKeyframeAnimation) this.widthAnimation).getFloatValue();
        RectF rectF2 = this.rect;
        float f2 = floatValue / 2.0f;
        rectF2.set(rectF2.left - f2, rectF2.top - f2, rectF2.right + f2, rectF2.bottom + f2);
        rectF.set(this.rect);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        L.endSection("StrokeContent#getBounds");
    }

    public void onValueChanged() {
        this.lottieDrawable.invalidateSelf();
    }

    public void resolveKeyPath(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.resolveKeyPath(keyPath, i, list, keyPath2, this);
    }

    public void setContents(List<Content> list, List<Content> list2) {
        TrimPathContent trimPathContent = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            Content content = list.get(size);
            if (content instanceof TrimPathContent) {
                TrimPathContent trimPathContent2 = (TrimPathContent) content;
                if (trimPathContent2.type == Type.INDIVIDUALLY) {
                    trimPathContent = trimPathContent2;
                }
            }
        }
        if (trimPathContent != null) {
            trimPathContent.listeners.add(this);
        }
        PathGroup pathGroup = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            Content content2 = list2.get(size2);
            if (content2 instanceof TrimPathContent) {
                TrimPathContent trimPathContent3 = (TrimPathContent) content2;
                if (trimPathContent3.type == Type.INDIVIDUALLY) {
                    if (pathGroup != null) {
                        this.pathGroups.add(pathGroup);
                    }
                    pathGroup = new PathGroup(trimPathContent3, null);
                    trimPathContent3.listeners.add(this);
                }
            }
            if (content2 instanceof PathContent) {
                if (pathGroup == null) {
                    pathGroup = new PathGroup(trimPathContent, null);
                }
                pathGroup.paths.add((PathContent) content2);
            }
        }
        if (pathGroup != null) {
            this.pathGroups.add(pathGroup);
        }
    }
}
