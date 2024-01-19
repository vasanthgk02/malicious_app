package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import java.util.Arrays;

public final class LinearIndeterminateContiguousAnimatorDelegate extends IndeterminateAnimatorDelegate<ObjectAnimator> {
    public static final Property<LinearIndeterminateContiguousAnimatorDelegate, Float> ANIMATION_FRACTION = new Property<LinearIndeterminateContiguousAnimatorDelegate, Float>(Float.class, "animationFraction") {
        public Object get(Object obj) {
            return Float.valueOf(((LinearIndeterminateContiguousAnimatorDelegate) obj).animationFraction);
        }

        public void set(Object obj, Object obj2) {
            LinearIndeterminateContiguousAnimatorDelegate linearIndeterminateContiguousAnimatorDelegate = (LinearIndeterminateContiguousAnimatorDelegate) obj;
            float floatValue = ((Float) obj2).floatValue();
            linearIndeterminateContiguousAnimatorDelegate.animationFraction = floatValue;
            linearIndeterminateContiguousAnimatorDelegate.segmentPositions[0] = 0.0f;
            float fractionInRange = linearIndeterminateContiguousAnimatorDelegate.getFractionInRange((int) (floatValue * 333.0f), 0, 667);
            float[] fArr = linearIndeterminateContiguousAnimatorDelegate.segmentPositions;
            float interpolation = linearIndeterminateContiguousAnimatorDelegate.interpolator.getInterpolation(fractionInRange);
            fArr[2] = interpolation;
            fArr[1] = interpolation;
            float[] fArr2 = linearIndeterminateContiguousAnimatorDelegate.segmentPositions;
            float interpolation2 = linearIndeterminateContiguousAnimatorDelegate.interpolator.getInterpolation(fractionInRange + 0.49925038f);
            fArr2[4] = interpolation2;
            fArr2[3] = interpolation2;
            float[] fArr3 = linearIndeterminateContiguousAnimatorDelegate.segmentPositions;
            fArr3[5] = 1.0f;
            if (linearIndeterminateContiguousAnimatorDelegate.dirtyColors && fArr3[3] < 1.0f) {
                int[] iArr = linearIndeterminateContiguousAnimatorDelegate.segmentColors;
                iArr[2] = iArr[1];
                iArr[1] = iArr[0];
                iArr[0] = ImageOriginUtils.compositeARGBWithAlpha(linearIndeterminateContiguousAnimatorDelegate.baseSpec.indicatorColors[linearIndeterminateContiguousAnimatorDelegate.newIndicatorColorIndex], linearIndeterminateContiguousAnimatorDelegate.drawable.totalAlpha);
                linearIndeterminateContiguousAnimatorDelegate.dirtyColors = false;
            }
            linearIndeterminateContiguousAnimatorDelegate.drawable.invalidateSelf();
        }
    };
    public float animationFraction;
    public ObjectAnimator animator;
    public final BaseProgressIndicatorSpec baseSpec;
    public boolean dirtyColors;
    public FastOutSlowInInterpolator interpolator;
    public int newIndicatorColorIndex = 1;

    public LinearIndeterminateContiguousAnimatorDelegate(LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(3);
        this.baseSpec = linearProgressIndicatorSpec;
        this.interpolator = new FastOutSlowInInterpolator();
    }

    public void cancelAnimatorImmediately() {
        ObjectAnimator objectAnimator = this.animator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    public void invalidateSpecValues() {
        resetPropertiesForNewStart();
    }

    public void registerAnimatorsCompleteCallback(Animatable2Compat$AnimationCallback animatable2Compat$AnimationCallback) {
    }

    public void requestCancelAnimatorAfterCurrentCycle() {
    }

    public void resetPropertiesForNewStart() {
        this.dirtyColors = true;
        this.newIndicatorColorIndex = 1;
        Arrays.fill(this.segmentColors, ImageOriginUtils.compositeARGBWithAlpha(this.baseSpec.indicatorColors[0], this.drawable.totalAlpha));
    }

    public void startAnimator() {
        if (this.animator == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, ANIMATION_FRACTION, new float[]{0.0f, 1.0f});
            this.animator = ofFloat;
            ofFloat.setDuration(333);
            this.animator.setInterpolator(null);
            this.animator.setRepeatCount(-1);
            this.animator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationRepeat(Animator animator) {
                    super.onAnimationRepeat(animator);
                    LinearIndeterminateContiguousAnimatorDelegate linearIndeterminateContiguousAnimatorDelegate = LinearIndeterminateContiguousAnimatorDelegate.this;
                    linearIndeterminateContiguousAnimatorDelegate.newIndicatorColorIndex = (linearIndeterminateContiguousAnimatorDelegate.newIndicatorColorIndex + 1) % linearIndeterminateContiguousAnimatorDelegate.baseSpec.indicatorColors.length;
                    linearIndeterminateContiguousAnimatorDelegate.dirtyColors = true;
                }
            });
        }
        resetPropertiesForNewStart();
        this.animator.start();
    }

    public void unregisterAnimatorsCompleteCallback() {
    }
}
