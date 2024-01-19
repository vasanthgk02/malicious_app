package io.sentry.adapters;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Map.Entry;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public final class MapAdapter implements JsonSerializer<Map<String, ?>> {
    public JsonElement serialize(Map<String, ?> map, Type type, JsonSerializationContext jsonSerializationContext) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        JsonObject jsonObject = new JsonObject();
        for (Entry next : map.entrySet()) {
            jsonObject.add((String) next.getKey(), jsonSerializationContext.serialize(next.getValue()));
        }
        return jsonObject;
    }
}
