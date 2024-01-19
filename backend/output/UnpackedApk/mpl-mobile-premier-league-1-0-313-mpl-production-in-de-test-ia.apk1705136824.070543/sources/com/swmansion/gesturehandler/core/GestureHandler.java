package com.swmansion.gesturehandler.core;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.MotionEvent.PointerCoords;
import android.view.MotionEvent.PointerProperties;
import android.view.View;
import android.view.Window;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.swmansion.gesturehandler.core.GestureHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.CharsKt__CharKt;

@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 »\u0001*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00002\u00020\u0002:\u0006º\u0001»\u0001¼\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\\\u001a\u00020]J\u0010\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020\u001dH\u0016J\u0010\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020`H\u0002J\u0010\u0010b\u001a\u00020]2\u0006\u0010c\u001a\u00020NH\u0002J\u0010\u0010d\u001a\u00020]2\u0006\u0010c\u001a\u00020NH\u0002J*\u0010e\u001a\u00028\u00002\u0017\u0010f\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020]0g¢\u0006\u0002\bhH\bø\u0001\u0000¢\u0006\u0002\u0010iJ\u0006\u0010j\u001a\u00020]J\u0006\u0010k\u001a\u00020]J\b\u0010l\u001a\u00020]H\u0002J\b\u0010m\u001a\u0004\u0018\u00010\u000eJ\b\u0010n\u001a\u0004\u0018\u00010\u000eJ\u0018\u0010o\u001a\n q*\u0004\u0018\u00010p0p2\u0006\u0010c\u001a\u00020NH\u0002J\u0010\u0010r\u001a\u00020]2\u0006\u0010a\u001a\u00020`H\u0016J\u0018\u0010s\u001a\u00020]2\u0006\u0010t\u001a\u00020\u00052\u0006\u0010u\u001a\u00020\u0005H\u0016J\u0010\u0010v\u001a\u00020]2\u0006\u0010a\u001a\u00020`H\u0002J\b\u0010w\u001a\u00020]H\u0016J\u0010\u0010x\u001a\u00020]2\u0006\u0010a\u001a\u00020`H\u0002J\u0010\u0010y\u001a\u00020]2\u0006\u0010a\u001a\u00020`H\u0002J\u0006\u0010z\u001a\u00020]J\b\u0010{\u001a\u00020]H\u0002J\u0006\u0010|\u001a\u00020]J\b\u0010}\u001a\u00020\u0005H\u0002J\u0016\u0010~\u001a\u0004\u0018\u000102\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0002J\u0019\u0010\u0001\u001a\u00020]2\u0007\u0010\u0001\u001a\u00020`2\u0007\u0010\u0001\u001a\u00020`J\u0014\u0010\u0001\u001a\u00020\u001d2\u000b\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000J\"\u0010$\u001a\u00020\u001d2\b\u0010T\u001a\u0004\u0018\u00010S2\u0007\u0010\u0001\u001a\u00020%2\u0007\u0010\u0001\u001a\u00020%J\u0011\u0010\u0001\u001a\u00020]2\u0006\u0010t\u001a\u00020\u0005H\u0002J\u0011\u0010\u0001\u001a\u00020\u001d2\u0006\u0010a\u001a\u00020`H\u0002J\t\u0010\u0001\u001a\u00020]H\u0014J\u001a\u0010\u0001\u001a\u00020]2\u0006\u0010a\u001a\u00020`2\u0007\u0010\u0001\u001a\u00020`H\u0014J\t\u0010\u0001\u001a\u00020]H\u0014J\t\u0010\u0001\u001a\u00020]H\u0014J\u001a\u0010\u0001\u001a\u00020]2\u0006\u0010t\u001a\u00020\u00052\u0007\u0010\u0001\u001a\u00020\u0005H\u0014J\u001b\u0010\u0001\u001a\u00020]2\b\u0010T\u001a\u0004\u0018\u00010S2\b\u0010=\u001a\u0004\u0018\u00010>J\u0007\u0010\u0001\u001a\u00020]J\t\u0010\u0001\u001a\u00020]H\u0016J\t\u0010\u0001\u001a\u00020]H\u0016J\u000f\u0010\u0001\u001a\u00028\u0000H\u0004¢\u0006\u0003\u0010\u0001J\u0016\u0010\u0001\u001a\u00028\u00002\u0007\u0010\u0001\u001a\u00020\u001d¢\u0006\u0003\u0010\u0001J\u0016\u0010\u0001\u001a\u00028\u00002\u0007\u0010\u0001\u001a\u00020%¢\u0006\u0003\u0010\u0001JC\u0010\u0001\u001a\u00028\u00002\u0007\u0010\u0001\u001a\u00020%2\u0007\u0010\u0001\u001a\u00020%2\u0007\u0010\u0001\u001a\u00020%2\u0007\u0010 \u0001\u001a\u00020%2\u0007\u0010¡\u0001\u001a\u00020%2\u0007\u0010¢\u0001\u001a\u00020%¢\u0006\u0003\u0010£\u0001J\u0018\u0010¤\u0001\u001a\u00028\u00002\t\u0010¥\u0001\u001a\u0004\u0018\u00010\u001b¢\u0006\u0003\u0010¦\u0001J\u0015\u0010§\u0001\u001a\u00028\u00002\u0006\u00105\u001a\u00020\u001d¢\u0006\u0003\u0010\u0001J\u0016\u0010¨\u0001\u001a\u0006\u0012\u0002\b\u00030\u00002\t\u0010©\u0001\u001a\u0004\u0018\u00010<J\u0015\u0010ª\u0001\u001a\u00028\u00002\u0006\u0010?\u001a\u00020\u001d¢\u0006\u0003\u0010\u0001J\u0016\u0010«\u0001\u001a\u00020\u001d2\u000b\u0010¬\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0016J\u0016\u0010­\u0001\u001a\u00020\u001d2\u000b\u0010¬\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0016J\u0016\u0010®\u0001\u001a\u00020\u001d2\u000b\u0010¬\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0016J\u0014\u0010¯\u0001\u001a\u00020\u001d2\u000b\u0010¬\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000J\u0010\u0010°\u0001\u001a\u00020]2\u0007\u0010±\u0001\u001a\u00020\u0005J\u0010\u0010²\u0001\u001a\u00020]2\u0007\u0010±\u0001\u001a\u00020\u0005J\n\u0010³\u0001\u001a\u00030´\u0001H\u0016J\u0014\u0010µ\u0001\u001a\u00030¶\u00012\b\u0010·\u0001\u001a\u00030¶\u0001H\u0004J\u000f\u0010¸\u0001\u001a\u00020]2\u0006\u0010a\u001a\u00020`J\u0007\u0010¹\u0001\u001a\u00020\u001dR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\"\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u001e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u0014@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001e\"\u0004\b\"\u0010 R\u001e\u0010#\u001a\u00020\u001d2\u0006\u0010\r\u001a\u00020\u001d@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001eR\u001e\u0010$\u001a\u00020\u001d2\u0006\u0010\r\u001a\u00020\u001d@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001eR\u001e\u0010&\u001a\u00020%2\u0006\u0010\r\u001a\u00020%@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001e\u0010)\u001a\u00020%2\u0006\u0010\r\u001a\u00020%@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010(R\u000e\u0010+\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010-\u001a\u00020%8F¢\u0006\u0006\u001a\u0004\b.\u0010(R\u0011\u0010/\u001a\u00020%8F¢\u0006\u0006\u001a\u0004\b0\u0010(R\u0011\u00101\u001a\u00020%8F¢\u0006\u0006\u001a\u0004\b2\u0010(R\u0011\u00103\u001a\u00020%8F¢\u0006\u0006\u001a\u0004\b4\u0010(R\u000e\u00105\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u001a\u00106\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001e\"\u0004\b8\u0010 R\u001e\u00109\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u0007R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010@\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u001e\"\u0004\bB\u0010 R\u001e\u0010C\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bD\u0010\u0007R\u001a\u0010E\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0007\"\u0004\bG\u0010\tR\u001e\u0010H\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bI\u0010\u0007R\u000e\u0010J\u001a\u00020KX\u0004¢\u0006\u0002\n\u0000R\u0018\u0010L\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010N0MX\u0004¢\u0006\u0004\n\u0002\u0010OR\u001e\u0010P\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010\u0007R\u000e\u0010R\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\"\u0010T\u001a\u0004\u0018\u00010S2\b\u0010\r\u001a\u0004\u0018\u00010S@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bU\u0010VR\u000e\u0010W\u001a\u00020KX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010X\u001a\u00020%2\u0006\u0010\r\u001a\u00020%@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bY\u0010(R\u001e\u0010Z\u001a\u00020%2\u0006\u0010\r\u001a\u00020%@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b[\u0010(\u0002\u0007\n\u0005\b20\u0001¨\u0006½\u0001"}, d2 = {"Lcom/swmansion/gesturehandler/core/GestureHandler;", "ConcreteGestureHandlerT", "", "()V", "actionType", "", "getActionType", "()I", "setActionType", "(I)V", "activationIndex", "getActivationIndex", "setActivationIndex", "<set-?>", "Lcom/facebook/react/bridge/WritableArray;", "allTouchesPayload", "getAllTouchesPayload", "()Lcom/facebook/react/bridge/WritableArray;", "changedTouchesPayload", "getChangedTouchesPayload", "", "eventCoalescingKey", "getEventCoalescingKey", "()S", "hitSlop", "", "interactionController", "Lcom/swmansion/gesturehandler/core/GestureHandlerInteractionController;", "isActive", "", "()Z", "setActive", "(Z)V", "isAwaiting", "setAwaiting", "isEnabled", "isWithinBounds", "", "lastAbsolutePositionX", "getLastAbsolutePositionX", "()F", "lastAbsolutePositionY", "getLastAbsolutePositionY", "lastEventOffsetX", "lastEventOffsetY", "lastPositionInWindowX", "getLastPositionInWindowX", "lastPositionInWindowY", "getLastPositionInWindowY", "lastRelativePositionX", "getLastRelativePositionX", "lastRelativePositionY", "getLastRelativePositionY", "manualActivation", "needsPointerData", "getNeedsPointerData", "setNeedsPointerData", "numberOfPointers", "getNumberOfPointers", "onTouchEventListener", "Lcom/swmansion/gesturehandler/core/OnTouchEventListener;", "orchestrator", "Lcom/swmansion/gesturehandler/core/GestureHandlerOrchestrator;", "shouldCancelWhenOutside", "shouldResetProgress", "getShouldResetProgress", "setShouldResetProgress", "state", "getState", "tag", "getTag", "setTag", "touchEventType", "getTouchEventType", "trackedPointerIDs", "", "trackedPointers", "", "Lcom/swmansion/gesturehandler/core/GestureHandler$PointerData;", "[Lcom/swmansion/gesturehandler/core/GestureHandler$PointerData;", "trackedPointersCount", "getTrackedPointersCount", "trackedPointersIDsCount", "Landroid/view/View;", "view", "getView", "()Landroid/view/View;", "windowOffset", "x", "getX", "y", "getY", "activate", "", "force", "adaptEvent", "Landroid/view/MotionEvent;", "event", "addChangedPointer", "pointerData", "addPointerToAll", "applySelf", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)Lcom/swmansion/gesturehandler/core/GestureHandler;", "begin", "cancel", "cancelPointers", "consumeAllTouchesPayload", "consumeChangedTouchesPayload", "createPointerData", "Lcom/facebook/react/bridge/WritableMap;", "kotlin.jvm.PlatformType", "dispatchHandlerUpdate", "dispatchStateChange", "newState", "prevState", "dispatchTouchDownEvent", "dispatchTouchEvent", "dispatchTouchMoveEvent", "dispatchTouchUpEvent", "end", "extractAllPointersData", "fail", "findNextLocalPointerId", "getWindow", "Landroid/view/Window;", "context", "Landroid/content/Context;", "handle", "transformedEvent", "sourceEvent", "hasCommonPointers", "other", "posX", "posY", "moveToState", "needAdapt", "onCancel", "onHandle", "onPrepare", "onReset", "onStateChange", "previousState", "prepare", "reset", "resetConfig", "resetProgress", "self", "()Lcom/swmansion/gesturehandler/core/GestureHandler;", "setEnabled", "enabled", "(Z)Lcom/swmansion/gesturehandler/core/GestureHandler;", "setHitSlop", "padding", "(F)Lcom/swmansion/gesturehandler/core/GestureHandler;", "leftPad", "topPad", "rightPad", "bottomPad", "width", "height", "(FFFFFF)Lcom/swmansion/gesturehandler/core/GestureHandler;", "setInteractionController", "controller", "(Lcom/swmansion/gesturehandler/core/GestureHandlerInteractionController;)Lcom/swmansion/gesturehandler/core/GestureHandler;", "setManualActivation", "setOnTouchEventListener", "listener", "setShouldCancelWhenOutside", "shouldBeCancelledBy", "handler", "shouldRecognizeSimultaneously", "shouldRequireToWaitForFailure", "shouldWaitForHandlerFailure", "startTrackingPointer", "pointerId", "stopTrackingPointer", "toString", "", "transformPoint", "Landroid/graphics/PointF;", "point", "updatePointerData", "wantEvents", "AdaptEventException", "Companion", "PointerData", "react-native-gesture-handler_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GestureHandler.kt */
public class GestureHandler<ConcreteGestureHandlerT extends GestureHandler<ConcreteGestureHandlerT>> {
    public static final Companion Companion = new Companion(null);
    public static short nextEventCoalescingKey;
    public static PointerCoords[] pointerCoords;
    public static PointerProperties[] pointerProps;
    public int actionType;
    public int activationIndex;
    public WritableArray allTouchesPayload;
    public WritableArray changedTouchesPayload;
    public short eventCoalescingKey;
    public float[] hitSlop;
    public GestureHandlerInteractionController interactionController;
    public boolean isActive;
    public boolean isAwaiting;
    public boolean isEnabled;
    public boolean isWithinBounds;
    public float lastAbsolutePositionX;
    public float lastAbsolutePositionY;
    public float lastEventOffsetX;
    public float lastEventOffsetY;
    public boolean manualActivation;
    public boolean needsPointerData;
    public int numberOfPointers;
    public OnTouchEventListener onTouchEventListener;
    public GestureHandlerOrchestrator orchestrator;
    public boolean shouldCancelWhenOutside;
    public boolean shouldResetProgress;
    public int state;
    public int tag;
    public int touchEventType;
    public final int[] trackedPointerIDs = new int[12];
    public final PointerData[] trackedPointers;
    public int trackedPointersCount;
    public int trackedPointersIDsCount;
    public View view;
    public final int[] windowOffset;
    public float x;
    public float y;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B%\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\u0010\u0007\u001a\u00060\bj\u0002`\t¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/swmansion/gesturehandler/core/GestureHandler$AdaptEventException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "handler", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "event", "Landroid/view/MotionEvent;", "e", "Ljava/lang/IllegalArgumentException;", "Lkotlin/IllegalArgumentException;", "(Lcom/swmansion/gesturehandler/core/GestureHandler;Landroid/view/MotionEvent;Ljava/lang/IllegalArgumentException;)V", "react-native-gesture-handler_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GestureHandler.kt */
    public static final class AdaptEventException extends Exception {
        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public AdaptEventException(GestureHandler<?> gestureHandler, MotionEvent motionEvent, IllegalArgumentException illegalArgumentException) {
            // Intrinsics.checkNotNullParameter(gestureHandler, "handler");
            // Intrinsics.checkNotNullParameter(motionEvent, "event");
            // Intrinsics.checkNotNullParameter(illegalArgumentException, "e");
            // StringBuilder sb = new StringBuilder();
            // sb.append("\n    handler: ");
            // sb.append(Reflection.getOrCreateKotlinClass(gestureHandler.getClass()).getSimpleName());
            // sb.append("\n    state: ");
            // sb.append(gestureHandler.state);
            // sb.append("\n    view: ");
            // sb.append(gestureHandler.view);
            // sb.append("\n    orchestrator: ");
            // sb.append(gestureHandler.orchestrator);
            // sb.append("\n    isEnabled: ");
            // sb.append(gestureHandler.isEnabled);
            // sb.append("\n    isActive: ");
            // sb.append(gestureHandler.isActive);
            // sb.append("\n    isAwaiting: ");
            // sb.append(gestureHandler.isAwaiting);
            // sb.append("\n    trackedPointersCount: ");
            // sb.append(gestureHandler.trackedPointersIDsCount);
            // sb.append("\n    trackedPointers: ");
            // int[] iArr = gestureHandler.trackedPointerIDs;
            // Intrinsics.checkNotNullParameter(iArr, "<this>");
            // Intrinsics.checkNotNullParameter(", ", "separator");
            // Intrinsics.checkNotNullParameter("", "prefix");
            // Intrinsics.checkNotNullParameter("", "postfix");
            // Intrinsics.checkNotNullParameter("...", "truncated");
            // StringBuilder sb2 = new StringBuilder();
            // Intrinsics.checkNotNullParameter(iArr, "<this>");
            // Intrinsics.checkNotNullParameter(sb2, "buffer");
            // Intrinsics.checkNotNullParameter(", ", "separator");
            // Intrinsics.checkNotNullParameter("", "prefix");
            // Intrinsics.checkNotNullParameter("", "postfix");
            // Intrinsics.checkNotNullParameter("...", "truncated");
            // sb2.append("");
            // int i = 0;
            for (int i2 : iArr) {
                // i++;
                // if (i > 1) {
                    // sb2.append(", ");
                // }
                // sb2.append(String.valueOf(i2));
            }
            // sb2.append("");
            // String sb3 = sb2.toString();
            // Intrinsics.checkNotNullExpressionValue(sb3, "joinTo(StringBuilder(), …ed, transform).toString()");
            // sb.append(sb3);
            // sb.append("\n    while handling event: ");
            // sb.append(motionEvent);
            // sb.append("\n    ");
            super(CharsKt__CharKt.trimIndent(sb.toString()), illegalArgumentException);
        }
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0010H\u0002J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0004H\u0002J\u0010\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001eX.¢\u0006\u0004\n\u0002\u0010 R\u0018\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0\u001eX.¢\u0006\u0004\n\u0002\u0010#¨\u0006-"}, d2 = {"Lcom/swmansion/gesturehandler/core/GestureHandler$Companion;", "", "()V", "ACTION_TYPE_JS_FUNCTION_NEW_API", "", "ACTION_TYPE_JS_FUNCTION_OLD_API", "ACTION_TYPE_NATIVE_ANIMATED_EVENT", "ACTION_TYPE_REANIMATED_WORKLET", "DIRECTION_DOWN", "DIRECTION_LEFT", "DIRECTION_RIGHT", "DIRECTION_UP", "HIT_SLOP_BOTTOM_IDX", "HIT_SLOP_HEIGHT_IDX", "HIT_SLOP_LEFT_IDX", "HIT_SLOP_NONE", "", "HIT_SLOP_RIGHT_IDX", "HIT_SLOP_TOP_IDX", "HIT_SLOP_WIDTH_IDX", "MAX_POINTERS_COUNT", "STATE_ACTIVE", "STATE_BEGAN", "STATE_CANCELLED", "STATE_END", "STATE_FAILED", "STATE_UNDETERMINED", "nextEventCoalescingKey", "", "pointerCoords", "", "Landroid/view/MotionEvent$PointerCoords;", "[Landroid/view/MotionEvent$PointerCoords;", "pointerProps", "Landroid/view/MotionEvent$PointerProperties;", "[Landroid/view/MotionEvent$PointerProperties;", "hitSlopSet", "", "value", "initPointerProps", "", "size", "stateToString", "", "state", "react-native-gesture-handler_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GestureHandler.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J;\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u001a\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\b\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\r¨\u0006\""}, d2 = {"Lcom/swmansion/gesturehandler/core/GestureHandler$PointerData;", "", "pointerId", "", "x", "", "y", "absoluteX", "absoluteY", "(IFFFF)V", "getAbsoluteX", "()F", "setAbsoluteX", "(F)V", "getAbsoluteY", "setAbsoluteY", "getPointerId", "()I", "getX", "setX", "getY", "setY", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "react-native-gesture-handler_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GestureHandler.kt */
    public static final class PointerData {
        public float absoluteX;
        public float absoluteY;
        public final int pointerId;
        public float x;
        public float y;

        public PointerData(int i, float f2, float f3, float f4, float f5) {
            this.pointerId = i;
            this.x = f2;
            this.y = f3;
            this.absoluteX = f4;
            this.absoluteY = f5;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PointerData)) {
                return false;
            }
            PointerData pointerData = (PointerData) obj;
            return this.pointerId == pointerData.pointerId && Intrinsics.areEqual(Float.valueOf(this.x), Float.valueOf(pointerData.x)) && Intrinsics.areEqual(Float.valueOf(this.y), Float.valueOf(pointerData.y)) && Intrinsics.areEqual(Float.valueOf(this.absoluteX), Float.valueOf(pointerData.absoluteX)) && Intrinsics.areEqual(Float.valueOf(this.absoluteY), Float.valueOf(pointerData.absoluteY));
        }

        public int hashCode() {
            int floatToIntBits = Float.floatToIntBits(this.x);
            int floatToIntBits2 = Float.floatToIntBits(this.y);
            int floatToIntBits3 = Float.floatToIntBits(this.absoluteX);
            return Float.floatToIntBits(this.absoluteY) + ((floatToIntBits3 + ((floatToIntBits2 + ((floatToIntBits + (this.pointerId * 31)) * 31)) * 31)) * 31);
        }

        public String toString() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("PointerData(pointerId=");
            outline73.append(this.pointerId);
            outline73.append(", x=");
            outline73.append(this.x);
            outline73.append(", y=");
            outline73.append(this.y);
            outline73.append(", absoluteX=");
            outline73.append(this.absoluteX);
            outline73.append(", absoluteY=");
            outline73.append(this.absoluteY);
            outline73.append(')');
            return outline73.toString();
        }
    }

    public GestureHandler() {
        int[] iArr = new int[2];
        for (int i = 0; i < 2; i++) {
            iArr[i] = 0;
        }
        this.windowOffset = iArr;
        this.isEnabled = true;
        PointerData[] pointerDataArr = new PointerData[12];
        for (int i2 = 0; i2 < 12; i2++) {
            pointerDataArr[i2] = null;
        }
        this.trackedPointers = pointerDataArr;
    }

    /* renamed from: setEnabled$lambda-3$lambda-2  reason: not valid java name */
    public static final void m52setEnabled$lambda3$lambda2(GestureHandler gestureHandler) {
        Intrinsics.checkNotNullParameter(gestureHandler, "$this_applySelf");
        gestureHandler.cancel();
    }

    public void activate(boolean z) {
        if (!this.manualActivation || z) {
            int i = this.state;
            if (i == 0 || i == 2) {
                moveToState(4);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:110:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0109  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.MotionEvent adaptEvent(android.view.MotionEvent r31) {
        /*
            r30 = this;
            r1 = r30
            r2 = r31
            int r0 = r31.getPointerCount()
            int r3 = r1.trackedPointersIDsCount
            r4 = -1
            r5 = 0
            r6 = 1
            if (r0 == r3) goto L_0x0010
            goto L_0x0020
        L_0x0010:
            int[] r0 = r1.trackedPointerIDs
            int r0 = r0.length
            r3 = 0
        L_0x0014:
            if (r3 >= r0) goto L_0x0024
            int r7 = r3 + 1
            int[] r8 = r1.trackedPointerIDs
            r8 = r8[r3]
            if (r8 == r4) goto L_0x0022
            if (r8 == r3) goto L_0x0022
        L_0x0020:
            r0 = 1
            goto L_0x0025
        L_0x0022:
            r3 = r7
            goto L_0x0014
        L_0x0024:
            r0 = 0
        L_0x0025:
            if (r0 != 0) goto L_0x0028
            return r2
        L_0x0028:
            int r0 = r31.getActionMasked()
            r3 = 6
            r7 = 5
            if (r0 == 0) goto L_0x004e
            if (r0 == r6) goto L_0x0038
            if (r0 == r7) goto L_0x004e
            if (r0 == r3) goto L_0x0038
            r3 = -1
            goto L_0x0065
        L_0x0038:
            int r3 = r31.getActionIndex()
            int r0 = r2.getPointerId(r3)
            int[] r7 = r1.trackedPointerIDs
            r0 = r7[r0]
            if (r0 == r4) goto L_0x0064
            int r0 = r1.trackedPointersIDsCount
            if (r0 != r6) goto L_0x004c
            r0 = 1
            goto L_0x0065
        L_0x004c:
            r0 = 6
            goto L_0x0065
        L_0x004e:
            int r3 = r31.getActionIndex()
            int r0 = r2.getPointerId(r3)
            int[] r7 = r1.trackedPointerIDs
            r0 = r7[r0]
            if (r0 == r4) goto L_0x0064
            int r0 = r1.trackedPointersIDsCount
            if (r0 != r6) goto L_0x0062
            r0 = 0
            goto L_0x0065
        L_0x0062:
            r0 = 5
            goto L_0x0065
        L_0x0064:
            r0 = 2
        L_0x0065:
            int r6 = r1.trackedPointersIDsCount
            android.view.MotionEvent$PointerProperties[] r7 = pointerProps
            if (r7 != 0) goto L_0x0075
            r7 = 12
            android.view.MotionEvent$PointerProperties[] r8 = new android.view.MotionEvent.PointerProperties[r7]
            pointerProps = r8
            android.view.MotionEvent$PointerCoords[] r7 = new android.view.MotionEvent.PointerCoords[r7]
            pointerCoords = r7
        L_0x0075:
            java.lang.String r7 = "pointerCoords"
            java.lang.String r8 = "pointerProps"
            r9 = 0
            if (r6 <= 0) goto L_0x00a1
            android.view.MotionEvent$PointerProperties[] r10 = pointerProps
            if (r10 == 0) goto L_0x009d
            int r6 = r6 + -1
            r11 = r10[r6]
            if (r11 != 0) goto L_0x00a1
            android.view.MotionEvent$PointerProperties r8 = new android.view.MotionEvent$PointerProperties
            r8.<init>()
            r10[r6] = r8
            android.view.MotionEvent$PointerCoords[] r8 = pointerCoords
            if (r8 == 0) goto L_0x0099
            android.view.MotionEvent$PointerCoords r7 = new android.view.MotionEvent$PointerCoords
            r7.<init>()
            r8[r6] = r7
            goto L_0x0075
        L_0x0099:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            throw r9
        L_0x009d:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)
            throw r9
        L_0x00a1:
            float r6 = r31.getRawX()
            float r10 = r31.getX()
            float r6 = r6 - r10
            float r10 = r31.getRawY()
            float r11 = r31.getY()
            float r10 = r10 - r11
            r2.offsetLocation(r6, r10)
            int r11 = r31.getPointerCount()
            r12 = 0
            r13 = 0
            r18 = r0
            r19 = 0
        L_0x00c0:
            if (r12 >= r11) goto L_0x0105
            int r0 = r2.getPointerId(r12)
            int[] r13 = r1.trackedPointerIDs
            r13 = r13[r0]
            if (r13 == r4) goto L_0x0102
            android.view.MotionEvent$PointerProperties[] r13 = pointerProps
            if (r13 == 0) goto L_0x00fe
            r13 = r13[r19]
            r2.getPointerProperties(r12, r13)
            android.view.MotionEvent$PointerProperties[] r13 = pointerProps
            if (r13 == 0) goto L_0x00fa
            r13 = r13[r19]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
            int[] r14 = r1.trackedPointerIDs
            r0 = r14[r0]
            r13.id = r0
            android.view.MotionEvent$PointerCoords[] r0 = pointerCoords
            if (r0 == 0) goto L_0x00f6
            r0 = r0[r19]
            r2.getPointerCoords(r12, r0)
            if (r12 != r3) goto L_0x00f3
            int r0 = r19 << 8
            r18 = r18 | r0
        L_0x00f3:
            int r19 = r19 + 1
            goto L_0x0102
        L_0x00f6:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            throw r9
        L_0x00fa:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)
            throw r9
        L_0x00fe:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)
            throw r9
        L_0x0102:
            int r12 = r12 + 1
            goto L_0x00c0
        L_0x0105:
            android.view.MotionEvent$PointerProperties[] r0 = pointerProps
            if (r0 == 0) goto L_0x019e
            int r0 = r0.length
            if (r0 != 0) goto L_0x010e
            r0 = 1
            goto L_0x010f
        L_0x010e:
            r0 = 0
        L_0x010f:
            if (r0 != 0) goto L_0x0171
            android.view.MotionEvent$PointerCoords[] r0 = pointerCoords
            if (r0 == 0) goto L_0x016d
            int r0 = r0.length
            if (r0 != 0) goto L_0x0119
            r5 = 1
        L_0x0119:
            if (r5 == 0) goto L_0x011c
            goto L_0x0171
        L_0x011c:
            long r14 = r31.getDownTime()     // Catch:{ IllegalArgumentException -> 0x0166 }
            long r16 = r31.getEventTime()     // Catch:{ IllegalArgumentException -> 0x0166 }
            android.view.MotionEvent$PointerProperties[] r20 = pointerProps     // Catch:{ IllegalArgumentException -> 0x0166 }
            if (r20 == 0) goto L_0x0162
            android.view.MotionEvent$PointerCoords[] r21 = pointerCoords     // Catch:{ IllegalArgumentException -> 0x0166 }
            if (r21 == 0) goto L_0x015e
            int r22 = r31.getMetaState()     // Catch:{ IllegalArgumentException -> 0x0166 }
            int r23 = r31.getButtonState()     // Catch:{ IllegalArgumentException -> 0x0166 }
            float r24 = r31.getXPrecision()     // Catch:{ IllegalArgumentException -> 0x0166 }
            float r25 = r31.getYPrecision()     // Catch:{ IllegalArgumentException -> 0x0166 }
            int r26 = r31.getDeviceId()     // Catch:{ IllegalArgumentException -> 0x0166 }
            int r27 = r31.getEdgeFlags()     // Catch:{ IllegalArgumentException -> 0x0166 }
            int r28 = r31.getSource()     // Catch:{ IllegalArgumentException -> 0x0166 }
            int r29 = r31.getFlags()     // Catch:{ IllegalArgumentException -> 0x0166 }
            android.view.MotionEvent r0 = android.view.MotionEvent.obtain(r14, r16, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)     // Catch:{ IllegalArgumentException -> 0x0166 }
            java.lang.String r3 = "obtain(\n        event.do…      event.flags\n      )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)     // Catch:{ IllegalArgumentException -> 0x0166 }
            float r3 = -r6
            float r4 = -r10
            r2.offsetLocation(r3, r4)
            r0.offsetLocation(r3, r4)
            return r0
        L_0x015e:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)     // Catch:{ IllegalArgumentException -> 0x0166 }
            throw r9
        L_0x0162:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)     // Catch:{ IllegalArgumentException -> 0x0166 }
            throw r9
        L_0x0166:
            r0 = move-exception
            com.swmansion.gesturehandler.core.GestureHandler$AdaptEventException r3 = new com.swmansion.gesturehandler.core.GestureHandler$AdaptEventException
            r3.<init>(r1, r2, r0)
            throw r3
        L_0x016d:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            throw r9
        L_0x0171:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "pointerCoords.size="
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r2)
            android.view.MotionEvent$PointerCoords[] r3 = pointerCoords
            if (r3 == 0) goto L_0x019a
            int r3 = r3.length
            r2.append(r3)
            java.lang.String r3 = ", pointerProps.size="
            r2.append(r3)
            android.view.MotionEvent$PointerProperties[] r3 = pointerProps
            if (r3 != 0) goto L_0x018e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)
            throw r9
        L_0x018e:
            int r3 = r3.length
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        L_0x019a:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            throw r9
        L_0x019e:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.gesturehandler.core.GestureHandler.adaptEvent(android.view.MotionEvent):android.view.MotionEvent");
    }

    public final void addChangedPointer(PointerData pointerData) {
        if (this.changedTouchesPayload == null) {
            this.changedTouchesPayload = Arguments.createArray();
        }
        WritableArray writableArray = this.changedTouchesPayload;
        Intrinsics.checkNotNull(writableArray);
        writableArray.pushMap(createPointerData(pointerData));
    }

    public final void begin() {
        if (this.state == 0) {
            moveToState(2);
        }
    }

    public final void cancel() {
        int i = this.state;
        if (i == 4 || i == 0 || i == 2) {
            onCancel();
            moveToState(3);
        }
    }

    public final WritableMap createPointerData(PointerData pointerData) {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("id", pointerData.pointerId);
        createMap.putDouble("x", (double) ImageOriginUtils.toDIPFromPixel(pointerData.x));
        createMap.putDouble("y", (double) ImageOriginUtils.toDIPFromPixel(pointerData.y));
        createMap.putDouble("absoluteX", (double) ImageOriginUtils.toDIPFromPixel(pointerData.absoluteX));
        createMap.putDouble("absoluteY", (double) ImageOriginUtils.toDIPFromPixel(pointerData.absoluteY));
        return createMap;
    }

    public void dispatchHandlerUpdate(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        OnTouchEventListener onTouchEventListener2 = this.onTouchEventListener;
        if (onTouchEventListener2 != null) {
            onTouchEventListener2.onHandlerUpdate(this, motionEvent);
        }
    }

    public void dispatchStateChange(int i, int i2) {
        OnTouchEventListener onTouchEventListener2 = this.onTouchEventListener;
        if (onTouchEventListener2 != null) {
            onTouchEventListener2.onStateChange(this, i, i2);
        }
    }

    public void dispatchTouchEvent() {
        if (this.changedTouchesPayload != null) {
            OnTouchEventListener onTouchEventListener2 = this.onTouchEventListener;
            if (onTouchEventListener2 != null) {
                onTouchEventListener2.onTouchEvent(this);
            }
        }
    }

    public final void dispatchTouchMoveEvent(MotionEvent motionEvent) {
        this.changedTouchesPayload = null;
        this.touchEventType = 2;
        float rawX = motionEvent.getRawX() - motionEvent.getX();
        float rawY = motionEvent.getRawY() - motionEvent.getY();
        int pointerCount = motionEvent.getPointerCount();
        int i = 0;
        int i2 = 0;
        while (i < pointerCount) {
            int i3 = i + 1;
            PointerData pointerData = this.trackedPointers[motionEvent.getPointerId(i)];
            if (pointerData != null) {
                if (pointerData.x == motionEvent.getX(i)) {
                    if (pointerData.y == motionEvent.getY(i)) {
                    }
                }
                pointerData.x = motionEvent.getX(i);
                pointerData.y = motionEvent.getY(i);
                pointerData.absoluteX = (motionEvent.getX(i) + rawX) - ((float) this.windowOffset[0]);
                pointerData.absoluteY = (motionEvent.getY(i) + rawY) - ((float) this.windowOffset[1]);
                addChangedPointer(pointerData);
                i2++;
            }
            i = i3;
        }
        if (i2 > 0) {
            extractAllPointersData();
            dispatchTouchEvent();
        }
    }

    public final void end() {
        int i = this.state;
        if (i == 2 || i == 4) {
            moveToState(5);
        }
    }

    public final void extractAllPointersData() {
        this.allTouchesPayload = null;
        PointerData[] pointerDataArr = this.trackedPointers;
        int length = pointerDataArr.length;
        int i = 0;
        while (i < length) {
            PointerData pointerData = pointerDataArr[i];
            i++;
            if (pointerData != null) {
                if (this.allTouchesPayload == null) {
                    this.allTouchesPayload = Arguments.createArray();
                }
                WritableArray writableArray = this.allTouchesPayload;
                Intrinsics.checkNotNull(writableArray);
                writableArray.pushMap(createPointerData(pointerData));
            }
        }
    }

    public final void fail() {
        int i = this.state;
        if (i == 4 || i == 0 || i == 2) {
            moveToState(1);
        }
    }

    public final float getLastPositionInWindowX() {
        return (this.lastAbsolutePositionX + this.lastEventOffsetX) - ((float) this.windowOffset[0]);
    }

    public final float getLastPositionInWindowY() {
        return (this.lastAbsolutePositionY + this.lastEventOffsetY) - ((float) this.windowOffset[1]);
    }

    public final Window getWindow(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return ((Activity) context).getWindow();
        }
        if (context instanceof ContextWrapper) {
            return getWindow(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public final boolean isWithinBounds(View view2, float f2, float f3) {
        float f4;
        Intrinsics.checkNotNull(view2);
        float width = (float) view2.getWidth();
        float height = (float) view2.getHeight();
        float[] fArr = this.hitSlop;
        float f5 = 0.0f;
        if (fArr == null) {
            f4 = 0.0f;
        } else {
            float f6 = fArr[0];
            float f7 = fArr[1];
            float f8 = fArr[2];
            float f9 = fArr[3];
            float f10 = Float.isNaN(f6) ^ true ? 0.0f - f6 : 0.0f;
            if (!Float.isNaN(f7)) {
                f5 = 0.0f - f7;
            }
            if (!Float.isNaN(f8)) {
                width += f8;
            }
            if (!Float.isNaN(f9)) {
                height += f9;
            }
            float f11 = fArr[4];
            float f12 = fArr[5];
            if (!Float.isNaN(f11)) {
                if (!(!Float.isNaN(f6))) {
                    f10 = width - f11;
                } else if (!(!Float.isNaN(f8))) {
                    width = f11 + f10;
                }
            }
            if (!Float.isNaN(f12)) {
                if (!(!Float.isNaN(f7))) {
                    f5 = height - f12;
                } else if (!(!Float.isNaN(f9))) {
                    height = f12 + f5;
                }
            }
            f4 = f5;
            f5 = f10;
        }
        if (!(f5 <= f2 && f2 <= width)) {
            return false;
        }
        if (f4 <= f3 && f3 <= height) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0098, code lost:
        if (r12 == false) goto L_0x009c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00b1 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void moveToState(int r14) {
        /*
            r13 = this;
            com.facebook.react.bridge.UiThreadUtil.assertOnUiThread()
            int r0 = r13.state
            if (r0 != r14) goto L_0x0008
            return
        L_0x0008:
            int r0 = r13.trackedPointersCount
            r1 = 3
            r2 = 5
            r3 = 4
            r4 = 1
            r5 = 0
            if (r0 <= 0) goto L_0x003b
            if (r14 == r2) goto L_0x0017
            if (r14 == r1) goto L_0x0017
            if (r14 != r4) goto L_0x003b
        L_0x0017:
            r13.touchEventType = r3
            r0 = 0
            r13.changedTouchesPayload = r0
            r13.extractAllPointersData()
            com.swmansion.gesturehandler.core.GestureHandler$PointerData[] r6 = r13.trackedPointers
            int r7 = r6.length
            r8 = 0
        L_0x0023:
            if (r8 >= r7) goto L_0x0030
            r9 = r6[r8]
            int r8 = r8 + 1
            if (r9 != 0) goto L_0x002c
            goto L_0x0023
        L_0x002c:
            r13.addChangedPointer(r9)
            goto L_0x0023
        L_0x0030:
            r13.trackedPointersCount = r5
            com.swmansion.gesturehandler.core.GestureHandler$PointerData[] r6 = r13.trackedPointers
            r7 = 6
            kotlin.collections.ArraysKt___ArraysJvmKt.fill$default(r6, r0, r5, r5, r7)
            r13.dispatchTouchEvent()
        L_0x003b:
            int r0 = r13.state
            r13.state = r14
            if (r14 != r3) goto L_0x004a
            short r6 = nextEventCoalescingKey
            int r7 = r6 + 1
            short r7 = (short) r7
            nextEventCoalescingKey = r7
            r13.eventCoalescingKey = r6
        L_0x004a:
            com.swmansion.gesturehandler.core.GestureHandlerOrchestrator r6 = r13.orchestrator
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            java.lang.String r7 = "handler"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r7)
            int r8 = r6.handlingChangeSemaphore
            int r8 = r8 + r4
            r6.handlingChangeSemaphore = r8
            if (r14 == r1) goto L_0x0062
            if (r14 == r4) goto L_0x0062
            if (r14 != r2) goto L_0x0060
            goto L_0x0062
        L_0x0060:
            r8 = 0
            goto L_0x0063
        L_0x0062:
            r8 = 1
        L_0x0063:
            r9 = 2
            if (r8 == 0) goto L_0x00b6
            int r8 = r6.awaitingHandlersCount
            r10 = 0
        L_0x0069:
            if (r10 >= r8) goto L_0x00b3
            int r11 = r10 + 1
            com.swmansion.gesturehandler.core.GestureHandler<?>[] r12 = r6.awaitingHandlers
            r10 = r12[r10]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            if (r10 == r13) goto L_0x009c
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r7)
            if (r13 != r10) goto L_0x007c
            goto L_0x0080
        L_0x007c:
            com.swmansion.gesturehandler.core.GestureHandlerInteractionController r12 = r10.interactionController
            if (r12 != 0) goto L_0x0082
        L_0x0080:
            r12 = 0
            goto L_0x0086
        L_0x0082:
            boolean r12 = r12.shouldWaitForHandlerFailure(r10, r13)
        L_0x0086:
            if (r12 != 0) goto L_0x009a
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r7)
            if (r10 != r13) goto L_0x008e
            goto L_0x0092
        L_0x008e:
            com.swmansion.gesturehandler.core.GestureHandlerInteractionController r12 = r13.interactionController
            if (r12 != 0) goto L_0x0094
        L_0x0092:
            r12 = 0
            goto L_0x0098
        L_0x0094:
            boolean r12 = r12.shouldRequireHandlerToWaitForFailure(r13, r10)
        L_0x0098:
            if (r12 == 0) goto L_0x009c
        L_0x009a:
            r12 = 1
            goto L_0x009d
        L_0x009c:
            r12 = 0
        L_0x009d:
            if (r12 == 0) goto L_0x00b1
            if (r14 != r2) goto L_0x00ae
            r10.cancel()
            int r12 = r10.state
            if (r12 != r2) goto L_0x00ab
            r10.dispatchStateChange(r1, r9)
        L_0x00ab:
            r10.isAwaiting = r5
            goto L_0x00b1
        L_0x00ae:
            r6.tryActivate(r10)
        L_0x00b1:
            r10 = r11
            goto L_0x0069
        L_0x00b3:
            r6.cleanupAwaitingHandlers()
        L_0x00b6:
            if (r14 != r3) goto L_0x00bc
            r6.tryActivate(r13)
            goto L_0x00da
        L_0x00bc:
            if (r0 == r3) goto L_0x00c9
            if (r0 != r2) goto L_0x00c1
            goto L_0x00c9
        L_0x00c1:
            if (r0 != 0) goto L_0x00c5
            if (r14 == r1) goto L_0x00da
        L_0x00c5:
            r13.dispatchStateChange(r14, r0)
            goto L_0x00da
        L_0x00c9:
            boolean r2 = r13.isActive
            if (r2 == 0) goto L_0x00d1
            r13.dispatchStateChange(r14, r0)
            goto L_0x00da
        L_0x00d1:
            if (r0 != r3) goto L_0x00da
            if (r14 == r1) goto L_0x00d7
            if (r14 != r4) goto L_0x00da
        L_0x00d7:
            r13.dispatchStateChange(r14, r9)
        L_0x00da:
            int r1 = r6.handlingChangeSemaphore
            int r1 = r1 - r4
            r6.handlingChangeSemaphore = r1
            boolean r2 = r6.isHandlingTouch
            if (r2 != 0) goto L_0x00ea
            if (r1 == 0) goto L_0x00e6
            goto L_0x00ea
        L_0x00e6:
            r6.cleanupFinishedHandlers()
            goto L_0x00ec
        L_0x00ea:
            r6.finishedHandlersCleanupScheduled = r4
        L_0x00ec:
            r13.onStateChange(r14, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.gesturehandler.core.GestureHandler.moveToState(int):void");
    }

    public void onCancel() {
    }

    public void onHandle(MotionEvent motionEvent, MotionEvent motionEvent2) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        Intrinsics.checkNotNullParameter(motionEvent2, "sourceEvent");
        moveToState(1);
    }

    public void onPrepare() {
    }

    public void onReset() {
    }

    public void onStateChange(int i, int i2) {
    }

    public void resetConfig() {
        this.needsPointerData = false;
        this.manualActivation = false;
        this.shouldCancelWhenOutside = false;
        this.isEnabled = true;
        this.hitSlop = null;
    }

    public void resetProgress() {
    }

    public final ConcreteGestureHandlerT setHitSlop(float f2, float f3, float f4, float f5, float f6, float f7) {
        if (this.hitSlop == null) {
            this.hitSlop = new float[6];
        }
        float[] fArr = this.hitSlop;
        Intrinsics.checkNotNull(fArr);
        boolean z = false;
        fArr[0] = f2;
        float[] fArr2 = this.hitSlop;
        Intrinsics.checkNotNull(fArr2);
        fArr2[1] = f3;
        float[] fArr3 = this.hitSlop;
        Intrinsics.checkNotNull(fArr3);
        fArr3[2] = f4;
        float[] fArr4 = this.hitSlop;
        Intrinsics.checkNotNull(fArr4);
        fArr4[3] = f5;
        float[] fArr5 = this.hitSlop;
        Intrinsics.checkNotNull(fArr5);
        fArr5[4] = f6;
        float[] fArr6 = this.hitSlop;
        Intrinsics.checkNotNull(fArr6);
        fArr6[5] = f7;
        if (!(Float.isNaN(f6) ^ true) || !(Float.isNaN(f2) ^ true) || !(Float.isNaN(f4) ^ true)) {
            if (!(Float.isNaN(f6) ^ true) || (Float.isNaN(f2) ^ true) || (Float.isNaN(f4) ^ true)) {
                if (!(Float.isNaN(f7) ^ true) || !(Float.isNaN(f5) ^ true) || !(Float.isNaN(f3) ^ true)) {
                    if (!(!Float.isNaN(f7)) || (!Float.isNaN(f5)) || (!Float.isNaN(f3))) {
                        z = true;
                    }
                    if (z) {
                        return this;
                    }
                    throw new IllegalArgumentException("When height is set one of top or bottom pads need to be defined".toString());
                }
                throw new IllegalArgumentException("Cannot have all of top, bottom and height defined".toString());
            }
            throw new IllegalArgumentException("When width is set one of left or right pads need to be defined".toString());
        }
        throw new IllegalArgumentException("Cannot have all of left, right and width defined".toString());
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=com.swmansion.gesturehandler.core.GestureHandler<?>, code=com.swmansion.gesturehandler.core.GestureHandler, for r3v0, types: [com.swmansion.gesturehandler.core.GestureHandler, com.swmansion.gesturehandler.core.GestureHandler<?>, java.lang.Object] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean shouldBeCancelledBy(com.swmansion.gesturehandler.core.GestureHandler r3) {
        /*
            r2 = this;
            java.lang.String r0 = "handler"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = 0
            if (r3 != r2) goto L_0x0009
            return r0
        L_0x0009:
            com.swmansion.gesturehandler.core.GestureHandlerInteractionController r1 = r2.interactionController
            if (r1 != 0) goto L_0x000e
            goto L_0x0012
        L_0x000e:
            boolean r0 = r1.shouldHandlerBeCancelledBy(r2, r3)
        L_0x0012:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.gesturehandler.core.GestureHandler.shouldBeCancelledBy(com.swmansion.gesturehandler.core.GestureHandler):boolean");
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=com.swmansion.gesturehandler.core.GestureHandler<?>, code=com.swmansion.gesturehandler.core.GestureHandler, for r2v0, types: [com.swmansion.gesturehandler.core.GestureHandler, com.swmansion.gesturehandler.core.GestureHandler<?>, java.lang.Object] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean shouldRecognizeSimultaneously(com.swmansion.gesturehandler.core.GestureHandler r2) {
        /*
            r1 = this;
            java.lang.String r0 = "handler"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            if (r2 != r1) goto L_0x0009
            r2 = 1
            return r2
        L_0x0009:
            com.swmansion.gesturehandler.core.GestureHandlerInteractionController r0 = r1.interactionController
            if (r0 != 0) goto L_0x000f
            r2 = 0
            goto L_0x0013
        L_0x000f:
            boolean r2 = r0.shouldRecognizeSimultaneously(r1, r2)
        L_0x0013:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.gesturehandler.core.GestureHandler.shouldRecognizeSimultaneously(com.swmansion.gesturehandler.core.GestureHandler):boolean");
    }

    public final void startTrackingPointer(int i) {
        int[] iArr = this.trackedPointerIDs;
        if (iArr[i] == -1) {
            int i2 = 0;
            while (i2 < this.trackedPointersIDsCount) {
                int i3 = 0;
                while (true) {
                    int[] iArr2 = this.trackedPointerIDs;
                    if (i3 < iArr2.length && iArr2[i3] != i2) {
                        i3++;
                    }
                }
                if (i3 == this.trackedPointerIDs.length) {
                    break;
                }
                i2++;
            }
            iArr[i] = i2;
            this.trackedPointersIDsCount++;
        }
    }

    public String toString() {
        String str;
        View view2 = this.view;
        if (view2 == null) {
            str = null;
        } else {
            Intrinsics.checkNotNull(view2);
            str = view2.getClass().getSimpleName();
        }
        return getClass().getSimpleName() + "@[" + this.tag + "]:" + str;
    }

    public final PointF transformPoint(PointF pointF) {
        PointF pointF2;
        Intrinsics.checkNotNullParameter(pointF, "point");
        GestureHandlerOrchestrator gestureHandlerOrchestrator = this.orchestrator;
        if (gestureHandlerOrchestrator == null) {
            pointF2 = null;
        } else {
            gestureHandlerOrchestrator.transformPointToViewCoords(this.view, pointF);
            pointF2 = pointF;
        }
        if (pointF2 != null) {
            return pointF2;
        }
        pointF.x = Float.NaN;
        pointF.y = Float.NaN;
        return pointF;
    }

    public final void updatePointerData(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        if (motionEvent.getActionMasked() == 0 || motionEvent.getActionMasked() == 5) {
            this.changedTouchesPayload = null;
            this.touchEventType = 1;
            int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
            float rawX = motionEvent.getRawX() - motionEvent.getX();
            float rawY = motionEvent.getRawY() - motionEvent.getY();
            PointerData[] pointerDataArr = this.trackedPointers;
            PointerData pointerData = new PointerData(pointerId, motionEvent.getX(motionEvent.getActionIndex()), motionEvent.getY(motionEvent.getActionIndex()), (motionEvent.getX(motionEvent.getActionIndex()) + rawX) - ((float) this.windowOffset[0]), (motionEvent.getY(motionEvent.getActionIndex()) + rawY) - ((float) this.windowOffset[1]));
            pointerDataArr[pointerId] = pointerData;
            this.trackedPointersCount++;
            PointerData pointerData2 = this.trackedPointers[pointerId];
            Intrinsics.checkNotNull(pointerData2);
            addChangedPointer(pointerData2);
            extractAllPointersData();
            dispatchTouchEvent();
            dispatchTouchMoveEvent(motionEvent);
        } else if (motionEvent.getActionMasked() == 1 || motionEvent.getActionMasked() == 6) {
            dispatchTouchMoveEvent(motionEvent);
            extractAllPointersData();
            this.changedTouchesPayload = null;
            this.touchEventType = 3;
            int pointerId2 = motionEvent.getPointerId(motionEvent.getActionIndex());
            float rawX2 = motionEvent.getRawX() - motionEvent.getX();
            float rawY2 = motionEvent.getRawY() - motionEvent.getY();
            PointerData[] pointerDataArr2 = this.trackedPointers;
            PointerData pointerData3 = new PointerData(pointerId2, motionEvent.getX(motionEvent.getActionIndex()), motionEvent.getY(motionEvent.getActionIndex()), (motionEvent.getX(motionEvent.getActionIndex()) + rawX2) - ((float) this.windowOffset[0]), (motionEvent.getY(motionEvent.getActionIndex()) + rawY2) - ((float) this.windowOffset[1]));
            pointerDataArr2[pointerId2] = pointerData3;
            PointerData pointerData4 = this.trackedPointers[pointerId2];
            Intrinsics.checkNotNull(pointerData4);
            addChangedPointer(pointerData4);
            this.trackedPointers[pointerId2] = null;
            this.trackedPointersCount--;
            dispatchTouchEvent();
        } else if (motionEvent.getActionMasked() == 2) {
            dispatchTouchMoveEvent(motionEvent);
        }
    }
}
