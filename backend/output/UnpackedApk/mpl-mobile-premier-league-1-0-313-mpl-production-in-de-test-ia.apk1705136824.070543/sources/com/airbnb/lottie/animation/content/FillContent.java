package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener;
import com.airbnb.lottie.animation.keyframe.ColorKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.ShapeFill;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;
import sfs2x.client.entities.invitation.InvitationReply;

public class FillContent implements DrawingContent, AnimationListener, KeyPathElementContent {
    public final BaseKeyframeAnimation<Integer, Integer> colorAnimation;
    public BaseKeyframeAnimation<ColorFilter, ColorFilter> colorFilterAnimation;
    public final boolean hidden;
    public final BaseLayer layer;
    public final LottieDrawable lottieDrawable;
    public final String name;
    public final BaseKeyframeAnimation<Integer, Integer> opacityAnimation;
    public final Paint paint = new LPaint(1);
    public final Path path = new Path();
    public final List<PathContent> paths = new ArrayList();

    public FillContent(LottieDrawable lottieDrawable2, BaseLayer baseLayer, ShapeFill shapeFill) {
        this.layer = baseLayer;
        this.name = shapeFill.name;
        this.hidden = shapeFill.hidden;
        this.lottieDrawable = lottieDrawable2;
        if (shapeFill.color == null || shapeFill.opacity == null) {
            this.colorAnimation = null;
            this.opacityAnimation = null;
            return;
        }
        this.path.setFillType(shapeFill.fillType);
        BaseKeyframeAnimation<Integer, Integer> createAnimation = shapeFill.color.createAnimation();
        this.colorAnimation = createAnimation;
        createAnimation.listeners.add(this);
        baseLayer.addAnimation(this.colorAnimation);
        BaseKeyframeAnimation<Integer, Integer> createAnimation2 = shapeFill.opacity.createAnimation();
        this.opacityAnimation = createAnimation2;
        createAnimation2.listeners.add(this);
        baseLayer.addAnimation(this.opacityAnimation);
    }

    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        if (t == LottieProperty.COLOR) {
            this.colorAnimation.setValueCallback(lottieValueCallback);
        } else if (t == LottieProperty.OPACITY) {
            this.opacityAnimation.setValueCallback(lottieValueCallback);
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
        if (!this.hidden) {
            Paint paint2 = this.paint;
            ColorKeyframeAnimation colorKeyframeAnimation = (ColorKeyframeAnimation) this.colorAnimation;
            paint2.setColor(colorKeyframeAnimation.getIntValue(colorKeyframeAnimation.getCurrentKeyframe(), colorKeyframeAnimation.getInterpolatedCurrentKeyframeProgress()));
            this.paint.setAlpha(MiscUtils.clamp((int) ((((((float) i) / 255.0f) * ((float) ((Integer) this.opacityAnimation.getValue()).intValue())) / 100.0f) * 255.0f), 0, (int) InvitationReply.EXPIRED));
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.colorFilterAnimation;
            if (baseKeyframeAnimation != null) {
                this.paint.setColorFilter((ColorFilter) baseKeyframeAnimation.getValue());
            }
            this.path.reset();
            for (int i2 = 0; i2 < this.paths.size(); i2++) {
                this.path.addPath(this.paths.get(i2).getPath(), matrix);
            }
            canvas.drawPath(this.path, this.paint);
            L.endSection("FillContent#draw");
        }
    }

    public void getBounds(RectF rectF, Matrix matrix, boolean z) {
        this.path.reset();
        for (int i = 0; i < this.paths.size(); i++) {
            this.path.addPath(this.paths.get(i).getPath(), matrix);
        }
        this.path.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    public String getName() {
        return this.name;
    }

    public void onValueChanged() {
        this.lottieDrawable.invalidateSelf();
    }

    public void resolveKeyPath(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.resolveKeyPath(keyPath, i, list, keyPath2, this);
    }

    public void setContents(List<Content> list, List<Content> list2) {
        for (int i = 0; i < list2.size(); i++) {
            Content content = list2.get(i);
            if (content instanceof PathContent) {
                this.paths.add((PathContent) content);
            }
        }
    }
}
