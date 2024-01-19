package org.eclipse.paho.client.mqttv3.internal;

import java.util.Enumeration;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import org.eclipse.paho.client.mqttv3.BufferedMessage;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttAsyncClient;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttClientPersistence;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.MqttPingSender;
import org.eclipse.paho.client.mqttv3.MqttToken;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttConnack;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttConnect;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttDisconnect;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttPublish;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;
import org.eclipse.paho.client.mqttv3.logging.Logger;
import org.eclipse.paho.client.mqttv3.logging.LoggerFactory;

public class ClientComms {
    public static String BUILD_LEVEL = "L${build.level}";
    public static final String CLASS_NAME = "org.eclipse.paho.client.mqttv3.internal.ClientComms";
    public static final byte CLOSED = 4;
    public static final byte CONNECTED = 0;
    public static final byte CONNECTING = 1;
    public static final byte DISCONNECTED = 3;
    public static final byte DISCONNECTING = 2;
    public static String VERSION = "${project.version}";
    public static final Logger log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, ClientComms.class.getName());
    public CommsCallback callback;
    public IMqttAsyncClient client;
    public ClientState clientState;
    public boolean closePending;
    public Object conLock;
    public MqttConnectOptions conOptions;
    public byte conState;
    public DisconnectedMessageBuffer disconnectedMessageBuffer;
    public ExecutorService executorService;
    public int networkModuleIndex;
    public NetworkModule[] networkModules;
    public MqttClientPersistence persistence;
    public MqttPingSender pingSender;
    public CommsReceiver receiver;
    public boolean resting;
    public CommsSender sender;
    public boolean stoppingComms;
    public CommsTokenStore tokenStore;

    public class ConnectBG implements Runnable {
        public ClientComms clientComms = null;
        public MqttConnect conPacket;
        public MqttToken conToken;
        public String threadName;

        public ConnectBG(ClientComms clientComms2, MqttToken mqttToken, MqttConnect mqttConnect, ExecutorService executorService) {
            this.clientComms = clientComms2;
            this.conToken = mqttToken;
            this.conPacket = mqttConnect;
            this.threadName = "MQTT Con: " + r1.getClient().getClientId();
        }

        public void run() {
            Thread.currentThread().setName(this.threadName);
            ClientComms.log.fine(ClientComms.CLASS_NAME, "connectBG:run", "220");
            MqttException e2 = null;
            try {
                MqttDeliveryToken[] outstandingDelTokens = ClientComms.this.tokenStore.getOutstandingDelTokens();
                for (MqttDeliveryToken mqttDeliveryToken : outstandingDelTokens) {
                    mqttDeliveryToken.internalTok.setException(null);
                }
                ClientComms.this.tokenStore.saveToken(this.conToken, (MqttWireMessage) this.conPacket);
                NetworkModule networkModule = ClientComms.this.networkModules[ClientComms.this.networkModuleIndex];
                networkModule.start();
                ClientComms.this.receiver = new CommsReceiver(this.clientComms, ClientComms.this.clientState, ClientComms.this.tokenStore, networkModule.getInputStream());
                ClientComms.this.receiver.start("MQTT Rec: " + ClientComms.this.getClient().getClientId(), ClientComms.this.executorService);
                ClientComms.this.sender = new CommsSender(this.clientComms, ClientComms.this.clientState, ClientComms.this.tokenStore, networkModule.getOutputStream());
                ClientComms.this.sender.start("MQTT Snd: " + ClientComms.this.getClient().getClientId(), ClientComms.this.executorService);
                ClientComms.this.callback.start("MQTT Call: " + ClientComms.this.getClient().getClientId(), ClientComms.this.executorService);
                ClientComms.this.internalSend(this.conPacket, this.conToken);
            } catch (MqttException e3) {
                e2 = e3;
                ClientComms.log.fine(ClientComms.CLASS_NAME, "connectBG:run", "212", null, e2);
            } catch (Exception e4) {
                ClientComms.log.fine(ClientComms.CLASS_NAME, "connectBG:run", "209", null, e4);
                e2 = ExceptionHelper.createMqttException((Throwable) e4);
            }
            if (e2 != null) {
                ClientComms.this.shutdownConnection(this.conToken, e2);
            }
        }

        public void start() {
            ClientComms.this.executorService.execute(this);
        }
    }

    public class DisconnectBG implements Runnable {
        public MqttDisconnect disconnect;
        public long quiesceTimeout;
        public String threadName;
        public MqttToken token;

        public DisconnectBG(MqttDisconnect mqttDisconnect, long j, MqttToken mqttToken, ExecutorService executorService) {
            this.disconnect = mqttDisconnect;
            this.quiesceTimeout = j;
            this.token = mqttToken;
        }

        public void run() {
            Thread.currentThread().setName(this.threadName);
            ClientComms.log.fine(ClientComms.CLASS_NAME, "disconnectBG:run", "221");
            ClientComms.this.clientState.quiesce(this.quiesceTimeout);
            try {
                ClientComms.this.internalSend(this.disconnect, this.token);
                this.token.internalTok.waitUntilSent();
            } catch (MqttException unused) {
            } catch (Throwable th) {
                this.token.internalTok.markComplete(null, null);
                ClientComms.this.shutdownConnection(this.token, null);
                throw th;
            }
            this.token.internalTok.markComplete(null, null);
            ClientComms.this.shutdownConnection(this.token, null);
        }

        public void start() {
            this.threadName = "MQTT Disc: " + ClientComms.this.getClient().getClientId();
            ClientComms.this.executorService.execute(this);
        }
    }

    public class ReconnectDisconnectedBufferCallback implements IDisconnectedBufferCallback {
        public final String methodName;

        public ReconnectDisconnectedBufferCallback(String str) {
            this.methodName = str;
        }

        public void publishBufferedMessage(BufferedMessage bufferedMessage) throws MqttException {
            if (ClientComms.this.isConnected()) {
                while (ClientComms.this.clientState.getActualInFlight() >= ClientComms.this.clientState.getMaxInFlight() - 1) {
                    Thread.yield();
                }
                ClientComms.log.fine(ClientComms.CLASS_NAME, this.methodName, "510", new Object[]{bufferedMessage.getMessage().getKey()});
                ClientComms.this.internalSend(bufferedMessage.getMessage(), bufferedMessage.getToken());
                ClientComms.this.clientState.unPersistBufferedMessage(bufferedMessage.getMessage());
                return;
            }
            ClientComms.log.fine(ClientComms.CLASS_NAME, this.methodName, "208");
            throw ExceptionHelper.createMqttException(32104);
        }
    }

    public ClientComms(IMqttAsyncClient iMqttAsyncClient, MqttClientPersistence mqttClientPersistence, MqttPingSender mqttPingSender, ExecutorService executorService2) throws MqttException {
        this.stoppingComms = false;
        this.conState = 3;
        this.conLock = new Object();
        this.closePending = false;
        this.resting = false;
        this.conState = 3;
        this.client = iMqttAsyncClient;
        this.persistence = mqttClientPersistence;
        this.pingSender = mqttPingSender;
        mqttPingSender.init(this);
        this.executorService = executorService2;
        this.tokenStore = new CommsTokenStore(getClient().getClientId());
        this.callback = new CommsCallback(this);
        ClientState clientState2 = new ClientState(mqttClientPersistence, this.tokenStore, this.callback, this, mqttPingSender);
        this.clientState = clientState2;
        this.callback.setClientState(clientState2);
        log.setResourceName(getClient().getClientId());
    }

    private MqttToken handleOldTokens(MqttToken mqttToken, MqttException mqttException) {
        log.fine(CLASS_NAME, "handleOldTokens", "222");
        MqttToken mqttToken2 = null;
        if (mqttToken != null) {
            try {
                if (this.tokenStore.getToken(mqttToken.internalTok.getKey()) == null) {
                    this.tokenStore.saveToken(mqttToken, mqttToken.internalTok.getKey());
                }
            } catch (Exception unused) {
            }
        }
        Enumeration elements = this.clientState.resolveOldTokens(mqttException).elements();
        while (elements.hasMoreElements()) {
            MqttToken mqttToken3 = (MqttToken) elements.nextElement();
            if (!mqttToken3.internalTok.getKey().equals("Disc")) {
                if (!mqttToken3.internalTok.getKey().equals("Con")) {
                    this.callback.asyncOperationComplete(mqttToken3);
                }
            }
            mqttToken2 = mqttToken3;
        }
        return mqttToken2;
    }

    private void handleRunException(Exception exc) {
        MqttException mqttException;
        log.fine(CLASS_NAME, "handleRunException", "804", null, exc);
        if (!(exc instanceof MqttException)) {
            mqttException = new MqttException(32109, exc);
        } else {
            mqttException = (MqttException) exc;
        }
        shutdownConnection(null, mqttException);
    }

    private void shutdownExecutorService() {
        this.executorService.shutdown();
        try {
            if (!this.executorService.awaitTermination(1, TimeUnit.SECONDS)) {
                this.executorService.shutdownNow();
                if (!this.executorService.awaitTermination(1, TimeUnit.SECONDS)) {
                    log.fine(CLASS_NAME, "shutdownExecutorService", "executorService did not terminate");
                }
            }
        } catch (InterruptedException unused) {
            this.executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    public MqttToken checkForActivity() {
        return checkForActivity(null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0062, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close(boolean r5) throws org.eclipse.paho.client.mqttv3.MqttException {
        /*
            r4 = this;
            java.lang.Object r0 = r4.conLock
            monitor-enter(r0)
            boolean r1 = r4.isClosed()     // Catch:{ all -> 0x0063 }
            if (r1 != 0) goto L_0x0061
            boolean r1 = r4.isDisconnected()     // Catch:{ all -> 0x0063 }
            if (r1 == 0) goto L_0x0011
            if (r5 == 0) goto L_0x0033
        L_0x0011:
            org.eclipse.paho.client.mqttv3.logging.Logger r5 = log     // Catch:{ all -> 0x0063 }
            java.lang.String r1 = CLASS_NAME     // Catch:{ all -> 0x0063 }
            java.lang.String r2 = "close"
            java.lang.String r3 = "224"
            r5.fine(r1, r2, r3)     // Catch:{ all -> 0x0063 }
            boolean r5 = r4.isConnecting()     // Catch:{ all -> 0x0063 }
            if (r5 != 0) goto L_0x0059
            boolean r5 = r4.isConnected()     // Catch:{ all -> 0x0063 }
            if (r5 != 0) goto L_0x0052
            boolean r5 = r4.isDisconnecting()     // Catch:{ all -> 0x0063 }
            if (r5 == 0) goto L_0x0033
            r5 = 1
            r4.closePending = r5     // Catch:{ all -> 0x0063 }
            monitor-exit(r0)     // Catch:{ all -> 0x0063 }
            return
        L_0x0033:
            r5 = 4
            r4.conState = r5     // Catch:{ all -> 0x0063 }
            r4.shutdownExecutorService()     // Catch:{ all -> 0x0063 }
            org.eclipse.paho.client.mqttv3.internal.ClientState r5 = r4.clientState     // Catch:{ all -> 0x0063 }
            r5.close()     // Catch:{ all -> 0x0063 }
            r5 = 0
            r4.clientState = r5     // Catch:{ all -> 0x0063 }
            r4.callback = r5     // Catch:{ all -> 0x0063 }
            r4.persistence = r5     // Catch:{ all -> 0x0063 }
            r4.sender = r5     // Catch:{ all -> 0x0063 }
            r4.pingSender = r5     // Catch:{ all -> 0x0063 }
            r4.receiver = r5     // Catch:{ all -> 0x0063 }
            r4.networkModules = r5     // Catch:{ all -> 0x0063 }
            r4.conOptions = r5     // Catch:{ all -> 0x0063 }
            r4.tokenStore = r5     // Catch:{ all -> 0x0063 }
            goto L_0x0061
        L_0x0052:
            r5 = 32100(0x7d64, float:4.4982E-41)
            org.eclipse.paho.client.mqttv3.MqttException r5 = org.eclipse.paho.client.mqttv3.internal.ExceptionHelper.createMqttException(r5)     // Catch:{ all -> 0x0063 }
            throw r5     // Catch:{ all -> 0x0063 }
        L_0x0059:
            org.eclipse.paho.client.mqttv3.MqttException r5 = new org.eclipse.paho.client.mqttv3.MqttException     // Catch:{ all -> 0x0063 }
            r1 = 32110(0x7d6e, float:4.4996E-41)
            r5.<init>(r1)     // Catch:{ all -> 0x0063 }
            throw r5     // Catch:{ all -> 0x0063 }
        L_0x0061:
            monitor-exit(r0)     // Catch:{ all -> 0x0063 }
            return
        L_0x0063:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0063 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.paho.client.mqttv3.internal.ClientComms.close(boolean):void");
    }

    public void connect(MqttConnectOptions mqttConnectOptions, MqttToken mqttToken) throws MqttException {
        synchronized (this.conLock) {
            if (!isDisconnected() || this.closePending) {
                log.fine(CLASS_NAME, "connect", "207", new Object[]{new Byte(this.conState)});
                if (isClosed() || this.closePending) {
                    throw new MqttException(32111);
                } else if (isConnecting()) {
                    throw new MqttException(32110);
                } else if (isDisconnecting()) {
                    throw new MqttException(32102);
                } else {
                    throw ExceptionHelper.createMqttException(32100);
                }
            } else {
                log.fine(CLASS_NAME, "connect", "214");
                this.conState = 1;
                this.conOptions = mqttConnectOptions;
                MqttConnect mqttConnect = new MqttConnect(this.client.getClientId(), this.conOptions.getMqttVersion(), this.conOptions.isCleanSession(), this.conOptions.getKeepAliveInterval(), this.conOptions.getUserName(), this.conOptions.getPassword(), this.conOptions.getWillMessage(), this.conOptions.getWillDestination());
                this.clientState.setKeepAliveSecs((long) this.conOptions.getKeepAliveInterval());
                this.clientState.setCleanSession(this.conOptions.isCleanSession());
                this.clientState.setMaxInflight(this.conOptions.getMaxInflight());
                this.tokenStore.open();
                ConnectBG connectBG = new ConnectBG(this, mqttToken, mqttConnect, this.executorService);
                connectBG.start();
            }
        }
    }

    public void connectComplete(MqttConnack mqttConnack, MqttException mqttException) throws MqttException {
        int returnCode = mqttConnack.getReturnCode();
        synchronized (this.conLock) {
            if (returnCode == 0) {
                log.fine(CLASS_NAME, "connectComplete", "215");
                this.conState = 0;
                return;
            }
            log.fine(CLASS_NAME, "connectComplete", "204", new Object[]{new Integer(returnCode)});
            throw mqttException;
        }
    }

    public void deleteBufferedMessage(int i) {
        this.disconnectedMessageBuffer.deleteMessage(i);
    }

    public void deliveryComplete(MqttPublish mqttPublish) throws MqttPersistenceException {
        this.clientState.deliveryComplete(mqttPublish);
    }

    public void disconnect(MqttDisconnect mqttDisconnect, long j, MqttToken mqttToken) throws MqttException {
        synchronized (this.conLock) {
            if (isClosed()) {
                log.fine(CLASS_NAME, "disconnect", "223");
                throw ExceptionHelper.createMqttException(32111);
            } else if (isDisconnected()) {
                log.fine(CLASS_NAME, "disconnect", "211");
                throw ExceptionHelper.createMqttException(32101);
            } else if (isDisconnecting()) {
                log.fine(CLASS_NAME, "disconnect", "219");
                throw ExceptionHelper.createMqttException(32102);
            } else if (Thread.currentThread() != this.callback.getThread()) {
                log.fine(CLASS_NAME, "disconnect", "218");
                this.conState = 2;
                DisconnectBG disconnectBG = new DisconnectBG(mqttDisconnect, j, mqttToken, this.executorService);
                disconnectBG.start();
            } else {
                log.fine(CLASS_NAME, "disconnect", "210");
                throw ExceptionHelper.createMqttException(32107);
            }
        }
    }

    public void disconnectForcibly(long j, long j2) throws MqttException {
        disconnectForcibly(j, j2, true);
    }

    public int getActualInFlight() {
        return this.clientState.getActualInFlight();
    }

    public MqttMessage getBufferedMessage(int i) {
        return ((MqttPublish) this.disconnectedMessageBuffer.getMessage(i).getMessage()).getMessage();
    }

    public int getBufferedMessageCount() {
        return this.disconnectedMessageBuffer.getMessageCount();
    }

    public IMqttAsyncClient getClient() {
        return this.client;
    }

    public ClientState getClientState() {
        return this.clientState;
    }

    public MqttConnectOptions getConOptions() {
        return this.conOptions;
    }

    public Properties getDebug() {
        Properties properties = new Properties();
        properties.put("conState", new Integer(this.conState));
        properties.put("serverURI", getClient().getServerURI());
        properties.put("callback", this.callback);
        properties.put("stoppingComms", new Boolean(this.stoppingComms));
        return properties;
    }

    public long getKeepAlive() {
        return this.clientState.getKeepAlive();
    }

    public int getNetworkModuleIndex() {
        return this.networkModuleIndex;
    }

    public NetworkModule[] getNetworkModules() {
        return this.networkModules;
    }

    public MqttDeliveryToken[] getPendingDeliveryTokens() {
        return this.tokenStore.getOutstandingDelTokens();
    }

    public CommsReceiver getReceiver() {
        return this.receiver;
    }

    public MqttTopic getTopic(String str) {
        return new MqttTopic(str, this);
    }

    public void internalSend(MqttWireMessage mqttWireMessage, MqttToken mqttToken) throws MqttException {
        log.fine(CLASS_NAME, "internalSend", "200", new Object[]{mqttWireMessage.getKey(), mqttWireMessage, mqttToken});
        if (mqttToken.getClient() == null) {
            mqttToken.internalTok.setClient(getClient());
            try {
                this.clientState.send(mqttWireMessage, mqttToken);
            } catch (MqttException e2) {
                if (mqttWireMessage instanceof MqttPublish) {
                    this.clientState.undo((MqttPublish) mqttWireMessage);
                }
                throw e2;
            }
        } else {
            log.fine(CLASS_NAME, "internalSend", "213", new Object[]{mqttWireMessage.getKey(), mqttWireMessage, mqttToken});
            throw new MqttException(32201);
        }
    }

    public boolean isClosed() {
        boolean z;
        synchronized (this.conLock) {
            try {
                z = this.conState == 4;
            }
        }
        return z;
    }

    public boolean isConnected() {
        boolean z;
        synchronized (this.conLock) {
            try {
                z = this.conState == 0;
            }
        }
        return z;
    }

    public boolean isConnecting() {
        boolean z;
        synchronized (this.conLock) {
            try {
                z = true;
                if (this.conState != 1) {
                    z = false;
                }
            }
        }
        return z;
    }

    public boolean isDisconnected() {
        boolean z;
        synchronized (this.conLock) {
            z = this.conState == 3;
        }
        return z;
    }

    public boolean isDisconnecting() {
        boolean z;
        synchronized (this.conLock) {
            try {
                z = this.conState == 2;
            }
        }
        return z;
    }

    public boolean isResting() {
        boolean z;
        synchronized (this.conLock) {
            z = this.resting;
        }
        return z;
    }

    public void messageArrivedComplete(int i, int i2) throws MqttException {
        this.callback.messageArrivedComplete(i, i2);
    }

    public void notifyConnect() {
        if (this.disconnectedMessageBuffer != null) {
            log.fine(CLASS_NAME, "notifyConnect", "509");
            this.disconnectedMessageBuffer.setPublishCallback(new ReconnectDisconnectedBufferCallback("notifyConnect"));
            this.executorService.execute(this.disconnectedMessageBuffer);
        }
    }

    public void removeMessageListener(String str) {
        this.callback.removeMessageListener(str);
    }

    public void sendNoWait(MqttWireMessage mqttWireMessage, MqttToken mqttToken) throws MqttException {
        if (isConnected() || ((!isConnected() && (mqttWireMessage instanceof MqttConnect)) || (isDisconnecting() && (mqttWireMessage instanceof MqttDisconnect)))) {
            DisconnectedMessageBuffer disconnectedMessageBuffer2 = this.disconnectedMessageBuffer;
            if (disconnectedMessageBuffer2 == null || disconnectedMessageBuffer2.getMessageCount() == 0) {
                internalSend(mqttWireMessage, mqttToken);
                return;
            }
            log.fine(CLASS_NAME, "sendNoWait", "507", new Object[]{mqttWireMessage.getKey()});
            if (this.disconnectedMessageBuffer.isPersistBuffer()) {
                this.clientState.persistBufferedMessage(mqttWireMessage);
            }
            this.disconnectedMessageBuffer.putMessage(mqttWireMessage, mqttToken);
        } else if (this.disconnectedMessageBuffer != null) {
            log.fine(CLASS_NAME, "sendNoWait", "508", new Object[]{mqttWireMessage.getKey()});
            if (this.disconnectedMessageBuffer.isPersistBuffer()) {
                this.clientState.persistBufferedMessage(mqttWireMessage);
            }
            this.disconnectedMessageBuffer.putMessage(mqttWireMessage, mqttToken);
        } else {
            log.fine(CLASS_NAME, "sendNoWait", "208");
            throw ExceptionHelper.createMqttException(32104);
        }
    }

    public void setCallback(MqttCallback mqttCallback) {
        this.callback.setCallback(mqttCallback);
    }

    public void setDisconnectedMessageBuffer(DisconnectedMessageBuffer disconnectedMessageBuffer2) {
        this.disconnectedMessageBuffer = disconnectedMessageBuffer2;
    }

    public void setManualAcks(boolean z) {
        this.callback.setManualAcks(z);
    }

    public void setMessageListener(String str, IMqttMessageListener iMqttMessageListener) {
        this.callback.setMessageListener(str, iMqttMessageListener);
    }

    public void setNetworkModuleIndex(int i) {
        this.networkModuleIndex = i;
    }

    public void setNetworkModules(NetworkModule[] networkModuleArr) {
        this.networkModules = networkModuleArr;
    }

    public void setReconnectCallback(MqttCallbackExtended mqttCallbackExtended) {
        this.callback.setReconnectCallback(mqttCallbackExtended);
    }

    public void setRestingState(boolean z) {
        this.resting = z;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:74|75|(2:77|78)|79|80) */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0036, code lost:
        if (r9 == null) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003c, code lost:
        if (r9.isComplete() != false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003e, code lost:
        r9.internalTok.setException(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0043, code lost:
        r0 = r8.callback;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0045, code lost:
        if (r0 == null) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0047, code lost:
        r0.stop();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004a, code lost:
        r0 = r8.receiver;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004c, code lost:
        if (r0 == null) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004e, code lost:
        r0.stop();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0053, code lost:
        if (r8.networkModules == null) goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0055, code lost:
        r0 = r8.networkModules[r8.networkModuleIndex];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x005b, code lost:
        if (r0 == null) goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x005d, code lost:
        r0.stop();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:79:0x00d9 */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a2 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00d2 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void shutdownConnection(org.eclipse.paho.client.mqttv3.MqttToken r9, org.eclipse.paho.client.mqttv3.MqttException r10) {
        /*
            r8 = this;
            java.lang.Object r0 = r8.conLock
            monitor-enter(r0)
            boolean r1 = r8.stoppingComms     // Catch:{ all -> 0x00e3 }
            if (r1 != 0) goto L_0x00e1
            boolean r1 = r8.closePending     // Catch:{ all -> 0x00e3 }
            if (r1 != 0) goto L_0x00e1
            boolean r1 = r8.isClosed()     // Catch:{ all -> 0x00e3 }
            if (r1 == 0) goto L_0x0013
            goto L_0x00e1
        L_0x0013:
            r1 = 1
            r8.stoppingComms = r1     // Catch:{ all -> 0x00e3 }
            org.eclipse.paho.client.mqttv3.logging.Logger r2 = log     // Catch:{ all -> 0x00e3 }
            java.lang.String r3 = CLASS_NAME     // Catch:{ all -> 0x00e3 }
            java.lang.String r4 = "shutdownConnection"
            java.lang.String r5 = "216"
            r2.fine(r3, r4, r5)     // Catch:{ all -> 0x00e3 }
            boolean r2 = r8.isConnected()     // Catch:{ all -> 0x00e3 }
            r3 = 0
            if (r2 != 0) goto L_0x0031
            boolean r2 = r8.isDisconnecting()     // Catch:{ all -> 0x00e3 }
            if (r2 != 0) goto L_0x0031
            r2 = 0
            goto L_0x0032
        L_0x0031:
            r2 = 1
        L_0x0032:
            r4 = 2
            r8.conState = r4     // Catch:{ all -> 0x00e3 }
            monitor-exit(r0)     // Catch:{ all -> 0x00e3 }
            if (r9 == 0) goto L_0x0043
            boolean r0 = r9.isComplete()
            if (r0 != 0) goto L_0x0043
            org.eclipse.paho.client.mqttv3.internal.Token r0 = r9.internalTok
            r0.setException(r10)
        L_0x0043:
            org.eclipse.paho.client.mqttv3.internal.CommsCallback r0 = r8.callback
            if (r0 == 0) goto L_0x004a
            r0.stop()
        L_0x004a:
            org.eclipse.paho.client.mqttv3.internal.CommsReceiver r0 = r8.receiver
            if (r0 == 0) goto L_0x0051
            r0.stop()
        L_0x0051:
            org.eclipse.paho.client.mqttv3.internal.NetworkModule[] r0 = r8.networkModules     // Catch:{ Exception -> 0x0060 }
            if (r0 == 0) goto L_0x0060
            org.eclipse.paho.client.mqttv3.internal.NetworkModule[] r0 = r8.networkModules     // Catch:{ Exception -> 0x0060 }
            int r4 = r8.networkModuleIndex     // Catch:{ Exception -> 0x0060 }
            r0 = r0[r4]     // Catch:{ Exception -> 0x0060 }
            if (r0 == 0) goto L_0x0060
            r0.stop()     // Catch:{ Exception -> 0x0060 }
        L_0x0060:
            org.eclipse.paho.client.mqttv3.internal.CommsTokenStore r0 = r8.tokenStore
            org.eclipse.paho.client.mqttv3.MqttException r4 = new org.eclipse.paho.client.mqttv3.MqttException
            r5 = 32102(0x7d66, float:4.4984E-41)
            r4.<init>(r5)
            r0.quiesce(r4)
            org.eclipse.paho.client.mqttv3.MqttToken r9 = r8.handleOldTokens(r9, r10)
            org.eclipse.paho.client.mqttv3.internal.ClientState r0 = r8.clientState     // Catch:{ Exception -> 0x0083 }
            r0.disconnected(r10)     // Catch:{ Exception -> 0x0083 }
            org.eclipse.paho.client.mqttv3.internal.ClientState r0 = r8.clientState     // Catch:{ Exception -> 0x0083 }
            boolean r0 = r0.getCleanSession()     // Catch:{ Exception -> 0x0083 }
            if (r0 == 0) goto L_0x0084
            org.eclipse.paho.client.mqttv3.internal.CommsCallback r0 = r8.callback     // Catch:{ Exception -> 0x0083 }
            r0.removeMessageListeners()     // Catch:{ Exception -> 0x0083 }
            goto L_0x0084
        L_0x0083:
        L_0x0084:
            org.eclipse.paho.client.mqttv3.internal.CommsSender r0 = r8.sender
            if (r0 == 0) goto L_0x008b
            r0.stop()
        L_0x008b:
            org.eclipse.paho.client.mqttv3.MqttPingSender r0 = r8.pingSender
            if (r0 == 0) goto L_0x0092
            r0.stop()
        L_0x0092:
            org.eclipse.paho.client.mqttv3.internal.DisconnectedMessageBuffer r0 = r8.disconnectedMessageBuffer     // Catch:{ Exception -> 0x009f }
            if (r0 != 0) goto L_0x009f
            org.eclipse.paho.client.mqttv3.MqttClientPersistence r0 = r8.persistence     // Catch:{ Exception -> 0x009f }
            if (r0 == 0) goto L_0x009f
            org.eclipse.paho.client.mqttv3.MqttClientPersistence r0 = r8.persistence     // Catch:{ Exception -> 0x009f }
            r0.close()     // Catch:{ Exception -> 0x009f }
        L_0x009f:
            java.lang.Object r4 = r8.conLock
            monitor-enter(r4)
            org.eclipse.paho.client.mqttv3.logging.Logger r0 = log     // Catch:{ all -> 0x00de }
            java.lang.String r5 = CLASS_NAME     // Catch:{ all -> 0x00de }
            java.lang.String r6 = "shutdownConnection"
            java.lang.String r7 = "217"
            r0.fine(r5, r6, r7)     // Catch:{ all -> 0x00de }
            r0 = 3
            r8.conState = r0     // Catch:{ all -> 0x00de }
            r8.stoppingComms = r3     // Catch:{ all -> 0x00de }
            monitor-exit(r4)     // Catch:{ all -> 0x00de }
            if (r9 == 0) goto L_0x00b8
            r0 = 1
            goto L_0x00b9
        L_0x00b8:
            r0 = 0
        L_0x00b9:
            org.eclipse.paho.client.mqttv3.internal.CommsCallback r4 = r8.callback
            if (r4 == 0) goto L_0x00be
            r3 = 1
        L_0x00be:
            r0 = r0 & r3
            if (r0 == 0) goto L_0x00c6
            org.eclipse.paho.client.mqttv3.internal.CommsCallback r0 = r8.callback
            r0.asyncOperationComplete(r9)
        L_0x00c6:
            if (r2 == 0) goto L_0x00cf
            org.eclipse.paho.client.mqttv3.internal.CommsCallback r9 = r8.callback
            if (r9 == 0) goto L_0x00cf
            r9.connectionLost(r10)
        L_0x00cf:
            java.lang.Object r9 = r8.conLock
            monitor-enter(r9)
            boolean r10 = r8.closePending     // Catch:{ all -> 0x00db }
            if (r10 == 0) goto L_0x00d9
            r8.close(r1)     // Catch:{ Exception -> 0x00d9 }
        L_0x00d9:
            monitor-exit(r9)     // Catch:{ all -> 0x00db }
            return
        L_0x00db:
            r10 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x00db }
            throw r10
        L_0x00de:
            r9 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x00de }
            throw r9
        L_0x00e1:
            monitor-exit(r0)     // Catch:{ all -> 0x00e3 }
            return
        L_0x00e3:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00e3 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.paho.client.mqttv3.internal.ClientComms.shutdownConnection(org.eclipse.paho.client.mqttv3.MqttToken, org.eclipse.paho.client.mqttv3.MqttException):void");
    }

    public MqttToken checkForActivity(IMqttActionListener iMqttActionListener) {
        try {
            return this.clientState.checkForActivity(iMqttActionListener);
        } catch (MqttException e2) {
            handleRunException(e2);
            return null;
        } catch (Exception e3) {
            handleRunException(e3);
            return null;
        }
    }

    public void deliveryComplete(int i) throws MqttPersistenceException {
        this.clientState.deliveryComplete(i);
    }

    public void disconnectForcibly(long j, long j2, boolean z) throws MqttException {
        ClientState clientState2 = this.clientState;
        if (clientState2 != null) {
            clientState2.quiesce(j);
        }
        MqttToken mqttToken = new MqttToken(this.client.getClientId());
        if (z) {
            try {
                internalSend(new MqttDisconnect(), mqttToken);
                mqttToken.waitForCompletion(j2);
            } catch (Exception unused) {
            } catch (Throwable th) {
                mqttToken.internalTok.markComplete(null, null);
                shutdownConnection(mqttToken, null);
                throw th;
            }
        }
        mqttToken.internalTok.markComplete(null, null);
        shutdownConnection(mqttToken, null);
    }
}
