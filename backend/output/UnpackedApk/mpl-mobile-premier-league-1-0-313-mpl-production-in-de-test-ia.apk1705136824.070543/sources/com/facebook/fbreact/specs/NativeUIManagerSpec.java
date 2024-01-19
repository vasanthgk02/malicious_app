package com.facebook.fbreact.specs;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReactModuleWithSpec;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import java.util.Map;

public abstract class NativeUIManagerSpec extends ReactContextBaseJavaModule implements ReactModuleWithSpec, TurboModule {
    public NativeUIManagerSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public abstract void blur(Double d2);

    @ReactMethod
    public abstract void clearJSResponder();

    @ReactMethod
    public abstract void configureNextLayoutAnimation(ReadableMap readableMap, Callback callback, Callback callback2);

    @ReactMethod
    public abstract void createView(Double d2, String str, double d3, ReadableMap readableMap);

    @ReactMethod
    public abstract void dismissPopupMenu();

    @ReactMethod
    public abstract void dispatchViewManagerCommand(Double d2, double d3, ReadableArray readableArray);

    @ReactMethod
    public abstract void findSubviewIn(Double d2, ReadableArray readableArray, Callback callback);

    @ReactMethod
    public abstract void focus(Double d2);

    public final Map<String, Object> getConstants() {
        return getTypedExportedConstants();
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public abstract WritableMap getConstantsForViewManager(String str);

    @ReactMethod(isBlockingSynchronousMethod = true)
    public abstract WritableArray getDefaultEventTypes();

    public abstract Map<String, Object> getTypedExportedConstants();

    @ReactMethod(isBlockingSynchronousMethod = true)
    public abstract WritableMap lazilyLoadView(String str);

    @ReactMethod
    public abstract void manageChildren(Double d2, ReadableArray readableArray, ReadableArray readableArray2, ReadableArray readableArray3, ReadableArray readableArray4, ReadableArray readableArray5);

    @ReactMethod
    public abstract void measure(Double d2, Callback callback);

    @ReactMethod
    public abstract void measureInWindow(Double d2, Callback callback);

    @ReactMethod
    public abstract void measureLayout(Double d2, Double d3, Callback callback, Callback callback2);

    @ReactMethod
    public abstract void measureLayoutRelativeToParent(Double d2, Callback callback, Callback callback2);

    @ReactMethod
    public abstract void playTouchSound();

    @ReactMethod
    public abstract void removeSubviewsFromContainerWithID(double d2);

    @ReactMethod
    public abstract void replaceExistingNonRootView(Double d2, Double d3);

    @ReactMethod
    public abstract void sendAccessibilityEvent(Double d2, double d3);

    @ReactMethod
    public abstract void setChildren(Double d2, ReadableArray readableArray);

    @ReactMethod
    public abstract void setJSResponder(Double d2, boolean z);

    @ReactMethod
    public abstract void setLayoutAnimationEnabledExperimental(boolean z);

    @ReactMethod
    public abstract void showPopupMenu(Double d2, ReadableArray readableArray, Callback callback, Callback callback2);

    @ReactMethod
    public abstract void updateView(double d2, String str, ReadableMap readableMap);

    @ReactMethod
    public abstract void viewIsDescendantOf(Double d2, Double d3, Callback callback);
}
