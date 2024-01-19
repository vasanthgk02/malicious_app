package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.Collections;

public class ValueCallbackKeyframeAnimation<K, A> extends BaseKeyframeAnimation<K, A> {
    public final A valueCallbackValue;

    public ValueCallbackKeyframeAnimation(LottieValueCallback<A> lottieValueCallback, A a2) {
        super(Collections.emptyList());
        setValueCallback(lottieValueCallback);
        this.valueCallbackValue = a2;
    }

    public float getEndProgress() {
        return 1.0f;
    }

    public A getValue() {
        LottieValueCallback<A> lottieValueCallback = this.valueCallback;
        A a2 = this.valueCallbackValue;
        float f2 = this.progress;
        return lottieValueCallback.getValueInternal(0.0f, 0.0f, a2, a2, f2, f2, f2);
    }

    public void notifyListeners() {
        if (this.valueCallback != null) {
            super.notifyListeners();
        }
    }

    public void setProgress(float f2) {
        this.progress = f2;
    }

    public A getValue(Keyframe<K> keyframe, float f2) {
        return getValue();
    }
}
