package com.freshchat.consumer.sdk.beans.fragment;

import com.android.tools.r8.GeneratedOutlineSupport;

public class ImageFragment extends MessageFragment {
    public int height;
    public Thumbnail thumbnail;
    public int width;

    public ImageFragment() {
        super(FragmentType.IMAGE.asInt());
    }

    public int getHeight() {
        return this.height;
    }

    public Thumbnail getThumbnail() {
        return this.thumbnail;
    }

    public int getWidth() {
        return this.width;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setThumbnail(Thumbnail thumbnail2) {
        this.thumbnail = thumbnail2;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("ImageFragment{height=");
        outline73.append(this.height);
        outline73.append(", width=");
        outline73.append(this.width);
        outline73.append(", thumbnail=");
        outline73.append(this.thumbnail);
        outline73.append("} ");
        outline73.append(super.toString());
        return outline73.toString();
    }
}
