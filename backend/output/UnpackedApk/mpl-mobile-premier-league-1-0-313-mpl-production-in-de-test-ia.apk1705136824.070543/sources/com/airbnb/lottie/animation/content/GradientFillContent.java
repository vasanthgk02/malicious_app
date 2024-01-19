package com.airbnb.lottie.animation.content;

import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.model.content.GradientFill;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

public class GradientFillContent implements DrawingContent, AnimationListener, KeyPathElementContent {
    public final RectF boundsRect = new RectF();
    public final int cacheSteps;
    public final BaseKeyframeAnimation<GradientColor, GradientColor> colorAnimation;
    public ValueCallbackKeyframeAnimation colorCallbackAnimation;
    public BaseKeyframeAnimation<ColorFilter, ColorFilter> colorFilterAnimation;
    public final BaseKeyframeAnimation<PointF, PointF> endPointAnimation;
    public final boolean hidden;
    public final BaseLayer layer;
    public final LongSparseArray<LinearGradient> linearGradientCache = new LongSparseArray<>(10);
    public final LottieDrawable lottieDrawable;
    public final String name;
    public final BaseKeyframeAnimation<Integer, Integer> opacityAnimation;
    public final Paint paint = new LPaint(1);
    public final Path path = new Path();
    public final List<PathContent> paths = new ArrayList();
    public final LongSparseArray<RadialGradient> radialGradientCache = new LongSparseArray<>(10);
    public final BaseKeyframeAnimation<PointF, PointF> startPointAnimation;
    public final GradientType type;

