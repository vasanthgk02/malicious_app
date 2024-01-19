package org.opencv.imgcodecs;

public class Imgcodecs {
    public static native long imdecode_0(long j, int i);

    public static native boolean imencode_0(String str, long j, long j2, long j3);

    public static native boolean imencode_1(String str, long j, long j2);

    public static native long imread_0(String str, int i);

    public static native long imread_1(String str);

    public static native boolean imreadmulti_0(String str, long j, int i);

    public static native boolean imreadmulti_1(String str, long j);

    public static native boolean imwrite_0(String str, long j, long j2);

    public static native boolean imwrite_1(String str, long j);
}
