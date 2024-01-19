package net.minidev.json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import net.minidev.json.reader.JsonWriter;
import net.minidev.json.reader.JsonWriter.AnonymousClass5;

public class JSONArray extends ArrayList<Object> implements List<Object>, JSONAwareEx, JSONStreamAwareEx {
    public static final long serialVersionUID = 9106884089231309568L;

    public static void writeJSONString(Iterable<? extends Object> iterable, Appendable appendable, JSONStyle jSONStyle) throws IOException {
        if (iterable == null) {
            appendable.append("null");
        } else {
            ((AnonymousClass5) JsonWriter.JSONIterableWriter).writeJSONString(iterable, appendable, jSONStyle);
        }
    }

    public String toJSONString(JSONStyle jSONStyle) {
        StringBuilder sb = new StringBuilder();
        try {
            writeJSONString(this, sb, jSONStyle);
        } catch (IOException unused) {
        }
        return sb.toString();
    }

    public String toString() {
        JSONStyle jSONStyle = JSONValue.COMPRESSION;
        StringBuilder sb = new StringBuilder();
        try {
            writeJSONString(this, sb, jSONStyle);
        } catch (IOException unused) {
        }
        return sb.toString();
    }

    public void writeJSONString(Appendable appendable) throws IOException {
        writeJSONString(this, appendable, JSONValue.COMPRESSION);
    }

    public String toJSONString() {
        JSONStyle jSONStyle = JSONValue.COMPRESSION;
        StringBuilder sb = new StringBuilder();
        try {
            writeJSONString(this, sb, jSONStyle);
        } catch (IOException unused) {
        }
        return sb.toString();
    }

    public void writeJSONString(Appendable appendable, JSONStyle jSONStyle) throws IOException {
        writeJSONString(this, appendable, jSONStyle);
    }
}
