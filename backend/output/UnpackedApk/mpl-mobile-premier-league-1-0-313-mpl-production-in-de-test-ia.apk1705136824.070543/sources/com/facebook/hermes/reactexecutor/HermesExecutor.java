package com.facebook.hermes.reactexecutor;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.crimzoncode.tqcontests.util.TQConstants;
import com.facebook.jni.HybridData;
import com.facebook.react.bridge.JavaScriptExecutor;
import com.facebook.soloader.SoLoader;

public class HermesExecutor extends JavaScriptExecutor {
    public static String mode_;

    static {
        SoLoader.loadLibrary("hermes");
        try {
            SoLoader.loadLibrary("hermes-executor-debug");
            mode_ = TQConstants.ENVIRONMENT_DEBUG;
        } catch (UnsatisfiedLinkError unused) {
            SoLoader.loadLibrary("hermes-executor-release");
            mode_ = "Release";
        }
    }

    public HermesExecutor() {
        super(initHybridDefaultConfig());
    }

    public static native boolean canLoadFile(String str);

    public static native HybridData initHybrid(long j, boolean z);

    public static native HybridData initHybridDefaultConfig();

    public String getName() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("HermesExecutor");
        outline73.append(mode_);
        return outline73.toString();
    }
}
