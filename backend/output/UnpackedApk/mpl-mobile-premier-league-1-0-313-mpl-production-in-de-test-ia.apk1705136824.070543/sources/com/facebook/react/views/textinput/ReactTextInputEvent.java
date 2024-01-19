package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.razorpay.AnalyticsConstants;

public class ReactTextInputEvent extends Event<ReactTextInputEvent> {
    public String mPreviousText;
    public int mRangeEnd;
    public int mRangeStart;
    public String mText;

    public ReactTextInputEvent(int i, String str, String str2, int i2, int i3) {
        super(i);
        this.mText = str;
        this.mPreviousText = str2;
        this.mRangeStart = i2;
        this.mRangeEnd = i3;
    }

    public boolean canCoalesce() {
        return false;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        int i = this.mViewTag;
        WritableMap createMap = Arguments.createMap();
        WritableMap createMap2 = Arguments.createMap();
        createMap2.putDouble(AnalyticsConstants.START, (double) this.mRangeStart);
        createMap2.putDouble(AnalyticsConstants.END, (double) this.mRangeEnd);
        createMap.putString("text", this.mText);
        createMap.putString("previousText", this.mPreviousText);
        createMap.putMap("range", createMap2);
        createMap.putInt("target", this.mViewTag);
        rCTEventEmitter.receiveEvent(i, "topTextInput", createMap);
    }

    public String getEventName() {
        return "topTextInput";
    }
}
