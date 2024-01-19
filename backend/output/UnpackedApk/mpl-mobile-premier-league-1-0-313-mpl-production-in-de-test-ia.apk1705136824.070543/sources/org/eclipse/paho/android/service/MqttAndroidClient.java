package org.eclipse.paho.android.service;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.SparseArray;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import org.eclipse.paho.client.mqttv3.DisconnectedBufferOptions;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttAsyncClient;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttClientPersistence;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;

public class MqttAndroidClient extends BroadcastReceiver implements IMqttAsyncClient {
    public static final int BIND_SERVICE_FLAG = 0;
    public static final String SERVICE_NAME = "org.eclipse.paho.android.service.MqttService";
    public static final ExecutorService pool = Executors.newCachedThreadPool();
    public volatile boolean bindedService;
    public MqttCallback callback;
    public String clientHandle;
    public final String clientId;
    public MqttConnectOptions connectOptions;
    public IMqttToken connectToken;
    public final Ack messageAck;
    public MqttService mqttService;
    public Context myContext;
    public MqttClientPersistence persistence;
    public volatile boolean receiverRegistered;
    public final String serverURI;
    public final MyServiceConnection serviceConnection;
    public final SparseArray<IMqttToken> tokenMap;
    public int tokenNumber;
    public MqttTraceHandler traceCallback;
    public boolean traceEnabled;

    public enum Ack {
        AUTO_ACK,
        MANUAL_ACK
    }

    public final class MyServiceConnection implements ServiceConnection {
        public MyServiceConnection() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MqttAndroidClient.this.mqttService = ((MqttServiceBinder) iBinder).getService();
            MqttAndroidClient.this.bindedService = true;
            MqttAndroidClient.this.doConnect();
        }

