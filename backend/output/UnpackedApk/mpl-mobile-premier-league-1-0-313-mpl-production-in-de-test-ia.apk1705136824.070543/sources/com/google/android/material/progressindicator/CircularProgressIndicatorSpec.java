package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.material.R$attr;

public final class CircularProgressIndicatorSpec extends BaseProgressIndicatorSpec {
    public int indicatorDirection;
    public int indicatorInset;
    public int indicatorSize;

    public CircularProgressIndicatorSpec(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.circularProgressIndicatorStyle);
    }

    public void validateSpec() {
    }

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CircularProgressIndicatorSpec(android.content.Context r10, android.util.AttributeSet r11, int r12) {
        /*
            r9 = this;
            int r4 = com.google.android.material.progressindicator.CircularProgressIndicator.DEF_STYLE_RES
            r9.<init>(r10, r11, r12, r4)
            android.content.res.Resources r0 = r10.getResources()
            int r1 = com.google.android.material.R$dimen.mtrl_progress_circular_size_medium
            int r6 = r0.getDimensionPixelSize(r1)
            android.content.res.Resources r0 = r10.getResources()
            int r1 = com.google.android.material.R$dimen.mtrl_progress_circular_inset_medium
            int r7 = r0.getDimensionPixelSize(r1)
            int[] r2 = com.google.android.material.R$styleable.CircularProgressIndicator
            r8 = 0
            int[] r5 = new int[r8]
            r0 = r10
            r1 = r11
            r3 = r12
            android.content.res.TypedArray r11 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r0, r1, r2, r3, r4, r5)
            int r12 = com.google.android.material.R$styleable.CircularProgressIndicator_indicatorSize
            int r12 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.getDimensionPixelSize(r10, r11, r12, r6)
            int r0 = r9.trackThickness
            int r0 = r0 * 2
            int r12 = java.lang.Math.max(r12, r0)
            r9.indicatorSize = r12
            int r12 = com.google.android.material.R$styleable.CircularProgressIndicator_indicatorInset
            int r10 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.getDimensionPixelSize(r10, r11, r12, r7)
            r9.indicatorInset = r10
            int r10 = com.google.android.material.R$styleable.CircularProgressIndicator_indicatorDirectionCircular
            int r10 = r11.getInt(r10, r8)
            r9.indicatorDirection = r10
            r11.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.progressindicator.CircularProgressIndicatorSpec.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
