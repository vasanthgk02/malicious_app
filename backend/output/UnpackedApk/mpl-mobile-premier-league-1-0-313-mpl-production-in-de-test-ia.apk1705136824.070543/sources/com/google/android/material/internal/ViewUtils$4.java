package com.google.android.material.internal;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import androidx.core.view.ViewCompat;

public final class ViewUtils$4 implements OnAttachStateChangeListener {
    public void onViewAttachedToWindow(View view) {
        view.removeOnAttachStateChangeListener(this);
        ViewCompat.requestApplyInsets(view);
    }

    public void onViewDetachedFromWindow(View view) {
    }
}
