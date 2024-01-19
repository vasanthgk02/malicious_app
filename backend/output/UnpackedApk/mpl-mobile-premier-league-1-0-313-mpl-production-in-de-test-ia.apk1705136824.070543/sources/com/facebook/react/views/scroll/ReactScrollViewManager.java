package com.facebook.react.views.scroll;

import android.util.DisplayMetrics;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.RetryableMountingLayerException;
import com.facebook.react.common.MapBuilder$Builder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import java.util.ArrayList;
import java.util.Map;

@ReactModule(name = "RCTScrollView")
public class ReactScrollViewManager extends ViewGroupManager<ReactScrollView> implements ReactScrollViewCommandHelper$ScrollCommandHandler<ReactScrollView> {
    public static final String REACT_CLASS = "RCTScrollView";
    public static final int[] SPACING_TYPES = {8, 0, 2, 1, 3};
    public FpsListener mFpsListener;

    public ReactScrollViewManager() {
        this(null);
    }

    public static Map<String, Object> createExportedCustomDirectEventTypeConstants() {
        MapBuilder$Builder builder = ImageOriginUtils.builder();
        builder.put(ScrollEventType.getJSEventName(ScrollEventType.SCROLL), ImageOriginUtils.of("registrationName", "onScroll"));
        builder.put(ScrollEventType.getJSEventName(ScrollEventType.BEGIN_DRAG), ImageOriginUtils.of("registrationName", "onScrollBeginDrag"));
        builder.put(ScrollEventType.getJSEventName(ScrollEventType.END_DRAG), ImageOriginUtils.of("registrationName", "onScrollEndDrag"));
        builder.put(ScrollEventType.getJSEventName(ScrollEventType.MOMENTUM_BEGIN), ImageOriginUtils.of("registrationName", "onMomentumScrollBegin"));
        builder.put(ScrollEventType.getJSEventName(ScrollEventType.MOMENTUM_END), ImageOriginUtils.of("registrationName", "onMomentumScrollEnd"));
        return builder.build();
    }

    public Map<String, Integer> getCommandsMap() {
        return ImageOriginUtils.of("scrollTo", Integer.valueOf(1), "scrollToEnd", Integer.valueOf(2), "flashScrollIndicators", Integer.valueOf(3));
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return createExportedCustomDirectEventTypeConstants();
    }

    public String getName() {
        return REACT_CLASS;
    }

    @ReactPropGroup(customType = "Color", names = {"borderColor", "borderLeftColor", "borderRightColor", "borderTopColor", "borderBottomColor"})
    public void setBorderColor(ReactScrollView reactScrollView, int i, Integer num) {
        float f2 = Float.NaN;
        float intValue = num == null ? Float.NaN : (float) (num.intValue() & 16777215);
        if (num != null) {
            f2 = (float) (num.intValue() >>> 24);
        }
        reactScrollView.mReactBackgroundManager.getOrCreateReactViewBackground().setBorderColor(SPACING_TYPES[i], intValue, f2);
    }

    @ReactPropGroup(defaultFloat = Float.NaN, names = {"borderRadius", "borderTopLeftRadius", "borderTopRightRadius", "borderBottomRightRadius", "borderBottomLeftRadius"})
    public void setBorderRadius(ReactScrollView reactScrollView, int i, float f2) {
        if (!ImageOriginUtils.isUndefined(f2)) {
            f2 = ImageOriginUtils.toPixelFromDIP(f2);
        }
        if (i == 0) {
            reactScrollView.setBorderRadius(f2);
            return;
        }
        reactScrollView.mReactBackgroundManager.getOrCreateReactViewBackground().setRadius(f2, i - 1);
    }

    @ReactProp(name = "borderStyle")
    public void setBorderStyle(ReactScrollView reactScrollView, String str) {
        reactScrollView.setBorderStyle(str);
    }

