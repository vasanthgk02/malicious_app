package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class ReactContentSizeChangedEvent extends Event<ReactTextChangedEvent> {
    public float mContentHeight;
    public float mContentWidth;

    public ReactContentSizeChangedEvent(int i, float f2, float f3) {
        super(i);
        this.mContentWidth = f2;
        this.mContentHeight = f3;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        int i = this.mViewTag;
        WritableMap createMap = Arguments.createMap();
        WritableMap createMap2 = Arguments.createMap();
        createMap2.putDouble("width", (double) this.mContentWidth);
        createMap2.putDouble("height", (double) this.mContentHeight);
        createMap.putMap("contentSize", createMap2);
        createMap.putInt("target", this.mViewTag);
        rCTEventEmitter.receiveEvent(i, "topContentSizeChange", createMap);
    }

    public String getEventName() {
        return "topContentSizeChange";
    }
}
