package com.reactnativecommunity.picker;

import android.content.Context;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;

@ReactModule(name = "RNCAndroidDialogPicker")
public class ReactDialogPickerManager extends ReactPickerManager {
    public static final String REACT_CLASS = "RNCAndroidDialogPicker";

    public String getName() {
        return REACT_CLASS;
    }

    public ReactPicker createViewInstance(ThemedReactContext themedReactContext) {
        return new ReactPicker((Context) themedReactContext, 0);
    }
}
