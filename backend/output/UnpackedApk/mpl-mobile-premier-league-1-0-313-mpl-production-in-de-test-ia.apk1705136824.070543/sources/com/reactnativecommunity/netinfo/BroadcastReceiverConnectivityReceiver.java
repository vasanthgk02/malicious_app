package com.reactnativecommunity.netinfo;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import com.facebook.react.bridge.ReactApplicationContext;
import com.paynimo.android.payment.util.Constant;
import com.reactnativecommunity.netinfo.types.CellularGeneration;
import com.reactnativecommunity.netinfo.types.ConnectionType;

public class BroadcastReceiverConnectivityReceiver extends ConnectivityReceiver {
    public final ConnectivityBroadcastReceiver mConnectivityBroadcastReceiver = new ConnectivityBroadcastReceiver(null);

    public class ConnectivityBroadcastReceiver extends BroadcastReceiver {
        public boolean isRegistered = false;

        public ConnectivityBroadcastReceiver(AnonymousClass1 r2) {
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action != null && action.equals(Constant.INTENT_NETWORK_STATUS)) {
                BroadcastReceiverConnectivityReceiver.this.updateAndSendConnectionType();
            }
        }
    }

    public BroadcastReceiverConnectivityReceiver(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public void register() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Constant.INTENT_NETWORK_STATUS);
        this.mReactContext.registerReceiver(this.mConnectivityBroadcastReceiver, intentFilter);
        this.mConnectivityBroadcastReceiver.isRegistered = true;
        updateAndSendConnectionType();
    }

    public void unregister() {
        ConnectivityBroadcastReceiver connectivityBroadcastReceiver = this.mConnectivityBroadcastReceiver;
        if (connectivityBroadcastReceiver.isRegistered) {
            this.mReactContext.unregisterReceiver(connectivityBroadcastReceiver);
            this.mConnectivityBroadcastReceiver.isRegistered = false;
        }
    }

    @SuppressLint({"MissingPermission"})
    public final void updateAndSendConnectionType() {
        ConnectionType connectionType = ConnectionType.UNKNOWN;
        CellularGeneration cellularGeneration = null;
        boolean z = false;
        try {
            NetworkInfo activeNetworkInfo = this.mConnectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isConnected()) {
                    z = activeNetworkInfo.isConnected();
                    int type = activeNetworkInfo.getType();
                    if (type != 0) {
                        if (type == 1) {
                            connectionType = ConnectionType.WIFI;
                        } else if (type != 4) {
                            if (type == 9) {
                                connectionType = ConnectionType.ETHERNET;
                            } else if (type == 17) {
                                connectionType = ConnectionType.VPN;
                            } else if (type == 6) {
                                connectionType = ConnectionType.WIMAX;
                            } else if (type == 7) {
                                connectionType = ConnectionType.BLUETOOTH;
                            }
                        }
                        updateConnectivity(connectionType, cellularGeneration, z);
                    }
                    connectionType = ConnectionType.CELLULAR;
                    cellularGeneration = CellularGeneration.fromNetworkInfo(activeNetworkInfo);
                    updateConnectivity(connectionType, cellularGeneration, z);
                }
            }
            connectionType = ConnectionType.NONE;
        } catch (SecurityException unused) {
            connectionType = ConnectionType.UNKNOWN;
        }
        updateConnectivity(connectionType, cellularGeneration, z);
    }
}
