package com.userexperior.c.c;

public enum c {
    UPLOAD_DATA("com.userexperiorsdk.upload.data"),
    UPLOAD_CRASH_DATA("com.userexperior.upload.crash"),
    UPLOAD_ANR_DATA("com.userexperior.upload.anr");
    
    public String value;

    /* access modifiers changed from: public */
    c(String str) {
        this.value = str;
    }

    public final String toString() {
        return this.value;
    }
}
