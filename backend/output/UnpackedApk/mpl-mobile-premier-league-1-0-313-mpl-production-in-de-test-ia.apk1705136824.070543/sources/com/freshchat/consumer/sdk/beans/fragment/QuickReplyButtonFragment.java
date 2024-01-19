package com.freshchat.consumer.sdk.beans.fragment;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.apache.commons.lang.text.ExtendedMessageFormat;

public class QuickReplyButtonFragment extends MessageFragment {
    public String customReplyText;
    public String label;
    public String payload;

    public QuickReplyButtonFragment() {
        super(FragmentType.QUICK_REPLY_BUTTON.asInt());
    }

    public String getCustomReplyText() {
        return this.customReplyText;
    }

    public String getLabel() {
        return this.label;
    }

    public String getPayload() {
        return this.payload;
    }

    public void setCustomReplyText(String str) {
        this.customReplyText = str;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void setPayload(String str) {
        this.payload = str;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("QuickReplyButtonFragment{messageFragment='");
        GeneratedOutlineSupport.outline99(outline73, super.toString(), ExtendedMessageFormat.QUOTE, ", label='");
        GeneratedOutlineSupport.outline99(outline73, this.label, ExtendedMessageFormat.QUOTE, ", customReplyText='");
        GeneratedOutlineSupport.outline99(outline73, this.customReplyText, ExtendedMessageFormat.QUOTE, ", payload='");
        return GeneratedOutlineSupport.outline60(outline73, this.payload, ExtendedMessageFormat.QUOTE, '}');
    }
}
