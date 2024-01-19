package com.userexperior.models.recording.enums;

public enum f {
    ACTION("com.userexperiorsdk.action"),
    INVOKE("com.userexperiorsdk.invoke"),
    START("com.userexperiorsdk.start"),
    START_STOP("com.userexperiorsdk.start_stop"),
    PAUSE_RESUME("com.userexperiorsdk.pasue_resume"),
    PAUSE("com.userexperiorsdk.pause"),
    RESUME("com.userexperiorsdk.resume"),
    STOP("com.userexperiorsdk.stop"),
    INTERRUPT("com.userexperiorsdk.interrupt"),
    APPLICATION_NOT_RESPONDING("com.userexperiorsdk.anr");
    
    public String value;

    /* access modifiers changed from: public */
    f(String str) {
        this.value = str;
    }

    public final String toString() {
        return this.value;
    }
}
