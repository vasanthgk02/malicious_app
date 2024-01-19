package io.sentry.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public interface PropertiesProvider {

    /* renamed from: io.sentry.config.PropertiesProvider$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Boolean $default$getBooleanProperty(PropertiesProvider _this, String str) {
            String property = _this.getProperty(str);
            if (property != null) {
                return Boolean.valueOf(property);
            }
            return null;
        }

        public static Double $default$getDoubleProperty(PropertiesProvider _this, String str) {
            String property = _this.getProperty(str);
            if (property != null) {
                return Double.valueOf(property);
            }
            return null;
        }

        public static List $default$getList(PropertiesProvider _this, String str) {
            String property = _this.getProperty(str);
            return property != null ? Arrays.asList(property.split(",")) : Collections.emptyList();
        }

        public static String $default$getProperty(PropertiesProvider _this, String str, String str2) {
            String property = _this.getProperty(str);
            return property != null ? property : str2;
        }
    }

    Boolean getBooleanProperty(String str);

    Double getDoubleProperty(String str);

    List<String> getList(String str);

    Map<String, String> getMap(String str);

    String getProperty(String str);

    String getProperty(String str, String str2);
}
