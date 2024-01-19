package com.paynimo.android.payment.util;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;

public class a extends TypefaceSpan {

    /* renamed from: a  reason: collision with root package name */
    public final Typeface f1439a;

    public a(String str, Typeface typeface) {
        super(str);
        this.f1439a = typeface;
    }

    public static void a(Paint paint, Typeface typeface) {
        int i;
        Typeface typeface2 = paint.getTypeface();
        if (typeface2 == null) {
            i = 0;
        } else {
            i = typeface2.getStyle();
        }
        int i2 = i & (~typeface.getStyle());
        if ((i2 & 1) != 0) {
            paint.setFakeBoldText(true);
        }
        if ((i2 & 2) != 0) {
            paint.setTextSkewX(-0.25f);
        }
        paint.setTypeface(typeface);
    }

    public void updateDrawState(TextPaint textPaint) {
        a(textPaint, this.f1439a);
    }

    public void updateMeasureState(TextPaint textPaint) {
        a(textPaint, this.f1439a);
    }
}
