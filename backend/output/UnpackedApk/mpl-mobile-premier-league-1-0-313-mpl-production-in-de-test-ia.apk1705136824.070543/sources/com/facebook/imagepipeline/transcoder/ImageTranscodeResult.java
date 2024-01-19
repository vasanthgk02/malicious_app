package com.facebook.imagepipeline.transcoder;

public class ImageTranscodeResult {
    public final int mTranscodeStatus;

    public ImageTranscodeResult(int i) {
        this.mTranscodeStatus = i;
    }

    public int getTranscodeStatus() {
        return this.mTranscodeStatus;
    }

    public String toString() {
        return String.format(null, "Status: %d", new Object[]{Integer.valueOf(this.mTranscodeStatus)});
    }
}
