package io.sentry.adapters;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.SpanId;
import java.lang.reflect.Type;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public final class SpanIdSerializerAdapter implements JsonSerializer<SpanId> {
    public final SentryOptions options;

    public SpanIdSerializerAdapter(SentryOptions sentryOptions) {
        this.options = sentryOptions;
    }

    public JsonElement serialize(SpanId spanId, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonElement jsonElement = null;
        if (spanId != null) {
            try {
                jsonElement = new JsonPrimitive(spanId.toString());
            } catch (Exception e2) {
                this.options.getLogger().log(SentryLevel.ERROR, (String) "Error when serializing SpanId", (Throwable) e2);
                return null;
            }
        }
        return jsonElement;
    }
}
