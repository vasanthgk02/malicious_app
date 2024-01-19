package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import java.lang.Object;

public class AndroidDropdownPickerManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & Object<T>> extends BaseViewManagerDelegate<T, U> {
    public AndroidDropdownPickerManagerDelegate(U u) {
        super(u);
    }
}
