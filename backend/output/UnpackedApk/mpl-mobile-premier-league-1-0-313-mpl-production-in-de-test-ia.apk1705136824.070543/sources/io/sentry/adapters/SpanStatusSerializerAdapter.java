package io.sentry.adapters;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.SpanStatus;
import java.lang.reflect.Type;
import java.util.Locale;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public final class SpanStatusSerializerAdapter implements JsonSerializer<SpanStatus> {
    public final SentryOptions options;

    public SpanStatusSerializerAdapter(SentryOptions sentryOptions) {
        this.options = sentryOptions;
    }

    public JsonElement serialize(SpanStatus spanStatus, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonElement jsonElement = null;
        if (spanStatus != null) {
            try {
                jsonElement = new JsonPrimitive(spanStatus.name().toLowerCase(Locale.ROOT));
            } catch (Exception e2) {
                this.options.getLogger().log(SentryLevel.ERROR, (String) "Error when serializing SpanStatus", (Throwable) e2);
                return null;
            }
        }
        return jsonElement;
    }
}