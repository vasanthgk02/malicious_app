package com.facebook.react.views.switchview;

import android.content.Context;
import android.view.View.MeasureSpec;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.AndroidSwitchManagerDelegate;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaNode;

public class ReactSwitchManager extends SimpleViewManager<ReactSwitch> {
    public static final OnCheckedChangeListener ON_CHECKED_CHANGE_LISTENER = new OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            ((UIManagerModule) ((ReactContext) compoundButton.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(new ReactSwitchEvent(compoundButton.getId(), z));
        }
    };
    public static final String REACT_CLASS = "AndroidSwitch";
    public final ViewManagerDelegate<ReactSwitch> mDelegate = new AndroidSwitchManagerDelegate(this);

    public static class ReactSwitchShadowNode extends LayoutShadowNode implements YogaMeasureFunction {
        public int mHeight;
        public boolean mMeasured;
        public int mWidth;

        public ReactSwitchShadowNode() {
            setMeasureFunction(this);
        }

        public long measure(YogaNode yogaNode, float f2, YogaMeasureMode yogaMeasureMode, float f3, YogaMeasureMode yogaMeasureMode2) {
            if (!this.mMeasured) {
                ReactSwitch reactSwitch = new ReactSwitch(getThemedContext());
                reactSwitch.setShowText(false);
                int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
                reactSwitch.measure(makeMeasureSpec, makeMeasureSpec);
                this.mWidth = reactSwitch.getMeasuredWidth();
                this.mHeight = reactSwitch.getMeasuredHeight();
                this.mMeasured = true;
            }
            return ImageOriginUtils.make(this.mWidth, this.mHeight);
        }

        public ReactSwitchShadowNode(AnonymousClass1 r1) {
            setMeasureFunction(this);
        }
    }

    public static void setValueInternal(ReactSwitch reactSwitch, boolean z) {
        reactSwitch.setOnCheckedChangeListener(null);
        reactSwitch.setOn(z);
        reactSwitch.setOnCheckedChangeListener(ON_CHECKED_CHANGE_LISTENER);
    }

    public ViewManagerDelegate<ReactSwitch> getDelegate() {
        return this.mDelegate;
    }

    public String getName() {
        return REACT_CLASS;
    }

    public Class getShadowNodeClass() {
        return ReactSwitchShadowNode.class;
    }

    public long measure(Context context, ReadableMap readableMap, ReadableMap readableMap2, ReadableMap readableMap3, float f2, YogaMeasureMode yogaMeasureMode, float f3, YogaMeasureMode yogaMeasureMode2, int[] iArr) {
        ReactSwitch reactSwitch = new ReactSwitch(context);
        reactSwitch.setShowText(false);
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        reactSwitch.measure(makeMeasureSpec, makeMeasureSpec);
        return ImageOriginUtils.make(ImageOriginUtils.toDIPFromPixel((float) reactSwitch.getMeasuredWidth()), ImageOriginUtils.toDIPFromPixel((float) reactSwitch.getMeasuredHeight()));
    }

    public void setNativeValue(ReactSwitch reactSwitch, boolean z) {
    }

    public void addEventEmitters(ThemedReactContext themedReactContext, ReactSwitch reactSwitch) {
        reactSwitch.setOnCheckedChangeListener(ON_CHECKED_CHANGE_LISTENER);
    }

    public LayoutShadowNode createShadowNodeInstance() {
        return new ReactSwitchShadowNode(null);
    }

    public ReactSwitch createViewInstance(ThemedReactContext themedReactContext) {
        ReactSwitch reactSwitch = new ReactSwitch(themedReactContext);
        reactSwitch.setShowText(false);
        return reactSwitch;
    }

    public void receiveCommand(ReactSwitch reactSwitch, String str, ReadableArray readableArray) {
        boolean z = false;
        if (((str.hashCode() == -669744680 && str.equals("setNativeValue")) ? (char) 0 : 65535) == 0) {
            if (readableArray != null && readableArray.getBoolean(0)) {
                z = true;
            }
            setValueInternal(reactSwitch, z);
        }
    }

    @ReactProp(defaultBoolean = false, name = "disabled")
    public void setDisabled(ReactSwitch reactSwitch, boolean z) {
        reactSwitch.setEnabled(!z);
    }

    @ReactProp(defaultBoolean = true, name = "enabled")
    public void setEnabled(ReactSwitch reactSwitch, boolean z) {
        reactSwitch.setEnabled(z);
    }

    @ReactProp(name = "on")
    public void setOn(ReactSwitch reactSwitch, boolean z) {
        setValueInternal(reactSwitch, z);
    }

    @ReactProp(customType = "Color", name = "thumbColor")
    public void setThumbColor(ReactSwitch reactSwitch, Integer num) {
        reactSwitch.setThumbColor(num);
    }

    @ReactProp(customType = "Color", name = "thumbTintColor")
    public void setThumbTintColor(ReactSwitch reactSwitch, Integer num) {
        setThumbColor(reactSwitch, num);
    }

    @ReactProp(customType = "Color", name = "trackColorForFalse")
    public void setTrackColorForFalse(ReactSwitch reactSwitch, Integer num) {
        if (num != reactSwitch.mTrackColorForFalse) {
            reactSwitch.mTrackColorForFalse = num;
            if (!reactSwitch.isChecked()) {
                reactSwitch.setTrackColor(reactSwitch.mTrackColorForFalse);
            }
        }
    }

    @ReactProp(customType = "Color", name = "trackColorForTrue")
    public void setTrackColorForTrue(ReactSwitch reactSwitch, Integer num) {
        if (num != reactSwitch.mTrackColorForTrue) {
            reactSwitch.mTrackColorForTrue = num;
            if (reactSwitch.isChecked()) {
                reactSwitch.setTrackColor(reactSwitch.mTrackColorForTrue);
            }
        }
    }

    @ReactProp(customType = "Color", name = "trackTintColor")
    public void setTrackTintColor(ReactSwitch reactSwitch, Integer num) {
        reactSwitch.setTrackColor(num);
    }

    @ReactProp(name = "value")
    public void setValue(ReactSwitch reactSwitch, boolean z) {
        setValueInternal(reactSwitch, z);
    }
}
