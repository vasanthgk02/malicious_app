package com.freshchat.consumer.sdk.beans.fragment;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.j.as;
import org.apache.commons.lang.text.ExtendedMessageFormat;

public abstract class MessageFragment {
    public String content;
    public String contentType;
    public int fragmentType;
    public String inputType;
    public String translatedContent;

    public MessageFragment(int i) {
        this.fragmentType = i;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MessageFragment messageFragment = (MessageFragment) obj;
        if (this.fragmentType != messageFragment.fragmentType || !as.o(this.content, messageFragment.content) || !as.o(this.contentType, messageFragment.contentType) || !as.o(this.translatedContent, messageFragment.translatedContent)) {
            z = false;
        }
        return z;
    }

    public String getContent() {
        return this.content;
    }

    public String getContentType() {
        return this.contentType;
    }

    public int getFragmentType() {
        return this.fragmentType;
    }

    public String getInputType() {
        return this.inputType;
    }

    public String getTranslatedContent() {
        return this.translatedContent;
    }

    public MessageFragment setContent(String str) {
        this.content = str;
        return this;
    }

    public MessageFragment setContentType(String str) {
        this.contentType = str;
        return this;
    }

    public void setInputType(String str) {
        this.inputType = str;
    }

    public void setTranslatedContent(String str) {
        this.translatedContent = str;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("MessageFragment{content='");
        GeneratedOutlineSupport.outline99(outline73, this.content, ExtendedMessageFormat.QUOTE, ", contentType='");
        GeneratedOutlineSupport.outline99(outline73, this.contentType, ExtendedMessageFormat.QUOTE, ", fragmentType=");
        outline73.append(this.fragmentType);
        outline73.append(", translatedContent='");
        return GeneratedOutlineSupport.outline60(outline73, this.translatedContent, ExtendedMessageFormat.QUOTE, '}');
    }
}
