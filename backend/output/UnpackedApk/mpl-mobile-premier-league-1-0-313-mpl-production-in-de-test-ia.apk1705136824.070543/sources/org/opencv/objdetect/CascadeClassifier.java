package org.opencv.objdetect;

public class CascadeClassifier {
    public final long nativeObj;

    public CascadeClassifier(String str) {
        this.nativeObj = CascadeClassifier_0(str);
    }

    public static native long CascadeClassifier_0(String str);

    public static native long CascadeClassifier_1();

    public static native boolean convert_0(String str, String str2);

    public static native void delete(long j);

    public static native void detectMultiScale2_0(long j, long j2, long j3, long j4, double d2, int i, int i2, double d3, double d4, double d5, double d6);

    public static native void detectMultiScale2_1(long j, long j2, long j3, long j4);

    public static native void detectMultiScale3_0(long j, long j2, long j3, long j4, long j5, double d2, int i, int i2, double d3, double d4, double d5, double d6, boolean z);

    public static native void detectMultiScale3_1(long j, long j2, long j3, long j4, long j5);

    public static native void detectMultiScale_0(long j, long j2, long j3, double d2, int i, int i2, double d3, double d4, double d5, double d6);

    public static native void detectMultiScale_1(long j, long j2, long j3);

    public static native boolean empty_0(long j);

    public static native int getFeatureType_0(long j);

    public static native double[] getOriginalWindowSize_0(long j);

    public static native boolean isOldFormatCascade_0(long j);

    public static native boolean load_0(long j, String str);

    public void finalize() throws Throwable {
        delete(this.nativeObj);
    }
}
