package com.swmansion.gesturehandler.core;

import android.view.MotionEvent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001!B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u000e\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0010\u0010 \u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0013@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\""}, d2 = {"Lcom/swmansion/gesturehandler/core/RotationGestureDetector;", "", "gestureListener", "Lcom/swmansion/gesturehandler/core/RotationGestureDetector$OnRotationGestureListener;", "(Lcom/swmansion/gesturehandler/core/RotationGestureDetector$OnRotationGestureListener;)V", "<set-?>", "", "anchorX", "getAnchorX", "()F", "anchorY", "getAnchorY", "currentTime", "", "isInProgress", "", "pointerIds", "", "previousAngle", "", "previousTime", "rotation", "getRotation", "()D", "timeDelta", "getTimeDelta", "()J", "finish", "", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "updateCurrent", "OnRotationGestureListener", "react-native-gesture-handler_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RotationGestureDetector.kt */
public final class RotationGestureDetector {
    public float anchorX;
    public float anchorY;
    public long currentTime;
    public final OnRotationGestureListener gestureListener;
    public boolean isInProgress;
    public final int[] pointerIds = new int[2];
    public double previousAngle;
    public long previousTime;
    public double rotation;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\t"}, d2 = {"Lcom/swmansion/gesturehandler/core/RotationGestureDetector$OnRotationGestureListener;", "", "onRotation", "", "detector", "Lcom/swmansion/gesturehandler/core/RotationGestureDetector;", "onRotationBegin", "onRotationEnd", "", "react-native-gesture-handler_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RotationGestureDetector.kt */
    public interface OnRotationGestureListener {
        boolean onRotation(RotationGestureDetector rotationGestureDetector);

        boolean onRotationBegin(RotationGestureDetector rotationGestureDetector);

        void onRotationEnd(RotationGestureDetector rotationGestureDetector);
    }

    public RotationGestureDetector(OnRotationGestureListener onRotationGestureListener) {
        this.gestureListener = onRotationGestureListener;
    }

    public final void updateCurrent(MotionEvent motionEvent) {
        double d2;
        this.previousTime = this.currentTime;
        this.currentTime = motionEvent.getEventTime();
        int findPointerIndex = motionEvent.findPointerIndex(this.pointerIds[0]);
        int findPointerIndex2 = motionEvent.findPointerIndex(this.pointerIds[1]);
        float x = motionEvent.getX(findPointerIndex);
        float y = motionEvent.getY(findPointerIndex);
        float x2 = motionEvent.getX(findPointerIndex2);
        float y2 = motionEvent.getY(findPointerIndex2);
        float f2 = y2 - y;
        this.anchorX = (x + x2) * 0.5f;
        this.anchorY = (y + y2) * 0.5f;
        double d3 = -Math.atan2((double) f2, (double) (x2 - x));
        if (Double.isNaN(this.previousAngle)) {
            d2 = 0.0d;
        } else {
            d2 = this.previousAngle - d3;
        }
        this.rotation = d2;
        this.previousAngle = d3;
        if (d2 > 3.141592653589793d) {
            this.rotation = d2 - 3.141592653589793d;
        } else if (d2 < -3.141592653589793d) {
            this.rotation = d2 + 3.141592653589793d;
        }
        double d4 = this.rotation;
        if (d4 > 1.5707963267948966d) {
            this.rotation = d4 - 3.141592653589793d;
        } else if (d4 < -1.5707963267948966d) {
            this.rotation = d4 + 3.141592653589793d;
        }
    }
}
