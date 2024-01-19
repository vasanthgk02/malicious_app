package com.facebook.react.views.drawer;

import android.view.View;
import androidx.core.app.NotificationCompat.WearableExtender;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.drawerlayout.widget.DrawerLayout.DrawerListener;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.viewmanagers.AndroidDrawerLayoutManagerDelegate;
import com.facebook.react.views.drawer.events.DrawerClosedEvent;
import com.facebook.react.views.drawer.events.DrawerOpenedEvent;
import com.facebook.react.views.drawer.events.DrawerSlideEvent;
import com.facebook.react.views.drawer.events.DrawerStateChangedEvent;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;
import java.util.ArrayList;
import java.util.Map;

@ReactModule(name = "AndroidDrawerLayout")
public class ReactDrawerLayoutManager extends ViewGroupManager<ReactDrawerLayout> {
    public static final int CLOSE_DRAWER = 2;
    public static final int OPEN_DRAWER = 1;
    public static final String REACT_CLASS = "AndroidDrawerLayout";
    public final ViewManagerDelegate<ReactDrawerLayout> mDelegate = new AndroidDrawerLayoutManagerDelegate(this);

    public static class DrawerEventEmitter implements DrawerListener {
        public final DrawerLayout mDrawerLayout;
        public final EventDispatcher mEventDispatcher;

        public DrawerEventEmitter(DrawerLayout drawerLayout, EventDispatcher eventDispatcher) {
            this.mDrawerLayout = drawerLayout;
            this.mEventDispatcher = eventDispatcher;
        }

        public void onDrawerClosed(View view) {
            this.mEventDispatcher.dispatchEvent(new DrawerClosedEvent(this.mDrawerLayout.getId()));
        }

        public void onDrawerOpened(View view) {
            this.mEventDispatcher.dispatchEvent(new DrawerOpenedEvent(this.mDrawerLayout.getId()));
        }

        public void onDrawerSlide(View view, float f2) {
            this.mEventDispatcher.dispatchEvent(new DrawerSlideEvent(this.mDrawerLayout.getId(), f2));
        }

        public void onDrawerStateChanged(int i) {
            this.mEventDispatcher.dispatchEvent(new DrawerStateChangedEvent(this.mDrawerLayout.getId(), i));
        }
    }

