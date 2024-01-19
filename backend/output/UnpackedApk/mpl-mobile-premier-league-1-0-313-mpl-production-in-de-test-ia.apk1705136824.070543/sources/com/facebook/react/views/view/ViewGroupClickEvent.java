package com.facebook.react.views.view;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class ViewGroupClickEvent extends Event<ViewGroupClickEvent> {
    public ViewGroupClickEvent(int i) {
        super(i);
    }

    public boolean canCoalesce() {
        return false;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(this.mViewTag, "topClick", Arguments.createMap());
    }

    public String getEventName() {
        return "topClick";
    }
}
