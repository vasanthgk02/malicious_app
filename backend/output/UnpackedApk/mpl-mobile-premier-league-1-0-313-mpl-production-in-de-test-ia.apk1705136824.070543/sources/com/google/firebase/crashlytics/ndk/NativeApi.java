package com.google.firebase.crashlytics.ndk;

import android.content.res.AssetManager;

public interface NativeApi {
    boolean initialize(String str, AssetManager assetManager);
}
