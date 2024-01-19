package com.facebook.react.views.text;

import android.annotation.TargetApi;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

@TargetApi(21)
public class CustomLetterSpacingSpan extends MetricAffectingSpan implements ReactSpan {
    public final float mLetterSpacing;

    public CustomLetterSpacingSpan(float f2) {
        this.mLetterSpacing = f2;
    }

    public void updateDrawState(TextPaint textPaint) {
        if (!Float.isNaN(this.mLetterSpacing)) {
            textPaint.setLetterSpacing(this.mLetterSpacing);
        }
    }

    public void updateMeasureState(TextPaint textPaint) {
        if (!Float.isNaN(this.mLetterSpacing)) {
            textPaint.setLetterSpacing(this.mLetterSpacing);
        }
    }
}
