package com.yalantis.ucrop.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.twitter.sdk.android.tweetui.TweetUtils;
import com.yalantis.ucrop.UCropActivity;
import com.yalantis.ucrop.model.ExifInfo;
import com.yalantis.ucrop.util.FastBitmapDrawable;

public class TransformImageView extends ImageView {
    public boolean mBitmapDecoded;
    public boolean mBitmapLaidOut;
    public final float[] mCurrentImageCenter;
    public final float[] mCurrentImageCorners;
    public Matrix mCurrentImageMatrix;
    public ExifInfo mExifInfo;
    public String mImageInputPath;
    public String mImageOutputPath;
    public float[] mInitialImageCenter;
    public float[] mInitialImageCorners;
    public final float[] mMatrixValues;
    public int mMaxBitmapSize;
    public int mThisHeight;
    public int mThisWidth;
    public TransformImageListener mTransformImageListener;

    public interface TransformImageListener {
    }

    public TransformImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public float getCurrentAngle() {
        return getMatrixAngle(this.mCurrentImageMatrix);
    }

    public float getCurrentScale() {
        return getMatrixScale(this.mCurrentImageMatrix);
    }

    public ExifInfo getExifInfo() {
        return this.mExifInfo;
    }

    public String getImageInputPath() {
        return this.mImageInputPath;
    }

    public String getImageOutputPath() {
        return this.mImageOutputPath;
    }

    public float getMatrixAngle(Matrix matrix) {
        matrix.getValues(this.mMatrixValues);
        float[] fArr = this.mMatrixValues;
        matrix.getValues(fArr);
        return (float) (-(Math.atan2((double) fArr[1], (double) this.mMatrixValues[0]) * 57.29577951308232d));
    }

    public float getMatrixScale(Matrix matrix) {
        matrix.getValues(this.mMatrixValues);
        double pow = Math.pow((double) this.mMatrixValues[0], 2.0d);
        matrix.getValues(this.mMatrixValues);
        return (float) Math.sqrt(Math.pow((double) this.mMatrixValues[3], 2.0d) + pow);
    }

    public int getMaxBitmapSize() {
        int i;
        if (this.mMaxBitmapSize <= 0) {
            WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
            Point point = new Point();
            if (windowManager != null) {
                windowManager.getDefaultDisplay().getSize(point);
            }
            int i2 = point.x;
            int i3 = point.y;
            int sqrt = (int) Math.sqrt(Math.pow((double) i3, 2.0d) + Math.pow((double) i2, 2.0d));
            Canvas canvas = new Canvas();
            int min = Math.min(canvas.getMaximumBitmapWidth(), canvas.getMaximumBitmapHeight());
            if (min > 0) {
                sqrt = Math.min(sqrt, min);
            }
            try {
                i = TweetUtils.getMaxTextureEgl14();
            } catch (Exception unused) {
                i = 0;
            }
            if (i > 0) {
                sqrt = Math.min(sqrt, i);
            }
            this.mMaxBitmapSize = sqrt;
        }
        return this.mMaxBitmapSize;
    }

    public Bitmap getViewBitmap() {
        if (getDrawable() == null || !(getDrawable() instanceof FastBitmapDrawable)) {
            return null;
        }
        return ((FastBitmapDrawable) getDrawable()).mBitmap;
    }

    public void init() {
        setScaleType(ScaleType.MATRIX);
    }

    public void onImageLaidOut() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            float intrinsicWidth = (float) drawable.getIntrinsicWidth();
            float intrinsicHeight = (float) drawable.getIntrinsicHeight();
            String.format("Image size: [%d:%d]", new Object[]{Integer.valueOf((int) intrinsicWidth), Integer.valueOf((int) intrinsicHeight)});
            RectF rectF = new RectF(0.0f, 0.0f, intrinsicWidth, intrinsicHeight);
            this.mInitialImageCorners = TweetUtils.getCornersFromRect(rectF);
            this.mInitialImageCenter = TweetUtils.getCenterFromRect(rectF);
            this.mBitmapLaidOut = true;
            TransformImageListener transformImageListener = this.mTransformImageListener;
            if (transformImageListener != null) {
                com.yalantis.ucrop.UCropActivity.AnonymousClass1 r0 = (com.yalantis.ucrop.UCropActivity.AnonymousClass1) transformImageListener;
                UCropActivity.this.mUCropView.animate().alpha(1.0f).setDuration(300).setInterpolator(new AccelerateInterpolator());
                UCropActivity.this.mBlockingView.setClickable(false);
                UCropActivity uCropActivity = UCropActivity.this;
                uCropActivity.mShowLoader = false;
                uCropActivity.supportInvalidateOptionsMenu();
            }
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z || (this.mBitmapDecoded && !this.mBitmapLaidOut)) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            this.mThisWidth = (getWidth() - getPaddingRight()) - paddingLeft;
            this.mThisHeight = (getHeight() - getPaddingBottom()) - paddingTop;
            onImageLaidOut();
        }
    }

    public void postRotate(float f2, float f3, float f4) {
        if (f2 != 0.0f) {
            this.mCurrentImageMatrix.postRotate(f2, f3, f4);
            setImageMatrix(this.mCurrentImageMatrix);
            TransformImageListener transformImageListener = this.mTransformImageListener;
            if (transformImageListener != null) {
                ((com.yalantis.ucrop.UCropActivity.AnonymousClass1) transformImageListener).onRotate(getMatrixAngle(this.mCurrentImageMatrix));
            }
        }
    }

    public void postScale(float f2, float f3, float f4) {
        if (f2 != 0.0f) {
            this.mCurrentImageMatrix.postScale(f2, f2, f3, f4);
            setImageMatrix(this.mCurrentImageMatrix);
            TransformImageListener transformImageListener = this.mTransformImageListener;
            if (transformImageListener != null) {
                ((com.yalantis.ucrop.UCropActivity.AnonymousClass1) transformImageListener).onScale(getMatrixScale(this.mCurrentImageMatrix));
            }
        }
    }

    public void postTranslate(float f2, float f3) {
        if (f2 != 0.0f || f3 != 0.0f) {
            this.mCurrentImageMatrix.postTranslate(f2, f3);
            setImageMatrix(this.mCurrentImageMatrix);
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        setImageDrawable(new FastBitmapDrawable(bitmap));
    }

    public void setImageMatrix(Matrix matrix) {
        super.setImageMatrix(matrix);
        this.mCurrentImageMatrix.set(matrix);
        this.mCurrentImageMatrix.mapPoints(this.mCurrentImageCorners, this.mInitialImageCorners);
        this.mCurrentImageMatrix.mapPoints(this.mCurrentImageCenter, this.mInitialImageCenter);
    }

    public void setMaxBitmapSize(int i) {
        this.mMaxBitmapSize = i;
    }

    public void setScaleType(ScaleType scaleType) {
        if (scaleType == ScaleType.MATRIX) {
            super.setScaleType(scaleType);
        }
    }

    public void setTransformImageListener(TransformImageListener transformImageListener) {
        this.mTransformImageListener = transformImageListener;
    }

    public TransformImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentImageCorners = new float[8];
        this.mCurrentImageCenter = new float[2];
        this.mMatrixValues = new float[9];
        this.mCurrentImageMatrix = new Matrix();
        this.mBitmapDecoded = false;
        this.mBitmapLaidOut = false;
        this.mMaxBitmapSize = 0;
        init();
    }
}
