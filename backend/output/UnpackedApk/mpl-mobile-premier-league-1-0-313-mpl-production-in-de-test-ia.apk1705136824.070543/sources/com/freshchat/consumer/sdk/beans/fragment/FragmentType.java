package com.freshchat.consumer.sdk.beans.fragment;

public enum FragmentType {
    TEXT(1, TextFragment.class),
    IMAGE(2, ImageFragment.class),
    AUDIO(3, AudioFragment.class),
    VIDEO(4, VideoFragment.class),
    BUTTON(5, ButtonFragment.class),
    CALENDAR_EVENT(7, CalendarEventFragment.class),
    QUICK_REPLY_BUTTON(51, QuickReplyButtonFragment.class),
    CALLBACK_BUTTON(52, CallbackButtonFragment.class),
    COLLECTION(1000, CollectionFragment.class),
    TEMPLATE(1002, TemplateFragment.class),
    STATIC_TEMPLATE(5000, StaticTemplateFragment.class);
    
    public final Class clz;
    public final int intValue;

    /* access modifiers changed from: public */
    FragmentType(int i, Class cls) {
        this.intValue = i;
        this.clz = cls;
    }

    public static FragmentType fromInt(int i) {
        for (FragmentType fragmentType : values()) {
            if (fragmentType.asInt() == i) {
                return fragmentType;
            }
        }
        return null;
    }

    public int asInt() {
        return this.intValue;
    }

    public Class getClz() {
        return this.clz;
    }
}
