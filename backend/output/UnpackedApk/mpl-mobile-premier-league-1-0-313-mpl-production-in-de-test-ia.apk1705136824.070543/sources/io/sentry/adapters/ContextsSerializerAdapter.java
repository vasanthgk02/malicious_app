package io.sentry.adapters;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.protocol.Contexts;
import java.lang.reflect.Type;
import java.util.Map.Entry;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public final class ContextsSerializerAdapter implements JsonSerializer<Contexts> {
    public final SentryOptions options;

    public ContextsSerializerAdapter(SentryOptions sentryOptions) {
        this.options = sentryOptions;
    }

    public JsonElement serialize(Contexts contexts, Type type, JsonSerializationContext jsonSerializationContext) {
        if (contexts == null) {
            return null;
        }
        JsonObject jsonObject = new JsonObject();
        for (Entry entry : contexts.entrySet()) {
            try {
                JsonElement serialize = jsonSerializationContext.serialize(entry.getValue(), Object.class);
                if (serialize != null) {
                    jsonObject.add((String) entry.getKey(), serialize);
                }
            } catch (JsonParseException unused) {
                this.options.getLogger().log(SentryLevel.ERROR, (String) "%s context key isn't serializable.", new Object[0]);
            }
        }
        return jsonObject;
    }
}
