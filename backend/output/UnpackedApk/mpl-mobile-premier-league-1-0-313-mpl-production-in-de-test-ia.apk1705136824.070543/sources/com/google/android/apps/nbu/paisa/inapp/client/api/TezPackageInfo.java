package com.google.android.apps.nbu.paisa.inapp.client.api;

import android.content.Context;
import android.util.Base64;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TezPackageInfo {
    public final long minimumTezSdkVersion;
    public final String packageName;
    public final byte[] signatureHash;

    public TezPackageInfo(Context context, int i) {
        InputStream openRawResource = context.getResources().openRawResource(i);
        Properties properties = new Properties();
        try {
            properties.load(openRawResource);
            Long.parseLong(properties.getProperty("config_version"));
            this.packageName = properties.getProperty("package_name");
            this.signatureHash = Base64.decode(properties.getProperty("signature_hash"), 0);
            this.minimumTezSdkVersion = Long.parseLong(properties.getProperty("minimum_tez_sdk_version"));
            if (this.packageName.isEmpty() || this.signatureHash.length < 1) {
                throw new IllegalArgumentException("Invalid Tez InApp API configuration");
            }
        } catch (IOException | IllegalArgumentException e2) {
            throw new IllegalArgumentException("Invalid Tez InApp API configuration", e2);
        }
    }
}
