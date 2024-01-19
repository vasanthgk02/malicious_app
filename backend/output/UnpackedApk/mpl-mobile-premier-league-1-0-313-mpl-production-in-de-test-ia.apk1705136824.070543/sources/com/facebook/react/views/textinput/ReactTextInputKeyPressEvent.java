package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class ReactTextInputKeyPressEvent extends Event<ReactTextInputEvent> {
    public String mKey;

    public ReactTextInputKeyPressEvent(int i, String str) {
        super(i);
        this.mKey = str;
    }

    public boolean canCoalesce() {
        return false;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        int i = this.mViewTag;
        WritableMap createMap = Arguments.createMap();
        createMap.putString("key", this.mKey);
        rCTEventEmitter.receiveEvent(i, "topKeyPress", createMap);
    }

    public String getEventName() {
        return "topKeyPress";
    }
}
