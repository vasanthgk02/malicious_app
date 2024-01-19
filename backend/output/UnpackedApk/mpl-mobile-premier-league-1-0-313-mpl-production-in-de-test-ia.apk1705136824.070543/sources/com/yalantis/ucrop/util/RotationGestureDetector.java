package com.yalantis.ucrop.util;

public class RotationGestureDetector {
    public float fX;
    public float fY;
    public float mAngle;
    public boolean mIsFirstTouch;
    public OnRotationGestureListener mListener;
    public int mPointerIndex1 = -1;
    public int mPointerIndex2 = -1;
    public float sX;
    public float sY;

    public interface OnRotationGestureListener {
    }

    public static class SimpleOnRotationGestureListener implements OnRotationGestureListener {
    }

    public RotationGestureDetector(OnRotationGestureListener onRotationGestureListener) {
        this.mListener = onRotationGestureListener;
    }
}
