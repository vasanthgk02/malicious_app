package com.facebook.react.fabric.mounting.mountitems;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ReadableMap;
import org.apache.fontbox.cmap.CMapParser;

public class UpdatePropsMountItem implements MountItem {
    public final int mReactTag;
    public final ReadableMap mUpdatedProps;

    public UpdatePropsMountItem(int i, ReadableMap readableMap) {
        this.mReactTag = i;
        this.mUpdatedProps = readableMap;
    }

    public String toString() {
        return GeneratedOutlineSupport.outline57(new StringBuilder("UpdatePropsMountItem ["), this.mReactTag, CMapParser.MARK_END_OF_ARRAY);
    }
}
