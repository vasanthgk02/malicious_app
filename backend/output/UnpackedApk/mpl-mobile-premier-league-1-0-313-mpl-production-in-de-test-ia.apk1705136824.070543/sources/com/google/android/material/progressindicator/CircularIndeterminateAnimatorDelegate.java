package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.google.android.material.animation.ArgbEvaluatorCompat;

public final class CircularIndeterminateAnimatorDelegate extends IndeterminateAnimatorDelegate<ObjectAnimator> {
    public static final Property<CircularIndeterminateAnimatorDelegate, Float> ANIMATION_FRACTION;
    public static final Property<CircularIndeterminateAnimatorDelegate, Float> COMPLETE_END_FRACTION;
    public static final int[] DELAY_TO_COLLAPSE_IN_MS = {667, 2017, 3367, 4717};
    public static final int[] DELAY_TO_EXPAND_IN_MS = {0, 1350, 2700, 4050};
    public static final int[] DELAY_TO_FADE_IN_MS = {1000, 2350, 3700, 5050};
    public float animationFraction;
    public ObjectAnimator animator;
    public Animatable2Compat$AnimationCallback animatorCompleteCallback = null;
    public final BaseProgressIndicatorSpec baseSpec;
    public ObjectAnimator completeEndAnimator;
    public float completeEndFraction;
    public int indicatorColorIndexOffset = 0;
    public final FastOutSlowInInterpolator interpolator;

    static {
        Class<Float> cls = Float.class;
        ANIMATION_FRACTION = new Property<CircularIndeterminateAnimatorDelegate, Float>(cls, "animationFraction") {
            public Object get(Object obj) {
                return Float.valueOf(((CircularIndeterminateAnimatorDelegate) obj).animationFraction);
            }

            public void set(Object obj, Object obj2) {
                CircularIndeterminateAnimatorDelegate circularIndeterminateAnimatorDelegate = (CircularIndeterminateAnimatorDelegate) obj;
                float floatValue = ((Float) obj2).floatValue();
                circularIndeterminateAnimatorDelegate.animationFraction = floatValue;
                int i = (int) (5400.0f * floatValue);
                float[] fArr = circularIndeterminateAnimatorDelegate.segmentPositions;
                float f2 = floatValue * 1520.0f;
                fArr[0] = -20.0f + f2;
                fArr[1] = f2;
                for (int i2 = 0; i2 < 4; i2++) {
                    float fractionInRange = circularIndeterminateAnimatorDelegate.getFractionInRange(i, CircularIndeterminateAnimatorDelegate.DELAY_TO_EXPAND_IN_MS[i2], 667);
                    float[] fArr2 = circularIndeterminateAnimatorDelegate.segmentPositions;
                    fArr2[1] = (circularIndeterminateAnimatorDelegate.interpolator.getInterpolation(fractionInRange) * 250.0f) + fArr2[1];
                    float fractionInRange2 = circularIndeterminateAnimatorDelegate.getFractionInRange(i, CircularIndeterminateAnimatorDelegate.DELAY_TO_COLLAPSE_IN_MS[i2], 667);
                    float[] fArr3 = circularIndeterminateAnimatorDelegate.segmentPositions;
                    fArr3[0] = (circularIndeterminateAnimatorDelegate.interpolator.getInterpolation(fractionInRange2) * 250.0f) + fArr3[0];
                }
                float[] fArr4 = circularIndeterminateAnimatorDelegate.segmentPositions;
                fArr4[0] = ((fArr4[1] - fArr4[0]) * circularIndeterminateAnimatorDelegate.completeEndFraction) + fArr4[0];
                fArr4[0] = fArr4[0] / 360.0f;
                fArr4[1] = fArr4[1] / 360.0f;
                int i3 = 0;
                while (true) {
                    if (i3 >= 4) {
                        break;
                    }
                    float fractionInRange3 = circularIndeterminateAnimatorDelegate.getFractionInRange(i, CircularIndeterminateAnimatorDelegate.DELAY_TO_FADE_IN_MS[i3], 333);
                    if (fractionInRange3 >= 0.0f && fractionInRange3 <= 1.0f) {
                        int i4 = i3 + circularIndeterminateAnimatorDelegate.indicatorColorIndexOffset;
                        int[] iArr = circularIndeterminateAnimatorDelegate.baseSpec.indicatorColors;
                        int length = i4 % iArr.length;
                        int compositeARGBWithAlpha = ImageOriginUtils.compositeARGBWithAlpha(iArr[length], circularIndeterminateAnimatorDelegate.drawable.totalAlpha);
                        int compositeARGBWithAlpha2 = ImageOriginUtils.compositeARGBWithAlpha(circularIndeterminateAnimatorDelegate.baseSpec.indicatorColors[(length + 1) % iArr.length], circularIndeterminateAnimatorDelegate.drawable.totalAlpha);
                        circularIndeterminateAnimatorDelegate.segmentColors[0] = ArgbEvaluatorCompat.instance.evaluate(circularIndeterminateAnimatorDelegate.interpolator.getInterpolation(fractionInRange3), Integer.valueOf(compositeARGBWithAlpha), Integer.valueOf(compositeARGBWithAlpha2)).intValue();
                        break;
                    }
                    i3++;
                }
                circularIndeterminateAnimatorDelegate.drawable.invalidateSelf();
            }
        };
        COMPLETE_END_FRACTION = new Property<CircularIndeterminateAnimatorDelegate, Float>(cls, "completeEndFraction") {
            public Object get(Object obj) {
                return Float.valueOf(((CircularIndeterminateAnimatorDelegate) obj).completeEndFraction);
            }

            public void set(Object obj, Object obj2) {
                ((CircularIndeterminateAnimatorDelegate) obj).completeEndFraction = ((Float) obj2).floatValue();
            }
        };
    }

