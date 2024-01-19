package com.badlogic.gdx;

public interface Input {

    public enum OnscreenKeyboardType {
        Default,
        NumberPad,
        PhonePad,
        Email,
        Password,
        URI
    }

    public enum Orientation {
        Landscape,
        Portrait
    }
}
