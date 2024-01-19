package com.facebook.react.bridge;

import com.android.tools.r8.GeneratedOutlineSupport;

public class JSCJavaScriptExecutorFactory implements JavaScriptExecutorFactory {
    public final String mAppName;
    public final String mDeviceName;

    public JSCJavaScriptExecutorFactory(String str, String str2) {
        this.mAppName = str;
        this.mDeviceName = str2;
    }

    public JavaScriptExecutor create() throws Exception {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putString("OwnerIdentity", "ReactNative");
        writableNativeMap.putString("AppIdentity", this.mAppName);
        writableNativeMap.putString("DeviceIdentity", this.mDeviceName);
        return new JSCJavaScriptExecutor(writableNativeMap);
    }

    public void startSamplingProfiler() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Starting sampling profiler not supported on ");
        outline73.append(toString());
        throw new UnsupportedOperationException(outline73.toString());
    }

    public void stopSamplingProfiler(String str) {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Stopping sampling profiler not supported on ");
        outline73.append(toString());
        throw new UnsupportedOperationException(outline73.toString());
    }

    public String toString() {
        return "JSCExecutor";
    }
}
