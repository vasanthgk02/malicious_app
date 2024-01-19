package com.facebook.react.devsupport;

import android.view.View;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.DefaultNativeModuleCallExceptionHandler;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.devsupport.interfaces.DevOptionHandler;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.devsupport.interfaces.PackagerStatusCallback;
import com.facebook.react.modules.debug.interfaces.DeveloperSettings;

public class DisabledDevSupportManager implements DevSupportManager {
    public final DefaultNativeModuleCallExceptionHandler mDefaultNativeModuleCallExceptionHandler = new DefaultNativeModuleCallExceptionHandler();

    public void addCustomDevOption(String str, DevOptionHandler devOptionHandler) {
    }

    public View createRootView(String str) {
        return null;
    }

    public void destroyRootView(View view) {
    }

    public DeveloperSettings getDevSettings() {
        return null;
    }

    public boolean getDevSupportEnabled() {
        return false;
    }

    public void handleException(Exception exc) {
        FLog.e((String) "DisabledDevSupportManager", (String) "Caught exception", (Throwable) exc);
        this.mDefaultNativeModuleCallExceptionHandler.handleException(exc);
    }

    public void handleReloadJS() {
    }

    public void hideRedboxDialog() {
    }

    public void isPackagerRunning(PackagerStatusCallback packagerStatusCallback) {
    }

    public void onNewReactContextCreated(ReactContext reactContext) {
    }

    public void onReactInstanceDestroyed(ReactContext reactContext) {
    }

    public void setDevSupportEnabled(boolean z) {
    }

    public void setFpsDebugEnabled(boolean z) {
    }

    public void setHotModuleReplacementEnabled(boolean z) {
    }

    public void setRemoteJSDebugEnabled(boolean z) {
    }

    public void showDevOptionsDialog() {
    }

    public void showNewJSError(String str, ReadableArray readableArray, int i) {
    }

    public void startInspector() {
    }

    public void stopInspector() {
    }

    public void toggleElementInspector() {
    }

    public void updateJSError(String str, ReadableArray readableArray, int i) {
    }
}
