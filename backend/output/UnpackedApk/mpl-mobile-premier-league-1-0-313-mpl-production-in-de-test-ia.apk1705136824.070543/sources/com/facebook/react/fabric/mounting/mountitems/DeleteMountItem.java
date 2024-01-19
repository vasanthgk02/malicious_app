package com.facebook.react.fabric.mounting.mountitems;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.apache.fontbox.cmap.CMapParser;

public class DeleteMountItem implements MountItem {
    public int mReactTag;

    public DeleteMountItem(int i) {
        this.mReactTag = i;
    }

    public String toString() {
        return GeneratedOutlineSupport.outline57(GeneratedOutlineSupport.outline73("DeleteMountItem ["), this.mReactTag, CMapParser.MARK_END_OF_ARRAY);
    }
}
