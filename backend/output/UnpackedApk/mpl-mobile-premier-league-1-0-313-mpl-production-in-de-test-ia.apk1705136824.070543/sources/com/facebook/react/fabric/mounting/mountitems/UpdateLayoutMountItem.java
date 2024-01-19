package com.facebook.react.fabric.mounting.mountitems;

import com.android.tools.r8.GeneratedOutlineSupport;

public class UpdateLayoutMountItem implements MountItem {
    public final int mHeight;
    public final int mLayoutDirection;
    public final int mReactTag;
    public final int mWidth;
    public final int mX;
    public final int mY;

    public UpdateLayoutMountItem(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mReactTag = i;
        this.mX = i2;
        this.mY = i3;
        this.mWidth = i4;
        this.mHeight = i5;
        int i7 = 2;
        if (i6 != 0) {
            if (i6 == 1) {
                i7 = 0;
            } else if (i6 == 2) {
                i7 = 1;
            } else {
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("Unsupported layout direction: ", i6));
            }
        }
        this.mLayoutDirection = i7;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("UpdateLayoutMountItem [");
        outline73.append(this.mReactTag);
        outline73.append("] - x: ");
        outline73.append(this.mX);
        outline73.append(" - y: ");
        outline73.append(this.mY);
        outline73.append(" - height: ");
        outline73.append(this.mHeight);
        outline73.append(" - width: ");
        outline73.append(this.mWidth);
        outline73.append(" - layoutDirection: ");
        outline73.append(this.mLayoutDirection);
        return outline73.toString();
    }
}
