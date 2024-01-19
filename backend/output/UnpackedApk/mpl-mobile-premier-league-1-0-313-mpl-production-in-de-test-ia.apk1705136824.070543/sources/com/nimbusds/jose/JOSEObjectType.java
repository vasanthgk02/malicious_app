package com.nimbusds.jose;

import java.io.Serializable;
import net.minidev.json.JSONAware;
import net.minidev.json.JSONObject;
import org.apache.commons.lang.StringEscapeUtils;

public final class JOSEObjectType implements JSONAware, Serializable {
    public static final long serialVersionUID = 1;
    public final String type;

    public JOSEObjectType(String str) {
        this.type = str;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof JOSEObjectType) && this.type.equals(obj.toString());
    }

    public int hashCode() {
        return this.type.hashCode();
    }

    public String toJSONString() {
        return "\"" + JSONObject.escape(this.type) + StringEscapeUtils.CSV_QUOTE;
    }

    public String toString() {
        return this.type;
    }
}
