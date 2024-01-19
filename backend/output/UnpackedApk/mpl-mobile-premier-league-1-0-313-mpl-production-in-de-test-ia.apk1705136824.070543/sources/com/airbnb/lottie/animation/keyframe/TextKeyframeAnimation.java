package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class TextKeyframeAnimation extends KeyframeAnimation<DocumentData> {
    public TextKeyframeAnimation(List<Keyframe<DocumentData>> list) {
        super(list);
    }

    public Object getValue(Keyframe keyframe, float f2) {
        if (f2 == 1.0f) {
            T t = keyframe.endValue;
            if (t != null) {
                return (DocumentData) t;
            }
        }
        return (DocumentData) keyframe.startValue;
    }
}
