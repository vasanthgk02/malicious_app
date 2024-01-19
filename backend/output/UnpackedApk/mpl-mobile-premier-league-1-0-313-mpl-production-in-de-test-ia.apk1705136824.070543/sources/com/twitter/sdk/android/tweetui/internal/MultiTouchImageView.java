package com.twitter.sdk.android.tweetui.internal;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import com.twitter.sdk.android.tweetui.internal.SwipeToDismissTouchListener.SwipeableViewProvider;

public class MultiTouchImageView extends ImageView implements SwipeableViewProvider {
    public boolean allowIntercept;
    public final Matrix baseMatrix;
    public final Matrix drawMatrix;
    public final RectF drawRect;
    public final GestureDetector gestureDetector;
    public final float[] matrixValues;
    public final ScaleGestureDetector scaleGestureDetector;
    public final Matrix updateMatrix;
    public final RectF viewRect;

    public MultiTouchImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void animateScale(float f2, float f3, float f4, float f5) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f2, f3});
        ofFloat.setDuration(300);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new AnimatorUpdateListener(f4, f5) {
            public final /* synthetic */ float f$1;
            public final /* synthetic */ float f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                MultiTouchImageView.this.lambda$animateScale$0$MultiTouchImageView(this.f$1, this.f$2, valueAnimator);
            }
        });
        ofFloat.start();
    }

    public boolean canBeSwiped() {
        return getScale() == 1.0f;
    }

    public Matrix getDrawMatrix() {
        this.drawMatrix.set(this.baseMatrix);
        this.drawMatrix.postConcat(this.updateMatrix);
        return this.drawMatrix;
    }

    public float getScale() {
        this.updateMatrix.getValues(this.matrixValues);
        return this.matrixValues[0];
    }

    public /* synthetic */ void lambda$animateScale$0$MultiTouchImageView(float f2, float f3, ValueAnimator valueAnimator) {
        setScale(((Float) valueAnimator.getAnimatedValue()).floatValue() / getScale(), f2, f3);
        setImageMatrix();
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        Drawable drawable = getDrawable();
        if (drawable != null && drawable.getIntrinsicWidth() > 0) {
            this.viewRect.set((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getWidth() - getPaddingRight()), (float) (getHeight() - getPaddingBottom()));
            Drawable drawable2 = getDrawable();
            RectF rectF = new RectF(0.0f, 0.0f, (float) drawable2.getIntrinsicWidth(), (float) drawable2.getIntrinsicHeight());
            this.baseMatrix.reset();
            this.baseMatrix.setRectToRect(rectF, this.viewRect, ScaleToFit.CENTER);
            setImageMatrix();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        Drawable drawable = getDrawable();
        boolean z = true;
        if (!(drawable != null && drawable.getIntrinsicWidth() > 0)) {
            return false;
        }
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        if (!(this.gestureDetector.onTouchEvent(motionEvent) || this.scaleGestureDetector.onTouchEvent(motionEvent)) && !super.onTouchEvent(motionEvent)) {
            z = false;
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x007f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setImageMatrix() {
        /*
            r7 = this;
            android.graphics.Matrix r0 = r7.getDrawMatrix()
            android.graphics.drawable.Drawable r1 = r7.getDrawable()
            r2 = 0
            if (r1 == 0) goto L_0x001f
            android.graphics.RectF r3 = r7.drawRect
            int r4 = r1.getIntrinsicWidth()
            float r4 = (float) r4
            int r1 = r1.getIntrinsicHeight()
            float r1 = (float) r1
            r3.set(r2, r2, r4, r1)
            android.graphics.RectF r1 = r7.drawRect
            r0.mapRect(r1)
        L_0x001f:
            android.graphics.RectF r0 = r7.drawRect
            float r1 = r0.height()
            android.graphics.RectF r3 = r7.viewRect
            float r3 = r3.height()
            r4 = 1073741824(0x40000000, float:2.0)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x0040
            android.graphics.RectF r1 = r7.viewRect
            float r1 = r1.height()
            float r3 = r0.height()
            float r1 = r1 - r3
            float r1 = r1 / r4
            float r3 = r0.top
            goto L_0x005c
        L_0x0040:
            float r1 = r0.top
            int r3 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r3 <= 0) goto L_0x0048
            float r1 = -r1
            goto L_0x005f
        L_0x0048:
            float r1 = r0.bottom
            android.graphics.RectF r3 = r7.viewRect
            float r3 = r3.height()
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 >= 0) goto L_0x005e
            android.graphics.RectF r1 = r7.viewRect
            float r1 = r1.height()
            float r3 = r0.bottom
        L_0x005c:
            float r1 = r1 - r3
            goto L_0x005f
        L_0x005e:
            r1 = 0
        L_0x005f:
            float r3 = r0.width()
            android.graphics.RectF r5 = r7.viewRect
            float r5 = r5.width()
            r6 = 1
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 > 0) goto L_0x007f
            r7.allowIntercept = r6
            android.graphics.RectF r2 = r7.viewRect
            float r2 = r2.width()
            float r3 = r0.width()
            float r2 = r2 - r3
            float r2 = r2 / r4
            float r0 = r0.left
            goto L_0x009f
        L_0x007f:
            float r3 = r0.left
            int r4 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x0089
            r7.allowIntercept = r6
            float r2 = -r3
            goto L_0x00a4
        L_0x0089:
            float r3 = r0.right
            android.graphics.RectF r4 = r7.viewRect
            float r4 = r4.width()
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 >= 0) goto L_0x00a1
            r7.allowIntercept = r6
            android.graphics.RectF r2 = r7.viewRect
            float r2 = r2.width()
            float r0 = r0.right
        L_0x009f:
            float r2 = r2 - r0
            goto L_0x00a4
        L_0x00a1:
            r0 = 0
            r7.allowIntercept = r0
        L_0x00a4:
            android.graphics.Matrix r0 = r7.updateMatrix
            r0.postTranslate(r2, r1)
            android.widget.ImageView$ScaleType r0 = android.widget.ImageView.ScaleType.MATRIX
            r7.setScaleType(r0)
            android.graphics.Matrix r0 = r7.getDrawMatrix()
            r7.setImageMatrix(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.tweetui.internal.MultiTouchImageView.setImageMatrix():void");
    }

    public void setScale(float f2, float f3, float f4) {
        this.updateMatrix.postScale(f2, f2, f3, f4);
    }

    public MultiTouchImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.drawMatrix = new Matrix();
        this.baseMatrix = new Matrix();
        this.updateMatrix = new Matrix();
        this.viewRect = new RectF();
        this.drawRect = new RectF();
        this.matrixValues = new float[9];
        this.scaleGestureDetector = new ScaleGestureDetector(context, new SimpleOnScaleGestureListener() {
            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                MultiTouchImageView multiTouchImageView = MultiTouchImageView.this;
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                multiTouchImageView.updateMatrix.postScale(scaleFactor, scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                MultiTouchImageView.this.setImageMatrix();
                return true;
            }

            public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
                if (MultiTouchImageView.this.getScale() < 1.0f) {
                    MultiTouchImageView.this.updateMatrix.reset();
                    MultiTouchImageView.this.setImageMatrix();
                }
            }
        });
        this.gestureDetector = new GestureDetector(context, new SimpleOnGestureListener() {
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (MultiTouchImageView.this.getScale() > 1.0f) {
                    MultiTouchImageView multiTouchImageView = MultiTouchImageView.this;
                    multiTouchImageView.animateScale(multiTouchImageView.getScale(), 1.0f, motionEvent.getX(), motionEvent.getY());
                } else {
                    MultiTouchImageView multiTouchImageView2 = MultiTouchImageView.this;
                    multiTouchImageView2.animateScale(multiTouchImageView2.getScale(), 2.0f, motionEvent.getX(), motionEvent.getY());
                }
                return true;
            }

            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                MultiTouchImageView.this.updateMatrix.postTranslate(-f2, -f3);
                MultiTouchImageView.this.setImageMatrix();
                MultiTouchImageView multiTouchImageView = MultiTouchImageView.this;
                if (multiTouchImageView.allowIntercept && !multiTouchImageView.scaleGestureDetector.isInProgress()) {
                    ViewParent parent = MultiTouchImageView.this.getParent();
                    if (parent != null) {
                        parent.requestDisallowInterceptTouchEvent(false);
                    }
                }
                return true;
            }
        });
    }
}
