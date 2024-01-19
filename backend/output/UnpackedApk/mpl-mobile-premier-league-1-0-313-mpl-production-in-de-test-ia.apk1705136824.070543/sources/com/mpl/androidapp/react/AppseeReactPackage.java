package com.mpl.androidapp.react;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ViewManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AppseeReactPackage implements ReactPackage {

    public class AppseeModule extends ReactContextBaseJavaModule {
        public AppseeModule(ReactApplicationContext reactApplicationContext) {
            super(reactApplicationContext);
        }

        @ReactMethod
        public void addEvent(String str, ReadableMap readableMap) {
        }

        @ReactMethod
        public void addScreenAction(String str) {
        }

        @ReactMethod
        public void deleteCurrentUserData() {
        }

        @ReactMethod
        public void finishSession(boolean z, boolean z2) {
        }

        @ReactMethod
        public void forceNewSession() {
        }

        @ReactMethod
        public void generate3rdPartyID(String str, boolean z) {
        }

        public String getName() {
            return "Appsee";
        }

        @ReactMethod
        public void markViewAsSensitive(int i) {
        }

        @ReactMethod
        public void pause() {
        }

        @ReactMethod
        public void resume() {
        }

        @ReactMethod
        public void set3rdPartyID(String str, String str2, boolean z) {
        }

        @ReactMethod
        public void setDebug(boolean z) {
        }

        @ReactMethod
        public void setLocation(double d2, double d3, float f2, float f3) {
        }

        @ReactMethod
        public void setLocationDescription(String str) {
        }

        @ReactMethod
        public void setOptOutStatus(boolean z) {
        }

        @ReactMethod
        public void setUserId(String str) {
        }

        @ReactMethod
        public void start() {
        }

        @ReactMethod
        public void startScreen(String str) {
        }

        @ReactMethod
        public void stop() {
        }

        @ReactMethod
        public void unmarkViewAsSensitive(int i) {
        }

        @ReactMethod
        public void upload() {
        }
    }

    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return Collections.emptyList();
    }

    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new AppseeModule(reactApplicationContext));
        return arrayList;
    }

    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Collections.emptyList();
    }
}
