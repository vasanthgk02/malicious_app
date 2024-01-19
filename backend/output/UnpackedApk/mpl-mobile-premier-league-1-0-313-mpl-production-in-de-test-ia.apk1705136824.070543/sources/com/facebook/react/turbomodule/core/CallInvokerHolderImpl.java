package com.facebook.react.turbomodule.core;

import com.facebook.jni.HybridData;
import com.facebook.react.turbomodule.core.interfaces.CallInvokerHolder;
import com.facebook.soloader.SoLoader;

public class CallInvokerHolderImpl implements CallInvokerHolder {
    public static volatile boolean sIsSoLibraryLoaded;
    public final HybridData mHybridData;

    public CallInvokerHolderImpl(HybridData hybridData) {
        maybeLoadSoLibrary();
        this.mHybridData = hybridData;
    }

    public static synchronized void maybeLoadSoLibrary() {
        synchronized (CallInvokerHolderImpl.class) {
            if (!sIsSoLibraryLoaded) {
                SoLoader.loadLibrary("turbomodulejsijni");
                sIsSoLibraryLoaded = true;
            }
        }
    }
}
