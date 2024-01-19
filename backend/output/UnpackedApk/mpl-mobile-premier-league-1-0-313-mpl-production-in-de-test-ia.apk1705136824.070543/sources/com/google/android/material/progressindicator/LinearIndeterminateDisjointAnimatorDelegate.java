package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.Property;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.google.android.material.R$animator;
import java.util.Arrays;
import org.apache.commons.net.ftp.FTPReply;

public final class LinearIndeterminateDisjointAnimatorDelegate extends IndeterminateAnimatorDelegate<ObjectAnimator> {
    public static final Property<LinearIndeterminateDisjointAnimatorDelegate, Float> ANIMATION_FRACTION = new Property<LinearIndeterminateDisjointAnimatorDelegate, Float>(Float.class, "animationFraction") {
        public Object get(Object obj) {
            return Float.valueOf(((LinearIndeterminateDisjointAnimatorDelegate) obj).animationFraction);
        }

        public void set(Object obj, Object obj2) {
            LinearIndeterminateDisjointAnimatorDelegate linearIndeterminateDisjointAnimatorDelegate = (LinearIndeterminateDisjointAnimatorDelegate) obj;
            float floatValue = ((Float) obj2).floatValue();
            linearIndeterminateDisjointAnimatorDelegate.animationFraction = floatValue;
            int i = (int) (floatValue * 1800.0f);
            for (int i2 = 0; i2 < 4; i2++) {
                linearIndeterminateDisjointAnimatorDelegate.segmentPositions[i2] = Math.max(0.0f, Math.min(1.0f, linearIndeterminateDisjointAnimatorDelegate.interpolatorArray[i2].getInterpolation(linearIndeterminateDisjointAnimatorDelegate.getFractionInRange(i, LinearIndeterminateDisjointAnimatorDelegate.DELAY_TO_MOVE_SEGMENT_ENDS[i2], LinearIndeterminateDisjointAnimatorDelegate.DURATION_TO_MOVE_SEGMENT_ENDS[i2]))));
            }
            if (linearIndeterminateDisjointAnimatorDelegate.dirtyColors) {
                Arrays.fill(linearIndeterminateDisjointAnimatorDelegate.segmentColors, ImageOriginUtils.compositeARGBWithAlpha(linearIndeterminateDisjointAnimatorDelegate.baseSpec.indicatorColors[linearIndeterminateDisjointAnimatorDelegate.indicatorColorIndex], linearIndeterminateDisjointAnimatorDelegate.drawable.totalAlpha));
                linearIndeterminateDisjointAnimatorDelegate.dirtyColors = false;
            }
            linearIndeterminateDisjointAnimatorDelegate.drawable.invalidateSelf();
        }
    };
    public static final int[] DELAY_TO_MOVE_SEGMENT_ENDS = {1267, 1000, 333, 0};
    public static final int[] DURATION_TO_MOVE_SEGMENT_ENDS = {FTPReply.DENIED_FOR_POLICY_REASONS, 567, 850, 750};
    public float animationFraction;
    public ObjectAnimator animator;
    public Animatable2Compat$AnimationCallback animatorCompleteCallback = null;
    public boolean animatorCompleteEndRequested;
    public final BaseProgressIndicatorSpec baseSpec;
    public boolean dirtyColors;
    public int indicatorColorIndex = 0;
    public final Interpolator[] interpolatorArray;

    public LinearIndeterminateDisjointAnimatorDelegate(Context context, LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(2);
        this.baseSpec = linearProgressIndicatorSpec;
        this.interpolatorArray = new Interpolator[]{AnimationUtils.loadInterpolator(context, R$animator.linear_indeterminate_line1_head_interpolator), AnimationUtils.loadInterpolator(context, R$animator.linear_indeterminate_line1_tail_interpolator), AnimationUtils.loadInterpolator(context, R$animator.linear_indeterminate_line2_head_interpolator), AnimationUtils.loadInterpolator(context, R$animator.linear_indeterminate_line2_tail_interpolator)};
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
        if (this.drawable.isVisible()) {
            this.animatorCompleteEndRequested = true;
            this.animator.setRepeatCount(0);
            return;
        }
        ObjectAnimator objectAnimator = this.animator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    public void resetPropertiesForNewStart() {
        this.indicatorColorIndex = 0;
        int compositeARGBWithAlpha = ImageOriginUtils.compositeARGBWithAlpha(this.baseSpec.indicatorColors[0], this.drawable.totalAlpha);
        int[] iArr = this.segmentColors;
        iArr[0] = compositeARGBWithAlpha;
        iArr[1] = compositeARGBWithAlpha;
    }

    public void startAnimator() {
        if (this.animator == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, ANIMATION_FRACTION, new float[]{0.0f, 1.0f});
            this.animator = ofFloat;
            ofFloat.setDuration(1800);
            this.animator.setInterpolator(null);
            this.animator.setRepeatCount(-1);
            this.animator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    LinearIndeterminateDisjointAnimatorDelegate linearIndeterminateDisjointAnimatorDelegate = LinearIndeterminateDisjointAnimatorDelegate.this;
                    if (linearIndeterminateDisjointAnimatorDelegate.animatorCompleteEndRequested) {
                        linearIndeterminateDisjointAnimatorDelegate.animator.setRepeatCount(-1);
                        LinearIndeterminateDisjointAnimatorDelegate linearIndeterminateDisjointAnimatorDelegate2 = LinearIndeterminateDisjointAnimatorDelegate.this;
                        linearIndeterminateDisjointAnimatorDelegate2.animatorCompleteCallback.onAnimationEnd(linearIndeterminateDisjointAnimatorDelegate2.drawable);
                        LinearIndeterminateDisjointAnimatorDelegate.this.animatorCompleteEndRequested = false;
                    }
                }

                public void onAnimationRepeat(Animator animator) {
                    super.onAnimationRepeat(animator);
                    LinearIndeterminateDisjointAnimatorDelegate linearIndeterminateDisjointAnimatorDelegate = LinearIndeterminateDisjointAnimatorDelegate.this;
                    linearIndeterminateDisjointAnimatorDelegate.indicatorColorIndex = (linearIndeterminateDisjointAnimatorDelegate.indicatorColorIndex + 1) % linearIndeterminateDisjointAnimatorDelegate.baseSpec.indicatorColors.length;
                    linearIndeterminateDisjointAnimatorDelegate.dirtyColors = true;
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
