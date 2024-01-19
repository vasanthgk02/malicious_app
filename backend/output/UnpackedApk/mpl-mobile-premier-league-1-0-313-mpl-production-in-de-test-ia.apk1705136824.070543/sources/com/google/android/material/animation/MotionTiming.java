package com.google.android.material.animation;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import com.android.tools.r8.GeneratedOutlineSupport;

public class MotionTiming {
    public long delay = 0;
    public long duration = 300;
    public TimeInterpolator interpolator = null;
    public int repeatCount = 0;
    public int repeatMode = 1;

    public MotionTiming(long j, long j2) {
        this.delay = j;
        this.duration = j2;
    }

    public void apply(Animator animator) {
        animator.setStartDelay(this.delay);
        animator.setDuration(this.duration);
        animator.setInterpolator(getInterpolator());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(this.repeatCount);
            valueAnimator.setRepeatMode(this.repeatMode);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MotionTiming)) {
            return false;
        }
        MotionTiming motionTiming = (MotionTiming) obj;
        if (this.delay == motionTiming.delay && this.duration == motionTiming.duration && this.repeatCount == motionTiming.repeatCount && this.repeatMode == motionTiming.repeatMode) {
            return getInterpolator().getClass().equals(motionTiming.getInterpolator().getClass());
        }
        return false;
    }

    public TimeInterpolator getInterpolator() {
        TimeInterpolator timeInterpolator = this.interpolator;
        return timeInterpolator != null ? timeInterpolator : AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
    }

    public int hashCode() {
        long j = this.delay;
        long j2 = this.duration;
        return ((((getInterpolator().getClass().hashCode() + (((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31)) * 31) + this.repeatCount) * 31) + this.repeatMode;
    }

    public String toString() {
        StringBuilder outline72 = GeneratedOutlineSupport.outline72(10);
        outline72.append(MotionTiming.class.getName());
        outline72.append('{');
        outline72.append(Integer.toHexString(System.identityHashCode(this)));
        outline72.append(" delay: ");
        outline72.append(this.delay);
        outline72.append(" duration: ");
        outline72.append(this.duration);
        outline72.append(" interpolator: ");
        outline72.append(getInterpolator().getClass());
        outline72.append(" repeatCount: ");
        outline72.append(this.repeatCount);
        outline72.append(" repeatMode: ");
        return GeneratedOutlineSupport.outline57(outline72, this.repeatMode, "}\n");
    }

    public MotionTiming(long j, long j2, TimeInterpolator timeInterpolator) {
        this.delay = j;
        this.duration = j2;
        this.interpolator = timeInterpolator;
    }
}
