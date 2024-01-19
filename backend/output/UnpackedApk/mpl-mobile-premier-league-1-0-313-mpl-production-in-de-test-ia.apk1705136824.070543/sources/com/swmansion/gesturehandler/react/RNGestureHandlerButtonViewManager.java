package com.swmansion.gesturehandler.react;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Build.VERSION;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import androidx.core.view.ViewGroupKt$children$1;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerDelegate;
import com.swmansion.gesturehandler.core.GestureHandler;
import com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import sfs2x.client.requests.CreateRoomRequest;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003:\u0002$%B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006H\u0014J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0014J\u0018\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0017J\u0018\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0015H\u0017J\u0018\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0015H\u0017J\u0018\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0015H\u0017J\u0018\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0015H\u0017J\u001f\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0017¢\u0006\u0002\u0010\u001fJ\u0018\u0010 \u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u001eH\u0017J\u0018\u0010\"\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u0015H\u0017R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerButtonViewManager;", "Lcom/facebook/react/uimanager/ViewGroupManager;", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerButtonViewManager$ButtonViewGroup;", "Lcom/facebook/react/viewmanagers/RNGestureHandlerButtonManagerInterface;", "()V", "mDelegate", "Lcom/facebook/react/uimanager/ViewManagerDelegate;", "createViewInstance", "context", "Lcom/facebook/react/uimanager/ThemedReactContext;", "getDelegate", "getName", "", "onAfterUpdateTransaction", "", "view", "setBorderRadius", "borderRadius", "", "setBorderless", "useBorderlessDrawable", "", "setEnabled", "enabled", "setExclusive", "exclusive", "setForeground", "useDrawableOnForeground", "setRippleColor", "rippleColor", "", "(Lcom/swmansion/gesturehandler/react/RNGestureHandlerButtonViewManager$ButtonViewGroup;Ljava/lang/Integer;)V", "setRippleRadius", "rippleRadius", "setTouchSoundDisabled", "touchSoundDisabled", "ButtonViewGroup", "Companion", "react-native-gesture-handler_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@ReactModule(name = "RNGestureHandlerButton")
/* compiled from: RNGestureHandlerButtonViewManager.kt */
public final class RNGestureHandlerButtonViewManager extends ViewGroupManager<ButtonViewGroup> {
    public static final Companion Companion = new Companion(null);
    public static final String REACT_CLASS = "RNGestureHandlerButton";
    public final ViewManagerDelegate<ButtonViewGroup> mDelegate = new RNGestureHandlerButtonManagerDelegate(this);

    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 N2\u00020\u00012\u00020\u0002:\u0001NB\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020\u0010H\u0016J\b\u00101\u001a\u000202H\u0002J\u0018\u00103\u001a\u00020-2\u0006\u00104\u001a\u00020\t2\u0006\u00105\u001a\u00020\tH\u0016J\u0018\u00106\u001a\u00020-2\u0006\u00104\u001a\u00020\t2\u0006\u00105\u001a\u00020\tH\u0016J\u0018\u00107\u001a\u00020\u00102\u000e\b\u0002\u00108\u001a\b\u0012\u0004\u0012\u00020:09H\u0002J\u0010\u0010;\u001a\u00020\u00102\u0006\u0010<\u001a\u00020/H\u0016J0\u0010=\u001a\u00020-2\u0006\u0010>\u001a\u00020\u00102\u0006\u0010?\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u0007H\u0014J\u0010\u0010C\u001a\u00020\u00102\u0006\u0010.\u001a\u00020/H\u0017J\b\u0010D\u001a\u00020\u0010H\u0016J\u0010\u0010E\u001a\u00020-2\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J\u0010\u0010F\u001a\u00020-2\u0006\u0010G\u001a\u00020\u0010H\u0016J\b\u0010H\u001a\u00020-H\u0002J\b\u0010I\u001a\u00020\u0010H\u0002J\u0006\u0010J\u001a\u00020-J\u0017\u0010K\u001a\u00020-2\f\u0010L\u001a\b\u0012\u0004\u0012\u00020-0MH\bR\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R$\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u000e\u0010\u0017\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R*\u0010\u001c\u001a\u0004\u0018\u00010\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u0007@FX\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R*\u0010\"\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007@FX\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R\u001a\u0010%\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0012\"\u0004\b'\u0010\u0014R$\u0010)\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u0010@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0012\"\u0004\b+\u0010\u0014¨\u0006O"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerButtonViewManager$ButtonViewGroup;", "Landroid/view/ViewGroup;", "Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler$NativeViewGestureHandlerHook;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "_backgroundColor", "", "radius", "", "borderRadius", "getBorderRadius", "()F", "setBorderRadius", "(F)V", "exclusive", "", "getExclusive", "()Z", "setExclusive", "(Z)V", "isTouched", "setTouched", "lastAction", "lastEventTime", "", "needBackgroundUpdate", "color", "rippleColor", "getRippleColor", "()Ljava/lang/Integer;", "setRippleColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "rippleRadius", "getRippleRadius", "setRippleRadius", "useBorderlessDrawable", "getUseBorderlessDrawable", "setUseBorderlessDrawable", "useForeground", "useDrawableOnForeground", "getUseDrawableOnForeground", "setUseDrawableOnForeground", "afterGestureEnd", "", "event", "Landroid/view/MotionEvent;", "canBegin", "createSelectableDrawable", "Landroid/graphics/drawable/Drawable;", "dispatchDrawableHotspotChanged", "x", "y", "drawableHotspotChanged", "isChildTouched", "children", "Lkotlin/sequences/Sequence;", "Landroid/view/View;", "onInterceptTouchEvent", "ev", "onLayout", "changed", "l", "t", "r", "b", "onTouchEvent", "performClick", "setBackgroundColor", "setPressed", "pressed", "tryFreeingResponder", "tryGrabbingResponder", "updateBackground", "withBackgroundUpdate", "block", "Lkotlin/Function0;", "Companion", "react-native-gesture-handler_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RNGestureHandlerButtonViewManager.kt */
    public static final class ButtonViewGroup extends ViewGroup implements NativeViewGestureHandlerHook {
        public static OnClickListener dummyClickListener = $$Lambda$tCT3veGvBarcYTSN5NbqXtKuJA.INSTANCE;
        public static TypedValue resolveOutValue = new TypedValue();
        public static ButtonViewGroup soundResponder;
        public static ButtonViewGroup touchResponder;
        public int _backgroundColor;
        public float borderRadius;
        public boolean exclusive = true;
        public boolean isTouched;
        public int lastAction = -1;
        public long lastEventTime = -1;
        public boolean needBackgroundUpdate;
        public Integer rippleColor;
        public Integer rippleRadius;
        public boolean useBorderlessDrawable;
        public boolean useDrawableOnForeground;

