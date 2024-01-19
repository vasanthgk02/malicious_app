package com.userexperior.models.recording.enums;

public enum d {
    USER_SCREEN_SHOTS("SCREENSHOTS"),
    EVENTS_JSON("EVENT_JSON"),
    CRASH_LOG("CRASH_LOG"),
    ANR_LOG("ANR_LOG");
    
    public String value;

    /* access modifiers changed from: public */
    d(String str) {
        this.value = str;
    }

    public final String toString() {
        return this.value;
    }
}
