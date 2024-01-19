package com.swmansion.gesturehandler.core;

import android.graphics.PointF;
import android.view.MotionEvent;
import com.swmansion.gesturehandler.core.RotationGestureDetector.OnRotationGestureListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0014J\b\u0010\u001c\u001a\u00020\u0015H\u0014J\b\u0010\u001d\u001a\u00020\u0015H\u0016R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/swmansion/gesturehandler/core/RotationGestureHandler;", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "()V", "<set-?>", "", "anchorX", "getAnchorX", "()F", "anchorY", "getAnchorY", "gestureListener", "Lcom/swmansion/gesturehandler/core/RotationGestureDetector$OnRotationGestureListener;", "", "rotation", "getRotation", "()D", "rotationGestureDetector", "Lcom/swmansion/gesturehandler/core/RotationGestureDetector;", "velocity", "getVelocity", "activate", "", "force", "", "onHandle", "event", "Landroid/view/MotionEvent;", "sourceEvent", "onReset", "resetProgress", "Companion", "react-native-gesture-handler_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RotationGestureHandler.kt */
public final class RotationGestureHandler extends GestureHandler<RotationGestureHandler> {
    public float anchorX = Float.NaN;
    public float anchorY = Float.NaN;
    public final OnRotationGestureListener gestureListener;
    public double rotation;
    public RotationGestureDetector rotationGestureDetector;
    public double velocity;

    public RotationGestureHandler() {
        this.shouldCancelWhenOutside = false;
        this.gestureListener = new RotationGestureHandler$gestureListener$1(this);
    }

    public void activate(boolean z) {
        if (this.state != 4) {
            resetProgress();
        }
        super.activate(z);
    }

    public void onHandle(MotionEvent motionEvent, MotionEvent motionEvent2) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        Intrinsics.checkNotNullParameter(motionEvent2, "sourceEvent");
        if (this.state == 0) {
            resetProgress();
            this.rotationGestureDetector = new RotationGestureDetector(this.gestureListener);
            this.anchorX = motionEvent.getX();
            this.anchorY = motionEvent.getY();
            begin();
        }
        RotationGestureDetector rotationGestureDetector2 = this.rotationGestureDetector;
        if (rotationGestureDetector2 != null) {
            Intrinsics.checkNotNullParameter(motionEvent2, "event");
            int actionMasked = motionEvent2.getActionMasked();
            if (actionMasked == 0) {
                rotationGestureDetector2.isInProgress = false;
                rotationGestureDetector2.pointerIds[0] = motionEvent2.getPointerId(motionEvent2.getActionIndex());
                rotationGestureDetector2.pointerIds[1] = -1;
            } else if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 5) {
                        if (actionMasked == 6 && rotationGestureDetector2.isInProgress) {
                            int pointerId = motionEvent2.getPointerId(motionEvent2.getActionIndex());
                            int[] iArr = rotationGestureDetector2.pointerIds;
                            if ((pointerId == iArr[0] || pointerId == iArr[1]) && rotationGestureDetector2.isInProgress) {
                                rotationGestureDetector2.isInProgress = false;
                                OnRotationGestureListener onRotationGestureListener = rotationGestureDetector2.gestureListener;
                                if (onRotationGestureListener != null) {
                                    onRotationGestureListener.onRotationEnd(rotationGestureDetector2);
                                }
                            }
                        }
                    } else if (!rotationGestureDetector2.isInProgress) {
                        rotationGestureDetector2.pointerIds[1] = motionEvent2.getPointerId(motionEvent2.getActionIndex());
                        rotationGestureDetector2.isInProgress = true;
                        rotationGestureDetector2.previousTime = motionEvent2.getEventTime();
                        rotationGestureDetector2.previousAngle = Double.NaN;
                        rotationGestureDetector2.updateCurrent(motionEvent2);
                        OnRotationGestureListener onRotationGestureListener2 = rotationGestureDetector2.gestureListener;
                        if (onRotationGestureListener2 != null) {
                            onRotationGestureListener2.onRotationBegin(rotationGestureDetector2);
                        }
                    }
                } else if (rotationGestureDetector2.isInProgress) {
                    rotationGestureDetector2.updateCurrent(motionEvent2);
                    OnRotationGestureListener onRotationGestureListener3 = rotationGestureDetector2.gestureListener;
                    if (onRotationGestureListener3 != null) {
                        onRotationGestureListener3.onRotation(rotationGestureDetector2);
                    }
                }
            } else if (rotationGestureDetector2.isInProgress) {
                rotationGestureDetector2.isInProgress = false;
                OnRotationGestureListener onRotationGestureListener4 = rotationGestureDetector2.gestureListener;
                if (onRotationGestureListener4 != null) {
                    onRotationGestureListener4.onRotationEnd(rotationGestureDetector2);
                }
            }
        }
        RotationGestureDetector rotationGestureDetector3 = this.rotationGestureDetector;
        if (rotationGestureDetector3 != null) {
            PointF transformPoint = transformPoint(new PointF(rotationGestureDetector3.anchorX, rotationGestureDetector3.anchorY));
            this.anchorX = transformPoint.x;
            this.anchorY = transformPoint.y;
        }
        if (motionEvent2.getActionMasked() != 1) {
            return;
        }
        if (this.state == 4) {
            end();
        } else {
            fail();
        }
    }

    public void onReset() {
        this.rotationGestureDetector = null;
        this.anchorX = Float.NaN;
        this.anchorY = Float.NaN;
        resetProgress();
    }

    public void resetProgress() {
        this.velocity = 0.0d;
        this.rotation = 0.0d;
    }
}
