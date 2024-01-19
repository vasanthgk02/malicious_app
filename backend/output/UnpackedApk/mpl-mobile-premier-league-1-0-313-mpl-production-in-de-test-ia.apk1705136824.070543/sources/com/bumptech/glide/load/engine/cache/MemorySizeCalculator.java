package com.bumptech.glide.load.engine.cache;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;

public final class MemorySizeCalculator {
    public final int arrayPoolSize;
    public final int bitmapPoolSize;
    public final Context context;
    public final int memoryCacheSize;

    public static final class Builder {
        public static final int BITMAP_POOL_TARGET_SCREENS = (VERSION.SDK_INT < 26 ? 4 : 1);
        public ActivityManager activityManager;
        public int arrayPoolSizeBytes = 4194304;
        public float bitmapPoolScreens = ((float) BITMAP_POOL_TARGET_SCREENS);
        public final Context context;
        public float lowMemoryMaxSizeMultiplier = 0.33f;
        public float maxSizeMultiplier = 0.4f;
        public float memoryCacheScreens = 2.0f;
        public ScreenDimensions screenDimensions;

        public Builder(Context context2) {
            this.context = context2;
            this.activityManager = (ActivityManager) context2.getSystemService("activity");
            this.screenDimensions = new DisplayMetricsScreenDimensions(context2.getResources().getDisplayMetrics());
            if (VERSION.SDK_INT >= 26 && this.activityManager.isLowRamDevice()) {
                this.bitmapPoolScreens = 0.0f;
            }
        }
    }

    public static final class DisplayMetricsScreenDimensions implements ScreenDimensions {
        public final DisplayMetrics displayMetrics;

        public DisplayMetricsScreenDimensions(DisplayMetrics displayMetrics2) {
            this.displayMetrics = displayMetrics2;
        }
    }

    public interface ScreenDimensions {
    }

    public MemorySizeCalculator(Builder builder) {
        int i;
        this.context = builder.context;
        if (builder.activityManager.isLowRamDevice()) {
            i = builder.arrayPoolSizeBytes / 2;
        } else {
            i = builder.arrayPoolSizeBytes;
        }
        this.arrayPoolSize = i;
        ActivityManager activityManager = builder.activityManager;
        float f2 = builder.maxSizeMultiplier;
        float f3 = builder.lowMemoryMaxSizeMultiplier;
        int round = Math.round(((float) (activityManager.getMemoryClass() * 1024 * 1024)) * (activityManager.isLowRamDevice() ? f3 : f2));
        DisplayMetrics displayMetrics = ((DisplayMetricsScreenDimensions) builder.screenDimensions).displayMetrics;
        float f4 = (float) (displayMetrics.widthPixels * displayMetrics.heightPixels * 4);
        int round2 = Math.round(builder.bitmapPoolScreens * f4);
        int round3 = Math.round(f4 * builder.memoryCacheScreens);
        int i2 = round - this.arrayPoolSize;
        if (round3 + round2 <= i2) {
            this.memoryCacheSize = round3;
            this.bitmapPoolSize = round2;
        } else {
            float f5 = (float) i2;
            float f6 = builder.bitmapPoolScreens;
            float f7 = builder.memoryCacheScreens;
            float f8 = f5 / (f6 + f7);
            this.memoryCacheSize = Math.round(f7 * f8);
            this.bitmapPoolSize = Math.round(f8 * builder.bitmapPoolScreens);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            toMb(this.memoryCacheSize);
            toMb(this.bitmapPoolSize);
            toMb(this.arrayPoolSize);
            toMb(round);
            builder.activityManager.getMemoryClass();
            builder.activityManager.isLowRamDevice();
        }
    }

    public final String toMb(int i) {
        return Formatter.formatFileSize(this.context, (long) i);
    }
}
