package com.freshchat.consumer.sdk.beans.fragment;

import com.freshchat.consumer.sdk.j.as;
import com.netcore.android.notification.SMTNotificationConstants;

public enum TemplateType {
    QUICK_REPLY_DROP_DOWN("quick_reply_dropdown", QuickReplyDropDownFragment.class),
    CAROUSEL(SMTNotificationConstants.NOTIF_CAROUSEL_KEY, CarouselFragment.class),
    CAROUSEL_CARD_DEFAULT("carousel_card_default", CarouselCardDefaultFragment.class),
    QUICK_ACTIONS_BUTTONS("quick_actions", QuickActionsButtonFragment.class);
    
    public Class clz;
    public String str;

    /* access modifiers changed from: public */
    TemplateType(String str2, Class cls) {
        this.str = str2;
        this.clz = cls;
    }

    public static TemplateType get(String str2) {
        if (as.isEmpty(str2)) {
            return null;
        }
        for (TemplateType templateType : values()) {
            if (templateType.str.equals(str2)) {
                return templateType;
            }
        }
        return null;
    }

    public String asString() {
        return this.str;
    }

    public Class getClz() {
        return this.clz;
    }
}
