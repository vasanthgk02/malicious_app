package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import java.lang.Object;

public class AndroidDrawerLayoutManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & Object<T>> extends BaseViewManagerDelegate<T, U> {
    public AndroidDrawerLayoutManagerDelegate(U u) {
        super(u);
    }
}
