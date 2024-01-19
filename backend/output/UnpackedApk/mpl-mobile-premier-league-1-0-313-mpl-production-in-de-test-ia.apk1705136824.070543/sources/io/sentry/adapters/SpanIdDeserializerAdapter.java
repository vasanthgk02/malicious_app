package io.sentry.adapters;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.SpanId;
import java.lang.reflect.Type;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public final class SpanIdDeserializerAdapter implements JsonDeserializer<SpanId> {
    public final SentryOptions options;

    public SpanIdDeserializerAdapter(SentryOptions sentryOptions) {
        this.options = sentryOptions;
    }

    public SpanId deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        SpanId spanId = null;
        if (jsonElement != null) {
            try {
                spanId = new SpanId(jsonElement.getAsString());
            } catch (Exception e2) {
                this.options.getLogger().log(SentryLevel.ERROR, (String) "Error when deserializing SpanId", (Throwable) e2);
                return null;
            }
        }
        return spanId;
    }
}
