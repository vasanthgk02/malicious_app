package com.airbnb.lottie.animation.keyframe;

import android.view.animation.Interpolator;
import com.airbnb.lottie.L;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseKeyframeAnimation<K, A> {
    public float cachedEndProgress = -1.0f;
    public A cachedGetValue = null;
    public float cachedStartDelayProgress = -1.0f;
    public boolean isDiscrete = false;
    public final KeyframesWrapper<K> keyframesWrapper;
    public final List<AnimationListener> listeners = new ArrayList(1);
    public float progress = 0.0f;
    public LottieValueCallback<A> valueCallback;

    public interface AnimationListener {
        void onValueChanged();
    }

    public static final class EmptyKeyframeWrapper<T> implements KeyframesWrapper<T> {
        public EmptyKeyframeWrapper(AnonymousClass1 r1) {
        }

        public Keyframe<T> getCurrentKeyframe() {
            throw new IllegalStateException("not implemented");
        }

        public float getEndProgress() {
            return 1.0f;
        }

        public float getStartDelayProgress() {
            return 0.0f;
        }

        public boolean isCachedValueEnabled(float f2) {
            throw new IllegalStateException("not implemented");
        }

        public boolean isEmpty() {
            return true;
        }

        public boolean isValueChanged(float f2) {
            return false;
        }
    }

    public interface KeyframesWrapper<T> {
        Keyframe<T> getCurrentKeyframe();

        float getEndProgress();

        float getStartDelayProgress();

        boolean isCachedValueEnabled(float f2);

        boolean isEmpty();

        boolean isValueChanged(float f2);
    }

    public static final class KeyframesWrapperImpl<T> implements KeyframesWrapper<T> {
        public Keyframe<T> cachedCurrentKeyframe = null;
        public float cachedInterpolatedProgress = -1.0f;
        public Keyframe<T> currentKeyframe;
        public final List<? extends Keyframe<T>> keyframes;

        public KeyframesWrapperImpl(List<? extends Keyframe<T>> list) {
            this.keyframes = list;
            this.currentKeyframe = findKeyframe(0.0f);
        }

        public final Keyframe<T> findKeyframe(float f2) {
            Keyframe<T> keyframe = (Keyframe) GeneratedOutlineSupport.outline30(this.keyframes, 1);
            if (f2 >= keyframe.getStartProgress()) {
                return keyframe;
            }
            for (int size = this.keyframes.size() - 2; size >= 1; size--) {
                Keyframe<T> keyframe2 = (Keyframe) this.keyframes.get(size);
                if (this.currentKeyframe != keyframe2 && keyframe2.containsProgress(f2)) {
                    return keyframe2;
                }
            }
            return (Keyframe) this.keyframes.get(0);
        }

        public Keyframe<T> getCurrentKeyframe() {
            return this.currentKeyframe;
        }

        public float getEndProgress() {
            return ((Keyframe) GeneratedOutlineSupport.outline29(this.keyframes, -1)).getEndProgress();
        }

        public float getStartDelayProgress() {
            return ((Keyframe) this.keyframes.get(0)).getStartProgress();
        }

        public boolean isCachedValueEnabled(float f2) {
            if (this.cachedCurrentKeyframe == this.currentKeyframe && this.cachedInterpolatedProgress == f2) {
                return true;
            }
            this.cachedCurrentKeyframe = this.currentKeyframe;
            this.cachedInterpolatedProgress = f2;
            return false;
        }

        public boolean isEmpty() {
            return false;
        }

        public boolean isValueChanged(float f2) {
            if (this.currentKeyframe.containsProgress(f2)) {
                return !this.currentKeyframe.isStatic();
            }
            this.currentKeyframe = findKeyframe(f2);
            return true;
        }
    }

    public static final class SingleKeyframeWrapper<T> implements KeyframesWrapper<T> {
        public float cachedInterpolatedProgress = -1.0f;
        public final Keyframe<T> keyframe;

        public SingleKeyframeWrapper(List<? extends Keyframe<T>> list) {
            this.keyframe = (Keyframe) list.get(0);
        }

        public Keyframe<T> getCurrentKeyframe() {
            return this.keyframe;
        }

        public float getEndProgress() {
            return this.keyframe.getEndProgress();
        }

        public float getStartDelayProgress() {
            return this.keyframe.getStartProgress();
        }

        public boolean isCachedValueEnabled(float f2) {
            if (this.cachedInterpolatedProgress == f2) {
                return true;
            }
            this.cachedInterpolatedProgress = f2;
            return false;
        }

        public boolean isEmpty() {
            return false;
        }

        public boolean isValueChanged(float f2) {
            return !this.keyframe.isStatic();
        }
    }

    public BaseKeyframeAnimation(List<? extends Keyframe<K>> list) {
        KeyframesWrapper<K> keyframesWrapper2;
        KeyframesWrapper<K> keyframesWrapper3;
        if (list.isEmpty()) {
            keyframesWrapper2 = new EmptyKeyframeWrapper<>(null);
        } else {
            if (list.size() == 1) {
                keyframesWrapper3 = new SingleKeyframeWrapper<>(list);
            } else {
                keyframesWrapper3 = new KeyframesWrapperImpl<>(list);
            }
            keyframesWrapper2 = keyframesWrapper3;
        }
        this.keyframesWrapper = keyframesWrapper2;
    }

    public Keyframe<K> getCurrentKeyframe() {
        Keyframe<K> currentKeyframe = this.keyframesWrapper.getCurrentKeyframe();
        L.endSection("BaseKeyframeAnimation#getCurrentKeyframe");
        return currentKeyframe;
    }

    public float getEndProgress() {
        if (this.cachedEndProgress == -1.0f) {
            this.cachedEndProgress = this.keyframesWrapper.getEndProgress();
        }
        return this.cachedEndProgress;
    }

    public float getInterpolatedCurrentKeyframeProgress() {
        Keyframe currentKeyframe = getCurrentKeyframe();
        if (currentKeyframe.isStatic()) {
            return 0.0f;
        }
        return currentKeyframe.interpolator.getInterpolation(getLinearCurrentKeyframeProgress());
    }

    public float getLinearCurrentKeyframeProgress() {
        if (this.isDiscrete) {
            return 0.0f;
        }
        Keyframe currentKeyframe = getCurrentKeyframe();
        if (currentKeyframe.isStatic()) {
            return 0.0f;
        }
        return (this.progress - currentKeyframe.getStartProgress()) / (currentKeyframe.getEndProgress() - currentKeyframe.getStartProgress());
    }

    public A getValue() {
        A a2;
        float linearCurrentKeyframeProgress = getLinearCurrentKeyframeProgress();
        if (this.valueCallback == null && this.keyframesWrapper.isCachedValueEnabled(linearCurrentKeyframeProgress)) {
            return this.cachedGetValue;
        }
        Keyframe currentKeyframe = getCurrentKeyframe();
        Interpolator interpolator = currentKeyframe.xInterpolator;
        if (interpolator == null || currentKeyframe.yInterpolator == null) {
            a2 = getValue(currentKeyframe, getInterpolatedCurrentKeyframeProgress());
        } else {
            a2 = getValue(currentKeyframe, linearCurrentKeyframeProgress, interpolator.getInterpolation(linearCurrentKeyframeProgress), currentKeyframe.yInterpolator.getInterpolation(linearCurrentKeyframeProgress));
        }
        this.cachedGetValue = a2;
        return a2;
    }

    public abstract A getValue(Keyframe<K> keyframe, float f2);

    public void notifyListeners() {
        for (int i = 0; i < this.listeners.size(); i++) {
            this.listeners.get(i).onValueChanged();
        }
    }

    public void setProgress(float f2) {
        if (!this.keyframesWrapper.isEmpty()) {
            if (this.cachedStartDelayProgress == -1.0f) {
                this.cachedStartDelayProgress = this.keyframesWrapper.getStartDelayProgress();
            }
            float f3 = this.cachedStartDelayProgress;
            if (f2 < f3) {
                if (f3 == -1.0f) {
                    this.cachedStartDelayProgress = this.keyframesWrapper.getStartDelayProgress();
                }
                f2 = this.cachedStartDelayProgress;
            } else if (f2 > getEndProgress()) {
                f2 = getEndProgress();
            }
            if (f2 != this.progress) {
                this.progress = f2;
                if (this.keyframesWrapper.isValueChanged(f2)) {
                    notifyListeners();
                }
            }
        }
    }

    public void setValueCallback(LottieValueCallback<A> lottieValueCallback) {
        LottieValueCallback<A> lottieValueCallback2 = this.valueCallback;
        if (lottieValueCallback2 == null || lottieValueCallback2 != null) {
            this.valueCallback = lottieValueCallback;
            return;
        }
        throw null;
    }

    public A getValue(Keyframe<K> keyframe, float f2, float f3, float f4) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }
}
