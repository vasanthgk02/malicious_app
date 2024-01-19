package com.reactnativecommunity.netinfo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;

public class AmazonFireDeviceConnectivityPoller {
    public final ConnectivityChangedCallback callback;
    public final Runnable checker = new PollerTask(null);
    public final Context context;
    public Handler handler;
    public boolean pollerRunning = false;
    public final Receiver receiver = new Receiver(null);

    public interface ConnectivityChangedCallback {
        void onAmazonFireDeviceConnectivityChanged(boolean z);
    }

    public class PollerTask implements Runnable {
        public PollerTask(AnonymousClass1 r2) {
        }

        public void run() {
            if (AmazonFireDeviceConnectivityPoller.this.pollerRunning) {
                AmazonFireDeviceConnectivityPoller.this.context.sendBroadcast(new Intent("com.amazon.tv.networkmonitor.CONNECTIVITY_CHECK"));
                AmazonFireDeviceConnectivityPoller amazonFireDeviceConnectivityPoller = AmazonFireDeviceConnectivityPoller.this;
                amazonFireDeviceConnectivityPoller.handler.postDelayed(amazonFireDeviceConnectivityPoller.checker, MqttAsyncClient.DISCONNECT_TIMEOUT);
            }
        }
    }

    public class Receiver extends BroadcastReceiver {
        public Boolean lastIsConnected;
        public boolean registered = false;

        public Receiver(AnonymousClass1 r2) {
        }

        public void onReceive(Context context, Intent intent) {
            boolean z;
            String action = intent == null ? null : intent.getAction();
            if ("com.amazon.tv.networkmonitor.INTERNET_DOWN".equals(action)) {
                z = false;
            } else if ("com.amazon.tv.networkmonitor.INTERNET_UP".equals(action)) {
                z = true;
            } else {
                return;
            }
            Boolean bool = this.lastIsConnected;
            if (bool == null || bool.booleanValue() != z) {
                this.lastIsConnected = Boolean.valueOf(z);
                AmazonFireDeviceConnectivityPoller.this.callback.onAmazonFireDeviceConnectivityChanged(z);
            }
        }
    }

    public AmazonFireDeviceConnectivityPoller(Context context2, ConnectivityChangedCallback connectivityChangedCallback) {
        this.context = context2;
        this.callback = connectivityChangedCallback;
    }

    public final boolean isFireOsDevice() {
        return Build.MANUFACTURER.equals("Amazon") && (Build.MODEL.startsWith("AF") || Build.MODEL.startsWith("KF"));
    }
}
