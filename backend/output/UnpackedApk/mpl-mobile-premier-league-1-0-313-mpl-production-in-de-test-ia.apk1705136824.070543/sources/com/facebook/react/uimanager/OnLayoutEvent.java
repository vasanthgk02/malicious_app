package com.facebook.react.uimanager;

import androidx.core.util.Pools$SynchronizedPool;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class OnLayoutEvent extends Event<OnLayoutEvent> {
    public static final Pools$SynchronizedPool<OnLayoutEvent> EVENTS_POOL = new Pools$SynchronizedPool<>(20);
    public int mHeight;
    public int mWidth;
    public int mX;
    public int mY;

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("x", (double) ImageOriginUtils.toDIPFromPixel((float) this.mX));
        createMap.putDouble("y", (double) ImageOriginUtils.toDIPFromPixel((float) this.mY));
        createMap.putDouble("width", (double) ImageOriginUtils.toDIPFromPixel((float) this.mWidth));
        createMap.putDouble("height", (double) ImageOriginUtils.toDIPFromPixel((float) this.mHeight));
        WritableMap createMap2 = Arguments.createMap();
        createMap2.putMap("layout", createMap);
        createMap2.putInt("target", this.mViewTag);
        rCTEventEmitter.receiveEvent(this.mViewTag, "topLayout", createMap2);
    }

    public String getEventName() {
        return "topLayout";
    }

    public void onDispose() {
        EVENTS_POOL.release(this);
    }
}
