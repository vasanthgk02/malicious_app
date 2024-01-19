package com.facebook.react.modules.blob;

import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.ReactContext;
import com.facebook.soloader.SoLoader;

public class BlobCollector {
    static {
        SoLoader.loadLibrary("reactnativeblob");
    }

    public static void install(final ReactContext reactContext, final BlobModule blobModule) {
        reactContext.runOnJSQueueThread(new Runnable() {
            public void run() {
                JavaScriptContextHolder javaScriptContextHolder = reactContext.getJavaScriptContextHolder();
                if (javaScriptContextHolder.get() != 0) {
                    BlobCollector.nativeInstall(blobModule, javaScriptContextHolder.get());
                }
            }
        });
    }

    public static native void nativeInstall(Object obj, long j);
}
