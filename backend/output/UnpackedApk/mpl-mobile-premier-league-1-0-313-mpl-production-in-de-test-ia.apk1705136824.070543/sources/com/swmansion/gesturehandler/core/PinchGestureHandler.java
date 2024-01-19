package com.swmansion.gesturehandler.core;

import com.swmansion.gesturehandler.core.ScaleGestureDetector.OnScaleGestureListener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0014J\b\u0010\u001e\u001a\u00020\u0017H\u0014J\b\u0010\u001f\u001a\u00020\u0017H\u0016R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000f¨\u0006 "}, d2 = {"Lcom/swmansion/gesturehandler/core/PinchGestureHandler;", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "()V", "<set-?>", "", "focalPointX", "getFocalPointX", "()F", "focalPointY", "getFocalPointY", "gestureListener", "Lcom/swmansion/gesturehandler/core/ScaleGestureDetector$OnScaleGestureListener;", "", "scale", "getScale", "()D", "scaleGestureDetector", "Lcom/swmansion/gesturehandler/core/ScaleGestureDetector;", "spanSlop", "startingSpan", "velocity", "getVelocity", "activate", "", "force", "", "onHandle", "event", "Landroid/view/MotionEvent;", "sourceEvent", "onReset", "resetProgress", "react-native-gesture-handler_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PinchGestureHandler.kt */
public final class PinchGestureHandler extends GestureHandler<PinchGestureHandler> {
    public float focalPointX = Float.NaN;
    public float focalPointY = Float.NaN;
    public final OnScaleGestureListener gestureListener = new PinchGestureHandler$gestureListener$1(this);
    public double scale;
    public ScaleGestureDetector scaleGestureDetector;
    public float spanSlop;
    public float startingSpan;
    public double velocity;

