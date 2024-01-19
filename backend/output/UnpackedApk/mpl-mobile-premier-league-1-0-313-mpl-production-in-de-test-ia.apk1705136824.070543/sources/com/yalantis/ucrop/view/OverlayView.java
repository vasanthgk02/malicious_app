package com.yalantis.ucrop.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.twitter.sdk.android.tweetui.TweetUtils;
import com.yalantis.ucrop.R$dimen;
import com.yalantis.ucrop.callback.OverlayViewChangeListener;
import sfs2x.client.entities.invitation.InvitationReply;

public class OverlayView extends View {
    public OverlayViewChangeListener mCallback;
    public boolean mCircleDimmedLayer;
    public Path mCircularPath;
    public Paint mCropFrameCornersPaint;
    public Paint mCropFramePaint;
    public int mCropGridColumnCount;
    public float[] mCropGridCorners;
    public Paint mCropGridPaint;
    public int mCropGridRowCount;
    public int mCropRectCornerTouchAreaLineLength;
    public int mCropRectMinSize;
    public final RectF mCropViewRect;
    public int mCurrentTouchCornerIndex;
    public int mDimmedColor;
    public Paint mDimmedStrokePaint;
    public int mFreestyleCropMode;
    public float[] mGridPoints;
    public float mPreviousTouchX;
    public float mPreviousTouchY;
    public boolean mShouldSetupCropBounds;
    public boolean mShowCropFrame;
    public boolean mShowCropGrid;
    public float mTargetAspectRatio;
    public final RectF mTempRect;
    public int mThisHeight;
    public int mThisWidth;
    public int mTouchPointThreshold;

    public OverlayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RectF getCropViewRect() {
        return this.mCropViewRect;
    }

    public int getFreestyleCropMode() {
        return this.mFreestyleCropMode;
    }

