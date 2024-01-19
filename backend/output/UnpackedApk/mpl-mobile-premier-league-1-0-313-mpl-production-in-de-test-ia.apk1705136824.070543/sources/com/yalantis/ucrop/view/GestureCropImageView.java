package com.yalantis.ucrop.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import android.widget.ImageView.ScaleType;
import com.yalantis.ucrop.util.RotationGestureDetector;
import com.yalantis.ucrop.util.RotationGestureDetector.OnRotationGestureListener;
import com.yalantis.ucrop.util.RotationGestureDetector.SimpleOnRotationGestureListener;
import com.yalantis.ucrop.view.CropImageView.ZoomImageToPosition;
import sfs2x.client.entities.invitation.InvitationReply;

public class GestureCropImageView extends CropImageView {
    public int mDoubleTapScaleSteps;
    public GestureDetector mGestureDetector;
    public boolean mIsRotateEnabled;
    public boolean mIsScaleEnabled;
    public float mMidPntX;
    public float mMidPntY;
    public RotationGestureDetector mRotateDetector;
    public ScaleGestureDetector mScaleDetector;

    public class GestureListener extends SimpleOnGestureListener {
        public GestureListener(AnonymousClass1 r2) {
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            GestureCropImageView gestureCropImageView = GestureCropImageView.this;
            float doubleTapTargetScale = gestureCropImageView.getDoubleTapTargetScale();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (doubleTapTargetScale > gestureCropImageView.getMaxScale()) {
                doubleTapTargetScale = gestureCropImageView.getMaxScale();
            }
            float currentScale = gestureCropImageView.getCurrentScale();
            ZoomImageToPosition zoomImageToPosition = new ZoomImageToPosition(gestureCropImageView, 200, currentScale, doubleTapTargetScale - currentScale, x, y);
            gestureCropImageView.mZoomImageToPositionRunnable = zoomImageToPosition;
            gestureCropImageView.post(zoomImageToPosition);
            return super.onDoubleTap(motionEvent);
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            GestureCropImageView.this.postTranslate(-f2, -f3);
            return true;
        }
    }

    public class RotateListener extends SimpleOnRotationGestureListener {
        public RotateListener(AnonymousClass1 r2) {
        }
    }

    public class ScaleListener extends SimpleOnScaleGestureListener {
        public ScaleListener(AnonymousClass1 r2) {
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            GestureCropImageView gestureCropImageView = GestureCropImageView.this;
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            GestureCropImageView gestureCropImageView2 = GestureCropImageView.this;
            gestureCropImageView.postScale(scaleFactor, gestureCropImageView2.mMidPntX, gestureCropImageView2.mMidPntY);
            return true;
        }
    }

    public GestureCropImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public int getDoubleTapScaleSteps() {
        return this.mDoubleTapScaleSteps;
    }

    public float getDoubleTapTargetScale() {
        return getCurrentScale() * ((float) Math.pow((double) (getMaxScale() / getMinScale()), (double) (1.0f / ((float) this.mDoubleTapScaleSteps))));
    }

