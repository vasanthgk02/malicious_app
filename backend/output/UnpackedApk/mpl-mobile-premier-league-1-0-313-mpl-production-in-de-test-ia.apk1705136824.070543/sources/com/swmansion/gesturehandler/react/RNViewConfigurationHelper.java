package com.swmansion.gesturehandler.react;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ReactPointerEventsView;
import com.facebook.react.views.view.ReactViewGroup;
import com.swmansion.gesturehandler.core.PointerEventsConfig;
import com.swmansion.gesturehandler.core.ViewConfigurationHelper;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016¨\u0006\u000e"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNViewConfigurationHelper;", "Lcom/swmansion/gesturehandler/core/ViewConfigurationHelper;", "()V", "getChildInDrawingOrderAtIndex", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "index", "", "getPointerEventsConfigForView", "Lcom/swmansion/gesturehandler/core/PointerEventsConfig;", "view", "isViewClippingChildren", "", "react-native-gesture-handler_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RNViewConfigurationHelper.kt */
public final class RNViewConfigurationHelper implements ViewConfigurationHelper {
    public View getChildInDrawingOrderAtIndex(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (viewGroup instanceof ReactViewGroup) {
            ReactViewGroup reactViewGroup = (ReactViewGroup) viewGroup;
            if (reactViewGroup.mDrawingOrderHelper.shouldEnableCustomDrawingOrder()) {
                i = reactViewGroup.mDrawingOrderHelper.getChildDrawingOrder(reactViewGroup.getChildCount(), i);
            }
            View childAt = viewGroup.getChildAt(i);
            Intrinsics.checkNotNullExpressionValue(childAt, "{\n      parent.getChildA…dChildIndex(index))\n    }");
            return childAt;
        }
        View childAt2 = viewGroup.getChildAt(i);
        Intrinsics.checkNotNullExpressionValue(childAt2, "parent.getChildAt(index)");
        return childAt2;
    }

    public PointerEventsConfig getPointerEventsConfigForView(View view) {
        PointerEvents pointerEvents;
        PointerEventsConfig pointerEventsConfig;
        Intrinsics.checkNotNullParameter(view, "view");
        if (view instanceof ReactPointerEventsView) {
            pointerEvents = ((ReactPointerEventsView) view).getPointerEvents();
            Intrinsics.checkNotNullExpressionValue(pointerEvents, "{\n        (view as React…ew).pointerEvents\n      }");
        } else {
            pointerEvents = PointerEvents.AUTO;
        }
        if (!view.isEnabled()) {
            if (pointerEvents == PointerEvents.AUTO) {
                return PointerEventsConfig.BOX_NONE;
            }
            if (pointerEvents == PointerEvents.BOX_ONLY) {
                return PointerEventsConfig.NONE;
            }
        }
        int ordinal = pointerEvents.ordinal();
        if (ordinal == 0) {
            pointerEventsConfig = PointerEventsConfig.NONE;
        } else if (ordinal == 1) {
            pointerEventsConfig = PointerEventsConfig.BOX_NONE;
        } else if (ordinal == 2) {
            pointerEventsConfig = PointerEventsConfig.BOX_ONLY;
        } else if (ordinal == 3) {
            pointerEventsConfig = PointerEventsConfig.AUTO;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return pointerEventsConfig;
    }

    public boolean isViewClippingChildren(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "view");
        if (viewGroup.getClipChildren()) {
            return true;
        }
        return viewGroup instanceof ReactViewGroup ? Intrinsics.areEqual("hidden", ((ReactViewGroup) viewGroup).getOverflow()) : false;
    }
}
