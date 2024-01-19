package com.mpl.androidapp.react;

import org.eclipse.paho.android.service.MqttAndroidClient;

public interface MqttListener {
    MqttAndroidClient getMqttClientInstance();
}