    @ReactPropGroup(defaultFloat = Float.NaN, names = {"borderWidth", "borderLeftWidth", "borderRightWidth", "borderTopWidth", "borderBottomWidth"})
    public void setBorderWidth(ReactScrollView reactScrollView, int i, float f2) {
        if (!ImageOriginUtils.isUndefined(f2)) {
            f2 = ImageOriginUtils.toPixelFromDIP(f2);
        }
        reactScrollView.mReactBackgroundManager.getOrCreateReactViewBackground().setBorderWidth(SPACING_TYPES[i], f2);
    }

    @ReactProp(customType = "Color", defaultInt = 0, name = "endFillColor")
    public void setBottomFillColor(ReactScrollView reactScrollView, int i) {
        reactScrollView.setEndFillColor(i);
    }

    @ReactProp(name = "contentOffset")
    public void setContentOffset(ReactScrollView reactScrollView, ReadableMap readableMap) {
        if (readableMap != null) {
            double d2 = 0.0d;
            double d3 = readableMap.hasKey("x") ? readableMap.getDouble("x") : 0.0d;
            if (readableMap.hasKey("y")) {
                d2 = readableMap.getDouble("y");
            }
            reactScrollView.reactScrollTo((int) ImageOriginUtils.toPixelFromDIP(d3), (int) ImageOriginUtils.toPixelFromDIP(d2));
            return;
        }
        reactScrollView.reactScrollTo(0, 0);
    }

    @ReactProp(name = "decelerationRate")
    public void setDecelerationRate(ReactScrollView reactScrollView, float f2) {
        reactScrollView.setDecelerationRate(f2);
    }

    @ReactProp(name = "disableIntervalMomentum")
    public void setDisableIntervalMomentum(ReactScrollView reactScrollView, boolean z) {
        reactScrollView.setDisableIntervalMomentum(z);
    }

    @ReactProp(name = "fadingEdgeLength")
    public void setFadingEdgeLength(ReactScrollView reactScrollView, int i) {
        if (i > 0) {
            reactScrollView.setVerticalFadingEdgeEnabled(true);
            reactScrollView.setFadingEdgeLength(i);
            return;
        }
        reactScrollView.setVerticalFadingEdgeEnabled(false);
        reactScrollView.setFadingEdgeLength(0);
    }

    @ReactProp(name = "nestedScrollEnabled")
    public void setNestedScrollEnabled(ReactScrollView reactScrollView, boolean z) {
        ViewCompat.setNestedScrollingEnabled(reactScrollView, z);
    }

    @ReactProp(name = "overScrollMode")
    public void setOverScrollMode(ReactScrollView reactScrollView, String str) {
        reactScrollView.setOverScrollMode(ImageOriginUtils.parseOverScrollMode(str));
    }

    @ReactProp(name = "overflow")
    public void setOverflow(ReactScrollView reactScrollView, String str) {
        reactScrollView.setOverflow(str);
    }

    @ReactProp(name = "pagingEnabled")
    public void setPagingEnabled(ReactScrollView reactScrollView, boolean z) {
        reactScrollView.setPagingEnabled(z);
    }

    @ReactProp(name = "persistentScrollbar")
    public void setPersistentScrollbar(ReactScrollView reactScrollView, boolean z) {
        reactScrollView.setScrollbarFadingEnabled(!z);
    }

    @ReactProp(name = "removeClippedSubviews")
    public void setRemoveClippedSubviews(ReactScrollView reactScrollView, boolean z) {
        reactScrollView.setRemoveClippedSubviews(z);
    }

    @ReactProp(defaultBoolean = true, name = "scrollEnabled")
    public void setScrollEnabled(ReactScrollView reactScrollView, boolean z) {
        reactScrollView.setScrollEnabled(z);
        reactScrollView.setFocusable(z);
    }

    @ReactProp(name = "scrollPerfTag")
    public void setScrollPerfTag(ReactScrollView reactScrollView, String str) {
        reactScrollView.setScrollPerfTag(str);
    }

    @ReactProp(name = "sendMomentumEvents")
    public void setSendMomentumEvents(ReactScrollView reactScrollView, boolean z) {
        reactScrollView.setSendMomentumEvents(z);
    }

