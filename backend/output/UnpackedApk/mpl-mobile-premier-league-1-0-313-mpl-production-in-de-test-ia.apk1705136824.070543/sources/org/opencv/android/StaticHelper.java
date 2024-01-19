package org.opencv.android;

public class StaticHelper {
    public static native String getLibraryList();

    public static boolean loadLibrary(String str) {
        try {
            System.loadLibrary(str);
            return true;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
