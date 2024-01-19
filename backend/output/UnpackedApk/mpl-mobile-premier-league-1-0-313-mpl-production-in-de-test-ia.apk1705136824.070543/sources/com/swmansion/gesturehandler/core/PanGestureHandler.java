package com.swmansion.gesturehandler.core;

import android.content.Context;
import android.os.Handler;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u0000 P2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001PB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u000fH\u0016J\b\u00103\u001a\u000201H\u0014J\u0018\u00104\u001a\u0002012\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000206H\u0014J\b\u00108\u001a\u000201H\u0014J\b\u00109\u001a\u000201H\u0016J\b\u0010:\u001a\u000201H\u0016J\u000e\u0010;\u001a\u00020\u00002\u0006\u0010<\u001a\u00020\u0006J\u000e\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010>\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010?\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\nJ\u000e\u0010@\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\nJ\u000e\u0010A\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010B\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\nJ\u000e\u0010C\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\nJ\u000e\u0010D\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\nJ\u000e\u0010E\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\nJ\u000e\u0010F\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010G\u001a\u00020\u00002\u0006\u0010H\u001a\u00020\nJ\u000e\u0010I\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001aJ\u000e\u0010J\u001a\u00020\u00002\u0006\u0010K\u001a\u00020\nJ\u000e\u0010L\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\nJ\u000e\u0010M\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\nJ\b\u0010N\u001a\u00020\u000fH\u0002J\b\u0010O\u001a\u00020\u000fH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010$\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b(\u0010&R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010,\u001a\u00020\n2\u0006\u0010+\u001a\u00020\n@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b-\u0010&R\u001e\u0010.\u001a\u00020\n2\u0006\u0010+\u001a\u00020\n@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b/\u0010&¨\u0006Q"}, d2 = {"Lcom/swmansion/gesturehandler/core/PanGestureHandler;", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "activateAfterLongPress", "", "activateDelayed", "Ljava/lang/Runnable;", "activeOffsetXEnd", "", "activeOffsetXStart", "activeOffsetYEnd", "activeOffsetYStart", "averageTouches", "", "defaultMinDistSq", "failOffsetXEnd", "failOffsetXStart", "failOffsetYEnd", "failOffsetYStart", "handler", "Landroid/os/Handler;", "lastX", "lastY", "maxPointers", "", "minDistSq", "minPointers", "minVelocitySq", "minVelocityX", "minVelocityY", "offsetX", "offsetY", "startX", "startY", "translationX", "getTranslationX", "()F", "translationY", "getTranslationY", "velocityTracker", "Landroid/view/VelocityTracker;", "<set-?>", "velocityX", "getVelocityX", "velocityY", "getVelocityY", "activate", "", "force", "onCancel", "onHandle", "event", "Landroid/view/MotionEvent;", "sourceEvent", "onReset", "resetConfig", "resetProgress", "setActivateAfterLongPress", "time", "setActiveOffsetXEnd", "setActiveOffsetXStart", "setActiveOffsetYEnd", "setActiveOffsetYStart", "setAverageTouches", "setFailOffsetXEnd", "setFailOffsetXStart", "setFailOffsetYEnd", "setFailOffsetYStart", "setMaxPointers", "setMinDist", "minDist", "setMinPointers", "setMinVelocity", "minVelocity", "setMinVelocityX", "setMinVelocityY", "shouldActivate", "shouldFail", "Companion", "react-native-gesture-handler_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PanGestureHandler.kt */
public final class PanGestureHandler extends GestureHandler<PanGestureHandler> {
    public static final Companion Companion = new Companion(null);
    public long activateAfterLongPress;
    public final Runnable activateDelayed = new Runnable() {
        public final void run() {
            PanGestureHandler.m55activateDelayed$lambda0(PanGestureHandler.this);
        }
    };
    public float activeOffsetXEnd = Float.MIN_VALUE;
    public float activeOffsetXStart = Float.MAX_VALUE;
    public float activeOffsetYEnd = Float.MIN_VALUE;
    public float activeOffsetYStart = Float.MAX_VALUE;
    public boolean averageTouches;
    public final float defaultMinDistSq;
    public float failOffsetXEnd = Float.MAX_VALUE;
    public float failOffsetXStart = Float.MIN_VALUE;
    public float failOffsetYEnd = Float.MAX_VALUE;
    public float failOffsetYStart = Float.MIN_VALUE;
    public Handler handler;
    public float lastX;
    public float lastY;
    public int maxPointers = 10;
    public float minDistSq = Float.MIN_VALUE;
    public int minPointers = 1;
    public float minVelocitySq = Float.MAX_VALUE;
    public float minVelocityX = Float.MAX_VALUE;
    public float minVelocityY = Float.MAX_VALUE;
    public float offsetX;
    public float offsetY;
    public float startX;
    public float startY;
    public VelocityTracker velocityTracker;
    public float velocityX;
    public float velocityY;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/swmansion/gesturehandler/core/PanGestureHandler$Companion;", "", "()V", "DEFAULT_ACTIVATE_AFTER_LONG_PRESS", "", "DEFAULT_MAX_POINTERS", "", "DEFAULT_MIN_POINTERS", "MAX_VALUE_IGNORE", "", "MIN_VALUE_IGNORE", "addVelocityMovement", "", "tracker", "Landroid/view/VelocityTracker;", "event", "Landroid/view/MotionEvent;", "react-native-gesture-handler_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PanGestureHandler.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public PanGestureHandler(Context context) {
        Intrinsics.checkNotNull(context);
        int scaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        float f2 = (float) (scaledTouchSlop * scaledTouchSlop);
        this.defaultMinDistSq = f2;
        this.minDistSq = f2;
    }

    /* renamed from: activateDelayed$lambda-0  reason: not valid java name */
    public static final void m55activateDelayed$lambda0(PanGestureHandler panGestureHandler) {
        Intrinsics.checkNotNullParameter(panGestureHandler, "this$0");
        panGestureHandler.activate(false);
    }

    public void activate(boolean z) {
        if (this.state != 4) {
            resetProgress();
        }
        super.activate(z);
    }

    public void onCancel() {
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:189:0x0319, code lost:
        if ((0.0f <= r15 && r15 <= r14) != false) goto L_0x035b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x0340, code lost:
        if ((0.0f <= r0 && r0 <= r14) != false) goto L_0x035b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x027c  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0281  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onHandle(android.view.MotionEvent r14, android.view.MotionEvent r15) {
        /*
            r13 = this;
            java.lang.String r0 = "event"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r14 = "sourceEvent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r14)
            int r14 = r13.state
            int r1 = r15.getActionMasked()
            r2 = 0
            r3 = -1
            r4 = 0
            r5 = 5
            r6 = 6
            if (r1 == r5) goto L_0x0091
            if (r1 == r6) goto L_0x0091
            boolean r7 = r13.averageTouches
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            int r8 = r15.getActionMasked()
            if (r8 != r6) goto L_0x0029
            int r8 = r15.getActionIndex()
            goto L_0x002a
        L_0x0029:
            r8 = -1
        L_0x002a:
            if (r7 == 0) goto L_0x0045
            int r7 = r15.getPointerCount()
            r9 = 0
            r10 = 0
            r11 = 0
        L_0x0033:
            if (r9 >= r7) goto L_0x0042
            int r12 = r9 + 1
            if (r9 == r8) goto L_0x0040
            float r9 = r15.getX(r9)
            float r11 = r11 + r9
            int r10 = r10 + 1
        L_0x0040:
            r9 = r12
            goto L_0x0033
        L_0x0042:
            float r7 = (float) r10
            float r11 = r11 / r7
            goto L_0x0052
        L_0x0045:
            int r7 = r15.getPointerCount()
            int r7 = r7 + r3
            if (r7 != r8) goto L_0x004e
            int r7 = r7 + -1
        L_0x004e:
            float r11 = r15.getX(r7)
        L_0x0052:
            r13.lastX = r11
            boolean r7 = r13.averageTouches
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            int r0 = r15.getActionMasked()
            if (r0 != r6) goto L_0x0064
            int r0 = r15.getActionIndex()
            goto L_0x0065
        L_0x0064:
            r0 = -1
        L_0x0065:
            if (r7 == 0) goto L_0x0080
            int r3 = r15.getPointerCount()
            r7 = 0
            r8 = 0
            r9 = 0
        L_0x006e:
            if (r7 >= r3) goto L_0x007d
            int r10 = r7 + 1
            if (r7 == r0) goto L_0x007b
            float r7 = r15.getY(r7)
            float r9 = r9 + r7
            int r8 = r8 + 1
        L_0x007b:
            r7 = r10
            goto L_0x006e
        L_0x007d:
            float r0 = (float) r8
            float r9 = r9 / r0
            goto L_0x008d
        L_0x0080:
            int r7 = r15.getPointerCount()
            int r7 = r7 + r3
            if (r7 != r0) goto L_0x0089
            int r7 = r7 + -1
        L_0x0089:
            float r9 = r15.getY(r7)
        L_0x008d:
            r13.lastY = r9
            goto L_0x0121
        L_0x0091:
            float r7 = r13.offsetX
            float r8 = r13.lastX
            float r9 = r13.startX
            float r8 = r8 - r9
            float r8 = r8 + r7
            r13.offsetX = r8
            float r7 = r13.offsetY
            float r8 = r13.lastY
            float r9 = r13.startY
            float r8 = r8 - r9
            float r8 = r8 + r7
            r13.offsetY = r8
            boolean r7 = r13.averageTouches
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            int r8 = r15.getActionMasked()
            if (r8 != r6) goto L_0x00b5
            int r8 = r15.getActionIndex()
            goto L_0x00b6
        L_0x00b5:
            r8 = -1
        L_0x00b6:
            if (r7 == 0) goto L_0x00d1
            int r7 = r15.getPointerCount()
            r9 = 0
            r10 = 0
            r11 = 0
        L_0x00bf:
            if (r9 >= r7) goto L_0x00ce
            int r12 = r9 + 1
            if (r9 == r8) goto L_0x00cc
            float r9 = r15.getX(r9)
            float r11 = r11 + r9
            int r10 = r10 + 1
        L_0x00cc:
            r9 = r12
            goto L_0x00bf
        L_0x00ce:
            float r7 = (float) r10
            float r11 = r11 / r7
            goto L_0x00de
        L_0x00d1:
            int r7 = r15.getPointerCount()
            int r7 = r7 + r3
            if (r7 != r8) goto L_0x00da
            int r7 = r7 + -1
        L_0x00da:
            float r11 = r15.getX(r7)
        L_0x00de:
            r13.lastX = r11
            boolean r7 = r13.averageTouches
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            int r0 = r15.getActionMasked()
            if (r0 != r6) goto L_0x00f0
            int r0 = r15.getActionIndex()
            goto L_0x00f1
        L_0x00f0:
            r0 = -1
        L_0x00f1:
            if (r7 == 0) goto L_0x010c
            int r3 = r15.getPointerCount()
            r7 = 0
            r8 = 0
            r9 = 0
        L_0x00fa:
            if (r7 >= r3) goto L_0x0109
            int r10 = r7 + 1
            if (r7 == r0) goto L_0x0107
            float r7 = r15.getY(r7)
            float r9 = r9 + r7
            int r8 = r8 + 1
        L_0x0107:
            r7 = r10
            goto L_0x00fa
        L_0x0109:
            float r0 = (float) r8
            float r9 = r9 / r0
            goto L_0x0119
        L_0x010c:
            int r7 = r15.getPointerCount()
            int r7 = r7 + r3
            if (r7 != r0) goto L_0x0115
            int r7 = r7 + -1
        L_0x0115:
            float r9 = r15.getY(r7)
        L_0x0119:
            r13.lastY = r9
            float r0 = r13.lastX
            r13.startX = r0
            r13.startY = r9
        L_0x0121:
            r7 = 0
            if (r14 != 0) goto L_0x0183
            int r0 = r15.getPointerCount()
            int r3 = r13.minPointers
            if (r0 < r3) goto L_0x0183
            r13.resetProgress()
            r13.offsetX = r2
            r13.offsetY = r2
            r13.velocityX = r2
            r13.velocityY = r2
            android.view.VelocityTracker r0 = android.view.VelocityTracker.obtain()
            r13.velocityTracker = r0
            float r3 = r15.getRawX()
            float r9 = r15.getX()
            float r3 = r3 - r9
            float r9 = r15.getRawY()
            float r10 = r15.getY()
            float r9 = r9 - r10
            r15.offsetLocation(r3, r9)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r0.addMovement(r15)
            float r0 = -r3
            float r3 = -r9
            r15.offsetLocation(r0, r3)
            r13.begin()
            long r9 = r13.activateAfterLongPress
            int r0 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r0 <= 0) goto L_0x01c7
            android.os.Handler r0 = r13.handler
            if (r0 != 0) goto L_0x0176
            android.os.Handler r0 = new android.os.Handler
            android.os.Looper r3 = android.os.Looper.getMainLooper()
            r0.<init>(r3)
            r13.handler = r0
        L_0x0176:
            android.os.Handler r0 = r13.handler
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.lang.Runnable r3 = r13.activateDelayed
            long r9 = r13.activateAfterLongPress
            r0.postDelayed(r3, r9)
            goto L_0x01c7
        L_0x0183:
            android.view.VelocityTracker r0 = r13.velocityTracker
            if (r0 == 0) goto L_0x01c7
            float r3 = r15.getRawX()
            float r9 = r15.getX()
            float r3 = r3 - r9
            float r9 = r15.getRawY()
            float r10 = r15.getY()
            float r9 = r9 - r10
            r15.offsetLocation(r3, r9)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r0.addMovement(r15)
            float r0 = -r3
            float r3 = -r9
            r15.offsetLocation(r0, r3)
            android.view.VelocityTracker r0 = r13.velocityTracker
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r3 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r3)
            android.view.VelocityTracker r0 = r13.velocityTracker
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            float r0 = r0.getXVelocity()
            r13.velocityX = r0
            android.view.VelocityTracker r0 = r13.velocityTracker
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            float r0 = r0.getYVelocity()
            r13.velocityY = r0
        L_0x01c7:
            r0 = 4
            r3 = 1
            if (r1 != r3) goto L_0x01d7
            if (r14 != r0) goto L_0x01d2
            r13.end()
            goto L_0x0360
        L_0x01d2:
            r13.fail()
            goto L_0x0360
        L_0x01d7:
            if (r1 != r5) goto L_0x01ed
            int r5 = r15.getPointerCount()
            int r9 = r13.maxPointers
            if (r5 <= r9) goto L_0x01ed
            if (r14 != r0) goto L_0x01e8
            r13.cancel()
            goto L_0x0360
        L_0x01e8:
            r13.fail()
            goto L_0x0360
        L_0x01ed:
            if (r1 != r6) goto L_0x01fe
            if (r14 != r0) goto L_0x01fe
            int r15 = r15.getPointerCount()
            int r0 = r13.minPointers
            if (r15 >= r0) goto L_0x01fe
            r13.fail()
            goto L_0x0360
        L_0x01fe:
            r15 = 2
            if (r14 != r15) goto L_0x0360
            float r14 = r13.lastX
            float r15 = r13.startX
            float r14 = r14 - r15
            float r15 = r13.offsetX
            float r14 = r14 + r15
            float r15 = r13.lastY
            float r0 = r13.startY
            float r15 = r15 - r0
            float r0 = r13.offsetY
            float r15 = r15 + r0
            long r0 = r13.activateAfterLongPress
            r5 = 2139095039(0x7f7fffff, float:3.4028235E38)
            r6 = 1
            int r9 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r9 <= 0) goto L_0x0230
            float r0 = r14 * r14
            float r1 = r15 * r15
            float r1 = r1 + r0
            float r0 = r13.defaultMinDistSq
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x0230
            android.os.Handler r14 = r13.handler
            if (r14 != 0) goto L_0x022b
            goto L_0x0277
        L_0x022b:
            r15 = 0
            r14.removeCallbacksAndMessages(r15)
            goto L_0x0277
        L_0x0230:
            float r0 = r13.failOffsetXStart
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r0 != 0) goto L_0x0238
            r0 = 1
            goto L_0x0239
        L_0x0238:
            r0 = 0
        L_0x0239:
            if (r0 != 0) goto L_0x0242
            float r0 = r13.failOffsetXStart
            int r0 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x0242
            goto L_0x0277
        L_0x0242:
            float r0 = r13.failOffsetXEnd
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 != 0) goto L_0x024a
            r0 = 1
            goto L_0x024b
        L_0x024a:
            r0 = 0
        L_0x024b:
            if (r0 != 0) goto L_0x0254
            float r0 = r13.failOffsetXEnd
            int r14 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r14 <= 0) goto L_0x0254
            goto L_0x0277
        L_0x0254:
            float r14 = r13.failOffsetYStart
            int r14 = (r14 > r6 ? 1 : (r14 == r6 ? 0 : -1))
            if (r14 != 0) goto L_0x025c
            r14 = 1
            goto L_0x025d
        L_0x025c:
            r14 = 0
        L_0x025d:
            if (r14 != 0) goto L_0x0266
            float r14 = r13.failOffsetYStart
            int r14 = (r15 > r14 ? 1 : (r15 == r14 ? 0 : -1))
            if (r14 >= 0) goto L_0x0266
            goto L_0x0277
        L_0x0266:
            float r14 = r13.failOffsetYEnd
            int r14 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r14 != 0) goto L_0x026e
            r14 = 1
            goto L_0x026f
        L_0x026e:
            r14 = 0
        L_0x026f:
            if (r14 != 0) goto L_0x0279
            float r14 = r13.failOffsetYEnd
            int r14 = (r15 > r14 ? 1 : (r15 == r14 ? 0 : -1))
            if (r14 <= 0) goto L_0x0279
        L_0x0277:
            r14 = 1
            goto L_0x027a
        L_0x0279:
            r14 = 0
        L_0x027a:
            if (r14 == 0) goto L_0x0281
            r13.fail()
            goto L_0x0360
        L_0x0281:
            float r14 = r13.lastX
            float r15 = r13.startX
            float r14 = r14 - r15
            float r15 = r13.offsetX
            float r14 = r14 + r15
            float r15 = r13.activeOffsetXStart
            int r15 = (r15 > r5 ? 1 : (r15 == r5 ? 0 : -1))
            if (r15 != 0) goto L_0x0291
            r15 = 1
            goto L_0x0292
        L_0x0291:
            r15 = 0
        L_0x0292:
            if (r15 != 0) goto L_0x029c
            float r15 = r13.activeOffsetXStart
            int r15 = (r14 > r15 ? 1 : (r14 == r15 ? 0 : -1))
            if (r15 >= 0) goto L_0x029c
            goto L_0x035b
        L_0x029c:
            float r15 = r13.activeOffsetXEnd
            int r15 = (r15 > r6 ? 1 : (r15 == r6 ? 0 : -1))
            if (r15 != 0) goto L_0x02a4
            r15 = 1
            goto L_0x02a5
        L_0x02a4:
            r15 = 0
        L_0x02a5:
            if (r15 != 0) goto L_0x02af
            float r15 = r13.activeOffsetXEnd
            int r15 = (r14 > r15 ? 1 : (r14 == r15 ? 0 : -1))
            if (r15 <= 0) goto L_0x02af
            goto L_0x035b
        L_0x02af:
            float r15 = r13.lastY
            float r0 = r13.startY
            float r15 = r15 - r0
            float r0 = r13.offsetY
            float r15 = r15 + r0
            float r0 = r13.activeOffsetYStart
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 != 0) goto L_0x02bf
            r0 = 1
            goto L_0x02c0
        L_0x02bf:
            r0 = 0
        L_0x02c0:
            if (r0 != 0) goto L_0x02ca
            float r0 = r13.activeOffsetYStart
            int r0 = (r15 > r0 ? 1 : (r15 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x02ca
            goto L_0x035b
        L_0x02ca:
            float r0 = r13.activeOffsetYEnd
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r0 != 0) goto L_0x02d2
            r0 = 1
            goto L_0x02d3
        L_0x02d2:
            r0 = 0
        L_0x02d3:
            if (r0 != 0) goto L_0x02dd
            float r0 = r13.activeOffsetYEnd
            int r0 = (r15 > r0 ? 1 : (r15 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x02dd
            goto L_0x035b
        L_0x02dd:
            float r14 = r14 * r14
            float r15 = r15 * r15
            float r15 = r15 + r14
            float r14 = r13.minDistSq
            int r14 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r14 != 0) goto L_0x02ea
            r14 = 1
            goto L_0x02eb
        L_0x02ea:
            r14 = 0
        L_0x02eb:
            if (r14 != 0) goto L_0x02f5
            float r14 = r13.minDistSq
            int r14 = (r15 > r14 ? 1 : (r15 == r14 ? 0 : -1))
            if (r14 < 0) goto L_0x02f5
            goto L_0x035b
        L_0x02f5:
            float r14 = r13.velocityX
            float r15 = r13.minVelocityX
            int r15 = (r15 > r5 ? 1 : (r15 == r5 ? 0 : -1))
            if (r15 != 0) goto L_0x02ff
            r15 = 1
            goto L_0x0300
        L_0x02ff:
            r15 = 0
        L_0x0300:
            if (r15 != 0) goto L_0x031c
            float r15 = r13.minVelocityX
            int r0 = (r15 > r2 ? 1 : (r15 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x030c
            int r15 = (r14 > r15 ? 1 : (r14 == r15 ? 0 : -1))
            if (r15 <= 0) goto L_0x035b
        L_0x030c:
            float r15 = r13.minVelocityX
            int r0 = (r2 > r15 ? 1 : (r2 == r15 ? 0 : -1))
            if (r0 > 0) goto L_0x0318
            int r15 = (r15 > r14 ? 1 : (r15 == r14 ? 0 : -1))
            if (r15 > 0) goto L_0x0318
            r15 = 1
            goto L_0x0319
        L_0x0318:
            r15 = 0
        L_0x0319:
            if (r15 == 0) goto L_0x031c
            goto L_0x035b
        L_0x031c:
            float r15 = r13.velocityY
            float r0 = r13.minVelocityY
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 != 0) goto L_0x0326
            r0 = 1
            goto L_0x0327
        L_0x0326:
            r0 = 0
        L_0x0327:
            if (r0 != 0) goto L_0x0343
            float r0 = r13.minVelocityY
            int r1 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r1 >= 0) goto L_0x0333
            int r0 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x035b
        L_0x0333:
            float r0 = r13.minVelocityY
            int r1 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r1 > 0) goto L_0x033f
            int r0 = (r0 > r14 ? 1 : (r0 == r14 ? 0 : -1))
            if (r0 > 0) goto L_0x033f
            r0 = 1
            goto L_0x0340
        L_0x033f:
            r0 = 0
        L_0x0340:
            if (r0 == 0) goto L_0x0343
            goto L_0x035b
        L_0x0343:
            float r14 = r14 * r14
            float r15 = r15 * r15
            float r15 = r15 + r14
            float r14 = r13.minVelocitySq
            int r14 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r14 != 0) goto L_0x0350
            r14 = 1
            goto L_0x0351
        L_0x0350:
            r14 = 0
        L_0x0351:
            if (r14 != 0) goto L_0x035a
            float r14 = r13.minVelocitySq
            int r14 = (r15 > r14 ? 1 : (r15 == r14 ? 0 : -1))
            if (r14 < 0) goto L_0x035a
            goto L_0x035b
        L_0x035a:
            r3 = 0
        L_0x035b:
            if (r3 == 0) goto L_0x0360
            r13.activate(r4)
        L_0x0360:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.gesturehandler.core.PanGestureHandler.onHandle(android.view.MotionEvent, android.view.MotionEvent):void");
    }

    public void onReset() {
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
        }
        VelocityTracker velocityTracker2 = this.velocityTracker;
        if (velocityTracker2 != null) {
            velocityTracker2.recycle();
            this.velocityTracker = null;
        }
    }

    public void resetConfig() {
        super.resetConfig();
        this.activeOffsetXStart = Float.MAX_VALUE;
        this.activeOffsetXEnd = Float.MIN_VALUE;
        this.failOffsetXStart = Float.MIN_VALUE;
        this.failOffsetXEnd = Float.MAX_VALUE;
        this.activeOffsetYStart = Float.MAX_VALUE;
        this.activeOffsetYEnd = Float.MIN_VALUE;
        this.failOffsetYStart = Float.MIN_VALUE;
        this.failOffsetYEnd = Float.MAX_VALUE;
        this.minVelocityX = Float.MAX_VALUE;
        this.minVelocityY = Float.MAX_VALUE;
        this.minVelocitySq = Float.MAX_VALUE;
        this.minDistSq = this.defaultMinDistSq;
        this.minPointers = 1;
        this.maxPointers = 10;
        this.activateAfterLongPress = 0;
        this.averageTouches = false;
    }

    public void resetProgress() {
        this.startX = this.lastX;
        this.startY = this.lastY;
    }
}
