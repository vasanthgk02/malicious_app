package com.facebook.react.views.view;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;
import java.util.Map;

@ReactModule(name = "RCTView")
public class ReactViewManager extends ReactClippingViewManager<ReactViewGroup> {
    public static final int CMD_HOTSPOT_UPDATE = 1;
    public static final int CMD_SET_PRESSED = 2;
    public static final String HOTSPOT_UPDATE_KEY = "hotspotUpdate";
    public static final String REACT_CLASS = "RCTView";
    public static final int[] SPACING_TYPES = {8, 0, 2, 1, 3, 4, 5};

    private void handleHotspotUpdate(ReactViewGroup reactViewGroup, ReadableArray readableArray) {
        if (readableArray == null || readableArray.size() != 2) {
            throw new JSApplicationIllegalArgumentException("Illegal number of arguments for 'updateHotspot' command");
        }
        reactViewGroup.drawableHotspotChanged(ImageOriginUtils.toPixelFromDIP(readableArray.getDouble(0)), ImageOriginUtils.toPixelFromDIP(readableArray.getDouble(1)));
    }

    private void handleSetPressed(ReactViewGroup reactViewGroup, ReadableArray readableArray) {
        if (readableArray == null || readableArray.size() != 1) {
            throw new JSApplicationIllegalArgumentException("Illegal number of arguments for 'setPressed' command");
        }
        reactViewGroup.setPressed(readableArray.getBoolean(0));
    }

    public Map<String, Integer> getCommandsMap() {
        return ImageOriginUtils.of(HOTSPOT_UPDATE_KEY, Integer.valueOf(1), "setPressed", Integer.valueOf(2));
    }

    public String getName() {
        return REACT_CLASS;
    }

    @ReactProp(defaultInt = -1, name = "nextFocusDown")
    public void nextFocusDown(ReactViewGroup reactViewGroup, int i) {
        reactViewGroup.setNextFocusDownId(i);
    }

    @ReactProp(defaultInt = -1, name = "nextFocusForward")
    public void nextFocusForward(ReactViewGroup reactViewGroup, int i) {
        reactViewGroup.setNextFocusForwardId(i);
    }

    @ReactProp(defaultInt = -1, name = "nextFocusLeft")
    public void nextFocusLeft(ReactViewGroup reactViewGroup, int i) {
        reactViewGroup.setNextFocusLeftId(i);
    }

    @ReactProp(defaultInt = -1, name = "nextFocusRight")
    public void nextFocusRight(ReactViewGroup reactViewGroup, int i) {
        reactViewGroup.setNextFocusRightId(i);
    }

    @ReactProp(defaultInt = -1, name = "nextFocusUp")
    public void nextFocusUp(ReactViewGroup reactViewGroup, int i) {
        reactViewGroup.setNextFocusUpId(i);
    }

    @ReactProp(name = "accessible")
    public void setAccessible(ReactViewGroup reactViewGroup, boolean z) {
        reactViewGroup.setFocusable(z);
    }

    @ReactProp(name = "backfaceVisibility")
    public void setBackfaceVisibility(ReactViewGroup reactViewGroup, String str) {
        reactViewGroup.setBackfaceVisibility(str);
    }

    @ReactPropGroup(customType = "Color", names = {"borderColor", "borderLeftColor", "borderRightColor", "borderTopColor", "borderBottomColor", "borderStartColor", "borderEndColor"})
    public void setBorderColor(ReactViewGroup reactViewGroup, int i, Integer num) {
        float f2 = Float.NaN;
        float intValue = num == null ? Float.NaN : (float) (num.intValue() & 16777215);
        if (num != null) {
            f2 = (float) (num.intValue() >>> 24);
        }
        reactViewGroup.setBorderColor(SPACING_TYPES[i], intValue, f2);
    }

    @ReactPropGroup(defaultFloat = Float.NaN, names = {"borderRadius", "borderTopLeftRadius", "borderTopRightRadius", "borderBottomRightRadius", "borderBottomLeftRadius", "borderTopStartRadius", "borderTopEndRadius", "borderBottomStartRadius", "borderBottomEndRadius"})
    public void setBorderRadius(ReactViewGroup reactViewGroup, int i, float f2) {
        if (!ImageOriginUtils.isUndefined(f2) && f2 < 0.0f) {
            f2 = Float.NaN;
        }
        if (!ImageOriginUtils.isUndefined(f2)) {
            f2 = ImageOriginUtils.toPixelFromDIP(f2);
        }
        if (i == 0) {
            reactViewGroup.setBorderRadius(f2);
        } else {
            reactViewGroup.setBorderRadius(f2, i - 1);
        }
    }

    @ReactProp(name = "borderStyle")
    public void setBorderStyle(ReactViewGroup reactViewGroup, String str) {
        reactViewGroup.setBorderStyle(str);
    }

    @ReactPropGroup(defaultFloat = Float.NaN, names = {"borderWidth", "borderLeftWidth", "borderRightWidth", "borderTopWidth", "borderBottomWidth", "borderStartWidth", "borderEndWidth"})
    public void setBorderWidth(ReactViewGroup reactViewGroup, int i, float f2) {
        if (!ImageOriginUtils.isUndefined(f2) && f2 < 0.0f) {
            f2 = Float.NaN;
        }
        if (!ImageOriginUtils.isUndefined(f2)) {
            f2 = ImageOriginUtils.toPixelFromDIP(f2);
        }
        reactViewGroup.setBorderWidth(SPACING_TYPES[i], f2);
    }

    @ReactProp(name = "collapsable")
    public void setCollapsable(ReactViewGroup reactViewGroup, boolean z) {
    }

