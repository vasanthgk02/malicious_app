package com.swmansion.gesturehandler.core;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.views.textinput.ReactEditText;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0003\u0019\u001a\u001bB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0014J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0014J\b\u0010\u0011\u001a\u00020\fH\u0014J\b\u0010\u0012\u001a\u00020\fH\u0014J\b\u0010\u0013\u001a\u00020\fH\u0016J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0004J\u0014\u0010\u0016\u001a\u00020\u00042\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0016J\u0014\u0010\u0018\u001a\u00020\u00042\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0016R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler;", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "()V", "<set-?>", "", "disallowInterruption", "getDisallowInterruption", "()Z", "hook", "Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler$NativeViewGestureHandlerHook;", "shouldActivateOnStart", "onCancel", "", "onHandle", "event", "Landroid/view/MotionEvent;", "sourceEvent", "onPrepare", "onReset", "resetConfig", "setDisallowInterruption", "setShouldActivateOnStart", "shouldBeCancelledBy", "handler", "shouldRecognizeSimultaneously", "Companion", "EditTextHook", "NativeViewGestureHandlerHook", "react-native-gesture-handler_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NativeViewGestureHandler.kt */
public final class NativeViewGestureHandler extends GestureHandler<NativeViewGestureHandler> {
    public static final Companion Companion = new Companion(null);
    public static final NativeViewGestureHandler$Companion$defaultHook$1 defaultHook = new NativeViewGestureHandler$Companion$defaultHook$1();
    public boolean disallowInterruption;
    public NativeViewGestureHandlerHook hook = defaultHook;
    public boolean shouldActivateOnStart;