    public void activate(boolean z) {
        if (this.state != 4) {
            resetProgress();
        }
        super.activate(z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a6, code lost:
        if (r11 != false) goto L_0x01e5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onHandle(android.view.MotionEvent r19, android.view.MotionEvent r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r20
            java.lang.String r2 = "event"
            r3 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r2)
            java.lang.String r2 = "sourceEvent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            int r2 = r0.state
            if (r2 != 0) goto L_0x0043
            android.view.View r2 = r0.view
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            android.content.Context r2 = r2.getContext()
            r18.resetProgress()
            com.swmansion.gesturehandler.core.ScaleGestureDetector r4 = new com.swmansion.gesturehandler.core.ScaleGestureDetector
            com.swmansion.gesturehandler.core.ScaleGestureDetector$OnScaleGestureListener r5 = r0.gestureListener
            r4.<init>(r2, r5)
            r0.scaleGestureDetector = r4
            android.view.ViewConfiguration r2 = android.view.ViewConfiguration.get(r2)
            int r2 = r2.getScaledTouchSlop()
            float r2 = (float) r2
            r0.spanSlop = r2
            float r2 = r19.getX()
            r0.focalPointX = r2
            float r2 = r19.getY()
            r0.focalPointY = r2
            r18.begin()
        L_0x0043:
            com.swmansion.gesturehandler.core.ScaleGestureDetector r2 = r0.scaleGestureDetector
            r3 = 6
            r4 = 2
            r5 = 1
            if (r2 != 0) goto L_0x004c
            goto L_0x01e5
        L_0x004c:
            long r6 = r20.getEventTime()
            r2.mCurrTime = r6
            int r6 = r20.getActionMasked()
            boolean r7 = r2.mQuickScaleEnabled
            if (r7 == 0) goto L_0x005f
            android.view.GestureDetector r7 = r2.mGestureDetector
            r7.onTouchEvent(r1)
        L_0x005f:
            int r7 = r20.getPointerCount()
            int r8 = r20.getButtonState()
            r8 = r8 & 32
            r9 = 0
            if (r8 == 0) goto L_0x006e
            r8 = 1
            goto L_0x006f
        L_0x006e:
            r8 = 0
        L_0x006f:
            int r10 = r2.mAnchoredScaleMode
            if (r10 != r4) goto L_0x0077
            if (r8 != 0) goto L_0x0077
            r10 = 1
            goto L_0x0078
        L_0x0077:
            r10 = 0
        L_0x0078:
            if (r6 == r5) goto L_0x0082
            r11 = 3
            if (r6 == r11) goto L_0x0082
            if (r10 == 0) goto L_0x0080
            goto L_0x0082
        L_0x0080:
            r11 = 0
            goto L_0x0083
        L_0x0082:
            r11 = 1
        L_0x0083:
            r12 = 0
            if (r6 == 0) goto L_0x0088
            if (r11 == 0) goto L_0x00aa
        L_0x0088:
            boolean r13 = r2.mInProgress
            if (r13 == 0) goto L_0x0098
            com.swmansion.gesturehandler.core.ScaleGestureDetector$OnScaleGestureListener r13 = r2.mListener
            r13.onScaleEnd(r2)
            r2.mInProgress = r9
            r2.mInitialSpan = r12
            r2.mAnchoredScaleMode = r9
            goto L_0x00a6
        L_0x0098:
            boolean r13 = r2.inAnchoredScaleMode()
            if (r13 == 0) goto L_0x00a6
            if (r11 == 0) goto L_0x00a6
            r2.mInProgress = r9
            r2.mInitialSpan = r12
            r2.mAnchoredScaleMode = r9
        L_0x00a6:
            if (r11 == 0) goto L_0x00aa
            goto L_0x01e5
        L_0x00aa:
            boolean r13 = r2.mInProgress
            if (r13 != 0) goto L_0x00cc
            boolean r13 = r2.mStylusScaleEnabled
            if (r13 == 0) goto L_0x00cc
            boolean r13 = r2.inAnchoredScaleMode()
            if (r13 != 0) goto L_0x00cc
            if (r11 != 0) goto L_0x00cc
            if (r8 == 0) goto L_0x00cc
            float r8 = r20.getX()
            r2.mAnchoredScaleStartX = r8
            float r8 = r20.getY()
            r2.mAnchoredScaleStartY = r8
            r2.mAnchoredScaleMode = r4
            r2.mInitialSpan = r12
        L_0x00cc:
            if (r6 == 0) goto L_0x00d8
            if (r6 == r3) goto L_0x00d8
            r8 = 5
            if (r6 == r8) goto L_0x00d8
            if (r10 == 0) goto L_0x00d6
            goto L_0x00d8
        L_0x00d6:
            r8 = 0
            goto L_0x00d9
        L_0x00d8:
            r8 = 1
        L_0x00d9:
            if (r6 != r3) goto L_0x00dd
            r10 = 1
            goto L_0x00de
        L_0x00dd:
            r10 = 0
        L_0x00de:
            if (r10 == 0) goto L_0x00e5
            int r11 = r20.getActionIndex()
            goto L_0x00e6
        L_0x00e5:
            r11 = -1
        L_0x00e6:
            if (r10 == 0) goto L_0x00eb
            int r10 = r7 + -1
            goto L_0x00ec
        L_0x00eb:
            r10 = r7
        L_0x00ec:
            boolean r13 = r2.inAnchoredScaleMode()
            if (r13 == 0) goto L_0x0104
            float r13 = r2.mAnchoredScaleStartX
            float r14 = r2.mAnchoredScaleStartY
            float r15 = r20.getY()
            int r15 = (r15 > r14 ? 1 : (r15 == r14 ? 0 : -1))
            if (r15 >= 0) goto L_0x0101
            r2.mEventBeforeOrAboveStartingGestureEvent = r5
            goto L_0x0124
        L_0x0101:
            r2.mEventBeforeOrAboveStartingGestureEvent = r9
            goto L_0x0124
        L_0x0104:
            r13 = 0
            r14 = 0
            r15 = 0
        L_0x0107:
            if (r13 >= r7) goto L_0x011b
            if (r11 != r13) goto L_0x010c
            goto L_0x0118
        L_0x010c:
            float r16 = r1.getX(r13)
            float r14 = r16 + r14
            float r16 = r1.getY(r13)
            float r15 = r16 + r15
        L_0x0118:
            int r13 = r13 + 1
            goto L_0x0107
        L_0x011b:
            float r13 = (float) r10
            float r14 = r14 / r13
            float r13 = r15 / r13
            r17 = r14
            r14 = r13
            r13 = r17
        L_0x0124:
            r5 = 0
            r15 = 0
        L_0x0126:
            if (r5 >= r7) goto L_0x0147
            if (r11 != r5) goto L_0x012b
            goto L_0x0144
        L_0x012b:
            float r16 = r1.getX(r5)
            float r16 = r16 - r13
            float r16 = java.lang.Math.abs(r16)
            float r16 = r16 + r12
            float r12 = r1.getY(r5)
            float r12 = r12 - r14
            float r12 = java.lang.Math.abs(r12)
            float r12 = r12 + r15
            r15 = r12
            r12 = r16
        L_0x0144:
            int r5 = r5 + 1
            goto L_0x0126
        L_0x0147:
            float r5 = (float) r10
            float r12 = r12 / r5
            float r15 = r15 / r5
            r5 = 1073741824(0x40000000, float:2.0)
            float r12 = r12 * r5
            float r15 = r15 * r5
            boolean r5 = r2.inAnchoredScaleMode()
            if (r5 == 0) goto L_0x0158
            r3 = r15
            goto L_0x015f
        L_0x0158:
            double r10 = (double) r12
            double r3 = (double) r15
            double r3 = java.lang.Math.hypot(r10, r3)
            float r3 = (float) r3
        L_0x015f:
            boolean r4 = r2.mInProgress
            r2.mFocusX = r13
            r2.mFocusY = r14
            boolean r10 = r2.inAnchoredScaleMode()
            if (r10 != 0) goto L_0x0181
            boolean r10 = r2.mInProgress
            if (r10 == 0) goto L_0x0181
            int r10 = r2.mMinSpan
            float r10 = (float) r10
            int r10 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r10 < 0) goto L_0x0178
            if (r8 == 0) goto L_0x0181
        L_0x0178:
            com.swmansion.gesturehandler.core.ScaleGestureDetector$OnScaleGestureListener r10 = r2.mListener
            r10.onScaleEnd(r2)
            r2.mInProgress = r9
            r2.mInitialSpan = r3
        L_0x0181:
            if (r8 == 0) goto L_0x018d
            r2.mCurrSpanX = r12
            r2.mCurrSpanY = r15
            r2.mCurrSpan = r3
            r2.mPrevSpan = r3
            r2.mInitialSpan = r3
        L_0x018d:
            boolean r8 = r2.inAnchoredScaleMode()
            if (r8 == 0) goto L_0x0196
            int r8 = r2.mSpanSlop
            goto L_0x0198
        L_0x0196:
            int r8 = r2.mMinSpan
        L_0x0198:
            boolean r9 = r2.mInProgress
            if (r9 != 0) goto L_0x01c6
            float r8 = (float) r8
            int r8 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r8 < 0) goto L_0x01c6
            if (r4 != 0) goto L_0x01b2
            float r4 = r2.mInitialSpan
            float r4 = r3 - r4
            float r4 = java.lang.Math.abs(r4)
            int r8 = r2.mSpanSlop
            float r8 = (float) r8
            int r4 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r4 <= 0) goto L_0x01c6
        L_0x01b2:
            r2.mCurrSpanX = r12
            r2.mCurrSpanY = r15
            r2.mCurrSpan = r3
            r2.mPrevSpan = r3
            long r8 = r2.mCurrTime
            r2.mPrevTime = r8
            com.swmansion.gesturehandler.core.ScaleGestureDetector$OnScaleGestureListener r4 = r2.mListener
            boolean r4 = r4.onScaleBegin(r2)
            r2.mInProgress = r4
        L_0x01c6:
            r4 = 2
            if (r6 != r4) goto L_0x01e5
            r2.mCurrSpanX = r12
            r2.mCurrSpanY = r15
            r2.mCurrSpan = r3
            boolean r3 = r2.mInProgress
            if (r3 == 0) goto L_0x01da
            com.swmansion.gesturehandler.core.ScaleGestureDetector$OnScaleGestureListener r3 = r2.mListener
            boolean r3 = r3.onScale(r2)
            goto L_0x01db
        L_0x01da:
            r3 = 1
        L_0x01db:
            if (r3 == 0) goto L_0x01e5
            float r3 = r2.mCurrSpan
            r2.mPrevSpan = r3
            long r3 = r2.mCurrTime
            r2.mPrevTime = r3
        L_0x01e5:
            com.swmansion.gesturehandler.core.ScaleGestureDetector r2 = r0.scaleGestureDetector
            if (r2 != 0) goto L_0x01ea
            goto L_0x01ff
        L_0x01ea:
            android.graphics.PointF r3 = new android.graphics.PointF
            float r4 = r2.mFocusX
            float r2 = r2.mFocusY
            r3.<init>(r4, r2)
            android.graphics.PointF r2 = r0.transformPoint(r3)
            float r3 = r2.x
            r0.focalPointX = r3
            float r2 = r2.y
            r0.focalPointY = r2
        L_0x01ff:
            int r2 = r20.getPointerCount()
            int r3 = r20.getActionMasked()
            r4 = 6
            if (r3 != r4) goto L_0x020c
            int r2 = r2 + -1
        L_0x020c:
            int r3 = r0.state
            r4 = 4
            if (r3 != r4) goto L_0x0218
            r3 = 2
            if (r2 >= r3) goto L_0x0218
            r18.end()
            goto L_0x0222
        L_0x0218:
            int r1 = r20.getActionMasked()
            r2 = 1
            if (r1 != r2) goto L_0x0222
            r18.fail()
        L_0x0222:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.gesturehandler.core.PinchGestureHandler.onHandle(android.view.MotionEvent, android.view.MotionEvent):void");
    }

    public void onReset() {
        this.scaleGestureDetector = null;
        this.focalPointX = Float.NaN;
        this.focalPointY = Float.NaN;
        resetProgress();
    }

    public void resetProgress() {
        this.velocity = 0.0d;
        this.scale = 1.0d;
    }
}
