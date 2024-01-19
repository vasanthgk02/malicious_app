package com.userexperior.models.recording;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;

public class d extends ScaleGestureDetector {

    /* renamed from: b  reason: collision with root package name */
    public static final String f4076b = d.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public MotionEvent f4077a;

    /* renamed from: c  reason: collision with root package name */
    public OnScaleGestureListener f4078c = new OnScaleGestureListener() {
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            return false;
        }

        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return false;
        }

        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }
    };

    public d(Context context, OnScaleGestureListener onScaleGestureListener) {
        super(context, onScaleGestureListener);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        if (super.isInProgress()) {
            new StringBuilder("updating event ").append(motionEvent.getPointerCount());
            new StringBuilder("updating event ").append(motionEvent.getDownTime());
            this.f4077a = motionEvent;
        }
        return super.onTouchEvent(motionEvent);
    }
}
