package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class ReactTextInputBlurEvent extends Event<ReactTextInputBlurEvent> {
    public ReactTextInputBlurEvent(int i) {
        super(i);
    }

    public boolean canCoalesce() {
        return false;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        int i = this.mViewTag;
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("target", this.mViewTag);
        rCTEventEmitter.receiveEvent(i, "topBlur", createMap);
    }

    public String getEventName() {
        return "topBlur";
    }
}
