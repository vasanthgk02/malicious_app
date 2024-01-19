package com.th3rdwave.safeareacontext;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.view.ReactViewManager;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;
import java.util.EnumSet;

public class SafeAreaViewManager extends ReactViewManager {
    public String getName() {
        return "RNCSafeAreaView";
    }

    public Class<? extends LayoutShadowNode> getShadowNodeClass() {
        return SafeAreaViewShadowNode.class;
    }

    @ReactProp(name = "edges")
    public void setEdges(SafeAreaView safeAreaView, ReadableArray readableArray) {
        EnumSet<E> noneOf = EnumSet.noneOf(SafeAreaViewEdges.class);
        if (readableArray != null) {
            for (int i = 0; i < readableArray.size(); i++) {
                String string = readableArray.getString(i);
                if (RNGestureHandlerModule.KEY_HIT_SLOP_TOP.equals(string)) {
                    noneOf.add(SafeAreaViewEdges.TOP);
                } else if (RNGestureHandlerModule.KEY_HIT_SLOP_RIGHT.equals(string)) {
                    noneOf.add(SafeAreaViewEdges.RIGHT);
                } else if (RNGestureHandlerModule.KEY_HIT_SLOP_BOTTOM.equals(string)) {
                    noneOf.add(SafeAreaViewEdges.BOTTOM);
                } else if (RNGestureHandlerModule.KEY_HIT_SLOP_LEFT.equals(string)) {
                    noneOf.add(SafeAreaViewEdges.LEFT);
                }
            }
        }
        safeAreaView.setEdges(noneOf);
    }

    @ReactProp(name = "mode")
    public void setMode(SafeAreaView safeAreaView, String str) {
        if ("padding".equals(str)) {
            safeAreaView.setMode(SafeAreaViewMode.PADDING);
        } else if ("margin".equals(str)) {
            safeAreaView.setMode(SafeAreaViewMode.MARGIN);
        }
    }

    public SafeAreaViewShadowNode createShadowNodeInstance() {
        return new SafeAreaViewShadowNode();
    }

    public SafeAreaView createViewInstance(ThemedReactContext themedReactContext) {
        return new SafeAreaView(themedReactContext);
    }
}
