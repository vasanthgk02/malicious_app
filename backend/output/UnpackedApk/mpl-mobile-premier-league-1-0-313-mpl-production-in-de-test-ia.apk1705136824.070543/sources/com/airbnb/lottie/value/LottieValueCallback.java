package com.airbnb.lottie.value;

public class LottieValueCallback<T> {
    public final LottieFrameInfo<T> frameInfo = new LottieFrameInfo<>();
    public T value = null;

    public LottieValueCallback(T t) {
        this.value = t;
    }

    public final T getValueInternal(float f2, float f3, T t, T t2, float f4, float f5, float f6) {
        LottieFrameInfo<T> lottieFrameInfo = this.frameInfo;
        lottieFrameInfo.startValue = t;
        lottieFrameInfo.endValue = t2;
        return this.value;
    }
}
