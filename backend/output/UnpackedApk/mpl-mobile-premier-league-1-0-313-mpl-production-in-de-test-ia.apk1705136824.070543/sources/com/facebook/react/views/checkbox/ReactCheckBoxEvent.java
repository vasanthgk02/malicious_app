package com.facebook.react.views.checkbox;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import io.hansel.core.criteria.HSLCriteriaBuilder;

public class ReactCheckBoxEvent extends Event<ReactCheckBoxEvent> {
    public final boolean mIsChecked;

    public ReactCheckBoxEvent(int i, boolean z) {
        super(i);
        this.mIsChecked = z;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        int i = this.mViewTag;
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("target", this.mViewTag);
        createMap.putBoolean(HSLCriteriaBuilder.VALUE, this.mIsChecked);
        rCTEventEmitter.receiveEvent(i, "topChange", createMap);
    }

    public short getCoalescingKey() {
        return 0;
    }

    public String getEventName() {
        return "topChange";
    }
}
