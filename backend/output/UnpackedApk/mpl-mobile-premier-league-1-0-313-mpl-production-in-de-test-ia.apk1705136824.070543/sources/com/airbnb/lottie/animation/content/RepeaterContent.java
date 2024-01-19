package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.Repeater;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class RepeaterContent implements DrawingContent, PathContent, GreedyContent, AnimationListener, KeyPathElementContent {
    public ContentGroup contentGroup;
    public final BaseKeyframeAnimation<Float, Float> copies;
    public final boolean hidden;
    public final BaseLayer layer;
    public final LottieDrawable lottieDrawable;
    public final Matrix matrix = new Matrix();
    public final String name;
    public final BaseKeyframeAnimation<Float, Float> offset;
    public final Path path = new Path();
    public final TransformKeyframeAnimation transform;

    public RepeaterContent(LottieDrawable lottieDrawable2, BaseLayer baseLayer, Repeater repeater) {
        this.lottieDrawable = lottieDrawable2;
        this.layer = baseLayer;
        this.name = repeater.name;
        this.hidden = repeater.hidden;
        BaseKeyframeAnimation<Float, Float> createAnimation = repeater.copies.createAnimation();
        this.copies = createAnimation;
        baseLayer.addAnimation(createAnimation);
        this.copies.listeners.add(this);
        BaseKeyframeAnimation<Float, Float> createAnimation2 = repeater.offset.createAnimation();
        this.offset = createAnimation2;
        baseLayer.addAnimation(createAnimation2);
        this.offset.listeners.add(this);
        AnimatableTransform animatableTransform = repeater.transform;
        if (animatableTransform != null) {
            TransformKeyframeAnimation transformKeyframeAnimation = new TransformKeyframeAnimation(animatableTransform);
            this.transform = transformKeyframeAnimation;
            transformKeyframeAnimation.addAnimationsToLayer(baseLayer);
            this.transform.addListener(this);
            return;
        }
        throw null;
    }

    public void absorbContent(ListIterator<Content> listIterator) {
        if (this.contentGroup == null) {
            while (listIterator.hasPrevious()) {
                if (listIterator.previous() == this) {
                    break;
                }
            }
            ArrayList arrayList = new ArrayList();
            while (listIterator.hasPrevious()) {
                arrayList.add(listIterator.previous());
                listIterator.remove();
            }
            Collections.reverse(arrayList);
            ContentGroup contentGroup2 = new ContentGroup(this.lottieDrawable, this.layer, "Repeater", this.hidden, arrayList, null);
            this.contentGroup = contentGroup2;
        }
    }

    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        if (!this.transform.applyValueCallback(t, lottieValueCallback)) {
            if (t == LottieProperty.REPEATER_COPIES) {
                this.copies.setValueCallback(lottieValueCallback);
            } else if (t == LottieProperty.REPEATER_OFFSET) {
                this.offset.setValueCallback(lottieValueCallback);
            }
        }
    }

    public void draw(Canvas canvas, Matrix matrix2, int i) {
        float floatValue = ((Float) this.copies.getValue()).floatValue();
        float floatValue2 = ((Float) this.offset.getValue()).floatValue();
        float floatValue3 = ((Float) this.transform.startOpacity.getValue()).floatValue() / 100.0f;
        float floatValue4 = ((Float) this.transform.endOpacity.getValue()).floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.matrix.set(matrix2);
            float f2 = (float) i2;
            this.matrix.preConcat(this.transform.getMatrixForRepeater(f2 + floatValue2));
            this.contentGroup.draw(canvas, this.matrix, (int) (MiscUtils.lerp(floatValue3, floatValue4, f2 / floatValue) * ((float) i)));
        }
    }

    public void getBounds(RectF rectF, Matrix matrix2, boolean z) {
        this.contentGroup.getBounds(rectF, matrix2, z);
    }

    public String getName() {
        return this.name;
    }

    public Path getPath() {
        Path path2 = this.contentGroup.getPath();
        this.path.reset();
        float floatValue = ((Float) this.copies.getValue()).floatValue();
        float floatValue2 = ((Float) this.offset.getValue()).floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.matrix.set(this.transform.getMatrixForRepeater(((float) i) + floatValue2));
            this.path.addPath(path2, this.matrix);
        }
        return this.path;
    }

    public void onValueChanged() {
        this.lottieDrawable.invalidateSelf();
    }

    public void resolveKeyPath(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.resolveKeyPath(keyPath, i, list, keyPath2, this);
    }

    public void setContents(List<Content> list, List<Content> list2) {
        this.contentGroup.setContents(list, list2);
    }
}
