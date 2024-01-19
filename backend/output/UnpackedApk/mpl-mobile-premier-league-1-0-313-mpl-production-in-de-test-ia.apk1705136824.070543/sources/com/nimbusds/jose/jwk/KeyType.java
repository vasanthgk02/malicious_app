package com.nimbusds.jose.jwk;

import com.nimbusds.jose.Requirement;
import java.io.Serializable;
import net.minidev.json.JSONAware;
import net.minidev.json.JSONObject;
import org.apache.commons.lang.StringEscapeUtils;

public final class KeyType implements JSONAware, Serializable {
    public static final KeyType EC = new KeyType("EC", Requirement.RECOMMENDED);
    public static final KeyType OCT = new KeyType("oct", Requirement.OPTIONAL);
    public static final KeyType OKP = new KeyType("OKP", Requirement.OPTIONAL);
    public static final KeyType RSA = new KeyType("RSA", Requirement.REQUIRED);
    public static final long serialVersionUID = 1;
    public final String value;

    public KeyType(String str, Requirement requirement) {
        this.value = str;
    }

    public static KeyType parse(String str) {
        if (str.equals(EC.value)) {
            return EC;
        }
        if (str.equals(RSA.value)) {
            return RSA;
        }
        if (str.equals(OCT.value)) {
            return OCT;
        }
        if (str.equals(OKP.value)) {
            return OKP;
        }
        return new KeyType(str, null);
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof KeyType) && this.value.equals(obj.toString());
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public String toJSONString() {
        return "\"" + JSONObject.escape(this.value) + StringEscapeUtils.CSV_QUOTE;
    }

    public String toString() {
        return this.value;
    }
}
