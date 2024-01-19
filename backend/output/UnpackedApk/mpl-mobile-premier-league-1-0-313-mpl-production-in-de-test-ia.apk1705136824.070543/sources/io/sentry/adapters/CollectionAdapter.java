package io.sentry.adapters;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.Collection;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public final class CollectionAdapter implements JsonSerializer<Collection<?>> {
    public JsonElement serialize(Collection<?> collection, Type type, JsonSerializationContext jsonSerializationContext) {
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        JsonArray jsonArray = new JsonArray();
        for (Object serialize : collection) {
            jsonArray.add(jsonSerializationContext.serialize(serialize));
        }
        return jsonArray;
    }
}
