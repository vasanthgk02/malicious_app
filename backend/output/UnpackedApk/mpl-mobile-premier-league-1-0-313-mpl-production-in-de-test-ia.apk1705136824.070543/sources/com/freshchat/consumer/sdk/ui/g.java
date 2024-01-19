package com.freshchat.consumer.sdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.inputmethod.InputMethodManager;
import android.widget.ListPopupWindow;
import com.freshchat.consumer.sdk.j.p;

public class g extends ListPopupWindow {
    public Context context;

    public g(Context context2, AttributeSet attributeSet, int i) {
        super(context2, attributeSet, i);
        this.context = context2;
    }

    public void show() {
        if (getHeight() > ((int) (((double) p.as(this.context)) * 0.5d))) {
            ((InputMethodManager) this.context.getSystemService("input_method")).hideSoftInputFromWindow(getAnchorView().getRootView().getWindowToken(), 0);
        }
        super.show();
    }
}
