package com.facebook.yoga;

import com.android.tools.r8.GeneratedOutlineSupport;

public enum YogaWrap {
    NO_WRAP(0),
    WRAP(1),
    WRAP_REVERSE(2);
    
    public final int mIntValue;

    /* access modifiers changed from: public */
    YogaWrap(int i) {
        this.mIntValue = i;
    }

    public static YogaWrap fromInt(int i) {
        if (i == 0) {
            return NO_WRAP;
        }
        if (i == 1) {
            return WRAP;
        }
        if (i == 2) {
            return WRAP_REVERSE;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("Unknown enum value: ", i));
    }

    public int intValue() {
        return this.mIntValue;
    }
}
