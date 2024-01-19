package com.freshchat.consumer.sdk.beans.fragment;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.j.as;

public class TextFragment extends MessageFragment {
    public TextFragment() {
        super(FragmentType.TEXT.asInt());
    }

    public String getContent() {
        String content = super.getContent();
        return as.a(content) ? content.replaceAll("\n", "<br>") : content;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("TextFragment{} ");
        outline73.append(super.toString());
        return outline73.toString();
    }
}
