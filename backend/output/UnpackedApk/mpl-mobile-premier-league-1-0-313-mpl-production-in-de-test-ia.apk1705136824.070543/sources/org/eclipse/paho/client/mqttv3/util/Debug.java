package org.eclipse.paho.client.mqttv3.util;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Enumeration;
import java.util.Properties;
import org.apache.fontbox.cmap.CMap;
import org.eclipse.paho.client.mqttv3.internal.ClientComms;
import org.eclipse.paho.client.mqttv3.logging.Logger;
import org.eclipse.paho.client.mqttv3.logging.LoggerFactory;

public class Debug {
    public static final String CLASS_NAME;
    public static final String lineSep = System.getProperty("line.separator", "\n");
    public static final Logger log;
    public static final String separator = "==============";
    public String clientID;
    public ClientComms comms;

    static {
        String name = ClientComms.class.getName();
        CLASS_NAME = name;
        log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, name);
    }

    public Debug(String str, ClientComms clientComms) {
        this.clientID = str;
        this.comms = clientComms;
        log.setResourceName(str);
    }

    public static String dumpProperties(Properties properties, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        Enumeration<?> propertyNames = properties.propertyNames();
        StringBuilder sb = new StringBuilder(String.valueOf(lineSep));
        GeneratedOutlineSupport.outline103(sb, separator, CMap.SPACE, str, CMap.SPACE);
        sb.append(separator);
        sb.append(lineSep);
        stringBuffer.append(sb.toString());
        while (propertyNames.hasMoreElements()) {
            String str2 = (String) propertyNames.nextElement();
            stringBuffer.append(String.valueOf(left(str2, 28, ' ')) + ":  " + properties.get(str2) + lineSep);
        }
        stringBuffer.append("==========================================" + lineSep);
        return stringBuffer.toString();
    }

    public static String left(String str, int i, char c2) {
        if (str.length() >= i) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(i);
        stringBuffer.append(str);
        int length = i - str.length();
        while (true) {
            length--;
            if (length < 0) {
                return stringBuffer.toString();
            }
            stringBuffer.append(c2);
        }
    }

    public void dumpBaseDebug() {
        dumpVersion();
        dumpSystemProperties();
        dumpMemoryTrace();
    }

    public void dumpClientComms() {
        ClientComms clientComms = this.comms;
        if (clientComms != null) {
            Properties debug = clientComms.getDebug();
            Logger logger = log;
            String str = CLASS_NAME;
            logger.fine(str, "dumpClientComms", dumpProperties(debug, String.valueOf(this.clientID) + " : ClientComms").toString());
        }
    }

    public void dumpClientDebug() {
        dumpClientComms();
        dumpConOptions();
        dumpClientState();
        dumpBaseDebug();
    }

    public void dumpClientState() {
        ClientComms clientComms = this.comms;
        if (clientComms != null && clientComms.getClientState() != null) {
            Properties debug = this.comms.getClientState().getDebug();
            Logger logger = log;
            String str = CLASS_NAME;
            logger.fine(str, "dumpClientState", dumpProperties(debug, String.valueOf(this.clientID) + " : ClientState").toString());
        }
    }

    public void dumpConOptions() {
        ClientComms clientComms = this.comms;
        if (clientComms != null) {
            Properties debug = clientComms.getConOptions().getDebug();
            Logger logger = log;
            String str = CLASS_NAME;
            logger.fine(str, "dumpConOptions", dumpProperties(debug, String.valueOf(this.clientID) + " : Connect Options").toString());
        }
    }

    public void dumpMemoryTrace() {
        log.dumpTrace();
    }

    public void dumpSystemProperties() {
        log.fine(CLASS_NAME, "dumpSystemProperties", dumpProperties(System.getProperties(), "SystemProperties").toString());
    }

    public void dumpVersion() {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder sb = new StringBuilder(String.valueOf(lineSep));
        GeneratedOutlineSupport.outline102(sb, separator, " Version Info ", separator);
        sb.append(lineSep);
        stringBuffer.append(sb.toString());
        stringBuffer.append(String.valueOf(left("Version", 20, ' ')) + ":  " + ClientComms.VERSION + lineSep);
        stringBuffer.append(String.valueOf(left("Build Level", 20, ' ')) + ":  " + ClientComms.BUILD_LEVEL + lineSep);
        StringBuilder sb2 = new StringBuilder("==========================================");
        sb2.append(lineSep);
        stringBuffer.append(sb2.toString());
        log.fine(CLASS_NAME, "dumpVersion", stringBuffer.toString());
    }
}
