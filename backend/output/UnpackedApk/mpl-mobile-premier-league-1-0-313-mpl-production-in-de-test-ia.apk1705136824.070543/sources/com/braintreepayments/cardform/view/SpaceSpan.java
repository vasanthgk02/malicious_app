package com.braintreepayments.cardform.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.text.style.ReplacementSpan;
import org.apache.fontbox.cmap.CMap;

public class SpaceSpan extends ReplacementSpan {
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f2, int i3, int i4, int i5, Paint paint) {
        canvas.drawText(charSequence.subSequence(i, i2) + CMap.SPACE, f2, (float) i4, paint);
    }

    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, FontMetricsInt fontMetricsInt) {
        return (int) (paint.measureText(charSequence, i, i2) + paint.measureText(CMap.SPACE, 0, 1));
    }
}
