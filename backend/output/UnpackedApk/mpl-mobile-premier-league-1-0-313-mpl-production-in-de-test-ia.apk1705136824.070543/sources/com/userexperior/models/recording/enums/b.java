package com.userexperior.models.recording.enums;

import com.userexperior.a.a.a.c;

public enum b {
    TOOL_TYPE_UNKNOWN("TOOL_TYPE_UNKNOWN"),
    TOOL_TYPE_FINGER("TOOL_TYPE_FINGER"),
    TOOL_TYPE_STYLUS("TOOL_TYPE_STYLUS"),
    TOOL_TYPE_MOUSE("TOOL_TYPE_MOUSE"),
    TOOL_TYPE_ERASER("TOOL_TYPE_ERASER"),
    SYSTEM_EVENT_OS("OS");
    
    @c(a = "inputType")
    public String value;

    /* access modifiers changed from: public */
    b(String str) {
        this.value = str;
    }

    public final String toString() {
        return this.value;
    }
}
