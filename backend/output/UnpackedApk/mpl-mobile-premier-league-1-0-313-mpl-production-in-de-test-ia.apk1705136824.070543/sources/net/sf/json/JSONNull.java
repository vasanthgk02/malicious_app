package net.sf.json;

public final class JSONNull implements JSON {
    public static JSONNull instance = new JSONNull();

    public boolean equals(Object obj) {
        return obj == null || obj == this || obj == instance || ((obj instanceof JSONObject) && ((JSONObject) obj).nullObject) || "null".equals(obj);
    }

    public int hashCode() {
        return 3392940;
    }

    public String toString() {
        return "null";
    }
}