        public ButtonViewGroup(Context context) {
            super(context);
            setOnClickListener(dummyClickListener);
            setClickable(true);
            setFocusable(true);
            this.needBackgroundUpdate = true;
        }

        /* renamed from: dummyClickListener$lambda-5  reason: not valid java name */
        public static final void m57dummyClickListener$lambda5(View view) {
        }

        public static boolean isChildTouched$default(ButtonViewGroup buttonViewGroup, Sequence sequence, int i) {
            ViewGroupKt$children$1 viewGroupKt$children$1;
            if ((i & 1) != 0) {
                Intrinsics.checkNotNullParameter(buttonViewGroup, "<this>");
                viewGroupKt$children$1 = new ViewGroupKt$children$1(buttonViewGroup);
            } else {
                viewGroupKt$children$1 = null;
            }
            return buttonViewGroup.isChildTouched(viewGroupKt$children$1);
        }

        public void afterGestureEnd(MotionEvent motionEvent) {
            Intrinsics.checkNotNullParameter(motionEvent, "event");
            tryFreeingResponder();
            this.isTouched = false;
        }

        public boolean canBegin() {
            boolean tryGrabbingResponder = tryGrabbingResponder();
            if (tryGrabbingResponder) {
                this.isTouched = true;
            }
            return tryGrabbingResponder;
        }

