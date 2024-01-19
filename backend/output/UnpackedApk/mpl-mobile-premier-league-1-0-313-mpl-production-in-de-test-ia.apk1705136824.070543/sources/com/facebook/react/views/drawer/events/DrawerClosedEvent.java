package com.facebook.react.views.drawer.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class DrawerClosedEvent extends Event<DrawerClosedEvent> {
    public DrawerClosedEvent(int i) {
        super(i);
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(this.mViewTag, "topDrawerClose", Arguments.createMap());
    }

    public short getCoalescingKey() {
        return 0;
    }

    public String getEventName() {
        return "topDrawerClose";
    }
}
