package org.opencv.core;

public class MatOfRect extends Mat {
    public Rect[] toArray() {
        int i = (int) total();
        Rect[] rectArr = new Rect[i];
        if (i == 0) {
            return rectArr;
        }
        int[] iArr = new int[(i * 4)];
        get(0, 0, iArr);
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = i2 * 4;
            rectArr[i2] = new Rect(iArr[i3], iArr[i3 + 1], iArr[i3 + 2], iArr[i3 + 3]);
        }
        return rectArr;
    }
}
