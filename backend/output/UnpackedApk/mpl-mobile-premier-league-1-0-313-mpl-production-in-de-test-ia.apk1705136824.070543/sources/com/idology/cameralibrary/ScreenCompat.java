package com.idology.cameralibrary;

import android.app.Activity;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class ScreenCompat {
    public float mHeight;
    public float mWidth;

    public ScreenCompat(Activity activity) {
        Constants constants = Constants.ourInstance;
        this.mWidth = (float) activity.getWindowManager().getDefaultDisplay().getWidth();
        this.mHeight = (float) activity.getWindowManager().getDefaultDisplay().getHeight();
        float f2 = activity.getApplicationContext().getResources().getDisplayMetrics().density;
    }

    public RelativeLayout calculateLayoutSize(RelativeLayout relativeLayout, float f2) {
        float f3 = (float) relativeLayout.getLayoutParams().width;
        float f4 = (float) relativeLayout.getLayoutParams().height;
        float f5 = this.mWidth;
        float f6 = this.mHeight;
        float f7 = f2 / 100.0f;
        float f8 = (f4 > f6 - f7 ? (f4 - f6) / f4 : f3 > f5 - f7 ? (f3 - f5) / f3 : 0.0f) + f7;
        LayoutParams layoutParams = new LayoutParams(relativeLayout.getLayoutParams());
        layoutParams.addRule(13);
        layoutParams.height = (int) (f4 - (f8 * f4));
        layoutParams.width = (int) (f3 - (f8 * f3));
        relativeLayout.setLayoutParams(layoutParams);
        return relativeLayout;
    }
}