    @Metadata(d1 = {"\u0000%\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u0010\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\f"}, d2 = {"Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler$Companion;", "", "()V", "defaultHook", "com/swmansion/gesturehandler/core/NativeViewGestureHandler$Companion$defaultHook$1", "Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler$Companion$defaultHook$1;", "tryIntercept", "", "view", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "react-native-gesture-handler_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: NativeViewGestureHandler.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0014\u0010\u0013\u001a\u00020\u00122\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler$EditTextHook;", "Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler$NativeViewGestureHandlerHook;", "handler", "Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler;", "editText", "Lcom/facebook/react/views/textinput/ReactEditText;", "(Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler;Lcom/facebook/react/views/textinput/ReactEditText;)V", "startX", "", "startY", "touchSlopSquared", "", "afterGestureEnd", "", "event", "Landroid/view/MotionEvent;", "handleEventBeforeActivation", "shouldCancelRootViewGestureHandlerIfNecessary", "", "shouldRecognizeSimultaneously", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "wantsToHandleEventBeforeActivation", "react-native-gesture-handler_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: NativeViewGestureHandler.kt */
    public static final class EditTextHook implements NativeViewGestureHandlerHook {
        public final ReactEditText editText;
        public final NativeViewGestureHandler handler;
        public float startX;
        public float startY;
        public int touchSlopSquared;

        public EditTextHook(NativeViewGestureHandler nativeViewGestureHandler, ReactEditText reactEditText) {
            Intrinsics.checkNotNullParameter(nativeViewGestureHandler, "handler");
            Intrinsics.checkNotNullParameter(reactEditText, "editText");
            this.handler = nativeViewGestureHandler;
            this.editText = reactEditText;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(reactEditText.getContext());
            this.touchSlopSquared = viewConfiguration.getScaledTouchSlop() * viewConfiguration.getScaledTouchSlop();
        }

        public void afterGestureEnd(MotionEvent motionEvent) {
            Intrinsics.checkNotNullParameter(motionEvent, "event");
            float x = (motionEvent.getX() - this.startX) * (motionEvent.getX() - this.startX);
            if (GeneratedOutlineSupport.outline3(motionEvent.getY(), this.startY, motionEvent.getY() - this.startY, x) < ((float) this.touchSlopSquared)) {
                this.editText.requestFocusInternal();
            }
        }

        public boolean canBegin() {
            Intrinsics.checkNotNullParameter(this, "this");
            return true;
        }

        public void handleEventBeforeActivation(MotionEvent motionEvent) {
            Intrinsics.checkNotNullParameter(motionEvent, "event");
            this.handler.activate(false);
            this.editText.onTouchEvent(motionEvent);
            this.startX = motionEvent.getX();
            this.startY = motionEvent.getY();
        }

        public boolean shouldCancelRootViewGestureHandlerIfNecessary() {
            return true;
        }

        public boolean shouldRecognizeSimultaneously(GestureHandler<?> gestureHandler) {
            Intrinsics.checkNotNullParameter(gestureHandler, "handler");
            return gestureHandler.tag > 0 && !(gestureHandler instanceof NativeViewGestureHandler);
        }

        public boolean wantsToHandleEventBeforeActivation() {
            return true;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\u0014\u0010\n\u001a\u00020\u00072\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016¨\u0006\u000e"}, d2 = {"Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler$NativeViewGestureHandlerHook;", "", "afterGestureEnd", "", "event", "Landroid/view/MotionEvent;", "canBegin", "", "handleEventBeforeActivation", "shouldCancelRootViewGestureHandlerIfNecessary", "shouldRecognizeSimultaneously", "handler", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "wantsToHandleEventBeforeActivation", "react-native-gesture-handler_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: NativeViewGestureHandler.kt */
    public interface NativeViewGestureHandlerHook {
        void afterGestureEnd(MotionEvent motionEvent);

        boolean canBegin();

        void handleEventBeforeActivation(MotionEvent motionEvent);

        boolean shouldCancelRootViewGestureHandlerIfNecessary();

        boolean shouldRecognizeSimultaneously(GestureHandler<?> gestureHandler);

        boolean wantsToHandleEventBeforeActivation();
    }

    public NativeViewGestureHandler() {
        this.shouldCancelWhenOutside = true;
    }

    public void onCancel() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        obtain.setAction(3);
        View view = this.view;
        Intrinsics.checkNotNull(view);
        view.onTouchEvent(obtain);
    }

    public void onHandle(MotionEvent motionEvent, MotionEvent motionEvent2) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        Intrinsics.checkNotNullParameter(motionEvent2, "sourceEvent");
        View view = this.view;
        Intrinsics.checkNotNull(view);
        boolean z = true;
        if (motionEvent.getActionMasked() == 1) {
            view.onTouchEvent(motionEvent);
            int i = this.state;
            if ((i == 0 || i == 2) && view.isPressed()) {
                activate(false);
            }
            end();
            this.hook.afterGestureEnd(motionEvent);
            return;
        }
        int i2 = this.state;
        if (i2 == 0 || i2 == 2) {
            if (this.shouldActivateOnStart) {
                if (view instanceof ViewGroup) {
                    ((ViewGroup) view).onInterceptTouchEvent(motionEvent);
                }
                view.onTouchEvent(motionEvent);
                activate(false);
                return;
            }
            if (!(view instanceof ViewGroup) || !((ViewGroup) view).onInterceptTouchEvent(motionEvent)) {
                z = false;
            }
            if (z) {
                view.onTouchEvent(motionEvent);
                activate(false);
            } else if (this.hook.wantsToHandleEventBeforeActivation()) {
                this.hook.handleEventBeforeActivation(motionEvent);
            } else if (this.state == 2) {
            } else {
                if (this.hook.canBegin()) {
                    begin();
                } else {
                    cancel();
                }
            }
        } else if (i2 == 4) {
            view.onTouchEvent(motionEvent);
        }
    }

    public void onPrepare() {
        View view = this.view;
        if (view instanceof NativeViewGestureHandlerHook) {
            this.hook = (NativeViewGestureHandlerHook) view;
        } else if (view instanceof ReactEditText) {
            this.hook = new EditTextHook(this, (ReactEditText) view);
        }
    }

    public void onReset() {
        this.hook = defaultHook;
    }

    public void resetConfig() {
        super.resetConfig();
        this.shouldActivateOnStart = false;
        this.disallowInterruption = false;
    }

    public boolean shouldBeCancelledBy(GestureHandler<?> gestureHandler) {
        Intrinsics.checkNotNullParameter(gestureHandler, "handler");
        return !this.disallowInterruption;
    }

    public boolean shouldRecognizeSimultaneously(GestureHandler<?> gestureHandler) {
        Intrinsics.checkNotNullParameter(gestureHandler, "handler");
        boolean z = true;
        if (!super.shouldRecognizeSimultaneously(gestureHandler) && !this.hook.shouldRecognizeSimultaneously(gestureHandler)) {
            if ((gestureHandler instanceof NativeViewGestureHandler) && gestureHandler.state == 4 && ((NativeViewGestureHandler) gestureHandler).disallowInterruption) {
                return false;
            }
            boolean z2 = !this.disallowInterruption;
            int i = gestureHandler.state;
            if ((this.state == 4 && i == 4 && z2) || this.state != 4 || !z2 || (this.hook.shouldCancelRootViewGestureHandlerIfNecessary() && gestureHandler.tag <= 0)) {
                z = false;
            }
        }
        return z;
    }
}
