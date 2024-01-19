package com.google.android.material.progressindicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Looper;
import android.util.AndroidRuntimeException;
import androidx.dynamicanimation.animation.AnimationHandler;
import androidx.dynamicanimation.animation.AnimationHandler.FrameCallbackProvider16;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;

public final class DeterminateDrawable<S extends BaseProgressIndicatorSpec> extends DrawableWithAnimatedVisibilityChange {
    public static final FloatPropertyCompat<DeterminateDrawable> INDICATOR_LENGTH_IN_LEVEL = new FloatPropertyCompat<DeterminateDrawable>("indicatorLevel") {
        public float getValue(Object obj) {
            return ((DeterminateDrawable) obj).indicatorFraction * 10000.0f;
        }

        public void setValue(Object obj, float f2) {
            DeterminateDrawable determinateDrawable = (DeterminateDrawable) obj;
            determinateDrawable.indicatorFraction = f2 / 10000.0f;
            determinateDrawable.invalidateSelf();
        }
    };
    public DrawingDelegate<S> drawingDelegate;
    public float indicatorFraction;
    public boolean skipAnimationOnLevelChange = false;
    public final SpringAnimation springAnimator;
    public final SpringForce springForce;

    public DeterminateDrawable(Context context, BaseProgressIndicatorSpec baseProgressIndicatorSpec, DrawingDelegate<S> drawingDelegate2) {
        super(context, baseProgressIndicatorSpec);
        this.drawingDelegate = drawingDelegate2;
        drawingDelegate2.drawable = this;
        SpringForce springForce2 = new SpringForce();
        this.springForce = springForce2;
        springForce2.mDampingRatio = (double) 1.0f;
        springForce2.mInitialized = false;
        springForce2.setStiffness(50.0f);
        SpringAnimation springAnimation = new SpringAnimation(this, INDICATOR_LENGTH_IN_LEVEL);
        this.springAnimator = springAnimation;
        springAnimation.mSpring = this.springForce;
        if (this.growFraction != 1.0f) {
            this.growFraction = 1.0f;
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        Rect rect = new Rect();
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(rect)) {
            canvas.save();
            DrawingDelegate<S> drawingDelegate2 = this.drawingDelegate;
            float growFraction = getGrowFraction();
            drawingDelegate2.spec.validateSpec();
            drawingDelegate2.adjustCanvas(canvas, growFraction);
            this.drawingDelegate.fillTrack(canvas, this.paint);
            Canvas canvas2 = canvas;
            this.drawingDelegate.fillIndicator(canvas2, this.paint, 0.0f, this.indicatorFraction, ImageOriginUtils.compositeARGBWithAlpha(this.baseSpec.indicatorColors[0], this.totalAlpha));
            canvas.restore();
        }
    }

    public int getIntrinsicHeight() {
        return this.drawingDelegate.getPreferredHeight();
    }

    public int getIntrinsicWidth() {
        return this.drawingDelegate.getPreferredWidth();
    }

    public void jumpToCurrentState() {
        this.springAnimator.cancel();
        this.indicatorFraction = ((float) getLevel()) / 10000.0f;
        invalidateSelf();
    }

    public boolean onLevelChange(int i) {
        if (this.skipAnimationOnLevelChange) {
            this.springAnimator.cancel();
            this.indicatorFraction = ((float) i) / 10000.0f;
            invalidateSelf();
        } else {
            SpringAnimation springAnimation = this.springAnimator;
            springAnimation.mValue = this.indicatorFraction * 10000.0f;
            springAnimation.mStartValueIsSet = true;
            float f2 = (float) i;
            if (springAnimation.mRunning) {
                springAnimation.mPendingPosition = f2;
            } else {
                if (springAnimation.mSpring == null) {
                    springAnimation.mSpring = new SpringForce(f2);
                }
                SpringForce springForce2 = springAnimation.mSpring;
                double d2 = (double) f2;
                springForce2.mFinalPosition = d2;
                double d3 = (double) ((float) d2);
                if (d3 > ((double) springAnimation.mMaxValue)) {
                    throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
                } else if (d3 >= ((double) springAnimation.mMinValue)) {
                    double abs = Math.abs((double) (springAnimation.mMinVisibleChange * 0.75f));
                    springForce2.mValueThreshold = abs;
                    springForce2.mVelocityThreshold = abs * 62.5d;
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        boolean z = springAnimation.mRunning;
                        if (!z && !z) {
                            springAnimation.mRunning = true;
                            if (!springAnimation.mStartValueIsSet) {
                                springAnimation.mValue = springAnimation.mProperty.getValue(springAnimation.mTarget);
                            }
                            float f3 = springAnimation.mValue;
                            if (f3 > springAnimation.mMaxValue || f3 < springAnimation.mMinValue) {
                                throw new IllegalArgumentException("Starting value need to be in between min value and max value");
                            }
                            AnimationHandler instance = AnimationHandler.getInstance();
                            if (instance.mAnimationCallbacks.size() == 0) {
                                if (instance.mProvider == null) {
                                    instance.mProvider = new FrameCallbackProvider16(instance.mCallbackDispatcher);
                                }
                                instance.mProvider.postFrameCallback();
                            }
                            if (!instance.mAnimationCallbacks.contains(springAnimation)) {
                                instance.mAnimationCallbacks.add(springAnimation);
                            }
                        }
                    } else {
                        throw new AndroidRuntimeException("Animations may only be started on the main thread");
                    }
                } else {
                    throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
                }
            }
        }
        return true;
    }

    public boolean setVisibleInternal(boolean z, boolean z2, boolean z3) {
        boolean visibleInternal = super.setVisibleInternal(z, z2, z3);
        float systemAnimatorDurationScale = this.animatorDurationScaleProvider.getSystemAnimatorDurationScale(this.context.getContentResolver());
        if (systemAnimatorDurationScale == 0.0f) {
            this.skipAnimationOnLevelChange = true;
        } else {
            this.skipAnimationOnLevelChange = false;
            this.springForce.setStiffness(50.0f / systemAnimatorDurationScale);
        }
        return visibleInternal;
    }
}
