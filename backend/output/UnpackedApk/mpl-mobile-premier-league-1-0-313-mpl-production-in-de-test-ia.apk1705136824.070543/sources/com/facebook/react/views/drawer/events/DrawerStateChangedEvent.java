package com.facebook.react.views.drawer.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class DrawerStateChangedEvent extends Event<DrawerStateChangedEvent> {
    public final int mDrawerState;

    public DrawerStateChangedEvent(int i, int i2) {
        super(i);
        this.mDrawerState = i2;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        int i = this.mViewTag;
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("drawerState", (double) this.mDrawerState);
        rCTEventEmitter.receiveEvent(i, "topDrawerStateChanged", createMap);
    }

    public short getCoalescingKey() {
        return 0;
    }

    public String getEventName() {
        return "topDrawerStateChanged";
    }
}
