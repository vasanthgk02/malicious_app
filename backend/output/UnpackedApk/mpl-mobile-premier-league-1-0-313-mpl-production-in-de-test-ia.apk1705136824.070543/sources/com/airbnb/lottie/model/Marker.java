package com.airbnb.lottie.model;

public class Marker {
    public final float durationFrames;
    public final String name;
    public final float startFrame;

    public Marker(String str, float f2, float f3) {
        this.name = str;
        this.durationFrames = f3;
        this.startFrame = f2;
    }
}
