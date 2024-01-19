package com.braintreepayments.cardform.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import android.util.TypedValue;

public class PaddedImageSpan extends ImageSpan {
    public boolean mDisabled;
    public int mPadding;

    public PaddedImageSpan(Context context, int i) {
        super(context, i);
        this.mPadding = Math.round(TypedValue.applyDimension(1, 8.0f, context.getResources().getDisplayMetrics()));
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f2, int i3, int i4, int i5, Paint paint) {
        super.draw(canvas, charSequence, i, i2, f2 + ((float) this.mPadding), i3, i4, i5, paint);
    }

    public Drawable getDrawable() {
        Drawable drawable = super.getDrawable();
        if (this.mDisabled) {
            drawable.mutate().setAlpha(80);
        }
        return drawable;
    }

    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, FontMetricsInt fontMetricsInt) {
        return (this.mPadding * 2) + super.getSize(paint, charSequence, i, i2, fontMetricsInt);
    }
}
