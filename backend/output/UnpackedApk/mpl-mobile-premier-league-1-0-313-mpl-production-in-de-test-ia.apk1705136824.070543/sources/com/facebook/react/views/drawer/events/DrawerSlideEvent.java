package com.facebook.react.views.drawer.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class DrawerSlideEvent extends Event<DrawerSlideEvent> {
    public final float mOffset;

    public DrawerSlideEvent(int i, float f2) {
        super(i);
        this.mOffset = f2;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        int i = this.mViewTag;
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("offset", (double) this.mOffset);
        rCTEventEmitter.receiveEvent(i, "topDrawerSlide", createMap);
    }

    public short getCoalescingKey() {
        return 0;
    }

    public String getEventName() {
        return "topDrawerSlide";
    }
}
