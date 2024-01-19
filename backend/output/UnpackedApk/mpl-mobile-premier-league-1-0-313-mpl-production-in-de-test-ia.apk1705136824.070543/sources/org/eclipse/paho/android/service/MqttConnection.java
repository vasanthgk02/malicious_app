package org.eclipse.paho.android.service;

import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Log;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.fontbox.cmap.CMap;
import org.eclipse.paho.android.service.MessageStore.StoredMessage;
import org.eclipse.paho.client.mqttv3.DisconnectedBufferOptions;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttClientPersistence;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.persist.MqttDefaultFilePersistence;

public class MqttConnection implements MqttCallbackExtended {
    public static final String NOT_CONNECTED = "not connected";
    public static final String TAG = "MqttConnection";
    public AlarmPingSender alarmPingSender = null;
    public DisconnectedBufferOptions bufferOpts = null;
    public boolean cleanSession = true;
    public String clientHandle;
    public String clientId;
    public MqttConnectOptions connectOptions;
    public volatile boolean disconnected = true;
    public volatile boolean isConnecting = false;
    public MqttAsyncClient myClient = null;
    public MqttClientPersistence persistence = null;
    public String reconnectActivityToken = null;
    public Map<IMqttDeliveryToken, String> savedActivityTokens = new HashMap();
    public Map<IMqttDeliveryToken, String> savedInvocationContexts = new HashMap();
    public Map<IMqttDeliveryToken, MqttMessage> savedSentMessages = new HashMap();
    public Map<IMqttDeliveryToken, String> savedTopics = new HashMap();
    public String serverURI;
    public MqttService service = null;
    public String wakeLockTag = null;
    public WakeLock wakelock = null;

    public class MqttConnectionListener implements IMqttActionListener {
        public final Bundle resultBundle;

        public void onFailure(IMqttToken iMqttToken, Throwable th) {
            this.resultBundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, th.getLocalizedMessage());
            this.resultBundle.putSerializable(MqttServiceConstants.CALLBACK_EXCEPTION, th);
            MqttConnection.this.service.callbackToActivity(MqttConnection.this.clientHandle, Status.ERROR, this.resultBundle);
        }

        public void onSuccess(IMqttToken iMqttToken) {
            MqttConnection.this.service.callbackToActivity(MqttConnection.this.clientHandle, Status.OK, this.resultBundle);
        }

