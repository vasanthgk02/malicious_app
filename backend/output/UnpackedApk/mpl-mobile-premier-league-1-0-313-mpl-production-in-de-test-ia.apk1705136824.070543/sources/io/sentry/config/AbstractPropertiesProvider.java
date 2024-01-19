package io.sentry.config;

import com.android.tools.r8.GeneratedOutlineSupport;
import io.sentry.config.PropertiesProvider.CC;
import io.sentry.util.Objects;
import io.sentry.util.StringUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

public abstract class AbstractPropertiesProvider implements PropertiesProvider {
    public final String prefix;
    public final Properties properties;

    public AbstractPropertiesProvider(String str, Properties properties2) {
        this.prefix = (String) Objects.requireNonNull(str, "prefix is required");
        this.properties = (Properties) Objects.requireNonNull(properties2, "properties are required");
    }

    public /* synthetic */ Boolean getBooleanProperty(String str) {
        return CC.$default$getBooleanProperty(this, str);
    }

    public /* synthetic */ Double getDoubleProperty(String str) {
        return CC.$default$getDoubleProperty(this, str);
    }

    public /* synthetic */ List<String> getList(String str) {
        return CC.$default$getList(this, str);
    }

    public Map<String, String> getMap(String str) {
        String outline63 = GeneratedOutlineSupport.outline63(new StringBuilder(), this.prefix, str, ".");
        HashMap hashMap = new HashMap();
        for (Entry entry : this.properties.entrySet()) {
            if ((entry.getKey() instanceof String) && (entry.getValue() instanceof String)) {
                String str2 = (String) entry.getKey();
                if (str2.startsWith(outline63)) {
                    hashMap.put(str2.substring(outline63.length()), StringUtils.removeSurrounding((String) entry.getValue(), "\""));
                }
            }
        }
        return hashMap;
    }

    public String getProperty(String str) {
        Properties properties2 = this.properties;
        return StringUtils.removeSurrounding(properties2.getProperty(this.prefix + str), "\"");
    }

    public /* synthetic */ String getProperty(String str, String str2) {
        return CC.$default$getProperty(this, str, str2);
    }

    public AbstractPropertiesProvider(Properties properties2) {
        this("", properties2);
    }
}
