package com.facebook.react.views.viewpager;

import android.view.View;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.AndroidViewPagerManagerDelegate;
import com.facebook.react.views.viewpager.ReactViewPager.Adapter;
import java.util.Map;

@ReactModule(name = "AndroidViewPager")
public class ReactViewPagerManager extends ViewGroupManager<ReactViewPager> {
    public static final int COMMAND_SET_PAGE = 1;
    public static final int COMMAND_SET_PAGE_WITHOUT_ANIMATION = 2;
    public static final String REACT_CLASS = "AndroidViewPager";
    public final ViewManagerDelegate<ReactViewPager> mDelegate = new AndroidViewPagerManagerDelegate(this);

    public Map<String, Integer> getCommandsMap() {
        return ImageOriginUtils.of("setPage", Integer.valueOf(1), "setPageWithoutAnimation", Integer.valueOf(2));
    }

    public ViewManagerDelegate<ReactViewPager> getDelegate() {
        return this.mDelegate;
    }

    public Map getExportedCustomDirectEventTypeConstants() {
        return ImageOriginUtils.of("topPageScroll", ImageOriginUtils.of("registrationName", "onPageScroll"), "topPageScrollStateChanged", ImageOriginUtils.of("registrationName", "onPageScrollStateChanged"), "topPageSelected", ImageOriginUtils.of("registrationName", "onPageSelected"));
    }

    public String getName() {
        return REACT_CLASS;
    }

    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    public void setInitialPage(ReactViewPager reactViewPager, int i) {
    }

    public void setKeyboardDismissMode(ReactViewPager reactViewPager, String str) {
    }

    public void setPage(ReactViewPager reactViewPager, int i) {
    }

    public void setPageWithoutAnimation(ReactViewPager reactViewPager, int i) {
    }

    public void addView(ReactViewPager reactViewPager, View view, int i) {
        Adapter adapter = reactViewPager.getAdapter();
        adapter.mViews.add(i, view);
        adapter.notifyDataSetChanged();
        ReactViewPager.this.setOffscreenPageLimit(adapter.mViews.size());
    }

    public ReactViewPager createViewInstance(ThemedReactContext themedReactContext) {
        return new ReactViewPager(themedReactContext);
    }

    public View getChildAt(ReactViewPager reactViewPager, int i) {
        return reactViewPager.getAdapter().mViews.get(i);
    }

    public int getChildCount(ReactViewPager reactViewPager) {
        return reactViewPager.getViewCountInAdapter();
    }

    public void removeViewAt(ReactViewPager reactViewPager, int i) {
        Adapter adapter = reactViewPager.getAdapter();
        adapter.mViews.remove(i);
        adapter.notifyDataSetChanged();
        ReactViewPager.this.setOffscreenPageLimit(adapter.mViews.size());
    }

    @ReactProp(defaultInt = 0, name = "pageMargin")
    public void setPageMargin(ReactViewPager reactViewPager, int i) {
        reactViewPager.setPageMargin((int) ImageOriginUtils.toPixelFromDIP((float) i));
    }

    @ReactProp(defaultBoolean = false, name = "peekEnabled")
    public void setPeekEnabled(ReactViewPager reactViewPager, boolean z) {
        reactViewPager.setClipToPadding(!z);
    }

    @ReactProp(defaultBoolean = true, name = "scrollEnabled")
    public void setScrollEnabled(ReactViewPager reactViewPager, boolean z) {
        reactViewPager.setScrollEnabled(z);
    }

    public void receiveCommand(ReactViewPager reactViewPager, int i, ReadableArray readableArray) {
        ImageOriginUtils.assertNotNull(reactViewPager);
        ImageOriginUtils.assertNotNull(readableArray);
        if (i == 1) {
            reactViewPager.setCurrentItemFromJs(readableArray.getInt(0), true);
        } else if (i == 2) {
            reactViewPager.setCurrentItemFromJs(readableArray.getInt(0), false);
        } else {
            throw new IllegalArgumentException(String.format("Unsupported command %d received by %s.", new Object[]{Integer.valueOf(i), ReactViewPagerManager.class.getSimpleName()}));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0051  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void receiveCommand(com.facebook.react.views.viewpager.ReactViewPager r5, java.lang.String r6, com.facebook.react.bridge.ReadableArray r7) {
        /*
            r4 = this;
            com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.assertNotNull(r5)
            com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.assertNotNull(r7)
            int r0 = r6.hashCode()
            r1 = -445763635(0xffffffffe56e2fcd, float:-7.030031E22)
            r2 = 1
            r3 = 0
            if (r0 == r1) goto L_0x0021
            r1 = 1984860689(0x764e9211, float:1.0474372E33)
            if (r0 == r1) goto L_0x0017
            goto L_0x002b
        L_0x0017:
            java.lang.String r0 = "setPage"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x002b
            r0 = 0
            goto L_0x002c
        L_0x0021:
            java.lang.String r0 = "setPageWithoutAnimation"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x002b
            r0 = 1
            goto L_0x002c
        L_0x002b:
            r0 = -1
        L_0x002c:
            if (r0 == 0) goto L_0x0051
            if (r0 != r2) goto L_0x0038
            int r6 = r7.getInt(r3)
            r5.setCurrentItemFromJs(r6, r3)
            return
        L_0x0038:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            r7 = 2
            java.lang.Object[] r7 = new java.lang.Object[r7]
            r7[r3] = r6
            java.lang.Class<com.facebook.react.views.viewpager.ReactViewPagerManager> r6 = com.facebook.react.views.viewpager.ReactViewPagerManager.class
            java.lang.String r6 = r6.getSimpleName()
            r7[r2] = r6
            java.lang.String r6 = "Unsupported command %d received by %s."
            java.lang.String r6 = java.lang.String.format(r6, r7)
            r5.<init>(r6)
            throw r5
        L_0x0051:
            int r6 = r7.getInt(r3)
            r5.setCurrentItemFromJs(r6, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.viewpager.ReactViewPagerManager.receiveCommand(com.facebook.react.views.viewpager.ReactViewPager, java.lang.String, com.facebook.react.bridge.ReadableArray):void");
    }
}
