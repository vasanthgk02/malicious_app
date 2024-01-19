package com.facebook.react.views.slider;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import io.hansel.core.criteria.HSLCriteriaBuilder;

public class ReactSliderEvent extends Event<ReactSliderEvent> {
    public final boolean mFromUser;
    public final double mValue;

    public ReactSliderEvent(int i, double d2, boolean z) {
        super(i);
        this.mValue = d2;
        this.mFromUser = z;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        int i = this.mViewTag;
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("target", this.mViewTag);
        createMap.putDouble(HSLCriteriaBuilder.VALUE, this.mValue);
        createMap.putBoolean("fromUser", this.mFromUser);
        rCTEventEmitter.receiveEvent(i, "topChange", createMap);
    }

    public short getCoalescingKey() {
        return 0;
    }

    public String getEventName() {
        return "topChange";
    }
}
