package com.google.android.material.internal;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;

public final class ViewUtils$3 implements OnApplyWindowInsetsListener {
    public final /* synthetic */ ViewUtils$RelativePadding val$initialPadding;
    public final /* synthetic */ ViewUtils$OnApplyWindowInsetsListener val$listener;

    public ViewUtils$3(ViewUtils$OnApplyWindowInsetsListener viewUtils$OnApplyWindowInsetsListener, ViewUtils$RelativePadding viewUtils$RelativePadding) {
        this.val$listener = viewUtils$OnApplyWindowInsetsListener;
        this.val$initialPadding = viewUtils$RelativePadding;
    }

    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return this.val$listener.onApplyWindowInsets(view, windowInsetsCompat, new ViewUtils$RelativePadding(this.val$initialPadding));
    }
}
