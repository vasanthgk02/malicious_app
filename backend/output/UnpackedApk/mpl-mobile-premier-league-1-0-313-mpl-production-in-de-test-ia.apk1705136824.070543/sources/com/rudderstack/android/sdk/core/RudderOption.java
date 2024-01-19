package com.rudderstack.android.sdk.core;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.rudderstack.android.sdk.core.RudderIntegration.Factory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RudderOption {
    public Map<String, Object> customContexts = new HashMap();
    public List<Map<String, Object>> externalIds = new ArrayList();
    public Map<String, Object> integrations = new HashMap();

    public Map<String, Object> getCustomContexts() {
        return this.customContexts;
    }

    public List<Map<String, Object>> getExternalIds() {
        return this.externalIds;
    }

    public Map<String, Object> getIntegrations() {
        return this.integrations;
    }

    public RudderOption putCustomContext(String str, Map<String, Object> map) {
        this.customContexts.put(str, map);
        return this;
    }

    public RudderOption putExternalId(String str, String str2) {
        Map map;
        int i = 0;
        while (true) {
            if (i >= this.externalIds.size()) {
                map = null;
                i = -1;
                break;
            }
            map = this.externalIds.get(i);
            String str3 = (String) map.get("type");
            if (str3 != null && str3.equalsIgnoreCase(str)) {
                break;
            }
            i++;
        }
        if (map == null) {
            map = GeneratedOutlineSupport.outline87("type", str);
        }
        map.put("id", str2);
        if (i == -1) {
            this.externalIds.add(map);
        } else {
            this.externalIds.get(i).put("id", str2);
        }
        return this;
    }

    public RudderOption putIntegration(String str, boolean z) {
        this.integrations.put(str, Boolean.valueOf(z));
        return this;
    }

    public RudderOption putIntegration(Factory factory, boolean z) {
        this.integrations.put(factory.key(), Boolean.valueOf(z));
        return this;
    }
}
