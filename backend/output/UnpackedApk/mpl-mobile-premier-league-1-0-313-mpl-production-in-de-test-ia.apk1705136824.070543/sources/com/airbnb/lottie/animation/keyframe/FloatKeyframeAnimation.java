package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class FloatKeyframeAnimation extends KeyframeAnimation<Float> {
    public FloatKeyframeAnimation(List<Keyframe<Float>> list) {
        super(list);
    }

    public float getFloatValue(Keyframe<Float> keyframe, float f2) {
        if (keyframe.startValue == null || keyframe.endValue == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        LottieValueCallback<A> lottieValueCallback = this.valueCallback;
        if (lottieValueCallback != null) {
            Float f3 = (Float) lottieValueCallback.getValueInternal(keyframe.startFrame, keyframe.endFrame.floatValue(), keyframe.startValue, keyframe.endValue, f2, getLinearCurrentKeyframeProgress(), this.progress);
            if (f3 != null) {
                return f3.floatValue();
            }
        }
        if (keyframe.startValueFloat == -3987645.8f) {
            keyframe.startValueFloat = ((Float) keyframe.startValue).floatValue();
        }
        float f4 = keyframe.startValueFloat;
        if (keyframe.endValueFloat == -3987645.8f) {
            keyframe.endValueFloat = ((Float) keyframe.endValue).floatValue();
        }
        return MiscUtils.lerp(f4, keyframe.endValueFloat, f2);
    }

    public Object getValue(Keyframe keyframe, float f2) {
        return Float.valueOf(getFloatValue(keyframe, f2));
    }

    public float getFloatValue() {
        return getFloatValue(getCurrentKeyframe(), getInterpolatedCurrentKeyframeProgress());
    }
}
