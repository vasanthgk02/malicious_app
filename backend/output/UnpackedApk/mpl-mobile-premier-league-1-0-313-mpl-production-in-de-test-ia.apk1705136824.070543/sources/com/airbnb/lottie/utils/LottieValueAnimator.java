package com.airbnb.lottie.utils;

import android.animation.Animator.AnimatorListener;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;

public class LottieValueAnimator extends BaseLottieAnimator implements FrameCallback {
    public LottieComposition composition;
    public float frame = 0.0f;
    public long lastFrameTimeNs = 0;
    public float maxFrame = 2.1474836E9f;
    public float minFrame = -2.1474836E9f;
    public int repeatCount = 0;
    public boolean running = false;
    public float speed = 1.0f;
    public boolean speedReversedForRepeatMode = false;

    public void cancel() {
        for (AnimatorListener onAnimationCancel : this.listeners) {
            onAnimationCancel.onAnimationCancel(this);
        }
        removeFrameCallback();
    }

    public void doFrame(long j) {
        float f2;
        postFrameCallback();
        if (this.composition != null && this.running) {
            long j2 = this.lastFrameTimeNs;
            long j3 = 0;
            if (j2 != 0) {
                j3 = j - j2;
            }
            LottieComposition lottieComposition = this.composition;
            if (lottieComposition == null) {
                f2 = Float.MAX_VALUE;
            } else {
                f2 = (1.0E9f / lottieComposition.frameRate) / Math.abs(this.speed);
            }
            float f3 = ((float) j3) / f2;
            float f4 = this.frame;
            if (isReversed()) {
                f3 = -f3;
            }
            float f5 = f4 + f3;
            this.frame = f5;
            boolean z = !MiscUtils.contains(f5, getMinFrame(), getMaxFrame());
            this.frame = MiscUtils.clamp(this.frame, getMinFrame(), getMaxFrame());
            this.lastFrameTimeNs = j;
            notifyUpdate();
            if (z) {
                if (getRepeatCount() == -1 || this.repeatCount < getRepeatCount()) {
                    for (AnimatorListener onAnimationRepeat : this.listeners) {
                        onAnimationRepeat.onAnimationRepeat(this);
                    }
                    this.repeatCount++;
                    if (getRepeatMode() == 2) {
                        this.speedReversedForRepeatMode = !this.speedReversedForRepeatMode;
                        reverseAnimationSpeed();
                    } else {
                        this.frame = isReversed() ? getMaxFrame() : getMinFrame();
                    }
                    this.lastFrameTimeNs = j;
                } else {
                    this.frame = this.speed < 0.0f ? getMinFrame() : getMaxFrame();
                    removeFrameCallback();
                    notifyEnd(isReversed());
                }
            }
            if (this.composition != null) {
                float f6 = this.frame;
                if (f6 < this.minFrame || f6 > this.maxFrame) {
                    throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", new Object[]{Float.valueOf(this.minFrame), Float.valueOf(this.maxFrame), Float.valueOf(this.frame)}));
                }
            }
            L.endSection("LottieValueAnimator#doFrame");
        }
    }

    public void endAnimation() {
        removeFrameCallback();
        notifyEnd(isReversed());
    }

    public float getAnimatedFraction() {
        float minFrame2;
        float maxFrame2;
        float minFrame3;
        if (this.composition == null) {
            return 0.0f;
        }
        if (isReversed()) {
            minFrame2 = getMaxFrame() - this.frame;
            maxFrame2 = getMaxFrame();
            minFrame3 = getMinFrame();
        } else {
            minFrame2 = this.frame - getMinFrame();
            maxFrame2 = getMaxFrame();
            minFrame3 = getMinFrame();
        }
        return minFrame2 / (maxFrame2 - minFrame3);
    }

    public Object getAnimatedValue() {
        return Float.valueOf(getAnimatedValueAbsolute());
    }

    public float getAnimatedValueAbsolute() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return 0.0f;
        }
        float f2 = this.frame;
        float f3 = lottieComposition.startFrame;
        return (f2 - f3) / (lottieComposition.endFrame - f3);
    }

    public long getDuration() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return 0;
        }
        return (long) lottieComposition.getDuration();
    }

    public float getMaxFrame() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return 0.0f;
        }
        float f2 = this.maxFrame;
        if (f2 == 2.1474836E9f) {
            f2 = lottieComposition.endFrame;
        }
        return f2;
    }

    public float getMinFrame() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return 0.0f;
        }
        float f2 = this.minFrame;
        if (f2 == -2.1474836E9f) {
            f2 = lottieComposition.startFrame;
        }
        return f2;
    }

    public final boolean isReversed() {
        return this.speed < 0.0f;
    }

    public boolean isRunning() {
        return this.running;
    }

    public void postFrameCallback() {
        if (this.running) {
            Choreographer.getInstance().removeFrameCallback(this);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    public void removeFrameCallback() {
        Choreographer.getInstance().removeFrameCallback(this);
        this.running = false;
    }

    public void reverseAnimationSpeed() {
        this.speed = -this.speed;
    }

    public void setFrame(float f2) {
        if (this.frame != f2) {
            this.frame = MiscUtils.clamp(f2, getMinFrame(), getMaxFrame());
            this.lastFrameTimeNs = 0;
            notifyUpdate();
        }
    }

    public void setMinAndMaxFrames(float f2, float f3) {
        float f4;
        float f5;
        if (f2 <= f3) {
            LottieComposition lottieComposition = this.composition;
            if (lottieComposition == null) {
                f4 = -3.4028235E38f;
            } else {
                f4 = lottieComposition.startFrame;
            }
            LottieComposition lottieComposition2 = this.composition;
            if (lottieComposition2 == null) {
                f5 = Float.MAX_VALUE;
            } else {
                f5 = lottieComposition2.endFrame;
            }
            this.minFrame = MiscUtils.clamp(f2, f4, f5);
            this.maxFrame = MiscUtils.clamp(f3, f4, f5);
            setFrame((float) ((int) MiscUtils.clamp(this.frame, f2, f3)));
            return;
        }
        throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", new Object[]{Float.valueOf(f2), Float.valueOf(f3)}));
    }

    public void setRepeatMode(int i) {
        super.setRepeatMode(i);
        if (i != 2 && this.speedReversedForRepeatMode) {
            this.speedReversedForRepeatMode = false;
            reverseAnimationSpeed();
        }
    }
}
