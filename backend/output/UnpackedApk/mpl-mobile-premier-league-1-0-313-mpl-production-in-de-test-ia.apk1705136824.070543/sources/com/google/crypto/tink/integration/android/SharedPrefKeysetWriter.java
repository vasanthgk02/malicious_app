package com.google.crypto.tink.integration.android;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.google.crypto.tink.KeysetWriter;

public final class SharedPrefKeysetWriter implements KeysetWriter {
    public final Editor editor;
    public final String keysetName;

    public SharedPrefKeysetWriter(Context context, String str, String str2) {
        this.keysetName = str;
        Context applicationContext = context.getApplicationContext();
        if (str2 == null) {
            this.editor = PreferenceManager.getDefaultSharedPreferences(applicationContext).edit();
        } else {
            this.editor = applicationContext.getSharedPreferences(str2, 0).edit();
        }
    }
}
