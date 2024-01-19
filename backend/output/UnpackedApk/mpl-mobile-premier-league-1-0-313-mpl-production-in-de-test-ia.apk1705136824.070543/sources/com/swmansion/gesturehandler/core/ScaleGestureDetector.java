package com.swmansion.gesturehandler.core;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

public class ScaleGestureDetector {
    public int mAnchoredScaleMode = 0;
    public float mAnchoredScaleStartX;
    public float mAnchoredScaleStartY;
    public final Context mContext;
    public float mCurrSpan;
    public float mCurrSpanX;
    public float mCurrSpanY;
    public long mCurrTime;
    public boolean mEventBeforeOrAboveStartingGestureEvent;
    public float mFocusX;
    public float mFocusY;
    public GestureDetector mGestureDetector;
    public final Handler mHandler;
    public boolean mInProgress;
    public float mInitialSpan;
    public final OnScaleGestureListener mListener;
    public int mMinSpan;
    public float mPrevSpan;
    public long mPrevTime;
    public boolean mQuickScaleEnabled;
    public int mSpanSlop;
    public boolean mStylusScaleEnabled;

    public interface OnScaleGestureListener {
        boolean onScale(ScaleGestureDetector scaleGestureDetector);

        boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector);

        void onScaleEnd(ScaleGestureDetector scaleGestureDetector);
    }

    public ScaleGestureDetector(Context context, OnScaleGestureListener onScaleGestureListener) {
        this.mContext = context;
        this.mListener = onScaleGestureListener;
        this.mSpanSlop = ViewConfiguration.get(context).getScaledTouchSlop() * 2;
        this.mMinSpan = 0;
        this.mHandler = null;
        int i = context.getApplicationInfo().targetSdkVersion;
        if (i > 18) {
            this.mQuickScaleEnabled = true;
            if (this.mGestureDetector == null) {
                this.mGestureDetector = new GestureDetector(this.mContext, new SimpleOnGestureListener() {
                    public boolean onDoubleTap(MotionEvent motionEvent) {
                        ScaleGestureDetector.this.mAnchoredScaleStartX = motionEvent.getX();
                        ScaleGestureDetector.this.mAnchoredScaleStartY = motionEvent.getY();
                        ScaleGestureDetector.this.mAnchoredScaleMode = 1;
                        return true;
                    }
                }, this.mHandler);
            }
        }
        if (i > 22) {
            this.mStylusScaleEnabled = true;
        }
    }

    public final boolean inAnchoredScaleMode() {
        return this.mAnchoredScaleMode != 0;
    }
}