    public void init() {
        setScaleType(ScaleType.MATRIX);
        this.mGestureDetector = new GestureDetector(getContext(), new GestureListener(null), null, true);
        this.mScaleDetector = new ScaleGestureDetector(getContext(), new ScaleListener(null));
        this.mRotateDetector = new RotationGestureDetector(new RotateListener(null));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & InvitationReply.EXPIRED) == 0) {
            cancelAllAnimations();
        }
        if (motionEvent.getPointerCount() > 1) {
            this.mMidPntX = (motionEvent.getX(1) + motionEvent.getX(0)) / 2.0f;
            this.mMidPntY = (motionEvent.getY(1) + motionEvent.getY(0)) / 2.0f;
        }
        this.mGestureDetector.onTouchEvent(motionEvent);
        if (this.mIsScaleEnabled) {
            this.mScaleDetector.onTouchEvent(motionEvent);
        }
        if (this.mIsRotateEnabled) {
            RotationGestureDetector rotationGestureDetector = this.mRotateDetector;
            if (rotationGestureDetector != null) {
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked == 0) {
                    rotationGestureDetector.sX = motionEvent.getX();
                    rotationGestureDetector.sY = motionEvent.getY();
                    rotationGestureDetector.mPointerIndex1 = motionEvent.findPointerIndex(motionEvent.getPointerId(0));
                    rotationGestureDetector.mAngle = 0.0f;
                    rotationGestureDetector.mIsFirstTouch = true;
                } else if (actionMasked == 1) {
                    rotationGestureDetector.mPointerIndex1 = -1;
                } else if (actionMasked != 2) {
                    if (actionMasked == 5) {
                        rotationGestureDetector.fX = motionEvent.getX();
                        rotationGestureDetector.fY = motionEvent.getY();
                        rotationGestureDetector.mPointerIndex2 = motionEvent.findPointerIndex(motionEvent.getPointerId(motionEvent.getActionIndex()));
                        rotationGestureDetector.mAngle = 0.0f;
                        rotationGestureDetector.mIsFirstTouch = true;
                    } else if (actionMasked == 6) {
                        rotationGestureDetector.mPointerIndex2 = -1;
                    }
                } else if (!(rotationGestureDetector.mPointerIndex1 == -1 || rotationGestureDetector.mPointerIndex2 == -1 || motionEvent.getPointerCount() <= rotationGestureDetector.mPointerIndex2)) {
                    float x = motionEvent.getX(rotationGestureDetector.mPointerIndex1);
                    float y = motionEvent.getY(rotationGestureDetector.mPointerIndex1);
                    float x2 = motionEvent.getX(rotationGestureDetector.mPointerIndex2);
                    float y2 = motionEvent.getY(rotationGestureDetector.mPointerIndex2);
                    if (rotationGestureDetector.mIsFirstTouch) {
                        rotationGestureDetector.mAngle = 0.0f;
                        rotationGestureDetector.mIsFirstTouch = false;
                    } else {
                        float f2 = rotationGestureDetector.fX;
                        float degrees = (((float) Math.toDegrees((double) ((float) Math.atan2((double) (y2 - y), (double) (x2 - x))))) % 360.0f) - (((float) Math.toDegrees((double) ((float) Math.atan2((double) (rotationGestureDetector.fY - rotationGestureDetector.sY), (double) (f2 - rotationGestureDetector.sX))))) % 360.0f);
                        rotationGestureDetector.mAngle = degrees;
                        if (degrees < -180.0f) {
                            rotationGestureDetector.mAngle = degrees + 360.0f;
                        } else if (degrees > 180.0f) {
                            rotationGestureDetector.mAngle = degrees - 360.0f;
                        }
                    }
                    OnRotationGestureListener onRotationGestureListener = rotationGestureDetector.mListener;
                    if (onRotationGestureListener != null) {
                        GestureCropImageView gestureCropImageView = GestureCropImageView.this;
                        gestureCropImageView.postRotate(rotationGestureDetector.mAngle, gestureCropImageView.mMidPntX, gestureCropImageView.mMidPntY);
                    }
                    rotationGestureDetector.fX = x2;
                    rotationGestureDetector.fY = y2;
                    rotationGestureDetector.sX = x;
                    rotationGestureDetector.sY = y;
                }
            } else {
                throw null;
            }
        }
        if ((motionEvent.getAction() & InvitationReply.EXPIRED) == 1) {
            setImageToWrapCropBounds(true);
        }
        return true;
    }

    public void setDoubleTapScaleSteps(int i) {
        this.mDoubleTapScaleSteps = i;
    }

    public void setRotateEnabled(boolean z) {
        this.mIsRotateEnabled = z;
    }

    public void setScaleEnabled(boolean z) {
        this.mIsScaleEnabled = z;
    }

    public GestureCropImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsRotateEnabled = true;
        this.mIsScaleEnabled = true;
        this.mDoubleTapScaleSteps = 5;
    }
}
