package com.facebook.react.modules.deviceinfo;

import android.content.Context;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.fbreact.specs.NativeDeviceInfoSpec;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftException;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import java.util.HashMap;
import java.util.Map;

@ReactModule(name = "DeviceInfo")
public class DeviceInfoModule extends NativeDeviceInfoSpec implements LifecycleEventListener {
    public static final String NAME = "DeviceInfo";
    public float mFontScale;
    public ReadableMap mPreviousDisplayMetrics;
    public ReactApplicationContext mReactApplicationContext;

    public DeviceInfoModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        ImageOriginUtils.initDisplayMetricsIfNotInitialized(reactApplicationContext);
        this.mFontScale = reactApplicationContext.getResources().getConfiguration().fontScale;
        this.mReactApplicationContext = reactApplicationContext;
        reactApplicationContext.addLifecycleEventListener(this);
    }

    public void emitUpdateDimensionsEvent() {
        ReactApplicationContext reactApplicationContext = this.mReactApplicationContext;
        if (reactApplicationContext != null) {
            if (reactApplicationContext.hasActiveCatalystInstance()) {
                double d2 = (double) this.mFontScale;
                ImageOriginUtils.assertNotNull(Boolean.valueOf((ImageOriginUtils.sWindowDisplayMetrics == null && ImageOriginUtils.sScreenDisplayMetrics == null) ? false : true), "DisplayMetricsHolder must be initialized with initDisplayMetricsIfNotInitialized or initDisplayMetrics");
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                writableNativeMap.putMap("windowPhysicalPixels", ImageOriginUtils.getPhysicalPixelsNativeMap(ImageOriginUtils.sWindowDisplayMetrics, d2));
                writableNativeMap.putMap("screenPhysicalPixels", ImageOriginUtils.getPhysicalPixelsNativeMap(ImageOriginUtils.sScreenDisplayMetrics, d2));
                ReadableMap readableMap = this.mPreviousDisplayMetrics;
                if (readableMap == null) {
                    this.mPreviousDisplayMetrics = writableNativeMap.copy();
                } else if (!writableNativeMap.equals(readableMap)) {
                    this.mPreviousDisplayMetrics = writableNativeMap.copy();
                    ((RCTDeviceEventEmitter) this.mReactApplicationContext.getJSModule(RCTDeviceEventEmitter.class)).emit("didUpdateDimensions", writableNativeMap);
                }
            } else {
                ReactSoftException.logSoftException("DeviceInfo", new ReactNoCrashSoftException((String) "No active CatalystInstance, cannot emitUpdateDimensionsEvent"));
            }
        }
    }

    public String getName() {
        return "DeviceInfo";
    }

    public Map<String, Object> getTypedExportedConstants() {
        HashMap hashMap = new HashMap();
        double d2 = (double) this.mFontScale;
        ImageOriginUtils.assertNotNull(Boolean.valueOf((ImageOriginUtils.sWindowDisplayMetrics == null && ImageOriginUtils.sScreenDisplayMetrics == null) ? false : true), "DisplayMetricsHolder must be initialized with initDisplayMetricsIfNotInitialized or initDisplayMetrics");
        HashMap hashMap2 = new HashMap();
        hashMap2.put("windowPhysicalPixels", ImageOriginUtils.getPhysicalPixelsMap(ImageOriginUtils.sWindowDisplayMetrics, d2));
        hashMap2.put("screenPhysicalPixels", ImageOriginUtils.getPhysicalPixelsMap(ImageOriginUtils.sScreenDisplayMetrics, d2));
        hashMap.put("Dimensions", hashMap2);
        return hashMap;
    }

    public void invalidate() {
    }

    public void onHostDestroy() {
    }

    public void onHostPause() {
    }

    public void onHostResume() {
        ReactApplicationContext reactApplicationContext = this.mReactApplicationContext;
        if (reactApplicationContext != null) {
            float f2 = reactApplicationContext.getResources().getConfiguration().fontScale;
            if (this.mFontScale != f2) {
                this.mFontScale = f2;
                emitUpdateDimensionsEvent();
            }
        }
    }

    public DeviceInfoModule(Context context) {
        super(null);
        this.mReactApplicationContext = null;
        ImageOriginUtils.initDisplayMetricsIfNotInitialized(context);
        this.mFontScale = context.getResources().getConfiguration().fontScale;
    }
}
