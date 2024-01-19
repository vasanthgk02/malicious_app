package com.squareup.moshi;

import com.android.tools.r8.GeneratedOutlineSupport;

public final class JsonScope {
    public static final int CLOSED = 8;
    public static final int DANGLING_NAME = 4;
    public static final int EMPTY_ARRAY = 1;
    public static final int EMPTY_DOCUMENT = 6;
    public static final int EMPTY_OBJECT = 3;
    public static final int NONEMPTY_ARRAY = 2;
    public static final int NONEMPTY_DOCUMENT = 7;
    public static final int NONEMPTY_OBJECT = 5;
    public static final int STREAMING_VALUE = 9;

    public static String getPath(int i, int[] iArr, String[] strArr, int[] iArr2) {
        StringBuilder outline72 = GeneratedOutlineSupport.outline72('$');
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = iArr[i2];
            if (i3 == 1 || i3 == 2) {
                outline72.append('[');
                outline72.append(iArr2[i2]);
                outline72.append(']');
            } else if (i3 == 3 || i3 == 4 || i3 == 5) {
                outline72.append('.');
                if (strArr[i2] != null) {
                    outline72.append(strArr[i2]);
                }
            }
        }
        return outline72.toString();
    }
}
