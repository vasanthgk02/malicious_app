package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class IntegerKeyframeAnimation extends KeyframeAnimation<Integer> {
    public IntegerKeyframeAnimation(List<Keyframe<Integer>> list) {
        super(list);
    }

    public int getIntValue(Keyframe<Integer> keyframe, float f2) {
        if (keyframe.startValue == null || keyframe.endValue == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        LottieValueCallback<A> lottieValueCallback = this.valueCallback;
        if (lottieValueCallback != null) {
            Integer num = (Integer) lottieValueCallback.getValueInternal(keyframe.startFrame, keyframe.endFrame.floatValue(), keyframe.startValue, keyframe.endValue, f2, getLinearCurrentKeyframeProgress(), this.progress);
            if (num != null) {
                return num.intValue();
            }
        }
        if (keyframe.startValueInt == 784923401) {
            keyframe.startValueInt = ((Integer) keyframe.startValue).intValue();
        }
        int i = keyframe.startValueInt;
        if (keyframe.endValueInt == 784923401) {
            keyframe.endValueInt = ((Integer) keyframe.endValue).intValue();
        }
        return MiscUtils.lerp(i, keyframe.endValueInt, f2);
    }

    public Object getValue(Keyframe keyframe, float f2) {
        return Integer.valueOf(getIntValue(keyframe, f2));
    }
}
