package com.userexperior.models.recording.enums;

import com.userexperior.a.a.a.c;

public enum h {
    SWIPE("SWIPE"),
    TAP("SINGLE_TAP"),
    DOUBLE_TAP("DOUBLE_TAP"),
    PINCH("PINCH"),
    ZOOM("ZOOM"),
    LONG_PRESS("LONG_PRESS"),
    ANR("ANR"),
    EXCEPTION("EXCEPTION"),
    CREATED("CREATED"),
    STARTED("STARTED"),
    RESUMED("RESUMED"),
    PAUSED("PAUSED"),
    STOPPED("STOPPED"),
    SAVED_INSTANCE_STATE("SAVED_INSTANCE_STATE"),
    DESTROYED("DESTROYED"),
    BACK_BUTTON_PRESSED("BACK_BUTTON_PRESSED"),
    HOME_BUTTON_PRESSED("HOME_BUTTON_PRESSED"),
    TAG(UeCustomType.TAG),
    EVENT(UeCustomType.EVENT),
    MSG(UeCustomType.MSG),
    ERROR("ERROR"),
    APP_LAUNCH("APP_LAUNCH");
    
    @c(a = "type")
    public String value;

    /* access modifiers changed from: public */
    h(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    public final void setValue(String str) {
        this.value = str;
    }

    public final String toString() {
        return this.value;
    }
}
