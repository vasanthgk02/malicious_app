package com.reactnativecommunity.netinfo;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import com.facebook.react.bridge.ReactApplicationContext;
import com.reactnativecommunity.netinfo.types.CellularGeneration;
import com.reactnativecommunity.netinfo.types.ConnectionType;

@TargetApi(24)
public class NetworkCallbackConnectivityReceiver extends ConnectivityReceiver {
    public Network mNetwork = null;
    public final ConnectivityNetworkCallback mNetworkCallback = new ConnectivityNetworkCallback(null);
    public NetworkCapabilities mNetworkCapabilities = null;

    public class ConnectivityNetworkCallback extends NetworkCallback {
        public ConnectivityNetworkCallback(AnonymousClass1 r2) {
        }

        public void onAvailable(Network network) {
            NetworkCallbackConnectivityReceiver networkCallbackConnectivityReceiver = NetworkCallbackConnectivityReceiver.this;
            networkCallbackConnectivityReceiver.mNetwork = network;
            networkCallbackConnectivityReceiver.mNetworkCapabilities = networkCallbackConnectivityReceiver.mConnectivityManager.getNetworkCapabilities(network);
            NetworkCallbackConnectivityReceiver.access$300(NetworkCallbackConnectivityReceiver.this);
        }

        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            NetworkCallbackConnectivityReceiver networkCallbackConnectivityReceiver = NetworkCallbackConnectivityReceiver.this;
            networkCallbackConnectivityReceiver.mNetwork = network;
            networkCallbackConnectivityReceiver.mNetworkCapabilities = networkCapabilities;
            NetworkCallbackConnectivityReceiver.access$300(networkCallbackConnectivityReceiver);
        }

        public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
            NetworkCallbackConnectivityReceiver networkCallbackConnectivityReceiver = NetworkCallbackConnectivityReceiver.this;
            networkCallbackConnectivityReceiver.mNetwork = network;
            networkCallbackConnectivityReceiver.mNetworkCapabilities = networkCallbackConnectivityReceiver.mConnectivityManager.getNetworkCapabilities(network);
            NetworkCallbackConnectivityReceiver.access$300(NetworkCallbackConnectivityReceiver.this);
        }

        public void onLosing(Network network, int i) {
            NetworkCallbackConnectivityReceiver networkCallbackConnectivityReceiver = NetworkCallbackConnectivityReceiver.this;
            networkCallbackConnectivityReceiver.mNetwork = network;
            networkCallbackConnectivityReceiver.mNetworkCapabilities = networkCallbackConnectivityReceiver.mConnectivityManager.getNetworkCapabilities(network);
            NetworkCallbackConnectivityReceiver.access$300(NetworkCallbackConnectivityReceiver.this);
        }

        public void onLost(Network network) {
            NetworkCallbackConnectivityReceiver networkCallbackConnectivityReceiver = NetworkCallbackConnectivityReceiver.this;
            networkCallbackConnectivityReceiver.mNetwork = null;
            networkCallbackConnectivityReceiver.mNetworkCapabilities = null;
            NetworkCallbackConnectivityReceiver.access$300(networkCallbackConnectivityReceiver);
        }

        public void onUnavailable() {
            NetworkCallbackConnectivityReceiver networkCallbackConnectivityReceiver = NetworkCallbackConnectivityReceiver.this;
            networkCallbackConnectivityReceiver.mNetwork = null;
            networkCallbackConnectivityReceiver.mNetworkCapabilities = null;
            NetworkCallbackConnectivityReceiver.access$300(networkCallbackConnectivityReceiver);
        }
    }

    public NetworkCallbackConnectivityReceiver(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public static void access$300(NetworkCallbackConnectivityReceiver networkCallbackConnectivityReceiver) {
        CellularGeneration cellularGeneration = null;
        if (networkCallbackConnectivityReceiver != null) {
            ConnectionType connectionType = ConnectionType.UNKNOWN;
            NetworkCapabilities networkCapabilities = networkCallbackConnectivityReceiver.mNetworkCapabilities;
            boolean z = false;
            if (networkCapabilities != null) {
                if (networkCapabilities.hasTransport(2)) {
                    connectionType = ConnectionType.BLUETOOTH;
                } else if (networkCallbackConnectivityReceiver.mNetworkCapabilities.hasTransport(0)) {
                    connectionType = ConnectionType.CELLULAR;
                } else if (networkCallbackConnectivityReceiver.mNetworkCapabilities.hasTransport(3)) {
                    connectionType = ConnectionType.ETHERNET;
                } else if (networkCallbackConnectivityReceiver.mNetworkCapabilities.hasTransport(1)) {
                    connectionType = ConnectionType.WIFI;
                } else if (networkCallbackConnectivityReceiver.mNetworkCapabilities.hasTransport(4)) {
                    connectionType = ConnectionType.VPN;
                }
                if (networkCallbackConnectivityReceiver.mNetworkCapabilities.hasCapability(12) && networkCallbackConnectivityReceiver.mNetworkCapabilities.hasCapability(16)) {
                    z = true;
                }
                Network network = networkCallbackConnectivityReceiver.mNetwork;
                if (network != null && connectionType == ConnectionType.CELLULAR) {
                    cellularGeneration = CellularGeneration.fromNetworkInfo(networkCallbackConnectivityReceiver.mConnectivityManager.getNetworkInfo(network));
                }
            } else {
                connectionType = ConnectionType.NONE;
            }
            networkCallbackConnectivityReceiver.updateConnectivity(connectionType, cellularGeneration, z);
            return;
        }
        throw null;
    }

    @SuppressLint({"MissingPermission"})
    public void register() {
        try {
            this.mConnectivityManager.registerDefaultNetworkCallback(this.mNetworkCallback);
        } catch (SecurityException unused) {
        }
    }

    public void unregister() {
        try {
            this.mConnectivityManager.unregisterNetworkCallback(this.mNetworkCallback);
        } catch (IllegalArgumentException | SecurityException unused) {
        }
    }
}
