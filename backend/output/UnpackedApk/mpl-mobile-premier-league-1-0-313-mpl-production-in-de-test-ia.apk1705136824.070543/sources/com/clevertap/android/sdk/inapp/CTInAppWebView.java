package com.clevertap.android.sdk.inapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.webkit.WebView;

@SuppressLint({"ViewConstructor"})
public class CTInAppWebView extends WebView {
    public final Point dim = new Point();
    public int height;
    public int heightPercentage;
    public int width;
    public int widthPercentage;

    @SuppressLint({"ResourceType"})
    public CTInAppWebView(Context context, int i, int i2, int i3, int i4) {
        super(context);
        this.width = i;
        this.height = i2;
        this.widthPercentage = i3;
        this.heightPercentage = i4;
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setOverScrollMode(2);
        setBackgroundColor(0);
        setId(188293);
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        updateDimension();
        Point point = this.dim;
        setMeasuredDimension(point.x, point.y);
    }

    public boolean performClick() {
        return super.performClick();
    }

    public void updateDimension() {
        int i = this.width;
        if (i != 0) {
            this.dim.x = (int) TypedValue.applyDimension(1, (float) i, getResources().getDisplayMetrics());
        } else {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            this.dim.x = (int) (((float) (displayMetrics.widthPixels * this.widthPercentage)) / 100.0f);
        }
        int i2 = this.height;
        if (i2 != 0) {
            this.dim.y = (int) TypedValue.applyDimension(1, (float) i2, getResources().getDisplayMetrics());
            return;
        }
        DisplayMetrics displayMetrics2 = getResources().getDisplayMetrics();
        this.dim.y = (int) (((float) (displayMetrics2.heightPixels * this.heightPercentage)) / 100.0f);
    }
}
