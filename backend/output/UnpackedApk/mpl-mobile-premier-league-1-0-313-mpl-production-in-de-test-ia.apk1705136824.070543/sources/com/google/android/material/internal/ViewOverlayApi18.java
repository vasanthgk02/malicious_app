package com.google.android.material.internal;

import android.view.View;
import android.view.ViewOverlay;

public class ViewOverlayApi18 implements ViewOverlayImpl {
    public final ViewOverlay viewOverlay;

    public ViewOverlayApi18(View view) {
        this.viewOverlay = view.getOverlay();
    }
}
