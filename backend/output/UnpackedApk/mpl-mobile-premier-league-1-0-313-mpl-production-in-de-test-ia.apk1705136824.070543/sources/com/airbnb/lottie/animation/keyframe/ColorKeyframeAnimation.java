package com.airbnb.lottie.animation.keyframe;

import co.hyperverge.hypersnapsdk.c.k;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class ColorKeyframeAnimation extends KeyframeAnimation<Integer> {
    public ColorKeyframeAnimation(List<Keyframe<Integer>> list) {
        super(list);
    }

    public int getIntValue(Keyframe<Integer> keyframe, float f2) {
        T t = keyframe.startValue;
        if (t == null || keyframe.endValue == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        int intValue = ((Integer) t).intValue();
        int intValue2 = ((Integer) keyframe.endValue).intValue();
        LottieValueCallback<A> lottieValueCallback = this.valueCallback;
        if (lottieValueCallback != null) {
            Integer num = (Integer) lottieValueCallback.getValueInternal(keyframe.startFrame, keyframe.endFrame.floatValue(), Integer.valueOf(intValue), Integer.valueOf(intValue2), f2, getLinearCurrentKeyframeProgress(), this.progress);
            if (num != null) {
                return num.intValue();
            }
        }
        return k.evaluate(MiscUtils.clamp(f2, 0.0f, 1.0f), intValue, intValue2);
    }

    public Object getValue(Keyframe keyframe, float f2) {
        return Integer.valueOf(getIntValue(keyframe, f2));
    }
}
