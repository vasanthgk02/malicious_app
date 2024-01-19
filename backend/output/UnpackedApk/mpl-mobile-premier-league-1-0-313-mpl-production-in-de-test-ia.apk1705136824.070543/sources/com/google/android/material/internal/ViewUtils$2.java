package com.google.android.material.internal;

import android.view.View;
import androidx.core.view.WindowInsetsCompat;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;

public final class ViewUtils$2 implements ViewUtils$OnApplyWindowInsetsListener {
    public final /* synthetic */ ViewUtils$OnApplyWindowInsetsListener val$listener;
    public final /* synthetic */ boolean val$paddingBottomSystemWindowInsets;
    public final /* synthetic */ boolean val$paddingLeftSystemWindowInsets;
    public final /* synthetic */ boolean val$paddingRightSystemWindowInsets;

    public ViewUtils$2(boolean z, boolean z2, boolean z3, ViewUtils$OnApplyWindowInsetsListener viewUtils$OnApplyWindowInsetsListener) {
        this.val$paddingBottomSystemWindowInsets = z;
        this.val$paddingLeftSystemWindowInsets = z2;
        this.val$paddingRightSystemWindowInsets = z3;
        this.val$listener = viewUtils$OnApplyWindowInsetsListener;
    }

    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat, ViewUtils$RelativePadding viewUtils$RelativePadding) {
        if (this.val$paddingBottomSystemWindowInsets) {
            viewUtils$RelativePadding.bottom = windowInsetsCompat.getSystemWindowInsetBottom() + viewUtils$RelativePadding.bottom;
        }
        boolean isLayoutRtl = ImageOriginUtils.isLayoutRtl(view);
        if (this.val$paddingLeftSystemWindowInsets) {
            if (isLayoutRtl) {
                viewUtils$RelativePadding.end = windowInsetsCompat.getSystemWindowInsetLeft() + viewUtils$RelativePadding.end;
            } else {
                viewUtils$RelativePadding.start = windowInsetsCompat.getSystemWindowInsetLeft() + viewUtils$RelativePadding.start;
            }
        }
        if (this.val$paddingRightSystemWindowInsets) {
            if (isLayoutRtl) {
                viewUtils$RelativePadding.start = windowInsetsCompat.getSystemWindowInsetRight() + viewUtils$RelativePadding.start;
            } else {
                viewUtils$RelativePadding.end = windowInsetsCompat.getSystemWindowInsetRight() + viewUtils$RelativePadding.end;
            }
        }
        view.setPaddingRelative(viewUtils$RelativePadding.start, viewUtils$RelativePadding.top, viewUtils$RelativePadding.end, viewUtils$RelativePadding.bottom);
        ViewUtils$OnApplyWindowInsetsListener viewUtils$OnApplyWindowInsetsListener = this.val$listener;
        return viewUtils$OnApplyWindowInsetsListener != null ? viewUtils$OnApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsetsCompat, viewUtils$RelativePadding) : windowInsetsCompat;
    }
}
