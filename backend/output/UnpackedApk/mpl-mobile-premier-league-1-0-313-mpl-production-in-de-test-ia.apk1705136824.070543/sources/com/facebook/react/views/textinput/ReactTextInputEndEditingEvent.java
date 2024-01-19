package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class ReactTextInputEndEditingEvent extends Event<ReactTextInputEndEditingEvent> {
    public String mText;

    public ReactTextInputEndEditingEvent(int i, String str) {
        super(i);
        this.mText = str;
    }

    public boolean canCoalesce() {
        return false;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        int i = this.mViewTag;
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("target", this.mViewTag);
        createMap.putString("text", this.mText);
        rCTEventEmitter.receiveEvent(i, "topEndEditing", createMap);
    }

    public String getEventName() {
        return "topEndEditing";
    }
}
