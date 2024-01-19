package org.eclipse.paho.client.mqttv3;

import com.mpl.payment.gopay.GopayLinkingHandler;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.internal.http2.Http2ExchangeCodec;
import org.eclipse.paho.android.service.MqttServiceConstants;
import org.eclipse.paho.client.mqttv3.internal.ClientComms;
import org.eclipse.paho.client.mqttv3.internal.ConnectActionListener;
import org.eclipse.paho.client.mqttv3.internal.DisconnectedMessageBuffer;
import org.eclipse.paho.client.mqttv3.internal.ExceptionHelper;
import org.eclipse.paho.client.mqttv3.internal.NetworkModule;
import org.eclipse.paho.client.mqttv3.internal.SSLNetworkModule;
import org.eclipse.paho.client.mqttv3.internal.TCPNetworkModule;
import org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory;
import org.eclipse.paho.client.mqttv3.internal.websocket.WebSocketNetworkModule;
import org.eclipse.paho.client.mqttv3.internal.websocket.WebSocketSecureNetworkModule;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttDisconnect;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttPublish;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttSubscribe;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttUnsubscribe;
import org.eclipse.paho.client.mqttv3.logging.Logger;
import org.eclipse.paho.client.mqttv3.logging.LoggerFactory;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.eclipse.paho.client.mqttv3.persist.MqttDefaultFilePersistence;
import org.eclipse.paho.client.mqttv3.util.Debug;

