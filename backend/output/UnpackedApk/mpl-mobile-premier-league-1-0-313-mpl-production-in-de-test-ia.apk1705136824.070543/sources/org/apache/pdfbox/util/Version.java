package org.apache.pdfbox.util;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public final class Version {
    public static final String PDFBOX_VERSION_PROPERTIES = "org/apache/pdfbox/resources/pdfbox.properties";

    public static String getVersion() {
        String str = null;
        try {
            URL resource = Version.class.getClassLoader().getResource(PDFBOX_VERSION_PROPERTIES);
            if (resource == null) {
                return null;
            }
            Properties properties = new Properties();
            properties.load(FirebasePerfUrlConnection.openStream(resource));
            str = properties.getProperty("pdfbox.version", null);
            return str;
        } catch (IOException unused) {
        }
    }
}
