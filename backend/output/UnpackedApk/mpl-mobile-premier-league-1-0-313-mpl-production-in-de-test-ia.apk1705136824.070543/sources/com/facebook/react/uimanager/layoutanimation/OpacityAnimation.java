package com.facebook.react.uimanager.layoutanimation;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;

public class OpacityAnimation extends Animation {
    public final float mDeltaOpacity;
    public final float mStartOpacity;
    public final View mView;

    public static class OpacityAnimationListener implements AnimationListener {
        public boolean mLayerTypeChanged = false;
        public final View mView;

        public OpacityAnimationListener(View view) {
            this.mView = view;
        }

        public void onAnimationEnd(Animation animation) {
            if (this.mLayerTypeChanged) {
                this.mView.setLayerType(0, null);
            }
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
            if (this.mView.hasOverlappingRendering() && this.mView.getLayerType() == 0) {
                this.mLayerTypeChanged = true;
                this.mView.setLayerType(2, null);
            }
        }
    }

    public OpacityAnimation(View view, float f2, float f3) {
        this.mView = view;
        this.mStartOpacity = f2;
        this.mDeltaOpacity = f3 - f2;
        setAnimationListener(new OpacityAnimationListener(view));
    }

    public void applyTransformation(float f2, Transformation transformation) {
        this.mView.setAlpha((this.mDeltaOpacity * f2) + this.mStartOpacity);
    }

    public boolean willChangeBounds() {
        return false;
    }
}
