package org.eclipse.paho.client.mqttv3.internal;

import com.paynimo.android.payment.util.Constant;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.apache.pdfbox.pdmodel.interactive.action.PDWindowsLaunchParams;
import org.eclipse.paho.client.mqttv3.MqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttToken;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttPublish;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;
import org.eclipse.paho.client.mqttv3.logging.Logger;
import org.eclipse.paho.client.mqttv3.logging.LoggerFactory;

public class CommsTokenStore {
    public static final String CLASS_NAME = "org.eclipse.paho.client.mqttv3.internal.CommsTokenStore";
    public static final Logger log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, CommsTokenStore.class.getName());
    public MqttException closedResponse = null;
    public String logContext;
    public Hashtable tokens;

    public CommsTokenStore(String str) {
        log.setResourceName(str);
        this.tokens = new Hashtable();
        this.logContext = str;
        log.fine(CLASS_NAME, "<Init>", "308");
    }

    public void clear() {
        log.fine(CLASS_NAME, "clear", "305", new Object[]{new Integer(this.tokens.size())});
        synchronized (this.tokens) {
            this.tokens.clear();
        }
    }

    public int count() {
        int size;
        synchronized (this.tokens) {
            try {
                size = this.tokens.size();
            }
        }
        return size;
    }

    public MqttDeliveryToken[] getOutstandingDelTokens() {
        MqttDeliveryToken[] mqttDeliveryTokenArr;
        synchronized (this.tokens) {
            try {
                log.fine(CLASS_NAME, "getOutstandingDelTokens", "311");
                Vector vector = new Vector();
                Enumeration elements = this.tokens.elements();
                while (elements.hasMoreElements()) {
                    MqttToken mqttToken = (MqttToken) elements.nextElement();
                    if (mqttToken != null && (mqttToken instanceof MqttDeliveryToken) && !mqttToken.internalTok.isNotified()) {
                        vector.addElement(mqttToken);
                    }
                }
                mqttDeliveryTokenArr = (MqttDeliveryToken[]) vector.toArray(new MqttDeliveryToken[vector.size()]);
            }
        }
        return mqttDeliveryTokenArr;
    }

    public Vector getOutstandingTokens() {
        Vector vector;
        synchronized (this.tokens) {
            try {
                log.fine(CLASS_NAME, "getOutstandingTokens", "312");
                vector = new Vector();
                Enumeration elements = this.tokens.elements();
                while (elements.hasMoreElements()) {
                    MqttToken mqttToken = (MqttToken) elements.nextElement();
                    if (mqttToken != null) {
                        vector.addElement(mqttToken);
                    }
                }
            }
        }
        return vector;
    }

    public MqttToken getToken(MqttWireMessage mqttWireMessage) {
        return (MqttToken) this.tokens.get(mqttWireMessage.getKey());
    }

    public void open() {
        synchronized (this.tokens) {
            log.fine(CLASS_NAME, PDWindowsLaunchParams.OPERATION_OPEN, "310");
            this.closedResponse = null;
        }
    }

    public void quiesce(MqttException mqttException) {
        synchronized (this.tokens) {
            log.fine(CLASS_NAME, "quiesce", "309", new Object[]{mqttException});
            this.closedResponse = mqttException;
        }
    }

    public MqttToken removeToken(MqttWireMessage mqttWireMessage) {
        if (mqttWireMessage != null) {
            return removeToken(mqttWireMessage.getKey());
        }
        return null;
    }

    public MqttDeliveryToken restoreToken(MqttPublish mqttPublish) {
        MqttDeliveryToken mqttDeliveryToken;
        synchronized (this.tokens) {
            try {
                String num = new Integer(mqttPublish.getMessageId()).toString();
                if (this.tokens.containsKey(num)) {
                    mqttDeliveryToken = (MqttDeliveryToken) this.tokens.get(num);
                    log.fine(CLASS_NAME, "restoreToken", "302", new Object[]{num, mqttPublish, mqttDeliveryToken});
                } else {
                    mqttDeliveryToken = new MqttDeliveryToken(this.logContext);
                    mqttDeliveryToken.internalTok.setKey(num);
                    this.tokens.put(num, mqttDeliveryToken);
                    log.fine(CLASS_NAME, "restoreToken", "303", new Object[]{num, mqttPublish, mqttDeliveryToken});
                }
            }
        }
        return mqttDeliveryToken;
    }

    public void saveToken(MqttToken mqttToken, MqttWireMessage mqttWireMessage) throws MqttException {
        synchronized (this.tokens) {
            if (this.closedResponse == null) {
                String key = mqttWireMessage.getKey();
                log.fine(CLASS_NAME, "saveToken", Constant.BANKCODE_HDFC, new Object[]{key, mqttWireMessage});
                saveToken(mqttToken, key);
            } else {
                throw this.closedResponse;
            }
        }
    }

    public String toString() {
        String stringBuffer;
        String property = System.getProperty("line.separator", "\n");
        StringBuffer stringBuffer2 = new StringBuffer();
        synchronized (this.tokens) {
            Enumeration elements = this.tokens.elements();
            while (elements.hasMoreElements()) {
                stringBuffer2.append("{" + ((MqttToken) elements.nextElement()).internalTok + "}" + property);
            }
            stringBuffer = stringBuffer2.toString();
        }
        return stringBuffer;
    }

    public MqttToken removeToken(String str) {
        log.fine(CLASS_NAME, "removeToken", "306", new Object[]{str});
        if (str != null) {
            return (MqttToken) this.tokens.remove(str);
        }
        return null;
    }

    public MqttToken getToken(String str) {
        return (MqttToken) this.tokens.get(str);
    }

    public void saveToken(MqttToken mqttToken, String str) {
        synchronized (this.tokens) {
            log.fine(CLASS_NAME, "saveToken", "307", new Object[]{str, mqttToken.toString()});
            mqttToken.internalTok.setKey(str);
            this.tokens.put(str, mqttToken);
        }
    }
}
