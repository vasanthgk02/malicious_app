package com.yalantis.ucrop.view;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.twitter.sdk.android.tweetui.TweetUtils;
import com.yalantis.ucrop.UCropActivity.AnonymousClass1;
import com.yalantis.ucrop.callback.CropBoundsChangeListener;
import com.yalantis.ucrop.view.TransformImageView.TransformImageListener;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class CropImageView extends TransformImageView {
    public CropBoundsChangeListener mCropBoundsChangeListener;
    public final RectF mCropRect;
    public long mImageToWrapCropBoundsAnimDuration;
    public int mMaxResultImageSizeX;
    public int mMaxResultImageSizeY;
    public float mMaxScale;
    public float mMaxScaleMultiplier;
    public float mMinScale;
    public float mTargetAspectRatio;
    public final Matrix mTempMatrix;
    public Runnable mWrapCropBoundsRunnable;
    public Runnable mZoomImageToPositionRunnable;

    public static class WrapCropBoundsRunnable implements Runnable {
        public final float mCenterDiffX;
        public final float mCenterDiffY;
        public final WeakReference<CropImageView> mCropImageView;
        public final float mDeltaScale;
        public final long mDurationMs;
        public final float mOldScale;
        public final float mOldX;
        public final float mOldY;
        public final long mStartTime = System.currentTimeMillis();
        public final boolean mWillBeImageInBoundsAfterTranslate;

        public WrapCropBoundsRunnable(CropImageView cropImageView, long j, float f2, float f3, float f4, float f5, float f6, float f7, boolean z) {
            this.mCropImageView = new WeakReference<>(cropImageView);
            this.mDurationMs = j;
            this.mOldX = f2;
            this.mOldY = f3;
            this.mCenterDiffX = f4;
            this.mCenterDiffY = f5;
            this.mOldScale = f6;
            this.mDeltaScale = f7;
            this.mWillBeImageInBoundsAfterTranslate = z;
        }

        public void run() {
            CropImageView cropImageView = (CropImageView) this.mCropImageView.get();
            if (cropImageView != null) {
                float min = (float) Math.min(this.mDurationMs, System.currentTimeMillis() - this.mStartTime);
                float f2 = this.mCenterDiffX;
                float f3 = (float) this.mDurationMs;
                float f4 = (min / f3) - 1.0f;
                float f5 = (f4 * f4 * f4) + 1.0f;
                float f6 = (f2 * f5) + 0.0f;
                float f7 = (f5 * this.mCenterDiffY) + 0.0f;
                float easeInOut = TweetUtils.easeInOut(min, 0.0f, this.mDeltaScale, f3);
                if (min < ((float) this.mDurationMs)) {
                    float[] fArr = cropImageView.mCurrentImageCenter;
                    cropImageView.postTranslate(f6 - (fArr[0] - this.mOldX), f7 - (fArr[1] - this.mOldY));
                    if (!this.mWillBeImageInBoundsAfterTranslate) {
                        cropImageView.zoomInImage(this.mOldScale + easeInOut, cropImageView.mCropRect.centerX(), cropImageView.mCropRect.centerY());
                    }
                    if (!cropImageView.isImageWrapCropBounds(cropImageView.mCurrentImageCorners)) {
                        cropImageView.post(this);
                    }
                }
            }
        }
    }

    public static class ZoomImageToPosition implements Runnable {
        public final WeakReference<CropImageView> mCropImageView;
        public final float mDeltaScale;
        public final float mDestX;
        public final float mDestY;
        public final long mDurationMs;
        public final float mOldScale;
        public final long mStartTime = System.currentTimeMillis();

        public ZoomImageToPosition(CropImageView cropImageView, long j, float f2, float f3, float f4, float f5) {
            this.mCropImageView = new WeakReference<>(cropImageView);
            this.mDurationMs = j;
            this.mOldScale = f2;
            this.mDeltaScale = f3;
            this.mDestX = f4;
            this.mDestY = f5;
        }

        public void run() {
            CropImageView cropImageView = (CropImageView) this.mCropImageView.get();
            if (cropImageView != null) {
                float min = (float) Math.min(this.mDurationMs, System.currentTimeMillis() - this.mStartTime);
                float easeInOut = TweetUtils.easeInOut(min, 0.0f, this.mDeltaScale, (float) this.mDurationMs);
                if (min < ((float) this.mDurationMs)) {
                    cropImageView.zoomInImage(this.mOldScale + easeInOut, this.mDestX, this.mDestY);
                    cropImageView.post(this);
                } else {
                    cropImageView.setImageToWrapCropBounds(true);
                }
            }
        }
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void calculateImageScaleBounds(float f2, float f3) {
        float min = Math.min(Math.min(this.mCropRect.width() / f2, this.mCropRect.width() / f3), Math.min(this.mCropRect.height() / f3, this.mCropRect.height() / f2));
        this.mMinScale = min;
        this.mMaxScale = min * this.mMaxScaleMultiplier;
    }

    public void cancelAllAnimations() {
        removeCallbacks(this.mWrapCropBoundsRunnable);
        removeCallbacks(this.mZoomImageToPositionRunnable);
    }

    public CropBoundsChangeListener getCropBoundsChangeListener() {
        return this.mCropBoundsChangeListener;
    }

    public float getMaxScale() {
        return this.mMaxScale;
    }

    public float getMinScale() {
        return this.mMinScale;
    }

    public float getTargetAspectRatio() {
        return this.mTargetAspectRatio;
    }

    public boolean isImageWrapCropBounds(float[] fArr) {
        this.mTempMatrix.reset();
        this.mTempMatrix.setRotate(-getCurrentAngle());
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        this.mTempMatrix.mapPoints(copyOf);
        float[] cornersFromRect = TweetUtils.getCornersFromRect(this.mCropRect);
        this.mTempMatrix.mapPoints(cornersFromRect);
        return TweetUtils.trapToRect(copyOf).contains(TweetUtils.trapToRect(cornersFromRect));
    }

    public void onImageLaidOut() {
        super.onImageLaidOut();
        Drawable drawable = getDrawable();
        if (drawable != null) {
            float intrinsicWidth = (float) drawable.getIntrinsicWidth();
            float intrinsicHeight = (float) drawable.getIntrinsicHeight();
            if (this.mTargetAspectRatio == 0.0f) {
                this.mTargetAspectRatio = intrinsicWidth / intrinsicHeight;
            }
            int i = this.mThisWidth;
            float f2 = (float) i;
            float f3 = this.mTargetAspectRatio;
            int i2 = (int) (f2 / f3);
            int i3 = this.mThisHeight;
            if (i2 > i3) {
                float f4 = (float) i3;
                int i4 = (int) (f3 * f4);
                int i5 = (i - i4) / 2;
                this.mCropRect.set((float) i5, 0.0f, (float) (i4 + i5), f4);
            } else {
                int i6 = (i3 - i2) / 2;
                this.mCropRect.set(0.0f, (float) i6, f2, (float) (i2 + i6));
            }
            calculateImageScaleBounds(intrinsicWidth, intrinsicHeight);
            float width = this.mCropRect.width();
            float height = this.mCropRect.height();
            float max = Math.max(this.mCropRect.width() / intrinsicWidth, this.mCropRect.height() / intrinsicHeight);
            RectF rectF = this.mCropRect;
            float f5 = ((height - (intrinsicHeight * max)) / 2.0f) + rectF.top;
            this.mCurrentImageMatrix.reset();
            this.mCurrentImageMatrix.postScale(max, max);
            this.mCurrentImageMatrix.postTranslate(((width - (intrinsicWidth * max)) / 2.0f) + rectF.left, f5);
            setImageMatrix(this.mCurrentImageMatrix);
            CropBoundsChangeListener cropBoundsChangeListener = this.mCropBoundsChangeListener;
            if (cropBoundsChangeListener != null) {
                UCropView.this.mViewOverlay.setTargetAspectRatio(this.mTargetAspectRatio);
            }
            TransformImageListener transformImageListener = this.mTransformImageListener;
            if (transformImageListener != null) {
                ((AnonymousClass1) transformImageListener).onScale(getCurrentScale());
                ((AnonymousClass1) this.mTransformImageListener).onRotate(getCurrentAngle());
            }
        }
    }

    public void postRotate(float f2) {
        postRotate(f2, this.mCropRect.centerX(), this.mCropRect.centerY());
    }

    public void postScale(float f2, float f3, float f4) {
        if (f2 > 1.0f && getCurrentScale() * f2 <= getMaxScale()) {
            super.postScale(f2, f3, f4);
        } else if (f2 < 1.0f && getCurrentScale() * f2 >= getMinScale()) {
            super.postScale(f2, f3, f4);
        }
    }

    public void setCropBoundsChangeListener(CropBoundsChangeListener cropBoundsChangeListener) {
        this.mCropBoundsChangeListener = cropBoundsChangeListener;
    }

    public void setCropRect(RectF rectF) {
        this.mTargetAspectRatio = rectF.width() / rectF.height();
        this.mCropRect.set(rectF.left - ((float) getPaddingLeft()), rectF.top - ((float) getPaddingTop()), rectF.right - ((float) getPaddingRight()), rectF.bottom - ((float) getPaddingBottom()));
        Drawable drawable = getDrawable();
        if (drawable != null) {
            calculateImageScaleBounds((float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
        }
        setImageToWrapCropBounds(true);
    }

    public void setImageToWrapCropBounds(boolean z) {
        float f2;
        float f3;
        float f4;
        float f5;
        if (this.mBitmapLaidOut && !isImageWrapCropBounds(this.mCurrentImageCorners)) {
            float[] fArr = this.mCurrentImageCenter;
            float f6 = fArr[0];
            float f7 = fArr[1];
            float currentScale = getCurrentScale();
            float centerX = this.mCropRect.centerX() - f6;
            float centerY = this.mCropRect.centerY() - f7;
            this.mTempMatrix.reset();
            this.mTempMatrix.setTranslate(centerX, centerY);
            float[] fArr2 = this.mCurrentImageCorners;
            float[] copyOf = Arrays.copyOf(fArr2, fArr2.length);
            this.mTempMatrix.mapPoints(copyOf);
            boolean isImageWrapCropBounds = isImageWrapCropBounds(copyOf);
            if (isImageWrapCropBounds) {
                this.mTempMatrix.reset();
                this.mTempMatrix.setRotate(-getCurrentAngle());
                float[] fArr3 = this.mCurrentImageCorners;
                float[] copyOf2 = Arrays.copyOf(fArr3, fArr3.length);
                float[] cornersFromRect = TweetUtils.getCornersFromRect(this.mCropRect);
                this.mTempMatrix.mapPoints(copyOf2);
                this.mTempMatrix.mapPoints(cornersFromRect);
                RectF trapToRect = TweetUtils.trapToRect(copyOf2);
                RectF trapToRect2 = TweetUtils.trapToRect(cornersFromRect);
                float f8 = trapToRect.left - trapToRect2.left;
                float f9 = trapToRect.top - trapToRect2.top;
                float f10 = trapToRect.right - trapToRect2.right;
                float f11 = trapToRect.bottom - trapToRect2.bottom;
                float[] fArr4 = new float[4];
                if (f8 <= 0.0f) {
                    f8 = 0.0f;
                }
                fArr4[0] = f8;
                if (f9 <= 0.0f) {
                    f9 = 0.0f;
                }
                fArr4[1] = f9;
                if (f10 >= 0.0f) {
                    f10 = 0.0f;
                }
                fArr4[2] = f10;
                if (f11 >= 0.0f) {
                    f11 = 0.0f;
                }
                fArr4[3] = f11;
                this.mTempMatrix.reset();
                this.mTempMatrix.setRotate(getCurrentAngle());
                this.mTempMatrix.mapPoints(fArr4);
                f5 = -(fArr4[0] + fArr4[2]);
                f4 = -(fArr4[1] + fArr4[3]);
                f2 = currentScale;
                f3 = 0.0f;
            } else {
                RectF rectF = new RectF(this.mCropRect);
                this.mTempMatrix.reset();
                this.mTempMatrix.setRotate(getCurrentAngle());
                this.mTempMatrix.mapRect(rectF);
                float[] fArr5 = this.mCurrentImageCorners;
                f2 = currentScale;
                float[] fArr6 = {(float) Math.sqrt(Math.pow((double) (fArr5[1] - fArr5[3]), 2.0d) + Math.pow((double) (fArr5[0] - fArr5[2]), 2.0d)), (float) Math.sqrt(Math.pow((double) (fArr5[3] - fArr5[5]), 2.0d) + Math.pow((double) (fArr5[2] - fArr5[4]), 2.0d))};
                f5 = centerX;
                f3 = (Math.max(rectF.width() / fArr6[0], rectF.height() / fArr6[1]) * f2) - f2;
                f4 = centerY;
            }
            if (z) {
                WrapCropBoundsRunnable wrapCropBoundsRunnable = new WrapCropBoundsRunnable(this, this.mImageToWrapCropBoundsAnimDuration, f6, f7, f5, f4, f2, f3, isImageWrapCropBounds);
                this.mWrapCropBoundsRunnable = wrapCropBoundsRunnable;
                post(wrapCropBoundsRunnable);
                return;
            }
            postTranslate(f5, f4);
            if (!isImageWrapCropBounds) {
                zoomInImage(f2 + f3, this.mCropRect.centerX(), this.mCropRect.centerY());
            }
        }
    }

    public void setImageToWrapCropBoundsAnimDuration(long j) {
        if (j > 0) {
            this.mImageToWrapCropBoundsAnimDuration = j;
            return;
        }
        throw new IllegalArgumentException("Animation duration cannot be negative value.");
    }

    public void setMaxResultImageSizeX(int i) {
        this.mMaxResultImageSizeX = i;
    }

    public void setMaxResultImageSizeY(int i) {
        this.mMaxResultImageSizeY = i;
    }

    public void setMaxScaleMultiplier(float f2) {
        this.mMaxScaleMultiplier = f2;
    }

    public void setTargetAspectRatio(float f2) {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            this.mTargetAspectRatio = f2;
            return;
        }
        if (f2 == 0.0f) {
            this.mTargetAspectRatio = ((float) drawable.getIntrinsicWidth()) / ((float) drawable.getIntrinsicHeight());
        } else {
            this.mTargetAspectRatio = f2;
        }
        CropBoundsChangeListener cropBoundsChangeListener = this.mCropBoundsChangeListener;
        if (cropBoundsChangeListener != null) {
            UCropView.this.mViewOverlay.setTargetAspectRatio(this.mTargetAspectRatio);
        }
    }

    public void zoomInImage(float f2, float f3, float f4) {
        if (f2 <= getMaxScale()) {
            postScale(f2 / getCurrentScale(), f3, f4);
        }
    }

    public CropImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCropRect = new RectF();
        this.mTempMatrix = new Matrix();
        this.mMaxScaleMultiplier = 10.0f;
        this.mZoomImageToPositionRunnable = null;
        this.mMaxResultImageSizeX = 0;
        this.mMaxResultImageSizeY = 0;
        this.mImageToWrapCropBoundsAnimDuration = 500;
    }
}
