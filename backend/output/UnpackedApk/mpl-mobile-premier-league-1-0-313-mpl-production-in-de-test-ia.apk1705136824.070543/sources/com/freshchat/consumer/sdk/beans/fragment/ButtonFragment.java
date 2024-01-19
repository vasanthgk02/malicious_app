package com.freshchat.consumer.sdk.beans.fragment;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.apache.commons.lang.text.ExtendedMessageFormat;

public class ButtonFragment extends MessageFragment {
    public String androidUri;
    public String iosUri;
    public String label;

    public ButtonFragment() {
        super(FragmentType.BUTTON.asInt());
    }

    public String getAndroidUri() {
        return this.androidUri;
    }

    public String getIosUri() {
        return this.iosUri;
    }

    public String getLabel() {
        return this.label;
    }

    public void setAndroidUri(String str) {
        this.androidUri = str;
    }

    public void setIosUri(String str) {
        this.iosUri = str;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("ButtonFragment{label='");
        GeneratedOutlineSupport.outline99(outline73, this.label, ExtendedMessageFormat.QUOTE, ", androidUri='");
        GeneratedOutlineSupport.outline99(outline73, this.androidUri, ExtendedMessageFormat.QUOTE, ", iosUri='");
        GeneratedOutlineSupport.outline99(outline73, this.iosUri, ExtendedMessageFormat.QUOTE, "} ");
        outline73.append(super.toString());
        return outline73.toString();
    }
}
