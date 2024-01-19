package com.facebook.react.views.checkbox;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.TypedValue;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import androidx.appcompat.widget.TintContextWrapper;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.annotations.ReactProp;
import org.apache.pdfbox.pdfparser.BaseParser;

public class ReactCheckBoxManager extends SimpleViewManager<ReactCheckBox> {
    public static final OnCheckedChangeListener ON_CHECKED_CHANGE_LISTENER = new OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            ReactContext reactContext;
            Context context = compoundButton.getContext();
            if (context instanceof TintContextWrapper) {
                reactContext = (ReactContext) ((TintContextWrapper) context).getBaseContext();
            } else {
                reactContext = (ReactContext) compoundButton.getContext();
            }
            ((UIManagerModule) reactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(new ReactCheckBoxEvent(compoundButton.getId(), z));
        }
    };
    public static final String REACT_CLASS = "AndroidCheckBox";

    public static int getIdentifier(Context context, String str) {
        return context.getResources().getIdentifier(str, ColorPropConverter.ATTR, context.getPackageName());
    }

    public static int getThemeColor(Context context, String str) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(getIdentifier(context, str), typedValue, true);
        return typedValue.data;
    }

    public String getName() {
        return REACT_CLASS;
    }

    @ReactProp(defaultBoolean = true, name = "enabled")
    public void setEnabled(ReactCheckBox reactCheckBox, boolean z) {
        reactCheckBox.setEnabled(z);
    }

    @ReactProp(name = "on")
    public void setOn(ReactCheckBox reactCheckBox, boolean z) {
        reactCheckBox.setOnCheckedChangeListener(null);
        reactCheckBox.setOn(z);
        reactCheckBox.setOnCheckedChangeListener(ON_CHECKED_CHANGE_LISTENER);
    }

    @ReactProp(name = "tintColors")
    public void setTintColors(ReactCheckBox reactCheckBox, ReadableMap readableMap) {
        int i;
        int i2;
        if (readableMap == null || !readableMap.hasKey(BaseParser.TRUE)) {
            i = getThemeColor(reactCheckBox.getContext(), "colorAccent");
        } else {
            i = readableMap.getInt(BaseParser.TRUE);
        }
        if (readableMap == null || !readableMap.hasKey(BaseParser.FALSE)) {
            i2 = getThemeColor(reactCheckBox.getContext(), "colorPrimaryDark");
        } else {
            i2 = readableMap.getInt(BaseParser.FALSE);
        }
        reactCheckBox.setButtonTintList(new ColorStateList(new int[][]{new int[]{16842912}, new int[]{-16842912}}, new int[]{i, i2}));
    }

    public void addEventEmitters(ThemedReactContext themedReactContext, ReactCheckBox reactCheckBox) {
        reactCheckBox.setOnCheckedChangeListener(ON_CHECKED_CHANGE_LISTENER);
    }

    public ReactCheckBox createViewInstance(ThemedReactContext themedReactContext) {
        return new ReactCheckBox(themedReactContext);
    }

    public void receiveCommand(ReactCheckBox reactCheckBox, String str, ReadableArray readableArray) {
        if (((str.hashCode() == -669744680 && str.equals("setNativeValue")) ? (char) 0 : 65535) == 0 && readableArray != null) {
            setOn(reactCheckBox, readableArray.getBoolean(0));
        }
    }
}
