package net.minidev.json.writer;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONAwareEx;
import net.minidev.json.JSONObject;

public class DefaultMapper<T> extends JsonReaderI<T> {
    public DefaultMapper(JsonReader jsonReader) {
        super(jsonReader);
    }

    public void addValue(Object obj, Object obj2) {
        ((JSONArray) obj).add(obj2);
    }

    public Object createArray() {
        return new JSONArray();
    }

    public Object createObject() {
        return new JSONObject();
    }

    public void setValue(Object obj, String str, Object obj2) {
        ((JSONObject) obj).put(str, obj2);
    }

    public JsonReaderI<JSONAwareEx> startArray(String str) {
        return this.base.DEFAULT;
    }

    public JsonReaderI<JSONAwareEx> startObject(String str) {
        return this.base.DEFAULT;
    }
}
