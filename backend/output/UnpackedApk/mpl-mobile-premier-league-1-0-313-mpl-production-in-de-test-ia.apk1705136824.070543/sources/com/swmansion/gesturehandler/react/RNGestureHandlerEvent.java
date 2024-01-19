package com.swmansion.gesturehandler.react;

import android.view.View;
import androidx.core.util.Pools$SynchronizedPool;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.swmansion.gesturehandler.core.GestureHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001aB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J=\u0010\u0011\u001a\u00020\u000b\"\u000e\b\u0000\u0010\u0012*\b\u0012\u0004\u0012\u0002H\u00120\u00132\u0006\u0010\u0014\u001a\u0002H\u00122\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u0002H\u0012\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\bH\u0002¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\u000bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerEvent;", "Lcom/facebook/react/uimanager/events/Event;", "()V", "coalescingKey", "", "extraData", "Lcom/facebook/react/bridge/WritableMap;", "useTopPrefixedName", "", "canCoalesce", "dispatch", "", "rctEventEmitter", "Lcom/facebook/react/uimanager/events/RCTEventEmitter;", "getCoalescingKey", "getEventName", "", "init", "T", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "handler", "dataExtractor", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerEventDataExtractor;", "useNativeAnimatedName", "(Lcom/swmansion/gesturehandler/core/GestureHandler;Lcom/swmansion/gesturehandler/react/RNGestureHandlerEventDataExtractor;Z)V", "onDispose", "Companion", "react-native-gesture-handler_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RNGestureHandlerEvent.kt */
public final class RNGestureHandlerEvent extends Event<RNGestureHandlerEvent> {
    public static final Companion Companion = new Companion(null);
    public static final Pools$SynchronizedPool<RNGestureHandlerEvent> EVENTS_POOL = new Pools$SynchronizedPool<>(7);
    public short coalescingKey;
    public WritableMap extraData;
    public boolean useTopPrefixedName;

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J3\u0010\u000b\u001a\u00020\f\"\u000e\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u000e2\u0006\u0010\u000f\u001a\u0002H\r2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u0002H\r\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012J=\u0010\u0013\u001a\u00020\u0005\"\u000e\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u000e2\u0006\u0010\u000f\u001a\u0002H\r2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u0002H\r\u0018\u00010\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerEvent$Companion;", "", "()V", "EVENTS_POOL", "Landroidx/core/util/Pools$SynchronizedPool;", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerEvent;", "EVENT_NAME", "", "NATIVE_ANIMATED_EVENT_NAME", "TOUCH_EVENTS_POOL_SIZE", "", "createEventData", "Lcom/facebook/react/bridge/WritableMap;", "T", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "handler", "dataExtractor", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerEventDataExtractor;", "(Lcom/swmansion/gesturehandler/core/GestureHandler;Lcom/swmansion/gesturehandler/react/RNGestureHandlerEventDataExtractor;)Lcom/facebook/react/bridge/WritableMap;", "obtain", "useTopPrefixedName", "", "(Lcom/swmansion/gesturehandler/core/GestureHandler;Lcom/swmansion/gesturehandler/react/RNGestureHandlerEventDataExtractor;Z)Lcom/swmansion/gesturehandler/react/RNGestureHandlerEvent;", "react-native-gesture-handler_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RNGestureHandlerEvent.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final <T extends GestureHandler<T>> WritableMap createEventData(T t, RNGestureHandlerEventDataExtractor<T> rNGestureHandlerEventDataExtractor) {
            Intrinsics.checkNotNullParameter(t, "handler");
            WritableMap createMap = Arguments.createMap();
            if (rNGestureHandlerEventDataExtractor != null) {
                Intrinsics.checkNotNullExpressionValue(createMap, "this");
                rNGestureHandlerEventDataExtractor.extractEventData(t, createMap);
            }
            createMap.putInt("handlerTag", t.tag);
            createMap.putInt("state", t.state);
            Intrinsics.checkNotNullExpressionValue(createMap, "createMap().apply {\n    …te\", handler.state)\n    }");
            return createMap;
        }

        public final <T extends GestureHandler<T>> RNGestureHandlerEvent obtain(T t, RNGestureHandlerEventDataExtractor<T> rNGestureHandlerEventDataExtractor, boolean z) {
            Intrinsics.checkNotNullParameter(t, "handler");
            RNGestureHandlerEvent rNGestureHandlerEvent = (RNGestureHandlerEvent) RNGestureHandlerEvent.EVENTS_POOL.acquire();
            if (rNGestureHandlerEvent == null) {
                rNGestureHandlerEvent = new RNGestureHandlerEvent(null);
            }
            RNGestureHandlerEvent.access$init(rNGestureHandlerEvent, t, rNGestureHandlerEventDataExtractor, z);
            return rNGestureHandlerEvent;
        }
    }

    public RNGestureHandlerEvent() {
    }

    public static final void access$init(RNGestureHandlerEvent rNGestureHandlerEvent, GestureHandler gestureHandler, RNGestureHandlerEventDataExtractor rNGestureHandlerEventDataExtractor, boolean z) {
        View view = gestureHandler.view;
        Intrinsics.checkNotNull(view);
        super.init(view.getId());
        Intrinsics.checkNotNullParameter(gestureHandler, "handler");
        WritableMap createMap = Arguments.createMap();
        if (rNGestureHandlerEventDataExtractor != null) {
            Intrinsics.checkNotNullExpressionValue(createMap, "this");
            rNGestureHandlerEventDataExtractor.extractEventData(gestureHandler, createMap);
        }
        createMap.putInt("handlerTag", gestureHandler.tag);
        createMap.putInt("state", gestureHandler.state);
        Intrinsics.checkNotNullExpressionValue(createMap, "createMap().apply {\n    …te\", handler.state)\n    }");
        rNGestureHandlerEvent.extraData = createMap;
        rNGestureHandlerEvent.coalescingKey = gestureHandler.eventCoalescingKey;
        rNGestureHandlerEvent.useTopPrefixedName = z;
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
        return this.useTopPrefixedName ? "topGestureHandlerEvent" : "onGestureHandlerEvent";
    }

    public void onDispose() {
        this.extraData = null;
        EVENTS_POOL.release(this);
    }

    public RNGestureHandlerEvent(DefaultConstructorMarker defaultConstructorMarker) {
    }
}
