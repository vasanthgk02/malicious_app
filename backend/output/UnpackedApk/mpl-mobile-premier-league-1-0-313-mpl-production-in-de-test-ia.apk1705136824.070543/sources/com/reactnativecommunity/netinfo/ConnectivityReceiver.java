package com.reactnativecommunity.netinfo;

import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.razorpay.AnalyticsConstants;
import com.reactnativecommunity.netinfo.types.CellularGeneration;
import com.reactnativecommunity.netinfo.types.ConnectionType;

public abstract class ConnectivityReceiver {
    public CellularGeneration mCellularGeneration = null;
    public ConnectionType mConnectionType = ConnectionType.UNKNOWN;
    public final ConnectivityManager mConnectivityManager;
    public boolean mIsInternetReachable = false;
    public Boolean mIsInternetReachableOverride;
    public final ReactApplicationContext mReactContext;
    public final TelephonyManager mTelephonyManager;
    public final WifiManager mWifiManager;

    public ConnectivityReceiver(ReactApplicationContext reactApplicationContext) {
        this.mReactContext = reactApplicationContext;
        this.mConnectivityManager = (ConnectivityManager) reactApplicationContext.getSystemService("connectivity");
        this.mWifiManager = (WifiManager) reactApplicationContext.getApplicationContext().getSystemService(AnalyticsConstants.WIFI);
        this.mTelephonyManager = (TelephonyManager) reactApplicationContext.getSystemService("phone");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:20|21|(1:25)|26|27|28|29|30|31) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0097 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x00a6 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x00c3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.facebook.react.bridge.WritableMap createConnectivityEventMap() {
        /*
            r8 = this;
            com.facebook.react.bridge.WritableNativeMap r0 = new com.facebook.react.bridge.WritableNativeMap
            r0.<init>()
            com.reactnativecommunity.netinfo.types.ConnectionType r1 = r8.mConnectionType
            java.lang.String r1 = r1.label
            java.lang.String r2 = "type"
            r0.putString(r2, r1)
            com.reactnativecommunity.netinfo.types.ConnectionType r1 = r8.mConnectionType
            com.reactnativecommunity.netinfo.types.ConnectionType r2 = com.reactnativecommunity.netinfo.types.ConnectionType.NONE
            boolean r1 = r1.equals(r2)
            r2 = 0
            r3 = 1
            if (r1 != 0) goto L_0x0026
            com.reactnativecommunity.netinfo.types.ConnectionType r1 = r8.mConnectionType
            com.reactnativecommunity.netinfo.types.ConnectionType r4 = com.reactnativecommunity.netinfo.types.ConnectionType.UNKNOWN
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x0026
            r1 = 1
            goto L_0x0027
        L_0x0026:
            r1 = 0
        L_0x0027:
            java.lang.String r4 = "isConnected"
            r0.putBoolean(r4, r1)
            boolean r4 = r8.mIsInternetReachable
            java.lang.String r5 = "isInternetReachable"
            r0.putBoolean(r5, r4)
            r4 = 0
            if (r1 == 0) goto L_0x0124
            com.facebook.react.bridge.WritableNativeMap r4 = new com.facebook.react.bridge.WritableNativeMap
            r4.<init>()
            android.net.ConnectivityManager r1 = r8.mConnectivityManager
            boolean r1 = r1.isActiveNetworkMetered()
            java.lang.String r5 = "isConnectionExpensive"
            r4.putBoolean(r5, r1)
            com.reactnativecommunity.netinfo.types.ConnectionType r1 = r8.mConnectionType
            com.reactnativecommunity.netinfo.types.ConnectionType r5 = com.reactnativecommunity.netinfo.types.ConnectionType.CELLULAR
            boolean r1 = r1.equals(r5)
            if (r1 == 0) goto L_0x006a
            com.reactnativecommunity.netinfo.types.CellularGeneration r1 = r8.mCellularGeneration
            if (r1 == 0) goto L_0x005b
            java.lang.String r1 = r1.label
            java.lang.String r2 = "cellularGeneration"
            r4.putString(r2, r1)
        L_0x005b:
            android.telephony.TelephonyManager r1 = r8.mTelephonyManager
            java.lang.String r1 = r1.getNetworkOperatorName()
            if (r1 == 0) goto L_0x0124
            java.lang.String r2 = "carrier"
            r4.putString(r2, r1)
            goto L_0x0124
        L_0x006a:
            com.reactnativecommunity.netinfo.types.ConnectionType r1 = r8.mConnectionType
            com.reactnativecommunity.netinfo.types.ConnectionType r5 = com.reactnativecommunity.netinfo.types.ConnectionType.WIFI
            boolean r1 = r1.equals(r5)
            if (r1 == 0) goto L_0x0124
            android.net.wifi.WifiManager r1 = r8.mWifiManager
            android.net.wifi.WifiInfo r1 = r1.getConnectionInfo()
            if (r1 == 0) goto L_0x0124
            java.lang.String r5 = r1.getSSID()     // Catch:{ Exception -> 0x0097 }
            if (r5 == 0) goto L_0x0097
            java.lang.String r6 = "<unknown ssid>"
            boolean r6 = r5.contains(r6)     // Catch:{ Exception -> 0x0097 }
            if (r6 != 0) goto L_0x0097
            java.lang.String r6 = "\""
            java.lang.String r7 = ""
            java.lang.String r5 = r5.replace(r6, r7)     // Catch:{ Exception -> 0x0097 }
            java.lang.String r6 = "ssid"
            r4.putString(r6, r5)     // Catch:{ Exception -> 0x0097 }
        L_0x0097:
            int r5 = r1.getRssi()     // Catch:{ Exception -> 0x00a6 }
            r6 = 100
            int r5 = android.net.wifi.WifiManager.calculateSignalLevel(r5, r6)     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r6 = "strength"
            r4.putInt(r6, r5)     // Catch:{ Exception -> 0x00a6 }
        L_0x00a6:
            int r5 = r1.getIpAddress()     // Catch:{ Exception -> 0x00c3 }
            long r5 = (long) r5     // Catch:{ Exception -> 0x00c3 }
            java.math.BigInteger r5 = java.math.BigInteger.valueOf(r5)     // Catch:{ Exception -> 0x00c3 }
            byte[] r5 = r5.toByteArray()     // Catch:{ Exception -> 0x00c3 }
            com.google.android.material.resources.TextAppearanceConfig.reverseByteArray(r5)     // Catch:{ Exception -> 0x00c3 }
            java.net.InetAddress r5 = java.net.InetAddress.getByAddress(r5)     // Catch:{ Exception -> 0x00c3 }
            java.lang.String r5 = r5.getHostAddress()     // Catch:{ Exception -> 0x00c3 }
            java.lang.String r6 = "ipAddress"
            r4.putString(r6, r5)     // Catch:{ Exception -> 0x00c3 }
        L_0x00c3:
            int r1 = r1.getIpAddress()     // Catch:{ Exception -> 0x0124 }
            long r5 = (long) r1     // Catch:{ Exception -> 0x0124 }
            java.math.BigInteger r1 = java.math.BigInteger.valueOf(r5)     // Catch:{ Exception -> 0x0124 }
            byte[] r1 = r1.toByteArray()     // Catch:{ Exception -> 0x0124 }
            com.google.android.material.resources.TextAppearanceConfig.reverseByteArray(r1)     // Catch:{ Exception -> 0x0124 }
            java.net.InetAddress r1 = java.net.InetAddress.getByAddress(r1)     // Catch:{ Exception -> 0x0124 }
            java.net.NetworkInterface r1 = java.net.NetworkInterface.getByInetAddress(r1)     // Catch:{ Exception -> 0x0124 }
            r5 = -1
            java.util.List r1 = r1.getInterfaceAddresses()     // Catch:{ Exception -> 0x0124 }
            java.lang.Object r1 = r1.get(r3)     // Catch:{ Exception -> 0x0124 }
            java.net.InterfaceAddress r1 = (java.net.InterfaceAddress) r1     // Catch:{ Exception -> 0x0124 }
            short r1 = r1.getNetworkPrefixLength()     // Catch:{ Exception -> 0x0124 }
            int r1 = 32 - r1
            int r1 = r5 << r1
            java.lang.String r5 = "%d.%d.%d.%d"
            r6 = 4
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x0124 }
            int r7 = r1 >> 24
            r7 = r7 & 255(0xff, float:3.57E-43)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ Exception -> 0x0124 }
            r6[r2] = r7     // Catch:{ Exception -> 0x0124 }
            int r2 = r1 >> 16
            r2 = r2 & 255(0xff, float:3.57E-43)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x0124 }
            r6[r3] = r2     // Catch:{ Exception -> 0x0124 }
            r2 = 2
            int r3 = r1 >> 8
            r3 = r3 & 255(0xff, float:3.57E-43)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0124 }
            r6[r2] = r3     // Catch:{ Exception -> 0x0124 }
            r2 = 3
            r1 = r1 & 255(0xff, float:3.57E-43)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x0124 }
            r6[r2] = r1     // Catch:{ Exception -> 0x0124 }
            java.lang.String r1 = java.lang.String.format(r5, r6)     // Catch:{ Exception -> 0x0124 }
            java.lang.String r2 = "subnet"
            r4.putString(r2, r1)     // Catch:{ Exception -> 0x0124 }
        L_0x0124:
            java.lang.String r1 = "details"
            r0.putMap(r1, r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativecommunity.netinfo.ConnectivityReceiver.createConnectivityEventMap():com.facebook.react.bridge.WritableMap");
    }

    public abstract void register();

    public abstract void unregister();

    public void updateConnectivity(ConnectionType connectionType, CellularGeneration cellularGeneration, boolean z) {
        Boolean bool = this.mIsInternetReachableOverride;
        if (bool != null) {
            z = bool.booleanValue();
        }
        boolean z2 = true;
        boolean z3 = connectionType != this.mConnectionType;
        boolean z4 = cellularGeneration != this.mCellularGeneration;
        if (z == this.mIsInternetReachable) {
            z2 = false;
        }
        if (z3 || z4 || z2) {
            this.mConnectionType = connectionType;
            this.mCellularGeneration = cellularGeneration;
            this.mIsInternetReachable = z;
            ((RCTDeviceEventEmitter) this.mReactContext.getJSModule(RCTDeviceEventEmitter.class)).emit("netInfo.networkStatusDidChange", createConnectivityEventMap());
        }
    }
}
