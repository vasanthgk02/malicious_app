package org.eclipse.paho.client.mqttv3.internal;

public abstract class MessageCatalog {
    public static MessageCatalog INSTANCE;

    public static final String getMessage(int i) {
        if (INSTANCE == null) {
            if (ExceptionHelper.isClassAvailable("java.util.ResourceBundle")) {
                try {
                    INSTANCE = (MessageCatalog) Class.forName("org.eclipse.paho.client.mqttv3.internal.ResourceBundleCatalog").newInstance();
                } catch (Exception unused) {
                    return "";
                }
            } else if (ExceptionHelper.isClassAvailable("org.eclipse.paho.client.mqttv3.internal.MIDPCatalog")) {
                try {
                    INSTANCE = (MessageCatalog) Class.forName("org.eclipse.paho.client.mqttv3.internal.MIDPCatalog").newInstance();
                } catch (Exception unused2) {
                    return "";
                }
            }
        }
        return INSTANCE.getLocalizedMessage(i);
    }

    public abstract String getLocalizedMessage(int i);
}
