package com.mpl.androidapp.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import android.net.NetworkRequest;
import android.net.NetworkRequest.Builder;
import android.os.Build.VERSION;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0012B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0006\u0010\u0011\u001a\u00020\rR\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/mpl/androidapp/utils/NetworkMonitorUtil;", "Landroid/net/ConnectivityManager$NetworkCallback;", "context", "Landroid/content/Context;", "change", "Lcom/mpl/androidapp/utils/NetworkMonitorUtil$NetworkStateChange;", "(Landroid/content/Context;Lcom/mpl/androidapp/utils/NetworkMonitorUtil$NetworkStateChange;)V", "mConnectivityManager", "Landroid/net/ConnectivityManager;", "mNetworkRequest", "Landroid/net/NetworkRequest;", "mStateChanged", "onAvailable", "", "network", "Landroid/net/Network;", "onLost", "registerNetworkCallbackEvents", "NetworkStateChange", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NetworkMonitorUtil.kt */
public final class NetworkMonitorUtil extends NetworkCallback {
    public final ConnectivityManager mConnectivityManager;
    public final NetworkRequest mNetworkRequest;
    public final NetworkStateChange mStateChanged;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/mpl/androidapp/utils/NetworkMonitorUtil$NetworkStateChange;", "", "onNetworkStateChange", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: NetworkMonitorUtil.kt */
    public interface NetworkStateChange {
        void onNetworkStateChange();
    }

    public NetworkMonitorUtil(Context context, NetworkStateChange networkStateChange) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(networkStateChange, "change");
        NetworkRequest build = new Builder().addTransportType(0).addTransportType(1).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n        .addTr…RT_WIFI)\n        .build()");
        this.mNetworkRequest = build;
        Object systemService = context.getSystemService("connectivity");
        if (systemService != null) {
            this.mConnectivityManager = (ConnectivityManager) systemService;
            this.mStateChanged = networkStateChange;
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
    }

    public void onAvailable(Network network) {
        Intrinsics.checkNotNullParameter(network, "network");
        super.onAvailable(network);
        this.mStateChanged.onNetworkStateChange();
    }

    public void onLost(Network network) {
        Intrinsics.checkNotNullParameter(network, "network");
        super.onLost(network);
    }

    public final void registerNetworkCallbackEvents() {
        try {
            this.mConnectivityManager.registerNetworkCallback(this.mNetworkRequest, this);
        } catch (Exception unused) {
            if (VERSION.SDK_INT >= 31) {
                this.mConnectivityManager.registerNetworkCallback(this.mNetworkRequest, this);
            }
        }
    }
}
