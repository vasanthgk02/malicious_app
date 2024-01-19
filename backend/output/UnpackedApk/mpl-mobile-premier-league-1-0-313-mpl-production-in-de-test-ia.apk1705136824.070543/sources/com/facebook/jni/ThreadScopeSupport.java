package com.facebook.jni;

import com.facebook.jni.annotations.DoNotStrip;
import com.facebook.soloader.nativeloader.NativeLoader;

@DoNotStrip
public class ThreadScopeSupport {
    static {
        NativeLoader.loadLibrary("fbjni");
    }

    @DoNotStrip
    public static void runStdFunction(long j) {
        runStdFunctionImpl(j);
    }

    public static native void runStdFunctionImpl(long j);
}