        public void onServiceDisconnected(ComponentName componentName) {
            MqttAndroidClient.this.mqttService = null;
        }
    }

    public MqttAndroidClient(Context context, String str, String str2) {
        this(context, str, str2, null, Ack.AUTO_ACK);
    }

    private void connectAction(Bundle bundle) {
        IMqttToken iMqttToken = this.connectToken;
        removeMqttToken(bundle);
        simpleAction(iMqttToken, bundle);
    }

    private void connectExtendedAction(Bundle bundle) {
        if (this.callback instanceof MqttCallbackExtended) {
            ((MqttCallbackExtended) this.callback).connectComplete(bundle.getBoolean(MqttServiceConstants.CALLBACK_RECONNECT, false), bundle.getString(MqttServiceConstants.CALLBACK_SERVER_URI));
        }
    }

    private void connectionLostAction(Bundle bundle) {
        if (this.callback != null) {
            this.callback.connectionLost((Exception) bundle.getSerializable(MqttServiceConstants.CALLBACK_EXCEPTION));
        }
    }

    private void disconnected(Bundle bundle) {
        this.clientHandle = null;
        IMqttToken removeMqttToken = removeMqttToken(bundle);
        if (removeMqttToken != null) {
            ((MqttTokenAndroid) removeMqttToken).notifyComplete();
        }
        MqttCallback mqttCallback = this.callback;
        if (mqttCallback != null) {
            mqttCallback.connectionLost(null);
        }
    }

    /* access modifiers changed from: private */
    public void doConnect() {
        if (this.clientHandle == null) {
            this.clientHandle = this.mqttService.getClient(this.serverURI, this.clientId, this.myContext.getApplicationInfo().packageName, this.persistence);
        }
        this.mqttService.setTraceEnabled(this.traceEnabled);
        this.mqttService.setTraceCallbackId(this.clientHandle);
        try {
            this.mqttService.connect(this.clientHandle, this.connectOptions, null, storeToken(this.connectToken));
        } catch (MqttException e2) {
            IMqttActionListener actionCallback = this.connectToken.getActionCallback();
            if (actionCallback != null) {
                actionCallback.onFailure(this.connectToken, e2);
            }
        }
    }

    private synchronized IMqttToken getMqttToken(Bundle bundle) {
        return this.tokenMap.get(Integer.parseInt(bundle.getString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN)));
    }

    private void messageArrivedAction(Bundle bundle) {
        if (this.callback != null) {
            String string = bundle.getString(MqttServiceConstants.CALLBACK_MESSAGE_ID);
            String string2 = bundle.getString(MqttServiceConstants.CALLBACK_DESTINATION_NAME);
            ParcelableMqttMessage parcelableMqttMessage = (ParcelableMqttMessage) bundle.getParcelable(MqttServiceConstants.CALLBACK_MESSAGE_PARCEL);
            try {
                if (this.messageAck == Ack.AUTO_ACK) {
                    this.callback.messageArrived(string2, parcelableMqttMessage);
                    this.mqttService.acknowledgeMessageArrival(this.clientHandle, string);
                    return;
                }
                parcelableMqttMessage.messageId = string;
                this.callback.messageArrived(string2, parcelableMqttMessage);
            } catch (Exception unused) {
            }
        }
    }

    private void messageDeliveredAction(Bundle bundle) {
        IMqttToken removeMqttToken = removeMqttToken(bundle);
        if (removeMqttToken != null && this.callback != null && ((Status) bundle.getSerializable(MqttServiceConstants.CALLBACK_STATUS)) == Status.OK && (removeMqttToken instanceof IMqttDeliveryToken)) {
            this.callback.deliveryComplete((IMqttDeliveryToken) removeMqttToken);
        }
    }

    /* access modifiers changed from: private */
    public void registerReceiver(BroadcastReceiver broadcastReceiver) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(MqttServiceConstants.CALLBACK_TO_ACTIVITY);
        LocalBroadcastManager.getInstance(this.myContext).registerReceiver(broadcastReceiver, intentFilter);
        this.receiverRegistered = true;
    }

    private synchronized IMqttToken removeMqttToken(Bundle bundle) {
        String string = bundle.getString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN);
        if (string == null) {
            return null;
        }
        int parseInt = Integer.parseInt(string);
        IMqttToken iMqttToken = this.tokenMap.get(parseInt);
        this.tokenMap.delete(parseInt);
        return iMqttToken;
    }

    private void sendAction(Bundle bundle) {
        simpleAction(getMqttToken(bundle), bundle);
    }

    private void simpleAction(IMqttToken iMqttToken, Bundle bundle) {
        if (iMqttToken == null) {
            this.mqttService.traceError("MqttService", "simpleAction : token is null");
        } else if (((Status) bundle.getSerializable(MqttServiceConstants.CALLBACK_STATUS)) == Status.OK) {
            ((MqttTokenAndroid) iMqttToken).notifyComplete();
        } else {
            ((MqttTokenAndroid) iMqttToken).notifyFailure((Exception) bundle.getSerializable(MqttServiceConstants.CALLBACK_EXCEPTION));
        }
    }

    private synchronized String storeToken(IMqttToken iMqttToken) {
        int i;
        this.tokenMap.put(this.tokenNumber, iMqttToken);
        i = this.tokenNumber;
        this.tokenNumber = i + 1;
        return Integer.toString(i);
    }

    private void subscribeAction(Bundle bundle) {
        simpleAction(removeMqttToken(bundle), bundle);
    }

    private void traceAction(Bundle bundle) {
        if (this.traceCallback != null) {
            String string = bundle.getString(MqttServiceConstants.CALLBACK_TRACE_SEVERITY);
            String string2 = bundle.getString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE);
            String string3 = bundle.getString(MqttServiceConstants.CALLBACK_TRACE_TAG);
            if ("debug".equals(string)) {
                this.traceCallback.traceDebug(string3, string2);
            } else if ("error".equals(string)) {
                this.traceCallback.traceError(string3, string2);
            } else {
                this.traceCallback.traceException(string3, string2, (Exception) bundle.getSerializable(MqttServiceConstants.CALLBACK_EXCEPTION));
            }
        }
    }

    private void unSubscribeAction(Bundle bundle) {
        simpleAction(removeMqttToken(bundle), bundle);
    }

    public boolean acknowledgeMessage(String str) {
        if (this.messageAck == Ack.MANUAL_ACK && this.mqttService.acknowledgeMessageArrival(this.clientHandle, str) == Status.OK) {
            return true;
        }
        return false;
    }

    public void close() {
        MqttService mqttService2 = this.mqttService;
        if (mqttService2 != null) {
            if (this.clientHandle == null) {
                this.clientHandle = mqttService2.getClient(this.serverURI, this.clientId, this.myContext.getApplicationInfo().packageName, this.persistence);
            }
            this.mqttService.close(this.clientHandle);
        }
    }

    public IMqttToken connect() throws MqttException {
        return connect(null, null);
    }

    public void deleteBufferedMessage(int i) {
        this.mqttService.deleteBufferedMessage(this.clientHandle, i);
    }

    public IMqttToken disconnect() throws MqttException {
        MqttTokenAndroid mqttTokenAndroid = new MqttTokenAndroid(this, null, null);
        this.mqttService.disconnect(this.clientHandle, null, storeToken(mqttTokenAndroid));
        return mqttTokenAndroid;
    }

    public void disconnectForcibly() throws MqttException {
        throw new UnsupportedOperationException();
    }

    public MqttMessage getBufferedMessage(int i) {
        return this.mqttService.getBufferedMessage(this.clientHandle, i);
    }

    public int getBufferedMessageCount() {
        return this.mqttService.getBufferedMessageCount(this.clientHandle);
    }

    public String getClientId() {
        return this.clientId;
    }

    public IMqttDeliveryToken[] getPendingDeliveryTokens() {
        return this.mqttService.getPendingDeliveryTokens(this.clientHandle);
    }

    public SSLSocketFactory getSSLSocketFactory(InputStream inputStream, String str) throws MqttSecurityException {
        try {
            KeyStore instance = KeyStore.getInstance("BKS");
            instance.load(inputStream, str.toCharArray());
            TrustManagerFactory instance2 = TrustManagerFactory.getInstance("X509");
            instance2.init(instance);
            TrustManager[] trustManagers = instance2.getTrustManagers();
            SSLContext instance3 = SSLContext.getInstance("TLSv1");
            instance3.init(null, trustManagers, null);
            return instance3.getSocketFactory();
        } catch (IOException | KeyManagementException | KeyStoreException | NoSuchAlgorithmException | CertificateException e2) {
            throw new MqttSecurityException(e2);
        }
    }

    public String getServerURI() {
        return this.serverURI;
    }

    public boolean isConnected() {
        String str = this.clientHandle;
        if (str != null) {
            MqttService mqttService2 = this.mqttService;
            if (mqttService2 != null && mqttService2.isConnected(str)) {
                return true;
            }
        }
        return false;
    }

    public void messageArrivedComplete(int i, int i2) throws MqttException {
        throw new UnsupportedOperationException();
    }

    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        String string = extras.getString(MqttServiceConstants.CALLBACK_CLIENT_HANDLE);
        if (string != null && string.equals(this.clientHandle)) {
            String string2 = extras.getString(MqttServiceConstants.CALLBACK_ACTION);
            if ("connect".equals(string2)) {
                connectAction(extras);
            } else if (MqttServiceConstants.CONNECT_EXTENDED_ACTION.equals(string2)) {
                connectExtendedAction(extras);
            } else if (MqttServiceConstants.MESSAGE_ARRIVED_ACTION.equals(string2)) {
                messageArrivedAction(extras);
            } else if (MqttServiceConstants.SUBSCRIBE_ACTION.equals(string2)) {
                subscribeAction(extras);
            } else if (MqttServiceConstants.UNSUBSCRIBE_ACTION.equals(string2)) {
                unSubscribeAction(extras);
            } else if (MqttServiceConstants.SEND_ACTION.equals(string2)) {
                sendAction(extras);
            } else if (MqttServiceConstants.MESSAGE_DELIVERED_ACTION.equals(string2)) {
                messageDeliveredAction(extras);
            } else if (MqttServiceConstants.ON_CONNECTION_LOST_ACTION.equals(string2)) {
                connectionLostAction(extras);
            } else if ("disconnect".equals(string2)) {
                disconnected(extras);
            } else if ("trace".equals(string2)) {
                traceAction(extras);
            } else {
                this.mqttService.traceError("MqttService", "Callback action doesn't exist.");
            }
        }
    }

    public IMqttDeliveryToken publish(String str, byte[] bArr, int i, boolean z) throws MqttException, MqttPersistenceException {
        return publish(str, bArr, i, z, null, null);
    }

    public void registerResources(Context context) {
        if (context != null) {
            this.myContext = context;
            if (!this.receiverRegistered) {
                registerReceiver(this);
            }
        }
    }

    public void setBufferOpts(DisconnectedBufferOptions disconnectedBufferOptions) {
        this.mqttService.setBufferOpts(this.clientHandle, disconnectedBufferOptions);
    }

    public void setCallback(MqttCallback mqttCallback) {
        this.callback = mqttCallback;
    }

    public void setManualAcks(boolean z) {
        throw new UnsupportedOperationException();
    }

    public void setTraceCallback(MqttTraceHandler mqttTraceHandler) {
        this.traceCallback = mqttTraceHandler;
    }

    public void setTraceEnabled(boolean z) {
        this.traceEnabled = z;
        MqttService mqttService2 = this.mqttService;
        if (mqttService2 != null) {
            mqttService2.setTraceEnabled(z);
        }
    }

    public IMqttToken subscribe(String str, int i) throws MqttException, MqttSecurityException {
        return subscribe(str, i, (Object) null, (IMqttActionListener) null);
    }

    public void unregisterResources() {
        if (this.myContext != null && this.receiverRegistered) {
            synchronized (this) {
                LocalBroadcastManager.getInstance(this.myContext).unregisterReceiver(this);
                this.receiverRegistered = false;
            }
            if (this.bindedService) {
                try {
                    this.myContext.unbindService(this.serviceConnection);
                    this.bindedService = false;
                } catch (IllegalArgumentException unused) {
                }
            }
        }
    }

    public IMqttToken unsubscribe(String str) throws MqttException {
        return unsubscribe(str, (Object) null, (IMqttActionListener) null);
    }

    public MqttAndroidClient(Context context, String str, String str2, Ack ack) {
        this(context, str, str2, null, ack);
    }

    public IMqttToken connect(MqttConnectOptions mqttConnectOptions) throws MqttException {
        return connect(mqttConnectOptions, null, null);
    }

    public void disconnectForcibly(long j) throws MqttException {
        throw new UnsupportedOperationException();
    }

    public IMqttDeliveryToken publish(String str, MqttMessage mqttMessage) throws MqttException, MqttPersistenceException {
        return publish(str, mqttMessage, (Object) null, (IMqttActionListener) null);
    }

    public IMqttToken subscribe(String[] strArr, int[] iArr) throws MqttException, MqttSecurityException {
        return subscribe(strArr, iArr, (Object) null, (IMqttActionListener) null);
    }

    public IMqttToken unsubscribe(String[] strArr) throws MqttException {
        return unsubscribe(strArr, (Object) null, (IMqttActionListener) null);
    }

    public MqttAndroidClient(Context context, String str, String str2, MqttClientPersistence mqttClientPersistence) {
        this(context, str, str2, mqttClientPersistence, Ack.AUTO_ACK);
    }

    public IMqttToken connect(Object obj, IMqttActionListener iMqttActionListener) throws MqttException {
        return connect(new MqttConnectOptions(), obj, iMqttActionListener);
    }

    public void disconnectForcibly(long j, long j2) throws MqttException {
        throw new UnsupportedOperationException();
    }

    public IMqttDeliveryToken publish(String str, byte[] bArr, int i, boolean z, Object obj, IMqttActionListener iMqttActionListener) throws MqttException, MqttPersistenceException {
        MqttMessage mqttMessage = new MqttMessage(bArr);
        mqttMessage.setQos(i);
        mqttMessage.setRetained(z);
        MqttDeliveryTokenAndroid mqttDeliveryTokenAndroid = new MqttDeliveryTokenAndroid(this, obj, iMqttActionListener, mqttMessage);
        String storeToken = storeToken(mqttDeliveryTokenAndroid);
        mqttDeliveryTokenAndroid.setDelegate(this.mqttService.publish(this.clientHandle, str, bArr, i, z, null, storeToken));
        return mqttDeliveryTokenAndroid;
    }

    public IMqttToken subscribe(String str, int i, Object obj, IMqttActionListener iMqttActionListener) throws MqttException {
        MqttTokenAndroid mqttTokenAndroid = new MqttTokenAndroid(this, obj, iMqttActionListener, new String[]{str});
        this.mqttService.subscribe(this.clientHandle, str, i, (String) null, storeToken(mqttTokenAndroid));
        return mqttTokenAndroid;
    }

    public IMqttToken unsubscribe(String str, Object obj, IMqttActionListener iMqttActionListener) throws MqttException {
        MqttTokenAndroid mqttTokenAndroid = new MqttTokenAndroid(this, obj, iMqttActionListener);
        this.mqttService.unsubscribe(this.clientHandle, str, (String) null, storeToken(mqttTokenAndroid));
        return mqttTokenAndroid;
    }

    public MqttAndroidClient(Context context, String str, String str2, MqttClientPersistence mqttClientPersistence, Ack ack) {
        this.serviceConnection = new MyServiceConnection();
        this.tokenMap = new SparseArray<>();
        this.tokenNumber = 0;
        this.persistence = null;
        this.traceEnabled = false;
        this.receiverRegistered = false;
        this.bindedService = false;
        this.myContext = context;
        this.serverURI = str;
        this.clientId = str2;
        this.persistence = mqttClientPersistence;
        this.messageAck = ack;
    }

    public IMqttToken connect(MqttConnectOptions mqttConnectOptions, Object obj, IMqttActionListener iMqttActionListener) throws MqttException {
        MqttTokenAndroid mqttTokenAndroid = new MqttTokenAndroid(this, obj, iMqttActionListener);
        this.connectOptions = mqttConnectOptions;
        this.connectToken = mqttTokenAndroid;
        if (this.mqttService == null) {
            Intent intent = new Intent();
            intent.setClassName(this.myContext, SERVICE_NAME);
            if (this.myContext.startService(intent) == null) {
                IMqttActionListener actionCallback = mqttTokenAndroid.getActionCallback();
                if (actionCallback != null) {
                    actionCallback.onFailure(mqttTokenAndroid, new RuntimeException("cannot start service org.eclipse.paho.android.service.MqttService"));
                }
            }
            this.myContext.bindService(intent, this.serviceConnection, 1);
            if (!this.receiverRegistered) {
                registerReceiver(this);
            }
        } else {
            pool.execute(new Runnable() {
                public void run() {
                    MqttAndroidClient.this.doConnect();
                    if (!MqttAndroidClient.this.receiverRegistered) {
                        MqttAndroidClient mqttAndroidClient = MqttAndroidClient.this;
                        mqttAndroidClient.registerReceiver(mqttAndroidClient);
                    }
                }
            });
        }
        return mqttTokenAndroid;
    }

    public IMqttToken disconnect(long j) throws MqttException {
        MqttTokenAndroid mqttTokenAndroid = new MqttTokenAndroid(this, null, null);
        this.mqttService.disconnect(this.clientHandle, j, null, storeToken(mqttTokenAndroid));
        return mqttTokenAndroid;
    }

    public IMqttToken subscribe(String[] strArr, int[] iArr, Object obj, IMqttActionListener iMqttActionListener) throws MqttException {
        MqttTokenAndroid mqttTokenAndroid = new MqttTokenAndroid(this, obj, iMqttActionListener, strArr);
        this.mqttService.subscribe(this.clientHandle, strArr, iArr, (String) null, storeToken(mqttTokenAndroid));
        return mqttTokenAndroid;
    }

    public IMqttToken unsubscribe(String[] strArr, Object obj, IMqttActionListener iMqttActionListener) throws MqttException {
        MqttTokenAndroid mqttTokenAndroid = new MqttTokenAndroid(this, obj, iMqttActionListener);
        this.mqttService.unsubscribe(this.clientHandle, strArr, (String) null, storeToken(mqttTokenAndroid));
        return mqttTokenAndroid;
    }

    public IMqttToken disconnect(Object obj, IMqttActionListener iMqttActionListener) throws MqttException {
        MqttTokenAndroid mqttTokenAndroid = new MqttTokenAndroid(this, obj, iMqttActionListener);
        this.mqttService.disconnect(this.clientHandle, null, storeToken(mqttTokenAndroid));
        return mqttTokenAndroid;
    }

    public IMqttToken subscribe(String str, int i, Object obj, IMqttActionListener iMqttActionListener, IMqttMessageListener iMqttMessageListener) throws MqttException {
        return subscribe(new String[]{str}, new int[]{i}, obj, iMqttActionListener, new IMqttMessageListener[]{iMqttMessageListener});
    }

    public IMqttToken disconnect(long j, Object obj, IMqttActionListener iMqttActionListener) throws MqttException {
        MqttTokenAndroid mqttTokenAndroid = new MqttTokenAndroid(this, obj, iMqttActionListener);
        this.mqttService.disconnect(this.clientHandle, j, null, storeToken(mqttTokenAndroid));
        return mqttTokenAndroid;
    }

    public IMqttDeliveryToken publish(String str, MqttMessage mqttMessage, Object obj, IMqttActionListener iMqttActionListener) throws MqttException, MqttPersistenceException {
        MqttDeliveryTokenAndroid mqttDeliveryTokenAndroid = new MqttDeliveryTokenAndroid(this, obj, iMqttActionListener, mqttMessage);
        mqttDeliveryTokenAndroid.setDelegate(this.mqttService.publish(this.clientHandle, str, mqttMessage, null, storeToken(mqttDeliveryTokenAndroid)));
        return mqttDeliveryTokenAndroid;
    }

    public IMqttToken subscribe(String str, int i, IMqttMessageListener iMqttMessageListener) throws MqttException {
        return subscribe(str, i, (Object) null, (IMqttActionListener) null, iMqttMessageListener);
    }

    public IMqttToken subscribe(String[] strArr, int[] iArr, IMqttMessageListener[] iMqttMessageListenerArr) throws MqttException {
        return subscribe(strArr, iArr, (Object) null, (IMqttActionListener) null, iMqttMessageListenerArr);
    }

    public IMqttToken subscribe(String[] strArr, int[] iArr, Object obj, IMqttActionListener iMqttActionListener, IMqttMessageListener[] iMqttMessageListenerArr) throws MqttException {
        this.mqttService.subscribe(this.clientHandle, strArr, iArr, null, storeToken(new MqttTokenAndroid(this, obj, iMqttActionListener, strArr)), iMqttMessageListenerArr);
        return null;
    }
}
