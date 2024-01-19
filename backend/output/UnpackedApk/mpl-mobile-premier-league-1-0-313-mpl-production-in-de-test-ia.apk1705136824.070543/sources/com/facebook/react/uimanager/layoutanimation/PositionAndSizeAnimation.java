package com.facebook.react.uimanager.layoutanimation;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class PositionAndSizeAnimation extends Animation implements LayoutHandlingAnimation {
    public int mDeltaHeight;
    public int mDeltaWidth;
    public float mDeltaX;
    public float mDeltaY;
    public int mStartHeight;
    public int mStartWidth;
    public float mStartX;
    public float mStartY;
    public final View mView;

    public PositionAndSizeAnimation(View view, int i, int i2, int i3, int i4) {
        this.mView = view;
        calculateAnimation(i, i2, i3, i4);
    }

    public void applyTransformation(float f2, Transformation transformation) {
        float f3 = (this.mDeltaX * f2) + this.mStartX;
        float f4 = (this.mDeltaY * f2) + this.mStartY;
        this.mView.layout(Math.round(f3), Math.round(f4), Math.round(f3 + (((float) this.mDeltaWidth) * f2) + ((float) this.mStartWidth)), Math.round(f4 + (((float) this.mDeltaHeight) * f2) + ((float) this.mStartHeight)));
    }

    public final void calculateAnimation(int i, int i2, int i3, int i4) {
        this.mStartX = this.mView.getX() - this.mView.getTranslationX();
        this.mStartY = this.mView.getY() - this.mView.getTranslationY();
        this.mStartWidth = this.mView.getWidth();
        int height = this.mView.getHeight();
        this.mStartHeight = height;
        this.mDeltaX = ((float) i) - this.mStartX;
        this.mDeltaY = ((float) i2) - this.mStartY;
        this.mDeltaWidth = i3 - this.mStartWidth;
        this.mDeltaHeight = i4 - height;
    }

    public void onLayoutUpdate(int i, int i2, int i3, int i4) {
        calculateAnimation(i, i2, i3, i4);
    }

    public boolean willChangeBounds() {
        return true;
    }
}
