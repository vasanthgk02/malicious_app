package com.freshchat.consumer.sdk.beans.fragment;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.apache.commons.lang.text.ExtendedMessageFormat;

public class CallbackButtonFragment extends MessageFragment {
    public String label;
    public String payload;

    public CallbackButtonFragment() {
        super(FragmentType.CALLBACK_BUTTON.asInt());
    }

    public String getLabel() {
        return this.label;
    }

    public String getPayload() {
        return this.payload;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void setPayload(String str) {
        this.payload = str;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("CallbackButtonFragment{content='");
        outline73.append(getContent());
        outline73.append(ExtendedMessageFormat.QUOTE);
        outline73.append(", contentType='");
        outline73.append(getContentType());
        outline73.append(ExtendedMessageFormat.QUOTE);
        outline73.append(", fragmentType=");
        outline73.append(getFragmentType());
        outline73.append(", label='");
        GeneratedOutlineSupport.outline99(outline73, this.label, ExtendedMessageFormat.QUOTE, ", payload='");
        return GeneratedOutlineSupport.outline60(outline73, this.payload, ExtendedMessageFormat.QUOTE, '}');
    }
}
