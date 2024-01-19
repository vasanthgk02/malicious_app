package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.Collections;

public class SplitDimensionPathKeyframeAnimation extends BaseKeyframeAnimation<PointF, PointF> {
    public final PointF point = new PointF();
    public final PointF pointWithCallbackValues = new PointF();
    public final BaseKeyframeAnimation<Float, Float> xAnimation;
    public LottieValueCallback<Float> xValueCallback;
    public final BaseKeyframeAnimation<Float, Float> yAnimation;
    public LottieValueCallback<Float> yValueCallback;

    public SplitDimensionPathKeyframeAnimation(BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation, BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2) {
        super(Collections.emptyList());
        this.xAnimation = baseKeyframeAnimation;
        this.yAnimation = baseKeyframeAnimation2;
        setProgress(this.progress);
    }

    public /* bridge */ /* synthetic */ Object getValue(Keyframe keyframe, float f2) {
        return getValue(f2);
    }

    public void setProgress(float f2) {
        this.xAnimation.setProgress(f2);
        this.yAnimation.setProgress(f2);
        this.point.set(((Float) this.xAnimation.getValue()).floatValue(), ((Float) this.yAnimation.getValue()).floatValue());
        for (int i = 0; i < this.listeners.size(); i++) {
            this.listeners.get(i).onValueChanged();
        }
    }

    public Object getValue() {
        return getValue(0.0f);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0082  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.PointF getValue(float r12) {
        /*
            r11 = this;
            com.airbnb.lottie.value.LottieValueCallback<java.lang.Float> r0 = r11.xValueCallback
            r1 = 0
            if (r0 == 0) goto L_0x002f
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> r0 = r11.xAnimation
            com.airbnb.lottie.value.Keyframe r0 = r0.getCurrentKeyframe()
            if (r0 == 0) goto L_0x002f
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> r2 = r11.xAnimation
            float r10 = r2.getInterpolatedCurrentKeyframeProgress()
            java.lang.Float r2 = r0.endFrame
            com.airbnb.lottie.value.LottieValueCallback<java.lang.Float> r3 = r11.xValueCallback
            float r4 = r0.startFrame
            if (r2 != 0) goto L_0x001d
            r5 = r4
            goto L_0x0022
        L_0x001d:
            float r2 = r2.floatValue()
            r5 = r2
        L_0x0022:
            T r6 = r0.startValue
            T r7 = r0.endValue
            r8 = r12
            r9 = r12
            java.lang.Object r0 = r3.getValueInternal(r4, r5, r6, r7, r8, r9, r10)
            java.lang.Float r0 = (java.lang.Float) r0
            goto L_0x0030
        L_0x002f:
            r0 = r1
        L_0x0030:
            com.airbnb.lottie.value.LottieValueCallback<java.lang.Float> r2 = r11.yValueCallback
            if (r2 == 0) goto L_0x005e
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> r2 = r11.yAnimation
            com.airbnb.lottie.value.Keyframe r2 = r2.getCurrentKeyframe()
            if (r2 == 0) goto L_0x005e
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> r1 = r11.yAnimation
            float r10 = r1.getInterpolatedCurrentKeyframeProgress()
            java.lang.Float r1 = r2.endFrame
            com.airbnb.lottie.value.LottieValueCallback<java.lang.Float> r3 = r11.yValueCallback
            float r4 = r2.startFrame
            if (r1 != 0) goto L_0x004c
            r5 = r4
            goto L_0x0051
        L_0x004c:
            float r1 = r1.floatValue()
            r5 = r1
        L_0x0051:
            T r6 = r2.startValue
            T r7 = r2.endValue
            r8 = r12
            r9 = r12
            java.lang.Object r12 = r3.getValueInternal(r4, r5, r6, r7, r8, r9, r10)
            r1 = r12
            java.lang.Float r1 = (java.lang.Float) r1
        L_0x005e:
            r12 = 0
            if (r0 != 0) goto L_0x006b
            android.graphics.PointF r0 = r11.pointWithCallbackValues
            android.graphics.PointF r2 = r11.point
            float r2 = r2.x
            r0.set(r2, r12)
            goto L_0x0074
        L_0x006b:
            android.graphics.PointF r2 = r11.pointWithCallbackValues
            float r0 = r0.floatValue()
            r2.set(r0, r12)
        L_0x0074:
            if (r1 != 0) goto L_0x0082
            android.graphics.PointF r12 = r11.pointWithCallbackValues
            float r0 = r12.x
            android.graphics.PointF r1 = r11.point
            float r1 = r1.y
            r12.set(r0, r1)
            goto L_0x008d
        L_0x0082:
            android.graphics.PointF r12 = r11.pointWithCallbackValues
            float r0 = r12.x
            float r1 = r1.floatValue()
            r12.set(r0, r1)
        L_0x008d:
            android.graphics.PointF r12 = r11.pointWithCallbackValues
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.animation.keyframe.SplitDimensionPathKeyframeAnimation.getValue(float):android.graphics.PointF");
    }
}