    @ReactProp(name = "showsVerticalScrollIndicator")
    public void setShowsVerticalScrollIndicator(ReactScrollView reactScrollView, boolean z) {
        reactScrollView.setVerticalScrollBarEnabled(z);
    }

    @ReactProp(name = "snapToEnd")
    public void setSnapToEnd(ReactScrollView reactScrollView, boolean z) {
        reactScrollView.setSnapToEnd(z);
    }

    @ReactProp(name = "snapToInterval")
    public void setSnapToInterval(ReactScrollView reactScrollView, float f2) {
        reactScrollView.setSnapInterval((int) (f2 * ImageOriginUtils.sScreenDisplayMetrics.density));
    }

    @ReactProp(name = "snapToOffsets")
    public void setSnapToOffsets(ReactScrollView reactScrollView, ReadableArray readableArray) {
        DisplayMetrics displayMetrics = ImageOriginUtils.sScreenDisplayMetrics;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < readableArray.size(); i++) {
            arrayList.add(Integer.valueOf((int) (readableArray.getDouble(i) * ((double) displayMetrics.density))));
        }
        reactScrollView.setSnapOffsets(arrayList);
    }

    @ReactProp(name = "snapToStart")
    public void setSnapToStart(ReactScrollView reactScrollView, boolean z) {
        reactScrollView.setSnapToStart(z);
    }

    public ReactScrollViewManager(FpsListener fpsListener) {
        this.mFpsListener = null;
        this.mFpsListener = fpsListener;
    }

    public ReactScrollView createViewInstance(ThemedReactContext themedReactContext) {
        return new ReactScrollView(themedReactContext, this.mFpsListener);
    }

    public void flashScrollIndicators(ReactScrollView reactScrollView) {
        reactScrollView.flashScrollIndicators();
    }

    public void scrollTo(ReactScrollView reactScrollView, ReactScrollViewCommandHelper$ScrollToCommandData reactScrollViewCommandHelper$ScrollToCommandData) {
        if (reactScrollViewCommandHelper$ScrollToCommandData.mAnimated) {
            reactScrollView.reactSmoothScrollTo(reactScrollViewCommandHelper$ScrollToCommandData.mDestX, reactScrollViewCommandHelper$ScrollToCommandData.mDestY);
        } else {
            reactScrollView.reactScrollTo(reactScrollViewCommandHelper$ScrollToCommandData.mDestX, reactScrollViewCommandHelper$ScrollToCommandData.mDestY);
        }
    }

    public void scrollToEnd(ReactScrollView reactScrollView, ReactScrollViewCommandHelper$ScrollToEndCommandData reactScrollViewCommandHelper$ScrollToEndCommandData) {
        View childAt = reactScrollView.getChildAt(0);
        if (childAt != null) {
            int paddingBottom = reactScrollView.getPaddingBottom() + childAt.getHeight();
            if (reactScrollViewCommandHelper$ScrollToEndCommandData.mAnimated) {
                reactScrollView.reactSmoothScrollTo(reactScrollView.getScrollX(), paddingBottom);
            } else {
                reactScrollView.reactScrollTo(reactScrollView.getScrollX(), paddingBottom);
            }
        } else {
            throw new RetryableMountingLayerException((String) "scrollToEnd called on ScrollView without child");
        }
    }

    public Object updateState(ReactScrollView reactScrollView, ReactStylesDiffMap reactStylesDiffMap, StateWrapper stateWrapper) {
        reactScrollView.mStateWrapper = stateWrapper;
        return null;
    }

    public void receiveCommand(ReactScrollView reactScrollView, int i, ReadableArray readableArray) {
        ImageOriginUtils.receiveCommand((ReactScrollViewCommandHelper$ScrollCommandHandler<T>) this, reactScrollView, i, readableArray);
    }

    public void receiveCommand(ReactScrollView reactScrollView, String str, ReadableArray readableArray) {
        ImageOriginUtils.receiveCommand((ReactScrollViewCommandHelper$ScrollCommandHandler<T>) this, reactScrollView, str, readableArray);
    }
}
