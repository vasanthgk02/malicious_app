package com.facebook.soloader.nativeloader;

public class NativeLoader {
    public static NativeLoaderDelegate sDelegate;

    public static synchronized void init(NativeLoaderDelegate nativeLoaderDelegate) {
        synchronized (NativeLoader.class) {
            if (sDelegate == null) {
                sDelegate = nativeLoaderDelegate;
            } else {
                throw new IllegalStateException("Cannot re-initialize NativeLoader.");
            }
        }
    }

    public static synchronized boolean isInitialized() {
        boolean z;
        synchronized (NativeLoader.class) {
            try {
                z = sDelegate != null;
            }
        }
        return z;
    }

    public static boolean loadLibrary(String str) {
        synchronized (NativeLoader.class) {
            if (sDelegate == null) {
                throw new IllegalStateException("NativeLoader has not been initialized.  To use standard native library loading, call NativeLoader.init(new SystemDelegate()).");
            }
        }
        return sDelegate.loadLibrary(str, 0);
    }
}
