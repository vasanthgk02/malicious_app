package com.facebook.react.fabric.mounting.mountitems;

import com.android.tools.r8.GeneratedOutlineSupport;

public class InsertMountItem implements MountItem {
    public int mIndex;
    public int mParentReactTag;
    public int mReactTag;

    public InsertMountItem(int i, int i2, int i3) {
        this.mReactTag = i;
        this.mParentReactTag = i2;
        this.mIndex = i3;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("InsertMountItem [");
        outline73.append(this.mReactTag);
        outline73.append("] - parentTag: ");
        outline73.append(this.mParentReactTag);
        outline73.append(" - index: ");
        outline73.append(this.mIndex);
        return outline73.toString();
    }
}
