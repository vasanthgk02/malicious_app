package com.rudderstack.android.sdk.core;

import com.rudderstack.android.sdk.core.ecomm.ECommerceParamNames;
import java.util.HashMap;
import java.util.Map;

public class RudderProperty {
    public Map<String, Object> map = new HashMap();

    public Map<String, Object> getMap() {
        return this.map;
    }

    public Object getProperty(String str) {
        if (this.map.containsKey(str)) {
            return this.map.get(str);
        }
        return null;
    }

    public boolean hasProperty(String str) {
        return this.map.containsKey(str);
    }

    public void put(String str, Object obj) {
        this.map.put(str, obj);
    }

    public void putCurrency(String str) {
        this.map.put("currency", str);
    }

    public void putRevenue(double d2) {
        this.map.put(ECommerceParamNames.REVENUE, Double.valueOf(d2));
    }

    public RudderProperty putValue(String str, Object obj) {
        if (obj instanceof RudderProperty) {
            this.map.put(str, ((RudderProperty) obj).getMap());
        } else {
            this.map.put(str, obj);
        }
        return this;
    }

    public RudderProperty putValue(Map<String, Object> map2) {
        if (map2 != null) {
            this.map.putAll(map2);
        }
        return this;
    }
}
