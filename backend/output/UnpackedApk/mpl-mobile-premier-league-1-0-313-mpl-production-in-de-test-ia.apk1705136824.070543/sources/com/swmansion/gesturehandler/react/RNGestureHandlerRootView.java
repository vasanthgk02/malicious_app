package com.swmansion.gesturehandler.react;

import android.content.Context;
import android.view.ViewParent;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.views.view.ReactViewGroup;
import com.swmansion.gesturehandler.core.GestureHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0014J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J\u0006\u0010\u0010\u001a\u00020\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerRootView;", "Lcom/facebook/react/views/view/ReactViewGroup;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "_enabled", "", "rootHelper", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerRootHelper;", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "onAttachedToWindow", "", "requestDisallowInterceptTouchEvent", "disallowIntercept", "tearDown", "Companion", "react-native-gesture-handler_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RNGestureHandlerRootView.kt */
public final class RNGestureHandlerRootView extends ReactViewGroup {
    public static final Companion Companion = new Companion(null);
    public boolean _enabled;
    public RNGestureHandlerRootHelper rootHelper;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u0007"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerRootView$Companion;", "", "()V", "hasGestureHandlerEnabledRootView", "", "viewGroup", "Landroid/view/ViewGroup;", "react-native-gesture-handler_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RNGestureHandlerRootView.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public RNGestureHandlerRootView(Context context) {
        super(context);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00d5, code lost:
        if (r13 == r2.wrapperView) goto L_0x00d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0030, code lost:
        if (r6 != 5) goto L_0x0094;
     */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0228  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0255  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0280  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00fb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(android.view.MotionEvent r21) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            java.lang.String r2 = "ev"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            boolean r3 = r0._enabled
            r4 = 1
            if (r3 == 0) goto L_0x0282
            com.swmansion.gesturehandler.react.RNGestureHandlerRootHelper r3 = r0.rootHelper
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            r3.passingTouch = r4
            com.swmansion.gesturehandler.core.GestureHandlerOrchestrator r2 = r3.orchestrator
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            java.lang.String r5 = "event"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r5)
            r2.isHandlingTouch = r4
            int r6 = r21.getActionMasked()
            r7 = 5
            r8 = 3
            r9 = -1
            r10 = 0
            if (r6 == 0) goto L_0x006e
            if (r6 == r8) goto L_0x0033
            if (r6 == r7) goto L_0x006e
            goto L_0x0094
        L_0x0033:
            int r6 = r2.awaitingHandlersCount
            int r6 = r6 + r9
            if (r6 < 0) goto L_0x0049
        L_0x0038:
            int r11 = r6 + -1
            com.swmansion.gesturehandler.core.GestureHandler<?>[] r12 = r2.awaitingHandlers
            r6 = r12[r6]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            r6.cancel()
            if (r11 >= 0) goto L_0x0047
            goto L_0x0049
        L_0x0047:
            r6 = r11
            goto L_0x0038
        L_0x0049:
            int r6 = r2.gestureHandlersCount
            r11 = 0
        L_0x004c:
            if (r11 >= r6) goto L_0x005a
            int r12 = r11 + 1
            com.swmansion.gesturehandler.core.GestureHandler<?>[] r13 = r2.preparedHandlers
            com.swmansion.gesturehandler.core.GestureHandler<?>[] r14 = r2.gestureHandlers
            r14 = r14[r11]
            r13[r11] = r14
            r11 = r12
            goto L_0x004c
        L_0x005a:
            int r6 = r6 + r9
            if (r6 < 0) goto L_0x0094
        L_0x005d:
            int r11 = r6 + -1
            com.swmansion.gesturehandler.core.GestureHandler<?>[] r12 = r2.preparedHandlers
            r6 = r12[r6]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            r6.cancel()
            if (r11 >= 0) goto L_0x006c
            goto L_0x0094
        L_0x006c:
            r6 = r11
            goto L_0x005d
        L_0x006e:
            int r6 = r21.getActionIndex()
            int r11 = r1.getPointerId(r6)
            float[] r12 = com.swmansion.gesturehandler.core.GestureHandlerOrchestrator.tempCoords
            float r13 = r1.getX(r6)
            r12[r10] = r13
            float[] r12 = com.swmansion.gesturehandler.core.GestureHandlerOrchestrator.tempCoords
            float r6 = r1.getY(r6)
            r12[r4] = r6
            android.view.ViewGroup r6 = r2.wrapperView
            float[] r12 = com.swmansion.gesturehandler.core.GestureHandlerOrchestrator.tempCoords
            r2.traverseWithPointerEvents(r6, r12, r11)
            android.view.ViewGroup r6 = r2.wrapperView
            float[] r12 = com.swmansion.gesturehandler.core.GestureHandlerOrchestrator.tempCoords
            r2.extractGestureHandlers(r6, r12, r11)
        L_0x0094:
            int r6 = r2.gestureHandlersCount
            com.swmansion.gesturehandler.core.GestureHandler<?>[] r11 = r2.gestureHandlers
            com.swmansion.gesturehandler.core.GestureHandler<?>[] r12 = r2.preparedHandlers
            kotlin.collections.ArraysKt___ArraysJvmKt.copyInto((T[]) r11, (T[]) r12, r10, r10, r6)
            com.swmansion.gesturehandler.core.GestureHandler<?>[] r11 = r2.preparedHandlers
            java.util.Comparator<com.swmansion.gesturehandler.core.GestureHandler<?>> r12 = com.swmansion.gesturehandler.core.GestureHandlerOrchestrator.handlersComparator
            java.lang.String r13 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r13)
            java.lang.String r13 = "comparator"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r13)
            java.util.Arrays.sort(r11, r10, r6, r12)
            r11 = 0
        L_0x00af:
            if (r11 >= r6) goto L_0x026b
            int r12 = r11 + 1
            com.swmansion.gesturehandler.core.GestureHandler<?>[] r13 = r2.preparedHandlers
            r11 = r13[r11]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            android.view.View r13 = r11.view
            if (r13 != 0) goto L_0x00bf
            goto L_0x00d9
        L_0x00bf:
            android.view.ViewGroup r14 = r2.wrapperView
            if (r13 != r14) goto L_0x00c4
            goto L_0x00d7
        L_0x00c4:
            android.view.ViewParent r13 = r13.getParent()
        L_0x00c8:
            if (r13 == 0) goto L_0x00d3
            android.view.ViewGroup r14 = r2.wrapperView
            if (r13 == r14) goto L_0x00d3
            android.view.ViewParent r13 = r13.getParent()
            goto L_0x00c8
        L_0x00d3:
            android.view.ViewGroup r14 = r2.wrapperView
            if (r13 != r14) goto L_0x00d9
        L_0x00d7:
            r13 = 1
            goto L_0x00da
        L_0x00d9:
            r13 = 0
        L_0x00da:
            if (r13 != 0) goto L_0x00e0
            r11.cancel()
            goto L_0x00f5
        L_0x00e0:
            boolean r13 = r11.isEnabled
            if (r13 == 0) goto L_0x00f2
            int r13 = r11.state
            if (r13 == r4) goto L_0x00f2
            if (r13 == r8) goto L_0x00f2
            if (r13 == r7) goto L_0x00f2
            int r13 = r11.trackedPointersIDsCount
            if (r13 <= 0) goto L_0x00f2
            r13 = 1
            goto L_0x00f3
        L_0x00f2:
            r13 = 0
        L_0x00f3:
            if (r13 != 0) goto L_0x00fb
        L_0x00f5:
            r17 = r5
            r0 = 1
            r8 = -1
            goto L_0x025f
        L_0x00fb:
            int r13 = r21.getActionMasked()
            android.view.View r14 = r11.view
            android.view.MotionEvent r15 = android.view.MotionEvent.obtain(r21)
            java.lang.String r9 = "obtain(sourceEvent)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, r9)
            r2.transformEventToViewCoords(r14, r15)
            boolean r9 = r11.needsPointerData
            if (r9 == 0) goto L_0x0118
            int r9 = r11.state
            if (r9 == 0) goto L_0x0118
            r11.updatePointerData(r15)
        L_0x0118:
            boolean r9 = r11.isAwaiting
            r14 = 2
            if (r9 == 0) goto L_0x0126
            if (r13 == r14) goto L_0x0120
            goto L_0x0126
        L_0x0120:
            r17 = r5
            r0 = 1
        L_0x0123:
            r8 = -1
            goto L_0x025c
        L_0x0126:
            int r9 = r11.state
            if (r9 != 0) goto L_0x012c
            r9 = 1
            goto L_0x012d
        L_0x012c:
            r9 = 0
        L_0x012d:
            java.lang.String r10 = "transformedEvent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r10)
            java.lang.String r10 = "sourceEvent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r10)
            boolean r10 = r11.isEnabled
            if (r10 == 0) goto L_0x0222
            int r10 = r11.state
            if (r10 == r8) goto L_0x0222
            if (r10 == r4) goto L_0x0222
            if (r10 == r7) goto L_0x0222
            int r10 = r11.trackedPointersIDsCount
            if (r10 >= r4) goto L_0x0149
            goto L_0x0222
        L_0x0149:
            r10 = 2
            android.view.MotionEvent[] r7 = new android.view.MotionEvent[r10]     // Catch:{ AdaptEventException -> 0x021c }
            android.view.MotionEvent r10 = r11.adaptEvent(r15)     // Catch:{ AdaptEventException -> 0x021c }
            r16 = 0
            r7[r16] = r10     // Catch:{ AdaptEventException -> 0x021c }
            android.view.MotionEvent r10 = r11.adaptEvent(r1)     // Catch:{ AdaptEventException -> 0x021c }
            r7[r4] = r10     // Catch:{ AdaptEventException -> 0x021c }
            r10 = r7[r16]
            r7 = r7[r4]
            float r8 = r10.getX()
            r11.x = r8
            float r8 = r10.getY()
            r11.y = r8
            int r8 = r10.getPointerCount()
            r11.numberOfPointers = r8
            android.view.View r8 = r11.view
            float r4 = r11.x
            float r14 = r11.y
            boolean r4 = r11.isWithinBounds(r8, r4, r14)
            r11.isWithinBounds = r4
            boolean r8 = r11.shouldCancelWhenOutside
            if (r8 == 0) goto L_0x0194
            if (r4 != 0) goto L_0x0194
            int r4 = r11.state
            r7 = 4
            if (r4 != r7) goto L_0x018c
            r11.cancel()
            goto L_0x0222
        L_0x018c:
            r7 = 2
            if (r4 != r7) goto L_0x0222
            r11.fail()
            goto L_0x0222
        L_0x0194:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r5)
            int r4 = r10.getActionMasked()
            r8 = 6
            if (r4 != r8) goto L_0x01a3
            int r4 = r10.getActionIndex()
            goto L_0x01a4
        L_0x01a3:
            r4 = -1
        L_0x01a4:
            int r8 = r10.getPointerCount()
            r0 = 0
            r14 = 0
            r18 = 0
        L_0x01ac:
            if (r14 >= r8) goto L_0x01bd
            int r19 = r14 + 1
            if (r14 == r4) goto L_0x01ba
            float r14 = r10.getX(r14)
            float r18 = r14 + r18
            int r0 = r0 + 1
        L_0x01ba:
            r14 = r19
            goto L_0x01ac
        L_0x01bd:
            float r0 = (float) r0
            float r0 = r18 / r0
            r11.lastAbsolutePositionX = r0
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r5)
            int r0 = r10.getActionMasked()
            r4 = 6
            if (r0 != r4) goto L_0x01d1
            int r0 = r10.getActionIndex()
            goto L_0x01d2
        L_0x01d1:
            r0 = -1
        L_0x01d2:
            int r4 = r10.getPointerCount()
            r17 = r5
            r5 = 0
            r8 = 0
            r14 = 0
        L_0x01db:
            if (r8 >= r4) goto L_0x01ec
            int r18 = r8 + 1
            if (r8 == r0) goto L_0x01e9
            float r8 = r10.getY(r8)
            float r8 = r8 + r14
            int r5 = r5 + 1
            r14 = r8
        L_0x01e9:
            r8 = r18
            goto L_0x01db
        L_0x01ec:
            float r0 = (float) r5
            float r14 = r14 / r0
            r11.lastAbsolutePositionY = r14
            float r0 = r10.getRawX()
            float r4 = r10.getX()
            float r0 = r0 - r4
            r11.lastEventOffsetX = r0
            float r0 = r10.getRawY()
            float r4 = r10.getY()
            float r0 = r0 - r4
            r11.lastEventOffsetY = r0
            r11.onHandle(r10, r7)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r10, r15)
            if (r0 != 0) goto L_0x0212
            r10.recycle()
        L_0x0212:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r1)
            if (r0 != 0) goto L_0x0224
            r7.recycle()
            goto L_0x0224
        L_0x021c:
            r17 = r5
            r11.fail()
            goto L_0x0224
        L_0x0222:
            r17 = r5
        L_0x0224:
            boolean r0 = r11.isActive
            if (r0 == 0) goto L_0x0235
            boolean r0 = r11.shouldResetProgress
            if (r0 == 0) goto L_0x0232
            r0 = 0
            r11.shouldResetProgress = r0
            r11.resetProgress()
        L_0x0232:
            r11.dispatchHandlerUpdate(r15)
        L_0x0235:
            boolean r0 = r11.needsPointerData
            if (r0 == 0) goto L_0x023e
            if (r9 == 0) goto L_0x023e
            r11.updatePointerData(r15)
        L_0x023e:
            r0 = 1
            if (r13 == r0) goto L_0x0246
            r4 = 6
            if (r13 == r4) goto L_0x0246
            goto L_0x0123
        L_0x0246:
            int r4 = r15.getActionIndex()
            int r4 = r15.getPointerId(r4)
            int[] r5 = r11.trackedPointerIDs
            r7 = r5[r4]
            r8 = -1
            if (r7 == r8) goto L_0x025c
            r5[r4] = r8
            int r4 = r11.trackedPointersIDsCount
            int r4 = r4 + r8
            r11.trackedPointersIDsCount = r4
        L_0x025c:
            r15.recycle()
        L_0x025f:
            r11 = r12
            r5 = r17
            r4 = 1
            r7 = 5
            r8 = 3
            r9 = -1
            r10 = 0
            r0 = r20
            goto L_0x00af
        L_0x026b:
            r0 = 1
            r4 = 0
            r2.isHandlingTouch = r4
            boolean r5 = r2.finishedHandlersCleanupScheduled
            if (r5 == 0) goto L_0x027a
            int r5 = r2.handlingChangeSemaphore
            if (r5 != 0) goto L_0x027a
            r2.cleanupFinishedHandlers()
        L_0x027a:
            r3.passingTouch = r4
            boolean r2 = r3.shouldIntercept
            if (r2 == 0) goto L_0x0282
            r4 = 1
            goto L_0x0286
        L_0x0282:
            boolean r4 = super.dispatchTouchEvent(r21)
        L_0x0286:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.gesturehandler.react.RNGestureHandlerRootView.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public void onAttachedToWindow() {
        boolean z;
        super.onAttachedToWindow();
        UiThreadUtil.assertOnUiThread();
        ViewParent parent = getParent();
        while (true) {
            z = false;
            if (parent == null) {
                break;
            } else if ((parent instanceof RNGestureHandlerEnabledRootView) || (parent instanceof RNGestureHandlerRootView)) {
                z = true;
            } else if (parent instanceof RootView) {
                break;
            } else {
                parent = parent.getParent();
            }
        }
        this._enabled = !z;
        if (this._enabled && this.rootHelper == null) {
            Context context = getContext();
            if (context != null) {
                this.rootHelper = new RNGestureHandlerRootHelper((ReactContext) context, this);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (this._enabled) {
            RNGestureHandlerRootHelper rNGestureHandlerRootHelper = this.rootHelper;
            Intrinsics.checkNotNull(rNGestureHandlerRootHelper);
            if (rNGestureHandlerRootHelper.orchestrator != null && !rNGestureHandlerRootHelper.passingTouch) {
                GestureHandler<?> gestureHandler = rNGestureHandlerRootHelper.jsGestureHandler;
                if (gestureHandler != null && gestureHandler.state == 2) {
                    gestureHandler.activate(false);
                    gestureHandler.end();
                }
            }
        }
        super.requestDisallowInterceptTouchEvent(z);
    }
}
