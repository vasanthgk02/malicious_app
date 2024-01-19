package com.swmansion.gesturehandler.core;

import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 12\b\u0012\u0004\u0012\u00020\u00000\u0001:\u00011B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001aH\u0002J\b\u0010\u001e\u001a\u00020\u001aH\u0014J\u0018\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!H\u0014J\b\u0010#\u001a\u00020\u001aH\u0014J\b\u0010$\u001a\u00020\u001aH\u0016J\u000e\u0010%\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\nJ\u000e\u0010(\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\rJ\u000e\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\nJ\u000e\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\nJ\u000e\u0010-\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010.\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0004J\b\u0010/\u001a\u00020\u001cH\u0002J\b\u00100\u001a\u00020\u001aH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/swmansion/gesturehandler/core/TapGestureHandler;", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "()V", "currentMaxNumberOfPointers", "", "failDelayed", "Ljava/lang/Runnable;", "handler", "Landroid/os/Handler;", "lastX", "", "lastY", "maxDelayMs", "", "maxDeltaX", "maxDeltaY", "maxDistSq", "maxDurationMs", "minNumberOfPointers", "numberOfTaps", "offsetX", "offsetY", "startX", "startY", "tapsSoFar", "activate", "", "force", "", "endTap", "onCancel", "onHandle", "event", "Landroid/view/MotionEvent;", "sourceEvent", "onReset", "resetConfig", "setMaxDelayMs", "setMaxDist", "maxDist", "setMaxDurationMs", "setMaxDx", "deltaX", "setMaxDy", "deltaY", "setMinNumberOfPointers", "setNumberOfTaps", "shouldFail", "startTap", "Companion", "react-native-gesture-handler_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TapGestureHandler.kt */
public final class TapGestureHandler extends GestureHandler<TapGestureHandler> {
    public int currentMaxNumberOfPointers = 1;
    public final Runnable failDelayed = new Runnable() {
        public final void run() {
            TapGestureHandler.m56failDelayed$lambda0(TapGestureHandler.this);
        }
    };
    public Handler handler;
    public float lastX;
    public float lastY;
    public long maxDelayMs = 200;
    public float maxDeltaX = Float.MIN_VALUE;
    public float maxDeltaY = Float.MIN_VALUE;
    public float maxDistSq = Float.MIN_VALUE;
    public long maxDurationMs = 500;
    public int minNumberOfPointers = 1;
    public int numberOfTaps = 1;
    public float offsetX;
    public float offsetY;
    public float startX;
    public float startY;
    public int tapsSoFar;

    public TapGestureHandler() {
        this.shouldCancelWhenOutside = true;
    }

    /* renamed from: failDelayed$lambda-0  reason: not valid java name */
    public static final void m56failDelayed$lambda0(TapGestureHandler tapGestureHandler) {
        Intrinsics.checkNotNullParameter(tapGestureHandler, "this$0");
        tapGestureHandler.fail();
    }

    public void activate(boolean z) {
        super.activate(z);
        end();
    }

