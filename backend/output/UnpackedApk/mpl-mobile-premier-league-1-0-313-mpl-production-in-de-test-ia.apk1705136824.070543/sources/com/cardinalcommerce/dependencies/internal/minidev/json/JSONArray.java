package com.cardinalcommerce.dependencies.internal.minidev.json;

import com.cardinalcommerce.dependencies.internal.minidev.json.c.e;
import com.cardinalcommerce.dependencies.internal.minidev.json.c.e.AnonymousClass14;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSONArray extends ArrayList<Object> implements JSONAwareEx, JSONStreamAwareEx, List<Object> {
    public static final long serialVersionUID = 9106884089231309568L;

    public static void writeJSONString(Iterable<? extends Object> iterable, Appendable appendable, JSONStyle jSONStyle) {
        if (iterable == null) {
            appendable.append("null");
        } else {
            ((AnonymousClass14) e.f1932e).a(iterable, appendable, jSONStyle);
        }
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

    public String toString() {
        JSONStyle jSONStyle = JSONValue.COMPRESSION;
        StringBuilder sb = new StringBuilder();
        try {
            writeJSONString(this, sb, jSONStyle);
        } catch (IOException unused) {
        }
        return sb.toString();
    }

    public void writeJSONString(Appendable appendable) {
        writeJSONString(this, appendable, JSONValue.COMPRESSION);
    }

    public void writeJSONString(Appendable appendable, JSONStyle jSONStyle) {
        writeJSONString(this, appendable, jSONStyle);
    }

    public String toJSONString(JSONStyle jSONStyle) {
        StringBuilder sb = new StringBuilder();
        try {
            writeJSONString(this, sb, jSONStyle);
        } catch (IOException unused) {
        }
        return sb.toString();
    }
}
