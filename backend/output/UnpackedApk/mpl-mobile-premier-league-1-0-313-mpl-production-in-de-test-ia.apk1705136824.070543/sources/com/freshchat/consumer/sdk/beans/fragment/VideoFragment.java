package com.freshchat.consumer.sdk.beans.fragment;

import com.android.tools.r8.GeneratedOutlineSupport;

public class VideoFragment extends MessageFragment {
    public Thumbnail thumbnail;

    public VideoFragment() {
        super(FragmentType.VIDEO.asInt());
    }

    public Thumbnail getThumbnail() {
        return this.thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail2) {
        this.thumbnail = thumbnail2;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("VideoFragment{thumbnail=");
        outline73.append(this.thumbnail);
        outline73.append("} ");
        outline73.append(super.toString());
        return outline73.toString();
    }
}
