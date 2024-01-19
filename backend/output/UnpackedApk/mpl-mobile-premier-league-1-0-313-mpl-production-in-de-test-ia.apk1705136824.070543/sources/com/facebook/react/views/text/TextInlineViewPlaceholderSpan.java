package com.facebook.react.views.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.text.style.ReplacementSpan;

public class TextInlineViewPlaceholderSpan extends ReplacementSpan implements ReactSpan {
    public int mHeight;
    public int mReactTag;
    public int mWidth;

    public TextInlineViewPlaceholderSpan(int i, int i2, int i3) {
        this.mReactTag = i;
        this.mWidth = i2;
        this.mHeight = i3;
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f2, int i3, int i4, int i5, Paint paint) {
    }

    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, FontMetricsInt fontMetricsInt) {
        if (fontMetricsInt != null) {
            int i3 = -this.mHeight;
            fontMetricsInt.ascent = i3;
            fontMetricsInt.descent = 0;
            fontMetricsInt.top = i3;
            fontMetricsInt.bottom = 0;
        }
        return this.mWidth;
    }
}
