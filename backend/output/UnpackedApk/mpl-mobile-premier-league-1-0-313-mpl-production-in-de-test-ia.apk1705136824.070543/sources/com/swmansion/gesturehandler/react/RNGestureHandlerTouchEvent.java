package com.swmansion.gesturehandler.react;

import android.view.View;
import androidx.core.util.Pools$SynchronizedPool;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.swmansion.gesturehandler.core.GestureHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0016B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J%\u0010\u0010\u001a\u00020\n\"\u000e\b\u0000\u0010\u0011*\b\u0012\u0004\u0012\u0002H\u00110\u00122\u0006\u0010\u0013\u001a\u0002H\u0011H\u0002¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerTouchEvent;", "Lcom/facebook/react/uimanager/events/Event;", "()V", "coalescingKey", "", "extraData", "Lcom/facebook/react/bridge/WritableMap;", "canCoalesce", "", "dispatch", "", "rctEventEmitter", "Lcom/facebook/react/uimanager/events/RCTEventEmitter;", "getCoalescingKey", "getEventName", "", "init", "T", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "handler", "(Lcom/swmansion/gesturehandler/core/GestureHandler;)V", "onDispose", "Companion", "react-native-gesture-handler_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RNGestureHandlerTouchEvent.kt */
public final class RNGestureHandlerTouchEvent extends Event<RNGestureHandlerTouchEvent> {
    public static final RNGestureHandlerTouchEvent Companion = null;
    public static final Pools$SynchronizedPool<RNGestureHandlerTouchEvent> EVENTS_POOL = new Pools$SynchronizedPool<>(7);
    public short coalescingKey;
    public WritableMap extraData;

    public RNGestureHandlerTouchEvent() {
    }

    public static final void access$init(RNGestureHandlerTouchEvent rNGestureHandlerTouchEvent, GestureHandler gestureHandler) {
        View view = gestureHandler.view;
        Intrinsics.checkNotNull(view);
        super.init(view.getId());
        Intrinsics.checkNotNullParameter(gestureHandler, "handler");
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("handlerTag", gestureHandler.tag);
        createMap.putInt("state", gestureHandler.state);
        createMap.putInt("numberOfTouches", gestureHandler.trackedPointersCount);
        createMap.putInt("eventType", gestureHandler.touchEventType);
        WritableArray writableArray = gestureHandler.changedTouchesPayload;
        gestureHandler.changedTouchesPayload = null;
        if (writableArray != null) {
            createMap.putArray("changedTouches", writableArray);
        }
        WritableArray writableArray2 = gestureHandler.allTouchesPayload;
        gestureHandler.allTouchesPayload = null;
        if (writableArray2 != null) {
            createMap.putArray("allTouches", writableArray2);
        }
        if (gestureHandler.isAwaiting && gestureHandler.state == 4) {
            createMap.putInt("state", 2);
        }
        Intrinsics.checkNotNullExpressionValue(createMap, "createMap().apply {\n    …TATE_BEGAN)\n      }\n    }");
        rNGestureHandlerTouchEvent.extraData = createMap;
        rNGestureHandlerTouchEvent.coalescingKey = gestureHandler.eventCoalescingKey;
    }

    public static final <T extends GestureHandler<T>> WritableMap createEventData(T t) {
        Intrinsics.checkNotNullParameter(t, "handler");
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("handlerTag", t.tag);
        createMap.putInt("state", t.state);
        createMap.putInt("numberOfTouches", t.trackedPointersCount);
        createMap.putInt("eventType", t.touchEventType);
        WritableArray writableArray = t.changedTouchesPayload;
        t.changedTouchesPayload = null;
        if (writableArray != null) {
            createMap.putArray("changedTouches", writableArray);
        }
        WritableArray writableArray2 = t.allTouchesPayload;
        t.allTouchesPayload = null;
        if (writableArray2 != null) {
            createMap.putArray("allTouches", writableArray2);
        }
        if (t.isAwaiting && t.state == 4) {
            createMap.putInt("state", 2);
        }
        Intrinsics.checkNotNullExpressionValue(createMap, "createMap().apply {\n    …TATE_BEGAN)\n      }\n    }");
        return createMap;
    }

    public boolean canCoalesce() {
        return true;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        Intrinsics.checkNotNullParameter(rCTEventEmitter, "rctEventEmitter");
        rCTEventEmitter.receiveEvent(this.mViewTag, "onGestureHandlerEvent", this.extraData);
    }

    public short getCoalescingKey() {
        return this.coalescingKey;
    }

    public String getEventName() {
        return "onGestureHandlerEvent";
    }

    public void onDispose() {
        this.extraData = null;
        EVENTS_POOL.release(this);
    }

    public RNGestureHandlerTouchEvent(DefaultConstructorMarker defaultConstructorMarker) {
    }
}
