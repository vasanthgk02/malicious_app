package com.freshchat.consumer.sdk.j;

import com.freshchat.consumer.sdk.beans.fragment.ButtonFragment;
import com.freshchat.consumer.sdk.beans.fragment.CallbackButtonFragment;
import com.freshchat.consumer.sdk.beans.fragment.MessageFragment;
import com.freshchat.consumer.sdk.beans.fragment.SectionKey;
import com.freshchat.consumer.sdk.beans.fragment.TemplateFragment;

public class cg {
    public static String a(TemplateFragment templateFragment, SectionKey sectionKey) {
        MessageFragment b2 = b(templateFragment, sectionKey);
        if (b2 == null) {
            return null;
        }
        return b2.getContent();
    }

    public static String a(TemplateFragment templateFragment, SectionKey sectionKey, String str) {
        if (templateFragment == null) {
            return str;
        }
        MessageFragment b2 = b(templateFragment, sectionKey);
        String str2 = null;
        if (b2 instanceof ButtonFragment) {
            str2 = ((ButtonFragment) b2).getLabel();
        } else if (b2 instanceof CallbackButtonFragment) {
            str2 = ((CallbackButtonFragment) b2).getLabel();
        }
        if (!as.isEmpty(str2)) {
            str = str2;
        }
        return str;
    }

    public static MessageFragment b(TemplateFragment templateFragment, SectionKey sectionKey) {
        if (templateFragment == null) {
            return null;
        }
        return templateFragment.getSingleFragmentFromSection(sectionKey);
    }
}
