package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import co.hyperverge.hypersnapsdk.c.k;
import com.bumptech.glide.manager.ConnectivityMonitor.ConnectivityListener;
import com.paynimo.android.payment.util.Constant;

public final class DefaultConnectivityMonitor implements ConnectivityMonitor {
    public final BroadcastReceiver connectivityReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            DefaultConnectivityMonitor defaultConnectivityMonitor = DefaultConnectivityMonitor.this;
            boolean z = defaultConnectivityMonitor.isConnected;
            defaultConnectivityMonitor.isConnected = defaultConnectivityMonitor.isConnected(context);
            if (z != DefaultConnectivityMonitor.this.isConnected) {
                if (Log.isLoggable("ConnectivityMonitor", 3)) {
                    boolean z2 = DefaultConnectivityMonitor.this.isConnected;
                }
                DefaultConnectivityMonitor defaultConnectivityMonitor2 = DefaultConnectivityMonitor.this;
                defaultConnectivityMonitor2.listener.onConnectivityChanged(defaultConnectivityMonitor2.isConnected);
            }
        }
    };
    public final Context context;
    public boolean isConnected;
    public boolean isRegistered;
    public final ConnectivityListener listener;

    public DefaultConnectivityMonitor(Context context2, ConnectivityListener connectivityListener) {
        this.context = context2.getApplicationContext();
        this.listener = connectivityListener;
    }

    @SuppressLint({"MissingPermission"})
    public boolean isConnected(Context context2) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context2.getSystemService("connectivity");
        k.checkNotNull(connectivityManager, (String) "Argument must not be null");
        boolean z = true;
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                z = false;
            }
            return z;
        } catch (RuntimeException unused) {
            boolean isLoggable = Log.isLoggable("ConnectivityMonitor", 5);
            return true;
        }
    }

    public void onDestroy() {
    }

    public void onStart() {
        if (!this.isRegistered) {
            this.isConnected = isConnected(this.context);
            try {
                this.context.registerReceiver(this.connectivityReceiver, new IntentFilter(Constant.INTENT_NETWORK_STATUS));
                this.isRegistered = true;
            } catch (SecurityException unused) {
                Log.isLoggable("ConnectivityMonitor", 5);
            }
        }
    }

    public void onStop() {
        if (this.isRegistered) {
            this.context.unregisterReceiver(this.connectivityReceiver);
            this.isRegistered = false;
        }
    }
}
