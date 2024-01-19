package com.google.crypto.tink.integration.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.android.material.resources.TextAppearanceConfig;
import java.io.CharConversionException;
import java.io.FileNotFoundException;
import java.io.IOException;

public final class SharedPrefKeysetReader {
    public final String keysetName;
    public final SharedPreferences sharedPreferences;

    public SharedPrefKeysetReader(Context context, String str, String str2) throws IOException {
        this.keysetName = str;
        Context applicationContext = context.getApplicationContext();
        if (str2 == null) {
            this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
        } else {
            this.sharedPreferences = applicationContext.getSharedPreferences(str2, 0);
        }
    }

    public final byte[] readPref() throws IOException {
        try {
            String string = this.sharedPreferences.getString(this.keysetName, null);
            if (string != null) {
                return TextAppearanceConfig.decode(string);
            }
            throw new FileNotFoundException(String.format("can't read keyset; the pref value %s does not exist", new Object[]{this.keysetName}));
        } catch (ClassCastException | IllegalArgumentException unused) {
            throw new CharConversionException(String.format("can't read keyset; the pref value %s is not a valid hex string", new Object[]{this.keysetName}));
        }
    }
}
