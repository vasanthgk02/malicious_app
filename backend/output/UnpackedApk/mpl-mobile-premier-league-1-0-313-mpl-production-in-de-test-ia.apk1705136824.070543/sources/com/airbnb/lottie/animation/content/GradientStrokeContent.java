package com.airbnb.lottie.animation.content;

import android.graphics.LinearGradient;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.model.content.GradientStroke;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.value.LottieValueCallback;

public class GradientStrokeContent extends BaseStrokeContent {
    public final RectF boundsRect = new RectF();
    public final int cacheSteps;
    public final BaseKeyframeAnimation<GradientColor, GradientColor> colorAnimation;
    public ValueCallbackKeyframeAnimation colorCallbackAnimation;
    public final BaseKeyframeAnimation<PointF, PointF> endPointAnimation;
    public final boolean hidden;
    public final LongSparseArray<LinearGradient> linearGradientCache = new LongSparseArray<>(10);
    public final String name;
    public final LongSparseArray<RadialGradient> radialGradientCache = new LongSparseArray<>(10);
    public final BaseKeyframeAnimation<PointF, PointF> startPointAnimation;
    public final GradientType type;

    public GradientStrokeContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, GradientStroke gradientStroke) {
        super(lottieDrawable, baseLayer, gradientStroke.capType.toPaintCap(), gradientStroke.joinType.toPaintJoin(), gradientStroke.miterLimit, gradientStroke.opacity, gradientStroke.width, gradientStroke.lineDashPattern, gradientStroke.dashOffset);
        this.name = gradientStroke.name;
        this.type = gradientStroke.gradientType;
        this.hidden = gradientStroke.hidden;
        this.cacheSteps = (int) (lottieDrawable.composition.getDuration() / 32.0f);
        BaseKeyframeAnimation<GradientColor, GradientColor> createAnimation = gradientStroke.gradientColor.createAnimation();
        this.colorAnimation = createAnimation;
        createAnimation.listeners.add(this);
        baseLayer.addAnimation(this.colorAnimation);
        BaseKeyframeAnimation<PointF, PointF> createAnimation2 = gradientStroke.startPoint.createAnimation();
        this.startPointAnimation = createAnimation2;
        createAnimation2.listeners.add(this);
        baseLayer.addAnimation(this.startPointAnimation);
        BaseKeyframeAnimation<PointF, PointF> createAnimation3 = gradientStroke.endPoint.createAnimation();
        this.endPointAnimation = createAnimation3;
        createAnimation3.listeners.add(this);
        baseLayer.addAnimation(this.endPointAnimation);
    }

    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        super.addValueCallback(t, lottieValueCallback);
        if (t == LottieProperty.GRADIENT_COLOR) {
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = this.colorCallbackAnimation;
            if (valueCallbackKeyframeAnimation != null) {
                this.layer.animations.remove(valueCallbackKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.colorCallbackAnimation = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.colorCallbackAnimation = valueCallbackKeyframeAnimation2;
            valueCallbackKeyframeAnimation2.listeners.add(this);
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

    /* JADX WARNING: type inference failed for: r2v3, types: [android.graphics.Shader] */
    /* JADX WARNING: type inference failed for: r2v6, types: [android.graphics.RadialGradient] */
    /* JADX WARNING: type inference failed for: r8v0, types: [android.graphics.RadialGradient] */
    /* JADX WARNING: type inference failed for: r2v17, types: [android.graphics.LinearGradient] */
    /* JADX WARNING: type inference failed for: r8v1, types: [android.graphics.LinearGradient] */
    /* JADX WARNING: type inference failed for: r8v2, types: [android.graphics.RadialGradient] */
    /* JADX WARNING: type inference failed for: r8v3, types: [android.graphics.LinearGradient] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r2v6, types: [android.graphics.RadialGradient]
      assigns: [android.graphics.RadialGradient, android.graphics.LinearGradient]
      uses: [?[int, boolean, OBJECT, ARRAY, byte, short, char], android.graphics.Shader, android.graphics.RadialGradient, android.graphics.LinearGradient]
      mth insns count: 75
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void draw(android.graphics.Canvas r17, android.graphics.Matrix r18, int r19) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r0.hidden
            if (r2 == 0) goto L_0x0009
            return
        L_0x0009:
            android.graphics.RectF r2 = r0.boundsRect
            r3 = 0
            r0.getBounds(r2, r1, r3)
            com.airbnb.lottie.model.content.GradientType r2 = r0.type
            com.airbnb.lottie.model.content.GradientType r3 = com.airbnb.lottie.model.content.GradientType.LINEAR
            if (r2 != r3) goto L_0x005c
            int r2 = r16.getGradientHash()
            androidx.collection.LongSparseArray<android.graphics.LinearGradient> r3 = r0.linearGradientCache
            long r4 = (long) r2
            java.lang.Object r2 = r3.get(r4)
            android.graphics.LinearGradient r2 = (android.graphics.LinearGradient) r2
            if (r2 == 0) goto L_0x0026
            goto L_0x00aa
        L_0x0026:
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<android.graphics.PointF, android.graphics.PointF> r2 = r0.startPointAnimation
            java.lang.Object r2 = r2.getValue()
            android.graphics.PointF r2 = (android.graphics.PointF) r2
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<android.graphics.PointF, android.graphics.PointF> r3 = r0.endPointAnimation
            java.lang.Object r3 = r3.getValue()
            android.graphics.PointF r3 = (android.graphics.PointF) r3
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<com.airbnb.lottie.model.content.GradientColor, com.airbnb.lottie.model.content.GradientColor> r6 = r0.colorAnimation
            java.lang.Object r6 = r6.getValue()
            com.airbnb.lottie.model.content.GradientColor r6 = (com.airbnb.lottie.model.content.GradientColor) r6
            int[] r7 = r6.colors
            int[] r13 = r0.applyDynamicColorsIfNeeded(r7)
            float[] r14 = r6.positions
            float r9 = r2.x
            float r10 = r2.y
            float r11 = r3.x
            float r12 = r3.y
            android.graphics.LinearGradient r2 = new android.graphics.LinearGradient
            android.graphics.Shader$TileMode r15 = android.graphics.Shader.TileMode.CLAMP
            r8 = r2
            r8.<init>(r9, r10, r11, r12, r13, r14, r15)
            androidx.collection.LongSparseArray<android.graphics.LinearGradient> r3 = r0.linearGradientCache
            r3.put(r4, r2)
            goto L_0x00aa
        L_0x005c:
            int r2 = r16.getGradientHash()
            androidx.collection.LongSparseArray<android.graphics.RadialGradient> r3 = r0.radialGradientCache
            long r4 = (long) r2
            java.lang.Object r2 = r3.get(r4)
            android.graphics.RadialGradient r2 = (android.graphics.RadialGradient) r2
            if (r2 == 0) goto L_0x006c
            goto L_0x00aa
        L_0x006c:
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<android.graphics.PointF, android.graphics.PointF> r2 = r0.startPointAnimation
            java.lang.Object r2 = r2.getValue()
            android.graphics.PointF r2 = (android.graphics.PointF) r2
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<android.graphics.PointF, android.graphics.PointF> r3 = r0.endPointAnimation
            java.lang.Object r3 = r3.getValue()
            android.graphics.PointF r3 = (android.graphics.PointF) r3
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<com.airbnb.lottie.model.content.GradientColor, com.airbnb.lottie.model.content.GradientColor> r6 = r0.colorAnimation
            java.lang.Object r6 = r6.getValue()
            com.airbnb.lottie.model.content.GradientColor r6 = (com.airbnb.lottie.model.content.GradientColor) r6
            int[] r7 = r6.colors
            int[] r12 = r0.applyDynamicColorsIfNeeded(r7)
            float[] r13 = r6.positions
            float r9 = r2.x
            float r10 = r2.y
            float r2 = r3.x
            float r3 = r3.y
            float r2 = r2 - r9
            double r6 = (double) r2
            float r3 = r3 - r10
            double r2 = (double) r3
            double r2 = java.lang.Math.hypot(r6, r2)
            float r11 = (float) r2
            android.graphics.RadialGradient r2 = new android.graphics.RadialGradient
            android.graphics.Shader$TileMode r14 = android.graphics.Shader.TileMode.CLAMP
            r8 = r2
            r8.<init>(r9, r10, r11, r12, r13, r14)
            androidx.collection.LongSparseArray<android.graphics.RadialGradient> r3 = r0.radialGradientCache
            r3.put(r4, r2)
        L_0x00aa:
            r2.setLocalMatrix(r1)
            android.graphics.Paint r3 = r0.paint
            r3.setShader(r2)
            super.draw(r17, r18, r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.animation.content.GradientStrokeContent.draw(android.graphics.Canvas, android.graphics.Matrix, int):void");
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
}