        public MqttConnectionListener(Bundle bundle) {
            this.resultBundle = bundle;
        }
    }

    public MqttConnection(MqttService mqttService, String str, String str2, MqttClientPersistence mqttClientPersistence, String str3) {
        this.serverURI = str;
        this.service = mqttService;
        this.clientId = str2;
        this.persistence = mqttClientPersistence;
        this.clientHandle = str3;
        StringBuilder sb = new StringBuilder(MqttConnection.class.getCanonicalName());
        GeneratedOutlineSupport.outline103(sb, CMap.SPACE, str2, CMap.SPACE, "on host ");
        sb.append(str);
        this.wakeLockTag = sb.toString();
    }

    private void acquireWakeLock() {
        if (this.wakelock == null) {
            this.wakelock = ((PowerManager) this.service.getSystemService("power")).newWakeLock(1, this.wakeLockTag);
        }
        this.wakelock.acquire();
    }

    private void deliverBacklog() {
        Iterator<StoredMessage> allArrivedMessages = this.service.messageStore.getAllArrivedMessages(this.clientHandle);
        while (allArrivedMessages.hasNext()) {
            StoredMessage next = allArrivedMessages.next();
            Bundle messageToBundle = messageToBundle(next.getMessageId(), next.getTopic(), next.getMessage());
            messageToBundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.MESSAGE_ARRIVED_ACTION);
            this.service.callbackToActivity(this.clientHandle, Status.OK, messageToBundle);
        }
    }

    /* access modifiers changed from: private */
    public void doAfterConnectFail(Bundle bundle) {
        acquireWakeLock();
        this.disconnected = true;
        setConnectingState(false);
        this.service.callbackToActivity(this.clientHandle, Status.ERROR, bundle);
        releaseWakeLock();
    }

    /* access modifiers changed from: private */
    public void doAfterConnectSuccess(Bundle bundle) {
        acquireWakeLock();
        this.service.callbackToActivity(this.clientHandle, Status.OK, bundle);
        deliverBacklog();
        setConnectingState(false);
        this.disconnected = false;
        releaseWakeLock();
    }

    private void handleException(Bundle bundle, Exception exc) {
        bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, exc.getLocalizedMessage());
        bundle.putSerializable(MqttServiceConstants.CALLBACK_EXCEPTION, exc);
        this.service.callbackToActivity(this.clientHandle, Status.ERROR, bundle);
    }

    private Bundle messageToBundle(String str, String str2, MqttMessage mqttMessage) {
        Bundle bundle = new Bundle();
        bundle.putString(MqttServiceConstants.CALLBACK_MESSAGE_ID, str);
        bundle.putString(MqttServiceConstants.CALLBACK_DESTINATION_NAME, str2);
        bundle.putParcelable(MqttServiceConstants.CALLBACK_MESSAGE_PARCEL, new ParcelableMqttMessage(mqttMessage));
        return bundle;
    }

    private void releaseWakeLock() {
        WakeLock wakeLock = this.wakelock;
        if (wakeLock != null && wakeLock.isHeld()) {
            this.wakelock.release();
        }
    }

    private synchronized void setConnectingState(boolean z) {
        this.isConnecting = z;
    }

    private void storeSendDetails(String str, MqttMessage mqttMessage, IMqttDeliveryToken iMqttDeliveryToken, String str2, String str3) {
        this.savedTopics.put(iMqttDeliveryToken, str);
        this.savedSentMessages.put(iMqttDeliveryToken, mqttMessage);
        this.savedActivityTokens.put(iMqttDeliveryToken, str3);
        this.savedInvocationContexts.put(iMqttDeliveryToken, str2);
    }

    public void close() {
        this.service.traceDebug(TAG, "close()");
        try {
            if (this.myClient != null) {
                this.myClient.close();
            }
        } catch (MqttException e2) {
            handleException(new Bundle(), e2);
        }
    }

    public void connect(MqttConnectOptions mqttConnectOptions, String str, String str2) {
        this.connectOptions = mqttConnectOptions;
        this.reconnectActivityToken = str2;
        if (mqttConnectOptions != null) {
            this.cleanSession = mqttConnectOptions.isCleanSession();
        }
        if (this.connectOptions.isCleanSession()) {
            this.service.messageStore.clearArrivedMessages(this.clientHandle);
        }
        MqttService mqttService = this.service;
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Connecting {");
        outline73.append(this.serverURI);
        outline73.append("} as {");
        outline73.append(this.clientId);
        outline73.append("}");
        mqttService.traceDebug(TAG, outline73.toString());
        final Bundle bundle = new Bundle();
        bundle.putString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN, str2);
        bundle.putString(MqttServiceConstants.CALLBACK_INVOCATION_CONTEXT, str);
        bundle.putString(MqttServiceConstants.CALLBACK_ACTION, "connect");
        try {
            if (this.persistence == null) {
                File externalFilesDir = this.service.getExternalFilesDir(TAG);
                if (externalFilesDir == null) {
                    externalFilesDir = this.service.getDir(TAG, 0);
                    if (externalFilesDir == null) {
                        bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, "Error! No external and internal storage available");
                        bundle.putSerializable(MqttServiceConstants.CALLBACK_EXCEPTION, new MqttPersistenceException());
                        this.service.callbackToActivity(this.clientHandle, Status.ERROR, bundle);
                        return;
                    }
                }
                this.persistence = new MqttDefaultFilePersistence(externalFilesDir.getAbsolutePath());
            }
            AnonymousClass1 r0 = new MqttConnectionListener(bundle) {
                public void onFailure(IMqttToken iMqttToken, Throwable th) {
                    bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, th.getLocalizedMessage());
                    bundle.putSerializable(MqttServiceConstants.CALLBACK_EXCEPTION, th);
                    MqttService access$200 = MqttConnection.this.service;
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("connect fail, call connect to reconnect.reason:");
                    outline73.append(th.getMessage());
                    access$200.traceError(MqttConnection.TAG, outline73.toString());
                    MqttConnection.this.doAfterConnectFail(bundle);
                }

                public void onSuccess(IMqttToken iMqttToken) {
                    MqttConnection.this.doAfterConnectSuccess(bundle);
                    MqttConnection.this.service.traceDebug(MqttConnection.TAG, "connect success!");
                }
            };
            if (this.myClient == null) {
                this.alarmPingSender = new AlarmPingSender(this.service);
                MqttAsyncClient mqttAsyncClient = new MqttAsyncClient(this.serverURI, this.clientId, this.persistence, this.alarmPingSender);
                this.myClient = mqttAsyncClient;
                mqttAsyncClient.setCallback(this);
                this.service.traceDebug(TAG, "Do Real connect!");
                setConnectingState(true);
                this.myClient.connect(this.connectOptions, str, r0);
            } else if (this.isConnecting) {
                this.service.traceDebug(TAG, "myClient != null and the client is connecting. Connect return directly.");
                MqttService mqttService2 = this.service;
                mqttService2.traceDebug(TAG, "Connect return:isConnecting:" + this.isConnecting + ".disconnected:" + this.disconnected);
            } else if (!this.disconnected) {
                this.service.traceDebug(TAG, "myClient != null and the client is connected and notify!");
                doAfterConnectSuccess(bundle);
            } else {
                this.service.traceDebug(TAG, "myClient != null and the client is not connected");
                this.service.traceDebug(TAG, "Do Real connect!");
                setConnectingState(true);
                this.myClient.connect(this.connectOptions, str, r0);
            }
        } catch (Exception e2) {
            MqttService mqttService3 = this.service;
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("Exception occurred attempting to connect: ");
            outline732.append(e2.getMessage());
            mqttService3.traceError(TAG, outline732.toString());
            setConnectingState(false);
            handleException(bundle, e2);
        }
    }

    public void connectComplete(boolean z, String str) {
        Bundle bundle = new Bundle();
        bundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.CONNECT_EXTENDED_ACTION);
        bundle.putBoolean(MqttServiceConstants.CALLBACK_RECONNECT, z);
        bundle.putString(MqttServiceConstants.CALLBACK_SERVER_URI, str);
        this.service.callbackToActivity(this.clientHandle, Status.OK, bundle);
    }

    public void connectionLost(Throwable th) {
        MqttService mqttService = this.service;
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("connectionLost(");
        outline73.append(th.getMessage());
        outline73.append(")");
        mqttService.traceDebug(TAG, outline73.toString());
        this.disconnected = true;
        try {
            if (!this.connectOptions.isAutomaticReconnect()) {
                this.myClient.disconnect(null, new IMqttActionListener() {
                    public void onFailure(IMqttToken iMqttToken, Throwable th) {
                    }

                    public void onSuccess(IMqttToken iMqttToken) {
                    }
                });
            } else {
                this.alarmPingSender.schedule(100);
            }
        } catch (Exception unused) {
        }
        Bundle outline14 = GeneratedOutlineSupport.outline14(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.ON_CONNECTION_LOST_ACTION);
        outline14.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, th.getMessage());
        if (th instanceof MqttException) {
            outline14.putSerializable(MqttServiceConstants.CALLBACK_EXCEPTION, th);
        }
        outline14.putString(MqttServiceConstants.CALLBACK_EXCEPTION_STACK, Log.getStackTraceString(th));
        this.service.callbackToActivity(this.clientHandle, Status.OK, outline14);
        releaseWakeLock();
    }

    public void deleteBufferedMessage(int i) {
        this.myClient.deleteBufferedMessage(i);
    }

    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        MqttService mqttService = this.service;
        mqttService.traceDebug(TAG, "deliveryComplete(" + iMqttDeliveryToken + ")");
        MqttMessage remove = this.savedSentMessages.remove(iMqttDeliveryToken);
        if (remove != null) {
            String remove2 = this.savedActivityTokens.remove(iMqttDeliveryToken);
            String remove3 = this.savedInvocationContexts.remove(iMqttDeliveryToken);
            Bundle messageToBundle = messageToBundle(null, this.savedTopics.remove(iMqttDeliveryToken), remove);
            if (remove2 != null) {
                messageToBundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.SEND_ACTION);
                messageToBundle.putString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN, remove2);
                messageToBundle.putString(MqttServiceConstants.CALLBACK_INVOCATION_CONTEXT, remove3);
                this.service.callbackToActivity(this.clientHandle, Status.OK, messageToBundle);
            }
            messageToBundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.MESSAGE_DELIVERED_ACTION);
            this.service.callbackToActivity(this.clientHandle, Status.OK, messageToBundle);
        }
    }

    public void disconnect(long j, String str, String str2) {
        this.service.traceDebug(TAG, "disconnect()");
        this.disconnected = true;
        Bundle bundle = new Bundle();
        bundle.putString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN, str2);
        bundle.putString(MqttServiceConstants.CALLBACK_INVOCATION_CONTEXT, str);
        bundle.putString(MqttServiceConstants.CALLBACK_ACTION, "disconnect");
        MqttAsyncClient mqttAsyncClient = this.myClient;
        if (mqttAsyncClient == null || !mqttAsyncClient.isConnected()) {
            bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, NOT_CONNECTED);
            this.service.traceError("disconnect", NOT_CONNECTED);
            this.service.callbackToActivity(this.clientHandle, Status.ERROR, bundle);
        } else {
            try {
                this.myClient.disconnect(j, str, new MqttConnectionListener(bundle));
            } catch (Exception e2) {
                handleException(bundle, e2);
            }
        }
        MqttConnectOptions mqttConnectOptions = this.connectOptions;
        if (mqttConnectOptions != null && mqttConnectOptions.isCleanSession()) {
            this.service.messageStore.clearArrivedMessages(this.clientHandle);
        }
        releaseWakeLock();
    }

    public MqttMessage getBufferedMessage(int i) {
        return this.myClient.getBufferedMessage(i);
    }

    public int getBufferedMessageCount() {
        return this.myClient.getBufferedMessageCount();
    }

    public String getClientHandle() {
        return this.clientHandle;
    }

    public String getClientId() {
        return this.clientId;
    }

    public MqttConnectOptions getConnectOptions() {
        return this.connectOptions;
    }

    public IMqttDeliveryToken[] getPendingDeliveryTokens() {
        return this.myClient.getPendingDeliveryTokens();
    }

    public String getServerURI() {
        return this.serverURI;
    }

    public boolean isConnected() {
        MqttAsyncClient mqttAsyncClient = this.myClient;
        return mqttAsyncClient != null && mqttAsyncClient.isConnected();
    }

    public void messageArrived(String str, MqttMessage mqttMessage) throws Exception {
        MqttService mqttService = this.service;
        StringBuilder outline80 = GeneratedOutlineSupport.outline80("messageArrived(", str, ",{");
        outline80.append(mqttMessage.toString());
        outline80.append("})");
        mqttService.traceDebug(TAG, outline80.toString());
        String storeArrived = this.service.messageStore.storeArrived(this.clientHandle, str, mqttMessage);
        Bundle messageToBundle = messageToBundle(storeArrived, str, mqttMessage);
        messageToBundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.MESSAGE_ARRIVED_ACTION);
        messageToBundle.putString(MqttServiceConstants.CALLBACK_MESSAGE_ID, storeArrived);
        this.service.callbackToActivity(this.clientHandle, Status.OK, messageToBundle);
    }

    public void offline() {
        if (!this.disconnected && !this.cleanSession) {
            connectionLost(new Exception("Android offline"));
        }
    }

    public IMqttDeliveryToken publish(String str, byte[] bArr, int i, boolean z, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.SEND_ACTION);
        bundle.putString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN, str3);
        bundle.putString(MqttServiceConstants.CALLBACK_INVOCATION_CONTEXT, str2);
        MqttAsyncClient mqttAsyncClient = this.myClient;
        IMqttDeliveryToken iMqttDeliveryToken = null;
        if (mqttAsyncClient == null || !mqttAsyncClient.isConnected()) {
            bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, NOT_CONNECTED);
            this.service.traceError(MqttServiceConstants.SEND_ACTION, NOT_CONNECTED);
            this.service.callbackToActivity(this.clientHandle, Status.ERROR, bundle);
            return null;
        }
        MqttConnectionListener mqttConnectionListener = new MqttConnectionListener(bundle);
        try {
            MqttMessage mqttMessage = new MqttMessage(bArr);
            mqttMessage.setQos(i);
            mqttMessage.setRetained(z);
            IMqttDeliveryToken publish = this.myClient.publish(str, bArr, i, z, str2, mqttConnectionListener);
            try {
                storeSendDetails(str, mqttMessage, publish, str2, str3);
                return publish;
            } catch (Exception e2) {
                e = e2;
                iMqttDeliveryToken = publish;
                handleException(bundle, e);
                return iMqttDeliveryToken;
            }
        } catch (Exception e3) {
            e = e3;
            handleException(bundle, e);
            return iMqttDeliveryToken;
        }
    }

    public synchronized void reconnect() {
        if (this.myClient == null) {
            this.service.traceError(TAG, "Reconnect myClient = null. Will not do reconnect");
        } else if (this.isConnecting) {
            this.service.traceDebug(TAG, "The client is connecting. Reconnect return directly.");
        } else if (!this.service.isOnline()) {
            this.service.traceDebug(TAG, "The network is not reachable. Will not do reconnect");
        } else if (this.connectOptions.isAutomaticReconnect()) {
            Bundle bundle = new Bundle();
            bundle.putString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN, this.reconnectActivityToken);
            bundle.putString(MqttServiceConstants.CALLBACK_INVOCATION_CONTEXT, null);
            bundle.putString(MqttServiceConstants.CALLBACK_ACTION, "connect");
            try {
                this.myClient.reconnect();
            } catch (MqttException e2) {
                e2.getMessage();
                setConnectingState(false);
                handleException(bundle, e2);
            }
        } else if (this.disconnected && !this.cleanSession) {
            this.service.traceDebug(TAG, "Do Real Reconnect!");
            final Bundle bundle2 = new Bundle();
            bundle2.putString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN, this.reconnectActivityToken);
            bundle2.putString(MqttServiceConstants.CALLBACK_INVOCATION_CONTEXT, null);
            bundle2.putString(MqttServiceConstants.CALLBACK_ACTION, "connect");
            try {
                this.myClient.connect(this.connectOptions, null, new MqttConnectionListener(bundle2) {
                    public void onFailure(IMqttToken iMqttToken, Throwable th) {
                        bundle2.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, th.getLocalizedMessage());
                        bundle2.putSerializable(MqttServiceConstants.CALLBACK_EXCEPTION, th);
                        MqttConnection.this.service.callbackToActivity(MqttConnection.this.clientHandle, Status.ERROR, bundle2);
                        MqttConnection.this.doAfterConnectFail(bundle2);
                    }

                    public void onSuccess(IMqttToken iMqttToken) {
                        MqttConnection.this.service.traceDebug(MqttConnection.TAG, "Reconnect Success!");
                        MqttConnection.this.service.traceDebug(MqttConnection.TAG, "DeliverBacklog when reconnect.");
                        MqttConnection.this.doAfterConnectSuccess(bundle2);
                    }
                });
                setConnectingState(true);
            } catch (MqttException e3) {
                MqttService mqttService = this.service;
                mqttService.traceError(TAG, "Cannot reconnect to remote server." + e3.getMessage());
                setConnectingState(false);
                handleException(bundle2, e3);
            } catch (Exception e4) {
                MqttService mqttService2 = this.service;
                mqttService2.traceError(TAG, "Cannot reconnect to remote server." + e4.getMessage());
                setConnectingState(false);
                handleException(bundle2, new MqttException(6, e4.getCause()));
            }
        }
    }

    public void setBufferOpts(DisconnectedBufferOptions disconnectedBufferOptions) {
        this.bufferOpts = disconnectedBufferOptions;
        this.myClient.setBufferOpts(disconnectedBufferOptions);
    }

    public void setClientHandle(String str) {
        this.clientHandle = str;
    }

    public void setClientId(String str) {
        this.clientId = str;
    }

    public void setConnectOptions(MqttConnectOptions mqttConnectOptions) {
        this.connectOptions = mqttConnectOptions;
    }

    public void setServerURI(String str) {
        this.serverURI = str;
    }

    public void subscribe(String str, int i, String str2, String str3) {
        MqttService mqttService = this.service;
        mqttService.traceDebug(TAG, "subscribe({" + str + "}," + i + ",{" + str2 + "}, {" + str3 + "}");
        Bundle bundle = new Bundle();
        bundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.SUBSCRIBE_ACTION);
        bundle.putString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN, str3);
        bundle.putString(MqttServiceConstants.CALLBACK_INVOCATION_CONTEXT, str2);
        MqttAsyncClient mqttAsyncClient = this.myClient;
        if (mqttAsyncClient == null || !mqttAsyncClient.isConnected()) {
            bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, NOT_CONNECTED);
            this.service.traceError(MqttServiceConstants.SUBSCRIBE_ACTION, NOT_CONNECTED);
            this.service.callbackToActivity(this.clientHandle, Status.ERROR, bundle);
            return;
        }
        try {
            this.myClient.subscribe(str, i, (Object) str2, (IMqttActionListener) new MqttConnectionListener(bundle));
        } catch (Exception e2) {
            handleException(bundle, e2);
        }
    }

    public void unsubscribe(String str, String str2, String str3) {
        MqttService mqttService = this.service;
        StringBuilder outline82 = GeneratedOutlineSupport.outline82("unsubscribe({", str, "},{", str2, "}, {");
        outline82.append(str3);
        outline82.append("})");
        mqttService.traceDebug(TAG, outline82.toString());
        Bundle bundle = new Bundle();
        bundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.UNSUBSCRIBE_ACTION);
        bundle.putString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN, str3);
        bundle.putString(MqttServiceConstants.CALLBACK_INVOCATION_CONTEXT, str2);
        MqttAsyncClient mqttAsyncClient = this.myClient;
        if (mqttAsyncClient == null || !mqttAsyncClient.isConnected()) {
            bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, NOT_CONNECTED);
            this.service.traceError(MqttServiceConstants.SUBSCRIBE_ACTION, NOT_CONNECTED);
            this.service.callbackToActivity(this.clientHandle, Status.ERROR, bundle);
            return;
        }
        try {
            this.myClient.unsubscribe(str, (Object) str2, (IMqttActionListener) new MqttConnectionListener(bundle));
        } catch (Exception e2) {
            handleException(bundle, e2);
        }
    }

    public void subscribe(String[] strArr, int[] iArr, String str, String str2) {
        MqttService mqttService = this.service;
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("subscribe({");
        outline73.append(Arrays.toString(strArr));
        outline73.append("},");
        outline73.append(Arrays.toString(iArr));
        outline73.append(",{");
        outline73.append(str);
        mqttService.traceDebug(TAG, GeneratedOutlineSupport.outline63(outline73, "}, {", str2, "}"));
        Bundle bundle = new Bundle();
        bundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.SUBSCRIBE_ACTION);
        bundle.putString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN, str2);
        bundle.putString(MqttServiceConstants.CALLBACK_INVOCATION_CONTEXT, str);
        MqttAsyncClient mqttAsyncClient = this.myClient;
        if (mqttAsyncClient == null || !mqttAsyncClient.isConnected()) {
            bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, NOT_CONNECTED);
            this.service.traceError(MqttServiceConstants.SUBSCRIBE_ACTION, NOT_CONNECTED);
            this.service.callbackToActivity(this.clientHandle, Status.ERROR, bundle);
            return;
        }
        try {
            this.myClient.subscribe(strArr, iArr, (Object) str, (IMqttActionListener) new MqttConnectionListener(bundle));
        } catch (Exception e2) {
            handleException(bundle, e2);
        }
    }

    public void unsubscribe(String[] strArr, String str, String str2) {
        MqttService mqttService = this.service;
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("unsubscribe({");
        GeneratedOutlineSupport.outline103(outline73, Arrays.toString(strArr), "},{", str, "}, {");
        outline73.append(str2);
        outline73.append("})");
        mqttService.traceDebug(TAG, outline73.toString());
        Bundle bundle = new Bundle();
        bundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.UNSUBSCRIBE_ACTION);
        bundle.putString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN, str2);
        bundle.putString(MqttServiceConstants.CALLBACK_INVOCATION_CONTEXT, str);
        MqttAsyncClient mqttAsyncClient = this.myClient;
        if (mqttAsyncClient == null || !mqttAsyncClient.isConnected()) {
            bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, NOT_CONNECTED);
            this.service.traceError(MqttServiceConstants.SUBSCRIBE_ACTION, NOT_CONNECTED);
            this.service.callbackToActivity(this.clientHandle, Status.ERROR, bundle);
            return;
        }
        try {
            this.myClient.unsubscribe(strArr, (Object) str, (IMqttActionListener) new MqttConnectionListener(bundle));
        } catch (Exception e2) {
            handleException(bundle, e2);
        }
    }

    public IMqttDeliveryToken publish(String str, MqttMessage mqttMessage, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.SEND_ACTION);
        bundle.putString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN, str3);
        bundle.putString(MqttServiceConstants.CALLBACK_INVOCATION_CONTEXT, str2);
        MqttAsyncClient mqttAsyncClient = this.myClient;
        IMqttDeliveryToken iMqttDeliveryToken = null;
        if (mqttAsyncClient == null || !mqttAsyncClient.isConnected()) {
            if (this.myClient != null) {
                DisconnectedBufferOptions disconnectedBufferOptions = this.bufferOpts;
                if (disconnectedBufferOptions != null && disconnectedBufferOptions.isBufferEnabled()) {
                    try {
                        iMqttDeliveryToken = this.myClient.publish(str, mqttMessage, (Object) str2, (IMqttActionListener) new MqttConnectionListener(bundle));
                        storeSendDetails(str, mqttMessage, iMqttDeliveryToken, str2, str3);
                        return iMqttDeliveryToken;
                    } catch (Exception e2) {
                        handleException(bundle, e2);
                        return iMqttDeliveryToken;
                    }
                }
            }
            bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, NOT_CONNECTED);
            this.service.traceError(MqttServiceConstants.SEND_ACTION, NOT_CONNECTED);
            this.service.callbackToActivity(this.clientHandle, Status.ERROR, bundle);
            return null;
        }
        try {
            iMqttDeliveryToken = this.myClient.publish(str, mqttMessage, (Object) str2, (IMqttActionListener) new MqttConnectionListener(bundle));
            storeSendDetails(str, mqttMessage, iMqttDeliveryToken, str2, str3);
            return iMqttDeliveryToken;
        } catch (Exception e3) {
            handleException(bundle, e3);
            return iMqttDeliveryToken;
        }
    }

    public void disconnect(String str, String str2) {
        this.service.traceDebug(TAG, "disconnect()");
        this.disconnected = true;
        Bundle bundle = new Bundle();
        bundle.putString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN, str2);
        bundle.putString(MqttServiceConstants.CALLBACK_INVOCATION_CONTEXT, str);
        bundle.putString(MqttServiceConstants.CALLBACK_ACTION, "disconnect");
        MqttAsyncClient mqttAsyncClient = this.myClient;
        if (mqttAsyncClient == null || !mqttAsyncClient.isConnected()) {
            bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, NOT_CONNECTED);
            this.service.traceError("disconnect", NOT_CONNECTED);
            this.service.callbackToActivity(this.clientHandle, Status.ERROR, bundle);
        } else {
            try {
                this.myClient.disconnect(str, new MqttConnectionListener(bundle));
            } catch (Exception e2) {
                handleException(bundle, e2);
            }
        }
        MqttConnectOptions mqttConnectOptions = this.connectOptions;
        if (mqttConnectOptions != null && mqttConnectOptions.isCleanSession()) {
            this.service.messageStore.clearArrivedMessages(this.clientHandle);
        }
        releaseWakeLock();
    }

    public void subscribe(String[] strArr, int[] iArr, String str, String str2, IMqttMessageListener[] iMqttMessageListenerArr) {
        MqttService mqttService = this.service;
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("subscribe({");
        outline73.append(Arrays.toString(strArr));
        outline73.append("},");
        outline73.append(Arrays.toString(iArr));
        outline73.append(",{");
        outline73.append(str);
        mqttService.traceDebug(TAG, GeneratedOutlineSupport.outline63(outline73, "}, {", str2, "}"));
        Bundle bundle = new Bundle();
        bundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.SUBSCRIBE_ACTION);
        bundle.putString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN, str2);
        bundle.putString(MqttServiceConstants.CALLBACK_INVOCATION_CONTEXT, str);
        MqttAsyncClient mqttAsyncClient = this.myClient;
        if (mqttAsyncClient == null || !mqttAsyncClient.isConnected()) {
            bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, NOT_CONNECTED);
            this.service.traceError(MqttServiceConstants.SUBSCRIBE_ACTION, NOT_CONNECTED);
            this.service.callbackToActivity(this.clientHandle, Status.ERROR, bundle);
            return;
        }
        new MqttConnectionListener(bundle);
        try {
            this.myClient.subscribe(strArr, iArr, iMqttMessageListenerArr);
        } catch (Exception e2) {
            handleException(bundle, e2);
        }
    }
}
