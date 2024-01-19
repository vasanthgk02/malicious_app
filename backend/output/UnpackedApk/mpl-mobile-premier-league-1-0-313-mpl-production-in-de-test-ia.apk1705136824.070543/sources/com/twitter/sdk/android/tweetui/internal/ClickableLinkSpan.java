package com.twitter.sdk.android.tweetui.internal;

import android.text.TextPaint;
import android.text.style.ClickableSpan;

public abstract class ClickableLinkSpan extends ClickableSpan implements HighlightedClickableSpan {
    public final boolean colored = true;
    public final int linkColor;
    public boolean selected;
    public final int selectedColor;
    public final boolean underlined;

    public ClickableLinkSpan(int i, int i2, boolean z) {
        this.selectedColor = i;
        this.linkColor = i2;
        this.underlined = z;
    }

    public boolean isSelected() {
        return this.selected;
    }

    public void select(boolean z) {
        this.selected = z;
    }

    public void updateDrawState(TextPaint textPaint) {
        if (this.colored) {
            textPaint.setColor(this.linkColor);
        } else {
            textPaint.setColor(textPaint.linkColor);
        }
        if (this.selected) {
            textPaint.bgColor = this.selectedColor;
        } else {
            textPaint.bgColor = 0;
        }
        if (this.underlined) {
            textPaint.setUnderlineText(true);
        }
    }
}
