package org.eclipse.paho.android.service;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.paynimo.android.payment.util.Constant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.eclipse.paho.client.mqttv3.DisconnectedBufferOptions;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttClientPersistence;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;

@SuppressLint({"Registered"})
public class MqttService extends Service implements MqttTraceHandler {
    public static final String TAG = "MqttService";
    public volatile boolean backgroundDataEnabled = true;
    public BackgroundDataPreferenceReceiver backgroundDataPreferenceMonitor;
    public Map<String, MqttConnection> connections = new ConcurrentHashMap();
    public MessageStore messageStore;
    public MqttServiceBinder mqttServiceBinder;
    public NetworkConnectionIntentReceiver networkConnectionMonitor;
    public String traceCallbackId;
    public boolean traceEnabled = false;

    public class BackgroundDataPreferenceReceiver extends BroadcastReceiver {
        public BackgroundDataPreferenceReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            MqttService.this.traceDebug("MqttService", "Reconnect since BroadcastReceiver.");
            if (!((ConnectivityManager) MqttService.this.getSystemService("connectivity")).getBackgroundDataSetting()) {
                MqttService.this.backgroundDataEnabled = false;
                MqttService.this.notifyClientsOffline();
            } else if (!MqttService.this.backgroundDataEnabled) {
                MqttService.this.backgroundDataEnabled = true;
                MqttService.this.reconnect();
            }
        }
    }

    public class NetworkConnectionIntentReceiver extends BroadcastReceiver {
        public NetworkConnectionIntentReceiver() {
        }

        @SuppressLint({"Wakelock"})
        public void onReceive(Context context, Intent intent) {
            MqttService.this.traceDebug("MqttService", "Internal network status receive.");
            WakeLock newWakeLock = ((PowerManager) MqttService.this.getSystemService("power")).newWakeLock(1, "MQTT");
            newWakeLock.acquire();
            MqttService.this.traceDebug("MqttService", "Reconnect for Network recovery.");
            if (MqttService.this.isOnline()) {
                MqttService.this.traceDebug("MqttService", "Online,reconnect.");
                MqttService.this.reconnect();
            } else {
                MqttService.this.notifyClientsOffline();
            }
            newWakeLock.release();
        }
    }

    private MqttConnection getConnection(String str) {
        MqttConnection mqttConnection = this.connections.get(str);
        if (mqttConnection != null) {
            return mqttConnection;
        }
        throw new IllegalArgumentException("Invalid ClientHandle");
    }

    /* access modifiers changed from: private */
    public void notifyClientsOffline() {
        for (MqttConnection offline : this.connections.values()) {
            offline.offline();
        }
    }

    private void registerBroadcastReceivers() {
        if (this.networkConnectionMonitor == null) {
            NetworkConnectionIntentReceiver networkConnectionIntentReceiver = new NetworkConnectionIntentReceiver();
            this.networkConnectionMonitor = networkConnectionIntentReceiver;
            registerReceiver(networkConnectionIntentReceiver, new IntentFilter(Constant.INTENT_NETWORK_STATUS));
        }
    }

    private void traceCallback(String str, String str2, String str3) {
        if (this.traceCallbackId != null && this.traceEnabled) {
            Bundle bundle = new Bundle();
            bundle.putString(MqttServiceConstants.CALLBACK_ACTION, "trace");
            bundle.putString(MqttServiceConstants.CALLBACK_TRACE_SEVERITY, str);
            bundle.putString(MqttServiceConstants.CALLBACK_TRACE_TAG, str2);
            bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, str3);
            callbackToActivity(this.traceCallbackId, Status.ERROR, bundle);
        }
    }

    private void unregisterBroadcastReceivers() {
        NetworkConnectionIntentReceiver networkConnectionIntentReceiver = this.networkConnectionMonitor;
        if (networkConnectionIntentReceiver != null) {
            unregisterReceiver(networkConnectionIntentReceiver);
            this.networkConnectionMonitor = null;
        }
    }

    public Status acknowledgeMessageArrival(String str, String str2) {
        if (this.messageStore.discardArrived(str, str2)) {
            return Status.OK;
        }
        return Status.ERROR;
    }

    public void callbackToActivity(String str, Status status, Bundle bundle) {
        Intent intent = new Intent(MqttServiceConstants.CALLBACK_TO_ACTIVITY);
        if (str != null) {
            intent.putExtra(MqttServiceConstants.CALLBACK_CLIENT_HANDLE, str);
        }
        intent.putExtra(MqttServiceConstants.CALLBACK_STATUS, status);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    public void close(String str) {
        getConnection(str).close();
    }

    public void connect(String str, MqttConnectOptions mqttConnectOptions, String str2, String str3) throws MqttSecurityException, MqttException {
        getConnection(str).connect(mqttConnectOptions, null, str3);
    }

    public void deleteBufferedMessage(String str, int i) {
        getConnection(str).deleteBufferedMessage(i);
    }

    public void disconnect(String str, String str2, String str3) {
        getConnection(str).disconnect(str2, str3);
        this.connections.remove(str);
        stopSelf();
    }

    public MqttMessage getBufferedMessage(String str, int i) {
        return getConnection(str).getBufferedMessage(i);
    }

    public int getBufferedMessageCount(String str) {
        return getConnection(str).getBufferedMessageCount();
    }

    public String getClient(String str, String str2, String str3, MqttClientPersistence mqttClientPersistence) {
        String outline54 = GeneratedOutlineSupport.outline54(str, ":", str2, ":", str3);
        if (!this.connections.containsKey(outline54)) {
            MqttConnection mqttConnection = new MqttConnection(this, str, str2, mqttClientPersistence, outline54);
            this.connections.put(outline54, mqttConnection);
        }
        return outline54;
    }

    public IMqttDeliveryToken[] getPendingDeliveryTokens(String str) {
        return getConnection(str).getPendingDeliveryTokens();
    }

    public boolean isConnected(String str) {
        return getConnection(str).isConnected();
    }

    public boolean isOnline() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected() && this.backgroundDataEnabled;
    }

    public boolean isTraceEnabled() {
        return this.traceEnabled;
    }

    public IBinder onBind(Intent intent) {
        this.mqttServiceBinder.setActivityToken(intent.getStringExtra(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN));
        return this.mqttServiceBinder;
    }

    public void onCreate() {
        super.onCreate();
        this.mqttServiceBinder = new MqttServiceBinder(this);
        this.messageStore = new DatabaseMessageStore(this, this);
    }

    public void onDestroy() {
        for (MqttConnection disconnect : this.connections.values()) {
            disconnect.disconnect(null, null);
        }
        if (this.mqttServiceBinder != null) {
            this.mqttServiceBinder = null;
        }
        unregisterBroadcastReceivers();
        MessageStore messageStore2 = this.messageStore;
        if (messageStore2 != null) {
            messageStore2.close();
        }
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        registerBroadcastReceivers();
        return 1;
    }

    public IMqttDeliveryToken publish(String str, String str2, byte[] bArr, int i, boolean z, String str3, String str4) throws MqttPersistenceException, MqttException {
        return getConnection(str).publish(str2, bArr, i, z, str3, str4);
    }

    public void reconnect() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Reconnect to server, client size=");
        outline73.append(this.connections.size());
        traceDebug("MqttService", outline73.toString());
        for (MqttConnection next : this.connections.values()) {
            traceDebug("Reconnect Client:", next.getClientId() + '/' + next.getServerURI());
            if (isOnline()) {
                next.reconnect();
            }
        }
    }

    public void setBufferOpts(String str, DisconnectedBufferOptions disconnectedBufferOptions) {
        getConnection(str).setBufferOpts(disconnectedBufferOptions);
    }

    public void setTraceCallbackId(String str) {
        this.traceCallbackId = str;
    }

    public void setTraceEnabled(boolean z) {
        this.traceEnabled = z;
    }

    public void subscribe(String str, String str2, int i, String str3, String str4) {
        getConnection(str).subscribe(str2, i, str3, str4);
    }

    public void traceDebug(String str, String str2) {
        traceCallback("debug", str, str2);
    }

    public void traceError(String str, String str2) {
        traceCallback("error", str, str2);
    }

    public void traceException(String str, String str2, Exception exc) {
        if (this.traceCallbackId != null) {
            Bundle bundle = new Bundle();
            bundle.putString(MqttServiceConstants.CALLBACK_ACTION, "trace");
            bundle.putString(MqttServiceConstants.CALLBACK_TRACE_SEVERITY, MqttServiceConstants.TRACE_EXCEPTION);
            bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, str2);
            bundle.putSerializable(MqttServiceConstants.CALLBACK_EXCEPTION, exc);
            bundle.putString(MqttServiceConstants.CALLBACK_TRACE_TAG, str);
            callbackToActivity(this.traceCallbackId, Status.ERROR, bundle);
        }
    }

    public void unsubscribe(String str, String str2, String str3, String str4) {
        getConnection(str).unsubscribe(str2, str3, str4);
    }

    public IMqttDeliveryToken publish(String str, String str2, MqttMessage mqttMessage, String str3, String str4) throws MqttPersistenceException, MqttException {
        return getConnection(str).publish(str2, mqttMessage, str3, str4);
    }

    public void subscribe(String str, String[] strArr, int[] iArr, String str2, String str3) {
        getConnection(str).subscribe(strArr, iArr, str2, str3);
    }

    public void unsubscribe(String str, String[] strArr, String str2, String str3) {
        getConnection(str).unsubscribe(strArr, str2, str3);
    }

    public void disconnect(String str, long j, String str2, String str3) {
        getConnection(str).disconnect(j, str2, str3);
        this.connections.remove(str);
        stopSelf();
    }

    public void subscribe(String str, String[] strArr, int[] iArr, String str2, String str3, IMqttMessageListener[] iMqttMessageListenerArr) {
        getConnection(str).subscribe(strArr, iArr, str2, str3, iMqttMessageListenerArr);
    }
}
