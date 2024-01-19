package com.facebook.react.bridge;

import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public class WritableNativeArray extends ReadableNativeArray implements WritableArray {
    static {
        ReactBridge.staticInit();
    }

    public WritableNativeArray() {
        super(initHybrid());
    }

    public static native HybridData initHybrid();

    private native void pushNativeArray(WritableNativeArray writableNativeArray);

    private native void pushNativeMap(WritableNativeMap writableNativeMap);

    public void pushArray(ReadableArray readableArray) {
        ImageOriginUtils.assertCondition(readableArray == null || (readableArray instanceof WritableNativeArray), "Illegal type provided");
        pushNativeArray((WritableNativeArray) readableArray);
    }

    public native void pushBoolean(boolean z);

    public native void pushDouble(double d2);

    public native void pushInt(int i);

    public void pushMap(ReadableMap readableMap) {
        ImageOriginUtils.assertCondition(readableMap == null || (readableMap instanceof WritableNativeMap), "Illegal type provided");
        pushNativeMap((WritableNativeMap) readableMap);
    }

    public native void pushNull();

    public native void pushString(String str);
}
