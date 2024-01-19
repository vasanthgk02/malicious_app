package io.sentry.config;

import io.sentry.config.PropertiesProvider.CC;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class CompositePropertiesProvider implements PropertiesProvider {
    public final List<PropertiesProvider> providers;

    public CompositePropertiesProvider(List<PropertiesProvider> list) {
        this.providers = list;
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
        for (PropertiesProvider map : this.providers) {
            Map<String, String> map2 = map.getMap(str);
            if (!map2.isEmpty()) {
                return map2;
            }
        }
        return new ConcurrentHashMap();
    }

    public String getProperty(String str) {
        for (PropertiesProvider property : this.providers) {
            String property2 = property.getProperty(str);
            if (property2 != null) {
                return property2;
            }
        }
        return null;
    }

    public /* synthetic */ String getProperty(String str, String str2) {
        return CC.$default$getProperty(this, str, str2);
    }
}
