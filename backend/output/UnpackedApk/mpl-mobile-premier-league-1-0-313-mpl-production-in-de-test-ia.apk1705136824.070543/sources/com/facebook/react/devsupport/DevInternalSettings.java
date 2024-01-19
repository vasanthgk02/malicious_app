package com.facebook.react.devsupport;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.react.modules.debug.interfaces.DeveloperSettings;

public class DevInternalSettings implements DeveloperSettings, OnSharedPreferenceChangeListener {
    public boolean isAnimationFpsDebugEnabled() {
        throw null;
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
    }
}
