package com.facebook.react.fabric.mounting.mountitems;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.fabric.events.EventEmitterWrapper;
import org.apache.fontbox.cmap.CMapParser;

public class UpdateEventEmitterMountItem implements MountItem {
    public final EventEmitterWrapper mEventHandler;
    public final int mReactTag;

    public UpdateEventEmitterMountItem(int i, EventEmitterWrapper eventEmitterWrapper) {
        this.mReactTag = i;
        this.mEventHandler = eventEmitterWrapper;
    }

    public String toString() {
        return GeneratedOutlineSupport.outline57(GeneratedOutlineSupport.outline73("UpdateEventEmitterMountItem ["), this.mReactTag, CMapParser.MARK_END_OF_ARRAY);
    }
}
