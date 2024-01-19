package com.facebook.react;

import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.common.MapBuilder$Builder;
import com.paynimo.android.payment.UPIFragment;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;
import in.juspay.hypersdk.mystique.AnimationHolder.InlineAnimation;
import java.util.Map;

public class ReactAndroidHWInputDeviceHelper {
    public static final Map<Integer, String> KEY_EVENTS_ACTIONS;
    public int mLastFocusedViewId = -1;
    public final ReactRootView mReactRootView;

    static {
        MapBuilder$Builder builder = ImageOriginUtils.builder();
        builder.put(Integer.valueOf(23), UPIFragment.CONFIG_TYPE_SELECT);
        builder.put(Integer.valueOf(66), UPIFragment.CONFIG_TYPE_SELECT);
        builder.put(Integer.valueOf(62), UPIFragment.CONFIG_TYPE_SELECT);
        builder.put(Integer.valueOf(85), "playPause");
        builder.put(Integer.valueOf(89), "rewind");
        builder.put(Integer.valueOf(90), "fastForward");
        builder.put(Integer.valueOf(19), "up");
        builder.put(Integer.valueOf(22), RNGestureHandlerModule.KEY_HIT_SLOP_RIGHT);
        builder.put(Integer.valueOf(20), "down");
        builder.put(Integer.valueOf(21), RNGestureHandlerModule.KEY_HIT_SLOP_LEFT);
        KEY_EVENTS_ACTIONS = builder.build();
    }

    public ReactAndroidHWInputDeviceHelper(ReactRootView reactRootView) {
        this.mReactRootView = reactRootView;
    }

    public final void dispatchEvent(String str, int i, int i2) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putString("eventType", str);
        writableNativeMap.putInt("eventKeyAction", i2);
        if (i != -1) {
            writableNativeMap.putInt(InlineAnimation.TAG, i);
        }
        this.mReactRootView.sendEvent("onHWKeyEvent", writableNativeMap);
    }
}
