package org.eclipse.paho.client.mqttv3.internal;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class ResourceBundleCatalog extends MessageCatalog {
    public ResourceBundle bundle = ResourceBundle.getBundle("org.eclipse.paho.client.mqttv3.internal.nls.messages");

    public String getLocalizedMessage(int i) {
        try {
            return this.bundle.getString(Integer.toString(i));
        } catch (MissingResourceException unused) {
            return "MqttException";
        }
    }
}
