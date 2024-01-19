package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.List;

public class PointKeyframeAnimation extends KeyframeAnimation<PointF> {
    public final PointF point = new PointF();

    public PointKeyframeAnimation(List<Keyframe<PointF>> list) {
        super(list);
    }

    public Object getValue(Keyframe keyframe, float f2) {
        return getValue(keyframe, f2, f2, f2);
    }

    public PointF getValue(Keyframe<PointF> keyframe, float f2, float f3, float f4) {
        T t = keyframe.startValue;
        if (t != null) {
            T t2 = keyframe.endValue;
            if (t2 != null) {
                PointF pointF = (PointF) t;
                PointF pointF2 = (PointF) t2;
                LottieValueCallback<A> lottieValueCallback = this.valueCallback;
                if (lottieValueCallback != null) {
                    PointF pointF3 = (PointF) lottieValueCallback.getValueInternal(keyframe.startFrame, keyframe.endFrame.floatValue(), pointF, pointF2, f2, getLinearCurrentKeyframeProgress(), this.progress);
                    if (pointF3 != null) {
                        return pointF3;
                    }
                }
                PointF pointF4 = this.point;
                float f5 = pointF.x;
                float outline3 = GeneratedOutlineSupport.outline3(pointF2.x, f5, f3, f5);
                float f6 = pointF.y;
                pointF4.set(outline3, ((pointF2.y - f6) * f4) + f6);
                return this.point;
            }
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
