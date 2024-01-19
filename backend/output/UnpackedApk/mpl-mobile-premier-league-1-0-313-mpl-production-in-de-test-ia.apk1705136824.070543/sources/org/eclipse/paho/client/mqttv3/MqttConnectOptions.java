package org.eclipse.paho.client.mqttv3;

import com.mpl.androidapp.miniprofile.ct.C.ViewerPropertyGroup;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import org.eclipse.paho.client.mqttv3.util.Debug;

public class MqttConnectOptions {
    public static final boolean CLEAN_SESSION_DEFAULT = true;
    public static final int CONNECTION_TIMEOUT_DEFAULT = 30;
    public static final int KEEP_ALIVE_INTERVAL_DEFAULT = 60;
    public static final int MAX_INFLIGHT_DEFAULT = 10;
    public static final int MQTT_VERSION_3_1 = 3;
    public static final int MQTT_VERSION_3_1_1 = 4;
    public static final int MQTT_VERSION_DEFAULT = 0;
    public static final int URI_TYPE_LOCAL = 2;
    public static final int URI_TYPE_SSL = 1;
    public static final int URI_TYPE_TCP = 0;
    public static final int URI_TYPE_WS = 3;
    public static final int URI_TYPE_WSS = 4;
    public int MqttVersion = 0;
    public boolean automaticReconnect = false;
    public boolean cleanSession = true;
    public int connectionTimeout = 30;
    public int keepAliveInterval = 60;
    public int maxInflight = 10;
    public char[] password;
    public String[] serverURIs = null;
    public SocketFactory socketFactory;
    public Properties sslClientProps = null;
    public HostnameVerifier sslHostnameVerifier = null;
    public String userName;
    public String willDestination = null;
    public MqttMessage willMessage = null;

    public static int validateURI(String str) {
        try {
            URI uri = new URI(str);
            if ("ws".equals(uri.getScheme())) {
                return 3;
            }
            if ("wss".equals(uri.getScheme())) {
                return 4;
            }
            if (uri.getPath() != null) {
                if (!uri.getPath().isEmpty()) {
                    throw new IllegalArgumentException(str);
                }
            }
            if ("tcp".equals(uri.getScheme())) {
                return 0;
            }
            if ("ssl".equals(uri.getScheme())) {
                return 1;
            }
            if ("local".equals(uri.getScheme())) {
                return 2;
            }
            throw new IllegalArgumentException(str);
        } catch (URISyntaxException unused) {
            throw new IllegalArgumentException(str);
        }
    }

    private void validateWill(String str, Object obj) {
        if (str == null || obj == null) {
            throw new IllegalArgumentException();
        }
        MqttTopic.validate(str, false);
    }

    public int getConnectionTimeout() {
        return this.connectionTimeout;
    }

    public Properties getDebug() {
        Object obj;
        Properties properties = new Properties();
        properties.put("MqttVersion", new Integer(getMqttVersion()));
        properties.put("CleanSession", Boolean.valueOf(isCleanSession()));
        properties.put("ConTimeout", new Integer(getConnectionTimeout()));
        properties.put("KeepAliveInterval", new Integer(getKeepAliveInterval()));
        properties.put(ViewerPropertyGroup.USER_NAME, getUserName() == null ? "null" : getUserName());
        if (getWillDestination() == null) {
            obj = "null";
        } else {
            obj = getWillDestination();
        }
        properties.put("WillDestination", obj);
        if (getSocketFactory() == null) {
            properties.put("SocketFactory", "null");
        } else {
            properties.put("SocketFactory", getSocketFactory());
        }
        if (getSSLProperties() == null) {
            properties.put("SSLProperties", "null");
        } else {
            properties.put("SSLProperties", getSSLProperties());
        }
        return properties;
    }

    public int getKeepAliveInterval() {
        return this.keepAliveInterval;
    }

    public int getMaxInflight() {
        return this.maxInflight;
    }

    public int getMqttVersion() {
        return this.MqttVersion;
    }

    public char[] getPassword() {
        return this.password;
    }

    public HostnameVerifier getSSLHostnameVerifier() {
        return this.sslHostnameVerifier;
    }

    public Properties getSSLProperties() {
        return this.sslClientProps;
    }

    public String[] getServerURIs() {
        return this.serverURIs;
    }

    public SocketFactory getSocketFactory() {
        return this.socketFactory;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getWillDestination() {
        return this.willDestination;
    }

    public MqttMessage getWillMessage() {
        return this.willMessage;
    }

    public boolean isAutomaticReconnect() {
        return this.automaticReconnect;
    }

    public boolean isCleanSession() {
        return this.cleanSession;
    }

    public void setAutomaticReconnect(boolean z) {
        this.automaticReconnect = z;
    }

    public void setCleanSession(boolean z) {
        this.cleanSession = z;
    }

    public void setConnectionTimeout(int i) {
        if (i >= 0) {
            this.connectionTimeout = i;
            return;
        }
        throw new IllegalArgumentException();
    }

    public void setKeepAliveInterval(int i) throws IllegalArgumentException {
        if (i >= 0) {
            this.keepAliveInterval = i;
            return;
        }
        throw new IllegalArgumentException();
    }

    public void setMaxInflight(int i) {
        if (i >= 0) {
            this.maxInflight = i;
            return;
        }
        throw new IllegalArgumentException();
    }

    public void setMqttVersion(int i) throws IllegalArgumentException {
        if (i == 0 || i == 3 || i == 4) {
            this.MqttVersion = i;
            return;
        }
        throw new IllegalArgumentException();
    }

    public void setPassword(char[] cArr) {
        this.password = cArr;
    }

    public void setSSLHostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.sslHostnameVerifier = hostnameVerifier;
    }

    public void setSSLProperties(Properties properties) {
        this.sslClientProps = properties;
    }

    public void setServerURIs(String[] strArr) {
        for (String validateURI : strArr) {
            validateURI(validateURI);
        }
        this.serverURIs = strArr;
    }

    public void setSocketFactory(SocketFactory socketFactory2) {
        this.socketFactory = socketFactory2;
    }

    public void setUserName(String str) {
        if (str == null || !str.trim().equals("")) {
            this.userName = str;
            return;
        }
        throw new IllegalArgumentException();
    }

    public void setWill(MqttTopic mqttTopic, byte[] bArr, int i, boolean z) {
        String name = mqttTopic.getName();
        validateWill(name, bArr);
        setWill(name, new MqttMessage(bArr), i, z);
    }

    public String toString() {
        return Debug.dumpProperties(getDebug(), "Connection options");
    }

    public void setWill(String str, byte[] bArr, int i, boolean z) {
        validateWill(str, bArr);
        setWill(str, new MqttMessage(bArr), i, z);
    }

    public void setWill(String str, MqttMessage mqttMessage, int i, boolean z) {
        this.willDestination = str;
        this.willMessage = mqttMessage;
        mqttMessage.setQos(i);
        this.willMessage.setRetained(z);
        this.willMessage.setMutable(false);
    }
}