    public void onCancel() {
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:93:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0197  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onHandle(android.view.MotionEvent r13, android.view.MotionEvent r14) {
        /*
            r12 = this;
            java.lang.String r0 = "event"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r13 = "sourceEvent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r13)
            int r13 = r12.state
            int r1 = r14.getActionMasked()
            r2 = 0
            r3 = -1
            r4 = 0
            r5 = 6
            if (r13 != 0) goto L_0x006c
            r12.offsetX = r2
            r12.offsetY = r2
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            int r6 = r14.getActionMasked()
            if (r6 != r5) goto L_0x0028
            int r6 = r14.getActionIndex()
            goto L_0x0029
        L_0x0028:
            r6 = -1
        L_0x0029:
            int r7 = r14.getPointerCount()
            r8 = 0
            r9 = 0
            r10 = 0
        L_0x0030:
            if (r8 >= r7) goto L_0x003f
            int r11 = r8 + 1
            if (r8 == r6) goto L_0x003d
            float r8 = r14.getX(r8)
            float r10 = r10 + r8
            int r9 = r9 + 1
        L_0x003d:
            r8 = r11
            goto L_0x0030
        L_0x003f:
            float r6 = (float) r9
            float r10 = r10 / r6
            r12.startX = r10
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            int r6 = r14.getActionMasked()
            if (r6 != r5) goto L_0x0051
            int r6 = r14.getActionIndex()
            goto L_0x0052
        L_0x0051:
            r6 = -1
        L_0x0052:
            int r7 = r14.getPointerCount()
            r8 = 0
            r9 = 0
            r10 = 0
        L_0x0059:
            if (r8 >= r7) goto L_0x0068
            int r11 = r8 + 1
            if (r8 == r6) goto L_0x0066
            float r8 = r14.getY(r8)
            float r10 = r10 + r8
            int r9 = r9 + 1
        L_0x0066:
            r8 = r11
            goto L_0x0059
        L_0x0068:
            float r6 = (float) r9
            float r10 = r10 / r6
            r12.startY = r10
        L_0x006c:
            r6 = 5
            if (r1 == r6) goto L_0x00c2
            if (r1 == r5) goto L_0x00c2
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            int r6 = r14.getActionMasked()
            if (r6 != r5) goto L_0x007f
            int r6 = r14.getActionIndex()
            goto L_0x0080
        L_0x007f:
            r6 = -1
        L_0x0080:
            int r7 = r14.getPointerCount()
            r8 = 0
            r9 = 0
            r10 = 0
        L_0x0087:
            if (r8 >= r7) goto L_0x0096
            int r11 = r8 + 1
            if (r8 == r6) goto L_0x0094
            float r8 = r14.getX(r8)
            float r10 = r10 + r8
            int r9 = r9 + 1
        L_0x0094:
            r8 = r11
            goto L_0x0087
        L_0x0096:
            float r6 = (float) r9
            float r10 = r10 / r6
            r12.lastX = r10
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            int r0 = r14.getActionMasked()
            if (r0 != r5) goto L_0x00a7
            int r3 = r14.getActionIndex()
        L_0x00a7:
            int r0 = r14.getPointerCount()
            r5 = 0
            r6 = 0
        L_0x00ad:
            if (r5 >= r0) goto L_0x00bd
            int r7 = r5 + 1
            if (r5 == r3) goto L_0x00bb
            float r5 = r14.getY(r5)
            float r5 = r5 + r2
            int r6 = r6 + 1
            r2 = r5
        L_0x00bb:
            r5 = r7
            goto L_0x00ad
        L_0x00bd:
            float r0 = (float) r6
            float r2 = r2 / r0
            r12.lastY = r2
            goto L_0x012c
        L_0x00c2:
            float r6 = r12.offsetX
            float r7 = r12.lastX
            float r8 = r12.startX
            float r7 = r7 - r8
            float r7 = r7 + r6
            r12.offsetX = r7
            float r6 = r12.offsetY
            float r7 = r12.lastY
            float r8 = r12.startY
            float r7 = r7 - r8
            float r7 = r7 + r6
            r12.offsetY = r7
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            int r6 = r14.getActionMasked()
            if (r6 != r5) goto L_0x00e4
            int r6 = r14.getActionIndex()
            goto L_0x00e5
        L_0x00e4:
            r6 = -1
        L_0x00e5:
            int r7 = r14.getPointerCount()
            r8 = 0
            r9 = 0
            r10 = 0
        L_0x00ec:
            if (r8 >= r7) goto L_0x00fb
            int r11 = r8 + 1
            if (r8 == r6) goto L_0x00f9
            float r8 = r14.getX(r8)
            float r10 = r10 + r8
            int r9 = r9 + 1
        L_0x00f9:
            r8 = r11
            goto L_0x00ec
        L_0x00fb:
            float r6 = (float) r9
            float r10 = r10 / r6
            r12.lastX = r10
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            int r0 = r14.getActionMasked()
            if (r0 != r5) goto L_0x010c
            int r3 = r14.getActionIndex()
        L_0x010c:
            int r0 = r14.getPointerCount()
            r5 = 0
            r6 = 0
        L_0x0112:
            if (r5 >= r0) goto L_0x0122
            int r7 = r5 + 1
            if (r5 == r3) goto L_0x0120
            float r5 = r14.getY(r5)
            float r5 = r5 + r2
            int r6 = r6 + 1
            r2 = r5
        L_0x0120:
            r5 = r7
            goto L_0x0112
        L_0x0122:
            float r0 = (float) r6
            float r2 = r2 / r0
            r12.lastY = r2
            float r0 = r12.lastX
            r12.startX = r0
            r12.startY = r2
        L_0x012c:
            int r0 = r12.currentMaxNumberOfPointers
            int r2 = r14.getPointerCount()
            if (r0 >= r2) goto L_0x013a
            int r14 = r14.getPointerCount()
            r12.currentMaxNumberOfPointers = r14
        L_0x013a:
            float r14 = r12.lastX
            float r0 = r12.startX
            float r14 = r14 - r0
            float r0 = r12.offsetX
            float r14 = r14 + r0
            float r0 = r12.maxDeltaX
            r2 = 1
            r3 = 1
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x014c
            r0 = 1
            goto L_0x014d
        L_0x014c:
            r0 = 0
        L_0x014d:
            if (r0 != 0) goto L_0x015a
            float r0 = java.lang.Math.abs(r14)
            float r5 = r12.maxDeltaX
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 <= 0) goto L_0x015a
            goto L_0x018e
        L_0x015a:
            float r0 = r12.lastY
            float r5 = r12.startY
            float r0 = r0 - r5
            float r5 = r12.offsetY
            float r0 = r0 + r5
            float r5 = r12.maxDeltaY
            int r5 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r5 != 0) goto L_0x016a
            r5 = 1
            goto L_0x016b
        L_0x016a:
            r5 = 0
        L_0x016b:
            if (r5 != 0) goto L_0x0178
            float r5 = java.lang.Math.abs(r0)
            float r6 = r12.maxDeltaY
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 <= 0) goto L_0x0178
            goto L_0x018e
        L_0x0178:
            float r0 = r0 * r0
            float r14 = r14 * r14
            float r14 = r14 + r0
            float r0 = r12.maxDistSq
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x0185
            r0 = 1
            goto L_0x0186
        L_0x0185:
            r0 = 0
        L_0x0186:
            if (r0 != 0) goto L_0x0190
            float r0 = r12.maxDistSq
            int r14 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r14 <= 0) goto L_0x0190
        L_0x018e:
            r14 = 1
            goto L_0x0191
        L_0x0190:
            r14 = 0
        L_0x0191:
            if (r14 == 0) goto L_0x0197
            r12.fail()
            goto L_0x01e7
        L_0x0197:
            if (r13 != 0) goto L_0x01a2
            if (r1 != 0) goto L_0x019e
            r12.begin()
        L_0x019e:
            r12.startTap()
            goto L_0x01e7
        L_0x01a2:
            r14 = 2
            if (r13 != r14) goto L_0x01e7
            if (r1 == 0) goto L_0x01e4
            if (r1 == r3) goto L_0x01aa
            goto L_0x01e7
        L_0x01aa:
            android.os.Handler r13 = r12.handler
            if (r13 != 0) goto L_0x01ba
            android.os.Handler r13 = new android.os.Handler
            android.os.Looper r14 = android.os.Looper.getMainLooper()
            r13.<init>(r14)
            r12.handler = r13
            goto L_0x01c1
        L_0x01ba:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
            r14 = 0
            r13.removeCallbacksAndMessages(r14)
        L_0x01c1:
            int r13 = r12.tapsSoFar
            int r13 = r13 + r3
            r12.tapsSoFar = r13
            int r14 = r12.numberOfTaps
            if (r13 != r14) goto L_0x01d7
            int r13 = r12.currentMaxNumberOfPointers
            int r14 = r12.minNumberOfPointers
            if (r13 < r14) goto L_0x01d7
            super.activate(r4)
            r12.end()
            goto L_0x01e7
        L_0x01d7:
            android.os.Handler r13 = r12.handler
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
            java.lang.Runnable r14 = r12.failDelayed
            long r0 = r12.maxDelayMs
            r13.postDelayed(r14, r0)
            goto L_0x01e7
        L_0x01e4:
            r12.startTap()
        L_0x01e7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.gesturehandler.core.TapGestureHandler.onHandle(android.view.MotionEvent, android.view.MotionEvent):void");
    }

    public void onReset() {
        this.tapsSoFar = 0;
        this.currentMaxNumberOfPointers = 0;
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
        }
    }

    public void resetConfig() {
        super.resetConfig();
        this.maxDeltaX = Float.MIN_VALUE;
        this.maxDeltaY = Float.MIN_VALUE;
        this.maxDistSq = Float.MIN_VALUE;
        this.maxDurationMs = 500;
        this.maxDelayMs = 200;
        this.numberOfTaps = 1;
        this.minNumberOfPointers = 1;
    }

    public final void startTap() {
        Handler handler2 = this.handler;
        if (handler2 == null) {
            this.handler = new Handler(Looper.getMainLooper());
        } else {
            Intrinsics.checkNotNull(handler2);
            handler2.removeCallbacksAndMessages(null);
        }
        Handler handler3 = this.handler;
        Intrinsics.checkNotNull(handler3);
        handler3.postDelayed(this.failDelayed, this.maxDurationMs);
    }
}
