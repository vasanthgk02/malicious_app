package com.reactnativecommunity.art;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ARTPackage implements ReactPackage {
    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        return Collections.emptyList();
    }

    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Arrays.asList(new ViewManager[]{ARTRenderableViewManager.createARTGroupViewManager(), ARTRenderableViewManager.createARTShapeViewManager(), ARTRenderableViewManager.createARTTextViewManager(), new ARTSurfaceViewManager()});
    }
}
