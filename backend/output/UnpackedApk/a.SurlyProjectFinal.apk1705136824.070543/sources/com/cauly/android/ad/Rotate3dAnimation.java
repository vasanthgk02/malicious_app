package com.cauly.android.ad;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class Rotate3dAnimation extends Animation {
    protected Camera mCamera;
    protected final float mCenterX;
    protected final float mCenterY;
    protected final float mDepthZ;
    protected final float mFromDegrees;
    protected final boolean mReverse;
    protected final float mToDegrees;

    protected Rotate3dAnimation(float fromDegrees, float toDegrees, float centerX, float centerY, float depthZ, boolean reverse) {
        this.mFromDegrees = fromDegrees;
        this.mToDegrees = toDegrees;
        this.mCenterX = centerX;
        this.mCenterY = centerY;
        this.mDepthZ = depthZ;
        this.mReverse = reverse;
    }

    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        this.mCamera = new Camera();
    }

    /* access modifiers changed from: protected */
    public void applyTransformation(float interpolatedTime, Transformation t) {
        float fromDegrees = this.mFromDegrees;
        float degrees = fromDegrees + ((this.mToDegrees - fromDegrees) * interpolatedTime);
        float centerX = this.mCenterX;
        float centerY = this.mCenterY;
        Camera camera = this.mCamera;
        camera.save();
        Matrix matrix = t.getMatrix();
        if (this.mReverse) {
            camera.translate(0.0f, 0.0f, this.mDepthZ * interpolatedTime);
        } else {
            camera.translate(0.0f, 0.0f, this.mDepthZ * (1.0f - interpolatedTime));
        }
        camera.rotateY(degrees);
        camera.getMatrix(matrix);
        camera.restore();
        matrix.preTranslate(-centerX, -centerY);
        matrix.postTranslate(centerX, centerY);
    }
}