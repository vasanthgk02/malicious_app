package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.ScaleXY;
import java.util.List;

public class ScaleKeyframeAnimation extends KeyframeAnimation<ScaleXY> {
    public final ScaleXY scaleXY = new ScaleXY();

    public ScaleKeyframeAnimation(List<Keyframe<ScaleXY>> list) {
        super(list);
    }

    public Object getValue(Keyframe keyframe, float f2) {
        T t = keyframe.startValue;
        if (t != null) {
            T t2 = keyframe.endValue;
            if (t2 != null) {
                ScaleXY scaleXY2 = (ScaleXY) t;
                ScaleXY scaleXY3 = (ScaleXY) t2;
                LottieValueCallback<A> lottieValueCallback = this.valueCallback;
                if (lottieValueCallback != null) {
                    ScaleXY scaleXY4 = (ScaleXY) lottieValueCallback.getValueInternal(keyframe.startFrame, keyframe.endFrame.floatValue(), scaleXY2, scaleXY3, f2, getLinearCurrentKeyframeProgress(), this.progress);
                    if (scaleXY4 != null) {
                        return scaleXY4;
                    }
                }
                ScaleXY scaleXY5 = this.scaleXY;
                float lerp = MiscUtils.lerp(scaleXY2.scaleX, scaleXY3.scaleX, f2);
                float lerp2 = MiscUtils.lerp(scaleXY2.scaleY, scaleXY3.scaleY, f2);
                scaleXY5.scaleX = lerp;
                scaleXY5.scaleY = lerp2;
                return this.scaleXY;
            }
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
