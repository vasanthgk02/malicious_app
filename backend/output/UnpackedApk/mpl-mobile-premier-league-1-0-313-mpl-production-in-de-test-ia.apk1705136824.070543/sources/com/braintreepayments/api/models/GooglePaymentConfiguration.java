package com.braintreepayments.api.models;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.wallet.Wallet;

public class GooglePaymentConfiguration {
    public boolean mEnabled;
    public String mEnvironment;
    public String mGoogleAuthorizationFingerprint;
    public String mPayPalClientId;
    public String[] mSupportedNetworks;

    public boolean isEnabled(Context context) {
        try {
            Class.forName(Wallet.class.getName());
            if (!this.mEnabled || GoogleApiAvailability.zab.isGooglePlayServicesAvailable(context, GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE) != 0) {
                return false;
            }
            return true;
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
            return false;
        }
    }
}
