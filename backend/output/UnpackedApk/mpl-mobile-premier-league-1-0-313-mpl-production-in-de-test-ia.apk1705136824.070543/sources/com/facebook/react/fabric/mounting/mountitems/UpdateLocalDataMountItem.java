package com.facebook.react.fabric.mounting.mountitems;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ReadableMap;
import org.apache.fontbox.cmap.CMapParser;

public class UpdateLocalDataMountItem implements MountItem {
    public final ReadableMap mNewLocalData;
    public final int mReactTag;

    public UpdateLocalDataMountItem(int i, ReadableMap readableMap) {
        this.mReactTag = i;
        this.mNewLocalData = readableMap;
    }

    public String toString() {
        return GeneratedOutlineSupport.outline57(new StringBuilder("UpdateLocalDataMountItem ["), this.mReactTag, CMapParser.MARK_END_OF_ARRAY);
    }
}
