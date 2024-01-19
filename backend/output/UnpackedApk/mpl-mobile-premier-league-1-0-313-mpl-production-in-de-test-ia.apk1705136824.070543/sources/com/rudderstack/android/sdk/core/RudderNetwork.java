package com.rudderstack.android.sdk.core;

import android.annotation.SuppressLint;
import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.net.wifi.WifiManager;
import android.provider.Settings.Global;
import android.telephony.TelephonyManager;
import com.google.gson.annotations.SerializedName;
import com.razorpay.AnalyticsConstants;
import com.rudderstack.android.sdk.core.util.Utils;

public class RudderNetwork {
    @SerializedName("carrier")
    public String carrier;
    @SerializedName("bluetooth")
    public boolean isBluetoothEnabled = false;
    @SerializedName("cellular")
    public boolean isCellularEnabled = false;
    @SerializedName("wifi")
    public boolean isWifiEnabled = false;

    @SuppressLint({"MissingPermission"})
    public RudderNetwork(Application application) {
        boolean z = false;
        try {
            if (!Utils.isTv(application)) {
                TelephonyManager telephonyManager = (TelephonyManager) application.getSystemService("phone");
                this.carrier = telephonyManager != null ? telephonyManager.getNetworkOperatorName() : AnalyticsConstants.NOT_AVAILABLE;
            }
            WifiManager wifiManager = (WifiManager) application.getSystemService(AnalyticsConstants.WIFI);
            this.isWifiEnabled = wifiManager != null && wifiManager.isWifiEnabled();
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            this.isBluetoothEnabled = defaultAdapter != null && defaultAdapter.isEnabled() && defaultAdapter.getState() == 12;
            TelephonyManager telephonyManager2 = (TelephonyManager) application.getSystemService("phone");
            if (telephonyManager2 != null && telephonyManager2.getSimState() == 5) {
                this.isCellularEnabled = Global.getInt(application.getContentResolver(), "mobile_data", 1) == 1 ? true : z;
            }
        } catch (SecurityException unused) {
            RudderLogger.logWarn("RudderNetwork: Missing Bluetooth/Wifi Permissions in the app");
            RudderLogger.logWarn("RudderNetwork: Bluetooth/Wifi status will be set to false");
        } catch (Exception e2) {
            RudderLogger.logError(e2);
        }
    }
}
