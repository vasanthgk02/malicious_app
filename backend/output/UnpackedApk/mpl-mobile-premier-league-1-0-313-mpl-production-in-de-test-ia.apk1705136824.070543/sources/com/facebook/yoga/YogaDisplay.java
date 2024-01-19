package com.facebook.yoga;

import com.android.tools.r8.GeneratedOutlineSupport;

public enum YogaDisplay {
    FLEX(0),
    NONE(1);
    
    public final int mIntValue;

    /* access modifiers changed from: public */
    YogaDisplay(int i) {
        this.mIntValue = i;
    }

    public static YogaDisplay fromInt(int i) {
        if (i == 0) {
            return FLEX;
        }
        if (i == 1) {
            return NONE;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("Unknown enum value: ", i));
    }

    public int intValue() {
        return this.mIntValue;
    }
}
