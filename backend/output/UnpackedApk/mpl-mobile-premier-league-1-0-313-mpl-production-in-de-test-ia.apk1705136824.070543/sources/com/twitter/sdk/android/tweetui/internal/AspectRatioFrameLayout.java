package com.twitter.sdk.android.tweetui.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.twitter.sdk.android.tweetui.R$styleable;

public class AspectRatioFrameLayout extends FrameLayout {
    public double aspectRatio;
    public int dimensionToAdjust;

    public AspectRatioFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.dimensionToAdjust == 0) {
            if (MeasureSpec.getMode(i) == 1073741824) {
                i6 = MeasureSpec.getSize(i);
            } else {
                super.onMeasure(i, i2);
                i6 = getMeasuredWidth();
            }
            i4 = i6 - paddingRight;
            i3 = (int) (((double) i4) / this.aspectRatio);
        } else {
            if (MeasureSpec.getMode(i2) == 1073741824) {
                i5 = MeasureSpec.getSize(i2);
            } else {
                super.onMeasure(i, i2);
                i5 = getMeasuredHeight();
            }
            i3 = i5 - paddingTop;
            i4 = (int) (((double) i3) * this.aspectRatio);
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(i4 + paddingRight, 1073741824), MeasureSpec.makeMeasureSpec(i3 + paddingTop, 1073741824));
    }

    public void setAspectRatio(double d2) {
        this.aspectRatio = d2;
    }

    public AspectRatioFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(i, R$styleable.AspectRatioFrameLayout);
        try {
            this.aspectRatio = (double) obtainStyledAttributes.getFloat(R$styleable.AspectRatioFrameLayout_tw__frame_layout_aspect_ratio, 1.0f);
            this.dimensionToAdjust = obtainStyledAttributes.getInt(R$styleable.AspectRatioFrameLayout_tw__frame_layout_dimension_to_adjust, 0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
