package com.facebook.react.views.slider;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.SliderManagerDelegate;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaNode;
import java.util.Map;

public class ReactSliderManager extends SimpleViewManager<ReactSlider> {
    public static final OnSeekBarChangeListener ON_CHANGE_LISTENER = new OnSeekBarChangeListener() {
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            ((UIManagerModule) ((ReactContext) seekBar.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(new ReactSliderEvent(seekBar.getId(), ((ReactSlider) seekBar).toRealProgress(i), z));
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            ((UIManagerModule) ((ReactContext) seekBar.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(new ReactSlidingCompleteEvent(seekBar.getId(), ((ReactSlider) seekBar).toRealProgress(seekBar.getProgress())));
        }
    };
    public static final String REACT_CLASS = "RCTSlider";
    public static final int STYLE = 16842875;
    public static ReactSliderAccessibilityDelegate sAccessibilityDelegate = new ReactSliderAccessibilityDelegate();
    public final ViewManagerDelegate<ReactSlider> mDelegate = new SliderManagerDelegate(this);

    public static class ReactSliderAccessibilityDelegate extends AccessibilityDelegateCompat {
        public static boolean isSliderAction(int i) {
            return i == AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId() || i == AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId() || i == AccessibilityActionCompat.ACTION_SET_PROGRESS.getId();
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (isSliderAction(i)) {
                ReactSliderManager.ON_CHANGE_LISTENER.onStartTrackingTouch((SeekBar) view);
            }
            boolean performAccessibilityAction = super.performAccessibilityAction(view, i, bundle);
            if (isSliderAction(i)) {
                ReactSliderManager.ON_CHANGE_LISTENER.onStopTrackingTouch((SeekBar) view);
            }
            return performAccessibilityAction;
        }
    }

    public static class ReactSliderShadowNode extends LayoutShadowNode implements YogaMeasureFunction {
        public int mHeight;
        public boolean mMeasured;
        public int mWidth;

        public ReactSliderShadowNode() {
            setMeasureFunction(this);
        }

        public long measure(YogaNode yogaNode, float f2, YogaMeasureMode yogaMeasureMode, float f3, YogaMeasureMode yogaMeasureMode2) {
            if (!this.mMeasured) {
                ReactSlider reactSlider = new ReactSlider(getThemedContext(), null, ReactSliderManager.STYLE);
                int makeMeasureSpec = MeasureSpec.makeMeasureSpec(-2, 0);
                reactSlider.measure(makeMeasureSpec, makeMeasureSpec);
                this.mWidth = reactSlider.getMeasuredWidth();
                this.mHeight = reactSlider.getMeasuredHeight();
                this.mMeasured = true;
            }
            return ImageOriginUtils.make(this.mWidth, this.mHeight);
        }

        public ReactSliderShadowNode(AnonymousClass1 r1) {
            setMeasureFunction(this);
        }
    }

    public ViewManagerDelegate<ReactSlider> getDelegate() {
        return this.mDelegate;
    }

    public Map getExportedCustomDirectEventTypeConstants() {
        return ImageOriginUtils.of("topSlidingComplete", ImageOriginUtils.of("registrationName", "onSlidingComplete"));
    }

    public String getName() {
        return REACT_CLASS;
    }

    public Class getShadowNodeClass() {
        return ReactSliderShadowNode.class;
    }

    public long measure(Context context, ReadableMap readableMap, ReadableMap readableMap2, ReadableMap readableMap3, float f2, YogaMeasureMode yogaMeasureMode, float f3, YogaMeasureMode yogaMeasureMode2, int[] iArr) {
        ReactSlider reactSlider = new ReactSlider(context, null, STYLE);
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(-2, 0);
        reactSlider.measure(makeMeasureSpec, makeMeasureSpec);
        return ImageOriginUtils.make(ImageOriginUtils.toDIPFromPixel((float) reactSlider.getMeasuredWidth()), ImageOriginUtils.toDIPFromPixel((float) reactSlider.getMeasuredHeight()));
    }

    public void setDisabled(ReactSlider reactSlider, boolean z) {
    }

    public void setMaximumTrackImage(ReactSlider reactSlider, ReadableMap readableMap) {
    }

    public void setMinimumTrackImage(ReactSlider reactSlider, ReadableMap readableMap) {
    }

    public void setThumbImage(ReactSlider reactSlider, ReadableMap readableMap) {
    }

    public void setTrackImage(ReactSlider reactSlider, ReadableMap readableMap) {
    }

    public void addEventEmitters(ThemedReactContext themedReactContext, ReactSlider reactSlider) {
        reactSlider.setOnSeekBarChangeListener(ON_CHANGE_LISTENER);
    }

    public LayoutShadowNode createShadowNodeInstance() {
        return new ReactSliderShadowNode(null);
    }

    public ReactSlider createViewInstance(ThemedReactContext themedReactContext) {
        ReactSlider reactSlider = new ReactSlider(themedReactContext, null, STYLE);
        ViewCompat.setAccessibilityDelegate(reactSlider, sAccessibilityDelegate);
        return reactSlider;
    }

    @ReactProp(defaultBoolean = true, name = "enabled")
    public void setEnabled(ReactSlider reactSlider, boolean z) {
        reactSlider.setEnabled(z);
    }

    @ReactProp(customType = "Color", name = "maximumTrackTintColor")
    public void setMaximumTrackTintColor(ReactSlider reactSlider, Integer num) {
        Drawable findDrawableByLayerId = ((LayerDrawable) reactSlider.getProgressDrawable().getCurrent()).findDrawableByLayerId(16908288);
        if (num == null) {
            findDrawableByLayerId.clearColorFilter();
        } else {
            findDrawableByLayerId.setColorFilter(num.intValue(), Mode.SRC_IN);
        }
    }

    @ReactProp(defaultDouble = 1.0d, name = "maximumValue")
    public void setMaximumValue(ReactSlider reactSlider, double d2) {
        reactSlider.setMaxValue(d2);
    }

    @ReactProp(customType = "Color", name = "minimumTrackTintColor")
    public void setMinimumTrackTintColor(ReactSlider reactSlider, Integer num) {
        Drawable findDrawableByLayerId = ((LayerDrawable) reactSlider.getProgressDrawable().getCurrent()).findDrawableByLayerId(16908301);
        if (num == null) {
            findDrawableByLayerId.clearColorFilter();
        } else {
            findDrawableByLayerId.setColorFilter(num.intValue(), Mode.SRC_IN);
        }
    }

    @ReactProp(defaultDouble = 0.0d, name = "minimumValue")
    public void setMinimumValue(ReactSlider reactSlider, double d2) {
        reactSlider.setMinValue(d2);
    }

    @ReactProp(defaultDouble = 0.0d, name = "step")
    public void setStep(ReactSlider reactSlider, double d2) {
        reactSlider.setStep(d2);
    }

    public void setTestID(ReactSlider reactSlider, String str) {
        super.setTestId(reactSlider, str);
    }

    @ReactProp(customType = "Color", name = "thumbTintColor")
    public void setThumbTintColor(ReactSlider reactSlider, Integer num) {
        if (num == null) {
            reactSlider.getThumb().clearColorFilter();
        } else {
            reactSlider.getThumb().setColorFilter(num.intValue(), Mode.SRC_IN);
        }
    }

    @ReactProp(defaultDouble = 0.0d, name = "value")
    public void setValue(ReactSlider reactSlider, double d2) {
        reactSlider.setOnSeekBarChangeListener(null);
        reactSlider.setValue(d2);
        reactSlider.setOnSeekBarChangeListener(ON_CHANGE_LISTENER);
    }
}