    public CircularIndeterminateAnimatorDelegate(CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(1);
        this.baseSpec = circularProgressIndicatorSpec;
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
        this.animatorCompleteCallback = animatable2Compat$AnimationCallback;
    }

    public void requestCancelAnimatorAfterCurrentCycle() {
        if (!this.completeEndAnimator.isRunning()) {
            if (this.drawable.isVisible()) {
                this.completeEndAnimator.start();
            } else {
                cancelAnimatorImmediately();
            }
        }
    }

    public void resetPropertiesForNewStart() {
        this.indicatorColorIndexOffset = 0;
        this.segmentColors[0] = ImageOriginUtils.compositeARGBWithAlpha(this.baseSpec.indicatorColors[0], this.drawable.totalAlpha);
        this.completeEndFraction = 0.0f;
    }

    public void startAnimator() {
        if (this.animator == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, ANIMATION_FRACTION, new float[]{0.0f, 1.0f});
            this.animator = ofFloat;
            ofFloat.setDuration(5400);
            this.animator.setInterpolator(null);
            this.animator.setRepeatCount(-1);
            this.animator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationRepeat(Animator animator) {
                    super.onAnimationRepeat(animator);
                    CircularIndeterminateAnimatorDelegate circularIndeterminateAnimatorDelegate = CircularIndeterminateAnimatorDelegate.this;
                    circularIndeterminateAnimatorDelegate.indicatorColorIndexOffset = (circularIndeterminateAnimatorDelegate.indicatorColorIndexOffset + 4) % circularIndeterminateAnimatorDelegate.baseSpec.indicatorColors.length;
                }
            });
        }
        if (this.completeEndAnimator == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, COMPLETE_END_FRACTION, new float[]{0.0f, 1.0f});
            this.completeEndAnimator = ofFloat2;
            ofFloat2.setDuration(333);
            this.completeEndAnimator.setInterpolator(this.interpolator);
            this.completeEndAnimator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    CircularIndeterminateAnimatorDelegate.this.cancelAnimatorImmediately();
                    CircularIndeterminateAnimatorDelegate circularIndeterminateAnimatorDelegate = CircularIndeterminateAnimatorDelegate.this;
                    circularIndeterminateAnimatorDelegate.animatorCompleteCallback.onAnimationEnd(circularIndeterminateAnimatorDelegate.drawable);
                }
            });
        }
        resetPropertiesForNewStart();
        this.animator.start();
    }

    public void unregisterAnimatorsCompleteCallback() {
        this.animatorCompleteCallback = null;
    }
}
