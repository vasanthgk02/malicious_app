package com.rudderstack.android.sdk.core;

import android.app.Application;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.gson.annotations.SerializedName;

public class RudderScreenInfo {
    @SerializedName("density")
    public int density;
    @SerializedName("height")
    public int height;
    @SerializedName("width")
    public int width;

    public RudderScreenInfo(Application application) {
        WindowManager windowManager = (WindowManager) application.getSystemService("window");
        if (windowManager != null) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            this.density = displayMetrics.densityDpi;
            this.height = displayMetrics.heightPixels;
            this.width = displayMetrics.widthPixels;
        }
    }
}
