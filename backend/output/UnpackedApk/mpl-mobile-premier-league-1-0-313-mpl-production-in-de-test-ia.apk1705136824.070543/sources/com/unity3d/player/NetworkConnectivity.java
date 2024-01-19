package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;

public class NetworkConnectivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    public final int f3380a = 0;

    /* renamed from: b  reason: collision with root package name */
    public final int f3381b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3382c;

    /* renamed from: d  reason: collision with root package name */
    public int f3383d;

    /* renamed from: e  reason: collision with root package name */
    public ConnectivityManager f3384e;

    /* renamed from: f  reason: collision with root package name */
    public final NetworkCallback f3385f;

    public NetworkConnectivity(Context context) {
        int i = 1;
        this.f3381b = 1;
        this.f3382c = 2;
        this.f3383d = 0;
        this.f3385f = new NetworkCallback() {
            public final void onAvailable(Network network) {
                super.onAvailable(network);
            }

            public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
                NetworkConnectivity networkConnectivity;
                int i;
                super.onCapabilitiesChanged(network, networkCapabilities);
                if (networkCapabilities.hasTransport(0)) {
                    networkConnectivity = NetworkConnectivity.this;
                    i = 1;
                } else {
                    networkConnectivity = NetworkConnectivity.this;
                    i = 2;
                }
                networkConnectivity.f3383d = i;
            }

            public final void onLost(Network network) {
                super.onLost(network);
                NetworkConnectivity.this.f3383d = 0;
            }

            public final void onUnavailable() {
                super.onUnavailable();
                NetworkConnectivity.this.f3383d = 0;
            }
        };
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        this.f3384e = connectivityManager;
        connectivityManager.registerDefaultNetworkCallback(this.f3385f);
        NetworkInfo activeNetworkInfo = this.f3384e.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            this.f3383d = activeNetworkInfo.getType() != 0 ? 2 : i;
        }
    }

    public final int a() {
        return this.f3383d;
    }

    public final void b() {
        this.f3384e.unregisterNetworkCallback(this.f3385f);
    }
}
