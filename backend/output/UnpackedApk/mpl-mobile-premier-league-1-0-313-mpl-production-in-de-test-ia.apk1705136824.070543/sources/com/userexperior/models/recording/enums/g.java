package com.userexperior.models.recording.enums;

import com.facebook.imagepipeline.transcoder.JpegTranscoderUtils;
import com.userexperior.a.a.a.c;

public enum g {
    LOW("Low", 240),
    MEDIUM("Medium", JpegTranscoderUtils.FULL_ROUND),
    HIGH("High", 720);
    
    @c(a = "resolution")
    public int resolution;
    public String value;

    /* access modifiers changed from: public */
    g(String str, int i) {
        this.value = str;
        this.resolution = i;
    }

    public final int getResolution() {
        return this.resolution;
    }

    public final String toString() {
        return this.value;
    }
}
