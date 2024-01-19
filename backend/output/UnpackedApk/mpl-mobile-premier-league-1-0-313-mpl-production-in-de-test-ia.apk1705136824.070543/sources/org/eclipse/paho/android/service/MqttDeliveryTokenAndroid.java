package org.eclipse.paho.android.service;

import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MqttDeliveryTokenAndroid extends MqttTokenAndroid implements IMqttDeliveryToken {
    public MqttMessage message;

    public MqttDeliveryTokenAndroid(MqttAndroidClient mqttAndroidClient, Object obj, IMqttActionListener iMqttActionListener, MqttMessage mqttMessage) {
        super(mqttAndroidClient, obj, iMqttActionListener);
        this.message = mqttMessage;
    }

    public MqttMessage getMessage() throws MqttException {
        return this.message;
    }

    public void notifyDelivery(MqttMessage mqttMessage) {
        this.message = mqttMessage;
        super.notifyComplete();
    }

    public void setMessage(MqttMessage mqttMessage) {
        this.message = mqttMessage;
    }
}
