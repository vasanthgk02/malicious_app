package com.facebook.react.uimanager;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.uimanager.UIManagerModule.ViewManagerResolver;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ViewManagerRegistry {
    public final ViewManagerResolver mViewManagerResolver;
    public final Map<String, ViewManager> mViewManagers;

    public ViewManagerRegistry(ViewManagerResolver viewManagerResolver) {
        this.mViewManagers = new HashMap();
        this.mViewManagerResolver = viewManagerResolver;
    }

    public ViewManager get(String str) {
        ViewManager viewManager = this.mViewManagers.get(str);
        if (viewManager != null) {
            return viewManager;
        }
        ViewManagerResolver viewManagerResolver = this.mViewManagerResolver;
        if (viewManagerResolver != null) {
            ViewManager viewManager2 = viewManagerResolver.getViewManager(str);
            if (viewManager2 != null) {
                this.mViewManagers.put(str, viewManager2);
            }
            if (viewManager2 != null) {
                return viewManager2;
            }
            throw new IllegalViewOperationException(GeneratedOutlineSupport.outline50("ViewManagerResolver returned null for ", str));
        }
        throw new IllegalViewOperationException(GeneratedOutlineSupport.outline50("No ViewManager found for class ", str));
    }

    public ViewManagerRegistry(List<ViewManager> list) {
        HashMap hashMap = new HashMap();
        for (ViewManager next : list) {
            hashMap.put(next.getName(), next);
        }
        this.mViewManagers = hashMap;
        this.mViewManagerResolver = null;
    }
}
