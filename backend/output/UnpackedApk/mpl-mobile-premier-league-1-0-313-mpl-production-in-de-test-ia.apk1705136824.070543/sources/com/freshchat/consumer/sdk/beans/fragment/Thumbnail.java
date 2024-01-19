package com.freshchat.consumer.sdk.beans.fragment;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.apache.commons.lang.text.ExtendedMessageFormat;

public class Thumbnail {
    public String content;
    public String contentType;
    public long height;
    public long width;

    public String getContent() {
        return this.content;
    }

    public String getContentType() {
        return this.contentType;
    }

    public long getHeight() {
        return this.height;
    }

    public long getWidth() {
        return this.width;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setContentType(String str) {
        this.contentType = str;
    }

    public void setHeight(long j) {
        this.height = j;
    }

    public void setWidth(long j) {
        this.width = j;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Thumbnail{content='");
        GeneratedOutlineSupport.outline99(outline73, this.content, ExtendedMessageFormat.QUOTE, ", contentType='");
        GeneratedOutlineSupport.outline99(outline73, this.contentType, ExtendedMessageFormat.QUOTE, ", height=");
        outline73.append(this.height);
        outline73.append(", width=");
        outline73.append(this.width);
        outline73.append('}');
        return outline73.toString();
    }
}
