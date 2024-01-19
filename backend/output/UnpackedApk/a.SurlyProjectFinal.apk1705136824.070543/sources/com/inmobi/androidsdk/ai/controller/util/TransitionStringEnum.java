package com.inmobi.androidsdk.ai.controller.util;

public enum TransitionStringEnum {
    DEFAULT("default"),
    DISSOLVE("dissolve"),
    FADE("fade"),
    ROLL("roll"),
    SLIDE("slide"),
    ZOOM("zoom"),
    NONE("none");
    
    private String text;

    private TransitionStringEnum(String text2) {
        this.text = text2;
    }

    public String getText() {
        return this.text;
    }

    public static TransitionStringEnum fromString(String text2) {
        if (text2 != null) {
            for (TransitionStringEnum b : values()) {
                if (text2.equalsIgnoreCase(b.text)) {
                    return b;
                }
            }
        }
        return null;
    }
}
