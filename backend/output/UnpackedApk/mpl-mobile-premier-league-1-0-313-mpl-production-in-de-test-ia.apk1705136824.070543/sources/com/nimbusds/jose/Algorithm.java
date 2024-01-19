package com.nimbusds.jose;

import java.io.Serializable;
import net.minidev.json.JSONAware;
import net.minidev.json.JSONObject;
import org.apache.commons.lang.StringEscapeUtils;

public class Algorithm implements JSONAware, Serializable {
    public static final Algorithm NONE = new Algorithm("none", Requirement.REQUIRED);
    public static final long serialVersionUID = 1;
    public final String name;

    public Algorithm(String str, Requirement requirement) {
        if (str != null) {
            this.name = str;
            return;
        }
        throw new IllegalArgumentException("The algorithm name must not be null");
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof Algorithm) && this.name.equals(obj.toString());
    }

    public final int hashCode() {
        return this.name.hashCode();
    }

    public final String toJSONString() {
        return "\"" + JSONObject.escape(this.name) + StringEscapeUtils.CSV_QUOTE;
    }

    public final String toString() {
        return this.name;
    }
}
