package com.squareup.moshi;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.squareup.moshi.JsonAdapter.Factory;
import in.juspay.hypersdk.core.InflateView;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class MapJsonAdapter<K, V> extends JsonAdapter<Map<K, V>> {
    public static final Factory FACTORY = new Factory() {
        public JsonAdapter<?> create(Type type, Set<? extends Annotation> set, Moshi moshi) {
            if (!set.isEmpty()) {
                return null;
            }
            Class<?> rawType = Types.getRawType(type);
            if (rawType != Map.class) {
                return null;
            }
            Type[] mapKeyAndValueTypes = Types.mapKeyAndValueTypes(type, rawType);
            return new MapJsonAdapter(moshi, mapKeyAndValueTypes[0], mapKeyAndValueTypes[1]).nullSafe();
        }
    };
    public final JsonAdapter<K> keyAdapter;
    public final JsonAdapter<V> valueAdapter;

    public MapJsonAdapter(Moshi moshi, Type type, Type type2) {
        this.keyAdapter = moshi.adapter(type);
        this.valueAdapter = moshi.adapter(type2);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("JsonAdapter(");
        outline73.append(this.keyAdapter);
        outline73.append(InflateView.SETTER_EQUALS);
        outline73.append(this.valueAdapter);
        outline73.append(")");
        return outline73.toString();
    }

    public Map<K, V> fromJson(JsonReader jsonReader) throws IOException {
        LinkedHashTreeMap linkedHashTreeMap = new LinkedHashTreeMap();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            jsonReader.promoteNameToValue();
            Object fromJson = this.keyAdapter.fromJson(jsonReader);
            Object fromJson2 = this.valueAdapter.fromJson(jsonReader);
            Object put = linkedHashTreeMap.put(fromJson, fromJson2);
            if (put != null) {
                throw new JsonDataException("Map key '" + fromJson + "' has multiple values at path " + jsonReader.getPath() + ": " + put + " and " + fromJson2);
            }
        }
        jsonReader.endObject();
        return linkedHashTreeMap;
    }

    public void toJson(JsonWriter jsonWriter, Map<K, V> map) throws IOException {
        jsonWriter.beginObject();
        for (Entry next : map.entrySet()) {
            if (next.getKey() != null) {
                jsonWriter.promoteValueToName();
                this.keyAdapter.toJson(jsonWriter, next.getKey());
                this.valueAdapter.toJson(jsonWriter, next.getValue());
            } else {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Map key is null at ");
                outline73.append(jsonWriter.getPath());
                throw new JsonDataException(outline73.toString());
            }
        }
        jsonWriter.endObject();
    }
}