    @ReactProp(name = "focusable")
    public void setFocusable(final ReactViewGroup reactViewGroup, boolean z) {
        if (z) {
            reactViewGroup.setOnClickListener(new OnClickListener(this) {
                public void onClick(View view) {
                    ((UIManagerModule) ((ReactContext) reactViewGroup.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(new ViewGroupClickEvent(reactViewGroup.getId()));
                }
            });
            reactViewGroup.setFocusable(true);
            return;
        }
        reactViewGroup.setOnClickListener(null);
        reactViewGroup.setClickable(false);
    }

    @ReactProp(name = "hitSlop")
    public void setHitSlop(ReactViewGroup reactViewGroup, ReadableMap readableMap) {
        if (readableMap == null) {
            reactViewGroup.setHitSlopRect(null);
            return;
        }
        int i = 0;
        int pixelFromDIP = readableMap.hasKey(RNGestureHandlerModule.KEY_HIT_SLOP_LEFT) ? (int) ImageOriginUtils.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_HIT_SLOP_LEFT)) : 0;
        int pixelFromDIP2 = readableMap.hasKey(RNGestureHandlerModule.KEY_HIT_SLOP_TOP) ? (int) ImageOriginUtils.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_HIT_SLOP_TOP)) : 0;
        int pixelFromDIP3 = readableMap.hasKey(RNGestureHandlerModule.KEY_HIT_SLOP_RIGHT) ? (int) ImageOriginUtils.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_HIT_SLOP_RIGHT)) : 0;
        if (readableMap.hasKey(RNGestureHandlerModule.KEY_HIT_SLOP_BOTTOM)) {
            i = (int) ImageOriginUtils.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_HIT_SLOP_BOTTOM));
        }
        reactViewGroup.setHitSlopRect(new Rect(pixelFromDIP, pixelFromDIP2, pixelFromDIP3, i));
    }

    @ReactProp(name = "nativeBackgroundAndroid")
    public void setNativeBackground(ReactViewGroup reactViewGroup, ReadableMap readableMap) {
        reactViewGroup.setTranslucentBackgroundDrawable(readableMap == null ? null : ReactDrawableHelper.createDrawableFromJSDescription(reactViewGroup.getContext(), readableMap));
    }

    @ReactProp(name = "nativeForegroundAndroid")
    @TargetApi(23)
    public void setNativeForeground(ReactViewGroup reactViewGroup, ReadableMap readableMap) {
        reactViewGroup.setForeground(readableMap == null ? null : ReactDrawableHelper.createDrawableFromJSDescription(reactViewGroup.getContext(), readableMap));
    }

    @ReactProp(name = "needsOffscreenAlphaCompositing")
    public void setNeedsOffscreenAlphaCompositing(ReactViewGroup reactViewGroup, boolean z) {
        reactViewGroup.setNeedsOffscreenAlphaCompositing(z);
    }

    @ReactProp(name = "overflow")
    public void setOverflow(ReactViewGroup reactViewGroup, String str) {
        reactViewGroup.setOverflow(str);
    }

    @ReactProp(name = "pointerEvents")
    public void setPointerEvents(ReactViewGroup reactViewGroup, String str) {
        if (str == null) {
            reactViewGroup.setPointerEvents(PointerEvents.AUTO);
        } else {
            reactViewGroup.setPointerEvents(PointerEvents.valueOf(str.toUpperCase(Locale.US).replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "_")));
        }
    }

    @ReactProp(name = "hasTVPreferredFocus")
    public void setTVPreferredFocus(ReactViewGroup reactViewGroup, boolean z) {
        if (z) {
            reactViewGroup.setFocusable(true);
            reactViewGroup.setFocusableInTouchMode(true);
            reactViewGroup.requestFocus();
        }
    }

    public ReactViewGroup createViewInstance(ThemedReactContext themedReactContext) {
        return new ReactViewGroup(themedReactContext);
    }

    public void setOpacity(ReactViewGroup reactViewGroup, float f2) {
        reactViewGroup.setOpacityIfPossible(f2);
    }

    public void setTransform(ReactViewGroup reactViewGroup, ReadableArray readableArray) {
        super.setTransform(reactViewGroup, readableArray);
        reactViewGroup.setBackfaceVisibilityDependantOpacity();
    }

    public void receiveCommand(ReactViewGroup reactViewGroup, int i, ReadableArray readableArray) {
        if (i == 1) {
            handleHotspotUpdate(reactViewGroup, readableArray);
        } else if (i == 2) {
            handleSetPressed(reactViewGroup, readableArray);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void receiveCommand(com.facebook.react.views.view.ReactViewGroup r4, java.lang.String r5, com.facebook.react.bridge.ReadableArray r6) {
        /*
            r3 = this;
            int r0 = r5.hashCode()
            r1 = -1639565984(0xffffffff9e463560, float:-1.04930704E-20)
            r2 = 1
            if (r0 == r1) goto L_0x001a
            r1 = -399823752(0xffffffffe82b2c78, float:-3.23338E24)
            if (r0 == r1) goto L_0x0010
            goto L_0x0024
        L_0x0010:
            java.lang.String r0 = "hotspotUpdate"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0024
            r5 = 0
            goto L_0x0025
        L_0x001a:
            java.lang.String r0 = "setPressed"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0024
            r5 = 1
            goto L_0x0025
        L_0x0024:
            r5 = -1
        L_0x0025:
            if (r5 == 0) goto L_0x002e
            if (r5 == r2) goto L_0x002a
            goto L_0x0031
        L_0x002a:
            r3.handleSetPressed(r4, r6)
            goto L_0x0031
        L_0x002e:
            r3.handleHotspotUpdate(r4, r6)
        L_0x0031:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.view.ReactViewManager.receiveCommand(com.facebook.react.views.view.ReactViewGroup, java.lang.String, com.facebook.react.bridge.ReadableArray):void");
    }
}
