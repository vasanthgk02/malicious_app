package com.swmansion.rnscreens;

import android.view.View;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001b2\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0014J\u001c\u0010\u0013\u001a\u00020\b2\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\t\u001a\u00020\nH\u0016J\u0014\u0010\u0014\u001a\u00020\n2\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0014\u0010\u0019\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016J\u001c\u0010\u001a\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u001c"}, d2 = {"Lcom/swmansion/rnscreens/ScreenContainerViewManager;", "Lcom/facebook/react/uimanager/ViewGroupManager;", "Lcom/swmansion/rnscreens/ScreenContainer;", "()V", "addView", "", "parent", "child", "Landroid/view/View;", "index", "", "createShadowNodeInstance", "Lcom/facebook/react/uimanager/LayoutShadowNode;", "context", "Lcom/facebook/react/bridge/ReactApplicationContext;", "createViewInstance", "Lcom/swmansion/rnscreens/ScreenFragment;", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "getChildAt", "getChildCount", "getName", "", "needsCustomLayoutForChildren", "", "removeAllViews", "removeViewAt", "Companion", "react-native-screens_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@ReactModule(name = "RNSScreenContainer")
/* compiled from: ScreenContainerViewManager.kt */
public final class ScreenContainerViewManager extends ViewGroupManager<ScreenContainer<?>> {
    public static final Companion Companion = new Companion(null);
    public static final String REACT_CLASS = "RNSScreenContainer";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/swmansion/rnscreens/ScreenContainerViewManager$Companion;", "", "()V", "REACT_CLASS", "", "react-native-screens_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ScreenContainerViewManager.kt */
    public static final class Companion {
        public Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public String getName() {
        return REACT_CLASS;
    }

    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    public void addView(ScreenContainer<?> screenContainer, View view, int i) {
        Intrinsics.checkNotNullParameter(screenContainer, "parent");
        Intrinsics.checkNotNullParameter(view, "child");
        if (view instanceof Screen) {
            Screen screen = (Screen) view;
            Intrinsics.checkNotNullParameter(screen, "screen");
            ScreenFragment adapt = screenContainer.adapt(screen);
            screen.setFragment(adapt);
            screenContainer.mScreenFragments.add(i, adapt);
            screen.setContainer(screenContainer);
            screenContainer.onScreenChanged();
            return;
        }
        throw new IllegalArgumentException("Attempt attach child that is not of type RNScreens".toString());
    }

    public LayoutShadowNode createShadowNodeInstance(ReactApplicationContext reactApplicationContext) {
        Intrinsics.checkNotNullParameter(reactApplicationContext, "context");
        return new ScreensShadowNode(reactApplicationContext);
    }

    public ScreenContainer<ScreenFragment> createViewInstance(ThemedReactContext themedReactContext) {
        Intrinsics.checkNotNullParameter(themedReactContext, "reactContext");
        return new ScreenContainer<>(themedReactContext);
    }

    public View getChildAt(ScreenContainer<?> screenContainer, int i) {
        Intrinsics.checkNotNullParameter(screenContainer, "parent");
        return ((ScreenFragment) screenContainer.mScreenFragments.get(i)).getScreen();
    }

    public int getChildCount(ScreenContainer<?> screenContainer) {
        Intrinsics.checkNotNullParameter(screenContainer, "parent");
        return screenContainer.getScreenCount();
    }

    public void removeAllViews(ScreenContainer<?> screenContainer) {
        Intrinsics.checkNotNullParameter(screenContainer, "parent");
        screenContainer.removeAllScreens();
    }

    public void removeViewAt(ScreenContainer<?> screenContainer, int i) {
        Intrinsics.checkNotNullParameter(screenContainer, "parent");
        screenContainer.removeScreenAt(i);
    }
}
