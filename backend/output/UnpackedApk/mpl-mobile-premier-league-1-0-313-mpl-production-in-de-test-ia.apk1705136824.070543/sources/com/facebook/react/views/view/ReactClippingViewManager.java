package com.facebook.react.views.view;

import android.view.View;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.view.ReactViewGroup;

public abstract class ReactClippingViewManager<T extends ReactViewGroup> extends ViewGroupManager<T> {
    @ReactProp(name = "removeClippedSubviews")
    public void setRemoveClippedSubviews(T t, boolean z) {
        UiThreadUtil.assertOnUiThread();
        t.setRemoveClippedSubviews(z);
    }

    public void addView(T t, View view, int i) {
        UiThreadUtil.assertOnUiThread();
        if (t.getRemoveClippedSubviews()) {
            t.addViewWithSubviewClippingEnabled1(view, i);
        } else {
            t.addView(view, i);
        }
    }

    public View getChildAt(T t, int i) {
        if (!t.getRemoveClippedSubviews()) {
            return t.getChildAt(i);
        }
        View[] viewArr = t.mAllChildren;
        ImageOriginUtils.assertNotNull(viewArr);
        return viewArr[i];
    }

    public int getChildCount(T t) {
        if (t.getRemoveClippedSubviews()) {
            return t.getAllChildrenCount();
        }
        return t.getChildCount();
    }

    public void removeAllViews(T t) {
        UiThreadUtil.assertOnUiThread();
        if (t.getRemoveClippedSubviews()) {
            ImageOriginUtils.assertCondition(t.mRemoveClippedSubviews);
            ImageOriginUtils.assertNotNull(t.mAllChildren);
            for (int i = 0; i < t.mAllChildrenCount; i++) {
                t.mAllChildren[i].removeOnLayoutChangeListener(t.mChildrenLayoutChangeListener);
            }
            t.removeAllViewsInLayout();
            t.mAllChildrenCount = 0;
            return;
        }
        t.removeAllViews();
    }

    public void removeViewAt(T t, int i) {
        UiThreadUtil.assertOnUiThread();
        if (t.getRemoveClippedSubviews()) {
            View childAt = getChildAt(t, i);
            if (childAt.getParent() != null) {
                t.removeView(childAt);
            }
            t.removeViewWithSubviewClippingEnabled(childAt);
            return;
        }
        t.removeViewAt(i);
    }
}
