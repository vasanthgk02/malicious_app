package org.opencv.core;

import com.android.tools.r8.GeneratedOutlineSupport;

public class MatOfPoint2f extends Mat {
    public Point[] toArray() {
        int i = (int) total();
        Point[] pointArr = new Point[i];
        if (i == 0) {
            return pointArr;
        }
        int i2 = i * 2;
        float[] fArr = new float[i2];
        int type = type();
        if (i2 % CvType.channels(type) != 0) {
            StringBuilder outline74 = GeneratedOutlineSupport.outline74("Provided data element number (", i2, ") should be multiple of the Mat channels count (");
            outline74.append(CvType.channels(type));
            outline74.append(")");
            throw new UnsupportedOperationException(outline74.toString());
        } else if ((type & 7) == 5) {
            Mat.nGetF(this.nativeObj, 0, 0, i2, fArr);
            for (int i3 = 0; i3 < i; i3++) {
                int i4 = i3 * 2;
                pointArr[i3] = new Point((double) fArr[i4], (double) fArr[i4 + 1]);
            }
            return pointArr;
        } else {
            throw new UnsupportedOperationException(GeneratedOutlineSupport.outline41("Mat data type is not compatible: ", type));
        }
    }
}