public class MqttAsyncClient implements IMqttAsyncClient {
    public static final String CLASS_NAME = "org.eclipse.paho.client.mqttv3.MqttAsyncClient";
    public static final String CLIENT_ID_PREFIX = "paho";
    public static final long DISCONNECT_TIMEOUT = 10000;
    public static final char MAX_HIGH_SURROGATE = '?';
    public static final char MIN_HIGH_SURROGATE = '?';
    public static final long QUIESCE_TIMEOUT = 30000;
    public static Object clientLock = new Object();
    public static final Logger log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, MqttAsyncClient.class.getName());
    public static int reconnectDelay = 1000;
    public String clientId;
    public ClientComms comms;
    public MqttConnectOptions connOpts;
    public ScheduledExecutorService executorService;
    public MqttCallback mqttCallback;
    public MqttClientPersistence persistence;
    public Timer reconnectTimer;
    public boolean reconnecting;
    public String serverURI;
    public Hashtable topics;
    public Object userContext;

    public class MqttReconnectActionListener implements IMqttActionListener {
        public final String methodName;

        public MqttReconnectActionListener(String str) {
            this.methodName = str;
        }

        private void rescheduleReconnectCycle(int i) {
            MqttAsyncClient.log.fine(MqttAsyncClient.CLASS_NAME, String.valueOf(this.methodName) + ":rescheduleReconnectCycle", "505", new Object[]{MqttAsyncClient.this.clientId, String.valueOf(MqttAsyncClient.reconnectDelay)});
            synchronized (MqttAsyncClient.clientLock) {
                if (MqttAsyncClient.this.connOpts.isAutomaticReconnect()) {
                    if (MqttAsyncClient.this.reconnectTimer != null) {
                        MqttAsyncClient.this.reconnectTimer.schedule(new ReconnectTask(MqttAsyncClient.this, null), (long) i);
                    } else {
                        MqttAsyncClient.reconnectDelay = i;
                        MqttAsyncClient.this.startReconnectCycle();
                    }
                }
            }
        }

        public void onFailure(IMqttToken iMqttToken, Throwable th) {
            MqttAsyncClient.log.fine(MqttAsyncClient.CLASS_NAME, this.methodName, "502", new Object[]{iMqttToken.getClient().getClientId()});
            if (MqttAsyncClient.reconnectDelay < 128000) {
                MqttAsyncClient.reconnectDelay = MqttAsyncClient.reconnectDelay * 2;
            }
            rescheduleReconnectCycle(MqttAsyncClient.reconnectDelay);
        }

        public void onSuccess(IMqttToken iMqttToken) {
            MqttAsyncClient.log.fine(MqttAsyncClient.CLASS_NAME, this.methodName, "501", new Object[]{iMqttToken.getClient().getClientId()});
            MqttAsyncClient.this.comms.setRestingState(false);
            MqttAsyncClient.this.stopReconnectCycle();
        }
    }

    public class MqttReconnectCallback implements MqttCallbackExtended {
        public final boolean automaticReconnect;

        public MqttReconnectCallback(boolean z) {
            this.automaticReconnect = z;
        }

        public void connectComplete(boolean z, String str) {
        }

        public void connectionLost(Throwable th) {
            if (this.automaticReconnect) {
                MqttAsyncClient.this.comms.setRestingState(true);
                MqttAsyncClient.this.reconnecting = true;
                MqttAsyncClient.this.startReconnectCycle();
            }
        }

        public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        }

        public void messageArrived(String str, MqttMessage mqttMessage) throws Exception {
        }
    }

    public class ReconnectTask extends TimerTask {
        public static final String methodName = "ReconnectTask.run";

        public ReconnectTask() {
        }

        public void run() {
            MqttAsyncClient.log.fine(MqttAsyncClient.CLASS_NAME, methodName, "506");
            MqttAsyncClient.this.attemptReconnect();
        }

        public /* synthetic */ ReconnectTask(MqttAsyncClient mqttAsyncClient, ReconnectTask reconnectTask) {
            this();
        }
    }

    public MqttAsyncClient(String str, String str2) throws MqttException {
        this(str, str2, new MqttDefaultFilePersistence());
    }

    public static boolean Character_isHighSurrogate(char c2) {
        return c2 >= 55296 && c2 <= 56319;
    }

    /* access modifiers changed from: private */
    public void attemptReconnect() {
        log.fine(CLASS_NAME, "attemptReconnect", "500", new Object[]{this.clientId});
        try {
            connect(this.connOpts, this.userContext, new MqttReconnectActionListener("attemptReconnect"));
        } catch (MqttSecurityException e2) {
            log.fine(CLASS_NAME, "attemptReconnect", "804", null, e2);
        } catch (MqttException e3) {
            log.fine(CLASS_NAME, "attemptReconnect", "804", null, e3);
        }
    }

    private NetworkModule createNetworkModule(String str, MqttConnectOptions mqttConnectOptions) throws MqttException, MqttSecurityException {
        SSLSocketFactoryFactory sSLSocketFactoryFactory;
        SSLSocketFactoryFactory sSLSocketFactoryFactory2;
        log.fine(CLASS_NAME, "createNetworkModule", "115", new Object[]{str});
        SocketFactory socketFactory = mqttConnectOptions.getSocketFactory();
        int validateURI = MqttConnectOptions.validateURI(str);
        try {
            URI uri = new URI(str);
            if (uri.getHost() == null && str.contains("_")) {
                Field declaredField = URI.class.getDeclaredField(Http2ExchangeCodec.HOST);
                declaredField.setAccessible(true);
                declaredField.set(uri, getHostName(str.substring(uri.getScheme().length() + 3)));
            }
            String host = uri.getHost();
            int port = uri.getPort();
            if (validateURI == 0) {
                if (port == -1) {
                    port = 1883;
                }
                if (socketFactory == null) {
                    socketFactory = SocketFactory.getDefault();
                } else if (socketFactory instanceof SSLSocketFactory) {
                    throw ExceptionHelper.createMqttException(32105);
                }
                TCPNetworkModule tCPNetworkModule = new TCPNetworkModule(socketFactory, host, port, this.clientId);
                tCPNetworkModule.setConnectTimeout(mqttConnectOptions.getConnectionTimeout());
                return tCPNetworkModule;
            } else if (validateURI == 1) {
                if (port == -1) {
                    port = 8883;
                }
                if (socketFactory == null) {
                    sSLSocketFactoryFactory = new SSLSocketFactoryFactory();
                    Properties sSLProperties = mqttConnectOptions.getSSLProperties();
                    if (sSLProperties != null) {
                        sSLSocketFactoryFactory.initialize(sSLProperties, null);
                    }
                    socketFactory = sSLSocketFactoryFactory.createSocketFactory(null);
                } else if (socketFactory instanceof SSLSocketFactory) {
                    sSLSocketFactoryFactory = null;
                } else {
                    throw ExceptionHelper.createMqttException(32105);
                }
                SSLNetworkModule sSLNetworkModule = new SSLNetworkModule((SSLSocketFactory) socketFactory, host, port, this.clientId);
                sSLNetworkModule.setSSLhandshakeTimeout(mqttConnectOptions.getConnectionTimeout());
                sSLNetworkModule.setSSLHostnameVerifier(mqttConnectOptions.getSSLHostnameVerifier());
                if (sSLSocketFactoryFactory != null) {
                    String[] enabledCipherSuites = sSLSocketFactoryFactory.getEnabledCipherSuites(null);
                    if (enabledCipherSuites != null) {
                        sSLNetworkModule.setEnabledCiphers(enabledCipherSuites);
                    }
                }
                return sSLNetworkModule;
            } else if (validateURI == 3) {
                int i = port == -1 ? 80 : port;
                if (socketFactory == null) {
                    socketFactory = SocketFactory.getDefault();
                } else if (socketFactory instanceof SSLSocketFactory) {
                    throw ExceptionHelper.createMqttException(32105);
                }
                WebSocketNetworkModule webSocketNetworkModule = new WebSocketNetworkModule(socketFactory, str, host, i, this.clientId);
                webSocketNetworkModule.setConnectTimeout(mqttConnectOptions.getConnectionTimeout());
                return webSocketNetworkModule;
            } else if (validateURI != 4) {
                log.fine(CLASS_NAME, "createNetworkModule", "119", new Object[]{str});
                return null;
            } else {
                int i2 = port == -1 ? 443 : port;
                if (socketFactory == null) {
                    SSLSocketFactoryFactory sSLSocketFactoryFactory3 = new SSLSocketFactoryFactory();
                    Properties sSLProperties2 = mqttConnectOptions.getSSLProperties();
                    if (sSLProperties2 != null) {
                        sSLSocketFactoryFactory3.initialize(sSLProperties2, null);
                    }
                    sSLSocketFactoryFactory2 = sSLSocketFactoryFactory3;
                    socketFactory = sSLSocketFactoryFactory3.createSocketFactory(null);
                } else if (socketFactory instanceof SSLSocketFactory) {
                    sSLSocketFactoryFactory2 = null;
                } else {
                    throw ExceptionHelper.createMqttException(32105);
                }
                WebSocketSecureNetworkModule webSocketSecureNetworkModule = new WebSocketSecureNetworkModule((SSLSocketFactory) socketFactory, str, host, i2, this.clientId);
                webSocketSecureNetworkModule.setSSLhandshakeTimeout(mqttConnectOptions.getConnectionTimeout());
                if (sSLSocketFactoryFactory2 != null) {
                    String[] enabledCipherSuites2 = sSLSocketFactoryFactory2.getEnabledCipherSuites(null);
                    if (enabledCipherSuites2 != null) {
                        webSocketSecureNetworkModule.setEnabledCiphers(enabledCipherSuites2);
                    }
                }
                return webSocketSecureNetworkModule;
            }
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException e2) {
            throw ExceptionHelper.createMqttException(e2.getCause());
        } catch (URISyntaxException e3) {
            throw new IllegalArgumentException("Malformed URI: " + str + ", " + e3.getMessage());
        }
    }

    public static String generateClientId() {
        return CLIENT_ID_PREFIX + System.nanoTime();
    }

    private String getHostName(String str) {
        int indexOf = str.indexOf(58);
        if (indexOf == -1) {
            indexOf = str.indexOf(47);
        }
        if (indexOf == -1) {
            indexOf = str.length();
        }
        return str.substring(0, indexOf);
    }

    /* access modifiers changed from: private */
    public void startReconnectCycle() {
        log.fine(CLASS_NAME, "startReconnectCycle", "503", new Object[]{this.clientId, new Long((long) reconnectDelay)});
        Timer timer = new Timer("MQTT Reconnect: " + this.clientId);
        this.reconnectTimer = timer;
        timer.schedule(new ReconnectTask(this, null), (long) reconnectDelay);
    }

    /* access modifiers changed from: private */
    public void stopReconnectCycle() {
        log.fine(CLASS_NAME, "stopReconnectCycle", "504", new Object[]{this.clientId});
        synchronized (clientLock) {
            if (this.connOpts.isAutomaticReconnect()) {
                if (this.reconnectTimer != null) {
                    this.reconnectTimer.cancel();
                    this.reconnectTimer = null;
                }
                reconnectDelay = 1000;
            }
        }
    }

    public IMqttToken checkPing(Object obj, IMqttActionListener iMqttActionListener) throws MqttException {
        log.fine(CLASS_NAME, "ping", "117");
        MqttToken checkForActivity = this.comms.checkForActivity();
        log.fine(CLASS_NAME, "ping", "118");
        return checkForActivity;
    }

    public void close() throws MqttException {
        close(false);
    }

    public IMqttToken connect(Object obj, IMqttActionListener iMqttActionListener) throws MqttException, MqttSecurityException {
        return connect(new MqttConnectOptions(), obj, iMqttActionListener);
    }

    public NetworkModule[] createNetworkModules(String str, MqttConnectOptions mqttConnectOptions) throws MqttException, MqttSecurityException {
        log.fine(CLASS_NAME, "createNetworkModules", "116", new Object[]{str});
        String[] serverURIs = mqttConnectOptions.getServerURIs();
        if (serverURIs == null) {
            serverURIs = new String[]{str};
        } else if (serverURIs.length == 0) {
            serverURIs = new String[]{str};
        }
        NetworkModule[] networkModuleArr = new NetworkModule[serverURIs.length];
        for (int i = 0; i < serverURIs.length; i++) {
            networkModuleArr[i] = createNetworkModule(serverURIs[i], mqttConnectOptions);
        }
        log.fine(CLASS_NAME, "createNetworkModules", "108");
        return networkModuleArr;
    }

    public void deleteBufferedMessage(int i) {
        this.comms.deleteBufferedMessage(i);
    }

    public IMqttToken disconnect(Object obj, IMqttActionListener iMqttActionListener) throws MqttException {
        return disconnect(30000, obj, iMqttActionListener);
    }

    public void disconnectForcibly() throws MqttException {
        disconnectForcibly(30000, DISCONNECT_TIMEOUT);
    }

    public MqttMessage getBufferedMessage(int i) {
        return this.comms.getBufferedMessage(i);
    }

    public int getBufferedMessageCount() {
        return this.comms.getBufferedMessageCount();
    }

    public String getClientId() {
        return this.clientId;
    }

    public String getCurrentServerURI() {
        return this.comms.getNetworkModules()[this.comms.getNetworkModuleIndex()].getServerURI();
    }

    public Debug getDebug() {
        return new Debug(this.clientId, this.comms);
    }

    public int getInFlightMessageCount() {
        return this.comms.getActualInFlight();
    }

    public IMqttDeliveryToken[] getPendingDeliveryTokens() {
        return this.comms.getPendingDeliveryTokens();
    }

    public String getServerURI() {
        return this.serverURI;
    }

    public MqttTopic getTopic(String str) {
        MqttTopic.validate(str, false);
        MqttTopic mqttTopic = (MqttTopic) this.topics.get(str);
        if (mqttTopic != null) {
            return mqttTopic;
        }
        MqttTopic mqttTopic2 = new MqttTopic(str, this.comms);
        this.topics.put(str, mqttTopic2);
        return mqttTopic2;
    }

    public boolean isConnected() {
        return this.comms.isConnected();
    }

    public void messageArrivedComplete(int i, int i2) throws MqttException {
        this.comms.messageArrivedComplete(i, i2);
    }

    public IMqttDeliveryToken publish(String str, byte[] bArr, int i, boolean z, Object obj, IMqttActionListener iMqttActionListener) throws MqttException, MqttPersistenceException {
        MqttMessage mqttMessage = new MqttMessage(bArr);
        mqttMessage.setQos(i);
        mqttMessage.setRetained(z);
        return publish(str, mqttMessage, obj, iMqttActionListener);
    }

    public void reconnect() throws MqttException {
        log.fine(CLASS_NAME, "reconnect", "500", new Object[]{this.clientId});
        if (this.comms.isConnected()) {
            throw ExceptionHelper.createMqttException(32100);
        } else if (this.comms.isConnecting()) {
            throw new MqttException(32110);
        } else if (this.comms.isDisconnecting()) {
            throw new MqttException(32102);
        } else if (!this.comms.isClosed()) {
            stopReconnectCycle();
            attemptReconnect();
        } else {
            throw new MqttException(32111);
        }
    }

    public void setBufferOpts(DisconnectedBufferOptions disconnectedBufferOptions) {
        this.comms.setDisconnectedMessageBuffer(new DisconnectedMessageBuffer(disconnectedBufferOptions));
    }

    public void setCallback(MqttCallback mqttCallback2) {
        this.mqttCallback = mqttCallback2;
        this.comms.setCallback(mqttCallback2);
    }

    public void setManualAcks(boolean z) {
        this.comms.setManualAcks(z);
    }

    public IMqttToken subscribe(String str, int i, Object obj, IMqttActionListener iMqttActionListener) throws MqttException {
        return subscribe(new String[]{str}, new int[]{i}, obj, iMqttActionListener);
    }

    public IMqttToken unsubscribe(String str, Object obj, IMqttActionListener iMqttActionListener) throws MqttException {
        return unsubscribe(new String[]{str}, obj, iMqttActionListener);
    }

    public MqttAsyncClient(String str, String str2, MqttClientPersistence mqttClientPersistence) throws MqttException {
        this(str, str2, mqttClientPersistence, new TimerPingSender());
    }

    public void close(boolean z) throws MqttException {
        log.fine(CLASS_NAME, "close", "113");
        this.comms.close(z);
        log.fine(CLASS_NAME, "close", "114");
    }

    public IMqttToken connect() throws MqttException, MqttSecurityException {
        return connect(null, null);
    }

    public IMqttToken disconnect() throws MqttException {
        return disconnect(null, null);
    }

    public void disconnectForcibly(long j) throws MqttException {
        disconnectForcibly(30000, j);
    }

    public IMqttToken subscribe(String str, int i) throws MqttException {
        return subscribe(new String[]{str}, new int[]{i}, (Object) null, (IMqttActionListener) null);
    }

    public IMqttToken unsubscribe(String str) throws MqttException {
        return unsubscribe(new String[]{str}, (Object) null, (IMqttActionListener) null);
    }

    public MqttAsyncClient(String str, String str2, MqttClientPersistence mqttClientPersistence, MqttPingSender mqttPingSender) throws MqttException {
        this(str, str2, mqttClientPersistence, mqttPingSender, null);
    }

    public IMqttToken connect(MqttConnectOptions mqttConnectOptions) throws MqttException, MqttSecurityException {
        return connect(mqttConnectOptions, null, null);
    }

    public IMqttToken disconnect(long j) throws MqttException {
        return disconnect(j, null, null);
    }

    public void disconnectForcibly(long j, long j2) throws MqttException {
        this.comms.disconnectForcibly(j, j2);
    }

    public IMqttToken subscribe(String[] strArr, int[] iArr) throws MqttException {
        return subscribe(strArr, iArr, (Object) null, (IMqttActionListener) null);
    }

    public IMqttToken unsubscribe(String[] strArr) throws MqttException {
        return unsubscribe(strArr, (Object) null, (IMqttActionListener) null);
    }

    public MqttAsyncClient(String str, String str2, MqttClientPersistence mqttClientPersistence, MqttPingSender mqttPingSender, ScheduledExecutorService scheduledExecutorService) throws MqttException {
        this.reconnecting = false;
        log.setResourceName(str2);
        if (str2 != null) {
            int i = 0;
            int i2 = 0;
            while (i < str2.length() - 1) {
                if (Character_isHighSurrogate(str2.charAt(i))) {
                    i++;
                }
                i2++;
                i++;
            }
            if (i2 <= 65535) {
                MqttConnectOptions.validateURI(str);
                this.serverURI = str;
                this.clientId = str2;
                this.persistence = mqttClientPersistence;
                if (mqttClientPersistence == null) {
                    this.persistence = new MemoryPersistence();
                }
                this.executorService = scheduledExecutorService;
                if (scheduledExecutorService == null) {
                    this.executorService = Executors.newScheduledThreadPool(10);
                }
                log.fine(CLASS_NAME, "MqttAsyncClient", "101", new Object[]{str2, str, mqttClientPersistence});
                this.persistence.open(str2, str);
                this.comms = new ClientComms(this, this.persistence, mqttPingSender, this.executorService);
                this.persistence.close();
                this.topics = new Hashtable();
                return;
            }
            throw new IllegalArgumentException("ClientId longer than 65535 characters");
        }
        throw new IllegalArgumentException("Null clientId");
    }

    public IMqttToken connect(MqttConnectOptions mqttConnectOptions, Object obj, IMqttActionListener iMqttActionListener) throws MqttException, MqttSecurityException {
        if (this.comms.isConnected()) {
            throw ExceptionHelper.createMqttException(32100);
        } else if (this.comms.isConnecting()) {
            throw new MqttException(32110);
        } else if (this.comms.isDisconnecting()) {
            throw new MqttException(32102);
        } else if (!this.comms.isClosed()) {
            if (mqttConnectOptions == null) {
                mqttConnectOptions = new MqttConnectOptions();
            }
            MqttConnectOptions mqttConnectOptions2 = mqttConnectOptions;
            this.connOpts = mqttConnectOptions2;
            this.userContext = obj;
            boolean isAutomaticReconnect = mqttConnectOptions2.isAutomaticReconnect();
            Logger logger = log;
            String str = CLASS_NAME;
            Object[] objArr = new Object[8];
            objArr[0] = Boolean.valueOf(mqttConnectOptions2.isCleanSession());
            objArr[1] = new Integer(mqttConnectOptions2.getConnectionTimeout());
            objArr[2] = new Integer(mqttConnectOptions2.getKeepAliveInterval());
            objArr[3] = mqttConnectOptions2.getUserName();
            Object obj2 = "[null]";
            objArr[4] = mqttConnectOptions2.getPassword() == null ? obj2 : "[notnull]";
            if (mqttConnectOptions2.getWillMessage() != null) {
                obj2 = "[notnull]";
            }
            objArr[5] = obj2;
            objArr[6] = obj;
            objArr[7] = iMqttActionListener;
            logger.fine(str, "connect", "103", objArr);
            this.comms.setNetworkModules(createNetworkModules(this.serverURI, mqttConnectOptions2));
            this.comms.setReconnectCallback(new MqttReconnectCallback(isAutomaticReconnect));
            MqttToken mqttToken = new MqttToken(getClientId());
            ConnectActionListener connectActionListener = new ConnectActionListener(this, this.persistence, this.comms, mqttConnectOptions2, mqttToken, obj, iMqttActionListener, this.reconnecting);
            mqttToken.setActionCallback(connectActionListener);
            mqttToken.setUserContext(this);
            MqttCallback mqttCallback2 = this.mqttCallback;
            if (mqttCallback2 instanceof MqttCallbackExtended) {
                connectActionListener.setMqttCallbackExtended((MqttCallbackExtended) mqttCallback2);
            }
            this.comms.setNetworkModuleIndex(0);
            connectActionListener.connect();
            return mqttToken;
        } else {
            throw new MqttException(32111);
        }
    }

    public IMqttToken disconnect(long j, Object obj, IMqttActionListener iMqttActionListener) throws MqttException {
        log.fine(CLASS_NAME, "disconnect", "104", new Object[]{new Long(j), obj, iMqttActionListener});
        MqttToken mqttToken = new MqttToken(getClientId());
        mqttToken.setActionCallback(iMqttActionListener);
        mqttToken.setUserContext(obj);
        try {
            this.comms.disconnect(new MqttDisconnect(), j, mqttToken);
            log.fine(CLASS_NAME, "disconnect", "108");
            return mqttToken;
        } catch (MqttException e2) {
            log.fine(CLASS_NAME, "disconnect", GopayLinkingHandler.CRC_NO_GOPAY_ACCOUNT, null, e2);
            throw e2;
        }
    }

    public void disconnectForcibly(long j, long j2, boolean z) throws MqttException {
        this.comms.disconnectForcibly(j, j2, z);
    }

    public IMqttToken subscribe(String[] strArr, int[] iArr, Object obj, IMqttActionListener iMqttActionListener) throws MqttException {
        if (strArr.length == iArr.length) {
            for (String removeMessageListener : strArr) {
                this.comms.removeMessageListener(removeMessageListener);
            }
            if (log.isLoggable(5)) {
                StringBuffer stringBuffer = new StringBuffer();
                for (int i = 0; i < strArr.length; i++) {
                    if (i > 0) {
                        stringBuffer.append(", ");
                    }
                    stringBuffer.append("topic=");
                    stringBuffer.append(strArr[i]);
                    stringBuffer.append(" qos=");
                    stringBuffer.append(iArr[i]);
                    MqttTopic.validate(strArr[i], true);
                }
                log.fine(CLASS_NAME, MqttServiceConstants.SUBSCRIBE_ACTION, "106", new Object[]{stringBuffer.toString(), obj, iMqttActionListener});
            }
            MqttToken mqttToken = new MqttToken(getClientId());
            mqttToken.setActionCallback(iMqttActionListener);
            mqttToken.setUserContext(obj);
            mqttToken.internalTok.setTopics(strArr);
            this.comms.sendNoWait(new MqttSubscribe(strArr, iArr), mqttToken);
            log.fine(CLASS_NAME, MqttServiceConstants.SUBSCRIBE_ACTION, "109");
            return mqttToken;
        }
        throw new IllegalArgumentException();
    }

    public IMqttToken unsubscribe(String[] strArr, Object obj, IMqttActionListener iMqttActionListener) throws MqttException {
        if (log.isLoggable(5)) {
            String str = "";
            for (int i = 0; i < strArr.length; i++) {
                if (i > 0) {
                    str = String.valueOf(str) + ", ";
                }
                str = String.valueOf(str) + strArr[i];
            }
            log.fine(CLASS_NAME, MqttServiceConstants.UNSUBSCRIBE_ACTION, "107", new Object[]{str, obj, iMqttActionListener});
        }
        for (String validate : strArr) {
            MqttTopic.validate(validate, true);
        }
        for (String removeMessageListener : strArr) {
            this.comms.removeMessageListener(removeMessageListener);
        }
        MqttToken mqttToken = new MqttToken(getClientId());
        mqttToken.setActionCallback(iMqttActionListener);
        mqttToken.setUserContext(obj);
        mqttToken.internalTok.setTopics(strArr);
        this.comms.sendNoWait(new MqttUnsubscribe(strArr), mqttToken);
        log.fine(CLASS_NAME, MqttServiceConstants.UNSUBSCRIBE_ACTION, "110");
        return mqttToken;
    }

    public IMqttDeliveryToken publish(String str, byte[] bArr, int i, boolean z) throws MqttException, MqttPersistenceException {
        return publish(str, bArr, i, z, null, null);
    }

    public IMqttDeliveryToken publish(String str, MqttMessage mqttMessage) throws MqttException, MqttPersistenceException {
        return publish(str, mqttMessage, (Object) null, (IMqttActionListener) null);
    }

    public IMqttDeliveryToken publish(String str, MqttMessage mqttMessage, Object obj, IMqttActionListener iMqttActionListener) throws MqttException, MqttPersistenceException {
        log.fine(CLASS_NAME, "publish", "111", new Object[]{str, obj, iMqttActionListener});
        MqttTopic.validate(str, false);
        MqttDeliveryToken mqttDeliveryToken = new MqttDeliveryToken(getClientId());
        mqttDeliveryToken.setActionCallback(iMqttActionListener);
        mqttDeliveryToken.setUserContext(obj);
        mqttDeliveryToken.setMessage(mqttMessage);
        mqttDeliveryToken.internalTok.setTopics(new String[]{str});
        this.comms.sendNoWait(new MqttPublish(str, mqttMessage), mqttDeliveryToken);
        log.fine(CLASS_NAME, "publish", "112");
        return mqttDeliveryToken;
    }

    public IMqttToken subscribe(String str, int i, Object obj, IMqttActionListener iMqttActionListener, IMqttMessageListener iMqttMessageListener) throws MqttException {
        return subscribe(new String[]{str}, new int[]{i}, obj, iMqttActionListener, new IMqttMessageListener[]{iMqttMessageListener});
    }

    public IMqttToken subscribe(String str, int i, IMqttMessageListener iMqttMessageListener) throws MqttException {
        return subscribe(new String[]{str}, new int[]{i}, (Object) null, (IMqttActionListener) null, new IMqttMessageListener[]{iMqttMessageListener});
    }

    public IMqttToken subscribe(String[] strArr, int[] iArr, IMqttMessageListener[] iMqttMessageListenerArr) throws MqttException {
        return subscribe(strArr, iArr, (Object) null, (IMqttActionListener) null, iMqttMessageListenerArr);
    }

    public IMqttToken subscribe(String[] strArr, int[] iArr, Object obj, IMqttActionListener iMqttActionListener, IMqttMessageListener[] iMqttMessageListenerArr) throws MqttException {
        if (iMqttMessageListenerArr.length == iArr.length && iArr.length == strArr.length) {
            IMqttToken subscribe = subscribe(strArr, iArr, obj, iMqttActionListener);
            for (int i = 0; i < strArr.length; i++) {
                this.comms.setMessageListener(strArr[i], iMqttMessageListenerArr[i]);
            }
            return subscribe;
        }
        throw new IllegalArgumentException();
    }
}
