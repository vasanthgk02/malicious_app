package io.sentry.config;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.xiaomi.mipush.sdk.Constants;
import io.sentry.config.PropertiesProvider.CC;
import io.sentry.util.StringUtils;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public final class EnvironmentVariablePropertiesProvider implements PropertiesProvider {
    public static final String PREFIX = "SENTRY";

    private String propertyToEnvironmentVariableName(String str) {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("SENTRY_");
        outline73.append(str.replace(".", "_").replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "_").toUpperCase(Locale.ROOT));
        return outline73.toString();
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
        String outline62 = GeneratedOutlineSupport.outline62(new StringBuilder(), propertyToEnvironmentVariableName(str), "_");
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (Entry next : System.getenv().entrySet()) {
            String str2 = (String) next.getKey();
            if (str2.startsWith(outline62)) {
                String removeSurrounding = StringUtils.removeSurrounding((String) next.getValue(), "\"");
                if (removeSurrounding != null) {
                    concurrentHashMap.put(str2.substring(outline62.length()).toLowerCase(Locale.ROOT), removeSurrounding);
                }
            }
        }
        return concurrentHashMap;
    }

    public String getProperty(String str) {
        return StringUtils.removeSurrounding(System.getenv(propertyToEnvironmentVariableName(str)), "\"");
    }

    public /* synthetic */ String getProperty(String str, String str2) {
        return CC.$default$getProperty(this, str, str2);
    }
}
