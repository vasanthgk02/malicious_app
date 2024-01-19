package org.opencv.core;

import com.android.tools.r8.GeneratedOutlineSupport;

public final class CvType {
    public static final int CV_32FC2 = CV_32FC(2);
    public static final int CV_32SC2 = CV_32SC(2);
    public static final int CV_8UC1 = CV_8UC(1);
    public static final int CV_8UC4 = CV_8UC(4);

    static {
        CV_8UC(2);
        CV_8UC(3);
        CV_8SC(1);
        CV_8SC(2);
        CV_8SC(3);
        CV_8SC(4);
        CV_16UC(1);
        CV_16UC(2);
        CV_16UC(3);
        CV_16UC(4);
        CV_16SC(1);
        CV_16SC(2);
        CV_16SC(3);
        CV_16SC(4);
        CV_32SC(1);
        CV_32SC(3);
        CV_32SC(4);
        CV_32FC(1);
        CV_32FC(3);
        CV_32FC(4);
        CV_64FC(1);
        CV_64FC(2);
        CV_64FC(3);
        CV_64FC(4);
    }

    public static final int CV_16SC(int i) {
        return makeType(3, i);
    }

    public static final int CV_16UC(int i) {
        return makeType(2, i);
    }

    public static final int CV_32FC(int i) {
        return makeType(5, i);
    }

    public static final int CV_32SC(int i) {
        return makeType(4, i);
    }

    public static final int CV_64FC(int i) {
        return makeType(6, i);
    }

    public static final int CV_8SC(int i) {
        return makeType(1, i);
    }

    public static final int CV_8UC(int i) {
        return makeType(0, i);
    }

    public static final int channels(int i) {
        return (i >> 3) + 1;
    }

    public static final int makeType(int i, int i2) {
        if (i2 <= 0 || i2 >= 512) {
            throw new UnsupportedOperationException("Channels count should be 1..511");
        } else if (i >= 0 && i < 8) {
            return (i & 7) + ((i2 - 1) << 3);
        } else {
            throw new UnsupportedOperationException("Data type depth should be 0..7");
        }
    }

    public static final String typeToString(int i) {
        String str;
        switch (i & 7) {
            case 0:
                str = "CV_8U";
                break;
            case 1:
                str = "CV_8S";
                break;
            case 2:
                str = "CV_16U";
                break;
            case 3:
                str = "CV_16S";
                break;
            case 4:
                str = "CV_32S";
                break;
            case 5:
                str = "CV_32F";
                break;
            case 6:
                str = "CV_64F";
                break;
            case 7:
                str = "CV_USRTYPE1";
                break;
            default:
                throw new UnsupportedOperationException(GeneratedOutlineSupport.outline41("Unsupported CvType value: ", i));
        }
        int i2 = (i >> 3) + 1;
        if (i2 <= 4) {
            return str + "C" + i2;
        }
        return str + "C(" + i2 + ")";
    }
}
