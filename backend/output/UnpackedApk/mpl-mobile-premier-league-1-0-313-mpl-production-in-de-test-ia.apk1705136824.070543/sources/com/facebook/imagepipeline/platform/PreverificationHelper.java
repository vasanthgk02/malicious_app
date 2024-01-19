package com.facebook.imagepipeline.platform;

import android.annotation.TargetApi;
import android.graphics.Bitmap.Config;
import com.facebook.soloader.DoNotOptimize;

@DoNotOptimize
public class PreverificationHelper {
    @DoNotOptimize
    @TargetApi(26)
    public boolean shouldUseHardwareBitmapConfig(Config config) {
        return config == Config.HARDWARE;
    }
}
