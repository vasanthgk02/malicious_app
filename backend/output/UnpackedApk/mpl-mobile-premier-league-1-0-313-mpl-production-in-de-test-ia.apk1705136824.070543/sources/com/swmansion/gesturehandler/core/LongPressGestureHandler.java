package com.swmansion.gesturehandler.core;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.MotionEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001&B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\bH\u0016J\u0018\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001bH\u0014J\u0018\u0010!\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\bH\u0014J\b\u0010#\u001a\u00020\u0019H\u0016J\u000e\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/swmansion/gesturehandler/core/LongPressGestureHandler;", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "defaultMaxDistSq", "", "duration", "", "getDuration", "()I", "handler", "Landroid/os/Handler;", "maxDistSq", "minDurationMs", "", "getMinDurationMs", "()J", "setMinDurationMs", "(J)V", "previousTime", "startTime", "startX", "startY", "dispatchHandlerUpdate", "", "event", "Landroid/view/MotionEvent;", "dispatchStateChange", "newState", "prevState", "onHandle", "sourceEvent", "onStateChange", "previousState", "resetConfig", "setMaxDist", "maxDist", "Companion", "react-native-gesture-handler_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LongPressGestureHandler.kt */
public final class LongPressGestureHandler extends GestureHandler<LongPressGestureHandler> {
    public final float defaultMaxDistSq;
    public Handler handler;
    public float maxDistSq;
    public long minDurationMs = 500;
    public long previousTime;
    public long startTime;
    public float startX;
    public float startY;

    public LongPressGestureHandler(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.shouldCancelWhenOutside = true;
        float f2 = context.getResources().getDisplayMetrics().density * 10.0f;
        float f3 = f2 * f2;
        this.defaultMaxDistSq = f3;
        this.maxDistSq = f3;
    }

    /* renamed from: onHandle$lambda-0  reason: not valid java name */
    public static final void m54onHandle$lambda0(LongPressGestureHandler longPressGestureHandler) {
        Intrinsics.checkNotNullParameter(longPressGestureHandler, "this$0");
        longPressGestureHandler.activate(false);
    }

    public void dispatchHandlerUpdate(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        this.previousTime = SystemClock.uptimeMillis();
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        OnTouchEventListener onTouchEventListener = this.onTouchEventListener;
        if (onTouchEventListener != null) {
            onTouchEventListener.onHandlerUpdate(this, motionEvent);
        }
    }

    public void dispatchStateChange(int i, int i2) {
        this.previousTime = SystemClock.uptimeMillis();
        OnTouchEventListener onTouchEventListener = this.onTouchEventListener;
        if (onTouchEventListener != null) {
            onTouchEventListener.onStateChange(this, i, i2);
        }
    }

    public void onHandle(MotionEvent motionEvent, MotionEvent motionEvent2) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        Intrinsics.checkNotNullParameter(motionEvent2, "sourceEvent");
        if (this.state == 0) {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.previousTime = uptimeMillis;
            this.startTime = uptimeMillis;
            begin();
            this.startX = motionEvent2.getRawX();
            this.startY = motionEvent2.getRawY();
            Handler handler2 = new Handler(Looper.getMainLooper());
            this.handler = handler2;
            int i = (this.minDurationMs > 0 ? 1 : (this.minDurationMs == 0 ? 0 : -1));
            if (i > 0) {
                Intrinsics.checkNotNull(handler2);
                handler2.postDelayed(new Runnable() {
                    public final void run() {
                        LongPressGestureHandler.m54onHandle$lambda0(LongPressGestureHandler.this);
                    }
                }, this.minDurationMs);
            } else if (i == 0) {
                activate(false);
            }
        }
        if (motionEvent2.getActionMasked() == 1) {
            Handler handler3 = this.handler;
            if (handler3 != null) {
                handler3.removeCallbacksAndMessages(null);
                this.handler = null;
            }
            if (this.state == 4) {
                end();
            } else {
                fail();
            }
        } else {
            float rawX = motionEvent2.getRawX() - this.startX;
            float rawY = motionEvent2.getRawY() - this.startY;
            if ((rawY * rawY) + (rawX * rawX) <= this.maxDistSq) {
                return;
            }
            if (this.state == 4) {
                cancel();
            } else {
                fail();
            }
        }
    }

    public void onStateChange(int i, int i2) {
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
            this.handler = null;
        }
    }

    public void resetConfig() {
        super.resetConfig();
        this.minDurationMs = 500;
        this.maxDistSq = this.defaultMaxDistSq;
    }
}
