package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.ThemeEnforcement;

public abstract class BaseProgressIndicatorSpec {
    public int hideAnimationBehavior;
    public int[] indicatorColors = new int[0];
    public int showAnimationBehavior;
    public int trackColor;
    public int trackCornerRadius;
    public int trackThickness;

    public BaseProgressIndicatorSpec(Context context, AttributeSet attributeSet, int i, int i2) {
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R$dimen.mtrl_progress_track_thickness);
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, R$styleable.BaseProgressIndicator, i, i2, new int[0]);
        this.trackThickness = ImageOriginUtils.getDimensionPixelSize(context, obtainStyledAttributes, R$styleable.BaseProgressIndicator_trackThickness, dimensionPixelSize);
        this.trackCornerRadius = Math.min(ImageOriginUtils.getDimensionPixelSize(context, obtainStyledAttributes, R$styleable.BaseProgressIndicator_trackCornerRadius, 0), this.trackThickness / 2);
        this.showAnimationBehavior = obtainStyledAttributes.getInt(R$styleable.BaseProgressIndicator_showAnimationBehavior, 0);
        this.hideAnimationBehavior = obtainStyledAttributes.getInt(R$styleable.BaseProgressIndicator_hideAnimationBehavior, 0);
        if (!obtainStyledAttributes.hasValue(R$styleable.BaseProgressIndicator_indicatorColor)) {
            this.indicatorColors = new int[]{ImageOriginUtils.getColor(context, R$attr.colorPrimary, -1)};
        } else if (obtainStyledAttributes.peekValue(R$styleable.BaseProgressIndicator_indicatorColor).type != 1) {
            this.indicatorColors = new int[]{obtainStyledAttributes.getColor(R$styleable.BaseProgressIndicator_indicatorColor, -1)};
        } else {
            int[] intArray = context.getResources().getIntArray(obtainStyledAttributes.getResourceId(R$styleable.BaseProgressIndicator_indicatorColor, -1));
            this.indicatorColors = intArray;
            if (intArray.length == 0) {
                throw new IllegalArgumentException("indicatorColors cannot be empty when indicatorColor is not used.");
            }
        }
        if (obtainStyledAttributes.hasValue(R$styleable.BaseProgressIndicator_trackColor)) {
            this.trackColor = obtainStyledAttributes.getColor(R$styleable.BaseProgressIndicator_trackColor, -1);
        } else {
            this.trackColor = this.indicatorColors[0];
            TypedArray obtainStyledAttributes2 = context.getTheme().obtainStyledAttributes(new int[]{16842803});
            float f2 = obtainStyledAttributes2.getFloat(0, 0.2f);
            obtainStyledAttributes2.recycle();
            this.trackColor = ImageOriginUtils.compositeARGBWithAlpha(this.trackColor, (int) (f2 * 255.0f));
        }
        obtainStyledAttributes.recycle();
    }

    public abstract void validateSpec();
}
