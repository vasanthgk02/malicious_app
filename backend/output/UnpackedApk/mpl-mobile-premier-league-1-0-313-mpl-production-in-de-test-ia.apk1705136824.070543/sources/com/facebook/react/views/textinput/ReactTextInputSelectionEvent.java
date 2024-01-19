package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.razorpay.AnalyticsConstants;

public class ReactTextInputSelectionEvent extends Event<ReactTextInputSelectionEvent> {
    public int mSelectionEnd;
    public int mSelectionStart;

    public ReactTextInputSelectionEvent(int i, int i2, int i3) {
        super(i);
        this.mSelectionStart = i2;
        this.mSelectionEnd = i3;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        int i = this.mViewTag;
        WritableMap createMap = Arguments.createMap();
        WritableMap createMap2 = Arguments.createMap();
        createMap2.putInt(AnalyticsConstants.END, this.mSelectionEnd);
        createMap2.putInt(AnalyticsConstants.START, this.mSelectionStart);
        createMap.putMap("selection", createMap2);
        rCTEventEmitter.receiveEvent(i, "topSelectionChange", createMap);
    }

    public String getEventName() {
        return "topSelectionChange";
    }
}
