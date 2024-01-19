package com.swmansion.gesturehandler.core;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.EditText;
import com.netcore.android.notification.SMTNotificationConstants;
import java.util.Arrays;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 L2\u00020\u0001:\u0001LB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0014\u0010\u001e\u001a\u00020\u001f2\n\u0010 \u001a\u0006\u0012\u0002\b\u00030\rH\u0002J\u0010\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020\u001fH\u0002J\b\u0010%\u001a\u00020\u001fH\u0002J\b\u0010&\u001a\u00020\u001fH\u0002JS\u0010'\u001a\u00020\n2\u0012\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\r0\f2\u0006\u0010)\u001a\u00020\n2'\u0010*\u001a#\u0012\u0019\u0012\u0017\u0012\u0002\b\u0003\u0018\u00010\r¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00110+H\b¢\u0006\u0002\u0010.J\u001c\u0010/\u001a\u00020\u001f2\n\u0010 \u001a\u0006\u0012\u0002\b\u00030\r2\u0006\u00100\u001a\u000201H\u0002J\u0010\u00102\u001a\u00020\u001f2\u0006\u00103\u001a\u000201H\u0002J \u00104\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020#2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\nH\u0002J\u0010\u00108\u001a\u00020\u001f2\u0006\u00103\u001a\u000201H\u0002J \u00108\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u00032\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\nH\u0002J\u0014\u0010:\u001a\u00020\u00112\n\u0010 \u001a\u0006\u0012\u0002\b\u00030\rH\u0002J\u0010\u0010;\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020#H\u0002J\u0012\u0010<\u001a\u00020\u00112\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002J\u0010\u0010=\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020#H\u0002J\u0014\u0010>\u001a\u00020\u001f2\n\u0010 \u001a\u0006\u0012\u0002\b\u00030\rH\u0002J\"\u0010?\u001a\u00020\u001f2\n\u0010 \u001a\u0006\u0012\u0002\b\u00030\r2\u0006\u0010@\u001a\u00020\n2\u0006\u0010A\u001a\u00020\nJ\u000e\u0010B\u001a\u00020\u00112\u0006\u00103\u001a\u000201J\u001c\u0010C\u001a\u00020\u001f2\n\u0010 \u001a\u0006\u0012\u0002\b\u00030\r2\u0006\u0010\"\u001a\u00020#H\u0002J \u0010D\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020#2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\nH\u0002J\b\u0010E\u001a\u00020\u001fH\u0002J\u0018\u0010F\u001a\u0002012\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u00103\u001a\u000201J\u0018\u0010G\u001a\u00020H2\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010I\u001a\u00020HJ \u0010J\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020#2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\nH\u0002J\u0014\u0010K\u001a\u00020\u001f2\n\u0010 \u001a\u0006\u0012\u0002\b\u00030\rH\u0002R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\r0\fX\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\r0\fX\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u0013\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\r0\fX\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u0015\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\r0\fX\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Lcom/swmansion/gesturehandler/core/GestureHandlerOrchestrator;", "", "wrapperView", "Landroid/view/ViewGroup;", "handlerRegistry", "Lcom/swmansion/gesturehandler/core/GestureHandlerRegistry;", "viewConfigHelper", "Lcom/swmansion/gesturehandler/core/ViewConfigurationHelper;", "(Landroid/view/ViewGroup;Lcom/swmansion/gesturehandler/core/GestureHandlerRegistry;Lcom/swmansion/gesturehandler/core/ViewConfigurationHelper;)V", "activationIndex", "", "awaitingHandlers", "", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "[Lcom/swmansion/gesturehandler/core/GestureHandler;", "awaitingHandlersCount", "finishedHandlersCleanupScheduled", "", "gestureHandlers", "gestureHandlersCount", "handlersToCancel", "handlingChangeSemaphore", "isHandlingTouch", "minimumAlphaForTraversal", "", "getMinimumAlphaForTraversal", "()F", "setMinimumAlphaForTraversal", "(F)V", "preparedHandlers", "addAwaitingHandler", "", "handler", "canReceiveEvents", "view", "Landroid/view/View;", "cancelAll", "cleanupAwaitingHandlers", "cleanupFinishedHandlers", "compactHandlersIf", "handlers", "count", "predicate", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "([Lcom/swmansion/gesturehandler/core/GestureHandler;ILkotlin/jvm/functions/Function1;)I", "deliverEventToGestureHandler", "sourceEvent", "Landroid/view/MotionEvent;", "deliverEventToGestureHandlers", "event", "extractAncestorHandlers", "coords", "", "pointerId", "extractGestureHandlers", "viewGroup", "hasOtherHandlerToWaitFor", "isClipping", "isViewAttachedUnderWrapper", "isViewOverflowingParent", "makeActive", "onHandlerStateChange", "newState", "prevState", "onTouchEvent", "recordHandlerIfNotPresent", "recordViewHandlersForPointer", "scheduleFinishedHandlersCleanup", "transformEventToViewCoords", "transformPointToViewCoords", "Landroid/graphics/PointF;", "point", "traverseWithPointerEvents", "tryActivate", "Companion", "react-native-gesture-handler_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GestureHandlerOrchestrator.kt */
public final class GestureHandlerOrchestrator {
    public static final Companion Companion = new Companion(null);
    public static final Comparator<GestureHandler<?>> handlersComparator = $$Lambda$vc0LM6DIGu1RswtZsUBezE8j2M.INSTANCE;
    public static final Matrix inverseMatrix = new Matrix();
    public static final float[] matrixTransformCoords = new float[2];
    public static final float[] tempCoords = new float[2];
    public static final PointF tempPoint = new PointF();
    public int activationIndex;
    public final GestureHandler<?>[] awaitingHandlers = new GestureHandler[20];
    public int awaitingHandlersCount;
    public boolean finishedHandlersCleanupScheduled;
    public final GestureHandler<?>[] gestureHandlers = new GestureHandler[20];
    public int gestureHandlersCount;
    public final GestureHandlerRegistry handlerRegistry;
    public final GestureHandler<?>[] handlersToCancel = new GestureHandler[20];
    public int handlingChangeSemaphore;
    public boolean isHandlingTouch;
    public float minimumAlphaForTraversal;
    public final GestureHandler<?>[] preparedHandlers = new GestureHandler[20];
    public final ViewConfigurationHelper viewConfigHelper;
    public final ViewGroup wrapperView;

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\t2\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\tH\u0002J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0006H\u0002J \u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J \u0010\u001c\u001a\u00020\u00122\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\t2\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\tH\u0002J \u0010\u001f\u001a\u00020\u00122\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\t2\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\tH\u0002J\u0018\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\rH\u0002J0\u0010#\u001a\u00020$2\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010%\u001a\u00020&2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\t0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/swmansion/gesturehandler/core/GestureHandlerOrchestrator$Companion;", "", "()V", "DEFAULT_MIN_ALPHA_FOR_TRAVERSAL", "", "SIMULTANEOUS_GESTURE_HANDLER_LIMIT", "", "handlersComparator", "Ljava/util/Comparator;", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "inverseMatrix", "Landroid/graphics/Matrix;", "matrixTransformCoords", "", "tempCoords", "tempPoint", "Landroid/graphics/PointF;", "canRunSimultaneously", "", "a", "b", "isFinished", "state", "isTransformedTouchPointInView", "x", "y", "child", "Landroid/view/View;", "shouldHandlerBeCancelledBy", "handler", "other", "shouldHandlerWaitForOther", "shouldHandlerlessViewBecomeTouchTarget", "view", "coords", "transformPointToChildViewCoords", "", "parent", "Landroid/view/ViewGroup;", "outLocalPoint", "react-native-gesture-handler_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GestureHandlerOrchestrator.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public static final boolean access$shouldHandlerBeCancelledBy(Companion companion, GestureHandler gestureHandler, GestureHandler gestureHandler2) {
            boolean z;
            Intrinsics.checkNotNullParameter(gestureHandler2, SMTNotificationConstants.NOTIF_ATTRIBUTION_OTHER);
            int length = gestureHandler.trackedPointerIDs.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = false;
                    break;
                }
                int i2 = i + 1;
                if (gestureHandler.trackedPointerIDs[i] != -1 && gestureHandler2.trackedPointerIDs[i] != -1) {
                    z = true;
                    break;
                }
                i = i2;
            }
            if (!z) {
                return false;
            }
            if (gestureHandler == gestureHandler2 || gestureHandler.shouldRecognizeSimultaneously(gestureHandler2) || gestureHandler2.shouldRecognizeSimultaneously(gestureHandler)) {
                return false;
            }
            if (gestureHandler == gestureHandler2 || (!gestureHandler.isAwaiting && gestureHandler.state != 4)) {
                return true;
            }
            return gestureHandler.shouldBeCancelledBy(gestureHandler2);
        }

        public static final boolean access$shouldHandlerlessViewBecomeTouchTarget(Companion companion, View view, float[] fArr) {
            if (!(!(view instanceof ViewGroup) || view.getBackground() != null) || !companion.isTransformedTouchPointInView(fArr[0], fArr[1], view)) {
                return false;
            }
            return true;
        }

        public final boolean isTransformedTouchPointInView(float f2, float f3, View view) {
            if (0.0f <= f2 && f2 <= ((float) view.getWidth())) {
                if (0.0f <= f3 && f3 <= ((float) view.getHeight())) {
                    return true;
                }
            }
            return false;
        }
    }

    public GestureHandlerOrchestrator(ViewGroup viewGroup, GestureHandlerRegistry gestureHandlerRegistry, ViewConfigurationHelper viewConfigurationHelper) {
        Intrinsics.checkNotNullParameter(viewGroup, "wrapperView");
        Intrinsics.checkNotNullParameter(gestureHandlerRegistry, "handlerRegistry");
        Intrinsics.checkNotNullParameter(viewConfigurationHelper, "viewConfigHelper");
        this.wrapperView = viewGroup;
        this.handlerRegistry = gestureHandlerRegistry;
        this.viewConfigHelper = viewConfigurationHelper;
    }

    /* renamed from: handlersComparator$lambda-12  reason: not valid java name */
    public static final int m53handlersComparator$lambda12(GestureHandler gestureHandler, GestureHandler gestureHandler2) {
        if ((gestureHandler.isActive && gestureHandler2.isActive) || (gestureHandler.isAwaiting && gestureHandler2.isAwaiting)) {
            return Integer.signum(gestureHandler2.activationIndex - gestureHandler.activationIndex);
        }
        if (!gestureHandler.isActive) {
            if (!gestureHandler2.isActive) {
                if (!gestureHandler.isAwaiting) {
                    if (!gestureHandler2.isAwaiting) {
                        return 0;
                    }
                }
            }
            return 1;
        }
        return -1;
    }

    public final void cleanupAwaitingHandlers() {
        GestureHandler<?>[] gestureHandlerArr = this.awaitingHandlers;
        int i = this.awaitingHandlersCount;
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            int i4 = i2 + 1;
            GestureHandler<?> gestureHandler = gestureHandlerArr[i2];
            Intrinsics.checkNotNull(gestureHandler);
            if (gestureHandler.isAwaiting) {
                gestureHandlerArr[i3] = gestureHandlerArr[i2];
                i2 = i4;
                i3++;
            } else {
                i2 = i4;
            }
        }
        this.awaitingHandlersCount = i3;
    }

    public final void cleanupFinishedHandlers() {
        int i = this.gestureHandlersCount - 1;
        boolean z = false;
        if (i >= 0) {
            while (true) {
                int i2 = i - 1;
                GestureHandler<?> gestureHandler = this.gestureHandlers[i];
                Intrinsics.checkNotNull(gestureHandler);
                int i3 = gestureHandler.state;
                if ((i3 == 3 || i3 == 1 || i3 == 5) && !gestureHandler.isAwaiting) {
                    this.gestureHandlers[i] = null;
                    gestureHandler.view = null;
                    gestureHandler.orchestrator = null;
                    Arrays.fill(gestureHandler.trackedPointerIDs, -1);
                    gestureHandler.trackedPointersIDsCount = 0;
                    gestureHandler.trackedPointersCount = 0;
                    ArraysKt___ArraysJvmKt.fill$default(gestureHandler.trackedPointers, null, 0, 0, 6);
                    gestureHandler.touchEventType = 0;
                    gestureHandler.onReset();
                    gestureHandler.isActive = false;
                    gestureHandler.isAwaiting = false;
                    gestureHandler.activationIndex = Integer.MAX_VALUE;
                    z = true;
                }
                if (i2 < 0) {
                    break;
                }
                i = i2;
            }
        }
        if (z) {
            GestureHandler<?>[] gestureHandlerArr = this.gestureHandlers;
            int i4 = this.gestureHandlersCount;
            int i5 = 0;
            int i6 = 0;
            while (i5 < i4) {
                int i7 = i5 + 1;
                if (gestureHandlerArr[i5] != null) {
                    gestureHandlerArr[i6] = gestureHandlerArr[i5];
                    i5 = i7;
                    i6++;
                } else {
                    i5 = i7;
                }
            }
            this.gestureHandlersCount = i6;
        }
        this.finishedHandlersCleanupScheduled = false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c1 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean extractGestureHandlers(android.view.ViewGroup r11, float[] r12, int r13) {
        /*
            r10 = this;
            int r0 = r11.getChildCount()
            r1 = 1
            int r0 = r0 - r1
            r2 = 0
            if (r0 < 0) goto L_0x00c8
        L_0x0009:
            int r3 = r0 + -1
            com.swmansion.gesturehandler.core.ViewConfigurationHelper r4 = r10.viewConfigHelper
            android.view.View r0 = r4.getChildInDrawingOrderAtIndex(r11, r0)
            int r4 = r0.getVisibility()
            if (r4 != 0) goto L_0x0023
            float r4 = r0.getAlpha()
            float r5 = r10.minimumAlphaForTraversal
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 < 0) goto L_0x0023
            r4 = 1
            goto L_0x0024
        L_0x0023:
            r4 = 0
        L_0x0024:
            if (r4 == 0) goto L_0x00c2
            android.graphics.PointF r4 = tempPoint
            r5 = r12[r2]
            r6 = r12[r1]
            int r7 = r11.getScrollX()
            float r7 = (float) r7
            float r5 = r5 + r7
            int r7 = r0.getLeft()
            float r7 = (float) r7
            float r5 = r5 - r7
            int r7 = r11.getScrollY()
            float r7 = (float) r7
            float r6 = r6 + r7
            int r7 = r0.getTop()
            float r7 = (float) r7
            float r6 = r6 - r7
            android.graphics.Matrix r7 = r0.getMatrix()
            boolean r8 = r7.isIdentity()
            if (r8 != 0) goto L_0x0062
            float[] r8 = matrixTransformCoords
            r8[r2] = r5
            r8[r1] = r6
            android.graphics.Matrix r5 = inverseMatrix
            r7.invert(r5)
            android.graphics.Matrix r5 = inverseMatrix
            r5.mapPoints(r8)
            r5 = r8[r2]
            r6 = r8[r1]
        L_0x0062:
            r4.set(r5, r6)
            r5 = r12[r2]
            r6 = r12[r1]
            float r7 = r4.x
            r12[r2] = r7
            float r4 = r4.y
            r12[r1] = r4
            boolean r4 = r0 instanceof android.view.ViewGroup
            if (r4 == 0) goto L_0x0083
            com.swmansion.gesturehandler.core.ViewConfigurationHelper r4 = r10.viewConfigHelper
            r7 = r0
            android.view.ViewGroup r7 = (android.view.ViewGroup) r7
            boolean r4 = r4.isViewClippingChildren(r7)
            if (r4 == 0) goto L_0x0081
            goto L_0x0083
        L_0x0081:
            r4 = 0
            goto L_0x0084
        L_0x0083:
            r4 = 1
        L_0x0084:
            if (r4 == 0) goto L_0x00b7
            r4 = r12[r2]
            r7 = r12[r1]
            r8 = 0
            int r9 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r9 > 0) goto L_0x009a
            int r9 = r0.getWidth()
            float r9 = (float) r9
            int r4 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r4 > 0) goto L_0x009a
            r4 = 1
            goto L_0x009b
        L_0x009a:
            r4 = 0
        L_0x009b:
            if (r4 == 0) goto L_0x00b1
            int r4 = (r8 > r7 ? 1 : (r8 == r7 ? 0 : -1))
            if (r4 > 0) goto L_0x00ac
            int r4 = r0.getHeight()
            float r4 = (float) r4
            int r4 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r4 > 0) goto L_0x00ac
            r4 = 1
            goto L_0x00ad
        L_0x00ac:
            r4 = 0
        L_0x00ad:
            if (r4 == 0) goto L_0x00b1
            r4 = 1
            goto L_0x00b2
        L_0x00b1:
            r4 = 0
        L_0x00b2:
            if (r4 == 0) goto L_0x00b5
            goto L_0x00b7
        L_0x00b5:
            r0 = 0
            goto L_0x00bb
        L_0x00b7:
            boolean r0 = r10.traverseWithPointerEvents(r0, r12, r13)
        L_0x00bb:
            r12[r2] = r5
            r12[r1] = r6
            if (r0 == 0) goto L_0x00c2
            return r1
        L_0x00c2:
            if (r3 >= 0) goto L_0x00c5
            goto L_0x00c8
        L_0x00c5:
            r0 = r3
            goto L_0x0009
        L_0x00c8:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.gesturehandler.core.GestureHandlerOrchestrator.extractGestureHandlers(android.view.ViewGroup, float[], int):boolean");
    }

    public final void recordHandlerIfNotPresent(GestureHandler<?> gestureHandler, View view) {
        int i = this.gestureHandlersCount;
        int i2 = 0;
        while (i2 < i) {
            int i3 = i2 + 1;
            if (this.gestureHandlers[i2] != gestureHandler) {
                i2 = i3;
            } else {
                return;
            }
        }
        if (this.gestureHandlersCount < this.gestureHandlers.length) {
            GestureHandler<?>[] gestureHandlerArr = this.gestureHandlers;
            int i4 = this.gestureHandlersCount;
            this.gestureHandlersCount = i4 + 1;
            gestureHandlerArr[i4] = gestureHandler;
            gestureHandler.isActive = false;
            gestureHandler.isAwaiting = false;
            gestureHandler.activationIndex = Integer.MAX_VALUE;
            if (gestureHandler.view == null && gestureHandler.orchestrator == null) {
                Arrays.fill(gestureHandler.trackedPointerIDs, -1);
                gestureHandler.trackedPointersIDsCount = 0;
                gestureHandler.state = 0;
                gestureHandler.view = view;
                gestureHandler.orchestrator = this;
                View view2 = null;
                Window window = gestureHandler.getWindow(view.getContext());
                if (window != null) {
                    view2 = window.getDecorView();
                }
                if (view2 != null) {
                    Rect rect = new Rect();
                    view2.getWindowVisibleDisplayFrame(rect);
                    int[] iArr = gestureHandler.windowOffset;
                    iArr[0] = rect.left;
                    iArr[1] = rect.top;
                } else {
                    int[] iArr2 = gestureHandler.windowOffset;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                }
                gestureHandler.onPrepare();
                return;
            }
            throw new IllegalStateException("Already prepared or hasn't been reset".toString());
        }
        throw new IllegalStateException("Too many recognizers".toString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00bb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean recordViewHandlersForPointer(android.view.View r12, float[] r13, int r14) {
        /*
            r11 = this;
            com.swmansion.gesturehandler.core.GestureHandlerRegistry r0 = r11.handlerRegistry
            java.util.ArrayList r0 = r0.getHandlersForView(r12)
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x000c
            r4 = 0
            goto L_0x003a
        L_0x000c:
            monitor-enter(r0)
            java.util.Iterator r3 = r0.iterator()     // Catch:{ all -> 0x0110 }
            r4 = 0
        L_0x0012:
            boolean r5 = r3.hasNext()     // Catch:{ all -> 0x0110 }
            if (r5 == 0) goto L_0x0039
            java.lang.Object r5 = r3.next()     // Catch:{ all -> 0x0110 }
            com.swmansion.gesturehandler.core.GestureHandler r5 = (com.swmansion.gesturehandler.core.GestureHandler) r5     // Catch:{ all -> 0x0110 }
            boolean r6 = r5.isEnabled     // Catch:{ all -> 0x0110 }
            if (r6 == 0) goto L_0x0012
            r6 = r13[r2]     // Catch:{ all -> 0x0110 }
            r7 = r13[r1]     // Catch:{ all -> 0x0110 }
            boolean r6 = r5.isWithinBounds(r12, r6, r7)     // Catch:{ all -> 0x0110 }
            if (r6 == 0) goto L_0x0012
            java.lang.String r4 = "handler"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r4)     // Catch:{ all -> 0x0110 }
            r11.recordHandlerIfNotPresent(r5, r12)     // Catch:{ all -> 0x0110 }
            r5.startTrackingPointer(r14)     // Catch:{ all -> 0x0110 }
            r4 = 1
            goto L_0x0012
        L_0x0039:
            monitor-exit(r0)
        L_0x003a:
            int r0 = r12.getWidth()
            float r0 = (float) r0
            r3 = r13[r2]
            r5 = 0
            int r6 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r6 > 0) goto L_0x004c
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 > 0) goto L_0x004c
            r0 = 1
            goto L_0x004d
        L_0x004c:
            r0 = 0
        L_0x004d:
            if (r0 == 0) goto L_0x010e
            int r0 = r12.getHeight()
            float r0 = (float) r0
            r3 = r13[r1]
            int r6 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r6 > 0) goto L_0x0060
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 > 0) goto L_0x0060
            r0 = 1
            goto L_0x0061
        L_0x0060:
            r0 = 0
        L_0x0061:
            if (r0 == 0) goto L_0x010e
            android.view.ViewParent r0 = r12.getParent()
            boolean r3 = r0 instanceof android.view.ViewGroup
            if (r3 == 0) goto L_0x006e
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            goto L_0x006f
        L_0x006e:
            r0 = 0
        L_0x006f:
            if (r0 != 0) goto L_0x0072
            goto L_0x00b6
        L_0x0072:
            android.graphics.Matrix r3 = r12.getMatrix()
            float[] r6 = matrixTransformCoords
            r6[r2] = r5
            r6[r1] = r5
            r3.mapPoints(r6)
            r3 = r6[r2]
            int r7 = r12.getLeft()
            float r7 = (float) r7
            float r3 = r3 + r7
            r6 = r6[r1]
            int r7 = r12.getTop()
            float r7 = (float) r7
            float r6 = r6 + r7
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 < 0) goto L_0x00b8
            int r7 = r12.getWidth()
            float r7 = (float) r7
            float r3 = r3 + r7
            int r7 = r0.getWidth()
            float r7 = (float) r7
            int r3 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r3 > 0) goto L_0x00b8
            int r3 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r3 < 0) goto L_0x00b8
            int r3 = r12.getHeight()
            float r3 = (float) r3
            float r6 = r6 + r3
            int r0 = r0.getHeight()
            float r0 = (float) r0
            int r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x00b6
            goto L_0x00b8
        L_0x00b6:
            r0 = 0
            goto L_0x00b9
        L_0x00b8:
            r0 = 1
        L_0x00b9:
            if (r0 == 0) goto L_0x010e
            android.view.ViewParent r0 = r12.getParent()
            r3 = 0
        L_0x00c0:
            if (r0 == 0) goto L_0x010b
            boolean r5 = r0 instanceof android.view.ViewGroup
            if (r5 == 0) goto L_0x0106
            r5 = r0
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
            com.swmansion.gesturehandler.core.GestureHandlerRegistry r6 = r11.handlerRegistry
            r7 = r0
            android.view.View r7 = (android.view.View) r7
            java.util.ArrayList r6 = r6.getHandlersForView(r7)
            if (r6 != 0) goto L_0x00d5
            goto L_0x0106
        L_0x00d5:
            monitor-enter(r6)
            java.util.Iterator r7 = r6.iterator()     // Catch:{ all -> 0x0103 }
        L_0x00da:
            boolean r8 = r7.hasNext()     // Catch:{ all -> 0x0103 }
            if (r8 == 0) goto L_0x0101
            java.lang.Object r8 = r7.next()     // Catch:{ all -> 0x0103 }
            com.swmansion.gesturehandler.core.GestureHandler r8 = (com.swmansion.gesturehandler.core.GestureHandler) r8     // Catch:{ all -> 0x0103 }
            boolean r9 = r8.isEnabled     // Catch:{ all -> 0x0103 }
            if (r9 == 0) goto L_0x00da
            r9 = r13[r2]     // Catch:{ all -> 0x0103 }
            r10 = r13[r1]     // Catch:{ all -> 0x0103 }
            boolean r9 = r8.isWithinBounds(r12, r9, r10)     // Catch:{ all -> 0x0103 }
            if (r9 == 0) goto L_0x00da
            java.lang.String r3 = "handler"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r3)     // Catch:{ all -> 0x0103 }
            r11.recordHandlerIfNotPresent(r8, r5)     // Catch:{ all -> 0x0103 }
            r8.startTrackingPointer(r14)     // Catch:{ all -> 0x0103 }
            r3 = 1
            goto L_0x00da
        L_0x0101:
            monitor-exit(r6)
            goto L_0x0106
        L_0x0103:
            r12 = move-exception
            monitor-exit(r6)
            throw r12
        L_0x0106:
            android.view.ViewParent r0 = r0.getParent()
            goto L_0x00c0
        L_0x010b:
            if (r3 == 0) goto L_0x010e
            goto L_0x010f
        L_0x010e:
            r1 = r4
        L_0x010f:
            return r1
        L_0x0110:
            r12 = move-exception
            monitor-exit(r0)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.gesturehandler.core.GestureHandlerOrchestrator.recordViewHandlersForPointer(android.view.View, float[], int):boolean");
    }

    public final MotionEvent transformEventToViewCoords(View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        if (view == null) {
            return motionEvent;
        }
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (!Intrinsics.areEqual(viewGroup, this.wrapperView)) {
            transformEventToViewCoords(viewGroup, motionEvent);
        }
        if (viewGroup != null) {
            motionEvent.setLocation((motionEvent.getX() + ((float) viewGroup.getScrollX())) - ((float) view.getLeft()), (motionEvent.getY() + ((float) viewGroup.getScrollY())) - ((float) view.getTop()));
        }
        if (!view.getMatrix().isIdentity()) {
            view.getMatrix().invert(inverseMatrix);
            motionEvent.transform(inverseMatrix);
        }
        return motionEvent;
    }

    public final PointF transformPointToViewCoords(View view, PointF pointF) {
        Intrinsics.checkNotNullParameter(pointF, "point");
        if (view == null) {
            return pointF;
        }
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (!Intrinsics.areEqual(viewGroup, this.wrapperView)) {
            transformPointToViewCoords(viewGroup, pointF);
        }
        if (viewGroup != null) {
            pointF.x += (float) (viewGroup.getScrollX() - view.getLeft());
            pointF.y += (float) (viewGroup.getScrollY() - view.getTop());
        }
        if (!view.getMatrix().isIdentity()) {
            view.getMatrix().invert(inverseMatrix);
            float[] fArr = tempCoords;
            fArr[0] = pointF.x;
            fArr[1] = pointF.y;
            inverseMatrix.mapPoints(fArr);
            float[] fArr2 = tempCoords;
            pointF.x = fArr2[0];
            pointF.y = fArr2[1];
        }
        return pointF;
    }

    public final boolean traverseWithPointerEvents(View view, float[] fArr, int i) {
        int ordinal = this.viewConfigHelper.getPointerEventsConfigForView(view).ordinal();
        if (ordinal != 0) {
            if (ordinal != 1) {
                if (ordinal != 2) {
                    if (ordinal == 3) {
                        boolean extractGestureHandlers = view instanceof ViewGroup ? extractGestureHandlers((ViewGroup) view, fArr, i) : false;
                        if (recordViewHandlersForPointer(view, fArr, i) || extractGestureHandlers || Companion.access$shouldHandlerlessViewBecomeTouchTarget(Companion, view, fArr)) {
                            return true;
                        }
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else if (recordViewHandlersForPointer(view, fArr, i) || Companion.access$shouldHandlerlessViewBecomeTouchTarget(Companion, view, fArr)) {
                    return true;
                }
            } else if (view instanceof ViewGroup) {
                boolean extractGestureHandlers2 = extractGestureHandlers((ViewGroup) view, fArr, i);
                if (!extractGestureHandlers2) {
                    return extractGestureHandlers2;
                }
                recordViewHandlersForPointer(view, fArr, i);
                return extractGestureHandlers2;
            } else if (view instanceof EditText) {
                return recordViewHandlersForPointer(view, fArr, i);
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0046, code lost:
        if (r2 == false) goto L_0x004a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x004d A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x004f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void tryActivate(com.swmansion.gesturehandler.core.GestureHandler<?> r11) {
        /*
            r10 = this;
            int r0 = r10.gestureHandlersCount
            r1 = 0
            r2 = 0
        L_0x0004:
            r3 = 5
            r4 = 1
            if (r2 >= r0) goto L_0x0051
            int r5 = r2 + 1
            com.swmansion.gesturehandler.core.GestureHandler<?>[] r6 = r10.gestureHandlers
            r2 = r6[r2]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            int r6 = r2.state
            r7 = 3
            if (r6 == r7) goto L_0x001d
            if (r6 == r4) goto L_0x001d
            if (r6 != r3) goto L_0x001b
            goto L_0x001d
        L_0x001b:
            r6 = 0
            goto L_0x001e
        L_0x001d:
            r6 = 1
        L_0x001e:
            if (r6 != 0) goto L_0x004f
            if (r11 == r2) goto L_0x004a
            java.lang.String r6 = "handler"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r6)
            if (r2 != r11) goto L_0x002a
            goto L_0x002e
        L_0x002a:
            com.swmansion.gesturehandler.core.GestureHandlerInteractionController r7 = r11.interactionController
            if (r7 != 0) goto L_0x0030
        L_0x002e:
            r7 = 0
            goto L_0x0034
        L_0x0030:
            boolean r7 = r7.shouldWaitForHandlerFailure(r11, r2)
        L_0x0034:
            if (r7 != 0) goto L_0x0048
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r6)
            if (r11 != r2) goto L_0x003c
            goto L_0x0040
        L_0x003c:
            com.swmansion.gesturehandler.core.GestureHandlerInteractionController r6 = r2.interactionController
            if (r6 != 0) goto L_0x0042
        L_0x0040:
            r2 = 0
            goto L_0x0046
        L_0x0042:
            boolean r2 = r6.shouldRequireHandlerToWaitForFailure(r2, r11)
        L_0x0046:
            if (r2 == 0) goto L_0x004a
        L_0x0048:
            r2 = 1
            goto L_0x004b
        L_0x004a:
            r2 = 0
        L_0x004b:
            if (r2 == 0) goto L_0x004f
            r0 = 1
            goto L_0x0052
        L_0x004f:
            r2 = r5
            goto L_0x0004
        L_0x0051:
            r0 = 0
        L_0x0052:
            if (r0 == 0) goto L_0x0091
            int r0 = r10.awaitingHandlersCount
            r2 = 0
        L_0x0057:
            if (r2 >= r0) goto L_0x0065
            int r3 = r2 + 1
            com.swmansion.gesturehandler.core.GestureHandler<?>[] r5 = r10.awaitingHandlers
            r2 = r5[r2]
            if (r2 != r11) goto L_0x0063
            goto L_0x010b
        L_0x0063:
            r2 = r3
            goto L_0x0057
        L_0x0065:
            int r0 = r10.awaitingHandlersCount
            com.swmansion.gesturehandler.core.GestureHandler<?>[] r2 = r10.awaitingHandlers
            int r2 = r2.length
            if (r0 >= r2) goto L_0x006d
            r1 = 1
        L_0x006d:
            if (r1 == 0) goto L_0x0085
            com.swmansion.gesturehandler.core.GestureHandler<?>[] r0 = r10.awaitingHandlers
            int r1 = r10.awaitingHandlersCount
            int r2 = r1 + 1
            r10.awaitingHandlersCount = r2
            r0[r1] = r11
            r11.isAwaiting = r4
            int r0 = r10.activationIndex
            int r1 = r0 + 1
            r10.activationIndex = r1
            r11.activationIndex = r0
            goto L_0x010b
        L_0x0085:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "Too many recognizers"
            java.lang.String r0 = r0.toString()
            r11.<init>(r0)
            throw r11
        L_0x0091:
            int r0 = r11.state
            r11.isAwaiting = r1
            r11.isActive = r4
            r11.shouldResetProgress = r4
            int r2 = r10.activationIndex
            int r5 = r2 + 1
            r10.activationIndex = r5
            r11.activationIndex = r2
            int r2 = r10.gestureHandlersCount
            r5 = 0
            r6 = 0
        L_0x00a5:
            if (r5 >= r2) goto L_0x00c3
            int r7 = r5 + 1
            com.swmansion.gesturehandler.core.GestureHandler<?>[] r8 = r10.gestureHandlers
            r5 = r8[r5]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            com.swmansion.gesturehandler.core.GestureHandlerOrchestrator$Companion r8 = Companion
            boolean r8 = com.swmansion.gesturehandler.core.GestureHandlerOrchestrator.Companion.access$shouldHandlerBeCancelledBy(r8, r5, r11)
            if (r8 == 0) goto L_0x00c1
            com.swmansion.gesturehandler.core.GestureHandler<?>[] r8 = r10.handlersToCancel
            int r9 = r6 + 1
            r8[r6] = r5
            r5 = r7
            r6 = r9
            goto L_0x00a5
        L_0x00c1:
            r5 = r7
            goto L_0x00a5
        L_0x00c3:
            int r6 = r6 - r4
            if (r6 < 0) goto L_0x00d7
        L_0x00c6:
            int r2 = r6 + -1
            com.swmansion.gesturehandler.core.GestureHandler<?>[] r5 = r10.handlersToCancel
            r5 = r5[r6]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            r5.cancel()
            if (r2 >= 0) goto L_0x00d5
            goto L_0x00d7
        L_0x00d5:
            r6 = r2
            goto L_0x00c6
        L_0x00d7:
            int r2 = r10.awaitingHandlersCount
            int r2 = r2 - r4
            if (r2 < 0) goto L_0x00f7
        L_0x00dc:
            int r4 = r2 + -1
            com.swmansion.gesturehandler.core.GestureHandler<?>[] r5 = r10.awaitingHandlers
            r2 = r5[r2]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            com.swmansion.gesturehandler.core.GestureHandlerOrchestrator$Companion r5 = Companion
            boolean r5 = com.swmansion.gesturehandler.core.GestureHandlerOrchestrator.Companion.access$shouldHandlerBeCancelledBy(r5, r2, r11)
            if (r5 == 0) goto L_0x00f2
            r2.cancel()
            r2.isAwaiting = r1
        L_0x00f2:
            if (r4 >= 0) goto L_0x00f5
            goto L_0x00f7
        L_0x00f5:
            r2 = r4
            goto L_0x00dc
        L_0x00f7:
            r10.cleanupAwaitingHandlers()
            r2 = 2
            r4 = 4
            r11.dispatchStateChange(r4, r2)
            if (r0 == r4) goto L_0x0109
            r11.dispatchStateChange(r3, r4)
            if (r0 == r3) goto L_0x0109
            r11.dispatchStateChange(r1, r3)
        L_0x0109:
            r11.isAwaiting = r1
        L_0x010b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.gesturehandler.core.GestureHandlerOrchestrator.tryActivate(com.swmansion.gesturehandler.core.GestureHandler):void");
    }
}
