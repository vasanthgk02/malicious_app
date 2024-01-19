package com.clevertap.android.sdk.inapp;

import android.widget.RelativeLayout.LayoutParams;

public class CTInAppHtmlCoverFragment extends CTInAppBaseFullHtmlFragment {
    public LayoutParams getLayoutParamsForCloseButton() {
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        layoutParams.addRule(11, this.webView.getId());
        layoutParams.addRule(10, this.webView.getId());
        int scaledPixels = getScaledPixels(40) / 4;
        layoutParams.setMargins(0, scaledPixels, scaledPixels, 0);
        return layoutParams;
    }
}
