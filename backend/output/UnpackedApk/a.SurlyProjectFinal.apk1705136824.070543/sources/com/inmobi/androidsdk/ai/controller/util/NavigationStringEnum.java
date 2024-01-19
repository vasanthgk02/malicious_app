package com.inmobi.androidsdk.ai.controller.util;

public enum NavigationStringEnum {
    NONE("none"),
    CLOSE("close"),
    BACK("back"),
    FORWARD("forward"),
    REFRESH("refresh");
    
    private String text;

    private NavigationStringEnum(String text2) {
        this.text = text2;
    }

    public String getText() {
        return this.text;
    }

    public static NavigationStringEnum fromString(String text2) {
        if (text2 != null) {
            for (NavigationStringEnum b : values()) {
                if (text2.equalsIgnoreCase(b.text)) {
                    return b;
                }
            }
        }
        return null;
    }
}
