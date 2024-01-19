package com.appsflyer.internal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class br<Body> {
    public final Map<String, List<String>> AFInAppEventParameterName;
    public final bk AFInAppEventType;
    public final boolean AFKeystoreWrapper;
    public final Body valueOf;
    public final int values;

    public br(Body body, int i, boolean z, Map<String, List<String>> map, bk bkVar) {
        this.valueOf = body;
        this.values = i;
        this.AFKeystoreWrapper = z;
        this.AFInAppEventParameterName = new HashMap(map);
        this.AFInAppEventType = bkVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || br.class != obj.getClass()) {
            return false;
        }
        br brVar = (br) obj;
        if (this.values == brVar.values && this.AFKeystoreWrapper == brVar.AFKeystoreWrapper && this.valueOf.equals(brVar.valueOf) && this.AFInAppEventParameterName.equals(brVar.AFInAppEventParameterName)) {
            return this.AFInAppEventType.equals(brVar.AFInAppEventType);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.AFInAppEventParameterName.hashCode();
        return this.AFInAppEventType.hashCode() + ((hashCode + (((((this.valueOf.hashCode() * 31) + this.values) * 31) + (this.AFKeystoreWrapper ? 1 : 0)) * 31)) * 31);
    }

    public final boolean values() {
        return this.AFKeystoreWrapper;
    }
}