    public GradientFillContent(LottieDrawable lottieDrawable2, BaseLayer baseLayer, GradientFill gradientFill) {
        this.layer = baseLayer;
        this.name = gradientFill.name;
        this.hidden = gradientFill.hidden;
        this.lottieDrawable = lottieDrawable2;
        this.type = gradientFill.gradientType;
        this.path.setFillType(gradientFill.fillType);
        this.cacheSteps = (int) (lottieDrawable2.composition.getDuration() / 32.0f);
        BaseKeyframeAnimation<GradientColor, GradientColor> createAnimation = gradientFill.gradientColor.createAnimation();
        this.colorAnimation = createAnimation;
        createAnimation.listeners.add(this);
        baseLayer.addAnimation(this.colorAnimation);
        BaseKeyframeAnimation<Integer, Integer> createAnimation2 = gradientFill.opacity.createAnimation();
        this.opacityAnimation = createAnimation2;
        createAnimation2.listeners.add(this);
        baseLayer.addAnimation(this.opacityAnimation);
        BaseKeyframeAnimation<PointF, PointF> createAnimation3 = gradientFill.startPoint.createAnimation();
        this.startPointAnimation = createAnimation3;
        createAnimation3.listeners.add(this);
        baseLayer.addAnimation(this.startPointAnimation);
        BaseKeyframeAnimation<PointF, PointF> createAnimation4 = gradientFill.endPoint.createAnimation();
        this.endPointAnimation = createAnimation4;
        createAnimation4.listeners.add(this);
        baseLayer.addAnimation(this.endPointAnimation);
    }

    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        if (t == LottieProperty.OPACITY) {
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
        } else if (t == LottieProperty.GRADIENT_COLOR) {
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = this.colorCallbackAnimation;
            if (valueCallbackKeyframeAnimation2 != null) {
                this.layer.animations.remove(valueCallbackKeyframeAnimation2);
            }
            if (lottieValueCallback == null) {
                this.colorCallbackAnimation = null;
                return;
            }
            this.linearGradientCache.clear();
            this.radialGradientCache.clear();
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation3 = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.colorCallbackAnimation = valueCallbackKeyframeAnimation3;
            valueCallbackKeyframeAnimation3.listeners.add(this);
            this.layer.addAnimation(this.colorCallbackAnimation);
        }
    }

    public final int[] applyDynamicColorsIfNeeded(int[] iArr) {
        ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = this.colorCallbackAnimation;
        if (valueCallbackKeyframeAnimation != null) {
            Integer[] numArr = (Integer[]) valueCallbackKeyframeAnimation.getValue();
            int i = 0;
            if (iArr.length == numArr.length) {
                while (i < iArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i < numArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            }
        }
        return iArr;
    }

    /* JADX WARNING: type inference failed for: r3v4, types: [android.graphics.Shader] */
    /* JADX WARNING: type inference failed for: r3v11, types: [android.graphics.RadialGradient] */
    /* JADX WARNING: type inference failed for: r9v0, types: [android.graphics.RadialGradient] */
    /* JADX WARNING: type inference failed for: r3v24, types: [android.graphics.LinearGradient] */
    /* JADX WARNING: type inference failed for: r9v1, types: [android.graphics.LinearGradient] */
    /* JADX WARNING: type inference failed for: r3v29 */
    /* JADX WARNING: type inference failed for: r9v2, types: [android.graphics.RadialGradient] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r3v11, types: [android.graphics.RadialGradient]
      assigns: [android.graphics.RadialGradient, android.graphics.LinearGradient, ?[OBJECT, ARRAY]]
      uses: [?[int, boolean, OBJECT, ARRAY, byte, short, char], android.graphics.Shader, android.graphics.RadialGradient]
      mth insns count: 118
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void draw(android.graphics.Canvas r18, android.graphics.Matrix r19, int r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r19
            boolean r2 = r0.hidden
            if (r2 == 0) goto L_0x0009
            return
        L_0x0009:
            android.graphics.Path r2 = r0.path
            r2.reset()
            r2 = 0
            r3 = 0
        L_0x0010:
            java.util.List<com.airbnb.lottie.animation.content.PathContent> r4 = r0.paths
            int r4 = r4.size()
            if (r3 >= r4) goto L_0x002c
            android.graphics.Path r4 = r0.path
            java.util.List<com.airbnb.lottie.animation.content.PathContent> r5 = r0.paths
            java.lang.Object r5 = r5.get(r3)
            com.airbnb.lottie.animation.content.PathContent r5 = (com.airbnb.lottie.animation.content.PathContent) r5
            android.graphics.Path r5 = r5.getPath()
            r4.addPath(r5, r1)
            int r3 = r3 + 1
            goto L_0x0010
        L_0x002c:
            android.graphics.Path r3 = r0.path
            android.graphics.RectF r4 = r0.boundsRect
            r3.computeBounds(r4, r2)
            com.airbnb.lottie.model.content.GradientType r3 = r0.type
            com.airbnb.lottie.model.content.GradientType r4 = com.airbnb.lottie.model.content.GradientType.LINEAR
            if (r3 != r4) goto L_0x0081
            int r3 = r17.getGradientHash()
            androidx.collection.LongSparseArray<android.graphics.LinearGradient> r4 = r0.linearGradientCache
            long r5 = (long) r3
            java.lang.Object r3 = r4.get(r5)
            android.graphics.LinearGradient r3 = (android.graphics.LinearGradient) r3
            if (r3 == 0) goto L_0x004a
            goto L_0x00dc
        L_0x004a:
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<android.graphics.PointF, android.graphics.PointF> r3 = r0.startPointAnimation
            java.lang.Object r3 = r3.getValue()
            android.graphics.PointF r3 = (android.graphics.PointF) r3
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<android.graphics.PointF, android.graphics.PointF> r4 = r0.endPointAnimation
            java.lang.Object r4 = r4.getValue()
            android.graphics.PointF r4 = (android.graphics.PointF) r4
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<com.airbnb.lottie.model.content.GradientColor, com.airbnb.lottie.model.content.GradientColor> r7 = r0.colorAnimation
            java.lang.Object r7 = r7.getValue()
            com.airbnb.lottie.model.content.GradientColor r7 = (com.airbnb.lottie.model.content.GradientColor) r7
            int[] r8 = r7.colors
            int[] r14 = r0.applyDynamicColorsIfNeeded(r8)
            float[] r15 = r7.positions
            android.graphics.LinearGradient r7 = new android.graphics.LinearGradient
            float r10 = r3.x
            float r11 = r3.y
            float r12 = r4.x
            float r13 = r4.y
            android.graphics.Shader$TileMode r16 = android.graphics.Shader.TileMode.CLAMP
            r9 = r7
            r9.<init>(r10, r11, r12, r13, r14, r15, r16)
            androidx.collection.LongSparseArray<android.graphics.LinearGradient> r3 = r0.linearGradientCache
            r3.put(r5, r7)
            r3 = r7
            goto L_0x00dc
        L_0x0081:
            int r3 = r17.getGradientHash()
            androidx.collection.LongSparseArray<android.graphics.RadialGradient> r4 = r0.radialGradientCache
            long r5 = (long) r3
            java.lang.Object r3 = r4.get(r5)
            android.graphics.RadialGradient r3 = (android.graphics.RadialGradient) r3
            if (r3 == 0) goto L_0x0091
            goto L_0x00dc
        L_0x0091:
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<android.graphics.PointF, android.graphics.PointF> r3 = r0.startPointAnimation
            java.lang.Object r3 = r3.getValue()
            android.graphics.PointF r3 = (android.graphics.PointF) r3
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<android.graphics.PointF, android.graphics.PointF> r4 = r0.endPointAnimation
            java.lang.Object r4 = r4.getValue()
            android.graphics.PointF r4 = (android.graphics.PointF) r4
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<com.airbnb.lottie.model.content.GradientColor, com.airbnb.lottie.model.content.GradientColor> r7 = r0.colorAnimation
            java.lang.Object r7 = r7.getValue()
            com.airbnb.lottie.model.content.GradientColor r7 = (com.airbnb.lottie.model.content.GradientColor) r7
            int[] r8 = r7.colors
            int[] r13 = r0.applyDynamicColorsIfNeeded(r8)
            float[] r14 = r7.positions
            float r10 = r3.x
            float r11 = r3.y
            float r3 = r4.x
            float r4 = r4.y
            float r3 = r3 - r10
            double r7 = (double) r3
            float r4 = r4 - r11
            double r3 = (double) r4
            double r3 = java.lang.Math.hypot(r7, r3)
            float r3 = (float) r3
            r4 = 0
            int r4 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r4 > 0) goto L_0x00ce
            r3 = 981668463(0x3a83126f, float:0.001)
            r12 = 981668463(0x3a83126f, float:0.001)
            goto L_0x00cf
        L_0x00ce:
            r12 = r3
        L_0x00cf:
            android.graphics.RadialGradient r3 = new android.graphics.RadialGradient
            android.graphics.Shader$TileMode r15 = android.graphics.Shader.TileMode.CLAMP
            r9 = r3
            r9.<init>(r10, r11, r12, r13, r14, r15)
            androidx.collection.LongSparseArray<android.graphics.RadialGradient> r4 = r0.radialGradientCache
            r4.put(r5, r3)
        L_0x00dc:
            r3.setLocalMatrix(r1)
            android.graphics.Paint r1 = r0.paint
            r1.setShader(r3)
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<android.graphics.ColorFilter, android.graphics.ColorFilter> r1 = r0.colorFilterAnimation
            if (r1 == 0) goto L_0x00f3
            android.graphics.Paint r3 = r0.paint
            java.lang.Object r1 = r1.getValue()
            android.graphics.ColorFilter r1 = (android.graphics.ColorFilter) r1
            r3.setColorFilter(r1)
        L_0x00f3:
            r1 = r20
            float r1 = (float) r1
            r3 = 1132396544(0x437f0000, float:255.0)
            float r1 = r1 / r3
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Integer, java.lang.Integer> r4 = r0.opacityAnimation
            java.lang.Object r4 = r4.getValue()
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            float r4 = (float) r4
            float r1 = r1 * r4
            r4 = 1120403456(0x42c80000, float:100.0)
            float r1 = r1 / r4
            float r1 = r1 * r3
            int r1 = (int) r1
            android.graphics.Paint r3 = r0.paint
            r4 = 255(0xff, float:3.57E-43)
            int r1 = com.airbnb.lottie.utils.MiscUtils.clamp(r1, r2, r4)
            r3.setAlpha(r1)
            android.graphics.Path r1 = r0.path
            android.graphics.Paint r2 = r0.paint
            r3 = r18
            r3.drawPath(r1, r2)
            java.lang.String r1 = "GradientFillContent#draw"
            com.airbnb.lottie.L.endSection(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.animation.content.GradientFillContent.draw(android.graphics.Canvas, android.graphics.Matrix, int):void");
    }

    public void getBounds(RectF rectF, Matrix matrix, boolean z) {
        this.path.reset();
        for (int i = 0; i < this.paths.size(); i++) {
            this.path.addPath(this.paths.get(i).getPath(), matrix);
        }
        this.path.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    public final int getGradientHash() {
        int round = Math.round(this.startPointAnimation.progress * ((float) this.cacheSteps));
        int round2 = Math.round(this.endPointAnimation.progress * ((float) this.cacheSteps));
        int round3 = Math.round(this.colorAnimation.progress * ((float) this.cacheSteps));
        int i = 17;
        if (round != 0) {
            i = 527 * round;
        }
        if (round2 != 0) {
            i = i * 31 * round2;
        }
        return round3 != 0 ? i * 31 * round3 : i;
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
