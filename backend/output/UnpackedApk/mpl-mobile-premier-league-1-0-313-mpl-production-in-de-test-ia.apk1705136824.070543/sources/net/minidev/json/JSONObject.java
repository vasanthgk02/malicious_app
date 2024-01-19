package net.minidev.json;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import net.minidev.json.reader.JsonWriter;
import net.minidev.json.reader.JsonWriter.AnonymousClass7;
import org.apache.commons.lang.StringEscapeUtils;

public class JSONObject extends HashMap<String, Object> implements JSONAware, JSONAwareEx, JSONStreamAwareEx {
    public static final long serialVersionUID = -503443796854799292L;

    public JSONObject() {
    }

    public static String escape(String str) {
        return JSONValue.escape(str);
    }

    public static String toJSONString(Map<String, ? extends Object> map, JSONStyle jSONStyle) {
        StringBuilder sb = new StringBuilder();
        try {
            writeJSON(map, sb, jSONStyle);
        } catch (IOException unused) {
        }
        return sb.toString();
    }

    public static void writeJSON(Map<String, ? extends Object> map, Appendable appendable, JSONStyle jSONStyle) throws IOException {
        if (map == null) {
            appendable.append("null");
        } else {
            ((AnonymousClass7) JsonWriter.JSONMapWriter).writeJSONString(map, appendable, jSONStyle);
        }
    }

    public static void writeJSONKV(String str, Object obj, Appendable appendable, JSONStyle jSONStyle) throws IOException {
        if (str == null) {
            appendable.append("null");
        } else if (!jSONStyle.mpKey.mustBeProtect(str)) {
            appendable.append(str);
        } else {
            appendable.append(StringEscapeUtils.CSV_QUOTE);
            JSONValue.escape(str, appendable, jSONStyle);
            appendable.append(StringEscapeUtils.CSV_QUOTE);
        }
        appendable.append(':');
        if (obj instanceof String) {
            jSONStyle.writeString(appendable, (String) obj);
        } else {
            JSONValue.writeJSONString(obj, appendable, jSONStyle);
        }
    }

    public String toString() {
        return toJSONString(this, JSONValue.COMPRESSION);
    }

    public void writeJSONString(Appendable appendable) throws IOException {
        writeJSON(this, appendable, JSONValue.COMPRESSION);
    }

    public JSONObject(Map<String, ?> map) {
        super(map);
    }

    public void writeJSONString(Appendable appendable, JSONStyle jSONStyle) throws IOException {
        writeJSON(this, appendable, jSONStyle);
    }

    public String toJSONString() {
        return toJSONString(this, JSONValue.COMPRESSION);
    }

    public String toJSONString(JSONStyle jSONStyle) {
        return toJSONString(this, jSONStyle);
    }
}
