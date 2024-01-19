package com.facebook.react.fabric.events;

import android.annotation.SuppressLint;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.fabric.FabricSoLoader;
import com.facebook.react.uimanager.events.BatchEventDispatchedListener;

@SuppressLint({"MissingNativeLoadLibrary"})
public class EventBeatManager implements BatchEventDispatchedListener {
    @DoNotStrip
    public final HybridData mHybridData;

    static {
        FabricSoLoader.staticInit();
    }

    public static native HybridData initHybrid();

    private native void tick();

    public void onBatchEventDispatched() {
        tick();
    }
}
