package com.twitter.sdk.android.core.internal;

public enum UserUtils$AvatarSize {
    NORMAL("_normal"),
    BIGGER("_bigger"),
    MINI("_mini"),
    ORIGINAL("_original"),
    REASONABLY_SMALL("_reasonably_small");
    
    public final String suffix;

    /* access modifiers changed from: public */
    UserUtils$AvatarSize(String str) {
        this.suffix = str;
    }

    public String getSuffix() {
        return this.suffix;
    }
}
