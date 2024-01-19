package com.swmansion.gesturehandler.core;

import android.view.MotionEvent;
import com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/swmansion/gesturehandler/core/NativeViewGestureHandler$Companion$defaultHook$1", "Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler$NativeViewGestureHandlerHook;", "react-native-gesture-handler_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NativeViewGestureHandler.kt */
public final class NativeViewGestureHandler$Companion$defaultHook$1 implements NativeViewGestureHandlerHook {
    public void afterGestureEnd(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this, "this");
        Intrinsics.checkNotNullParameter(motionEvent, "event");
    }

    public boolean canBegin() {
        Intrinsics.checkNotNullParameter(this, "this");
        return true;
    }

    public void handleEventBeforeActivation(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this, "this");
        Intrinsics.checkNotNullParameter(motionEvent, "event");
    }

    public boolean shouldCancelRootViewGestureHandlerIfNecessary() {
        Intrinsics.checkNotNullParameter(this, "this");
        return false;
    }

    public boolean shouldRecognizeSimultaneously(GestureHandler<?> gestureHandler) {
        Intrinsics.checkNotNullParameter(this, "this");
        Intrinsics.checkNotNullParameter(gestureHandler, "handler");
        return false;
    }

    public boolean wantsToHandleEventBeforeActivation() {
        Intrinsics.checkNotNullParameter(this, "this");
        return false;
    }
}
