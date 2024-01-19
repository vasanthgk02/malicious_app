package com.userexperior.models.recording.enums;

import com.userexperior.a.a.a.c;

public enum a {
    USER("USER"),
    SYSTEM("SYSTEM"),
    UE("UE");
    
    @c(a = "eventType")
    public String value;

    /* access modifiers changed from: public */
    a(String str) {
        this.value = str;
    }

    public final String toString() {
        return this.value;
    }
}
