package net.minidev.json.writer;

import java.util.LinkedHashMap;
import java.util.Map;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONAwareEx;

public class DefaultMapperOrdered extends JsonReaderI<JSONAwareEx> {
    public DefaultMapperOrdered(JsonReader jsonReader) {
        super(jsonReader);
    }

    public void addValue(Object obj, Object obj2) {
        ((JSONArray) obj).add(obj2);
    }

    public Object createArray() {
        return new JSONArray();
    }

    public Object createObject() {
        return new LinkedHashMap();
    }

    public void setValue(Object obj, String str, Object obj2) {
        ((Map) obj).put(str, obj2);
    }

    public JsonReaderI<JSONAwareEx> startArray(String str) {
        return this.base.DEFAULT_ORDERED;
    }

    public JsonReaderI<JSONAwareEx> startObject(String str) {
        return this.base.DEFAULT_ORDERED;
    }
}
