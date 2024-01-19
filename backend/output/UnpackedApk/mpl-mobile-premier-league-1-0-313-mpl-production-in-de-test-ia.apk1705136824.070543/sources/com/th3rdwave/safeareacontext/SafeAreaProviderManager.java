package com.th3rdwave.safeareacontext;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.common.MapBuilder$Builder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.google.android.material.resources.TextAppearanceConfig;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;
import com.th3rdwave.safeareacontext.SafeAreaProvider.OnInsetsChangeListener;
import java.util.Map;

public class SafeAreaProviderManager extends ViewGroupManager<SafeAreaProvider> {
    public final ReactApplicationContext mContext;

    public SafeAreaProviderManager(ReactApplicationContext reactApplicationContext) {
        this.mContext = reactApplicationContext;
    }

    private Map<String, Object> getInitialWindowMetrics() {
        Activity currentActivity = this.mContext.getCurrentActivity();
        if (currentActivity == null) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) currentActivity.getWindow().getDecorView();
        if (viewGroup == null) {
            return null;
        }
        View findViewById = viewGroup.findViewById(16908290);
        if (findViewById == null) {
            return null;
        }
        EdgeInsets safeAreaInsets = TextAppearanceConfig.getSafeAreaInsets(viewGroup);
        Rect frame = TextAppearanceConfig.getFrame(viewGroup, findViewById);
        if (safeAreaInsets == null || frame == null) {
            return null;
        }
        return ImageOriginUtils.of("insets", ImageOriginUtils.of(RNGestureHandlerModule.KEY_HIT_SLOP_TOP, Float.valueOf(ImageOriginUtils.toDIPFromPixel(safeAreaInsets.top)), RNGestureHandlerModule.KEY_HIT_SLOP_RIGHT, Float.valueOf(ImageOriginUtils.toDIPFromPixel(safeAreaInsets.right)), RNGestureHandlerModule.KEY_HIT_SLOP_BOTTOM, Float.valueOf(ImageOriginUtils.toDIPFromPixel(safeAreaInsets.bottom)), RNGestureHandlerModule.KEY_HIT_SLOP_LEFT, Float.valueOf(ImageOriginUtils.toDIPFromPixel(safeAreaInsets.left))), "frame", ImageOriginUtils.of("x", Float.valueOf(ImageOriginUtils.toDIPFromPixel(frame.x)), "y", Float.valueOf(ImageOriginUtils.toDIPFromPixel(frame.y)), "width", Float.valueOf(ImageOriginUtils.toDIPFromPixel(frame.width)), "height", Float.valueOf(ImageOriginUtils.toDIPFromPixel(frame.height))));
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        MapBuilder$Builder builder = ImageOriginUtils.builder();
        builder.put("topInsetsChange", ImageOriginUtils.of("registrationName", "onInsetsChange"));
        return builder.build();
    }

    public Map<String, Object> getExportedViewConstants() {
        return ImageOriginUtils.of("initialWindowMetrics", getInitialWindowMetrics());
    }

    public String getName() {
        return "RNCSafeAreaProvider";
    }

    public void addEventEmitters(ThemedReactContext themedReactContext, SafeAreaProvider safeAreaProvider) {
        final EventDispatcher eventDispatcher = ((UIManagerModule) themedReactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher();
        safeAreaProvider.setOnInsetsChangeListener(new OnInsetsChangeListener(this) {
            public void onInsetsChange(SafeAreaProvider safeAreaProvider, EdgeInsets edgeInsets, Rect rect) {
                eventDispatcher.dispatchEvent(new InsetsChangeEvent(safeAreaProvider.getId(), edgeInsets, rect));
            }
        });
    }

    public SafeAreaProvider createViewInstance(ThemedReactContext themedReactContext) {
        return new SafeAreaProvider(themedReactContext);
    }
}
