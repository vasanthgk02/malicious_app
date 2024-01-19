package com.google.android.material.circularreveal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.google.android.material.circularreveal.CircularRevealWidget.RevealInfo;

public class CircularRevealLinearLayout extends LinearLayout implements CircularRevealWidget {
    public final CircularRevealHelper helper = new CircularRevealHelper(this);

    public CircularRevealLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void actualDraw(Canvas canvas) {
        super.draw(canvas);
    }

    public boolean actualIsOpaque() {
        return super.isOpaque();
    }

    public void buildCircularRevealCache() {
        if (this.helper == null) {
            throw null;
        }
    }

    public void destroyCircularRevealCache() {
        if (this.helper == null) {
            throw null;
        }
    }

    public void draw(Canvas canvas) {
        CircularRevealHelper circularRevealHelper = this.helper;
        if (circularRevealHelper != null) {
            circularRevealHelper.draw(canvas);
        } else {
            super.draw(canvas);
        }
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return this.helper.overlayDrawable;
    }

    public int getCircularRevealScrimColor() {
        return this.helper.getCircularRevealScrimColor();
    }

    public RevealInfo getRevealInfo() {
        return this.helper.getRevealInfo();
    }

    public boolean isOpaque() {
        CircularRevealHelper circularRevealHelper = this.helper;
        if (circularRevealHelper != null) {
            return circularRevealHelper.isOpaque();
        }
        return super.isOpaque();
    }

    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        CircularRevealHelper circularRevealHelper = this.helper;
        circularRevealHelper.overlayDrawable = drawable;
        circularRevealHelper.view.invalidate();
    }

    public void setCircularRevealScrimColor(int i) {
        CircularRevealHelper circularRevealHelper = this.helper;
        circularRevealHelper.scrimPaint.setColor(i);
        circularRevealHelper.view.invalidate();
    }

    public void setRevealInfo(RevealInfo revealInfo) {
        this.helper.setRevealInfo(revealInfo);
    }
}
