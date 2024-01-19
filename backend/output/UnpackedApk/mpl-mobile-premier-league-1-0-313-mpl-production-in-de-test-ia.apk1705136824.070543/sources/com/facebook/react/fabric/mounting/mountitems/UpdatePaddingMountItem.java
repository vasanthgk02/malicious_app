package com.facebook.react.fabric.mounting.mountitems;

import com.android.tools.r8.GeneratedOutlineSupport;

public class UpdatePaddingMountItem implements MountItem {
    public final int mBottom;
    public final int mLeft;
    public final int mReactTag;
    public final int mRight;
    public final int mTop;

    public UpdatePaddingMountItem(int i, int i2, int i3, int i4, int i5) {
        this.mReactTag = i;
        this.mLeft = i2;
        this.mTop = i3;
        this.mRight = i4;
        this.mBottom = i5;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("UpdatePaddingMountItem [");
        outline73.append(this.mReactTag);
        outline73.append("] - left: ");
        outline73.append(this.mLeft);
        outline73.append(" - top: ");
        outline73.append(this.mTop);
        outline73.append(" - right: ");
        outline73.append(this.mRight);
        outline73.append(" - bottom: ");
        outline73.append(this.mBottom);
        return outline73.toString();
    }
}
