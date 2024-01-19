package com.th3rdwave.safeareacontext;

import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;

public class InsetsChangeEvent extends Event<InsetsChangeEvent> {
    public Rect mFrame;
    public EdgeInsets mInsets;

    public InsetsChangeEvent(int i, EdgeInsets edgeInsets, Rect rect) {
        super(i);
        this.mInsets = edgeInsets;
        this.mFrame = rect;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        WritableMap createMap = Arguments.createMap();
        EdgeInsets edgeInsets = this.mInsets;
        WritableMap createMap2 = Arguments.createMap();
        createMap2.putDouble(RNGestureHandlerModule.KEY_HIT_SLOP_TOP, (double) ImageOriginUtils.toDIPFromPixel(edgeInsets.top));
        createMap2.putDouble(RNGestureHandlerModule.KEY_HIT_SLOP_RIGHT, (double) ImageOriginUtils.toDIPFromPixel(edgeInsets.right));
        createMap2.putDouble(RNGestureHandlerModule.KEY_HIT_SLOP_BOTTOM, (double) ImageOriginUtils.toDIPFromPixel(edgeInsets.bottom));
        createMap2.putDouble(RNGestureHandlerModule.KEY_HIT_SLOP_LEFT, (double) ImageOriginUtils.toDIPFromPixel(edgeInsets.left));
        createMap.putMap("insets", createMap2);
        Rect rect = this.mFrame;
        WritableMap createMap3 = Arguments.createMap();
        createMap3.putDouble("x", (double) ImageOriginUtils.toDIPFromPixel(rect.x));
        createMap3.putDouble("y", (double) ImageOriginUtils.toDIPFromPixel(rect.y));
        createMap3.putDouble("width", (double) ImageOriginUtils.toDIPFromPixel(rect.width));
        createMap3.putDouble("height", (double) ImageOriginUtils.toDIPFromPixel(rect.height));
        createMap.putMap("frame", createMap3);
        rCTEventEmitter.receiveEvent(this.mViewTag, "topInsetsChange", createMap);
    }

    public String getEventName() {
        return "topInsetsChange";
    }
}
