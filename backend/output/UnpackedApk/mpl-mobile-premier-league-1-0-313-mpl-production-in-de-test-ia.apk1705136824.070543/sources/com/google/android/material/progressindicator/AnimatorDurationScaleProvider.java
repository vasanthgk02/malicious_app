package com.google.android.material.progressindicator;

import android.content.ContentResolver;
import android.provider.Settings.Global;

public class AnimatorDurationScaleProvider {
    public float getSystemAnimatorDurationScale(ContentResolver contentResolver) {
        return Global.getFloat(contentResolver, "animator_duration_scale", 1.0f);
    }
}
