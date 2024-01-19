package com.facebook.react.views.slider;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import io.hansel.core.criteria.HSLCriteriaBuilder;

public class ReactSlidingCompleteEvent extends Event<ReactSlidingCompleteEvent> {
    public final double mValue;

    public ReactSlidingCompleteEvent(int i, double d2) {
        super(i);
        this.mValue = d2;
    }

    public boolean canCoalesce() {
        return false;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        int i = this.mViewTag;
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("target", this.mViewTag);
        createMap.putDouble(HSLCriteriaBuilder.VALUE, this.mValue);
        rCTEventEmitter.receiveEvent(i, "topSlidingComplete", createMap);
    }

    public short getCoalescingKey() {
        return 0;
    }

    public String getEventName() {
        return "topSlidingComplete";
    }
}
