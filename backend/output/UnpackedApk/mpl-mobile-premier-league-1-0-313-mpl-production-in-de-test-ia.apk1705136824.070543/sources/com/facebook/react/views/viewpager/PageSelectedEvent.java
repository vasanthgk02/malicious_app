package com.facebook.react.views.viewpager;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class PageSelectedEvent extends Event<PageSelectedEvent> {
    public final int mPosition;

    public PageSelectedEvent(int i, int i2) {
        super(i);
        this.mPosition = i2;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        int i = this.mViewTag;
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("position", this.mPosition);
        rCTEventEmitter.receiveEvent(i, "topPageSelected", createMap);
    }

    public String getEventName() {
        return "topPageSelected";
    }
}
