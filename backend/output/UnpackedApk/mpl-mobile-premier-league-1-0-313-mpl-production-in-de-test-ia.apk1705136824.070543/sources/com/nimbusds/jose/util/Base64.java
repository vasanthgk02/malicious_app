package com.nimbusds.jose.util;

import java.io.Serializable;
import java.nio.charset.Charset;
import net.minidev.json.JSONAware;
import net.minidev.json.JSONValue;

public class Base64 implements JSONAware, Serializable {
    public static final Charset CHARSET = Charset.forName("UTF-8");
    public static final long serialVersionUID = 1;
    public final String value;

    public Base64(String str) {
        if (str != null) {
            this.value = str;
            return;
        }
        throw new IllegalArgumentException("The Base64 value must not be null");
    }

    public byte[] decode() {
        return Base64Codec.decode(this.value);
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof Base64) && this.value.equals(obj.toString());
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public String toJSONString() {
        return "\"" + JSONValue.escape(this.value) + "\"";
    }

    public String toString() {
        return this.value;
    }
}
