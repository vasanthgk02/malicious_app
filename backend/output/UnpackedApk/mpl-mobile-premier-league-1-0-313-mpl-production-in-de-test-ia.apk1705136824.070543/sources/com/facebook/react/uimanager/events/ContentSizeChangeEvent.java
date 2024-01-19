package com.facebook.react.uimanager.events;

import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;

public class ContentSizeChangeEvent extends Event<ContentSizeChangeEvent> {
    public final int mHeight;
    public final int mWidth;

    public ContentSizeChangeEvent(int i, int i2, int i3) {
        super(i);
        this.mWidth = i2;
        this.mHeight = i3;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("width", (double) ImageOriginUtils.toDIPFromPixel((float) this.mWidth));
        createMap.putDouble("height", (double) ImageOriginUtils.toDIPFromPixel((float) this.mHeight));
        rCTEventEmitter.receiveEvent(this.mViewTag, "topContentSizeChange", createMap);
    }

    public String getEventName() {
        return "topContentSizeChange";
    }
}
