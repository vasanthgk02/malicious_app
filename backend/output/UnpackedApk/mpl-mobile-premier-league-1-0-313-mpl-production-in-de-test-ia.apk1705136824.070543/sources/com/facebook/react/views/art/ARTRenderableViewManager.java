package com.facebook.react.views.art;

import android.view.View;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManager;

public class ARTRenderableViewManager extends ViewManager<View, ReactShadowNode> {
    public static final String CLASS_GROUP = "ARTGroup";
    public static final String CLASS_SHAPE = "ARTShape";
    public static final String CLASS_TEXT = "ARTText";
    public final String mClassName;

    public ARTRenderableViewManager(String str) {
        this.mClassName = str;
    }

    public static ARTRenderableViewManager createARTGroupViewManager() {
        return new ARTGroupViewManager();
    }

    public static ARTRenderableViewManager createARTShapeViewManager() {
        return new ARTShapeViewManager();
    }

    public static ARTRenderableViewManager createARTTextViewManager() {
        return new ARTTextViewManager();
    }

    public ReactShadowNode createShadowNodeInstance() {
        if ("ARTGroup".equals(this.mClassName)) {
            return new ARTGroupShadowNode();
        }
        if ("ARTShape".equals(this.mClassName)) {
            return new ARTShapeShadowNode();
        }
        if ("ARTText".equals(this.mClassName)) {
            return new ARTTextShadowNode();
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Unexpected type ");
        outline73.append(this.mClassName);
        throw new IllegalStateException(outline73.toString());
    }

    public View createViewInstance(ThemedReactContext themedReactContext) {
        throw new IllegalStateException("ARTShape does not map into a native view");
    }

    public String getName() {
        return this.mClassName;
    }

    public Class<? extends ReactShadowNode> getShadowNodeClass() {
        if ("ARTGroup".equals(this.mClassName)) {
            return ARTGroupShadowNode.class;
        }
        if ("ARTShape".equals(this.mClassName)) {
            return ARTShapeShadowNode.class;
        }
        if ("ARTText".equals(this.mClassName)) {
            return ARTTextShadowNode.class;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Unexpected type ");
        outline73.append(this.mClassName);
        throw new IllegalStateException(outline73.toString());
    }

    public void updateExtraData(View view, Object obj) {
        throw new IllegalStateException("ARTShape does not map into a native view");
    }
}
