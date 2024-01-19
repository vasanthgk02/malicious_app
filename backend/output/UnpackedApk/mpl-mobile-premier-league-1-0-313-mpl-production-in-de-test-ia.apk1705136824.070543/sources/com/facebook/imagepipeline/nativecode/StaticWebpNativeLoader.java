package com.facebook.imagepipeline.nativecode;

import com.facebook.soloader.SoLoader;

public class StaticWebpNativeLoader {
    public static boolean sInitialized;

    public static synchronized void ensure() {
        synchronized (StaticWebpNativeLoader.class) {
            if (!sInitialized) {
                SoLoader.loadLibrary("static-webp");
                sInitialized = true;
            }
        }
    }
}
