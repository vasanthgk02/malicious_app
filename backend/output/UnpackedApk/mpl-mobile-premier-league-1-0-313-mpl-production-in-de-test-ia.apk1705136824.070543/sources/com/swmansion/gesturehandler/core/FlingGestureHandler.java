package com.swmansion.gesturehandler.core;

import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001%B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u0018H\u0014J\u0018\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001dH\u0014J\b\u0010!\u001a\u00020\u0018H\u0014J\b\u0010\"\u001a\u00020\u0018H\u0016J\u0010\u0010#\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010$\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eXD¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/swmansion/gesturehandler/core/FlingGestureHandler;", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "()V", "direction", "", "getDirection", "()I", "setDirection", "(I)V", "failDelayed", "Ljava/lang/Runnable;", "handler", "Landroid/os/Handler;", "maxDurationMs", "", "maxNumberOfPointersSimultaneously", "minAcceptableDelta", "numberOfPointersRequired", "getNumberOfPointersRequired", "setNumberOfPointersRequired", "startX", "", "startY", "activate", "", "force", "", "endFling", "event", "Landroid/view/MotionEvent;", "onCancel", "onHandle", "sourceEvent", "onReset", "resetConfig", "startFling", "tryEndFling", "Companion", "react-native-gesture-handler_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlingGestureHandler.kt */
public final class FlingGestureHandler extends GestureHandler<FlingGestureHandler> {
    public int direction = 1;
    public final Runnable failDelayed = new Runnable() {
        public final void run() {
            FlingGestureHandler.m51failDelayed$lambda0(FlingGestureHandler.this);
        }
    };
    public Handler handler;
    public final long maxDurationMs = 800;
    public int maxNumberOfPointersSimultaneously;
    public final long minAcceptableDelta = 160;
    public int numberOfPointersRequired = 1;
    public float startX;
    public float startY;

    /* renamed from: failDelayed$lambda-0  reason: not valid java name */
    public static final void m51failDelayed$lambda0(FlingGestureHandler flingGestureHandler) {
        Intrinsics.checkNotNullParameter(flingGestureHandler, "this$0");
        flingGestureHandler.fail();
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

    public void onHandle(MotionEvent motionEvent, MotionEvent motionEvent2) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        Intrinsics.checkNotNullParameter(motionEvent2, "sourceEvent");
        int i = this.state;
        if (i == 0) {
            this.startX = motionEvent2.getRawX();
            this.startY = motionEvent2.getRawY();
            begin();
            this.maxNumberOfPointersSimultaneously = 1;
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
        if (i == 2) {
            tryEndFling(motionEvent2);
            if (motionEvent2.getPointerCount() > this.maxNumberOfPointersSimultaneously) {
                this.maxNumberOfPointersSimultaneously = motionEvent2.getPointerCount();
            }
            if (motionEvent2.getActionMasked() == 1 && !tryEndFling(motionEvent2)) {
                fail();
            }
        }
    }

    public void onReset() {
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
        }
    }

    public void resetConfig() {
        super.resetConfig();
        this.numberOfPointersRequired = 1;
        this.direction = 1;
    }

    public final boolean tryEndFling(MotionEvent motionEvent) {
        if (this.maxNumberOfPointersSimultaneously != this.numberOfPointersRequired || (((this.direction & 1) == 0 || motionEvent.getRawX() - this.startX <= ((float) this.minAcceptableDelta)) && (((this.direction & 2) == 0 || this.startX - motionEvent.getRawX() <= ((float) this.minAcceptableDelta)) && (((this.direction & 4) == 0 || this.startY - motionEvent.getRawY() <= ((float) this.minAcceptableDelta)) && ((this.direction & 8) == 0 || motionEvent.getRawY() - this.startY <= ((float) this.minAcceptableDelta)))))) {
            return false;
        }
        Handler handler2 = this.handler;
        Intrinsics.checkNotNull(handler2);
        handler2.removeCallbacksAndMessages(null);
        activate(false);
        return true;
    }
}