    private void setDrawerPositionInternal(ReactDrawerLayout reactDrawerLayout, String str) {
        if (str.equals(RNGestureHandlerModule.KEY_HIT_SLOP_LEFT)) {
            reactDrawerLayout.mDrawerPosition = 8388611;
            reactDrawerLayout.setDrawerProperties();
        } else if (str.equals(RNGestureHandlerModule.KEY_HIT_SLOP_RIGHT)) {
            reactDrawerLayout.mDrawerPosition = WearableExtender.DEFAULT_CONTENT_ICON_GRAVITY;
            reactDrawerLayout.setDrawerProperties();
        } else {
            throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline50("drawerPosition must be 'left' or 'right', received", str));
        }
    }

    public Map<String, Integer> getCommandsMap() {
        return ImageOriginUtils.of("openDrawer", Integer.valueOf(1), "closeDrawer", Integer.valueOf(2));
    }

    public ViewManagerDelegate<ReactDrawerLayout> getDelegate() {
        return this.mDelegate;
    }

    public Map getExportedCustomDirectEventTypeConstants() {
        return ImageOriginUtils.of("topDrawerSlide", ImageOriginUtils.of("registrationName", "onDrawerSlide"), "topDrawerOpen", ImageOriginUtils.of("registrationName", "onDrawerOpen"), "topDrawerClose", ImageOriginUtils.of("registrationName", "onDrawerClose"), "topDrawerStateChanged", ImageOriginUtils.of("registrationName", "onDrawerStateChanged"));
    }

    public Map getExportedViewConstants() {
        return ImageOriginUtils.of("DrawerPosition", ImageOriginUtils.of("Left", Integer.valueOf(8388611), "Right", Integer.valueOf(WearableExtender.DEFAULT_CONTENT_ICON_GRAVITY)));
    }

    public String getName() {
        return REACT_CLASS;
    }

    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    public void setDrawerBackgroundColor(ReactDrawerLayout reactDrawerLayout, Integer num) {
    }

    public void setKeyboardDismissMode(ReactDrawerLayout reactDrawerLayout, String str) {
    }

    public void setStatusBarBackgroundColor(ReactDrawerLayout reactDrawerLayout, Integer num) {
    }

    public void addEventEmitters(ThemedReactContext themedReactContext, ReactDrawerLayout reactDrawerLayout) {
        DrawerEventEmitter drawerEventEmitter = new DrawerEventEmitter(reactDrawerLayout, ((UIManagerModule) themedReactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher());
        if (reactDrawerLayout != null) {
            if (reactDrawerLayout.mListeners == null) {
                reactDrawerLayout.mListeners = new ArrayList();
            }
            reactDrawerLayout.mListeners.add(drawerEventEmitter);
            return;
        }
        throw null;
    }

    public void addView(ReactDrawerLayout reactDrawerLayout, View view, int i) {
        if (getChildCount(reactDrawerLayout) >= 2) {
            throw new JSApplicationIllegalArgumentException("The Drawer cannot have more than two children");
        } else if (i == 0 || i == 1) {
            reactDrawerLayout.addView(view, i);
            reactDrawerLayout.setDrawerProperties();
        } else {
            throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline42("The only valid indices for drawer's child are 0 or 1. Got ", i, " instead."));
        }
    }

    public void closeDrawer(ReactDrawerLayout reactDrawerLayout) {
        reactDrawerLayout.closeDrawer(reactDrawerLayout.mDrawerPosition);
    }

    public ReactDrawerLayout createViewInstance(ThemedReactContext themedReactContext) {
        return new ReactDrawerLayout(themedReactContext);
    }

    public void openDrawer(ReactDrawerLayout reactDrawerLayout) {
        reactDrawerLayout.openDrawer(reactDrawerLayout.mDrawerPosition);
    }

    @ReactProp(name = "drawerLockMode")
    public void setDrawerLockMode(ReactDrawerLayout reactDrawerLayout, String str) {
        if (str == null || "unlocked".equals(str)) {
            reactDrawerLayout.setDrawerLockMode(0);
        } else if ("locked-closed".equals(str)) {
            reactDrawerLayout.setDrawerLockMode(1);
        } else if ("locked-open".equals(str)) {
            reactDrawerLayout.setDrawerLockMode(2);
        } else {
            throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline50("Unknown drawerLockMode ", str));
        }
    }

    public void setDrawerPosition(ReactDrawerLayout reactDrawerLayout, String str) {
        if (str == null) {
            reactDrawerLayout.mDrawerPosition = 8388611;
            reactDrawerLayout.setDrawerProperties();
            return;
        }
        setDrawerPositionInternal(reactDrawerLayout, str);
    }

    @ReactProp(defaultFloat = Float.NaN, name = "drawerWidth")
    public void setDrawerWidth(ReactDrawerLayout reactDrawerLayout, float f2) {
        int i;
        if (Float.isNaN(f2)) {
            i = -1;
        } else {
            i = Math.round(ImageOriginUtils.toPixelFromDIP(f2));
        }
        reactDrawerLayout.mDrawerWidth = i;
        reactDrawerLayout.setDrawerProperties();
    }

    public void setElevation(ReactDrawerLayout reactDrawerLayout, float f2) {
        reactDrawerLayout.setDrawerElevation(ImageOriginUtils.toPixelFromDIP(f2));
    }

    public void receiveCommand(ReactDrawerLayout reactDrawerLayout, int i, ReadableArray readableArray) {
        if (i == 1) {
            reactDrawerLayout.openDrawer(reactDrawerLayout.mDrawerPosition);
        } else if (i == 2) {
            reactDrawerLayout.closeDrawer(reactDrawerLayout.mDrawerPosition);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0030  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void receiveCommand(com.facebook.react.views.drawer.ReactDrawerLayout r3, java.lang.String r4, com.facebook.react.bridge.ReadableArray r5) {
        /*
            r2 = this;
            int r5 = r4.hashCode()
            r0 = -258774775(0xfffffffff0936909, float:-3.649702E29)
            r1 = 1
            if (r5 == r0) goto L_0x001a
            r0 = -83186725(0xfffffffffb0aabdb, float:-7.200226E35)
            if (r5 == r0) goto L_0x0010
            goto L_0x0024
        L_0x0010:
            java.lang.String r5 = "openDrawer"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0024
            r4 = 0
            goto L_0x0025
        L_0x001a:
            java.lang.String r5 = "closeDrawer"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0024
            r4 = 1
            goto L_0x0025
        L_0x0024:
            r4 = -1
        L_0x0025:
            if (r4 == 0) goto L_0x0030
            if (r4 == r1) goto L_0x002a
            goto L_0x0035
        L_0x002a:
            int r4 = r3.mDrawerPosition
            r3.closeDrawer(r4)
            goto L_0x0035
        L_0x0030:
            int r4 = r3.mDrawerPosition
            r3.openDrawer(r4)
        L_0x0035:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.drawer.ReactDrawerLayoutManager.receiveCommand(com.facebook.react.views.drawer.ReactDrawerLayout, java.lang.String, com.facebook.react.bridge.ReadableArray):void");
    }

    @ReactProp(name = "drawerPosition")
    public void setDrawerPosition(ReactDrawerLayout reactDrawerLayout, Dynamic dynamic) {
        if (dynamic.isNull()) {
            reactDrawerLayout.mDrawerPosition = 8388611;
            reactDrawerLayout.setDrawerProperties();
        } else if (dynamic.getType() == ReadableType.Number) {
            int asInt = dynamic.asInt();
            if (8388611 == asInt || 8388613 == asInt) {
                reactDrawerLayout.mDrawerPosition = asInt;
                reactDrawerLayout.setDrawerProperties();
                return;
            }
            throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline41("Unknown drawerPosition ", asInt));
        } else if (dynamic.getType() == ReadableType.String) {
            setDrawerPositionInternal(reactDrawerLayout, dynamic.asString());
        } else {
            throw new JSApplicationIllegalArgumentException("drawerPosition must be a string or int");
        }
    }

    public void setDrawerWidth(ReactDrawerLayout reactDrawerLayout, Float f2) {
        reactDrawerLayout.mDrawerWidth = f2 == null ? -1 : Math.round(ImageOriginUtils.toPixelFromDIP(f2.floatValue()));
        reactDrawerLayout.setDrawerProperties();
    }
}