    public OverlayViewChangeListener getOverlayViewChangeListener() {
        return this.mCallback;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        if (this.mCircleDimmedLayer) {
            canvas.clipPath(this.mCircularPath, Op.DIFFERENCE);
        } else {
            canvas.clipRect(this.mCropViewRect, Op.DIFFERENCE);
        }
        canvas.drawColor(this.mDimmedColor);
        canvas.restore();
        if (this.mCircleDimmedLayer) {
            canvas.drawCircle(this.mCropViewRect.centerX(), this.mCropViewRect.centerY(), Math.min(this.mCropViewRect.width(), this.mCropViewRect.height()) / 2.0f, this.mDimmedStrokePaint);
        }
        if (this.mShowCropGrid) {
            if (this.mGridPoints == null && !this.mCropViewRect.isEmpty()) {
                this.mGridPoints = new float[((this.mCropGridColumnCount * 4) + (this.mCropGridRowCount * 4))];
                int i = 0;
                for (int i2 = 0; i2 < this.mCropGridRowCount; i2++) {
                    float[] fArr = this.mGridPoints;
                    int i3 = i + 1;
                    RectF rectF = this.mCropViewRect;
                    fArr[i] = rectF.left;
                    int i4 = i3 + 1;
                    float f2 = ((float) i2) + 1.0f;
                    float height = (f2 / ((float) (this.mCropGridRowCount + 1))) * rectF.height();
                    RectF rectF2 = this.mCropViewRect;
                    fArr[i3] = height + rectF2.top;
                    float[] fArr2 = this.mGridPoints;
                    int i5 = i4 + 1;
                    fArr2[i4] = rectF2.right;
                    i = i5 + 1;
                    fArr2[i5] = ((f2 / ((float) (this.mCropGridRowCount + 1))) * rectF2.height()) + this.mCropViewRect.top;
                }
                for (int i6 = 0; i6 < this.mCropGridColumnCount; i6++) {
                    float[] fArr3 = this.mGridPoints;
                    int i7 = i + 1;
                    float f3 = ((float) i6) + 1.0f;
                    float width = (f3 / ((float) (this.mCropGridColumnCount + 1))) * this.mCropViewRect.width();
                    RectF rectF3 = this.mCropViewRect;
                    fArr3[i] = width + rectF3.left;
                    float[] fArr4 = this.mGridPoints;
                    int i8 = i7 + 1;
                    fArr4[i7] = rectF3.top;
                    int i9 = i8 + 1;
                    float width2 = (f3 / ((float) (this.mCropGridColumnCount + 1))) * rectF3.width();
                    RectF rectF4 = this.mCropViewRect;
                    fArr4[i8] = width2 + rectF4.left;
                    i = i9 + 1;
                    this.mGridPoints[i9] = rectF4.bottom;
                }
            }
            float[] fArr5 = this.mGridPoints;
            if (fArr5 != null) {
                canvas.drawLines(fArr5, this.mCropGridPaint);
            }
        }
        if (this.mShowCropFrame) {
            canvas.drawRect(this.mCropViewRect, this.mCropFramePaint);
        }
        if (this.mFreestyleCropMode != 0) {
            canvas.save();
            this.mTempRect.set(this.mCropViewRect);
            RectF rectF5 = this.mTempRect;
            int i10 = this.mCropRectCornerTouchAreaLineLength;
            rectF5.inset((float) i10, (float) (-i10));
            canvas.clipRect(this.mTempRect, Op.DIFFERENCE);
            this.mTempRect.set(this.mCropViewRect);
            RectF rectF6 = this.mTempRect;
            int i11 = this.mCropRectCornerTouchAreaLineLength;
            rectF6.inset((float) (-i11), (float) i11);
            canvas.clipRect(this.mTempRect, Op.DIFFERENCE);
            canvas.drawRect(this.mCropViewRect, this.mCropFrameCornersPaint);
            canvas.restore();
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            this.mThisWidth = (getWidth() - getPaddingRight()) - paddingLeft;
            this.mThisHeight = (getHeight() - getPaddingBottom()) - paddingTop;
            if (this.mShouldSetupCropBounds) {
                this.mShouldSetupCropBounds = false;
                setTargetAspectRatio(this.mTargetAspectRatio);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mCropViewRect.isEmpty() || this.mFreestyleCropMode == 0) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if ((motionEvent.getAction() & InvitationReply.EXPIRED) == 0) {
            double d2 = (double) this.mTouchPointThreshold;
            int i = -1;
            for (int i2 = 0; i2 < 8; i2 += 2) {
                double sqrt = Math.sqrt(Math.pow((double) (y - this.mCropGridCorners[i2 + 1]), 2.0d) + Math.pow((double) (x - this.mCropGridCorners[i2]), 2.0d));
                if (sqrt < d2) {
                    i = i2 / 2;
                    d2 = sqrt;
                }
            }
            int i3 = (this.mFreestyleCropMode != 1 || i >= 0 || !this.mCropViewRect.contains(x, y)) ? i : 4;
            this.mCurrentTouchCornerIndex = i3;
            boolean z = i3 != -1;
            if (!z) {
                this.mPreviousTouchX = -1.0f;
                this.mPreviousTouchY = -1.0f;
            } else if (this.mPreviousTouchX < 0.0f) {
                this.mPreviousTouchX = x;
                this.mPreviousTouchY = y;
            }
            return z;
        } else if ((motionEvent.getAction() & InvitationReply.EXPIRED) == 2 && motionEvent.getPointerCount() == 1 && this.mCurrentTouchCornerIndex != -1) {
            float min = Math.min(Math.max(x, (float) getPaddingLeft()), (float) (getWidth() - getPaddingRight()));
            float min2 = Math.min(Math.max(y, (float) getPaddingTop()), (float) (getHeight() - getPaddingBottom()));
            this.mTempRect.set(this.mCropViewRect);
            int i4 = this.mCurrentTouchCornerIndex;
            if (i4 == 0) {
                RectF rectF = this.mTempRect;
                RectF rectF2 = this.mCropViewRect;
                rectF.set(min, min2, rectF2.right, rectF2.bottom);
            } else if (i4 == 1) {
                RectF rectF3 = this.mTempRect;
                RectF rectF4 = this.mCropViewRect;
                rectF3.set(rectF4.left, min2, min, rectF4.bottom);
            } else if (i4 == 2) {
                RectF rectF5 = this.mTempRect;
                RectF rectF6 = this.mCropViewRect;
                rectF5.set(rectF6.left, rectF6.top, min, min2);
            } else if (i4 == 3) {
                RectF rectF7 = this.mTempRect;
                RectF rectF8 = this.mCropViewRect;
                rectF7.set(min, rectF8.top, rectF8.right, min2);
            } else if (i4 == 4) {
                this.mTempRect.offset(min - this.mPreviousTouchX, min2 - this.mPreviousTouchY);
                if (this.mTempRect.left > ((float) getLeft()) && this.mTempRect.top > ((float) getTop()) && this.mTempRect.right < ((float) getRight()) && this.mTempRect.bottom < ((float) getBottom())) {
                    this.mCropViewRect.set(this.mTempRect);
                    updateGridPoints();
                    postInvalidate();
                }
                this.mPreviousTouchX = min;
                this.mPreviousTouchY = min2;
                return true;
            }
            boolean z2 = this.mTempRect.height() >= ((float) this.mCropRectMinSize);
            boolean z3 = this.mTempRect.width() >= ((float) this.mCropRectMinSize);
            RectF rectF9 = this.mCropViewRect;
            rectF9.set(z3 ? this.mTempRect.left : rectF9.left, (z2 ? this.mTempRect : this.mCropViewRect).top, (z3 ? this.mTempRect : this.mCropViewRect).right, (z2 ? this.mTempRect : this.mCropViewRect).bottom);
            if (z2 || z3) {
                updateGridPoints();
                postInvalidate();
            }
            this.mPreviousTouchX = min;
            this.mPreviousTouchY = min2;
            return true;
        } else {
            if ((motionEvent.getAction() & InvitationReply.EXPIRED) == 1) {
                this.mPreviousTouchX = -1.0f;
                this.mPreviousTouchY = -1.0f;
                this.mCurrentTouchCornerIndex = -1;
                OverlayViewChangeListener overlayViewChangeListener = this.mCallback;
                if (overlayViewChangeListener != null) {
                    UCropView.this.mGestureCropImageView.setCropRect(this.mCropViewRect);
                }
            }
            return false;
        }
    }

    public void setCircleDimmedLayer(boolean z) {
        this.mCircleDimmedLayer = z;
    }

    public void setCropFrameColor(int i) {
        this.mCropFramePaint.setColor(i);
    }

    public void setCropFrameStrokeWidth(int i) {
        this.mCropFramePaint.setStrokeWidth((float) i);
    }

    public void setCropGridColor(int i) {
        this.mCropGridPaint.setColor(i);
    }

    public void setCropGridColumnCount(int i) {
        this.mCropGridColumnCount = i;
        this.mGridPoints = null;
    }

    public void setCropGridRowCount(int i) {
        this.mCropGridRowCount = i;
        this.mGridPoints = null;
    }

    public void setCropGridStrokeWidth(int i) {
        this.mCropGridPaint.setStrokeWidth((float) i);
    }

    public void setDimmedColor(int i) {
        this.mDimmedColor = i;
    }

    @Deprecated
    public void setFreestyleCropEnabled(boolean z) {
        this.mFreestyleCropMode = z ? 1 : 0;
    }

    public void setFreestyleCropMode(int i) {
        this.mFreestyleCropMode = i;
        postInvalidate();
    }

    public void setOverlayViewChangeListener(OverlayViewChangeListener overlayViewChangeListener) {
        this.mCallback = overlayViewChangeListener;
    }

    public void setShowCropFrame(boolean z) {
        this.mShowCropFrame = z;
    }

    public void setShowCropGrid(boolean z) {
        this.mShowCropGrid = z;
    }

    public void setTargetAspectRatio(float f2) {
        this.mTargetAspectRatio = f2;
        int i = this.mThisWidth;
        if (i > 0) {
            int i2 = (int) (((float) i) / f2);
            int i3 = this.mThisHeight;
            if (i2 > i3) {
                int i4 = (int) (((float) i3) * f2);
                int i5 = (i - i4) / 2;
                this.mCropViewRect.set((float) (getPaddingLeft() + i5), (float) getPaddingTop(), (float) (getPaddingLeft() + i4 + i5), (float) (getPaddingTop() + this.mThisHeight));
            } else {
                int i6 = (i3 - i2) / 2;
                this.mCropViewRect.set((float) getPaddingLeft(), (float) (getPaddingTop() + i6), (float) (getPaddingLeft() + this.mThisWidth), (float) (getPaddingTop() + i2 + i6));
            }
            OverlayViewChangeListener overlayViewChangeListener = this.mCallback;
            if (overlayViewChangeListener != null) {
                UCropView.this.mGestureCropImageView.setCropRect(this.mCropViewRect);
            }
            updateGridPoints();
            postInvalidate();
            return;
        }
        this.mShouldSetupCropBounds = true;
    }

    public final void updateGridPoints() {
        this.mCropGridCorners = TweetUtils.getCornersFromRect(this.mCropViewRect);
        TweetUtils.getCenterFromRect(this.mCropViewRect);
        this.mGridPoints = null;
        this.mCircularPath.reset();
        this.mCircularPath.addCircle(this.mCropViewRect.centerX(), this.mCropViewRect.centerY(), Math.min(this.mCropViewRect.width(), this.mCropViewRect.height()) / 2.0f, Direction.CW);
    }

    public OverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCropViewRect = new RectF();
        this.mTempRect = new RectF();
        this.mGridPoints = null;
        this.mCircularPath = new Path();
        this.mDimmedStrokePaint = new Paint(1);
        this.mCropGridPaint = new Paint(1);
        this.mCropFramePaint = new Paint(1);
        this.mCropFrameCornersPaint = new Paint(1);
        this.mFreestyleCropMode = 0;
        this.mPreviousTouchX = -1.0f;
        this.mPreviousTouchY = -1.0f;
        this.mCurrentTouchCornerIndex = -1;
        this.mTouchPointThreshold = getResources().getDimensionPixelSize(R$dimen.ucrop_default_crop_rect_corner_touch_threshold);
        this.mCropRectMinSize = getResources().getDimensionPixelSize(R$dimen.ucrop_default_crop_rect_min_size);
        this.mCropRectCornerTouchAreaLineLength = getResources().getDimensionPixelSize(R$dimen.ucrop_default_crop_rect_corner_touch_area_line_length);
    }
}
