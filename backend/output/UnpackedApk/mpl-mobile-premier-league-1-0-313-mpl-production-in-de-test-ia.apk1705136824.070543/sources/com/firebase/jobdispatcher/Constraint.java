package com.firebase.jobdispatcher;

public final class Constraint {
    public static final int[] ALL_CONSTRAINTS = {2, 1, 4, 8};

    public static int compact(int[] iArr) {
        if (iArr == null) {
            return 0;
        }
        int i = 0;
        for (int i2 : iArr) {
            i |= i2;
        }
        return i;
    }
}