        public void dispatchDrawableHotspotChanged(float f2, float f3) {
        }

        public void drawableHotspotChanged(float f2, float f3) {
            ButtonViewGroup buttonViewGroup = touchResponder;
            if (buttonViewGroup == null || buttonViewGroup == this) {
                super.drawableHotspotChanged(f2, f3);
            }
        }

        public final float getBorderRadius() {
            return this.borderRadius;
        }

        public final boolean getExclusive() {
            return this.exclusive;
        }

        public final Integer getRippleColor() {
            return this.rippleColor;
        }

        public final Integer getRippleRadius() {
            return this.rippleRadius;
        }

        public final boolean getUseBorderlessDrawable() {
            return this.useBorderlessDrawable;
        }

        public final boolean getUseDrawableOnForeground() {
            return this.useDrawableOnForeground;
        }

        public void handleEventBeforeActivation(MotionEvent motionEvent) {
            Intrinsics.checkNotNullParameter(this, "this");
            Intrinsics.checkNotNullParameter(motionEvent, "event");
        }

        public final boolean isChildTouched(Sequence<? extends View> sequence) {
            for (View view : sequence) {
                if (view instanceof ButtonViewGroup) {
                    ButtonViewGroup buttonViewGroup = (ButtonViewGroup) view;
                    if (buttonViewGroup.isTouched || buttonViewGroup.isPressed()) {
                        return true;
                    }
                }
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    Intrinsics.checkNotNullParameter(viewGroup, "<this>");
                    if (isChildTouched(new ViewGroupKt$children$1(viewGroup))) {
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            Intrinsics.checkNotNullParameter(motionEvent, CreateRoomRequest.KEY_EVENTS);
            if (super.onInterceptTouchEvent(motionEvent)) {
                return true;
            }
            onTouchEvent(motionEvent);
            return isPressed();
        }

        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        }

        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(MotionEvent motionEvent) {
            Intrinsics.checkNotNullParameter(motionEvent, "event");
            if (motionEvent.getAction() == 3) {
                tryFreeingResponder();
            }
            long eventTime = motionEvent.getEventTime();
            int action = motionEvent.getAction();
            if (this.lastEventTime == eventTime && this.lastAction == action) {
                return false;
            }
            this.lastEventTime = eventTime;
            this.lastAction = action;
            return super.onTouchEvent(motionEvent);
        }

        public boolean performClick() {
            if (isChildTouched$default(this, null, 1) || !Intrinsics.areEqual(soundResponder, this)) {
                return false;
            }
            tryFreeingResponder();
            soundResponder = null;
            return super.performClick();
        }

        public void setBackgroundColor(int i) {
            this._backgroundColor = i;
            this.needBackgroundUpdate = true;
        }

        public final void setBorderRadius(float f2) {
            this.borderRadius = f2 * getResources().getDisplayMetrics().density;
            this.needBackgroundUpdate = true;
        }

        public final void setExclusive(boolean z) {
            this.exclusive = z;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0022, code lost:
            if (isChildTouched$default(r3, null, 1) == false) goto L_0x0026;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void setPressed(boolean r4) {
            /*
                r3 = this;
                if (r4 == 0) goto L_0x000a
                boolean r0 = r3.tryGrabbingResponder()
                if (r0 == 0) goto L_0x000a
                soundResponder = r3
            L_0x000a:
                boolean r0 = r3.exclusive
                r1 = 1
                r2 = 0
                if (r0 != 0) goto L_0x0025
                com.swmansion.gesturehandler.react.RNGestureHandlerButtonViewManager$ButtonViewGroup r0 = touchResponder
                if (r0 != 0) goto L_0x0016
            L_0x0014:
                r0 = 0
                goto L_0x001b
            L_0x0016:
                boolean r0 = r0.exclusive
                if (r0 != r1) goto L_0x0014
                r0 = 1
            L_0x001b:
                if (r0 != 0) goto L_0x0025
                r0 = 0
                boolean r0 = isChildTouched$default(r3, r0, r1)
                if (r0 != 0) goto L_0x0025
                goto L_0x0026
            L_0x0025:
                r1 = 0
            L_0x0026:
                if (r4 == 0) goto L_0x002e
                com.swmansion.gesturehandler.react.RNGestureHandlerButtonViewManager$ButtonViewGroup r0 = touchResponder
                if (r0 == r3) goto L_0x002e
                if (r1 == 0) goto L_0x0033
            L_0x002e:
                r3.isTouched = r4
                super.setPressed(r4)
            L_0x0033:
                if (r4 != 0) goto L_0x003b
                com.swmansion.gesturehandler.react.RNGestureHandlerButtonViewManager$ButtonViewGroup r4 = touchResponder
                if (r4 != r3) goto L_0x003b
                r3.isTouched = r2
            L_0x003b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.swmansion.gesturehandler.react.RNGestureHandlerButtonViewManager.ButtonViewGroup.setPressed(boolean):void");
        }

        public final void setRippleColor(Integer num) {
            this.rippleColor = num;
            this.needBackgroundUpdate = true;
        }

        public final void setRippleRadius(Integer num) {
            this.rippleRadius = num;
            this.needBackgroundUpdate = true;
        }

        public final void setTouched(boolean z) {
            this.isTouched = z;
        }

        public final void setUseBorderlessDrawable(boolean z) {
            this.useBorderlessDrawable = z;
        }

        public final void setUseDrawableOnForeground(boolean z) {
            this.useDrawableOnForeground = z;
            this.needBackgroundUpdate = true;
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

        public final void tryFreeingResponder() {
            if (touchResponder == this) {
                touchResponder = null;
                soundResponder = this;
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0020, code lost:
            if (r0 == false) goto L_0x0022;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
            if (r0 == r4) goto L_0x0022;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean tryGrabbingResponder() {
            /*
                r4 = this;
                r0 = 0
                r1 = 1
                boolean r0 = isChildTouched$default(r4, r0, r1)
                r2 = 0
                if (r0 == 0) goto L_0x000a
                return r2
            L_0x000a:
                com.swmansion.gesturehandler.react.RNGestureHandlerButtonViewManager$ButtonViewGroup r0 = touchResponder
                if (r0 != 0) goto L_0x0011
                touchResponder = r4
                return r1
            L_0x0011:
                boolean r3 = r4.exclusive
                if (r3 == 0) goto L_0x001a
                if (r0 != r4) goto L_0x0018
                goto L_0x0022
            L_0x0018:
                r1 = 0
                goto L_0x0022
            L_0x001a:
                if (r0 != 0) goto L_0x001e
                r0 = 0
                goto L_0x0020
            L_0x001e:
                boolean r0 = r0.exclusive
            L_0x0020:
                if (r0 != 0) goto L_0x0018
            L_0x0022:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.swmansion.gesturehandler.react.RNGestureHandlerButtonViewManager.ButtonViewGroup.tryGrabbingResponder():boolean");
        }

        public boolean wantsToHandleEventBeforeActivation() {
            Intrinsics.checkNotNullParameter(this, "this");
            return false;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerButtonViewManager$Companion;", "", "()V", "REACT_CLASS", "", "react-native-gesture-handler_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RNGestureHandlerButtonViewManager.kt */
    public static final class Companion {
        public Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public ViewManagerDelegate<ButtonViewGroup> getDelegate() {
        return this.mDelegate;
    }

    public String getName() {
        return REACT_CLASS;
    }

    public ButtonViewGroup createViewInstance(ThemedReactContext themedReactContext) {
        Intrinsics.checkNotNullParameter(themedReactContext, "context");
        return new ButtonViewGroup(themedReactContext);
    }

    public void onAfterUpdateTransaction(ButtonViewGroup buttonViewGroup) {
        ColorStateList colorStateList;
        Intrinsics.checkNotNullParameter(buttonViewGroup, "view");
        if (buttonViewGroup.needBackgroundUpdate) {
            buttonViewGroup.needBackgroundUpdate = false;
            if (buttonViewGroup._backgroundColor == 0) {
                buttonViewGroup.setBackground(null);
            }
            if (VERSION.SDK_INT >= 23) {
                buttonViewGroup.setForeground(null);
            }
            int[][] iArr = {new int[]{16842910}};
            Integer num = buttonViewGroup.rippleRadius;
            Integer num2 = buttonViewGroup.rippleColor;
            if (num2 != null) {
                Intrinsics.checkNotNull(num2);
                colorStateList = new ColorStateList(iArr, new int[]{num2.intValue()});
            } else {
                buttonViewGroup.getContext().getTheme().resolveAttribute(16843820, ButtonViewGroup.resolveOutValue, true);
                colorStateList = new ColorStateList(iArr, new int[]{ButtonViewGroup.resolveOutValue.data});
            }
            RippleDrawable rippleDrawable = new RippleDrawable(colorStateList, null, buttonViewGroup.useBorderlessDrawable ? null : new ShapeDrawable(new RectShape()));
            if (VERSION.SDK_INT >= 23 && num != null) {
                rippleDrawable.setRadius((int) ImageOriginUtils.toPixelFromDIP((float) num.intValue()));
            }
            if (!(buttonViewGroup.borderRadius == 0.0f)) {
                PaintDrawable paintDrawable = new PaintDrawable(-1);
                paintDrawable.setCornerRadius(buttonViewGroup.borderRadius);
                rippleDrawable.setDrawableByLayerId(16908334, paintDrawable);
            }
            if (buttonViewGroup.useDrawableOnForeground && VERSION.SDK_INT >= 23) {
                buttonViewGroup.setForeground(rippleDrawable);
                int i = buttonViewGroup._backgroundColor;
                if (i != 0) {
                    buttonViewGroup.setBackgroundColor(i);
                }
            } else if (buttonViewGroup._backgroundColor == 0 && buttonViewGroup.rippleColor == null) {
                buttonViewGroup.setBackground(rippleDrawable);
            } else {
                PaintDrawable paintDrawable2 = new PaintDrawable(buttonViewGroup._backgroundColor);
                if (!(buttonViewGroup.borderRadius == 0.0f)) {
                    paintDrawable2.setCornerRadius(buttonViewGroup.borderRadius);
                }
                buttonViewGroup.setBackground(new LayerDrawable(new Drawable[]{paintDrawable2, rippleDrawable}));
            }
        }
    }

    @ReactProp(name = "borderRadius")
    public void setBorderRadius(ButtonViewGroup buttonViewGroup, float f2) {
        Intrinsics.checkNotNullParameter(buttonViewGroup, "view");
        buttonViewGroup.setBorderRadius(f2);
    }

    @ReactProp(name = "borderless")
    public void setBorderless(ButtonViewGroup buttonViewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(buttonViewGroup, "view");
        buttonViewGroup.setUseBorderlessDrawable(z);
    }

    @ReactProp(name = "enabled")
    public void setEnabled(ButtonViewGroup buttonViewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(buttonViewGroup, "view");
        buttonViewGroup.setEnabled(z);
    }

    @ReactProp(name = "exclusive")
    public void setExclusive(ButtonViewGroup buttonViewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(buttonViewGroup, "view");
        buttonViewGroup.setExclusive(z);
    }

    @ReactProp(name = "foreground")
    @TargetApi(23)
    public void setForeground(ButtonViewGroup buttonViewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(buttonViewGroup, "view");
        buttonViewGroup.setUseDrawableOnForeground(z);
    }

    @ReactProp(name = "rippleColor")
    public void setRippleColor(ButtonViewGroup buttonViewGroup, Integer num) {
        Intrinsics.checkNotNullParameter(buttonViewGroup, "view");
        buttonViewGroup.setRippleColor(num);
    }

    @ReactProp(name = "rippleRadius")
    public void setRippleRadius(ButtonViewGroup buttonViewGroup, int i) {
        Intrinsics.checkNotNullParameter(buttonViewGroup, "view");
        buttonViewGroup.setRippleRadius(Integer.valueOf(i));
    }

    @ReactProp(name = "touchSoundDisabled")
    public void setTouchSoundDisabled(ButtonViewGroup buttonViewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(buttonViewGroup, "view");
        buttonViewGroup.setSoundEffectsEnabled(!z);
    }
}
