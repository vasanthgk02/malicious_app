package com.facebook.react.views.modal;

import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class RequestCloseEvent extends Event<RequestCloseEvent> {
    public RequestCloseEvent(int i) {
        super(i);
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(this.mViewTag, "topRequestClose", null);
    }

    public String getEventName() {
        return "topRequestClose";
    }
}
