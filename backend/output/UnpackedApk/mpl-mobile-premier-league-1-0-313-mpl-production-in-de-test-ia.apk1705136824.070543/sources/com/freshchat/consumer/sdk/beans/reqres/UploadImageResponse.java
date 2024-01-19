package com.freshchat.consumer.sdk.beans.reqres;

import com.freshchat.consumer.sdk.beans.fragment.ImageFragment;

public class UploadImageResponse {
    public ImageFragment image;
    public String name;

    public ImageFragment getImage() {
        return this.image;
    }

    public String getName() {
        return this.name;
    }

    public void setImage(ImageFragment imageFragment) {
        this.image = imageFragment;
    }

    public void setName(String str) {
        this.name = str;
    }
}
